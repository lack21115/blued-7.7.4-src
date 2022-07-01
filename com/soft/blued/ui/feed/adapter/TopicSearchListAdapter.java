package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.utils.StringUtils;
import java.util.List;

public class TopicSearchListAdapter extends BaseAdapter {
  private Context a;
  
  private LayoutInflater b;
  
  private List<BluedTopic> c;
  
  private IRequestHost d;
  
  private String e;
  
  public int getCount() {
    return this.c.size();
  }
  
  public Object getItem(int paramInt) {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder;
    if (paramView == null) {
      viewHolder = new ViewHolder();
      paramView = this.b.inflate(2131493663, null);
      viewHolder.a = (ImageView)paramView.findViewById(2131297949);
      viewHolder.b = (TextView)paramView.findViewById(2131301443);
      viewHolder.c = (ImageView)paramView.findViewById(2131297948);
      viewHolder.d = (TextView)paramView.findViewById(2131301442);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    BluedTopic bluedTopic = this.c.get(paramInt);
    ImageLoader.a(this.d, AvatarUtils.a(0, bluedTopic.avatar)).a(2131234240).c().a(viewHolder.a);
    if (!TextUtils.isEmpty(bluedTopic.name)) {
      viewHolder.b.setText(bluedTopic.name);
    } else {
      viewHolder.b.setText("");
    } 
    String str = bluedTopic.name;
    if (!StringUtils.e(str) && !StringUtils.e(this.e)) {
      if (str.contains(this.e)) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        paramInt = 0;
        while (paramInt < str.length()) {
          int i = str.indexOf(this.e, paramInt);
          if (i >= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.a, 2131100527)), i, this.e.length() + i, 33);
            paramInt = Math.max(paramInt + 1, i);
          } 
        } 
        viewHolder.b.setText((CharSequence)spannableStringBuilder);
      } else {
        viewHolder.b.setText(str);
      } 
    } else {
      viewHolder.b.setText(str);
    } 
    long l = 0L;
    if (!TextUtils.isEmpty(bluedTopic.join_total))
      l = StringUtils.a(bluedTopic.join_total, 0); 
    TextView textView = viewHolder.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(l);
    stringBuilder.append(" ");
    stringBuilder.append(this.a.getResources().getString(2131757729));
    textView.setText(stringBuilder.toString());
    return paramView;
  }
  
  class ViewHolder {
    public ImageView a;
    
    public TextView b;
    
    public ImageView c;
    
    public TextView d;
    
    private ViewHolder(TopicSearchListAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\TopicSearchListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */