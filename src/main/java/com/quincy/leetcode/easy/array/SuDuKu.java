package com.quincy.leetcode.easy.array;

import java.util.*;

/**
 * <a href='https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/30/'></a>
 * <p>
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * @author quinc
 * @date 2019/1/3 星期四
 */
public class SuDuKu {

    /**
     * 思路1：3个规则一个个去匹配
     *
     * @param board 矩阵
     * @return 结果
     */
    public static boolean isValidSudoku(char[][] board) {
        // 规则1
        Map<Integer, List<Character>> across = new HashMap<>();
        // 规则2
        Map<Integer, List<Character>> vertical = new HashMap<>();
        // 规则3
        Map<Integer, List<Character>> matrix = new HashMap<>();
        // 初始化
        for (int init = 0; init < 9; init++) {
            across.put(init, new ArrayList<>());
            vertical.put(init, new ArrayList<>());
            matrix.put(init, new ArrayList<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 规则3按照从左到右，上到下依次算map的key
                int matrixIndex = 3 * (i / 3) + j / 3;
                if (board[i][j] != '.') {
                    if (across.get(i).contains(board[i][j])
                            || vertical.get(j).contains(board[i][j])
                            || matrix.get(matrixIndex).contains(board[i][j])) {
                        System.out.println(String.format("false,i=%s,j=%s,value=%s", i, j, board[i][j]));
                        return false;
                    } else {
                        across.get(i).add(board[i][j]);
                        vertical.get(j).add(board[i][j]);
                        matrix.get(matrixIndex).add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                for (int k = 8; k > j; k--) {
                    if (board[i][j] == board[i][k]) {
                        return false;
                    }
                }
                for (int k = 8; k > i; k--) {
                    if (board[i][j] == board[k][j]) {
                        return false;
                    }
                }
                for (int k = i + 1; k % 3 != 0; k++) {
                    for (int h = j / 3 * 3; h < j / 3 * 3 + 3; h++) {
                        if (board[i][j] == board[k][h]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static boolean isValidSudoku3(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i / 3 + b + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean isValidSudoku4(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (
                int i = 0;
                i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});

        isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});


    }
}
