package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.aigestudio.wheelpicker.IDebug;
import com.aigestudio.wheelpicker.IWheelPicker;
import com.aigestudio.wheelpicker.R;
import com.aigestudio.wheelpicker.WheelPicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by xiaomei on 16/6/17.
 */

public class WheeliOSLikeDateTimePicker extends LinearLayout implements WheelPicker.OnItemSelectedListener,
        IDebug, IWheelPicker, IWheeliOSDayPicker, IWheelHourPicker, IWheelMinutePicker, IWheeliOSLikeDateTimePicker {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("EEE dd MMM hh mm", Locale.getDefault());

    private WheeliOSDayPicker mPickeriOSDay;
    private WheelHourPicker mPickerHour;
    private WheelMinutePicker mPickerMinute;

    private OnDateSelectedListener mListener;

    private WheeliOSDayPicker.IOSLikeDate miOSDay;
    private int mHour, mMinute;

    public WheeliOSLikeDateTimePicker(Context context) {
        this(context, null);
    }

    public WheeliOSLikeDateTimePicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_wheel_ios_date_picker, this);

        mPickeriOSDay = (WheeliOSDayPicker) findViewById(R.id.wheel_ios_date_picker_day);
        mPickerHour = (WheelHourPicker) findViewById(R.id.wheel_ios_date_picker_hour);
        mPickerMinute = (WheelMinutePicker) findViewById(R.id.wheel_ios_date_picker_minute);

        mPickeriOSDay.setOnItemSelectedListener(this);
        mPickerHour.setOnItemSelectedListener(this);
        mPickerMinute.setOnItemSelectedListener(this);

        setMaximumWidthTextiOSDay();
        mPickerHour.setMaximumWidthText("00");
        mPickerMinute.setMaximumWidthText("00");

        Calendar calendar = Calendar.getInstance();
        mHour = calendar.get(Calendar.HOUR_OF_DAY);
        mMinute = calendar.get(Calendar.MINUTE);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        miOSDay = new WheeliOSDayPicker.IOSLikeDate();
        miOSDay.date = calendar.getTime();
        mPickeriOSDay.setSelectediOSLikeDay(miOSDay);
        mPickerHour.setSelectedHour(mHour);
        mPickerMinute.setSelectedMinute(mMinute);
    }

    private void setMaximumWidthTextiOSDay() {
        List iOSDays = mPickeriOSDay.getData();
        int maxWidth = 0;
        String maxWidthText = "";
        for (int i = 0; i < iOSDays.size(); i++) {
            String iOSDay = String.valueOf(iOSDays.get(i));
            if (iOSDay.length() > maxWidth) {
                maxWidth = iOSDay.length();
                maxWidthText = iOSDay;
            }
        }
        mPickeriOSDay.setMaximumWidthText(maxWidthText);
    }

    @Override
    public void setDebug(boolean isDebug) {
        mPickeriOSDay.setDebug(isDebug);
        mPickerHour.setDebug(isDebug);
        mPickerMinute.setDebug(isDebug);
    }

    @Override
    public int getSelectedHour() {
        return mPickerHour.getSelectedHour();
    }

    @Override
    public void setSelectedHour(int hour) {
        mPickerHour.setSelectedHour(hour);
    }

    @Override
    public int getCurrentHour() {
        return mPickerHour.getCurrentHour();
    }

    @Override
    public int getSelectedMinute() {
        return mPickerMinute.getSelectedMinute();
    }

    @Override
    public void setSelectedMinute(int minute) {
        mPickerMinute.setSelectedMinute(minute);
    }

    @Override
    public int getCurrentMinute() {
        return mPickerMinute.getCurrentMinute();
    }

    @Override
    public WheeliOSDayPicker.IOSLikeDate getSelectediOSLikeDay() {
        return mPickeriOSDay.getSelectediOSLikeDay();
    }

    @Override
    public void setSelectediOSLikeDay(WheeliOSDayPicker.IOSLikeDate day) {
        mPickeriOSDay.setSelectediOSLikeDay(day);
    }

    @Override
    public WheeliOSDayPicker.IOSLikeDate getCurrentiOSLikeDay() {
        return mPickeriOSDay.getCurrentiOSLikeDay();
    }

    @Override
    public int getYear() {
        return mPickeriOSDay.getYear();
    }

    @Override
    public int getMonth() {
        return mPickeriOSDay.getMonth();
    }

    @Override
    public int getDay() {
        return mPickeriOSDay.getDay();
    }

    @Override
    public void setDayStart(WheeliOSDayPicker.IOSLikeDate startDay) {
        mPickeriOSDay.setDayStart(startDay);
    }

    @Override
    public void setDayEnd(WheeliOSDayPicker.IOSLikeDate endDay) {
        mPickeriOSDay.setDayEnd(endDay);
    }

    @Override
    public int getVisibleItemCount() {
        if (mPickeriOSDay.getVisibleItemCount() == mPickerHour.getVisibleItemCount() &&
                mPickerHour.getVisibleItemCount() == mPickerMinute.getVisibleItemCount())
            return mPickeriOSDay.getVisibleItemCount();
        throw new ArithmeticException("Can not get visible item count correctly from" +
                "WheeliOSLikeDateTimePicker!");
    }

    @Override
    public void setVisibleItemCount(int count) {
        mPickeriOSDay.setVisibleItemCount(count);
        mPickerHour.setVisibleItemCount(count);
        mPickerMinute.setVisibleItemCount(count);
    }

    @Override
    public boolean isCyclic() {
        return mPickeriOSDay.isCyclic() && mPickerHour.isCyclic() && mPickerMinute.isCyclic();
    }

    @Override
    public void setCyclic(boolean isCyclic) {
        mPickeriOSDay.setCyclic(isCyclic);
        mPickerHour.setCyclic(isCyclic);
        mPickerMinute.setCyclic(isCyclic);
    }

    @Override
    public void setOnItemSelectedListener(WheelPicker.OnItemSelectedListener listener) {
        throw new UnsupportedOperationException("You can not set OnItemSelectedListener for" +
                "WheeliOSLikeDateTimePicker");
    }

    @Override
    public int getSelectedItemPosition() {
        throw new UnsupportedOperationException("You can not get position of selected item from" +
                "WheeliOSLikeDateTimePicker");
    }

    @Override
    public void setSelectedItemPosition(int position) {
        throw new UnsupportedOperationException("You can not set position of selected item for" +
                "WheeliOSLikeDateTimePicker");
    }

    @Override
    public int getCurrentItemPosition() {
        throw new UnsupportedOperationException("You can not get position of current item from" +
                "WheeliOSLikeDateTimePicker");
    }

    @Override
    public List getData() {
        throw new UnsupportedOperationException("You can not get data source from WheeliOSLikeDateTimePicker");
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You don't need to set data source for" +
                "WheeliOSLikeDateTimePicker");
    }

    @Override
    public void setSameWidth(boolean hasSameSize) {
        throw new UnsupportedOperationException("You don't need to set same width for" +
                "WheeliOSLikeDateTimePicker");
    }

    @Override
    public boolean hasSameWidth() {
        throw new UnsupportedOperationException("You don't need to set same width for" +
                "WheeliOSLikeDateTimePicker");
    }

    @Override
    public void setOnWheelChangeListener(WheelPicker.OnWheelChangeListener listener) {
        throw new UnsupportedOperationException("WheeliOSLikeDateTimePicker unsupport set" +
                "OnWheelChangeListener");
    }

    @Override
    public String getMaximumWidthText() {
        throw new UnsupportedOperationException("You can not get maximum width text from" +
                "WheeliOSLikeDateTimePicker");
    }

    @Override
    public void setMaximumWidthText(String text) {
        throw new UnsupportedOperationException("You don't need to set maximum width text for" +
                "WheeliOSLikeDateTimePicker");
    }

    @Override
    public int getMaximumWidthTextPosition() {
        throw new UnsupportedOperationException("You can not get maximum width text position" +
                "from WheeliOSLikeDateTimePicker");
    }

    @Override
    public void setMaximumWidthTextPosition(int position) {
        throw new UnsupportedOperationException("You don't need to set maximum width text" +
                "position for WheeliOSLikeDateTimePicker");
    }

    @Override
    public int getSelectedItemTextColor() {
        if (mPickeriOSDay.getSelectedItemTextColor() == mPickerHour.getSelectedItemTextColor() &&
                mPickerHour.getSelectedItemTextColor() == mPickerMinute.getSelectedItemTextColor())
            return mPickeriOSDay.getSelectedItemTextColor();
        throw new RuntimeException("Can not get color of selected item text correctly from" +
                "WheeliOSLikeDateTimePicker!");
    }

    @Override
    public void setSelectedItemTextColor(int color) {
        mPickeriOSDay.setSelectedItemTextColor(color);
        mPickerHour.setSelectedItemTextColor(color);
        mPickerMinute.setSelectedItemTextColor(color);
    }

    @Override
    public int getItemTextColor() {
        if (mPickeriOSDay.getItemTextColor() == mPickerHour.getItemTextColor() &&
                mPickerHour.getItemTextColor() == mPickerMinute.getItemTextColor())
            return mPickeriOSDay.getItemTextColor();
        throw new RuntimeException("Can not get color of item text correctly from" +
                "WheeliOSLikeDateTimePicker!");
    }

    @Override
    public void setItemTextColor(int color) {
        mPickeriOSDay.setItemTextColor(color);
        mPickerHour.setItemTextColor(color);
        mPickerMinute.setItemTextColor(color);
    }

    @Override
    public int getItemTextSize() {
        if (mPickeriOSDay.getItemTextSize() == mPickerHour.getItemTextSize() &&
                mPickerHour.getItemTextSize() == mPickerMinute.getItemTextSize())
            return mPickeriOSDay.getItemTextSize();
        throw new RuntimeException("Can not get size of item text correctly from" +
                "WheeliOSLikeDateTimePicker!");
    }

    @Override
    public void setItemTextSize(int size) {
        mPickeriOSDay.setItemTextSize(size);
        mPickerHour.setItemTextSize(size);
        mPickerMinute.setItemTextSize(size);
    }

    @Override
    public int getItemSpace() {
        if (mPickeriOSDay.getItemSpace() == mPickerHour.getItemSpace() &&
                mPickerHour.getItemSpace() == mPickerMinute.getItemSpace())
            return mPickeriOSDay.getItemSpace();
        throw new RuntimeException("Can not get item space correctly from WheeliOSLikeDateTimePicker!");
    }

    @Override
    public void setItemSpace(int space) {
        mPickeriOSDay.setItemSpace(space);
        mPickerHour.setItemSpace(space);
        mPickerMinute.setItemSpace(space);
    }

    @Override
    public void setIndicator(boolean hasIndicator) {
        mPickeriOSDay.setIndicator(hasIndicator);
        mPickerHour.setIndicator(hasIndicator);
        mPickerMinute.setIndicator(hasIndicator);
    }

    @Override
    public boolean hasIndicator() {
        return mPickeriOSDay.hasIndicator() && mPickerHour.hasIndicator() &&
                mPickerMinute.hasIndicator();
    }

    @Override
    public int getIndicatorSize() {
        if (mPickeriOSDay.getIndicatorSize() == mPickerHour.getIndicatorSize() &&
                mPickerHour.getIndicatorSize() == mPickerMinute.getIndicatorSize())
            return mPickeriOSDay.getIndicatorSize();
        throw new RuntimeException("Can not get indicator size correctly from WheeliOSLikeDateTimePicker!");
    }

    @Override
    public void setIndicatorSize(int size) {
        mPickeriOSDay.setIndicatorSize(size);
        mPickerHour.setIndicatorSize(size);
        mPickerMinute.setIndicatorSize(size);
    }

    @Override
    public int getIndicatorColor() {
        if (mPickeriOSDay.getCurtainColor() == mPickerHour.getCurtainColor() &&
                mPickerHour.getCurtainColor() == mPickerMinute.getCurtainColor())
            return mPickeriOSDay.getCurtainColor();
        throw new RuntimeException("Can not get indicator color correctly from WheeliOSLikeDateTimePicker!");
    }

    @Override
    public void setIndicatorColor(int color) {
        mPickeriOSDay.setIndicatorColor(color);
        mPickerHour.setIndicatorColor(color);
        mPickerMinute.setIndicatorColor(color);
    }

    @Override
    public void setCurtain(boolean hasCurtain) {
        mPickeriOSDay.setCurtain(hasCurtain);
        mPickerHour.setCurtain(hasCurtain);
        mPickerMinute.setCurtain(hasCurtain);
    }

    @Override
    public boolean hasCurtain() {
        return mPickeriOSDay.hasCurtain() && mPickerHour.hasCurtain() &&
                mPickerMinute.hasCurtain();
    }

    @Override
    public int getCurtainColor() {
        if (mPickeriOSDay.getCurtainColor() == mPickerHour.getCurtainColor() &&
                mPickerHour.getCurtainColor() == mPickerMinute.getCurtainColor())
            return mPickeriOSDay.getCurtainColor();
        throw new RuntimeException("Can not get curtain color correctly from WheeliOSLikeDateTimePicker!");
    }

    @Override
    public void setCurtainColor(int color) {
        mPickeriOSDay.setCurtainColor(color);
        mPickerHour.setCurtainColor(color);
        mPickerMinute.setCurtainColor(color);
    }

    @Override
    public void setAtmospheric(boolean hasAtmospheric) {
        mPickeriOSDay.setAtmospheric(hasAtmospheric);
        mPickerHour.setAtmospheric(hasAtmospheric);
        mPickerMinute.setAtmospheric(hasAtmospheric);
    }

    @Override
    public boolean hasAtmospheric() {
        return mPickeriOSDay.hasAtmospheric() && mPickerHour.hasAtmospheric() &&
                mPickerMinute.hasAtmospheric();
    }

    @Override
    public boolean isCurved() {
        return mPickeriOSDay.isCurved() && mPickerHour.isCurved() && mPickerMinute.isCurved();
    }

    @Override
    public void setCurved(boolean isCurved) {
        mPickeriOSDay.setCurved(isCurved);
        mPickerHour.setCurved(isCurved);
        mPickerMinute.setCurved(isCurved);
    }

    @Override
    public int getItemAlign() {
        throw new UnsupportedOperationException("You can not get item align from WheeliOSLikeDateTimePicker");
    }

    @Override
    public void setItemAlign(int align) {
        throw new UnsupportedOperationException("You don't need to set item align for" +
                "WheeliOSLikeDateTimePicker");
    }

    @Override
    public Typeface getTypeface() {
        if (mPickeriOSDay.getTypeface().equals(mPickerHour.getTypeface()) &&
                mPickerHour.getTypeface().equals(mPickerMinute.getTypeface()))
            return mPickeriOSDay.getTypeface();
        throw new RuntimeException("Can not get typeface correctly from WheelDatePicker!");
    }

    @Override
    public void setTypeface(Typeface tf) {
        mPickeriOSDay.setTypeface(tf);
        mPickerHour.setTypeface(tf);
        mPickerMinute.setTypeface(tf);
    }

    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {
        if (picker.getId() == R.id.wheel_ios_date_picker_day) {
            miOSDay = (WheeliOSDayPicker.IOSLikeDate) data;
        } else if (picker.getId() == R.id.wheel_ios_date_picker_hour) {
            mHour = (int) data;
        } else if (picker.getId() == R.id.wheel_ios_date_picker_minute) {
            mMinute = (int) data;
        }
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date today = calendar.getTime();
        if (!miOSDay.date.before(today)) {
            mHour = hour;
            mMinute = minute;
            mPickerHour.setSelectedHour(mHour);
            mPickerMinute.setSelectedMinute(mMinute);
        }
        Calendar.getInstance();
        calendar.setTime(miOSDay.date);
        calendar.set(Calendar.HOUR_OF_DAY, mHour);
        calendar.set(Calendar.MINUTE, mMinute);
        if (null != mListener) {
            mListener.onDateSelected(this, calendar.getTime());
        }
    }

    @Override
    public void setOnDateSelectedListener(OnDateSelectedListener listener) {
        mListener = listener;
    }

    @Override
    public Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(miOSDay.date);
        calendar.set(Calendar.HOUR_OF_DAY, mHour);
        calendar.set(Calendar.MINUTE, mMinute);
        return calendar.getTime();
    }

    @Override
    public int getItemAligniOSDay() {
        return mPickeriOSDay.getItemAlign();
    }

    @Override
    public void setItemAligniOSDay(int align) {
        mPickeriOSDay.setItemAlign(align);
    }

    @Override
    public int getItemAlignHour() {
        return mPickerHour.getItemAlign();
    }

    @Override
    public void setItemAlignHour(int align) {
        mPickerHour.setItemAlign(align);
    }

    @Override
    public int getItemAlignMinute() {
        return mPickerMinute.getItemAlign();
    }

    @Override
    public void setItemAlignMinute(int align) {
        mPickerMinute.setItemAlign(align);
    }

    @Override
    public WheeliOSDayPicker getWheeliOSDayPicker() {
        return mPickeriOSDay;
    }

    @Override
    public WheelHourPicker getWheelHourPicker() {
        return mPickerHour;
    }

    @Override
    public WheelMinutePicker getWheelMinutePicker() {
        return mPickerMinute;
    }

    public interface OnDateSelectedListener {
        void onDateSelected(WheeliOSLikeDateTimePicker picker, Date date);
    }
}
