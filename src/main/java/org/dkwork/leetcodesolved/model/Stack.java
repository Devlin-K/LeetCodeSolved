package org.dkwork.leetcodesolved.model;

/**
 * @author jin
 * @date 2020/12/7
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProject LeetCodeSolved
 * @BelongPackage org.dkwork.leetcodesolved.model
 * @Describe:
 */
public class Stack<T> {
    private T data[];
    private int maxSize;
    private int topNum;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.data = (T[]) new Object[maxSize];
        this.topNum = -1;
    }

    public boolean isNull() {
        return this.topNum <= -1;
    }

    public boolean isFull() {
        return this.topNum == this.maxSize - 1;
    }

    public boolean push(T vaule) {
        if (isFull()) {
            //栈满
            return false;

        } else {
            data[++topNum] = vaule;//栈顶指针加1并赋值
            return true;

        }
    }

    public T pop() {
        if (isNull()) {
            //栈为空
            return null;
        } else {
            T value = data[topNum];//取出栈顶元素
            --topNum;//栈顶指针-1
            return value;
        }
    }
}


