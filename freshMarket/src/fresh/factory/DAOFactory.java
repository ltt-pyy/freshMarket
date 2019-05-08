package fresh.factory ;
import fresh.dao.IuserDAO;
import fresh.dao.proxy.userDAOProxy;
import fresh.dao.IempolyeeDAO;
import fresh.dao.proxy.empolyeeDAOProxy;
import fresh.dao.IfreshDAO;
import fresh.dao.proxy.freshDAOProxy;
import fresh.dao.IorderDAO;
import fresh.dao.proxy.orderDAOProxy;
import fresh.dao.IcartDAO;
import fresh.dao.proxy.cartDAOProxy;
import fresh.dao.IAddressInfoDAO;
import fresh.dao.proxy.AddressInfoDAOProxy;
import fresh.dao.ItypeDAO;
import fresh.dao.proxy.typeDAOProxy;

public class DAOFactory {
	public static IuserDAO getIuserDAOInstance() throws Exception{
		return new userDAOProxy() ; 
	}
	public static IemployeeDAO getIemployeeDAOInstance() throws Exception{
		return new employeeDAOProxy() ;
	}
	public static IfreshDAO getIfreshDAOInstance() throws Exception{
		return new freshDAOProxy() ;
	}
	public static IorderDAO getIorderDAOInstance() throws Exception{
		return new orderDAOProxy() ;
	}
	public static IcartDAO getIcartDAOInstance() throws Exception{
		return new cartDAOProxy() ;
	}
	public static IAddressInfoDAO getIAddressInfoDAOInstance() throws Exception{
		return new AddressInfoDAOProxy() ;
	}
	public static ItypeDAO getItypeDAOInstance() throws Exception{
		return new typeDAOProxy() ;
	}
}