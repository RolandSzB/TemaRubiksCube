package tema.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tema.helpers.*;
import tema.pojo.*;

public class RubicDAO {

	public static ArrayList<Rubic> getAll() throws SQLException {
		ArrayList<Rubic> result = new ArrayList<Rubic>();
		Connection conn = RubicHelper.getConnection();
		Statement stmt = conn.createStatement();
		String query = "select * from rubikscube";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Rubic s = new Rubic();
			s.setId(rs.getInt("id"));
			s.setBrand(rs.getString("brand"));
			s.setWeight(rs.getDouble("weight"));
			s.setSides(rs.getInt("sides"));
			s.setManufactured(rs.getDate("manufactured"));
			result.add(s);
		}

		return result;
	}

	public static Rubic getById(int id) throws SQLException {
		Rubic result = null;
		Connection conn = RubicHelper.getConnection();
		String query = "select * from rubikscube where id=?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			result = new Rubic();
			result.setId(rs.getInt("id"));
			result.setBrand(rs.getString("brand"));
			result.setWeight(rs.getDouble("weight"));
			result.setSides(rs.getInt("sides"));
			result.setManufactured(rs.getDate("manufactured"));
		}
		return result;
	}

	// insert
	public static void create(Rubic r) throws SQLException {
		Connection c=  RubicHelper.getConnection();
		String query = "insert into rubikscube (brand, weight, sides, manufactured) values (?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, r.getBrand());
		ps.setDouble(2, r.getWeight());
		ps.setInt(3, r.getSides());
		ps.setDate(4, r.getManufactured());
		ps.executeUpdate();
		System.out.println("S-a inserat cu succes "+ r.getBrand());
				
	}
	
	// delete
	public static String delete(String brand) throws SQLException {
		Connection c = RubicHelper.getConnection();
		String deleteQuery = "delete from rubikscube where brand=?";
		PreparedStatement ps = c.prepareStatement(deleteQuery);
		ps.setString(1, brand);
		int deleted = ps.executeUpdate();

		return deleted == 0 ? "Nu a fost sters nici-o inregistrare"
				: "A fost sters cu succes " + deleted + " inregistrari";

	}

	// update
	public static boolean update(Rubic r) throws SQLException {

		Connection c = RubicHelper.getConnection();
		String query = "update rubikscube set brand=?, weight=?, sides=? , manufactured=? where id=?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, r.getBrand());
		ps.setDouble(2, r.getWeight());
		ps.setInt(3, r.getSides());
		ps.setDate(4,r.getManufactured());
		ps.setInt(5, r.getId());

		int ar = ps.executeUpdate();

		return ar == 0 ? false : true;

	}
	
}
