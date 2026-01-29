#include <stdio.h>
#include <stdlib.h>
int checkLine(int *board, int start, int stride, int n);
int getWinner(int *board, int size);

int main() {
    int size;
    printf("Input size : ");
    if (scanf("%d", &size) != 1 || size <= 0) {
        printf("Invalid size.\n");
        return 1;
    }

    // 在堆上分配内存
    int *board = (int *)malloc(size * size * sizeof(int));
    if (board == NULL) return 1;

    printf("Enter board (O and X):\n");
    for (int r = 0; r < size; r++) {
        for (int c = 0; c < size; c++) {
            char ch;
            // " %c" 的空格非常重要，用来跳过换行符
            if (scanf(" %c", &ch) == 1) {
                board[r * size + c] = (ch == 'X' || ch == 'x') ? 1 : 0;
            }
        }
    }

    // 获取结果
    int winner = getWinner(board, size);

    if (winner == 0) printf("O wins\n");
    else if (winner == 1) printf("X wins\n");
    else printf("Nobody wins\n");

    // 必须释放内存
    free(board);
    return 0;
}


/**
 * 通用线检查函数：利用内存步长(Stride)抽象
 * start:  起始格子的索引
 * stride: 每次移动几个格子
 * n:      需要检查几个格子（即棋盘大小）
 * 返回值：0 代表 O 赢，1 代表 X 赢，-1 代表无胜者
 */
int checkLine(int *board, int start, int stride, int n) {
    int numOFO = 0, numOFX = 0;
    for (int i = 0; i < n; i++) {
        // 计算当前格子的物理索引：起点 + 偏移量
        int currentIndex = start + (i * stride);
        if (board[currentIndex] == 1) {
            numOFX++;
        } else {
            numOFO++;
        }
    }
    if (numOFO == n) return 0;
    if (numOFX == n) return 1;
    return -1;
}

/**
 * 核心判断函数：将四种检查合并
 */
int getWinner(int *board, int size) {
    int result = -1;

    // 1. 检查所有行：起点是每一行的开头(0, size, 2*size...)，步长为 1
    for (int r = 0; r < size; r++) {
        if ((result = checkLine(board, r * size, 1, size)) != -1) return result;
    }

    // 2. 检查所有列：起点是第一行的每个格子(0, 1, 2...)，步长为 size
    for (int c = 0; c < size; c++) {
        if ((result = checkLine(board, c, size, size)) != -1) return result;
    }

    // 3. 检查主对角线：从左上角(0)开始，每次跳过一行加一列 (size + 1)
    if ((result = checkLine(board, 0, size + 1, size)) != -1) return result;

    // 4. 检查反对角线：从右上角(size-1)开始，每次跳过一行减一列 (size - 1)
    if ((result = checkLine(board, size - 1, size - 1, size)) != -1) return result;

    return -1;
}