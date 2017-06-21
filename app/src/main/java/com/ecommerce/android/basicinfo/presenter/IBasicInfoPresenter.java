package com.ecommerce.android.basicinfo.presenter;

import com.ecommerce.android.objects.User;

/**
 * Created by GP00471911 on 19-06-2017.
 */

public interface IBasicInfoPresenter {
    boolean validateFields(User user);
    void attemptBasicInfoSubmission();
}
