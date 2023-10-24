package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CustomerBean;

public class CustomerDetailDAO {

	public List<CustomerBean> getCustomerDetails(int customerId) throws ClassNotFoundException, SQLException {

		List<CustomerBean> customerDetailList = new ArrayList<>();
		String sql = "SELECT * FROM m_customer WHERE customer_id = ?";

		try {
			Connection con = ConnectionManager.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, customerId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				CustomerBean customerDetail = new CustomerBean();
				customerDetail.setId(rs.getInt("customer_id"));
				customerDetail.setName(rs.getString("customer_name"));
				customerDetail.setNameKana(rs.getString("customer_name_kana"));
				customerDetail.setPostCode(rs.getString("post_code"));
				customerDetail.setAreaCode(rs.getString("area_code"));
				customerDetail.setGender(rs.getString("gender"));
				customerDetail.setBirthday(rs.getString("birthday"));
				customerDetail.setPhoneNumber(rs.getString("phone_number"));
				customerDetail.setInsertDateTime(rs.getString("insert_datetime"));
				customerDetail.setUpdateDateTime(rs.getString("UPDATE_datetime"));

				customerDetailList.add(customerDetail);
			}

		} catch (Exception e) {

		}

		return customerDetailList;
	}
}
