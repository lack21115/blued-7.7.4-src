package com.soft.blued.ui.msg.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.StringUtils;
import java.util.List;

public class PeopleHelloQuickAdapter extends PeopleGridQuickAdapter {
  private MessageProtos.SortType w = MessageProtos.SortType.UNKNOWN_SORT_TYPE;
  
  private String x = "";
  
  public PeopleHelloQuickAdapter(List<UserFindResult> paramList, Activity paramActivity, IRequestHost paramIRequestHost, String paramString, RecyclerView paramRecyclerView) {
    super(paramList, paramActivity, paramIRequestHost, paramString, paramRecyclerView);
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
    logData2.w = this.b;
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
    Context context = this.a;
    String str2 = this.b;
    if (paramUserFindResult.live > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    UserInfoFragmentNew.a(context, (UserBasicModel)paramUserFindResult, str2, bool, paramView, logData2, new MsgSourceEntity(MessageProtos.StrangerSource.APPRECIATE_CALL_TOTAL, ""));
  }
  
  public void a(MessageProtos.SortType paramSortType) {
    this.w = paramSortType;
  }
  
  public void c(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    EventTrackMessage.a(MessageProtos.Event.CALL_PAGE_USER_CLICK, paramUserFindResult.uid, this.w, this.x);
  }
  
  public void d(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    if (!paramUserFindResult.isShowUrlVisited && !StringUtils.e(paramUserFindResult.uid)) {
      EventTrackMessage.a(MessageProtos.Event.CALL_PAGE_USER_SHOW, paramUserFindResult.uid, this.w, this.x);
      paramUserFindResult.isShowUrlVisited = true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\PeopleHelloQuickAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */