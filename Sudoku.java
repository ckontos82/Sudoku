import java.util.*;
import java.io.*;

public class Sudoku
{
    public int[][] board = new int[9][9];

    public Sudoku(int[][] board)
    {
        this.board = board;
    }

    public Sudoku(Sudoku sudoku)        //Kataskevastis sudoku pou dexetai ws orisma antikeimeno typou sudoku.
    {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                this.board[i][j] = sudoku.board[i][j];
    }
    
    public void print()     //Ektyposi tou sudoku.
    {
        for (int[] i : board)
        {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
        System.out.println();
    }

    //Elegxos an ena stoixeio mporei na mpei sti sygkekrimeni thesi me vasi 
    //tous kanones tou sudoku.
    public boolean isValid(int x, int y, int number) 
    {
        //Elegxoume an ypaxei to stoixeio sti stili
        for (int j = 0; j < board.length; j++)      
        if (board[x][j] == number)
            return false;

        //Elegxoume an yparxei to stoixeio sti grammi.
        for (int i = 0; i < board.length; i++)      
        if (board[i][y] == number) 
            return false;

        //Elegxoume an yparxei to stoixeio sto 3x3 block.
        int xStart = x - x % 3;         
        int yStart = y - y % 3;
        
        for (int r = xStart; r < xStart + 3; r++)
        {
            for (int d = yStart; d < yStart + 3; d++)
                if (board[r][d] == number)
                    return false; 
        }
        return true;
    }

    //Elegxoume an o pinakas exei adeia tetragwna.
    public boolean hasEmpty() 
    {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == 0)
                    return true;
        return false;
    }
}