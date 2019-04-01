package by.epam.javatraining.rassolko.maintask02.model.entity.aircrafts;

public class CargoAirliner extends Plane
{
    // These parameters describes size of loading gates of this cargo airliner.
    // Cargo can require really lot of space
    private double loadingGateHeightMeters;
    private double loadingGateWidthMeters;  

    
    /**
     * @return the loadingGateHeightMeters
     */
    public double getLoadingGateHeightMeters()
    {
        return loadingGateHeightMeters;
    }

    /**
     * @param loadingGateHeightMeters the loadingGateHeightMeters to set
     */
    public void setLoadingGateHeightMeters(double loadingGateHeightMeters)
    {
        this.loadingGateHeightMeters = loadingGateHeightMeters;
    }

    /**
     * @return the loadingGateWidthMeters
     */
    public double getLoadingGateWidthMeters()
    {
        return loadingGateWidthMeters;
    }

    /**
     * @param loadingGateWidthMeters the loadingGateWidthMeters to set
     */
    public void setLoadingGateWidthMeters(double loadingGateWidthMeters)
    {
        this.loadingGateWidthMeters = loadingGateWidthMeters;
    }
}
