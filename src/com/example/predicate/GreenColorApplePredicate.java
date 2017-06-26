package com.example.predicate;

import java.util.function.Predicate;

public class GreenColorApplePredicate implements Predicate<Apple> {

	@Override
	public boolean test(Apple t) {
		return t.getColor().equalsIgnoreCase("green");
	}

}
