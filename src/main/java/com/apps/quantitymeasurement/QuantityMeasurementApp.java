/**
 * QuantityMeasurementApp - UC2: Feet and Inches measurement equality
 *
 * This class is responsible for checking the equality of two numerical values
 * measured in feet and inches in the Quantity Measurement Application.
 */

package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Inner class to represent Feet measurement
    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Inner class to represent Inches measurement
    public static class Inches {

        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;
            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Static method to demonstrate Feet equality check
    public static void demonstrateFeetEquality() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        System.out.println("Are 1.0 ft and 1.0 ft equal? " + feet1.equals(feet2));

        Feet feet3 = new Feet(2.0);
        System.out.println("Are 1.0 ft and 2.0 ft equal? " + feet1.equals(feet3));
    }

    // Static method to demonstrate Inches equality check
    public static void demonstrateInchesEquality() {
        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(1.0);
        System.out.println("Are 1.0 inch and 1.0 inch equal? " + inch1.equals(inch2));

        Inches inch3 = new Inches(2.0);
        System.out.println("Are 1.0 inch and 2.0 inch equal? " + inch1.equals(inch3));
    }

    // Main method
    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}