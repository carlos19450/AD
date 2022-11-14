import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "calendar")
public class Calendar {
    private ArrayList<Race> races = new ArrayList<>();

    public Calendar() {
    }

    @XmlElement(name = "race")
    public ArrayList<Race> getRaces() {
        return races;
    }

    public void setRaces(ArrayList<Race> races) {
        this.races = races;
    }
}