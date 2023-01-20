@file:Suppress("NOTHING_TO_INLINE")

package com.jakewharton.platformcollections

import kotlinx.cinterop.UnsafeNumber
import platform.Foundation.NSCopyingProtocol
import platform.Foundation.NSMutableDictionary
import platform.Foundation.enumerateKeysAndObjectsUsingBlock
import platform.Foundation.removeAllObjects
import platform.darwin.nil

public actual inline fun <K, V> PlatformMap(): PlatformMap<K, V> {
	return PlatformMap(NSMutableDictionary())
}

@Suppress("ACTUAL_WITHOUT_EXPECT")
public actual value class PlatformMap<K, V>
@PublishedApi internal constructor(
	@PublishedApi internal val storage: NSMutableDictionary,
) {
	@OptIn(UnsafeNumber::class)
	public actual inline val size: Int get() = storage.count.toInt()

	@OptIn(UnsafeNumber::class)
	public actual inline fun isEmpty(): Boolean {
		return storage.count.toInt() == 0
	}

	public actual inline operator fun contains(key: K): Boolean {
		return storage.objectForKey(key) != nil
	}

	public actual inline operator fun get(key: K): V? {
		@Suppress("UNCHECKED_CAST")
		return storage.objectForKey(key) as V?
	}

	public actual inline fun put(key: K, value: V) {
		storage.setObject(value, key as NSCopyingProtocol)
	}

	public actual inline fun remove(key: K) {
		storage.removeObjectForKey(key)
	}

	public actual inline fun clear() {
		storage.removeAllObjects()
	}

	public actual inline fun forEach(crossinline block: (key: K, value: V) -> Unit) {
		storage.enumerateKeysAndObjectsUsingBlock { key, value, _ ->
			@Suppress("UNCHECKED_CAST")
			block.invoke(key as K, value as V)
		}
	}

	public actual inline fun asMutableMap(): MutableMap<K, V> {
		TODO()
	}

	public actual inline fun toMutableMap(): MutableMap<K, V> {
		TODO()
	}

	@Suppress("OVERRIDE_BY_INLINE")
	actual override inline fun toString(): String {
		TODO()
	}
}
