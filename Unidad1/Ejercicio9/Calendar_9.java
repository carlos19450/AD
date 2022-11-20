
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "calendar")
@XmlAccessorType(XmlAccessType.FIELD)
public class Calendar_9 {
    @XmlElement(name = "race")
    private ArrayList<Race_9> races = new ArrayList<>();

    public Calendar_9() {
    }

    public ArrayList<Race_9> getRaces() {
        return races;
    }
}