package by.epam.javatraining.rassolko.maintask02.model.entity.aircrafts;

public class PassengerAirliner extends Plane
{
    // number of passenger seats in current passenger airliner
    private int seats;

    /**
     * @return the seats
     */
    public int getSeats()
    {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(int seats)
    {
        this.seats = seats;
    }
    
}
