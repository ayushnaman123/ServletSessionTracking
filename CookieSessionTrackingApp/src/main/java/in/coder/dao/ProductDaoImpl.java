package in.coder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.coder.dto.Product;
import in.coder.util.JdbcUtil;

public class ProductDaoImpl implements IProductDao {
	private final String sqlInsertQuery = "Insert into products(`pName`,`pCost`,`pBrand`,`pQuantity`,`pCategory`,`pManufacturer`) value(?,?,?,?,?,?)";

	@Override
	public String insertProduct(Product product) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		String status = null;
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			if (pstmt != null) {
				pstmt.setString(1, product.getpName());
				pstmt.setInt(2, product.getpCost());
				pstmt.setString(3, product.getpBrand());
				pstmt.setInt(4, product.getpQuantity());
				pstmt.setString(5, product.getpCategory());
				pstmt.setString(6, product.getpManufacturer());

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected == 1)
					status = "success";
				else
					status = "failure";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	
    
	
}
