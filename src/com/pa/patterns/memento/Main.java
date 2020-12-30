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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BagOfWords words = new BagOfWords();
        Caretaker caretaker = new Caretaker(words);
        
        caretaker.requestSave();
        
        words.put("Este");
        words.put("é");
        
        caretaker.requestSave();
        
        words.put("o");
        words.put("padrão");
        
        caretaker.requestSave();
        
        words.put("memento");
        
        System.out.println("\n# Current contents of bag:");
        System.out.println(words);
        
        System.out.println("\n# Current contents of caretaker:");
        for (Memento memento : caretaker) {
            System.out.println(memento.getDescription());
        }
        
        System.out.println("\n# Performing all available restore states:");
        while(caretaker.canUndo()) {
            caretaker.requestRestore();
            System.out.println(words);
        }
        
    }
    
}
