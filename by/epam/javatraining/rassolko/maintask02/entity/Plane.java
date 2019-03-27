package by.epam.javatraining.rassolko.entity;

public abstract class Plane extends HeavierThanAirAircraft
{
    private int runwayLength;
    

    /**
     * @return the minimalRunwayLengthInMeters
     */
    public int getRunwayLength()
    {
        return runwayLength;
    }

    /**
     * @param minimalRunwayLengthInMeters the minimalRunwayLengthInMeters to set
     */
    public void setRunwayLength(int minimalRunwayLengthInMeters)
    {
        this.runwayLength = minimalRunwayLengthInMeters;
    }
    
}
