package com.jakewharton.platformcollections

internal class PlatformSetMutableIterator<E>(
	private val set: JsSet<E>,
	private val iterator: JsIterator<E>,
) : MutableIterator<E> {
	private var needsNext = true
	private var current: JsIteratorResult<E>? = null
	private var lastValue: E? = null
	private var canRemove = false

	override fun hasNext(): Boolean {
		if (needsNext) {
			current = iterator.next()
			needsNext = false
		}
		return !current.unsafeCast<JsIteratorResult<E>>().done
	}

	override fun next(): E {
		if (hasNext()) {
			val current = current.unsafeCast<JsIteratorResult<E>>()
			canRemove = true
			lastValue = current.value
			needsNext = true
			return current.value
		}
		throw NoSuchElementException()
	}

	override fun remove() {
		check(canRemove)
		canRemove = false
		set.delete(lastValue.unsafeCast<E>())
		lastValue = null
	}
}
