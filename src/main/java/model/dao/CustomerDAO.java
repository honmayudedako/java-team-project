package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.CustomerBean;

public class CustomerDAO {
	public void createCustomer(CustomerBean customer) throws ClassNotFoundException, SQLException {

		// SQL文-新規登録 
		String sql = "INSERT INTO m_customer (customer_name, customer_name_kana, post_code, area_code, gender, birthday, phone_number) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getNameKana());
			pstmt.setString(3, customer.getPostCode());
			pstmt.setString(4, customer.getAreaCode());
			pstmt.setString(5, customer.getGender());
			pstmt.setString(6, customer.getBirthday());
			pstmt.setString(7, customer.getPhoneNumber());

			// SQL文の実行
			pstmt.executeUpdate();

		}
		return;
	}
}
