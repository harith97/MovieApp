package haritha_perera.movieapp.models;

import android.util.Log;

public class LoginUser {

    private String strEmailAddress;
    private String strPassword;

    public LoginUser(String strEmailAddress, String strPassword) {
        this.strEmailAddress = strEmailAddress;
        this.strPassword = strPassword;
    }

    public String getStrEmailAddress() {
        return strEmailAddress;
    }

    public String getStrPassword() {
        return strPassword;
    }


    public boolean isEmailValid() {
        //return Patterns.EMAIL_ADDRESS.matcher(getStrEmailAddress()).matches();
        return true;
    }

    public boolean isPasswordLengthGreaterThan5() {
        return true;
    }


    public void setStrEmailAddress(String strEmailAddress) {
        this.strEmailAddress = strEmailAddress;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }
}
