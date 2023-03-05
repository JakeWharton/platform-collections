package com.jakewharton.platformcollections

internal class PlatformListMutableIterator<E>(
	private val list: PlatformList<E>,
) : MutableIterator<E> {
	private var index = 0
	private var canRemove = false

	override fun hasNext(): Boolean {
		return index < list.size
	}

	override fun next(): E {
		if (hasNext()) {
			canRemove = true
			return list[index++]
		}
		throw NoSuchElementException()
	}

	override fun remove() {
		check(canRemove)
		canRemove = false
		list.removeAt(--index)
	}
}
