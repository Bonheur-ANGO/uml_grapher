package fr.lernejo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static fr.lernejo.Sample.Operation.ADD;
import static fr.lernejo.Sample.Operation.MULT;
import static org.junit.jupiter.api.Assertions.*;

class SampleTest {
    private final Sample sample = new Sample();

    @Test
    void testADD() {
        Sample sample = new Sample();
        Assertions.assertEquals(sample.op(ADD, 2, 2), 4);
    }

    @Test
    void testMULT() {
        Sample sample = new Sample();
        Assertions.assertEquals(sample.op(MULT, 2, 2), 4);
    }

    @Test
    void testNullFact() {
        Sample sample = new Sample();
        Assertions.assertThrows(IllegalArgumentException.class, () -> sample.fact(-5));
    }

    @Test
    void testFactIfZero() {
        Sample sample = new Sample();
        Assertions.assertEquals(sample.fact(0), 1);
    }
}
