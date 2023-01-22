@file:OptIn(UnsafeNumber::class)

package com.jakewharton.platformcollections

import kotlinx.cinterop.UnsafeNumber
import kotlinx.cinterop.convert
import platform.Foundation.NSEnumerationReverse
import platform.Foundation.NSMutableArray
import platform.Foundation.NSNotFound
import platform.Foundation.indexOfObject
import platform.Foundation.indexOfObjectWithOptions
import platform.Foundation.removeAllObjects
import platform.darwin.NSInteger

@Suppress(
	"ACTUAL_WITHOUT_EXPECT", // Our use of 'value' fails the matcher.
	"unused", // Type parameter matches expect and needed for extensions.
)
public actual value class PlatformList<E>
private constructor(
	public val storage: NSMutableArray,
) {
	public actual constructor() : this(NSMutableArray())
}

public actual inline fun <E> PlatformList<E>.add(item: E) {
	storage.addObject(item)
}

public actual inline fun <E> PlatformList<E>.add(index: Int, item: E) {
	storage.insertObject(item, index.convert())
}

public actual fun <E> PlatformList<E>.asMutableList(): MutableList<E> {
	return PlatformListMutableList(this)
}

public actual inline fun <E> PlatformList<E>.clear() {
	storage.removeAllObjects()
}

public actual inline operator fun <E> PlatformList<E>.contains(item: E): Boolean {
	// Kotlin thinks this function returns NSUInteger, but it's documented to return NSInteger.
	// The not found value is NSNotFound which is NSIntegerMax, an NSInteger.
	// See https://developer.apple.com/documentation/foundation/nsarray/1417076-index.
	return storage.indexOfObject(item).convert<NSInteger>() != NSNotFound
}

public actual inline operator fun <E> PlatformList<E>.get(index: Int): E {
	@Suppress("UNCHECKED_CAST")
	return storage.objectAtIndex(index.convert()) as E
}

public actual fun <E> PlatformList<E>.indexOf(item: E): Int {
	// Kotlin thinks this function returns NSUInteger, but it's documented to return NSInteger.
	// The not found value is NSNotFound which is NSIntegerMax, an NSInteger.
	// See https://developer.apple.com/documentation/foundation/nsarray/1417076-index.
	val index = storage.indexOfObject(item).convert<NSInteger>()
	return if (index == NSNotFound) -1 else index.convert()
}

public actual inline fun <E> PlatformList<E>.isEmpty(): Boolean {
	return storage.count.toInt() == 0
}

public actual fun <E> PlatformList<E>.lastIndexOf(item: E): Int {
	// Kotlin thinks this function returns NSUInteger, but it's documented to return NSInteger.
	// The not found value is NSNotFound which is NSIntegerMax, an NSInteger.
	// See https://developer.apple.com/documentation/foundation/nsarray/1417053-indexofobject.
	val index = storage.indexOfObjectWithOptions(
		opts = NSEnumerationReverse,
		passingTest = { candidate, _, _ -> candidate == item }
	).convert<NSInteger>()
	return if (index == NSNotFound) -1 else index.convert()
}

public actual inline fun <E> PlatformList<E>.removeAt(index: Int) {
	storage.removeObjectAtIndex(index.convert())
}

public actual inline fun <E> PlatformList<E>.set(index: Int, item: E) {
	storage.replaceObjectAtIndex(index.convert(), item)
}

public actual inline val <E> PlatformList<E>.size: Int get() = storage.count.toInt()

public actual fun <E> PlatformList<E>.toMutableList(): MutableList<E> {
	TODO()
}
