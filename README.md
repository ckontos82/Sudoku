# Sudoku
A sudoku solver, written in Java.

This program is a sudoku solver, in Java, in command line, using stack stracture or queue stracture.

Compile: javac Solver.java

Usage: java Solver file switch
  
where "<file>" is the name of the file containing the puzzle, and switch is a number 1 - 4, depending on what data structure we want to use
  
  1: Using stack and ArrayList
  
  2: Queue and ArrayList
  
  3: Stack and Java stack class
  
  4: Queue and Java LinkedList class
  
  
So, for example, if you type
  
  java Solver puzzle.txt 2
  
it means that you want to solve the Sudoku puzzle provided in file puzzle.txt using queue and ArrayList.
  
For the puzzles, their values must be separeted with a single space. For the empty cells you must provide 0. File puzzle.txt is an example of a valid Sudoku puzzle.  
