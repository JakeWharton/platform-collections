package com.jakewharton.platformcollections

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PlatformSetTest {
	@Test fun add() {
		val set = PlatformSet<String>()
		set.add("one")
		set.add("two")
		assertEquals(2, set.size)
		assertTrue("one" in set)
		assertTrue("two" in set)
	}

	@Test fun addExisting() {
		val set = PlatformSet<String>()
		set.add("one")
		set.add("one")
		assertEquals(1, set.size)
		assertTrue("one" in set)
	}

	@Test fun asSet() {
		val platformSet = PlatformSet<String>()
		platformSet.add("one")
		val kotlinSet = platformSet.asSet()
		assertEquals(setOf("one"), kotlinSet)
		platformSet.add("two")
		assertEquals(setOf("one", "two"), kotlinSet)
	}

	@Test fun asMutableSet() {
		val platformSet = PlatformSet<String>()
		platformSet.add("one")
		val kotlinSet = platformSet.asMutableSet()
		assertEquals(setOf("one"), kotlinSet)
		platformSet.add("two")
		assertEquals(setOf("one", "two"), kotlinSet)
	}

	@Test fun asMutableSetAdd() {
		val platformSet = PlatformSet<String>()
		platformSet.add("one")
		val kotlinSet = platformSet.asMutableSet()
		kotlinSet.add("two")
		assertEquals(setOf("one", "two"), kotlinSet)
		assertEquals(2, platformSet.size)
		assertTrue("two" in platformSet)
	}

	@Test fun asMutableSetClear() {
		val platformSet = PlatformSet<String>()
		platformSet.add("one")
		platformSet.add("two")
		assertEquals(2, platformSet.size)
		val kotlinSet = platformSet.asMutableSet()
		kotlinSet.clear()
		assertEquals(0, platformSet.size)
	}

	@Test fun asMutableSetRemove() {
		val platformSet = PlatformSet<String>()
		platformSet.add("one")
		platformSet.add("two")
		assertEquals(2, platformSet.size)
		val kotlinSet = platformSet.asMutableSet()
		kotlinSet.remove("one")
		assertEquals(1, platformSet.size)
		assertFalse("one" in platformSet)
	}

	@Test fun clear() {
		val set = PlatformSet<String>()
		set.add("one")
		set.add("two")
		assertEquals(2, set.size)
		set.clear()
		assertEquals(0, set.size)
	}

	@Test fun contains() {
		val set = PlatformSet<String>()
		assertFalse(set.contains("one"))
		set.add("one")
		assertTrue(set.contains("one"))
	}

	@Test fun isEmpty() {
		val set = PlatformSet<String>()
		assertTrue(set.isEmpty())
		set.add("one")
		assertFalse(set.isEmpty())
	}

	@Test fun isNotEmpty() {
		val set = PlatformSet<String>()
		assertFalse(set.isNotEmpty())
		set.add("one")
		assertTrue(set.isNotEmpty())
	}

	@Test fun iterator() {
		val set = PlatformSet<String>()
		set.add("one")
		set.add("two")

		val iterator = set.iterator()
		assertEquals("one", iterator.next())
		assertEquals("two", iterator.next())
		assertFailsWith<NoSuchElementException> {
			iterator.next()
		}
	}

	@Test fun iteratorHasNext() {
		val set = PlatformSet<String>()
		set.add("one")
		set.add("two")

		val iterator = set.iterator()
		assertTrue(iterator.hasNext())
		iterator.next()
		assertTrue(iterator.hasNext())
		iterator.next()
		assertFalse(iterator.hasNext())
	}

	@Test fun iteratorRemove() {
		val set = PlatformSet<String>()
		set.add("one")
		set.add("two")

		val iterator = set.iterator()
		iterator.next()
		iterator.remove()
		assertEquals(1, set.size)
		assertTrue("two" in set)
	}

	@Test fun iteratorRemoveAfterHasNextFalse() {
		val set = PlatformSet<String>()
		set.add("one")
		set.add("two")

		val iterator = set.iterator()
		iterator.next()
		iterator.next()
		assertFalse(iterator.hasNext()) // Should not affect removal ability.
		iterator.remove()
		assertEquals(1, set.size)
		assertTrue("one" in set)
	}

	@DarwinIgnore // Objective-C's exceptions cannot be caught.
	@Test fun iteratorRemoveBeforeNextThrows() {
		val set = PlatformSet<String>()
		set.add("one")
		set.add("two")

		val iterator = set.iterator()
		assertFailsWith<IllegalStateException> {
			iterator.remove()
		}
		assertEquals(2, set.size)
	}

	@DarwinIgnore // Objective-C's exceptions cannot be caught.
	@Test fun iteratorRemoveTwiceThrows() {
		val set = PlatformSet<String>()
		set.add("one")
		set.add("two")

		val iterator = set.iterator()
		iterator.next()
		iterator.remove()
		assertFailsWith<IllegalStateException> {
			iterator.remove()
		}
		assertEquals(1, set.size)
	}

	@DarwinIgnore // Objective-C's exceptions cannot be caught.
	@Test fun iteratorRemoveAfterHasNextThrows() {
		val set = PlatformSet<String>()
		set.add("one")
		set.add("two")

		val iterator = set.iterator()
		iterator.next()
		iterator.remove()
		assertTrue(iterator.hasNext()) // Should not reset removal ability.
		assertFailsWith<IllegalStateException> {
			iterator.remove()
		}
		assertEquals(1, set.size)
	}

	@Test fun remove() {
		val set = PlatformSet<String>()
		set.add("one")
		assertEquals(1, set.size)

		set.remove("one")
		assertEquals(0, set.size)

		// Ensure we can remove an element which is not in the set.
		set.remove("one")
		assertEquals(0, set.size)
	}

	@Test fun size() {
		val set = PlatformSet<String>()
		assertEquals(0, set.size)

		set.add("one")
		assertEquals(1, set.size)

		set.add("two")
		assertEquals(2, set.size)
	}

	@Test fun toSet() {
		val platformSet = PlatformSet<String>()
		platformSet.add("one")
		val kotlinSet = platformSet.toSet()
		assertEquals(setOf("one"), kotlinSet)
		platformSet.add("two")
		assertEquals(setOf("one"), kotlinSet)
	}

	@Test fun toMutableSet() {
		val platformSet = PlatformSet<String>()
		platformSet.add("one")
		val kotlinSet = platformSet.toMutableSet()
		assertEquals(setOf("one"), kotlinSet)
		platformSet.add("two")
		assertEquals(setOf("one"), kotlinSet)
	}

	@Test fun toMutableSetAdd() {
		val platformSet = PlatformSet<String>()
		platformSet.add("one")
		val kotlinSet = platformSet.toMutableSet()
		assertEquals(setOf("one"), kotlinSet)
		kotlinSet.add("two")
		assertEquals(setOf("one", "two"), kotlinSet)
		assertEquals(1, platformSet.size)
		assertFalse("two" in platformSet)
	}
}
