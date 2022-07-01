package com.alipay.sdk.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.sdk.util.c;
import java.io.ByteArrayInputStream;

public class a {
  public static final String a = "正在加载";
  
  public static final String b = "去支付宝付款";
  
  public static final String c = "去支付宝授权";
  
  public static String d = "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";
  
  private a e;
  
  private Activity f;
  
  private String g;
  
  private long h = -1L;
  
  private final int i = 1;
  
  private final long j = 15000L;
  
  private boolean k = false;
  
  private Handler l = new d(this, Looper.getMainLooper());
  
  public a(Activity paramActivity) {
    this.f = paramActivity;
  }
  
  public a(Activity paramActivity, String paramString) {
    this.f = paramActivity;
    this.g = paramString;
  }
  
  public String a() {
    return this.g;
  }
  
  public void a(String paramString) {
    this.g = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.k = paramBoolean;
  }
  
  public void b() {
    Activity activity = this.f;
    if (activity != null)
      activity.runOnUiThread(new b(this)); 
  }
  
  public void c() {
    Activity activity = this.f;
    if (activity != null)
      activity.runOnUiThread(new c(this)); 
  }
  
  public void d() {
    this.f = null;
    this.e = null;
  }
  
  public class a extends AlertDialog {
    protected a(a this$0, Context param1Context) {
      super(param1Context);
    }
    
    private int a(Context param1Context, float param1Float) {
      Resources resources;
      if (param1Context == null) {
        resources = Resources.getSystem();
      } else {
        resources = resources.getResources();
      } 
      return (int)(param1Float * (resources.getDisplayMetrics()).density);
    }
    
    private Drawable a(Context param1Context, String param1String, int param1Int) {
      try {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(com.alipay.sdk.encrypt.a.a(param1String));
      } finally {
        param1String = null;
      } 
      try {
        c.a((Throwable)param1String);
        return null;
      } finally {
        if (exception != null)
          try {
            exception.close();
          } catch (Exception exception1) {} 
      } 
    }
    
    private View a(Context param1Context) {
      String str;
      LinearLayout linearLayout = new LinearLayout(param1Context);
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, a(param1Context, 50.0F));
      layoutParams.gravity = 17;
      linearLayout.setOrientation(0);
      linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      GradientDrawable gradientDrawable = new GradientDrawable();
      gradientDrawable.setColor(-450944201);
      gradientDrawable.setCornerRadius(a(param1Context, 5.0F));
      linearLayout.setBackgroundDrawable((Drawable)gradientDrawable);
      ImageView imageView = new ImageView(param1Context);
      LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a(param1Context, 20.0F), a(param1Context, 20.0F));
      layoutParams2.gravity = 16;
      layoutParams2.setMargins(a((Context)a.a(this.a), 17.0F), a((Context)a.a(this.a), 10.0F), a((Context)a.a(this.a), 8.0F), a((Context)a.a(this.a), 10.0F));
      imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
      imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      imageView.setImageDrawable(a(param1Context, a.d, 480));
      RotateAnimation rotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      rotateAnimation.setRepeatCount(-1);
      rotateAnimation.setDuration(900L);
      rotateAnimation.setInterpolator((Interpolator)new LinearInterpolator());
      imageView.startAnimation((Animation)rotateAnimation);
      TextView textView = new TextView(param1Context);
      if (TextUtils.isEmpty(a.b(this.a))) {
        str = "正在加载";
      } else {
        str = a.b(this.a);
      } 
      textView.setText(str);
      textView.setTextSize(16.0F);
      textView.setTextColor(-1);
      LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-2, -2);
      layoutParams1.gravity = 16;
      layoutParams1.setMargins(0, 0, a(param1Context, 17.0F), 0);
      textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
      linearLayout.addView((View)imageView);
      linearLayout.addView((View)textView);
      FrameLayout frameLayout = new FrameLayout(param1Context);
      frameLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
      frameLayout.addView((View)linearLayout);
      return (View)frameLayout;
    }
    
    protected void onCreate(Bundle param1Bundle) {
      super.onCreate(param1Bundle);
      setContentView(a(getContext()));
      Window window = getWindow();
      if (window != null)
        window.setBackgroundDrawable((Drawable)new ColorDrawable(0)); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */