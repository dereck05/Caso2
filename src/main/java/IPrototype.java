/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naty9
 */
public interface IPrototype <T extends IPrototype> extends Cloneable {
    public T clone();
    public T deepClone();
}
