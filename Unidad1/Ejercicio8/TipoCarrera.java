public class TipoCarrera {
    private Race track;
    private String driver;
    private String team;
    private String timeRetired;
    private int position;
    private int no;
    private int startingGrid;
    private int laps;
    private double points;

    public TipoCarrera(Race track, String driver, String team, String timeRetired, int position, int no, int startingGrid, int laps, double points) {
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

    public Race getTrack() {
        return track;
    }

    public void setTrack(Race track) {
        this.track = track;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
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
}
