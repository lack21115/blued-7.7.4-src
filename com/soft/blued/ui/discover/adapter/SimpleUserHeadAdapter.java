package com.soft.blued.ui.discover.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.PauseOnScrollListener;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

public class SimpleUserHeadAdapter extends RecyclerView.Adapter<SimpleUserHeadAdapter.MyViewHolder> {
  public static int b = 10;
  
  public List<UserBasicModel> a;
  
  private LayoutInflater c;
  
  private PauseOnScrollListener d;
  
  private View.OnClickListener e;
  
  private IRequestHost f;
  
  public MyViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    return new MyViewHolder(this, this.c.inflate(2131493655, paramViewGroup, false));
  }
  
  public void a(MyViewHolder paramMyViewHolder, int paramInt) {
    UserBasicModel userBasicModel = this.a.get(paramInt);
    ImageLoader.a(this.f, userBasicModel.avatar).a(2131234356).c().a(paramMyViewHolder.p);
    paramMyViewHolder.r.setImageResource(2131231095);
    UserRelationshipUtils.a(paramMyViewHolder.q, userBasicModel.vbadge, 3);
    if (paramInt == b - 1) {
      paramMyViewHolder.q.setVisibility(8);
      paramMyViewHolder.s.setVisibility(0);
      paramMyViewHolder.r.setVisibility(0);
    } else {
      paramMyViewHolder.s.setVisibility(8);
      paramMyViewHolder.r.setVisibility(8);
    } 
    if (this.e != null)
      paramMyViewHolder.p.setOnClickListener(this.e); 
  }
  
  public int getItemCount() {
    List<UserBasicModel> list = this.a;
    return (list != null) ? list.size() : 0;
  }
  
  class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView p;
    
    ImageView q;
    
    ImageView r;
    
    ImageView s;
    
    public MyViewHolder(SimpleUserHeadAdapter this$0, View param1View) {
      super(param1View);
      this.p = (ImageView)param1View.findViewById(2131297489);
      this.q = (ImageView)param1View.findViewById(2131297575);
      this.r = (ImageView)param1View.findViewById(2131297524);
      this.s = (ImageView)param1View.findViewById(2131297566);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\adapter\SimpleUserHeadAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */