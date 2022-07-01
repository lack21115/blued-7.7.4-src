package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveMusicSheetModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LiveMusicTabAdapter extends BaseQuickAdapter<LiveMusicSheetModel, BaseViewHolder> {
  protected Context a;
  
  private RecyclerView b;
  
  private int c = 0;
  
  private Set<BaseViewHolder> d = new HashSet<BaseViewHolder>();
  
  private EventCallBack e;
  
  public LiveMusicTabAdapter(Context paramContext, RecyclerView paramRecyclerView) {
    super(R.layout.live_music_tab_view, new ArrayList());
    this.a = paramContext;
    this.b = paramRecyclerView;
  }
  
  private void a() {
    for (BaseViewHolder baseViewHolder : this.d) {
      int i = baseViewHolder.getLayoutPosition();
      if (n() != null && i < n().size() && i >= 0)
        a(n().get(i), i, baseViewHolder); 
    } 
  }
  
  private void a(LiveMusicSheetModel paramLiveMusicSheetModel, int paramInt, BaseViewHolder paramBaseViewHolder) {
    LinearLayoutManager linearLayoutManager;
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.tv_tab);
    if (paramInt == this.c) {
      textView.setTextColor(this.a.getResources().getColor(R.color.syc_dark_b));
      RecyclerView recyclerView = this.b;
      if (recyclerView != null) {
        linearLayoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
        int i = linearLayoutManager.findFirstVisibleItemPosition();
        int j = linearLayoutManager.findLastVisibleItemPosition();
        int k = this.c;
        paramInt = k;
        if (i >= 0) {
          paramInt = k;
          if (j >= 0)
            if (Math.abs(j - k) > Math.abs(i - this.c)) {
              paramInt = i;
              if (i >= 1)
                paramInt = i - 1; 
            } else {
              paramInt = k;
              if (Math.abs(j - this.c) < Math.abs(i - this.c)) {
                paramInt = j;
                if (j < n().size() - 1)
                  paramInt = j + 1; 
              } 
            }  
        } 
        this.b.smoothScrollToPosition(paramInt);
        return;
      } 
    } else {
      linearLayoutManager.setTextColor(this.a.getResources().getColor(R.color.syc_dark_j));
    } 
  }
  
  public void a(int paramInt) {
    if (this.c == paramInt)
      return; 
    this.c = paramInt;
    this.b.smoothScrollToPosition(paramInt);
    a();
  }
  
  public void a(EventCallBack paramEventCallBack) {
    this.e = paramEventCallBack;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, LiveMusicSheetModel paramLiveMusicSheetModel) {
    this.d.add(paramBaseViewHolder);
    int i = paramBaseViewHolder.getLayoutPosition();
    if (i < 0)
      return; 
    a(paramLiveMusicSheetModel, i, paramBaseViewHolder);
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.tv_tab);
    textView.setText(paramLiveMusicSheetModel.sheet_name);
    textView.setOnClickListener(new View.OnClickListener(this, i) {
          public void onClick(View param1View) {
            if (LiveMusicTabAdapter.a(this.b) != null)
              LiveMusicTabAdapter.a(this.b).a(this.a); 
          }
        });
  }
  
  public void a(List<LiveMusicSheetModel> paramList, int paramInt) {
    this.c = paramInt;
    this.d.clear();
    c(paramList);
    this.b.scrollToPosition(paramInt);
  }
  
  public static interface EventCallBack {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LiveMusicTabAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */