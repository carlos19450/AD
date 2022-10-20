public class Formula1 {
    private String track, driver, team;
    private int position, no, startingGrid, laps, points;
    private boolean extraPoint;

    public Formula1(String track, int position, int no, String driver, String team, int startingGrid, int laps, /*String timeRetired,*/ int points /*,boolean extraPoint,*//*boolean FastestLap*/) {
        this.track = track;
        this.driver = driver;
        this.team = team;
        this.position = position;
        this.no = no;
        this.startingGrid = startingGrid;
        this.laps = laps;
        this.points = points;
        this.extraPoint = extraPoint;
    }
}
