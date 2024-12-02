try:
  # Prompt the user for the numerator and convert to integer
  numerator = int(input("Enter numerator: "))  # May raise ValueError

  # Prompt the user for the denominator and convert to integer
  denominator = int(input("Enter denominator: "))  # May raise ValueError

  # Perform division and print the result
  result = numerator / denominator  # May raise ZeroDivisionError
  print("Result:", result)

except ZeroDivisionError:
  # Handle division by zero error
  print("Error: Division by zero is not allowed.")

except ValueError:
  # Handle invalid input (non-integer values)
  print("Error: Invalid input. Please enter a valid integer.")

finally:
  # Always execute this block to indicate operation completion
  print("Operation completed.")
