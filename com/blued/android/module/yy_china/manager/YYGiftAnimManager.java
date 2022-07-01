package com.blued.android.module.yy_china.manager;

import android.text.TextUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.Log;
import com.blued.android.module.live.base.view.animation.AnimationListenerAdapter;
import com.blued.android.module.live.base.view.animation.LiveAnimationListener;
import com.blued.android.module.live.base.view.animation.LiveAnimationView;
import com.blued.android.module.live.base.view.animation.LiveAnimationViewFactory;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.GiftHitListener;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMsgGiftExtra;
import com.blued.android.module.yy_china.observer.GiftObserver;
import com.blued.android.module.yy_china.view.GiftBaseHitView;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class YYGiftAnimManager implements GiftHitListener, GiftObserver {
  private List<YYImModel> a = Collections.synchronizedList(new LinkedList<YYImModel>());
  
  private List<YYMsgGiftExtra> b = Collections.synchronizedList(new LinkedList<YYMsgGiftExtra>());
  
  private GiftBaseHitView c;
  
  private GiftBaseHitView d;
  
  private LiveAnimationView e;
  
  private YYMsgGiftExtra f;
  
  private BaseYYStudioFragment g;
  
  public YYGiftAnimManager(BaseYYStudioFragment paramBaseYYStudioFragment, GiftBaseHitView paramGiftBaseHitView1, GiftBaseHitView paramGiftBaseHitView2, LiveAnimationView paramLiveAnimationView) {
    this.g = paramBaseYYStudioFragment;
    this.c = paramGiftBaseHitView1;
    this.d = paramGiftBaseHitView2;
    this.e = paramLiveAnimationView;
    this.c.setGiftHitListener(this);
    this.d.setGiftHitListener(this);
    YYObserverManager.a().a(this);
  }
  
  private void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Lcom/blued/android/module/yy_china/view/GiftBaseHitView;
    //   6: ifnull -> 220
    //   9: aload_0
    //   10: getfield d : Lcom/blued/android/module/yy_china/view/GiftBaseHitView;
    //   13: ifnull -> 220
    //   16: aload_0
    //   17: getfield a : Ljava/util/List;
    //   20: invokeinterface size : ()I
    //   25: ifne -> 31
    //   28: goto -> 220
    //   31: aload_0
    //   32: getfield a : Ljava/util/List;
    //   35: invokeinterface iterator : ()Ljava/util/Iterator;
    //   40: astore_3
    //   41: aload_3
    //   42: invokeinterface hasNext : ()Z
    //   47: ifeq -> 217
    //   50: aload_3
    //   51: invokeinterface next : ()Ljava/lang/Object;
    //   56: checkcast com/blued/android/module/yy_china/model/YYImModel
    //   59: astore #4
    //   61: aload_0
    //   62: getfield c : Lcom/blued/android/module/yy_china/view/GiftBaseHitView;
    //   65: invokevirtual getVisibility : ()I
    //   68: istore_1
    //   69: iconst_1
    //   70: istore_2
    //   71: iload_1
    //   72: ifne -> 228
    //   75: iconst_1
    //   76: istore_1
    //   77: goto -> 80
    //   80: aload_0
    //   81: getfield d : Lcom/blued/android/module/yy_china/view/GiftBaseHitView;
    //   84: invokevirtual getVisibility : ()I
    //   87: ifne -> 233
    //   90: goto -> 93
    //   93: iload_1
    //   94: ifeq -> 118
    //   97: aload_0
    //   98: getfield c : Lcom/blued/android/module/yy_china/view/GiftBaseHitView;
    //   101: aload #4
    //   103: invokevirtual a : (Lcom/blued/android/module/yy_china/model/YYImModel;)Z
    //   106: ifeq -> 118
    //   109: aload_3
    //   110: invokeinterface remove : ()V
    //   115: goto -> 41
    //   118: iload_2
    //   119: ifeq -> 238
    //   122: aload_0
    //   123: getfield d : Lcom/blued/android/module/yy_china/view/GiftBaseHitView;
    //   126: aload #4
    //   128: invokevirtual a : (Lcom/blued/android/module/yy_china/model/YYImModel;)Z
    //   131: ifeq -> 238
    //   134: aload_3
    //   135: invokeinterface remove : ()V
    //   140: goto -> 41
    //   143: iload_1
    //   144: ifne -> 169
    //   147: iload_2
    //   148: ifne -> 169
    //   151: aload_0
    //   152: getfield c : Lcom/blued/android/module/yy_china/view/GiftBaseHitView;
    //   155: aload #4
    //   157: invokevirtual setHitModel : (Lcom/blued/android/module/yy_china/model/YYImModel;)V
    //   160: aload_3
    //   161: invokeinterface remove : ()V
    //   166: goto -> 41
    //   169: iload_1
    //   170: ifeq -> 195
    //   173: iload_2
    //   174: ifne -> 195
    //   177: aload_0
    //   178: getfield d : Lcom/blued/android/module/yy_china/view/GiftBaseHitView;
    //   181: aload #4
    //   183: invokevirtual setHitModel : (Lcom/blued/android/module/yy_china/model/YYImModel;)V
    //   186: aload_3
    //   187: invokeinterface remove : ()V
    //   192: goto -> 41
    //   195: iload_1
    //   196: ifne -> 41
    //   199: aload_0
    //   200: getfield c : Lcom/blued/android/module/yy_china/view/GiftBaseHitView;
    //   203: aload #4
    //   205: invokevirtual setHitModel : (Lcom/blued/android/module/yy_china/model/YYImModel;)V
    //   208: aload_3
    //   209: invokeinterface remove : ()V
    //   214: goto -> 41
    //   217: aload_0
    //   218: monitorexit
    //   219: return
    //   220: aload_0
    //   221: monitorexit
    //   222: return
    //   223: astore_3
    //   224: aload_0
    //   225: monitorexit
    //   226: aload_3
    //   227: athrow
    //   228: iconst_0
    //   229: istore_1
    //   230: goto -> 80
    //   233: iconst_0
    //   234: istore_2
    //   235: goto -> 93
    //   238: iload_1
    //   239: ifeq -> 143
    //   242: iload_2
    //   243: ifeq -> 143
    //   246: goto -> 217
    // Exception table:
    //   from	to	target	type
    //   2	28	223	finally
    //   31	41	223	finally
    //   41	69	223	finally
    //   80	90	223	finally
    //   97	115	223	finally
    //   122	140	223	finally
    //   151	166	223	finally
    //   177	192	223	finally
    //   199	214	223	finally
  }
  
  private void c() {
    if (this.g == null)
      return; 
    if (this.f == null) {
      Log.e("==yy==", "=== notifyPlayGif ===");
      this.g.a(new Runnable(this) {
            public void run() {
              YYGiftAnimManager.f(this.a);
            }
          });
    } 
  }
  
  private void d() {
    YYMsgGiftExtra yYMsgGiftExtra = e();
    Log.e("==yy==", "=== loopPlayFullScreen ===");
    if (yYMsgGiftExtra != null) {
      this.f = yYMsgGiftExtra;
      this.e.setVisibility(0);
      f();
      return;
    } 
    this.e.setVisibility(8);
  }
  
  private YYMsgGiftExtra e() {
    YYMsgGiftExtra yYMsgGiftExtra = this.f;
    if (yYMsgGiftExtra != null)
      return yYMsgGiftExtra; 
    try {
      if (this.b.size() > 0)
        return this.b.remove(0); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  private void f() {
    if (this.g == null)
      return; 
    Log.e("==yy==", "=== playFullScreenAnimation ===");
    this.e.a((IRequestHost)this.g.w_(), "", "", this.f.gift_mp4, "", LiveAnimationViewFactory.ScaleType.a, (LiveAnimationListener)new AnimationListenerAdapter(this) {
          public void b() {
            YYGiftAnimManager.g(this.a);
          }
        });
  }
  
  private void g() {
    BaseYYStudioFragment baseYYStudioFragment = this.g;
    if (baseYYStudioFragment == null)
      return; 
    baseYYStudioFragment.a(new Runnable(this) {
          public void run() {
            YYGiftAnimManager.a(this.a, (YYMsgGiftExtra)null);
            YYGiftAnimManager.f(this.a);
          }
        });
  }
  
  public void a() {
    this.g = null;
    GiftBaseHitView giftBaseHitView = this.c;
    if (giftBaseHitView != null) {
      giftBaseHitView.a();
      this.c = null;
    } 
    giftBaseHitView = this.d;
    if (giftBaseHitView != null) {
      giftBaseHitView.a();
      this.d = null;
    } 
    this.e = null;
    this.a.clear();
  }
  
  public void a(YYImModel paramYYImModel, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Lcom/blued/android/module/yy_china/fragment/BaseYYStudioFragment;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield g : Lcom/blued/android/module/yy_china/fragment/BaseYYStudioFragment;
    //   18: new com/blued/android/module/yy_china/manager/YYGiftAnimManager$1
    //   21: dup
    //   22: aload_0
    //   23: iload_2
    //   24: aload_1
    //   25: invokespecial <init> : (Lcom/blued/android/module/yy_china/manager/YYGiftAnimManager;ZLcom/blued/android/module/yy_china/model/YYImModel;)V
    //   28: invokevirtual a : (Ljava/lang/Runnable;)Z
    //   31: pop
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	35	finally
    //   14	32	35	finally
  }
  
  public void a(GiftBaseHitView paramGiftBaseHitView) {
    b();
  }
  
  public void b(GiftBaseHitView paramGiftBaseHitView) {
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\manager\YYGiftAnimManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */