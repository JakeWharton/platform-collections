package com.jakewharton.platformcollections

import kotlin.collections.MutableMap.MutableEntry

public actual typealias PlatformMap<K, V> = JsMap<K, V>

public actual fun <K, V> PlatformMap<K, V>.asMutableMap(): MutableMap<K, V> {
	return PlatformMapMutableMap(this)
}

public actual inline fun <K, V> PlatformMap<K, V>.clear() {
	clear()
}

public actual inline operator fun <K, V> PlatformMap<K, V>.contains(key: K): Boolean {
	return has(key)
}

public actual inline operator fun <K, V> PlatformMap<K, V>.get(key: K): V? {
	return get(key)
}

public actual inline fun <K, V> PlatformMap<K, V>.isEmpty(): Boolean {
	return size == 0
}

public actual operator fun <K, V> PlatformMap<K, V>.iterator(): MutableIterator<MutableEntry<K, V>> {
	return JsMapMutableIterator(this, entries())
}

public actual inline fun <K, V> PlatformMap<K, V>.put(key: K, value: V) {
	set(key, value)
}

public actual inline fun <K, V> PlatformMap<K, V>.remove(key: K) {
	delete(key)
}

public actual inline val <K, V> PlatformMap<K, V>.size: Int get() = size

public actual fun <K, V> PlatformMap<K, V>.toMutableMap(): MutableMap<K, V> {
	// Currently JS sets in the Kotlin stdlib are a travesty of abstraction. They ignore
	// capacity sizing because after many layers they bottom out in a JS object.
	val map = LinkedHashMap<K, V>()

	val iterator = entries()
	while (true) {
		val result = iterator.next()
		if (result.done) break
		val item = result.value
		map.put(item.key, item.value)
	}
	return map
}
