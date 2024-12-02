% Rule to perform division and check for division by zero
safe_division(Numerator, Denominator) :-
    ( 
        Denominator == 0 ->
        % If the denominator is zero, print an error message
        write('Error: Division by zero is not allowed.'), nl
    ;
        % Otherwise, perform the division and display the result
        Result is Numerator / Denominator,
        write('Result: '), write(Result), nl
    ).

% Main predicate to test error handling
main :-
    % Test case: Division by zero
    safe_division(10, 0),
    % Test case: Valid division
    safe_division(10, 2),
    % Print completion message
    write('Operation completed.'), nl.
