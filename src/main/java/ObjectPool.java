
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
public abstract class ObjectPool implements IObjectPool, IObjectFactory{
   private int size;	
   private boolean shutdown;
   private ArrayList<Ball> objects;
	
   public ObjectPool(int size) {
      this.size = size;
      shutdown = false;
      init();
   }
	
   /*
    * initiate the pool with fix size
    */

   public void init() {
      objects = new ArrayList<>();
      for (int i = 0; i < size; i++) {
         objects.add((Ball)createNew());
      }
   }
	
   //getObject() method: will get an object from the pool and will deliver it to the user;
   
  
   @Override
   public ArrayList<Ball> getObjects(int cantidad) {
   ArrayList<Ball> arr = new ArrayList<>();
   for(int i = 0;i<cantidad;i++){
        Ball t = null;
        t = (Ball) objects.get(i);
        arr.add(t);
        objects.remove(i);
        
    }

    return arr;
    }
    public ArrayList<Ball> setObjects(ArrayList<Ball> arr ,String color,int velocidad,int orient){
        ArrayList<Ball> arr2 = new ArrayList<>();
        for(int i = 0;i<arr.size();i++){
            Ball t = null;
            t = (Ball)arr.get(i);
            t.setBallColor(color);
            t.setVelocidad(velocidad);
            t.setOrientation(orient);
            arr2.add(t) ;
        }

        return arr2;
   }
	
   //return size of the pool
   public int size() {
      return objects.size();
   }
}
