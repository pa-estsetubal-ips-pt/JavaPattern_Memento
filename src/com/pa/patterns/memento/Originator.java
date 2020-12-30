/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.patterns.memento;

/**
 *
 * @author brunomnsilva
 */
 public interface Originator {
    
    public Memento save();
    public void restore(Memento savedState);
    
}
