
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

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
    static long start = System.currentTimeMillis();
    static long finish;
    
    
    
    public ArrayList<Ball> ballCreator(String patron,String color,int velocidad, int orientacion,int cantidad){
        ArrayList<Ball> arr = new ArrayList();
        if(patron.equals("Prototype")){
            BallListImpl standardBolita = new BallListImpl("Bolita1");
            Ball item = new Ball(color,velocidad,orientacion);
            standardBolita.addProductItem(item);   
            for(int c = 1; c < cantidad; c++){
                Ball cloneItem = item.clone();
                standardBolita.addProductItem(cloneItem);    
            }
            arr = standardBolita.getBalls();
            finish = System.currentTimeMillis();
            
        }
        else if (patron.equals("Builder")){
            for (int i=0;i<cantidad;i++){
                arr.add(new Ball.BallBuilder().setColor(color).setVelocidad(velocidad).setOrientacion(orientacion).build());
            }
            finish = System.currentTimeMillis();
        }
        else if (patron.equals("Factory")){
            BallFactoryMethod factory = new BallFactoryMethod();
            for (int i=0;i<cantidad;i++){  
                arr.add(factory.createBall(color, velocidad, orientacion));
            }
            finish = System.currentTimeMillis();
        }
        else if (patron.equals("Pool")){
            BallPool pool = new BallPool(200); //Pool de objetos bolita
            ArrayList array = pool.setObjects(pool.getObjects(cantidad), color, velocidad, orientacion);
            for (int i=0;i<array.size();i++){  
                arr.add((Ball)array.get(i));
            }
            finish = System.currentTimeMillis();
        }
        JOptionPane.showMessageDialog(null,finish-start + " milisegundos", "Tiempo", JOptionPane.INFORMATION_MESSAGE);
        return arr;
    }
}
