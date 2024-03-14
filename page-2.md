# Page 2

```java
// Extend the sudo code with a class that represents a Simple Calculator

class SimpleCalculator {
    // Method to add two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to subtract two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method to multiply two numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method to divide two numbers
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / (double) b;
    }

    // Method to check if the first number is greater than the second
    public boolean isGreater(int a, int b) {
        return a > b;
    }
}

// Demonstrate using the SimpleCalculator in the main method
public static void main(String[] args) {
    SimpleCalculator calculator = new SimpleCalculator();

    int sum = calculator.add(10, 5);
    System.out.println("10 + 5 = " + sum);

    int diff = calculator.subtract(10, 5);
    System.out.println("10 - 5 = " + diff);

    int product = calculator.multiply(10, 5);
    System.out.println("10 * 5 = " + product);

    double quotient = calculator.divide(10, 5);
    System.out.println("10 / 5 = " + quotient);

    boolean isGreaterResult = calculator.isGreater(10, 5);
    System.out.println("Is 10 greater than 5? " + isGreaterResult);
}
```
