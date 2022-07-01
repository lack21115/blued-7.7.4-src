package com.blued.android.module.media.audio.audio_manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

public class BLAudioManager {
  private static boolean i = false;
  
  private static BLAudioManager v;
  
  private final Context a;
  
  private AudioManager b;
  
  private AudioFocusRequest c;
  
  private PowerManager d;
  
  private PowerManager.WakeLock e;
  
  private AudioManagerEvents f;
  
  private AudioManagerState g;
  
  private AudioSwitchMode h = AudioSwitchMode.a;
  
  private int j = -2;
  
  private boolean k;
  
  private boolean l;
  
  private boolean m;
  
  private AudioDevice n;
  
  private AudioDevice o;
  
  private AudioDevice p;
  
  private BLProximitySensor q;
  
  private final BLBluetoothManager r;
  
  private Set<AudioDevice> s = new HashSet<AudioDevice>();
  
  private BroadcastReceiver t;
  
  private AudioManager.OnAudioFocusChangeListener u;
  
  private final Handler w = new Handler(Looper.getMainLooper(), new -$$Lambda$BLAudioManager$1UVZwexKHqiTpvN_66T23A_Xl-Y(this));
  
  private BLAudioManager(Context paramContext) {
    Log.d("BLAudioManager", "ctor");
    ThreadUtils.a();
    this.a = paramContext.getApplicationContext();
    this.b = (AudioManager)paramContext.getSystemService("audio");
    this.r = BLBluetoothManager.a(paramContext, this);
    this.t = new WiredHeadsetReceiver();
    this.g = AudioManagerState.a;
    j();
    this.q = BLProximitySensor.a(paramContext, new -$$Lambda$BLAudioManager$mSN69PyYjqvVqK7Sg3P4jjksSpU(this));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("defaultAudioDevice: ");
    stringBuilder.append(this.n);
    Log.d("BLAudioManager", stringBuilder.toString());
    s();
    BLUtils.a("BLAudioManager");
    if (i)
      this.d = (PowerManager)paramContext.getSystemService("power"); 
  }
  
  public static BLAudioManager a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/blued/android/module/media/audio/audio_manager/BLAudioManager.v : Lcom/blued/android/module/media/audio/audio_manager/BLAudioManager;
    //   3: ifnonnull -> 38
    //   6: ldc com/blued/android/module/media/audio/audio_manager/BLAudioManager
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/media/audio/audio_manager/BLAudioManager.v : Lcom/blued/android/module/media/audio/audio_manager/BLAudioManager;
    //   12: ifnonnull -> 26
    //   15: new com/blued/android/module/media/audio/audio_manager/BLAudioManager
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/blued/android/module/media/audio/audio_manager/BLAudioManager.v : Lcom/blued/android/module/media/audio/audio_manager/BLAudioManager;
    //   26: ldc com/blued/android/module/media/audio/audio_manager/BLAudioManager
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/blued/android/module/media/audio/audio_manager/BLAudioManager
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/blued/android/module/media/audio/audio_manager/BLAudioManager.v : Lcom/blued/android/module/media/audio/audio_manager/BLAudioManager;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a(BroadcastReceiver paramBroadcastReceiver) {
    this.a.unregisterReceiver(paramBroadcastReceiver);
  }
  
  private void a(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter) {
    this.a.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  private void a(AudioDevice paramAudioDevice) {
    if (paramAudioDevice == this.o)
      return; 
    Set<AudioDevice> set = this.s;
    if (set == null || set.isEmpty() || !this.s.contains(paramAudioDevice)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("no audio device found! device = ");
      stringBuilder1.append(paramAudioDevice);
      Log.e("BLAudioManager", stringBuilder1.toString());
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setAudioDeviceInternal(device=");
    stringBuilder.append(paramAudioDevice);
    stringBuilder.append(")");
    Log.d("BLAudioManager", stringBuilder.toString());
    if (paramAudioDevice == AudioDevice.c) {
      i = 3;
    } else {
      AudioManager audioManager = this.b;
      i = 0;
    } 
    a(i);
    int i = null.a[paramAudioDevice.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            Log.e("BLAudioManager", "Invalid audio device selection");
          } else {
            a(false);
          } 
        } else {
          a(false);
        } 
      } else {
        a(false);
      } 
    } else {
      a(true);
    } 
    this.o = paramAudioDevice;
    AudioManagerEvents audioManagerEvents = this.f;
    if (audioManagerEvents != null)
      audioManagerEvents.onAudioDeviceChanged(this.o, this.s); 
  }
  
  private void a(boolean paramBoolean) {
    if (this.b.isSpeakerphoneOn() == paramBoolean)
      return; 
    this.b.setSpeakerphoneOn(paramBoolean);
  }
  
  private void f() {
    if (this.h != AudioSwitchMode.a)
      return; 
    if (i())
      o(); 
  }
  
  private void g() {
    PowerManager powerManager = this.d;
    if (powerManager == null)
      return; 
    if (this.e == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a.getPackageName());
      stringBuilder.append(";manager_proximity_sensor");
      this.e = powerManager.newWakeLock(32, stringBuilder.toString());
    } 
    if (!this.e.isHeld())
      this.e.acquire(); 
  }
  
  private void h() {
    PowerManager.WakeLock wakeLock = this.e;
    if (wakeLock != null && wakeLock.isHeld()) {
      this.e.setReferenceCounted(false);
      this.e.release();
    } 
  }
  
  private boolean i() {
    return (this.s.size() == 2 && this.s.contains(AudioDevice.c) && this.s.contains(AudioDevice.a));
  }
  
  private void j() {
    AudioDevice audioDevice;
    if (this.h == AudioSwitchMode.b) {
      audioDevice = AudioDevice.c;
    } else {
      audioDevice = AudioDevice.a;
    } 
    this.n = audioDevice;
  }
  
  private boolean k() {
    return (Build.VERSION.SDK_INT >= 26);
  }
  
  private void l() {
    if (this.c != null)
      return; 
    AudioAttributes audioAttributes = (new AudioAttributes.Builder()).setUsage(1).setContentType(2).build();
    this.c = (new AudioFocusRequest.Builder(2)).setAudioAttributes(audioAttributes).setOnAudioFocusChangeListener(this.u).setAcceptsDelayedFocusGain(true).build();
  }
  
  private int m() {
    int i;
    String str;
    if (k()) {
      l();
      i = this.b.requestAudioFocus(this.c);
    } else {
      i = this.b.requestAudioFocus(this.u, 3, 2);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("requestAudioFocus: SDK_INT ");
    if (k()) {
      str = ">= 26, ";
    } else {
      str = "< 26, ";
    } 
    stringBuilder.append(str);
    stringBuilder.append("result = ");
    stringBuilder.append(i);
    Log.d("BLAudioManager", stringBuilder.toString());
    return i;
  }
  
  private int n() {
    int i;
    String str;
    if (k()) {
      l();
      i = this.b.abandonAudioFocusRequest(this.c);
    } else {
      i = this.b.abandonAudioFocus(this.u);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("abandonAudioFocus: SDK_INT ");
    if (k()) {
      str = ">= 26, ";
    } else {
      str = "< 26, ";
    } 
    stringBuilder.append(str);
    stringBuilder.append("result = ");
    stringBuilder.append(i);
    Log.d("BLAudioManager", stringBuilder.toString());
    return i;
  }
  
  private void o() {
    this.w.removeMessages(1);
    this.w.sendEmptyMessage(1);
  }
  
  private void p() {
    BLProximitySensor bLProximitySensor = this.q;
    if (bLProximitySensor == null)
      return; 
    if (bLProximitySensor.c()) {
      r();
      if (i) {
        g();
        return;
      } 
    } else {
      q();
      if (i)
        h(); 
    } 
  }
  
  private void q() {
    a(AudioDevice.a);
  }
  
  private void r() {
    a(AudioDevice.c);
  }
  
  private void s() {
    if (this.u != null)
      return; 
    this.u = -$$Lambda$BLAudioManager$X5wShwudrSSyvs4eYJX2fb28tCA.INSTANCE;
  }
  
  private boolean t() {
    return this.a.getPackageManager().hasSystemFeature("android.hardware.telephony");
  }
  
  @Deprecated
  private boolean u() {
    if (Build.VERSION.SDK_INT < 23)
      return this.b.isWiredHeadsetOn(); 
    AudioDeviceInfo[] arrayOfAudioDeviceInfo = this.b.getDevices(3);
    int j = arrayOfAudioDeviceInfo.length;
    for (int i = 0; i < j; i++) {
      int k = arrayOfAudioDeviceInfo[i].getType();
      if (k == 3) {
        Log.d("BLAudioManager", "hasWiredHeadset: found wired headset");
        return true;
      } 
      if (k == 11) {
        Log.d("BLAudioManager", "hasWiredHeadset: found USB audio device");
        return true;
      } 
    } 
    return false;
  }
  
  public void a() {
    String str;
    Log.d("BLAudioManager", "start");
    ThreadUtils.a();
    if (this.g == AudioManagerState.c) {
      Log.e("BLAudioManager", "AudioManager is already active");
      return;
    } 
    Log.d("BLAudioManager", "AudioManager starts...");
    this.g = AudioManagerState.c;
    j();
    this.j = this.b.getMode();
    this.k = this.b.isSpeakerphoneOn();
    this.l = this.b.isMicrophoneMute();
    this.m = u();
    int i = m();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Audio focus request ");
    if (i == 1) {
      str = "granted";
    } else {
      str = "failed";
    } 
    stringBuilder.append(str);
    Log.d("BLAudioManager", stringBuilder.toString());
    this.p = AudioDevice.e;
    this.o = AudioDevice.e;
    this.s.clear();
    this.r.b();
    this.q.a();
    e();
    a(this.t, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    Log.d("BLAudioManager", "AudioManager started");
  }
  
  public void a(int paramInt) {
    this.b.setMode(paramInt);
  }
  
  public void a(AudioManagerEvents paramAudioManagerEvents) {
    this.f = paramAudioManagerEvents;
  }
  
  public void a(AudioSwitchMode paramAudioSwitchMode) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setAudioSwitchMode: ");
    stringBuilder.append(paramAudioSwitchMode.name());
    Log.i("BLAudioManager", stringBuilder.toString());
    this.h = paramAudioSwitchMode;
    j();
  }
  
  public void b() {
    Log.d("BLAudioManager", "stop");
    ThreadUtils.a();
    this.w.removeCallbacksAndMessages(null);
    if (this.g != AudioManagerState.c) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Trying to stop AudioManager in incorrect state: ");
      stringBuilder.append(this.g);
      Log.e("BLAudioManager", stringBuilder.toString());
      return;
    } 
    this.g = AudioManagerState.a;
    a(this.t);
    this.r.c();
    a(this.k);
    a(this.j);
    n();
    Log.d("BLAudioManager", "Abandoned audio focus for VOICE_CALL streams");
    BLProximitySensor bLProximitySensor = this.q;
    if (bLProximitySensor != null)
      bLProximitySensor.b(); 
    Log.d("BLAudioManager", "AudioManager stopped");
  }
  
  public void c() {
    this.w.removeMessages(2);
    this.w.sendEmptyMessage(2);
  }
  
  public void d() {
    this.w.removeMessages(3);
    this.w.sendEmptyMessage(3);
  }
  
  public void e() {
    boolean bool1;
    AudioDevice audioDevice;
    ThreadUtils.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("--- updateAudioDeviceState: wired headset=");
    stringBuilder.append(this.m);
    stringBuilder.append(", BT state=");
    stringBuilder.append(this.r.a());
    Log.d("BLAudioManager", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Device status: available=");
    stringBuilder.append(this.s);
    stringBuilder.append(", selected=");
    stringBuilder.append(this.o);
    stringBuilder.append(", user selected=");
    stringBuilder.append(this.p);
    Log.d("BLAudioManager", stringBuilder.toString());
    if (this.r.a() == BLBluetoothManager.State.d || this.r.a() == BLBluetoothManager.State.c || this.r.a() == BLBluetoothManager.State.e)
      this.r.e(); 
    HashSet<AudioDevice> hashSet = new HashSet();
    if (this.r.a() == BLBluetoothManager.State.g || this.r.a() == BLBluetoothManager.State.f || this.r.a() == BLBluetoothManager.State.d)
      hashSet.add(AudioDevice.d); 
    if (this.m) {
      hashSet.add(AudioDevice.b);
    } else {
      hashSet.add(AudioDevice.a);
      if (t())
        hashSet.add(AudioDevice.c); 
    } 
    boolean bool = this.s.equals(hashSet);
    boolean bool2 = true;
    this.s = hashSet;
    if (this.r.a() == BLBluetoothManager.State.c && this.p == AudioDevice.d)
      this.p = AudioDevice.e; 
    if (this.m && this.p == AudioDevice.a)
      this.p = AudioDevice.b; 
    if (!this.m && this.p == AudioDevice.b)
      this.p = AudioDevice.a; 
    if (this.r.a() == BLBluetoothManager.State.d && (this.p == AudioDevice.e || this.p == AudioDevice.d)) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if ((this.r.a() != BLBluetoothManager.State.g && this.r.a() != BLBluetoothManager.State.f) || this.p == AudioDevice.e || this.p == AudioDevice.d)
      bool2 = false; 
    if (this.r.a() == BLBluetoothManager.State.d || this.r.a() == BLBluetoothManager.State.f || this.r.a() == BLBluetoothManager.State.g) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Need BT audio: start=");
      stringBuilder1.append(bool1);
      stringBuilder1.append(", stop=");
      stringBuilder1.append(bool2);
      stringBuilder1.append(", BT state=");
      stringBuilder1.append(this.r.a());
      Log.d("BLAudioManager", stringBuilder1.toString());
    } 
    if (this.r.a() == BLBluetoothManager.State.g || this.r.a() == BLBluetoothManager.State.d || this.r.a() == BLBluetoothManager.State.f) {
      audioDevice = AudioDevice.d;
    } else if (this.m) {
      audioDevice = AudioDevice.b;
    } else {
      audioDevice = this.n;
    } 
    if (audioDevice != this.o || (bool ^ true) != 0) {
      a(audioDevice);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("New device status: available=");
      stringBuilder1.append(this.s);
      stringBuilder1.append(", selected=");
      stringBuilder1.append(audioDevice);
      Log.d("BLAudioManager", stringBuilder1.toString());
    } 
    Log.d("BLAudioManager", "--- updateAudioDeviceState done");
  }
  
  public enum AudioDevice {
    a, b, c, d, e;
  }
  
  public static interface AudioManagerEvents {
    void onAudioDeviceChanged(BLAudioManager.AudioDevice param1AudioDevice, Set<BLAudioManager.AudioDevice> param1Set);
  }
  
  public enum AudioManagerState {
    a, b, c;
  }
  
  public enum AudioSwitchMode {
    a, b;
  }
  
  class WiredHeadsetReceiver extends BroadcastReceiver {
    private WiredHeadsetReceiver(BLAudioManager this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      String str1;
      boolean bool = false;
      int i = param1Intent.getIntExtra("state", 0);
      int j = param1Intent.getIntExtra("microphone", 0);
      String str2 = param1Intent.getStringExtra("name");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("WiredHeadsetReceiver.onReceive");
      stringBuilder.append(BLUtils.a());
      stringBuilder.append(": a=");
      stringBuilder.append(param1Intent.getAction());
      stringBuilder.append(", s=");
      if (i == 0) {
        str1 = "unplugged";
      } else {
        str1 = "plugged";
      } 
      stringBuilder.append(str1);
      stringBuilder.append(", m=");
      if (j == 1) {
        str1 = "mic";
      } else {
        str1 = "no mic";
      } 
      stringBuilder.append(str1);
      stringBuilder.append(", n=");
      stringBuilder.append(str2);
      stringBuilder.append(", sb=");
      stringBuilder.append(isInitialStickyBroadcast());
      Log.d("BLAudioManager", stringBuilder.toString());
      BLAudioManager bLAudioManager = this.a;
      if (i == 1)
        bool = true; 
      BLAudioManager.a(bLAudioManager, bool);
      this.a.e();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\audio\audio_manager\BLAudioManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */