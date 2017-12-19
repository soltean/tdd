public class Money implements Expression {

    protected int amount;
    protected String currency;

    public Money(int i, String currency) {
        this.amount = i;
        this.currency = currency;
    }

    public String currency() {
        return currency;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount
                && currency().equals(money.currency());
    }

    public Money times(int i) {
        return new Money(i * amount, currency) {
        };
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return amount;
    }

    static Money dollar(int i) {
        return new Money(i, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Money reduce(String to) {
        return this;
    }

}
