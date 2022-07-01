package com.bytedance.sdk.openadsdk.core.bannerexpress;

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
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ai;
import java.util.Locale;

public class BannerExpressBackupView extends BackupView {
  private static i[] h = new i[] { new i(1, 6.6666665F, 600, 90), new i(1, 6.4F, 640, 100), new i(1, 4.0F, 600, 150), new i(2, 1.2F, 600, 500), new i(3, 1.5F, 600, 400), new i(3, 2.0F, 600, 300), new i(3, 2.3076923F, 600, 260), new i(3, 1.7783505F, 690, 388) };
  
  private View i;
  
  private NativeExpressView j;
  
  private a k;
  
  private int l = 1;
  
  public BannerExpressBackupView(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
  }
  
  private i a(int paramInt1, int paramInt2) {
    float f = paramInt1;
    try {
      float f1 = Float.valueOf(f).floatValue() / Float.valueOf(paramInt2).floatValue();
      i i1 = h[0];
      i[] arrayOfI = h;
      paramInt2 = arrayOfI.length;
      paramInt1 = 0;
      return i1;
    } finally {
      Exception exception = null;
    } 
  }
  
  private void a(ImageView paramImageView) {
    String str = ((j)this.b.F().get(0)).a();
    e.a(this.a).a(str, paramImageView);
  }
  
  private void b() {
    i i1 = a(this.j.getExpectExpressWidth(), this.j.getExpectExpressHeight());
    if (this.j.getExpectExpressWidth() > 0 && this.j.getExpectExpressHeight() > 0) {
      if (this.j.getExpectExpressWidth() > this.j.getExpectExpressHeight()) {
        this.f = ai.c(this.a, this.j.getExpectExpressHeight() * i1.b);
        this.g = ai.c(this.a, this.j.getExpectExpressHeight());
      } else {
        this.f = ai.c(this.a, this.j.getExpectExpressWidth());
        this.g = ai.c(this.a, this.j.getExpectExpressWidth() / i1.b);
      } 
    } else if (this.j.getExpectExpressWidth() > 0 && this.j.getExpectExpressHeight() <= 0) {
      this.f = ai.c(this.a, this.j.getExpectExpressWidth());
      this.g = Float.valueOf(this.f / i1.b).intValue();
    } else if (this.j.getExpectExpressWidth() <= 0 && this.j.getExpectExpressHeight() > 0) {
      this.g = ai.c(this.a, this.j.getExpectExpressHeight());
      this.f = Float.valueOf(this.g * i1.b).intValue();
    } else {
      this.f = ai.c(this.a);
      this.g = Float.valueOf(this.f / i1.b).intValue();
    } 
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
    if (i1.a == 1) {
      e();
      return;
    } 
    if (i1.a == 2) {
      d();
      return;
    } 
    if (i1.a == 3) {
      c();
      return;
    } 
    e();
  }
  
  private void c() {
    this.i = LayoutInflater.from(this.a).inflate(ab.f(this.a, "tt_backup_banner_layout3"), (ViewGroup)this, true);
    View view = this.i.findViewById(ab.e(this.a, "tt_bu_close"));
    ImageView imageView1 = (ImageView)this.i.findViewById(ab.e(this.a, "tt_bu_img"));
    ImageView imageView2 = (ImageView)this.i.findViewById(ab.e(this.a, "tt_bu_icon"));
    TextView textView1 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_title"));
    TextView textView2 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_desc"));
    TextView textView3 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_name"));
    TextView textView4 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_download"));
    view.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a();
          }
        });
    int j = (int)ai.a(this.a, 15.0F);
    ai.a(view, j, j, j, j);
    a(imageView1);
    e.a(this.a).a(this.b.C().a(), imageView2);
    textView3.setText(getNameOrSource());
    textView1.setText(String.format(Locale.getDefault(), "%s提供的广告", new Object[] { getNameOrSource() }));
    textView2.setText(getDescription());
    if (!TextUtils.isEmpty(this.b.L()))
      textView4.setText(this.b.L()); 
    a((View)this, false);
    a((View)textView4, true);
  }
  
  private void d() {
    this.i = LayoutInflater.from(this.a).inflate(ab.f(this.a, "tt_backup_banner_layout2"), (ViewGroup)this, true);
    View view = this.i.findViewById(ab.e(this.a, "tt_bu_close"));
    ImageView imageView1 = (ImageView)this.i.findViewById(ab.e(this.a, "tt_bu_img"));
    ImageView imageView2 = (ImageView)this.i.findViewById(ab.e(this.a, "tt_bu_icon"));
    TextView textView1 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_title"));
    TextView textView2 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_desc"));
    TextView textView3 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_download"));
    view.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a();
          }
        });
    int j = (int)ai.a(this.a, 15.0F);
    ai.a(view, j, j, j, j);
    a(imageView1);
    e.a(this.a).a(this.b.C().a(), imageView2);
    textView1.setText(getTitle());
    textView2.setText(getDescription());
    if (!TextUtils.isEmpty(this.b.L()))
      textView3.setText(this.b.L()); 
    a((View)this, false);
    a((View)textView3, true);
  }
  
  private void e() {
    byte b;
    this.i = LayoutInflater.from(this.a).inflate(ab.f(this.a, "tt_backup_banner_layout1"), (ViewGroup)this, true);
    View view = this.i.findViewById(ab.e(this.a, "tt_bu_close"));
    ImageView imageView = (ImageView)this.i.findViewById(ab.e(this.a, "tt_bu_icon"));
    TextView textView1 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_title"));
    TextView textView2 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_score"));
    TTRatingBar tTRatingBar = (TTRatingBar)this.i.findViewById(ab.e(this.a, "tt_bu_score_bar"));
    TextView textView3 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_download"));
    view.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a();
          }
        });
    e.a(this.a).a(this.b.C().a(), imageView);
    textView1.setText(getTitle());
    if (!TextUtils.isEmpty(this.b.L()))
      textView3.setText(this.b.L()); 
    if (this.b.N() != null) {
      b = this.b.N().e();
    } else {
      b = 4;
    } 
    textView2.setText(String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf(b) }));
    tTRatingBar.setStarEmptyNum(1);
    tTRatingBar.setStarFillNum(b);
    tTRatingBar.setStarImageWidth(ai.c(this.a, 15.0F));
    tTRatingBar.setStarImageHeight(ai.c(this.a, 14.0F));
    tTRatingBar.setStarImagePadding(ai.c(this.a, 4.0F));
    tTRatingBar.a();
    a((View)this, false);
    a((View)textView3, true);
  }
  
  public void a(int paramInt, i parami) {
    NativeExpressView nativeExpressView = this.j;
    if (nativeExpressView != null)
      nativeExpressView.a(paramInt, parami); 
  }
  
  void a(k paramk, NativeExpressView paramNativeExpressView, a parama) {
    setBackgroundColor(-1);
    this.b = paramk;
    this.j = paramNativeExpressView;
    this.k = parama;
    this.e = "banner_ad";
    this.j.addView((View)this, new ViewGroup.LayoutParams(-2, -2));
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\bannerexpress\BannerExpressBackupView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */