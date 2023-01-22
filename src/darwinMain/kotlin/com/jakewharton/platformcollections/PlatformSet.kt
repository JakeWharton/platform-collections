@file:OptIn(UnsafeNumber::class)

package com.jakewharton.platformcollections

import kotlinx.cinterop.UnsafeNumber
import platform.Foundation.NSMutableArray
import platform.Foundation.NSMutableSet
import platform.Foundation.containsObject
import platform.Foundation.enumerateObjectsUsingBlock
import platform.Foundation.removeAllObjects

@Suppress(
	"ACTUAL_WITHOUT_EXPECT", // Our use of 'value' fails the matcher.
	"unused", // Type parameter matches expect and needed for extensions.
)
public actual value class PlatformSet<E>
private constructor(
	public val storage: NSMutableSet,
) {
	public actual constructor() : this(NSMutableSet())
}

public actual inline fun <E> PlatformSet<E>.add(item: E) {
	storage.addObject(item)
}

public actual inline fun <E> PlatformSet<E>.asMutableSet(): MutableSet<E> {
	TODO()
}

public actual inline fun <E> PlatformSet<E>.clear() {
	storage.removeAllObjects()
}

public actual inline operator fun <E> PlatformSet<E>.contains(item: E): Boolean {
	return storage.containsObject(item)
}

@OptIn(UnsafeNumber::class)
public actual inline fun <E> PlatformSet<E>.isEmpty(): Boolean {
	return storage.count.toInt() == 0
}

public actual inline fun <E> PlatformSet<E>.remove(item: E) {
	storage.removeObject(item)
}

@OptIn(UnsafeNumber::class)
public actual inline val <E> PlatformSet<E>.size: Int get() = storage.count.toInt()

public actual inline fun <E> PlatformSet<E>.toMutableSet(): MutableSet<E> {
	TODO()
}
