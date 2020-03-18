import java.io.*;
import java.util.*;

class GenerateStudent
{
    final String capLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
    final String letter = "abcdefghijklmnopqrstuvwxyz";
    final String number = "0123456789";

    final Set<String> firstNameCheck = new HashSet<String>();
    final Set<String> lastNameCheck = new HashSet<String>();
    final Set<String> idCheck = new HashSet<String>();

    final int nameLength = 7;
    final int idLength = 10;

    GenerateStudent(){

    }

    GenerateStudent(int size) throws IOException {
        List<Student> students = new ArrayList<>();
        int divider = (int) (0.6 * size);
        while (size != 0){
            String firstName = GetFirstName();
            String lastName = GetLastName();
            String id = Getid();
            String field = "CS";
            if (size > divider){
                field = "DS";
            }

            Student newStudent = new Student(firstName, lastName, id, field);
            students.add(newStudent);

            size --;
        }
        SaveText(students, size);
    }

    private String GetFirstName(){
        String newFirstName = GetName();
        while (firstNameCheck.contains(newFirstName)){
            newFirstName = GetName();
        }
        firstNameCheck.add(newFirstName);
        return newFirstName;
    }

    private String GetLastName(){
        String newLastName = GetName();
        while (lastNameCheck.contains(newLastName)){
            newLastName = GetName();
        }
        lastNameCheck.add(newLastName);
        return newLastName;
    }

    private String GetName(){
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0){
            builder.append(capLetter.charAt(rand.nextInt(26)));
            for (int i = 1; i < nameLength; i++){
                builder.append(letter.charAt(rand.nextInt(26)));
            }
        }
        return builder.toString();
    }

    private String Getid(){
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0 || idCheck.contains(builder)){
            for (int i = 0; i < idLength; i++){
                builder.append(number.charAt(rand.nextInt(10)));
            }
        }
        idCheck.add(builder.toString());
        return builder.toString();
    }

    private void SaveText(List<Student> students, int size) throws IOException {
        String filename = "students-" + Integer.toString(size)  + ".txt";
        File output = new File(filename);
        FileOutputStream fos = new FileOutputStream(output);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for(Student each: students){
            bw.write(each.toString());
        }
        bw.close();
    }
}
