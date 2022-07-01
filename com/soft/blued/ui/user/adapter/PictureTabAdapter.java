package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.soft.blued.ui.user.model.PictureTabModel;
import java.util.List;

public class PictureTabAdapter extends RecyclerView.Adapter<PictureTabAdapter.MyViewHolder> implements View.OnClickListener {
  private Context a;
  
  private MyItemClickListener b;
  
  private List<PictureTabModel> c;
  
  public PictureTabAdapter(Context paramContext, List<PictureTabModel> paramList) {
    this.a = paramContext;
    this.c = paramList;
  }
  
  public MyViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    MyViewHolder myViewHolder = new MyViewHolder(this, LayoutInflater.from(this.a).inflate(2131493535, paramViewGroup, false));
    myViewHolder.p.setOnClickListener(this);
    return myViewHolder;
  }
  
  public void a(MyItemClickListener paramMyItemClickListener) {
    this.b = paramMyItemClickListener;
  }
  
  public void a(MyViewHolder paramMyViewHolder, int paramInt) {
    PictureTabModel pictureTabModel = this.c.get(paramInt);
    if (paramMyViewHolder != null && pictureTabModel != null) {
      paramMyViewHolder.q.setText(pictureTabModel.name);
      paramMyViewHolder.p.setTag(Integer.valueOf(paramInt));
    } 
  }
  
  public int getItemCount() {
    List<PictureTabModel> list = this.c;
    return (list == null) ? 0 : list.size();
  }
  
  public void onClick(View paramView) {
    MyItemClickListener myItemClickListener = this.b;
    if (myItemClickListener != null)
      myItemClickListener.a(paramView, ((Integer)paramView.getTag()).intValue()); 
  }
  
  public static interface MyItemClickListener {
    void a(View param1View, int param1Int);
  }
  
  public class MyViewHolder extends RecyclerView.ViewHolder {
    public View p;
    
    public TextView q;
    
    public MyViewHolder(PictureTabAdapter this$0, View param1View) {
      super(param1View);
      this.q = (TextView)param1View.findViewById(2131301368);
      this.p = param1View.findViewById(2131297158);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\PictureTabAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */