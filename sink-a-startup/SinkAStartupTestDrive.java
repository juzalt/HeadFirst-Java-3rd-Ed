public class SinkAStartupTestDrive {
    public static void main() {
        /** 
         *   1  2  3  4  5  6  7
         * A A1 2A 3A 4A 5A 6A 7A
         * B B1 ... et c
         * C C1 C2 ... et c
         * D et c
         * E
         * F
         * G
         * 
         */

        SinkAStartup game = new SinkAStartup();

        String[] ship_1Location = {"A1", "A2", "A3"};
        String[] ship_2Location = {"B1", "B2", "B3"};
        String[] ship_3Location = {"E5", "E6", "E7"};
        Ship ship_1 = new Ship(ship_1Location);
        Ship ship_2 = new Ship(ship_2Location);
        Ship ship_3 = new Ship(ship_3Location);
        game.setBoard(ship_1.shipPosition, ship_2.shipPosition, ship_3.shipPosition);

        String[] failedAttack = {"A1", "A2", "A7"};
        game.attack(ship_1.shipPosition);
        game.attack(failedAttack);
        game.attack(ship_2.shipPosition);
        game.attack(ship_3.shipPosition);
        System.out.println("********* Test finished. *********");
    }
}
