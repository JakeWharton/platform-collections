@file:Suppress("NOTHING_TO_INLINE")

package com.jakewharton.platformcollections

@Suppress("ACTUAL_WITHOUT_EXPECT") // https://youtrack.jetbrains.com/issue/KT-37316
internal actual typealias PlatformListStorage<E> = java.util.ArrayList<E>

public actual inline fun <E> PlatformList(): PlatformList<E> {
	return PlatformList(ArrayList())
}

@JvmInline
public actual value class PlatformList<E>
@PublishedApi internal constructor(
	@PublishedApi internal val storage: ArrayList<E>,
) {
	public actual inline fun size(): Int = storage.size

	public actual inline operator fun contains(element: E): Boolean {
		return storage.contains(element)
	}

	public actual inline operator fun get(index: Int): E {
		return storage[index]
	}

	public actual inline fun indexOf(element: E): Int {
		return storage.indexOf(element)
	}

	public actual inline fun lastIndexOf(element: E): Int {
		return storage.lastIndexOf(element)
	}

	public actual inline fun add(element: E) {
		storage.add(element)
	}

	public actual inline fun add(index: Int, element: E) {
		storage.add(index, element)
	}

	public actual inline operator fun set(index: Int, element: E): E {
		return storage.set(index, element)
	}

	public actual inline fun clear() {
		storage.clear()
	}

	public actual inline fun forEach(noinline block: (E) -> Unit) {
		storage.forEach(block)
	}

	public actual inline fun asMutableList(): MutableList<E> {
		return storage
	}

	public actual inline fun toMutableList(): MutableList<E> {
		return ArrayList(storage)
	}

	@Suppress("OVERRIDE_BY_INLINE")
	actual override inline fun toString(): String {
		// TODO Eliminate the intrinsic check this produces:
		//    27: aload_0
		//    28: invokevirtual #68  // Method java/util/ArrayList.toString:()Ljava/lang/String;
		//    31: dup
		//    32: ldc           #70  // String storage.toString()
		//    34: invokestatic  #73  // Method kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
		//  For now we double bang to eliminate the string, at least.
		@Suppress("UNNECESSARY_NOT_NULL_ASSERTION")
		return storage.toString()!!
	}
}
