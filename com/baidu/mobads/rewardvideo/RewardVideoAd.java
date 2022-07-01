package com.baidu.mobads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.MobRewardVideoImpl;
import com.baidu.mobads.f.q;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.rewardvideo.a;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;

public class RewardVideoAd {
  private IXAdConstants4PDK.ActivityState a = IXAdConstants4PDK.ActivityState.CREATE;
  
  private final Context b;
  
  private a c;
  
  private RewardVideoAdListener d;
  
  public RewardVideoAd(Activity paramActivity, String paramString, RewardVideoAdListener paramRewardVideoAdListener) {
    this(paramActivity, paramString, paramRewardVideoAdListener, false);
  }
  
  public RewardVideoAd(Activity paramActivity, String paramString, RewardVideoAdListener paramRewardVideoAdListener, boolean paramBoolean) {
    this.b = (Context)paramActivity;
    XAdSDKFoundationFacade.getInstance().initializeApplicationContext(this.b.getApplicationContext());
    q.a(this.b).a();
    this.d = paramRewardVideoAdListener;
    this.c = new a(this.b, paramString, paramBoolean);
  }
  
  public RewardVideoAd(Context paramContext, String paramString, RewardVideoAdListener paramRewardVideoAdListener) {
    this(paramContext, paramString, paramRewardVideoAdListener, false);
  }
  
  public RewardVideoAd(Context paramContext, String paramString, RewardVideoAdListener paramRewardVideoAdListener, boolean paramBoolean) {
    this.b = paramContext;
    XAdSDKFoundationFacade.getInstance().initializeApplicationContext(this.b.getApplicationContext());
    q.a(this.b).a();
    this.d = paramRewardVideoAdListener;
    this.c = new a(this.b, paramString, paramBoolean);
  }
  
  private void a() {
    CustomIOAdEventListener customIOAdEventListener = new CustomIOAdEventListener(this);
    this.c.removeAllListeners();
    this.c.addEventListener("AdUserClick", customIOAdEventListener);
    this.c.addEventListener("AdLoaded", customIOAdEventListener);
    this.c.addEventListener("AdStarted", customIOAdEventListener);
    this.c.addEventListener("AdStopped", customIOAdEventListener);
    this.c.addEventListener("AdError", customIOAdEventListener);
    this.c.addEventListener("AdRvdieoCacheSucc", customIOAdEventListener);
    this.c.addEventListener("AdRvdieoCacheFailed", customIOAdEventListener);
    this.c.addEventListener("PlayCompletion", customIOAdEventListener);
    this.c.addEventListener("AdRvdieoPlayError", customIOAdEventListener);
    this.c.request();
  }
  
  private void a(IXAdConstants4PDK.ActivityState paramActivityState) {
    this.a = paramActivityState;
    if (this.c != null) {
      if (paramActivityState == IXAdConstants4PDK.ActivityState.PAUSE)
        this.c.pause(); 
      if (paramActivityState == IXAdConstants4PDK.ActivityState.RESUME)
        this.c.resume(); 
    } 
  }
  
  public static void setAppSid(String paramString) {
    XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(paramString);
  }
  
  public boolean isReady() {
    a a1 = this.c;
    return (a1 != null && a1.t() && !this.c.a() && this.c.b());
  }
  
