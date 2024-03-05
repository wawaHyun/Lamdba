
package account;

import java.util.List;

public interface AccountService {
    String deposit(Account accountInfor);
    String withdraw(Account accountInfor);
    String getBalance(Account accountInfor);

}
