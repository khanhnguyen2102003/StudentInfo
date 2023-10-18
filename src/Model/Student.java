package Model;


public class Student {
    private String name;
    private float mark;
    private String className;

    public Student() {
        this.name = "";
        this.mark = 0.0f;
        this.className = "";
    }

    public Student(String name, String className, float mark) {
        this.name = name;
        this.className = className;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    

    @Override
    public String toString() {
        return "Name: " + name + ", Mark: " + mark + ", Class: " + className;
    }
}


