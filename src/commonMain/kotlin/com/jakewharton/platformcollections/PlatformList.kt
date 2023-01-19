@file:Suppress("NOTHING_TO_INLINE")

package com.jakewharton.platformcollections

import kotlin.jvm.JvmInline

internal expect class PlatformListStorage<E>

public expect fun <E> PlatformList(): PlatformList<E>

@JvmInline
public expect value class PlatformList<E>
// TODO This constructor should not need to be defined in the expect.
//  It causes the need to expose PlatformListStorage here, too.
@PublishedApi internal constructor(
	@PublishedApi internal val storage: PlatformListStorage<E>,
){
	// TODO Should be a `val` but Kotlin complains.
	public inline fun size(): Int

	public inline operator fun contains(element: E): Boolean
	public inline operator fun get(index: Int): E
	public inline fun indexOf(element: E): Int
	public inline fun lastIndexOf(element: E): Int

	public inline fun add(element: E)
	public inline fun add(index: Int, element: E)
	public inline operator fun set(index: Int, element: E): E
	public inline fun clear()

	public inline fun forEach(noinline block: (E) -> Unit)

	public fun toMutableList(): MutableList<E>

	@Suppress("OVERRIDE_BY_INLINE")
	public override inline fun toString(): String
}

public inline fun <E> PlatformList<E>.toList(): List<E> = toMutableList()

public inline fun <E> PlatformList<E>.isEmpty(): Boolean {
	return size() == 0
}
public inline fun <E> PlatformList<E>.isNotEmpty(): Boolean {
	return size() != 0
}
