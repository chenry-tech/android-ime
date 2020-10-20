package com.example.android_ime;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.inputmethod.EditorInfoCompat;

import com.example.android_ime.keyboard.LatinKeyboard;
import com.example.android_ime.keyboard.NumericKeyboard;

public class TestInputView extends ConstraintLayout {
    LatinKeyboard latinKeyboard;
    NumericKeyboard numericKeyboard;

    public TestInputView(Context context) {
        super(context);
        create();
    }

    public TestInputView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        create();
    }

    public TestInputView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        create();
    }

    void create() {
        latinKeyboard = new LatinKeyboard(getContext());
        numericKeyboard = new NumericKeyboard(getContext());
    }

    public void start(EditorInfo info, InputConnection ic) {
        String[] mimeTypes = EditorInfoCompat.getContentMimeTypes(info);

        removeAllViews();

        switch (info.inputType & InputType.TYPE_MASK_CLASS) {
            case InputType.TYPE_CLASS_NUMBER:
            case InputType.TYPE_CLASS_PHONE:
            case InputType.TYPE_CLASS_DATETIME:
                // Number
                numericKeyboard.start(ic);

                ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                addView(numericKeyboard, params);

                break;

            case InputType.TYPE_CLASS_TEXT:

                // Text
                latinKeyboard.start(ic);

                addView(latinKeyboard);
                break;
        }
    }
}
