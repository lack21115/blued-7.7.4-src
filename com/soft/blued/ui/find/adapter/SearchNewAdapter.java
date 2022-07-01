package com.soft.blued.ui.find.adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.KeyboardUtils;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.find.fragment.FilterDialogFragment;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

public class SearchNewAdapter extends PeopleListQuickAdapter {
  public String w;
  
  public SearchNewAdapter(List<UserFindResult> paramList, Activity paramActivity, IRequestHost paramIRequestHost, String paramString, RecyclerView paramRecyclerView) {
    super(paramList, paramActivity, paramIRequestHost, paramString, paramRecyclerView);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    super.a(paramBaseViewHolder, paramUserFindResult);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131299358);
    textView2.setTypeface(Typeface.defaultFromStyle(0));
    String str = paramUserFindResult.name;
    if (!TextUtils.isEmpty(paramUserFindResult.note))
      str = paramUserFindResult.note; 
    UserRelationshipUtils.a(this.a, textView2, (UserBasicModel)paramUserFindResult);
    UserRelationshipUtils.a(this.a, str, this.w, textView2);
    paramBaseViewHolder.d(2131298064).setOnClickListener(new View.OnClickListener(this, paramUserFindResult, paramBaseViewHolder) {
          public void onClick(View param1View) {
            if (this.c.a instanceof Activity)
              KeyboardUtils.a((Activity)this.c.a); 
            FilterDialogFragment.b = true;
            UserInfoFragmentNew.a(this.c.a, (UserBasicModel)this.a, "", this.b.d(2131297362));
          }
        });
    paramBaseViewHolder.b(2131299415, false);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131296943);
    if (!TextUtils.isEmpty(paramUserFindResult.distance)) {
      textView1.setText(DistanceUtils.a(paramUserFindResult.distance, BlueAppLocal.c(), false));
    } else {
      textView1.setText("");
    } 
    DistanceUtils.a(this.a, textView1, (UserBasicModel)paramUserFindResult, 1);
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297536);
    if (paramUserFindResult.online_state == 1) {
      imageView.setImageResource(2131234365);
      return;
    } 
    imageView.setImageResource(2131234364);
  }
  
  public void a(List<UserFindResult> paramList, String paramString) {
    if (paramList != null && paramList.size() > 0) {
      for (int i = 0; i < paramList.size(); i++) {
        if (BlueAppLocal.d()) {
          ((UserFindResult)paramList.get(i)).height = StringUtils.a(((UserFindResult)paramList.get(i)).height, BlueAppLocal.c(), false);
          ((UserFindResult)paramList.get(i)).weight = StringUtils.b(((UserFindResult)paramList.get(i)).weight, BlueAppLocal.c(), false);
        } else {
          ((UserFindResult)paramList.get(i)).height = StringUtils.a(((UserFindResult)paramList.get(i)).height, BlueAppLocal.c(), true);
          ((UserFindResult)paramList.get(i)).weight = StringUtils.b(((UserFindResult)paramList.get(i)).weight, BlueAppLocal.c(), true);
        } 
      } 
      c(paramList);
    } 
    this.w = paramString;
  }
  
  public void b(List<UserFindResult> paramList, String paramString) {
    if (paramList != null && paramList.size() > 0) {
      for (int i = 0; i < paramList.size(); i++) {
        if (BlueAppLocal.d()) {
          ((UserFindResult)paramList.get(i)).height = StringUtils.a(((UserFindResult)paramList.get(i)).height, BlueAppLocal.c(), false);
          ((UserFindResult)paramList.get(i)).weight = StringUtils.b(((UserFindResult)paramList.get(i)).weight, BlueAppLocal.c(), false);
        } else {
          ((UserFindResult)paramList.get(i)).height = StringUtils.a(((UserFindResult)paramList.get(i)).height, BlueAppLocal.c(), true);
          ((UserFindResult)paramList.get(i)).weight = StringUtils.b(((UserFindResult)paramList.get(i)).weight, BlueAppLocal.c(), true);
        } 
      } 
      a(paramList);
    } 
    this.w = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\SearchNewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */