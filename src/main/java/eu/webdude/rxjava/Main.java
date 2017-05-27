package eu.webdude.rxjava;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        regularObservableDemo();
//        fibObservableDemo();
        subjectDemo();
    }

    private static void regularObservableDemo() {
        Observable<Integer> observable = Observable
                .fromIterable(Arrays.asList(1, 2, 3, 4, 5))
                .filter(x -> x % 2 == 0);

        observable.subscribe(System.out::println, x -> System.out.println("Error"), () -> System.out.println("No more values"));
    }

    private static void fibObservableDemo() {
        Observable<BigInteger> fibObservable = Observable.fromIterable(new FibGenerator());

        fibObservable
                .skipWhile(x -> x.compareTo(BigInteger.valueOf(100_000_000)) < 0)
                .take(10)
                .subscribe(System.out::println);
    }

    private static void subjectDemo() {
        BehaviorSubject<BigInteger> subject = BehaviorSubject.create();

        subject.subscribe(num -> System.out.printf("Subscriber 1: %d%n", num));

        Observable.fromIterable(new FibGenerator())
                .take(10)
                .subscribe(subject::onNext, subject::onError, () -> {
                    System.out.println("Observable elapsed!");
                    subject.onComplete();
                });

        subject.subscribe(num -> System.out.printf("Subscriber 2: %d%n", num), System.out::println, () -> System.out.println("Subscriber 2 finished"));
    }
}
