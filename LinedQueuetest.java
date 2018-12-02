package uno;

import java.util.Scanner;

public class LinedQueuetest {
    public static void main(String[] args) {
        LInedQueue a =new LInedQueue();
        System.out.println("请键入所需要的数字：");
        Scanner scan = new Scanner(System.in);
         String b = scan.nextLine();
         String[] c = b.split(" ");

        for (int i =0;i<c.length;i++){
            a.enqueue(c[i]);
        }
        System.out.println("链表的内容为：");
        System.out.println(a.toString());
        System.out.println("元素的总数为；");
        System.out.println(a.size());



    }
}
