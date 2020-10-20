package com.example.android_ime.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.example.android_ime.R;

public class NumericKeyboard extends Keyboard {

    int[] keys = {R.id.bt_1, R.id.bt_2, R.id.bt_3,
            R.id.bt_4, R.id.bt_5, R.id.bt_6,
            R.id.bt_7, R.id.bt_8, R.id.bt_9,};

    public NumericKeyboard(Context context) {
        this(context, null);
    }

    public NumericKeyboard(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumericKeyboard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(getContext(), R.layout.numeric_keyboard, this);
        for (int id : keys)
            initButton(this, id);
    }
}
