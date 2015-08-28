import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Userjpa;
import customTools.DBUtil;

public class UserDB {
	public static void insert(Userjpa user) {
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

	public static void update(Userjpa user) {
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

	public static void delete(Userjpa user) {
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
	
	
	public static List<Userjpa> selectAllUser(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Userjpa i order by i.twitterid desc";
		TypedQuery<Userjpa> q = em.createQuery(qString, Userjpa.class);
		List<Userjpa> users;
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
	

	public static List<Userjpa> selectSearchResult(String keyword){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Userjpa i where i.post like '%" + keyword + "%'";
		TypedQuery<Userjpa> q = em.createQuery(qString, Userjpa.class);
		List<Userjpa> users;
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
	
	public static List<Userjpa> selectPostByUser(String uname){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Userjpa i where i.username = '" + uname + "' order by i.twitterid desc";
		TypedQuery<Userjpa> q = em.createQuery(qString, Userjpa.class);
		List<Userjpa> users;
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
	
	public static List<Userjpa> selectPostByKeyword(String uname, String keyword){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Userjpa i where i.username = '" + uname + "' and i.post like '%" + keyword + "%' order by i.twitterid desc";
		TypedQuery<Userjpa> q = em.createQuery(qString, Userjpa.class);
		List<Userjpa> users;
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
}