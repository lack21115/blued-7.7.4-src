package com.blued.android.framework.utils;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;

public class AudioManagerUtils {
  private static final String b = AudioManagerUtils.class.getSimpleName();
  
  private static AudioManagerUtils g;
  
  AudioManager.OnAudioFocusChangeListener a = new AudioManager.OnAudioFocusChangeListener(this) {
      public void onAudioFocusChange(int param1Int) {}
    };
  
  private AudioManager c;
  
  private AudioFocusRequest d;
  
  private boolean e = false;
  
  private Handler f = new Handler(Looper.getMainLooper(), new Handler.Callback(this) {
        public boolean handleMessage(Message param1Message) {
          if (param1Message != null) {
            int i = param1Message.what;
            if (i != 1) {
              if (i == 2)
                AudioManagerUtils.a(this.a); 
            } else {
              AudioManagerUtils.b(this.a);
            } 
          } 
          return false;
        }
      });
  
  public static AudioManagerUtils a() {
    // Byte code:
    //   0: getstatic com/blued/android/framework/utils/AudioManagerUtils.g : Lcom/blued/android/framework/utils/AudioManagerUtils;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/framework/utils/AudioManagerUtils
    //   8: monitorenter
    //   9: getstatic com/blued/android/framework/utils/AudioManagerUtils.g : Lcom/blued/android/framework/utils/AudioManagerUtils;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/framework/utils/AudioManagerUtils
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/framework/utils/AudioManagerUtils.g : Lcom/blued/android/framework/utils/AudioManagerUtils;
    //   25: ldc com/blued/android/framework/utils/AudioManagerUtils
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/framework/utils/AudioManagerUtils
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/framework/utils/AudioManagerUtils.g : Lcom/blued/android/framework/utils/AudioManagerUtils;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void c() {
    if (!this.e) {
      if (this.c == null)
        this.c = (AudioManager)AppInfo.d().getSystemService("audio"); 
      if (this.c != null)
        try {
          int i;
          String str;
          if (Build.VERSION.SDK_INT < 26) {
            i = this.c.requestAudioFocus(this.a, 3, 2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(" requestAudioFocus: SDK_INT < 26,");
            str = stringBuilder.toString();
          } else {
            if (this.d == null) {
              AudioAttributes audioAttributes = (new AudioAttributes.Builder()).setUsage(1).setContentType(3).build();
              this.d = (new AudioFocusRequest.Builder(2)).setAudioAttributes(audioAttributes).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this.a).build();
            } 
            i = this.c.requestAudioFocus(this.d);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(" requestAudioFocus: SDK_INT >= 26,");
            str = stringBuilder.toString();
          } 
          if (i == 1)
            this.e = true; 
          if (AppInfo.m()) {
            String str1 = b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" SDK_INT = ");
            stringBuilder.append(Build.VERSION.SDK_INT);
            stringBuilder.append(" , requestFocusResult = ");
            stringBuilder.append(i);
            Log.b(str1, stringBuilder.toString());
            return;
          } 
        } catch (Exception exception) {
          exception.printStackTrace();
        }  
    } 
  }
  
  private void d() {
    if (this.e) {
      if (this.c == null)
        this.c = (AudioManager)AppInfo.d().getSystemService("audio"); 
      if (this.c != null)
        try {
          int i;
          String str;
          if (Build.VERSION.SDK_INT < 26) {
            i = this.c.abandonAudioFocus(this.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(" abandonAudioFocus: SDK_INT < 26,");
            str = stringBuilder.toString();
          } else {
            if (this.d == null) {
              AudioAttributes audioAttributes = (new AudioAttributes.Builder()).setUsage(1).setContentType(3).build();
              this.d = (new AudioFocusRequest.Builder(2)).setAudioAttributes(audioAttributes).setOnAudioFocusChangeListener(this.a).setAcceptsDelayedFocusGain(true).build();
            } 
            i = this.c.abandonAudioFocusRequest(this.d);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(" abandonAudioFocus: SDK_INT >= 26,");
            str = stringBuilder.toString();
          } 
          if (i == 1)
            this.e = false; 
          if (AppInfo.m()) {
            String str1 = b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" SDK_INT = ");
            stringBuilder.append(Build.VERSION.SDK_INT);
            stringBuilder.append(" , abandonFocusResult = ");
            stringBuilder.append(i);
            Log.b(str1, stringBuilder.toString());
            return;
          } 
        } catch (Exception exception) {
          exception.printStackTrace();
        }  
    } 
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      Handler handler = this.f;
      if (handler != null) {
        handler.removeMessages(1);
        this.f.sendEmptyMessageDelayed(1, 1000L);
        return;
      } 
    } else {
      Handler handler = this.f;
      if (handler != null) {
        handler.removeMessages(1);
        this.f.sendEmptyMessage(1);
      } 
    } 
  }
  
  public void b() {
    Handler handler = this.f;
    if (handler != null) {
      handler.removeMessages(1);
      this.f.sendEmptyMessage(2);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\AudioManagerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */