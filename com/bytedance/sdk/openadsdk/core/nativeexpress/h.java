package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import java.util.Locale;

class h extends BackupView {
  private static i[] j = new i[] { new i(2, 3.0241935F, 375, 124), new i(3, 1.25F, 375, 300), new i(4, 1.4044944F, 375, 267), new i(16, 1.25F, 375, 300), new i(5, 1.25F, 375, 300), new i(15, 1.25F, 375, 300) };
  
  boolean h = true;
  
  boolean i = true;
  
  private int k;
  
  private View l;
  
  private NativeExpressView m;
  
  private a n;
  
  public h(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
  }
  
  private i a(int paramInt) {
    i[] arrayOfI = j;
    int j = 0;
    i i1 = arrayOfI[0];
    try {
      int k = arrayOfI.length;
      return i1;
    } finally {
      arrayOfI = null;
    } 
  }
  
  private void a(ImageView paramImageView) {
    String str = ((j)this.b.F().get(0)).a();
    e.a(this.a).a(str, paramImageView);
  }
  
  private void b(int paramInt) {
    this.i = o.h().a(this.k);
    paramInt = o.h().c(paramInt);
    if (3 == paramInt) {
      this.h = false;
      return;
    } 
    if (1 == paramInt && w.d(this.a)) {
      this.h = true;
      return;
    } 
    if (2 == paramInt && (w.e(this.a) || w.d(this.a)))
      this.h = true; 
  }
  
  private void c() {
    i i1 = a(this.b.Q());
    this.f = ai.c(this.a, this.m.getExpectExpressWidth());
    this.g = ai.c(this.a, this.m.getExpectExpressHeight());
    if (this.f <= 0)
      this.f = ai.c(this.a); 
    if (this.g <= 0)
      this.g = Float.valueOf(this.f / i1.b).intValue(); 
    if (this.f > 0 && this.f > ai.c(this.a)) {
      float f = ai.c(this.a) / this.f;
      this.f = ai.c(this.a);
      this.g = Float.valueOf(this.g * f).intValue();
    } 
    ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
    ViewGroup.LayoutParams layoutParams1 = layoutParams2;
    if (layoutParams2 == null)
      layoutParams1 = new ViewGroup.LayoutParams(this.f, this.g); 
    layoutParams1.width = this.f;
    layoutParams1.height = this.g;
    if (layoutParams1 instanceof FrameLayout.LayoutParams)
      ((FrameLayout.LayoutParams)layoutParams1).gravity = 17; 
    setLayoutParams(layoutParams1);
    if (ah.c(this.b.P()) == 9) {
      this.e = "draw_ad";
      h();
      return;
    } 
    this.e = "embeded_ad";
    int j = this.b.Q();
    if (j != 2) {
      if (j != 3) {
        if (j != 4) {
          if (j != 5) {
            if (j != 15) {
              if (j != 16)
                return; 
              j();
              return;
            } 
            g();
            return;
          } 
          i();
          return;
        } 
        e();
        return;
      } 
      f();
      return;
    } 
    d();
  }
  
