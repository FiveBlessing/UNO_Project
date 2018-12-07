package uno;

import java.util.Random;

public class Cardteam {
    protected Card[] card;
    protected LInedQueue<Card> queue;
    public Cardteam(){
        card=new Card[110];
        queue=new LInedQueue<>();
    }

    public void  card(){
        card[0]=new Card("Red",0,"null");
        card[1]=new Card("Red",1,"null");
        card[2]=new Card("Red",1,"null");
        card[3]=new Card("Red",2,"null");
        card[4]=new Card("Red",2,"null");
        card[5]=new Card("Red",3,"null");
        card[6]=new Card("Red",3,"null");
        card[7]=new Card("Red",4,"null");
        card[8]=new Card("Red",4,"null");
        card[9]=new Card("Red",5,"null");
        card[10]=new Card("Red",5,"null");
        card[11]=new Card("Red",6,"null");
        card[12]=new Card("Red",6,"null");
        card[13]=new Card("Red",7,"null");
        card[14]=new Card("Red",7,"null");
        card[15]=new Card("Red",8,"null");
        card[16]=new Card("Red",8,"null");
        card[17]=new Card("Red",9,"null");
        card[18]=new Card("Red",9,"null");
        card[19]=new Card("Red",-1,"skip");
        card[20]=new Card("Red",-1,"skip");
        card[21]=new Card("Red",-1,"veer");
        card[22]=new Card("Red",-1,"veer");
        card[23]=new Card("Red",-1,"+2");
        card[24]=new Card("Red",-1,"+2");

        card[25]=new Card("Yellow",0,"null");
        card[26]=new Card("Yellow",1,"null");
        card[27]=new Card("Yellow",1,"null");
        card[28]=new Card("Yellow",2,"null");
        card[29]=new Card("Yellow",2,"null");
        card[30]=new Card("Yellow",3,"null");
        card[31]=new Card("Yellow",3,"null");
        card[32]=new Card("Yellow",4,"null");
        card[33]=new Card("Yellow",4,"null");
        card[34]=new Card("Yellow",5,"null");
        card[35]=new Card("Yellow",5,"null");
        card[36]=new Card("Yellow",6,"null");
        card[37]=new Card("Yellow",6,"null");
        card[38]=new Card("Yellow",7,"null");
        card[39]=new Card("Yellow",7,"null");
        card[40]=new Card("Yellow",8,"null");
        card[41]=new Card("Yellow",8,"null");
        card[42]=new Card("Yellow",9,"null");
        card[43]=new Card("Yellow",9,"null");
        card[44]=new Card("Yellow",-1,"skip");
        card[45]=new Card("Yellow",-1,"skip");
        card[46]=new Card("Yellow",-1,"veer");
        card[47]=new Card("Yellow",-1,"veer");
        card[48]=new Card("Yellow",-1,"+2");
        card[49]=new Card("Yellow",-1,"+2");

        card[50]=new Card("Blue",0,"null");
        card[51]=new Card("Blue",1,"null");
        card[52]=new Card("Blue",1,"null");
        card[53]=new Card("Blue",2,"null");
        card[54]=new Card("Blue",2,"null");
        card[55]=new Card("Blue",3,"null");
        card[56]=new Card("Blue",3,"null");
        card[57]=new Card("Blue",4,"null");
        card[58]=new Card("Blue",4,"null");
        card[59]=new Card("Blue",5,"null");
        card[60]=new Card("Blue",5,"null");
        card[61]=new Card("Blue",6,"null");
        card[62]=new Card("Blue",6,"null");
        card[63]=new Card("Blue",7,"null");
        card[64]=new Card("Blue",7,"null");
        card[65]=new Card("Blue",8,"null");
        card[66]=new Card("Blue",8,"null");
        card[67]=new Card("Blue",9,"null");
        card[68]=new Card("Blue",9,"null");
        card[69]=new Card("Blue",-1,"skip");
        card[70]=new Card("Blue",-1,"skip");
        card[71]=new Card("Blue",-1,"veer");
        card[72]=new Card("Blue",-1,"veer");
        card[73]=new Card("Blue",-1,"+2");
        card[74]=new Card("Blue",-1,"+2");

        card[75]=new Card("Green",0,"null");
        card[76]=new Card("Green",1,"null");
        card[77]=new Card("Green",1,"null");
        card[78]=new Card("Green",2,"null");
        card[79]=new Card("Green",2,"null");
        card[80]=new Card("Green",3,"null");
        card[81]=new Card("Green",3,"null");
        card[82]=new Card("Green",4,"null");
        card[83]=new Card("Green",4,"null");
        card[84]=new Card("Green",5,"null");
        card[85]=new Card("Green",5,"null");
        card[86]=new Card("Green",6,"null");
        card[87]=new Card("Green",6,"null");
        card[88]=new Card("Green",7,"null");
        card[89]=new Card("Green",7,"null");
        card[90]=new Card("Green",8,"null");
        card[91]=new Card("Green",8,"null");
        card[92]=new Card("Green",9,"null");
        card[93]=new Card("Green",9,"null");
        card[94]=new Card("Green",-1,"skip");
        card[95]=new Card("Green",-1,"skip");
        card[96]=new Card("Green",-1,"veer");
        card[97]=new Card("Green",-1,"veer");
        card[98]=new Card("Green",-1,"+2");
        card[99]=new Card("Green",-1,"+2");

        card[100]=new Card("ALl",-1,"+4");
        card[101]=new Card("All",-1,"+4");
        card[102]=new Card("All",-1,"+4");
        card[103]=new Card("All",-1,"+4");

        card[104]=new Card("All",-1,"changecolor");
        card[105]=new Card("All",-1,"changecolor");
        card[106]=new Card("All",-1,"changecolor");
        card[107]=new Card("All",-1,"changecolor");
        card[108]=new Card("All",-1,"all+1");
        card[109]=new Card("All",-1,"all+2");

    }
public String prin(int i){
        return card[i].toString();
}
public String prit(){
        String result="";
        for (int i =0;i<card.length;i++ ){
            result+=card[i]+"\n";
        }
        return result;
}
    public void washcard(){
        for(int i=0;i<100;i++){
            Random random=new Random();
            int a=random.nextInt(109)+1;
            int b=random.nextInt(109)+1;

            Card k=card[a];
            card[a]=card[b];
            card[b]=k;

        }
        for (int i =0;i<card.length;i++){
            queue.enqueue(card[i]);
        }

    }

}
