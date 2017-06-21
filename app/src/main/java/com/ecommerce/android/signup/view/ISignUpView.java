package com.ecommerce.android.signup.view;

/**
 * Created by GP00471911 on 19-06-2017.
 */

public interface ISignUpView {
    void signUpFailed(String message);
    void SignUpSuccess(String message);
    String getFullName();
    String getEmail();
    String getPassword();
    String getContactNo();
    String getGender();
    String getReferralCode();
    boolean getTermsAndConditionCheckStatus();
    void hideProgressView();
    void showProgressView();
}
