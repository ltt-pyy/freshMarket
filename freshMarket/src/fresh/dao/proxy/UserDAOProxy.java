package fresh.dao.proxy;

import java.util.List;







import fresh.dao.IUserDAO;
import fresh.dao.impl.UserDAOImpl;
import fresh.dbc.DatabaseConnection;
import fresh.vo.User;
import fresh.vo.Fresh;

public class UserDAOProxy implements IUserDAO {

	private DatabaseConnection dbc = null;
	private IUserDAO dao;

	public UserDAOProxy() throws Exception{
              

		this.dbc = new DatabaseConnection();
               
		this.dao = new UserDAOImpl(this.dbc.getConnection());
	}

	public void doUpdateLastdate(String id) throws Exception {
		try {
			this.dao.doUpdateLastdate(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	public boolean findLogin(User vo) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.findLogin(vo);
			if (flag) { // 用户登陆成功
				this.dao.doUpdateLastdate(vo.getUserId()); // 更新用户的最后一次登陆时间
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean doCreate(User vo) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(vo.getUserId()) == null) {
				flag = this.dao.doCreate(vo);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean doRemove(String id) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doRemove(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean doUpdate(User vo) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doUpdate(vo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public List<User> findAll(String keyWord) throws Exception {
		List<User> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public List<User> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		List<User> all = null;
		try {
			all = this.dao.findAll(keyWord, currentPage, lineSize);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public User findById(String id) throws Exception {
		User mem = null;
		try {
			mem = this.dao.findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return mem;
	}

	public long getAllCount(String keyWord) throws Exception {
		long count = 0;
		try {
			count = this.dao.getAllCount(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return count;
	}
	public boolean findPaypass(User vo) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.findPaypass(vo);
			
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public int PageSize() throws Exception {
		// TODO Auto-generated method stub
		int rowCount = 0;
		try {
			rowCount = this.dao.PageSize();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return rowCount;
	}

	@Override
	public List<User> findPage(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<User> all = null;
		try {
			all = this.dao.findPage( keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

}
