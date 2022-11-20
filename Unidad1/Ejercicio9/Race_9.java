import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;

@XmlRootElement(name = "race")
@XmlAccessorType(XmlAccessType.FIELD)
public class Race_9 {
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
    @XmlElement(name = "racedate")
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate racedate;
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
    public Race_9() {
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
    public LocalDate getRacedate() {
        return racedate;
    }
    public void setRacedate(LocalDate racedate) {
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