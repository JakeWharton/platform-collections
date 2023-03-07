package com.jakewharton.platformcollections

import kotlin.collections.MutableMap.MutableEntry

internal class PlatformMapMutableMap<K, V>(
	private val map: PlatformMap<K, V>,
) : AbstractMutableMap<K, V>() {
	private var _entries: MutableSet<MutableEntry<K, V>>? = null
	override val entries: MutableSet<MutableEntry<K, V>>
		get() = _entries ?: run {
			val set = object : AbstractMutableSet<MutableEntry<K, V>>() {
				override val size get() = map.size

				override fun clear() {
					map.clear()
				}

				override fun iterator(): MutableIterator<MutableEntry<K, V>> {
					return map.iterator()
				}

				override fun add(element: MutableEntry<K, V>): Boolean {
					throw UnsupportedOperationException("Add is not supported on entries")
				}
			}
			_entries = set
			set
		}

	override fun clear() {
		map.clear()
	}

	override fun containsKey(key: K): Boolean {
		return map.contains(key)
	}

	override fun get(key: K): V? {
		return map[key]
	}

	override fun put(key: K, value: V): V? {
		val old = map[key]
		map.put(key, value)
		return old
	}

	override fun remove(key: K): V? {
		val value = map[key]
		map.remove(key)
		return value
	}

	override val size: Int get() = map.size
}
