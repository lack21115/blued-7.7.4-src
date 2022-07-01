package com.soft.blued.ui.setting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.soft.blued.ui.setting.model.BluedIcon;
import java.util.List;

public class BluedIconAdapter extends RecyclerView.Adapter<BluedIconAdapter.ViewHolder> {
  private Context a;
  
  private OnItemClickListener b;
  
  private LayoutInflater c;
  
  private List<BluedIcon> d;
  
  public BluedIconAdapter(Context paramContext, List<BluedIcon> paramList) {
    this.a = paramContext;
    this.d = paramList;
    this.c = LayoutInflater.from(paramContext);
  }
  
  public ViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    return new ViewHolder(this, this.c.inflate(2131493427, null));
  }
  
  public void a(OnItemClickListener paramOnItemClickListener) {
    this.b = paramOnItemClickListener;
  }
  
  public void a(ViewHolder paramViewHolder, int paramInt) {
    if (paramViewHolder != null) {
      BluedIcon bluedIcon = this.d.get(paramInt);
      paramViewHolder.p.setImageResource(bluedIcon.getIconResourceId());
      if (bluedIcon.isChecked()) {
        paramViewHolder.p.getBackground().setAlpha(255);
      } else {
        paramViewHolder.p.getBackground().setAlpha(0);
      } 
      paramViewHolder.p.setOnClickListener(new View.OnClickListener(this, paramViewHolder) {
            public void onClick(View param1View) {
              if (BluedIconAdapter.a(this.b) != null && this.a.getAdapterPosition() != -1)
                BluedIconAdapter.a(this.b).a(param1View, this.a.getAdapterPosition()); 
            }
          });
    } 
  }
  
  public int getItemCount() {
    List<BluedIcon> list = this.d;
    return (list == null) ? 0 : list.size();
  }
  
  public static interface OnItemClickListener {
    void a(View param1View, int param1Int);
  }
  
  public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView p;
    
    public ViewHolder(BluedIconAdapter this$0, View param1View) {
      super(param1View);
      this.p = (ImageView)param1View.findViewById(2131297390);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\adapter\BluedIconAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */