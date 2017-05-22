package eu.webdude.rxjava;

import io.reactivex.Observable;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Observable<Integer> observable = Observable
				.fromIterable(Arrays.asList(1, 2, 3, 4, 5))
				.filter(x -> x % 2 == 0);

		observable.subscribe(System.out::println, x -> System.out.println("Error"), () -> System.out.println("No more values"));
	}
}
