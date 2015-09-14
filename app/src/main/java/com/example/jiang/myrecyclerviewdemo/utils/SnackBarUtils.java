package com.example.jiang.myrecyclerviewdemo.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by jiang on 15/9/14.
 */
public class SnackBarUtils {


    public static void showShortSnackBar(View v, String mText) {
        Snackbar.make(v, mText, Snackbar.LENGTH_SHORT).show();

    }


    public static void showCustomColorLongSnackBar(View v, String mText) {
        Snackbar.make(v, mText, Snackbar.LENGTH_LONG).show();
    }


    public static void showShortCallBackSnackBar(View v, String mText, String actionText, final SnackBarCallBack callBack) {
        showCallBackSnackBar(v, mText, actionText, callBack, Snackbar.LENGTH_SHORT);

    }

    private static void showCallBackSnackBar(final View v, String mText, String mActionText, final SnackBarCallBack callBack, int LENTGH) {
        Snackbar.make(v, mText, LENTGH).setAction(mActionText, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callBack != null) {
                    callBack.viewClicked(view);
                }
            }
        }).show();
    }


    public static void showLongCallBackSnackBar(final View v, String mText, String actionText, final SnackBarCallBack callBack) {
        showCallBackSnackBar(v, mText, actionText, callBack, Snackbar.LENGTH_LONG);

    }


    interface SnackBarCallBack {
        public void viewClicked(View v);

    }


}
