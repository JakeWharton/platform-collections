package com.jakewharton.platformcollections

import platform.Foundation.NSMutableSet

internal class PlatformSetMutableIterator<E>(
	private val storage: NSMutableSet,
	private val iterator: Iterator<Any?>,
) : MutableIterator<E> {
	private var canRemove = false
	private var lastValue: Any? = null

	override fun hasNext() = iterator.hasNext()

	override fun next(): E {
		val next = iterator.next()
		canRemove = true
		lastValue = next
		@Suppress("UNCHECKED_CAST")
		return next as E
	}

	override fun remove() {
		check(canRemove)
		canRemove = false
		storage.removeObject(lastValue)
		lastValue = null
	}
}
