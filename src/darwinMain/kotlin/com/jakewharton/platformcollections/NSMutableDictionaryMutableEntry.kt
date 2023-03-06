package com.jakewharton.platformcollections

import kotlin.collections.MutableMap.MutableEntry
import platform.Foundation.NSCopyingProtocol
import platform.Foundation.NSMutableDictionary

internal class NSMutableDictionaryMutableEntry<K, V>(
	private val storage: NSMutableDictionary,
	override val key: K,
	override var value: V,
) : MutableEntry<K, V> {
	override fun setValue(newValue: V): V {
		val oldValue = value
		storage.setObject(newValue, key as NSCopyingProtocol)
		value = newValue
		return oldValue
	}
}
