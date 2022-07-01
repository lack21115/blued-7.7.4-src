package com.qq.e.comm.plugin.n;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ab.d.e;
import com.qq.e.comm.plugin.s.e;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.aq;
import com.qq.e.comm.plugin.util.s;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;

public class f extends RelativeLayout implements View.OnClickListener, h {
  private com.qq.e.comm.plugin.ab.d.a a;
  
  private k b;
  
  private ImageView c;
  
  private e d;
  
  private a e;
  
  private CountDownTimer f;
  
  private boolean g;
  
  private boolean h;
  
  private d i;
  
  private c j;
  
  private String k;
  
  private int l;
  
  f(Context paramContext, String paramString, int paramInt, e parame, c paramc) {
    super(paramContext);
    this.k = paramString;
    this.l = paramInt;
    this.d = parame;
    this.i = new d();
    this.j = paramc;
    this.a = (new e(paramContext, null)).a();
    this.a.a(new com.qq.e.comm.plugin.ab.d.f(this) {
          long a;
          
          public void a(int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("EndCardView onProgressChanged : ");
            stringBuilder.append(param1Int);
            GDTLogger.d(stringBuilder.toString());
          }
          
          public void a(int param1Int, String param1String1, String param1String2) {
            // Byte code:
            //   0: new java/lang/StringBuilder
            //   3: dup
            //   4: invokespecial <init> : ()V
            //   7: astore #8
            //   9: aload #8
            //   11: ldc 'EndCardView onReceivedError : '
            //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   16: pop
            //   17: aload #8
            //   19: aload_2
            //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   23: pop
            //   24: aload #8
            //   26: invokevirtual toString : ()Ljava/lang/String;
            //   29: invokestatic d : (Ljava/lang/String;)V
            //   32: aload_0
            //   33: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   36: invokestatic a : (Lcom/qq/e/comm/plugin/n/f;)Z
            //   39: ifeq -> 43
            //   42: return
            //   43: aload_0
            //   44: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   47: iconst_1
            //   48: invokestatic a : (Lcom/qq/e/comm/plugin/n/f;Z)Z
            //   51: pop
            //   52: aload_0
            //   53: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   56: invokestatic g : (Lcom/qq/e/comm/plugin/n/f;)Z
            //   59: ifne -> 94
            //   62: aload_0
            //   63: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   66: invokestatic h : (Lcom/qq/e/comm/plugin/n/f;)Lcom/qq/e/comm/plugin/ab/d/a;
            //   69: ifnull -> 85
            //   72: aload_0
            //   73: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   76: invokestatic h : (Lcom/qq/e/comm/plugin/n/f;)Lcom/qq/e/comm/plugin/ab/d/a;
            //   79: aload_3
            //   80: invokeinterface a : (Ljava/lang/String;)V
            //   85: aload_0
            //   86: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   89: iconst_1
            //   90: invokestatic b : (Lcom/qq/e/comm/plugin/n/f;Z)Z
            //   93: pop
            //   94: aload_0
            //   95: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   98: invokestatic f : (Lcom/qq/e/comm/plugin/n/f;)Lcom/qq/e/comm/plugin/n/k;
            //   101: ifnull -> 114
            //   104: aload_0
            //   105: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   108: invokestatic f : (Lcom/qq/e/comm/plugin/n/f;)Lcom/qq/e/comm/plugin/n/k;
            //   111: invokevirtual a : ()V
            //   114: invokestatic currentTimeMillis : ()J
            //   117: lstore #4
            //   119: aload_0
            //   120: getfield a : J
            //   123: lstore #6
            //   125: aload_0
            //   126: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   129: invokestatic b : (Lcom/qq/e/comm/plugin/n/f;)Ljava/lang/String;
            //   132: ldc 'EndCard'
            //   134: aload_0
            //   135: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   138: invokestatic c : (Lcom/qq/e/comm/plugin/n/f;)I
            //   141: lload #4
            //   143: lload #6
            //   145: lsub
            //   146: aload_3
            //   147: aload_2
            //   148: aload_0
            //   149: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   152: invokestatic d : (Lcom/qq/e/comm/plugin/n/f;)Lcom/qq/e/comm/plugin/y/c;
            //   155: invokestatic a : (Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Lcom/qq/e/comm/plugin/y/c;)V
            //   158: aload_0
            //   159: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   162: invokestatic b : (Lcom/qq/e/comm/plugin/n/f;)Ljava/lang/String;
            //   165: ldc 'Interstitial'
            //   167: invokevirtual equals : (Ljava/lang/Object;)Z
            //   170: ifeq -> 218
            //   173: aload_0
            //   174: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   177: invokestatic e : (Lcom/qq/e/comm/plugin/n/f;)Lcom/qq/e/comm/plugin/y/d;
            //   180: ldc 'wu'
            //   182: aload_3
            //   183: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)Lcom/qq/e/comm/plugin/y/d;
            //   186: pop
            //   187: ldc 1030019
            //   189: istore_1
            //   190: aload_0
            //   191: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   194: invokestatic d : (Lcom/qq/e/comm/plugin/n/f;)Lcom/qq/e/comm/plugin/y/c;
            //   197: astore_2
            //   198: aload_0
            //   199: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   202: invokestatic e : (Lcom/qq/e/comm/plugin/n/f;)Lcom/qq/e/comm/plugin/y/d;
            //   205: astore #8
            //   207: iload_1
            //   208: iconst_0
            //   209: aload_2
            //   210: aload #8
            //   212: invokestatic a : (IILcom/qq/e/comm/plugin/y/c;Lcom/qq/e/comm/plugin/y/d;)V
            //   215: goto -> 257
            //   218: aload_0
            //   219: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   222: invokestatic b : (Lcom/qq/e/comm/plugin/n/f;)Ljava/lang/String;
            //   225: ldc 'Reward'
            //   227: invokevirtual equals : (Ljava/lang/Object;)Z
            //   230: ifeq -> 257
            //   233: ldc 1020017
            //   235: istore_1
            //   236: aload_0
            //   237: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   240: invokestatic d : (Lcom/qq/e/comm/plugin/n/f;)Lcom/qq/e/comm/plugin/y/c;
            //   243: astore_2
            //   244: aload_0
            //   245: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   248: aload_3
            //   249: invokestatic a : (Lcom/qq/e/comm/plugin/n/f;Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/d;
            //   252: astore #8
            //   254: goto -> 207
            //   257: aload_0
            //   258: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   261: invokestatic c : (Lcom/qq/e/comm/plugin/n/f;)I
            //   264: iconst_2
            //   265: if_icmpne -> 289
            //   268: ldc 1140004
            //   270: iconst_0
            //   271: aload_0
            //   272: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   275: invokestatic d : (Lcom/qq/e/comm/plugin/n/f;)Lcom/qq/e/comm/plugin/y/c;
            //   278: aload_0
            //   279: getfield b : Lcom/qq/e/comm/plugin/n/f;
            //   282: aload_3
            //   283: invokestatic a : (Lcom/qq/e/comm/plugin/n/f;Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/d;
            //   286: invokestatic a : (IILcom/qq/e/comm/plugin/y/c;Lcom/qq/e/comm/plugin/y/d;)V
            //   289: return
          }
          
          public void a(ValueCallback<Uri> param1ValueCallback, Intent param1Intent) {
            GDTLogger.d("EndCardView openFileChooser");
          }
          
          public void a(String param1String) {
            GDTLogger.d("EndCardView onPageFinished");
            if (f.a(this.b))
              return; 
            long l1 = System.currentTimeMillis();
            long l2 = this.a;
            s.a(f.b(this.b), "EndCard", f.c(this.b), l1 - l2, param1String, null, f.d(this.b));
            if (f.b(this.b).equals("Interstitial")) {
              f.e(this.b).a("wu", param1String);
              u.a(1030018, 0, f.d(this.b), f.e(this.b));
            } else if (f.b(this.b).equals("Reward")) {
              u.a(1020030, f.d(this.b));
            } 
            if (f.f(this.b) != null)
              f.f(this.b).a(); 
          }
          
          public void a(String param1String, Bitmap param1Bitmap) {
            GDTLogger.d("EndCardView onPageStarted");
            this.a = System.currentTimeMillis();
          }
          
          public void b(String param1String) {
            GDTLogger.d("EndCardView onOverrideUrlLoading");
          }
          
          public boolean b(ValueCallback<Uri[]> param1ValueCallback, Intent param1Intent) {
            GDTLogger.d("EndCardView onShowFileChooser");
            return false;
          }
          
          public void c(String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("EndCardView onReceivedTitle : ");
            stringBuilder.append(param1String);
            GDTLogger.d(stringBuilder.toString());
          }
          
          public void d_() {
            GDTLogger.d("EndCardView onLeftApplication");
          }
        });
    addView(this.a.b(), (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    this.c = new ImageView(paramContext);
    this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.c.setImageBitmap(aq.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAbFBMVEUAAAAAAAD////p6eknJyf/\n//8MDAz///////8REREbGxs9PT11dXWlpaX39/f///////////////9qamoZGRksLCxQUFBkZGSL\ni4u/v7/Z2dny8vL///////////////////////////////8d9apUAAAAI3RSTlOAAE3qikd6JQV3\nc2hbVE5AKx4RoYZtY15YUVBORD48MhoKNpZmpn4AAAHhSURBVFjDpZfbloIwDEXPVFsoFwW830H/\n/x+HRMYRIQIr54EHl2eTNiVN8CMoLIPb5WyNsefLLShD6X/9gCJbmg8ts2IsIAwad4cRhIMAslsj\nyhLiOyB/2Q/JduMd4PxmmxxeiPwroLoa1iKNHVpycbowrGslAwr7tCcOPXLJE2ELCZAb1t5DkN8b\nVt4PyAwpjfBFUWpIWR/gbkg7DGhnSPcugN9/ijGo+NSKAe/rP0YYoejI+9AGFOz3GCXPhOIdUFmK\nP8JIRbQKW70B+PzEGK2YT9Q/IBf2fyAX+R8gtJR/TFJKiwgbQEC4CJMUkScgQBPAHhO1b0LAM4CF\nx0T5BYXAAKo/CVpardHReoWWEqpRBCgoANf2P2ZzfGg+e7QJjkIoakDWTcF6RoRP/2zdTURWA5Y9\nZ2hOBPGHRjGvASHlw0EiyH44coYoqX4CEkH2A1RpSwScA5kg+zkPAW71cwuZIPuxra03XOrnBjJB\n9mNTWy84108PmSD74WvrGZaTIBNkP6fBgnIByATZD/aqAeolqDdRnUb1QVIfZfXHpP6ctQVFXdLU\nRVVb1tUXi/pq016u6utd22BoWxx1k6Vt87SNprbVVTfb+nZfP3DoRx790KUf+/SDp3701Q/f6vH/\nFzOPJ4ULw0zxAAAAAElFTkSuQmCC\n"));
    this.c.setOnClickListener(this);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(am.a(paramContext, 30), am.a(paramContext, 30));
    layoutParams.addRule(9, -1);
    layoutParams.addRule(10, -1);
    layoutParams.topMargin = am.a(paramContext, 15);
    layoutParams.leftMargin = am.a(paramContext, 20);
    addView((View)this.c, (ViewGroup.LayoutParams)layoutParams);
    if (GDTADManager.getInstance().getSM().getInteger("interstitialFullScreenEndcardSoft", 0) == 1) {
      setLayerType(1, null);
    } else {
      this.a.b().setBackgroundColor(0);
    } 
    if (this.l == 1) {
      this.b = new k(getContext());
      addView((View)this.b);
    } 
  }
  
  private d b(String paramString) {
    d d1 = new d();
    if (paramString != null)
      d1.a("rs", paramString); 
    return d1;
  }
  
  public void a() {
    setVisibility(4);
  }
  
  public void a(ViewGroup paramViewGroup) {
    if (getParent() == null)
      paramViewGroup.addView((View)this, new ViewGroup.LayoutParams(-1, -1)); 
  }
  
  public void a(a parama) {
    this.e = parama;
    this.a.c().a("videoService", new e(this.d, this.e));
  }
  
  public void a(String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      GDTLogger.d("EndCardView loadUrl url is null");
      return;
    } 
    com.qq.e.comm.plugin.ab.d.a a1 = this.a;
    if (a1 != null) {
      a1.a(paramString);
      k k1 = this.b;
      if (k1 != null) {
        k1.setVisibility(0);
        this.f = (new CountDownTimer(this, 3000L, 3000L) {
            public void onFinish() {
              if (f.f(this.a) != null)
                f.f(this.a).a(); 
            }
            
            public void onTick(long param1Long) {}
          }).start();
      } 
    } 
  }
  
  public void b() {
    if (this.h && this.g) {
      a a1 = this.e;
      if (a1 != null) {
        a1.b();
        return;
      } 
    } else {
      int i;
      setVisibility(0);
      if (this.k.equals("Reward")) {
        i = 1020071;
      } else if (this.k.equals("Interstitial")) {
        i = 1030030;
      } else {
        return;
      } 
      u.a(i, this.j);
      return;
    } 
  }
  
  public void c() {
    com.qq.e.comm.plugin.ab.d.a a1 = this.a;
    if (a1 != null)
      a1.a(); 
    CountDownTimer countDownTimer = this.f;
    if (countDownTimer != null) {
      countDownTimer.cancel();
      this.f = null;
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView == this.c) {
      a a1 = this.e;
      if (a1 != null)
        a1.b(); 
    } 
  }
  
  public static interface a {
    void a(String param1String, boolean param1Boolean);
    
    void b();
    
    com.qq.e.comm.plugin.s.a c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\n\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */