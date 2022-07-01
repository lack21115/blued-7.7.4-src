package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.das.vip.VipProtos;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.user.model.VIPCenterForJsonParse;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import java.util.ArrayList;
import java.util.List;

public class VIPCenterBannerAdapter extends PagerAdapter {
  private List<View> a = new ArrayList<View>();
  
  private int b;
  
  public VIPCenterBannerAdapter(Context paramContext, IRequestHost paramIRequestHost, int paramInt, List<VIPCenterForJsonParse._banner> paramList) {
    this.b = paramInt;
    if (paramList != null && paramList.size() > 0) {
      for (VIPCenterForJsonParse._banner _banner : paramList) {
        View view = LayoutInflater.from(paramContext).inflate(2131493685, null);
        ImageView imageView = (ImageView)view.findViewById(2131297539);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageLoader.a(paramIRequestHost, _banner.img).a(2131231369).a(imageView);
        view.setOnClickListener(new -$$Lambda$VIPCenterBannerAdapter$Z9EsfbfbIP6lYa0sQ3miIg3bjUc(paramInt, _banner, paramContext));
        view.setTag(_banner);
        this.a.add(view);
      } 
      notifyDataSetChanged();
    } 
  }
  
  public VIPCenterForJsonParse._banner a(int paramInt) {
    List<View> list = this.a;
    return (list != null && paramInt < list.size()) ? (VIPCenterForJsonParse._banner)((View)this.a.get(paramInt)).getTag() : null;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount() {
    List<View> list = this.a;
    return (list != null) ? list.size() : 0;
  }
  
  public int getItemPosition(Object paramObject) {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
    paramViewGroup.addView(this.a.get(paramInt));
    return this.a.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject) {
    return (paramView == paramObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\VIPCenterBannerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */