package gateway.wrb.controllers_TungBenSong;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import gateway.wrb.entity_TungBenSong.User;
import gateway.wrb.repositorie_TungBenSong.Implement.UserRepoImpl;
import gateway.wrb.service_TungBenSong.UserService;

@Controller // lớp controller thì có @Controller để đánh dấu, lên mạng tìm hiểu thêm
@RequestMapping(value = "/BS")
public class TungBS_Controller {
	@Autowired // dùng cái Autowired thì khi tạo object userService không cần từ khóa new
	private UserService userService;
	@Autowired
	private UserRepoImpl userRepo;

	@GetMapping(value = "/test")
	public ResponseEntity<?> test() {
		return new ResponseEntity("Tung BS anlol ", HttpStatus.OK);
	}

	// Post 1 user từ Postman, liu vào trong database
	@PostMapping(value = "/addUser")
	public ResponseEntity<?> add(@RequestBody User user) {
		User u = user;
		userService.insertUser(user);
		return new ResponseEntity("Post dữ liệu thành công ", HttpStatus.OK);

	}

	// Lấy các user trong DB có userName = name truyền từ Postman
	@GetMapping(value = "/select")
	public ResponseEntity<?> selectByName(@RequestParam(value = "name") String tenNguoi) {
		List<User> list = userService.selectUserByName(tenNguoi);
		if (list.isEmpty())
			return new ResponseEntity("Không có ai có tên là: " + tenNguoi, HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity(list, HttpStatus.OK);
	}

	// Lấy tất cả user trogn DB
	@GetMapping(value = "/selectAll")
	@ResponseBody
	public String select() {
		List<User> list = userService.selectAllUser();
		Gson gson = new Gson();
		if (list.isEmpty())
			return "DB rỗng";
		else
			return gson.toJson(list);
	}

	// Xóa user = id
	@DeleteMapping(value = "/delete")
	public ResponseEntity<?> del(@RequestParam(value = "id") Long ID) {
		userService.deleteUserById(ID);
		return new ResponseEntity("Xóa OK nhé bên sông", HttpStatus.OK);

	}


}
