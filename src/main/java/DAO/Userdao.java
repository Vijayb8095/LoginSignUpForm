package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Controller.SignUpPage;
import DTO.UserInfoPage;
import antlr.collections.List;

public class Userdao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("project");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		public UserInfoPage fetch(int id) {
			return entityManager.find(UserInfoPage.class, id);
		}
		
		public void delete(UserInfoPage infoPage) {
			entityTransaction.begin();
			entityManager.remove(infoPage);
			entityTransaction.commit();
		}
		
		
		
		public java.util.List<UserInfoPage> fetchAll(){
			return entityManager.createQuery("Select x from UserInfoPage x").getResultList();
		}

	public void save(UserInfoPage infoPage) {
		entityTransaction.begin();
		entityManager.persist(infoPage);
		entityTransaction.commit();			
	}
	
	public UserInfoPage fetch(long mobile) {
		java.util.List<UserInfoPage> list =entityManager.createQuery("Select x from UserInfoPage x where mobile=?1").setParameter(1, mobile).getResultList();
		if(list.isEmpty()) {
			return null;
		}
		else {
			return list.get(0);
		}
	}
	
	
	

	public UserInfoPage fetch(String email) {
		java.util.List<UserInfoPage> list =entityManager.createQuery("Select x from UserInfoPage x where email=?1").setParameter(1, email).getResultList();
		if(list.isEmpty()) {
			return null;
		}
		else {
			return list.get(0);
		}
		
	}

	public void merge(UserInfoPage infoPage) {
		entityTransaction.begin();
		entityManager.merge(infoPage);
		entityTransaction.commit();
	}


	
}
