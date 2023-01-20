package com.jakewharton.platformcollections

public expect inline fun <K, V> PlatformMap(): PlatformMap<K, V>

public expect class PlatformMap<K, V> {
	@Suppress("INLINE_PROPERTY_WITH_BACKING_FIELD")
	public inline val size: Int
	public inline fun isEmpty(): Boolean

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

public inline fun <K, V> PlatformMap<K, V>.isNotEmpty(): Boolean {
	return !isEmpty()
}
