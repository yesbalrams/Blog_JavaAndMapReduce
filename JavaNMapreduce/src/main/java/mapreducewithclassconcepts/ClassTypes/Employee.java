package mapreducewithclassconcepts.ClassTypes;

public class Employee{
   String name;
   String Ethnicity;
   String DOB;
   int height;
   int weight;
   String maritalstatus;
   long employee_id;
   String designation;
   char gender;
   String joiningdate;
   
   public Employee(String name,String DOB,char gender,int height,int weight,String designation)
   {
	   super();
		this.name = name;
		this.DOB = DOB;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.designation = designation;
		
   }
   public Employee(String name, String ethnicity, String DOB, int height, int weight, 
		   String maritalstatus,long employee_id, String designation, char gender, String joiningdate) {
	super();
	this.name = name;
	Ethnicity = ethnicity;
	this.DOB = DOB;
	this.height = height;
	this.weight = weight;
	this.maritalstatus = maritalstatus;
	this.employee_id = employee_id;
	this.designation = designation;
	this.gender = gender;
	this.joiningdate = joiningdate;
}

void get_personal_info(){
	System.out.println("We have following peronal information about "+name);
	System.out.println("DOB : "+DOB+"\n"+
	                   "height : "+height+"\n"+
			           "weight : "+weight+"\n"+
	                   "gender : "+gender);
   }
   
   void get_designation(){
	   System.out.println("Designation : "+designation);
   }
   
   void get_age(){
	   System.out.println("Adult");
   }
}
