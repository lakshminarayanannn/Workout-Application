package com.personalworkouttracker.test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import com.personalworkouttracker.entity.Role;
import com.personalworkouttracker.entity.User;
import com.personalworkouttracker.exception.ValidationException;
import com.personalworkouttracker.repository.UserRepository;
import com.personalworkouttracker.service.UserService;

public class UserTest {

	UserRepository userRepository = new UserRepository();
	UserService userService = new UserService();
    @Test
	public void testAddUser() throws ValidationException {

		Role role = new Role("admin");
		Role role1 = new Role("user");
		Role role2 = new Role("trainer");
		User user = new User("murali@123.com", "Murali@123", 180, 76, role);
		User user1 = new User("saiJoshe@123.com", "saiJoshe@123", 190, 75, role1);
		User user2 = new User("Vinitha@123.com", "Vinitha@123", 165, 60, role2);
		User user3 = new User("Ranjith@123.com", "Ranjith@123", 185, 78, role2);
		User user4 = new User("Aishu@123.com", "Aishuu@123456", 176, 65, role2);
		User user5 = new User("chandiPriya@123", "chandiPriya@123", 175, 66, role);

		userService.add(user);
		userService.add(user1);
		userService.add(user2);
		userService.add(user3);
		userService.add(user4);
		userService.add(user5);

	}

	// @Test(expected = ValidationException.class)
	public void testInvalidUserAdd() throws ValidationException {
		Role role2 = new Role("trainer");
		User user5 = new User("chandiPriya123", "chandiPriya123", 175, 66, role2);
		userService.add(user5);
	}

	 //@Test
	public void testLogin() {
		boolean authenticated = userRepository.loginTest("saiJoshe@123.com", "saiJoshe@123");
		assertTrue(authenticated);
	}

	// @Test
	public void loginFailTest() {
		boolean authenticated = userRepository.loginTest("saiJoshe@123.com", "Joshe@123");

		assertFalse(authenticated);
	}

	// @Test
	public void testEditUser() {

		User user = userService.editUser(5, "Radhakrishna@123.com");
		assertNotNull(user);
	}

	// @Test
	public void testDeleteUser() throws ValidationException {

		User user = userRepository.deleteUser(5, "Radhakrishna@123.com");
		assertNull(user);

	}

	// @Test
	public void testFindUserByEmail() {

		User user = userRepository.findUser("Aishu@123.com");

		assertEquals(65, user.getWeight());
	}

	// @Test
	public void testViewAllUser() {
		List<User> userList = userRepository.findAllUser();
		assertEquals(4, userList.size());
		assertNotNull(userList);
	}

}
