package myapp.test;

import java.util.Date;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import myapp.dao.AccountDAO;
import myapp.hibernate.HibernateUtil;
import myapp.model.Account;

public class TestCases {

	@Test
	public void testCreateAccount() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Account account = new Account();
		account.setAccountType(Account.ACCOUNT_TYPE_SAVINGS);
		account.setCreationDate(new Date());
		account.setBalance(1000L);
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.saveOrUpdateAccount(account);
		session.getTransaction().commit();
		System.out.println(account);
		Assert.assertTrue(account.getAccountId() > 0);
	}

	@Test
	public void testGetAccount() {
		Account account = createAccount();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		AccountDAO accountService = new AccountDAO();
		Account anotherCopy = accountService.getAccount(account.getAccountId());
		System.out.println(account);
		// make sure these are two separate instances
		Assert.assertTrue(account != anotherCopy);
		System.out.println("var anotherCopy = " + anotherCopy);
		session.getTransaction().commit();

	}

	@Test
	public void testAccountUpdate() {

		Account account = createAccount();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		account.setBalance(6000);
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.saveOrUpdateAccount(account);
		session.getTransaction().commit();

		Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
		session2.beginTransaction();
		Account anotherCopy = accountDAO.getAccount(account.getAccountId());
		System.out.println(anotherCopy);
		// make sure the one we just pulled back from the
		// database has the updated balance
		Assert.assertTrue(anotherCopy.getBalance() == 6000);
		session2.getTransaction().commit();
	}

	@Test
	public void testDeleteAccount() {
		// create an account to delete
		Account account = createAccount();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		AccountDAO accountService = new AccountDAO();
		// delete the account
		accountService.deleteAccount(account);
		session.getTransaction().commit();
		Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
		session2.beginTransaction();
		// try to get the account again -- should be null
		Account anotherCopy = accountService.getAccount(account.getAccountId());
		System.out.println("var anotherCopy = " + anotherCopy);
		Assert.assertNull(anotherCopy);
		session2.getTransaction().commit();
	}

	private Account createAccount() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Account account = new Account();
		account.setAccountType(Account.ACCOUNT_TYPE_SAVINGS);
		account.setCreationDate(new Date());
		account.setBalance(2000L);
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.saveOrUpdateAccount(account);
		session.getTransaction().commit();

		return account;

	}

}
