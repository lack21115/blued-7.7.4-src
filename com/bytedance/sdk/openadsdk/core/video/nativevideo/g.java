package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.d.a;
import com.bytedance.sdk.openadsdk.core.widget.d;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

public class g extends h {
  private TextView J;
  
  private ImageView K;
  
  private View L;
  
  private TextView M;
  
  private TextView N;
  
  private TextView O;
  
  private ImageView P;
  
  private View Q;
  
  private ImageView R;
  
  private TextView S;
  
  private View T;
  
  private SeekBar U;
  
  private TextView V;
  
  private TextView W;
  
  private ImageView X;
  
  private final ak Y = new ak(this);
  
  private boolean Z = false;
  
  private boolean aA;
  
  private boolean aB;
  
  private boolean aa = false;
  
  private int ab = 0;
  
  private int ac = 0;
  
  private int ad = 0;
  
  private int ae = 0;
  
  private int af = 0;
  
  private final Rect ag = new Rect();
  
  private ColorStateList ah;
  
  private float ai;
  
  private final Rect aj = new Rect();
  
  private int ak = 0;
  
  private boolean al;
  
  private int am = 0;
  
  private int an = 0;
  
  private d ao = null;
  
  private boolean ap = false;
  
  private final View.OnTouchListener aq = new View.OnTouchListener(this) {
      private float b;
      
      public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
        float f = param1MotionEvent.getX();
        int i = param1MotionEvent.getActionMasked();
        if (i != 0) {
          boolean bool = true;
          if (i != 1) {
            if (i != 2) {
              if (i != 3)
                return false; 
              param1View.getParent().requestDisallowInterceptTouchEvent(false);
              return false;
            } 
            param1View.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
          } 
          g g1 = this.a;
          if (Math.abs(this.b - param1MotionEvent.getX()) >= 10.0F)
            bool = false; 
          g.a(g1, bool);
          return false;
        } 
        this.b = f;
        return false;
      }
    };
  
  private float ar;
  
  private ColorStateList as;
  
  private float at;
  
  private final Rect au = new Rect();
  
  private float av;
  
  private ColorStateList aw;
  
  private float ax;
  
  private final Rect ay = new Rect();
  
  private final Rect az = new Rect();
  
  public g(Context paramContext, View paramView, boolean paramBoolean1, EnumSet<b.a> paramEnumSet, k paramk, c paramc, boolean paramBoolean2) {
    super(paramContext, paramView, paramBoolean1, paramEnumSet, paramk, paramc, paramBoolean2);
    c(paramBoolean2);
    this.a = paramView;
    this.u = paramBoolean1;
    this.ao = new d(this);
    this.ao.a(this.u);
    DisplayMetrics displayMetrics = this.z.getResources().getDisplayMetrics();
    this.am = displayMetrics.widthPixels;
    this.an = displayMetrics.heightPixels;
    EnumSet<b.a> enumSet = paramEnumSet;
    if (paramEnumSet == null)
      enumSet = EnumSet.noneOf(b.a.class); 
    this.x = enumSet;
    this.E = paramc;
    this.y = paramk;
    c(8);
    a(paramContext, this.a);
    a();
    n();
  }
  
  private void e(boolean paramBoolean) {
    if (paramBoolean) {
      y();
      return;
    } 
    z();
  }
  
  private void y() {
    DisplayMetrics displayMetrics = this.z.getResources().getDisplayMetrics();
    TextView textView2 = this.W;
    if (textView2 != null) {
      this.ar = textView2.getTextSize();
      this.W.setTextSize(2, 14.0F);
      this.as = this.W.getTextColors();
      if (this.as != null)
        this.W.setTextColor(ab.i(this.z, "tt_ssxinzi15")); 
      this.at = this.W.getAlpha();
      this.W.setAlpha(0.85F);
      this.W.setShadowLayer(0.0F, ai.a(this.z, 0.5F), ai.a(this.z, 0.5F), ab.i(this.z, "tt_video_shaoow_color_fullscreen"));
      ViewGroup.LayoutParams layoutParams = this.W.getLayoutParams();
      if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
        this.au.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        ai.b((View)this.W, (int)TypedValue.applyDimension(1, 16.0F, displayMetrics), this.au.top, (int)TypedValue.applyDimension(1, 14.0F, displayMetrics), this.au.bottom);
      } 
    } 
    textView2 = this.V;
    if (textView2 != null) {
      this.av = textView2.getTextSize();
      this.V.setTextSize(2, 14.0F);
      this.aw = this.V.getTextColors();
      if (this.aw != null)
        this.V.setTextColor(ab.i(this.z, "tt_ssxinzi15")); 
      this.ax = this.V.getAlpha();
      this.V.setAlpha(0.85F);
      this.V.setShadowLayer(0.0F, ai.a(this.z, 0.5F), ai.a(this.z, 0.5F), ab.i(this.z, "tt_video_shaoow_color_fullscreen"));
      ViewGroup.LayoutParams layoutParams = this.V.getLayoutParams();
      if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
        this.ay.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        ai.b((View)this.V, (int)TypedValue.applyDimension(1, 14.0F, displayMetrics), this.ay.top, this.ay.right, this.ay.bottom);
      } 
    } 
    ImageView imageView = this.X;
    if (imageView != null) {
      ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
      if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
        this.az.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        ai.b((View)this.X, this.az.left, this.az.top, (int)TypedValue.applyDimension(1, 16.0F, displayMetrics), this.az.bottom);
      } 
    } 
    imageView = this.X;
    if (imageView != null)
      imageView.setImageDrawable(ab.c(this.z, "tt_shrink_fullscreen")); 
    TextView textView1 = this.N;
    if (textView1 != null) {
      this.ah = textView1.getTextColors();
      if (this.ah != null)
        this.N.setTextColor(ab.i(this.z, "tt_ssxinzi15")); 
      this.ai = this.N.getAlpha();
      this.N.setAlpha(0.85F);
      ViewGroup.LayoutParams layoutParams = this.N.getLayoutParams();
      if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
        this.aj.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        ai.b((View)this.N, (int)TypedValue.applyDimension(1, 1.0F, displayMetrics), this.ay.top, this.ay.right, this.ay.bottom);
      } 
    } 
    View view = this.L;
    if (view != null) {
      ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
      this.ak = layoutParams.height;
      layoutParams.height = (int)TypedValue.applyDimension(1, 49.0F, displayMetrics);
      this.L.setLayoutParams(layoutParams);
      this.L.setBackgroundResource(ab.d(this.z, "tt_shadow_fullscreen_top"));
    } 
    b(this.al, true);
  }
  
  private void z() {
    TextView textView2 = this.W;
    if (textView2 != null) {
      textView2.setTextSize(0, this.ar);
      ColorStateList colorStateList = this.as;
      if (colorStateList != null)
        this.W.setTextColor(colorStateList); 
      this.W.setAlpha(this.at);
      this.W.setShadowLayer(ai.a(this.z, 1.0F), 0.0F, 0.0F, ab.i(this.z, "tt_video_shadow_color"));
      ai.b((View)this.W, this.au.left, this.au.top, this.au.right, this.au.bottom);
    } 
    textView2 = this.V;
    if (textView2 != null) {
      textView2.setTextSize(0, this.av);
      ColorStateList colorStateList = this.aw;
      if (colorStateList != null)
        this.V.setTextColor(colorStateList); 
      this.V.setAlpha(this.ax);
      this.V.setShadowLayer(ai.a(this.z, 1.0F), 0.0F, 0.0F, ab.i(this.z, "tt_video_shadow_color"));
      ai.b((View)this.V, this.ay.left, this.ay.top, this.ay.right, this.ay.bottom);
    } 
    ImageView imageView = this.X;
    if (imageView != null)
      ai.b((View)imageView, this.az.left, this.az.top, this.az.right, this.az.bottom); 
    imageView = this.X;
    if (imageView != null)
      imageView.setImageDrawable(ab.c(this.z, "tt_enlarge_video")); 
    TextView textView1 = this.N;
    if (textView1 != null) {
      ColorStateList colorStateList = this.ah;
      if (colorStateList != null)
        textView1.setTextColor(colorStateList); 
      this.N.setAlpha(this.ai);
      ai.b((View)this.N, this.ay.left, this.ay.top, this.ay.right, this.ay.bottom);
    } 
    View view = this.L;
    if (view != null) {
      ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
      layoutParams.height = this.ak;
      this.L.setLayoutParams(layoutParams);
      this.L.setBackgroundResource(ab.d(this.z, "tt_video_black_desc_gradient"));
    } 
    b(this.al, true);
  }
  
  protected void a() {
    byte b1;
    super.a();
    this.ao.a(this.a);
    ImageView imageView = this.K;
    boolean bool = this.u;
    byte b2 = 8;
    if (bool || this.x.contains(b.a.a)) {
      b1 = 8;
    } else {
      b1 = 0;
    } 
    ai.a((View)imageView, b1);
    this.K.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.r())
              this.a.B.c(this.a, param1View); 
          }
        });
    TextView textView = this.J;
    if (this.u && !this.x.contains(b.a.b)) {
      b1 = b2;
    } else {
      b1 = 0;
    } 
    ai.a((View)textView, b1);
    this.J.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.r())
              this.a.B.d(this.a, param1View); 
          }
        });
    this.P.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.r())
              this.a.B.e(this.a, param1View); 
          }
        });
    this.R.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.b(false, true);
            this.a.f();
            this.a.d();
            if (this.a.r())
              this.a.B.f(this.a, param1View); 
          }
        });
    this.X.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.r())
              this.a.B.b(this.a, param1View); 
          }
        });
    this.U.setThumbOffset(0);
    this.U.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
          public void onProgressChanged(SeekBar param1SeekBar, int param1Int, boolean param1Boolean) {
            if (this.a.r())
              this.a.B.a(this.a, param1Int, param1Boolean); 
          }
          
          public void onStartTrackingTouch(SeekBar param1SeekBar) {
            if (!g.a(this.a) && this.a.z != null)
              param1SeekBar.setThumb(ab.c(o.a(), "tt_seek_thumb_press")); 
            if (this.a.r()) {
              param1SeekBar.setThumbOffset(0);
              this.a.B.b(this.a, param1SeekBar.getProgress());
            } 
          }
          
          public void onStopTrackingTouch(SeekBar param1SeekBar) {
            if (!g.a(this.a) && this.a.z != null)
              param1SeekBar.setThumb(ab.c(o.a(), "tt_seek_thumb_normal")); 
            if (this.a.r()) {
              param1SeekBar.setThumbOffset(0);
              this.a.B.a(this.a, param1SeekBar.getProgress());
            } 
          }
        });
    this.U.setOnTouchListener(this.aq);
  }
  
  public void a(int paramInt) {
    View view = this.T;
    if (view != null && view.getVisibility() == 0) {
      ai.a((View)this.o, 8);
      return;
    } 
    ai.a((View)this.o, 0);
    this.U.setProgress(paramInt);
    this.o.setProgress(paramInt);
  }
  
  public void a(long paramLong) {
    this.W.setText(a.a(paramLong));
  }
  
  public void a(long paramLong1, long paramLong2) {
    this.V.setText(a.a(paramLong2));
    this.W.setText(a.a(paramLong1));
    int i = a.a(paramLong1, paramLong2);
    this.U.setProgress(i);
  }
  
  protected void a(Context paramContext, View paramView) {
    super.a(paramContext, paramView);
    this.J = (TextView)paramView.findViewById(ab.e(paramContext, "tt_video_back"));
    this.K = (ImageView)paramView.findViewById(ab.e(paramContext, "tt_video_close"));
    this.L = paramView.findViewById(ab.e(paramContext, "tt_video_top_layout"));
    this.P = (ImageView)paramView.findViewById(ab.e(paramContext, "tt_video_fullscreen_back"));
    this.M = (TextView)paramView.findViewById(ab.e(paramContext, "tt_video_title"));
    this.N = (TextView)paramView.findViewById(ab.e(paramContext, "tt_video_top_title"));
    this.O = (TextView)paramView.findViewById(ab.e(paramContext, "tt_video_current_time"));
    this.Q = paramView.findViewById(ab.e(paramContext, "tt_video_loading_retry"));
    this.R = (ImageView)paramView.findViewById(ab.e(paramContext, "tt_video_retry"));
    this.S = (TextView)paramView.findViewById(ab.e(paramContext, "tt_video_retry_des"));
    this.U = (SeekBar)paramView.findViewById(ab.e(paramContext, "tt_video_seekbar"));
    this.V = (TextView)paramView.findViewById(ab.e(paramContext, "tt_video_time_left_time"));
    this.W = (TextView)paramView.findViewById(ab.e(paramContext, "tt_video_time_play"));
    this.T = paramView.findViewById(ab.e(paramContext, "tt_video_ad_bottom_layout"));
    this.X = (ImageView)paramView.findViewById(ab.e(paramContext, "tt_video_ad_full_screen"));
    this.g = (ViewStub)paramView.findViewById(ab.e(paramContext, "tt_video_ad_cover"));
  }
  
  public void a(Message paramMessage) {
    if (paramMessage.what != 1)
      return; 
    j();
  }
  
  public void a(View paramView, boolean paramBoolean) {
    if (h()) {
      String str = (new SimpleDateFormat("HH:mm", Locale.getDefault())).format(new Date());
      if (this.y != null && !TextUtils.isEmpty(this.y.J()))
        a(this.y.J()); 
      this.O.setText(str);
    } else {
      a("");
      this.O.setText("");
    } 
    if (!this.C) {
      paramBoolean = this.u;
      boolean bool = false;
      if (paramBoolean && !this.Z) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      b(paramBoolean);
      if (r()) {
        d d1 = this.B;
        paramBoolean = bool;
        if (this.d.getVisibility() != 0)
          paramBoolean = true; 
        d1.a(this, paramView, true, paramBoolean);
      } 
    } 
  }
  
  public void a(ViewGroup paramViewGroup) {
    if (paramViewGroup == null)
      return; 
    if (!(this.a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      return; 
    this.Z = true;
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
    this.ac = marginLayoutParams.leftMargin;
    this.ab = marginLayoutParams.topMargin;
    this.ad = marginLayoutParams.width;
    this.ae = marginLayoutParams.height;
    marginLayoutParams.width = -1;
    marginLayoutParams.height = -1;
    marginLayoutParams.topMargin = 0;
    marginLayoutParams.leftMargin = 0;
    this.a.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
    ViewGroup.LayoutParams layoutParams = paramViewGroup.getLayoutParams();
    if (layoutParams instanceof RelativeLayout.LayoutParams) {
      boolean bool;
      RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams)layoutParams;
      int[] arrayOfInt = layoutParams1.getRules();
      if (arrayOfInt.length > 0) {
        bool = arrayOfInt[3];
      } else {
        bool = false;
      } 
      this.af = bool;
      layoutParams1.addRule(3, 0);
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    } 
    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
      ViewGroup.MarginLayoutParams marginLayoutParams1 = (ViewGroup.MarginLayoutParams)layoutParams;
      this.ag.set(marginLayoutParams1.leftMargin, marginLayoutParams1.topMargin, marginLayoutParams1.rightMargin, marginLayoutParams1.bottomMargin);
      ai.b((View)paramViewGroup, 0, 0, 0, 0);
    } 
    a(true);
    this.X.setImageDrawable(ab.c(this.z, "tt_shrink_video"));
    this.U.setThumb(ab.c(this.z, "tt_seek_thumb_fullscreen_selector"));
    this.U.setThumbOffset(0);
    a.a(this.a, false);
    e(this.Z);
    ai.a(this.L, 8);
    if (!this.u) {
      ai.a((View)this.K, 8);
      ai.a((View)this.J, 8);
      return;
    } 
    if (this.x.contains(b.a.a))
      ai.a((View)this.K, 8); 
  }
  
  public void a(k paramk, WeakReference<Context> paramWeakReference, boolean paramBoolean) {
    String str1;
    String str2;
    if (paramk == null)
      return; 
    a(this.a, o.a());
    a(false, this.u);
    ai.a(this.h, 0);
    ai.a((View)this.i, 0);
    ai.a(this.j, 0);
    if (this.i != null && this.y != null && this.y.z() != null && this.y.z().f() != null)
      e.a(this.z).a(this.y.z().f(), this.i); 
    if (!TextUtils.isEmpty(paramk.A())) {
      str2 = paramk.A();
    } else if (!TextUtils.isEmpty(paramk.J())) {
      str2 = paramk.J();
    } else if (!TextUtils.isEmpty(paramk.K())) {
      str2 = paramk.K();
    } else {
      str2 = "";
    } 
    if (this.y != null && this.y.C() != null && this.y.C().a() != null) {
      ai.a((View)this.k, 0);
      ai.a((View)this.l, 4);
      if (this.k != null) {
        e.a(this.z).a(this.y.C().a(), (ImageView)this.k);
        this.k.setOnClickListener((View.OnClickListener)this.F);
        this.k.setOnTouchListener((View.OnTouchListener)this.F);
      } 
    } else if (!TextUtils.isEmpty(str2)) {
      ai.a((View)this.k, 4);
      ai.a((View)this.l, 0);
      if (this.l != null) {
        this.l.setText(str2.substring(0, 1));
        this.l.setOnClickListener((View.OnClickListener)this.F);
        this.l.setOnTouchListener((View.OnTouchListener)this.F);
      } 
    } 
    if (this.m != null && !TextUtils.isEmpty(str2))
      this.m.setText(str2); 
    ai.a((View)this.m, 0);
    ai.a((View)this.n, 0);
    int i = paramk.B();
    if (i != 2 && i != 3) {
      if (i != 4) {
        if (i != 5) {
          str1 = ab.a(this.z, "tt_video_mobile_go_detail");
        } else {
          str1 = ab.a(this.z, "tt_video_dial_phone");
        } 
      } else {
        str1 = ab.a(this.z, "tt_video_download_apk");
      } 
    } else {
      str1 = ab.a(this.z, "tt_video_mobile_go_detail");
    } 
    if (this.n != null) {
      this.n.setText(str1);
      this.n.setOnClickListener((View.OnClickListener)this.F);
      this.n.setOnTouchListener((View.OnTouchListener)this.F);
    } 
  }
  
  public void a(String paramString) {
    TextView textView = this.M;
    if (textView != null)
      textView.setText(paramString); 
    textView = this.N;
    if (textView != null)
      textView.setText(paramString); 
  }
  
  public void a(boolean paramBoolean) {
    int i;
    int j;
    if (h()) {
      i = this.an;
    } else {
      i = this.q;
    } 
    if (h()) {
      j = this.am;
    } else {
      j = this.r;
    } 
    if (this.t > 0) {
      if (this.s <= 0)
        return; 
      if (i <= 0)
        return; 
      int k = j;
      if (!i()) {
        k = j;
        if (!h())
          if (this.x.contains(b.a.d)) {
            k = j;
          } else {
            k = this.z.getResources().getDimensionPixelSize(ab.h(this.z, "tt_video_container_maxheight"));
          }  
      } 
      float f = i * 1.0F / this.s;
      j = (int)(this.t * f);
      if (j > k) {
        f = k * 1.0F / this.t;
        i = (int)(this.s * f);
      } else {
        k = j;
      } 
      int m = i;
      j = k;
      if (!paramBoolean) {
        m = i;
        j = k;
        if (!h()) {
          m = this.q;
          j = this.r;
        } 
      } 
      this.b.a(m, j);
    } 
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    byte b;
    ai.a(this.T, 8);
    ai.a(this.L, 8);
    ProgressBar progressBar = this.o;
    if (paramBoolean1) {
      b = 0;
    } else {
      b = 8;
    } 
    ai.a((View)progressBar, b);
    ai.a((View)this.c, 8);
    if (!this.u && !this.Z) {
      ai.a((View)this.K, 8);
      if (!this.x.contains(b.a.b))
        ai.a((View)this.J, 8); 
    } else if (this.x.contains(b.a.a)) {
      ai.a((View)this.K, 8);
    } 
    if (paramBoolean2) {
      ai.a((View)this.K, 8);
      ai.a((View)this.J, 8);
    } 
    b(false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    byte b1;
    ai.a(this.T, 0);
    ai.a((View)this.o, 0);
    paramBoolean2 = this.Z;
    byte b2 = 8;
    if (paramBoolean2) {
      ai.a(this.L, 0);
      ai.a((View)this.N, 0);
    } else if (paramBoolean3) {
      ai.a(this.L, 8);
    } 
    ImageView imageView = this.c;
    if (paramBoolean1 && this.d.getVisibility() != 0) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    ai.a((View)imageView, b1);
    if (!this.u && !this.Z) {
      if (!this.x.contains(b.a.a) && !paramBoolean3)
        ai.a((View)this.K, 0); 
      TextView textView = this.J;
      if (paramBoolean3) {
        b1 = b2;
      } else {
        b1 = 0;
      } 
      ai.a((View)textView, b1);
    } 
    ai.a((View)this.V, 0);
    ai.a((View)this.W, 0);
    ai.a((View)this.U, 0);
  }
  
  public void b() {
    this.Y.removeMessages(1);
    Message message = this.Y.obtainMessage(1);
    this.Y.sendMessageDelayed(message, 2000L);
  }
  
  public void b(ViewGroup paramViewGroup) {
    t.e("FullScreen", "Detail exitFullScreen.....");
    if (paramViewGroup == null)
      return; 
    if (this.a != null) {
      if (!(this.a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
        return; 
      this.Z = false;
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
      marginLayoutParams.width = this.ad;
      marginLayoutParams.height = this.ae;
      marginLayoutParams.leftMargin = this.ac;
      marginLayoutParams.topMargin = this.ab;
      this.a.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
      ViewGroup.LayoutParams layoutParams = paramViewGroup.getLayoutParams();
      if (layoutParams instanceof RelativeLayout.LayoutParams) {
        RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams)layoutParams;
        layoutParams1.addRule(3, this.af);
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
      } 
      if (layoutParams instanceof ViewGroup.MarginLayoutParams)
        ai.b((View)paramViewGroup, this.ag.left, this.ag.top, this.ag.right, this.ag.bottom); 
      a(true);
      this.X.setImageDrawable(ab.c(this.z, "tt_enlarge_video"));
      this.U.setThumb(ab.c(this.z, "tt_seek_thumb_normal"));
      this.U.setThumbOffset(0);
      a.a(this.a, true);
      e(this.Z);
      ai.a(this.L, 8);
      if (this.x.contains(b.a.b))
        ai.a((View)this.J, 0); 
    } 
  }
  
  public void b(boolean paramBoolean) {
    if (this.M != null) {
      boolean bool = this.u;
      byte b = 8;
      if (bool) {
        ai.a((View)this.M, 8);
        return;
      } 
      TextView textView = this.M;
      if (paramBoolean)
        b = 0; 
      ai.a((View)textView, b);
    } 
  }
  
  public boolean b(int paramInt) {
    SeekBar seekBar = this.U;
    return (seekBar != null && paramInt > seekBar.getSecondaryProgress());
  }
  
  public void c() {
    this.Y.removeMessages(1);
  }
  
  public void c(int paramInt) {
    this.w = paramInt;
    ai.a(this.a, paramInt);
    if (paramInt != 0) {
      this.aB = false;
      return;
    } 
    if (this.aA)
      this.aB = true; 
  }
  
  public void d() {
    ai.e(this.d);
    ai.e(this.e);
    ai.d(this.Q);
    if (this.f != null && this.y != null && this.y.z() != null && this.y.z().f() != null) {
      ai.e((View)this.f);
      e.a(this.z).a(this.y.z().f(), this.f);
    } 
    if (this.c.getVisibility() == 0)
      ai.a((View)this.c, 8); 
  }
  
  public void e() {
    a(false, this.u);
    v();
  }
  
  public void f() {
    ai.d(this.d);
    ai.d(this.Q);
  }
  
  public void g() {
    this.U.setProgress(0);
    this.U.setSecondaryProgress(0);
    this.o.setProgress(0);
    this.o.setSecondaryProgress(0);
    this.V.setText(ab.b(this.z, "tt_00_00"));
    this.W.setText(ab.b(this.z, "tt_00_00"));
    c(8);
    if (x())
      this.b.setVisibility(8); 
    if (this.f != null)
      this.f.setImageDrawable(null); 
    c(8);
    ai.a(this.T, 8);
    ai.a(this.h, 8);
    ai.a((View)this.i, 8);
    ai.a(this.j, 8);
    ai.a((View)this.k, 8);
    ai.a((View)this.l, 8);
    ai.a((View)this.m, 8);
    if (this.A != null)
      this.A.a(true); 
  }
  
  public boolean h() {
    return this.Z;
  }
  
  public boolean i() {
    return this.u;
  }
  
  public void j() {
    a(true, false);
  }
  
  public boolean k() {
    return this.v;
  }
  
  public void l() {
    j();
    b(false);
  }
  
  public boolean m() {
    return (this.A != null && this.A.a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\nativevideo\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */