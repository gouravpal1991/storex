package com.ecommerce.android.basicinfo.view;

/**
 * Created by GP00471911 on 19-06-2017.
 */

public interface IBasicInfoView {
    void basicInfoFailed(String message);
    void basicInfoSuccess(String message);
    String getFullName();
    String getContactNo();
    boolean getTermsAndConditionCheckStatus();
    void hideProgressView();
    void showProgressView();
}
