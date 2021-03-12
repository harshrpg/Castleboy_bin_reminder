package com.example.castleboy;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.castleboy.helper.util.DateUtil;

import static com.example.castleboy.helper.constants.Constants.BIN_DAY;
import static com.example.castleboy.helper.constants.Constants.BIN_OUT_DAY;
import static com.example.castleboy.helper.constants.Constants.EPOCH_BIN_TYPE;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static boolean viewsReady = false;

    private TextView binIndicator, weekStartDate, nextBinDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            initializeViews();
        } catch (IllegalStateException e) {
            Log.e(TAG, e.getMessage());
        }
        if (viewsReady) {
            setBinIndicator(EPOCH_BIN_TYPE.toString());
            setWeekStartDate(DateUtil.getPreviousDateOfWeekForToday(BIN_DAY));
            setNextBinDate(DateUtil.getNextDateOfWeekFor(BIN_OUT_DAY));
        }

    }

    private void initializeViews() throws IllegalStateException {
        try {
            binIndicator = findViewById(R.id.bin_indicator);
            weekStartDate = findViewById(R.id.week_start_date);
            nextBinDate = findViewById(R.id.next_bin_date);
            viewsReady = true;
        } catch (Exception e) {
            throw new IllegalStateException("View not Found");
        }

    }

    private void setBinIndicator(final String binIndicatorText) {
        binIndicator.setText(binIndicatorText);
    }

    private void setWeekStartDate(final String weekStartDateText) {
        weekStartDate.setText(weekStartDateText);
    }

    private void setNextBinDate(final String nextBinDateText) {
        nextBinDate.setText(nextBinDateText);
    }
}