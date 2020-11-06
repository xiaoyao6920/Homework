package others;

import java.util.Scanner;
import java.util.Stack;

//传入一个字符串，解析此字符串数字与运算符做计算
//* 比如: 字符串str="1+2", 可计算出结果=3
public class calcString2 {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        String str= input.next();
        String str = "2+3*（6-2）";
        System.out.println(help(str.intern()));
    }
    public static Integer help(String str){
        Stack<Integer> num = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        char x[] = str.toCharArray();
        for (int i =0;i<x.length;i++){
            if (isNum(x[i])){
                stringBuilder.append(x[i]);
                if (i+1==x.length){
                    num.push(Integer.parseInt(stringBuilder.toString()));
                }
                if (x[i+1]==' '){
                    num.push(Integer.parseInt(stringBuilder.toString()));
                    stringBuilder.delete(0,stringBuilder.length());
                    continue;
                }
            }
            if (x[i]=='+'){
                num.push(num.pop()+num.pop());
            }
            if (x[i]=='-'){
                int a = num.pop();
                int b = num.pop();
                num.push(b-a);
            }
            if (x[i]=='*'){
                num.push(num.pop()*num.pop());
            }
            if (x[i]=='/'){
                int a = num.pop();
                int b = num.pop();
                num.push(b/a);
            }
        }
        return num.pop();
    }
//    中缀波兰表达式
    public static String inorder (String str){
        Stack<Character> stack = new Stack<>();
//        字符串转化为字符型数组
        char x[] = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
//        1.当前字符为数字
//        2.当前字符为运算符
//        3.当前字符为括号
        for (int i = 0;i<x.length;i++){
            if (isNum(x[i])) {
                stringBuilder.append(x[i]);
//                数字多位时
                if (((i<x.length-1&&!isNum(x[i+1]))||i==x.length-1)){
                    stringBuilder.append(" ");
                }
                continue;
            }
            if (x[i]=='*'||x[i]=='('||x[i]=='/'){
                stack.push(x[i]);
                continue;
            }
            if (x[i]==')'){
                while (!stack.isEmpty()){
                    if (stack.peek()=='('){
                        stack.pop();
                        continue;
                    }
                    stringBuilder.append(stack.pop());
                }
                continue;
            }
//            1.当前栈为空，直接将符号入栈
//            2.当前栈不为空，栈顶元素为（，说明±是括号内的运算符，我们也直接入栈，
//            3.当前栈不为空，栈顶元素不是（，说明±可能在括号内，但当前运算顺序的±应该是排在栈顶元素的后面，我们进行出栈后，再将±放入栈内
            if (x[i]=='+'||x[i]=='-'){
                while (!stack.isEmpty()&&stack.peek()!='('){
                    stringBuilder.append(stack.pop());
                }
                stack.push(x[i]);
                continue;
            }
        }
        return stringBuilder.toString();
    }
    public static boolean isNum(char x){
        return x>=48 && x<=57;
    }//利用ascall码判断是否为数字
}
