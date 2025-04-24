package com.jitcall.plugins.jitsiplugin;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;


import java.util.UUID;


@CapacitorPlugin(name = "JitsiPlugin")
public class JitsiPluginPlugin extends Plugin {

    private JitsiPlugin implementation = new JitsiPlugin();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void testPluginMethod(PluginCall call){
        String value = call.getString("msg");
        JSObject ret = new JSObject();
        ret.put("value", value);
        call.resolve(ret);
    }

    @PluginMethod
public void joinCall(PluginCall call) {
    String room = call.getString("room");
    if (room == null || room.isEmpty()) {
        call.reject("Room name is required");
        return;
    }

    JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
            .setRoom(room)
            .setFeatureFlag("welcomepage.enabled", false)
            .build();

    JitsiMeetActivity.launch(getActivity(), options);
    call.resolve();
}

@PluginMethod
public void startCall(PluginCall call) {
    String room = "room-" + UUID.randomUUID().toString();

    JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
            .setRoom(room)
            .setFeatureFlag("welcomepage.enabled", false)
            .build();

    JitsiMeetActivity.launch(getActivity(), options);

    JSObject result = new JSObject();
    result.put("room", room);
    call.resolve(result);
}
}
