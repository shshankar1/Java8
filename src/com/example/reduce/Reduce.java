package com.example.reduce;

import java.util.Arrays;
import java.util.List;

public class Reduce {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

		// sum operation using reduce
		int sum = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println("Sum="+sum);
		
		//product operation using reduce
		int product = numbers.stream().reduce(1, (a,b)->a*b);
		System.out.println("Product="+product);
		
		//max operation using reduce
		int max = numbers.stream().reduce(Integer.MIN_VALUE, (a,b)->Integer.max(a, b));
		System.out.println("Max Value="+max);
		
		int min = numbers.stream().reduce(Integer.MAX_VALUE, (a,b)->Integer.min(a, b));
		System.out.println("Min Value="+min);
	}

}
