package data;

public class FullTimeTeacher extends Teacher{

    private float experienceYears;

    public FullTimeTeacher(String name, int baseSalary, float experienceYears, String status){
        super(name, baseSalary, status);
        this.experienceYears = experienceYears;
    }

    public float getFullSalary() {
        return super.baseSalary * (experienceYears * 1.10F);
    }
}
