@file:OptIn(UnsafeNumber::class)

package com.jakewharton.platformcollections

import kotlinx.cinterop.UnsafeNumber
import platform.Foundation.NSEnumerator
import platform.Foundation.NSMutableSet
import platform.Foundation.allObjects

internal class NSMutableSetMutableIterator<E>(
	private val storage: NSMutableSet,
) : MutableIterator<E> {
	/* Non-null when iterating without removing. Null after a call to remove(). */
	private var enumerator: NSEnumerator? = storage.objectEnumerator()
	/* Empty unless enumerator is null. */
	private var values: List<E> = emptyList()
	private var index = 0

	private var canRemove = false
	private var lastValue: Any? = null

	override fun hasNext() = index < storage.count.toInt()

	override fun next(): E {
		if (hasNext()) {
			val enumerator = enumerator
			val value = if (enumerator != null) {
				@Suppress("UNCHECKED_CAST")
				enumerator.nextObject() as E
			} else {
				values[index]
			}
			index++
			canRemove = true
			lastValue = value
			return value
		}
		throw NoSuchElementException()
	}

	override fun remove() {
		check(canRemove)
		canRemove = false

		if (enumerator != null) {
			// Darwin APIs do not allow mutation while enumerating. We are forced to snapshot
			// the values in order to support this case.
			@Suppress("UNCHECKED_CAST")
			values = storage.allObjects as List<E>
			enumerator = null
		}

		storage.removeObject(lastValue)
		index--
		lastValue = null
	}
}
