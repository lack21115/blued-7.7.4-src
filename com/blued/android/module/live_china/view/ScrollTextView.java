package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveHornModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;

public class ScrollTextView extends LinearLayout {
  public boolean a = false;
  
  private Context b;
  
  private LayoutInflater c;
  
  private ImageView d;
  
  private TextView e;
  
  private float f = 0.0F;
  
  private int g;
  
  private float h = 0.0F;
  
  private float i = 0.0F;
  
  private OnScrollListener j;
  
  private LiveHornModel k;
  
  public ScrollTextView(Context paramContext) {
    super(paramContext);
    this.b = paramContext;
    c();
  }
  
  public ScrollTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    c();
  }
  
  public ScrollTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    c();
  }
  
  private void c() {
    this.c = LayoutInflater.from(this.b);
    View view = this.c.inflate(R.layout.scroll_text_layout, null);
    this.d = (ImageView)view.findViewById(R.id.scroll_icon);
    this.e = (TextView)view.findViewById(R.id.scroll_text);
    setWillNotDraw(false);
    addView(view);
  }
  
  public void a() {
    this.a = true;
    invalidate();
  }
  
  public void a(LiveHornModel paramLiveHornModel) {
    ViewGroup.LayoutParams layoutParams;
    this.k = paramLiveHornModel;
    this.g = paramLiveHornModel.type;
    TextPaint textPaint = this.e.getPaint();
    this.e.setText(paramLiveHornModel.content);
    try {
      this.e.setTextColor(Color.parseColor(paramLiveHornModel.color));
    } catch (Exception exception) {
      this.e.setTextColor(-1);
    } 
    String str1 = paramLiveHornModel.content;
    String str2 = paramLiveHornModel.highlight_new;
    SpannableString spannableString = new SpannableString(str1);
    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str1) && str1.indexOf(str2) >= 0) {
      int i = spannableString.toString().indexOf(str2);
      int j = spannableString.toString().indexOf(str2) + str2.length();
      if (i >= 0) {
        if (j < 0)
          return; 
        spannableString.setSpan(new ClickableSpan(this) {
              public void onClick(View param1View) {}
              
              public void updateDrawState(TextPaint param1TextPaint) {
                param1TextPaint.setColor(ScrollTextView.a(this.a).getResources().getColor(R.color.nafio_f));
                param1TextPaint.setUnderlineText(false);
              }
            },  i, j, 33);
      } else {
        return;
      } 
    } 
    CharSequence charSequence = LiveRoomInfo.a().a((CharSequence)spannableString, "#ffef5f", new LiveRoomConstants.ClickAtLinkListener(this) {
          public void a(String param1String1, String param1String2) {
            if (TextUtils.isEmpty(param1String2)) {
              LiveSetDataObserver.a().d(param1String1);
              return;
            } 
            LiveSetDataObserver.a().e(param1String2);
          }
        });
    this.e.setText(charSequence);
    if (paramLiveHornModel.is_hongbao) {
      this.d.setImageResource(R.drawable.live_hongbao_horn_icon);
    } else if (paramLiveHornModel.is_wifi) {
      this.d.setImageResource(R.drawable.wifi_horn_icon);
    } else if (!TextUtils.isEmpty(paramLiveHornModel.notify_icon)) {
      ImageLoader.a(null, paramLiveHornModel.notify_icon).a(this.d);
    } else {
      this.d.setImageResource(R.drawable.live_horn_icon);
    } 
    if (paramLiveHornModel.type == 1) {
      layoutParams = this.d.getLayoutParams();
      layoutParams.width = AppMethods.a(32);
      layoutParams.height = AppMethods.a(32);
      this.d.setLayoutParams(layoutParams);
      this.e.setTextSize(14.0F);
      this.f = textPaint.measureText(charSequence.toString()) + AppMethods.a(32) + AppMethods.a(8);
    } else if (((LiveHornModel)layoutParams).type == 2) {
      layoutParams = this.d.getLayoutParams();
      layoutParams.width = AppMethods.a(18);
      layoutParams.height = AppMethods.a(18);
      this.d.setLayoutParams(layoutParams);
      this.e.setTextSize(12.0F);
      this.f = textPaint.measureText(charSequence.toString()) + AppMethods.a(18) + AppMethods.a(8);
    } 
    this.e.setMovementMethod((MovementMethod)LinkMovementClickMethod.a());
  }
  
  public void b() {
    this.a = false;
    invalidate();
  }
  
  public void onDraw(Canvas paramCanvas) {
    paramCanvas.translate(this.h, 0.0F);
    if (!this.a) {
      super.onDraw(paramCanvas);
      return;
    } 
    this.h -= 3.0F;
    if (this.h <= -this.f) {
      this.h = 0.0F;
      b();
      OnScrollListener onScrollListener = this.j;
      if (onScrollListener != null)
        onScrollListener.a(); 
    } 
    invalidate();
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure((int)this.f, paramInt2);
  }
  
  public void setOnScrollListener(OnScrollListener paramOnScrollListener) {
    this.j = paramOnScrollListener;
  }
  
  public static interface OnScrollListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\ScrollTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */