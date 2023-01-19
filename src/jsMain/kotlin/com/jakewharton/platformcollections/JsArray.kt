package com.jakewharton.platformcollections

@PublishedApi
internal external class JsArray<E> {
	var length: Int
	fun includes(element: E): Boolean
	fun indexOf(element: E): Int
	fun lastIndexOf(element: E): Int
	fun push(value: E): Int
	fun splice(start: Int, deleteCount: Int, element: E = definedExternally): JsArray<E>
	fun forEach(block: (E) -> Unit)
	override fun toString(): String
}

@PublishedApi
internal inline operator fun <E> JsArray<E>.get(index: Int): E {
	return asDynamic()[index].unsafeCast<E>()
}
