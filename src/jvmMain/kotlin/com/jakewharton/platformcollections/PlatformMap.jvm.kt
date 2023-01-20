@file:Suppress("NOTHING_TO_INLINE")

package com.jakewharton.platformcollections

@Suppress("ACTUAL_WITHOUT_EXPECT") // https://youtrack.jetbrains.com/issue/KT-37316
internal actual typealias PlatformMapStorage<K, V> = java.util.LinkedHashMap<K, V>

public actual inline fun <K, V> PlatformMap(): PlatformMap<K, V> {
	return PlatformMap(LinkedHashMap())
}

@JvmInline
public actual value class PlatformMap<K, V>
@PublishedApi internal constructor(
	@PublishedApi internal val storage: PlatformMapStorage<K, V>,
) {
	public actual inline fun size(): Int {
		return storage.size
	}

	public actual inline operator fun contains(key: K): Boolean {
		return storage.containsKey(key)
	}

	public actual inline operator fun get(key: K): V? {
		return storage[key]
	}

	public actual inline fun put(key: K, value: V) {
		storage[key] = value
	}

	public actual inline fun remove(key: K) {
		storage.remove(key)
	}

	public actual inline fun clear() {
		storage.clear()
	}

	public actual inline fun forEach(noinline block: (key: K, value: V) -> Unit) {
		storage.forEach(block)
	}

	public actual inline fun asMutableMap(): MutableMap<K, V> {
		return storage
	}

	public actual inline fun toMutableMap(): MutableMap<K, V> {
		return LinkedHashMap(storage)
	}

	@Suppress("OVERRIDE_BY_INLINE")
	actual override inline fun toString(): String {
		return storage.toString()
	}
}
