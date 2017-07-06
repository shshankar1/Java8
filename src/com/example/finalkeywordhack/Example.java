package com.example.finalkeywordhack;

import java.lang.reflect.Field;

public class Example {

	public static void main(String[] args) throws SecurityException,
			NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {
		Employee e1 = new Employee(123);
		Field id = Employee.class.getDeclaredField("id");
		id.setAccessible(true);
		id.set(e1, 345);
		System.out.println(e1.toString());
	}
}

class Employee {
	private final int id;

	public Employee(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + "]";
	}

}
