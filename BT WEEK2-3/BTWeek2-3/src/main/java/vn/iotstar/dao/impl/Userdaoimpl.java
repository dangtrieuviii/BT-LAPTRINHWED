package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.BDConnectMySQL;
import vn.iotstar.dao.IUserdao;
import vn.iotstar.models.UserModel;

public class Userdaoimpl extends BDConnectMySQL implements IUserdao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "select * from users";
		List<UserModel> list = new ArrayList<>();
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("fullname"), rs.getString("images"), rs.getString("password")));
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		UserModel user = null;
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id); // Thiết lập giá trị cho tham số id trong câu lệnh SQL
			rs = ps.executeQuery();

			// Kiểm tra kết quả truy vấn
			if (rs.next()) {
				user = new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("fullname"), rs.getString("images"), rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user; // Trả về đối tượng UserModel hoặc null nếu không tìm thấy
	}

	@Override
	public void insert(UserModel user) {
		String Bigger_ID = "SELECT MAX(id) FROM users";
		String insertSql = "INSERT INTO users(id, username, email, fullname, images, password) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(Bigger_ID);
			rs = ps.executeQuery();
			int newId = 1;
			if (rs.next()) {
				newId = rs.getInt(1) + 1;
			}
			rs.close();
			ps.close();

			ps = conn.prepareStatement(insertSql);
			ps.setInt(1, newId);
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getImages());
			ps.setString(6, user.getPassword());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		/*
		 * Userdaoimpl userdao = new Userdaoimpl(); List<UserModel> list =
		 * userdao.findAll(); for (UserModel user : list) {
		 * 
		 * System.out.println(user); }
		 */

		Userdaoimpl userDao = new Userdaoimpl();
		userDao.insert(new UserModel("Khai", "khai@gmail.com", "Duy Khai", "null", "6758"));
		List<UserModel> list = userDao.findAll();
		for (UserModel user : list) {
			System.out.println(user);
		}

		/*
		 * Userdaoimpl userdao = new Userdaoimpl(); int id = 3; UserModel user =
		 * userdao.findById(id); if (user != null) { System.out.println("User found: " +
		 * user); } else { System.out.println("User not found with ID: " + id); }
		 */

	}

}
