package com.sky.datastructure.array;

/**
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        //1.初始化二维数组
        int[][] towArr = new int[8][8];
        towArr[1][1] = 1;
        towArr[1][2] = 1;
        towArr[2][3] = 2;

        printArr(towArr);

        //2. 二维数组 转 稀疏数组
        int[][] sparseArr;

            //a 遍历 原始的二维数组， 得到有效数据的个数 sum
            int sum = 0;
            for(int i = 0; i < towArr.length; i++){ 
                for(int j = 0; j < towArr[i].length; j++){
                    if(towArr[i][j] > 0){
                        sum++;
                    }
                }
            }

            //b 根据 sum  就可以创建稀疏数据 sparseArr int[sum+1][3]
                sparseArr = new int[sum+1][3];
                System.out.println("创建稀疏数组");
                printArr(sparseArr);

                //添加 数组的长宽 和 有限个数
                sparseArr[0][0] = towArr.length;
                sparseArr[0][1] = towArr.length;
                sparseArr[0][2] = sum;

            //c 将二维数组的有效数据 数据 存入到 稀疏数组
            int count = 0;
            for(int i = 0; i < towArr.length; i++){
                for(int j = 0; j < towArr[i].length; j++){
                    if(towArr[i][j] > 0){
                        count++;
                      sparseArr[count][0] = i;
                      sparseArr[count][1] = j;
                      sparseArr[count][2] = towArr[i][j];
                    }
                }
            }


            System.out.println("遍历稀疏数组");
            printArr(sparseArr);

        //3. 稀疏数组 转原始  二维数组

            //a. 先读取 稀疏数组的第一行，根据第一行的数组，创建原始的二维数组

            //b. 在读取稀疏数组后 几行的数据，并赋给 原始的二维数组

    }


    public static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }




}
