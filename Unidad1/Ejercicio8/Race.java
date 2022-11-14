import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//@XmlRootElement(name = "race")
//@XmlType(propOrder = {"round", "country", "city", "circuitname", "gpname", "racedate", "firstgp", "numberoflaps", "circuitlength", "racedistance", "laprecord", "recordowner", "recordyear", "turns", "drszones"})
public class Race {
    @XmlAttribute(name = "round")
    private String round;
    @XmlElement(name = "country")
    private String country;
    @XmlElement(name = "city")
    private String city;
    @XmlElement(name = "circuitname")
    private String circuitname;
    @XmlElement(name = "gpname")
    private String gpname;
    @XmlElement(name = "racedate", required = true)
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private String racedate;
    @XmlElement(name = "laprecord")
    private String laprecord;
    @XmlElement(name = "recordowner")
    private String recordowner;
    @XmlElement(name = "firstgp")
    private int firstgp;
    @XmlElement(name = "numberoflaps")
    private int numberoflaps;
    @XmlElement(name = "recordyear")
    private int recordyear;
    @XmlElement(name = "turns")
    private int turns;
    @XmlElement(name = "drszones")
    private int drszones;
    @XmlElement(name = "circuitlength")
    private float circuitlength;
    @XmlElement(name = "racedistance")
    private float racedistance;
    public Race() {
    }


    public String getRound() {
        return round;
    }
    public void setRound(String round) {
        this.round = round;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCircuitname() {
        return circuitname;
    }
    public void setCircuitname(String circuitname) {
        this.circuitname = circuitname;
    }
    public String getGpname() {
        return gpname;
    }
    public void setGpname(String gpname) {
        this.gpname = gpname;
    }
    public String getRacedate() {
        return racedate;
    }
    public void setRacedate(String racedate) {
        this.racedate = racedate;
    }
    public String getLaprecord() {
        return laprecord;
    }
    public void setLaprecord(String laprecord) {
        this.laprecord = laprecord;
    }
    public String getRecordowner() {
        return recordowner;
    }
    public void setRecordowner(String recordowner) {
        this.recordowner = recordowner;
    }
    public int getFirstgp() {
        return firstgp;
    }
    public void setFirstgp(int firstgp) {
        this.firstgp = firstgp;
    }
    public int getNumberoflaps() {
        return numberoflaps;
    }
    public void setNumberoflaps(int numberoflaps) {
        this.numberoflaps = numberoflaps;
    }
    public int getRecordyear() {
        return recordyear;
    }
    public void setRecordyear(int recordyear) {
        this.recordyear = recordyear;
    }
    public int getTurns() {
        return turns;
    }
    public void setTurns(int turns) {
        this.turns = turns;
    }
    public int getDrszones() {
        return drszones;
    }
    public void setDrszones(int drszones) {
        this.drszones = drszones;
    }
    public float getCircuitlength() {
        return circuitlength;
    }
    public void setCircuitlength(float circuitlength) {
        this.circuitlength = circuitlength;
    }
    public float getRacedistance() {
        return racedistance;
    }
    public void setRacedistance(float racedistance) {
        this.racedistance = racedistance;
    }
}