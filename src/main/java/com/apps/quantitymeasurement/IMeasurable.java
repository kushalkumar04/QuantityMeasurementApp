/*
 * Interface representing measurable units.
 * Supports conversion and optional arithmetic validation.
 */

package com.apps.quantitymeasurement;

public interface IMeasurable {

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double value);

    /*
     * By default all measurable units
     * support arithmetic operations.
     */
    default SupportsArithmetic supportsArithmetic() {
        return () -> true;
    }

    /*
     * Returns whether arithmetic
     * operations are supported.
     */
    default boolean isArithmeticSupported() {
        return supportsArithmetic().isSupported();
    }

    /*
     * Validates arithmetic support.
     */
    default void validateOperationSupport(String operation) {

        if (!isArithmeticSupported()) {

            throw new UnsupportedOperationException(
                    operation +
                            " operation is not supported for this measurement type."
            );
        }
    }
}