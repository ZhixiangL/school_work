#!/bin/sh

## It's possible that for some system reason, this shell script doesn't work.
## In this case, please run the commands manually.
make
echo "\n>>>>>>>>>>Valid tests start<<<<<<<<<<"
java Compiler tests/valid_guideline.ul 
java Compiler tests/valid_func_decl.ul 
java Compiler tests/valid_expression.ul 
java Compiler tests/valid_statement.ul 

echo "\n>>>>>>>>>>Semantic error tests start<<<<<<<<<<"
java Compiler tests/semantic_array1.ul
java Compiler tests/semantic_array2.ul
java Compiler tests/semantic_array3.ul
java Compiler tests/semantic_assign1.ul
java Compiler tests/semantic_assign2.ul
java Compiler tests/semantic_decl1.ul
java Compiler tests/semantic_decl2.ul
java Compiler tests/semantic_decl3.ul
java Compiler tests/semantic_expr1.ul
java Compiler tests/semantic_expr2.ul
java Compiler tests/semantic_expr3.ul
java Compiler tests/semantic_func_call1.ul
java Compiler tests/semantic_func_call2.ul
java Compiler tests/semantic_func_call3.ul
java Compiler tests/semantic_func.ul
java Compiler tests/semantic_id.ul
java Compiler tests/semantic_if_expr.ul
java Compiler tests/semantic_main1.ul
java Compiler tests/semantic_main2.ul
java Compiler tests/semantic_main3.ul
java Compiler tests/semantic_print1.ul
java Compiler tests/semantic_print2.ul
java Compiler tests/semantic_return1.ul
java Compiler tests/semantic_return2.ul
java Compiler tests/semantic_return3.ul


make clean
