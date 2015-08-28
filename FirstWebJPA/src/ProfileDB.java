import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Userjpa;
import model.Userprofile;
import customTools.DBUtil;

public class ProfileDB {
	public static void insert(Userprofile user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Userprofile user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Userprofile user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(user));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static List<Userprofile> getProfile(String uname){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Userprofile i where i.username = '" + uname + "'";
		TypedQuery<Userprofile> q = em.createQuery(qString, Userprofile.class);
		List<Userprofile> users;
		try{
			users = q.getResultList();
			if(users == null || users.isEmpty()){
				users = null;
			}
		}finally{
			em.close();
		}
		return users;
	}
	
/*	public static List<Userprofile> getProfile(String uname){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Userprofile i where i.username = ?1";
		TypedQuery<Userprofile> q = em.createQuery(qString, Userprofile.class);
		q.setParameter(1, uname);
		List<Userprofile> users;
		try{
			users = q.getResultList();
			if(users == null || users.isEmpty()){
				users = null;
			}
		}finally{
			em.close();
		}
		return users;
	}*/
	
/*	public static boolean checkLogin(String username){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Userprofile i where i.username = '" + username + "'";
		TypedQuery<Userprofile> q = em.createQuery(qString, Userprofile.class);
		List<Userprofile> users;
		try{
			users = q.getResultList();
			if(users != null && users.size() > 0){
				return true;
			}
		}finally{
			em.close();
		}
		return false;
	}*/
	
	public static boolean checkLogin(String username){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select count(i) from Userprofile i where i.username = '" + username + "'";
		TypedQuery<Long> query = em.createQuery(qString, Long.class);
		long total = query.getSingleResult();
		if(total > 0){
			return true;
		}else{
			return false;
		}
	}
	
}