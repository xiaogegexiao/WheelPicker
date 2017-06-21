package com.aigestudio.wheelpicker.widgets;

/**
 * 选择器方法接口
 * <p>
 * Interface of WheelMinutePicker
 *
 * @author AigeStudio 2016-07-12
 * @version 1
 */
public interface IWheelMinutePicker {
    /**
     * 获取分钟选择器初始化时选择的分钟
     *
     * @return 选择的分钟
     */
    int getSelectedMinute();

    /**
     * 设置分钟选择器初始化时选择的分钟
     *
     * @param minute 选择的分钟
     */
    void setSelectedMinute(int minute);

    /**
     * 获取当前选择的分钟
     *
     * @return 选择的分钟
     */
    int getCurrentMinute();
}