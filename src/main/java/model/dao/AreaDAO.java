package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.AreaBean;


public class AreaDAO {

	public static List<AreaBean> areaList() throws ClassNotFoundException, SQLException {
		
		List<AreaBean> areaList = new ArrayList<>();
		
		
		// SQL文 
		String sql = "select * from m_area order by area_code;";

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// SQL文の実行
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				AreaBean area = new AreaBean();
				area.setCode(res.getString("area_code"));
				area.setName(res.getString("area_name"));
				areaList.add(area);
			}
		}
		return areaList;
	}

}

