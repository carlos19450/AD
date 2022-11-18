public class RaceResults extends TipoCarrera{
    private String extraPoint;
    private String fastestLap;
    public RaceResults(Race track, int position, int no, String driver, String team, int startingGrid, int laps, String timeRetired, double points, String extraPoint, String fastestLap) {
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
