package com.jakewharton.platformcollections

internal external interface JsIterator<E> {
	fun next(): JsIteratorResult<E>
}

@Suppress("unused") // Type parameter used by extension function.
internal external interface JsIteratorResult<E>

@Suppress("UnsafeCastFromDynamic") // Relying on falsey conversion.
internal inline val JsIteratorResult<*>.done: Boolean
	get() = asDynamic().done || false

@Suppress("UnsafeCastFromDynamic") // Safe assuming 'done' was false.
internal inline val <E> JsIteratorResult<E>.value: E
	get() = asDynamic().value
