package com.idlefish.flutterboost.containers;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.idlefish.flutterboost.Debuger;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XFlutterView;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

public class FlutterSplashView extends FrameLayout {
  private static String a = "FlutterSplashView";
  
  private FlutterEngine b;
  
  private SplashScreen c;
  
  private XFlutterView d;
  
  private View e;
  
  private Bundle f;
  
  private String g;
  
  private String h;
  
  private Handler i = new Handler();
  
  private final FlutterView.FlutterEngineAttachmentListener j = new FlutterView.FlutterEngineAttachmentListener(this) {
      public void onFlutterEngineAttachedToFlutterView(FlutterEngine param1FlutterEngine) {
        FlutterSplashView.a(this.a).a(this);
      }
      
      public void onFlutterEngineDetachedFromFlutterView() {}
    };
  
  private final FlutterUiDisplayListener k = new FlutterUiDisplayListener(this) {
      public void onFlutterUiDisplayed() {
        if (FlutterSplashView.b(this.a) != null)
          FlutterSplashView.c(this.a); 
      }
      
      public void onFlutterUiNoLongerDisplayed() {}
    };
  
  private final Runnable l = new Runnable(this) {
      public void run() {
        FlutterSplashView flutterSplashView = this.a;
        flutterSplashView.removeView(FlutterSplashView.d(flutterSplashView));
        flutterSplashView = this.a;
        FlutterSplashView.a(flutterSplashView, FlutterSplashView.e(flutterSplashView));
      }
    };
  
  public FlutterSplashView(Context paramContext) {
    this(paramContext, (AttributeSet)null, 0);
  }
  
  public FlutterSplashView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlutterSplashView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setSaveEnabled(true);
    if (this.b == null)
      this.b = FlutterBoost.a().g(); 
  }
  
  private void c() {
    this.g = this.d.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Transitioning splash screen to a Flutter UI. Isolate: ");
    stringBuilder.append(this.g);
    Log.v(str, stringBuilder.toString());
    this.c.transitionToFlutter(this.l);
  }
  
  public void a() {
    Debuger.a("BoostFlutterView onAttach");
    this.d.a(this.b);
  }
  
  public void a(XFlutterView paramXFlutterView, SplashScreen paramSplashScreen) {
    XFlutterView xFlutterView = this.d;
    if (xFlutterView != null) {
      xFlutterView.b(this.k);
      removeView((View)this.d);
    } 
    View view = this.e;
    if (view != null)
      removeView(view); 
    this.d = paramXFlutterView;
    addView((View)paramXFlutterView);
    this.c = paramSplashScreen;
    if (paramSplashScreen != null) {
      this.e = paramSplashScreen.createSplashView(getContext(), this.f);
      this.e.setBackgroundColor(-1);
      addView(this.e);
      paramXFlutterView.a(this.k);
    } 
  }
  
  public void b() {
    Debuger.a("BoostFlutterView onDetach");
    this.d.a();
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.i.removeCallbacksAndMessages(null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\containers\FlutterSplashView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */