package com.jakewharton.platformcollections

@JsName("Map")
@PublishedApi
internal external class JsMap<K, V> {
	val size: Int
	fun delete(key: K): Boolean
	fun has(key: K): Boolean
	fun get(key: K): V?
	fun set(key: K, value: V)
	fun clear()
	fun forEach(block: (K, V) -> Unit)
	override fun toString(): String
}
