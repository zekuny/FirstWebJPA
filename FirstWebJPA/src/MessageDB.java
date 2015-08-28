import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Message;
import customTools.DBUtil;

public class MessageDB {
	public static void insert(Message mm) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(mm);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	} 

	public static void update(Message mm) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(mm);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Message mm) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(mm));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	
	public static List<Message> selectAllMessage(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Message i order by i.messageid desc";
		TypedQuery<Message> q = em.createQuery(qString, Message.class);
		List<Message> messages;
		try{
			messages = q.getResultList();
			if(messages == null || messages.isEmpty()){
				messages = null;
			}
		}finally{
			em.close();
		}
		return messages;
	}
	
	// all the messages that I received
	public static List<Message> getAllSender(String uname){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Message i where i.receiver = '" + uname + "' order by i.messageid desc";
		TypedQuery<Message> q = em.createQuery(qString, Message.class);
		List<Message> users;
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
	
	// all the messages that I sent
	public static List<Message> getAllReceiver(String uname){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Message i where i.sender = '" + uname + "' order by i.messageid desc";
		TypedQuery<Message> q = em.createQuery(qString, Message.class);
		List<Message> users;
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
	
	public static List<Message> selectPostByUser(String uname){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Userjpa i where i.username = '" + uname + "' order by i.twitterid desc";
		TypedQuery<Message> q = em.createQuery(qString, Message.class);
		List<Message> users;
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
	
	public static List<Message> selectPostByKeyword(String uname, String keyword){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Userjpa i where i.username = '" + uname + "' and i.post like '%" + keyword + "%' order by i.twitterid desc";
		TypedQuery<Message> q = em.createQuery(qString, Message.class);
		List<Message> users;
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