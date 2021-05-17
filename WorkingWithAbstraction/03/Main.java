import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        CardRank cardPower = CardRank.valueOf(cardRank);
        CardSuits cardSuits = CardSuits.valueOf(cardSuit);

        int power = cardPower.getPower() + cardSuits.getPower();

        System.out.printf("Card name: %s of %s; Card power: %d",
                cardPower, cardSuit, power);


    }
}
