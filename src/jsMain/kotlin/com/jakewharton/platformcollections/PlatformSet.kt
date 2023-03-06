@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")

package com.jakewharton.platformcollections

public actual typealias PlatformSet<E> = JsSet<E>

public actual inline fun <E> PlatformSet<E>.add(item: E) {
	add(item)
}

public actual fun <E> PlatformSet<E>.asMutableSet(): MutableSet<E> {
	return PlatformSetMutableSet(this)
}

public actual inline fun <E> PlatformSet<E>.clear() {
	clear()
}

public actual inline operator fun <E> PlatformSet<E>.contains(item: E): Boolean {
	return has(item)
}

public actual inline fun <E> PlatformSet<E>.isEmpty(): Boolean {
	return size == 0
}

public actual inline fun <E> PlatformSet<E>.remove(item: E) {
	delete(item)
}

public actual inline val <E> PlatformSet<E>.size: Int get() = size

public actual fun <E> PlatformSet<E>.toMutableSet(): MutableSet<E> {
	// Currently JS sets in the Kotlin stdlib are a travesty of abstraction. They ignore
	// capacity sizing because after many layers they bottom out in a JS object.
	val set = LinkedHashSet<E>()

	val iterator = jsIterator()
	while (true) {
		val result = iterator.next()
		if (result.done) break
		set.add(result.value)
	}
	return set
}
