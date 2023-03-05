@file:Suppress(
	"EXTENSION_SHADOWED_BY_MEMBER",
	"NOTHING_TO_INLINE",
	"KotlinRedundantDiagnosticSuppress",
)

package com.jakewharton.platformcollections

@Suppress("ACTUAL_TYPE_ALIAS_NOT_TO_CLASS") // On the JVM it aliases to java.util.ArrayList.
public actual typealias PlatformList<E> = ArrayList<E>

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

public actual inline operator fun <E> PlatformList<E>.iterator(): MutableIterator<E> {
	return iterator()
}

public actual inline fun <E> PlatformList<E>.lastIndexOf(item: E): Int {
	return lastIndexOf(item)
}

public actual inline fun <E> PlatformList<E>.removeAt(index: Int) {
	removeAt(index)
}

public actual inline fun <E> PlatformList<E>.set(index: Int, item: E) {
	set(index, item)
}

public actual inline val <E> PlatformList<E>.size: Int get() = size

public actual inline fun <E> PlatformList<E>.toMutableList(): MutableList<E> {
	return ArrayList(this)
}
