package Entries;

public class User extends ASimpleEntry {

    private String userName;
    private String password;
    private String birthDate;
    private String firstName;
    private String lastName;


    public User(String userName, String password, String birthDate, String firstName, String lastName) throws Exception {
        if(isStringEmpty(userName) || isStringEmpty(password) || isStringEmpty(birthDate) || isStringEmpty(firstName) || isStringEmpty(lastName))
            throw new Exception("One or more of the values missing");
        if(!(StringChecker.isWriting(firstName) && StringChecker.isWriting(lastName)))
            throw  new Exception("first or last name contain invalid characters");
        this.userName=userName;
        this.password=password;
        this.birthDate=birthDate;
        this.firstName=firstName;
        this.lastName=lastName;
    }
    @Override
    protected String getTableName() {
        return "Users";
    }

    @Override
    protected String[] getValuesTitles() {
        String[] titles = new String[5];
        titles[0]="Username";
        titles[1]="Password";
        titles[2]="Birth_Date";
        titles[3]="First_Name";
        titles[4]="Last_Name";
        return titles;
    }

    @Override
    public String[] getValues() {
        String[] values = new String[5];
        values[0] = userName;
        values[1] = password;
        values[2] = birthDate;
        values[3] = firstName;
        values[4] = lastName;
        return values;
    }

    public String toString(){
        return "Username: " + userName + "\nPassword: " + password + "\nFirst Name: " + firstName + "Last Name: " + lastName + "\nBirthDate: " + birthDate;
    }

    public boolean equals(Object other){
        boolean ans = (other instanceof User);
        if(ans) {
            String[] theseValues = getValues();
            String[] otherValues = ((User)other).getValues();
            for (int i = 0; i < theseValues.length && ans; i++) {
                ans = StringChecker.stringsAreEqual(theseValues[i], otherValues[i]);
            }
        }
        return ans;
    }

}
