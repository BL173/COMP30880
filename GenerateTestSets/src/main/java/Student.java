import java.util.ArrayList;

public class Student {
    private int id;
 //   private String name;    
    final String firstName;
    final String lastName;
    final String field;

    
    private ArrayList<Project> recomendedProjects=new ArrayList<Project>();


/*    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    public void setRecomendedProjects(ArrayList<Project> recomendedProjects) {
        this.recomendedProjects = recomendedProjects;
    }

    public Student(int id){
        this.id=id;

    }
    
    public Student(String firstName, String lastName, int id, String field){
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

    public int getId() {
        return id;
    }
    
    public String toString() {
        return firstName + " " + lastName + " " + id +  " " + field + "\n";
    }
    
    public void showArray(String[] inputArray){
        for(String item: inputArray){
            System.out.println(item);
        }
    }

    public ArrayList<Project> getRecomendedProjects() {
        return recomendedProjects;
    }
}
