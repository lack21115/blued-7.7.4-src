package com.soft.blued.ui.discover.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.view.CubicInterpolator;
import com.soft.blued.customview.CircleProgressView;
import com.soft.blued.db.model.NewFeedModel;
import com.soft.blued.manager.SendNotificationManager;
import com.soft.blued.ui.discover.adapter.ShineVideoListAdapter;
import com.soft.blued.ui.feed.manager.FeedSendManager;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.find.observer.FeedRefreshObserver;
import com.soft.blued.utils.Logger;

public class SendFeedFloatManager implements FeedRefreshObserver.IFeedRefreshObserver {
  public static volatile SendFeedFloatManager i;
  
  public Context a;
  
  public boolean b = false;
  
  public View c;
  
  public int d;
  
  public CircleProgressView e;
  
  public TextView f;
  
  public TextView g;
  
  Handler h = new Handler(Looper.getMainLooper());
  
  private WindowManager.LayoutParams j;
  
  private WindowManager k;
  
  public static SendFeedFloatManager a() {
    // Byte code:
    //   0: getstatic com/soft/blued/ui/discover/fragment/SendFeedFloatManager.i : Lcom/soft/blued/ui/discover/fragment/SendFeedFloatManager;
    //   3: ifnonnull -> 46
    //   6: ldc com/soft/blued/ui/discover/fragment/SendFeedFloatManager
    //   8: monitorenter
    //   9: getstatic com/soft/blued/ui/discover/fragment/SendFeedFloatManager.i : Lcom/soft/blued/ui/discover/fragment/SendFeedFloatManager;
    //   12: ifnonnull -> 34
    //   15: new com/soft/blued/ui/discover/fragment/SendFeedFloatManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/ui/discover/fragment/SendFeedFloatManager.i : Lcom/soft/blued/ui/discover/fragment/SendFeedFloatManager;
    //   25: getstatic com/soft/blued/ui/discover/fragment/SendFeedFloatManager.i : Lcom/soft/blued/ui/discover/fragment/SendFeedFloatManager;
    //   28: invokestatic d : ()Landroid/content/Context;
    //   31: invokevirtual a : (Landroid/content/Context;)V
    //   34: ldc com/soft/blued/ui/discover/fragment/SendFeedFloatManager
    //   36: monitorexit
    //   37: goto -> 46
    //   40: astore_0
    //   41: ldc com/soft/blued/ui/discover/fragment/SendFeedFloatManager
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: getstatic com/soft/blued/ui/discover/fragment/SendFeedFloatManager.i : Lcom/soft/blued/ui/discover/fragment/SendFeedFloatManager;
    //   49: areturn
    // Exception table:
    //   from	to	target	type
    //   9	34	40	finally
    //   34	37	40	finally
    //   41	44	40	finally
  }
  
  private void a(Object paramObject, boolean paramBoolean) {
    i();
    if (paramObject == null)
      return; 
    if (paramObject instanceof BluedIngSelfFeed) {
      paramObject = paramObject;
      this.h.postDelayed(new -$$Lambda$SendFeedFloatManager$eWimvRhr0w3Jh3gx-uw59b3qWEI(paramBoolean, (BluedIngSelfFeed)paramObject), 100L);
    } 
  }
  
  private void j() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Landroid/os/Handler;
    //   6: new com/soft/blued/ui/discover/fragment/SendFeedFloatManager$3
    //   9: dup
    //   10: aload_0
    //   11: invokespecial <init> : (Lcom/soft/blued/ui/discover/fragment/SendFeedFloatManager;)V
    //   14: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   17: pop
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
  }
  
  public void a(Context paramContext) {
    try {
      this.j = new WindowManager.LayoutParams();
      this.k = (WindowManager)paramContext.getSystemService("window");
      Logger.b("ddrb", new Object[] { "sdk api version:", Integer.valueOf(Build.VERSION.SDK_INT) });
      if (Build.VERSION.SDK_INT >= 26) {
        this.j.type = 2038;
      } else if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 23) {
        this.j.type = 2005;
      } else {
        this.j.type = 2003;
      } 
      this.j.format = 1;
      this.j.flags = 8;
      this.j.gravity = 51;
      this.j.width = -2;
      this.j.height = -2;
      j();
      return;
    } catch (SecurityException securityException) {
      securityException.printStackTrace();
      return;
    } 
  }
  
  public void a(Object paramObject, int paramInt) {
    if (paramObject != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("feedState=");
      stringBuilder.append(paramInt);
      LogUtils.c(stringBuilder.toString());
    } 
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            if (paramInt != 4)
              return; 
            i();
            return;
          } 
          b();
          h();
          return;
        } 
        a(paramObject, true);
        return;
      } 
      h();
      return;
    } 
    a(paramObject, false);
  }
  
  public void a(boolean paramBoolean) {
    this.b = paramBoolean;
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic android/os/Build$VERSION.SDK_INT : I
    //   5: bipush #23
    //   7: if_icmplt -> 140
    //   10: invokestatic d : ()Landroid/content/Context;
    //   13: invokestatic canDrawOverlays : (Landroid/content/Context;)Z
    //   16: ifeq -> 26
    //   19: aload_0
    //   20: invokevirtual d : ()V
    //   23: goto -> 144
    //   26: getstatic com/soft/blued/app/BluedApplicationLike.ifFeedFloatAuthShowed : Z
    //   29: ifne -> 144
    //   32: iconst_1
    //   33: putstatic com/soft/blued/app/BluedApplicationLike.ifFeedFloatAuthShowed : Z
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore_1
    //   44: aload_1
    //   45: ldc_w 'package:'
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_1
    //   53: invokestatic d : ()Landroid/content/Context;
    //   56: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   59: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: new android/content/Intent
    //   66: dup
    //   67: ldc_w 'android.settings.action.MANAGE_OVERLAY_PERMISSION'
    //   70: aload_1
    //   71: invokevirtual toString : ()Ljava/lang/String;
    //   74: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   77: invokespecial <init> : (Ljava/lang/String;Landroid/net/Uri;)V
    //   80: invokestatic a : (Landroid/content/Intent;)Z
    //   83: ifeq -> 127
    //   86: new android/content/Intent
    //   89: dup
    //   90: invokestatic d : ()Landroid/content/Context;
    //   93: ldc_w com/soft/blued/ui/live/activity/SendFeedDialogActivity
    //   96: invokespecial <init> : (Landroid/content/Context;Ljava/lang/Class;)V
    //   99: astore_1
    //   100: aload_1
    //   101: ldc_w 'flag'
    //   104: iconst_2
    //   105: invokevirtual putExtra : (Ljava/lang/String;I)Landroid/content/Intent;
    //   108: pop
    //   109: aload_1
    //   110: ldc_w 268435456
    //   113: invokevirtual addFlags : (I)Landroid/content/Intent;
    //   116: pop
    //   117: invokestatic d : ()Landroid/content/Context;
    //   120: aload_1
    //   121: invokevirtual startActivity : (Landroid/content/Intent;)V
    //   124: goto -> 144
    //   127: aload_0
    //   128: invokevirtual c : ()V
    //   131: ldc_w 2131757396
    //   134: invokestatic d : (I)V
    //   137: goto -> 144
    //   140: aload_0
    //   141: invokevirtual d : ()V
    //   144: aload_0
    //   145: monitorexit
    //   146: return
    //   147: astore_1
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	147	finally
    //   26	124	147	finally
    //   127	137	147	finally
    //   140	144	147	finally
  }
  
  public void c() {
    /* monitor enter ThisExpression{ObjectType{com/soft/blued/ui/discover/fragment/SendFeedFloatManager}} */
    /* monitor exit ThisExpression{ObjectType{com/soft/blued/ui/discover/fragment/SendFeedFloatManager}} */
  }
  
  public void d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic a : ()Lcom/soft/blued/manager/SendNotificationManager;
    //   5: invokevirtual b : ()Landroid/app/Activity;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull -> 54
    //   13: invokestatic a : ()Lcom/soft/blued/manager/SendNotificationManager;
    //   16: aload_1
    //   17: invokevirtual c : (Landroid/app/Activity;)Landroidx/fragment/app/Fragment;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull -> 54
    //   25: aload_1
    //   26: invokevirtual getClass : ()Ljava/lang/Class;
    //   29: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   32: ldc_w com/soft/blued/ui/feed/fragment/AttentionFeedFragment
    //   35: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   38: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   41: ifeq -> 54
    //   44: ldc_w 'curFragment is AttentionFeedFragment, did not show'
    //   47: invokestatic c : (Ljava/lang/String;)I
    //   50: pop
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: invokevirtual e : ()V
    //   58: aload_0
    //   59: getfield h : Landroid/os/Handler;
    //   62: new com/soft/blued/ui/discover/fragment/SendFeedFloatManager$1
    //   65: dup
    //   66: aload_0
    //   67: invokespecial <init> : (Lcom/soft/blued/ui/discover/fragment/SendFeedFloatManager;)V
    //   70: ldc2_w 300
    //   73: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   76: pop
    //   77: invokestatic by : ()I
    //   80: ifne -> 140
    //   83: invokestatic S : ()Z
    //   86: ifeq -> 140
    //   89: invokestatic d : ()Landroid/content/Context;
    //   92: invokestatic a : (Landroid/content/Context;)Z
    //   95: ifne -> 140
    //   98: new android/content/Intent
    //   101: dup
    //   102: invokestatic d : ()Landroid/content/Context;
    //   105: ldc_w com/soft/blued/ui/live/activity/SendFeedDialogActivity
    //   108: invokespecial <init> : (Landroid/content/Context;Ljava/lang/Class;)V
    //   111: astore_1
    //   112: aload_1
    //   113: ldc_w 'flag'
    //   116: iconst_1
    //   117: invokevirtual putExtra : (Ljava/lang/String;I)Landroid/content/Intent;
    //   120: pop
    //   121: aload_1
    //   122: ldc_w 268435456
    //   125: invokevirtual addFlags : (I)Landroid/content/Intent;
    //   128: pop
    //   129: invokestatic d : ()Landroid/content/Context;
    //   132: aload_1
    //   133: invokevirtual startActivity : (Landroid/content/Intent;)V
    //   136: iconst_1
    //   137: invokestatic o : (I)V
    //   140: aload_0
    //   141: monitorexit
    //   142: return
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	143	finally
    //   13	21	143	finally
    //   25	51	143	finally
    //   54	140	143	finally
  }
  
  public void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Landroid/os/Handler;
    //   6: new com/soft/blued/ui/discover/fragment/-$$Lambda$SendFeedFloatManager$wgGsSRNC5CphhYOcRyIVnXYUx9A
    //   9: dup
    //   10: aload_0
    //   11: invokespecial <init> : (Lcom/soft/blued/ui/discover/fragment/SendFeedFloatManager;)V
    //   14: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   17: pop
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
  }
  
  public void f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Landroid/os/Handler;
    //   6: new com/soft/blued/ui/discover/fragment/SendFeedFloatManager$2
    //   9: dup
    //   10: aload_0
    //   11: invokespecial <init> : (Lcom/soft/blued/ui/discover/fragment/SendFeedFloatManager;)V
    //   14: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   17: pop
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
  }
  
  public int g() {
    try {
      Class<?> clazz = Class.forName("com.android.internal.R$dimen");
      Object object = clazz.newInstance();
      int i = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
      this.d = AppInfo.d().getResources().getDimensionPixelSize(i);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return this.d;
  }
  
  public void h() {
    if (FeedSendManager.a() != null && FeedSendManager.a().d() != null && FeedSendManager.a().d().size() > 0) {
      int i = ((NewFeedModel)FeedSendManager.a().d().get(0)).getProgress();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("progress: ");
      stringBuilder1.append(i);
      LogUtils.c(stringBuilder1.toString());
      this.e.setBarColor(new int[] { this.a.getResources().getColor(2131100331) });
      this.e.a(i, 200L);
      TextView textView = this.f;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(i);
      stringBuilder2.append("%");
      textView.setText(stringBuilder2.toString());
      int j = FeedSendManager.a().e() - FeedSendManager.a().h();
      i = j;
      if (j < 1)
        i = 1; 
      String str = this.a.getResources().getString(2131757110);
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(i);
      stringBuilder2.append("");
      str = String.format(str, new Object[] { stringBuilder2.toString() });
      this.g.setText(str);
    } 
  }
  
  public void i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual f : ()V
    //   6: aload_0
    //   7: invokevirtual c : ()V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\SendFeedFloatManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */