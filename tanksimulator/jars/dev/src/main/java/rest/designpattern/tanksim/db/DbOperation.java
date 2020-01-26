package rest.designpattern.tanksim.db;

/*import clari5.platform.applayer.Clari5;
import clari5.platform.dbcon.CxConnection;
import clari5.platform.rdbms.RDBMS;

import java.sql.PreparedStatement;
import java.sql.SQLException;*/

public class DbOperation {
    /**
     * (0) returns nothing
     * (1) return the success result.
     * @param random
     * @param tankName
     * @return
     */
/*    public static int inertIntoTankSimulator(int random, String tankName) {
        int res = 0;
        String sql = "INSERT INTO TANK_SIMULATOR (TANK_NAME, LEVEL) VALUES(?,?)";
        try (CxConnection connection = getConnection()){
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                res = ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static CxConnection getConnection() {
        RDBMS rdbms = (RDBMS) Clari5.rdbms();
        if (rdbms == null) throw new RuntimeException("RDBMS as a resource is unavailable");
        return rdbms.getCxConnection();
    }*/
}
