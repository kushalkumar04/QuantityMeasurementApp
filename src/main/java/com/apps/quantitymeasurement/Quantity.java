/*
 * Generic quantity class supporting
 * measurable unit conversions and arithmetic operations.
 */

package com.apps.quantitymeasurement;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    /*
     * Converts quantity to base unit.
     */
    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    /*
     * Converts quantity to target unit.
     */
    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = convertToBaseUnit();

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        double rounded =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Quantity<>(rounded, targetUnit);
    }

    /*
     * Adds two quantities.
     */
    public Quantity<U> add(Quantity<U> other) {

        double result =
                performBaseArithmetic(
                        other,
                        ArithmeticOperation.ADD
                );

        double converted =
                unit.convertFromBaseUnit(result);

        double rounded =
                Math.round(converted * 100.0) / 100.0;

        return new Quantity<>(rounded, unit);
    }

    /*
     * Subtracts two quantities.
     */
    public Quantity<U> subtract(Quantity<U> other) {

        double result =
                performBaseArithmetic(
                        other,
                        ArithmeticOperation.SUBTRACT
                );

        double converted =
                unit.convertFromBaseUnit(result);

        double rounded =
                Math.round(converted * 100.0) / 100.0;

        return new Quantity<>(rounded, unit);
    }

    /*
     * Divides two quantities.
     */
    public double divide(Quantity<U> other) {

        return performBaseArithmetic(
                other,
                ArithmeticOperation.DIVIDE
        );
    }

    /*
     * Performs arithmetic operation
     * using base unit conversion.
     */
    private double performBaseArithmetic(
            Quantity<U> other,
            ArithmeticOperation operation
    ) {

        validateQuantity(other);

        double thisBase =
                this.convertToBaseUnit();

        double otherBase =
                other.convertToBaseUnit();

        return operation.compute(
                thisBase,
                otherBase
        );
    }

    /*
     * Validates compatible quantities.
     */
    private void validateQuantity(Quantity<U> other) {

        if (other == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        if (!this.unit.getClass().equals(other.unit.getClass())) {

            throw new IllegalArgumentException(
                    "Incompatible quantity types"
            );
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Quantity<?> that = (Quantity<?>) o;

        if (!this.unit.getClass().equals(that.unit.getClass())) {
            return false;
        }

        return Double.compare(
                this.convertToBaseUnit(),
                that.convertToBaseUnit()
        ) == 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}