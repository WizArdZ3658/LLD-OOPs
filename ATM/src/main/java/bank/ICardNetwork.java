package bank;

public interface ICardNetwork {
    void withdrawFunds(Integer amount);

    void transferFunds(Integer amount, String IFSC, String accountNumber);

    void checkBalance();
}
