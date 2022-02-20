package clean.code.dependency.verification;

public class Verification {

    private int age;
    private boolean valid;

    public Verification(int age) {
        this.age = age;
        this.valid = age > 1 && age < 18;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
