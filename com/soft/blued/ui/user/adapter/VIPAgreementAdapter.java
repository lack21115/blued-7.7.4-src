package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.soft.blued.customview.LabeledTextView;
import com.soft.blued.ui.user.model.VIPBuyOptionForJsonParse;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.ArrayList;
import java.util.List;

public class VIPAgreementAdapter extends BaseAdapter {
  private List<VIPBuyOptionForJsonParse._rule_list> a;
  
  private Context b;
  
  private LayoutInflater c;
  
  public VIPAgreementAdapter(Context paramContext, List<VIPBuyOptionForJsonParse._rule_list> paramList) {
    this.b = paramContext;
    this.c = LayoutInflater.from(this.b);
    if (paramList != null) {
      this.a = paramList;
      return;
    } 
    this.a = new ArrayList<VIPBuyOptionForJsonParse._rule_list>();
  }
  
  public int getCount() {
    return this.a.size();
  }
  
  public Object getItem(int paramInt) {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder(this);
      View view = this.c.inflate(2131493678, paramViewGroup, false);
      viewHolder1.a = (LabeledTextView)view.findViewById(2131301088);
      viewHolder1.b = view.findViewById(2131298118);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    viewHolder1.b.setBackgroundColor(BluedSkinUtils.a(this.b, 2131100728));
    VIPBuyOptionForJsonParse._rule_list _rule_list = this.a.get(paramInt);
    if (_rule_list != null)
      viewHolder1.a.setTextTitle(_rule_list.title); 
    viewHolder2.setOnClickListener(new -$$Lambda$VIPAgreementAdapter$S58YcNxqzL7x6PZpQ9ZnpGvGILA(this, _rule_list));
    return (View)viewHolder2;
  }
  
  public class ViewHolder {
    public LabeledTextView a;
    
    public View b;
    
    public ViewHolder(VIPAgreementAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\VIPAgreementAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */