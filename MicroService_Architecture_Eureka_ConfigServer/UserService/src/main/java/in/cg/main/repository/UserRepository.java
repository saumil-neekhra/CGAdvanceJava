package in.cg.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.main.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
