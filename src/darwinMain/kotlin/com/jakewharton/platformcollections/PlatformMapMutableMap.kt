package com.jakewharton.platformcollections

import kotlin.collections.MutableMap.MutableEntry

internal class PlatformMapMutableMap<K, V>(
	private val map: PlatformMap<K, V>,
) : AbstractMutableMap<K, V>() {
	override val entries: MutableSet<MutableEntry<K, V>>
		get() = TODO()

	override fun put(key: K, value: V): V? {
		val old = map[key]
		map.put(key, value)
		return old
	}
}
