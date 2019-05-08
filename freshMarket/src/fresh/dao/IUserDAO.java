package fresh.dao;

import java.util.List;

import fresh.vo.User;

public interface IUserDAO extends IDAO<User, String> {
	public boolean findLogin(User vo) throws Exception;

	public void doUpdateLastdate(String id) throws Exception;
	public boolean findPaypass(User vo) throws Exception;

	public int PageSize() throws Exception;

	public List<User> findPage(String keyWord) throws Exception;
}
