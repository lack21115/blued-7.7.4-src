package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.b;
import com.bytedance.sdk.openadsdk.component.reward.c;
import com.bytedance.sdk.openadsdk.component.reward.top.b;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.i.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
  private static TTFullScreenVideoAd.FullScreenVideoAdInteractionListener aG;
  
  private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener aF;
  
  private void J() {
    Intent intent = getIntent();
    if (intent == null)
      return; 
    this.t = intent.getBooleanExtra("show_download_bar", true);
    this.v = intent.getStringExtra("video_cache_url");
    this.w = intent.getIntExtra("orientation", 2);
    this.ac = intent.getStringExtra("rit_scene");
    this.aq = intent.getBooleanExtra("is_verity_playable", false);
  }
  
  private void K() {
    if (this.q == null) {
      t.e("TTFullScreenVideoActivity", "mMaterialMeta is null , no data to display ,the TTFullScreenVideoActivity finished !!");
      finish();
      return;
    } 
    if (this.q.q() && this.q.c() == 1)
      a(getApplicationContext()); 
    this.ap = 8;
    this.Q = ah.d(this.q.P());
    this.O = this.q.Q();
    this.H = this.q.M();
    this.I = this.q.P();
    this.N = (int)G();
    this.J = 5;
    this.M = o.h().b(this.Q);
    this.K = 2956;
    k();
    a(this.M);
    j();
    p();
    i();
    l();
    h();
    g();
    a("fullscreen_endcard");
    L();
    b("fullscreen_interstitial_ad");
    n();
  }
  
  private void L() {
    if (this.h != null)
      this.h.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              TTFullScreenVideoActivity.a(this.a);
              TTFullScreenVideoActivity.b(this.a);
              this.a.finish();
            }
          }); 
    if (this.b != null)
      this.b.setListener(new b(this) {
            public void a(View param1View) {
              HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
              if (!TextUtils.isEmpty(this.a.ac))
                hashMap.put("rit_scene", this.a.ac); 
              hashMap.put("play_type", Integer.valueOf(ah.a(this.a.A, this.a.x)));
              this.a.a("fullscreen_interstitial_ad", "feed_break", (Map)hashMap);
              this.a.a("fullscreen_interstitial_ad", "skip", (Map<String, Object>)null);
              if (b.b()) {
                TTFullScreenVideoActivity.a(this.a, "onSkippedVideo");
              } else if (TTFullScreenVideoActivity.c(this.a) != null) {
                TTFullScreenVideoActivity.c(this.a).onSkippedVideo();
              } 
              if (this.a.O()) {
                this.a.D();
                return;
              } 
              this.a.finish();
            }
            
            public void b(View param1View) {
              TTFullScreenVideoActivity tTFullScreenVideoActivity = this.a;
              tTFullScreenVideoActivity.M ^= 0x1;
              if (this.a.A != null && this.a.q != null && this.a.q.c() != 1) {
                this.a.A.c(this.a.M);
                return;
              } 
              if (this.a.q != null && this.a.q.q() && this.a.q.c() == 1) {
                tTFullScreenVideoActivity = this.a;
                tTFullScreenVideoActivity.c(tTFullScreenVideoActivity.M);
              } 
            }
            
            public void c(View param1View) {
              this.a.H();
            }
          }); 
  }
  
  private void M() {
    if (this.b != null) {
      this.b.a(null, "跳过");
      this.b.setSkipEnable(true);
    } 
  }
  
  private void R() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (this.q != null && this.q.q() && this.q.c() == 1)
      hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.as)); 
    d.n(this.d, this.q, "fullscreen_interstitial_ad", "click_close", hashMap);
  }
  
  private void S() {
    if (this.q != null) {
      if (this.e == null)
        return; 
      if (!this.q.q())
        return; 
      Bitmap bitmap = ai.a((WebView)this.e);
      if (bitmap == null)
        return; 
      ai.a(o.a(), this.q, "fullscreen_interstitial_ad", "playable_show_status", bitmap);
    } 
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
            t.c("TTFullScreenVideoActivity", "initData MultiGlobalInfo throws ", exception);
          }  
      } 
      if (this.q != null && this.q.B() == 4)
        this.B = a.a(this.d, this.q, "fullscreen_interstitial_ad"); 
    } else {
      this.q = u.a().c();
      this.aF = u.a().e();
      this.B = u.a().f();
      u.a().g();
    } 
    if (paramBundle != null) {
      if (this.aF == null) {
        this.aF = aG;
        aG = null;
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
        if (this.T.get()) {
          if (this.b != null)
            this.b.setShowSkip(true); 
          M();
        } 
      } finally {}
      if (this.B == null)
        this.B = a.a(this.d, this.q, "rewarded_video"); 
    } 
    k k = this.q;
    boolean bool2 = false;
    if (k == null) {
      t.e("TTFullScreenVideoActivity", "mMaterialMeta is null , no data to display ,the TTFullScreenVideoActivity finished !!");
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
  
  private void d(int paramInt) {
    if (this.b != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("s后可跳过");
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
      this.b.a(null, (CharSequence)spannableStringBuilder);
    } 
  }
  
  private void d(String paramString) {
    a.a().a(new Runnable(this, paramString) {
          public void run() {
            try {
              return;
            } finally {
              Exception exception = null;
              t.c("TTFullScreenVideoActivity", "executeFullVideoCallback execute throw Exception : ", exception);
            } 
          }
        }5);
  }
  
  protected void I() {
    if (this.q == null) {
      finish();
      return;
    } 
    if (this.q.h() == 0) {
      setContentView(ab.f((Context)this, "tt_activity_full_video"));
    } else if (this.q.h() == 1) {
      setContentView(ab.f((Context)this, "tt_activity_full_video_newstyle"));
    } else if (this.q.h() == 3) {
      setContentView(ab.f((Context)this, "tt_activity_full_video_new_bar_3_style"));
    } else {
      setContentView(ab.f((Context)this, "tt_activity_full_video"));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getPlayBarStyle=");
    stringBuilder.append(this.q.h());
    t.b("report-5", stringBuilder.toString());
  }
  
  public void N() {
    if (b.b()) {
      d("onAdShow");
      return;
    } 
    TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aF;
    if (fullScreenVideoAdInteractionListener != null)
      fullScreenVideoAdInteractionListener.onAdShow(); 
  }
  
  protected boolean O() {
    return (o.h().j(String.valueOf(this.Q)) == 2);
  }
  
  public void P() {
    if (b.b()) {
      d("onAdVideoBarClick");
      return;
    } 
    TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aF;
    if (fullScreenVideoAdInteractionListener != null)
      fullScreenVideoAdInteractionListener.onAdVideoBarClick(); 
  }
  
  protected void Q() {
    if (b.b()) {
      d("onVideoComplete");
      return;
    } 
    TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aF;
    if (fullScreenVideoAdInteractionListener != null)
      fullScreenVideoAdInteractionListener.onVideoComplete(); 
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (b.b()) {
      d("onAdVideoBarClick");
      return;
    } 
    TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aF;
    if (fullScreenVideoAdInteractionListener != null)
      fullScreenVideoAdInteractionListener.onAdVideoBarClick(); 
  }
  
  public boolean a(long paramLong, boolean paramBoolean) {
    Map map;
    if (this.A == null)
      this.A = (c)new b(this.d, (ViewGroup)this.m, this.q); 
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
            t.b("TTFullScreenVideoActivity", "onTimeOut、、、、、、、、");
            if (this.a.O()) {
              this.a.q();
            } else {
              this.a.finish();
            } 
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            hashMap.put("vbtt_skip_type", Integer.valueOf(0));
            this.a.a("fullscreen_interstitial_ad", (Map)hashMap);
            if (this.a.A != null)
              this.a.A.l(); 
          }
          
          public void a(long param1Long, int param1Int) {
            this.a.Q();
            if (this.a.O()) {
              this.a.q();
              return;
            } 
            this.a.finish();
          }
          
          public void a(long param1Long1, long param1Long2) {
            TTFullScreenVideoActivity tTFullScreenVideoActivity = this.a;
            double d = tTFullScreenVideoActivity.G();
            param1Long1 /= 1000L;
            tTFullScreenVideoActivity.N = (int)(d - param1Long1);
            int i = (int)param1Long1;
            this.a.e(i);
            if (this.a.N >= 0 && this.a.b != null) {
              this.a.b.setShowCountDown(true);
              this.a.b.a(String.valueOf(this.a.N), null);
            } 
            if (this.a.N <= 0) {
              t.b("TTFullScreenVideoActivity", "onProgressUpdate、、、、、、、、");
              if (this.a.O()) {
                this.a.q();
              } else {
                this.a.finish();
              } 
            } 
            if ((this.a.X.get() || this.a.V.get()) && this.a.r())
              this.a.A.h(); 
          }
          
          public void b(long param1Long, int param1Int) {
            if (this.a.r())
              return; 
            if (this.a.A != null)
              this.a.A.l(); 
            t.e("TTFullScreenVideoActivity", "onError、、、、、、、、");
            if (this.a.O()) {
              this.a.q();
              HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
              hashMap.put("vbtt_skip_type", Integer.valueOf(1));
              this.a.a("fullscreen_interstitial_ad", (Map)hashMap);
              return;
            } 
            this.a.finish();
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
      d.a(this.d, this.q, "fullscreen_interstitial_ad", map);
      N();
    } 
    return bool;
  }
  
  protected void e(int paramInt) {
    if (!o.h().b(String.valueOf(this.Q))) {
      if (paramInt >= 5) {
        if (!this.T.getAndSet(true) && this.b != null)
          this.b.setShowSkip(true); 
        M();
        return;
      } 
    } else {
      if (!this.T.getAndSet(true) && this.b != null)
        this.b.setShowSkip(true); 
      if (paramInt <= 5) {
        d(5 - paramInt);
        if (this.b != null) {
          this.b.setSkipEnable(false);
          return;
        } 
      } else {
        M();
      } 
    } 
  }
  
  public void f(int paramInt) {
    if (paramInt == 10002)
      Q(); 
  }
  
  protected void finalize() throws Throwable {
    super.finalize();
    aG = null;
  }
  
  public void finish() {
    if (b.b()) {
      d("onAdClose");
    } else {
      TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aF;
      if (fullScreenVideoAdInteractionListener != null)
        fullScreenVideoAdInteractionListener.onAdClose(); 
    } 
    super.finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    J();
    if (!a(paramBundle))
      return; 
    I();
    d();
    K();
    a();
    u();
    y();
    if (this.q != null)
      this.Q = ah.d(this.q.P()); 
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (b.b())
      d("recycleRes"); 
    if (this.aF != null)
      this.aF = null; 
    if (this.G != null)
      for (Map.Entry<String, a> entry : this.G.entrySet()) {
        if (entry.getValue() != null)
          ((a)entry.getValue()).d(); 
      }  
    if (TextUtils.isEmpty(this.v))
      c.a(o.a()).b(); 
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
    aG = this.aF;
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
      bundle.putString("rit_scene", this.ac);
      bundle.putBoolean("has_show_skip_btn", this.T.get());
    } finally {}
    super.onSaveInstanceState(bundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\activity\TTFullScreenVideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */