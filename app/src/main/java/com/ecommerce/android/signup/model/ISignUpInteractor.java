package com.ecommerce.android.signup.model;

import com.ecommerce.android.objects.User;
import com.ecommerce.android.signup.listener.OnSignUpFinishedListener;

/**
 * Created by GP00471911 on 19-06-2017.
 */

public interface ISignUpInteractor {
    void submitSignUp(OnSignUpFinishedListener listener, User user);
}
