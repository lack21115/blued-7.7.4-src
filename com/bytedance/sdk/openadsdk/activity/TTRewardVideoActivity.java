package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.f;
import com.bytedance.sdk.openadsdk.component.reward.g;
import com.bytedance.sdk.openadsdk.component.reward.top.b;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.a;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.i.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.c;
import com.bytedance.sdk.openadsdk.utils.d;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class TTRewardVideoActivity extends TTBaseVideoActivity {
  private static TTRewardVideoAd.RewardAdInteractionListener aK;
  
  private p aF;
  
  private String aG;
  
  private int aH;
  
  private String aI;
  
  private String aJ;
  
  private AtomicBoolean aL = new AtomicBoolean(false);
  
  protected int aN;
  
  protected int aO;
  
  protected TTRewardVideoAd.RewardAdInteractionListener aP;
  
  protected final AtomicBoolean aQ = new AtomicBoolean(false);
  
  private void J() {
    this.aF = o.f();
    if (this.q == null) {
      t.e("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
      finish();
      return;
    } 
    if (this.q.q() && this.q.c() == 1)
      a(getApplicationContext()); 
    this.ap = 7;
    this.Q = ah.d(this.q.P());
    this.M = o.h().b(this.Q);
    this.O = this.q.Q();
    this.H = this.q.M();
    this.I = this.q.P();
    this.N = (int)G();
    this.J = 7;
    this.K = 2956;
    k();
    a(this.M);
    c();
    j();
    p();
    i();
    g();
    l();
    h();
    a("reward_endcard");
    K();
    b("rewarded_video");
    n();
  }
  
  private void K() {
    if (this.h != null)
      this.h.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              boolean bool;
              TTRewardVideoActivity.a(this.a);
              TTRewardVideoActivity.b(this.a);
              if (this.a.q != null && this.a.q.q() && this.a.q.c() == 1) {
                bool = true;
              } else {
                bool = false;
              } 
              if (bool) {
                TTRewardVideoActivity.a(this.a, true);
                return;
              } 
              this.a.finish();
            }
          }); 
    if (this.b != null)
      this.b.setListener(new b(this) {
            public void a(View param1View) {
              TTRewardVideoActivity.a(this.a, false);
            }
            
            public void b(View param1View) {
              TTRewardVideoActivity tTRewardVideoActivity = this.a;
              tTRewardVideoActivity.M ^= 0x1;
              if (this.a.A != null && this.a.q != null && this.a.q.c() != 1) {
                this.a.A.c(this.a.M);
                return;
              } 
              if (this.a.q != null && this.a.q.q() && this.a.q.c() == 1) {
                tTRewardVideoActivity = this.a;
                tTRewardVideoActivity.c(tTRewardVideoActivity.M);
              } 
            }
            
            public void c(View param1View) {
              this.a.H();
            }
          }); 
  }
  
  private void L() {
    if (this.A != null)
      this.A.l(); 
    a("rewarded_video", "skip", (Map<String, Object>)null);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (!TextUtils.isEmpty(this.ac))
      hashMap.put("rit_scene", this.ac); 
    hashMap.put("play_type", Integer.valueOf(ah.a(this.A, this.x)));
    a("rewarded_video", "feed_break", (Map)hashMap);
    D();
    if (b.b()) {
      d("onSkippedVideo");
      return;
    } 
    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aP;
    if (rewardAdInteractionListener != null)
      rewardAdInteractionListener.onSkippedVideo(); 
  }
  
  private void M() {
    Intent intent = getIntent();
    if (intent == null)
      return; 
    this.aG = intent.getStringExtra("reward_name");
    this.aH = intent.getIntExtra("reward_amount", 0);
    this.aI = intent.getStringExtra("media_extra");
    this.aJ = intent.getStringExtra("user_id");
    this.t = intent.getBooleanExtra("show_download_bar", true);
    this.v = intent.getStringExtra("video_cache_url");
    this.w = intent.getIntExtra("orientation", 2);
    this.ac = intent.getStringExtra("rit_scene");
  }
  
  private JSONObject R() {
    float f1;
    boolean bool;
    JSONObject jSONObject = new JSONObject();
    c c = d.a(this.d);
    float f2 = 0.0F;
    if (c == null) {
      f1 = 0.0F;
    } else {
      f1 = (d.a(this.d)).a;
    } 
    if (d.a(this.d) != null)
      f2 = (d.a(this.d)).b; 
    if (this.A != null) {
      bool = (int)this.A.r();
    } else {
      bool = false;
    } 
    try {
      jSONObject.put("oversea_version_type", 0);
      jSONObject.put("reward_name", this.aG);
      jSONObject.put("reward_amount", this.aH);
      jSONObject.put("network", w.c(this.d));
      jSONObject.put("latitude", f1);
      jSONObject.put("longitude", f2);
      jSONObject.put("sdk_version", "2.9.5.6");
      jSONObject.put("user_agent", r.a);
      jSONObject.put("extra", new JSONObject(this.I));
      jSONObject.put("media_extra", this.aI);
      jSONObject.put("video_duration", G());
      jSONObject.put("play_start_ts", this.aN);
      jSONObject.put("play_end_ts", this.aO);
      jSONObject.put("duration", bool);
      jSONObject.put("user_id", this.aJ);
      return jSONObject;
    } finally {
      jSONObject = null;
    } 
  }
  
  private void S() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (this.q != null && this.q.c() == 1 && this.q.q())
      hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.as)); 
    d.n(this.d, this.q, "rewarded_video", "click_close", null);
  }
  
  private void T() {
    if (this.q != null) {
      if (this.e == null)
        return; 
      if (!this.q.q())
        return; 
      Bitmap bitmap = ai.a((WebView)this.e);
      if (bitmap == null)
        return; 
      ai.a(o.a(), this.q, "rewarded_video", "playable_show_status", bitmap);
    } 
  }
  
  private void a(String paramString1, boolean paramBoolean, int paramInt, String paramString2) {
    a.a().a(new Runnable(this, paramString1, paramBoolean, paramInt, paramString2) {
          public void run() {
            try {
              return;
            } finally {
              Exception exception = null;
              t.c("TTRewardVideoActivity", "executeRewardVideoCallback execute throw Exception : ", exception);
            } 
          }
        }5);
  }
  
  private boolean a(Bundle paramBundle) {
    if (b.b()) {
      Intent intent = getIntent();
      if (intent != null) {
        String str = intent.getStringExtra("multi_process_materialmeta");
        this.s = intent.getStringExtra("multi_process_meta_md5");
        if (str != null)
          try {
            this.q = c.a(new JSONObject(str));
          } catch (Exception exception) {
            t.c("TTRewardVideoActivity", "TTRewardVideoActivity MultiGlobalInfo throw ", exception);
          }  
      } 
      if (this.q != null && this.q.B() == 4)
        this.B = a.a(this.d, this.q, "rewarded_video"); 
    } else {
      this.q = u.a().c();
      this.aP = u.a().d();
      this.B = u.a().f();
      u.a().g();
    } 
    if (paramBundle != null) {
      if (this.aP == null) {
        this.aP = aK;
        aK = null;
      } 
      try {
        String str = paramBundle.getString("material_meta");
        this.s = paramBundle.getString("multi_process_meta_md5");
        this.v = paramBundle.getString("video_cache_url");
        this.w = paramBundle.getInt("orientation", 2);
        this.M = paramBundle.getBoolean("is_mute");
        this.ac = paramBundle.getString("rit_scene");
        this.q = c.a(new JSONObject(str));
        this.T.set(paramBundle.getBoolean("has_show_skip_btn"));
        if (this.T.get() && this.b != null) {
          this.b.setShowSkip(true);
          this.b.a(null, "跳过");
          this.b.setSkipEnable(true);
        } 
      } finally {}
      if (this.B == null)
        this.B = a.a(this.d, this.q, "rewarded_video"); 
    } 
    k k = this.q;
    boolean bool2 = false;
    if (k == null) {
      t.e("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
      finish();
      return false;
    } 
    if (this.q.h() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.ad = bool1;
    boolean bool1 = bool2;
    if (this.q.h() == 3)
      bool1 = true; 
    this.ae = bool1;
    if (this.q != null)
      this.q.z(); 
    return true;
  }
  
  private void e(boolean paramBoolean) {
    if (!o.h().d(String.valueOf(this.Q))) {
      if (paramBoolean) {
        finish();
        return;
      } 
      L();
      return;
    } 
    if (this.aL.get()) {
      if (paramBoolean) {
        finish();
        return;
      } 
      L();
      return;
    } 
    this.X.set(true);
    if (this.A != null)
      this.A.h(); 
    if (paramBoolean)
      B(); 
    this.Y = new a((Context)this);
    if (paramBoolean) {
      this.Y.a("试玩后才可领取奖励").b("继续试玩").c("放弃奖励");
    } else {
      this.Y.a("观看完整视频才能获得奖励").b("继续观看").c("放弃奖励");
    } 
    this.Y.a(new a.a(this, paramBoolean) {
          public void a() {
            if (this.b.A != null)
              this.b.A.j(); 
            if (this.a)
              this.b.C(); 
            this.b.Y.dismiss();
            this.b.X.set(false);
          }
          
          public void b() {
            this.b.Y.dismiss();
            this.b.X.set(false);
            if (this.a) {
              this.b.finish();
              return;
            } 
            TTRewardVideoActivity.c(this.b);
          }
        }).show();
  }
  
  protected void I() {
    if (this.q == null) {
      finish();
      return;
    } 
    if (this.q.h() == 0) {
      setContentView(ab.f((Context)this, "tt_activity_rewardvideo"));
      return;
    } 
    if (this.q.h() == 1) {
      setContentView(ab.f((Context)this, "tt_activity_reward_video_newstyle"));
      return;
    } 
    if (this.q.h() == 3) {
      setContentView(ab.f((Context)this, "tt_activity_rewardvideo_new_bar_3_style"));
      return;
    } 
    setContentView(ab.f((Context)this, "tt_activity_rewardvideo"));
  }
  
  public void N() {
    if (b.b()) {
      d("onAdShow");
      return;
    } 
    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aP;
    if (rewardAdInteractionListener != null)
      rewardAdInteractionListener.onAdShow(); 
  }
  
  protected void O() {
    if (this.aL.get())
      return; 
    this.aL.set(true);
    if (o.h().n(String.valueOf(this.Q))) {
      if (b.b()) {
        a("onRewardVerify", true, this.aH, this.aG);
        return;
      } 
      TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aP;
      if (rewardAdInteractionListener != null)
        rewardAdInteractionListener.onRewardVerify(true, this.aH, this.aG); 
      return;
    } 
    JSONObject jSONObject = R();
    this.aF.a(jSONObject, new p.c(this) {
          public void a(int param1Int, String param1String) {
            if (b.b()) {
              TTRewardVideoActivity.a(this.a, "onRewardVerify", false, 0, "");
              return;
            } 
            if (this.a.aP != null)
              this.a.aP.onRewardVerify(false, 0, ""); 
          }
          
          public void a(q.c param1c) {
            int i = param1c.c.a();
            String str = param1c.c.b();
            if (b.b()) {
              TTRewardVideoActivity.a(this.a, "onRewardVerify", param1c.b, i, str);
              return;
            } 
            if (this.a.aP != null)
              this.a.aP.onRewardVerify(param1c.b, i, str); 
          }
        });
  }
  
  public void P() {
    if (b.b()) {
      d("onAdVideoBarClick");
      return;
    } 
    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aP;
    if (rewardAdInteractionListener != null)
      rewardAdInteractionListener.onAdVideoBarClick(); 
  }
  
  protected void Q() {
    if (b.b()) {
      d("onVideoComplete");
      return;
    } 
    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aP;
    if (rewardAdInteractionListener != null)
      rewardAdInteractionListener.onVideoComplete(); 
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (b.b()) {
      d("onAdVideoBarClick");
      return;
    } 
    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aP;
    if (rewardAdInteractionListener != null)
      rewardAdInteractionListener.onAdVideoBarClick(); 
  }
  
  public boolean a(long paramLong, boolean paramBoolean) {
    Map map;
    if (this.A == null)
      this.A = (c)new f(this.d, (ViewGroup)this.m, this.q); 
    boolean bool = TextUtils.isEmpty(this.ac);
    String str1 = null;
    if (!bool) {
      map = new HashMap<Object, Object>();
      map.put("rit_scene", this.ac);
    } else {
      map = null;
    } 
    this.A.a(map);
    this.A.a(new c.a(this) {
          public void a() {
            this.a.q();
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            hashMap.put("vbtt_skip_type", Integer.valueOf(0));
            this.a.a("rewarded_video", (Map)hashMap);
            if (this.a.A != null)
              this.a.A.l(); 
          }
          
          public void a(long param1Long, int param1Int) {
            this.a.Q();
            this.a.q();
            this.a.aO = (int)(System.currentTimeMillis() / 1000L);
            this.a.O();
          }
          
          public void a(long param1Long1, long param1Long2) {
            int i = (o.h().r(String.valueOf(this.a.Q))).g;
            if (param1Long2 > 0L && (float)(100L * param1Long1) / Float.valueOf((float)param1Long2).floatValue() >= i)
              this.a.O(); 
            TTRewardVideoActivity tTRewardVideoActivity = this.a;
            double d = tTRewardVideoActivity.G();
            param1Long1 /= 1000L;
            tTRewardVideoActivity.N = (int)(d - param1Long1);
            if (this.a.N >= 0 && this.a.b != null) {
              this.a.b.setShowCountDown(true);
              this.a.b.a(String.valueOf(this.a.N), null);
            } 
            int j = (int)param1Long1;
            i = this.a.P;
            boolean bool = false;
            if (i != -1 && j == this.a.P && !this.a.aQ.get()) {
              this.a.c.setVisibility(0);
              this.a.aQ.set(true);
              this.a.o();
            } 
            int k = o.h().g(String.valueOf(this.a.Q));
            i = bool;
            if (k != -1) {
              i = bool;
              if (k >= 0)
                i = 1; 
            } 
            if (i != 0 && j >= k) {
              if (!this.a.T.getAndSet(true) && this.a.b != null)
                this.a.b.setShowSkip(true); 
              if (this.a.b != null) {
                this.a.b.a(null, "跳过");
                this.a.b.setSkipEnable(true);
              } 
            } 
            if (this.a.N <= 0)
              this.a.q(); 
            if ((this.a.X.get() || this.a.V.get()) && this.a.r())
              this.a.A.h(); 
          }
          
          public void b(long param1Long, int param1Int) {
            if (b.b()) {
              this.a.d("onVideoError");
            } else if (this.a.aP != null) {
              this.a.aP.onVideoError();
            } 
            if (this.a.r())
              return; 
            if (this.a.A != null)
              this.a.A.l(); 
            this.a.q();
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            hashMap.put("vbtt_skip_type", Integer.valueOf(1));
            this.a.a("rewarded_video", (Map)hashMap);
          }
        });
    if (this.q.z() != null)
      str1 = this.q.z().g(); 
    String str2 = str1;
    if (this.v != null) {
      File file = new File(this.v);
      str2 = str1;
      if (file.exists()) {
        str2 = str1;
        if (file.length() > 0L) {
          str2 = this.v;
          this.x = true;
        } 
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("videoUrl:");
    stringBuilder.append(str2);
    t.e("wzj", stringBuilder.toString());
    if (this.A == null)
      return false; 
    bool = this.A.a(str2, this.q.M(), this.m.getWidth(), this.m.getHeight(), null, this.q.P(), paramLong, this.M);
    if (bool && !paramBoolean) {
      d.a(this.d, this.q, "rewarded_video", map);
      N();
      this.aN = (int)(System.currentTimeMillis() / 1000L);
    } 
    return bool;
  }
  
  protected void d(String paramString) {
    a(paramString, false, 0, "");
  }
  
  public void f(int paramInt) {
    if (paramInt == 10000) {
      O();
      return;
    } 
    if (paramInt == 10001)
      Q(); 
  }
  
  protected void finalize() throws Throwable {
    super.finalize();
    aK = null;
  }
  
  public void finish() {
    if (b.b()) {
      d("onAdClose");
    } else {
      TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aP;
      if (rewardAdInteractionListener != null)
        rewardAdInteractionListener.onAdClose(); 
    } 
    super.finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    M();
    if (!a(paramBundle))
      return; 
    I();
    d();
    J();
    a();
    u();
    y();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (b.b())
      d("recycleRes"); 
    if (this.aP != null)
      this.aP = null; 
    if (this.G != null)
      for (Map.Entry<String, a> entry : this.G.entrySet()) {
        if (entry.getValue() != null)
          ((a)entry.getValue()).d(); 
      }  
    if (TextUtils.isEmpty(this.v))
      g.a(o.a()).a(); 
  }
  
  protected void onPause() {
    super.onPause();
    if (this.G != null)
      for (Map.Entry<String, a> entry : this.G.entrySet()) {
        if (entry.getValue() != null)
          ((a)entry.getValue()).c(); 
      }  
  }
  
  protected void onResume() {
    super.onResume();
    if (this.G != null)
      for (Map.Entry<String, a> entry : this.G.entrySet()) {
        if (entry.getValue() != null)
          ((a)entry.getValue()).b(); 
      }  
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    aK = this.aP;
    try {
      long l;
      if (this.q != null) {
        String str = this.q.ae().toString();
      } else {
        paramBundle = null;
      } 
      bundle.putString("material_meta", (String)paramBundle);
      bundle.putString("multi_process_meta_md5", this.s);
      if (this.A == null) {
        l = this.u;
      } else {
        l = this.A.m();
      } 
      bundle.putLong("video_current", l);
      bundle.putString("video_cache_url", this.v);
      bundle.putInt("orientation", this.w);
      bundle.putBoolean("is_mute", this.M);
      bundle.putBoolean("has_show_skip_btn", this.T.get());
      bundle.putString("rit_scene", this.ac);
    } finally {}
    super.onSaveInstanceState(bundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\activity\TTRewardVideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */