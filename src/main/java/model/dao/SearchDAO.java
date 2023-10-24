package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CustomerBean;

public class SearchDAO {

	public List<CustomerBean> SearchCustomer(String searchWord) throws ClassNotFoundException, SQLException {
		// SQL文 顧客の名前で検索
		searchWord = "%" + searchWord + "%";
		String sql = "SELECT * FROM m_customer WHERE customer_name LIKE ?";

		List<CustomerBean> customerList = new ArrayList<>();

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setString(1, searchWord);

			// SQL文の実行の結果をresに代入
			ResultSet res = pstmt.executeQuery();

			// id、passwordが一致する情報がデータベースにあれば、UserBeanをインスタンス化し、各カラムの値をインスタンスにセット
			while (res.next()) {
				CustomerBean customer = new CustomerBean();
				customer.setId(res.getInt("customer_id"));
				customer.setName(res.getString("customer_name"));
				customer.setNameKana(res.getString("customer_name_kana"));
				customer.setGender(res.getString("gender"));
				customerList.add(customer);
			}
		}
		return customerList;
	}

	public CustomerBean IDSearchCustomer(String id) throws ClassNotFoundException, SQLException {
		// SQL文 顧客のIDで検索
		String sql = "SELECT * FROM m_customer WHERE customer_id = ?";

		CustomerBean customer = new CustomerBean();

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setString(1, id);

			// SQL文の実行の結果をresに代入
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
			
				customer.setId(res.getInt("customer_id"));
				customer.setName(res.getString("customer_name"));
				customer.setNameKana(res.getString("customer_name_kana"));
				customer.setPostCode(res.getString("post_code"));
				customer.setAreaCode(res.getString("area_code"));
				customer.setBirthday(res.getString("birthday"));
				customer.setPhoneNumber(res.getString("phone_number"));
				customer.setGender(res.getString("gender"));
				
			} else {
				return null;
			}
		}
			
		return customer;
}}
