package matrizes;

import input.Input;

public class Matrizes
{
    public static void main(String args[])
    {
        int lines = Input.inputInt("Lines: ");
        int columns = Input.inputInt("Columns: ");

        int[][] matrix = new int[lines][columns];

        System.out.println("Type the matrix");

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = Input.inputIntSemTexto();
            
        int number = Input.inputInt("Type a number of matrix");
        int numberPositionLine = 0;
        int numberPositionColumn = 0;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if(matrix[i][j] == number)
                {
                    numberPositionLine = i;
                    numberPositionColumn = j;
                    verifyPositions(matrix, numberPositionLine, numberPositionColumn);
                }
    }

    public static void verifyPositions(int[][] matrix, int numberPositionLine, int numberPositionColumn)
    {
        System.out.println("Position (" +numberPositionLine+ ","+numberPositionColumn+ ")");
        try
        {
            System.out.println("Left: " +matrix[numberPositionLine][numberPositionColumn - 1]);
        } catch(ArrayIndexOutOfBoundsException e){}
        try
        {
            System.out.println("Right: " +matrix[numberPositionLine][numberPositionColumn + 1]);
        } catch(ArrayIndexOutOfBoundsException e){}
        try
        {
            System.out.println("Up: " +matrix[numberPositionLine - 1][numberPositionColumn]);
        } catch(ArrayIndexOutOfBoundsException e){}
        try
        {
            System.out.println("Down: " +matrix[numberPositionLine + 1][numberPositionColumn]);
        } catch(ArrayIndexOutOfBoundsException e){}
    }
}