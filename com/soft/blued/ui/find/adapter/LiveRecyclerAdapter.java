package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import java.util.ArrayList;
import java.util.List;

public class LiveRecyclerAdapter extends BaseQuickAdapter<UserFindResult, BaseViewHolder> {
  public Context a;
  
  public LiveRecyclerAdapter(Context paramContext) {
    super(2131493613, new ArrayList());
    this.a = paramContext;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    if (paramBaseViewHolder != null) {
      ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297489);
      ImageLoader.a(null, paramUserFindResult.avatar).a(2131234356).a(1.5F, -9411593).a(imageView2);
      imageView2.setOnClickListener(new View.OnClickListener(this, paramUserFindResult) {
            public void onClick(View param1View) {
              int i = 0;
              InstantLog.b("nearby_model", 0);
              ArrayList<LiveRoomData> arrayList = new ArrayList();
              while (i < LiveRecyclerAdapter.a(this.b).size()) {
                arrayList.add(new LiveRoomData(((UserFindResult)LiveRecyclerAdapter.b(this.b).get(i)).live, 0, ((UserFindResult)LiveRecyclerAdapter.c(this.b).get(i)).source, ((UserFindResult)LiveRecyclerAdapter.d(this.b).get(i)).uid, ((UserFindResult)LiveRecyclerAdapter.e(this.b).get(i)).name, ((UserFindResult)LiveRecyclerAdapter.f(this.b).get(i)).avatar, ((UserFindResult)LiveRecyclerAdapter.g(this.b).get(i)).vbadge));
                i++;
              } 
              LiveRoomData liveRoomData = new LiveRoomData(this.a.live, 0, this.a.source, this.a.uid, this.a.name, this.a.avatar, this.a.vbadge);
              LiveRoomInfoChannel.a(this.b.a, liveRoomData, -1, arrayList);
            }
          });
      ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297509);
      if (paramUserFindResult.live_type == 1) {
        imageView1.setImageResource(2131232261);
      } else {
        int i = paramUserFindResult.link_type;
        if (i != 1) {
          if (i != 2) {
            imageView1.setImageResource(2131232260);
          } else {
            imageView1.setImageResource(2131232259);
          } 
        } else {
          imageView1.setImageResource(2131233231);
        } 
      } 
      if (!paramUserFindResult.isShowUrlVisited) {
        String str1;
        String str2 = paramUserFindResult.uid;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramUserFindResult.live);
        stringBuilder.append("");
        String str3 = stringBuilder.toString();
        String str4 = paramUserFindResult.source;
        if (paramUserFindResult.link_type == 1) {
          str1 = "1";
        } else {
          str1 = "0";
        } 
        InstantLog.a(0, str2, str3, str4, str1, String.valueOf(paramUserFindResult.realtime_count));
        paramUserFindResult.isShowUrlVisited = true;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\LiveRecyclerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */