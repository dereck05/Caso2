
import PoolExample.ObjectFactory;
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
public abstract class ObjectPool implements PoolExample.IObjectPool,ObjectFactory{
    private int size;	
   private boolean shutdown;
   private BlockingQueue objects;
	
   public ObjectPool(int size) {
      this.size = size;
      shutdown = false;
      init();
   }
	
   /*
    * initiate the pool with fix size
    */
   private void init() {
      objects = new LinkedBlockingQueue();
      for (int i = 0; i < size; i++) {
         objects.add(createNew());
      }
   }
	
   //getObject() method: will get an object from the pool and will deliver it to the user;
   
   @Override
   public Ball getObject() {
      if (!shutdown) {
         Ball t = null;
         			
         try {
            t = (Ball) objects.take();
         }
         catch (Exception e) {
            e.printStackTrace();
         }
			
         return t;
      }
		
      throw new IllegalStateException("Object pool is already shutdown.");
   }
   
   //releaseObject() method: will return an object to the pool;
	
   @Override
   public void releseObject(Object ball){
      try {
         objects.offer(ball);
      } catch (Exception e) {
         e.printStackTrace();
      }
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
