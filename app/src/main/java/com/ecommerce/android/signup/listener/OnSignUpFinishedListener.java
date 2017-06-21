package com.ecommerce.android.signup.listener;

/**
 * Created by GP00471911 on 19-06-2017.
 */

public interface OnSignUpFinishedListener {
    void onSignUpSuccess();
    void onSignUpFailure(String message);
}
