package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.ui.user.model.UserGift;
import com.soft.blued.utils.StringUtils;
import java.util.List;

public class UserProfileGiftdapter extends RecyclerView.Adapter<UserProfileGiftdapter.GiftViewHolder> implements View.OnClickListener {
  private LayoutInflater a;
  
  private List<UserGift.Gift> b;
  
  private Context c;
  
  private IRequestHost d;
  
  private RecyclerViewItemClickListener e;
  
  public UserProfileGiftdapter(IRequestHost paramIRequestHost, Context paramContext, List<UserGift.Gift> paramList) {
    this.c = paramContext;
    this.d = paramIRequestHost;
    this.a = LayoutInflater.from(paramContext);
    this.b = paramList;
  }
  
  public View a() {
    return this.a.inflate(2131493669, null);
  }
  
  public GiftViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    View view = a();
    view.setOnClickListener(this);
    return new GiftViewHolder(this, view);
  }
  
  public void a(GiftViewHolder paramGiftViewHolder, int paramInt) {
    if (paramGiftViewHolder != null) {
      UserGift.Gift gift = this.b.get(paramInt);
      if (!StringUtils.e(gift.icon)) {
        ImageLoader.a(this.d, gift.icon).a(paramGiftViewHolder.p);
        paramGiftViewHolder.q.setTag(Integer.valueOf(paramInt));
      } 
    } 
  }
  
  public void a(RecyclerViewItemClickListener paramRecyclerViewItemClickListener) {
    this.e = paramRecyclerViewItemClickListener;
  }
  
  public int getItemCount() {
    return this.b.size();
  }
  
  public void onClick(View paramView) {
    if (this.e != null) {
      int i = 0;
      try {
        int j = ((Integer)paramView.getTag()).intValue();
        i = j;
      } catch (Exception exception) {}
      this.e.onItemClick(paramView, i);
    } 
  }
  
  class GiftViewHolder extends RecyclerView.ViewHolder {
    public ImageView p;
    
    public LinearLayout q;
    
    public GiftViewHolder(UserProfileGiftdapter this$0, View param1View) {
      super(param1View);
      this.p = (ImageView)param1View.findViewById(2131297521);
      this.q = (LinearLayout)param1View.findViewById(2131298758);
    }
  }
  
  public static interface RecyclerViewItemClickListener {
    void onItemClick(View param1View, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\UserProfileGiftdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */