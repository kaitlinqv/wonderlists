package SE330;

/**
 * Created by Kaitlin on 3/3/2016.
 */
public class Student {
    public int ID;
    public int classCount;

    public Student(int i){
        ID = i;
        classCount = 0;
    }

    public int getClassCount(){
        return classCount;
    }
}