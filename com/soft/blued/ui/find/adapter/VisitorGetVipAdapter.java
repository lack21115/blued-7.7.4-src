package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.log.model.LogData;
import com.soft.blued.ui.find.model.BluedMyVisitorList;
import com.soft.blued.ui.find.viewholder.VisitorViewHolder;
import java.util.List;

public class VisitorGetVipAdapter extends BaseAdapter {
  private Context a;
  
  private IRequestHost b;
  
  private LoadOptions c;
  
  private List<BluedMyVisitorList> d;
  
  private LayoutInflater e;
  
  private List<Integer> f;
  
  public int getCount() {
    return this.d.size();
  }
  
  public Object getItem(int paramInt) {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    VisitorGetVipViewHolder visitorGetVipViewHolder1;
    VisitorGetVipViewHolder visitorGetVipViewHolder2;
    BluedMyVisitorList bluedMyVisitorList = this.d.get(paramInt);
    if (paramView == null) {
      View view = this.e.inflate(2131493695, null);
      visitorGetVipViewHolder1 = new VisitorGetVipViewHolder(this, this.a, view, this.c);
      view.setTag(visitorGetVipViewHolder1);
    } else {
      VisitorGetVipViewHolder visitorGetVipViewHolder = (VisitorGetVipViewHolder)visitorGetVipViewHolder1.getTag();
      visitorGetVipViewHolder2 = visitorGetVipViewHolder1;
      visitorGetVipViewHolder1 = visitorGetVipViewHolder;
    } 
    visitorGetVipViewHolder1.a(bluedMyVisitorList, paramInt);
    return (View)visitorGetVipViewHolder2;
  }
  
  public class VisitorGetVipViewHolder extends VisitorViewHolder {
    ImageView a;
    
    public VisitorGetVipViewHolder(VisitorGetVipAdapter this$0, Context param1Context, View param1View, LoadOptions param1LoadOptions) {
      super(param1Context, VisitorGetVipAdapter.a(this$0), param1View, param1LoadOptions, 1);
      this.a = (ImageView)param1View.findViewById(2131297428);
    }
    
    public void a(int param1Int) {
      if (param1Int < VisitorGetVipAdapter.b(this.b).size())
        this.a.setImageResource(((Integer)VisitorGetVipAdapter.b(this.b).get(param1Int)).intValue()); 
    }
    
    public void a(LogData param1LogData) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\VisitorGetVipAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */