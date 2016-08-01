package mapreducewithclassconcepts.Inner;

public class StaticInnerwithStaticMember {
	  static class Inner{  
	   static void msg(){
		   System.out.println("I am a static inner class. I can access static fields or class variables");
		   System.out.println("I have a static method, which you can access through my parent class "
		   		+ "\nwithout wasting time in creating an object for me");
		   
		   }  
	  }  
	  public static void main(String args[]){  
		  StaticInnerwithStaticMember.Inner.msg();  
	  }  

}
