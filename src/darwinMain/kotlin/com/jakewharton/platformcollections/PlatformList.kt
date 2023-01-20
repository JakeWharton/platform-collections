@file:Suppress("NOTHING_TO_INLINE")

package com.jakewharton.platformcollections

import kotlinx.cinterop.UnsafeNumber
import kotlinx.cinterop.convert
import platform.Foundation.NSEnumerationReverse
import platform.Foundation.NSMutableArray
import platform.Foundation.containsObject
import platform.Foundation.enumerateObjectsUsingBlock
import platform.Foundation.indexOfObject
import platform.Foundation.indexOfObjectWithOptions
import platform.Foundation.removeAllObjects

public actual inline fun <E> PlatformList(): PlatformList<E> {
	return PlatformList(NSMutableArray())
}

@Suppress("ACTUAL_WITHOUT_EXPECT")
public actual value class PlatformList<E>
@PublishedApi internal constructor(
	@PublishedApi internal val storage: NSMutableArray,
) {
	@OptIn(UnsafeNumber::class)
	public actual inline val size: Int get() = storage.count.toInt()

	@OptIn(UnsafeNumber::class)
	public actual inline fun isEmpty(): Boolean {
		return storage.count.toInt() == 0
	}

	public actual inline operator fun contains(element: E): Boolean {
		return storage.containsObject(element)
	}

	@Suppress("UnnecessaryOptInAnnotation") // Nope! It's needed.
	@OptIn(UnsafeNumber::class)
	public actual inline operator fun get(index: Int): E {
		@Suppress("UNCHECKED_CAST")
		return storage.objectAtIndex(index.convert()) as E
	}

	@OptIn(UnsafeNumber::class)
	public actual inline fun indexOf(element: E): Int {
		return storage.indexOfObject(element).toInt()
	}

	@OptIn(UnsafeNumber::class)
	public actual inline fun lastIndexOf(element: E): Int {
		return storage.indexOfObjectWithOptions(
			opts = NSEnumerationReverse,
			passingTest = { candidate, _, _ -> candidate == element},
		).toInt()
	}

	public actual inline fun add(element: E) {
		storage.addObject(element)
	}

	@Suppress("UnnecessaryOptInAnnotation") // Nope! It's needed.
	@OptIn(UnsafeNumber::class)
	public actual inline fun add(index: Int, element: E) {
		storage.insertObject(element, index.convert())
	}

	@Suppress("UnnecessaryOptInAnnotation") // Nope! It's needed.
	@OptIn(UnsafeNumber::class)
	public actual inline operator fun set(index: Int, element: E) {
		storage.replaceObjectAtIndex(index.convert(), element)
	}

	public actual inline fun clear() {
		storage.removeAllObjects()
	}

	@Suppress("UnnecessaryOptInAnnotation") // Nope! It's needed.
	@OptIn(UnsafeNumber::class)
	public actual inline fun forEach(crossinline block: (E) -> Unit) {
		storage.enumerateObjectsUsingBlock { element, _, _ ->
			@Suppress("UNCHECKED_CAST")
			block(element as E)
		}
	}

	public actual inline fun asMutableList(): MutableList<E> {
		TODO()
	}

	public actual inline fun toMutableList(): MutableList<E> {
		TODO()
	}

	@Suppress("OVERRIDE_BY_INLINE")
	actual override inline fun toString(): String {
		TODO()
	}
}
