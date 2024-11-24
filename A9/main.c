#include <stdio.h>

int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void scopingExample() {
    int localVariable = 10;
    printf("Local Variable: %d\n", localVariable);
}

int globalVariable = 5;

int main() {
    int number = 5;
    printf("Factorial of %d is %d\n", number, factorial(number));

    int x = 10, y = 20;
    printf("Before Swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After Swap: x = %d, y = %d\n", x, y);

    printf("Global Variable: %d\n", globalVariable);
    scopingExample();

    return 0;
}
