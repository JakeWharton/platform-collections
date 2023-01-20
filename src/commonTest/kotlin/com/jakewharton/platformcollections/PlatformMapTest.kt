package com.jakewharton.platformcollections

import kotlin.test.Test
import kotlin.test.assertEquals

class PlatformMapTest {
	@Test fun litmus() {
		val map = PlatformMap<String, String>()
		map.put("hey", "hello")
		assertEquals(1, map.size)
		assertEquals("hello", map["hey"])
	}
}
