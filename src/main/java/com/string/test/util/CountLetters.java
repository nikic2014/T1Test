package com.string.test.util;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CountLetters {
    public Map<Character, Integer> sortMap(Map<Character, Integer> unsortedMap){
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(unsortedMap.entrySet());

        // Сортируем записи по значению
        entries.sort(Map.Entry.comparingByValue());
        Collections.reverse(entries);

        // Создаем новый LinkedHashMap, чтобы сохранить порядок сортировки
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }


    public Map<Character, Integer> countLetters(String input) {
        Map<Character, Integer> countLetters = new TreeMap<>(Comparator.reverseOrder());

        for (char ch : input.toCharArray()) {
            countLetters.put(ch, countLetters.getOrDefault(ch, 0) + 1);
        }

        return sortMap(countLetters);
    }
}
