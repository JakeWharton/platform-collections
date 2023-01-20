package com.jakewharton.platformcollections

import kotlin.jvm.JvmInline

internal expect class PlatformMapStorage<K, V>

public expect inline fun <K, V> PlatformMap(): PlatformMap<K, V>

@JvmInline
public expect value class PlatformMap<K, V>
// TODO This constructor should not need to be defined in the expect.
//  It causes the need to expose PlatformMapStorage here, too.
@PublishedApi internal constructor(
	@PublishedApi internal val storage: PlatformMapStorage<K, V>,
) {
	// TODO Should be a `val` but Kotlin complains.
	public inline fun size(): Int

	public inline operator fun contains(key: K): Boolean
	public inline operator fun get(key: K): V?

	public inline fun put(key: K, value: V)
	public inline fun remove(key: K)
	public inline fun clear()

	public inline fun forEach(noinline block: (key: K, value: V) -> Unit)

	public fun asMutableMap(): MutableMap<K, V>
	public fun toMutableMap(): MutableMap<K, V>

	@Suppress("OVERRIDE_BY_INLINE")
	public override inline fun toString(): String
}
