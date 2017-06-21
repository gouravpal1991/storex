package com.ecommerce.android;

import android.app.Application;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by GP00471911 on 31-01-2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Iconify
                .with(new FontAwesomeModule());
    }
}
