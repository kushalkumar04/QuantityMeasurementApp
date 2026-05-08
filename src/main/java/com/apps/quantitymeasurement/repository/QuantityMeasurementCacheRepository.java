package com.apps.quantitymeasurement.repository;

import com.apps.quantitymeasurement.model.QuantityMeasurementEntity;

import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementCacheRepository
        implements QuantityMeasurementRepository {

    private final List<QuantityMeasurementEntity> records =
            new ArrayList<>();

    @Override
    public void save(
            QuantityMeasurementEntity entity
    ) {

        records.add(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> findAll() {
        return records;
    }
}