package com.bridgelabz.DesignPatterns;

public class LazyInitializedSingleton {
	
private static LazyInitializedSingleton instance;
    
    private LazyInitializedSingleton(){}
    
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
    public static void main(String[] args) {
    	LazyInitializedSingleton es= getInstance();
    	System.out.println(es);
    	LazyInitializedSingleton es1= getInstance();// only one instance is created
    	System.out.println(es1);
    }
}
