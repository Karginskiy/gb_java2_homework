package lessons.lesson3;

public class PhoneRecord {

    private String number;
    private String email;

    public PhoneRecord(String number, String email) {

        this.number = number;
        this.email = email;

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumbers() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Number = '" + number + '\'' +
                ", email ='" + email + '\'' +
                "\n";
    }
}
