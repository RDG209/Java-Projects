package main

import (
	"errors"
	"fmt"
)

// Function that performs division and returns an error if needed
func divide(numerator, denominator int) (int, error) {
	// catches divide by 0 error
	if denominator == 0 {
		return 0, errors.New("division by zero is not allowed")
	}
	// if clear then perform the operation and return the result.
	return numerator / denominator, nil
}

func main() {
	var numerator, denominator int
	fmt.Print("Enter numerator: ")
	fmt.Scan(&numerator)
	fmt.Print("Enter denominator: ")
	fmt.Scan(&denominator)

	// Perform division and handle errors
	result, err := divide(numerator, denominator)
	if err != nil { // check for error, print error code
		fmt.Println("Error:", err)
	} else { // if no issue, return the results
		fmt.Println("Result:", result)
	}

	// confirmation that the code is done running
	fmt.Println("Operation completed.")
}
