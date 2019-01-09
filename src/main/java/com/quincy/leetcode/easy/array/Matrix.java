package com.quincy.leetcode.easy.array;

import java.util.StringJoiner;

/**
 * <a herf='https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/31/'></a>
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 *
 * @author quinc
 * @date 2019/1/6 星期日
 */
public class Matrix {


    /**
     * 思路1：设定原元素位置下标为(i,j)，长度为n,经过找规律发现旋转后的下标为:(j,n-1-i),每次替换次数为4
     * 每一行需要进行4次旋转的最大列下标为n-i-1
     *  思路2： 翻转90°就是矩阵先按照x轴对称翻转，然后按照对角线翻转
     *
     * @param matrix n*n矩阵
     */
    public static void rotate(int[][] matrix) {
        print(matrix);
        System.out.println("--------------------");
        int n = matrix.length;
        // i表示遍历的行，j表示列,k表示每一行
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int count = 4;
                int cur = matrix[i][j];
                int nextI = j;
                int nextJ = n - 1 - i;
                while (count > 0) {
                    int temp = matrix[nextI][nextJ];
                    matrix[nextI][nextJ] = cur;
                    cur = temp;
                    int t2 = nextI;
                    nextI = nextJ;
                    nextJ = n - 1 - t2;
                    count--;
                }
//                System.out.println("----");
//                print(matrix);
            }
        }
    }

    private static void print(int[][] matrix) {
        for (int[] crossArray : matrix) {
            StringJoiner sj = new StringJoiner(",", "[", "]");
            for (int v : crossArray) {
                sj.add(Integer.toString(v));
            }
            System.out.println(sj.toString());
        }
    }

    public void rotate2(int[][] matrix) {
        // 翻转 90° = 先关于 X 轴对称翻转 + 再关于对角线翻转
        for (int i = 0; i < matrix.length / 2; i++) {
            swap(matrix, i, matrix.length - i - 1);
        }
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < x; y++) {
                swap(matrix, x, y, y, x);
            }
        }
    }

    private void swap(int[][] matrix, int r1, int r2) {
        int[] temp = matrix[r1];
        matrix[r1] = matrix[r2];
        matrix[r2] = temp;
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }


    public static void main(String[] args) {
        rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}});

        System.out.println("==========================");
        rotate(new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}});


    }

}
