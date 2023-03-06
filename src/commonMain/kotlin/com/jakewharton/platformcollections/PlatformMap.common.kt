@file:Suppress(
	"NOTHING_TO_INLINE",
	"EXTENSION_SHADOWED_BY_MEMBER", // Mirroring MutableMap API closely.
	"KotlinRedundantDiagnosticSuppress", // Shadow only occurs on some targets.
)

package com.jakewharton.platformcollections

import kotlin.collections.MutableMap.MutableEntry

@Suppress("unused") // Type parameters on actual and extensions.
public expect class PlatformMap<K, V>
public constructor()

public inline fun <K, V> PlatformMap<K, V>.asMap(): Map<K, V> {
	// TODO file a bug?
	@Suppress(
		"USELESS_CAST", // Some platforms don't see this as polymorphic.
		"UNCHECKED_CAST",
	)
	return asMutableMap() as Map<K, V>
}

public expect fun <K, V> PlatformMap<K, V>.asMutableMap(): MutableMap<K, V>

public expect fun <K, V> PlatformMap<K, V>.clear()

public expect operator fun <K, V> PlatformMap<K, V>.contains(key: K): Boolean

public expect operator fun <K, V> PlatformMap<K, V>.get(key: K): V?

public expect fun <K, V> PlatformMap<K, V>.isEmpty(): Boolean

public inline fun <K, V> PlatformMap<K, V>.isNotEmpty(): Boolean {
	return !isEmpty()
}

public expect operator fun <K, V> PlatformMap<K, V>.iterator(): MutableIterator<MutableEntry<K, V>>

public expect fun <K, V> PlatformMap<K, V>.put(key: K, value: V)

public expect fun <K, V> PlatformMap<K, V>.remove(key: K)

public expect val <K, V> PlatformMap<K, V>.size: Int

public inline fun <K, V> PlatformMap<K, V>.toMap(): Map<K, V> {
	// TODO file a bug?
	@Suppress(
		"USELESS_CAST", // Some platforms don't see this as polymorphic.
		"UNCHECKED_CAST",
	)
	return toMutableMap() as Map<K, V>
}

public expect fun <K, V> PlatformMap<K, V>.toMutableMap(): MutableMap<K, V>
