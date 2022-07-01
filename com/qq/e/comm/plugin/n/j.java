package com.qq.e.comm.plugin.n;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qq.e.comm.plugin.ab.d.e;
import com.qq.e.comm.plugin.ab.d.f;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.q.b;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;

public class j extends LinearLayout implements h {
  private b a;
  
  private com.qq.e.comm.plugin.ab.d.a b;
  
  private g c;
  
  private f.a d;
  
  private c e;
  
  private d f;
  
  j(Context paramContext, g paramg, c paramc) {
    super(paramContext);
    this.c = paramg;
    this.e = paramc;
    this.f = new d();
    d();
  }
  
  private void d() {
    setOrientation(1);
    this.a = new b(getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, am.a(getContext(), 45));
    layoutParams.gravity = 48;
    this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.a.setBackgroundColor(-1);
    this.a.a(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (j.a(this.a).d()) {
              j.a(this.a).e();
              return;
            } 
            if (j.b(this.a) != null)
              j.b(this.a).b(); 
          }
        });
    addView((View)this.a);
    this.b = (new e(getContext(), null)).a();
    this.b.a(new f(this) {
          public void a(int param1Int) {}
          
          public void a(int param1Int, String param1String1, String param1String2) {
            j.c(this.a).a("wu", param1String2);
            u.a(1020052, 0, j.d(this.a), j.c(this.a));
          }
          
          public void a(ValueCallback<Uri> param1ValueCallback, Intent param1Intent) {}
          
          public void a(String param1String) {
            j.c(this.a).a("wu", param1String);
            u.a(1020051, 0, j.d(this.a), j.c(this.a));
          }
          
          public void a(String param1String, Bitmap param1Bitmap) {}
          
          public void b(String param1String) {}
          
          public boolean b(ValueCallback<Uri[]> param1ValueCallback, Intent param1Intent) {
            return false;
          }
          
          public void c(String param1String) {
            if (j.e(this.a) != null)
              j.e(this.a).a(param1String); 
          }
          
          public void d_() {}
        });
    this.b.b().setOnTouchListener(new a());
    addView(this.b.b(), (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    this.c.a((View)this);
  }
  
  private String e() {
    String str;
    View view = this.b.b();
    this.c.a().a(view.getHeight());
    this.c.a().b(view.getWidth());
    this.c.b(System.currentTimeMillis());
    view = null;
    try {
      null = this.c.b();
      str = null;
      JSONObject jSONObject = new JSONObject(null);
      str = null;
      jSONObject.put("click_area", 10);
      str = null;
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return str;
    } 
  }
  
  public void a() {
    setVisibility(8);
  }
  
  public void a(ViewGroup paramViewGroup) {
    if (getParent() == null)
      paramViewGroup.addView((View)this, new ViewGroup.LayoutParams(-1, -1)); 
  }
  
  public void a(f.a parama) {
    this.d = parama;
  }
  
  public void a(String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      ak.a("LandingPageView", "load url is null");
      return;
    } 
    com.qq.e.comm.plugin.ab.d.a a1 = this.b;
    if (a1 != null)
      a1.a(paramString); 
  }
  
  public void b() {
    setVisibility(0);
  }
  
  public void c() {
    com.qq.e.comm.plugin.ab.d.a a1 = this.b;
    if (a1 != null)
      a1.a(); 
  }
  
  class a implements View.OnTouchListener {
    private boolean b;
    
    private boolean c;
    
    private float d;
    
    private float e;
    
    private int f = ViewConfiguration.get(this.a.getContext()).getScaledTouchSlop();
    
    private a(j this$0) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      if (j.f(this.a) != null)
        j.f(this.a).a(param1MotionEvent, true); 
      int i = param1MotionEvent.getAction();
      if (i != 0) {
        if (i == 1) {
          boolean bool;
          if (param1MotionEvent.getRawX() - this.d > this.f || param1MotionEvent.getRawY() - this.e > this.f) {
            bool = true;
          } else {
            bool = false;
          } 
          this.c = bool;
          if (!this.b && !this.c) {
            ak.a("LandingPageView", "LandingPageView user click");
            u.a(1020050, j.d(this.a));
            this.b = true;
            if (j.b(this.a) != null)
              j.b(this.a).a(j.g(this.a), true); 
          } 
          this.c = false;
        } 
      } else {
        this.d = param1MotionEvent.getRawX();
        this.e = param1MotionEvent.getRawY();
      } 
      return j.a(this.a).b().onTouchEvent(param1MotionEvent);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\n\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */