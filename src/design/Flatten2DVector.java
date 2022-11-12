package design;

import java.util.NoSuchElementException;

/**
 * Good Question
 * https://leetcode.com/problems/flatten-2d-vector/
 * Design an iterator to flatten a 2D vector. It should support the next and hasNext operations.
 *
 * Implement the Vector2D class:
 *
 * Vector2D(int[][] vec) initializes the object with the 2D vector vec.
 * next() returns the next element from the 2D vector and moves the pointer one step forward.
 * You may assume that all the calls to next are valid.
 * hasNext() returns true if there are still some elements in the vector, and false otherwise.
 */
public class Flatten2DVector {
    int[][] vector;
    int row;
    int column;
    public Flatten2DVector(int[][] vec) {
        vector = vec;
    }

    public int next() {
        if(!hasNext()) throw  new NoSuchElementException();
        return vector[row][column++];
    }

    public boolean hasNext() {
        advanceToNext();
        return row < vector.length;
    }

    private void advanceToNext(){
        while (row< vector.length && column==vector[row].length){
            row++;
            column=0;
        }
    }
}
