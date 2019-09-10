
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author derec
 */
public class SuperFactory {
    public SuperFactory(){
        
    }
    
    public ArrayList<Ball> ballCreator(String patron,String color,int velocidad, int orientacion,int cantidad){
        ArrayList<Ball> arr = new ArrayList();
        if(patron.equals("Prototype")){
            
        }
        else if (patron.equals("Builder")){
            for (int i=0;i<cantidad;i++){
                arr.add(new Ball.BallBuilder().setColor(color).setVelocidad(velocidad).setOrientacion(cantidad).build());
            }
        }
        else if (patron.equals("Factory")){
            BallFactoryMethod factory = new BallFactoryMethod();
            for (int i=0;i<cantidad;i++){
                
                arr.add(factory.createBall(color, velocidad, orientacion));
            }
        }
        else if (patron.equals("Pool")){
            
        }
        
        return arr;
    }
}
