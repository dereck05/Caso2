package PoolExample;


import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naty9
 */
public class BallPrueba extends ObjectPool {
        private String nombre = "";    
    
        public BallPrueba(int size) {
            super(size);
            //nombre = this.nombre;
        }
        
        public Ball0 createNew(){
            return new Ball0("Natalia");
        }
}
