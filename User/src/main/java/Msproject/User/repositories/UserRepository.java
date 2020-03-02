package Msproject.User.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Msproject.User.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findByUsername(String Username);
	
	public Optional<User> findByUsernameAndEmail(String username, String email);

	public Optional<User> findByUsernameAndPassword(String username, String password);

}