package ir.sogol.wallet.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Long> {
}
