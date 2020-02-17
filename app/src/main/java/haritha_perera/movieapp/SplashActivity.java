package haritha_perera.movieapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import haritha_perera.movieapp.auth.LoginActivity;
import haritha_perera.movieapp.databinding.SplashBinding;

import static java.lang.Thread.sleep;

/**
 * Created by harithaperera on 4/29/17.
 */
public class SplashActivity extends AppCompatActivity {

    private SplashBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(SplashActivity.this, R.layout.splash);




        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                startActivity(new Intent(SplashActivity.this, LoginActivity.class));

                // overridePendingTransition(R.animator.transition1, R.animator.transition2);
                finish();
            }
        }).start();




    }




}
