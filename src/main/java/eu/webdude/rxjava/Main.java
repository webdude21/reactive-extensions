package eu.webdude.rxjava;

import io.reactivex.Observable;

import java.math.BigInteger;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Observable<Integer> observable = Observable
				.fromIterable(Arrays.asList(1, 2, 3, 4, 5))
				.filter(x -> x % 2 == 0);

		observable.subscribe(System.out::println, x -> System.out.println("Error"), () -> System.out.println("No more values"));

		Observable<BigInteger> fibObservable = Observable.fromIterable(new FibGenerator());

		fibObservable
				.skipWhile(x -> x.compareTo(BigInteger.valueOf(100_000_000)) < 0)
				.take(10)
				.subscribe(System.out::println);
	}
}
