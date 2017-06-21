package com.ecommerce.android.signup.presenter;

import android.text.TextUtils;
import android.widget.Toast;

import com.ecommerce.android.objects.User;
import com.ecommerce.android.signup.listener.OnSignUpFinishedListener;
import com.ecommerce.android.signup.model.SignUpInteractor;
import com.ecommerce.android.signup.view.ISignUpView;

/**
 * Created by GP00471911 on 19-06-2017.
 */

public class SignUpPresenter implements ISignUpPresenter, OnSignUpFinishedListener {

    private final ISignUpView mView;
    private final SignUpInteractor mInteractor;

    public SignUpPresenter(ISignUpView view) {
        this.mView = view;
        this.mInteractor = new SignUpInteractor();
    }

    @Override
    public boolean validateFields(User user) {
        if (TextUtils.isEmpty(user.getFullName())) {
            mView.signUpFailed("Please enter full name.");
            return false;
        }
        if (TextUtils.isEmpty(user.getEmail())) {
            mView.signUpFailed("Please enter valid email id.");
            return false;
        }
        if (TextUtils.isEmpty(user.getPassword())) {
            mView.signUpFailed("Please enter valid password.");
            return false;
        }
        if (TextUtils.isEmpty(user.getContactNo())) {
            mView.signUpFailed("Please enter contact number.");
            return false;
        }
        if (TextUtils.isEmpty(user.getGender())) {
            mView.signUpFailed("Please select gender.");
            return false;
        }

        if (!mView.getTermsAndConditionCheckStatus()) {
            mView.signUpFailed("Please accept terms and condition.");
            return false;
        }
        return true;
    }

    @Override
    public void attemptSignUpFormSubmission() {
        mView.showProgressView();

        User user = new User();
        user.setFullName(mView.getFullName());
        user.setEmail(mView.getEmail());
        user.setPassword(mView.getPassword());
        user.setContactNo(mView.getContactNo());
        user.setGender(mView.getGender());
        user.setReferralCode(mView.getReferralCode());

        if (validateFields(user)) {
            mInteractor.submitSignUp(this, user);
            return;
        }
        mView.hideProgressView();
    }

    @Override
    public void onSignUpSuccess() {

    }

    @Override
    public void onSignUpFailure(String message) {
        mView.signUpFailed(message);
    }
}