  public void load() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/baidu/mobads/MobRewardVideoImpl.mVideoPlaying : Z
    //   5: istore_1
    //   6: iload_1
    //   7: ifeq -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: getfield c : Lcom/baidu/mobads/production/rewardvideo/a;
    //   17: ifnull -> 28
    //   20: aload_0
    //   21: getfield c : Lcom/baidu/mobads/production/rewardvideo/a;
    //   24: iconst_0
    //   25: invokevirtual c : (Z)V
    //   28: aload_0
    //   29: invokespecial a : ()V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	6	35	finally
    //   13	28	35	finally
    //   28	32	35	finally
  }
  
  public void pause() {
    a(IXAdConstants4PDK.ActivityState.PAUSE);
  }
  
  public void resume() {
    a(IXAdConstants4PDK.ActivityState.RESUME);
  }
  
  public void show() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Lcom/baidu/mobads/production/rewardvideo/a;
    //   6: ifnull -> 86
    //   9: getstatic com/baidu/mobads/MobRewardVideoImpl.mVideoPlaying : Z
    //   12: istore_1
    //   13: iload_1
    //   14: ifeq -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield c : Lcom/baidu/mobads/production/rewardvideo/a;
    //   24: invokevirtual getCurrentXAdContainer : ()Lcom/baidu/mobads/interfaces/IXAdContainer;
    //   27: ifnull -> 74
    //   30: aload_0
    //   31: getfield c : Lcom/baidu/mobads/production/rewardvideo/a;
    //   34: invokevirtual u : ()Z
    //   37: ifeq -> 74
    //   40: aload_0
    //   41: getfield c : Lcom/baidu/mobads/production/rewardvideo/a;
    //   44: invokevirtual a : ()Z
    //   47: ifne -> 74
    //   50: aload_0
    //   51: getfield c : Lcom/baidu/mobads/production/rewardvideo/a;
    //   54: invokevirtual t : ()Z
    //   57: ifeq -> 74
    //   60: iconst_1
    //   61: putstatic com/baidu/mobads/MobRewardVideoImpl.mVideoPlaying : Z
    //   64: aload_0
    //   65: getfield c : Lcom/baidu/mobads/production/rewardvideo/a;
    //   68: invokevirtual v : ()V
    //   71: goto -> 86
    //   74: aload_0
    //   75: invokespecial a : ()V
    //   78: aload_0
    //   79: getfield c : Lcom/baidu/mobads/production/rewardvideo/a;
    //   82: iconst_1
    //   83: invokevirtual c : (Z)V
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	89	finally
    //   20	71	89	finally
    //   74	86	89	finally
  }
  
  class CustomIOAdEventListener implements IOAdEventListener {
    public CustomIOAdEventListener(RewardVideoAd this$0) {}
    
    public void run(IOAdEvent param1IOAdEvent) {
      String str = param1IOAdEvent.getType();
      HashMap hashMap = (HashMap)param1IOAdEvent.getData();
      if ("AdLoaded".equals(str))
        return; 
      if ("AdStarted".equals(str)) {
        if (RewardVideoAd.a(this.a) != null) {
          RewardVideoAd.a(this.a).onAdShow();
          return;
        } 
      } else if ("AdUserClick".equals(str)) {
        if (RewardVideoAd.a(this.a) != null) {
          RewardVideoAd.a(this.a).onAdClick();
          return;
        } 
      } else {
        String str1;
        if ("AdStopped".equals(str)) {
          MobRewardVideoImpl.mVideoPlaying = false;
          if (hashMap != null) {
            str1 = hashMap.get("play_scale").toString();
          } else {
            str1 = "0";
          } 
          if (RewardVideoAd.a(this.a) != null) {
            RewardVideoAd.a(this.a).onAdClose(Float.valueOf(str1).floatValue());
            return;
          } 
        } else if ("AdRvdieoCacheSucc".equals(str)) {
          if (RewardVideoAd.a(this.a) != null) {
            RewardVideoAd.a(this.a).onVideoDownloadSuccess();
            return;
          } 
        } else if ("AdRvdieoCacheFailed".equals(str)) {
          if (RewardVideoAd.a(this.a) != null) {
            RewardVideoAd.a(this.a).onVideoDownloadFailed();
            return;
          } 
        } else if ("AdError".equals(str)) {
          if (RewardVideoAd.a(this.a) != null) {
            RewardVideoAd.a(this.a).onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(str1.getData()));
            return;
          } 
        } else if ("PlayCompletion".equals(str)) {
          if (RewardVideoAd.a(this.a) != null) {
            RewardVideoAd.a(this.a).playCompletion();
            return;
          } 
        } else {
          "AdRvdieoPlayError".equals(str);
        } 
      } 
    }
  }
  
  public static interface RewardVideoAdListener {
    void onAdClick();
    
    void onAdClose(float param1Float);
    
    void onAdFailed(String param1String);
    
    void onAdShow();
    
    void onVideoDownloadFailed();
    
    void onVideoDownloadSuccess();
    
    void playCompletion();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\rewardvideo\RewardVideoAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */