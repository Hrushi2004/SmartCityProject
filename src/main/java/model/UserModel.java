package model;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Details;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserModel implements UserRemote {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hackathon");

    @Override
    public String InsertData(Details d) throws Exception {
    	 
	        EntityManager em = emf.createEntityManager();

	        em.getTransaction().begin();
	        em.persist(d);
	        em.getTransaction().commit();

	        em.close();
	        emf.close();

	        return "Record Inserted Successfully";
    }

    @Override
    public Details getUserByUsername(String username) {
        EntityManager em = emf.createEntityManager();
        try {
        	 Details detail = em.find(Details.class, username);
        	 return detail;
        } finally {
            em.close();
        }
       
    }

	@Override
	public boolean verifyPassword(String password, String password2) {
		// TODO Auto-generated method stub
		return password.equals(password2);
	}
}
