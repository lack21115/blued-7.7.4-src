package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.DensityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.model.FeedRepost;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;
import com.soft.blued.ui.user.model.AlbumFlow;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class AlbumAdapterNew extends BaseQuickAdapter<AlbumFlow, BaseViewHolder> implements IFeedDataObserver {
  public int a;
  
  public int b = 3;
  
  public int c;
  
  public int d;
  
  public RecyclerView.OnScrollListener e = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        super.onScrollStateChanged(param1RecyclerView, param1Int);
      }
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
      }
    };
  
  private Context f;
  
  private ActivityFragmentActive g;
  
  public AlbumAdapterNew(Context paramContext, ActivityFragmentActive paramActivityFragmentActive) {
    super(2131494219, new ArrayList());
    this.f = paramContext;
    this.g = paramActivityFragmentActive;
    this.c = (this.f.getResources().getDisplayMetrics()).widthPixels;
    this.d = DensityUtils.a(this.f, 3.0F);
    this.a = (this.c - this.d * this.b - DensityUtils.a(this.f, 3.0F)) / this.b;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, AlbumFlow paramAlbumFlow) {
    if (this.n != null && this.n.size() > 0 && ((AlbumFlow)this.n.get(0)).showApply)
      return; 
    super.a(paramInt, paramAlbumFlow);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, AlbumFlow paramAlbumFlow) {
    if (paramBaseViewHolder != null) {
      String str;
      StringBuilder stringBuilder;
      FrameLayout frameLayout = (FrameLayout)paramBaseViewHolder.d(2131297133);
      GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams)frameLayout.getLayoutParams();
      int i = this.a;
      layoutParams.width = i;
      layoutParams.height = i;
      i = this.d;
      layoutParams.bottomMargin = i;
      layoutParams.rightMargin = i;
      if (paramBaseViewHolder.getAdapterPosition() <= 2) {
        layoutParams.topMargin = DensityUtils.a(this.f, 16.0F);
      } else {
        layoutParams.topMargin = 0;
      } 
      frameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297362);
      ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297403);
      ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131297518);
      TextView textView = (TextView)paramBaseViewHolder.d(2131299171);
      if ("1".equals(paramAlbumFlow.is_videos)) {
        imageView2.setVisibility(0);
      } else {
        imageView2.setVisibility(8);
      } 
      if (paramAlbumFlow.showApply) {
        imageView3.setVisibility(0);
        textView.setVisibility(0);
        textView.setText(paramAlbumFlow.lockText);
        if (paramAlbumFlow.feed_pics_width != null && paramAlbumFlow.feed_pics_width.length > 0 && StringUtils.a(paramAlbumFlow.feed_pics_width[0], 0) > 0 && paramAlbumFlow.feed_pics_height != null && paramAlbumFlow.feed_pics_height.length > 0 && StringUtils.a(paramAlbumFlow.feed_pics_height[0], 0) > 0 && StringUtils.a(paramAlbumFlow.feed_pics_height[0], 0) > StringUtils.a(paramAlbumFlow.feed_pics_width[0], 0) * 3) {
          str = paramAlbumFlow.getImageMogr(true);
        } else {
          str = "";
        } 
        ActivityFragmentActive activityFragmentActive = this.g;
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramAlbumFlow.album_pic);
        stringBuilder.append(str);
        ImageLoader.a((IRequestHost)activityFragmentActive, stringBuilder.toString()).a(6.0F).a(2131233538).c(2131233538).d().a(imageView1);
        return;
      } 
      stringBuilder.setVisibility(8);
      str.setVisibility(8);
      ImageLoader.a((IRequestHost)this.g, paramAlbumFlow.album_pic).a(6.0F).a(2131232201).a(imageView1);
    } 
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {}
  
  public void a(FeedComment paramFeedComment) {
    if (!StringUtils.e(paramFeedComment.feed_id)) {
      for (AlbumFlow albumFlow : this.n) {
        if (paramFeedComment.feed_id.equals(albumFlow.feed_id))
          albumFlow.feed_comment++; 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public void a(FeedRepost paramFeedRepost) {
    if (!StringUtils.e(paramFeedRepost.feed_id)) {
      for (AlbumFlow albumFlow : this.n) {
        if (paramFeedRepost.feed_id.equals(albumFlow.feed_id))
          albumFlow.repost_count++; 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public void a(String paramString, int paramInt) {
    if (!StringUtils.e(paramString)) {
      for (AlbumFlow albumFlow : this.n) {
        if (paramString.equals(albumFlow.feed_id))
          albumFlow.allow_comments = paramInt; 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public void a(String paramString1, String paramString2) {
    if (!StringUtils.e(paramString1)) {
      for (AlbumFlow albumFlow : this.n) {
        if (paramString1.equals(albumFlow.feed_id)) {
          int j = albumFlow.feed_comment;
          int i = j;
          if (j >= 1)
            i = j - 1; 
          albumFlow.feed_comment = i;
        } 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public void b(int paramInt) {}
  
  public void b(String paramString, int paramInt) {
    if (!StringUtils.e(paramString)) {
      for (AlbumFlow albumFlow : this.n) {
        if (paramString.equals(albumFlow.feed_id))
          albumFlow.reading_scope = paramInt; 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void c(String paramString, int paramInt) {
    if (!StringUtils.e(paramString)) {
      for (AlbumFlow albumFlow : this.n) {
        if (paramString.equals(albumFlow.feed_id)) {
          int i;
          int j = albumFlow.feed_dig;
          if (paramInt == 1) {
            i = j + 1;
            albumFlow.iliked = 1;
          } else {
            i = j;
            if (j >= 1)
              i = j - 1; 
            albumFlow.iliked = 0;
          } 
          albumFlow.feed_dig = i;
        } 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public void d(String paramString) {
    if (!StringUtils.e(paramString)) {
      Iterator iterator = this.n.iterator();
      while (iterator.hasNext()) {
        if (paramString.equals(((AlbumFlow)iterator.next()).feed_id))
          iterator.remove(); 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public void e(String paramString) {
    if (!StringUtils.e(paramString)) {
      for (AlbumFlow albumFlow : this.n) {
        if (paramString.equals(albumFlow.feed_id)) {
          int j = albumFlow.repost_count - 1;
          int i = j;
          if (j < 0)
            i = 0; 
          albumFlow.repost_count = i;
        } 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public static interface AlbumNotifyListener {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\AlbumAdapterNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */