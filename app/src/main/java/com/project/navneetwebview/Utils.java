package com.project.navneetwebview;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class Utils {
    public static boolean isNetworkConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni=cm.getActiveNetworkInfo();
        if(ni==null)
            return false;
        else
            return true;
    }
}
