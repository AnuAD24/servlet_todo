package dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.UserDto;

public class UserDao {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("service");
	EntityManager m=f.createEntityManager();
	
	public void saveUser(UserDto dto) 
	{
		m.getTransaction().begin();
		m.persist(dto);
		m.getTransaction().commit();
	}

	public UserDto findByEmail(String email) {
		Query query=m.createQuery("select x from UserDto x where email=?1").setParameter(1, email);
		List<UserDto> list=query.getResultList();
		if(!list.isEmpty())
			return list.get(0);
		else
			return null;
	}
	
	

}
