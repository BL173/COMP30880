import java.util.*;

public class ProjectDistribution {
	
	public static void main(String[] args) {
        
		// run the other tests by commeting out each of the test sets. the process is the same for all
        int TEST=60;
//        int TEST=120;
//        int TEST=240;
//        int TEST=500;

        ArrayList<Student> students=new ArrayList<Student>();

        //creating student list : you can add names and other information to student object, but for now, they only have id
        for(int i=0;i<TEST;i++){
            students.add(new Student(i));
        }

        // these are the constant values for normal distibution, you can change the values of MEAN and Variance but mean should be in range of project ids
        // by this solution, the projects with ids around the mean are more popular (peak of bell)
        double MEAN = TEST/2;
        double VARIANCE = TEST/2;
        Random fRandom = new Random();

        
        for (Student std: students) {

            ArrayList<Project> projects=new ArrayList<Project>();
            ArrayList<Integer> takenProjects=new ArrayList<Integer>();
            while (projects.size()<10){
                Double dblrand = fRandom.nextGaussian() * Math.sqrt(VARIANCE) + MEAN;
                int rand = dblrand.intValue();
                //we should make sure that the random number does exist in projects
                if (rand<0 || rand>TEST){
                    continue;
                }
                // we shouldn't recomned same a project more than once to student
                if (takenProjects.contains(rand)){
                    continue;
                }
                Project project = new Project(rand);
                project.setProbability(getNormalProbability(rand,MEAN,Math.sqrt(VARIANCE)));
                projects.add(project);
                takenProjects.add(rand);
            }
            Collections.sort(projects);
            std.setRecomendedProjects(projects);
        }
        
        //showing top 5 students
        for(int i=0;i<5;i++){
        	showStudent(students.get(i));
        	}
    }

    private static void showStudent(Student std){
        String output=" ";
        for (Project p: std.getRecomendedProjects()){
            Integer id=p.getId();
            Double prb=p.getProbability();
            output=output+id.toString()+"/"+prb.toString()+" ";
        }
        System.out.println(output);
    }
    
    private static double getNormalProbability(int x,double mu,double sigma) {
        double prob=(1/(sigma*Math.sqrt(2*Math.PI)))*Math.exp(-0.5*Math.pow((x-mu)/(sigma),2));
        return prob;

    }

}


