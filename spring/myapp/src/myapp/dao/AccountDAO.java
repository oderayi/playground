package myapp.dao;

import org.hibernate.Session;

import myapp.hibernate.HibernateUtil;
import myapp.model.Account;

public class AccountDAO {
	
	public Account getAccount(long accountId){
		return (Account) HibernateUtil
						.getSessionFactory()
						.getCurrentSession()
						.get(Account.class, accountId);
	}
	
	public void saveOrUpdateAccount(Account account){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(account);		
	}
	
	public void deleteAccount(Account account) {
		HibernateUtil.getSessionFactory().getCurrentSession().delete(account);
	}
	
	

}
