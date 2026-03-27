package com.apps.quantitymeasurement;

public class Quantity {
    /*
     * UC13: Arithmetic Operations Enum
     */
    private enum ArithmeticOperation {
        ADD {
            public double apply(double a, double b) {
                return a + b;
            }
        },
        SUBTRACT {
            public double apply(double a, double b) {
                return a - b;
            }
        },
        DIVIDE {
            public double apply(double a, double b) {
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            }
        };

        public abstract double apply(double a, double b);
    }
}
