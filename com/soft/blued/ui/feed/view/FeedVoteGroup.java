package com.soft.blued.ui.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;

public class FeedVoteGroup extends RelativeLayout {
  private FeedVoteView a = new FeedVoteView(getContext());
  
  private FeedVoteView b = new FeedVoteView(getContext());
  
  private ImageView c = new ImageView(getContext());
  
  private OnViewClickListener d;
  
  private boolean e = false;
  
  public FeedVoteGroup(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public FeedVoteGroup(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public FeedVoteGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    int i = (int)((AppInfo.l - DensityUtils.a(getContext(), 30.0F)) * 600.0F / 690.0F);
    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
    addView((View)this.c, (ViewGroup.LayoutParams)layoutParams);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(0, -1, 1.0F);
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, 1.0F);
    LinearLayout linearLayout = new LinearLayout(getContext());
    linearLayout.addView((View)this.a, (ViewGroup.LayoutParams)layoutParams1);
    linearLayout.addView((View)this.b, (ViewGroup.LayoutParams)layoutParams2);
    addView((View)linearLayout, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, i));
    this.a.setLeft(true);
    this.b.setLeft(false);
    b();
  }
  
  private void b() {
    this.a.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (FeedVoteGroup.a(this.a) != null) {
              if (FeedVoteGroup.b(this.a)) {
                FeedVoteGroup.a(this.a).b(true);
                return;
              } 
              FeedVoteGroup.a(this.a).a(true);
            } 
          }
        });
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (FeedVoteGroup.a(this.a) != null) {
              if (FeedVoteGroup.b(this.a)) {
                FeedVoteGroup.a(this.a).b(false);
                return;
              } 
              FeedVoteGroup.a(this.a).a(false);
            } 
          }
        });
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.a.setPercent(paramInt1);
    this.b.setPercent(paramInt2);
  }
  
  public void a(IRequestHost paramIRequestHost) {
    this.a.a(paramIRequestHost);
    this.b.a(paramIRequestHost);
  }
  
  public void a(IRequestHost paramIRequestHost, String paramString) {
    ImageLoader.a(paramIRequestHost, paramString).a(this.c);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    this.e = paramBoolean1;
    if (paramBoolean2) {
      this.a.setShowOk(true);
      this.b.setShowOk(false);
    } else {
      this.a.setShowOk(false);
      this.b.setShowOk(true);
    } 
    this.a.setVoted(paramBoolean1);
    this.b.setVoted(paramBoolean1);
  }
  
  public void setOnViewClickListener(OnViewClickListener paramOnViewClickListener) {
    this.d = paramOnViewClickListener;
  }
  
  public void setVote(boolean paramBoolean) {
    this.e = paramBoolean;
    this.a.setVoted(paramBoolean);
    this.b.setVoted(paramBoolean);
  }
  
  public static interface OnViewClickListener {
    void a(boolean param1Boolean);
    
    void b(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\view\FeedVoteGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */