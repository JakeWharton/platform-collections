@file:Suppress(
	"NOTHING_TO_INLINE",
	"EXTENSION_SHADOWED_BY_MEMBER", // Mirroring MutableSet API closely.
	"KotlinRedundantDiagnosticSuppress", // Shadow only occurs on some targets.
)

package com.jakewharton.platformcollections

@Suppress("unused") // Type parameter on actual and extensions.
public expect class PlatformSet<E>
public constructor()

public expect fun <E> PlatformSet<E>.add(item: E)

public expect fun <E> PlatformSet<E>.asMutableSet(): MutableSet<E>

public inline fun <E> PlatformSet<E>.asSet(): Set<E> {
	// TODO file a bug?
	@Suppress(
		"USELESS_CAST", // Some platforms don't see this as polymorphic.
		"UNCHECKED_CAST",
	)
	return asMutableSet() as Set<E>
}

public expect fun <E> PlatformSet<E>.clear()

public expect operator fun <E> PlatformSet<E>.contains(item: E): Boolean

public expect fun <E> PlatformSet<E>.isEmpty(): Boolean

public inline fun <E> PlatformSet<E>.isNotEmpty(): Boolean {
	return !isEmpty()
}

public expect fun <E> PlatformSet<E>.remove(item: E)

public expect val <E> PlatformSet<E>.size: Int

public expect fun <E> PlatformSet<E>.toMutableSet(): MutableSet<E>

public inline fun <E> PlatformSet<E>.toSet(): Set<E> {
	// TODO file a bug?
	@Suppress(
		"USELESS_CAST", // Some platforms don't see this as polymorphic.
		"UNCHECKED_CAST",
	)
	return toMutableSet() as Set<E>
}
