package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.find.fragment.FilterDialogFragment;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.UserRelationshipUtils;

public class SearchUserAdapter extends BaseQuickAdapter<UserBasicModel, BaseViewHolder> {
  private String a;
  
  private Context b;
  
  private IRequestHost c;
  
  protected void a(BaseViewHolder paramBaseViewHolder, UserBasicModel paramUserBasicModel) {
    UserRelationshipUtils.a((ImageView)paramBaseViewHolder.d(2131297575), paramUserBasicModel.vbadge, 3);
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297362);
    IRequestHost iRequestHost = this.c;
    String str1 = paramUserBasicModel.avatar;
    int i = 0;
    ImageLoader.a(iRequestHost, AvatarUtils.a(0, str1)).c().a(2131234356).a(imageView);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131299744);
    UserRelationshipUtils.a(this.b, textView1, paramUserBasicModel.role);
    textView1 = (TextView)paramBaseViewHolder.d(2131296943);
    if (!TextUtils.isEmpty(paramUserBasicModel.distance)) {
      textView1.setText(DistanceUtils.a(paramUserBasicModel.distance, BlueAppLocal.c(), false));
    } else {
      textView1.setText("");
    } 
    DistanceUtils.a(this.b, textView1, paramUserBasicModel, 1);
    textView1 = (TextView)paramBaseViewHolder.d(2131299358);
    if (!TextUtils.isEmpty(paramUserBasicModel.name)) {
      textView1.setText(paramUserBasicModel.name);
    } else {
      textView1.setText("");
    } 
    UserRelationshipUtils.a(this.b, textView1, paramUserBasicModel);
    UserRelationshipUtils.a((ImageView)paramBaseViewHolder.d(2131297447), paramUserBasicModel);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131296426);
    if (!TextUtils.isEmpty(paramUserBasicModel.age)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramUserBasicModel.age);
      stringBuilder.append(this.b.getResources().getString(2131755267));
      textView2.setText(stringBuilder.toString());
    } else {
      textView2.setText("");
    } 
    textView2 = (TextView)paramBaseViewHolder.d(2131297368);
    if (!TextUtils.isEmpty(paramUserBasicModel.height)) {
      textView2.setText(paramUserBasicModel.height);
    } else {
      textView2.setText("");
    } 
    textView2 = (TextView)paramBaseViewHolder.d(2131301755);
    if (!TextUtils.isEmpty(paramUserBasicModel.weight)) {
      textView2.setText(paramUserBasicModel.weight);
    } else {
      textView2.setText("");
    } 
    textView2 = (TextView)paramBaseViewHolder.d(2131299959);
    if (!TextUtils.isEmpty(paramUserBasicModel.description)) {
      textView2.setVisibility(0);
      textView2.setText(paramUserBasicModel.description);
    } else {
      textView2.setVisibility(4);
    } 
    String str2 = paramUserBasicModel.name;
    if (!TextUtils.isEmpty(str2)) {
      if (str2.toLowerCase().contains(this.a.toLowerCase())) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        str2 = str2.toLowerCase();
        this.a = this.a.toLowerCase();
        while (i < str2.length()) {
          int j = str2.indexOf(this.a, i);
          if (j >= 0) {
            spannableStringBuilder.setSpan(new StyleSpan(1), j, this.a.length() + j, 33);
            i = Math.max(i + 1, j);
          } 
        } 
        textView1.setText((CharSequence)spannableStringBuilder);
      } else {
        textView1.setText(str2);
      } 
    } else {
      textView1.setText("");
    } 
    paramBaseViewHolder.d(2131299066).setOnClickListener(new View.OnClickListener(this, paramUserBasicModel, imageView) {
          public void onClick(View param1View) {
            FilterDialogFragment.b = true;
            UserInfoFragmentNew.a(SearchUserAdapter.a(this.c), this.a, "", (View)this.b);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\SearchUserAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */