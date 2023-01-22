@file:Suppress(
	"EXTENSION_SHADOWED_BY_MEMBER",
	"NOTHING_TO_INLINE",
	"KotlinRedundantDiagnosticSuppress",
)

package com.jakewharton.platformcollections

@Suppress("ACTUAL_TYPE_ALIAS_NOT_TO_CLASS") // On the JVM it aliases to java.util.LinkedHashMap.
public actual typealias PlatformMap<K, V> = LinkedHashMap<K, V>

public actual inline fun <K, V> PlatformMap<K, V>.asMutableMap(): MutableMap<K, V> {
	return this
}

public actual inline fun <K, V> PlatformMap<K, V>.clear() {
	clear()
}

public actual inline operator fun <K, V> PlatformMap<K, V>.contains(key: K): Boolean {
	return containsKey(key)
}

public actual inline fun <K, V> PlatformMap<K, V>.isEmpty(): Boolean {
	return isEmpty()
}

public actual inline operator fun <K, V> PlatformMap<K, V>.get(key: K): V? {
	return this[key]
}

public actual inline fun <K, V> PlatformMap<K, V>.put(key: K, value: V) {
	this[key] = value
}

public actual inline fun <K, V> PlatformMap<K, V>.remove(key: K) {
	remove(key)
}

public actual inline val <K, V> PlatformMap<K, V>.size: Int get() = size

public actual inline fun <K, V> PlatformMap<K, V>.toMutableMap(): MutableMap<K, V> {
	return LinkedHashMap(this)
}
