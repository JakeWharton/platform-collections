@file:Suppress(
	"EXTENSION_SHADOWED_BY_MEMBER",
	"NOTHING_TO_INLINE",
	"KotlinRedundantDiagnosticSuppress",
)

package com.jakewharton.platformcollections

@Suppress("ACTUAL_TYPE_ALIAS_NOT_TO_CLASS") // On the JVM it aliases to java.util.LinkedHashSet.
public actual typealias PlatformSet<E> = LinkedHashSet<E>

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
