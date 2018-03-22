package tr.com.nuevo.androidmvpexaple.login;

/**
 * Created by nuevomacpro13 on 22.03.2018.
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUserNameError();
    void setPasswordError();
    void navigateToMain();
    void showAlert(String message);
}
