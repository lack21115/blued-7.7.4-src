package com.blued.android.module.live_china.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.live.base.view.FlowLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.same.Logger;
import java.util.List;

public class QuickReplyView extends FrameLayout {
  private View a;
  
  private Context b;
  
  private LayoutInflater c;
  
  private ImageView d;
  
  private FlowLayout e;
  
  private boolean f;
  
  private OnItemClickListener g;
  
  public QuickReplyView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public QuickReplyView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QuickReplyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    a();
  }
  
  private void a() {
    this.c = LayoutInflater.from(this.b);
    this.a = this.c.inflate(R.layout.live_quick_reply_view, (ViewGroup)this);
    this.d = (ImageView)this.a.findViewById(R.id.quick_reply_close);
    this.e = (FlowLayout)this.a.findViewById(R.id.quick_reply_flow_layout);
    setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            QuickReplyView.a(this.a, true);
            this.a.setVisibility(8);
          }
        });
    setMaxRows(3);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setData(List<LiveZanExtraModel.HotWords> paramList) {
    if (paramList != null && paramList.size() > 0) {
      this.e.removeAllViews();
      for (int i = 0; i < paramList.size(); i++) {
        View view = this.c.inflate(R.layout.live_quick_reply_text_view, null);
        ((TextView)view.findViewById(R.id.live_quick_reply_text)).setText(((LiveZanExtraModel.HotWords)paramList.get(i)).text);
        this.e.addView(view);
      } 
      this.e.setOnItemClickListener(new FlowLayout.OnItemClickListener(this, paramList) {
            public void a(View param1View, int param1Int) {
              Logger.a("drb", new Object[] { "mFlowLayout onItemClick" });
              TextView textView = (TextView)param1View.findViewById(R.id.live_quick_reply_text);
              if (QuickReplyView.a(this.b) != null)
                QuickReplyView.a(this.b).onItemClick((View)textView, this.a.get(param1Int)); 
              this.b.setVisibility(8);
              KeyboardUtils.a((Activity)QuickReplyView.b(this.b));
            }
          });
      return;
    } 
    setQuickReplyViewVisibility(8);
  }
  
  public void setMaxRows(int paramInt) {
    this.e.setMaxRows(paramInt);
  }
  
  public void setOnItemClickListener(OnItemClickListener paramOnItemClickListener) {
    this.g = paramOnItemClickListener;
  }
  
  public void setQuickReplyViewVisibility(int paramInt) {
    if (paramInt == 0) {
      if (!this.f) {
        if (this.e.getChildCount() > 0) {
          setVisibility(0);
          return;
        } 
        setVisibility(8);
        return;
      } 
    } else {
      setVisibility(8);
    } 
  }
  
  public static interface OnItemClickListener {
    void onItemClick(View param1View, LiveZanExtraModel.HotWords param1HotWords);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\QuickReplyView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */