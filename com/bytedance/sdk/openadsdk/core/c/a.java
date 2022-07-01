package com.bytedance.sdk.openadsdk.core.c;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ai;

class a extends BackupView {
  private static i[] h = new i[] { new i(1, 1.0F, 300, 300), new i(2, 0.6666667F, 300, 450), new i(3, 1.5F, 300, 200) };
  
  private View i;
  
  private NativeExpressView j;
  
  private com.bytedance.sdk.openadsdk.downloadnew.core.a k;
  
  private int l = 1;
  
  private Dialog m;
  
  public a(Context paramContext) {
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
  
  private void a(View paramView) {
    if (paramView == null)
      return; 
    paramView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (a.a(this.a) != null)
              a.a(this.a).dismiss(); 
          }
        });
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
    } else {
      this.f = ai.c(this.a, i1.c);
      this.g = ai.c(this.a, i1.d);
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
    setLayoutParams(layoutParams1);
    if (i1.a == 1) {
      c();
      return;
    } 
    if (i1.a == 2) {
      d();
      return;
    } 
    if (i1.a == 3) {
      e();
      return;
    } 
    c();
  }
  
  private void c() {
    this.i = LayoutInflater.from(this.a).inflate(ab.f(this.a, "tt_backup_insert_layout1"), (ViewGroup)this, true);
    ImageView imageView1 = (ImageView)this.i.findViewById(ab.e(this.a, "tt_bu_img"));
    View view = this.i.findViewById(ab.e(this.a, "tt_bu_close"));
    ImageView imageView2 = (ImageView)this.i.findViewById(ab.e(this.a, "tt_bu_icon"));
    TextView textView1 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_title"));
    TextView textView2 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_desc"));
    TextView textView3 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_download"));
    int j = (int)ai.a(this.a, 15.0F);
    ai.a(view, j, j, j, j);
    a(view);
    if (!TextUtils.isEmpty(this.b.L()))
      textView3.setText(this.b.L()); 
    a(imageView1);
    e.a(this.a).a(this.b.C().a(), imageView2);
    textView1.setText(getTitle());
    textView2.setText(getDescription());
    a((View)this, false);
    a((View)textView3, true);
  }
  
  private void d() {
    this.i = LayoutInflater.from(this.a).inflate(ab.f(this.a, "tt_backup_insert_layout2"), (ViewGroup)this, true);
    ImageView imageView1 = (ImageView)this.i.findViewById(ab.e(this.a, "tt_bu_img"));
    View view = this.i.findViewById(ab.e(this.a, "tt_bu_close"));
    ImageView imageView2 = (ImageView)this.i.findViewById(ab.e(this.a, "tt_bu_icon"));
    TextView textView1 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_title"));
    TextView textView2 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_desc"));
    TextView textView3 = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_download"));
    int j = (int)ai.a(this.a, 15.0F);
    ai.a(view, j, j, j, j);
    a(view);
    if (!TextUtils.isEmpty(this.b.L()))
      textView3.setText(this.b.L()); 
    a(imageView1);
    e.a(this.a).a(this.b.C().a(), imageView2);
    textView1.setText(getTitle());
    textView2.setText(getDescription());
    a((View)this, false);
    a((View)textView3, true);
  }
  
  private void e() {
    this.i = LayoutInflater.from(this.a).inflate(ab.f(this.a, "tt_backup_insert_layout3"), (ViewGroup)this, true);
    ImageView imageView = (ImageView)this.i.findViewById(ab.e(this.a, "tt_bu_img"));
    View view = this.i.findViewById(ab.e(this.a, "tt_bu_close"));
    TextView textView = (TextView)this.i.findViewById(ab.e(this.a, "tt_bu_desc"));
    int j = (int)ai.a(this.a, 15.0F);
    ai.a(view, j, j, j, j);
    a(view);
    a(imageView);
    textView.setText(getDescription());
    a((View)this, false);
    a(this.i, true);
  }
  
  public void a(int paramInt, i parami) {
    NativeExpressView nativeExpressView = this.j;
    if (nativeExpressView != null)
      nativeExpressView.a(paramInt, parami); 
  }
  
  public void a(Dialog paramDialog) {
    this.m = paramDialog;
  }
  
  void a(k paramk, NativeExpressView paramNativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a parama) {
    setBackgroundColor(-1);
    this.b = paramk;
    this.j = paramNativeExpressView;
    this.k = parama;
    this.e = "interaction";
    this.j.addView((View)this, new ViewGroup.LayoutParams(-2, -2));
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */