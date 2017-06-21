package com.aigestudio.wheelpicker.widgets;

/**
 * 选择器方法接口
 * <p>
 * Interface of WheelHourPicker
 *
 * @author AigeStudio 2016-07-12
 * @version 1
 */
public interface IWheelHourPicker {
    /**
     * 获取小时选择器初始化时选择的小时
     *
     * @return 选择的小时
     */
    int getSelectedHour();

    /**
     * 设置小时选择器初始化时选择的小时
     *
     * @param hour 选择的小时
     */
    void setSelectedHour(int hour);

    /**
     * 获取当前选择的小时
     *
     * @return 选择的小时
     */
    int getCurrentHour();
}