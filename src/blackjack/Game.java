
package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {
      
     public Player[] p=new Player[4]; 
    public Card [] cd=new Card[52];
    public int highScore;
    public int index=2;
    
    public void generateCard()
    { 
        int numOfCard=0;
        for(int j=0;j<4;j++)
        {
            
            for(int i=0;i<13;i++)
            {
              if(i<10)
              {
                cd[numOfCard++]=new Card(j,i,i+1);
              }
                else
              {
                cd[numOfCard++]=new Card(j,i,10);
              }
            }
        }
        
    }
    
   public Card drowRandCard()
    {
        Random rand=new Random();
        Card card=new Card();
        while(true)
        {  
        int randamCard=rand.nextInt(52);
        if(cd[randamCard]!=null)
        {
           card= cd[randamCard];
           cd[randamCard]=null;
           return card;
        }
       
        }
    }
   public void setsInfo(){
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<3;i++)
        {
            System.out.println("Player "+(i+1)+" name is: ");
            String name=scanner.nextLine();
            
            p[i]=new Player(name);
            p[i].pc[0]=drowRandCard();
            p[i].pc[1]=drowRandCard();
            
            p[i].setScore(p[i].pc[0].getValue()+p[i].pc[1].getValue());     
    }
        
            p[3]=new Player("Dealer");
            p[3].pc[0]=drowRandCard();
            p[3].pc[1]=drowRandCard();
            
            p[3].setScore( p[3].pc[0].getValue()+ p[3].pc[1].getValue());
   
}
    
   public int maxScore(Player p[],int size)
   {

        int mx=p[0].getScore(),indexOfMaxScore=0;
        for(int i=0;i<size;i++)
        {
        if(p[i].getScore()>mx)
          {
            mx=p[i].getScore();
             indexOfMaxScore=i;
          }
        }
        return indexOfMaxScore;
    }
   public Card addCard ( int playerIndex)
    {
      
        Card card=new Card( drowRandCard());
      p[playerIndex].pc[index++]=card;
      updataScore(card,p,playerIndex); 
      return card;
    
    }
   public void updataScore(Card d,Player p[],int index)
   {
       p[index].setScore(p[index].getScore()+d.getValue());
   }
   
}
