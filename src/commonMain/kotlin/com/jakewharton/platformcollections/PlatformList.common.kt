@file:Suppress(
	"NOTHING_TO_INLINE",
	"EXTENSION_SHADOWED_BY_MEMBER", // Mirroring MutableList API closely.
	"KotlinRedundantDiagnosticSuppress", // Shadow only occurs on some targets.
)

package com.jakewharton.platformcollections

@Suppress("unused") // Type parameter on actual and extensions.
public expect class PlatformList<E>
public constructor()

public expect fun <E> PlatformList<E>.add(item: E)

public expect fun <E> PlatformList<E>.add(index: Int, item: E)

public inline fun <E> PlatformList<E>.asList(): List<E> {
	return asMutableList()
}

public expect fun <E> PlatformList<E>.asMutableList(): MutableList<E>

public expect fun <E> PlatformList<E>.clear()

public expect operator fun <E> PlatformList<E>.contains(item: E): Boolean

public expect operator fun <E> PlatformList<E>.get(index: Int): E

public expect fun <E> PlatformList<E>.indexOf(item: E): Int

public expect fun <E> PlatformList<E>.isEmpty(): Boolean

public inline fun <E> PlatformList<E>.isNotEmpty(): Boolean {
	return !isEmpty()
}

public expect fun <E> PlatformList<E>.lastIndexOf(item: E): Int

public expect fun <E> PlatformList<E>.set(index: Int, item: E)

public expect val <E> PlatformList<E>.size: Int

public inline fun <E> PlatformList<E>.toList(): List<E> {
	return toMutableList()
}

public expect fun <E> PlatformList<E>.toMutableList(): MutableList<E>
