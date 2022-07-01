package com.soft.blued.ui.msg.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity;
import java.util.List;

public class SafeSensitiveContentListAdapter extends RecyclerView.Adapter {
  private final int a = 0;
  
  private final int b = 1;
  
  private List<MsgExtraForTextTypeEntity.SecureNotify.SecureContent> c;
  
  private List<String> d;
  
  public SafeSensitiveContentListAdapter(List<MsgExtraForTextTypeEntity.SecureNotify.SecureContent> paramList, List<String> paramList1) {
    this.c = paramList;
    this.d = paramList1;
  }
  
  public int getItemCount() {
    List<MsgExtraForTextTypeEntity.SecureNotify.SecureContent> list = this.c;
    return (list == null) ? 0 : list.size();
  }
  
  public int getItemViewType(int paramInt) {
    MsgExtraForTextTypeEntity.SecureNotify.SecureContent secureContent = this.c.get(paramInt);
    return (secureContent != null && !TextUtils.isEmpty(secureContent.title)) ? 1 : 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    MsgExtraForTextTypeEntity.SecureNotify.SecureContent secureContent = this.c.get(paramInt);
    paramViewHolder = paramViewHolder;
    if (paramViewHolder != null)
      paramViewHolder.a(secureContent, this.d); 
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    View view = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493956, paramViewGroup, false);
    if (paramInt == 1) {
      paramInt = DensityUtils.a(AppInfo.d(), 60.0F);
    } else {
      paramInt = DensityUtils.a(AppInfo.d(), 49.0F);
    } 
    (view.getLayoutParams()).height = paramInt;
    return new SafeContentViewHolder(this, view);
  }
  
  public class SafeContentViewHolder extends RecyclerView.ViewHolder {
    private ImageView q;
    
    private TextView r;
    
    private TextView s;
    
    public SafeContentViewHolder(SafeSensitiveContentListAdapter this$0, View param1View) {
      super(param1View);
      this.q = (ImageView)param1View.findViewById(2131299803);
      this.r = (TextView)param1View.findViewById(2131299805);
      this.s = (TextView)param1View.findViewById(2131299806);
    }
    
    public void a(MsgExtraForTextTypeEntity.SecureNotify.SecureContent param1SecureContent, List<String> param1List) {
      if (param1SecureContent != null && !TextUtils.isEmpty(param1SecureContent.body))
        this.s.setText(param1SecureContent.body); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\SafeSensitiveContentListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */