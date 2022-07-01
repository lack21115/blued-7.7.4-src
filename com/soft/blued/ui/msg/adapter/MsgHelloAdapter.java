package com.soft.blued.ui.msg.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

public class MsgHelloAdapter extends BaseQuickAdapter<UserFindResult, BaseViewHolder> {
  private LoadOptions a;
  
  private Context b;
  
  private String c = "";
  
  private IRequestHost d;
  
  public MsgHelloAdapter(IRequestHost paramIRequestHost, Context paramContext) {
    super(2131493602, null);
    this.b = paramContext;
    this.d = paramIRequestHost;
    int i = (this.b.getResources().getDisplayMetrics()).widthPixels;
    this.a = new LoadOptions();
    LoadOptions loadOptions = this.a;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
    i /= 2;
    loadOptions.a(i, i);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, UserFindResult paramUserFindResult) {
    if (paramBaseViewHolder != null) {
      ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297362);
      ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297575);
      paramUserFindResult.is_call = 1;
      ImageLoader.a(this.d, paramUserFindResult.avatar).a(2131234356).c().a(imageView1);
      UserRelationshipUtils.a(imageView2, paramUserFindResult.vbadge, 3, 1, this.b.getResources().getColor(2131100528));
      paramBaseViewHolder.a(2131301088, paramUserFindResult.name);
      View view = paramBaseViewHolder.d(2131299708);
      ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)view.getLayoutParams();
      if (paramBaseViewHolder.getAdapterPosition() == 0) {
        layoutParams.leftMargin = DensityUtils.a(this.b, 10.0F);
      } else {
        layoutParams.leftMargin = 0;
      } 
      view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      imageView1.setOnClickListener(new -$$Lambda$MsgHelloAdapter$TOqt7UAhPgrthrkw8tFvDUDUlsw(this, paramUserFindResult, imageView1));
      if (!paramUserFindResult.isShowUrlVisited) {
        EventTrackMessage.a(MessageProtos.Event.MSG_VOCATIV_USER_SHOW, MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, paramUserFindResult.uid, true);
        paramUserFindResult.isShowUrlVisited = true;
        return;
      } 
      EventTrackMessage.a(MessageProtos.Event.MSG_VOCATIV_USER_SHOW, MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, paramUserFindResult.uid, false);
    } 
  }
  
  public void c(List<UserFindResult> paramList) {
    super.c(paramList);
    this.c = "";
    if (this.n != null && this.n.size() > 0) {
      for (int i = 0; i < this.n.size(); i++) {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        if (StringUtils.e(this.c)) {
          str = "";
        } else {
          str = "-";
        } 
        stringBuilder.append(str);
        stringBuilder.append(((UserFindResult)this.n.get(i)).uid);
        this.c = stringBuilder.toString();
      } 
      LogData logData = new LogData();
      logData.J = "msg_rec_chat_show";
      logData.c = this.c;
      logData.l = "0";
      InstantLog.a(logData);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\MsgHelloAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */