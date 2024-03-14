
package com.turing.api.account;


import com.turing.api.enums.Messenger;
import com.turing.api.common.AbstractService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountServiceImpl extends AbstractService<Account> implements AccountService {

    private static AccountServiceImpl instance = new AccountServiceImpl();
    List<Account> list;

    private AccountServiceImpl() {
        this.list = new ArrayList<>();
    }

    public static AccountServiceImpl getInstance() {
        return instance;
    }

    @Override
    public String deposit(Account accountInfor) {
        String result = "";
        Account sum = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccountNumber() == null) {
                System.out.println("404 Not found : Account");
            } else {
                if (list.get(i).getAccountHolder() == null) {
                    System.out.println("AccountHolder are not the same.");
                } else {
                    accountInfor.setBalance(accountInfor.getBalance() + accountInfor.getBalance());
                    list.add(accountInfor);
                    System.out.println("list " + list.toString());
                    System.out.println("accountInfor " + accountInfor.toString());
                    result = accountInfor.getTransactionDate() + " : " +
                            accountInfor.getMoney() + " has been deposited.\n" +
                            "Current balance is " + list.get(i).getBalance();
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public String withdraw(Account accountInfor) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccountNumber() == null) {
                System.out.println("404 Not found : Account");
            } else {
                if (list.get(i).getAccountHolder() == null) {
                    System.out.println("AccountHolder are not the same.");
                } else {
                    //ramda
//                    list.stream().mapToInt(Integer::intValue).sum(accountInfor.getMoney());
                    System.out.println((list.get(i).getBalance() - accountInfor.getMoney()));
                    result = accountInfor.getTransactionDate() + " : " +
                            accountInfor.getMoney() + " has been withdrawed.\n" +
                            "Current balance is " + list.get(i).getBalance();
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public String getBalance(Account accountInfor) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccountNumber().equals(accountInfor.getAccountNumber())) {
                result = accountInfor.getTransactionDate() + " Current balance : " +
                        list.get(i).getBalance();
                break;
            } else {
                result = "404 Not found : com.turing.api.account";
            }
        }
        return result;
    }

    @Override
    public Messenger save(Account account) {
        return null;
    }

    @Override
    public Messenger save2(Account account) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Account> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public Messenger delete(Account account) {
        return Messenger.SUCCESS;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}