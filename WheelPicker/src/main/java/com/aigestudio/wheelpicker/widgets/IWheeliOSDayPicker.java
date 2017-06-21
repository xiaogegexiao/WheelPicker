package com.aigestudio.wheelpicker.widgets;

/**
 * 选择器方法接口
 * <p>
 * Interface of WheeliOSDayPicker
 *
 * @author AigeStudio 2016-07-12
 * @version 1
 */
public interface IWheeliOSDayPicker {
    /**
     * 获取iOS-like日期选择器初始化时选择的日期
     *
     * @return 选择的日期
     */
    WheeliOSDayPicker.IOSLikeDate getSelectediOSLikeDay();

    /**
     * 设置iOS-like日期选择器初始化时选择的日期
     *
     * @param day 选择的日期
     */
    void setSelectediOSLikeDay(WheeliOSDayPicker.IOSLikeDate day);

    /**
     * 获取当前选择的日期
     *
     * @return 选择的日期
     */
    WheeliOSDayPicker.IOSLikeDate getCurrentiOSLikeDay();

    /**
     * 获取年份
     *
     * @return 年份
     */
    int getYear();

    /**
     * 获取月份
     *
     * @return 月份
     */
    int getMonth();

    /**
     * 设置日期
     *
     * @return 日期
     */
    int getDay();

    /**
     * 设置起始日期
     * @param startDay
     */
    void setDayStart(WheeliOSDayPicker.IOSLikeDate startDay);

    /**
     * 设置结束日期
     * @param endDay
     */
    void setDayEnd(WheeliOSDayPicker.IOSLikeDate endDay);
}