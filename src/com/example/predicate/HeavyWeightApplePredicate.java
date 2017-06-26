package com.example.predicate;

import java.util.function.Predicate;

public class HeavyWeightApplePredicate implements Predicate<Apple> {

	@Override
	public boolean test(Apple t) {
		return t.getWeight() > 150;
	}

}
