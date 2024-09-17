package vn.iotstar.services.impl;

import vn.iotstar.dao.IUserdao;
import vn.iotstar.dao.impl.Userdaoimpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService {
	//lấy tất cả hàm trong tầng Dao
	IUserdao userDao = new Userdaoimpl();
	

	@Override
	public UserModel login(String username, String password) {
		
		UserModel user = this.findByUsername(username);
		 
		if (user != null && password.equals(user.getPassword())) {
			 return user;
		 }
		 return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		
		return userDao.findByUsername(username);
	}
	public static void main(String[] args) {
	 	
        IUserService userDao = new UserService();
        System.out.println(userDao.findByUsername("trieuvi"));
        //List<UserModel> list = userDao.findAll();
       // for (UserModel user : list) {
       //     System.out.println(user);
       // }
    }
}
