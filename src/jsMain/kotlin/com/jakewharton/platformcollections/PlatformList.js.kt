@file:Suppress("NOTHING_TO_INLINE")

package com.jakewharton.platformcollections

internal actual typealias PlatformListStorage<E> = JsArray<E>

public actual inline fun <E> PlatformList(): PlatformList<E> {
	return PlatformList(js("[]").unsafeCast<JsArray<E>>())
}

public actual value class PlatformList<E>
@PublishedApi internal constructor(
	@PublishedApi internal val storage: JsArray<E>,
) {
	public actual inline fun size(): Int = storage.length

	public actual inline operator fun contains(element: E): Boolean {
		return storage.includes(element)
	}

	public actual inline operator fun get(index: Int): E {
		return storage[index]
	}

	public actual inline fun indexOf(element: E): Int {
		return storage.indexOf(element)
	}

	public actual inline fun lastIndexOf(element: E): Int {
		return storage.lastIndexOf(element)
	}

	public actual inline fun add(element: E) {
		storage.push(element)
	}

	public actual inline fun add(index: Int, element: E) {
		storage.splice(index, 0, element)
	}

	public actual inline operator fun set(index: Int, element: E): E {
		return storage.splice(index, 1, element)[0]
	}

	public actual inline fun clear() {
		storage.length = 0
	}

	public actual inline fun forEach(noinline block: (E) -> Unit) {
		storage.forEach(block)
	}

	public actual fun toMutableList(): MutableList<E> {
		val arrayList = ArrayList<E>(size())
		@Suppress("UNUSED_VARIABLE") // Used in JS code block below.
		val storage = storage
		// Kotlin loops generate verbose JS in the form:
		//   var i = 0
		//   if (i < size)
		//     do {
		//       i++
		//       ...
		//     while (i < size);
		// so hand-roll a normal JS for-loop for decent size and performance.
		js("""
			for (var i = 0, size = storage.length; i < size; ++i) {
				arrayList.add(storage[i]);
			}
		""")
		return arrayList
	}

	@Suppress("OVERRIDE_BY_INLINE")
	actual override inline fun toString(): String {
		return storage.toString()
	}
}
