package com.sky.datastructure.stack;

public class MiGoDemo {
    public static void main(String[] args) {

        miGo();
    }

    private static void miGo() {
        int[][] map = initMap();
        printArr(map);

        setStep(map);

    }

    /**
     *  初始化迷宫  1 代表墙
     *   1	1	1	1	1	1	1
         1	0	0	0	0	0	1
         1	0	0	0	0	0	1
         1	1	1	0	0	0	1
         1	0	0	0	0	0	1
         1	0	0	0	0	0	1
         1	0	0	0	0	0	1
         1	1	1	1	1	1	1
     */
    private static int[][] initMap() {
        int[][] map = new int[8][7];

        /**
         *  1 代表墙  初始化左右的墙
         */
        for(int i = 0;  i < map.length; i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        /**
         * 初始化上下的墙
         */
        for(int i = 0; i <map[0].length; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //突出的墙
        map[3][1] = 1;
        map[3][2] = 1;


        return  map;
    }

    public static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 走 返回是否走成功
     * @param step
     */
    public static boolean setStep(int[][] step) {

        return true;
    }
}
