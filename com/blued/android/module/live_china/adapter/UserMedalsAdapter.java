package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.AnchorMedal;
import java.util.List;

public class UserMedalsAdapter extends RecyclerView.Adapter<UserMedalsAdapter.MedalViewHolder> implements View.OnClickListener {
  private LayoutInflater a;
  
  private List<AnchorMedal> b;
  
  private Context c;
  
  private RecyclerViewItemClickListener d;
  
  public UserMedalsAdapter(Context paramContext, List<AnchorMedal> paramList) {
    this.c = paramContext;
    this.a = LayoutInflater.from(paramContext);
    this.b = paramList;
  }
  
  public View a() {
    return this.a.inflate(R.layout.item_user_anchor_medal4card, null);
  }
  
  public MedalViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    View view = a();
    view.setOnClickListener(this);
    return new MedalViewHolder(this, view);
  }
  
  public void a(MedalViewHolder paramMedalViewHolder, int paramInt) {
    if (paramMedalViewHolder != null) {
      AnchorMedal anchorMedal = this.b.get(paramInt);
      if (!TextUtils.isEmpty(anchorMedal.pic)) {
        ImageLoader.a(null, anchorMedal.pic).a(paramMedalViewHolder.p);
        paramMedalViewHolder.q.setTag(Integer.valueOf(paramInt));
      } 
    } 
  }
  
  public void a(RecyclerViewItemClickListener paramRecyclerViewItemClickListener) {
    this.d = paramRecyclerViewItemClickListener;
  }
  
  public int getItemCount() {
    return this.b.size();
  }
  
  public void onClick(View paramView) {
    int i = ((Integer)paramView.getTag()).intValue();
    RecyclerViewItemClickListener recyclerViewItemClickListener = this.d;
    if (recyclerViewItemClickListener != null)
      recyclerViewItemClickListener.a(paramView, i); 
  }
  
  class MedalViewHolder extends RecyclerView.ViewHolder {
    public ImageView p;
    
    public LinearLayout q;
    
    public MedalViewHolder(UserMedalsAdapter this$0, View param1View) {
      super(param1View);
      this.p = (ImageView)param1View.findViewById(R.id.img_medal);
      this.q = (LinearLayout)param1View.findViewById(R.id.ll_content);
    }
  }
  
  public static interface RecyclerViewItemClickListener {
    void a(View param1View, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\UserMedalsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */