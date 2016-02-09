package atkmanager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adinb
 */
public class Statistic {
    DBHelper db = new DBHelper();
    ArrayList <Integer> numbers;
    
    public ArrayList <Integer> yearlyUsageStatistics(int year, ATK item) {
        ArrayList <Integer> yearlyStatistics = new ArrayList(12);
        String sql;
        for (int month = 1; month <= 12; month++) {
            sql = "SELECT SUM(jumlah) as total FROM pesananATK WHERE strftime('%Y-%m', tanggal_pesanan) = '0" + year + "-0" + month + "' AND id_atk = " + item.getID() + ";";
            ResultSet rs = db.runQuery(sql);
            try {
                if(rs.next()) {
                    yearlyStatistics.add(rs.getInt("total"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return yearlyStatistics;
    }
    
}
