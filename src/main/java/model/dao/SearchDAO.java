package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.CustomerBean;
import model.entity.UserBean;

public class SearchDAO {

	public CustomerBean checkLogin(String searchWord) throws ClassNotFoundException, SQLException {
		// ユーザ情報を格納する変数
		CustomerBean user = null;

		// プレースホルダーのSQL文
		String sql = "SELECT * FROM m_customer WHERE _name = ?";

		
		List<CustomerBean> customerList = new Arraylist<>()
		
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
				customer.setcustomerId (res.getInt("id"));
				customer.setcustomername(res.getString("name"));
				customer.setcustomernameKana(res.getString("nameKana"));
				customer.setcustomergender(res.getString("gender"));
		
			}
		}
		return customer;
	}
}
