import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "drivers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Drivers {
    @XmlElement(name = "driver")
    private ArrayList<Piloto> drivers = new ArrayList<>();

    public Drivers() {
    }

    public ArrayList<Piloto> getDrivers() {
        return drivers;
    }
}