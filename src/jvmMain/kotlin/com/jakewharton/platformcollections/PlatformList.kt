@file:Suppress(
	"EXTENSION_SHADOWED_BY_MEMBER",
	"NOTHING_TO_INLINE",
)

package com.jakewharton.platformcollections

public actual typealias PlatformList<E> = java.util.ArrayList<E>

public actual inline fun <E> PlatformList<E>.add(item: E) {
	add(item)
}

public actual inline fun <E> PlatformList<E>.add(index: Int, item: E) {
	add(index, item)
}

public actual inline fun <E> PlatformList<E>.asMutableList(): MutableList<E> {
	return this
}

public actual inline fun <E> PlatformList<E>.clear() {
	clear()
}

public actual inline operator fun <E> PlatformList<E>.contains(item: E): Boolean {
	return contains(item)
}

public actual inline operator fun <E> PlatformList<E>.get(index: Int): E {
	return get(index)
}

public actual inline fun <E> PlatformList<E>.indexOf(item: E): Int {
	return indexOf(item)
}

public actual inline fun <E> PlatformList<E>.isEmpty(): Boolean {
	return isEmpty()
}

public actual inline fun <E> PlatformList<E>.lastIndexOf(item: E): Int {
	return lastIndexOf(item)
}

public actual inline fun <E> PlatformList<E>.set(index: Int, item: E) {
	set(index, item)
}

public actual inline val <E> PlatformList<E>.size: Int get() = size

public actual inline fun <E> PlatformList<E>.toMutableList(): MutableList<E> {
	return ArrayList(this)
}
