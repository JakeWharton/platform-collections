package com.jakewharton.platformcollections

import kotlin.collections.MutableMap.MutableEntry
import platform.Foundation.NSMutableDictionary

internal class NSMutableDictionaryMutableIterator<K, V>(
	private val storage: NSMutableDictionary,
	private val entryIterator: Iterator<Map.Entry<K, V>>,
) : MutableIterator<MutableEntry<K, V>> {
	private var canRemove = false
	private var lastKey: Any? = null

	override fun hasNext() = entryIterator.hasNext()

	override fun next(): MutableEntry<K, V> {
		val entry = entryIterator.next()
		canRemove = true
		lastKey = entry.key
		return NSMutableDictionaryMutableEntry(storage, entry.key, entry.value)
	}

	override fun remove() {
		check(canRemove)
		canRemove = false
		storage.removeObjectForKey(lastKey)
		lastKey = null
	}
}
