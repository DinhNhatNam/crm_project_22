package crm_project.reposivetory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm_project.confic.MysqlConfig;
import crm_project.entity.LoaiThanhVien;
import crm_project.entity.NguoiDung;

// class tạo theo tên bảng để quản lý tất cả các câu query liên quan
//findBy dành cho câu select có điều kiện where
public class NguoiDungReposivetory {
	public List<NguoiDung> findByEmailAndPass(String email, String pass) {
		 List<NguoiDung> list = new ArrayList<NguoiDung>();
		String query = "Select * from NguoiDung nd join LoaiThanhVien ltv ON nd.id =ltv .id \r\n"
				+ "\r\n"
				+ "where nd.email = ? and nd.matkhau= ?";

		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, email);
			statement.setString(2, pass);
			/*
			 * excuteQuery; dùng khi câu truy vấn trả ra dữ liệu excuteUpdate; truy vấn ko
			 * trả dữ liệu
			 * 
			 */
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				NguoiDung ng = new NguoiDung();
				LoaiThanhVien loaithanhvien = new LoaiThanhVien();
				ng.setId(resultSet.getInt("id"));
				ng.setFullname(resultSet.getString("fullname"));
				ng.setEmail(resultSet.getString("matkhau"));	
				loaithanhvien.setName(resultSet.getString("ten"));
				ng.setLoaithanhvien(loaithanhvien);
				list.add(ng);
			}
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("lỗi thực thi" + e.getLocalizedMessage());
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.err.println("lỗi đóng kết nối " + e.getLocalizedMessage());
				}
		}
		
		return list;
	}
	
//	public int FindLoaiThanhVien() {
//		String
//	}
}
