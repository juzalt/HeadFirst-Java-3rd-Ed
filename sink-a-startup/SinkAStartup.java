import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//page 96 Headfirst Java 3rd ed
class SinkAStartup {
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
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;
    String[] availableLetters = {"A", "B", "C", "D", "E", "F", "G"};
    int sizeOfShips = 3;
    int amountOfShips = 3;
    ArrayList<String[]> shipsLocations = new ArrayList<String[]>();
    ArrayList<Ship> ships = new ArrayList<Ship>();
    int amountOfTargetsHit = 0;

    public static void main(String[] args)
    {
        SinkAStartup game = new SinkAStartup();
        System.out.println("GAME STARTED");
    }    

    SinkAStartup() 
    {
        this.setBoard();
        this.attack();
    }

    private Ship getShip(String[] coordinates) 
    {
        return new Ship(coordinates);
    }

    private void setBoard() 
    {
        String[] shipOneLocations = {"A1", "A2", "A3"};
        String[] shipTwoLocations = {"B1", "B2", "B3"};
        String[] shipThreeLocations = {"E5", "E6", "E7"};
        this.ships.add(this.getShip(shipOneLocations));
        this.ships.add(this.getShip(shipTwoLocations));
        this.ships.add(this.getShip(shipThreeLocations));
    }

    private void attack()
    {
        System.out.println("Which coordinate do you attack?");
        try {
            boolean attackReceived = false;
            String coordinate = this.reader.readLine();
            for (Ship ship : this.ships) {
                if (Arrays.stream(ship.shipPosition).anyMatch(coordinate::equals) && !Arrays.stream(ship.shipPositionsDestroyed).anyMatch(coordinate::equals)) {
                    ship.receiveAttack(coordinate);
                    attackReceived = true;
                    this.amountOfTargetsHit = this.amountOfTargetsHit++;

                    if (this.amountOfTargetsHit == 9) {
                        System.out.println("You won!!");
                        System.exit(0);
                    }
                }
            }
            
            if (!attackReceived) {
                System.out.println("Miss...");
            }

            this.attack();
        } catch (IOException e) {
            System.out.println("That wasnt a correct coordinate.");
        }
    }
}
