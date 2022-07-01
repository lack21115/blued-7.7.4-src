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
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.ui.circle.fragment.CirclePostDetailsFragment;
import com.soft.blued.ui.feed.fragment.FeedDetailsFragment;
import com.soft.blued.ui.feed.fragment.ReplyCommentFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.notify.model.FeedNotice;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ViewPointNoticeAdapter extends BaseAdapter {
  private Context a;
  
  private LayoutInflater b;
  
  private List<FeedNotice> c;
  
  private LoadOptions d;
  
  private int e;
  
  private int f = 0;
  
  private LoadOptions g;
  
  private boolean h;
  
  private IRequestHost i;
  
  public ViewPointNoticeAdapter(Context paramContext, IRequestHost paramIRequestHost, boolean paramBoolean) {
    this.a = paramContext;
    this.i = paramIRequestHost;
    this.h = paramBoolean;
    this.b = LayoutInflater.from(this.a);
    this.g = new LoadOptions();
    LoadOptions loadOptions = this.g;
    loadOptions.d = 2131100615;
    loadOptions.b = 2131100615;
    this.c = new ArrayList<FeedNotice>();
    this.e = (this.a.getResources().getDisplayMetrics()).widthPixels;
    this.d = new LoadOptions();
    loadOptions = this.d;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
    int i = this.e;
    loadOptions.a(i >> 1, i >> 1);
  }
  
  public long a() {
    ArrayList<Long> arrayList = new ArrayList();
    List<FeedNotice> list = this.c;
    if (list != null && list.size() > 0) {
      Iterator<FeedNotice> iterator = this.c.iterator();
      while (iterator.hasNext())
        arrayList.add(Long.valueOf(((FeedNotice)iterator.next()).notification_id)); 
      return ((Long)Collections.<Long>max(arrayList)).longValue();
    } 
    return 0L;
  }
  
  public void a(int paramInt) {
    this.f = paramInt;
  }
  
  public void a(ViewHolder paramViewHolder, FeedNotice paramFeedNotice, View paramView, int paramInt) {
    paramViewHolder.a.setVisibility(0);
    if (paramFeedNotice.has_read == 0) {
      paramViewHolder.a.setBackgroundColor(BluedSkinUtils.a(this.a, 2131100881));
    } else {
      paramViewHolder.a.setBackgroundColor(BluedSkinUtils.a(this.a, 2131100728));
    } 
    UserRelationshipUtils.a(paramViewHolder.j, paramFeedNotice.vbadge, 3);
    ImageLoader.a(this.i, AvatarUtils.a(0, paramFeedNotice.avatar)).a(2131234356).c().a(paramViewHolder.b);
    paramViewHolder.b.setOnClickListener(new View.OnClickListener(this, paramFeedNotice, paramViewHolder) {
          public void onClick(View param1View) {
            this.a.has_read = 1;
            this.c.notifyDataSetChanged();
            UserInfoFragmentNew.a(ViewPointNoticeAdapter.a(this.c), (UserBasicModel)this.a, "", (View)this.b.b);
          }
        });
    if (!TextUtils.isEmpty(paramFeedNotice.note)) {
      paramViewHolder.f.setText(paramFeedNotice.note);
    } else {
      paramViewHolder.f.setText(paramFeedNotice.name);
    } 
    UserRelationshipUtils.a(this.a, paramViewHolder.f, (UserBasicModel)paramFeedNotice);
    UserRelationshipUtils.a(paramViewHolder.n, (UserBasicModel)paramFeedNotice);
    if ("0".equals(paramFeedNotice.type)) {
      paramViewHolder.g.setVisibility(0);
      paramViewHolder.h.setVisibility(8);
      if (!TextUtils.isEmpty(paramFeedNotice.content)) {
        TypefaceUtils.a(paramViewHolder.g, paramFeedNotice.content, 1, "");
      } else {
        paramViewHolder.g.setText("");
      } 
    } else {
      paramViewHolder.g.setVisibility(8);
      paramViewHolder.h.setVisibility(0);
      if (paramFeedNotice.from == 1) {
        paramViewHolder.h.setText(2131755884);
      } else if (paramFeedNotice.is_comments_liked == 1) {
        paramViewHolder.h.setText(this.a.getResources().getString(2131757120));
      } else {
        paramViewHolder.h.setText(this.a.getResources().getString(2131757119));
      } 
    } 
    if (!TextUtils.isEmpty(paramFeedNotice.timestamp)) {
      paramViewHolder.e.setText(TimeAndDateUtils.a(this.a, TimeAndDateUtils.b(paramFeedNotice.timestamp)));
    } else {
      paramViewHolder.e.setText("");
    } 
    if (paramFeedNotice.feed_pics != null && paramFeedNotice.feed_pics.length > 0) {
      paramViewHolder.i.setVisibility(8);
      paramViewHolder.c.setVisibility(0);
      paramViewHolder.d.setVisibility(8);
      ImageLoader.a(this.i, paramFeedNotice.feed_pics[0]).a(2131231369).a(paramViewHolder.c);
    } else if ("1".equals(paramFeedNotice.is_videos) && paramFeedNotice.feed_videos != null && paramFeedNotice.feed_videos.length > 0) {
      paramViewHolder.i.setVisibility(8);
      paramViewHolder.c.setVisibility(0);
      paramViewHolder.d.setVisibility(0);
      ImageLoader.a(this.i, paramFeedNotice.feed_videos[0]).a(2131231369).a(paramViewHolder.c);
    } else {
      paramViewHolder.i.setVisibility(0);
      paramViewHolder.c.setVisibility(8);
      paramViewHolder.d.setVisibility(8);
      if (!TextUtils.isEmpty(paramFeedNotice.feed_content)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringUtils.a(paramFeedNotice.feed_content, false, true, false, ""));
        stringBuilder.append("");
        String str = stringBuilder.toString();
        paramViewHolder.i.setText(str);
      } else {
        paramViewHolder.i.setText("");
      } 
    } 
    if (paramFeedNotice.from == 1) {
      paramViewHolder.l.setText(2131756571);
    } else {
      paramViewHolder.l.setText(2131756572);
    } 
    if (paramFeedNotice.from_top == 1) {
      paramViewHolder.m.setText(2131755962);
    } else {
      paramViewHolder.m.setText(2131758286);
    } 
    paramViewHolder.k.setOnClickListener(new View.OnClickListener(this, paramFeedNotice) {
          public void onClick(View param1View) {
            this.a.has_read = 1;
            this.b.notifyDataSetChanged();
            if (this.a.from == 1) {
              CirclePostDetailsFragment.a(ViewPointNoticeAdapter.a(this.b), this.a.feed_id, FeedProtos.NoteSource.NOTICE_LIKE_ENTER);
              return;
            } 
            BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
            bluedIngSelfFeed.feed_id = this.a.feed_id;
            bluedIngSelfFeed.aid = this.a.aid;
            bluedIngSelfFeed.is_ads = this.a.is_ads;
            FeedDetailsFragment.a(ViewPointNoticeAdapter.a(this.b), bluedIngSelfFeed, -1, 0);
          }
        });
    paramView.setOnClickListener(new View.OnClickListener(this, paramFeedNotice, paramViewHolder) {
          public void onClick(View param1View) {
            this.a.has_read = 1;
            this.c.notifyDataSetChanged();
            this.b.k.callOnClick();
          }
        });
    paramViewHolder.m.setOnClickListener(new View.OnClickListener(this, paramFeedNotice) {
          public void onClick(View param1View) {
            this.a.has_read = 1;
            this.b.notifyDataSetChanged();
            if (this.a.from_top == 1) {
              CirclePostDetailsFragment.a(ViewPointNoticeAdapter.a(this.b), this.a.feed_id, FeedProtos.NoteSource.NOTICE_LIKE_ENTER);
              return;
            } 
            ReplyCommentFragment.a(ViewPointNoticeAdapter.a(this.b), this.a);
          }
        });
  }
  
  public void a(List<FeedNotice> paramList) {
    if (this.c == null)
      this.c = new ArrayList<FeedNotice>(); 
    this.c.clear();
    if (paramList != null)
      this.c.addAll(paramList); 
    notifyDataSetChanged();
  }
  
  public FeedNotice b(int paramInt) {
    return this.c.get(paramInt);
  }
  
  public void b() {
    List<FeedNotice> list = this.c;
    if (list != null)
      list.clear(); 
    notifyDataSetChanged();
  }
  
  public void b(List<FeedNotice> paramList) {
    if (this.c == null)
      this.c = new ArrayList<FeedNotice>(); 
    if (paramList != null)
      this.c.addAll(paramList); 
    notifyDataSetChanged();
  }
  
  public int getCount() {
    List<FeedNotice> list = this.c;
    return (list != null) ? list.size() : 0;
  }
  
  public long getItemId(int paramInt) {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder2 = null;
    ViewHolder viewHolder1 = viewHolder2;
    View view = paramView;
    if (paramView != null)
      if (paramView.getTag() instanceof ViewHolder) {
        viewHolder1 = (ViewHolder)paramView.getTag();
        view = paramView;
      } else {
        view = null;
        viewHolder1 = viewHolder2;
      }  
    paramView = view;
    if (view == null) {
      viewHolder1 = new ViewHolder(this);
      paramView = this.b.inflate(2131493657, paramViewGroup, false);
      viewHolder1.a = paramView;
      viewHolder1.b = (ImageView)viewHolder1.a.findViewById(2131297362);
      viewHolder1.g = (TextView)viewHolder1.a.findViewById(2131299381);
      viewHolder1.f = (TextView)viewHolder1.a.findViewById(2131299358);
      viewHolder1.h = (TextView)viewHolder1.a.findViewById(2131301789);
      viewHolder1.i = (TextView)viewHolder1.a.findViewById(2131296838);
      viewHolder1.c = (ImageView)viewHolder1.a.findViewById(2131299472);
      viewHolder1.d = (ImageView)viewHolder1.a.findViewById(2131301596);
      viewHolder1.e = (TextView)viewHolder1.a.findViewById(2131300267);
      viewHolder1.j = (ImageView)viewHolder1.a.findViewById(2131297575);
      viewHolder1.k = viewHolder1.a.findViewById(2131298758);
      viewHolder1.l = (TextView)viewHolder1.a.findViewById(2131300786);
      viewHolder1.m = (TextView)viewHolder1.a.findViewById(2131300760);
      viewHolder1.n = (ImageView)viewHolder1.a.findViewById(2131297581);
      paramView.setTag(viewHolder1);
    } 
    FeedNotice feedNotice = this.c.get(paramInt);
    if (this.h) {
      viewHolder1.m.setVisibility(0);
    } else {
      viewHolder1.m.setVisibility(8);
    } 
    if (feedNotice != null) {
      viewHolder1.a.setVisibility(8);
      a(viewHolder1, feedNotice, paramView, paramInt);
      if (this.f == 1) {
        viewHolder1.l.setVisibility(8);
        return paramView;
      } 
      viewHolder1.l.setVisibility(0);
    } 
    return paramView;
  }
  
  public static interface USED_IN_PAGE {}
  
  public class ViewHolder {
    public View a;
    
    public ImageView b;
    
    public ImageView c;
    
    public ImageView d;
    
    public TextView e;
    
    public TextView f;
    
    public TextView g;
    
    public TextView h;
    
    public TextView i;
    
    public ImageView j;
    
    public View k;
    
    public TextView l;
    
    public TextView m;
    
    public ImageView n;
    
    public ViewHolder(ViewPointNoticeAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\adapter\ViewPointNoticeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */