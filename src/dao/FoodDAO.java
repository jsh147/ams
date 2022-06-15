package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.FoodDTO;
import dto.ManagerDTO;

public class FoodDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public FoodDAO() {
		conn = DBConnection.getConnection();
	}

	public boolean addFood(FoodDTO newFood) {
		String sql = "insert into food (foodname,foodamount,foodexpdate) values(?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newFood.foodname);
			ps.setInt(2, newFood.foodamount);
			ps.setString(3, newFood.foodexpdate);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}return false;
	}

	public ArrayList<FoodDTO> getList() {
		String userid = ((ManagerDTO)Session.getData("loginManager")).MarmyCode;
		ArrayList<FoodDTO> result = new ArrayList<FoodDTO>();
		String sql = "select * from food where userid = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FoodDTO f = new FoodDTO();
				f.foodname = rs.getString("foodname" );
				f.foodamount = rs.getInt("foodamount" );
				f.foodexpdate = rs.getString("foodexpdate");
			
				result.add(f);
			}
		} catch (SQLException e) {
		}
		
		
		return result;
	}

	public boolean removeFood(String foodname) {
		String sql = "delete from food where foodname = "+foodname;
		try {
			ps = conn.prepareStatement(sql);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean modifyFood(String foodname, int choice, String newData) {
			String sql = "";
		String[] cols = {"","foodexpdate"};
		try {
			switch(choice) {
			case 1: 
				sql = "update food set "+cols[choice]+" = ? where foodname="+foodname;
				ps = conn.prepareStatement(sql);
				ps.setString(1, newData);
				break;
			case 3:
				sql = "update food set foodamount where foodname="+foodname;
				ps = conn.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(newData));
				break;
			}
			return ps.executeUpdate() == 1;
		} catch (NumberFormatException e) {
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean removeAll(String foodname) {
		String sql = "delete from food where foodname = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, foodname);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	public ArrayList<FoodDTO> search(String keyword) {
		ArrayList<FoodDTO> result = new ArrayList<FoodDTO>();
		String sql = "select * from food where foodname like('%"+keyword+"%')";
		try {
			ps = conn.prepareStatement(sql);		
			rs = ps.executeQuery();
			while(rs.next()) {
				FoodDTO f = new FoodDTO();
				f.foodname = rs.getString("foodname" );
				f.foodamount = rs.getInt("foodamount" );
				f.foodexpdate = rs.getString("foodexpdate");
			
				result.add(f);
			}
		} catch (SQLException e) {
		}
		
		return result;
	}
	
}


