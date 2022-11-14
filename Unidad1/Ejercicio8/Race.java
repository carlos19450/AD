import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "race")
@XmlType(propOrder = {"round", "country", "city", "circuitname", "gpname", "racedate", "firstgp", "numberoflaps", "circuitlength", "racedistance", "laprecord", "recordowner", "recordyear", "turns", "drszones"})
public class Race {
    private String round, country, city, circuitname, gpname, racedate, laprecord, recordowner;
    private int firstgp, numberoflaps, recordyear, turns, drszones;
    private float circuitlength, racedistance;
    public Race() {
    }

    @XmlAttribute(name = "round")
    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }
    @XmlElement(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    @XmlElement(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @XmlElement(name = "circuitname")
    public String getCircuitname() {
        return circuitname;
    }

    public void setCircuitname(String circuitname) {
        this.circuitname = circuitname;
    }
    @XmlElement(name = "gpname")
    public String getGpname() {
        return gpname;
    }

    public void setGpname(String gpname) {
        this.gpname = gpname;
    }
    @XmlElement(name = "racedate")
    public String getRacedate() {
        return racedate;
    }

    public void setRacedate(String racedate) {
        this.racedate = racedate;
    }
    @XmlElement(name = "laprecord")
    public String getLaprecord() {
        return laprecord;
    }

    public void setLaprecord(String laprecord) {
        this.laprecord = laprecord;
    }
    @XmlElement(name = "recordowner")
    public String getRecordowner() {
        return recordowner;
    }

    public void setRecordowner(String recordowner) {
        this.recordowner = recordowner;
    }
    @XmlElement(name = "firstgp")
    public int getFirstgp() {
        return firstgp;
    }

    public void setFirstgp(int firstgp) {
        this.firstgp = firstgp;
    }
    @XmlElement(name = "numberoflaps")
    public int getNumberoflaps() {
        return numberoflaps;
    }

    public void setNumberoflaps(int numberoflaps) {
        this.numberoflaps = numberoflaps;
    }
    @XmlElement(name = "recordyear")
    public int getRecordyear() {
        return recordyear;
    }

    public void setRecordyear(int recordyear) {
        this.recordyear = recordyear;
    }
    @XmlElement(name = "turns")
    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }
    @XmlElement(name = "drszones")
    public int getDrszones() {
        return drszones;
    }

    public void setDrszones(int drszones) {
        this.drszones = drszones;
    }
    @XmlElement(name = "circuitlength")
    public float getCircuitlength() {
        return circuitlength;
    }

    public void setCircuitlength(float circuitlength) {
        this.circuitlength = circuitlength;
    }
    @XmlElement(name = "racedistance")
    public float getRacedistance() {
        return racedistance;
    }

    public void setRacedistance(float racedistance) {
        this.racedistance = racedistance;
    }
}