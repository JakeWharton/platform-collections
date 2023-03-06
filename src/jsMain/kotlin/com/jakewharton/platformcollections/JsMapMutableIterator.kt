package com.jakewharton.platformcollections

import kotlin.collections.MutableMap.MutableEntry

internal class JsMapMutableIterator<K, V>(
	private val map: JsMap<K, V>,
	private val iterator: JsIterator<JsEntry<K, V>>,
) : MutableIterator<MutableEntry<K, V>> {
	private var needsNext = true
	private var current: JsIteratorResult<JsEntry<K, V>>? = null
	private var lastKey: K? = null
	private var canRemove = false

	override fun hasNext(): Boolean {
		if (needsNext) {
			current = iterator.next()
			needsNext = false
		}
		return !current.unsafeCast<JsIteratorResult<JsEntry<K, V>>>().done
	}

	override fun next(): MutableEntry<K, V> {
		if (hasNext()) {
			val entry = current.unsafeCast<JsIteratorResult<JsEntry<K, V>>>().value
			canRemove = true
			lastKey = entry.key
			needsNext = true
			return JsMapMutableEntry(map, entry.key, entry.value)
		}
		throw NoSuchElementException()
	}

	override fun remove() {
		check(canRemove)
		canRemove = false
		map.delete(lastKey.unsafeCast<K>())
		lastKey = null
	}
}
