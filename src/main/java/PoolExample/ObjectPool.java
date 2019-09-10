package PoolExample;


import PoolExample.ObjectFactory;
import PoolExample.IObjectPool;
import PoolExample.Ball0;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static javafx.scene.input.KeyCode.T;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naty9
 */
public abstract class ObjectPool implements IObjectPool,ObjectFactory{
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
	
   @Override
   public Ball0 getObject() {
      if (!shutdown) {
         Ball0 t = null;
         			
         try {
            t = (Ball0) objects.take();
         }
         catch (Exception e) {
            e.printStackTrace();
         }
			
         return t;
      }
		
      throw new IllegalStateException("Object pool is already shutdown.");
   }
	
   @Override
   public void releseObject(Object ball){
      try {
         objects.offer(ball);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
	
   @Override
   public void shutdown() {
      objects.clear();
   }
	
   public int size() {
      return objects.size();
   }


	
}
    
