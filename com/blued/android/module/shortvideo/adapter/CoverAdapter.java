package com.blued.android.module.shortvideo.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.shortvideo.R;

public class CoverAdapter extends RecyclerView.Adapter<CoverAdapter.CoverItemViewHolder> {
  private Drawable a;
  
  private int b;
  
  public CoverItemViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    return new CoverItemViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.cover_item, paramViewGroup, false));
  }
  
  public void a(CoverItemViewHolder paramCoverItemViewHolder, int paramInt) {
    paramCoverItemViewHolder.q.setVisibility(8);
    if (this.b == paramInt) {
      paramCoverItemViewHolder.p.setAlpha(1.0F);
      paramCoverItemViewHolder.q.setVisibility(0);
    } else {
      paramCoverItemViewHolder.p.setAlpha(0.6F);
    } 
    paramCoverItemViewHolder.p.setTag(Integer.valueOf(paramInt));
    paramCoverItemViewHolder.p.setOnClickListener(new View.OnClickListener(this, paramInt) {
          public void onClick(View param1View) {
            CoverAdapter coverAdapter2 = this.b;
            coverAdapter2.notifyItemChanged(CoverAdapter.a(coverAdapter2));
            CoverAdapter.a(this.b, this.a);
            CoverAdapter.a(this.b, ((ImageView)param1View).getDrawable());
            CoverAdapter coverAdapter1 = this.b;
            coverAdapter1.notifyItemChanged(CoverAdapter.a(coverAdapter1));
          }
        });
  }
  
  public int getItemCount() {
    return 0;
  }
  
  public int getItemViewType(int paramInt) {
    return super.getItemViewType(paramInt);
  }
  
  public class CoverItemViewHolder extends RecyclerView.ViewHolder {
    ImageView p = (ImageView)this.itemView.findViewById(R.id.stv_cover_img);
    
    ImageView q = (ImageView)this.itemView.findViewById(R.id.stv_cover_selected_icon);
    
    public CoverItemViewHolder(CoverAdapter this$0, View param1View) {
      super(param1View);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\adapter\CoverAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */