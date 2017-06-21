package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.aigestudio.wheelpicker.WheelPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Hour Picker
 *
 * Created by xiaomei on 16/6/17.
 */

public class WheelHourPicker extends WheelPicker implements IWheelHourPicker{
    private int mSelectedHour;

    public WheelHourPicker(Context context) {
        this(context, null);
    }

    public WheelHourPicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            data.add(i);
        }
        super.setData(data);

        mSelectedHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        updateSelectedHour();
    }

    private void updateSelectedHour() {
        setSelectedItemPosition(mSelectedHour);
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelHourPicker");
    }

    @Override
    public int getSelectedHour() {
        return mSelectedHour;
    }

    @Override
    public void setSelectedHour(int hour) {
        mSelectedHour = hour;
        updateSelectedHour();
    }

    @Override
    public int getCurrentHour() {
        return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition())));
    }
}
