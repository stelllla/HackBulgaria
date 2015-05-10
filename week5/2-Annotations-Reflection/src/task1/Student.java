package task1;

public class Student extends Person {
    private String university;
    private String specialty;
    
    Student(String name,int age,String uni,String spec) {
        super(name,age);
        this.university = uni;
        this.specialty = spec;
    }
    
    public String getUniversity() {
        return university;
    }
    public void setUniversity(String university) {
        this.university = university;
    }
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    
    

}
