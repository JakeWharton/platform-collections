@file:Suppress("NOTHING_TO_INLINE")

package com.jakewharton.platformcollections

internal actual typealias PlatformMapStorage<K, V> = JsMap<K, V>

public actual inline fun <K, V> PlatformMap(): PlatformMap<K, V> {
	return PlatformMap(JsMap())
}

public actual value class PlatformMap<K, V>
@PublishedApi internal constructor(
	@PublishedApi internal val storage: JsMap<K, V>,
) {
	public actual inline fun size(): Int {
		return storage.size
	}

	public actual inline operator fun contains(key: K): Boolean {
		return storage.has(key)
	}

	public actual inline operator fun get(key: K): V? {
		return storage.get(key)
	}

	public actual inline fun put(key: K, value: V) {
		storage.set(key, value)
	}

	public actual inline fun remove(key: K) {
		storage.delete(key)
	}

	public actual inline fun clear() {
		storage.clear()
	}

	public actual inline fun forEach(noinline block: (key: K, value: V) -> Unit) {
		storage.forEach(block)
	}

	public actual fun asMutableMap(): MutableMap<K, V> {
		return JsMapMutableMap(storage)
	}

	public actual fun toMutableMap(): MutableMap<K, V> {
		TODO("Not yet implemented")
	}

	@Suppress("OVERRIDE_BY_INLINE")
	actual override inline fun toString(): String {
		return storage.toString()
	}
}
