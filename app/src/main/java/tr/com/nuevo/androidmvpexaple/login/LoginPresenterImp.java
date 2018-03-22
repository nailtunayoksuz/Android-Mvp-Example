package tr.com.nuevo.androidmvpexaple.login;

/**
 * Created by nuevomacpro13 on 22.03.2018.
 */

public class LoginPresenterImp implements LoginPresenter,LoginInteractor.onLoginFinishedListener {
    LoginView mLoginView;
    LoginInteractor mLoginInteractor;

    public LoginPresenterImp(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginInteractor = new LoginInteractorImp();
    }

    @Override
    public void validateCreds(String userName, String password) {
        if (mLoginView!=null) {
            mLoginView.showProgress();
            mLoginInteractor.login(userName, password, this);
        }
    }

    @Override
    public void onDestroy() {
        if (mLoginView!=null){
            mLoginView=null;
        }
    }

    @Override
    public void onUserNameError() {
        if (mLoginView!=null){
           mLoginView.hideProgress();
           mLoginView.setUserNameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (mLoginView!=null){
            mLoginView.hideProgress();
            mLoginView.setPasswordError();
        }
    }

    @Override
    public void onSuccess() {
        if (mLoginView!=null){
            mLoginView.hideProgress();
            mLoginView.navigateToMain();
        }
    }

    @Override
    public void onFailure(String message) {
        if (mLoginView!=null){
            mLoginView.hideProgress();
            mLoginView.showAlert(message);
        }
    }
}
