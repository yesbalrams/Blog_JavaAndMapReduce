package mapreducewithclassconcepts.Inner;

public class LocalOuter{  
	 private int data=30;//instance variable  
 void display(){  
  class LocalInner{  
   void msg(){System.out.println(data);}  
  }  
  LocalInner l=new LocalInner();  
  l.msg();  
 }  
 public static void main(String args[]){  
	 LocalOuter obj=new LocalOuter();  
  obj.display();  
 }  
}  

