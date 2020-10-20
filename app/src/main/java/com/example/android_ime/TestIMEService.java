package com.example.android_ime;

import android.inputmethodservice.InputMethodService;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodSubtype;

import androidx.core.view.inputmethod.EditorInfoCompat;

public class TestIMEService extends InputMethodService {

    TestInputView inputView;

    public TestIMEService() {
    }

    @Override
    public View onCreateInputView() {
        Log.v("=TEST=", "[TestIMEService.onCreateInputView]");

        inputView = new TestInputView(this);//(TextInputView)getLayoutInflater().inflate(R.layout.inputview_text, null);
        return inputView;
    }

    @Override
    public void onStartInputView(EditorInfo info, boolean restarting) {
        Log.v("=TEST=", "[TestIMEService.onStartInputView]");
        inputView.start(info, getCurrentInputConnection());
    }

    @Override
    protected void onCurrentInputMethodSubtypeChanged(InputMethodSubtype newSubtype) {
        super.onCurrentInputMethodSubtypeChanged(newSubtype);
        Log.v("=TEST=", "[TestIMEService.onCurrentInputMethodSubtypeChanged]");
    }
}
