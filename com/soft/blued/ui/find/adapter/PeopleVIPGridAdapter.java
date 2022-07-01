package com.soft.blued.ui.find.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.das.client.featured.FeaturedProtos;
import com.blued.das.vip.VipProtos;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackFeatured;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DistanceUtils;
import java.util.List;

public class PeopleVIPGridAdapter extends PeopleGridQuickAdapter {
  public PeopleVIPGridAdapter(List<UserFindResult> paramList, Activity paramActivity, IRequestHost paramIRequestHost, String paramString, RecyclerView paramRecyclerView) {
    super(paramList, paramActivity, paramIRequestHost, paramString, paramRecyclerView);
    a();
  }
  
  public void b(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    boolean bool;
    String str;
    FrameLayout frameLayout = (FrameLayout)paramBaseViewHolder.d(2131297133);
    GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams)frameLayout.getLayoutParams();
    layoutParams.width = this.c;
    layoutParams.height = this.c;
    layoutParams.bottomMargin = this.i;
    layoutParams.rightMargin = this.i;
    frameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131301088);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131300663);
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297362);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131301325);
    View view = paramBaseViewHolder.d(2131297448);
    imageView.setVisibility(0);
    view.setVisibility(0);
    imageView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, this.c));
    FrameLayout.LayoutParams layoutParams1 = (FrameLayout.LayoutParams)view.getLayoutParams();
    layoutParams1.height = this.c * 2 / 5;
    layoutParams1.width = -1;
    view.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    if ((BluedConfig.b().c()).vip_grade == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool) {
      ImageLoader.a(this.s, paramUserFindResult.avatar).a(2131231368).a(imageView);
      imageView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              PayUtils.a(this.a.a, 2, "nearby_choice_for_you_buy", 26, VipProtos.FromType.UNKNOWN_FROM);
            }
          });
      paramBaseViewHolder.b(2131297448, false);
      return;
    } 
    imageView.setVisibility(0);
    if (!paramUserFindResult.isShowUrlVisited) {
      EventTrackFeatured.a(FeaturedProtos.Event.NEARBY_FEATURED_PHOTO_DRAW, paramUserFindResult.uid, paramUserFindResult.additional_tag_type, paramUserFindResult.selected_tag);
      paramUserFindResult.isShowUrlVisited = true;
    } 
    if (!TextUtils.isEmpty(paramUserFindResult.selected_tag)) {
      textView3.setVisibility(0);
      textView3.setText(paramUserFindResult.selected_tag);
    } else {
      textView3.setVisibility(8);
    } 
    if (!TextUtils.isEmpty(paramUserFindResult.note)) {
      textView1.setText(paramUserFindResult.note);
    } else if (!TextUtils.isEmpty(paramUserFindResult.name)) {
      textView1.setText(paramUserFindResult.name);
    } else {
      textView1.setText("");
    } 
    IRequestHost iRequestHost = this.s;
    if (paramUserFindResult.is_invisible_half == 1) {
      str = paramUserFindResult.avatar;
    } else {
      str = AvatarUtils.a(2, paramUserFindResult.avatar);
    } 
    ImageLoader.a(iRequestHost, str).a(2131231368).a(imageView);
    if (!TextUtils.isEmpty(paramUserFindResult.additional_tag_data)) {
      if (paramUserFindResult.additional_tag_type == 0) {
        textView2.setText(paramUserFindResult.distance);
        DistanceUtils.a(this.a, textView2, (UserBasicModel)paramUserFindResult, 1);
      } else {
        textView2.setText(paramUserFindResult.additional_tag_data);
      } 
    } else {
      textView2.setText("");
    } 
    imageView.setOnClickListener(new View.OnClickListener(this, paramBaseViewHolder, paramUserFindResult, imageView) {
          public void onClick(View param1View) {
            if (this.a.getAdapterPosition() != -1) {
              LogData logData = new LogData();
              logData.J = "click_position";
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.a.getAdapterPosition() / this.d.d);
              stringBuilder.append("");
              logData.l = stringBuilder.toString();
              logData.g = this.d.b;
              logData.c = this.b.uid;
              stringBuilder = new StringBuilder();
              stringBuilder.append(this.b.is_call);
              stringBuilder.append("");
              logData.u = stringBuilder.toString();
              logData.k = "0";
              InstantLog.a(logData);
              EventTrackFeatured.a(FeaturedProtos.Event.NEARBY_FEATURED_PHOTO_CLICK, this.b.uid, this.b.additional_tag_type, this.b.selected_tag);
              boolean bool1 = BluedPreferences.Y().equals("0-max");
              boolean bool = true;
              if ((bool1 ^ true) != 0) {
                InstantLog.g("personal_page", "1");
              } else {
                InstantLog.g("personal_page", "0");
              } 
              if (this.b.is_invisible_half == 1 && (((UserInfo.a().i()).vip_grade != 2 && (UserInfo.a().i()).vip_grade != 1) || (BluedConfig.b().j()).is_invisible_half == 0)) {
                PayUtils.a(this.d.a, 3, "user_half_invisible");
                return;
              } 
              PeopleVIPGridAdapter peopleVIPGridAdapter = this.d;
              UserFindResult userFindResult = this.b;
              ImageView imageView = this.c;
              if (userFindResult.live <= 0)
                bool = false; 
              peopleVIPGridAdapter.a(userFindResult, (View)imageView, bool, 0);
            } 
          }
        });
  }
  
  public void c() {
    b(10, 2131493383);
    b(11, 2131493623);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\PeopleVIPGridAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */