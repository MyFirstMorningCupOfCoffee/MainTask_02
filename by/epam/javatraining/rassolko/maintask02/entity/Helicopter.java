package by.epam.javatraining.rassolko.entity;


public class Helicopter extends HeavierThanAirAircraft
{
    private int seats;


    /**
     * @return the seats quantity
     */
    public int getSeats()
    {
        return seats;
    }

    /**
     * @param seats the seats quantity to set
     */
    public void setSeats(int seats)
    {
        this.seats = seats;
    }
    
}
