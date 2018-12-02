package uno;

import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws InterruptedException {
        Cardteam team = new Cardteam();
        team.card();
        team.washcard();
        Card[] r1=new Card[109];
        Card[] r2=new Card[109];
        Card[] r3=new Card[109];
//        Operater o=new Operater();
//        o.card();
//        o.washcard();
        Operater o1=new Operater(team.queue);
//        o1.card();
//        o1.washcard();
        Operater o2=new Operater(team.queue);
//        o2.card();
//        o2.washcard();
        Operater o3=new Operater(team.queue);
//        o3.card();
//        o3.washcard();
        Men n1=new Men("Jack",r1,o1.Num);
        Men n2=new Men("Mary",r2,o2.Num);
        Men n3=new Men("David",r3,o3.Num);
        o1.deal(r1);
        o2.deal(r2);
        o3.deal(r3);
        Men[] sum = new Men[3];
        sum[0]=n1;
        sum[1]=n2;//玩家
        sum[2]=n3;

       // Card temp1=new Card("null",-1,"null");
        Card temp1=null;//上家出的牌
            int i=0;
            int time1=0;//+2的累加次数
            int time2=0;//+4的累加次数
            String[] color=new String[]{"Red","Green","Yellow","Blue"};
        while (true){
            switch (sum[i].name){

                case ("Jack"):{
                    System.out.println("我是"+n1.name);
                    System.out.println("我现在的剩余牌数为"+o1.Num);
                    Card temp2=temp1;//记录上家出的牌，防止出现该家出不去牌，把出牌变为null;
                    temp1=o1.outcard(n1.card,temp1);
                  //  temp1=new Card("Yellow",-1,"skip");
                    System.out.println("我出的牌是"+temp1);
//                    if (temp1.function.equals("+2")&&temp1!=null){
//                        time1++;
//                    }
//                    if (temp1.function.equals("+4")&&temp1!=null){
//                        time2++;
//                    }
                    if (temp1==null){
                        o1.add_two(n1.card);
                        System.out.println("出不去牌啦！");
                        temp1=temp2;
                        System.out.println("我上家出的牌的颜色为："+temp1.color);
                        if (temp1.number!=-1){
                            System.out.println("我上家出牌的");
                        }
                        temp1=new Card(temp1.color,temp1.number,"null");
                        System.out.println();
                        break;
                    }
                    else if(temp1.color.equals("All")){     //黑牌改变颜色
                        if (temp1.function.equals("all+1")){
                            o2.add_one(r2);
                            o3.add_one(r3);
                        }
                        if (temp1.function.equals("all+2")){
                            o2.add_two(r2);
                            o3.add_two(r3);
                        }
                        Random r = new Random();
                        String color1= color[r.nextInt(3)];
                        System.out.println("我决定下家的出牌颜色为："+color1);
                        //问题：假如有功能是+4，此时的temp1会将+4替换为null，轮加问题，玩家出+4,All怎么没有判断
                        temp1=new Card(color1,-1,"null");}

                    if (temp1.function.equals("veer")){
                        o1.changedir(sum,n2,n3);
                    }
                    System.out.println();
                    break;
                }


                case ("Mary"):{

                    System.out.println("我是"+n2.name);
                    System.out.println("牌为：");
                    System.out.println(o2.pritn(r2));
                    if (temp1.function.equals("+2")){
                        o2.add_two(r2);
                        System.out.println("+2以后的手牌为：");
                        System.out.println(o2.pritn(r2));
                    }
                    if (temp1.function.equals("+4")){
                        o2.add_four(r2);
                        System.out.println("被+4了");
                        System.out.println();
                        break;
                    }
                    if (temp1.function.equals("skip")){
                        if (!o2.findfunction(r2,"skip")){
                            System.out.println("我被跳过了");
                            System.out.println("上家出的牌为："+temp1);
                            System.out.println("下家需要出牌的颜色为"+temp1.color);
                            temp1=new Card(temp1.color,-1,"null");
                            System.out.println();
                            break;
                        }

                    }
                    System.out.println("请问你想出第几张牌");
                    Scanner scanner = new Scanner(System.in);
                    int number = scanner.nextInt();
                    if (number==-1){
                        System.out.println("出不去牌啦！");
                        o2.add_two(n2.card);
                        System.out.println();
                        }
                        else {
                        temp1 = n2.card[number];
                        System.out.println("出的牌为" + temp1);
                        o2.delete(n2.card, temp1);
                        if (temp1.color.equals("All")){
                            if (temp1.function.equals("all+1")){
                                o1.add_one(r1);
                                o3.add_one(r3);
                            }
                            if (temp1.function.equals("all+2")){
                                o1.add_two(r1);
                                o3.add_two(r3);
                            }
                            Scanner a = new Scanner(System.in);
                            System.out.println("请输入你想要让下家出的颜色");
                            String sentence = a.nextLine();
                            temp1=new Card(sentence,-1,"null");
                        }
                        if (temp1.function.equals("veer")){
                            o2.changedir(sum,n1,n3);
                        }
                        System.out.println();
                    }
                    break;
                }

                case ("David"):{
                    System.out.println("我是"+n3.name);
                    System.out.println("我现在的剩余牌数为"+o3.Num);
                    Card temp2 = temp1;
                    temp1=o3.outcard(n3.card,temp1);
                    System.out.println("我出的牌是"+temp1);

                    if (temp1==null){
                        o3.add_two(n3.card);
                        System.out.println("出不去牌啦！");
                        temp1=temp2;
                        System.out.println("我上家出的牌为："+temp1);
                        temp1=new Card(temp1.color,temp1.number,"null");
                        System.out.println();
                        break;
                    }
                    else if(temp1.color.equals("All")){
                        if (temp1.function.equals("all+1")){
                            o1.add_one(r1);
                            o2.add_one(r2);
                        }
                        if (temp1.function.equals("all+2")){
                            o1.add_two(r1);
                            o2.add_two(r2);
                        }
                        Random r = new Random();
                        String color1= color[r.nextInt(3)];
                        System.out.println("我决定下家的出牌颜色为："+color1);
                        temp1=new Card(color1,-1,"null");}

                    if (temp1.function.equals("veer")){
                        o3.changedir(sum,n1,n2);
                    }
                    System.out.println();
                    break;
                }

            }

            if (o1.Num==0){
                System.out.println("第一是："+n1.name);
                break;
            }
            else {
                if (o2.Num==0){
                    System.out.println("第一是："+n2.name);
                    break;
                }
                else if (o3.Num==0){
                    System.out.println("第一是："+n3.name);
                    break;
                }
            }
            if (team.queue.size()==0){
                System.out.println("平局");
                break;
            }

            i++;
          if (i==3){
                i=0;
          }

            Thread.sleep(3000);
        }

    }


}
