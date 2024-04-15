
import java.util.Scanner;

 public class LoginUser {
     static Scanner loginUserInput = new Scanner(System.in);

     public static String loginUsername() {
         while (true) {
             System.out.println("Please enter your username.");
             String loginUsername = loginUserInput.nextLine();
             
             if (loginUsername.equals(RegisterUser.registerUsername)) {
                 System.out.println("Username matches.");
                 break;
             }
                else {



                    System.out.println("Username is incorrect, please try again.");
                }
         }
         return null;
     }
     public void loginPassword() {
         while (true) {
             System.out.println("Please enter your password.");
             String loginPassword = loginUserInput.nextLine();

             if (loginPassword.equals(RegisterUser.registerPassword)) /*(Farrell, 2019)*/{
                    System.out.println("Password matches.");
                 break;
             }
             else {



                 System.out.println("Password is incorrect, please try again.");
             }
         }
     }
 }

