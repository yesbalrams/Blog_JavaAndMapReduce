package mapreducewithclassconcepts.ClassTypes;

class EmployeeObject {
    public static void main(String[] args) {

        // Create two different 
        // Bicycle objects
        Employee abhay = new Employee ("abhay", "25/05/1991", 'M', 178, 64,"System Engineer");
        Employee banti = new Employee ("Banti", "22/05/1991", 'M', 171, 74,"Senior System Engineer");

        // Invoke methods on 
        // those objects
        abhay. get_personal_info();
        abhay. get_designation();
        abhay. get_age();
        System.out.println();
        banti. get_personal_info();
        banti. get_designation();
        banti. get_age();
    }
}

