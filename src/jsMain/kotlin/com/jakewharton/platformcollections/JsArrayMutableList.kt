package com.jakewharton.platformcollections

internal class JsArrayMutableList<E>(
	private val storage: JsArray<E>,
) : AbstractMutableList<E>() {
	override val size get() = storage.length
	override fun get(index: Int) = storage[index]

	override fun removeAt(index: Int): E {
		return storage.splice(index, 1)[0]
	}

	override fun set(index: Int, element: E): E {
		return storage.splice(index, 1, element)[0]
	}

	override fun add(index: Int, element: E) {
		storage.splice(index, 0, element)
	}
}
