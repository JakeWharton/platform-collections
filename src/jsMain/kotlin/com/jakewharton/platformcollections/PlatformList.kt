package com.jakewharton.platformcollections

public actual typealias PlatformList<E> = JsArray<E>

public actual inline fun <E> PlatformList<E>.add(item: E) {
	push(item)
}

public actual fun <E> PlatformList<E>.add(index: Int, item: E) {
	if (index < 0 || index > length) {
		throw IndexOutOfBoundsException("Index $index, size: $length")
	}
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

public actual operator fun <E> PlatformList<E>.get(index: Int): E {
	if (index < 0 || index >= length) {
		throw IndexOutOfBoundsException("Index $index, size: $length")
	}
	@Suppress("UnsafeCastFromDynamic") // Avoids yet another set of temporary vars.
	return asDynamic()[index]
}

public actual inline fun <E> PlatformList<E>.indexOf(item: E): Int {
	return indexOf(item)
}

public actual inline fun <E> PlatformList<E>.isEmpty(): Boolean {
	return length == 0
}

public actual operator fun <E> PlatformList<E>.iterator(): MutableIterator<E> {
	return PlatformListMutableIterator(this)
}

public actual inline fun <E> PlatformList<E>.lastIndexOf(item: E): Int {
	return lastIndexOf(item)
}

public actual inline fun <E> PlatformList<E>.removeAt(index: Int) {
	splice(index, 1)
}

public actual inline fun <E> PlatformList<E>.set(index: Int, item: E) {
	splice(index, 1, item)
}

public actual inline val <E> PlatformList<E>.size: Int get() = length

public actual fun <E> PlatformList<E>.toMutableList(): MutableList<E> {
	val self = asDynamic()
	val size = size // Avoid two property reads in JS.
	val arrayList = ArrayList<E>(size)
	repeat(size) { index ->
		@Suppress("UnsafeCastFromDynamic") // Avoids yet another set of temporary vars.
		arrayList.add(self[index])
	}
	return arrayList
}
