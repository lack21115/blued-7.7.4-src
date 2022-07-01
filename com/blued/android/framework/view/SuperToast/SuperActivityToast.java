package com.blued.android.framework.view.SuperToast;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import com.blued.android.framework.R;
import com.blued.android.framework.view.SuperToast.utils.BackgroundUtils;
import java.util.ArrayList;

public class SuperActivityToast extends SuperToast {
  private Context a;
  
  private View b;
  
  private ViewGroup c;
  
  private Style d;
  
  private boolean e;
  
  public SuperActivityToast(Context paramContext) {
    super(paramContext, 2);
    if (paramContext instanceof Activity) {
      this.a = paramContext;
      this.d = j();
      this.c = (ViewGroup)((Activity)paramContext).findViewById(16908290);
      return;
    } 
    throw new IllegalArgumentException("SuperActivityToast Context must be an Activity.");
  }
  
  public SuperActivityToast(Context paramContext, Style paramStyle) {
    super(paramContext, paramStyle, 2);
    if (paramContext instanceof Activity) {
      this.a = paramContext;
      this.d = paramStyle;
      this.c = (ViewGroup)((Activity)paramContext).findViewById(16908290);
      return;
    } 
    throw new IllegalArgumentException("SuperActivityToast Context must be an Activity.");
  }
  
  public static void a(Context paramContext, Bundle paramBundle) {
    if (paramBundle == null)
      return; 
    if (Build.VERSION.SDK_INT == 28 && g())
      paramBundle.setClassLoader(Style.class.getClassLoader()); 
    ArrayList arrayList = paramBundle.getParcelableArrayList("0x532e412e542e");
    if (arrayList == null) {
      Log.e(SuperActivityToast.class.getName(), "Cannot recreate SuperActivityToasts onRestoreState(). Was onSaveState() called?");
      return;
    } 
    boolean bool = true;
    for (Style style : arrayList) {
      if (!style.p) {
        (new SuperToast(paramContext, style)).o();
      } else if (bool) {
        (new SuperActivityToast(paramContext, style)).a().o();
      } else {
        (new SuperActivityToast(paramContext, style)).o();
      } 
      bool = false;
    } 
  }
  
  public static void a(Bundle paramBundle) {
    ArrayList<Style> arrayList = new ArrayList();
    for (SuperToast superToast : Toaster.a().c()) {
      if (superToast instanceof SuperActivityToast)
        (superToast.j()).p = true; 
      arrayList.add(superToast.j());
    } 
    paramBundle.putParcelableArrayList("0x532e412e542e", arrayList);
    Toaster.a().b();
  }
  
  public static boolean g() {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    return ((str2 != null && str2.toLowerCase().contains("rmx")) || (str1 != null && str1.toLowerCase().contains("realme")));
  }
  
  public View a(Context paramContext, LayoutInflater paramLayoutInflater) {
    return paramLayoutInflater.inflate(R.layout.supertoast_button, (ViewGroup)((Activity)paramContext).findViewById(16908290), false);
  }
  
  protected View a(Context paramContext, LayoutInflater paramLayoutInflater, int paramInt) {
    if (paramContext instanceof Activity) {
      this.b = a(paramContext, paramLayoutInflater);
      return this.b;
    } 
    throw new IllegalArgumentException("SuperActivityToast Context must be an Activity.");
  }
  
  protected SuperActivityToast a() {
    this.e = true;
    return this;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    if (this.d.e != 3) {
      Style style = this.d;
      style.j = -1;
      style.h = BackgroundUtils.b(paramInt1);
      this.d.i = BackgroundUtils.b(paramInt2);
    } 
    if (((this.a.getResources().getConfiguration()).screenLayout & 0xF) >= 3) {
      this.d.j = BackgroundUtils.b(paramInt3);
      this.d.g = 8388659;
    } 
  }
  
  protected boolean b() {
    return this.e;
  }
  
  public boolean c() {
    return this.d.x;
  }
  
  public ViewGroup d() {
    return this.c;
  }
  
  public void e() {
    String str;
    Button button = (Button)this.b.findViewById(R.id.button);
    button.setBackgroundResource(BackgroundUtils.a(this.d.e));
    if (this.d.z != null) {
      str = this.d.z.toUpperCase();
    } else {
      str = "";
    } 
    button.setText(str);
    button.setTypeface(button.getTypeface(), this.d.A);
    button.setTextColor(this.d.B);
    button.setTextSize(this.d.C);
    if (this.d.e != 3) {
      this.b.findViewById(R.id.divider).setBackgroundColor(this.d.D);
      if (this.d.E > 0)
        button.setCompoundDrawablesWithIntrinsicBounds(ResourcesCompat.getDrawable(this.a.getResources(), this.d.E, this.a.getTheme()), null, null, null); 
    } 
  }
  
  protected void f() {
    super.f();
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.d.j, this.d.k);
    a(24, 24, 568);
    e();
    layoutParams.width = this.d.j;
    layoutParams.height = this.d.k;
    layoutParams.gravity = this.d.g;
    layoutParams.bottomMargin = this.d.i;
    layoutParams.topMargin = this.d.i;
    layoutParams.leftMargin = this.d.h;
    layoutParams.rightMargin = this.d.h;
    this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    if (this.d.y) {
      this.b.setOnTouchListener(new View.OnTouchListener(this) {
            int a;
            
            public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
              if (this.a == 0 && param1MotionEvent.getAction() == 0)
                this.b.p(); 
              this.a++;
              return false;
            }
          });
      return;
    } 
    this.b.setOnTouchListener(null);
  }
  
  public static interface OnButtonClickListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\SuperToast\SuperActivityToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */