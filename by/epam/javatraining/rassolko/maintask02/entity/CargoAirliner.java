package by.epam.javatraining.rassolko.entity;

public class CargoAirliner extends Plane
{
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
