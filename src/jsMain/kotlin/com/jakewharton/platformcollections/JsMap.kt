package com.jakewharton.platformcollections

/** @suppress */
@JsName("Map")
public external class JsMap<K, V> {
	public val size: Int
	public fun delete(key: K): Boolean
	public fun has(key: K): Boolean
	public fun get(key: K): V?
	public fun set(key: K, value: V)
	public fun clear()
	public fun forEach(block: (K, V) -> Unit)
	override fun toString(): String
}
