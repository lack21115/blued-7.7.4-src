package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.soft.blued.ui.find.model.SearchPositionModel;
import java.util.ArrayList;
import java.util.List;

public class MapSearchPositionAdapter extends RecyclerView.Adapter<MapSearchPositionAdapter.ViewHolder> {
  private Context a;
  
  private List<SearchPositionModel> b;
  
  private LayoutInflater c;
  
  private OnItemClickListener d;
  
  public MapSearchPositionAdapter(Context paramContext, List<SearchPositionModel> paramList) {
    this.a = paramContext;
    if (paramList.size() > 0) {
      SearchPositionModel searchPositionModel = new SearchPositionModel();
      searchPositionModel.isDel = true;
      paramList.add(searchPositionModel);
    } 
    this.b = paramList;
  }
  
  public MapSearchPositionAdapter(Context paramContext, List<String> paramList, int paramInt) {
    this.a = paramContext;
    this.b = c(paramList, true);
  }
  
  private List<SearchPositionModel> c(List<String> paramList, boolean paramBoolean) {
    ArrayList<SearchPositionModel> arrayList = new ArrayList();
    for (String str : paramList) {
      SearchPositionModel searchPositionModel = new SearchPositionModel();
      searchPositionModel.name = str;
      arrayList.add(searchPositionModel);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getModelList list.size():");
    stringBuilder.append(arrayList.size());
    Log.v("drb", stringBuilder.toString());
    if (arrayList.size() > 0 && paramBoolean) {
      SearchPositionModel searchPositionModel = new SearchPositionModel();
      searchPositionModel.isDel = true;
      arrayList.add(searchPositionModel);
    } 
    return arrayList;
  }
  
  public ViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    this.c = LayoutInflater.from(this.a);
    return new ViewHolder(this, this.c.inflate(2131493592, paramViewGroup, false));
  }
  
  public void a() {
    this.b.clear();
    notifyDataSetChanged();
  }
  
  public void a(OnItemClickListener paramOnItemClickListener) {
    this.d = paramOnItemClickListener;
  }
  
  public void a(ViewHolder paramViewHolder, int paramInt) {
    SearchPositionModel searchPositionModel = this.b.get(paramInt);
    if (searchPositionModel.isDel) {
      paramViewHolder.q.setVisibility(8);
      paramViewHolder.s.setVisibility(8);
      paramViewHolder.r.setVisibility(0);
    } else {
      paramViewHolder.q.setVisibility(0);
      paramViewHolder.s.setVisibility(0);
      paramViewHolder.r.setVisibility(8);
    } 
    paramViewHolder.q.setText(searchPositionModel.name);
    paramViewHolder.p.setOnClickListener(new View.OnClickListener(this, paramViewHolder, searchPositionModel) {
          public void onClick(View param1View) {
            if (MapSearchPositionAdapter.a(this.c) != null && this.a.getAdapterPosition() != -1)
              MapSearchPositionAdapter.a(this.c).a(param1View, this.a.getAdapterPosition(), this.b); 
          }
        });
  }
  
  public void a(List<String> paramList, boolean paramBoolean) {
    this.b = c(paramList, paramBoolean);
    notifyDataSetChanged();
  }
  
  public void b(List<SearchPositionModel> paramList, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setDataList dataList.size():");
    stringBuilder.append(paramList.size());
    Log.v("drb", stringBuilder.toString());
    if (paramList.size() > 0 && paramBoolean && !((SearchPositionModel)paramList.get(paramList.size() - 1)).isDel) {
      SearchPositionModel searchPositionModel = new SearchPositionModel();
      searchPositionModel.isDel = true;
      paramList.add(searchPositionModel);
    } 
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public int getItemCount() {
    List<SearchPositionModel> list = this.b;
    return (list != null) ? list.size() : 0;
  }
  
  public static interface OnItemClickListener {
    void a(View param1View, int param1Int, SearchPositionModel param1SearchPositionModel);
  }
  
  public class ViewHolder extends RecyclerView.ViewHolder {
    public ConstraintLayout p;
    
    public TextView q;
    
    public TextView r;
    
    public TextView s;
    
    public ViewHolder(MapSearchPositionAdapter this$0, View param1View) {
      super(param1View);
      this.p = (ConstraintLayout)param1View.findViewById(2131297617);
      this.q = (TextView)param1View.findViewById(2131300463);
      this.r = (TextView)param1View.findViewById(2131300701);
      this.s = (TextView)param1View.findViewById(2131300960);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\MapSearchPositionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */