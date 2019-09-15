/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naty9
 */
public class BallPool extends ObjectPool{
    
    public BallPool(int size) {
        super(size);
    }

    @Override
    public Object createNew() {
        return new Ball();
    }
    
}
