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
 private static void printMasterlist(List<Hardware> list) {
        System.out.println("============================================");
        System.out.println("           HARDWARE MASTERLIST              ");
        System.out.println("============================================");
        System.out.printf("%-4s %-20s %-10s %-20s%n", "ID", "Brand", "Type", "Specification");
        System.out.println("--------------------------------------------");
}
