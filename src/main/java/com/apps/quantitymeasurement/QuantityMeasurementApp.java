/*
 * QuantityMeasurementApp
 *
 * Demonstrates:
 * - Equality comparison
 * - Unit conversion
 * - Addition
 * - Subtraction
 * - Division
 * across Length, Weight, and Volume categories.
 */

package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        /*
         * =========================
         * LENGTH OPERATIONS
         * =========================
         */

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> yards =
                new Quantity<>(1.0, LengthUnit.YARDS);

        System.out.println("=== LENGTH OPERATIONS ===");

        // Equality
        System.out.println(
                "1 FEET equals 12 INCHES : "
                        + feet.equals(inches)
        );

        // Conversion
        System.out.println(
                "1 YARD to FEET : "
                        + yards.convertTo(LengthUnit.FEET)
        );

        // Addition
        System.out.println(
                "1 FEET + 12 INCHES : "
                        + feet.add(inches)
        );

        /*
         * =========================
         * WEIGHT OPERATIONS
         * =========================
         */

        Quantity<WeightUnit> kilogram =
                new Quantity<>(5.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("\n=== WEIGHT OPERATIONS ===");

        // Equality
        System.out.println(
                "1 KILOGRAM equals 1000 GRAM : "
                        + new Quantity<>(1.0, WeightUnit.KILOGRAM)
                        .equals(new Quantity<>(1000.0, WeightUnit.GRAM))
        );

        // Conversion
        System.out.println(
                "5 KILOGRAM to GRAM : "
                        + kilogram.convertTo(WeightUnit.GRAM)
        );

        // Subtraction
        System.out.println(
                "5 KILOGRAM - 1000 GRAM : "
                        + kilogram.subtract(gram)
        );

        /*
         * =========================
         * VOLUME OPERATIONS
         * =========================
         */

        Quantity<VolumeUnit> litre =
                new Quantity<>(10.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(2000.0, VolumeUnit.MILLILITRE);

        System.out.println("\n=== VOLUME OPERATIONS ===");

        // Equality
        System.out.println(
                "1 LITRE equals 1000 MILLILITRE : "
                        + new Quantity<>(1.0, VolumeUnit.LITRE)
                        .equals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE))
        );

        // Conversion
        System.out.println(
                "1 GALLON to LITRE : "
                        + new Quantity<>(1.0, VolumeUnit.GALLON)
                        .convertTo(VolumeUnit.LITRE)
        );

        // Division
        System.out.println(
                "10 LITRE / 2000 MILLILITRE : "
                        + litre.divide(millilitre)
        );

        /*
         * =========================
         * CROSS CATEGORY CHECK
         * =========================
         */

        System.out.println("\n=== CROSS CATEGORY CHECK ===");

        System.out.println(
                "1 FEET equals 1 KILOGRAM : "
                        + feet.equals(
                        new Quantity<>(1.0, WeightUnit.KILOGRAM)
                )


        );

        /*
         * =========================
         * TEMPERATURE OPERATIONS
         * =========================
         */

        System.out.println("\n=== TEMPERATURE OPERATIONS ===");

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(273.15, TemperatureUnit.KELVIN);

// Equality
        System.out.println(
                "0 CELSIUS equals 32 FAHRENHEIT : "
                        + celsius.equals(fahrenheit)
        );

// Conversion
        System.out.println(
                "0 CELSIUS to KELVIN : "
                        + celsius.convertTo(TemperatureUnit.KELVIN)
        );

// Unsupported arithmetic
        try {

            System.out.println(
                    celsius.add(fahrenheit)
            );

        } catch (UnsupportedOperationException e) {

            System.out.println(
                    "Error : " + e.getMessage()
            );
        }
    }
}