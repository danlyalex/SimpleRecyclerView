package com.example.jiang.myrecyclerviewdemo.utils;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.example.jiang.myrecyclerviewdemo.R;

/**
 * Created by jiang on 15/9/14.
 */
public class SnackBarUtils {


    public static void showShortSnackBar(View v, String mText) {
        Snackbar snackBar = Snackbar.make(v, mText, Snackbar.LENGTH_SHORT);
        setSnackBarMessageTextColor(snackBar);
        snackBar.show();

    }


    public static void setSnackBarMessageTextColor(Snackbar bar) {
        ((TextView) bar.getView().findViewById(R.id.snackbar_text)).setTextColor(Color.WHITE);
    }


    public static void showCustomColorLongSnackBar(View v, String mText) {
        Snackbar bar = Snackbar.make(v, mText, Snackbar.LENGTH_LONG);
        setSnackBarMessageTextColor(bar);
        bar.show();
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
