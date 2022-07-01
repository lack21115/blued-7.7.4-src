package com.soft.blued.ui.msg.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.msg.fragment.HelloFragment;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.click.SingleClickProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HelloGridQuickAdapter extends PeopleGridQuickAdapter {
  protected IRequestHost A;
  
  public HelloFragment B;
  
  private int C;
  
  private HashSet<String> D;
  
  private String E;
  
  private MessageProtos.SortType F;
  
  public Context w;
  
  public String x;
  
  public int y;
  
  public int z;
  
  private void a(List<UserFindResult> paramList) {
    if (paramList != null) {
      Iterator<UserFindResult> iterator = paramList.iterator();
      while (iterator.hasNext()) {
        UserFindResult userFindResult = iterator.next();
        if (a(userFindResult)) {
          iterator.remove();
          continue;
        } 
        this.D.add(userFindResult.uid);
      } 
    } 
  }
  
  private boolean a(UserFindResult paramUserFindResult) {
    return (paramUserFindResult == null) ? true : this.D.contains(paramUserFindResult.uid);
  }
  
  public void a(int paramInt, UserFindResult paramUserFindResult) {
    if (!a(paramUserFindResult)) {
      super.a(paramInt, paramUserFindResult);
      this.D.add(paramUserFindResult.uid);
    } 
  }
  
  public void a(View paramView, UserFindResult paramUserFindResult) {
    boolean bool;
    String str1;
    LogData logData1 = new LogData();
    logData1.J = "msg_rec_chat_click";
    logData1.l = "1";
    logData1.c = paramUserFindResult.uid;
    InstantLog.a(logData1);
    LogData logData2 = new LogData();
    logData2.g = "msg_recommend_more";
    logData2.u = "1";
    logData2.b = paramUserFindResult.uid;
    logData2.w = this.x;
    if (StringUtils.e(paramUserFindResult.distanceStr)) {
      str1 = paramUserFindResult.distance;
    } else {
      str1 = paramUserFindResult.distanceStr;
    } 
    logData2.x = str1;
    if (StringUtils.e(paramUserFindResult.last_operate_str)) {
      str1 = paramUserFindResult.last_operate;
    } else {
      str1 = paramUserFindResult.last_operate_str;
    } 
    logData2.y = str1;
    logData2.k = "0";
    paramUserFindResult.is_call = 1;
    Context context = this.w;
    String str2 = this.x;
    if (paramUserFindResult.live > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    UserInfoFragmentNew.a(context, (UserBasicModel)paramUserFindResult, str2, bool, paramView, logData2, new MsgSourceEntity(MessageProtos.StrangerSource.APPRECIATE_CALL_TOTAL, ""));
  }
  
  public void a(MessageProtos.SortType paramSortType) {
    this.F = paramSortType;
  }
  
  public void a(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    if (paramBaseViewHolder != null) {
      paramBaseViewHolder.getItemViewType();
      b(paramBaseViewHolder, paramUserFindResult);
    } 
  }
  
  protected void a(UserFindResult paramUserFindResult, int paramInt) {
    EventTrackMessage.a(MessageProtos.Event.CALL_PAGE_USER_CLICK, paramUserFindResult.uid, this.F, this.B.a());
  }
  
  public void a(String paramString) {
    this.E = paramString;
  }
  
  public void a(Collection<? extends UserFindResult> paramCollection) {
    paramCollection = new ArrayList<UserFindResult>(paramCollection);
    a((List)paramCollection);
    super.a(paramCollection);
    notifyDataSetChanged();
  }
  
  public String b() {
    return this.E;
  }
  
  public void b(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    FrameLayout frameLayout = (FrameLayout)paramBaseViewHolder.d(2131297133);
    GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams)frameLayout.getLayoutParams();
    int i = this.y;
    layoutParams.width = i;
    layoutParams.height = i;
    i = this.z;
    layoutParams.bottomMargin = i;
    layoutParams.rightMargin = i;
    frameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131300020);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131301088);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297581);
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297362);
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131297575);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131296426);
    TextView textView4 = (TextView)paramBaseViewHolder.d(2131297368);
    TextView textView5 = (TextView)paramBaseViewHolder.d(2131301755);
    TextView textView6 = (TextView)paramBaseViewHolder.d(2131299744);
    imageView3.setVisibility(8);
    imageView2.setVisibility(8);
    imageView3.setVisibility(0);
    UserRelationshipUtils.b(imageView3, paramUserFindResult.vbadge, 4, 8);
    UserRelationshipUtils.b(imageView2, (UserBasicModel)paramUserFindResult);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("maxWidth = ");
    stringBuilder.append(this.C);
    Log.e("adapter", stringBuilder.toString());
    textView1.setMaxWidth(this.C);
    View view = paramBaseViewHolder.d(2131297448);
    imageView1.setVisibility(0);
    view.setVisibility(0);
    if (!TextUtils.isEmpty(paramUserFindResult.age)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramUserFindResult.age);
      stringBuilder1.append(this.w.getResources().getString(2131755267));
      textView3.setText(stringBuilder1.toString());
    } else {
      textView3.setText("");
    } 
    if (!TextUtils.isEmpty(paramUserFindResult.height)) {
      textView4.setText(paramUserFindResult.height);
    } else {
      textView4.setText("");
    } 
    if (!TextUtils.isEmpty(paramUserFindResult.weight)) {
      textView5.setText(paramUserFindResult.weight);
    } else {
      textView5.setText("");
    } 
    UserRelationshipUtils.a(this.w, textView6, paramUserFindResult.role);
    if (!TextUtils.isEmpty(paramUserFindResult.note)) {
      textView1.setText(paramUserFindResult.note);
    } else if (!TextUtils.isEmpty(paramUserFindResult.name)) {
      textView1.setText(paramUserFindResult.name);
    } else {
      textView1.setText("");
    } 
    int j = paramUserFindResult.is_invisible_half;
    i = 3;
    if (j == 1) {
      str = paramUserFindResult.avatar;
    } else if ("selected".equalsIgnoreCase(this.x)) {
      str = AvatarUtils.a(3, paramUserFindResult.avatar);
    } else {
      str = AvatarUtils.a(2, paramUserFindResult.avatar);
    } 
    ImageLoader.a(this.A, str).a(2131231368).a(imageView1);
    String str = this.x;
    switch (str.hashCode()) {
      default:
        i = -1;
        break;
      case 492822833:
        if (str.equals("integrate")) {
          i = 1;
          break;
        } 
      case -1012222381:
        if (str.equals("online")) {
          i = 0;
          break;
        } 
      case -1048842402:
        if (str.equals("newbie")) {
          i = 2;
          break;
        } 
      case -1049482625:
        if (str.equals("nearby"))
          break; 
    } 
    if (i != 0) {
      if (i != 1 && i != 2) {
        if (StringUtils.e(paramUserFindResult.distanceStr)) {
          str = paramUserFindResult.distance;
        } else {
          str = paramUserFindResult.distanceStr;
        } 
        if (!TextUtils.isEmpty(str)) {
          textView2.setText(str);
          textView2.setVisibility(0);
        } else {
          textView2.setText("");
          textView2.setVisibility(8);
        } 
        DistanceUtils.a(this.w, textView2, (UserBasicModel)paramUserFindResult, 1);
      } else {
        textView2.setVisibility(8);
      } 
    } else {
      if (paramUserFindResult.online_state == 1 && BluedConfig.b().K() == 0) {
        textView2.setVisibility(0);
        textView2.setText(2131756566);
      } else {
        if (StringUtils.e(paramUserFindResult.last_operate_str)) {
          str = paramUserFindResult.last_operate;
        } else {
          str = paramUserFindResult.last_operate_str;
        } 
        if (!TextUtils.isEmpty(str)) {
          textView2.setVisibility(0);
          textView2.setText(str);
        } else {
          textView2.setVisibility(8);
          textView2.setText("");
        } 
      } 
      TypefaceUtils.a(this.w, textView2, paramUserFindResult.is_hide_last_operate, 1);
    } 
    imageView1.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this, paramBaseViewHolder, paramUserFindResult, imageView1) {
            public void onClick(View param1View) {
              LiveEventBus.get("is_click_on_header").post(Boolean.valueOf(true));
              if (this.a.getAdapterPosition() != -1) {
                this.d.a(this.b, this.a.getAdapterPosition());
                this.d.a((View)this.c, this.b);
              } 
            }
          }));
    d(paramBaseViewHolder, paramUserFindResult);
  }
  
  public void b(String paramString) {
    this.x = paramString;
  }
  
  public void c() {
    b(10, 2131493403);
  }
  
  public void c(List<UserFindResult> paramList) {
    List<UserFindResult> list = paramList;
    if (paramList == null)
      list = new ArrayList<UserFindResult>(); 
    this.D.clear();
    a(list);
    if (this.n != null && this.n.size() > 0) {
      this.n.clear();
      this.n.addAll(list);
    } else {
      this.n = new ArrayList();
      this.n.addAll(list);
    } 
    int i = 0;
    for (UserFindResult userFindResult : list) {
      if (userFindResult.getItemType() == 10 && userFindResult.live > 0) {
        userFindResult.positionReal = i;
        i++;
      } 
    } 
    c(true);
    notifyDataSetChanged();
  }
  
  public void d(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    if (!paramUserFindResult.isShowUrlVisited && !StringUtils.e(paramUserFindResult.uid)) {
      EventTrackMessage.a(MessageProtos.Event.CALL_PAGE_USER_SHOW, paramUserFindResult.uid, this.F, this.B.a());
      paramUserFindResult.isShowUrlVisited = true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\HelloGridQuickAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */