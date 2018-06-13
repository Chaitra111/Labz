package com.bridgelabz.DesignPatterns;

public class EagerInitializedSingleton {


    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    
    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
    public static void main(String[] args) {
    	EagerInitializedSingleton es= getInstance();
    	System.out.println(es);
    	EagerInitializedSingleton es1= getInstance();// only one instance is created
    	System.out.println(es1);
    }
}
