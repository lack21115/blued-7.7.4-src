package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.utils.BlueAppChatLocal;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

public class RecommendedGroupAdapter extends RecyclerView.Adapter<RecommendedGroupAdapter.GroupViewHolder> {
  private Context a;
  
  private IRequestHost b;
  
  private List<BluedGroupLists> c;
  
  public RecommendedGroupAdapter(Context paramContext, IRequestHost paramIRequestHost, List<BluedGroupLists> paramList) {
    this.a = paramContext;
    this.b = paramIRequestHost;
    this.c = paramList;
  }
  
  public GroupViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    try {
      return new GroupViewHolder(this, LayoutInflater.from(this.a).inflate(2131493641, paramViewGroup, false));
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public void a(GroupViewHolder paramGroupViewHolder, int paramInt) {
    BluedGroupLists bluedGroupLists = this.c.get(paramInt);
    if (paramGroupViewHolder != null) {
      if (bluedGroupLists == null)
        return; 
      if (!TextUtils.isEmpty(bluedGroupLists.groups_distance)) {
        GroupViewHolder.a(paramGroupViewHolder).setText(DistanceUtils.b(bluedGroupLists.groups_distance, BlueAppLocal.c(), false));
        GroupViewHolder.a(paramGroupViewHolder).setVisibility(0);
      } else {
        GroupViewHolder.a(paramGroupViewHolder).setVisibility(4);
      } 
      if (BlueAppChatLocal.isZh()) {
        if (!TextUtils.isEmpty(bluedGroupLists.groups_members_count)) {
          TextView textView = GroupViewHolder.b(paramGroupViewHolder);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(StringUtils.a(bluedGroupLists.groups_members_count));
          stringBuilder.append("人");
          textView.setText(stringBuilder.toString());
          GroupViewHolder.b(paramGroupViewHolder).setVisibility(0);
        } else {
          GroupViewHolder.b(paramGroupViewHolder).setVisibility(4);
        } 
      } else if (!TextUtils.isEmpty(bluedGroupLists.groups_members_count)) {
        GroupViewHolder.b(paramGroupViewHolder).setText(StringUtils.a(bluedGroupLists.groups_members_count));
        GroupViewHolder.b(paramGroupViewHolder).setVisibility(0);
      } else {
        GroupViewHolder.b(paramGroupViewHolder).setVisibility(4);
      } 
      if (!TextUtils.isEmpty(bluedGroupLists.groups_name)) {
        GroupViewHolder.c(paramGroupViewHolder).setText(bluedGroupLists.groups_name);
        GroupViewHolder.c(paramGroupViewHolder).setVisibility(0);
      } else {
        GroupViewHolder.c(paramGroupViewHolder).setVisibility(4);
      } 
      ImageLoader.a(this.b, bluedGroupLists.groups_avatar).a(2131232322).c().a(GroupViewHolder.d(paramGroupViewHolder));
      UserRelationshipUtils.a(GroupViewHolder.e(paramGroupViewHolder), bluedGroupLists.vbadge, 3);
      GroupViewHolder.f(paramGroupViewHolder).setOnClickListener(new View.OnClickListener(this, bluedGroupLists) {
            public void onClick(View param1View) {
              InstantLog.a("groups_recommend");
              GroupInfoFragment.a(RecommendedGroupAdapter.a(this.b), this.a.groups_gid, "recommend");
            }
          });
    } 
  }
  
  public void a(List<BluedGroupLists> paramList) {
    this.c.clear();
    if (paramList != null)
      this.c.addAll(paramList); 
    notifyDataSetChanged();
  }
  
  public int getItemCount() {
    List<BluedGroupLists> list = this.c;
    return (list == null) ? 0 : list.size();
  }
  
  public class GroupViewHolder extends RecyclerView.ViewHolder {
    private TextView q;
    
    private TextView r;
    
    private TextView s;
    
    private ImageView t;
    
    private ConstraintLayout u;
    
    private ImageView v;
    
    public GroupViewHolder(RecommendedGroupAdapter this$0, View param1View) {
      super(param1View);
      this.u = (ConstraintLayout)param1View.findViewById(2131296769);
      this.q = (TextView)param1View.findViewById(2131300715);
      this.r = (TextView)param1View.findViewById(2131300851);
      this.s = (TextView)param1View.findViewById(2131300866);
      this.t = (ImageView)param1View.findViewById(2131297958);
      this.v = (ImageView)param1View.findViewById(2131296344);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\RecommendedGroupAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */