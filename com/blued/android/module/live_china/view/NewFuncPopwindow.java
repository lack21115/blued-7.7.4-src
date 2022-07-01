package com.blued.android.module.live_china.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.same.Logger;

public class NewFuncPopwindow extends PopupWindow {
  private Context a;
  
  private TextView b;
  
  private ImageView c;
  
  private int d = 0;
  
  private int e = 0;
  
  private HoleRelativeLayout f;
  
  private Window g;
  
  private HoleRelativeLayout.RoundRect h;
  
  private View i;
  
  private int j = (int)(AppInfo.l * 0.6D);
  
  private int k = 0;
  
  private CountDownTimer l;
  
  private FuncDismissListener m;
  
  private int n = 0;
  
  public NewFuncPopwindow(Context paramContext, int paramInt1, int paramInt2) {
    super(paramContext);
    this.a = paramContext;
    if (paramInt1 > 0)
      this.j = paramInt1; 
    if (paramInt2 > 0)
      this.k = paramInt2; 
    a();
  }
  
  private void a() {
    View view = LayoutInflater.from(this.a).inflate(R.layout.pop_new_function_layout, null);
    this.b = (TextView)view.findViewById(R.id.pop_guest_text);
    this.c = (ImageView)view.findViewById(R.id.pop_guest_image);
    setContentView(view);
    int i = this.j;
    if (i > 0)
      setWidth(i); 
    i = this.k;
    if (i > 0)
      setHeight(i); 
    setBackgroundDrawable((Drawable)new ColorDrawable(0));
    setOutsideTouchable(true);
  }
  
  public void a(float paramFloat) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("backgroundAlpha ... bgAlpha = ");
    stringBuilder.append(paramFloat);
    Logger.d("NewFuncPopwindow", new Object[] { stringBuilder.toString() });
    if (this.f == null) {
      this.g = ((Activity)this.a).getWindow();
      this.f = new HoleRelativeLayout(this.a);
      if (this.h == null) {
        this.h = new HoleRelativeLayout.RoundRect();
        HoleRelativeLayout.RoundRect roundRect = this.h;
        roundRect.d = 50.0F;
        roundRect.c = 60.0F;
        roundRect.a = this.d;
        roundRect.b = this.e;
      } 
      this.f.a(this.h);
      this.g.addContentView((View)this.f, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    } 
    if (paramFloat < 1.0F) {
      this.f.setBgColor(this.a.getResources().getColor(R.color.syc_62000000));
      return;
    } 
    HoleRelativeLayout holeRelativeLayout = this.f;
    if (holeRelativeLayout != null && holeRelativeLayout.getParent() != null && this.f.getParent() instanceof ViewGroup)
      ((ViewGroup)this.f.getParent()).removeView((View)this.f); 
  }
  
  public void a(int paramInt) {
    TextView textView = this.b;
    if (textView != null)
      textView.setVisibility(8); 
    ImageView imageView = this.c;
    if (imageView != null) {
      imageView.setVisibility(0);
      this.c.setImageResource(paramInt);
    } 
  }
  
  public void a(long paramLong) {
    this.l = new CountDownTimer(this, paramLong, 1000L) {
        public void onFinish() {
          Logger.d("NewFuncPopwindow", new Object[] { "onFinish ... " });
          this.a.dismiss();
        }
        
        public void onTick(long param1Long) {}
      };
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {
    Context context = this.a;
    if (context != null) {
      if (((Activity)context).isFinishing())
        return; 
      if (Build.VERSION.SDK_INT >= 17 && ((Activity)this.a).isDestroyed())
        return; 
      this.d = paramInt1;
      this.e = paramInt2;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("show ... offsetX: ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" ; offsetY: ");
      stringBuilder.append(paramInt2);
      Logger.d("NewFuncPopwindow", new Object[] { stringBuilder.toString() });
      getContentView().measure(0, 0);
      int j = getContentView().getMeasuredHeight();
      int i = getContentView().getMeasuredWidth();
      stringBuilder = new StringBuilder();
      stringBuilder.append("show ... width: ");
      stringBuilder.append(i);
      stringBuilder.append(" ; height：");
      stringBuilder.append(j);
      Logger.d("NewFuncPopwindow", new Object[] { stringBuilder.toString() });
      int k = i + paramInt1;
      stringBuilder = new StringBuilder();
      stringBuilder.append("show ... totalLength: ");
      stringBuilder.append(k);
      Logger.d("NewFuncPopwindow", new Object[] { stringBuilder.toString() });
      i = paramInt1;
      if (k > AppInfo.l) {
        i = paramInt1 - k - AppInfo.l;
        stringBuilder = new StringBuilder();
        stringBuilder.append("show ... (moveX + width) > 屏幕宽度 --> screen width: ");
        stringBuilder.append(AppInfo.l);
        Logger.d("NewFuncPopwindow", new Object[] { stringBuilder.toString() });
      } 
      paramInt1 = paramInt2 - j - DensityUtils.a(this.a, 7.0F);
      stringBuilder = new StringBuilder();
      stringBuilder.append("show ... moveX: ");
      stringBuilder.append(i);
      stringBuilder.append(" ; moveY：");
      stringBuilder.append(paramInt1);
      Logger.d("NewFuncPopwindow", new Object[] { stringBuilder.toString() });
      showAtLocation(paramView, 0, i - this.n, paramInt1);
    } 
  }
  
  public void a(HoleRelativeLayout.RoundRect paramRoundRect) {
    this.h = paramRoundRect;
  }
  
  public void a(FuncDismissListener paramFuncDismissListener) {
    this.m = paramFuncDismissListener;
  }
  
  public void b(int paramInt) {
    this.n = paramInt;
  }
  
  public void dismiss() {
    super.dismiss();
    Logger.d("NewFuncPopwindow", new Object[] { "dismiss ... " });
    a(1.0F);
    View view = this.i;
    if (view != null)
      view.setVisibility(8); 
    CountDownTimer countDownTimer = this.l;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
    FuncDismissListener funcDismissListener = this.m;
    if (funcDismissListener != null)
      funcDismissListener.a(); 
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3) {
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    Logger.d("NewFuncPopwindow", new Object[] { "showAtLocation ... " });
    a(0.3F);
    CountDownTimer countDownTimer = this.l;
    if (countDownTimer != null)
      countDownTimer.start(); 
  }
  
  public static interface FuncDismissListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\NewFuncPopwindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */