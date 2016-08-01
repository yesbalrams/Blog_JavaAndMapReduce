package mapreducewithclassconcepts.Inner;

abstract class Car{  
	  abstract void driving();  
}  

class AnonymousClass{  
 public static void main(String args[]){  
	 Car p=new Car(){  
  void driving(){System.out.println("car is driving at a high speed !!!");}  
  };  
  p.driving();  
 }  
}

