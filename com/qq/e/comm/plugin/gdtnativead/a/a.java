package com.qq.e.comm.plugin.gdtnativead.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import com.qq.e.comm.plugin.aa.b.g;
import com.qq.e.comm.plugin.ac.h;
import com.qq.e.comm.plugin.ac.j;
import com.qq.e.comm.plugin.ad.j;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.aq;
import com.qq.e.comm.plugin.util.ar;
import com.qq.e.comm.util.GDTLogger;

public class a extends RelativeLayout {
  private static final int a = Color.parseColor("#909090");
  
  private static final int b = Color.parseColor("#D5D5D6");
  
  private static final int c = Color.parseColor("#00C634");
  
  private static final int d = Color.parseColor("#3185FC");
  
  private j e;
  
  private TextView f;
  
  private TextView g;
  
  private h h;
  
  private TextView i;
  
  private Context j;
  
  private int k;
  
  private long l;
  
  private FrameLayout m;
  
  private RelativeLayout n;
  
  private ImageView o;
  
  private ImageView p;
  
  private ImageView q;
  
  private com.qq.e.comm.plugin.s.a r;
  
  private j s;
  
  private b.a t;
  
  private Space u;
  
  private a v;
  
  private r w;
  
  public a(Context paramContext, j paramj, com.qq.e.comm.plugin.s.a parama) {
    super(paramContext);
    this.j = paramContext.getApplicationContext();
    this.r = parama;
    this.s = paramj;
    b();
    this.w = new r(paramContext);
  }
  
