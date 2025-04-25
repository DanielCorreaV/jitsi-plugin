package com.jitcall.plugins.jitsiplugin;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;
import org.jitsi.meet.sdk.JitsiMeetUserInfo;


import java.net.MalformedURLException;
import java.net.URL;
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
  public void startCall(PluginCall call) {
    String room = call.getString("meetingId");
    String userName = call.getString("userName");

    if (room == null || userName == null) {
      call.reject("Meeting ID y User Name son requeridos");
      return;
    }

    JitsiMeetUserInfo userInfo = new JitsiMeetUserInfo();
    userInfo.setDisplayName(userName);

    try {
      JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
        .setServerURL(new URL("https://jitsi1.geeksec.de/"))
        .setRoom(room)
        .setAudioOnly(false)
        .setUserInfo(userInfo)
        .setFeatureFlag("welcomepage.enabled", false)
        .build();

      JitsiMeetActivity.launch(getContext(), options);
      call.resolve();
    } catch (MalformedURLException e) {
      call.reject("URL inválida", e);
    }
  }

  @PluginMethod
  public void joinCall(PluginCall call) {
    String room = call.getString("meetingId");
    String userName = call.getString("userName");

    if (room == null || userName == null) {
      call.reject("Meeting ID y User Name son requeridos");
      return;
    }

    JitsiMeetUserInfo userInfo = new JitsiMeetUserInfo();
    userInfo.setDisplayName(userName);

    try {
      JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
        .setServerURL(new URL("https://jitsi1.geeksec.de/"))
        .setRoom(room)
        .setUserInfo(userInfo)
        .setFeatureFlag("welcomepage.enabled", false)
        .build();

      JitsiMeetActivity.launch(getContext(), options);
      call.resolve();
    } catch (MalformedURLException e) {
      call.reject("URL inválida", e);
    }
  }

  @PluginMethod
  public void createRoom(PluginCall call) {
    String meetingId = "room-" + UUID.randomUUID().toString();

    JSObject result = new JSObject();
    result.put("meetingId", meetingId);
    call.resolve(result);
  }

}
