package Service;

import dao.UserDao;

import dto.UserDto;
import helper.AES;

public class UserService {
	public boolean saveUser(UserDto dto)
	{
		if(dto.getAge()<18)
			return false;
		else {
			UserDao dao=new UserDao();
//			dao.saveUser(dto);
			
			UserDto dto1=dao.findByEmail(dto.getEmail());
			if(dto1 != null)
				return false;
			else {
				dto.setPassword(AES.encrypt(dto.getPassword(),"123"));
				dao.saveUser(dto);
			    return true;
		}
	}
	}

	public boolean login(String email, String password) {
		UserDao dao=new UserDao();
		UserDto dto=dao.findByEmail(email);
		if(dto==null)
			return false;
		else {
			System.out.println("asjsd");
			if(password.equals(AES.decrypt(dto.getPassword(),"123")))
//			if(password.equals(dto.getPassword()))
			return true;
			else
				return false;
	}
	
	
}
}

	
	
	
	
	
	
	
	
	