package ir.sogol.wallet.reseller;

import ir.sogol.wallet.user.UserDAO;
import org.springframework.stereotype.Repository;

@Repository
public interface ResellerDAO extends UserDAO<Reseller> {
}
