package hcl.com.departmentshow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DataQueryDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void showDepartment(){
		String cmd= "select * from department ";
		List emps=null;
		emps = jdbcTemplate.query(cmd, new RowMapper() {
			
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				String res = rs.getInt("deptno") + "-----"+
						rs.getString("dname") + "-------" +
						rs.getString("loc")+ "------" +
						rs.getString("head") ;
				return res;
			}
		});
		for(Object obj : emps){
			System.out.println(obj);
		}
	}
	
	public void searchDepartment(int deptno){
		String cmd="select * from department where deptno = ?";
		List emps = null;
		emps  =jdbcTemplate.query(cmd, new Object[]{deptno},new RowMapper() {
			
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				String res = rs.getInt("deptno") + "-----"+
						rs.getString("dname") + "-------" +
						rs.getString("loc")+ "------" +
						rs.getString("head") ;
				return res;
			}
		});
		for(Object obj : emps){
			System.out.println(obj);}
	}
}
