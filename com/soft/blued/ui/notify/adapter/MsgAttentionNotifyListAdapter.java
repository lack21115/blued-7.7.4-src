package com.soft.blued.ui.notify.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.notify.model.FeedNotice;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MsgAttentionNotifyListAdapter extends BaseAdapter {
  private LayoutInflater a;
  
  private Context b;
  
  private List<FeedNotice> c;
  
  private IRequestHost d;
  
  public MsgAttentionNotifyListAdapter(IRequestHost paramIRequestHost, Context paramContext) {
    this.b = paramContext;
    this.d = paramIRequestHost;
    this.c = new ArrayList<FeedNotice>();
    this.a = LayoutInflater.from(this.b);
  }
  
  private void a(View paramView, FeedNotice paramFeedNotice) {
    if (paramFeedNotice.has_read == 0) {
      paramView.setBackgroundColor(BluedSkinUtils.a(this.b, 2131100881));
      return;
    } 
    paramView.setBackgroundColor(BluedSkinUtils.a(this.b, 2131100728));
  }
  
  private void a(FeedNotice paramFeedNotice, TextView paramTextView) {
    if (!TextUtils.isEmpty(paramFeedNotice.note)) {
      paramTextView.setText(paramFeedNotice.note);
    } else if (!TextUtils.isEmpty(paramFeedNotice.name)) {
      paramTextView.setText(paramFeedNotice.name);
    } 
    UserRelationshipUtils.a(this.b, paramTextView, (UserBasicModel)paramFeedNotice);
  }
  
  private void a(FeedNotice paramFeedNotice, ViewHolder paramViewHolder) {
    if (paramFeedNotice == null)
      return; 
    paramViewHolder.c.setText(MsgCommonUtils.a(this.b, TimeAndDateUtils.b(paramFeedNotice.timestamp)));
  }
  
  public List<FeedNotice> a() {
    return this.c;
  }
  
  public void a(List<FeedNotice> paramList, int paramInt) {
    List<FeedNotice> list = paramList;
    if (paramList == null)
      list = new ArrayList<FeedNotice>(); 
    this.c = list;
    notifyDataSetChanged();
  }
  
  public long b() {
    List<FeedNotice> list = this.c;
    if (list != null) {
      if (list.isEmpty())
        return 0L; 
      list = new ArrayList<FeedNotice>();
      Iterator<FeedNotice> iterator = this.c.iterator();
      while (iterator.hasNext())
        list.add(Long.valueOf(StringUtils.a(((FeedNotice)iterator.next()).timestamp, 0L))); 
      return ((Long)Collections.max(list)).longValue();
    } 
    return 0L;
  }
  
  public void c() {
    List<FeedNotice> list = this.c;
    if (list != null) {
      if (list.isEmpty())
        return; 
      this.c.clear();
      notifyDataSetChanged();
    } 
  }
  
  public int getCount() {
    List<FeedNotice> list = this.c;
    return (list == null) ? 0 : list.size();
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
      paramView = this.a.inflate(2131493599, paramViewGroup, false);
      viewHolder = new ViewHolder();
      viewHolder.d = (ImageView)paramView.findViewById(2131299261);
      viewHolder.e = (ImageView)paramView.findViewById(2131299277);
      viewHolder.a = (TextView)paramView.findViewById(2131299265);
      viewHolder.b = (TextView)paramView.findViewById(2131299263);
      viewHolder.c = (TextView)paramView.findViewById(2131299267);
      viewHolder.f = (ImageView)paramView.findViewById(2131297581);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    FeedNotice feedNotice = this.c.get(paramInt);
    ImageLoader.a(this.d, AvatarUtils.a(0, feedNotice.avatar)).a(2131234356).c().a(viewHolder.d);
    UserRelationshipUtils.a(viewHolder.e, feedNotice.vbadge, 3);
    UserRelationshipUtils.a(viewHolder.f, (UserBasicModel)feedNotice);
    a(feedNotice, viewHolder.a);
    a(feedNotice, viewHolder);
    a(paramView, feedNotice);
    paramView.setOnClickListener(new View.OnClickListener(this, feedNotice, viewHolder) {
          public void onClick(View param1View) {
            this.a.has_read = 1;
            this.c.notifyDataSetChanged();
            UserInfoFragmentNew.a(MsgAttentionNotifyListAdapter.a(this.c), (UserBasicModel)this.a, "", (View)this.b.d);
          }
        });
    return paramView;
  }
  
  class ViewHolder {
    TextView a;
    
    TextView b;
    
    TextView c;
    
    ImageView d;
    
    ImageView e;
    
    ImageView f;
    
    private ViewHolder(MsgAttentionNotifyListAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\adapter\MsgAttentionNotifyListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */