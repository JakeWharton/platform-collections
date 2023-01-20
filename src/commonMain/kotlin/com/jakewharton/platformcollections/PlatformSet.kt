package com.jakewharton.platformcollections

import kotlin.jvm.JvmInline

internal expect class PlatformSetStorage<E>

public expect inline fun <E> PlatformSet(): PlatformSet<E>

@JvmInline
public expect value class PlatformSet<E>
// TODO This constructor should not need to be defined in the expect.
//  It causes the need to expose PlatformMapStorage here, too.
@PublishedApi internal constructor(
	@PublishedApi internal val storage: PlatformSetStorage<E>,
) {
	// TODO Should be a `val` but Kotlin complains.
	public inline fun size(): Int

	public inline operator fun contains(item: E): Boolean

	public inline fun add(item: E)
	public inline fun remove(item: E)
	public inline fun clear()

	public inline fun forEach(noinline block: (item: E) -> Unit)

	public fun asMutableSet(): MutableSet<E>
	public fun toMutableSet(): MutableSet<E>

	@Suppress("OVERRIDE_BY_INLINE")
	public override inline fun toString(): String
}
