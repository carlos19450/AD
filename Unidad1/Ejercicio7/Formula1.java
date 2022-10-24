import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formula1 {
    private String track, driver, team;
    private int position, no, startingGrid, laps;
    private float points;
    private String extraPoint, timeRetired, fastestLap;

    public Formula1(String track, int position, int no, String driver, String team, int startingGrid, int laps, String timeRetired, float points, String extraPoint, String fastestLap) {
        this.track = track;
        this.driver = driver;
        this.team = team;
        this.position = position;
        this.no = no;
        this.startingGrid = startingGrid;
        this.laps = laps;
        this.timeRetired = timeRetired;
        this.points = points;
        this.extraPoint = extraPoint;
        this.fastestLap = fastestLap;
    }

    @Override
    public String toString() {
        return "Formula1{" +
                "  track='" + track + '\'' +
                ", driver='" + driver + '\'' +
                ", team='" + team + '\'' +
                ", position=" + position +
                ", no=" + no +
                ", startingGrid=" + startingGrid +
                ", laps=" + laps +
                ", points=" + points +
                ", extraPoint='" + extraPoint + '\'' +
                ", timeRetired='" + timeRetired + '\'' +
                ", fastestLap=" + fastestLap +
                '}';
    }
}
