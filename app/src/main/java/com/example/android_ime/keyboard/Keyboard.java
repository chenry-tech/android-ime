package com.example.android_ime.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Keyboard extends ConstraintLayout {

    InputConnection inputConnection;

    public Keyboard(Context context) {
        this(context, null);
    }

    public Keyboard(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Keyboard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void start(InputConnection ic) {
        inputConnection = ic;
    }

    void initButton(ViewGroup root, int btId) {
        Button bt = findViewById(btId);
        bt.setOnClickListener((view) -> {
            Log.v("=TEST=", "[Button.OnClickListener]" + bt.getText());
            if (inputConnection != null)
                inputConnection.commitText(bt.getText(), 1);
        });
    }
}
