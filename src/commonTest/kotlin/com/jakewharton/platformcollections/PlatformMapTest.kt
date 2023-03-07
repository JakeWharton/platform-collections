package com.jakewharton.platformcollections

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class PlatformMapTest {
	@Test fun asMap() {
		val platformMap = PlatformMap<String, String>()
		platformMap.put("one", "two")
		val kotlinMap = platformMap.asMap()
		assertEquals(mapOf("one" to "two"), kotlinMap)
		platformMap.put("three", "four")
		assertEquals(mapOf("one" to "two", "three" to "four"), kotlinMap)
	}

	@Test fun asMutableMap() {
		val platformMap = PlatformMap<String, String>()
		platformMap.put("one", "two")
		val kotlinMap = platformMap.asMutableMap()
		assertEquals(mapOf("one" to "two"), kotlinMap)
		platformMap.put("three", "four")
		assertEquals(mapOf("one" to "two", "three" to "four"), kotlinMap)
	}

	@Test fun asMutableMapAdd() {
		val platformMap = PlatformMap<String, String>()
		platformMap.put("one", "two")
		val kotlinMap = platformMap.asMutableMap()
		kotlinMap.put("three", "four")
		assertEquals(mapOf("one" to "two", "three" to "four"), kotlinMap)
		assertEquals(2, platformMap.size)
		assertTrue("three" in platformMap)
	}

	@Test fun asMutableMapClear() {
		val platformMap = PlatformMap<String, String>()
		platformMap.put("one", "two")
		platformMap.put("three", "four")
		assertEquals(2, platformMap.size)
		val kotlinMap = platformMap.asMutableMap()
		kotlinMap.clear()
		assertEquals(0, platformMap.size)
	}

	@Test fun asMutableMapRemove() {
		val platformMap = PlatformMap<String, String>()
		platformMap.put("one", "two")
		platformMap.put("three", "four")
		assertEquals(2, platformMap.size)
		val kotlinMap = platformMap.asMutableMap()
		kotlinMap.remove("one")
		assertEquals(1, platformMap.size)
		assertFalse("one" in platformMap)
	}

	@Test fun asMutableMapKeysRemove() {
		val platformMap = PlatformMap<String, String>()
		platformMap.put("one", "two")
		platformMap.put("three", "four")
		assertEquals(2, platformMap.size)
		val kotlinMap = platformMap.asMutableMap()
		kotlinMap.keys.remove("one")
		assertEquals(1, platformMap.size)
		assertFalse("one" in platformMap)
	}

	@Test fun asMutableMapKeysAddThrows() {
		val platformMap = PlatformMap<String, String>()
		val kotlinMapKey = platformMap.asMutableMap().keys
		assertFailsWith<UnsupportedOperationException> {
			kotlinMapKey.add("one")
		}
	}

	@Test fun asMutableMapValuesRemove() {
		val platformMap = PlatformMap<String, String>()
		platformMap.put("one", "two")
		platformMap.put("three", "four")
		assertEquals(2, platformMap.size)
		val kotlinMap = platformMap.asMutableMap()
		kotlinMap.values.remove("two")
		assertEquals(1, platformMap.size)
		assertFalse("one" in platformMap)
	}

	@Test fun asMutableMapValuesAddThrows() {
		val platformMap = PlatformMap<String, String>()
		val kotlinMapValues = platformMap.asMutableMap().values
		assertFailsWith<UnsupportedOperationException> {
			kotlinMapValues.add("one")
		}
	}

	@Test fun asMutableMapEntriesRemove() {
		val platformMap = PlatformMap<String, String>()
		platformMap.put("one", "two")
		platformMap.put("three", "four")
		assertEquals(2, platformMap.size)
		val kotlinMap = platformMap.asMutableMap()
		kotlinMap.entries.iterator().apply {
			assertEquals("one", next().key)
			remove()
		}
		assertEquals(1, platformMap.size)
		assertFalse("one" in platformMap)
	}

	@Test fun asMutableMapEntriesSetValue() {
		val platformMap = PlatformMap<String, String>()
		platformMap.put("one", "two")
		val kotlinMap = platformMap.asMutableMap()
		val kotlinEntry = kotlinMap.entries.iterator().next()
		assertEquals("one", kotlinEntry.key)
		kotlinEntry.setValue("ten")
		assertEquals(mapOf("one" to "ten"), kotlinMap)
		assertEquals("ten", platformMap.get("one"))
	}

	@Test fun asMutableMapEntriesAddThrows() {
		val platformMap = PlatformMap<String, String>()
		val kotlinMapEntries = platformMap.asMutableMap().entries
		val newEntry = object : MutableMap.MutableEntry<String, String> {
			override val key get() = "one"
			override var value = "two"
			override fun setValue(newValue: String): String {
				val oldValue = value
				value = newValue
				return oldValue
			}
		}
		assertFailsWith<UnsupportedOperationException> {
			kotlinMapEntries.add(newEntry)
		}
	}

	@Test fun clear() {
		val map = PlatformMap<String, String>()
		map.put("one", "two")
		map.put("three", "four")
		assertEquals(2, map.size)
		map.clear()
		assertEquals(0, map.size)
	}

	@Test fun contains() {
		val map = PlatformMap<String, String>()
		assertFalse(map.contains("one"))
		map.put("one", "two")
		assertTrue(map.contains("one"))
	}

	@Test fun get() {
		val map = PlatformMap<String, String>()
		map.put("one", "two")
		assertEquals("two", map.get("one"))
	}

	@Test fun getMissingReturnsNull() {
		val map = PlatformMap<String, String>()
		assertNull(map.get("one"))
	}

	@Test fun isEmpty() {
		val map = PlatformMap<String, String>()
		assertTrue(map.isEmpty())
		map.put("one", "two")
		assertFalse(map.isEmpty())
	}

	@Test fun isNotEmpty() {
		val map = PlatformMap<String, String>()
		assertFalse(map.isNotEmpty())
		map.put("one", "two")
		assertTrue(map.isNotEmpty())
	}

	@Test fun iterator() {
		val map = PlatformMap<String, String>()
		map.put("one", "two")
		map.put("three", "four")

		val iterator = map.iterator()
		iterator.next().let {
			assertEquals("one", it.key)
			assertEquals("two", it.value)
		}
		iterator.next().let {
			assertEquals("three", it.key)
			assertEquals("four", it.value)
		}
		assertFailsWith<NoSuchElementException> {
			iterator.next()
		}
	}

	@Test fun iteratorHasNext() {
		val map = PlatformMap<String, String>()
		map.put("one", "two")
		map.put("three", "four")

		val iterator = map.iterator()
		assertTrue(iterator.hasNext())
		iterator.next()
		assertTrue(iterator.hasNext())
		iterator.next()
		assertFalse(iterator.hasNext())
	}

	@Test fun iteratorRemove() {
		val map = PlatformMap<String, String>()
		map.put("one", "two")
		map.put("three", "four")

		val iterator = map.iterator()
		iterator.next()
		iterator.remove()
		assertEquals(1, map.size)
		assertTrue("three" in map)
	}

	@Test fun iteratorRemoveAfterHasNextFalse() {
		val map = PlatformMap<String, String>()
		map.put("one", "two")
		map.put("three", "four")

		val iterator = map.iterator()
		iterator.next()
		iterator.next()
		assertFalse(iterator.hasNext()) // Should not affect removal ability.
		iterator.remove()
		assertEquals(1, map.size)
		assertTrue("one" in map)
	}

	@DarwinIgnore // Objective-C's exceptions cannot be caught.
	@Test fun iteratorRemoveBeforeNextThrows() {
		val map = PlatformMap<String, String>()
		map.put("one", "two")
		map.put("three", "four")

		val iterator = map.iterator()
		assertFailsWith<IllegalStateException> {
			iterator.remove()
		}
		assertEquals(2, map.size)
	}

	@DarwinIgnore // Objective-C's exceptions cannot be caught.
	@Test fun iteratorRemoveTwiceThrows() {
		val map = PlatformMap<String, String>()
		map.put("one", "two")
		map.put("three", "four")

		val iterator = map.iterator()
		iterator.next()
		iterator.remove()
		assertFailsWith<IllegalStateException> {
			iterator.remove()
		}
		assertEquals(1, map.size)
	}

	@DarwinIgnore // Objective-C's exceptions cannot be caught.
	@Test fun iteratorRemoveAfterHasNextThrows() {
		val map = PlatformMap<String, String>()
		map.put("one", "two")
		map.put("three", "four")

		val iterator = map.iterator()
		iterator.next()
		iterator.remove()
		assertTrue(iterator.hasNext()) // Should not reset removal ability.
		assertFailsWith<IllegalStateException> {
			iterator.remove()
		}
		assertEquals(1, map.size)
	}

	@Test fun put() {
		val map = PlatformMap<String, String>()
		map.put("one", "two")
		assertEquals("two", map.get("one"))
	}

	@Test fun putReplacesExistingValue() {
		val map = PlatformMap<String, String>()
		map.put("one", "two")
		map.put("one", "three")
		assertEquals(1, map.size)
		assertEquals("three", map.get("one"))
	}

	@Test fun remove() {
		val map = PlatformMap<String, String>()
		map.put("one", "two")
		assertEquals(1, map.size)

		map.remove("one")
		assertEquals(0, map.size)

		// Ensure we can remove an element which is not in the set.
		map.remove("one")
		assertEquals(0, map.size)
	}

	@Test fun size() {
		val map = PlatformMap<String, String>()
		assertEquals(0, map.size)
		map.put("one", "two")
		assertEquals(1, map.size)
		map.put("three", "four")
		assertEquals(2, map.size)
	}

	@Test fun toMap() {
		val platformMap = PlatformMap<String, String>()
		platformMap.put("one", "two")
		val kotlinMap = platformMap.toMap()
		assertEquals(mapOf("one" to "two"), kotlinMap)
		platformMap.put("three", "four")
		assertEquals(mapOf("one" to "two"), kotlinMap)
	}

	@Test fun toMutableMap() {
		val platformMap = PlatformMap<String, String>()
		platformMap.put("one", "two")
		val kotlinMap = platformMap.toMutableMap()
		assertEquals(mapOf("one" to "two"), kotlinMap)
		platformMap.put("three", "four")
		assertEquals(mapOf("one" to "two"), kotlinMap)
	}

	@Test fun toMutableMapAdd() {
		val platformMap = PlatformMap<String, String>()
		platformMap.put("one", "two")
		val kotlinMap = platformMap.toMutableMap()
		assertEquals(mapOf("one" to "two"), kotlinMap)
		kotlinMap.put("three", "four")
		assertEquals(mapOf("one" to "two", "three" to "four"), kotlinMap)
		assertEquals(1, platformMap.size)
		assertFalse("three" in platformMap)
	}
}
