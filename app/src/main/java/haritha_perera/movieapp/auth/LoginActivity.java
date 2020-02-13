package haritha_perera.movieapp.auth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import haritha_perera.movieapp.MainActivity;
import haritha_perera.movieapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mEmailField;
    private EditText mPasswordField;
    private static final String TAG = "EmailPassword";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.textView3).setOnClickListener(this);
        findViewById(R.id.registerpage2).setOnClickListener(this);
        mEmailField = findViewById(R.id.editText);
        mPasswordField = findViewById(R.id.editText2);



    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.button3) {
            boolean isLoginSuccess = true;
            if(isLoginSuccess) {
                startActivity(new Intent(this, MainActivity.class));
            }
        }else if (i == R.id.textView3) {
            //startActivity(new Intent(this, ForgetPasswordActivity.class));
        } else if (i == R.id.registerpage2) {
            //startActivity(new Intent(this, RegisterActivity.class));
        }
    }









}
