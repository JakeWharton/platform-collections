package com.jakewharton.platformcollections

public expect inline fun <E> PlatformSet(): PlatformSet<E>

public expect class PlatformSet<E> {
	@Suppress("INLINE_PROPERTY_WITH_BACKING_FIELD")
	public inline val size: Int

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
