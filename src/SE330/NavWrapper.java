package SE330;
import java.io.*;

/**
 * Created by Kaitlin on 3/9/2016.
 */
public class NavWrapper {
    public Registrar school;
    public Student currentStudent = null;
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    public NavWrapper(){
        this(new Registrar());
    }
    public NavWrapper(Registrar reg){
        school = reg;
    }

    public int displayCourseList(){
        school.printCourseList();
        return 2;
    }

    public int loginWithNumber(int num){
        do{
            System.out.println("Login with student number:");
            try {
                int input = Integer.parseInt(buffer.readLine().toString());
                currentStudent = school.login(input);
            } catch (Exception e) {
                System.out.printf("\n%s\n", e );
            }
            return num;
        }while(currentStudent == null);
    }

    public int addCourse(){

        if (currentStudent != null)
        {
            int check = 1;
            while( check > 0 ){
                try{
                    System.out.printf("\nPlease enter: Course Number | 1 - Course List | 0 - Back to menu\n ");
                    int input = Integer.parseInt(buffer.readLine().toString());
                    if(input != 0 && input != 1) {
                        school.addCourse(currentStudent, input);
                        System.out.print("\nCourse Add Successful\n");
                    }
                    check = input;
                    if(input == 1){
                        school.printCourseList();
                    }
                }catch(Exception e) {
                    System.out.printf("\n%s\n", e);
                }
                //Please enter course to add
            }
            //or 1 to display available courses
        }else {
            System.out.printf("\nPlease login first!\n");
        }
        return 3;
    }

}
