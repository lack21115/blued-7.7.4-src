package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveActivityItemModel;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LiveActivityDotAdapter extends BaseMultiItemQuickAdapter<LiveActivityItemModel, BaseViewHolder> {
  protected Context a;
  
  int b = -1;
  
  private RecyclerView c;
  
  private int d = 0;
  
  private Set<BaseViewHolder> e = new HashSet<BaseViewHolder>();
  
  public LiveActivityDotAdapter(Context paramContext, List<LiveActivityItemModel> paramList, RecyclerView paramRecyclerView) {
    super(paramList);
    this.a = paramContext;
    this.c = paramRecyclerView;
    b(0, R.layout.live_activity_dot_item);
    c(paramList);
  }
  
  private void a() {
    for (BaseViewHolder baseViewHolder : this.e) {
      int i = baseViewHolder.getLayoutPosition();
      if (n() != null && i < n().size() && i >= 0)
        a(n().get(i), i, baseViewHolder); 
    } 
  }
  
  private void a(int paramInt, BaseViewHolder paramBaseViewHolder) {
    ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(R.id.tab_indicator);
    ViewGroup.LayoutParams layoutParams = shapeTextView.getLayoutParams();
    ShapeModel shapeModel = new ShapeModel();
    if (this.d == paramInt) {
      layoutParams.width = DensityUtils.a(this.a, 4.0F);
      layoutParams.height = DensityUtils.a(this.a, 4.0F);
      shapeModel.H = DensityUtils.a(this.a, 4.0F);
      shapeModel.k = ContextCompat.getColor(this.a, R.color.syc_dark_b);
    } else {
      if (n() != null && n().size() > 4 && this.c.getLayoutManager() instanceof LinearLayoutManager) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager)this.c.getLayoutManager();
        int i = linearLayoutManager.findLastVisibleItemPosition();
        if (paramInt == linearLayoutManager.findFirstVisibleItemPosition()) {
          layoutParams.width = DensityUtils.a(this.a, 3.0F);
          layoutParams.height = DensityUtils.a(this.a, 3.0F);
          shapeModel.H = DensityUtils.a(this.a, 3.0F);
        } else if (paramInt == i) {
          layoutParams.width = DensityUtils.a(this.a, 3.0F);
          layoutParams.height = DensityUtils.a(this.a, 3.0F);
          shapeModel.H = DensityUtils.a(this.a, 3.0F);
        } else {
          layoutParams.width = DensityUtils.a(this.a, 4.0F);
          layoutParams.height = DensityUtils.a(this.a, 4.0F);
          shapeModel.H = DensityUtils.a(this.a, 4.0F);
        } 
      } else {
        layoutParams.width = DensityUtils.a(this.a, 4.0F);
        layoutParams.height = DensityUtils.a(this.a, 4.0F);
        shapeModel.H = DensityUtils.a(this.a, 4.0F);
      } 
      shapeModel.k = ContextCompat.getColor(this.a, R.color.syc_afffffff);
      shapeTextView.clearAnimation();
    } 
    shapeTextView.setLayoutParams(layoutParams);
    shapeTextView.setShapeModel(shapeModel);
  }
  
  private void a(LiveActivityItemModel paramLiveActivityItemModel, int paramInt, BaseViewHolder paramBaseViewHolder) {
    a(paramInt, paramBaseViewHolder);
  }
  
  private void b() {
    if (this.c != null) {
      int k = this.b;
      int j = this.d;
      if (k < j) {
        i = j + 1;
      } else {
        i = j;
        if (k > j)
          i = j - 1; 
      } 
      this.b = this.d;
      j = i;
      if (i < 0)
        j = 0; 
      int i = j;
      if (j >= n().size() - 1)
        i = n().size() - 1; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("currentPositon:");
      stringBuilder.append(this.d);
      stringBuilder.append("  toPosition:");
      stringBuilder.append(i);
      Log.i("==cpp", stringBuilder.toString());
      this.c.smoothScrollToPosition(i);
    } 
  }
  
  public void a(int paramInt) {
    if (this.d == paramInt)
      return; 
    this.d = paramInt;
    b();
    a();
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, LiveActivityItemModel paramLiveActivityItemModel) {
    this.e.add(paramBaseViewHolder);
    int i = paramBaseViewHolder.getLayoutPosition();
    if (i < 0)
      return; 
    a(i, paramBaseViewHolder);
  }
  
  public void a(List<LiveActivityItemModel> paramList, int paramInt) {
    if (paramList == null)
      return; 
    this.d = paramInt;
    this.e.clear();
    c(paramList);
    this.c.scrollToPosition(paramInt);
    this.c.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
            super.onScrollStateChanged(param1RecyclerView, param1Int);
            if (param1Int == 0)
              LiveActivityDotAdapter.a(this.a); 
          }
          
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
          }
        });
    this.c.postDelayed(new Runnable(this) {
          public void run() {
            LiveActivityDotAdapter.a(this.a);
          }
        },  300L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LiveActivityDotAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */