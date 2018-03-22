package tr.com.nuevo.androidmvpexaple.login;

/**
 * Created by nuevomacpro13 on 22.03.2018.
 */

public interface LoginInteractor  {
    interface onLoginFinishedListener{
        void onUserNameError();
        void onPasswordError();
        void onSuccess();
        void onFailure(String message);
    }

    void login(String userName,String password,onLoginFinishedListener listener);
}
