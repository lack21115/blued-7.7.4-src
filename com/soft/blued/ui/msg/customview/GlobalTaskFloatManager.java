package com.soft.blued.ui.msg.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.live.activity.SendFeedDialogActivity;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.Logger;
import java.util.Timer;
import java.util.TimerTask;

public class GlobalTaskFloatManager {
  public static volatile GlobalTaskFloatManager a;
  
  private static final String b = GlobalTaskFloatManager.class.getSimpleName();
  
  private ViewHolder c;
  
  private WindowManager.LayoutParams d;
  
  private WindowManager e;
  
  private TaskInfo f;
  
  private boolean g = true;
  
  private boolean h = false;
  
  private float i;
  
  private float j;
  
  private float k;
  
  private float l;
  
  private float m;
  
  private float n;
  
  private float o = 0.0F;
  
  private float p = 0.0F;
  
  private int q = b();
  
  private int r;
  
  private int s;
  
  private ValueAnimator t;
  
  private String u;
  
  private Timer v;
  
  private int w = 1000;
  
  private boolean x;
  
  private int y = DensityUtil.a(8.0F);
  
  private GlobalTaskFloatManager() {
    a(AppInfo.d());
    LiveEventBus.get("live_open_close", Boolean.class).observeForever(new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            if (param1Boolean.booleanValue()) {
              GlobalTaskFloatManager.a(this.a, 26);
              return;
            } 
            this.a.a(26);
          }
        });
  }
  
  public static GlobalTaskFloatManager a() {
    // Byte code:
    //   0: getstatic com/soft/blued/ui/msg/customview/GlobalTaskFloatManager.a : Lcom/soft/blued/ui/msg/customview/GlobalTaskFloatManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/ui/msg/customview/GlobalTaskFloatManager
    //   8: monitorenter
    //   9: getstatic com/soft/blued/ui/msg/customview/GlobalTaskFloatManager.a : Lcom/soft/blued/ui/msg/customview/GlobalTaskFloatManager;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/ui/msg/customview/GlobalTaskFloatManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/ui/msg/customview/GlobalTaskFloatManager.a : Lcom/soft/blued/ui/msg/customview/GlobalTaskFloatManager;
    //   25: ldc com/soft/blued/ui/msg/customview/GlobalTaskFloatManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/ui/msg/customview/GlobalTaskFloatManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/ui/msg/customview/GlobalTaskFloatManager.a : Lcom/soft/blued/ui/msg/customview/GlobalTaskFloatManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(Context paramContext) {
    try {
      this.d = new WindowManager.LayoutParams();
      this.e = (WindowManager)paramContext.getSystemService("window");
      Logger.b("ddrb", new Object[] { "sdk api version:", Integer.valueOf(Build.VERSION.SDK_INT) });
      if (Build.VERSION.SDK_INT >= 26) {
        this.d.type = 2038;
      } else if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 23) {
        this.d.type = 2005;
      } else {
        this.d.type = 2003;
      } 
      this.d.format = 1;
      this.d.flags = 8;
      this.d.gravity = 51;
      this.d.width = -2;
      this.d.height = -2;
      g();
      return;
    } catch (SecurityException securityException) {
      securityException.printStackTrace();
      return;
    } 
  }
  
  private void b(int paramInt) {
    if (this.c != null) {
      TaskInfo taskInfo = this.f;
      if (taskInfo == null)
        return; 
      if (paramInt != taskInfo.task_id)
        return; 
      if (this.v == null)
        this.v = new Timer(); 
      this.v.schedule(new TimerTask(this, paramInt) {
            public void run() {
              AppInfo.n().post(new Runnable(this) {
                    public void run() {
                      if (!GlobalTaskFloatManager.a(this.a.b) && GlobalTaskFloatManager.b(this.a.b) != null) {
                        if (GlobalTaskFloatManager.c(this.a.b) == null)
                          return; 
                        GlobalTaskFloatManager.b(this.a.b, GlobalTaskFloatManager.d(this.a.b) - 100);
                        String str = GlobalTaskFloatManager.f();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("second====");
                        stringBuilder.append(GlobalTaskFloatManager.d(this.a.b));
                        Logger.c(str, new Object[] { stringBuilder.toString() });
                        float f = ((GlobalTaskFloatManager.e(this.a.b)).progress * 1000 + GlobalTaskFloatManager.d(this.a.b)) / ((GlobalTaskFloatManager.e(this.a.b)).max * 1000);
                        (GlobalTaskFloatManager.b(this.a.b)).d.setProgress((int)((1.0F - f) * 1000.0F));
                        str = GlobalTaskFloatManager.f();
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("progress====");
                        stringBuilder.append((GlobalTaskFloatManager.b(this.a.b)).d.getProgress());
                        Logger.c(str, new Object[] { stringBuilder.toString() });
                        if (GlobalTaskFloatManager.d(this.a.b) == 0) {
                          TextView textView = (GlobalTaskFloatManager.b(this.a.b)).a;
                          stringBuilder = new StringBuilder();
                          GlobalTaskFloatManager.TaskInfo taskInfo = GlobalTaskFloatManager.e(this.a.b);
                          int i = taskInfo.progress;
                          taskInfo.progress = i - 1;
                          stringBuilder.append(i);
                          stringBuilder.append("s");
                          textView.setText(stringBuilder.toString());
                          GlobalTaskFloatManager.b(this.a.b, 1000);
                        } 
                        if (GlobalTaskFloatManager.e(this.a.b) != null && (GlobalTaskFloatManager.e(this.a.b)).progress == -1) {
                          this.a.b.a(this.a.a);
                          if (GlobalTaskFloatManager.b(this.a.b) != null) {
                            (GlobalTaskFloatManager.b(this.a.b)).a.setVisibility(8);
                            (GlobalTaskFloatManager.b(this.a.b)).e.setText(AppInfo.d().getString(2131759003));
                            (GlobalTaskFloatManager.b(this.a.b)).f.setVisibility(0);
                          } 
                          ChatHttpUtils.a(new BluedUIHttpResponse<BluedEntityA>(this, null) {
                                protected void a(BluedEntityA param3BluedEntityA) {}
                              }(GlobalTaskFloatManager.e(this.a.b)).max);
                        } 
                      } 
                    }
                  });
            }
          }1000L, 100L);
    } 
  }
  
  private void g() {
    try {
      Point point = new Point();
      ((WindowManager)AppInfo.d().getSystemService("window")).getDefaultDisplay().getSize(point);
      this.r = point.x;
      this.s = point.y;
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private void h() {
    if (this.c != null) {
      if (!TextUtils.isEmpty(this.f.task_name))
        this.c.e.setText(this.f.task_name); 
      if (this.f.task_id == 26) {
        float f = (this.f.progress * 1000 + this.w) / (this.f.max * 1000);
        this.c.d.setProgress((int)((1.0F - f) * 1000.0F));
        TextView textView = this.c.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f.progress);
        stringBuilder.append("s");
        textView.setText(stringBuilder.toString());
        if (LiveFloatManager.a().x()) {
          b(26);
          return;
        } 
      } else {
        TextView textView = this.c.a;
        if (this.f.progress == this.f.max) {
          i = 8;
        } else {
          i = 0;
        } 
        textView.setVisibility(i);
        textView = this.c.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(this.f.progress);
        stringBuilder.append("/");
        stringBuilder.append(this.f.max);
        stringBuilder.append(")");
        textView.setText(stringBuilder.toString());
        int i = (int)(this.f.progress / Float.valueOf(this.f.max).floatValue() * 1000.0F);
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator != null && valueAnimator.isRunning())
          this.t.cancel(); 
        this.t = ValueAnimator.ofInt(new int[] { this.c.d.getProgress(), i });
        this.t.setDuration(1000L);
        this.t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
              public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
                if (GlobalTaskFloatManager.b(this.a) != null)
                  (GlobalTaskFloatManager.b(this.a)).d.setProgress(((Integer)param1ValueAnimator.getAnimatedValue()).intValue()); 
              }
            });
        if (i())
          this.t.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
                public void onAnimationEnd(Animator param1Animator) {
                  if (GlobalTaskFloatManager.b(this.a) != null) {
                    (GlobalTaskFloatManager.b(this.a)).e.setText(AppInfo.d().getString(2131759003));
                    (GlobalTaskFloatManager.b(this.a)).f.setVisibility(0);
                  } 
                }
              }); 
        this.t.start();
      } 
    } 
  }
  
  private boolean i() {
    TaskInfo taskInfo = this.f;
    if (taskInfo != null && taskInfo.task_id == 26 && this.f.progress == -1)
      return true; 
    taskInfo = this.f;
    return (taskInfo != null && taskInfo.progress == this.f.max);
  }
  
  private void j() {
    this.c = new ViewHolder();
    this.c.b = View.inflate(AppInfo.d(), 2131493388, null);
    ViewHolder viewHolder = this.c;
    viewHolder.d = (ProgressBar)viewHolder.b.findViewById(2131299526);
    viewHolder = this.c;
    viewHolder.c = (ImageView)viewHolder.b.findViewById(2131297681);
    viewHolder = this.c;
    viewHolder.e = (TextView)viewHolder.b.findViewById(2131300890);
    viewHolder = this.c;
    viewHolder.f = (TextView)viewHolder.b.findViewById(2131300547);
    viewHolder = this.c;
    viewHolder.a = (TextView)viewHolder.b.findViewById(2131301198);
    viewHolder = this.c;
    viewHolder.g = (ImageView)viewHolder.b.findViewById(2131297729);
    this.c.f.setVisibility(8);
    this.c.d.setMax(1000);
    this.c.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (GlobalTaskFloatManager.f(this.a)) {
              if (GlobalTaskFloatManager.e(this.a) != null && (GlobalTaskFloatManager.e(this.a)).task_id == 26)
                LiveRefreshUIObserver.a().b(true); 
              this.a.a(true);
            } 
          }
        });
    this.c.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a(26);
            this.a.a(false);
          }
        });
    this.c.b.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            try {
              int i = param1MotionEvent.getAction();
              float f = 0.0F;
              if (i != 0) {
                if (i != 1) {
                  if (i != 2)
                    return false; 
                  int[] arrayOfInt = new int[2];
                  (GlobalTaskFloatManager.b(this.a)).b.getLocationOnScreen(arrayOfInt);
                  float f1 = param1MotionEvent.getRawX();
                  f = param1MotionEvent.getRawY();
                  float f2 = f1 - GlobalTaskFloatManager.g(this.a);
                  float f3 = f - GlobalTaskFloatManager.h(this.a);
                  GlobalTaskFloatManager.a(this.a, f1);
                  GlobalTaskFloatManager.b(this.a, f);
                  if (arrayOfInt[0] < GlobalTaskFloatManager.i(this.a)) {
                    if (f2 >= 0.0F)
                      GlobalTaskFloatManager.e(this.a, GlobalTaskFloatManager.j(this.a) + f2); 
                  } else if (arrayOfInt[0] >= GlobalTaskFloatManager.i(this.a) && arrayOfInt[0] <= GlobalTaskFloatManager.k(this.a) - GlobalTaskFloatManager.i(this.a) - (GlobalTaskFloatManager.b(this.a)).b.getWidth()) {
                    GlobalTaskFloatManager.e(this.a, GlobalTaskFloatManager.j(this.a) + f2);
                  } else if (f2 <= 0.0F) {
                    GlobalTaskFloatManager.e(this.a, GlobalTaskFloatManager.j(this.a) + f2);
                  } 
                  if (arrayOfInt[1] < GlobalTaskFloatManager.i(this.a) + GlobalTaskFloatManager.l(this.a)) {
                    if (f3 >= 0.0F)
                      GlobalTaskFloatManager.f(this.a, GlobalTaskFloatManager.m(this.a) + f3); 
                  } else if (arrayOfInt[1] >= GlobalTaskFloatManager.i(this.a) + GlobalTaskFloatManager.l(this.a) && arrayOfInt[1] <= GlobalTaskFloatManager.n(this.a) - GlobalTaskFloatManager.i(this.a) - (GlobalTaskFloatManager.b(this.a)).b.getHeight()) {
                    GlobalTaskFloatManager.f(this.a, GlobalTaskFloatManager.m(this.a) + f3);
                  } else if (f3 <= 0.0F) {
                    GlobalTaskFloatManager.f(this.a, GlobalTaskFloatManager.m(this.a) + f3);
                  } 
                  if (GlobalTaskFloatManager.j(this.a) > (GlobalTaskFloatManager.k(this.a) - GlobalTaskFloatManager.i(this.a) - (GlobalTaskFloatManager.b(this.a)).b.getWidth()))
                    GlobalTaskFloatManager.e(this.a, (GlobalTaskFloatManager.k(this.a) - GlobalTaskFloatManager.i(this.a) - (GlobalTaskFloatManager.b(this.a)).b.getWidth())); 
                  if (GlobalTaskFloatManager.j(this.a) < GlobalTaskFloatManager.i(this.a))
                    GlobalTaskFloatManager.e(this.a, GlobalTaskFloatManager.i(this.a)); 
                  if (GlobalTaskFloatManager.m(this.a) > (GlobalTaskFloatManager.n(this.a) - GlobalTaskFloatManager.i(this.a) - (GlobalTaskFloatManager.b(this.a)).b.getHeight()))
                    GlobalTaskFloatManager.f(this.a, (GlobalTaskFloatManager.n(this.a) - GlobalTaskFloatManager.i(this.a) - (GlobalTaskFloatManager.b(this.a)).b.getHeight())); 
                  if (GlobalTaskFloatManager.m(this.a) < (GlobalTaskFloatManager.i(this.a) + GlobalTaskFloatManager.l(this.a)))
                    GlobalTaskFloatManager.f(this.a, (GlobalTaskFloatManager.i(this.a) + GlobalTaskFloatManager.l(this.a))); 
                  (GlobalTaskFloatManager.o(this.a)).x = (int)GlobalTaskFloatManager.j(this.a);
                  (GlobalTaskFloatManager.o(this.a)).y = (int)(GlobalTaskFloatManager.m(this.a) - GlobalTaskFloatManager.l(this.a));
                  if (GlobalTaskFloatManager.p(this.a)) {
                    GlobalTaskFloatManager.q(this.a).updateViewLayout(param1View, (ViewGroup.LayoutParams)GlobalTaskFloatManager.o(this.a));
                    return false;
                  } 
                } else {
                  if (Math.abs(param1MotionEvent.getRawX() - GlobalTaskFloatManager.r(this.a)) < 20.0F && Math.abs(param1MotionEvent.getRawY() - GlobalTaskFloatManager.s(this.a)) < 20.0F && GlobalTaskFloatManager.p(this.a) && !GlobalTaskFloatManager.t(this.a))
                    return false; 
                  float f1 = GlobalTaskFloatManager.j(this.a);
                  f = ((GlobalTaskFloatManager.b(this.a)).b.getWidth() / 2);
                  float f2 = GlobalTaskFloatManager.m(this.a) + ((GlobalTaskFloatManager.b(this.a)).b.getHeight() / 2);
                  if (f2 <= (GlobalTaskFloatManager.b(this.a)).b.getHeight()) {
                    GlobalTaskFloatManager.g(this.a, GlobalTaskFloatManager.j(this.a));
                    GlobalTaskFloatManager.h(this.a, (GlobalTaskFloatManager.i(this.a) + GlobalTaskFloatManager.l(this.a)));
                  } else if (f2 > (GlobalTaskFloatManager.b(this.a)).b.getHeight() && f2 < (GlobalTaskFloatManager.n(this.a) - (GlobalTaskFloatManager.b(this.a)).b.getHeight())) {
                    if (f1 + f <= (GlobalTaskFloatManager.k(this.a) / 2)) {
                      GlobalTaskFloatManager.g(this.a, GlobalTaskFloatManager.i(this.a));
                      GlobalTaskFloatManager.h(this.a, GlobalTaskFloatManager.m(this.a));
                    } else {
                      GlobalTaskFloatManager.g(this.a, (GlobalTaskFloatManager.k(this.a) - GlobalTaskFloatManager.i(this.a) - (GlobalTaskFloatManager.b(this.a)).b.getWidth()));
                      GlobalTaskFloatManager.h(this.a, GlobalTaskFloatManager.m(this.a));
                    } 
                  } else {
                    GlobalTaskFloatManager.g(this.a, GlobalTaskFloatManager.j(this.a));
                    GlobalTaskFloatManager.h(this.a, (GlobalTaskFloatManager.n(this.a) - GlobalTaskFloatManager.i(this.a) - (GlobalTaskFloatManager.b(this.a)).b.getHeight()));
                  } 
                  i = (int)GlobalTaskFloatManager.u(this.a);
                  f1 = GlobalTaskFloatManager.v(this.a);
                  int j = (int)f1;
                  try {
                    if (GlobalTaskFloatManager.j(this.a) != GlobalTaskFloatManager.u(this.a)) {
                      ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { (int)GlobalTaskFloatManager.j(this.a), i });
                      valueAnimator.setDuration(300L);
                      valueAnimator.setInterpolator((TimeInterpolator)new OvershootInterpolator(1.0F));
                      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, j, param1View) {
                            public void onAnimationUpdate(ValueAnimator param2ValueAnimator) {
                              Integer integer = (Integer)param2ValueAnimator.getAnimatedValue();
                              (GlobalTaskFloatManager.o(this.c.a)).x = integer.intValue();
                              (GlobalTaskFloatManager.o(this.c.a)).y = this.a - GlobalTaskFloatManager.l(this.c.a);
                              if (GlobalTaskFloatManager.p(this.c.a))
                                GlobalTaskFloatManager.q(this.c.a).updateViewLayout(this.b, (ViewGroup.LayoutParams)GlobalTaskFloatManager.o(this.c.a)); 
                            }
                          });
                      valueAnimator.addListener(new Animator.AnimatorListener(this) {
                            public void onAnimationCancel(Animator param2Animator) {}
                            
                            public void onAnimationEnd(Animator param2Animator) {
                              GlobalTaskFloatManager.a(this.a.a, false);
                            }
                            
                            public void onAnimationRepeat(Animator param2Animator) {}
                            
                            public void onAnimationStart(Animator param2Animator) {
                              GlobalTaskFloatManager.a(this.a.a, true);
                            }
                          });
                      valueAnimator.start();
                      return false;
                    } 
                    if (GlobalTaskFloatManager.m(this.a) != GlobalTaskFloatManager.v(this.a)) {
                      ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { (int)GlobalTaskFloatManager.m(this.a), j });
                      valueAnimator.setDuration(300L);
                      valueAnimator.setInterpolator((TimeInterpolator)new OvershootInterpolator(1.0F));
                      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, i, param1View) {
                            public void onAnimationUpdate(ValueAnimator param2ValueAnimator) {
                              Integer integer = (Integer)param2ValueAnimator.getAnimatedValue();
                              (GlobalTaskFloatManager.o(this.c.a)).x = this.a;
                              (GlobalTaskFloatManager.o(this.c.a)).y = integer.intValue() - GlobalTaskFloatManager.l(this.c.a);
                              if (GlobalTaskFloatManager.p(this.c.a))
                                GlobalTaskFloatManager.q(this.c.a).updateViewLayout(this.b, (ViewGroup.LayoutParams)GlobalTaskFloatManager.o(this.c.a)); 
                            }
                          });
                      valueAnimator.addListener(new Animator.AnimatorListener(this) {
                            public void onAnimationCancel(Animator param2Animator) {}
                            
                            public void onAnimationEnd(Animator param2Animator) {
                              GlobalTaskFloatManager.a(this.a.a, false);
                            }
                            
                            public void onAnimationRepeat(Animator param2Animator) {}
                            
                            public void onAnimationStart(Animator param2Animator) {
                              GlobalTaskFloatManager.a(this.a.a, true);
                            }
                          });
                      valueAnimator.start();
                      return false;
                    } 
                  } catch (Exception exception) {
                    (GlobalTaskFloatManager.o(this.a)).x = i;
                    (GlobalTaskFloatManager.o(this.a)).y = j - GlobalTaskFloatManager.l(this.a);
                    if (GlobalTaskFloatManager.p(this.a))
                      GlobalTaskFloatManager.q(this.a).updateViewLayout(param1View, (ViewGroup.LayoutParams)GlobalTaskFloatManager.o(this.a)); 
                    GlobalTaskFloatManager.a(this.a, false);
                    exception.printStackTrace();
                    return false;
                  } 
                } 
              } else {
                float f1;
                try {
                  f1 = exception.getRawX();
                  try {
                    float f2 = exception.getRawY();
                    i = 1;
                    f = f2;
                    if (i != 0) {
                      GlobalTaskFloatManager.a(this.a, f1);
                      GlobalTaskFloatManager.b(this.a, f);
                      GlobalTaskFloatManager.c(this.a, f1);
                      GlobalTaskFloatManager.d(this.a, f);
                      int[] arrayOfInt = new int[2];
                      (GlobalTaskFloatManager.b(this.a)).b.getLocationOnScreen(arrayOfInt);
                      GlobalTaskFloatManager.e(this.a, arrayOfInt[0]);
                      GlobalTaskFloatManager.f(this.a, arrayOfInt[1]);
                      return false;
                    } 
                  } catch (IllegalArgumentException illegalArgumentException) {}
                } catch (IllegalArgumentException illegalArgumentException) {
                  f1 = 0.0F;
                } 
                i = 0;
                if (i != 0) {
                  GlobalTaskFloatManager.a(this.a, f1);
                  GlobalTaskFloatManager.b(this.a, f);
                  GlobalTaskFloatManager.c(this.a, f1);
                  GlobalTaskFloatManager.d(this.a, f);
                  int[] arrayOfInt = new int[2];
                  (GlobalTaskFloatManager.b(this.a)).b.getLocationOnScreen(arrayOfInt);
                  GlobalTaskFloatManager.e(this.a, arrayOfInt[0]);
                  GlobalTaskFloatManager.f(this.a, arrayOfInt[1]);
                  return false;
                } 
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
            return false;
          }
        });
  }
  
  public void a(int paramInt) {
    if (this.c != null) {
      TaskInfo taskInfo = this.f;
      if (taskInfo == null)
        return; 
      if (paramInt != taskInfo.task_id)
        return; 
      Timer timer = this.v;
      if (timer != null) {
        timer.cancel();
        this.v = null;
      } 
      this.w = 1000;
    } 
  }
  
  public void a(TaskInfo paramTaskInfo) {
    if (paramTaskInfo != null && this.f != null && paramTaskInfo.task_id == this.f.task_id) {
      if (paramTaskInfo.task_id == 26)
        return; 
      this.f = paramTaskInfo;
      h();
    } 
  }
  
  public void a(boolean paramBoolean) {
    ViewHolder viewHolder = this.c;
    if (viewHolder != null && viewHolder.b.getWindowToken() != null) {
      this.e.removeViewImmediate(this.c.b);
      this.c.c.setImageBitmap(null);
    } 
    if (paramBoolean && !TextUtils.isEmpty(this.u) && UserInfo.a().j())
      WebViewShowInfoFragment.show(AppInfo.d(), this.u, -1); 
    this.c = null;
    this.f = null;
  }
  
  public int b() {
    try {
      Class<?> clazz = Class.forName("com.android.internal.R$dimen");
      Object object = clazz.newInstance();
      int i = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
      this.q = AppInfo.d().getResources().getDimensionPixelSize(i);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return this.q;
  }
  
  public void b(TaskInfo paramTaskInfo) {
    TaskInfo taskInfo = this.f;
    if (taskInfo != null && taskInfo.task_id == paramTaskInfo.task_id && paramTaskInfo.task_id == 26 && this.f.progress != 0)
      paramTaskInfo.progress = this.f.progress; 
    this.f = paramTaskInfo;
    String str = b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("currentTaskInfo : ");
    stringBuilder.append(this.f.toString());
    Logger.c(str, new Object[] { stringBuilder.toString() });
    this.u = paramTaskInfo.back_url;
    if (Build.VERSION.SDK_INT >= 23) {
      if (Settings.canDrawOverlays(AppInfo.d())) {
        c();
        return;
      } 
      if (!BluedApplicationLike.ifFeedFloatAuthShowed) {
        BluedApplicationLike.ifFeedFloatAuthShowed = true;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("package:");
        stringBuilder1.append(AppInfo.d().getPackageManager());
        if (AppUtils.a(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(stringBuilder1.toString())))) {
          Intent intent = new Intent(AppInfo.d(), SendFeedDialogActivity.class);
          intent.putExtra("type", 1);
          intent.putExtra("flag", 2);
          intent.addFlags(268435456);
          AppInfo.d().startActivity(intent);
          return;
        } 
        AppMethods.d(2131757396);
        return;
      } 
    } else {
      c();
    } 
  }
  
  public void c() {
    if (this.f == null)
      return; 
    this.g = true;
    if (this.c == null)
      j(); 
    h();
    if (this.c.b.getWindowToken() != null)
      this.e.removeViewImmediate(this.c.b); 
    this.d.x = DensityUtils.a(AppInfo.d(), 8.0F);
    this.d.y = DensityUtils.a(AppInfo.d(), 52.0F);
    try {
      this.e.addView(this.c.b, (ViewGroup.LayoutParams)this.d);
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public void d() {
    ViewHolder viewHolder = this.c;
    if (viewHolder != null && viewHolder.b != null) {
      this.c.b.setVisibility(4);
      this.x = true;
    } 
  }
  
  public void e() {
    ViewHolder viewHolder = this.c;
    if (viewHolder != null && viewHolder.b != null) {
      this.c.b.setVisibility(0);
      this.x = false;
    } 
  }
  
  public static class TaskInfo {
    public String back_url;
    
    public int max;
    
    public int progress;
    
    public int task_id;
    
    public String task_name;
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("TaskInfo{task_name='");
      stringBuilder.append(this.task_name);
      stringBuilder.append('\'');
      stringBuilder.append(", task_id=");
      stringBuilder.append(this.task_id);
      stringBuilder.append(", max=");
      stringBuilder.append(this.max);
      stringBuilder.append(", progress=");
      stringBuilder.append(this.progress);
      stringBuilder.append(", back_url='");
      stringBuilder.append(this.back_url);
      stringBuilder.append('\'');
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  static class ViewHolder {
    public TextView a;
    
    public View b;
    
    public ImageView c;
    
    public ProgressBar d;
    
    public TextView e;
    
    public TextView f;
    
    public ImageView g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\customview\GlobalTaskFloatManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */