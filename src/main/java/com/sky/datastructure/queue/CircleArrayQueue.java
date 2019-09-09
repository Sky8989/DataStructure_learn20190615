package com.sky.datastructure.queue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 环形 队列
 */
public class CircleArrayQueue {

    /**
     * 队列的最大长度
     */
    int maxSize;

    /**
     * 队列首指针  每次获取数据 front  加一
     * 默认长度 为 0
     */
    int front;

    /**
     * 队列的尾指针  每次添加数据 rear 加一
     * 默认长度 为 0
     */
    int rear;

    /**
     * 使用 数组 存储数据
     */
    int[] arr;

    /**
     * 初始化队列
     */
    public CircleArrayQueue(int length){
        maxSize = length;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否为空
     * 当  front == rear 时队列为空
     */
    boolean isEmpty(){
        if(front == rear){
            //  throw new RuntimeException("队列为空");
            System.out.println("队列为空");
            return true;
        }
        return false;
    }

    /**
     * 判断 队列是否为满
     *   通过 % 取模
     *   条件 (rear + 1) % maxSize = front
     */

    boolean isFull(){
        if( ( (rear + 1) % maxSize == front)){
            System.out.println("队列已满");
            return true;
        }

        return false;
    }

    /**
     * 获取 队列中 元素的数量
     *
     * 条件  (rear + maxSize - front) % maxSize
     */

    int size(){
        return (rear + maxSize - front) % maxSize;
    }

    void add(int val){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }

        arr[rear] = val;
        //循环使用
        rear = (rear + 1) % maxSize;

    }

    /**
     * 获得 队列的元素
     * @return
     */
    int get(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int result = arr[front];

        front = ( front + 1) % maxSize;

        return result;
    }

    /**
     * 显示队列
     */
    void showQueue(){
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 获得 头数据
     * 注意不是取出数据
     * @return
     */
    int getHead(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }


        return arr[front];
    }




    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(3);
        Scanner scanner =  new Scanner(System.in);
        boolean flag = true;

        char key;

        while(flag){
            System.out.println("N 队列是否为空");
            System.out.println("M 队列是否满");
            System.out.println("A 队列添加元素");
            System.out.println("G 队列获取元素");
            System.out.println("H 队列首元素的位置");
            System.out.println("S 显示队列列表");
            System.out.println("L 显示队列的长度");
            System.out.println("E 退出");

            key = scanner.next().charAt(0);

            switch (key){
                case 'N':
                    queue.isEmpty();
                    break;
                case 'M':
                    queue.isFull();
                    break;
                case 'A':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'G':
                    int getVal =  queue.get();
                    System.out.println("获取的元素为 ：" + getVal);
                    break;
                case 'S':
                    queue.showQueue();
                    break;
                case 'L':
                    int size = queue.size();
                    System.out.println("队列的长度为： " + size);
                    break;
                case 'H':
                    int h =  queue.getHead();
                    System.out.println("头指针的位置：" + h);
                    break;
                case 'E':
                    flag = false;
                    break;
            }
        }
    }
    


}
