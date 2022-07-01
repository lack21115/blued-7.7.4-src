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
import com.blued.android.module.live_china.model.AnchorMedal;
import com.blued.das.profile.PersonalProfileProtos;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.utils.StringUtils;
import java.util.List;

public class UserMedalsAdapter extends RecyclerView.Adapter<UserMedalsAdapter.MedalViewHolder> implements View.OnClickListener {
  private LayoutInflater a;
  
  private List<AnchorMedal> b;
  
  private Context c;
  
  private IRequestHost d;
  
  private RecyclerViewItemClickListener e;
  
  public UserMedalsAdapter(IRequestHost paramIRequestHost, Context paramContext, List<AnchorMedal> paramList) {
    this.c = paramContext;
    this.d = paramIRequestHost;
    this.a = LayoutInflater.from(paramContext);
    this.b = paramList;
  }
  
  public View a() {
    return this.a.inflate(2131493665, null);
  }
  
  public MedalViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    View view = a();
    view.setOnClickListener(this);
    return new MedalViewHolder(this, view);
  }
  
  public void a(MedalViewHolder paramMedalViewHolder, int paramInt) {
    if (paramMedalViewHolder != null) {
      AnchorMedal anchorMedal = this.b.get(paramInt);
      if (!StringUtils.e(anchorMedal.pic)) {
        ImageLoader.a(this.d, anchorMedal.pic).a(2131230933).a(paramMedalViewHolder.p);
        paramMedalViewHolder.q.setTag(Integer.valueOf(paramInt));
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
    int i = ((Integer)paramView.getTag()).intValue();
    if (this.e != null) {
      EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_MEDAL_CLICK);
      this.e.onItemClick(paramView, i);
    } 
  }
  
  class MedalViewHolder extends RecyclerView.ViewHolder {
    public ImageView p;
    
    public LinearLayout q;
    
    public MedalViewHolder(UserMedalsAdapter this$0, View param1View) {
      super(param1View);
      this.p = (ImageView)param1View.findViewById(2131297521);
      this.q = (LinearLayout)param1View.findViewById(2131298758);
    }
  }
  
  public static interface RecyclerViewItemClickListener {
    void onItemClick(View param1View, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\UserMedalsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */