

public class KanBan {

    private static String password;
    private static String username;

    public static void main(String[] args) {
        System.out.println("Welcome to the KanBan App");

        Login kanBan = new Login();
        String firstName = kanBan.promptFirstName();
        String lastName = kanBan.promptLastName();
        while (true) {
            boolean isUserNameValid = kanBan.checkUserName();
            boolean isPasswordComplex = kanBan.checkPasswordComplexity();
            kanBan.registerUser(isUserNameValid, isPasswordComplex);
            if (isUserNameValid && isPasswordComplex) {
                break;
            }
        }

        while (true) {
            boolean isUserLoggedIn = kanBan.loginUser(username, password);


        String loginStatus = kanBan.returnLoginStatus(isUserLoggedIn);
        System.out.println(loginStatus);
            if (isUserLoggedIn) {
                break;
            }

        }
    } System.out.println("Welcome " + firstName + " " + lastName + "it is great to see you again.");
}
