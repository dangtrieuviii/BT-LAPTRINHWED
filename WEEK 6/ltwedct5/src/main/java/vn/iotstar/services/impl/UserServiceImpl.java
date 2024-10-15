package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IUserdao;
import vn.iotstar.dao.impl.Userdaoimpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserServiceImpl implements IUserService {
	IUserdao userDao = new Userdaoimpl();

	@Override
	public List<UserModel> findAll() {
		return userDao.findAll();
	}

	@Override
	public UserModel findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public UserModel SignIn(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;

	}

	@Override
	public UserModel FindByUserName(String username) {
		return userDao.findByUsername(username);
	}
	/*
	 * public static void main(String[] args) { UserServiceImpl userService = new
	 * UserServiceImpl(); System.out.println(userService.SignIn("MinhTrung",
	 * "trung125")); }
	 */

	@Override
	public UserModel Register(UserModel user) {
	    UserModel existingUser = userDao.findByUsername(user.getUsername()); 
	    if (existingUser != null) {
	        // Nếu user đã tồn tại, trả về null
	        return null;
	    }

	    // Nếu chưa tồn tại, thêm user vào cơ sở dữ liệu
	    userDao.Register(user);
	    return user;
		
	}

	@Override
	public UserModel ChangePassword(String username, String newpassword) {
		// Kiểm tra xem username có tồn tại không
        UserModel user = userDao.findByUsername(username);

        if (user != null) {
            // Username tồn tại, thay đổi mật khẩu
            userDao.ChangePassword(username, newpassword);
            return userDao.findByUsername(username); // Trả về thông tin người dùng sau khi thay đổi mật khẩu
        } else {
            // Username không tồn tại, trả về null
            return null;
        }
	}

	@Override
	public UserModel UpdateProfile(String username, String fullname, String email, String phone) {
		// Kiểm tra xem username có tồn tại không
        UserModel user = userDao.findByUsername(username);

        if (user != null) {
            // Username tồn tại, thay đổi mật khẩu
        	userDao.UpdateProfile(username, fullname, email, phone);
            return userDao.findByUsername(username); // Trả về thông tin người dùng sau khi thay đổi mật khẩu
        } else {
            // Username không tồn tại, trả về null
            return null;
        }
	}

	@Override
	public UserModel login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
	
			// ------------------------------ FUCTION: FIND ALL ----------------------------
	
			/*
			 * UserDaoImpl userDao = new UserDaoImpl(); List<UserModel> list =
			 * userDao.findAll(); for (UserModel user : list) { System.out.println(user); }
			 */
	
			// ------------------------------ FUCTION: FIND BY ID
			// ----------------------------
	
			/*
			 * UserDaoImpl userDao = new UserDaoImpl(); int userId = 3; UserModel user =
			 * userDao.findById(userId); System.out.println("Information User" + user);
			 */
	
			// ------------------------------FUCTION: SIGN IN------------------------------
	
			/*
			 * Userdaoimpl userDao = new Userdaoimpl(); String username = "trieuvi"; String
			 * password = "12345"; UserModel users = userDao.SignIn(username, password); if
			 * (users != null) { System.out.println(" Sign In Successfully ! " + users); }
			 * else { System.out.
			 * println("Sign In Failed ! Check Your Username And Password Again !"); }
			 */
	
			// ------------------FUCTION: INSERT (ID INCREASE
			// AUTOMATICALLY)-------------------
	
			/*
			 * UserDaoImpl userDao = new UserDaoImpl(); userDao.insert(new
			 * UserModel("MinhTrung", "MTrung@gmail.com", "NMT", "null", "8423"));
			 * List<UserModel> list = userDao.findAll(); for (UserModel user : list) {
			 * System.out.println(user); }
			 */
	
			// ------------------ FUNCTION: FIND BY USER ---------------------------------
	
			
			/*
			 * UserServiceImpl userservices = new UserServiceImpl(); String userName =
			 * "trieuvi"; UserModel user = userservices.SignIn("trieuvi", "12345");
			 * System.out.println( user);
			 */
	
			// ------------------- FUNCTION: REGISTER ---------------------------
	
			
			/*
			 * UserDaoImpl userDao = new UserDaoImpl(); userDao.Register(new
			 * UserModel("NguyenHoangMy","my@gmail.com","5189","HoangMy", "my518"));
			 * List<UserModel> list = userDao.findAll(); for (UserModel user : list) {
			 * System.out.println(user); }
			 */
			 
	
			// ------------------ FUNCTION: UPDATE PASSWORD ---------------------------
			/*
			 * UserDaoImpl userDao = new UserDaoImpl(); String username = "NgocHan"; String
			 * newPassword = "han582";
			 * 
			 * // Cập nhật mật khẩu userDao.ChangePassword(username, newPassword);
			 * 
			 * // Kiểm tra việc thay đổi mật khẩu UserModel user =
			 * userDao.findByUsername(username);
			 * System.out.println("Information User After Password Change: " + user);
			 */
			
			// ------------------ FUNCTION: UPDATE PROFILE ---------------------------
			
			/*
			 * UserDaoImpl userDao = new UserDaoImpl(); String username = "ThanhHai" ;
			 * String fullname = "PhamThanhHai"; String email ="hai@gmail.com"; String phone
			 * = "5649";
			 * 
			 * // Cập nhật mật khẩu userDao.UpdateProfile(username, fullname, email, phone);
			 * 
			 * // Kiểm tra việc thay đổi mật khẩu UserModel user =
			 * userDao.findByUsername(username);
			 * System.out.println("Information User After Password Change: " + user);
			 */
			 	
			
	
		}
	
	
	
	}
	



   
