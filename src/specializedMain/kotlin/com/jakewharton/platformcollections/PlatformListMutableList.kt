package com.jakewharton.platformcollections

internal class PlatformListMutableList<E>(
	private val list: PlatformList<E>,
) : AbstractMutableList<E>(), RandomAccess {
	override fun add(index: Int, element: E) {
		list.add(index, element)
	}

	override fun clear() {
		list.clear()
	}

	override fun contains(element: E): Boolean {
		return list.contains(element)
	}

	override fun get(index: Int): E {
		return list[index]
	}

	override fun indexOf(element: E): Int {
		return list.indexOf(element)
	}

	override fun lastIndexOf(element: E): Int {
		return list.lastIndexOf(element)
	}

	override fun removeAt(index: Int): E {
		val old = list[index]
		list.removeAt(index)
		return old
	}

	override fun set(index: Int, element: E): E {
		val old = list[index]
		list.set(index, element)
		return old
	}

	override val size: Int get() = list.size
}
