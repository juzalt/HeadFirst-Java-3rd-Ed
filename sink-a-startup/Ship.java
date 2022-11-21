import java.util.Arrays;

public class Ship {
    String[] shipPosition = {};
    String[] shipPositionsDestroyed = new String[2];


    public String[] getShipPosition() {
        return shipPosition;
    }

    private void setShipPosition(String[] shipPosition) {
        this.shipPosition = shipPosition;
    }

    public void receiveAttack(String coordinates)
    {
        this.shipPositionsDestroyed[Arrays.asList(this.shipPosition).indexOf(coordinates)] = coordinates;
        System.out.println("Hit!");
    }

    public Ship(String[] shipPosition)
    {
        this.setShipPosition(shipPosition);
    }
}
