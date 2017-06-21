package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.aigestudio.wheelpicker.WheelPicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 日期选择器
 * <p>
 * Picker for Day
 *
 * @author AigeStudio 2016-07-12
 * @version 1
 */
public class WheeliOSDayPicker extends WheelPicker implements IWheeliOSDayPicker {
    public static class IOSLikeDate {
        public static final SimpleDateFormat SDF =
                new SimpleDateFormat("EEE dd MMM", Locale.getDefault());

        Date date;

        public IOSLikeDate() {
            this.date = new Date();
        }

        public IOSLikeDate(Date date) {
            this.date = date;
        }

        @Override
        public String toString() {
            if (date == null) {
                return "null";
            }
            return SDF.format(date);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof IOSLikeDate) {
                return (date != null && date.compareTo(((IOSLikeDate) obj).date) == 0);
            } else {
                return super.equals(obj);
            }
        }
    }

    private static final List<IOSLikeDate> DAYS = new ArrayList<>();
    private static final int DAY_GAP = 30;
    private IOSLikeDate mDayStart = new IOSLikeDate(), mDayEnd = new IOSLikeDate();

    private Calendar mCalendar;

    private IOSLikeDate mSelectedDay = new IOSLikeDate();

    public WheeliOSDayPicker(Context context) {
        this(context, null);
    }

    public WheeliOSDayPicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.MILLISECOND, 0);
        mCalendar.set(Calendar.SECOND, 0);
        mCalendar.set(Calendar.MINUTE, 0);
        mCalendar.set(Calendar.HOUR_OF_DAY, 0);
        mDayEnd.date = mCalendar.getTime();
        mSelectedDay.date = mCalendar.getTime();

        mCalendar.add(Calendar.DAY_OF_YEAR, -(DAY_GAP - 1));
        mDayStart.date = mCalendar.getTime();

        updateiOSDays();

        updateSelectediOSDay();
    }

    private void updateiOSDays() {
        DAYS.clear();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDayStart.date);
        while (calendar.getTime().before(mDayEnd.date)){
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            DAYS.add(new IOSLikeDate(calendar.getTime()));
        }

        super.setData(DAYS);
    }

    private void updateSelectediOSDay() {
        setSelectedItemPosition(DAYS.indexOf(mSelectedDay));
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelDayPicker");
    }

    @Override
    public IOSLikeDate getSelectediOSLikeDay() {
        return mSelectedDay;
    }

    @Override
    public void setSelectediOSLikeDay(IOSLikeDate day) {
        mSelectedDay = day;
        updateSelectediOSDay();
    }

    @Override
    public IOSLikeDate getCurrentiOSLikeDay() {
        return (IOSLikeDate) getData().get(getCurrentItemPosition());
    }

    @Override
    public int getYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mSelectedDay.date);
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public int getMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mSelectedDay.date);
        return calendar.get(Calendar.MONTH);
    }

    @Override
    public int getDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mSelectedDay.date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public void setDayStart(IOSLikeDate startDay) {
        mDayStart = startDay;
        mSelectedDay = getCurrentiOSLikeDay();
        updateiOSDays();
        updateSelectediOSDay();
    }

    @Override
    public void setDayEnd(IOSLikeDate endDay) {
        mDayEnd = endDay;
        mSelectedDay = getCurrentiOSLikeDay();
        updateiOSDays();
        updateSelectediOSDay();
    }
}