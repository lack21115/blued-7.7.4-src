package com.soft.blued.ui.msg.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.StringUtils;
import java.util.List;

public class SafeCommonContentListAdapter extends RecyclerView.Adapter {
  private List<MsgExtraForTextTypeEntity.SecureNotify.SecureContent> a;
  
  public SafeCommonContentListAdapter(List<MsgExtraForTextTypeEntity.SecureNotify.SecureContent> paramList) {
    this.a = paramList;
  }
  
  public int getItemCount() {
    List<MsgExtraForTextTypeEntity.SecureNotify.SecureContent> list = this.a;
    return (list == null) ? 0 : list.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    MsgExtraForTextTypeEntity.SecureNotify.SecureContent secureContent = this.a.get(paramInt);
    paramViewHolder = paramViewHolder;
    if (paramViewHolder != null)
      paramViewHolder.a(secureContent); 
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    return new SafeContentViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493954, paramViewGroup, false));
  }
  
  public class SafeContentViewHolder extends RecyclerView.ViewHolder {
    private TextView q;
    
    private TextView r;
    
    public SafeContentViewHolder(SafeCommonContentListAdapter this$0, View param1View) {
      super(param1View);
      this.q = (TextView)param1View.findViewById(2131299805);
      this.r = (TextView)param1View.findViewById(2131299806);
    }
    
    public void a(MsgExtraForTextTypeEntity.SecureNotify.SecureContent param1SecureContent) {
      if (param1SecureContent != null) {
        if (!TextUtils.isEmpty(param1SecureContent.title)) {
          this.q.setVisibility(0);
          this.q.setText(param1SecureContent.title);
        } else {
          this.q.setVisibility(8);
        } 
        if (!TextUtils.isEmpty(param1SecureContent.body))
          this.r.setText(StringUtils.b(param1SecureContent.body, param1SecureContent.link_title)); 
        this.itemView.setOnClickListener(new View.OnClickListener(this, param1SecureContent) {
              public void onClick(View param2View) {
                if (!TextUtils.isEmpty(this.a.link))
                  WebViewShowInfoFragment.show(this.b.itemView.getContext(), this.a.link, -1); 
              }
            });
      } 
    }
  }
  
  class null implements View.OnClickListener {
    null(SafeCommonContentListAdapter this$0, MsgExtraForTextTypeEntity.SecureNotify.SecureContent param1SecureContent) {}
    
    public void onClick(View param1View) {
      if (!TextUtils.isEmpty(this.a.link))
        WebViewShowInfoFragment.show(this.b.itemView.getContext(), this.a.link, -1); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\SafeCommonContentListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */