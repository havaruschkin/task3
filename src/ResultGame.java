public class ResultGame {

    public void choiceWin(int user, int computer, int halfSize) {
        if (user == computer) {
            System.out.println("Draw!");
        } else if ((computer > user && halfSize >= computer - user)
                || (computer < user && halfSize < user - computer)) {
            System.out.println("Computer win!");
        } else {
            System.out.println("You win");
        }
    }
}
