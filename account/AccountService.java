
package com.turing.api.account;

public interface AccountService {
    String deposit(Account accountInfor);
    String withdraw(Account accountInfor);
    String getBalance(Account accountInfor);

}
