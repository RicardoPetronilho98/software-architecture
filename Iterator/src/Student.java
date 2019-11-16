public class Student {
    public String id;
    public String name;
    public int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Student{id='" + this.id + "', name='" + this.name + "', age=" + this.age + "}";
    }
}