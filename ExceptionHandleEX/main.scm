;; Main function to test error handling
(define (main)
  (safe-division 10 0) ; Test case: Division by zero
  (safe-division 10 2) ; Test case: Valid division
  (display "Operation completed.\n\n\n\n\n\n\n"))

;; Function that performs division and checks for division by zero
(define (safe-division numerator denominator)
  (if (= denominator 0) ;; check for divide by zero exception
      (display "Error: Division by zero is not allowed.\n")
      (let ((result (/ numerator denominator))) ; Perform division if denominator is valid
        (display (string-append "Result: " (number->string result) "\n")))))

(main)