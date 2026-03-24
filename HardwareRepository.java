import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HardwareRepository {

    private static final String DB_URL = "jdbc:sqlite:hardware.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(
                    "\n[ERROR] SQLite JDBC driver not found on classpath.\n" +
                            "  NetBeans : Right-click project > Properties > Libraries > Add JAR\n" +
                            "  IntelliJ : File > Project Structure > Modules > Dependencies > Add JAR\n" +
                            "  Terminal : java -cp .;sqlite-jdbc.jar Main  (Windows)\n" +
                            "             java -cp .:sqlite-jdbc.jar Main  (Mac/Linux)\n", e);
        }
    }

    // ── Fetches all rows from the database and maps them to Hardware objects ──
    public List<Hardware> getAllHardware() {
        List<Hardware> hardwareList = new ArrayList<>();

        String query = "SELECT id, brand, spec, type FROM hardware ORDER BY id;";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement  stmt = conn.createStatement();
             ResultSet  rs   = stmt.executeQuery(query)) {

            while (rs.next()) {
                int    id    = rs.getInt("id");
                String brand = rs.getString("brand");
                int    spec  = rs.getInt("spec");
                String type  = rs.getString("type");

                if ("Laptop".equalsIgnoreCase(type)) {
                    hardwareList.add(new Laptop(id, brand, spec));
                } else if ("Phone".equalsIgnoreCase(type)) {
                    hardwareList.add(new Phone(id, brand, spec));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "\n[ERROR] Could not read from database.\n" +
                            "Make sure you have run hardware.sql first to set up the database.\n", e);
        }

        return hardwareList;
    }
}
