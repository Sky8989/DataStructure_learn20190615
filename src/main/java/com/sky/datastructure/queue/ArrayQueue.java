package com.sky.datastructure.queue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 通过 数组实现队列  直线队列  只能使用一次
 */
public class ArrayQueue {
    /**
     * 队列的最大长度
     */
    int maxSize;

    /**
     * 队列首指针  每次获取数据 front  加一
     */
    int front;

    /**
     * 队列的尾指针  每次添加数据 rear 加一
     */
    int rear;

    /**
     * 使用 数组 存储数据
     */
    int[] arr;


    /**
     * 初始化队列
     */
    public ArrayQueue(int length){
        maxSize = length;
        front = -1;
        rear = -1;
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
     * 判断队列是否 满
     *
     *  当 rear == maxSize-1  队列已满
     */
    boolean isFull(){
        if(rear == maxSize - 1){
           // throw new RuntimeException("队列已满");
            System.out.println("队列已满");

            return true;
        }
        return false;
    }

    /**
     *  添加元素 到队列中
     */
    void add(int val){
        if(isFull()){
            return;
        }
        rear++;
        arr[rear] = val;
    }

    /**
     * 获取队列的数据, 出队列
     * @return
     */
    int get(){
        if(isEmpty()){
           throw new RuntimeException("队列为空");
        }

        // 这里需要分析出 front是指向队列的第一个元素
        // 1. 先把 front 对应的值保留到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int result = arr[rear];
        front = (front + 1) % maxSize;
        return result;
    }

    /**
     * 显示 队列
     */
    void showQueue(){
        System.out.println(Arrays.toString(arr));
    }

    /**
     *   显示队列的头数据， 注意不是取出数据
      */
    int getHead(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }

    int size(){
        // rear = 2
        // front = 1
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;
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
