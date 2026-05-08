package com.apps.quantitymeasurement.repository;


import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuantityMeasurementRepository
        extends JpaRepository<
        QuantityMeasurementEntity,
        Long
        > {
}