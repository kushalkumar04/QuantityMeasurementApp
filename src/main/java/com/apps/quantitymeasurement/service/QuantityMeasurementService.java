/*
 * Service interface for quantity operations.
 */

package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.IMeasurable;
import com.apps.quantitymeasurement.Quantity;

public interface QuantityMeasurementService {

    <U extends IMeasurable>
    boolean compare(
            Quantity<U> q1,
            Quantity<U> q2
    );

    <U extends IMeasurable>
    Quantity<U> convert(
            Quantity<U> quantity,
            U targetUnit
    );

    <U extends IMeasurable>
    Quantity<U> add(
            Quantity<U> q1,
            Quantity<U> q2
    );

    <U extends IMeasurable>
    Quantity<U> subtract(
            Quantity<U> q1,
            Quantity<U> q2
    );

    <U extends IMeasurable>
    double divide(
            Quantity<U> q1,
            Quantity<U> q2
    );
}