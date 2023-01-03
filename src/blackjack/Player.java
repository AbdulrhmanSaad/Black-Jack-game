
package blackjack;

public class Player {
    private final String  name;
   private int score;
 public  Card []pc=new Card[11];
   
    public Player(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

}
