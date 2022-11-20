public class TipoCarrera_9 {
    private Race_9 track;
    private Drivers_9 driver;
    private Teams_9 team;
    private String timeRetired;
    private int position;
    private int no;
    private int startingGrid;
    private int laps;
    private double points;

    public TipoCarrera_9(Race_9 track, Drivers_9 driver, Teams_9 team, String timeRetired, int position, int no, int startingGrid, int laps, double points) {
        this.track = track;
        this.driver = driver;
        this.team = team;
        this.timeRetired = timeRetired;
        this.position = position;
        this.no = no;
        this.startingGrid = startingGrid;
        this.laps = laps;
        this.points = points;
    }

    public Race_9 getTrack() {
        return track;
    }

    public void setTrack(Race_9 track) {
        this.track = track;
    }

    public Drivers_9 getDriver() {
        return driver;
    }

    public void setDriver(Drivers_9 driver) {
        this.driver = driver;
    }

    public Teams_9 getTeam() {
        return team;
    }

    public void setTeam(Teams_9 team) {
        this.team = team;
    }

    public String getTimeRetired() {
        return timeRetired;
    }

    public void setTimeRetired(String timeRetired) {
        this.timeRetired = timeRetired;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getStartingGrid() {
        return startingGrid;
    }

    public void setStartingGrid(int startingGrid) {
        this.startingGrid = startingGrid;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "TipoCarrera{" +
                "track=" + track +
                ", driver='" + driver + '\'' +
                ", team='" + team + '\'' +
                ", timeRetired='" + timeRetired + '\'' +
                ", position=" + position +
                ", no=" + no +
                ", startingGrid=" + startingGrid +
                ", laps=" + laps +
                ", points=" + points +
                '}';
    }
}
