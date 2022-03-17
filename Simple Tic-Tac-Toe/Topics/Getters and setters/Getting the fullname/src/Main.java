
class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
        // write your code here
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
        // write your code here
    }

    public String getFullName() {
        if ("".equals(firstName) && lastName.equals(firstName)) {
            return "Unknown";
        } else  if ("".equals(firstName)) {
            return lastName;
        } else if ("".equals(lastName)) {
            return firstName;
        }
        return firstName + " " + lastName;
        // write your code here
    }
}