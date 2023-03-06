package com.jakewharton.platformcollections

/** @suppress Type has to be public because of typealias */
@JsName("Map")
public external class JsMap<K, V> {
	@PublishedApi
	internal val size: Int
	@PublishedApi
	internal fun delete(key: K): Boolean
	@PublishedApi
	internal fun has(key: K): Boolean
	@PublishedApi
	internal fun get(key: K): V?
	@PublishedApi
	internal fun set(key: K, value: V)
	@PublishedApi
	internal fun clear()

	override fun toString(): String
}
