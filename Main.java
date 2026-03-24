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
 
     for (Hardware h : list) {
            String type = (h instanceof Laptop) ? "Laptop" : "Phone";
            System.out.printf("%-4d %-20s %-10s %-20s%n",
                    h.getId(),
                    h.getBrand(),
                    type,
                    h.getInterpretation());
        }
        System.out.println("============================================");
    }
 // ── Prints the Laptop and Phone Inventory ─────────────────────────────────
    private static void printInventory(List<Hardware> list) {
        System.out.println("============================================");
        System.out.println("       LAPTOP AND PHONE INVENTORY           ");
        System.out.println("============================================");

        Map<String, Integer> laptopCounts = new LinkedHashMap<>();
        Map<String, Integer> phoneCounts  = new LinkedHashMap<>();

        // Single polymorphic loop using instanceof
        for (Hardware h : list) {
            if (h instanceof Laptop) {
                String key = h.getInterpretation();
                laptopCounts.put(key, laptopCounts.getOrDefault(key, 0) + 1);
            } else if (h instanceof Phone) {
                String key = h.getInterpretation();
                phoneCounts.put(key, phoneCounts.getOrDefault(key, 0) + 1);
            }
        }
    }
