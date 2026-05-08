/*
 * Controller layer handling
 * quantity measurement requests.
 */

package com.apps.quantitymeasurement.controller;

import com.apps.quantitymeasurement.IMeasurable;
import com.apps.quantitymeasurement.Quantity;
import com.apps.quantitymeasurement.service.QuantityMeasurementService;

public class QuantityMeasurementController {

    private final QuantityMeasurementService service;

    public QuantityMeasurementController(
            QuantityMeasurementService service
    ) {

        this.service = service;
    }

    public <U extends IMeasurable>
    boolean compareQuantities(
            Quantity<U> q1,
            Quantity<U> q2
    ) {

        return service.compare(q1, q2);
    }

    public <U extends IMeasurable>
    Quantity<U> convertQuantity(
            Quantity<U> quantity,
            U targetUnit
    ) {

        return service.convert(
                quantity,
                targetUnit
        );
    }

    public <U extends IMeasurable>
    Quantity<U> addQuantities(
            Quantity<U> q1,
            Quantity<U> q2
    ) {

        return service.add(q1, q2);
    }

    public <U extends IMeasurable>
    Quantity<U> subtractQuantities(
            Quantity<U> q1,
            Quantity<U> q2
    ) {

        return service.subtract(q1, q2);
    }

    public <U extends IMeasurable>
    double divideQuantities(
            Quantity<U> q1,
            Quantity<U> q2
    ) {

        return service.divide(q1, q2);
    }
}