package DAL;

import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class DAO {

    //Constructor, getter and setter============================================
    public static DAO INSTANCE = new DAO();
    private Connection con;
    private String status;

    private DAO() {
        if (INSTANCE == null) {
            try {
                con = DBContext.makeConnection();
            } catch (ClassNotFoundException | SQLException e) {
                status = "Error at Connection" + e.getMessage();
            }
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User checkLogin(String text, String password) {
        String sql = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, text);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), 
                        rs.getString(3), rs.getString(4), 
                        rs.getString(5), rs.getString(6), rs.getDate(7),
                        rs.getBoolean(8), rs.getString(9), rs.getInt(10), rs.getString(11));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

}
