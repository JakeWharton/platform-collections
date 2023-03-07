package com.jakewharton.platformcollections

internal class PlatformSetMutableSet<E>(
	private val set: PlatformSet<E>
) : AbstractMutableSet<E>() {
	override fun add(element: E): Boolean {
		val oldSize = set.size
		set.add(element)
		return oldSize != set.size
	}

	override fun contains(element: E): Boolean {
		return set.contains(element)
	}

	override fun clear() {
		set.clear()
	}

	override fun iterator(): MutableIterator<E> {
		return set.iterator()
	}

	override fun remove(element: E): Boolean {
		val oldSize = set.size
		set.remove(element)
		return set.size != oldSize
	}

	override val size: Int get() = set.size
}
