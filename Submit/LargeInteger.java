import java.util.Arrays;

/**
 * 
 * @author YOUR NAME 
 *
 */
import java.io.Serializable;

public class LargeInteger extends HasState implements Relatable, Serializable {
    private int[] num;
    private int digitCount;
    private final int arraySize = 23;

    // No-argument constructor
    public LargeInteger() {
        num = new int[arraySize];
        digitCount = 1;
    }

    // Constructor from string
    public LargeInteger(String number) throws LargeIntegerNumberFormatException {
        if (number == null || number.isEmpty()) {
            throw new LargeIntegerNumberFormatException("String is empty");
        }

        if (number.length() > arraySize) {
            throw new LargeIntegerNumberFormatException("String is too long to be stored as a 23-digit number");
        }

        num = new int[arraySize];
        digitCount = 0;

        for (int i = number.length() - 1; i >= 0; i--) {
            char digitChar = number.charAt(i);
            if (!Character.isDigit(digitChar)) {
                throw new LargeIntegerNumberFormatException("String contains non-digits");
            }

            int digit = Character.getNumericValue(digitChar);
            num[digitCount++] = digit;
        }

        if (digitCount == 0) {
            throw new LargeIntegerNumberFormatException("String contains no digits");
        }
    }

    // Constructor from long
    public LargeInteger(long number) throws LargeIntegerNumberFormatException {
        if (number < 0) {
            throw new LargeIntegerNumberFormatException("Cannot construct LargeInteger from a negative number");
        }

        num = new int[arraySize];
        digitCount = 0;

        while (number > 0 && digitCount < arraySize) {
            num[digitCount++] = (int) (number % 10);
            number /= 10;
        }
    }

    // Accessor method for digit count
    public int getDigitCount() {
        return digitCount;
    }

    // toString method
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = digitCount - 1; i >= 0; i--) {
            result.append(num[i]);
        }
        return result.toString();
    }
// add method
public LargeInteger add(LargeInteger other) throws LargeIntegerOverflowException {
    LargeInteger sum = new LargeInteger();
    int carry = 0;

    for (int i = 0; i < arraySize; i++) {
        int columnSum = num[i] + other.num[i] + carry;
        sum.num[i] = columnSum % 10;
        carry = columnSum / 10;
    }

    if (carry > 0) {
        throw new LargeIntegerOverflowException("Resulting number is more than 23 digits long");
    }

    // Update digitCount based on the actual number of digits in the sum
    for (int i = arraySize - 1; i >= 0; i--) {
        if (sum.num[i] != 0) {
            sum.digitCount = i + 1;
            break;
        }
    }

    return sum;
}

@Override
public LargeInteger clone() {
    try {
        LargeInteger clone = new LargeInteger();

        // Copy the array
        clone.num = Arrays.copyOf(this.num, arraySize);

        // Copy the digitCount
        clone.digitCount = this.digitCount;

        // Copy the state (inherited from HasState)
        clone.changeState(); // Set a new random state for the clone

        return clone;
    } catch (Exception e) {
        // This should not happen since LargeInteger extends HasState
        throw new InternalError(e);
    }
}


@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    LargeInteger other = (LargeInteger) obj;
    return Arrays.equals(num, other.num) && digitCount == other.digitCount;
}

@Override
public boolean isGreater(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    LargeInteger other = (LargeInteger) obj;
    return compareArrays(num, other.num) > 0;
}

@Override
public boolean isLess(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    LargeInteger other = (LargeInteger) obj;
    return compareArrays(num, other.num) < 0;
}

    // Helper method for array comparison
    private int compareArrays(int[] arr1, int[] arr2) {
        for (int i = arraySize - 1; i >= 0; i--) {
            if (arr1[i] > arr2[i]) {
                return 1;
            } else if (arr1[i] < arr2[i]) {
                return -1;
            }
        }
        return 0;
    }
}
