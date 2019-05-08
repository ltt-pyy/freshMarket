package fresh.factory ;
import fresh.dao.IUserDAO;
import fresh.dao.proxy.UserDAOProxy;
import fresh.dao.IEmpDAO;
import fresh.dao.proxy.EmpDAOProxy;
import fresh.dao.IFreshDAO;
import fresh.dao.proxy.FreshDAOProxy;
import fresh.dao.IOrderDAO;
import fresh.dao.proxy.OrderDAOProxy;
import fresh.dao.ICartDAO;
import fresh.dao.proxy.CartDAOProxy;
import fresh.dao.IAddressInfoDAO;
import fresh.dao.proxy.AddressInfoDAOProxy;

public class DAOFactory {
	public static IUserDAO getIUserDAOInstance() throws Exception{
		return new UserDAOProxy() ; 
	}
	public static IEmpDAO getIEmpDAOInstance() throws Exception{
		return new EmpDAOProxy() ;
	}
	public static IFreshDAO getIFreshDAOInstance() throws Exception{
		return new FreshDAOProxy() ;
	}
	public static IOrderDAO getIOrderDAOInstance() throws Exception{
		return new OrderDAOProxy() ;
	}
	public static ICartDAO getICartDAOInstance() throws Exception{
		return new CartDAOProxy() ;
	}
	public static IAddressInfoDAO getIAddressInfoDAOInstance() throws Exception{
		return new AddressInfoDAOProxy() ;
	}
}