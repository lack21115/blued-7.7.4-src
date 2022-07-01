package com.soft.blued.ui.yy_room.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.model.YYBannerModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.ArrayList;
import java.util.List;

public class BannerPagerAdapter extends PagerAdapter {
  private Context a;
  
  private IRequestHost b;
  
  private List<YYBannerModel> c = new ArrayList<YYBannerModel>();
  
  public BannerPagerAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    this.a = paramContext;
    this.b = paramIRequestHost;
  }
  
  public void a(List<YYBannerModel> paramList) {
    if (paramList != null) {
      List<YYBannerModel> list = this.c;
      if (list != null) {
        list.clear();
      } else {
        this.c = new ArrayList<YYBannerModel>();
      } 
      this.c.addAll(paramList);
    } 
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount() {
    List<YYBannerModel> list = this.c;
    return (list != null) ? list.size() : 0;
  }
  
  public int getItemPosition(Object paramObject) {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
    YYBannerModel yYBannerModel = this.c.get(paramInt);
    String str = yYBannerModel.target_url;
    List list = yYBannerModel.show_url;
    View view = LayoutInflater.from(this.a).inflate(2131493598, paramViewGroup, false);
    ImageView imageView = (ImageView)view.findViewById(2131297419);
    ((ImageView)view.findViewById(2131297421)).setVisibility(8);
    ImageLoader.a(this.b, ((YYBannerModel)this.c.get(paramInt)).ads_pics).a(2131231369).a(imageView);
    if (!((YYBannerModel)this.c.get(paramInt)).isShowUrlVisited && list != null) {
      FindHttpUtils.a((String[])list.toArray((Object[])new String[0]));
      ((YYBannerModel)this.c.get(paramInt)).isShowUrlVisited = true;
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_BANNER_SHOW, yYBannerModel.ads_id);
    } 
    imageView.setOnClickListener(new View.OnClickListener(this, str, yYBannerModel) {
          public void onClick(View param1View) {
            if (TextUtils.isEmpty(this.a))
              return; 
            List list = this.b.click_url;
            if (list != null)
              FindHttpUtils.a((String[])list.toArray((Object[])new String[0])); 
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_BANNER_CLICK, this.b.ads_id);
            WebViewShowInfoFragment.show(BannerPagerAdapter.a(this.c), this.a, 9);
          }
        });
    paramViewGroup.addView(view);
    return view;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject) {
    return (paramView == paramObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\adapter\BannerPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */