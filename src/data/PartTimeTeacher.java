package data;

public class PartTimeTeacher extends Teacher{

    private float hoursPerWeek;

    public PartTimeTeacher(String name, int baseSalary, float hoursPerWeek, String status){
        super(name, baseSalary, status);
        this.hoursPerWeek = hoursPerWeek;
    }

    public float getFullSalary() {
        return super.baseSalary * hoursPerWeek;
    }
}
