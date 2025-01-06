public abstract class Account {
    protected String holderName;
    protected double accountBalance;
    private Pin pin; 

    public Account(String holderName, double accountBalance, int pin) {
        this.holderName = holderName;
        this.accountBalance = accountBalance;
        this.pin = new Pin(pin); 
    }

    public boolean verifyPin(int enteredPin) {
        return this.pin.verifyPin(enteredPin);
    }

    public void updatePin(int oldPin, int newPin) {
        this.pin.updatePin(oldPin, newPin);
    }

    public abstract void showAccountDetails();
}
