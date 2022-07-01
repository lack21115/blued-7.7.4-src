package com.qq.e.comm.plugin.gdtnativead.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.qq.e.comm.plugin.ac.h;
import com.qq.e.comm.plugin.ad.j;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONArray;
import org.json.JSONObject;

public class b extends FrameLayout {
  private static final int a = Color.parseColor("#909090");
  
  private static final int b = Color.parseColor("#909090");
  
  private static final int c = Color.parseColor("#D5D5D6");
  
  private static final int d = Color.parseColor("#00C634");
  
  private static final int e = Color.parseColor("#3185FC");
  
  private ScrollView f;
  
  private LinearLayout g;
  
  private ImageView h;
  
  private TextView i;
  
  private TextView j;
  
  private TextView k;
  
  private TextView l;
  
  private TextView m;
  
  private h n;
  
  private TextView o;
  
  private Context p;
  
  private int q;
  
  private HorizontalScrollView r;
  
  private FrameLayout s;
  
  private int t;
  
  private long u;
  
  private JSONObject v;
  
  private j w;
  
  private a x;
  
  private r y;
  
  public b(Context paramContext, j paramj, JSONObject paramJSONObject) {
    super(paramContext);
    this.p = paramContext.getApplicationContext();
    this.v = paramJSONObject;
    this.w = paramj;
    this.q = paramJSONObject.optInt("producttype");
    if (paramj != null && paramj.h() == 32)
      this.t = paramj.f(); 
    this.y = new r(paramContext);
    a();
  }
  
