package com.jakewharton.platformcollections

internal class JsMapMutableEntry<K, V>(
	private val map: JsMap<K, V>,
	override val key: K,
	override var value: V,
	) : MutableMap.MutableEntry<K, V> {
	override fun setValue(newValue: V): V {
		val oldValue = value
		map.set(key, newValue)
		value = newValue
		return oldValue
	}
}
