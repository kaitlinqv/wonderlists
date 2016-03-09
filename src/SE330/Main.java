package SE330;
import java.io.*;
public class Main {

    /*  The UI wrapper needs to be initialized, probably through an additional class. Delete functions and a couple additional compare functions will be added*/

    public static void main(String[] args) {
	    Student currentStudent = null;

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int navigation = 0;
        Registrar SB2016 = new Registrar();
        NavWrapper school = new NavWrapper(SB2016);

        do{
            System.out.printf("\n\nEnter: 1 - Login | 2 - Display Course List | 3 - Add Course | 4 - Drop Course | 5 - Display Course Students | 0 - Exit\n");
            try {
                navigation = Integer.parseInt(buffer.readLine().toString());
                System.out.println();
            }catch(Exception e){
                System.err.print(e);
            }
            switch (navigation){
                case 1:
                    school.loginWithNumber(navigation);
                    break;
                case 2:
                    school.displayCourseList();
                    break;
                case 3:
                    school.addCourse();
                    break;
                case 4:
                    school.dropCourse();
                    break;
                case 5:
                    school.printCourseStudents();
                    break;
                default:
                    navigation = 0;
                    break;
            }

        }while(navigation > 0);

/*
        try {
            while(currentStudent == null) {

                System.out.println("Please enter your student number to login: ");
                int number = Integer.parseInt(buffer.readLine().toString());
                //currentStudent = SB2016.stuList.find(new Student(number));
                //System.out.print(number);
                currentStudent = SB2016.login(number);
                //System.out.print(currentStudent.ID);
                //System.out.print((SB2016.stuList.find(currentStudent)).ID);
                SB2016.printCourseList();
//TESTING TESTING TESTING

                System.out.println("Enter course to add");
                number = Integer.parseInt(buffer.readLine().toString());
                SB2016.addCourse(currentStudent, number);
                SB2016.printCourseStudents(number);
                SB2016.printCourseList();
                SB2016.printStuList();
                SB2016.dropCourse(currentStudent, number);
                //1SB2016.printCourseStudents(number);
                SB2016.printCourseList();
                SB2016.printStuList();
            }
        }catch(Exception e){
            System.err.print(e);
        }
*/

    }
}
