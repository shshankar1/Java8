package com.example.IntStream;

import java.util.stream.IntStream;

public class IntStreamExample {

	public static void main(String[] args) {
		//for 1 to 100 step 1
		IntStream.range(1,100).forEach(x ->System.out.println(x));
		
		//for 1 to 100 step 2
		IntStream.range(1, 100/2).map(i -> 2*i-1).forEach(x ->System.out.println(x));

	}

}
