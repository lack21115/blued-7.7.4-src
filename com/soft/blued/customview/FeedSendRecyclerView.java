package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.soft.blued.ui.feed.adapter.FeedSendRecyclerAdapter;
import com.soft.blued.ui.find.observer.FeedRefreshObserver;
import skin.support.widget.SkinCompatBackgroundHelper;

public class FeedSendRecyclerView extends RecyclerView implements BluedSkinSupportable, FeedRefreshObserver.IFeedRefreshObserver {
  private Context L;
  
  private IRequestHost M;
  
  private LinearLayoutManager N;
  
  private FeedSendRecyclerAdapter O;
  
  private SkinCompatBackgroundHelper P;
  
  public FeedSendRecyclerView(Context paramContext) {
    super(paramContext);
    this.L = paramContext;
    x();
  }
  
  public FeedSendRecyclerView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.L = paramContext;
    this.P = new SkinCompatBackgroundHelper((View)this);
    this.P.a(paramAttributeSet, 0);
    x();
  }
  
  private void x() {
    this.N = new LinearLayoutManager(this.L);
    setLayoutManager((RecyclerView.LayoutManager)this.N);
    setHasFixedSize(true);
    setItemAnimator((RecyclerView.ItemAnimator)new DefaultItemAnimator());
    this.O = new FeedSendRecyclerAdapter(this.L, this.M);
    setAdapter((RecyclerView.Adapter)this.O);
  }
  
  private void y() {
    FeedSendRecyclerAdapter feedSendRecyclerAdapter = this.O;
    if (feedSendRecyclerAdapter != null)
      feedSendRecyclerAdapter.notifyDataSetChanged(); 
  }
  
  public void a(Object paramObject, int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            if (paramInt != 4)
              return; 
            y();
            return;
          } 
          y();
          return;
        } 
        y();
        return;
      } 
      y();
      return;
    } 
    y();
  }
  
  public void g() {
    SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.P;
    if (skinCompatBackgroundHelper != null)
      skinCompatBackgroundHelper.a(); 
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.P;
    if (skinCompatBackgroundHelper != null)
      skinCompatBackgroundHelper.a(paramInt); 
  }
  
  public void setRequestHost(IRequestHost paramIRequestHost) {
    this.M = paramIRequestHost;
  }
  
  public void v() {
    FeedRefreshObserver.a().a(this);
  }
  
  public void w() {
    FeedRefreshObserver.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\FeedSendRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */