package com.blued.android.module.media.audio.audio_manager;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import java.util.List;
import java.util.Set;

public class BLBluetoothManager {
  private final Context a;
  
  private final BLAudioManager b;
  
  private final AudioManager c;
  
  private final Handler d;
  
  private int e;
  
  private State f;
  
  private final BluetoothProfile.ServiceListener g;
  
  private BluetoothAdapter h;
  
  private BluetoothHeadset i;
  
  private BluetoothDevice j;
  
  private final BroadcastReceiver k;
  
  private final Runnable l = new Runnable(this) {
      public void run() {
        BLBluetoothManager.a(this.a);
      }
    };
  
  protected BLBluetoothManager(Context paramContext, BLAudioManager paramBLAudioManager) {
    Log.d("BLBluetoothManager", "ctor");
    ThreadUtils.a();
    this.a = paramContext;
    this.b = paramBLAudioManager;
    this.c = a(paramContext);
    this.f = State.a;
    this.g = new BluetoothServiceListener();
    this.k = new BluetoothHeadsetBroadcastReceiver();
    this.d = new Handler(Looper.getMainLooper());
  }
  
  static BLBluetoothManager a(Context paramContext, BLAudioManager paramBLAudioManager) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("create");
    stringBuilder.append(BLUtils.a());
    Log.d("BLBluetoothManager", stringBuilder.toString());
    return new BLBluetoothManager(paramContext, paramBLAudioManager);
  }
  
  private String a(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            switch (paramInt) {
              default:
                return "INVALID";
              case 13:
                return "TURNING_OFF";
              case 12:
                return "ON";
              case 11:
                return "TURNING_ON";
              case 10:
                break;
            } 
            return "OFF";
          } 
          return "DISCONNECTING";
        } 
        return "CONNECTED";
      } 
      return "CONNECTING";
    } 
    return "DISCONNECTED";
  }
  
  private void f() {
    ThreadUtils.a();
    Log.d("BLBluetoothManager", "updateAudioDeviceState");
    this.b.e();
  }
  
  private void g() {
    ThreadUtils.a();
    Log.d("BLBluetoothManager", "cancelTimer");
    this.d.removeCallbacks(this.l);
  }
  
  private void h() {
    ThreadUtils.a();
    if (this.f != State.a) {
      if (this.i == null)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("bluetoothTimeout: BT state=");
      stringBuilder.append(this.f);
      stringBuilder.append(", attempts: ");
      stringBuilder.append(this.e);
      stringBuilder.append(", SCO is on: ");
      stringBuilder.append(i());
      Log.d("BLBluetoothManager", stringBuilder.toString());
      if (this.f != State.f)
        return; 
      List<BluetoothDevice> list = this.i.getConnectedDevices();
      if (list.size() > 0) {
        boolean bool1;
        this.j = list.get(0);
        if (this.i.isAudioConnected(this.j)) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("SCO connected with ");
          stringBuilder2.append(this.j.getName());
          Log.d("BLBluetoothManager", stringBuilder2.toString());
          bool1 = true;
        } else {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("SCO is not connected with ");
          stringBuilder2.append(this.j.getName());
          Log.d("BLBluetoothManager", stringBuilder2.toString());
          bool1 = false;
        } 
        if (bool1) {
          this.f = State.g;
          this.e = 0;
        } else {
          Log.w("BLBluetoothManager", "BT failed to connect after timeout");
          d();
        } 
        f();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("bluetoothTimeout done: BT state=");
        stringBuilder1.append(this.f);
        Log.d("BLBluetoothManager", stringBuilder1.toString());
        return;
      } 
    } else {
      return;
    } 
    boolean bool = false;
  }
  
  private boolean i() {
    return this.c.isBluetoothScoOn();
  }
  
  protected AudioManager a(Context paramContext) {
    return (AudioManager)paramContext.getSystemService("audio");
  }
  
  public State a() {
    ThreadUtils.a();
    return this.f;
  }
  
  protected void a(BluetoothAdapter paramBluetoothAdapter) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("BluetoothAdapter: enabled=");
    stringBuilder.append(paramBluetoothAdapter.isEnabled());
    stringBuilder.append(", state=");
    stringBuilder.append(a(paramBluetoothAdapter.getState()));
    stringBuilder.append(", name=");
    stringBuilder.append(paramBluetoothAdapter.getName());
    stringBuilder.append(", address=");
    stringBuilder.append(paramBluetoothAdapter.getAddress());
    Log.d("BLBluetoothManager", stringBuilder.toString());
    Set set = paramBluetoothAdapter.getBondedDevices();
    if (!set.isEmpty()) {
      Log.d("BLBluetoothManager", "paired devices:");
      for (BluetoothDevice bluetoothDevice : set) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(" name=");
        stringBuilder1.append(bluetoothDevice.getName());
        stringBuilder1.append(", address=");
        stringBuilder1.append(bluetoothDevice.getAddress());
        Log.d("BLBluetoothManager", stringBuilder1.toString());
      } 
    } 
  }
  
  protected void a(BroadcastReceiver paramBroadcastReceiver) {
    this.a.unregisterReceiver(paramBroadcastReceiver);
  }
  
  protected void a(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter) {
    this.a.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  protected boolean a(Context paramContext, BluetoothProfile.ServiceListener paramServiceListener, int paramInt) {
    return this.h.getProfileProxy(paramContext, paramServiceListener, paramInt);
  }
  
  protected boolean a(Context paramContext, String paramString) {
    return (this.a.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0);
  }
  
  public void b() {
    ThreadUtils.a();
    Log.d("BLBluetoothManager", "start");
    if (!a(this.a, "android.permission.BLUETOOTH")) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Process (pid=");
      stringBuilder1.append(Process.myPid());
      stringBuilder1.append(") lacks BLUETOOTH permission");
      Log.w("BLBluetoothManager", stringBuilder1.toString());
      return;
    } 
    if (this.f != State.a) {
      Log.w("BLBluetoothManager", "Invalid BT state");
      return;
    } 
    this.i = null;
    this.j = null;
    this.e = 0;
    this.h = BluetoothAdapter.getDefaultAdapter();
    if (this.h == null) {
      Log.w("BLBluetoothManager", "Device does not support Bluetooth");
      return;
    } 
    if (!this.c.isBluetoothScoAvailableOffCall()) {
      Log.e("BLBluetoothManager", "Bluetooth SCO audio is not available off call");
      return;
    } 
    a(this.h);
    if (!a(this.a, this.g, 1)) {
      Log.e("BLBluetoothManager", "BluetoothAdapter.getProfileProxy(HEADSET) failed");
      return;
    } 
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
    intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
    a(this.k, intentFilter);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("HEADSET profile state: ");
    stringBuilder.append(a(this.h.getProfileConnectionState(1)));
    Log.d("BLBluetoothManager", stringBuilder.toString());
    Log.d("BLBluetoothManager", "Bluetooth proxy for headset profile has started");
    this.f = State.c;
    stringBuilder = new StringBuilder();
    stringBuilder.append("start done: BT state=");
    stringBuilder.append(this.f);
    Log.d("BLBluetoothManager", stringBuilder.toString());
  }
  
  public void c() {
    ThreadUtils.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("stop: BT state=");
    stringBuilder2.append(this.f);
    Log.d("BLBluetoothManager", stringBuilder2.toString());
    if (this.h == null)
      return; 
    d();
    if (this.f == State.a)
      return; 
    a(this.k);
    g();
    BluetoothHeadset bluetoothHeadset = this.i;
    if (bluetoothHeadset != null) {
      this.h.closeProfileProxy(1, (BluetoothProfile)bluetoothHeadset);
      this.i = null;
    } 
    this.h = null;
    this.j = null;
    this.f = State.a;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("stop done: BT state=");
    stringBuilder1.append(this.f);
    Log.d("BLBluetoothManager", stringBuilder1.toString());
  }
  
  public void d() {
    ThreadUtils.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stopScoAudio: BT state=");
    stringBuilder.append(this.f);
    stringBuilder.append(", SCO is on: ");
    stringBuilder.append(i());
    Log.d("BLBluetoothManager", stringBuilder.toString());
    if (this.f != State.f && this.f != State.g)
      return; 
    g();
    this.c.stopBluetoothSco();
    this.c.setBluetoothScoOn(false);
    this.f = State.e;
    stringBuilder = new StringBuilder();
    stringBuilder.append("stopScoAudio done: BT state=");
    stringBuilder.append(this.f);
    stringBuilder.append(", SCO is on: ");
    stringBuilder.append(i());
    Log.d("BLBluetoothManager", stringBuilder.toString());
  }
  
  public void e() {
    if (this.f != State.a) {
      if (this.i == null)
        return; 
      Log.d("BLBluetoothManager", "updateDevice");
      List<BluetoothDevice> list = this.i.getConnectedDevices();
      if (list.isEmpty()) {
        this.j = null;
        this.f = State.c;
        Log.d("BLBluetoothManager", "No connected bluetooth headset");
      } else {
        this.j = list.get(0);
        this.f = State.d;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Connected bluetooth headset: name=");
        stringBuilder1.append(this.j.getName());
        stringBuilder1.append(", state=");
        stringBuilder1.append(a(this.i.getConnectionState(this.j)));
        stringBuilder1.append(", SCO audio=");
        stringBuilder1.append(this.i.isAudioConnected(this.j));
        Log.d("BLBluetoothManager", stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("updateDevice done: BT state=");
      stringBuilder.append(this.f);
      Log.d("BLBluetoothManager", stringBuilder.toString());
    } 
  }
  
  class BluetoothHeadsetBroadcastReceiver extends BroadcastReceiver {
    private BluetoothHeadsetBroadcastReceiver(BLBluetoothManager this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      if (BLBluetoothManager.b(this.a) == BLBluetoothManager.State.a)
        return; 
      String str = param1Intent.getAction();
      if (str.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
        int i = param1Intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        stringBuilder = new StringBuilder();
        stringBuilder.append("BluetoothHeadsetBroadcastReceiver.onReceive: a=ACTION_CONNECTION_STATE_CHANGED, s=");
        stringBuilder.append(BLBluetoothManager.a(this.a, i));
        stringBuilder.append(", sb=");
        stringBuilder.append(isInitialStickyBroadcast());
        stringBuilder.append(", BT state: ");
        stringBuilder.append(BLBluetoothManager.b(this.a));
        Log.d("BLBluetoothManager", stringBuilder.toString());
        if (i == 2) {
          BLBluetoothManager.b(this.a, 0);
          BLBluetoothManager.c(this.a);
        } else if (i != 1 && i != 3 && i == 0) {
          this.a.d();
          BLBluetoothManager.c(this.a);
        } 
      } else if (stringBuilder.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
        int i = param1Intent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
        stringBuilder = new StringBuilder();
        stringBuilder.append("BluetoothHeadsetBroadcastReceiver.onReceive: a=ACTION_AUDIO_STATE_CHANGED, s=");
        stringBuilder.append(BLBluetoothManager.a(this.a, i));
        stringBuilder.append(", sb=");
        stringBuilder.append(isInitialStickyBroadcast());
        stringBuilder.append(", BT state: ");
        stringBuilder.append(BLBluetoothManager.b(this.a));
        Log.d("BLBluetoothManager", stringBuilder.toString());
        if (i == 12) {
          BLBluetoothManager.d(this.a);
          if (BLBluetoothManager.b(this.a) == BLBluetoothManager.State.f) {
            Log.d("BLBluetoothManager", "+++ Bluetooth audio SCO is now connected");
            BLBluetoothManager.a(this.a, BLBluetoothManager.State.g);
            BLBluetoothManager.b(this.a, 0);
            BLBluetoothManager.c(this.a);
          } else {
            Log.w("BLBluetoothManager", "Unexpected state BluetoothHeadset.STATE_AUDIO_CONNECTED");
          } 
        } else if (i == 11) {
          Log.d("BLBluetoothManager", "+++ Bluetooth audio SCO is now connecting...");
        } else if (i == 10) {
          Log.d("BLBluetoothManager", "+++ Bluetooth audio SCO is now disconnected");
          if (isInitialStickyBroadcast()) {
            Log.d("BLBluetoothManager", "Ignore STATE_AUDIO_DISCONNECTED initial sticky broadcast.");
            return;
          } 
          BLBluetoothManager.c(this.a);
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onReceive done: BT state=");
      stringBuilder.append(BLBluetoothManager.b(this.a));
      Log.d("BLBluetoothManager", stringBuilder.toString());
    }
  }
  
  class BluetoothServiceListener implements BluetoothProfile.ServiceListener {
    private BluetoothServiceListener(BLBluetoothManager this$0) {}
    
    public void onServiceConnected(int param1Int, BluetoothProfile param1BluetoothProfile) {
      if (param1Int == 1) {
        if (BLBluetoothManager.b(this.a) == BLBluetoothManager.State.a)
          return; 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("BluetoothServiceListener.onServiceConnected: BT state=");
        stringBuilder2.append(BLBluetoothManager.b(this.a));
        Log.d("BLBluetoothManager", stringBuilder2.toString());
        BLBluetoothManager.a(this.a, (BluetoothHeadset)param1BluetoothProfile);
        BLBluetoothManager.c(this.a);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("onServiceConnected done: BT state=");
        stringBuilder1.append(BLBluetoothManager.b(this.a));
        Log.d("BLBluetoothManager", stringBuilder1.toString());
      } 
    }
    
    public void onServiceDisconnected(int param1Int) {
      if (param1Int == 1) {
        if (BLBluetoothManager.b(this.a) == BLBluetoothManager.State.a)
          return; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BluetoothServiceListener.onServiceDisconnected: BT state=");
        stringBuilder.append(BLBluetoothManager.b(this.a));
        Log.d("BLBluetoothManager", stringBuilder.toString());
        this.a.d();
        BLBluetoothManager.a(this.a, (BluetoothHeadset)null);
        BLBluetoothManager.a(this.a, (BluetoothDevice)null);
        BLBluetoothManager.a(this.a, BLBluetoothManager.State.c);
        BLBluetoothManager.c(this.a);
        stringBuilder = new StringBuilder();
        stringBuilder.append("onServiceDisconnected done: BT state=");
        stringBuilder.append(BLBluetoothManager.b(this.a));
        Log.d("BLBluetoothManager", stringBuilder.toString());
      } 
    }
  }
  
  public enum State {
    a, b, c, d, e, f, g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\audio\audio_manager\BLBluetoothManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */