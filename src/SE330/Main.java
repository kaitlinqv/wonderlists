package SE330;
import java.io.*;
public class Main {

    public static void main(String[] args) {
	    Student currentStudent = null;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        Registrar SB2016 = new Registrar();

        try {
            while(currentStudent == null) {

                System.out.println("Please enter your student number to login: ");
                int number = Integer.parseInt(buffer.readLine().toString());
                //currentStudent = SB2016.stuList.find(new Student(number));
                //System.out.print(number);
                currentStudent = SB2016.login(number);
                //System.out.print(currentStudent.ID);
                //System.out.print((SB2016.stuList.find(currentStudent)).ID);
            }
        }catch(Exception e){
            System.err.print(e);
        }


    }
}
