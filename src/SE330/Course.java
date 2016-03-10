package SE330;

/**
 * Created by Kaitlin on 3/8/2016.
 */
public class Course {
    public SLList<Student> stuList;  //list of enrolled students
    //public SLList<Student> waitList;  //waitlist to be implemented later
    //public Tree waitList;
    public theBinaryTree waitList;
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
        //waitList = new SLList<Student>();
        waitList = new theBinaryTree();
        currentEnrolled = 0;
    }

    public void printStuList(SLList<Student> list) throws EmptyListException{  //print student list, must enter waitlist or stulist, possibly reformat later
        if ( list.isEmpty() )
            throw new EmptyListException(list.name);
        else {
            for (SLNode tmp = list.head; tmp != null; tmp = tmp.next)
            {
                Student tmpStu = (Student) (Student) tmp.getInfo();
                tmpStu.displayStudent();
            }
        }
    }//end printStuList

    public void addStudent(Student stu) throws Exception {  //add student but check current stuList to make sure there is no duplicate

        for (SLNode tmp = stuList.head; tmp != null; tmp = tmp.next)  //cycle through this course's enrolled students
        {
            Student tmpStu = (Student) (Student) tmp.getInfo();
            if (tmpStu.ID == stu.ID)  //check Student in the list versus student you're adding
            {

                throw new Exception("\nYou are already registered for this class!\n");
            }
        }

        /*for (SLNode tmp = waitList.head; tmp != null; tmp = tmp.next){
            Student tmpStu = (Student) (Student) tmp.getInfo();
            if (tmpStu.ID == stu.ID ){
                waitList.delete(tmpStu);
            }
        }*/

        if(stu.classCount<4) {  //if student class count is less than 4 and the course hasn't reached capacity
            if(currentEnrolled<courseCapacity) {
                stu.classCount++;
                stuList.insertAtBack(stu);
                currentEnrolled++;
            }else {
                waitList.insert(stu.ID);
                //waitList.insertAtBack(stu);
                throw new Exception("\nThis class is full, you have been added to the waitlist.\n");

            }
        }else {
                //something about being registered for too many classes and/or class is full
            throw new Exception("\nYou are already registered for 4 classes!\n");
        }

    }

    public void removeStudent(Student stu)throws Exception{
        boolean isDuplicate = false;
        for (SLNode tmp = stuList.head; tmp != null; tmp = tmp.next)  //cycle through this course's enrolled students
        {
            Student tmpStu = (Student) (Student) tmp.getInfo();
            if (tmpStu.ID == stu.ID)  //check Student in the list versus student you're removing
            {
                isDuplicate = true;
                stu.classCount--;
                stuList.delete(stu);
                currentEnrolled--;
                updateLists();  //update waitlist and stulist
            }
        }

        if(!isDuplicate){
            throw new Exception ("You are not enrolled in this course");
        }

    }

    public void updateLists() {
        int openings = courseCapacity - currentEnrolled;
        for (int i = openings; i>0; i-- ){
            try {
                //addStudent(waitList.deleteFromFront());
            }catch(Exception e){
                //System.out.print("Something went wrong");
            }
        }
    }

    public void displayCourse() {  //display course, works great in a for loop when listing my SLList
        System.out.printf("Course ID: %d\tCapacity: %d\tOpenings: %d\t Name: %s\n", courseNumber, courseCapacity, courseCapacity-currentEnrolled, name);
    }
}
