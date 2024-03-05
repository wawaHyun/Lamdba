
package account;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@ToString(exclude = {"id"})
public class Account {
    private long id;
    private String accountNumber;  //계좌번호
    private String accountHolder; //예금주
    private double balance;  //잔고
    private LocalDate transactionDate; //거래일자
    private int money;
@Builder(builderClassName = "builder")
    public Account(long id, String accountNumber, String accountHolder, double balance, LocalDate transactionDate, int money ){
    this.id = id;
    this.accountNumber = accountNumber;
    this.accountHolder = accountHolder;
    this.balance = balance;
    this.transactionDate = transactionDate;
    this.money = money;
}}