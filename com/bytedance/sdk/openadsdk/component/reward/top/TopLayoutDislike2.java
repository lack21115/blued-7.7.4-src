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

public class TopLayoutDislike2 extends FrameLayout implements a<TopLayoutDislike2> {
  private View a;
  
  private ImageView b;
  
  private TextView c;
  
  private boolean d;
  
  private k e;
  
  private boolean f;
  
  private b g;
  
  private CharSequence h = "";
  
  private CharSequence i = "";
  
  public TopLayoutDislike2(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public TopLayoutDislike2(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopLayoutDislike2(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c() {
    View view = this.a;
    if (view != null)
      view.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (TopLayoutDislike2.a(this.a) != null)
                TopLayoutDislike2.a(this.a).c(param1View); 
            }
          }); 
    ImageView imageView = this.b;
    if (imageView != null)
      imageView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              int i;
              TopLayoutDislike2 topLayoutDislike2 = this.a;
              TopLayoutDislike2.a(topLayoutDislike2, TopLayoutDislike2.b(topLayoutDislike2) ^ true);
              if (TopLayoutDislike2.b(this.a)) {
                i = ab.d(this.a.getContext(), "tt_mute");
              } else {
                i = ab.d(this.a.getContext(), "tt_unmute");
              } 
              TopLayoutDislike2.c(this.a).setImageResource(i);
              if (TopLayoutDislike2.a(this.a) != null)
                TopLayoutDislike2.a(this.a).b(param1View); 
            }
          }); 
    TextView textView = this.c;
    if (textView != null)
      textView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (TopLayoutDislike2.a(this.a) != null)
                TopLayoutDislike2.a(this.a).a(param1View); 
            }
          }); 
  }
  
  public TopLayoutDislike2 a(boolean paramBoolean, k paramk) {
    this.d = paramBoolean;
    this.e = paramk;
    int i = ab.f(getContext(), "tt_top_reward_dislike_2");
    LayoutInflater.from(getContext()).inflate(i, (ViewGroup)this, true);
    this.a = findViewById(ab.e(getContext(), "tt_top_dislike"));
    this.b = (ImageView)findViewById(ab.e(getContext(), "tt_top_mute"));
    this.c = (TextView)findViewById(ab.e(getContext(), "tt_top_skip"));
    this.c.setVisibility(0);
    this.c.setText("");
    this.c.setEnabled(false);
    this.c.setClickable(false);
    c();
    return this;
  }
  
  public void a() {
    TextView textView = this.c;
    if (textView != null)
      textView.performClick(); 
  }
  
  public void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
    if (!TextUtils.isEmpty(paramCharSequence1))
      this.h = paramCharSequence1; 
    if (!TextUtils.isEmpty(paramCharSequence2))
      this.i = paramCharSequence2; 
    if (this.c != null) {
      paramCharSequence2 = this.h;
      paramCharSequence1 = paramCharSequence2;
      if (!TextUtils.isEmpty(this.i)) {
        paramCharSequence1 = new StringBuilder();
        paramCharSequence1.append(paramCharSequence2);
        paramCharSequence1.append(" | ");
        paramCharSequence1.append(this.i);
        paramCharSequence1 = paramCharSequence1.toString();
      } 
      this.c.setText(paramCharSequence1);
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
  
  public void setShowCountDown(boolean paramBoolean) {}
  
  public void setShowDislike(boolean paramBoolean) {
    View view = this.a;
    if (view != null) {
      byte b1;
      if (paramBoolean) {
        b1 = 0;
      } else {
        b1 = 8;
      } 
      view.setVisibility(b1);
    } 
  }
  
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\reward\top\TopLayoutDislike2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */