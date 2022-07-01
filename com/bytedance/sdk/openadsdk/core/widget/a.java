package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ab;

public class a extends Dialog {
  public a a;
  
  private ImageView b;
  
  private TextView c;
  
  private TextView d;
  
  private Button e;
  
  private Button f;
  
  private View g;
  
  private Context h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private String l;
  
  private int m = -1;
  
  private boolean n = false;
  
  public a(Context paramContext) {
    super(paramContext, ab.g(paramContext, "tt_custom_dialog"));
    this.h = paramContext;
  }
  
  private void a() {
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.a != null)
              this.a.a.a(); 
          }
        });
    this.e.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.a != null)
              this.a.a.b(); 
          }
        });
  }
  
  private void b() {
    if (!TextUtils.isEmpty(this.j)) {
      this.c.setText(this.j);
      this.c.setVisibility(0);
    } else {
      this.c.setVisibility(8);
    } 
    if (!TextUtils.isEmpty(this.i))
      this.d.setText(this.i); 
    if (!TextUtils.isEmpty(this.k)) {
      this.f.setText(this.k);
    } else {
      this.f.setText("确定");
    } 
    if (!TextUtils.isEmpty(this.l)) {
      this.e.setText(this.l);
    } else {
      this.e.setText("取消");
    } 
    int i = this.m;
    if (i != -1) {
      this.b.setImageResource(i);
      this.b.setVisibility(0);
    } else {
      this.b.setVisibility(8);
    } 
    if (this.n) {
      this.g.setVisibility(8);
      this.e.setVisibility(8);
      return;
    } 
    this.e.setVisibility(0);
    this.g.setVisibility(0);
  }
  
  private void c() {
    this.e = (Button)findViewById(ab.e(this.h, "tt_negtive"));
    this.f = (Button)findViewById(ab.e(this.h, "tt_positive"));
    this.c = (TextView)findViewById(ab.e(this.h, "tt_title"));
    this.d = (TextView)findViewById(ab.e(this.h, "tt_message"));
    this.b = (ImageView)findViewById(ab.e(this.h, "tt_image"));
    this.g = findViewById(ab.e(this.h, "tt_column_line"));
  }
  
  public a a(a parama) {
    this.a = parama;
    return this;
  }
  
  public a a(String paramString) {
    this.i = paramString;
    return this;
  }
  
  public a b(String paramString) {
    this.k = paramString;
    return this;
  }
  
  public a c(String paramString) {
    this.l = paramString;
    return this;
  }
  
  public void onBackPressed() {}
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(ab.f(this.h, "tt_custom_dailog_layout"));
    setCanceledOnTouchOutside(false);
    c();
    b();
    a();
  }
  
  public void show() {
    super.show();
    b();
  }
  
  public static interface a {
    void a();
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */