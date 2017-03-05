package com.daidonef.pointofsale;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DAOAccountHistory {
	
	private static SessionFactory factory;

	private static void setupFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			;
		}
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addResource("accounthistory.hbm.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		factory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static int addAccountHistory(AccountHistory ah) {
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		int i = (Integer) hibernateSession.save(ah);
		hibernateSession.getTransaction().commit(); 
		hibernateSession.close();
		return i;
	}
	
	public static List<AccountHistory> getAccountHistory(String query) { 
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		List<AccountHistory> accHistory = hibernateSession.createQuery(query).list();
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return accHistory;
	}
	
	public static void updateAccountHistory(AccountHistory ah) {
		if (factory == null)
			setupFactory();	
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		hibernateSession.merge(ah);
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
	}
	
	public static AccountHistory deleteAccountHistory(int i) {
		if (factory == null)
			setupFactory();	
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		AccountHistory accHistory = hibernateSession.get(AccountHistory.class, i);
		hibernateSession.delete(accHistory);
		hibernateSession.getTransaction().commit();
		hibernateSession.clear();
		return accHistory;
	}

}
