package com.jakewharton.platformcollections

/** @suppress Type has to be public because of typealias */
@JsName("Set")
public external class JsSet<E> {
	@PublishedApi
	internal val size: Int
	@PublishedApi
	internal fun add(item: E)
	@PublishedApi
	internal fun delete(item: E): Boolean
	@PublishedApi
	internal fun has(item: E): Boolean
	@PublishedApi
	internal fun clear()

	override fun toString(): String
}
