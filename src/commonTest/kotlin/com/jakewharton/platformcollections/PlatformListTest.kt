package com.jakewharton.platformcollections

import assertk.assertThat
import assertk.assertions.isInstanceOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PlatformListTest {
	@Test fun add() {
		val list = PlatformList<String>()
		list.add("one")
		list.add("two")
		assertEquals(2, list.size)
		assertEquals("one", list[0])
		assertEquals("two", list[1])
	}

	@Test fun addIndex() {
		val list = PlatformList<String>()
		list.add(0, "two")
		list.add(1, "three")
		list.add(0, "one")
		assertEquals(3, list.size)
		assertEquals("one", list[0])
		assertEquals("two", list[1])
		assertEquals("three", list[2])
	}

	@DarwinIgnore // Objective-C's exceptions cannot be caught.
	@Test fun addNegativeIndexThrows() {
		val list = PlatformList<String>()
		assertFails {
			list.add(-1, "hey")
		}
	}

	@DarwinIgnore // Objective-C's exceptions cannot be caught.
	@Test fun addIndexOutOfRangeThrows() {
		val list = PlatformList<String>()
		assertFails {
			list.add(1, "hey")
		}
	}

	@Test fun asList() {
		val platformList = PlatformList<String>()
		platformList.add("one")
		val kotlinList = platformList.asList()
		assertEquals(listOf("one"), kotlinList)
		platformList.add("two")
		assertEquals(listOf("one", "two"), kotlinList)
	}

	@Test fun asListIsRandomAccess() {
		val list = PlatformList<String>().asList()
		assertThat(list).isInstanceOf<RandomAccess>()
	}

	@Test fun asMutableList() {
		val platformList = PlatformList<String>()
		platformList.add("one")
		val kotlinList = platformList.asMutableList()
		assertEquals(listOf("one"), kotlinList)
		platformList.add("two")
		assertEquals(listOf("one", "two"), kotlinList)
	}

	@Test fun asMutableListIsRandomAccess() {
		val list = PlatformList<String>().asMutableList()
		assertThat(list).isInstanceOf<RandomAccess>()
	}

	@Test fun asMutableListAdd() {
		val platformList = PlatformList<String>()
		platformList.add("one")
		val kotlinList = platformList.asMutableList()
		kotlinList.add("two")
		assertEquals(listOf("one", "two"), kotlinList)
		assertEquals(2, platformList.size)
		assertEquals("two", platformList[1])
	}

	@Test fun asMutableListClear() {
		val platformList = PlatformList<String>()
		platformList.add("one")
		platformList.add("two")
		assertEquals(2, platformList.size)
		val kotlinList = platformList.asMutableList()
		kotlinList.clear()
		assertEquals(0, platformList.size)
	}

	@Test fun asMutableListRemove() {
		val platformList = PlatformList<String>()
		platformList.add("one")
		platformList.add("two")
		assertEquals(2, platformList.size)
		val kotlinList = platformList.asMutableList()
		kotlinList.remove("one")
		assertEquals(1, platformList.size)
		assertEquals("two", platformList[0])
	}

	@Test fun clear() {
		val list = PlatformList<String>()
		list.add("one")
		list.add("two")
		assertEquals(2, list.size)
		list.clear()
		assertEquals(0, list.size)
	}

	@Test fun contains() {
		val list = PlatformList<String>()
		assertFalse(list.contains("one"))
		list.add("one")
		assertTrue(list.contains("one"))
	}

	@Test fun get() {
		val list = PlatformList<String>()
		list.add("one")
		list.add("two")
		assertEquals("one", list[0])
		assertEquals("two", list[1])
	}

	@DarwinIgnore // Objective-C's exceptions cannot be caught.
	@Test fun getEmptyThrows() {
		val list = PlatformList<String>()
		assertFails {
			list[0]
		}
	}

	@DarwinIgnore // Objective-C's exceptions cannot be caught.
	@Test fun getNegativeThrows() {
		val list = PlatformList<String>()
		list.add("one")
		assertFails {
			list[-1]
		}
	}

	@DarwinIgnore // Objective-C's exceptions cannot be caught.
	@Test fun getOutOfRangeThrows() {
		val list = PlatformList<String>()
		list.add("one")
		assertFails {
			list[1]
		}
	}

	@Test fun indexOf() {
		val list = PlatformList<String>()
		list.add("one")
		list.add("two")
		list.add("three")
		list.add("two")
		list.add("one")
		assertEquals(1, list.indexOf("two"))
		assertEquals(2, list.indexOf("three"))
		assertEquals(-1, list.indexOf("four"))
	}

	@Test fun isEmpty() {
		val list = PlatformList<String>()
		assertTrue(list.isEmpty())
		list.add("one")
		assertFalse(list.isEmpty())
	}

	@Test fun isNotEmpty() {
		val list = PlatformList<String>()
		assertFalse(list.isNotEmpty())
		list.add("one")
		assertTrue(list.isNotEmpty())
	}

	@Test fun iterator() {
		val list = PlatformList<String>()
		list.add("one")
		list.add("two")

		val iterator = list.iterator()
		assertEquals("one", iterator.next())
		assertEquals("two", iterator.next())
		assertFailsWith<NoSuchElementException> {
			iterator.next()
		}
	}

	@Test fun iteratorHasNext() {
		val list = PlatformList<String>()
		list.add("one")
		list.add("two")

		val iterator = list.iterator()
		assertTrue(iterator.hasNext())
		iterator.next()
		assertTrue(iterator.hasNext())
		iterator.next()
		assertFalse(iterator.hasNext())
	}

	@Test fun iteratorRemove() {
		val list = PlatformList<String>()
		list.add("one")
		list.add("two")

		val iterator = list.iterator()
		iterator.next()
		iterator.remove()
		assertEquals(1, list.size)
		assertEquals("two", list[0])
	}

	@Test fun iteratorRemoveAfterHasNextFalse() {
		val list = PlatformList<String>()
		list.add("one")
		list.add("two")

		val iterator = list.iterator()
		iterator.next()
		iterator.next()
		assertFalse(iterator.hasNext()) // Should not affect removal ability.
		iterator.remove()
		assertEquals(1, list.size)
		assertEquals("one", list[0])
	}

	@Test fun iteratorRemoveBeforeNextThrows() {
		val list = PlatformList<String>()
		list.add("one")
		list.add("two")

		val iterator = list.iterator()
		assertFailsWith<IllegalStateException> {
			iterator.remove()
		}
		assertEquals(2, list.size)
	}

	@Test fun iteratorRemoveTwiceThrows() {
		val list = PlatformList<String>()
		list.add("one")
		list.add("two")

		val iterator = list.iterator()
		iterator.next()
		iterator.remove()
		assertFailsWith<IllegalStateException> {
			iterator.remove()
		}
		assertEquals(1, list.size)
	}

	@Test fun iteratorRemoveAfterHasNextThrows() {
		val list = PlatformList<String>()
		list.add("one")
		list.add("two")

		val iterator = list.iterator()
		iterator.next()
		iterator.remove()
		assertTrue(iterator.hasNext())
		assertFailsWith<IllegalStateException> {
			iterator.remove()
		}
		assertEquals(1, list.size)
	}

	@Test fun lastIndexOf() {
		val list = PlatformList<String>()
		list.add("one")
		list.add("two")
		list.add("three")
		list.add("two")
		list.add("one")
		assertEquals(3, list.lastIndexOf("two"))
		assertEquals(2, list.lastIndexOf("three"))
		assertEquals(-1, list.lastIndexOf("four"))
	}

	@Test fun toList() {
		val platformList = PlatformList<String>()
		platformList.add("one")
		val kotlinList = platformList.toList()
		assertEquals(listOf("one"), kotlinList)
		platformList.add("two")
		assertEquals(listOf("one"), kotlinList)
	}

	@Test fun toListIsRandomAccess() {
		val list = PlatformList<String>().toList()
		assertThat(list).isInstanceOf<RandomAccess>()
	}

	@Test fun toMutableList() {
		val platformList = PlatformList<String>()
		platformList.add("one")
		val kotlinList = platformList.toMutableList()
		assertEquals(listOf("one"), kotlinList)
		platformList.add("two")
		assertEquals(listOf("one"), kotlinList)
	}

	@Test fun toMutableListIsRandomAccess() {
		val list = PlatformList<String>().toMutableList()
		assertThat(list).isInstanceOf<RandomAccess>()
	}

	@Test fun toMutableListAdd() {
		val platformList = PlatformList<String>()
		platformList.add("one")
		val kotlinList = platformList.toMutableList()
		assertEquals(listOf("one"), kotlinList)
		kotlinList.add("two")
		assertEquals(listOf("one", "two"), kotlinList)
		assertEquals(1, platformList.size)
		assertEquals("one", platformList[0])
	}
}
