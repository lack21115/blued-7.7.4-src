package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.model.LiveFansRecommendModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.trackUtils.EventTrackLive;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class LiveFansRecommendAdapater extends BaseQuickAdapter<LiveFansRecommendModel, BaseViewHolder> {
  private Context a;
  
  private IRequestHost b;
  
  private List<LiveFansRecommendModel> c;
  
  private List<String> d;
  
  public LiveFansRecommendAdapater(IRequestHost paramIRequestHost, Context paramContext) {
    super(2131493855);
    this.a = paramContext;
    this.b = paramIRequestHost;
    this.c = new ArrayList<LiveFansRecommendModel>();
    this.d = new ArrayList<String>();
    c(this.c);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, LiveFansRecommendModel paramLiveFansRecommendModel) {
    String str1;
    String str2;
    if (!this.d.contains(paramLiveFansRecommendModel.lid)) {
      this.d.add(paramLiveFansRecommendModel.lid);
      EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_SHOW, paramLiveFansRecommendModel.lid, paramLiveFansRecommendModel.uid);
    } 
    if (paramLiveFansRecommendModel.anchor != null) {
      str1 = paramLiveFansRecommendModel.anchor.name;
      str2 = paramLiveFansRecommendModel.anchor.avatar;
    } else {
      str1 = "";
      str2 = str1;
    } 
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131296484);
    ImageLoader.a(this.b, str2).a(3.0F).a(imageView);
    TextView textView = (TextView)paramBaseViewHolder.d(2131297030);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLiveFansRecommendModel.fans_count);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    textView = (TextView)paramBaseViewHolder.d(2131296477);
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramLiveFansRecommendModel.realtime_count);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    ((TextView)paramBaseViewHolder.d(2131301088)).setText(str1);
    paramBaseViewHolder.d(2131299066).setOnClickListener(new View.OnClickListener(this, paramLiveFansRecommendModel) {
          public void onClick(View param1View) {
            String str1;
            String str2;
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_CLICK, this.a.lid, this.a.uid);
            ArrayList<LiveRoomData> arrayList = new ArrayList();
            for (int i = 0; i < LiveFansRecommendAdapater.a(this.b).size(); i++) {
              if (((LiveFansRecommendModel)LiveFansRecommendAdapater.b(this.b).get(i)).anchor != null) {
                str1 = ((LiveFansRecommendModel)LiveFansRecommendAdapater.c(this.b).get(i)).anchor.name;
                str2 = ((LiveFansRecommendModel)LiveFansRecommendAdapater.d(this.b).get(i)).anchor.avatar;
              } else {
                str1 = "";
                str2 = str1;
              } 
              arrayList.add(new LiveRoomData(StringUtils.a(((LiveFansRecommendModel)LiveFansRecommendAdapater.e(this.b).get(i)).lid, 0L), this.a.screen_pattern, "live_followed_grid_recommend", ((LiveFansRecommendModel)LiveFansRecommendAdapater.f(this.b).get(i)).uid, str1, str2, 0));
            } 
            if (this.a.anchor != null) {
              str1 = this.a.anchor.name;
              str2 = this.a.anchor.avatar;
            } else {
              str1 = "";
              str2 = str1;
            } 
            LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(this.a.lid, 0L), this.a.screen_pattern, "live_followed_grid_recommend", this.a.uid, str1, str2, 0);
            LiveRoomInfoChannel.a(LiveFansRecommendAdapater.g(this.b), liveRoomData, -1, arrayList);
          }
        });
  }
  
  public void a(List<LiveFansRecommendModel> paramList) {
    if (paramList == null)
      return; 
    this.d.clear();
    c(paramList);
  }
  
  public void b(List<LiveFansRecommendModel> paramList) {
    if (paramList == null)
      return; 
    a(paramList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\adapter\LiveFansRecommendAdapater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */