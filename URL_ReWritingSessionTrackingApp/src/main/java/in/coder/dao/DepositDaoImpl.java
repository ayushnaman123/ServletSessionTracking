package in.coder.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.coder.dto.Deposit;
import in.coder.util.JdbcUtil;

public class DepositDaoImpl implements IDepositDao {

	private final String sqlInsertQuery = "Insert into deposit(`accNumber`, `accName`, `accType`, `accBranch`, `depName`, `depAmount`) value(?,?,?,?,?,?)";

	@Override
	public String doInsert(Deposit deposit) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		String status=null;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection!=null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			
		    if(pstmt!=null) {
		    	pstmt.setString(1, deposit.getAccountNo());
		    	pstmt.setString(2, deposit.getAccountName());
		    	pstmt.setString(3, deposit.getAccountType());
		    	pstmt.setString(4, deposit.getAccountBranch());
		    	pstmt.setString(5, deposit.getDepositorName());
		    	pstmt.setInt(6, deposit.getDepositorAmount());
		    	
		    	int rowsAffected = pstmt.executeUpdate();
		    	
		    	if(rowsAffected==1)
		    		status="success";
		    	else
		    		status="failure";
		    }
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}

}
