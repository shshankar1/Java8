package com.example.lamba.uncheckedexception;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaCheckedException {

	public static void main(String[] args) {
		List<String> input = Arrays.asList("10", "20", "30", "40", "tyi");

		FunctionWithException<String, Integer> myConversion = x -> Integer.parseInt(x);
		
		List<Integer> parsedInput = input.stream().map(x -> myConversion.apply(x))
				.collect(Collectors.toList());
		System.out.println(parsedInput.toString());
	}
}