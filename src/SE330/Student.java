package SE330;

/**
 * Created by Kaitlin on 3/3/2016.
 */
public class Student {
    public int ID;
    public int classCount;
    //public String name;  //not used since using dummy students
    public Student(int i){
        ID = i;
        classCount = 0;
    }

    public void displayStudent(){
        System.out.printf("Student ID: %d\tCurrently enrolled in %d course(s).\n", ID,classCount);
    }
}