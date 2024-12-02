#include <stdio.h>

int main() {
    int numerator, denominator;

    // Prompt user to enter numerator and validate input
    printf("Enter numerator: ");
    if (scanf("%d", &numerator) != 1) {  // If invalid input, give error and exit
        printf("Error: Invalid input. Please enter an integer.\n");
        return 1;
    }

    // Prompt user to enter denominator and validate input
    printf("Enter denominator: ");
    if (scanf("%d", &denominator) != 1) {  // If invalid input, give error and exit
        printf("Error: Invalid input. Please enter an integer.\n");
        return 1;
    }

    if (denominator == 0) {
        // Catches divide by zero error
        printf("Error: Division by zero is not allowed.\n");
    } else {
        // If no issue, return the result
        printf("Result: %d\n", numerator / denominator);
    }

    // Print completion message
    printf("Operation completed.\n");

    return 0;  // Exit program successfully
}
