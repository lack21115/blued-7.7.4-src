package com.blued.android.framework.view.SuperToast;

import android.animation.Animator;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.blued.android.framework.view.SuperToast.utils.AnimationUtils;
import java.util.Comparator;
import java.util.PriorityQueue;

class Toaster extends Handler {
  private static Toaster a;
  
  private final PriorityQueue<SuperToast> b = new PriorityQueue<SuperToast>(10, new SuperToastComparator());
  
  static Toaster a() {
    // Byte code:
    //   0: ldc com/blued/android/framework/view/SuperToast/Toaster
    //   2: monitorenter
    //   3: getstatic com/blued/android/framework/view/SuperToast/Toaster.a : Lcom/blued/android/framework/view/SuperToast/Toaster;
    //   6: ifnull -> 18
    //   9: getstatic com/blued/android/framework/view/SuperToast/Toaster.a : Lcom/blued/android/framework/view/SuperToast/Toaster;
    //   12: astore_0
    //   13: ldc com/blued/android/framework/view/SuperToast/Toaster
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new com/blued/android/framework/view/SuperToast/Toaster
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: putstatic com/blued/android/framework/view/SuperToast/Toaster.a : Lcom/blued/android/framework/view/SuperToast/Toaster;
    //   28: getstatic com/blued/android/framework/view/SuperToast/Toaster.a : Lcom/blued/android/framework/view/SuperToast/Toaster;
    //   31: astore_0
    //   32: ldc com/blued/android/framework/view/SuperToast/Toaster
    //   34: monitorexit
    //   35: aload_0
    //   36: areturn
    //   37: astore_0
    //   38: ldc com/blued/android/framework/view/SuperToast/Toaster
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	37	finally
    //   18	32	37	finally
  }
  
  private void a(SuperToast paramSuperToast, int paramInt, long paramLong) {
    Message message = obtainMessage(paramInt);
    message.obj = paramSuperToast;
    sendMessageDelayed(message, paramLong);
  }
  
  private void c(SuperToast paramSuperToast) {
    if (paramSuperToast.m())
      return; 
    if (paramSuperToast instanceof SuperActivityToast) {
      SuperActivityToast superActivityToast = (SuperActivityToast)paramSuperToast;
      if (superActivityToast.d() == null) {
        Log.e(getClass().getName(), "The SuperActivityToast's ViewGroup was null, could not show.");
        return;
      } 
      try {
        ((SuperActivityToast)paramSuperToast).d().addView(paramSuperToast.l());
        if (!((SuperActivityToast)paramSuperToast).b())
          AnimationUtils.a((SuperActivityToast)paramSuperToast).start(); 
      } catch (IllegalStateException illegalStateException) {
        Log.e(getClass().getName(), illegalStateException.toString());
      } 
      if (!superActivityToast.c()) {
        a(paramSuperToast, 5395284, paramSuperToast.h() + 250L);
        return;
      } 
    } else {
      WindowManager windowManager = (WindowManager)paramSuperToast.k().getApplicationContext().getSystemService("window");
      if (windowManager != null)
        windowManager.addView(paramSuperToast.l(), (ViewGroup.LayoutParams)paramSuperToast.n()); 
      a(paramSuperToast, 5395284, paramSuperToast.h() + 250L);
    } 
  }
  
  private void d() {
    if (this.b.isEmpty())
      return; 
    SuperToast superToast = this.b.peek();
    if (!superToast.m()) {
      Message message = obtainMessage(4477780);
      message.obj = superToast;
      sendMessage(message);
    } 
  }
  
  void a(SuperToast paramSuperToast) {
    this.b.add(paramSuperToast);
    d();
  }
  
  void b() {
    removeMessages(4281172);
    removeMessages(4477780);
    removeMessages(5395284);
    for (SuperToast superToast : this.b) {
      if (superToast instanceof SuperActivityToast) {
        if (superToast.m()) {
          try {
            ((SuperActivityToast)superToast).d().removeView(superToast.l());
            ((SuperActivityToast)superToast).d().invalidate();
            continue;
          } catch (NullPointerException nullPointerException) {
          
          } catch (IllegalStateException illegalStateException) {}
          Log.e(getClass().getName(), illegalStateException.toString());
        } 
        continue;
      } 
      WindowManager windowManager = (WindowManager)illegalStateException.k().getApplicationContext().getSystemService("window");
      if (illegalStateException.m()) {
        try {
          windowManager.removeView(illegalStateException.l());
          continue;
        } catch (NullPointerException nullPointerException) {
        
        } catch (IllegalArgumentException illegalArgumentException) {}
        Log.e(getClass().getName(), illegalArgumentException.toString());
      } 
    } 
    this.b.clear();
  }
  
  void b(SuperToast paramSuperToast) {
    if (paramSuperToast instanceof SuperActivityToast) {
      if (!paramSuperToast.m()) {
        this.b.remove(paramSuperToast);
        return;
      } 
      Animator animator = AnimationUtils.b((SuperActivityToast)paramSuperToast);
      animator.addListener(new Animator.AnimatorListener(this, paramSuperToast) {
            public void onAnimationCancel(Animator param1Animator) {}
            
            public void onAnimationEnd(Animator param1Animator) {
              if (this.a.i() != null)
                this.a.i().a(this.a.l(), (this.a.j()).m); 
              ((SuperActivityToast)this.a).d().removeView(this.a.l());
              Toaster.a(this.b);
            }
            
            public void onAnimationRepeat(Animator param1Animator) {}
            
            public void onAnimationStart(Animator param1Animator) {}
          });
      animator.start();
    } else {
      WindowManager windowManager = (WindowManager)paramSuperToast.k().getSystemService("window");
      if (windowManager != null) {
        try {
          windowManager.removeView(paramSuperToast.l());
        } catch (IllegalArgumentException illegalArgumentException) {
          Log.e(getClass().getName(), illegalArgumentException.toString());
        } 
        if (paramSuperToast.i() != null)
          paramSuperToast.i().a(paramSuperToast.l(), (paramSuperToast.j()).m); 
        a(paramSuperToast, 4281172, 250L);
      } else {
        throw new IllegalStateException("The SuperToast's WindowManager was null when trying to remove the SuperToast.");
      } 
    } 
    this.b.poll();
  }
  
  public PriorityQueue<SuperToast> c() {
    return this.b;
  }
  
  public void handleMessage(Message paramMessage) {
    SuperToast superToast = (SuperToast)paramMessage.obj;
    int i = paramMessage.what;
    if (i != 4281172) {
      if (i != 4477780) {
        if (i != 5395284) {
          super.handleMessage(paramMessage);
          return;
        } 
        b(superToast);
        return;
      } 
      c(superToast);
      return;
    } 
    d();
  }
  
  static final class Messages {}
  
  class SuperToastComparator implements Comparator<SuperToast> {
    private SuperToastComparator(Toaster this$0) {}
    
    public int a(SuperToast param1SuperToast1, SuperToast param1SuperToast2) {
      return param1SuperToast1.m() ? -1 : (((param1SuperToast1.j()).n < (param1SuperToast2.j()).n) ? -1 : (((param1SuperToast1.j()).n > (param1SuperToast2.j()).n) ? 1 : (((param1SuperToast1.j()).o <= (param1SuperToast2.j()).o) ? -1 : 1)));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\SuperToast\Toaster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */