package PoolExample;


import PoolExample.BallPrueba;
import PoolExample.Ball0;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naty9
 */
public class MainObjectPool {
    public static void main(String[] args)	{
      final BallPrueba pool = new BallPrueba(3);
		
      System.out.println("Simple usage");
      System.out.println();
      System.out.println("Pool size:" + pool.size());
		
      /* simple usage - get the object */
      Ball0 obj0 = pool.getObject();
      /* simple usage - use the object */
      obj0.doSomething();
		
      /* to check that the object was removed from the pool */
      System.out.println("Pool size:" + pool.size());
		
      /* simple usage - return the object */
      pool.releseObject(obj0);
		
      System.out.println();
      System.out.println("extended usage");
      System.out.println();
		
      final Ball0 obj1 = pool.getObject();
      Ball0 obj2 = pool.getObject();
      Ball0 obj3 = pool.getObject();
		
      /* to check that the object was removed from the pool */
      System.out.println("Pool size:" + pool.size());
      obj1.doSomething();
      obj2.doSomething();
      obj3.doSomething();
		
      /* create a new thread to simulate the long operation for obj1 - this will avoid blocking the test app */
      Runnable exec = new Runnable() {
				
         @Override
         public void run() {
            try {
               Thread.sleep(10 * 1000);
            } catch (InterruptedException e)	{
               e.printStackTrace();
            }
            pool.releseObject(obj1);
         }
      };
      Thread thread = new Thread(exec);
      thread.start();	
		
      /* will wait until the thread will finish and will return the object to the pool - 10 sec 
       * will be the same object as for obj1.
       */
      System.out.println("Pool size:" + pool.size());
      Ball0 obj4 = pool.getObject();
      obj4.doSomething();
		
      /*return all objects to the pool */
      pool.releseObject(obj4);
      pool.releseObject(obj2);
      pool.releseObject(obj3);
		
      /* check the pool size */
      System.out.println("Pool size:" + pool.size());
		
      /* shutdown the pool*/
      pool.shutdown();
		
      /* check the pool size */
      System.out.println("Pool size:" + pool.size());
   }
}
