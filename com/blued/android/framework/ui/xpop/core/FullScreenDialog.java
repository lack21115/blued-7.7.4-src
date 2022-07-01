package com.blued.android.framework.ui.xpop.core;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

public class FullScreenDialog extends Dialog {
  BasePopupView a;
  
  public FullScreenDialog(Context paramContext) {
    super(paramContext, R.style._XPopup_TransparentDialog);
  }
  
  private String a(int paramInt) {
    try {
      return getContext().getResources().getResourceEntryName(paramInt);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public FullScreenDialog a(BasePopupView paramBasePopupView) {
    this.a = paramBasePopupView;
    return this;
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
    if (paramBoolean) {
      layoutParams.flags = paramInt | layoutParams.flags;
    } else {
      layoutParams.flags = paramInt & layoutParams.flags;
    } 
    getWindow().setAttributes(layoutParams);
  }
  
  public void a(MotionEvent paramMotionEvent) {
    BasePopupView basePopupView = this.a;
    if (basePopupView != null && basePopupView.getContext() instanceof Activity)
      ((Activity)this.a.getContext()).dispatchTouchEvent(paramMotionEvent); 
  }
  
  public boolean a() {
    // Byte code:
    //   0: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   3: ldc 'X'
    //   5: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   8: istore_2
    //   9: iconst_0
    //   10: istore_3
    //   11: iload_2
    //   12: ifne -> 34
    //   15: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   18: ldc 'x'
    //   20: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   23: ifeq -> 29
    //   26: goto -> 34
    //   29: iconst_0
    //   30: istore_1
    //   31: goto -> 36
    //   34: iconst_1
    //   35: istore_1
    //   36: iload_3
    //   37: istore_2
    //   38: invokestatic a : ()Z
    //   41: ifeq -> 70
    //   44: getstatic android/os/Build$VERSION.SDK_INT : I
    //   47: bipush #26
    //   49: if_icmpeq -> 62
    //   52: iload_3
    //   53: istore_2
    //   54: getstatic android/os/Build$VERSION.SDK_INT : I
    //   57: bipush #27
    //   59: if_icmpne -> 70
    //   62: iload_3
    //   63: istore_2
    //   64: iload_1
    //   65: ifne -> 70
    //   68: iconst_1
    //   69: istore_2
    //   70: iload_2
    //   71: ireturn
  }
  
  public boolean b() {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= 23) {
      bool1 = bool2;
      if ((((Activity)this.a.getContext()).getWindow().getDecorView().getSystemUiVisibility() & 0x2000) != 0)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public void c() {
    if (!this.a.l.u.booleanValue()) {
      getWindow().setFlags(1024, 1024);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 23) {
      View view = getWindow().getDecorView();
      int i = view.getSystemUiVisibility();
      if (b()) {
        i |= 0x2000;
      } else {
        i &= 0xFFFFDFFF;
      } 
      view.setSystemUiVisibility(i);
    } 
  }
  
  public void d() {
    if (Build.VERSION.SDK_INT < 19)
      return; 
    ViewGroup viewGroup = (ViewGroup)getWindow().getDecorView();
    int i = 0;
    int j = viewGroup.getChildCount();
    while (i < j) {
      View view = viewGroup.getChildAt(i);
      int k = view.getId();
      if (k != -1 && "navigationBarBackground".equals(a(k)))
        view.setVisibility(4); 
      i++;
    } 
    getWindow().setFlags(8, 8);
    viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() | 0xF06);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    if (a())
      paramMotionEvent.setLocation(paramMotionEvent.getX(), paramMotionEvent.getY() + XPopupUtils.a()); 
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (getWindow() == null)
      return; 
    BasePopupView basePopupView = this.a;
    if (basePopupView != null && basePopupView.l.F)
      if (Build.VERSION.SDK_INT >= 26) {
        getWindow().setType(2038);
      } else {
        getWindow().setType(2003);
      }  
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    getWindow().setFlags(16777216, 16777216);
    getWindow().setSoftInputMode(16);
    if (a()) {
      getWindow().getDecorView().setTranslationY(-XPopupUtils.a());
      getWindow().setLayout(-1, Math.max(XPopupUtils.c(getWindow()), XPopupUtils.b(getContext())));
    } else {
      getWindow().setLayout(-1, Math.max(XPopupUtils.c(getWindow()), XPopupUtils.b(getContext())));
    } 
    getWindow().getDecorView().setSystemUiVisibility(1280);
    if (!this.a.l.B)
      getWindow().setFlags(8, 8); 
    if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21)
      a(201326592, true); 
    if (Build.VERSION.SDK_INT >= 21) {
      a(201326592, false);
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(this.a.l.w);
      getWindow().addFlags(-2147483648);
    } 
    if (Build.VERSION.SDK_INT == 19)
      getWindow().clearFlags(67108864); 
    if (!this.a.l.v.booleanValue())
      d(); 
    c();
    setContentView((View)this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\core\FullScreenDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */