package com.string.test;

import com.string.test.util.CountLetters;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class TestApplicationTests {

	@Autowired
	private CountLetters countLetters;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCountLetters_EmptyString() {
		String input = "";
		Map<Character, Integer> expected = new LinkedHashMap<>();
		assertMapsEqual(expected, countLetters.countLetters(input));
	}

	@Test
	public void testCountLetters_SingleCharacter() {
		String input = "a";
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('a', 1);
		assertMapsEqual(expected, countLetters.countLetters(input));
	}

	@Test
	public void testCountLetters_RepeatedCharacters() {
		String input = "aaabbb";
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('a', 3);
		expected.put('b', 3);
		assertMapsEqual(expected, countLetters.countLetters(input));
	}

	@Test
	public void testCountLetters_MixedCharacters() {
		String input = "aabcc";
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('a', 2);
		expected.put('c', 2);
		expected.put('b', 1);
		assertMapsEqual(expected, countLetters.countLetters(input));
	}

	@Test
	public void testCountLetters_ReverseMixedCharacters() {
		String input = "cccbbbbaaazzzz";
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('b', 4);
		expected.put('z', 4);
		expected.put('a', 3);
		expected.put('c', 3);
		assertMapsEqual(expected, countLetters.countLetters(input));
	}

	@Test
	public void testCountLetters_SpecialCharacters() {
		String input = "a!@#a";
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('a', 2);
		expected.put('!', 1);
		expected.put('#', 1);
		expected.put('@', 1);
		assertMapsEqual(expected, countLetters.countLetters(input));
	}

	@Test
	public void testCountLetters_NumericCharacters() {
		String input = "a1a2";
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('a', 2);
		expected.put('1', 1);
		expected.put('2', 1);
		assertMapsEqual(expected, countLetters.countLetters(input));
	}

	@Test
	public void testCountLetters_CaseSensitive() {
		String input = "aAaA";
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('A', 2);
		expected.put('a', 2);
		assertMapsEqual(expected, countLetters.countLetters(input));
	}

	public static void assertMapsEqual(Map<Character, Integer> expected, Map<Character, Integer> actual) {
		if (expected.size() != actual.size()) {
			assertEquals(expected.size(), actual.size());
		}
		Iterator<Map.Entry<Character, Integer>> expectedIterator = expected.entrySet().iterator();
		Iterator<Map.Entry<Character, Integer>> actualIterator = actual.entrySet().iterator();

		while (expectedIterator.hasNext() && actualIterator.hasNext()) {
			Map.Entry<Character, Integer> expectedEntry = expectedIterator.next();
			Map.Entry<Character, Integer> actualEntry = actualIterator.next();

			assertEquals(expectedEntry.getKey(), actualEntry.getKey(), "Keys not equal");
			assertEquals(expectedEntry.getValue(), actualEntry.getValue(), "Values not equal");
		}
	}
}
