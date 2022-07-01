package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.das.guy.GuyProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.ui.find.model.FindRecommendData;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.StringUtils;
import java.io.File;

public class RecommendMixedInNearbyAdapter extends BaseQuickAdapter<FindRecommendData, BaseViewHolder> {
  private IRequestHost a;
  
  public RecommendMixedInNearbyAdapter(Context paramContext, IRequestHost paramIRequestHost, RecyclerView paramRecyclerView) {
    super(2131493528);
    this.a = paramIRequestHost;
    this.k = paramContext;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, FindRecommendData paramFindRecommendData) {
    if (paramBaseViewHolder != null) {
      if (paramFindRecommendData == null)
        return; 
      RelativeLayout relativeLayout1 = (RelativeLayout)paramBaseViewHolder.d(2131299708);
      ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297362);
      TextView textView1 = (TextView)paramBaseViewHolder.d(2131301088);
      RelativeLayout relativeLayout2 = (RelativeLayout)paramBaseViewHolder.d(2131299709);
      ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131297367);
      ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297834);
      TextView textView2 = (TextView)paramBaseViewHolder.d(2131301089);
      if (!BluedConfig.b().G()) {
        textView1.setText(paramFindRecommendData.title);
        ImageLoader.a(this.a, paramFindRecommendData.pic).a(2131234356).c().a(imageView2);
        relativeLayout1.setVisibility(0);
        textView1.setVisibility(0);
        relativeLayout2.setVisibility(8);
        textView2.setVisibility(8);
      } else {
        textView2.setText(paramFindRecommendData.title);
        ImageLoader.a(this.a, paramFindRecommendData.pic).a(2131231368).a(imageView3);
        if (TextUtils.isEmpty(paramFindRecommendData.type_pic) || paramFindRecommendData.live_type == -1) {
          imageView1.setVisibility(8);
        } else {
          imageView1.setVisibility(0);
          ImageSize imageSize = new ImageSize();
          ImageFileLoader.a(this.a).a(paramFindRecommendData.type_pic).a(imageSize).a(new -$$Lambda$RecommendMixedInNearbyAdapter$G0x9ySje8gat5Z4lk-6nULuWDjg(this, imageSize, imageView1, paramFindRecommendData, paramBaseViewHolder)).a();
        } 
        relativeLayout1.setVisibility(8);
        textView1.setVisibility(8);
        relativeLayout2.setVisibility(0);
        textView2.setVisibility(0);
      } 
      paramBaseViewHolder.d(2131296768).setOnClickListener(new View.OnClickListener(this, paramFindRecommendData, paramBaseViewHolder) {
            public void onClick(View param1View) {
              if (this.a.type == 1) {
                GuyProtos.Event event = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_USER_CLICK;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a.uid);
                stringBuilder.append("");
                EventTrackGuy.a(event, stringBuilder.toString());
              } else if (this.a.type == 2) {
                GuyProtos.Event event = GuyProtos.Event.HOME_GUY_PAGE_LIVE_USER_CLICK;
                String str1 = this.a.live;
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(this.a.uid);
                stringBuilder1.append("");
                String str2 = stringBuilder1.toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(this.a.live_type);
                stringBuilder2.append("");
                EventTrackGuy.a(event, str1, str2, stringBuilder2.toString(), this.a.recommend_type, this.b.getAdapterPosition() - this.c.o());
              } 
              LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(this.a.live, 0L), 0, "nearby_mix_recommend", String.valueOf(this.a.uid), "", "", 0);
              liveRoomData.liveFrom = "home_live";
              liveRoomData.recommendType = this.a.recommend_type;
              liveRoomData.livePosition = this.b.getLayoutPosition() + 1;
              LiveRoomInfoChannel.a(RecommendMixedInNearbyAdapter.a(this.c), liveRoomData, this.b.getAdapterPosition(), LiveRoomInfoChannel.b(this.c.n(), "nearby_mix_recommend"));
            }
          });
      if (!paramFindRecommendData.isShowUrlVisited) {
        GuyProtos.Event event;
        paramFindRecommendData.isShowUrlVisited = true;
        if (paramFindRecommendData.type == 1) {
          event = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_USER_SHOW;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramFindRecommendData.uid);
          stringBuilder.append("");
          EventTrackGuy.a(event, stringBuilder.toString());
          return;
        } 
        if (paramFindRecommendData.type == 2) {
          GuyProtos.Event event1 = GuyProtos.Event.HOME_GUY_PAGE_LIVE_USER_SHOW;
          String str1 = paramFindRecommendData.live;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramFindRecommendData.uid);
          stringBuilder1.append("");
          String str2 = stringBuilder1.toString();
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(paramFindRecommendData.live_type);
          stringBuilder2.append("");
          EventTrackGuy.a(event1, str1, str2, stringBuilder2.toString(), paramFindRecommendData.recommend_type, event.getAdapterPosition() - o());
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\RecommendMixedInNearbyAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */