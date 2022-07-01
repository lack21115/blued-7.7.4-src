package com.soft.blued.ui.search.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.log.model.LogData;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.search.SearchLikeChatFragment;
import com.soft.blued.ui.search.model.SearchSessionModel;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

public class SearchAllAdapter extends BaseQuickAdapter<SearchSessionModel, BaseViewHolder> {
  private BaseFragment a;
  
  private String b = "";
  
  public SearchAllAdapter(BaseFragment paramBaseFragment) {
    super(2131493643, new ArrayList());
    this.a = paramBaseFragment;
  }
  
  private UserBasicModel a(SessionModel paramSessionModel) {
    UserBasicModel userBasicModel = new UserBasicModel();
    userBasicModel.vip_grade = paramSessionModel.vipGrade;
    userBasicModel.is_vip_annual = paramSessionModel.vipAnnual;
    userBasicModel.is_hide_vip_look = paramSessionModel.hideVipLook;
    userBasicModel.vip_exp_lvl = paramSessionModel.vipExpLvl;
    return userBasicModel;
  }
  
  private String a(SessionModel paramSessionModel, SessionSettingModel paramSessionSettingModel) {
    String str1;
    String str2 = paramSessionModel.nickName;
    if (paramSessionSettingModel != null) {
      str1 = paramSessionSettingModel.getSessinoNote();
    } else {
      str1 = "";
    } 
    return !TextUtils.isEmpty(str1) ? str1 : (!TextUtils.isEmpty(str2) ? str2 : "");
  }
  
  private void a(SearchSessionModel paramSearchSessionModel) {
    if (paramSearchSessionModel.a > 1) {
      SearchLikeChatFragment.a(this.a.getContext(), this.b, a((SessionModel)paramSearchSessionModel, (SessionSettingModel)paramSearchSessionModel.sessionSettingModel), paramSearchSessionModel.sessionId, paramSearchSessionModel.sessionType, paramSearchSessionModel.avatar, paramSearchSessionModel.vBadge, paramSearchSessionModel.vipGrade, paramSearchSessionModel.vipAnnual, paramSearchSessionModel.vipExpLvl, paramSearchSessionModel.hideVipLook);
      return;
    } 
    if (paramSearchSessionModel.sessionType == 2 && BluedPreferences.ar()) {
      a(paramSearchSessionModel, true);
      return;
    } 
    a(paramSearchSessionModel, false);
  }
  
  private void a(SearchSessionModel paramSearchSessionModel, boolean paramBoolean) {
    boolean bool;
    LogData logData = new LogData();
    logData.g = "none";
    ChatHelperV4 chatHelperV4 = ChatHelperV4.a();
    Context context = this.a.getContext();
    long l = paramSearchSessionModel.sessionId;
    String str1 = paramSearchSessionModel.nickName;
    String str2 = paramSearchSessionModel.avatar;
    int i = paramSearchSessionModel.vBadge;
    int j = paramSearchSessionModel.vipGrade;
    int k = paramSearchSessionModel.vipAnnual;
    int m = paramSearchSessionModel.vipExpLvl;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramSearchSessionModel.lastMsgFromDistance);
    stringBuilder.append("");
    String str3 = stringBuilder.toString();
    if (paramSearchSessionModel.sessionType == 3) {
      bool = true;
    } else {
      bool = false;
    } 
    chatHelperV4.a(context, l, str1, str2, i, j, k, m, str3, paramBoolean, bool, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""), paramSearchSessionModel.lastMsgId, paramSearchSessionModel.lastMsgLocalId);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, SearchSessionModel paramSearchSessionModel) {
    String str;
    LinearLayout linearLayout1 = (LinearLayout)paramBaseViewHolder.d(2131297655);
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297362);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131299262);
    ImageView imageView4 = (ImageView)paramBaseViewHolder.d(2131299266);
    LinearLayout linearLayout2 = (LinearLayout)paramBaseViewHolder.d(2131299241);
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131297581);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131299265);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131301122);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131299263);
    TextView textView4 = (TextView)paramBaseViewHolder.d(2131299267);
    short s = paramSearchSessionModel.lastMsgStateCode;
    if (s != 1) {
      if (s != 6) {
        if (s != 7) {
          imageView4.setVisibility(8);
        } else {
          imageView4.setImageResource(2131232601);
          imageView4.setVisibility(0);
        } 
      } else {
        imageView4.setImageResource(2131232602);
        imageView4.setVisibility(0);
      } 
    } else {
      imageView4.setImageResource(2131232613);
      imageView4.setVisibility(0);
    } 
    textView2.setMaxWidth(DensityUtils.a(this.a.getContext(), 120.0F));
    linearLayout2.setVisibility(0);
    if (paramSearchSessionModel.a <= 0) {
      if (TextUtils.isEmpty(paramSearchSessionModel.b))
        linearLayout2.setVisibility(8); 
      textView1.setText("");
      imageView4.setVisibility(8);
    } else if (paramSearchSessionModel.a > 1) {
      Resources resources = this.k.getResources();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramSearchSessionModel.a);
      stringBuilder.append("");
      textView1.setText(resources.getString(2131755804, new Object[] { stringBuilder.toString() }));
    } else {
      CharSequence charSequence = StringUtils.a(StringUtils.a(paramSearchSessionModel.lastMsgContent, false, true, true, ""), (int)textView1.getTextSize());
      UserRelationshipUtils.a(this.k, charSequence.toString(), this.b, textView1);
    } 
    if (paramSearchSessionModel.lastMsgTime == 0L || paramSearchSessionModel.a > 1) {
      textView4.setText("");
    } else {
      textView4.setText(MsgCommonUtils.a(this.a.getContext(), paramSearchSessionModel.lastMsgTime));
    } 
    ActivityFragmentActive activityFragmentActive = this.a.w_();
    if (paramSearchSessionModel.sessionType == 3) {
      str = paramSearchSessionModel.avatar;
    } else {
      str = AvatarUtils.a(0, paramSearchSessionModel.avatar);
    } 
    boolean bool = false;
    ImageLoader.a((IRequestHost)activityFragmentActive, str).a(2131234356).a(imageView1);
    if (!TextUtils.isEmpty(paramSearchSessionModel.b)) {
      textView3.setVisibility(0);
      UserRelationshipUtils.a(this.k, this.k.getResources().getString(2131758053, new Object[] { paramSearchSessionModel.nickName }), this.b, textView3);
    } else {
      textView3.setVisibility(8);
    } 
    UserRelationshipUtils.a(this.k, a((SessionModel)paramSearchSessionModel, (SessionSettingModel)paramSearchSessionModel.sessionSettingModel), this.b, textView2);
    UserRelationshipUtils.a(imageView2, paramSearchSessionModel.vBadge, 3);
    UserRelationshipUtils.a(imageView3, a((SessionModel)paramSearchSessionModel));
    UserRelationshipUtils.a(this.a.getContext(), textView2, a((SessionModel)paramSearchSessionModel));
    if (paramSearchSessionModel.sessionType == 3)
      bool = true; 
    paramBaseViewHolder.b(2131300828, bool);
    linearLayout1.setOnClickListener(new View.OnClickListener(this, paramSearchSessionModel) {
          public void onClick(View param1View) {
            if (SearchAllAdapter.a(this.b) instanceof Activity)
              KeyboardUtils.a((Activity)SearchAllAdapter.b(this.b)); 
            SearchAllAdapter.a(this.b, this.a);
          }
        });
  }
  
  public void a(List<SearchSessionModel> paramList, String paramString) {
    this.b = paramString;
    c(paramList);
  }
  
  public void b(List<SearchSessionModel> paramList, String paramString) {
    this.b = paramString;
    a(paramList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\search\adapter\SearchAllAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */