@file:Suppress("NOTHING_TO_INLINE")

package com.jakewharton.platformcollections

@Suppress("ACTUAL_WITHOUT_EXPECT") // https://youtrack.jetbrains.com/issue/KT-37316
internal actual typealias PlatformSetStorage<E> = java.util.LinkedHashSet<E>

public actual inline fun <E> PlatformSet(): PlatformSet<E> {
	return PlatformSet(LinkedHashSet())
}

@JvmInline
public actual value class PlatformSet<E>
@PublishedApi internal constructor(
	@PublishedApi internal val storage: PlatformSetStorage<E>,
) {
	public actual inline fun size(): Int {
		return storage.size
	}

	public actual inline operator fun contains(item: E): Boolean {
		return storage.contains(item)
	}

	public actual inline fun add(item: E) {
		storage.add(item)
	}

	public actual inline fun remove(item: E) {
		storage.remove(item)
	}

	public actual inline fun clear() {
		storage.clear()
	}

	public actual inline fun forEach(noinline block: (item: E) -> Unit) {
		storage.forEach(block)
	}

	public actual inline fun asMutableSet(): MutableSet<E> {
		return storage
	}

	public actual inline fun toMutableSet(): MutableSet<E> {
		return LinkedHashSet(storage)
	}

	@Suppress("OVERRIDE_BY_INLINE")
	actual override inline fun toString(): String {
		return storage.toString()
	}
}
