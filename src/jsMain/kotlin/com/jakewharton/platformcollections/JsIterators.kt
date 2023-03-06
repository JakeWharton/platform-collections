package com.jakewharton.platformcollections

@Suppress("UnsafeCastFromDynamic")
internal inline fun <E> JsSet<E>.jsIterator(): JsIterator<E> {
	return asDynamic()[JsSymbol.iterator]()
}

@Suppress("UnsafeCastFromDynamic")
internal inline fun <K, V> JsMap<K, V>.jsIterator(): JsIterator<JsEntry<K, V>> {
	return asDynamic()[JsSymbol.iterator]()
}

@Suppress("unused") // Type parameter used by extension function.
internal external interface JsEntry<K, V>
@Suppress("UnsafeCastFromDynamic")
internal inline val <K, V> JsEntry<K, V>.key: K get() = asDynamic()[0]
@Suppress("UnsafeCastFromDynamic")
internal inline val <K, V> JsEntry<K, V>.value: V get() = asDynamic()[1]

@JsName("Symbol")
internal external object JsSymbol {
	val iterator: dynamic
}

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
