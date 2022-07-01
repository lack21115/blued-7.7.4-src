package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

public class ChooseFollowedListAdapter extends BaseAdapter {
  private Context a;
  
  private IRequestHost b;
  
  private LayoutInflater c;
  
  private List<BluedRecommendUsers> d = new ArrayList<BluedRecommendUsers>();
  
  private LoadOptions e;
  
  private String f = "";
  
  public ChooseFollowedListAdapter(IRequestHost paramIRequestHost, Context paramContext) {
    this.a = paramContext;
    this.b = paramIRequestHost;
    this.c = LayoutInflater.from(this.a);
    this.d = new ArrayList<BluedRecommendUsers>();
    this.e = new LoadOptions();
    LoadOptions loadOptions = this.e;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
  }
  
  public BluedRecommendUsers a(int paramInt) {
    return this.d.get(paramInt);
  }
  
  public void a() {
    this.d.clear();
    notifyDataSetChanged();
  }
  
  public void a(String paramString) {
    this.f = paramString;
    notifyDataSetChanged();
  }
  
  public void a(List<BluedRecommendUsers> paramList) {
    this.d.clear();
    this.d.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void b(List<BluedRecommendUsers> paramList) {
    this.d.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount() {
    return this.d.size();
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    int i = 0;
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = this.c.inflate(2131493477, paramViewGroup, false);
      viewHolder1.a = (ImageView)view.findViewById(2131297490);
      viewHolder1.b = (TextView)view.findViewById(2131301088);
      viewHolder1.d = (ImageView)view.findViewById(2131297575);
      viewHolder1.e = (ImageView)view.findViewById(2131297536);
      viewHolder1.f = (ImageView)view.findViewById(2131297447);
      viewHolder1.c = (TextView)view.findViewById(2131301121);
      viewHolder1.g = (ImageView)view.findViewById(2131297581);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    BluedRecommendUsers bluedRecommendUsers = this.d.get(paramInt);
    ImageLoader.a(this.b, AvatarUtils.a(0, bluedRecommendUsers.avatar)).c().a(2131234356).a(viewHolder1.a);
    String str = bluedRecommendUsers.name;
    if (StringUtils.e(bluedRecommendUsers.note)) {
      viewHolder1.c.setVisibility(8);
    } else {
      viewHolder1.c.setVisibility(0);
      TextView textView = viewHolder1.c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a.getResources().getString(2131758193));
      stringBuilder.append(bluedRecommendUsers.note);
      textView.setText(stringBuilder.toString());
    } 
    UserRelationshipUtils.a(viewHolder1.g, (UserBasicModel)bluedRecommendUsers);
    if (!StringUtils.e(bluedRecommendUsers.blued_pic)) {
      viewHolder1.f.setVisibility(0);
      ImageLoader.a(this.b, bluedRecommendUsers.blued_pic).a(2131231113).a(viewHolder1.f);
    } else {
      viewHolder1.f.setVisibility(8);
    } 
    if (1 == bluedRecommendUsers.online_state) {
      viewHolder1.e.setVisibility(0);
    } else {
      viewHolder1.e.setVisibility(8);
    } 
    if (!StringUtils.e(str)) {
      if (!StringUtils.e(this.f) && str.toLowerCase().contains(this.f.toLowerCase())) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        str = str.toLowerCase();
        this.f = this.f.toLowerCase();
        paramInt = i;
        while (paramInt < str.length()) {
          i = str.indexOf(this.f, paramInt);
          if (i >= 0) {
            spannableStringBuilder.setSpan(new StyleSpan(1), i, this.f.length() + i, 33);
            paramInt = Math.max(paramInt + 1, i);
          } 
        } 
        viewHolder1.b.setText((CharSequence)spannableStringBuilder);
      } else {
        viewHolder1.b.setText(str);
      } 
    } else {
      viewHolder1.b.setText("");
    } 
    UserRelationshipUtils.a(this.a, viewHolder1.b, (UserBasicModel)bluedRecommendUsers);
    UserRelationshipUtils.a(viewHolder1.d, bluedRecommendUsers.vbadge, 3);
    return (View)viewHolder2;
  }
  
  class ViewHolder {
    public ImageView a;
    
    public TextView b;
    
    public TextView c;
    
    public ImageView d;
    
    public ImageView e;
    
    public ImageView f;
    
    public ImageView g;
    
    private ViewHolder(ChooseFollowedListAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\ChooseFollowedListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */