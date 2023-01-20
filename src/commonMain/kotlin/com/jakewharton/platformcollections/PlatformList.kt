@file:Suppress("NOTHING_TO_INLINE")

package com.jakewharton.platformcollections

public expect inline fun <E> PlatformList(): PlatformList<E>

public expect class PlatformList<E> {
	@Suppress("INLINE_PROPERTY_WITH_BACKING_FIELD")
	public inline val size: Int

	public inline operator fun contains(element: E): Boolean
	public inline operator fun get(index: Int): E
	public inline fun indexOf(element: E): Int
	public inline fun lastIndexOf(element: E): Int

	public inline fun add(element: E)
	public inline fun add(index: Int, element: E)
	public inline operator fun set(index: Int, element: E): E
	public inline fun clear()

	public inline fun forEach(noinline block: (item: E) -> Unit)

	public fun asMutableList(): MutableList<E>
	public fun toMutableList(): MutableList<E>

	@Suppress("OVERRIDE_BY_INLINE")
	public override inline fun toString(): String
}

public inline fun <E> PlatformList<E>.toList(): List<E> = toMutableList()

public inline fun <E> PlatformList<E>.isEmpty(): Boolean {
	return size == 0
}
public inline fun <E> PlatformList<E>.isNotEmpty(): Boolean {
	return size != 0
}
