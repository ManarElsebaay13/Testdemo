package com.example.testdemo;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;


public class CustomSpinner extends AppCompatSpinner {

    public interface OnSpinnerEventsListener {
        void onPopupWindowOpened(Spinner spinner);
        void onPopupWindowClosed(Spinner spinner);
        void onPopupWindowOpened2(Spinner spinner);
        void onPopupWindowClosed2(Spinner spinner);
    }

    private OnSpinnerEventsListener mListener1,mListener2;
    private boolean mOpenInitiated1 = false;
    private boolean mOpenInitiated2 = false;


    public CustomSpinner(Context context) {
        super(context);
    }

    public CustomSpinner(@NonNull Context context, @Nullable AttributeSet attrs) {super(context, attrs);}

    public CustomSpinner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean performClick() {
        if (mListener1 != null) {
            mOpenInitiated1 = true;
            mListener1.onPopupWindowOpened(this);
        }else
            if (mListener2 != null) {
            mOpenInitiated2 = true;
            mListener2.onPopupWindowOpened2(this);}

        return super.performClick();
    }

    @Override
    public void onWindowFocusChanged (boolean hasFocus) {
        if (hasBeenOpened1() && hasFocus) {
            performClosedEvent1();
        }

        if (hasBeenOpened2() && hasFocus) {
            performClosedEvent2();
        }
    }

    public void setSpinnerEventsListener(OnSpinnerEventsListener onSpinnerEventsListener) {
        mListener1 = onSpinnerEventsListener;
    }

    public void setSpinnerEventsListener2(OnSpinnerEventsListener onSpinnerEventsListener) {
        mListener2 = onSpinnerEventsListener;
    }


    public void performClosedEvent1() {
        mOpenInitiated1 = false;
        if (mListener1 != null) {
            mListener1.onPopupWindowClosed(this);
        }
    }

    public boolean hasBeenOpened1() {
        return mOpenInitiated1;
    }

    public void performClosedEvent2() {
        mOpenInitiated2 = false;
        if (mListener2 != null) {
            mListener2.onPopupWindowClosed2(this);
        }
    }

    public boolean hasBeenOpened2() {
        return mOpenInitiated2;
    }

}