  private FrameLayout a(int paramInt) {
    this.m = new FrameLayout(getContext());
    this.m.setId(33339);
    if (this.h == null) {
      this.h = new h(getContext());
      this.h.a(true);
      this.h.a(am.a(getContext(), paramInt));
      this.h.b(100);
      this.h.a(this.s.f());
      this.h.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (a.b(this.a) != null && !a.c(this.a) && a.d(this.a).a())
                a.b(this.a).c(false); 
            }
          });
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.m.addView((View)this.h, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.n == null) {
      float f;
      TextView textView;
      this.n = new RelativeLayout(getContext());
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.m.addView((View)this.n, (ViewGroup.LayoutParams)layoutParams);
      LinearLayout linearLayout = new LinearLayout(getContext());
      linearLayout.setOrientation(0);
      RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams2.addRule(13);
      this.n.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
      this.q = new ImageView(getContext());
      int i = g.a("gdt_ic_native_download");
      if (i == 0) {
        this.q.setImageBitmap(aq.a("iVBORw0KGgoAAAANSUhEUgAAACgAAAAoCAYAAACM/rhtAAAAAXNSR0IArs4c6QAAAi9JREFUWAntl78vZUEUx98lhAgSGpuQEMWuTqN5YbcQokMUCqUGiWRFoRKFRKUg0fkHNltsuYlKRLVaLxRKiYT4ET8iQuzzGe7IMS53mHk0c5KP+XXO95yc3HvfyGQ8WT6fb4JxaPAk6VeGwrZAWc6vsic1Cru+L+/hT4kn2UyRL6FC6YQCXTsbOhg66NoB1/jwDIYOunbANT48g947yGUkCwNQ6ipuE0+eCLqhM9UfpxbQtsakNjUodsD3zdctYirgD2jrMfOZz6DqWj52+s74j8hvZpCPNbr16KxDv9BLv0cSOAm3oO2ESZcQSZziY91BfNtgD6TNs4gSxc1NHHvhQkTfMB81/eSac6sC8RuES9Cm4oalltWcoFbY1SrxuMhYnCTAfmqB+MzAf9B2yORHkp7VHsFfYEOrxeNfxipTgL0XC+SsDH6BtG0WzabOm9eIlMNvqcw8B41SjHVigezXgXrZpK2wqJbxTnPE1LdqVmZgfgBZLcz8WYHsJT0mS+wnPiZa690jwkNwBdrUfEgJMj4pkHUfmC/a2LuT2waSNAv7IE11VxY4zVq+DFafKtsaUv1I3gibYGM7OH1NFfXtQNJKUG/0a7bKYY3v3NZ6JC8G9W1MsmU203+6rLM5OFLICNzEVaqfyQkHucKEUlQ7LEBHYTIE1dCB0IH0DvAG/oQj+Cw7J/GUrPTJFZvDUw6f3fVkwAfMz6IoeryKmf80zVHAxQcU8VKKYw5m5OEd4C2QlVmLW1QAAAAASUVORK5CYII="));
      } else {
        this.q.setImageResource(i);
      } 
      LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(am.a(this.j, 17), am.a(this.j, 20));
      layoutParams1.setMargins(0, 0, am.a(this.j, 8), 0);
      linearLayout.addView((View)this.q, (ViewGroup.LayoutParams)layoutParams1);
      this.i = new TextView(getContext());
      linearLayout.addView((View)this.i);
      this.i.setGravity(17);
      if (a()) {
        textView = this.i;
        f = 17.0F;
      } else {
        textView = this.i;
        f = 15.0F;
      } 
      textView.setTextSize(2, f);
      this.i.setTextColor(-1);
      a(this.s.f(), this.s.h(), paramInt);
    } 
    return this.m;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3) {
    TextView textView;
    StringBuilder stringBuilder2;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("setDownloadButtonText progress:");
    stringBuilder1.append(paramInt1);
    stringBuilder1.append(" status:");
    stringBuilder1.append(paramInt2);
    stringBuilder1.append(" pkg size:");
    stringBuilder1.append(this.s.b());
    GDTLogger.d(stringBuilder1.toString());
    if (paramInt2 != 0) {
      if (paramInt2 != 1) {
        if (paramInt2 != 4)
          if (paramInt2 != 8) {
            if (paramInt2 != 16) {
              if (paramInt2 != 32) {
                if (paramInt2 != 128)
                  return; 
              } else {
                this.n.setBackgroundColor(0);
                TextView textView2 = this.i;
                if (paramInt1 > 0) {
                  stringBuilder2 = new StringBuilder();
                  str1 = "继续下载 ";
                } else {
                  str1 = "继续下载";
                  textView2.setText(str1);
                } 
                stringBuilder2.append(str1);
                stringBuilder2.append(paramInt1);
                stringBuilder2.append("%");
                String str1 = stringBuilder2.toString();
              } 
            } else {
              this.n.setBackgroundDrawable((Drawable)ar.a(paramInt3, d, 255));
              TextView textView2 = this.i;
              String str1 = "下载失败，点击重试";
              textView2.setText(str1);
            } 
          } else {
            this.n.setBackgroundDrawable((Drawable)ar.a(paramInt3, c, 255));
            TextView textView2 = this.i;
            String str1 = "立即安装";
            textView2.setText(str1);
          }  
        this.n.setBackgroundColor(0);
        TextView textView1 = this.i;
        if (paramInt1 > 0) {
          stringBuilder2 = new StringBuilder();
          String str1 = "下载中...";
        } else {
          String str1 = "下载中";
          textView1.setText(str1);
        } 
      } else {
        this.n.setBackgroundDrawable((Drawable)ar.a(paramInt3, d, 255));
        TextView textView1 = this.i;
        String str1 = "打开";
        textView1.setText(str1);
      } 
    } else {
      String str1;
      this.n.setBackgroundDrawable((Drawable)ar.a(paramInt3, d, 255));
      textView = this.i;
      if (this.s.b() > 0L) {
        str1 = String.format("下载（%.1fM）", new Object[] { Float.valueOf((float)this.s.b() / 1000000.0F) });
      } else {
        str1 = "下载";
      } 
      textView.setText(str1);
      if (a()) {
        this.q.setVisibility(0);
        return;
      } 
      this.q.setVisibility(8);
    } 
    stringBuilder2.append((String)textView);
    stringBuilder2.append(paramInt1);
    stringBuilder2.append("%");
    String str = stringBuilder2.toString();
  }
  
  private boolean a() {
    return (this.r.P() > this.r.Q());
  }
  
  private void b() {
    c();
    this.u = new Space(getContext());
    this.u.setId(33337);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, am.b(getContext()) * this.r.Q() / this.r.P());
    layoutParams.addRule(13);
    this.u.setVisibility(4);
    addView((View)this.u, (ViewGroup.LayoutParams)layoutParams);
    if (a()) {
      e();
      return;
    } 
    d();
  }
  
  private void c() {
    int i = am.a(this.j, 32);
    int k = am.a(this.j, 20);
    int m = am.a(this.j, 16);
    int n = am.a(this.j, 16);
    if (this.o == null) {
      this.o = new ImageView(this.j);
      int i1 = g.a("gdt_ic_native_back");
      if (i1 == 0) {
        this.o.setImageBitmap(aq.a("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"));
      } else {
        this.o.setImageResource(i1);
      } 
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
      layoutParams.addRule(9);
      layoutParams.addRule(10);
      layoutParams.setMargins(m, k, 0, 0);
      addView((View)this.o, (ViewGroup.LayoutParams)layoutParams);
      this.o.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (a.a(this.a) != null)
                a.a(this.a).a(); 
            }
          });
    } 
    if (this.p == null) {
      this.p = new ImageView(this.j);
      a(false);
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
      layoutParams.addRule(11);
      layoutParams.addRule(10);
      layoutParams.setMargins(0, k, n, 0);
      addView((View)this.p, (ViewGroup.LayoutParams)layoutParams);
      this.p.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (a.a(this.a) != null)
                a.a(this.a).b(); 
            }
          });
    } 
  }
  
  private void d() {
    int i = am.a(this.j, 40);
    int k = am.a(this.j, 8);
    int m = am.a(this.j, 16);
    int n = am.a(this.j, 8);
    int i1 = am.a(this.j, 120);
    int i2 = am.a(this.j, 32);
    int i3 = am.a(this.j, 48);
    RelativeLayout relativeLayout = new RelativeLayout(getContext());
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams.addRule(8, this.u.getId());
    layoutParams.setMargins(0, 0, 0, i3);
    addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams);
    relativeLayout.setPadding(m, 0, m, 0);
    if (this.e == null) {
      this.e = new j(getContext());
      this.e.a(k);
      this.e.setId(33333);
      layoutParams = new RelativeLayout.LayoutParams(i, i);
      layoutParams.addRule(9);
      com.qq.e.comm.plugin.p.a.a().a(this.s.j(), (ImageView)this.e);
      relativeLayout.addView((View)this.e, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.m == null) {
      this.m = a(i2);
      layoutParams = new RelativeLayout.LayoutParams(i1, i2);
      layoutParams.addRule(11);
      layoutParams.setMargins(0, (i - i2) / 2, 0, 0);
      relativeLayout.addView((View)this.m, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.f == null) {
      this.f = new TextView(getContext());
      this.f.setId(33335);
      this.f.setGravity(16);
      layoutParams = new RelativeLayout.LayoutParams(-2, i);
      layoutParams.addRule(1, 33333);
      layoutParams.addRule(0, 33339);
      layoutParams.leftMargin = n;
      layoutParams.rightMargin = n;
      this.f.setText(this.r.n());
      this.f.setTextColor(-1);
      this.f.setTextSize(2, 15.0F);
      this.f.setTypeface(null, 1);
      this.f.setMaxLines(1);
      this.f.setEllipsize(TextUtils.TruncateAt.END);
      relativeLayout.addView((View)this.f, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.g == null) {
      this.g = new TextView(getContext());
      layoutParams = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams.topMargin = am.a(this.j, 8);
      layoutParams.addRule(3, 33333);
      this.g.setText(this.r.i());
      this.g.setTextColor(-1);
      this.g.setTextSize(2, 15.0F);
      this.g.setMaxLines(2);
      this.g.setEllipsize(TextUtils.TruncateAt.END);
      relativeLayout.addView((View)this.g, (ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  private void e() {
    int i = am.a(this.j, 80);
    int k = am.a(this.j, 21);
    int m = am.a(this.j, 16);
    int n = am.a(this.j, 16);
    int i1 = am.a(this.j, 44);
    RelativeLayout relativeLayout = new RelativeLayout(getContext());
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams.addRule(2, this.u.getId());
    layoutParams.setMargins(0, 0, 0, am.a(this.j, 33));
    addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams);
    relativeLayout.setPadding(m, 0, m, 0);
    if (this.e == null) {
      this.e = new j(getContext());
      this.e.a(k);
      this.e.setId(33333);
      layoutParams = new RelativeLayout.LayoutParams(i, i);
      layoutParams.addRule(9);
      com.qq.e.comm.plugin.p.a.a().a(this.s.j(), (ImageView)this.e);
      relativeLayout.addView((View)this.e, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.f == null) {
      this.f = new TextView(getContext());
      this.f.setId(33335);
      layoutParams = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams.addRule(1, 33333);
      layoutParams.addRule(10);
      layoutParams.leftMargin = n;
      layoutParams.rightMargin = n;
      this.f.setText(this.r.n());
      this.f.setTextColor(-1);
      this.f.setTextSize(2, 17.0F);
      this.f.setTypeface(null, 1);
      this.f.setEllipsize(TextUtils.TruncateAt.END);
      this.f.setMaxLines(1);
      relativeLayout.addView((View)this.f, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.m == null) {
      this.m = a(i1);
      layoutParams = new RelativeLayout.LayoutParams(-1, i1);
      layoutParams.addRule(3, this.u.getId());
      layoutParams.setMargins(m, am.a(this.j, 40), m, 0);
      addView((View)this.m, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.g == null) {
      this.g = new TextView(getContext());
      layoutParams = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams.topMargin = am.a(this.j, 4);
      layoutParams.leftMargin = n;
      layoutParams.rightMargin = n;
      layoutParams.addRule(1, 33333);
      layoutParams.addRule(11);
      layoutParams.addRule(3, 33335);
      this.g.setText(this.r.i());
      this.g.setTextColor(-1);
      this.g.setTextSize(2, 15.0F);
      this.g.setMaxLines(2);
      this.g.setEllipsize(TextUtils.TruncateAt.END);
      relativeLayout.addView((View)this.g, (ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  private boolean f() {
    long l = System.currentTimeMillis();
    if (l - this.l < 500L)
      return true; 
    this.l = l;
    return false;
  }
  
  public void a(int paramInt1, int paramInt2) {
    if (paramInt2 == 32)
      this.k = paramInt1; 
    if (paramInt2 == 0 || paramInt2 == 8)
      this.k = 0; 
    h h1 = this.h;
    if (h1 != null) {
      int k = this.k;
      int i = k;
      if (paramInt1 >= k)
        i = paramInt1; 
      h1.a(i);
    } 
    if (this.i != null) {
      int i = this.k;
      if (paramInt1 < i)
        paramInt1 = i; 
      a(paramInt1, paramInt2, this.i.getHeight());
    } 
  }
  
  public void a(a parama) {
    this.v = parama;
  }
  
  public void a(b.a parama) {
    this.t = parama;
  }
  
  public void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield p : Landroid/widget/ImageView;
    //   4: ifnonnull -> 8
    //   7: return
    //   8: iload_1
    //   9: ifeq -> 39
    //   12: ldc_w 'gdt_ic_native_volume_off'
    //   15: invokestatic a : (Ljava/lang/String;)I
    //   18: istore_3
    //   19: iload_3
    //   20: istore_2
    //   21: iload_3
    //   22: ifne -> 74
    //   25: aload_0
    //   26: getfield p : Landroid/widget/ImageView;
    //   29: astore #5
    //   31: ldc_w 'iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAYAAAA6/NlyAAAAAXNSR0IArs4c6QAAC4NJREFUaAXlW2lMFVkW9j0EFGkWRUUQEKQRtKXFfYmTEWVso2kngpqoiWv8o3HJuEbjZIwmbjHRjDpqJ66oGVsy7okL2t0uLbiMDWJEmk0WGwUVFwQE5vsq3Op6RVW9evAQJn2T4m7nnnu/Oveec+6ph6VNM6XJkye75efnh9fU1IRYLJaumMYfj1ddXV071NtxWpQ/ovwRxXI8z1H/zcXFJS84ODjr5MmTVaRxdrI4k+GQIUO8amtrB2PhMQASitylMfwxtgZjc5A/sFqtKXfu3OELcUpyCuDBgwdHAOhfsKI+eKxOWdnvTGpRfATgl1JSUjJ/b25cqUmABw4c2AvTfosnvHHTOzwqCyPO3L1794nDI+sHNArwmDFjvMvLyydDqoMaO3FTxkHaqV5eXievXLnyxlE+DgOGVL/C2ZqHM9be0cmcSY81VGAN30Ha6Y7wdUipAGwcmM/C4+rIJM1EyzUMDggIqCwqKso2O4cpCQ8YMMAV22g63ugws4w/Jx2kfRvHK/HevXvV9ua1K+ERI0Z8AaCL8ETbY9aC/UGw35E9evT45dmzZ4b22xAwJUuweHthLQjG1NRYpy+ecH9//5Ti4mKaMs1kaDO5jf8fwApkXCvXLOpaua6E6xXUWK1BrbwtyEiRaUqYpgeg4rWAeXh4uMBPDvbz83PT6m8lbfH1GBosp4GE6VRUVlb+DZSapmfPnj2j4+PjByUkJEQ+efKkAEqiogHXlm+A4rZE9+7d+3Z2dnalcjkNJEwPCodf16no0KGDOxm0Q9q8efP44cOHd1IyNFtesGBB5NWrV6fxmTRpUrDZcWbpiIFY1PQ2EsY26AXCBDWRsl5QUFAaGxsb1rY+jRo1KswRScN0eOzatWvM6NGjo93d3d34REVF+SUmJj5SzuOMMrAE4jw/hWNSKvipJcyLgGHCVa1s5cqV5z8ikdARSc+ZM+fLI0eOTI6IiAhSTgJ94KOsq8vUGRjb2AuKDSZZwrzi4Y1MUE+mVee5pVQpXTOSDgwMbLdjx47Y8ePHx5Bei+f+/fvvabXPmjUrfOnSpXGDBg0KxQ70vnz5ch6CCnVatDptHbt3755ZWFgoSVmWMGwY77Om061bt0rNSHr69Omhx44dm9K3b98egjk2RxW2dbKoG+Xv37+XPaf+/fuHHzx4cJyvr6+mQtXjo8QmAWakAsS8vDuUjEB37tzZfe/evbFLliyJgymTQjpknpubWzx37tzvsXDebe0mhHryodgeCsLw8PDAAwcOTMDZl4Ul+gzyPvUY20hbGgd7JIhpex1Oetsbpqt3SEgIY1lSwjasPXPmTOqiRYt+LC0tlaQ2f/78AaJfb0uzH/feQh8fn6o+ffp0R9WCu3AHbFNrcnJyoRhvJ+cl6Q1vVdJbwtmNsTPAsFtL0p6enh5iEAC+XrZs2X82btz4X8wlmh3Kt27dmgaFd1MMiouL+xqaXn6hol0vFxitjC7CSIfqESrbO3Xq5LZp06ahp0+fngQH5M+4ocjXSzVoMS4jIyMPcyTduHHjpWizl9MuY4c0sM07d+7MePz4cT7H07NYsWKFzRqM+BIjsVoZSgV6WVvrDeratav7iRMn4mk/cQT8oDEjADrWHuiwsLCuUFjeenzV7QS7evXqb1atWvXN7t27GwBau3btDxUVFZJJ7Nixo/fEiRNtTJyan6gTI7FaGTcWjUb5mjVrhuAcfaGkiYmJ6WkPtCN2WsmbZZiiCGzlEcp2LLri+vXrGaJtwoQJEaJsLydWK0Rt6hzAG6LCkNLRo0dv8sGZupGenl4cHR1tI0H19nYEdFJSUj4ApYm5Ro4cGTVu3LgAUWd+/PjxTGSSMoC/HMLdp+zXKxMrlRa/CNhNkK6nIIIT8YgPzxSfBw8evBZ9Im8K6OXLl98Gz1/reVlmzpzZX/BljnNcnpOT85xlHCkXvBBT2xrk/gRMG9wsqSmg169ff4umjAvr2bNnNzwdlIvELahE1OGqmr3AeFlxmGWnQDBwZt5Y0LikVGRlZQk7a4Hj0Fm5LoRx3ok6trSNbhHt6pxYeYabFTAn1QOtXpC6Dv9XPirdunWTjxTp4ES8FfTt27c3FYwgVsnxEAObM9cCbWI+pZci23yOw3aXh3/69Ena+nKDQYFbWrJpBjRO61KDtscYtyxfQQOJyluYbfAF5DNdVlZm0yfGqHNi5Zb+bIC5AD3Q6sgJr5S8KNQvui41NfWFEkCXLl3kLf7ixYv3yj69MrFySzvt26veROp2LdDqcNG6deuGw+JIRw4mqBgKzEaK8Atkc4qzLp9n9Vyqejkv47Rndn3p169fvxO2ePHixbpXyVevXlUcPnw4WzVRg6oATaB0TJhY5h0b7uKXvPuKQYcOHbovyswheU+EiiTANF3nzp3LV/YblJ+3xb7+zYBA7oKxLxg2bFgkG2bMmGHj7slE9YWxY8cWwBe+jqvjB3Wfsq4Fevv27X+lMyHobt68mXH+/PkiUWc+ZcoUvgxJiWVmZha8fPlSDhIo6dRlYrWCd566Q6uOq90dSNnU1oEj0B2uZ8LUqVN7aPFStgnQIkamBHv//v2nuFbKV0KOwz24PTyrrwUPuKGmAgmkJ1YXKIs3SPzCYGiiEGqpuXDhQibsoRW7zwUKoE1VVVW18gGPOrFgV1fXtuDdEzclD1wNi0CnazrUQQQuDmGZ2i1btvyYl5dns0u2bdv2p6CgoC6kKSkpKcOlhh6Z0nyxq0HCemsQkDgmbQtc9ZaDQj4zDahNNjDWBJdw2NChQ6WtL4YxALBhw4Zk9Z0YL8eiXCw1tTjTHEup80xzF7C+cOHCKPjVI1lmAtgzly5dog4yk7Lw8XyrdFZgAhid0FVEZriRBuurvXjxYh4AvsDVMcDNzc2V7YxpIULRCy5gLUDLC0TMazR2TS7OFsnaqCXNCKeIe+MaGDJ79myClYQEM5WJi0u6NNDEH0j4KkM8EmBskZeYdIxgZmK8IQkU3BsAeQLT4Ykj0JHE+KpniYyMDATwgIcPHxYxrgXTE4dPsj72QCPoEI5dGAo2EliaKXy5SK6urtY9JqoF1mI3HYL5qpQAswDPhQxN3Y1VzDSrHz58qIG5yEFehvtyIM80CRlEQHyaXzjeIRYeyhdC0GfPns0RjNSSrtcLElhcKkrmzZt38e3bt58EvYk8HTviJ9LJigoSuGRioMMk+ISSM23atH+npaXlisFQem6QUKyoM3IiyiJXa2/Rvm/fvhRYi2pRN5MrsUkS5iBIuRRSjkJR2oJmGJmloTQQ+PsVCqocWjtA6+uDVphWLWnOB18g2JFvWRiSBemeFWuVAbMBgKkNm+2HK4hilF27du1pv379fBEBlcNC+Mr3Dt5ZmliUMleDFooM0dBnEFKFklanfBDKStLy7LcBzA4Ydn+cL+G06/BofDO3I+JWWdDg76EsvXG1q0F08ieGbfS4aoGGc+N96tSpp3pj2I6tDOGmXlbSSIpA2cAP4nBE/gHQut+IlfSfs6y009D02VBeV/Tmhxmq8Pb2/rv613oNAJMBTMBXyBbi0ewnTUsl/tQCttkf/nUhLYHOOmjY/6n1Kz1dQAAdh0EJOgxbe/P3AGuzlcWCbc6waGROrwQemB+KQcr21l7GVr4NsEl665TtsBYB/PdEHHy7d1utsS3RxrVyzUZz60qYg/iLNly0f4EC4/cnOb5kxLCl+ggW3txu/CTD0FQZAubiYRKq+HM+MCTgVrm9uY0h2X32wBKPrtJipzrVK7J4tDs0Ts3HiXVq41N6CkprHrsSVg6iIoM3los3Go126eqn7P+cZdpZzPcvgP3ZkXkdAkzGAF3CX7ghguHTnB6ZEQgcr1Q4Fbtwt35mRKfV16StiS3eC0y/xdPkaInW4jTaGL/6/P/koV7IH+bfeNTA/zD/qKUGzjp/QMLfVOAO3Kr+Fe9/9s3Jk128m5sAAAAASUVORK5CYII='
    //   34: astore #4
    //   36: goto -> 63
    //   39: ldc_w 'gdt_ic_native_volume_on'
    //   42: invokestatic a : (Ljava/lang/String;)I
    //   45: istore_3
    //   46: iload_3
    //   47: istore_2
    //   48: iload_3
    //   49: ifne -> 74
    //   52: aload_0
    //   53: getfield p : Landroid/widget/ImageView;
    //   56: astore #5
    //   58: ldc_w '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'
    //   61: astore #4
    //   63: aload #5
    //   65: aload #4
    //   67: invokestatic a : (Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   70: invokevirtual setImageBitmap : (Landroid/graphics/Bitmap;)V
    //   73: return
    //   74: aload_0
    //   75: getfield p : Landroid/widget/ImageView;
    //   78: iload_2
    //   79: invokevirtual setImageResource : (I)V
    //   82: return
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    this.w.a(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public static interface a {
    void a();
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\gdtnativead\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */