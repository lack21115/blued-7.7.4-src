package com.soft.blued.ui.msg.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.click.SingleClickProxy;

public class HelloListQuickAdapter extends HelloGridQuickAdapter {
  public void a(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    if (paramBaseViewHolder != null) {
      paramBaseViewHolder.getItemViewType();
      b(paramBaseViewHolder, paramUserFindResult);
    } 
  }
  
  public void b(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    String str;
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297362);
    TextView textView6 = (TextView)paramBaseViewHolder.d(2131299358);
    TextView textView7 = (TextView)paramBaseViewHolder.d(2131296943);
    TextView textView5 = (TextView)paramBaseViewHolder.d(2131299415);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131296426);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131297368);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131301755);
    TextView textView4 = (TextView)paramBaseViewHolder.d(2131299959);
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297575);
    ImageView imageView4 = (ImageView)paramBaseViewHolder.d(2131297536);
    ImageView imageView5 = (ImageView)paramBaseViewHolder.d(2131298138);
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131297447);
    View view = paramBaseViewHolder.d(2131298064);
    ImageView imageView6 = (ImageView)paramBaseViewHolder.d(2131297512);
    LinearLayout linearLayout = (LinearLayout)paramBaseViewHolder.d(2131299013);
    imageView1.setVisibility(0);
    UserRelationshipUtils.b(imageView1, paramUserFindResult.vbadge, 4, 8);
    imageView4.setVisibility(0);
    imageView6.setVisibility(8);
    if (paramUserFindResult.call_tip == 1) {
      imageView5.setVisibility(0);
    } else {
      imageView5.setVisibility(8);
    } 
    if (paramUserFindResult.live > 0) {
      imageView4.setVisibility(8);
      imageView5.setVisibility(8);
      imageView6.setVisibility(0);
    } else if (paramUserFindResult.online_state == 1) {
      imageView4.setImageDrawable(BluedSkinUtils.b(this.w, 2131234365));
    } else {
      imageView4.setImageDrawable(BluedSkinUtils.b(this.w, 2131234364));
    } 
    if (paramUserFindResult.is_invisible_half == 1) {
      str = paramUserFindResult.avatar;
    } else {
      str = AvatarUtils.a(0, paramUserFindResult.avatar);
    } 
    ImageLoader.a(this.A, str).a(2131234356).c().a(imageView2);
    UserRelationshipUtils.a(imageView3, (UserBasicModel)paramUserFindResult);
    if (StringUtils.e(paramUserFindResult.distanceStr)) {
      str = paramUserFindResult.distance;
    } else {
      str = paramUserFindResult.distanceStr;
    } 
    if (!TextUtils.isEmpty(str)) {
      textView7.setText(str);
    } else {
      textView7.setText("");
    } 
    DistanceUtils.a(this.w, textView7, (UserBasicModel)paramUserFindResult, 1);
    if (!TextUtils.isEmpty(paramUserFindResult.note)) {
      textView6.setText(paramUserFindResult.note);
    } else if (!TextUtils.isEmpty(paramUserFindResult.name)) {
      textView6.setText(paramUserFindResult.name);
    } else {
      textView6.setText("");
    } 
    UserRelationshipUtils.a(this.w, textView6, (UserBasicModel)paramUserFindResult);
    if (paramUserFindResult.online_state == 1 && BluedConfig.b().K() == 0) {
      textView5.setText(2131756566);
    } else {
      if (StringUtils.e(paramUserFindResult.last_operate_str)) {
        str = paramUserFindResult.last_operate;
      } else {
        str = paramUserFindResult.last_operate_str;
      } 
      if (!TextUtils.isEmpty(str)) {
        textView5.setText(str);
      } else {
        textView5.setText("");
      } 
    } 
    TypefaceUtils.a(this.w, textView5, paramUserFindResult.is_hide_last_operate, 1);
    if (paramUserFindResult.vbadge == 5) {
      linearLayout.setVisibility(8);
    } else {
      linearLayout.setVisibility(0);
      if (!TextUtils.isEmpty(paramUserFindResult.age)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramUserFindResult.age);
        stringBuilder.append(this.w.getResources().getString(2131755267));
        textView1.setText(stringBuilder.toString());
      } else {
        textView1.setText("");
      } 
      if (!TextUtils.isEmpty(paramUserFindResult.height)) {
        textView2.setText(paramUserFindResult.height);
      } else {
        textView2.setText("");
      } 
      if (!TextUtils.isEmpty(paramUserFindResult.weight)) {
        textView3.setText(paramUserFindResult.weight);
      } else {
        textView3.setText("");
      } 
    } 
    if (TextUtils.isEmpty(paramUserFindResult.description)) {
      textView4.setText("");
      textView4.setVisibility(8);
    } else {
      textView4.setVisibility(0);
      textView4.setText(paramUserFindResult.description);
    } 
    view.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this, paramUserFindResult, paramBaseViewHolder, imageView2) {
            public void onClick(View param1View) {
              LiveEventBus.get("is_click_on_header").post(Boolean.valueOf(true));
              this.d.a(this.a, this.b.getAdapterPosition());
              this.d.a((View)this.c, this.a);
            }
          }));
    d(paramBaseViewHolder, paramUserFindResult);
  }
  
  public void c() {
    b(10, 2131493404);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\HelloListQuickAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */