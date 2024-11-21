package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.UserModel;




public interface IUserService {

	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	UserModel Register(UserModel user); 
	
	UserModel SignIn(String username, String password);
	
	UserModel FindByUserName(String username);
	
	UserModel ChangePassword(String username, String newpassword); 
	
	UserModel UpdateProfile(String username, String fullname, String email, String phone);

	UserModel login(String username, String password);

	UserModel findByUsername(String username); 
}