  private void a() {
    if (this.f == null)
      this.f = new ScrollView(this, getContext()) {
          protected void onScrollChanged(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
            Runnable runnable;
            super.onScrollChanged(param1Int1, param1Int2, param1Int3, param1Int4);
            if (b.a(this.a) == null)
              return; 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onScrollChanged, ");
            stringBuilder.append(param1Int1);
            stringBuilder.append(", ");
            stringBuilder.append(param1Int2);
            GDTLogger.d(stringBuilder.toString());
            if (param1Int2 <= 0 && b.a(this.a).getVisibility() != 4) {
              runnable = new Runnable(this) {
                  public void run() {
                    if (b.a(this.a.a) != null)
                      b.a(this.a.a).setVisibility(4); 
                  }
                };
            } else if (param1Int2 > 0 && b.a(this.a).getVisibility() != 0) {
              runnable = new Runnable(this) {
                  public void run() {
                    if (b.a(this.a.a) != null)
                      b.a(this.a.a).setVisibility(0); 
                  }
                };
            } else {
              return;
            } 
            post(runnable);
          }
        }; 
    this.f.setVisibility(0);
    this.f.setBackgroundColor(-1);
    this.f.setVerticalScrollBarEnabled(false);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.bottomMargin = am.a(this.p, 50);
    addView((View)this.f, (ViewGroup.LayoutParams)layoutParams);
    if (this.s == null) {
      this.s = new FrameLayout(getContext());
      GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { Integer.MIN_VALUE, 1073741824, 0 });
      FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, am.a(this.p, 5));
      this.s.setBackgroundDrawable((Drawable)gradientDrawable);
      this.s.setVisibility(4);
      addView((View)this.s, (ViewGroup.LayoutParams)layoutParams1);
    } 
    if (this.n == null) {
      this.n = new h(getContext());
      this.n.a(true);
      this.n.b(100);
      this.n.a(this.w.f());
      this.n.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (b.b(this.a) != null && !b.c(this.a) && b.d(this.a).a())
                b.b(this.a).c(false); 
            }
          });
      layoutParams = new FrameLayout.LayoutParams(-1, am.a(this.p, 50));
      layoutParams.gravity = 80;
      addView((View)this.n, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.o == null) {
      this.o = new TextView(getContext());
      layoutParams = new FrameLayout.LayoutParams(-1, am.a(this.p, 50));
      layoutParams.gravity = 81;
      this.o.setGravity(17);
      b(this.w.f(), this.w.h());
      this.o.setTextSize(2, 17.0F);
      this.o.setTextColor(-1);
      addView((View)this.o, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.g == null) {
      this.g = new LinearLayout(getContext());
      this.g.setOrientation(1);
      layoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.g.setBackgroundColor(-1);
      this.f.addView((View)this.g, (ViewGroup.LayoutParams)layoutParams);
    } 
    JSONArray jSONArray = this.v.optJSONArray("screenshot_url_list");
    if (this.q == 12 && jSONArray != null && jSONArray.length() > 0) {
      a(jSONArray);
      return;
    } 
    c();
  }
  
  private void a(JSONArray paramJSONArray) {
    RelativeLayout relativeLayout = new RelativeLayout(getContext());
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
    layoutParams2.topMargin = am.a(this.p, 24);
    this.g.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams2);
    relativeLayout.setPadding(am.a(this.p, 16), 0, am.a(this.p, 16), 0);
    if (this.h == null) {
      this.h = new ImageView(getContext());
      this.h.setId(33333);
      RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(am.a(this.p, 64), am.a(this.p, 64));
      layoutParams3.addRule(9);
      this.h.setBackgroundColor(c);
      com.qq.e.comm.plugin.p.a.a().a(this.w.j(), this.h);
      relativeLayout.addView((View)this.h, (ViewGroup.LayoutParams)layoutParams3);
    } 
    if (this.k == null) {
      this.k = new TextView(getContext());
      this.k.setId(33335);
      RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
      layoutParams3.addRule(1, 33333);
      layoutParams3.addRule(11);
      layoutParams3.addRule(10);
      layoutParams3.leftMargin = am.a(this.p, 16);
      layoutParams3.rightMargin = am.a(this.p, 16);
      this.k.setText(this.v.optString("txt"));
      this.k.setTextColor(-16777216);
      this.k.setTextSize(2, 17.0F);
      this.k.setMaxLines(1);
      relativeLayout.addView((View)this.k, (ViewGroup.LayoutParams)layoutParams3);
    } 
    if (this.l == null) {
      this.l = new TextView(getContext());
      RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams3.topMargin = am.a(this.p, 4);
      layoutParams3.leftMargin = am.a(this.p, 16);
      layoutParams3.rightMargin = am.a(this.p, 16);
      layoutParams3.addRule(1, 33333);
      layoutParams3.addRule(11);
      layoutParams3.addRule(3, 33335);
      this.l.setText(this.v.optString("desc"));
      this.l.setTextColor(a);
      this.l.setTextSize(2, 15.0F);
      this.l.setMaxLines(2);
      relativeLayout.addView((View)this.l, (ViewGroup.LayoutParams)layoutParams3);
    } 
    if (this.r == null)
      this.r = new HorizontalScrollView(getContext()); 
    this.r.setVisibility(0);
    this.r.setBackgroundColor(-1);
    this.r.setHorizontalScrollBarEnabled(false);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    layoutParams1.topMargin = am.a(this.p, 24);
    this.r.setPadding(am.a(this.p, 12), 0, am.a(this.p, 12), 0);
    this.g.addView((View)this.r, (ViewGroup.LayoutParams)layoutParams1);
    LinearLayout linearLayout = new LinearLayout(getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
    linearLayout.setOrientation(0);
    this.r.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
    for (int i = 0; i < paramJSONArray.length(); i++) {
      String str = paramJSONArray.optString(i);
      if (!TextUtils.isEmpty(str)) {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(am.a(this.p, 160), am.a(this.p, 285));
        layoutParams3.setMargins(am.a(this.p, 3), am.a(this.p, 0), am.a(this.p, 3), am.a(this.p, 8));
        imageView.setBackgroundColor(c);
        com.qq.e.comm.plugin.p.a.a().a(str, imageView);
        linearLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams3);
      } 
    } 
    if (this.i == null) {
      this.i = new TextView(getContext());
      LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
      layoutParams3.topMargin = am.a(this.p, 12);
      layoutParams3.leftMargin = am.a(this.p, 16);
      this.i.setText("版本");
      this.i.setTextColor(b);
      this.i.setTextSize(2, 15.0F);
      this.g.addView((View)this.i, (ViewGroup.LayoutParams)layoutParams3);
    } 
    if (this.m == null) {
      this.m = new TextView(getContext());
      this.m.setText(this.w.a());
      this.m.setTextColor(a);
      this.m.setTextSize(2, 15.0F);
      LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
      layoutParams3.leftMargin = am.a(this.p, 16);
      layoutParams3.topMargin = am.a(this.p, 4);
      layoutParams3.bottomMargin = am.a(this.p, 96);
      this.g.addView((View)this.m, (ViewGroup.LayoutParams)layoutParams3);
    } 
  }
  
  private void b(int paramInt1, int paramInt2) {
    TextView textView;
    String str = "下载";
    if (paramInt2 != 0) {
      if (paramInt2 != 1) {
        if (paramInt2 != 4)
          if (paramInt2 != 8) {
            if (paramInt2 != 16) {
              if (paramInt2 != 32) {
                if (paramInt2 != 128)
                  return; 
              } else {
                String str2;
                this.o.setBackgroundColor(0);
                TextView textView2 = this.o;
                if (paramInt1 > 0) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("继续下载 ");
                  stringBuilder.append(paramInt1);
                  stringBuilder.append("%");
                  str2 = stringBuilder.toString();
                } 
                textView2.setText(str2);
                return;
              } 
            } else {
              this.o.setBackgroundColor(e);
              TextView textView2 = this.o;
              String str2 = "下载失败，点击重试";
              textView2.setText(str2);
            } 
          } else {
            this.o.setBackgroundColor(d);
            TextView textView2 = this.o;
            String str2 = "立即安装";
            textView2.setText(str2);
          }  
        this.o.setBackgroundColor(0);
        textView = this.o;
        if (paramInt1 > 0) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("下载中 ");
          stringBuilder.append(paramInt1);
          stringBuilder.append("%");
          String str2 = stringBuilder.toString();
        } else {
          str = "下载中";
        } 
        textView.setText(str);
        return;
      } 
      this.o.setBackgroundColor(e);
      TextView textView1 = this.o;
      String str1 = "打开";
    } else {
      this.o.setBackgroundColor(e);
      textView = this.o;
      if (this.w.b() > 0L)
        str = String.format("下载（%.1fM）", new Object[] { Float.valueOf((float)this.w.b() / 1000000.0F) }); 
      textView.setText(str);
      return;
    } 
    str.setText((CharSequence)textView);
  }
  
  private boolean b() {
    long l = System.currentTimeMillis();
    if (l - this.u < 3000L)
      return true; 
    this.u = l;
    return false;
  }
  
  private void c() {
    if (this.h == null) {
      this.h = new ImageView(getContext());
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(am.a(this.p, 64), am.a(this.p, 64));
      layoutParams.gravity = 1;
      layoutParams.topMargin = am.a(this.p, 32);
      this.h.setBackgroundColor(c);
      com.qq.e.comm.plugin.p.a.a().a(this.w.j(), this.h);
      this.g.addView((View)this.h, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.k == null) {
      this.k = new TextView(getContext());
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
      layoutParams.gravity = 1;
      layoutParams.setMargins(am.a(this.p, 16), am.a(this.p, 16), am.a(this.p, 16), am.a(this.p, 16));
      this.k.setText(this.v.optString("txt"));
      this.k.setGravity(1);
      this.k.setTextColor(-16777216);
      this.k.setTextSize(2, 17.0F);
      this.g.addView((View)this.k, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.j == null) {
      this.j = new TextView(getContext());
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
      layoutParams.topMargin = am.a(this.p, 24);
      layoutParams.leftMargin = am.a(this.p, 16);
      this.j.setText("描述");
      this.j.setTextColor(b);
      this.j.setTextSize(2, 15.0F);
      this.g.addView((View)this.j, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.l == null) {
      this.l = new TextView(getContext());
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
      layoutParams.topMargin = am.a(this.p, 4);
      layoutParams.leftMargin = am.a(this.p, 16);
      layoutParams.rightMargin = am.a(this.p, 16);
      this.l.setText(this.v.optString("desc"));
      this.l.setTextColor(a);
      this.l.setTextSize(2, 15.0F);
      this.g.addView((View)this.l, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.i == null) {
      this.i = new TextView(getContext());
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
      layoutParams.topMargin = am.a(this.p, 12);
      layoutParams.leftMargin = am.a(this.p, 16);
      this.i.setText("版本");
      this.i.setTextColor(b);
      this.i.setTextSize(2, 15.0F);
      this.g.addView((View)this.i, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.m == null) {
      this.m = new TextView(getContext());
      this.m.setText(this.w.a());
      this.m.setTextColor(a);
      this.m.setTextSize(2, 15.0F);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
      layoutParams.leftMargin = am.a(this.p, 16);
      layoutParams.topMargin = am.a(this.p, 4);
      layoutParams.bottomMargin = am.a(this.p, 32);
      this.g.addView((View)this.m, (ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    if (paramInt2 == 32)
      this.t = paramInt1; 
    if (paramInt2 == 0 || paramInt2 == 8)
      this.t = 0; 
    h h1 = this.n;
    if (h1 != null) {
      int k = this.t;
      int i = k;
      if (paramInt1 >= k)
        i = paramInt1; 
      h1.a(i);
    } 
    if (this.o != null) {
      int i = this.t;
      if (paramInt1 < i)
        paramInt1 = i; 
      b(paramInt1, paramInt2);
    } 
  }
  
  public void a(a parama) {
    this.x = parama;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    this.y.a(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public static interface a {
    void c(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\gdtnativead\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */