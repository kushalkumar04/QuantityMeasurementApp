/*
 * Enum representing temperature units.
 * Supports conversion but not arithmetic.
 */

package com.apps.quantitymeasurement;

import java.util.function.Function;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS(
            celsius -> celsius,
            celsius -> celsius
    ),

    FAHRENHEIT(
            fahrenheit -> (fahrenheit - 32) * 5 / 9,
            celsius -> (celsius * 9 / 5) + 32
    ),

    KELVIN(
            kelvin -> kelvin - 273.15,
            celsius -> celsius + 273.15
    );

    private final Function<Double, Double> toBaseConversion;

    private final Function<Double, Double> fromBaseConversion;

    TemperatureUnit(
            Function<Double, Double> toBaseConversion,
            Function<Double, Double> fromBaseConversion
    ) {

        this.toBaseConversion =
                toBaseConversion;

        this.fromBaseConversion =
                fromBaseConversion;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return toBaseConversion.apply(value);
    }

    @Override
    public double convertFromBaseUnit(double value) {
        return fromBaseConversion.apply(value);
    }

    /*
     * Temperature does not support arithmetic.
     */
    @Override
    public SupportsArithmetic supportsArithmetic() {
        return () -> false;
    }

    @Override
    public void validateOperationSupport(String operation) {

        throw new UnsupportedOperationException(
                "Temperature does not support "
                        + operation +
                        " operation."
        );
    }
}