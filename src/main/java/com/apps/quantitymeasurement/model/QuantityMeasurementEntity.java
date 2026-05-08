/*
 * Entity class representing
 * stored quantity operations.
 */

package com.apps.quantitymeasurement.model;

public class QuantityMeasurementEntity {

    private String operation;
    private String result;

    public QuantityMeasurementEntity(
            String operation,
            String result
    ) {

        this.operation = operation;
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {

        return "Operation : "
                + operation
                + ", Result : "
                + result;
    }
}