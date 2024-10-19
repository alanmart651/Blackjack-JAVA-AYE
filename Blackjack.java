import java.util.Random;

public class Blackjack {
    static int player = 0;
    static int dealer = 0;
    static String playerMessage = "Las cartas del jugador son: ";
    static String dealerMessage = "Las cartas del dealer son: ";
    static int[] cards = new int[52];

    public static void createDeck() {
        int cardValue = 2;
        int cardCount = 0;
        for (int figure = 1; figure <= 4; figure++) {
            for (int card = 1; card <= 13; card++) {
                switch (card) {
                    case 10:
                    case 11:
                    case 12:
                        cardValue = 10;
                        break;
                    case 13:
                        cardValue = 11;
                        break;
                    default:
                        break;
                }
                cards[cardCount] = cardValue;
                cardCount++;
                cardValue++;
            }
            cardValue = 2;
        }
    }

    public static int drawCard() {
        Random rand = new Random();
        int card = rand.nextInt(52) + 1;
        return cards[card - 1];
    }

    public static void initGame() {
        player = 0;
        dealer = 0;
        playerMessage = "Las cartas del jugador son: ";
        dealerMessage = "Las cartas del dealer son: ";

        for (int i = 0; i < 2; i++) {
            int card = drawCard();
            player += card;
            playerMessage += card + " ";
        }

        for (int i = 0; i < 2; i++) {
            int card = drawCard();
            dealer += card;
            dealerMessage += card + " ";
        }
    }

    public static void checkWinner() {
        System.out.println(playerMessage);
        System.out.println("Puntos del jugador: " + player);
        System.out.println(dealerMessage);
        System.out.println("Puntos del dealer: " + dealer);

        if (player == 21) {
            System.out.println("¡Ganaste con 21 puntos!");
        } else if (player > dealer && player <= 21) {
            System.out.println("¡Ganaste!");
        } else if (player == dealer) {
            System.out.println("Empate.");
        } else {
            System.out.println("Perdiste.");
        }
    }

    public static void main(String[] args) {
        createDeck();
        initGame();
        checkWinner();
    }
}