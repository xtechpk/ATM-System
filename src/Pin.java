public class Pin {
    private int pin;

    public Pin(int pin) {
        this.pin = pin;
    }

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public void updatePin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            System.out.println("PIN updated successfully!");
        } else {
            System.out.println("Old PIN is incorrect!");
        }
    }
}
