/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.patterns.memento;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author brunomnsilva
 */
public class Caretaker implements Iterable<Memento>{
    
    private final Originator originator;    
    private final Stack<Memento> states;

    public Caretaker(Originator originator) {
        this.originator = originator;
        this.states = new Stack<>();
    }
    
    public void requestSave() {
        Memento state = originator.save();
        states.push(state);
    }
    
    public boolean canUndo() {
        //could be a binding property to use in UI
        return !states.isEmpty();
    }
    
    public void requestRestore() {
        if(!canUndo()) return;
        
        originator.restore(states.pop());
    }

    @Override
    public Iterator<Memento> iterator() {
        return states.iterator();
    }
    
}
