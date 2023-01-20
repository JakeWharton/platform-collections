package com.jakewharton.platformcollections

@JsName("Set")
@PublishedApi
internal external class JsSet<E> {
	val size: Int
	fun add(item: E)
	fun delete(item: E): Boolean
	fun has(item: E): Boolean
	fun clear()
	fun forEach(block: (E) -> Unit)
	override fun toString(): String
}
