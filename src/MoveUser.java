import java.util.Scanner;

public class MoveUser {

    int user;

    public int choice(String[] args) {
        boolean temp = true;
        Scanner scanner = new Scanner(System.in);
        while (temp) {
            System.out.println("Available moves: ");
            for (int i = 0; i < args.length; i++) {
                System.out.println(i + 1 + " - " + args[i]);
            }
            System.out.println(0 + " - Exit");
            System.out.println("Enter your move: ");
            int value = scanner.nextInt();
            if (value == 0) {
                System.exit(0);
            }
            if (value <= args.length) {
                temp = false;
                scanner.close();
                user = value - 1;
            }
        }
        return user;
    }
}
