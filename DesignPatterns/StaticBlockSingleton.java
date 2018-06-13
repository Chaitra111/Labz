package com.bridgelabz.DesignPatterns;

public class StaticBlockSingleton {
	
private static StaticBlockSingleton instance;
    
	private StaticBlockSingleton(){}
    
    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
    public static void main(String[] args) {
    	StaticBlockSingleton es= getInstance();
    	System.out.println(es);
    	StaticBlockSingleton es1= getInstance();// only one instance is created
    	System.out.println(es1);
    }
}