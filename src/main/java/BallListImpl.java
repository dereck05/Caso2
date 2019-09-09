
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naty9
 */
public class BallListImpl implements IPrototype<BallListImpl> {
    private String ballName;
    private ArrayList<Ball> balls = new ArrayList();

    public BallListImpl(String ballName){
        this.ballName = ballName;
    }
    
    public String getBallName() {
        return ballName;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }
    
    public void setBallName(String ballName) {
        this.ballName = ballName;
    }
    
    public void setBalls(ArrayList<Ball> balls) {       
        this.balls = balls;
    }
    
    @Override
    public BallListImpl clone() {
        BallListImpl clone = new BallListImpl(ballName);
        clone.setBallName(ballName);
        return clone;
    }

    @Override
    public BallListImpl deepClone() {
        ArrayList<Ball> cloneBalls = new ArrayList<>(); 
        for(Ball ball:this.balls){
            Ball cloneItem = ball.clone();
            cloneBalls.add(cloneItem);
        }
        BallListImpl clone = new BallListImpl(ballName);
        clone.setBalls(balls);
        return clone;
    }
    
    void addProductItem(Ball item) {
        balls.add(item);
    }
    
    @Override
    public String toString() {
        String items = "";
        for(Ball item : this.balls){
            items += "\t" + item.toString() + "\n";
        }
        return "BallList{listName=" + ballName + ", balls=\n" + items + '}';
    }
}
