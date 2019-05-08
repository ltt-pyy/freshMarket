package fresh.dao;

import java.util.List;
import java.util.Set;

import fresh.vo.User;
import fresh.vo.Fresh;

public interface IFreshDAO extends IDAO<Fresh, Integer> {
	public List<Fresh> findAll(Set<Integer> key) throws Exception;

	public void doUpdateCount(Integer id) throws Exception ;

	public List<Fresh> findByType(String keyWord) throws Exception ;
	
}
