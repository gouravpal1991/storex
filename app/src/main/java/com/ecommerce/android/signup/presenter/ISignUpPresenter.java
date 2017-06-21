package com.ecommerce.android.signup.presenter;

import com.ecommerce.android.objects.User;

/**
 * Created by GP00471911 on 19-06-2017.
 */

public interface ISignUpPresenter {
    boolean validateFields(User user);
    void attemptSignUpFormSubmission();
}
