package ir.sogol.wallet.porsant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorsantDAO extends JpaRepository<Porsant, Long> {

}
