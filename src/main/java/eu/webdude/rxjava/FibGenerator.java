package eu.webdude.rxjava;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.function.Consumer;


public class FibGenerator implements Iterable<BigInteger> {
    @Override
    public Iterator<BigInteger> iterator() {
        return new Iterator<BigInteger>() {
            private BigInteger current = BigInteger.ONE;
            private BigInteger previous = BigInteger.ZERO;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public BigInteger next() {
                BigInteger temp = current;
                current = previous.add(current);
                previous = temp;
                return temp;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super BigInteger> action) {
        for (BigInteger i : this) {
            action.accept(i);
        }
    }
}