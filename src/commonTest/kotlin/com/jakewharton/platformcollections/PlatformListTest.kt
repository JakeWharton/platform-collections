package com.jakewharton.platformcollections

import kotlin.test.Test
import kotlin.test.assertEquals

class PlatformListTest {
	@Test fun litmus() {
		val list = PlatformList<String>()
		list.add("hey")
		assertEquals(1, list.size)
		assertEquals("hey", list[0])
	}
}
