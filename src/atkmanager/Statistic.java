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
    DBHelper db;
    ArrayList <Integer> numbers;
    ArrayList <Integer> ids;
    
    public Statistic() {
        db = DBHelper.getInstance();
    }
    
    public void itemUsageStatistics(int year, ATK item) {
        //ArrayList <Integer> usageStatistics = null;//new ArrayList(12);
        numbers = new ArrayList();
        String sql;
        for (int month = 1; month <= 12; month++) {
            sql = "SELECT SUM(jumlah) as total FROM pesananATK WHERE strftime('%Y-%m', tanggal_pesanan) = '0" + year + "-0" + month + "' AND id_atk = " + item.getID() + ";";
            ResultSet rs = db.runQuery(sql);
            try {
                if(rs.next()) {
                    numbers.add(rs.getInt("total"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void userItemStatistics(int year, int month, User user) {
        numbers = new ArrayList();
        ids = new ArrayList();
        String sql;
        
        sql = "SELECT DISTINCT id_atk, SUM(jumlah) as total FROM pesananATK WHERE strftime('%Y-%m', tanggal_pesanan) = '0" + year + "-0" + month + "' AND id_pemesan = " + user.getID() + ";";
        ResultSet rs = db.runQuery(sql);
        try {
            while(rs.next()) {
                numbers.add(rs.getInt("total"));
                ids.add(rs.getInt("id_atk"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
