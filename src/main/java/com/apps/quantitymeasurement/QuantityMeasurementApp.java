/*
 * Application entry point for
 * Quantity Measurement Application.
 */

package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.controller.QuantityMeasurementController;
import com.apps.quantitymeasurement.repository.QuantityMeasurementRepository;
import com.apps.quantitymeasurement.service.QuantityMeasurementService;
import com.apps.quantitymeasurement.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        /*
         * Dependency initialization
         */
        QuantityMeasurementRepository repository =
                new QuantityMeasurementRepository();

        QuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(
                        repository
                );

        QuantityMeasurementController controller =
                new QuantityMeasurementController(
                        service
                );

        /*
         * Length Operations
         */
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println(
                "Length Equality : "
                        + controller.compareQuantities(
                        feet,
                        inches
                )
        );

        /*
         * Weight Operations
         */
        Quantity<WeightUnit> kilogram =
                new Quantity<>(5.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println(
                "Weight Subtraction : "
                        + controller.subtractQuantities(
                        kilogram,
                        gram
                )
        );

        /*
         * Volume Operations
         */
        Quantity<VolumeUnit> litre =
                new Quantity<>(10.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(2000.0,
                        VolumeUnit.MILLILITRE);

        System.out.println(
                "Volume Division : "
                        + controller.divideQuantities(
                        litre,
                        millilitre
                )
        );

        /*
         * Temperature Operations
         */
        Quantity<TemperatureUnit> celsius =
                new Quantity<>(0.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(32.0,
                        TemperatureUnit.FAHRENHEIT);

        System.out.println(
                "Temperature Equality : "
                        + controller.compareQuantities(
                        celsius,
                        fahrenheit
                )
        );
    }
}