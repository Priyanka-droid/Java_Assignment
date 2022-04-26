import java.util.Scanner;

public class CollegeAppStart {

    public static void startApp() {

        Tasks.initialiseStudentList();
        int menuChoice = 0;
        final int ADD_DETAILS = 1;
        final int DISPLAY_DETAILS = 2;
        final int DELETE_DETAILS = 3;
        final int SAVE_DETAILS = 4;
        final int EXIT = 5;
        final int RANGE_BEGIN = 1;
        final int RANGE_END = 5;
        outer:
        do {

            System.out.println("""
                    Enter menu choice:
                    1: Add details
                    2. Display details
                    3. Delete details
                    4. Save details
                    5: Exit
                    """);
            Scanner sc = new Scanner(System.in);
            try {
                menuChoice = sc.nextInt();
                Validations.validateNumber(menuChoice, RANGE_BEGIN, RANGE_END);
            } catch (NumberFormatException e) {
                System.out.println(e);
            } catch (NumberOutOfRangeException e) {
                System.out.println(e);
            }

            switch (menuChoice) {
                case ADD_DETAILS:
                    Tasks.addDetails();
                    break;
                case DISPLAY_DETAILS:
                    Tasks.displayDetails();
                    break;
                case DELETE_DETAILS:
                    Tasks.deleteDetails();
                    break;
                case SAVE_DETAILS:
                    Tasks.saveDetails();
                    break;
                case EXIT:
                    Tasks.exit();
                    break outer;
            }

        } while (true);

    }
}
