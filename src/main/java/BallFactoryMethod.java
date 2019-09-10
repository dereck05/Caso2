/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author derec
 */
public class BallFactoryMethod {
    public Ball createBall(String color, int velocidad,int orientacion){
        return new Ball(color,velocidad,orientacion);
    }
}
