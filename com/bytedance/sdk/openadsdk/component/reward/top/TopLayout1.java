package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ai;

public class TopLayout1 extends FrameLayout implements a<TopLayout1> {
  private TextView a;
  
  private ImageView b;
  
  private TextView c;
  
  private boolean d;
  
  private k e;
  
  private boolean f;
  
  private b g;
  
  public TopLayout1(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public TopLayout1(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopLayout1(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c() {
    ImageView imageView = this.b;
    if (imageView != null)
      imageView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              int i;
              TopLayout1 topLayout1 = this.a;
              TopLayout1.a(topLayout1, TopLayout1.a(topLayout1) ^ true);
              if (TopLayout1.a(this.a)) {
                i = ab.d(this.a.getContext(), "tt_mute");
              } else {
                i = ab.d(this.a.getContext(), "tt_unmute");
              } 
              TopLayout1.b(this.a).setImageResource(i);
              if (TopLayout1.c(this.a) != null)
                TopLayout1.c(this.a).b(param1View); 
            }
          }); 
    TextView textView = this.c;
    if (textView != null)
      textView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (TopLayout1.c(this.a) != null)
                TopLayout1.c(this.a).a(param1View); 
            }
          }); 
  }
  
  public TopLayout1 a(boolean paramBoolean, k paramk) {
    int i;
    this.d = paramBoolean;
    this.e = paramk;
    if (this.d) {
      i = ab.f(getContext(), "tt_top_reward_1");
    } else {
      i = ab.f(getContext(), "tt_top_full_1");
    } 
    LayoutInflater.from(getContext()).inflate(i, (ViewGroup)this, true);
    if (this.d) {
      this.a = (TextView)findViewById(ab.e(getContext(), "tt_top_countdown"));
      this.b = (ImageView)findViewById(ab.e(getContext(), "tt_top_mute"));
      this.c = (TextView)findViewById(ab.e(getContext(), "tt_top_skip"));
    } else {
      this.a = (TextView)findViewById(ab.e(getContext(), "tt_top_countdown"));
      this.b = (ImageView)findViewById(ab.e(getContext(), "tt_top_mute"));
      this.c = (TextView)findViewById(ab.e(getContext(), "tt_top_skip"));
    } 
    c();
    return this;
  }
  
  public void a() {
    TextView textView = this.c;
    if (textView != null)
      textView.performClick(); 
  }
  
  public void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
    if (this.a != null && !TextUtils.isEmpty(paramCharSequence1))
      this.a.setText(paramCharSequence1); 
    if (this.c != null && !TextUtils.isEmpty(paramCharSequence2)) {
      this.c.setText(paramCharSequence2);
      if (!this.d) {
        float f;
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (paramCharSequence2.length() <= 2) {
          f = ai.a(getContext(), 53.0F);
        } else {
          f = ai.a(getContext(), 96.0F);
        } 
        layoutParams.width = (int)f;
        this.c.setLayoutParams(layoutParams);
      } 
    } 
  }
  
  public void b() {
    ImageView imageView = this.b;
    if (imageView != null)
      imageView.performClick(); 
  }
  
  public void setListener(b paramb) {
    this.g = paramb;
  }
  
  public void setShowCountDown(boolean paramBoolean) {
    TextView textView = this.a;
    if (textView != null) {
      byte b1;
      if (paramBoolean) {
        b1 = 0;
      } else {
        b1 = 8;
      } 
      textView.setVisibility(b1);
    } 
  }
  
  public void setShowDislike(boolean paramBoolean) {}
  
  public void setShowSkip(boolean paramBoolean) {
    TextView textView = this.c;
    if (textView != null) {
      byte b1;
      if (paramBoolean) {
        b1 = 0;
      } else {
        b1 = 8;
      } 
      textView.setVisibility(b1);
    } 
  }
  
  public void setShowSound(boolean paramBoolean) {
    ImageView imageView = this.b;
    if (imageView != null) {
      byte b1;
      if (paramBoolean) {
        b1 = 0;
      } else {
        b1 = 8;
      } 
      imageView.setVisibility(b1);
    } 
  }
  
  public void setSkipEnable(boolean paramBoolean) {
    TextView textView = this.c;
    if (textView != null) {
      textView.setEnabled(paramBoolean);
      this.c.setClickable(paramBoolean);
    } 
  }
  
  public void setSoundMute(boolean paramBoolean) {
    int i;
    this.f = paramBoolean;
    if (this.f) {
      i = ab.d(getContext(), "tt_mute");
    } else {
      i = ab.d(getContext(), "tt_unmute");
    } 
    this.b.setImageResource(i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\reward\top\TopLayout1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */