package com.blued.android.module.shortvideo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.ConfigData;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.model.FilterItem;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvViewUtils;

public class ConfigAdapter extends RecyclerView.Adapter<ConfigAdapter.MyViewHolder> {
  private static final String a = ConfigAdapter.class.getSimpleName();
  
  private ConfigData b;
  
  private CommonModel c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  public ConfigAdapter(CommonModel paramCommonModel) {
    this.c = paramCommonModel;
    this.b = new ConfigData(paramCommonModel);
  }
  
  public int a(boolean paramBoolean) {
    ConfigData configData = this.b;
    return (configData != null) ? configData.setCoverActivated(paramBoolean) : -1;
  }
  
  public MyViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    return new MyViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.config_view_item, paramViewGroup, false));
  }
  
  public void a() {
    notifyItemChanged(this.b.setCoverActivated(true));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    this.d = paramInt1;
    this.f = paramInt2;
    this.e = paramInt3;
    this.b.switchPage(paramInt1, this.f, this.e);
  }
  
  public void a(int paramInt, long paramLong) {
    int i = this.e;
    boolean bool = true;
    if (i == 1) {
      float f;
      ConfigData configData = this.b;
      if (paramInt > 0) {
        f = 0.4F;
      } else {
        f = 1.0F;
      } 
      i = configData.setMusicAlphas(f);
      configData = this.b;
      if (paramInt > 0)
        bool = false; 
      configData.setMusicActivated(bool);
      notifyItemChanged(i);
    } 
  }
  
  public void a(MyViewHolder paramMyViewHolder, int paramInt) {
    if (this.b.ids.size() - 1 >= paramInt) {
      paramMyViewHolder.a(((Integer)this.b.ids.get(paramInt)).intValue(), ((Integer)this.b.iconids.get(paramInt)).intValue(), ((Integer)this.b.nameids.get(paramInt)).intValue(), ((Float)this.b.alphas.get(paramInt)).floatValue(), ((Boolean)this.b.activateds.get(paramInt)).booleanValue());
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("ConfigAdapter onBindViewHolder() (mData.ids.length-1)<position");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
  }
  
  public void b() {
    int i;
    FilterItem filterItem;
    if (this.e == 4 && this.f == 3) {
      filterItem = this.c.getSelectedFilter();
    } else {
      filterItem = this.c.getSelectedFilter();
    } 
    if (filterItem != null && filterItem.b() != null) {
      i = this.b.setFilter(filterItem.b, filterItem.c);
    } else {
      i = this.b.setFilter(R.string.stv_config_filter_name, R.drawable.config_filter_icon);
    } 
    notifyItemChanged(i);
  }
  
  public int getItemCount() {
    ConfigData configData = this.b;
    return (configData != null) ? configData.ids.size() : 0;
  }
  
  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ImageView q;
    
    private TextView r;
    
    private int s;
    
    public MyViewHolder(ConfigAdapter this$0, View param1View) {
      super(param1View);
      param1View.setOnClickListener(this);
      this.q = (ImageView)param1View.findViewById(R.id.stv_config_item_image);
      this.r = (TextView)param1View.findViewById(R.id.stv_config_item_text);
    }
    
    public void a(int param1Int1, int param1Int2, int param1Int3, float param1Float, boolean param1Boolean) {
      this.s = param1Int1;
      this.q.setAlpha(param1Float);
      if (param1Int2 != -1)
        this.q.setImageResource(param1Int2); 
      this.q.setActivated(param1Boolean);
      param1Int1 = this.s;
      if (param1Int1 != 1) {
        if (param1Int1 != 2) {
          this.r.setText(param1Int3);
          return;
        } 
        this.r.setText(param1Int3);
        if (param1Int3 != ConfigAdapter.a(this.p).getDefaultFilterNameId()) {
          StvViewUtils.g(this.itemView.getContext(), this.itemView);
          return;
        } 
      } else {
        TextView textView = this.r;
        if (!param1Boolean)
          param1Int3 = R.string.stv_config_close_beauty_name; 
        textView.setText(param1Int3);
      } 
    }
    
    public void onClick(View param1View) {
      StvViewUtils.a(param1View);
      int i = this.s;
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
                if (i != 5)
                  return; 
                ObserverMgr.a().a(EventType.VALUE.d);
                return;
              } 
              ObserverMgr.a().a(EventType.VALUE.e);
              return;
            } 
            if (ConfigAdapter.b(this.p) < 60)
              StatisticsProxy.a().a("sv_coutdown_click"); 
            ObserverMgr.a().a(EventType.VALUE.m);
            return;
          } 
          ObserverMgr.a().a(EventType.VALUE.c);
          return;
        } 
        int j = this.q.isActivated() ^ true;
        if (j != 0) {
          this.r.setText(R.string.stv_config_open_beauty_name);
        } else {
          this.r.setText(R.string.stv_config_close_beauty_name);
        } 
        this.q.setActivated(j);
        ObserverMgr.a().a(EventType.VALUE.b);
        return;
      } 
      if (this.q.isActivated())
        ObserverMgr.a().a(EventType.VALUE.a); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\adapter\ConfigAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */