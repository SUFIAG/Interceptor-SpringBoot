
package com.netsurfingzone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netsurfingzone.annotation.NotSecuredApi;
import com.netsurfingzone.constants.ApplicationConstant;
import com.netsurfingzone.entity.User;
import com.netsurfingzone.error.UserNotAuthorizedException;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/login")
	@NotSecuredApi
	public String getAuthenticated(@RequestHeader(value = "username") String username,
			@RequestHeader(value = "password") String password) {

		// if username and password is not admin & admin then show error
		if (!ApplicationConstant.USERNAME.equals(username) || !ApplicationConstant.PASSWORD.equals(password)) {

			throw new UserNotAuthorizedException("Not a valid user");
		}
		return "User successfully auntheticated";
	}

	@GetMapping("/getuser")
	public User getUser() {
		User user = new User();
		user.setId(1);
		user.setUsername("Tom");
		user.setEmail("teste@gmail.com");
		return user;
	}

}