  private void d() {
    this.l = LayoutInflater.from(this.a).inflate(ab.f(this.a, "tt_backup_feed_img_small"), (ViewGroup)this, true);
    ImageView imageView1 = (ImageView)this.l.findViewById(ab.e(this.a, "tt_bu_img"));
    ImageView imageView2 = (ImageView)this.l.findViewById(ab.e(this.a, "tt_bu_close"));
    TextView textView1 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_desc"));
    TextView textView2 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_title"));
    a(imageView1);
    textView1.setText(getDescription());
    textView2.setText(getTitle());
    imageView2.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a();
          }
        });
    a((View)this, true);
  }
  
  private void e() {
    this.l = LayoutInflater.from(this.a).inflate(ab.f(this.a, "tt_backup_feed_img_group"), (ViewGroup)this, true);
    ImageView imageView1 = (ImageView)this.l.findViewById(ab.e(this.a, "tt_bu_img_1"));
    ImageView imageView2 = (ImageView)this.l.findViewById(ab.e(this.a, "tt_bu_img_2"));
    ImageView imageView3 = (ImageView)this.l.findViewById(ab.e(this.a, "tt_bu_img_3"));
    ImageView imageView4 = (ImageView)this.l.findViewById(ab.e(this.a, "tt_bu_icon"));
    ImageView imageView5 = (ImageView)this.l.findViewById(ab.e(this.a, "tt_bu_close"));
    TextView textView1 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_desc"));
    TextView textView2 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_title"));
    TextView textView3 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_download"));
    String str1 = ((j)this.b.F().get(0)).a();
    String str2 = ((j)this.b.F().get(1)).a();
    String str3 = ((j)this.b.F().get(2)).a();
    e.a(this.a).a(str1, imageView1);
    e.a(this.a).a(str2, imageView2);
    e.a(this.a).a(str3, imageView3);
    e.a(this.a).a(this.b.C().a(), imageView4);
    imageView5.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a();
          }
        });
    textView1.setText(getDescription());
    textView2.setText(getTitle());
    if (!TextUtils.isEmpty(this.b.L()))
      textView3.setText(this.b.L()); 
    a((View)this, false);
    a((View)textView3, true);
  }
  
  private void f() {
    this.l = LayoutInflater.from(this.a).inflate(ab.f(this.a, "tt_backup_feed_horizontal"), (ViewGroup)this, true);
    this.l.findViewById(ab.e(this.a, "tt_bu_video_container")).setVisibility(8);
    this.l.findViewById(ab.e(this.a, "tt_bu_img_container")).setVisibility(0);
    ImageView imageView1 = (ImageView)this.l.findViewById(ab.e(this.a, "tt_bu_img"));
    ImageView imageView2 = (ImageView)this.l.findViewById(ab.e(this.a, "tt_bu_close"));
    TextView textView1 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_desc"));
    TextView textView2 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_title"));
    TextView textView3 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_download"));
    imageView1.setAdjustViewBounds(true);
    imageView1.setMaxHeight(this.g);
    a(imageView1);
    imageView2.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a();
          }
        });
    textView1.setText(getDescription());
    textView2.setText(getTitle());
    if (!TextUtils.isEmpty(this.b.L()))
      textView3.setText(this.b.L()); 
    a((View)this, false);
    a((View)textView3, true);
  }
  
  private void g() {
    int j;
    this.l = LayoutInflater.from(this.a).inflate(ab.f(this.a, "tt_backup_feed_vertical"), (ViewGroup)this, true);
    this.l.findViewById(ab.e(this.a, "tt_bu_video_container")).setVisibility(0);
    this.l.findViewById(ab.e(this.a, "tt_bu_img_container")).setVisibility(8);
    FrameLayout frameLayout = (FrameLayout)this.l.findViewById(ab.e(this.a, "tt_bu_video_container_inner"));
    ImageView imageView1 = (ImageView)this.l.findViewById(ab.e(this.a, "tt_bu_video_icon"));
    ImageView imageView2 = (ImageView)this.l.findViewById(ab.e(this.a, "tt_bu_close"));
    TextView textView2 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_desc"));
    TextView textView3 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_title"));
    TextView textView4 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_video_name1"));
    TextView textView5 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_video_name2"));
    TextView textView1 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_download"));
    TextView textView6 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_video_score"));
    TTRatingBar tTRatingBar = (TTRatingBar)this.l.findViewById(ab.e(this.a, "tt_bu_video_score_bar"));
    e.a(this.a).a(this.b.C().a(), imageView1);
    imageView2.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a();
          }
        });
    if (this.b.N() != null) {
      j = this.b.N().e();
    } else {
      j = 4;
    } 
    textView6.setText(String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf(j) }));
    tTRatingBar.setStarEmptyNum(1);
    tTRatingBar.setStarFillNum(j);
    tTRatingBar.setStarImageWidth(ai.c(this.a, 15.0F));
    tTRatingBar.setStarImageHeight(ai.c(this.a, 14.0F));
    tTRatingBar.setStarImagePadding(ai.c(this.a, 4.0F));
    tTRatingBar.a();
    textView4.setText(getNameOrSource());
    textView5.setText(getTitle());
    textView2.setText(getDescription());
    textView3.setText(getTitle());
    if (!TextUtils.isEmpty(this.b.L()))
      textView1.setText(this.b.L()); 
    View view = b();
    if (view != null) {
      j = this.f * 123 / 375;
      int k = j * 16 / 9;
      frameLayout.removeAllViews();
      frameLayout.addView(view, new ViewGroup.LayoutParams(j, k));
    } 
    a((View)this, false);
    a((View)textView1, true);
  }
  
  private void h() {
    this.l = LayoutInflater.from(this.a).inflate(ab.f(this.a, "tt_backup_draw"), (ViewGroup)this, true);
    FrameLayout frameLayout = (FrameLayout)this.l.findViewById(ab.e(this.a, "tt_bu_video_container"));
    TextView textView1 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_desc"));
    TextView textView2 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_title"));
    TextView textView3 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_download"));
    textView1.setText(getDescription());
    textView2.setText(getTitle());
    if (!TextUtils.isEmpty(this.b.L()))
      textView3.setText(this.b.L()); 
    View view = b();
    if (view != null) {
      frameLayout.removeAllViews();
      frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
    } 
    a((View)textView2, false);
    a((View)textView1, false);
    a((View)textView3, true);
  }
  
  private void i() {
    this.l = LayoutInflater.from(this.a).inflate(ab.f(this.a, "tt_backup_feed_horizontal"), (ViewGroup)this, true);
    FrameLayout frameLayout = (FrameLayout)this.l.findViewById(ab.e(this.a, "tt_bu_video_container"));
    frameLayout.setVisibility(0);
    this.l.findViewById(ab.e(this.a, "tt_bu_img_container")).setVisibility(8);
    ImageView imageView = (ImageView)this.l.findViewById(ab.e(this.a, "tt_bu_close"));
    TextView textView2 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_desc"));
    TextView textView3 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_title"));
    TextView textView1 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_download"));
    imageView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a();
          }
        });
    textView2.setText(getDescription());
    textView3.setText(getTitle());
    if (!TextUtils.isEmpty(this.b.L()))
      textView1.setText(this.b.L()); 
    View view = b();
    if (view != null) {
      frameLayout.removeAllViews();
      frameLayout.addView(view, new ViewGroup.LayoutParams(this.f, this.f * 9 / 16));
    } 
    a((View)this, false);
    a((View)textView1, true);
  }
  
  private void j() {
    this.l = LayoutInflater.from(this.a).inflate(ab.f(this.a, "tt_backup_feed_vertical"), (ViewGroup)this, true);
    this.l.findViewById(ab.e(this.a, "tt_bu_video_container")).setVisibility(8);
    this.l.findViewById(ab.e(this.a, "tt_bu_img_container")).setVisibility(0);
    ImageView imageView1 = (ImageView)this.l.findViewById(ab.e(this.a, "tt_bu_img"));
    ImageView imageView2 = (ImageView)this.l.findViewById(ab.e(this.a, "tt_bu_close"));
    TextView textView1 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_desc"));
    TextView textView2 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_title"));
    TextView textView3 = (TextView)this.l.findViewById(ab.e(this.a, "tt_bu_download"));
    a(imageView1);
    imageView2.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a();
          }
        });
    textView1.setText(getDescription());
    textView2.setText(getTitle());
    if (!TextUtils.isEmpty(this.b.L()))
      textView3.setText(this.b.L()); 
    a((View)this, false);
    a((View)textView3, true);
  }
  
  private boolean k() {
    return (this.b != null && (this.b.Q() == 5 || this.b.Q() == 15));
  }
  
  protected void a(int paramInt, i parami) {
    NativeExpressView nativeExpressView = this.m;
    if (nativeExpressView != null)
      nativeExpressView.a(paramInt, parami); 
  }
  
  void a(k paramk, NativeExpressView paramNativeExpressView, a parama) {
    t.b("FeedExpressBackupView", "show backup view");
    setBackgroundColor(-1);
    this.b = paramk;
    this.m = paramNativeExpressView;
    this.n = parama;
    this.k = ah.d(this.b.P());
    b(this.k);
    c();
    this.m.addView((View)this, new ViewGroup.LayoutParams(-2, -2));
  }
  
  public View b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   4: ifnull -> 97
    //   7: aload_0
    //   8: getfield a : Landroid/content/Context;
    //   11: ifnonnull -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: invokespecial k : ()Z
    //   20: ifeq -> 70
    //   23: new com/bytedance/sdk/openadsdk/core/video/nativevideo/NativeVideoTsView
    //   26: dup
    //   27: aload_0
    //   28: getfield a : Landroid/content/Context;
    //   31: aload_0
    //   32: getfield b : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   35: invokespecial <init> : (Landroid/content/Context;Lcom/bytedance/sdk/openadsdk/core/d/k;)V
    //   38: astore_1
    //   39: aload_1
    //   40: new com/bytedance/sdk/openadsdk/core/nativeexpress/h$7
    //   43: dup
    //   44: aload_0
    //   45: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/nativeexpress/h;)V
    //   48: invokevirtual setControllerStatusCallBack : (Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/NativeVideoTsView$a;)V
    //   51: aload_1
    //   52: aload_0
    //   53: getfield h : Z
    //   56: invokevirtual setIsAutoPlay : (Z)V
    //   59: aload_1
    //   60: aload_0
    //   61: getfield i : Z
    //   64: invokevirtual setIsQuiet : (Z)V
    //   67: goto -> 72
    //   70: aconst_null
    //   71: astore_1
    //   72: aload_0
    //   73: invokespecial k : ()Z
    //   76: ifeq -> 97
    //   79: aload_1
    //   80: ifnull -> 97
    //   83: aload_1
    //   84: lconst_0
    //   85: iconst_1
    //   86: iconst_0
    //   87: invokevirtual a : (JZZ)Z
    //   90: ifne -> 95
    //   93: aconst_null
    //   94: areturn
    //   95: aload_1
    //   96: areturn
    //   97: aconst_null
    //   98: areturn
    //   99: astore_1
    //   100: goto -> 70
    // Exception table:
    //   from	to	target	type
    //   23	67	99	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\nativeexpress\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */