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
	@PublishedApi
	internal fun entries(): JsIterator<JsEntry<K, V>>

	override fun toString(): String
}

@Suppress("unused") // Type parameter used by extension function.
internal external interface JsEntry<K, V>
@Suppress("UnsafeCastFromDynamic")
internal inline val <K, V> JsEntry<K, V>.key: K get() = asDynamic()[0]
@Suppress("UnsafeCastFromDynamic")
internal inline val <K, V> JsEntry<K, V>.value: V get() = asDynamic()[1]
