package mapreducewithclassconcepts.Inner;

class MemberOuter{  
	 class MemberInner{  
	  void msg(){
		  System.out.println("I am a class but i am a member of Outer class \""+
	                         this.getClass().getEnclosingClass().getSimpleName()+"\"");		  
		  }  
	 }  
	 public static void main(String args[]){  
		 MemberOuter obj=new MemberOuter();  
		 MemberOuter.MemberInner in=obj.new MemberInner();  
	  in.msg();  
	 }  
	}  
