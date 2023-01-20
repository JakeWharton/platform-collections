package com.jakewharton.platformcollections

import kotlin.collections.MutableMap.MutableEntry

internal class JsMapMutableMap<K, V>(
	private val storage: JsMap<K, V>,
) : AbstractMutableMap<K, V>() {
	override fun put(key: K, value: V): V? {
		val old = storage.get(key)
		storage.set(key, value)
		return old
	}

	override val entries: MutableSet<MutableEntry<K, V>>
		get() = TODO("Not yet implemented")
}
