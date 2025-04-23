package com.jitcall.plugins.jitsiplugin;

import android.util.Log;

public class JitsiPlugin {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
