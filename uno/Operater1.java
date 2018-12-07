package uno;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Operater1   {
    //  protected LInedQueue<Card> queue;
    protected int Num;
    protected int times;
    LInedQueue<Card> queue;
    public Operater1(LInedQueue Q) {

        // queue=new LInedQueue<>();
        Num=0;
        times=0;
        queue=Q;

    }

//洗牌
//    public void washcard(){
//        for(int i=0;i<100;i++){
//            Random random=new Random();
//            int a=random.nextInt(109)+1;
//            int b=random.nextInt(109)+1;
//
//            Card k=card[a];
//            card[a]=card[b];
//            card[b]=k;
//
//        }
//        for (int i =0;i<card.length;i++){
//            queue.enqueue(card[i]);
//        }
//
//    }


    //发牌，每个人五张
    public String deal(Card[] a){
        String result="";
        for (int i =0;i<5;i++){
            a[i]= queue.dequeue();
            Num++;
        }
        clear(a);
        for (int i =0;i<Num;i++ ){
            result+=a[i]+"\n";
        }
        return result;
    }
    //加罚1张牌
    public void add_one(Card[] a){
        for (int i =0;i<1;i++){
            a[Num]=queue.dequeue();
            Num++;
        }
    }
    //加罚2张牌
    public void add_two(Card[] a){
        for (int i =0;i<2;i++){
            a[Num]=queue.dequeue();
            Num++;
        }
    }
    //加罚4张牌
    public void add_four(Card[] a){
        for (int i =0;i<4;i++){
            a[Num]=queue.dequeue();
            Num++;
        }
    }
    //转向
    public void changedir(Men[] sum,Men one,Men two){

        System.out.println("我打出的是转向牌了");
        // swap(o,findmen(o,one),findmen(o,two));
        int index1=findmen(sum,one);
        int index2=findmen(sum,two);
        Men temp=sum[index1];
        sum[index1]=sum[index2];
        sum[index2]=temp;
    }
    public int findmen(Object[] sum,Men o){
        int a =0;
        for (int i =0;i<sum.length;i++){
            if (sum[i].equals(o)){
                a=i;
                break;
            }
        }
        return a;
    }
    //跳过牌
    public void skip(){
        System.out.println("我被跳过了");
    }

    //整理
    public void clear(Card[] o){
        selectionSort(o);
    }


    public  void selectionSort(Card[] data)
    {
        int min;
        for (int index = 0; index < Num-1; index++)
        {
            min = index;
            for (int scan = index+1; scan < Num; scan++) {
                if (data[scan].compareTo(data[min])<0) {
                    min = scan;
                }
            }
            swap(data, min, index);
        }
    }
    private static <T extends Comparable<T>>
    void swap(T[] data, int index1, int index2)
    {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }


    //出牌
    public Card outcard(Card[] o,Card a){//o是现在玩家的手牌，a是上家出的牌
        Card result=null;
        if (a==null){
            Random random=new Random();
            int ran=random.nextInt(Num);
            result=o[ran];
            delete(o,result);
        }else {
            if (!a.color.equals("All")) {
                if (a.function.equals("skip")) {
                    if (findfunction(o, "skip")) {
                        result = findfunctioncard(o, "skip");
                        delete(o, result);
                    } else {
                        skip();
                        System.out.println("因为我被跳过了，我的上家出牌为：");
                        System.out.println("需要出牌的颜色为："+a.color);
                        //  result=new Card(a.color,-1,"null");
                    }
                }
                if (a.function.equals("veer")) {

                    if (findcolorjudge(o, a.color)) {
                        System.out.println("因为我的下家出了转换方向牌，所以又到我了");
                        result = findcolorcard(o, a.color);
                        delete(o, result);
                    } else {
//                        System.out.println("因为我的下家出了转换方向牌，所以又到我了");
//                        System.out.println("但是因为我出不去了，我的上家出牌为：");
                        System.out.println("完了，出不去！");
                        System.out.println("需要出牌的颜色为："+a.color);
                        result=new Card(a.color,a.number,"null");

                    }
                }
                if (a.function.equals("+2")) {
                    times++;
                    if (findfunction(o, "+2")) {
                        result = findfunctioncard(o, "+2");
                        delete(o, result);
                    } else {
                        for (int i = 0; i < times; i++) {
                            add_two(o);
                        }
                        System.out.println("因为我被+2了，我的上家出牌为：");
                        //    result=new Card(a.color,-1,"null");
                        System.out.println();
                        System.out.println("需要出牌的颜色为："+a.color);
                        times = 0;
                    }
                }

                if ((findcolorjudge(o, a.color) && a.function.equals("null"))||findcolorjudge(o,"All")) {
                    Card[] temp = findcolor(o, a.color);//可出牌数组
                    Card[] temp1=findcolor(o,"All");
                    Random random = new Random();
                    //    int ran = random.nextInt(findgeshu(temp));
                    int suiji=random.nextInt(2);
                    Card out=null;
                    if (suiji==0&&findcolorjudge(o,"All")){
                        int ran1=random.nextInt(findgeshu(temp1));
                        out = temp1[ran1];
                    }else if (findcolorjudge(o, a.color)){
                        int ran = random.nextInt(findgeshu(temp));
                        out=temp[ran];
                    }
                    result = out;
                    if (result!=null){
                        delete(o, result);}
                } else {
                    if (findnumjudge(o, a.number) && a.function.equals("null")&&a.number!=-1) {
                        Card[] temp = findnum(o, a.number);
                        Random random = new Random();
                        int ran = random.nextInt(findgeshu(temp));
                        Card out = temp[ran];
                        result = out;
                        delete(o, result);
                    }
                }

            } else {
                if (a.function.equals("+4")) {
                    times++;
                    if (findfunction(o, "+4")) {
                        result = findfunctioncard(o, "+4");
                        delete(o, result);
                    } else {
                        for (int i = 0; i < times; i++) {
                            add_four(o);
                        }
                        System.out.println("我被+4了");

                        times = 0;
                    }
                }
                if (a.function.equals("changecolor")) {
                    System.out.println("我打出了一张换颜色的牌");
                }
                if (a.function.equals("all+1")) {
                    //  add_one(o);
                    System.out.println("我打出了全场+1");
                }
                if (a.function.equals("all+2")) {
                    // add_two(o);
                    System.out.println("我打出了全场+2");
                }
            }
        }

        return result;
    }

    public void  delete(Card[] o,Card a)
    {
        for (int i =findcard(o,a);i<Num;i++)
        {
            o[i]=o[i+1];
        }
        o[Num]=null;
        Num--;
    }


    public Card[] findnum(Card[] o,int num){
        Card[] a =new Card[999];
        int temp=0;
        for (int i =0;i<Num;i++){
            if (o[i].number==num){
                a[temp]=o[i];
                temp++;
            }
        }
        return a;
    }
    public boolean findnumjudge(Card[] o,int num){
        boolean result=false;
        for (int i =0;i<Num;i++){
            if (o[i].number==num){
                result=true;
                break;
            }
        }
        return result;
    }
    public Card[] findcolor(Card[] o,String color){
        Card[] a =new Card[999];
        int temp=0;
        for (int i =0;i<Num;i++){
            if (o[i].color.equals(color)){
                a[temp]=o[i];
                temp++;
            }
        }
        return a;
    }

    public Card findcolorcard(Card[] o,String color){
        Card result=null;
        for (int i =0;i<Num;i++){
            if (o[i].color.equals(color)){
                result=o[i];
            }
        }
        return result;
    }
    public boolean findcolorjudge(Card[] o,String color){
        boolean result=false;
        for (int i =0;i<Num;i++){
            if (o[i].color.equals(color)){
                result=true;
                break;
            }
        }
        return result;
    }

    public int findgeshu(Card[] o){
        int a =0;
        while (o[a]!=null){
            a++;
        }
        return a;
    }
    public int findcard(Card[] o,Card a){
        int result=-1;
        for (int i =0;i<Num;i++){
            if (o[i].equals(a)){
                result=i;
                break;
            }
        }
        return result;
    }

    public boolean findfunction(Card[] o,String function){
        boolean result=false;
        for (int i =0;i<Num;i++){
            if (o[i].function.equals(function)){
                result=true;
                break;
            }
        }
        return result;
    }
    public Card findfunctioncard(Card[] o,String function){
        Card result=null;
        for (int i =0;i<Num;i++){
            if (o[i].function.equals(function)){
                result=o[i];
            }
        }
        return result;
    }

    public String pritn(Card[] o){
        String result="";
        for (int i =0;i<Num;i++ ){
            result+=o[i]+"\n";
        }
        return result;
    }

    public String choicecolor(){
        Scanner scan = new Scanner(System.in);
        System.out.println("您想选择什么颜色");
        String result =scan.nextLine();
        return result;
    }
    public static void main(String[] args) {
        Cardteam c = new Cardteam();
        c.card();
        c.washcard();
        Operater1 a =new Operater1(c.queue);
        Operater1 q =new Operater1(c.queue);
        Card[] b=new Card[109];
        Card[] n=new Card[109];
//        a.card();
//        a.washcard();
//        q.card();
//        q.washcard();
//            c.card();
//            c.washcard();


        System.out.println(a.deal(b));
//        Card temp=new Card("Blue",-1,"null");
//        System.out.println(a.outcard(b,temp));
//        System.out.println();
//        System.out.println(a.pritn(b));
//        System.out.println();
      //  System.out.println(.queue.size());
        System.out.println(c.queue.size());
        q.deal(n);
       // q.add_two(n);
        System.out.println(c.queue.size());

    }


}
