import java.io.*;
import java.util.*;

public class Solver
{
    private static final int SIZE = 9;     
    private static final int MAX_NUM = 9;
    public static void main(String[] args)
    {
        try {
            int choice = Integer.parseInt(args[1]);
            if (choice > 4 || choice <1)                    //An to deytero orisma einai > 4 i < 1 to programma termatizei.
                throw new IllegalArgumentException();
           
            File puzzle = new File(args[0]);
            Scanner fScanner = new Scanner(puzzle);         //Diavazoume apo to arxeio to puzzle sudoku.
            int[][] tableau = new int[SIZE][SIZE];
            readFile(fScanner, tableau);
            
            Sudoku mySudoku = new Sudoku(tableau);          //Kataskeyazoume antikeimeno sudoku me orisma ton pinaka tou sudoku.
            
            System.out.println("\nInitial board: \n");      //Ektyposi arxikou pinaka.
            mySudoku.print();
            switch (choice)
            {
                case 1:     //Ylopoiisi me stoiva kai arraylist.
                System.out.println("Soliving sudoku using stack and ArrayList:\n");
                ArrayList<int[][]> list = new ArrayList<int[][]>();
                Structure.list = list;
                Structure.Stack.push(mySudoku.board);           //Anevazoume ton pinaka tou sudoku sti stoiva.
                
                while(!Structure.list.isEmpty())                //Oso i stoiva den einai adeia ekteleitai o algorithmos gia anazitisi lysis.
                {
                    mySudoku.board = Structure.Stack.pop();     //Afairoume ton pinaka pou einai stin koryfi tis stoivas.

                    //Diatrexoume ton pinaka mexri na entopisoume to prwto mideniko stoixeio.
                    for (int i = 0; i < SIZE; i++)
                        for (int j = 0; j < SIZE; j++)
                            if (mySudoku.board[i][j] == 0)
                            {
                                for (int nr = 1; nr <= MAX_NUM; ++nr)      
                                {
                                    //Elegxoume an o arithmos nr mporei na mpei sti thesi tou board[i][j].
                                    if (mySudoku.isValid(i, j, nr))
                                    {
                                        Sudoku nSudoku = new Sudoku(mySudoku);
                                        nSudoku.board[i][j] = nr;
                                        if (!nSudoku.hasEmpty())    //An to sudoku den exei adeies theseis lythike. Ektypwnetai kai termatizoume to programma.
                                        {
                                            nSudoku.print();
                                            System.exit(0);
                                        }
                                        else        //An to sudoku exei adeies theseis den exei lythei. O pinakas mpainei stin koryfi tis stoivas.
                                            Structure.Stack.push(nSudoku.board);    
                                    }
                                }
                                i = SIZE;           //Stamatoume tous vroxous wste na ksekisinei i diadikasia apo tin arxi.
                                j = SIZE;
                            } 
                }
                if (Structure.list.isEmpty())       //An i stoiva adeiasei xwris na vrethei lysi, ektypwnetai minima pou enimerwnei oti to sudoku
                                                    //den exei lysi.
                    System.out.println("Sudoku has no solution.\n");

                break;

                case 2:     //Ylopoiisi me oura kai ArrayList.
                System.out.println("Soliving sudoku using queue and ArrayList:\n");
                ArrayList<int[][]> qList= new ArrayList<int[][]>();
                Structure.list = qList;
                Structure.Queue.enqueue(mySudoku.board);            //Anevazoume ton pinaka tou sudoku stin oura.
                
                while(!Structure.list.isEmpty())                    //Oso i oura den einai adeia ekteleitai o algorithmos gia anazitisi lysis.
                {
                    mySudoku.board = Structure.Queue.dequeue();     //Afairoume ton pinaka pou einai stin arxi tis ouras.

                    //Diatrexoume ton pinaka mexri na entopisoume to prwto mideniko stoixeio.
                    for (int i = 0; i < SIZE; i++)
                        for (int j = 0; j < SIZE; j++)
                            if (mySudoku.board[i][j] == 0)
                            {
                                for (int nr = 1; nr <= MAX_NUM; ++nr)
                                {
                                    //Elegxoume an o arithmos nr mporei na mpei sti thesi tou board[i][j].
                                    if (mySudoku.isValid(i, j, nr)) 
                                    {
                                        Sudoku nSudoku = new Sudoku(mySudoku);
                                        nSudoku.board[i][j] = nr;
                                        if (!nSudoku.hasEmpty())    //An to sudoku den exei adeies theseis to sudoku lythike.
                                                                    // Ektypwnetai kai termatizoume to programma.
                                        {
                                            nSudoku.print();
                                            System.exit(0); 
                                        }
                                        else        //An to sudoku  exei adeies theseis den exei lythei. O pinakas mpainei stin koryfi tis ouras.
                                            Structure.Queue.enqueue(nSudoku.board);
                                    }
                                }
                                i = SIZE;           //Stamatoume tous vroxous wste na ksekisinei i diadikasia apo tin arxi.
                                j = SIZE;
                            } 
                }

                if (Structure.list.isEmpty())       //An i stoiva adeiasei xwris na vrethei lysi, ektypwnetai minima pou enimerwnei oti to sudoku
                                                    //den exei lysi.
                    System.out.println("Sudoku has no solution.\n");

                break;

                case 3:     //Ylopoiisi me stoiva kai tin klasi stack tis Java. Antistoixi me to case 1.
                System.out.println("Soliving sudoku using stack and Java Stack class:\n");
                Stack<int[][]> mystack = new Stack<int[][]>();
                mystack.push(mySudoku.board);           //Anevazoume ton pinaka sti stoiva.
                
                while(!mystack.isEmpty())               //Oso i stoiva den einai adeia ekteleitai o algorithmos
                {
                    mySudoku.board = mystack.pop();     //Afairoume ton pinaka apo tin stoiva

                    //Diatrexoume ton pinaka mexri na entopisoume to prwto mideniko stoixeio.
                    for (int i = 0; i < SIZE; i++)
                        for (int j = 0; j < SIZE; j++)
                        {
                            if (mySudoku.board[i][j] == 0)
                            {
                                for (int nr = 1; nr <= MAX_NUM; ++nr)
                                {
                                    //Elegxoume an o arithmos nr mporei na mpei sti thesi tou board[i][j]
                                    if (mySudoku.isValid(i, j, nr))  
                                    {
                                        Sudoku nSudoku = new Sudoku(mySudoku);
                                        nSudoku.board[i][j] = nr;
                                        if (!nSudoku.hasEmpty())    //An to sudoku den exei adeies theseis, exei lythei. 
                                        {                           //Ektyponoume ton pinaka kai to programma termatizei.
                                            nSudoku.print();
                                            System.exit(0);
                                        }
                                        else                        //An o pinakas exei adeies theseis to sudoku den lythike.
                                                                    //O pinakas anevainei sti stoiva.
                                            mystack.push(nSudoku.board);
                                    }
                                }
                                i = SIZE;       //Stamatoume tous vroxous wste na ksekisinei i diadikasia apo tin arxi.
                                j = SIZE;
                            }
                        } 
                }

                if (mystack.isEmpty())      //An i stoiva adeiasei to sudoku den exei lysi. Ektyponetai antistoixo minima kai to programma termatizei.
                    System.out.println("Sudoku has no solution.\n");

                break;
                
                case 4:     //Ylopoiisi me stoiva kai LinkedList. Antistoixi me to case 2.
                System.out.println("Soliving sudoku using queue and LinkedList:\n");
                LinkedList<int[][]> lQueue = new LinkedList<int[][]>();
                Structure.linkedQueue = lQueue;
                Structure.LinkedQueue.enqueueLinked(mySudoku.board);        //Anevazoume ton pinaka stin oura.
                
                while(!Structure.linkedQueue.isEmpty())             //O algorithmos ekteleitai oso i oura den einai adeia.
                {
                    mySudoku.board = Structure.LinkedQueue.dequeueLinked();        //Afairoume ton pinaka apo tin oura.
                    for (int i = 0; i < SIZE; i++)
                        for (int j = 0; j < SIZE; j++)
                            if (mySudoku.board[i][j] == 0)          //
                            {
                                for (int nr = 1; nr <= MAX_NUM; ++nr)
                                {
                                    //Elegxoume an o arithmos nr mporei na mpei sti thesi tou board[i][j]
                                    if (mySudoku.isValid(i, j, nr)) 
                                    {
                                        Sudoku nSudoku = new Sudoku(mySudoku);
                                        nSudoku.board[i][j] = nr;
                                        if (!nSudoku.hasEmpty())        //An to sudoku den exei adeia thesi, exei lythei.
                                        {                               //Ektyponetai kai to programma termatizei.
                                            nSudoku.print();
                                            System.exit(0); 
                                        }
                                        else        //An to sudoku exei adeia thesi to sudoku den exei lythei.
                                                    //O pinakas anevainei stin oura kai i diadikasia epanalambaneta
                                            Structure.LinkedQueue.enqueueLinked(nSudoku.board);
                                    }
                                }
                                i = SIZE;
                                j = SIZE;
                            } 
                }

                if (Structure.linkedQueue.isEmpty())
                    System.out.println("Sudoku has no solution.\n");

                break;
            }
        } catch (ArrayIndexOutOfBoundsException e)  //Elegxos an dothoun ligotera apo 2 orismata.
        {
            System.err.println("Few arguments.");
        }   
        catch (IOException e)                       //Elegxos an dothei lanthasmeno onoma arxeiou.
        {
            System.err.println("File not found.");
        }
        catch (NumberFormatException e)             //Elegxos an to deytero orisma den einai arithmos.
        {
            System.err.println("Second argument must be an integer between 1 and 4.");
        }
        catch (IllegalArgumentException e)          //Elegxos an to 2o orisma einai <1 i >4.
        {
            System.err.println("Second argument must be an integer between 1 and 4.");
        }
    }    

    private static void readFile(Scanner sc, int[][] data)      //Anagnwsi tou sudoku apo arxeio kai anathesi tou se enan pinaka int[][].
    {
        while (sc.hasNextLine())
        {
            for (int i = 0; i < data.length; i++)
            {
                String[] line = sc.nextLine().split(" ");
                for(int j = 0; j < line.length; j++)
                    data[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}