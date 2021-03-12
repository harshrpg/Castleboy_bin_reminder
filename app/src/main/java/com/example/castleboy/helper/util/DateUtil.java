package com.example.castleboy.helper.util;


import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.util.*;

import static com.example.castleboy.helper.constants.Constants.EPOCH_TIME_FOR_8TH_MARCH_2021;

public class DateUtil {

    private static final Date EPOCH_START_DATE = new Date(EPOCH_TIME_FOR_8TH_MARCH_2021);
    public static Date getEpochStartDate() {
        return EPOCH_START_DATE;
    }

    public static String getPreviousDateOfWeekForToday(final DayOfWeek dayOfWeek) {
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .format(LocalDate.now().with(TemporalAdjusters.previousOrSame(dayOfWeek)));
    }

    public static String getNextDateOfWeekFor(final DayOfWeek dayOfWeek) {
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .format(LocalDate.now().with(TemporalAdjusters.next(dayOfWeek)));
    }
}