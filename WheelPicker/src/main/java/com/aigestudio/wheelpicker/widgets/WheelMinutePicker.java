package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.aigestudio.wheelpicker.WheelPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Minute Picker
 *
 * Created by xiaomei on 16/6/17.
 */

public class WheelMinutePicker extends WheelPicker implements IWheelMinutePicker{
    private int mSelectedMinute;

    public WheelMinutePicker(Context context) {
        this(context, null);
    }

    public WheelMinutePicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            data.add(i);
        }
        super.setData(data);

        mSelectedMinute = Calendar.getInstance().get(Calendar.MINUTE);
        updateSelectedMinute();
    }

    private void updateSelectedMinute() {
        setSelectedItemPosition(mSelectedMinute);
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelHourPicker");
    }

    @Override
    public int getSelectedMinute() {
        return mSelectedMinute;
    }

    @Override
    public void setSelectedMinute(int minute) {
        mSelectedMinute = minute;
        updateSelectedMinute();
    }

    @Override
    public int getCurrentMinute() {
        return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition())));
    }
}
