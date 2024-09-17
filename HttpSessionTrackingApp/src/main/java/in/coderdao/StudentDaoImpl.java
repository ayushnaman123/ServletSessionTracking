package in.coderdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.coder.dto.Students;
import in.coder.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {
    private final String sqlInsertQuery="Insert into students(`sName`,`sAge`,`sQualification`,`sDesignation`,`sEmail`,`sMobile`) value(?,?,?,?,?,?)";
    
	@Override
	public String insertStudent(Students student) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;
		String status = null;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection!=null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			if(pstmt!=null) {
				pstmt.setString(1, student.getsName());
				pstmt.setInt(2, student.getsAge());
				pstmt.setString(3, student.getsQualification());
				pstmt.setString(4, student.getsDesignation());
				pstmt.setString(5, student.getsEmail());
				pstmt.setString(6, student.getsMobile());
				
				int rowsAffected = pstmt.executeUpdate();
				
				if(rowsAffected==1)
					status = "Success";
				else
					status = "Failure";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		return status;
	}

}
