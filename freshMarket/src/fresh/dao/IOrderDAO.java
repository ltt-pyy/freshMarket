package fresh.dao;

import java.util.List;
import java.util.Set;

import fresh.vo.Order;

public interface IOrderDAO extends IDAO<Order, Integer> {
	public List<Order> findAll(Set<Integer> key) throws Exception;

	public void doUpdateCount(Integer id) throws Exception ;
	public boolean doUpdateSth(Order vo) throws Exception ;
}