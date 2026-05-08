/*
 * Repository layer for storing
 * quantity operation records.
 */

package com.apps.quantitymeasurement.repository;

import com.apps.quantitymeasurement.model.QuantityMeasurementEntity;

import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementRepository {

    private final List<QuantityMeasurementEntity> records =
            new ArrayList<>();

    public void save(
            QuantityMeasurementEntity entity
    ) {

        records.add(entity);
    }

    public List<QuantityMeasurementEntity> findAll() {
        return records;
    }
}