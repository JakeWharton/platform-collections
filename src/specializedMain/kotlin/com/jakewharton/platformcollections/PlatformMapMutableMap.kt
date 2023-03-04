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
					return object : MutableIterator<MutableEntry<K, V>> {
						override fun hasNext(): Boolean {
							TODO("Not yet implemented")
						}

						override fun next(): MutableEntry<K, V> {
							TODO("Not yet implemented")
						}

						override fun remove() {
							TODO("Not yet implemented")
						}
					}
				}

				override fun add(element: MutableEntry<K, V>): Boolean {
					throw UnsupportedOperationException("Add is not supported on entries")
				}
			}
			_entries = set
			set
		}

	override fun put(key: K, value: V): V? {
		val old = map[key]
		map.put(key, value)
		return old
	}
}