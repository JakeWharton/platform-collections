@file:Suppress(
	"EXTENSION_SHADOWED_BY_MEMBER",
	"NOTHING_TO_INLINE",
)

package com.jakewharton.platformcollections

public actual typealias PlatformSet<E> = java.util.LinkedHashSet<E>

public actual inline fun <E> PlatformSet<E>.add(item: E) {
	add(item)
}

public actual inline fun <E> PlatformSet<E>.asMutableSet(): MutableSet<E> {
	return this
}

public actual inline fun <E> PlatformSet<E>.clear() {
	clear()
}

public actual inline operator fun <E> PlatformSet<E>.contains(item: E): Boolean {
	return contains(item)
}

public actual inline fun <E> PlatformSet<E>.isEmpty(): Boolean {
	return isEmpty()
}

public actual inline fun <E> PlatformSet<E>.remove(item: E) {
	remove(item)
}

public actual inline val <E> PlatformSet<E>.size: Int get() = size

public actual inline fun <E> PlatformSet<E>.toMutableSet(): MutableSet<E> {
	return LinkedHashSet(this)
}
