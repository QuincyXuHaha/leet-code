package com.quincy.leetcode.easy;

/**
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * <p>
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * <p>
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 * <p>
 * circularQueue.enQueue(1);  // 返回 true
 * <p>
 * circularQueue.enQueue(2);  // 返回 true
 * <p>
 * circularQueue.enQueue(3);  // 返回 true
 * <p>
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * <p>
 * circularQueue.Rear();  // 返回 3
 * <p>
 * circularQueue.isFull();  // 返回 true
 * <p>
 * circularQueue.deQueue();  // 返回 true
 * <p>
 * circularQueue.enQueue(4);  // 返回 true
 * <p>
 * circularQueue.Rear();  // 返回 4
 *
 * @author quinc
 * @date 2019/3/13 星期三
 */
public class MyCircularQueue {
    /**
     * 内容
     */
    private int[] elements;

    /**
     * 头指针
     */
    private int head = -1;
    /**
     * 尾指针
     */
    private int tail = -1;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        elements = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head++;
        }
        // 往下移动一个位置给元素插入
        tail = (tail + 1) % elements.length;
        elements[tail] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        //先删除当前头指针元素
        elements[head] = 0;
        if (head == tail) {
            // 删除了最后一个元素，此时应该为空
            tail = head = -1;
            return true;
        }
        head = (head + 1) % elements.length;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elements[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return head == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (tail + 1) % elements.length == head;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1));// 返回 true

        System.out.println(circularQueue.enQueue(2));  // 返回 true

        System.out.println(circularQueue.enQueue(3));  // 返回 true

        System.out.println(circularQueue.enQueue(4));  // 返回 false，队列已满

        System.out.println(circularQueue.Rear());  // 返回 3

        System.out.println(circularQueue.isFull());  // 返回 true

        System.out.println(circularQueue.deQueue());  // 返回 true

        System.out.println(circularQueue.enQueue(4));  // 返回 true

        System.out.println(circularQueue.Rear());  // 返回 4

    }


}
