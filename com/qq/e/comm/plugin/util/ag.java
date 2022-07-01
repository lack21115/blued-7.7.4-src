package com.qq.e.comm.plugin.util;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.OrientationEventListener;
import com.qq.e.comm.util.GDTLogger;
import java.lang.ref.WeakReference;

public class ag {
  private OrientationEventListener a;
  
  private boolean b;
  
  private boolean c;
  
  private boolean d;
  
  private int e;
  
  private int f = 1;
  
  private WeakReference<Activity> g;
  
  private boolean h;
  
  private a i;
  
  public ag(Activity paramActivity) {
    this.g = new WeakReference<Activity>(paramActivity);
    a(paramActivity.getApplicationContext());
  }
  
  private void a(Context paramContext) {
    if (this.a == null)
      this.a = new OrientationEventListener(this, paramContext, paramContext) {
          public void onOrientationChanged(int param1Int) {
            boolean bool;
            if (Settings.System.getInt(this.a.getContentResolver(), "accelerometer_rotation", 0) == 1) {
              bool = true;
            } else {
              bool = false;
            } 
            if (!bool)
              return; 
            if ((param1Int >= 0 && param1Int <= 30) || param1Int >= 330) {
              if (ag.a(this.b)) {
                if (ag.b(this.b) <= 0 || ag.c(this.b)) {
                  ag.a(this.b, true);
                  ag.b(this.b, false);
                  ag.a(this.b, 0);
                  return;
                } 
              } else {
                if (ag.b(this.b) > 0) {
                  ag.b(this.b, 1);
                  if (ag.d(this.b) != null)
                    ag.d(this.b).a(); 
                  if (ag.e(this.b) != null && ag.e(this.b).get() != null) {
                    ((Activity)ag.e(this.b).get()).setRequestedOrientation(1);
                    ag.a(this.b, 0);
                  } else {
                    return;
                  } 
                } else {
                  return;
                } 
                ag.b(this.b, false);
              } 
            } else if (param1Int >= 240 && param1Int <= 300) {
              if (ag.a(this.b)) {
                if (ag.b(this.b) == 1 || ag.f(this.b)) {
                  ag.c(this.b, true);
                  ag.b(this.b, false);
                  ag.a(this.b, 1);
                  return;
                } 
              } else {
                if (ag.b(this.b) != 1) {
                  ag.b(this.b, 0);
                  if (ag.d(this.b) != null)
                    ag.d(this.b).b(); 
                  if (ag.e(this.b) != null && ag.e(this.b).get() != null) {
                    ((Activity)ag.e(this.b).get()).setRequestedOrientation(0);
                    ag.a(this.b, 1);
                  } else {
                    return;
                  } 
                } else {
                  return;
                } 
                ag.b(this.b, false);
              } 
            } else if (param1Int > 60 && param1Int < 120) {
              if (ag.a(this.b)) {
                if (ag.b(this.b) == 2 || ag.f(this.b)) {
                  ag.c(this.b, true);
                  ag.b(this.b, false);
                  ag.a(this.b, 2);
                  return;
                } 
              } else {
                if (ag.b(this.b) != 2) {
                  ag.b(this.b, 0);
                  if (ag.d(this.b) != null)
                    ag.d(this.b).c(); 
                  if (ag.e(this.b) != null && ag.e(this.b).get() != null) {
                    ((Activity)ag.e(this.b).get()).setRequestedOrientation(8);
                    ag.a(this.b, 2);
                  } else {
                    return;
                  } 
                } else {
                  return;
                } 
                ag.b(this.b, false);
              } 
            } 
          }
        }; 
  }
  
  public void a() {
    OrientationEventListener orientationEventListener = this.a;
    if (orientationEventListener != null) {
      orientationEventListener.disable();
      this.g = null;
    } 
  }
  
  public void a(a parama) {
    this.i = parama;
  }
  
  public void a(boolean paramBoolean) {
    this.h = paramBoolean;
    if (this.h) {
      this.a.enable();
      return;
    } 
    this.a.disable();
  }
  
  public void b() {
    a a1;
    WeakReference<Activity> weakReference = this.g;
    if (weakReference == null) {
      GDTLogger.e("orientationutil has been released");
      return;
    } 
    this.b = true;
    if (this.e == 0) {
      this.f = 0;
      if (weakReference != null && weakReference.get() != null) {
        ((Activity)this.g.get()).setRequestedOrientation(0);
        a1 = this.i;
        if (a1 != null)
          a1.b(); 
        this.e = 1;
        this.c = false;
        return;
      } 
    } else {
      this.f = 1;
      if (a1 != null && a1.get() != null) {
        ((Activity)this.g.get()).setRequestedOrientation(1);
        a1 = this.i;
        if (a1 != null)
          a1.a(); 
        this.e = 0;
        this.d = false;
      } 
    } 
  }
  
  public static interface a {
    void a();
    
    void b();
    
    void c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */