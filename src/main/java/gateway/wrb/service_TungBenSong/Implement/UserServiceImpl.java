package gateway.wrb.service_TungBenSong.Implement;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gateway.wrb.entity_TungBenSong.User;
import gateway.wrb.repositorie_TungBenSong.UserRepo;
import gateway.wrb.service_TungBenSong.UserService;

@Service //Lớp service thì có @Servie để đánh dấu.
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userRepo.insertUser(user);
	}

	@Override
	public User selectUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepo.selectUserById(id);
	}

	@Override
	public List<User> selectUserByName(String name) {
		// TODO Auto-generated method stub
		return userRepo.selectUserByName(name);
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userRepo.selectAllUser();
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userRepo.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userRepo.deleteUser(user);
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		userRepo.deleteUserById(id);
	}
	

}
