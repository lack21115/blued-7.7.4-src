package com.qq.e.comm.plugin.o;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.ab.e.e;
import com.qq.e.comm.plugin.ab.e.f;
import com.qq.e.comm.plugin.ab.f.a.c;
import com.qq.e.comm.plugin.o.a.a;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;

public class a implements View.OnClickListener, ACTD, f {
  private static final String h = a.class.getSimpleName();
  
  private final Activity a;
  
  private HybridADListener b;
  
  private HybridADSetting c;
  
  private RelativeLayout d;
  
  private c e;
  
  private com.qq.e.comm.plugin.ab.e.a f;
  
  private ProgressBar g;
  
  private boolean i;
  
  public a(Activity paramActivity) {
    this.a = paramActivity;
  }
  
  private void a() {
    this.d = new RelativeLayout((Context)this.a);
    this.e = new c((Context)this.a, this.c);
    this.e.setId(2131755009);
    this.e.a().setOnClickListener(this);
    this.e.b().setOnClickListener(this);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, am.a((Context)this.a, this.c.getTitleBarHeight()));
    layoutParams.addRule(10, -1);
    this.d.addView((View)this.e, (ViewGroup.LayoutParams)layoutParams);
    this.f = (new e((Context)this.a)).a();
    this.f.a(this);
    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
    layoutParams.addRule(3, 2131755009);
    this.d.addView(this.f.c(), (ViewGroup.LayoutParams)layoutParams);
    this.g = new ProgressBar((Context)this.a);
    this.g.setVisibility(8);
    layoutParams = new RelativeLayout.LayoutParams(am.a((Context)this.a, 46), am.a((Context)this.a, 46));
    layoutParams.addRule(13, -1);
    this.d.addView((View)this.g, (ViewGroup.LayoutParams)layoutParams);
    this.a.setContentView((View)this.d, new ViewGroup.LayoutParams(-1, -1));
  }
  
  private void a(int paramInt) {
    y.a(new Runnable(this, paramInt) {
          public void run() {
            a.a(this.b).onError(ai.a(this.a));
          }
        });
  }
  
  private void b() {
    if (this.f.a(-1)) {
      this.f.a();
      return;
    } 
    c();
  }
  
  private void c() {
    y.a(new Runnable(this) {
          public void run() {
            a.a(this.a).onClose();
          }
        });
    this.a.finish();
  }
  
  public void a(String paramString) {
    ak.a("gdt_tag_callback", "onPageFinished(url)");
    ak.b(h, "onPageFinished : url = %s", new Object[] { paramString });
    if (!this.i) {
      y.a(new Runnable(this) {
            public void run() {
              a.a(this.a).onLoadFinished();
            }
          });
      u.a(21042, 3, null);
      this.i = true;
    } 
    this.g.setVisibility(8);
    if (this.f.a(-1)) {
      this.e.d().setVisibility(0);
      this.e.b().setVisibility(0);
      return;
    } 
    this.e.d().setVisibility(4);
    this.e.b().setVisibility(4);
  }
  
  public void a(String paramString, Bitmap paramBitmap) {
    ak.a("gdt_tag_callback", "onPageStarted(url, favicon)");
    ak.b(h, "onPageStarted : url = %s", new Object[] { paramString });
    this.g.setVisibility(0);
  }
  
  public void b(String paramString) {
    ak.a("gdt_tag_callback", "onReceivedTitle(title)");
    HybridADSetting hybridADSetting = this.c;
    if (hybridADSetting == null || TextUtils.isEmpty(hybridADSetting.getTitle()))
      this.e.c().setText(paramString); 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    ak.a("gdt_tag_callback", "onActivityResult(requestCode, resultCode, data)");
  }
  
  public void onAfterCreate(Bundle paramBundle) {
    ak.a("gdt_tag_callback", "onAfterCreate(savedInstanceState)");
    this.b = b.a(this.a.getIntent().getIntExtra("id", 0));
    this.c = (HybridADSetting)this.a.getIntent().getParcelableExtra("setting");
    String str = this.a.getIntent().getStringExtra("url");
    if (this.b == null || this.c == null || TextUtils.isEmpty(str)) {
      GDTLogger.e("HybridAD activity fail to create");
    } else {
      a();
      if (this.c.getType() != 1) {
        GDTLogger.e("unknow HybridAD type");
        a(4001);
      } else {
        a a1 = new a();
        this.f.d().a(a1.a(), (c)a1);
        this.f.loadUrl(str);
        u.a(21042, 2, null);
        return;
      } 
    } 
    this.a.finish();
  }
  
  public void onBackPressed() {
    ak.a("gdt_tag_callback", "onBackPressed()");
    b();
  }
  
  public void onBeforeCreate(Bundle paramBundle) {
    ak.a("gdt_tag_callback", "onBeforeCreate(savedInstanceState)");
    this.a.requestWindowFeature(1);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131755009) {
      if (i != 2131755011)
        return; 
      c();
      i = 21062;
    } else {
      b();
      i = 21052;
    } 
    u.a(i, 0, null);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    ak.a("gdt_tag_callback", "onConfigurationChanged(newConfig)");
  }
  
  public void onDestroy() {
    ak.a("gdt_tag_callback", "onDestroy()");
    com.qq.e.comm.plugin.ab.e.a a1 = this.f;
    if (a1 != null)
      a1.b(); 
    y.a(null);
  }
  
  public void onPause() {
    ak.a("gdt_tag_callback", "onPause()");
  }
  
  public void onResume() {
    ak.a("gdt_tag_callback", "onResume()");
  }
  
  public void onStop() {
    ak.a("gdt_tag_callback", "onStop()");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\o\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */