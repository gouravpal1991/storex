package com.ecommerce.android.manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.ecommerce.android.basicinfo.BasicInfoActivity;
import com.ecommerce.android.objects.User;

import java.util.HashMap;

/**
 * Created by gouravpal on 09/04/17.
 */

public class SessionManager {
    private static final String IS_BASIC_INFO_STORED = "IsBasicInfoStored";
    private SharedPreferences mPref;
    private static final String APP_PREFERNCE = "ecommap_pref";
    private static final String IS_FIRST_TIME_VISIT = "isFirstTimeVisit";
    private static final String IS_LOGIN = "IsLoggedIn";

    SharedPreferences.Editor mEditor;
    Context mContext;

    public SessionManager(Context context) {
        this.mContext = context;
        mPref = mContext.getSharedPreferences(APP_PREFERNCE, Context.MODE_PRIVATE);
        mEditor = mPref.edit();
    }

    public void saveBoardingSuccessfull() {
        mEditor.putBoolean(IS_FIRST_TIME_VISIT, true);
        mEditor.commit();
    }

    public boolean isFirstTimeVisit() {
        return mPref.getBoolean(IS_FIRST_TIME_VISIT, false);
    }


//    public void logoutUser() {
//        // Clearing all data from Shared Preferences
//        mEditor.clear();
//        mEditor.commit();
//
//        // After logout redirect user to Loing Activity
//        Intent i = new Intent(mContext, LoginActivity.class);
//        // Closing all the Activities
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        // Add new Flag to start new Activity
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//        // Staring Login Activity
//        mContext.startActivity(i);
//    }

    // Get Login State
    public boolean isLoggedIn() {
        return mPref.getBoolean(IS_LOGIN, false);
    }

//    public void createLoginSession(User user, User.Profile profile, String pwd) {
//        mEditor.putBoolean(IS_LOGIN, true);
//        mEditor.putString(ProfileActivity.PROFILE_KEY_UNAME, user.getUserName());
//        mEditor.putString(ProfileActivity.PROFILE_KEY_PWD, pwd);
//        mEditor.putString(ProfileActivity.PROFILE_KEY_FNAME, profile.getFirstName());
//        mEditor.putString(ProfileActivity.PROFILE_KEY_LNAME, profile.getLastName());
//        mEditor.putString(ProfileActivity.PROFILE_KEY_EMAIL, user.getEmail());
//        mEditor.commit();
//    }


    //get basic info stored in preferences
    public HashMap<String, String> getBasicInfo() {
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(BasicInfoActivity.USER_KEY_FULLNAME, mPref.getString(BasicInfoActivity.USER_KEY_FULLNAME, null));
        user.put(BasicInfoActivity.USER_KEY_CONTACT, mPref.getString(BasicInfoActivity.USER_KEY_CONTACT, null));
        return user;
    }


    public void setBasicInfo(String name, String contact) {
        mEditor.putBoolean(IS_BASIC_INFO_STORED, true);
        mEditor.putString(BasicInfoActivity.USER_KEY_FULLNAME, name);
        mEditor.putString(BasicInfoActivity.USER_KEY_CONTACT, contact);
        mEditor.commit();

    }

    public boolean isBasicInfoStored() {
        return mPref.getBoolean(IS_BASIC_INFO_STORED, false);
    }
}
