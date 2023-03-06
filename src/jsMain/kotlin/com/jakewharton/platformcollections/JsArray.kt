package com.jakewharton.platformcollections

/** @suppress Type has to be public because of typealias */
@JsName("Array")
public external class JsArray<E> {
	@PublishedApi
	internal var length: Int
	@PublishedApi
	internal fun includes(element: E): Boolean
	@PublishedApi
	internal fun indexOf(element: E): Int
	@PublishedApi
	internal fun lastIndexOf(element: E): Int
	@PublishedApi
	internal fun push(value: E): Int
	@PublishedApi
	internal fun splice(start: Int, deleteCount: Int, element: E = definedExternally): JsArray<E>

	override fun toString(): String
}
