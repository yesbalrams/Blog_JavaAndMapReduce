package mapreducewithclassconcepts.Inner;


class StaticInnerwithNonStaticMember{  
	  static int data=30;  
	  static class Inner{  
	   void msg(){
		   System.out.println("I am a static inner class. I can access static fields or class variables");
		   System.out.println("data variable is now "+data);
		   }  
	  }  
	  public static void main(String args[]){  
		  StaticInnerwithNonStaticMember.Inner obj=new StaticInnerwithNonStaticMember.Inner();  
	  obj.msg();  
	  }  
	}  

