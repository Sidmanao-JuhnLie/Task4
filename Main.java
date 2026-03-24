import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HardwareRepository repository = new HardwareRepository();
        List<Hardware> hardwareList   = repository.getAllHardware();

        printMasterlist(hardwareList);
        System.out.println();
        printInventory(hardwareList);
    }
}
