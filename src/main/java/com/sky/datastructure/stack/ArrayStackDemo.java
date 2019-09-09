package com.sky.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArrayStackDemo {

    public static void main(String[] args) {
        String str = "16+2*4-3+40";
        ArrayStack munberStack = new ArrayStack(10);
        ArrayStack symbolStack = new ArrayStack(10);

        //用来存储多位数
        String douStr = "";
        int len = str.length();
        for(int i = 0; i < len; i++){
            int cur = str.charAt(i);

            if(munberStack.isSymbol(cur)){
                //是一个 +-*/
                if(!symbolStack.isEmpty()){
                    //判断优先级
                    int c1 = symbolStack.peek();
                    int curLevel = priority(cur);
                    int c1Level = priority(c1);

                    //栈的符号优先级大于当前
                    if(c1Level >= curLevel){
                        int out = symbolStack.pop();
                        int n1 = munberStack.pop();
                        int n2 = munberStack.pop();
                       int res =  calculation(n1,n2,out);

                        munberStack.push(res);
                        symbolStack.push(cur);
                    }else{
                        symbolStack.push(cur);
                    }

                }else{
                    //判断是第一个入栈的符号
                    symbolStack.push(cur);
                }

            }else{
                //是一个数字
//                munberStack.push(cur - 48);

                int n1 = cur -48;

                //拼接多位数
                douStr += n1;

                if(i == len - 1){
                    //判断是最后一个数 直接加入
                    munberStack.push(Integer.parseInt(douStr));
                    break;
                }

                //判断下一位是否为数字 为数字就是多位数
                if( !munberStack.isSymbol(str.charAt(i+1))){
                    //前面以及拼接了这里不需要拼接

                }else if(munberStack.isSymbol(str.charAt(i+1))){
                    //当下一个不是数字 结束多位数拼接 存入栈中
                        munberStack.push(Integer.parseInt(douStr));
                        douStr = "";
                }


            }
        }

        // 进行 + - 计算
        int num1 = 0;
        int num2 = 0;
        int symbol = 0;
     //   int sum = 0;

        System.out.println("munberStack = ");
        munberStack.list();
        System.out.println("symbolStack = ");
        symbolStack.list();

        while(true){


            if(symbolStack.isEmpty()) {
                break;
            }
            num1 = munberStack.pop();
            num2 = munberStack.pop();
            symbol = symbolStack.pop();



            int res =  calculation(num1,num2,symbol);
             munberStack.push(res);

        }

        System.out.println("表达式为 = " + str);
        System.out.println("最终的结果为 = " + munberStack.pop());

    }

    private static int calculation(int n1, int n2, int symbol) {
        int res = 0;
        switch (symbol){
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n2 - n1; //注意位置
                break;
            case '*':
                res = n1 * n2;
                break;
            case '/':
                res = n2 / n2; //注意位置
                break;

        }

        return res;
    }

    private static int priority(int cur) {
        if('+' == cur || '-' == cur){
            return 0;
        }else if('*' == cur || '/' == cur){
            return 1;
        }else {
            return -1;
        }
    }


    static class ArrayStack{
        int[] stack;

        int size;

        int top = -1;

        public ArrayStack(int size){
            this.size = size;
            stack = new int[this.size];
        }

        public boolean isFull(){
            return top == this.size - 1;
        }

        public boolean isEmpty(){
            return  -1 == top;
        }

        public void push(int val){
            if(isFull()){
                throw new RuntimeException("栈满了");
            }
            top++;
            stack[top] = val;
        }

        public int peek(){
            return stack[top];
        }

        public int pop(){
            if(isEmpty()){
                throw new RuntimeException("栈空");
            }
            int val = stack[top];
            stack[top--] = 0;
            return val;
        }

        public void list(){
            if(isEmpty()){
                throw new RuntimeException("栈空");
            }
            int i = 0;
           while (true){
               if(i == top+1){
                   break;
               }
               System.out.println("[" + i +"] = " + stack[i]);
               i++;
           }
        }

        public int size(){
            return top+1;
        }

         public boolean isSymbol(int item){
            return '+' == item || '-' == item || '*' == item || '/' == item;
         }
    }


}
