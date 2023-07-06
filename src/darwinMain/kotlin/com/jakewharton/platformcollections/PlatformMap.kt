@file:OptIn(UnsafeNumber::class, ExperimentalForeignApi::class)

package com.jakewharton.platformcollections

import kotlin.collections.MutableMap.MutableEntry
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.UnsafeNumber
import platform.Foundation.NSCopyingProtocol
import platform.Foundation.NSMutableDictionary
import platform.Foundation.enumerateKeysAndObjectsUsingBlock
import platform.Foundation.removeAllObjects
import platform.darwin.nil

@Suppress(
	"ACTUAL_WITHOUT_EXPECT", // Our use of 'value' fails the matcher.
	"unused", // Type parameters match expect and needed for extensions.
)
public actual value class PlatformMap<K, V>
private constructor(
	public val storage: NSMutableDictionary,
) {
	public actual constructor() : this(NSMutableDictionary())
}

public actual fun <K, V> PlatformMap<K, V>.asMutableMap(): MutableMap<K, V> {
	return PlatformMapMutableMap(this)
}

public actual inline fun <K, V> PlatformMap<K, V>.clear() {
	storage.removeAllObjects()
}

public actual inline operator fun <K, V> PlatformMap<K, V>.contains(key: K): Boolean {
	return storage.objectForKey(key) != nil
}

public actual inline operator fun <K, V> PlatformMap<K, V>.get(key: K): V? {
	@Suppress("UNCHECKED_CAST")
	return storage.objectForKey(key) as V?
}

public actual inline fun <K, V> PlatformMap<K, V>.isEmpty(): Boolean {
	return storage.count.toInt() == 0
}

public actual operator fun <K, V> PlatformMap<K, V>.iterator(): MutableIterator<MutableEntry<K, V>> {
	// Darwin APIs do not allow mutation while enumerating. We are forced to snapshot
	// the keys and values in order to support this case.
	return NSMutableDictionaryMutableIterator(storage, toMap().iterator())
}

public actual inline fun <K, V> PlatformMap<K, V>.put(key: K, value: V) {
	storage.setObject(value, key as NSCopyingProtocol)
}

public actual inline fun <K, V> PlatformMap<K, V>.remove(key: K) {
	storage.removeObjectForKey(key)
}

public actual inline val <K, V> PlatformMap<K, V>.size: Int get() = storage.count.toInt()

public actual inline fun <K, V> PlatformMap<K, V>.toMutableMap(): MutableMap<K, V> {
	// Unlike the JVM and per https://github.com/JetBrains/kotlin/blob/ca7d1d019474fee468a756079e099a9b1da7d3c0/libraries/stdlib/native-wasm/src/kotlin/collections/HashMap.kt#L36-L37
	// this initial value is used to directly size the underlying storage.
	val map = LinkedHashMap<K, V>(size)
	storage.enumerateKeysAndObjectsUsingBlock { key, value, _ ->
		@Suppress("UNCHECKED_CAST")
		map[key as K] = value as V
	}
	return map
}
