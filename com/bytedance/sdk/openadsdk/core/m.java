package com.bytedance.sdk.openadsdk.core;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ai;

public class m extends Dialog {
  private View a;
  
  private Context b;
  
  private ImageView c;
  
  private ImageView d;
  
  private ImageView e;
  
  private TextView f;
  
  private FrameLayout g;
  
  private a h;
  
  private boolean i = false;
  
  public m(Context paramContext) {
    this(paramContext, 0);
  }
  
  public m(Context paramContext, int paramInt) {
    super(paramContext, i);
    this.b = paramContext;
  }
  
  private void a() {
    boolean bool = false;
    setCancelable(false);
    this.a = LayoutInflater.from(this.b).inflate(ab.f(this.b, "tt_insert_ad_layout"), null);
    setContentView(this.a);
    this.c = (ImageView)this.a.findViewById(ab.e(this.b, "tt_insert_ad_img"));
    this.d = (ImageView)this.a.findViewById(ab.e(this.b, "tt_insert_dislike_icon_img"));
    this.e = (ImageView)this.a.findViewById(ab.e(this.b, "tt_insert_ad_logo"));
    this.f = (TextView)this.a.findViewById(ab.e(this.b, "tt_insert_ad_text"));
    this.g = (FrameLayout)this.a.findViewById(ab.e(this.b, "tt_insert_express_ad_fl"));
    int i = ai.c(this.b);
    int j = i / 3;
    this.c.setMaxWidth(i);
    this.c.setMinimumWidth(j);
    this.c.setMinimumHeight(j);
    this.g.setMinimumWidth(j);
    this.g.setMinimumHeight(j);
    ImageView imageView = this.c;
    if (this.i) {
      i = 8;
    } else {
      i = 0;
    } 
    imageView.setVisibility(i);
    this.d.setVisibility(0);
    imageView = this.e;
    if (this.i) {
      i = 8;
    } else {
      i = 0;
    } 
    imageView.setVisibility(i);
    TextView textView = this.f;
    if (this.i) {
      i = 8;
    } else {
      i = 0;
    } 
    textView.setVisibility(i);
    FrameLayout frameLayout = this.g;
    if (this.i) {
      i = bool;
    } else {
      i = 8;
    } 
    frameLayout.setVisibility(i);
    i = (int)ai.a(this.b, 15.0F);
    ai.a((View)this.d, i, i, i, i);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (m.a(this.a) != null)
              m.a(this.a).a(param1View); 
          }
        });
  }
  
  private void b() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public void a(boolean paramBoolean, a parama) {
    this.i = paramBoolean;
    this.h = parama;
    a();
    parama = this.h;
    if (parama != null)
      parama.a(this.c, this.d, this.g); 
  }
  
  public void onBackPressed() {}
  
  public void show() {
    b();
    super.show();
  }
  
  public static interface a {
    void a(View param1View);
    
    void a(ImageView param1ImageView1, ImageView param1ImageView2, FrameLayout param1FrameLayout);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */