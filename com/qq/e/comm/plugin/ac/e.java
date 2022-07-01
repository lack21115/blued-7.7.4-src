package com.qq.e.comm.plugin.ac;

import android.app.Dialog;
import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qq.e.comm.plugin.ab.d.a;
import com.qq.e.comm.plugin.util.aq;
import com.qq.e.comm.plugin.util.o;

public class e extends Dialog {
  Context a;
  
  private LinearLayout b;
  
  private a c;
  
  private double d = 0.8D;
  
  private double e = 1.0D;
  
  private double f = 0.095D;
  
  private int g;
  
  private int h;
  
  private double i = 0.8D;
  
  private int j;
  
  private int k;
  
  private boolean l = false;
  
  private boolean m = true;
  
  public e(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
  }
  
  private void a() {
    this.b = new LinearLayout(this.a);
    this.b.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    this.b.setOrientation(1);
    this.b.setBackgroundColor(-1);
    setContentView((View)this.b);
    this.c = (new com.qq.e.comm.plugin.ab.d.e(this.a, null)).a();
    this.c.b().setLayerType(1, null);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ImageView imageView = new ImageView(this.a);
    imageView.setImageBitmap(aq.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAbFBMVEUAAAAAAAD////p6eknJyf/\n//8MDAz///////8REREbGxs9PT11dXWlpaX39/f///////////////9qamoZGRksLCxQUFBkZGSL\ni4u/v7/Z2dny8vL///////////////////////////////8d9apUAAAAI3RSTlOAAE3qikd6JQV3\nc2hbVE5AKx4RoYZtY15YUVBORD48MhoKNpZmpn4AAAHhSURBVFjDpZfbloIwDEXPVFsoFwW830H/\n/x+HRMYRIQIr54EHl2eTNiVN8CMoLIPb5WyNsefLLShD6X/9gCJbmg8ts2IsIAwad4cRhIMAslsj\nyhLiOyB/2Q/JduMd4PxmmxxeiPwroLoa1iKNHVpycbowrGslAwr7tCcOPXLJE2ELCZAb1t5DkN8b\nVt4PyAwpjfBFUWpIWR/gbkg7DGhnSPcugN9/ijGo+NSKAe/rP0YYoejI+9AGFOz3GCXPhOIdUFmK\nP8JIRbQKW70B+PzEGK2YT9Q/IBf2fyAX+R8gtJR/TFJKiwgbQEC4CJMUkScgQBPAHhO1b0LAM4CF\nx0T5BYXAAKo/CVpardHReoWWEqpRBCgoANf2P2ZzfGg+e7QJjkIoakDWTcF6RoRP/2zdTURWA5Y9\nZ2hOBPGHRjGvASHlw0EiyH44coYoqX4CEkH2A1RpSwScA5kg+zkPAW71cwuZIPuxra03XOrnBjJB\n9mNTWy84108PmSD74WvrGZaTIBNkP6fBgnIByATZD/aqAeolqDdRnUb1QVIfZfXHpP6ctQVFXdLU\nRVVb1tUXi/pq016u6utd22BoWxx1k6Vt87SNprbVVTfb+nZfP3DoRx790KUf+/SDp3701Q/f6vH/\nFzOPJ4ULw0zxAAAAAElFTkSuQmCC\n"));
    int i = this.h;
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(i, i);
    layoutParams1.gravity = 83;
    imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    FrameLayout frameLayout = new FrameLayout(this.a);
    i = this.g;
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i);
    layoutParams2.gravity = 5;
    frameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    frameLayout.setBackgroundColor(-1);
    frameLayout.addView((View)imageView);
    this.b.addView((View)frameLayout);
    this.b.addView(this.c.b(), (ViewGroup.LayoutParams)layoutParams);
    frameLayout.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.cancel();
          }
        });
  }
  
  private void b() {
    d();
    a();
    setCanceledOnTouchOutside(this.l);
    setCancelable(this.m);
  }
  
  private void b(String paramString) {
    this.c.a(paramString);
  }
  
  private void c() {
    show();
    Window window = getWindow();
    if (window != null)
      window.setLayout(this.j, this.k); 
  }
  
  private void d() {
    Pair pair = o.a();
    this.j = (int)(Math.min(((Integer)pair.first).intValue(), ((Integer)pair.second).intValue()) * this.d);
    int i = this.j;
    this.k = (int)(i * this.e);
    this.g = (int)(i * this.f);
    this.h = (int)(this.g * this.i);
  }
  
  public void a(String paramString) {
    b();
    b(paramString);
    c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ac\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */