package gateway.wrb.service_TungBenSong;

import java.util.List;

import gateway.wrb.entity_TungBenSong.User;

public interface UserService {
	// CREATE
	void insertUser(User user);

	// READ
	User selectUserById(Long id);

	List<User> selectUserByName(String name);

	List<User> selectAllUser();

	// UPDATE
	void updateUser(User user);

	// DELETE
	void deleteUser(User user);

	void deleteUserById(Long id);
}
