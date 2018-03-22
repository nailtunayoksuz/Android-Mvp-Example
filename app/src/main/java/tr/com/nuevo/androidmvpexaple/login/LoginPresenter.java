package tr.com.nuevo.androidmvpexaple.login;

/**
 * Created by nuevomacpro13 on 22.03.2018.
 */

public interface LoginPresenter {
    void validateCreds(String userName,String password);
    void onDestroy();

}
