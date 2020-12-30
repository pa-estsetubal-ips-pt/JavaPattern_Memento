/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.patterns.memento;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author brunomnsilva
 */
public class BagOfWords implements Originator {

    private final List<String> bag;

    public BagOfWords() {
        bag = new LinkedList<>();
    }
    
    public void put(String word) {
        bag.add(word);
    }
    
    public void remove(String word) {
        bag.remove(word);
    }

    @Override
    public String toString() {
        return "BagOfWords{" + "bag=" + bag + '}';
    }
    
    
    
    @Override
    public Memento save() {
        return new MyMemento(bag);
    }

    @Override
    public void restore(Memento savedState) {
        if(savedState instanceof MyMemento) {
            
            bag.clear();
            bag.addAll( ((MyMemento)savedState).state );
            
        }
    }
    
    private class MyMemento implements Memento {
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        
        private final String description;
        private final List<String> state;

        public MyMemento(List<String> stateToSave) {
            this.description = "BagOfWords saved state from " + simpleDateFormat.format(new Date());
            this.state = new LinkedList<>(stateToSave); //copy of list
        }
        
        
        @Override
        public String getDescription() {
            return description;
        }
        
    }
    
}
