#include <stdio.h>
#include <stdlib.h>
int rowsCheck(int size, int board[size][size]);
int colsCheck(int size, int board[size][size]);
int diagonalCheck(int size, int board[size][size]);
int backdiagonalCheck(int size, int board[size][size]);


int main(void)
{
    int size;
    printf("Input size : ");
    scanf("%d", &size);
    int (*board)[size] = malloc(sizeof(int[size][size]));
    if (board == NULL) return 1;

    for (int r = 0; r < size; r++)
        for (int c = 0; c < size; c++)
        {
            char ch;
            scanf(" %c", &ch);
            board[r][c] = (ch == 'X') ? 1 : 0;;
        }

    int result = rowsCheck(size, board);
    if (result == -1) result = colsCheck(size, board);
    if (result == -1) result = diagonalCheck(size, board);
    if (result == -1) result = backdiagonalCheck(size, board);

    if (result == 0) printf("O wins\n");
    else if (result == 1) printf("X wins\n");
    else printf("Nobody wins\n");

    free(board);
    return 0;
}



int rowsCheck(int size, int board[size][size])
{
    for(int r = 0; r < size; r++)
    {
        int numOFO =0, numOFX = 0;
        for (int c = 0; c < size; c++)
        {
            if (board[r][c] == 1)
            {
                numOFX++;
            }
            else
            {   
                numOFO++;
            }
        }
        if (numOFO == size) return 0;
        if (numOFX == size) return 1;
    }
    return -1;
}

int colsCheck(int size, int board[size][size])
{
    for(int c = 0; c < size; c++)
    {
        int numOFO = 0, numOFX = 0;
        for (int r = 0; r < size; r++)
        {
            if (board[r][c] == 1)
            {
                numOFX++;
            }
            else
            {
                numOFO++;
            }
        }
        if (numOFO == size) return 0;
        if (numOFX == size) return 1;
    }
    return -1;
}

int diagonalCheck(int size, int board[size][size])
{
    int numOFO = 0, numOFX = 0;
        for (int r = 0; r < size; r++)
        {
            if (board[r][r] == 1)
            {
                numOFX++;
            }
            else
            {
                numOFO++;
            }
        }
        if (numOFO == size) return 0;
        if (numOFX == size) return 1;
        return -1;
}

int backdiagonalCheck(int size, int board[size][size])
{
    int numOFO = 0, numOFX = 0;
    for (int r = 0; r < size; r++)
    {
        if (board[r][size - r - 1] == 1)
        {
            numOFX++;
        }
        else
        {
            numOFO++;
        }
    }
    if (numOFO == size) return 0;
    if (numOFX == size) return 1;
    return -1;
}