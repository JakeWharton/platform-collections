package com.jakewharton.platformcollections

import kotlin.test.Test
import kotlin.test.assertEquals

class PlatformSetTest {
	@Test fun litmus() {
		val set = PlatformSet<String>()
		set.add("hey")
		assertEquals(1, set.size)
		set.add("hey")
		assertEquals(1, set.size)
	}
}
