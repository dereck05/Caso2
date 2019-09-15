
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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
         objects.add(new Ball());
      }
   }
	
   //getObject() method: will get an object from the pool and will deliver it to the user;
   
  
   public ArrayList<Ball> getObjects(int cantidad) {
   ArrayList<Ball> arr = new ArrayList<>();
   for(int i = 0;i<cantidad;i++){
        Ball t = null;
        t = (Ball) objects.get(i);
        arr.add(t);
    }

    return arr;
    }
   public setObjects(ArrayList<Ball> arr ,String color,int velocidad,int orient){
        ArrayList<Ball> arr = new ArrayList<>();
        for(int i = 0;i<arr.size();i++){
            Ball t = null;
            b = (Ball)objects.get(i);
            
            arr.add(b) ;
        }

        return arr;
   }
		
      
   
   
 
	
   //shutdown() method: will close down the pool.
   
   @Override
   public void shutdown() {
      objects.clear();
   }
	
   //return size of the pool
   public int size() {
      return objects.size();
   }
}
