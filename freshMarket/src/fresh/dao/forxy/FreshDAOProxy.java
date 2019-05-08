package fresh.dao.proxy;

import java.util.List;


import java.util.Set;

import fresh.dao.IFreshDAO;
import fresh.dao.impl.FreshDAOImpl;
import fresh.dbc.DatabaseConnection;
import fresh.vo.Fresh;

public class FreshDAOProxy implements IFreshDAO {
	private DatabaseConnection dbc = null;
	private IFreshDAO dao = null;
	private long count = 0;
    private int page=0;
	public FreshDAOProxy() throws Exception{
		this.dbc = new DatabaseConnection();
		this.dao = new FreshDAOImpl(this.dbc.getConnection());
	}

	public void doUpdateCount(Integer id) throws Exception {
		try {
			this.dao.doUpdateCount(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	public List<Fresh> findAll(Set<Integer> key) throws Exception {
		List<Fresh> all = null;
		try {
			all = this.dao.findAll(key);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public boolean doCreate(Fresh vo) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doCreate(vo);
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

	public boolean doUpdate(Fresh vo) throws Exception {
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

	public List<Fresh> findAll(String keyWord) throws Exception {
		List<Fresh> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public List<Fresh> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		List<Fresh> all = null;
		try {
			all = this.dao.findAll(keyWord, currentPage, lineSize);
			this.count = this.dao.getAllCount(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public Fresh findById(String id) throws Exception {
		Fresh pro = null;
		try {
			pro = this.dao.findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return pro;
	}

	public long getAllCount(String keyWord) throws Exception {
		return this.count;
	}
	public List<Fresh> findByType(String keyWord) throws Exception {
		List<Fresh> all = null;
		try {
			all = this.dao.findByType(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}
	
}
