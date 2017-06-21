package com.aigestudio.wheelpicker.widgets;

import java.util.Date;

public interface IWheeliOSLikeDateTimePicker {
    void setOnDateSelectedListener(WheeliOSLikeDateTimePicker.OnDateSelectedListener listener);

    Date getCurrentDate();

    int getItemAligniOSDay();

    void setItemAligniOSDay(int align);

    int getItemAlignHour();

    void setItemAlignHour(int align);

    int getItemAlignMinute();

    void setItemAlignMinute(int align);

    WheeliOSDayPicker getWheeliOSDayPicker();

    WheelHourPicker getWheelHourPicker();

    WheelMinutePicker getWheelMinutePicker();
}