package com.example.picpaydemojava.resource;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.picpaydemojava.dto.UserDTO;
import com.example.picpaydemojava.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserResource extends ResourceBase<UserDTO> {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/{login}")
	public ResponseEntity<UserDTO> consult(@PathVariable String login){
		UserDTO user = userService.consult(login);
		return answerSuccessfullyWithItem(user);
	}

	@GetMapping("/contacts")
	public ResponseEntity<List<UserDTO>> list(@RequestParam String login){
		List<UserDTO> user = userService.list(login);
		return answerItemList(user);
	}
	
	@GetMapping("/{login}/balance")
	public ResponseEntity<UserDTO> consultBalance(@PageableDefault(page = 0,size = 20) Pageable paging,
			@PathVariable String login){
		UserDTO userDTO = userService.consult(login);
		return answerSuccessfullyWithItem(userDTO);
	}
}