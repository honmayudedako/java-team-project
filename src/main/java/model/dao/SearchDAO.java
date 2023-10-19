package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CustomerBean;

public class SearchDAO {

	public List<CustomerBean>  SearchCustomer(String searchWord) throws ClassNotFoundException, SQLException {
		// ユーザ情報を格納する変数
		CustomerBean user = null;

		// プレースホルダーのSQL文
		String sql = "SELECT * FROM m_customer WHERE customer_name = ?";

		
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
				customer.setId (res.getInt("id"));
				customer.setName(res.getString("name"));
				customer.setNameKana(res.getString("nameKana"));
				customer.setGender(res.getString("gender"));
				customerList.add(customer);
		
			}
		}
		return customerList;
	}
}
