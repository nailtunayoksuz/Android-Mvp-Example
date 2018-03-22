package tr.com.nuevo.androidmvpexaple.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import tr.com.nuevo.androidmvpexaple.MainActivity;
import tr.com.nuevo.androidmvpexaple.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText edUserName ,edPassword;
    private Button btnDone;
    private ProgressBar pbLoad;

    private LoginPresenter mLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLoginPresenter = new LoginPresenterImp(this);

        edPassword=findViewById(R.id.ed_password);
        edUserName=findViewById(R.id.ed_user_name);
        btnDone=findViewById(R.id.btn_done);
        pbLoad=findViewById(R.id.pb_load);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.validateCreds(edUserName.getText().toString().trim(),edPassword.getText().toString().trim());
            }
        });

    }

    @Override
    public void showProgress() {
        pbLoad.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoad.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        edUserName.setError("UserName Empty");
    }

    @Override
    public void setPasswordError() {
        edPassword.setError("Password Empty");
    }

    @Override
    public void navigateToMain() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
    }
}
