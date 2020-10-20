package com.example.android_ime.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.example.android_ime.R;

public class LatinKeyboard extends Keyboard {

    int[] keys = {R.id.bt_q, R.id.bt_w, R.id.bt_e, R.id.bt_r,
            R.id.bt_a, R.id.bt_s, R.id.bt_d, R.id.bt_f,
            R.id.bt_z, R.id.bt_x, R.id.bt_c, R.id.bt_v};

    public LatinKeyboard(Context context) {
        this(context, null);
    }

    public LatinKeyboard(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LatinKeyboard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(getContext(), R.layout.latin_keyboard, this);

        for (int id : keys)
            initButton(this, id);
    }
}
