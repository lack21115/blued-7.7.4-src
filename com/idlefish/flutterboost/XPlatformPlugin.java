package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import java.util.ArrayList;
import java.util.List;

public class XPlatformPlugin {
  private Activity a;
  
  private PlatformChannel b;
  
  private PlatformChannel.SystemChromeStyle c;
  
  private int d;
  
  private PlatformChannel.PlatformMessageHandler e = new PlatformChannel.PlatformMessageHandler(this) {
      public CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat param1ClipboardContentFormat) {
        return XPlatformPlugin.a(this.a, param1ClipboardContentFormat);
      }
      
      public List<Rect> getSystemGestureExclusionRects() {
        return XPlatformPlugin.c(this.a);
      }
      
      public void playSystemSound(PlatformChannel.SoundType param1SoundType) {
        XPlatformPlugin.a(this.a, param1SoundType);
      }
      
      public void popSystemNavigator() {
        XPlatformPlugin.b(this.a);
      }
      
      public void restoreSystemUiOverlays() {
        XPlatformPlugin.a(this.a);
      }
      
      public void setApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription param1AppSwitcherDescription) {
        XPlatformPlugin.a(this.a, param1AppSwitcherDescription);
      }
      
      public void setClipboardData(String param1String) {
        XPlatformPlugin.a(this.a, param1String);
      }
      
      public void setPreferredOrientations(int param1Int) {
        XPlatformPlugin.a(this.a, param1Int);
      }
      
      public void setSystemGestureExclusionRects(ArrayList<Rect> param1ArrayList) {
        XPlatformPlugin.a(this.a, param1ArrayList);
      }
      
      public void setSystemUiOverlayStyle(PlatformChannel.SystemChromeStyle param1SystemChromeStyle) {
        XPlatformPlugin.a(this.a, param1SystemChromeStyle);
      }
      
      public void showSystemOverlays(List<PlatformChannel.SystemUiOverlay> param1List) {
        XPlatformPlugin.a(this.a, param1List);
      }
      
      public void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType param1HapticFeedbackType) {
        XPlatformPlugin.a(this.a, param1HapticFeedbackType);
      }
    };
  
  public XPlatformPlugin(PlatformChannel paramPlatformChannel) {
    this.b = paramPlatformChannel;
    this.b.setPlatformMessageHandler(this.e);
    this.d = 1280;
  }
  
  private CharSequence a(PlatformChannel.ClipboardContentFormat paramClipboardContentFormat) {
    ClipData clipData = ((ClipboardManager)this.a.getSystemService("clipboard")).getPrimaryClip();
    return (clipData == null) ? null : ((paramClipboardContentFormat == null || paramClipboardContentFormat == PlatformChannel.ClipboardContentFormat.PLAIN_TEXT) ? clipData.getItemAt(0).coerceToText((Context)this.a) : null);
  }
  
  private void a(int paramInt) {
    this.a.setRequestedOrientation(paramInt);
  }
  
  private void a(PlatformChannel.AppSwitcherDescription paramAppSwitcherDescription) {
    if (Build.VERSION.SDK_INT < 21)
      return; 
    if (Build.VERSION.SDK_INT < 28 && Build.VERSION.SDK_INT > 21)
      this.a.setTaskDescription(new ActivityManager.TaskDescription(paramAppSwitcherDescription.label, null, paramAppSwitcherDescription.color)); 
    if (Build.VERSION.SDK_INT >= 28) {
      ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(paramAppSwitcherDescription.label, 0, paramAppSwitcherDescription.color);
      this.a.setTaskDescription(taskDescription);
    } 
  }
  
  private void a(PlatformChannel.HapticFeedbackType paramHapticFeedbackType) {
    View view = this.a.getWindow().getDecorView();
    int i = null.a[paramHapticFeedbackType.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i != 5)
              return; 
            view.performHapticFeedback(4);
            return;
          } 
          view.performHapticFeedback(6);
          return;
        } 
        view.performHapticFeedback(3);
        return;
      } 
      view.performHapticFeedback(1);
      return;
    } 
    view.performHapticFeedback(0);
  }
  
  private void a(PlatformChannel.SoundType paramSoundType) {
    if (paramSoundType == PlatformChannel.SoundType.CLICK)
      this.a.getWindow().getDecorView().playSoundEffect(0); 
  }
  
  private void a(PlatformChannel.SystemChromeStyle paramSystemChromeStyle) {
    Window window = this.a.getWindow();
    View view = window.getDecorView();
    int j = view.getSystemUiVisibility();
    int i = j;
    if (Build.VERSION.SDK_INT >= 26) {
      int k = j;
      if (paramSystemChromeStyle.systemNavigationBarIconBrightness != null) {
        i = null.c[paramSystemChromeStyle.systemNavigationBarIconBrightness.ordinal()];
        if (i != 1) {
          if (i != 2) {
            k = j;
          } else {
            k = j & 0xFFFFFFEF;
          } 
        } else {
          k = j | 0x10;
        } 
      } 
      i = k;
      if (paramSystemChromeStyle.systemNavigationBarColor != null) {
        window.setNavigationBarColor(paramSystemChromeStyle.systemNavigationBarColor.intValue());
        i = k;
      } 
    } 
    j = i;
    if (Build.VERSION.SDK_INT >= 23) {
      int k = i;
      if (paramSystemChromeStyle.statusBarIconBrightness != null) {
        k = null.c[paramSystemChromeStyle.statusBarIconBrightness.ordinal()];
        if (k != 1) {
          if (k != 2) {
            k = i;
          } else {
            k = i & 0xFFFFDFFF;
          } 
        } else {
          k = i | 0x2000;
        } 
      } 
      j = k;
      if (paramSystemChromeStyle.statusBarColor != null) {
        window.setStatusBarColor(paramSystemChromeStyle.statusBarColor.intValue());
        j = k;
      } 
    } 
    Integer integer = paramSystemChromeStyle.systemNavigationBarDividerColor;
    view.setSystemUiVisibility(j);
    this.c = paramSystemChromeStyle;
  }
  
  private void a(String paramString) {
    ((ClipboardManager)this.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", paramString));
  }
  
  private void a(ArrayList<Rect> paramArrayList) {
    if (Build.VERSION.SDK_INT < 29)
      return; 
    this.a.getWindow().getDecorView().setSystemGestureExclusionRects(paramArrayList);
  }
  
  private void a(List<PlatformChannel.SystemUiOverlay> paramList) {
    int i;
    if (paramList.size() == 0) {
      i = 5894;
    } else {
      i = 1798;
    } 
    for (int j = 0; j < paramList.size(); j++) {
      PlatformChannel.SystemUiOverlay systemUiOverlay = paramList.get(j);
      int k = null.b[systemUiOverlay.ordinal()];
      if (k != 1) {
        if (k == 2)
          i = i & 0xFFFFFDFF & 0xFFFFFFFD; 
      } else {
        i &= 0xFFFFFFFB;
      } 
    } 
    this.d = i;
    a();
  }
  
  private void b() {
    a();
  }
  
  private void c() {
    this.a.finish();
  }
  
  private List<Rect> d() {
    return (Build.VERSION.SDK_INT >= 29) ? this.a.getWindow().getDecorView().getSystemGestureExclusionRects() : null;
  }
  
  public void a() {
    this.a.getWindow().getDecorView().setSystemUiVisibility(this.d);
    PlatformChannel.SystemChromeStyle systemChromeStyle = this.c;
    if (systemChromeStyle != null)
      a(systemChromeStyle); 
  }
  
  public void a(Activity paramActivity) {
    this.a = paramActivity;
  }
  
  public void b(Activity paramActivity) {
    if (paramActivity == this.a)
      this.a = null; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\XPlatformPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */