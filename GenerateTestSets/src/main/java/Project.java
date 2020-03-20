
public class Project implements Comparable<Project> {
    private int id;
    private String name;

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    private double probability;

    public Project(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Project comparePro) {
        double other = comparePro.probability;

        if (this.probability == other)
            return 0;
        else if (this.probability < other)
            return 1;
        else
            return -1;
    }
    }

