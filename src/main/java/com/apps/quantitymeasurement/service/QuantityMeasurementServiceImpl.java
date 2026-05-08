/*
 * Service implementation containing
 * quantity business logic.
 */

package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.IMeasurable;
import com.apps.quantitymeasurement.Quantity;
import com.apps.quantitymeasurement.model.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.repository.QuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl
        implements QuantityMeasurementService {

    private final QuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(
            QuantityMeasurementRepository repository
    ) {

        this.repository = repository;
    }

    @Override
    public <U extends IMeasurable>
    boolean compare(
            Quantity<U> q1,
            Quantity<U> q2
    ) {

        boolean result = q1.equals(q2);

        repository.save(
                new QuantityMeasurementEntity(
                        "COMPARE",
                        String.valueOf(result)
                )
        );

        return result;
    }

    @Override
    public <U extends IMeasurable>
    Quantity<U> convert(
            Quantity<U> quantity,
            U targetUnit
    ) {

        Quantity<U> result =
                quantity.convertTo(targetUnit);

        repository.save(
                new QuantityMeasurementEntity(
                        "CONVERT",
                        result.toString()
                )
        );

        return result;
    }

    @Override
    public <U extends IMeasurable>
    Quantity<U> add(
            Quantity<U> q1,
            Quantity<U> q2
    ) {

        Quantity<U> result = q1.add(q2);

        repository.save(
                new QuantityMeasurementEntity(
                        "ADD",
                        result.toString()
                )
        );

        return result;
    }

    @Override
    public <U extends IMeasurable>
    Quantity<U> subtract(
            Quantity<U> q1,
            Quantity<U> q2
    ) {

        Quantity<U> result =
                q1.subtract(q2);

        repository.save(
                new QuantityMeasurementEntity(
                        "SUBTRACT",
                        result.toString()
                )
        );

        return result;
    }

    @Override
    public <U extends IMeasurable>
    double divide(
            Quantity<U> q1,
            Quantity<U> q2
    ) {

        double result = q1.divide(q2);

        repository.save(
                new QuantityMeasurementEntity(
                        "DIVIDE",
                        String.valueOf(result)
                )
        );

        return result;
    }
}