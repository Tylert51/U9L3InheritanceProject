import java.io.Serializable;
import java.util.UUID;


public class LVM implements Serializable {
    private String name;
    private UUID ID;

    public LVM (String n) {
        name = n;
        ID = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public UUID getUUID() {
        return ID;
    }

}
