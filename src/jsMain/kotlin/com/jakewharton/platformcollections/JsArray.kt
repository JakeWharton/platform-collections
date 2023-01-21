package com.jakewharton.platformcollections

@JsName("Array")
public external class JsArray<E> {
	public var length: Int
	public fun includes(element: E): Boolean
	public fun indexOf(element: E): Int
	public fun lastIndexOf(element: E): Int
	public fun push(value: E): Int
	public fun splice(start: Int, deleteCount: Int, element: E = definedExternally): JsArray<E>
	public fun forEach(block: (E) -> Unit)
	override fun toString(): String
}
