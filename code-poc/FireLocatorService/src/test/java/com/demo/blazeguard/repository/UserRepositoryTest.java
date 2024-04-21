package com.demo.blazeguard.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import com.demo.blazeguard.model.User;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository repository;

	@Test
	public void test() {
		
		int initialCountOfUsers = repository.findAll().size();
		
		// findAll
		User firstUser = new User("Mert15", "mert123");
		entityManager.persist(firstUser);
		entityManager.flush();

		User secondUser = new User("Mert12", "mert125");
		entityManager.persist(secondUser);
		entityManager.flush();

		List<User> users = repository.findAll();

		assertThat(users.size()).isEqualTo(initialCountOfUsers + 2);
		assertThat(users.get(initialCountOfUsers + 0)).isEqualTo(firstUser);
		assertThat(users.get(initialCountOfUsers + 1)).isEqualTo(secondUser);
		
		// save
		User userToSave = new User("Saved_Mert", "mert1235");
		User savedUser = repository.save(userToSave);
		
		assertThat(repository.findAll().size()).isEqualTo(initialCountOfUsers + 3);
		assertThat(userToSave.getUsername()).isEqualTo(savedUser.getUsername());
		
		// findByUsername
		User foundByUsername = repository.findByUsername(firstUser.getUsername());
		assertThat(firstUser.getUsername()).isEqualTo(foundByUsername.getUsername());
		assertThat(firstUser.getPassword()).isEqualTo(foundByUsername.getPassword());

	}

}
