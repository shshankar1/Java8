package com.example.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PredicateFilterExample {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple("green", 80),
												new Apple("red", 60), 
												new Apple("red", 160), 
												new Apple("green", 30));

		List<Apple> greenApples = inventory.stream()
				.filter(new GreenColorApplePredicate())
				.collect(Collectors.toList());
		
		System.out.println(greenApples.toString());
		
		List<Apple> heavyApples = inventory.stream()
				.filter(new HeavyWeightApplePredicate())
				.collect(Collectors.toList());
		
		System.out.println(heavyApples.toString());
		
		//Using Lambdas
		greenApples = inventory.stream()
				.filter(x -> x.getColor().equalsIgnoreCase("green")).collect(Collectors.toList());
		System.out.println(greenApples);
		
		heavyApples = inventory.stream().filter(x -> x.getWeight() >140).collect(Collectors.toList());
		System.out.println(heavyApples);
		
	}

}
