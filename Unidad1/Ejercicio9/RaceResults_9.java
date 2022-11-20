public class RaceResults_9 extends TipoCarrera_9{
    private String extraPoint;
    private String fastestLap;
    public RaceResults_9(Race_9 track, int position, int no, Drivers_9 driver, Teams_9 team, int startingGrid, int laps, String timeRetired, double points, String extraPoint, String fastestLap) {
        super(track, driver, team, timeRetired, position, no, startingGrid, laps, points);
    }

    public String getExtraPoint() {
        return extraPoint;
    }

    public void setExtraPoint(String extraPoint) {
        this.extraPoint = extraPoint;
    }

    public String getFastestLap() {
        return fastestLap;
    }

    public void setFastestLap(String fastestLap) {
        this.fastestLap = fastestLap;
    }
}
