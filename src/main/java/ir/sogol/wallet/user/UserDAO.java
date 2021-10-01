package ir.sogol.wallet.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDAO<T extends User> extends JpaRepository<T,Long> {

    @Query(value = "select u from User u where u.username like ':username'")
    Optional<T> findByUserName(String username);
}
