package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.i.a;
import com.bytedance.sdk.openadsdk.multipro.aidl.a;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.e;
import com.bytedance.sdk.openadsdk.multipro.aidl.b.c;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

class i implements TTFullScreenVideoAd {
  private final Context a;
  
  private final k b;
  
  private final AdSlot c;
  
  private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener d;
  
  private a e;
  
  private boolean f = true;
  
  private boolean g;
  
  private String h;
  
  private String i;
  
  private AtomicBoolean j = new AtomicBoolean(false);
  
  private boolean k = false;
  
  private String l;
  
  i(Context paramContext, k paramk, AdSlot paramAdSlot) {
    this.a = paramContext;
    this.b = paramk;
    this.c = paramAdSlot;
    if (getInteractionType() == 4)
      this.e = a.a(this.a, this.b, "fullscreen_interstitial_ad"); 
    this.g = false;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.hashCode());
    stringBuilder.append(this.b.ae().toString());
    this.l = j.a(stringBuilder.toString());
  }
  
  private void a(int paramInt) {
    if (!b.b())
      return; 
    a.a().a(new Runnable(this, paramInt) {
          public void run() {
            a a = a.a(i.a(this.b));
            if (this.a != 1)
              return; 
            if (i.b(this.b) != null) {
              t.b("MultiProcess", "start registerFullScreenVideoListener ! ");
              c c = new c(i.b(this.b));
              IListenerManager iListenerManager = e.asInterface(a.a(1));
              if (iListenerManager != null)
                try {
                  iListenerManager.registerFullVideoListener(i.c(this.b), (IFullScreenVideoAdInteractionListener)c);
                  t.b("MultiProcess", "end registerFullScreenVideoListener ! ");
                  return;
                } catch (RemoteException remoteException) {
                  remoteException.printStackTrace();
                }  
            } 
          }
        }5);
  }
  
  public void a(String paramString) {
    if (this.j.get())
      return; 
    this.g = true;
    this.h = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.k = paramBoolean;
  }
  
  public int getFullVideoAdType() {
    k k1 = this.b;
    return (k1 == null) ? -1 : ((k1.q() && this.b.c() == 1) ? 2 : ((this.b.q() && this.b.c() == 0) ? 1 : 0));
  }
  
  public int getInteractionType() {
    k k1 = this.b;
    return (k1 == null) ? -1 : k1.B();
  }
  
  public Map<String, Object> getMediaExtraInfo() {
    k k1 = this.b;
    return (k1 != null) ? k1.X() : null;
  }
  
  public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener) {
    a a1 = this.e;
    if (a1 != null)
      a1.a(paramTTAppDownloadListener); 
  }
  
  public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener paramFullScreenVideoAdInteractionListener) {
    this.d = paramFullScreenVideoAdInteractionListener;
    a(1);
  }
  
  public void setShowDownLoadBar(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public void showFullScreenVideoAd(Activity paramActivity) {
    if (paramActivity != null && paramActivity.isFinishing()) {
      t.e("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
      return;
    } 
    if (Looper.getMainLooper() == Looper.myLooper()) {
      if (this.j.get())
        return; 
      this.j.set(true);
      k k1 = this.b;
      if (k1 != null) {
        Activity activity1;
        Intent intent;
        Context context;
        if (k1.z() == null)
          return; 
        if (paramActivity == null) {
          Context context1 = this.a;
        } else {
          activity1 = paramActivity;
        } 
        Activity activity2 = activity1;
        if (activity1 == null)
          context = o.a(); 
        if (this.b.x() != null) {
          intent = new Intent(context, TTFullScreenExpressVideoActivity.class);
        } else {
          intent = new Intent(context, TTFullScreenVideoActivity.class);
        } 
        if (paramActivity == null)
          intent.addFlags(268435456); 
        intent.putExtra("show_download_bar", this.f);
        intent.putExtra("orientation", this.c.getOrientation());
        intent.putExtra("is_verity_playable", this.k);
        if (!TextUtils.isEmpty(this.i))
          intent.putExtra("rit_scene", this.i); 
        if (this.g)
          intent.putExtra("video_cache_url", this.h); 
        if (b.b()) {
          intent.putExtra("multi_process_materialmeta", this.b.ae().toString());
          intent.putExtra("multi_process_meta_md5", this.l);
        } else {
          u.a().g();
          u.a().a(this.b);
          u.a().a(this.d);
          u.a().a(this.e);
          this.d = null;
        } 
        b.a(context, intent, new b.a(this) {
              public void a() {}
              
              public void a(Throwable param1Throwable) {
                t.c("TTFullScreenVideoAdImpl", "show full screen video error: ", param1Throwable);
              }
            });
        if (!TextUtils.isEmpty(this.b.P()))
          try {
            String str = (new JSONObject(this.b.P())).optString("rit", null);
            AdSlot adSlot = c.a(this.a).b(str);
            c.a(this.a).a(str);
            return;
          } finally {
            paramActivity = null;
          }  
      } 
      return;
    } 
    t.e("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error2: not main looper");
    throw new IllegalStateException("不能在子线程调用 TTFullScreenVideoAd.showFullScreenVideoAd");
  }
  
  public void showFullScreenVideoAd(Activity paramActivity, TTAdConstant.RitScenes paramRitScenes, String paramString) {
    if (paramRitScenes == null) {
      t.e("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
      return;
    } 
    if (paramRitScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
      this.i = paramString;
    } else {
      this.i = paramRitScenes.getScenesName();
    } 
    showFullScreenVideoAd(paramActivity);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\reward\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */