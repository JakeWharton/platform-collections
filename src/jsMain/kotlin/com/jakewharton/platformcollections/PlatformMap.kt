@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")

package com.jakewharton.platformcollections

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

public actual inline fun <K, V> PlatformMap<K, V>.isEmpty(): Boolean {
	return size == 0
}

public actual inline operator fun <K, V> PlatformMap<K, V>.get(key: K): V? {
	return get(key)
}

public actual inline fun <K, V> PlatformMap<K, V>.put(key: K, value: V) {
	set(key, value)
}

public actual inline fun <K, V> PlatformMap<K, V>.remove(key: K) {
	delete(key)
}

public actual inline val <K, V> PlatformMap<K, V>.size: Int get() = size

public actual fun <K, V> PlatformMap<K, V>.toMutableMap(): MutableMap<K, V> {
	TODO("Not yet implemented")
}
