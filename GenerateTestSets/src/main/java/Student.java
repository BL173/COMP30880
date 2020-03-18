public class Student {

    final String firstName;
    final String lastName;
    final String id;
    final String field;
//    enum Major {
//        CS,
//        DS
//    }

    Student(String firstName, String lastName, String id, String field){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.field = field;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return firstName + " " + lastName + " " + id +  " " + field + "\n";
    }

}
