@file:Suppress("NOTHING_TO_INLINE")

package com.jakewharton.platformcollections

import kotlinx.cinterop.UnsafeNumber
import platform.Foundation.NSMutableSet
import platform.Foundation.containsObject
import platform.Foundation.enumerateObjectsUsingBlock
import platform.Foundation.removeAllObjects

public actual inline fun <E> PlatformSet(): PlatformSet<E> {
	return PlatformSet(NSMutableSet())
}

@Suppress("ACTUAL_WITHOUT_EXPECT")
public actual value class PlatformSet<E>
@PublishedApi internal constructor(
	@PublishedApi internal val storage: NSMutableSet,
) {
	@OptIn(UnsafeNumber::class)
	public actual inline val size: Int get() = storage.count.toInt()

	@OptIn(UnsafeNumber::class)
	public actual inline fun isEmpty(): Boolean {
		return storage.count.toInt() == 0
	}

	public actual inline operator fun contains(item: E): Boolean {
		return storage.containsObject(item)
	}

	public actual inline fun add(item: E) {
		storage.addObject(item)
	}

	public actual inline fun remove(item: E) {
		storage.removeObject(item)
	}

	public actual inline fun clear() {
		storage.removeAllObjects()
	}

	public actual inline fun forEach(crossinline block: (item: E) -> Unit) {
		storage.enumerateObjectsUsingBlock { element, _ ->
			@Suppress("UNCHECKED_CAST")
			block(element as E)
		}
	}

	public actual inline fun asMutableSet(): MutableSet<E> {
		TODO()
	}

	public actual inline fun toMutableSet(): MutableSet<E> {
		TODO()
	}

	@Suppress("OVERRIDE_BY_INLINE")
	actual override inline fun toString(): String {
		TODO()
	}
}
