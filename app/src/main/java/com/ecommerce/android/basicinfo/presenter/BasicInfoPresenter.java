package com.ecommerce.android.basicinfo.presenter;

import android.text.TextUtils;

import com.ecommerce.android.basicinfo.listener.OnBasicInfoFinishedListener;
import com.ecommerce.android.basicinfo.model.BasicInfoInteractor;
import com.ecommerce.android.basicinfo.view.IBasicInfoView;
import com.ecommerce.android.objects.User;
import com.ecommerce.android.signup.listener.OnSignUpFinishedListener;
import com.ecommerce.android.signup.model.SignUpInteractor;
import com.ecommerce.android.signup.view.ISignUpView;

/**
 * Created by GP00471911 on 19-06-2017.
 */

public class BasicInfoPresenter implements IBasicInfoPresenter, OnBasicInfoFinishedListener {

    private final IBasicInfoView mView;
    private final BasicInfoInteractor mInteractor;

    public BasicInfoPresenter(IBasicInfoView view) {
        this.mView = view;
        this.mInteractor = new BasicInfoInteractor();
    }

    @Override
    public boolean validateFields(User user) {
        if (TextUtils.isEmpty(user.getFullName())) {
            mView.basicInfoFailed("Please enter full name.");
            return false;
        }

        if (TextUtils.isEmpty(user.getContactNo())) {
            mView.basicInfoFailed("Please enter contact number.");
            return false;
        }

        if (!mView.getTermsAndConditionCheckStatus()) {
            mView.basicInfoFailed("Please accept terms and condition.");
            return false;
        }
        return true;
    }

    @Override
    public void attemptBasicInfoSubmission() {
        mView.showProgressView();

        User user = new User();
        user.setFullName(mView.getFullName());
        user.setContactNo(mView.getContactNo());

        if (validateFields(user)) {
            mInteractor.submitBasicInfo(this, user);
            return;
        }
        mView.hideProgressView();
    }


    @Override
    public void onBasicInfoSuccess() {

    }

    @Override
    public void onBasicInfoFailure(String message) {
        mView.basicInfoFailed(message);
    }
}
