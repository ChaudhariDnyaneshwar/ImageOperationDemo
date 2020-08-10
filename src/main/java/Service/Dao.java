package Service;

import java.util.List;



public interface Dao {

	public int insertRecord(Bean be);
	public List<Bean> getList();
	public java.sql.Blob getImage(int id);
	public int delete(int id);
}
