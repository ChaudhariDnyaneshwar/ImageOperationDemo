package Service;

import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

public class ImageDao implements Dao
{

	
	private JdbcTemplate jdbcTemplate;

	public ImageDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public int insertRecord(Bean be) {
		
		int a=0;
		try {
			byte[] photoBytes=be.getPhoto().getBytes();
			
			String sql = "INSERT INTO STUDENT(NAME,AGE,PHOTO) VALUES (?,?,?)";

			 a=jdbcTemplate.update(sql, new Object[] { be.getName(), be.getAge(), photoBytes });
				
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public List<Bean> getList() {
		
		RowMapper<Bean> rowMapper=new RowMapper<Bean>() {

			public Bean mapRow(ResultSet req, int c) throws SQLException {
				
				 Bean obj=new Bean();
				 obj.setId(req.getInt(1));
				 obj.setName(req.getString(2));
				 obj.setAge(req.getInt(3));
				return obj;
			}
		};
	
		
		List<Bean> lis=jdbcTemplate.query("select * from student", rowMapper);
		return lis;
	}

	public Blob getImage(int id) {
		// TODO Auto-generated method stub
		
		String query = "select photo from student where id=?";

		Blob photo = jdbcTemplate.queryForObject(query, new Object[] { id }, Blob.class);

		return photo;
	}
	public int delete(int id) {
		
		//.id.int a=jdbcTemplate.update("delete from student where id=?",id);
		int a=jdbcTemplate.update("delete from student where id=?",id);
		return a;
	}
}
