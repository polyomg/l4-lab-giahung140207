package poly.edu.service;

import poly.edu.entity.Account;
import java.util.List;

public interface AccountService {
    Account findById(String username);
    List<Account> findAll();
}
