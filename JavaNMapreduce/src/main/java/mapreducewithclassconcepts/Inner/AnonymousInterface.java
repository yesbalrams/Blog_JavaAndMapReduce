package mapreducewithclassconcepts.Inner;

interface Human{  
	 void eat(); 
	 void speak();
	 void walk();
	 void drives();
	}  
	
class AnonymousInterface{  
 public static void main(String args[]){  
	 Human man=new Human(){  
  public void eat(){System.out.println("A man eats processed food ...");}

public void speak() {
	System.out.println("A man can speak various languages ...");
}

public void walk() {
	System.out.println("A man can walk on two legs ...");
}

public void drives() {
	System.out.println("A man can drive vehicles ...");
}  
 };  
 man.eat();  
 man.speak();
 man.walk();
 man.drives();
 }  
}  