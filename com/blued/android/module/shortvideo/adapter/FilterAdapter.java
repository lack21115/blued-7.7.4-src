package com.blued.android.module.shortvideo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.model.FilterItem;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import java.util.List;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterItemViewHolder> {
  private Context a;
  
  private List<FilterItem> b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private CommonModel f;
  
  public FilterAdapter(Context paramContext, CommonModel paramCommonModel) {
    this.a = paramContext;
    this.f = paramCommonModel;
  }
  
  public FilterItemViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    return new FilterItemViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.stv_filter_item, paramViewGroup, false));
  }
  
  public void a(int paramInt) {
    notifyItemChanged(this.c);
    this.c = paramInt;
    notifyItemChanged(this.c);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    CommonModel commonModel = this.f;
    if (commonModel == null)
      return; 
    this.d = paramInt2;
    this.e = paramInt3;
    paramInt1 = 0;
    if (this.e == 4 && this.d == 3) {
      boolean bool = commonModel.isUseData();
      this.b = this.f.getFilters();
      if (bool)
        paramInt1 = this.f.getSelectFilterPosition(); 
    } else {
      boolean bool = this.f.isUseData();
      this.b = this.f.getFilters();
      if (bool)
        paramInt1 = this.f.getSelectFilterPosition(); 
    } 
    AppInfo.n().postDelayed(new Runnable(this, paramInt1) {
          public void run() {
            this.b.a(this.a);
          }
        }1000L);
    notifyDataSetChanged();
  }
  
  public void a(FilterItemViewHolder paramFilterItemViewHolder, int paramInt) {
    FilterItem filterItem = this.b.get(paramInt);
    paramFilterItemViewHolder.p.setVisibility(8);
    if (this.c == paramInt)
      paramFilterItemViewHolder.p.setVisibility(0); 
    paramFilterItemViewHolder.r.setText(filterItem.a());
    paramFilterItemViewHolder.q.setImageResource(filterItem.c());
    paramFilterItemViewHolder.q.setTag(filterItem);
    paramFilterItemViewHolder.q.setOnClickListener(new View.OnClickListener(this, paramInt) {
          public void onClick(View param1View) {
            StvViewUtils.a(param1View);
            FilterAdapter filterAdapter = this.b;
            filterAdapter.notifyItemChanged(FilterAdapter.a(filterAdapter));
            FilterItem filterItem = (FilterItem)param1View.getTag();
            FilterAdapter.a(this.b, this.a);
            if (FilterAdapter.b(this.b) != null && FilterAdapter.b(this.b).getFrom() < 60)
              StatisticsProxy.a().a("sv_filter_click", FilterAdapter.a(this.b)); 
            filterAdapter = this.b;
            filterAdapter.notifyItemChanged(FilterAdapter.a(filterAdapter));
            if (FilterAdapter.b(this.b) != null) {
              FilterAdapter.b(this.b).setSelectedFilter(filterItem);
              FilterAdapter.b(this.b).setSelectFilterPosition(FilterAdapter.a(this.b));
            } 
            ObserverMgr.a().a(EventType.VALUE.n);
          }
        });
  }
  
  public int getItemCount() {
    List<FilterItem> list = this.b;
    return (list != null) ? list.size() : 0;
  }
  
  public int getItemViewType(int paramInt) {
    return super.getItemViewType(paramInt);
  }
  
  public class FilterItemViewHolder extends RecyclerView.ViewHolder {
    public ImageView p;
    
    public ImageView q;
    
    public TextView r;
    
    public FilterItemViewHolder(FilterAdapter this$0, View param1View) {
      super(param1View);
      this.q = (ImageView)param1View.findViewById(R.id.stv_filter_icon);
      this.p = (ImageView)param1View.findViewById(R.id.stv_filter_selected_icon);
      this.r = (TextView)param1View.findViewById(R.id.stv_filter_name);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\adapter\FilterAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */