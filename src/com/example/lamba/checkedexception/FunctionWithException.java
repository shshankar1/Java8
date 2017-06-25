package com.example.lamba.checkedexception;

//please note that @FunctionalInterface not a mandatory thing
//for qualifying an interface as functional
//this is just a check that interface has mandatory method apply
//@FunctionalInterface
public interface FunctionWithException<T, R> {
	R apply(T t) throws NumberFormatException;

}
