package SE330;

/**
 * Created by Kaitlin on 3/8/2016.
 */
public class Course {
    public SLList<Student> stuList;  //list of enrolled students
    public SLList<Student> waitList;  //waitlist to be implemented later
    public String name;  //name  of course
    public int courseNumber;  //course number
    public int courseCapacity;  //course Capacity
    public int currentEnrolled;  //currently enrolled count

    public Course() {  //base constructor
        this("course",0,20);
    }

    public Course (String courseName, int num, int cap ){  //full constructor which initiates lists
        name = courseName;
        courseNumber = num;
        courseCapacity = cap;
        stuList = new SLList<Student>();
        waitList = new SLList<Student>();
        currentEnrolled = 0;
    }

    public void printStuList(SLList<Student> list) throws EmptyListException{  //print student list, must enter waitlist or stulist, possibly reformat later
        if ( list.isEmpty() )
            throw new EmptyListException(list.name);
        else {
            for (SLNode tmp = list.head; tmp != null; tmp = tmp.next)
            {
                Student tmpStu = (Student) (Student) tmp.getInfo();
                System.out.print(tmpStu.ID);
                System.out.println();
            }
        }
    }//end printStuList

    public void addStudent(Student stu) {  //add student but check current stuList to make sure there is no duplicate
        boolean isDuplicate = false;
        for (SLNode tmp = stuList.head; tmp != null; tmp = tmp.next)  //cycle through this course's enrolled students
        {
            Student tmpStu = (Student) (Student) tmp.getInfo();
            if (tmpStu.ID == stu.ID)  //check Student in the list versus student you're adding
            {
                isDuplicate = true;
            }
        }
        if(!isDuplicate) //if not duplicate
        {
            if(stu.classCount<4 && currentEnrolled<courseCapacity) {  //if student class count is less than 4 and the course hasn't reached capacity
                stu.classCount++;
                stuList.insertAtBack(stu);
                currentEnrolled++;
            }else {
                //something about being registered for too many classes and/or class is full
            }
        }else
        {
            //print something about being already registered
        }
    }

    public void removeStudent(Student stu)throws Exception{
        boolean isDuplicate = false;
        for (SLNode tmp = stuList.head; tmp != null; tmp = tmp.next)  //cycle through this course's enrolled students
        {
            Student tmpStu = (Student) (Student) tmp.getInfo();
            if (tmpStu.ID == stu.ID)  //check Student in the list versus student you're adding
            {
                isDuplicate = true;
                stuList.delete(stu);
                //updateLists();  //update waitlist and stulist
            }
        }

        if(!isDuplicate){
            throw new Exception ("You are not enrolled in this course");
        }

    }

    public void displayCourse() {  //display course, works great in a for loop when listing my SLList
        System.out.printf("Course ID: %d\tCapacity: %d\tOpenings: %d\t Name: %s\n", courseNumber, courseCapacity, courseCapacity-currentEnrolled, name);
    }
}
