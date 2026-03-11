package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        assertTrue(feet1.equals(feet2), "1.0 ft should be equal to 1.0 ft");
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);
        assertFalse(feet1.equals(feet2), "1.0 ft should not be equal to 2.0 ft");
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet feet1 = new Feet(1.0);
        assertFalse(feet1.equals(null), "A Feet object should not be equal to null");
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet feet1 = new Feet(1.0);
        assertFalse(feet1.equals("one foot"), "A Feet object should not be equal to a String");
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet feet1 = new Feet(1.0);
        assertTrue(feet1.equals(feet1), "A Feet object should be equal to itself");
    }
}
```

        ---

        ## STEP 8: Run the Tests

        1. Right-click on `QuantityMeasurementAppTest.java` in the left panel
        2. Click **Run 'QuantityMeasurementAppTest'**
        3. A panel opens at the bottom — you should see **5 green ticks ✅** like this:
        ```
        ✅ testFeetEquality_SameValue
        ✅ testFeetEquality_DifferentValue
        ✅ testFeetEquality_NullComparison
        ✅ testFeetEquality_DifferentClass
        ✅ testFeetEquality_SameReference