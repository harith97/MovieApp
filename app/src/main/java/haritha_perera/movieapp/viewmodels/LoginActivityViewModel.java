package haritha_perera.movieapp.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import haritha_perera.movieapp.MovieListActivity;
import haritha_perera.movieapp.auth.LoginActivity;
import haritha_perera.movieapp.models.LoginUser;


public class LoginActivityViewModel extends ViewModel {

    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();

    private MutableLiveData<LoginUser> userMutableLiveData;

    public MutableLiveData<LoginUser> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }



    public void loginBtnClicked(View view){
        LoginUser loginUser = new LoginUser(EmailAddress.getValue(), Password.getValue());
        userMutableLiveData.setValue(loginUser);
    }

    public void registerBtnClicked(View view){
        Context context = view.getContext();
        //context.startActivity(new Intent(context, RegisterMeAcitivity.class));

    }

    public void forgetPwBtnClicked(View view){
        Context context = view.getContext();
        //context.startActivity(new Intent(context, ForgetPw.class));
    }


}
