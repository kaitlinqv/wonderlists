package SE330;

/**
 * Created by Kaitlin on 3/8/2016.
 */
public class Registrar {
    public SLList<Student> stuList;  //there is only one registrar per program and it contains the master student list
    public SLList<Course> courseList;  //registrar also contains the master course list

    public Registrar() {  //normally populate lists would read in from database files or other things, but for ease I am populating dummy lists
        populateLists();
    }

    public Student login(int num) {  //compare login number sent in with students in stuList
        boolean isDuplicate = false;
        for (SLNode tmp = stuList.head; tmp != null; tmp = tmp.next)  //cycle through stuList
        {
            Student tmpStu = (Student) (Student) tmp.getInfo();  //cast out the student in the info to a tmpStu
            if (tmpStu.ID == num) //if duplicate is found
            {
                isDuplicate = true;  //this probably isn't needed
                return tmpStu;  //return the found student
            }
        }
        if(!isDuplicate)//can remove this if statement altogether unless implementing throws
        {
            return null;
            //student number not found
        }
        return null;
    }  //end login

    public void populateLists() {
        //can read from files here but manually setting up info instead
        stuList = new SLList("Students");
        courseList = new SLList("Courses");
        Student newStu;
        int tmp = 1001;
        for(int i = 0; i<40; i++){  //create stu list, all students have number 1001 through 1040
            newStu = new Student(tmp);
            stuList.insertAtFront(newStu);
            tmp++;
        }
        Course course1 = new Course("Typing", 12, 16);
        Course course2 = new Course("English", 10, 20);
        Course course3 = new Course("Math", 4, 20);
        courseList.insertAtFront(course1);
        courseList.insertAtFront(course2);
        courseList.insertAtFront(course3);
    }

    public void printStuList() throws EmptyListException{  //print the student list - mostly for debugging unless admin abilities are inserted
        if ( stuList.isEmpty() )
            throw new EmptyListException(stuList.name);
        else {
            for (SLNode tmp = stuList.head; tmp != null; tmp = tmp.next)
            {
                Student tmpStu = (Student) (Student) tmp.getInfo();
                tmpStu.displayStudent();
            }
        }
    }

    public void printCourseList() throws EmptyListException {  //print a list of courses
        if (courseList.isEmpty())
            throw new EmptyListException(courseList.name);
        else {
            for (SLNode tmp = courseList.head; tmp != null; tmp = tmp.next) {
                Course tmpCourse = (Course) (Course) tmp.getInfo();
                tmpCourse.displayCourse();
            }
        }
    }

    public void printCourseStudents(int courseNum)throws Exception{  //print

        for (SLNode tmp = courseList.head; tmp != null; tmp = tmp.next) {
            Course tmpCourse = (Course) (Course) tmp.getInfo();
            if(tmpCourse.courseNumber == courseNum){
                try{
                    tmpCourse.printStuList(tmpCourse.stuList);
                }catch(Exception e){
                    throw e;
                }
            }
        }
    }


    public void dropCourse(Student stu, int courseNum)throws Exception{  //drop class and update from waitlist

        for (SLNode tmp = courseList.head; tmp != null; tmp = tmp.next) {
            Course tmpCourse = (Course) (Course) tmp.getInfo();
            if(tmpCourse.courseNumber == courseNum){
                try{
                    tmpCourse.removeStudent(stu);
                }catch(Exception e){
                    throw e;
                }
            }
        }
    }

    public void addCourse(Student stu, int courseNum)throws Exception{  //add class

        for (SLNode tmp = courseList.head; tmp != null; tmp = tmp.next) {
            Course tmpCourse = (Course) (Course) tmp.getInfo();
            if(tmpCourse.courseNumber == courseNum){
                try{
                    tmpCourse.addStudent(stu);
                }catch(Exception e){
                    throw e;
                }
            }
        }

    }





}

