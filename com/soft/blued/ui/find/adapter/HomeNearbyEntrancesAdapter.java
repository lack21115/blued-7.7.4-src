package com.soft.blued.ui.find.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.ui.find.model.JoyEntryModel;
import java.util.List;

public class HomeNearbyEntrancesAdapter extends RecyclerView.Adapter<HomeNearbyEntrancesAdapter.ViewHolder> implements View.OnClickListener {
  private LayoutInflater a;
  
  private List<JoyEntryModel> b;
  
  private IRequestHost c;
  
  private HomeNearbyEntranceItemClickListener d;
  
  public ViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    View view = this.a.inflate(2131493611, null);
    view.setOnClickListener(this);
    return new ViewHolder(this, view);
  }
  
  public void a(ViewHolder paramViewHolder, int paramInt) {
    if (paramViewHolder != null) {
      JoyEntryModel joyEntryModel = this.b.get(paramInt);
      paramViewHolder.q.setText(joyEntryModel.name);
      ImageLoader.a(this.c, joyEntryModel.icon).a(2131231369).a(paramViewHolder.p);
      paramViewHolder.r.setTag(Integer.valueOf(paramInt));
    } 
  }
  
  public int getItemCount() {
    return this.b.size();
  }
  
  public void onClick(View paramView) {
    int i = ((Integer)paramView.getTag()).intValue();
    HomeNearbyEntranceItemClickListener homeNearbyEntranceItemClickListener = this.d;
    if (homeNearbyEntranceItemClickListener != null)
      homeNearbyEntranceItemClickListener.a(paramView, i); 
  }
  
  public static interface HomeNearbyEntranceItemClickListener {
    void a(View param1View, int param1Int);
  }
  
  class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView p;
    
    public TextView q;
    
    public LinearLayout r;
    
    public ViewHolder(HomeNearbyEntrancesAdapter this$0, View param1View) {
      super(param1View);
      this.p = (ImageView)param1View.findViewById(2131297463);
      this.q = (TextView)param1View.findViewById(2131301088);
      this.r = (LinearLayout)param1View.findViewById(2131298758);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\HomeNearbyEntrancesAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */