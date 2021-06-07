#!/bin/sh

## It's possible that for some system reason, this shell script doesn't work.
## In this case, please run the commands manually.
make
echo "\n>>>>>>>>>>Valid tests and diff start<<<<<<<<<<"
java Compiler tests/valid_guideline.ul | diff - tests/valid_guideline.ul
java Compiler tests/valid_func_decl.ul | diff - tests/valid_func_decl.ul
java Compiler tests/valid_expression.ul | diff - tests/valid_expression.ul
java Compiler tests/valid_statement.ul | diff - tests/valid_statement.ul
java Compiler tests/accept_array_outofbound.ul | diff - tests/accept_array_outofbound.ul
java Compiler tests/accept_expression.ul | diff - tests/accept_expression.ul
java Compiler tests/accept_function_parameter.ul | diff - tests/accept_function_parameter.ul
java Compiler tests/accept_variable.ul | diff - tests/accept_variable.ul
java Compiler tests/accept_incorrect_functioncall.ul | diff - tests/accept_incorrect_functioncall.ul
echo "\n>>>>>>>>>>Invalid tests start<<<<<<<<<<"
index=1
while [ $index -lt 15 ]
do
    java Compiler tests/invalid$index.ul
    index=$(( $index + 1 ))
done

make clean
