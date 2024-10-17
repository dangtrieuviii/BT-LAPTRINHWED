package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserdao {
	
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	UserModel findByUsername(String username);

	void UpdateProfile(String username, String fullname, String email, String phone);

	void ChangePassword(String username, String newPassword);

	void Register(UserModel user);

	UserModel SignIn(String username, String password);


}
