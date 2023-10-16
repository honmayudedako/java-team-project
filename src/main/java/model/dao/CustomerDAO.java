package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.CustomerBean;

public class CustomerDAO {
	public CustomerBean createCustomer(CustomerBean customer) throws ClassNotFoundException, SQLException {
	    // 顧客情報を格納する変数
		// CustomerBean customer = null;
			
	    // SQL文-新規登録
	    String sql = "INSERT INTO m_customer VALUES(?, ?, ?, ?, ?, ?, ?)";
			
	    // try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
	    try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				
	      // プレースホルダに値をセット
//	      pstmt.setString(1, );
//	      pstmt.setString(2, );
				
	      // SQL文の実行
//	      ResultSet res = pstmt.executeUpdate();
				
	      // id、passwordが一致する情報がデータベースにあれば、UserBeanをインスタンス化し、各カラムの値をインスタンスにセット
//	      if (res.next()) {
//	        
//	      }
	    }
	    return customer;
	  }
}
