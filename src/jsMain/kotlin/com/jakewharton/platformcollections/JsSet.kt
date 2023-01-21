package com.jakewharton.platformcollections

@JsName("Set")
public external class JsSet<E> {
	public val size: Int
	public fun add(item: E)
	public fun delete(item: E): Boolean
	public fun has(item: E): Boolean
	public fun clear()
	public fun forEach(block: (E) -> Unit)
	override fun toString(): String
}
