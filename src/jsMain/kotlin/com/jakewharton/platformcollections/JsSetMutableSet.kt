package com.jakewharton.platformcollections

import kotlin.collections.MutableMap.MutableEntry

internal class JsSetMutableSet<E>(
	private val storage: JsSet<E>,
) : AbstractMutableSet<E>() {
	override val size get() = storage.size

	override fun add(element: E): Boolean {
		val oldSize = size
		storage.add(element)
		return size != oldSize
	}

	override fun iterator(): MutableIterator<E> {
		TODO("Not yet implemented")
	}
}
