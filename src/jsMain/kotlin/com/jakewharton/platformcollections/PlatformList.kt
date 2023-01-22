@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")

package com.jakewharton.platformcollections

public actual typealias PlatformList<E> = JsArray<E>

public actual inline fun <E> PlatformList<E>.add(item: E) {
	push(item)
}

public actual inline fun <E> PlatformList<E>.add(index: Int, item: E) {
	splice(index, 0, item)
}

public actual fun <E> PlatformList<E>.asMutableList(): MutableList<E> {
	return PlatformListMutableList(this)
}

public actual inline fun <E> PlatformList<E>.clear() {
	length = 0
}

public actual inline operator fun <E> PlatformList<E>.contains(item: E): Boolean {
	return includes(item)
}

public actual inline operator fun <E> PlatformList<E>.get(index: Int): E {
	@Suppress("UnsafeCastFromDynamic") // Avoids yet another set of temporary vars.
	return asDynamic()[index]
}

public actual inline fun <E> PlatformList<E>.indexOf(item: E): Int {
	return indexOf(item)
}

public actual inline fun <E> PlatformList<E>.isEmpty(): Boolean {
	return length == 0
}

public actual inline fun <E> PlatformList<E>.lastIndexOf(item: E): Int {
	return lastIndexOf(item)
}

public actual inline fun <E> PlatformList<E>.set(index: Int, item: E) {
	splice(index, 1, item)
}

public actual inline val <E> PlatformList<E>.size: Int get() = length

public actual fun <E> PlatformList<E>.toMutableList(): MutableList<E> {
	val arrayList = ArrayList<E>(size)
	@Suppress("UNUSED_VARIABLE") // Used in JS code block below.
	val storage = this
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
