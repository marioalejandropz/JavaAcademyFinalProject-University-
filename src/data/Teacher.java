package data;

public abstract class Teacher {

    protected String name, status;
    protected int baseSalary;
    protected int teacherId;
    protected static int id = 1;

    public Teacher(String name, int baseSalary, String status){
        this.name = name;
        this.baseSalary = baseSalary;
        this.status = status;
        this.teacherId = id++;
    }

    public String getName(){
        return name;
    }

    public String getStatus(){ return status;}

    public int getTeacherId(){
        return teacherId;
    }

    public String toString(){
        return "Teacher name: " + getName() + "\n" +
                "Salary/month: $" + getFullSalary() + "\n" +
                "Status: " + getStatus() + "\n" +
                "Teacher Id: " + getTeacherId() + "\n";
    }

    public abstract float getFullSalary();
}
