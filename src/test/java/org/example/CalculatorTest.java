package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// Al ejecutar run with Coverage y si es que algún test no cubre totalmente alguna funcionalidad de
// la clase
// En la clase en cuestión, saldrá rojo o amarilla
// Si el test cubre, saldrá en verde

class CalculatorTest {

    @Test
    void addTwoNumbersReturnsSum() {
        int result = Calculator.add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void addThreeNumbersReturnsSum() {
        int result = Calculator.add(1, 2, 3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void addMultipleNumbersReturnsSum() {
        int result = Calculator.add(1, 2, 3, 4);
        assertThat(result).isEqualTo(10);
    }

    @Test
    void noParametersReturnsZero() {
        int result = Calculator.add();
        assertThat(result).isEqualTo(0);
    }
}
