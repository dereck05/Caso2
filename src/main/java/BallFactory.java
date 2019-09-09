
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naty9
 */
public class BallFactory {
    private static HashMap <String,IPrototype> balls = new HashMap<>();
    
    public static IPrototype getPrototype(String ballName){
        return balls.get(ballName).deepClone();
    }
    
    public static void addPrototype(String ballName, IPrototype prototype){
        balls.put(ballName, prototype);
    }
}
