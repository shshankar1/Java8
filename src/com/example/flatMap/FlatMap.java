package com.example.flatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

	public static void main(String[] args) {
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> numbers2 = Arrays.asList(6, 7, 8);

		List<int[]> pairs = numbers1
				.stream()
				.flatMap(
						((Integer i) -> numbers2.stream().map(
								(Integer j) -> new int[] { i, j })))
				.collect(Collectors.toList());
		pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1]	+ ")"));
	}

}
