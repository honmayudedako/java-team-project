package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CustomerBean;

public class CustomerDAO {
	//顧客の新規登録
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

	//顧客情報を編集
	public void editCustomer(CustomerBean customer) throws ClassNotFoundException, SQLException {

		// SQL文-編集
		String sql = "UPDATE m_customer SET customer_name = ?, customer_name_kana = ? , post_code = ?, area_code = ?, gender = ?, birthday = ?, phone_number = ? where customer_id = ?";

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
			pstmt.setInt(8, customer.getId());

			// SQL文の実行
			pstmt.executeUpdate();

		}
		return;
	}

	CustomerBean checkLogin(String id, String name, String nameKana, String postCode, String areaCode, String gender,
			String birthday, String phoneNumber, String insertDatetime, String updateDatetime)
			throws ClassNotFoundException, SQLException {
		// 顧客情報を格納する変数
		CustomerBean customer = null;

		// プレースホルダーのSQL文
		String sql = "SELECT * FROM m_customer WHERE customer_id = ? AND customer_name = ? AND customer_name_kana = ? AND post_code = ? AND area_code = ? AND gender = ? AND birthday = ? AND phone_number = ? AND = insert_datetime = ? AND UPDATE_datetime = ?";

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, nameKana);
			pstmt.setString(4, postCode);
			pstmt.setString(5, areaCode);
			pstmt.setString(6, gender);
			pstmt.setString(7, birthday);
			pstmt.setString(8, phoneNumber);
			pstmt.setString(9, insertDatetime);
			pstmt.setString(9, updateDatetime);

			// SQL文の実行
			ResultSet res = pstmt.executeQuery();

			// 一致する情報がデータベースにあれば、CustomerBeanをインスタンス化し、各カラムの値をインスタンスにセット
			if (res.next()) {
				customer = new CustomerBean();
				//        customer.setUserId(res.getString("cusomer_id"));
				//        customer.setPassword(res.getString("customer_name"));
				//        customer.setUserId(res.getString("customer_name_kana"));
				//        customer.setPassword(res.getString("post_code"));
				//        customer.setUserId(res.getString("area_code"));
				//        customer.setPassword(res.getString("gender"));
				//        customer.setUserId(res.getString("birthday"));
				//        customer.setPassword(res.getString("phone_number"));
				//        customer.setUserId(res.getString("insert_datetime"));
				//        customer.setPassword(res.getString("UPDATE_datetime"));
			}
		}
		return customer;
	}

	//顧客を削除
	public static void deleteCustomer(String customerId) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM m_customer WHERE customer_id = ?";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setString(1, customerId);
			// SQL文の実行
			pstmt.executeUpdate();

		}
	}

	// 顧客一覧を取得
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

	//IDで顧客を取得
	public CustomerBean IDSearchCustomer(int id) throws ClassNotFoundException, SQLException {
		// SQL文 顧客のIDで検索
		String sql = "SELECT * FROM m_customer WHERE customer_id = ?";

		CustomerBean customer = new CustomerBean();

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setInt(1, id);

			// SQL文の実行の結果をresに代入
			ResultSet res = pstmt.executeQuery();

			if (res.next()) {

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
	}
}
