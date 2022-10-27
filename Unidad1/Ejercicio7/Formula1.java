import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formula1 {
    private String track, driver, team;
    private int position, no, startingGrid, laps;
    private double points;
    private String extraPoint, timeRetired, fastestLap;

    public Formula1 () {

    }
    public Formula1(String track, int position, int no, String driver, String team, int startingGrid, int laps, String timeRetired, double points, String extraPoint, String fastestLap) {
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

    public String getTrack() {
        return track;
    }

    public String getDriver() {
        return driver;
    }

    public String getTeam() {
        return team;
    }

    public int getPosition() {
        return position;
    }

    public int getNo() {
        return no;
    }

    public int getStartingGrid() {
        return startingGrid;
    }

    public int getLaps() {
        return laps;
    }

    public double getPoints() {
        return points;
    }

    public String getExtraPoint() {
        return extraPoint;
    }

    public String getTimeRetired() {
        return timeRetired;
    }

    public String getFastestLap() {
        return fastestLap;
    }

    @Override
    public String toString() {
        return "Formula1{" +
                "  track='" + track +
                ", position=" + position +
                ", no=" + no +
                ", driver='" + driver +
                ", team='" + team +
                ", startingGrid=" + startingGrid +
                ", laps=" + laps +
                ", timeRetired='" + timeRetired +
                ", points=" + points +
                ", extraPoint='" + extraPoint +
                ", fastestLap=" + fastestLap +
                '}';
    }
}
