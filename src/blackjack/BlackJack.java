
package blackjack;

import java.util.Scanner;


public class BlackJack {

   static Game G=new Game();
    public static void main(String[] args) {
        
       GUI Gui = new GUI();
       G.generateCard();
       G.setsInfo();
       Gui.runGUI(G.cd,G.p[0].pc,G.p[1].pc,G.p[2].pc,G.p[3].pc);
         playerFunction();
      int index= G.maxScore(G.p,3);
      if(G.p[index].getScore()>G.p[3].getScore()){     
         dealerFunction(index);                                                                
      }
   
 if(G.p[3].getScore()>21) 
     G.p[3].setScore(0);
 
       resultOfGame(G.p);
    }
    
    
    
    
    public static void playerFunction()
    {
        Scanner input=new Scanner(System.in);
        GUI Gui = new GUI();
        for(int i=0;i<3;i++)
       {
           System.out.println("player "+(i+1));
           int y=G.p[i].getScore();
         while(y<21)
        {
          System.out.println("1)Hit");
          System.out.println("2)Stand");
          int cho=input.nextInt();
         if (cho==1)
          {
               Card r=new Card();
            System.out.println("The dealer will give you card");
            r= G.addCard(i);
            Gui.updatePlayerHand(r,i);
            if(G.p[i].getScore()>21)
             {
              System.out.println("you are pusted " +" with score "+G.p[i].getScore());
               y=G.p[i].getScore();
              G.p[i].setScore(0);
              //break;
            } 
            else if(G.p[i].getScore()==21)
              break;
            }
          else 
            {
                 System.out.println((i+1)+" stand and player hand is"+G.p[i].getScore());
                 break;
            }
       }
       }
    }
    
    public static void dealerFunction(int x)
    {
        GUI Gui = new GUI();
        while(true){
            Card D=new Card();
         D=G.addCard(3);
         Gui.updateDealerHand(D,G.cd);

           if((G.p[3].getScore()>G.p[x].getScore()&&G.p[3].getScore()<21)||G.p[3].getScore()==21||G.p[3].getScore()>21)
               break;
        }
    }
    
    
    public static void resultOfGame(Player p[])
    {
        int maxIndex=G.maxScore(G.p,4);
        int check=0;
        for(int i=0;i<4;i++)
        {
           if(G.p[i].getScore()==G.p[maxIndex].getScore())
            check++;
        }
        if(check>1)
                    System.out.println("PUSH");
        else
        {
            if(G.p[maxIndex].getScore()==21)
                    System.out.println(" player  "+(maxIndex+1)+"  is BLACKJACK");
            else
                if(maxIndex==3)
                        System.out.println(" Dealer is Win!!");
                else
                        System.out.println(" player  "+(maxIndex+1)+ "  is Winner!!");  
        }
    }
    
    }
    

