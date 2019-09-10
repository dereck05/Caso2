package PoolExample;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naty9
 */
public class Ball0 {
    
    private String name;
    
    public Ball0(String name) {
      this.name = name;
   }
	
   public void doSomething() {
      System.out.println("I am resource " + this.name + ".");
   }
}
