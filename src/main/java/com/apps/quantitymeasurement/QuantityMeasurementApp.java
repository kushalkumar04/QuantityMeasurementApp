package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            // 1. Reference Check
            if (this == obj) return true;

            // 2. Null Check
            if (obj == null) return false;

            // 3. Type Check
            if (this.getClass() != obj.getClass()) return false;

            // 4. Value Comparison
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    public static void main(String[] args) {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        System.out.println("Are 1.0 ft and 1.0 ft equal? " + feet1.equals(feet2));

        Feet feet3 = new Feet(2.0);
        System.out.println("Are 1.0 ft and 2.0 ft equal? " + feet1.equals(feet3));
    }
}