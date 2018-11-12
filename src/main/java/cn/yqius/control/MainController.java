package cn.yqius.control;

import cn.yqius.entity.Users;
import cn.yqius.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class MainController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody
	String addNewUser (@RequestParam String name, @RequestParam String nickName) {
		Users n = new Users();
		n.setName(name);
		n.setNickName(nickName);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Users> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}