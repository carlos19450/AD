import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "calendar")
@XmlAccessorType(XmlAccessType.FIELD)
public class Calendar {
    @XmlElement(name = "race")
    private ArrayList<Race> races = new ArrayList<>();

    public Calendar() {
    }

    public ArrayList<Race> getRaces() {
        return races;
    }
}