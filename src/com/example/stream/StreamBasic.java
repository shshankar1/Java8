package com.example.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class StreamBasic {

	public static void main(String[] args) {
		StreamBasic basic = new StreamBasic();
		List<Dish> dishes = Dish.menu;
		System.out.println(dishes.size());
		long start = System.nanoTime(); 
		basic.getLowCalorieDishesInJava7(dishes);
		long end = System.nanoTime();
		System.out.println("Time taken in execution: "+TimeUnit.MILLISECONDS.convert((end-start),TimeUnit.NANOSECONDS)+" ms");
		System.out.println("-----------");
		start = System.nanoTime();
		basic.getLowCalorieDishesInJava8(dishes);
		end = System.nanoTime();
		System.out.println("Time taken in execution: "+TimeUnit.MILLISECONDS.convert((end-start),TimeUnit.NANOSECONDS)+" ms");
	}

	private List<String> getLowCalorieDishesInJava7(List<Dish> dishes) {
		List<Dish> lowCalorieDishes = new ArrayList<>();

		for (Dish dish : dishes) {
			if (dish.getCalories() < 400)
				lowCalorieDishes.add(dish);
		}

		Collections.sort(lowCalorieDishes, new Comparator<Dish>() {
			@Override
			public int compare(Dish o1, Dish o2) {
				return Integer.compare(o1.getCalories(), o2.getCalories());
			}
		});
		
		List<String> dishNames = new ArrayList<>();
		for(Dish dish: lowCalorieDishes)
			dishNames.add(dish.getName());
		return dishNames;
	}
	
	private List<String> getLowCalorieDishesInJava8(List<Dish> dishes) {
		return dishes.stream()
				.filter(dish -> dish.getCalories() < 400)
				.sorted(Comparator.comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(Collectors.toList());
	}
}
