import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Game {

    static int user;
    static int computer;

    public static void main(String[] args) {
        if (args.length < 3 || (args.length % 2) == 0) {
            throw new IllegalArgumentException("Invalid row count!");
        }
        Set<String> strings = new HashSet<>(Arrays.asList(args));
        if (strings.size() != args.length) {
            throw new IllegalArgumentException("Words are repeated!");
        }

        Generator generator = new Generator();
        String hmacKey = generator.generatorHmacKey();
        computer = generator.generatorMoveComputer(args.length);
        String hmac = generator.generationHmac(hmacKey, args[computer]);
        System.out.println("HMAC: " + hmac);

        MoveUser moveUser = new MoveUser();
        user = moveUser.choice(args);
        System.out.println("Your move: " + args[user]);
        System.out.println("Computer move: " + args[computer]);

        int halfSize = args.length / 2;
        ResultGame resultGame = new ResultGame();
        resultGame.choiceWin(user, computer, halfSize);

        System.out.println("HMAC key: " + hmacKey);
    }
}
