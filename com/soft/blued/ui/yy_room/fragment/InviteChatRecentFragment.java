package com.soft.blued.ui.yy_room.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.listener.SessionListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.liveForMsg.model.LiveMsgShareEntity;
import com.blued.android.module.live_china.msg.ILiveMsgSender;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.BluedConstant;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InviteChatRecentFragment extends PreloadFragment {
  private ShareToMsgEntity A;
  
  private String B;
  
  private String C;
  
  private List<SessionModel> D;
  
  private Context o;
  
  private ChatListAdapter p;
  
  private ShareToSessionListListener q;
  
  private View r;
  
  private NoDataAndLoadFailView s;
  
  private ProgressBar t;
  
  private RecyclerView u;
  
  private PullToRefreshRecyclerView v;
  
  private KeyboardListenLinearLayout w;
  
  private FrameLayout x;
  
  private boolean y = false;
  
  private int z = 0;
  
  public static InviteChatRecentFragment a(Bundle paramBundle) {
    InviteChatRecentFragment inviteChatRecentFragment = new InviteChatRecentFragment();
    if (paramBundle != null)
      inviteChatRecentFragment.setArguments(paramBundle); 
    return inviteChatRecentFragment;
  }
  
  private String a(SessionModel paramSessionModel) {
    String str;
    if (paramSessionModel == null)
      return ""; 
    SessionSettingModel sessionSettingModel = (SessionSettingModel)paramSessionModel.sessionSettingModel;
    if (sessionSettingModel != null) {
      str = sessionSettingModel.getSessinoNote();
    } else {
      str = "";
    } 
    if (!TextUtils.isEmpty(str))
      return str; 
    if (!TextUtils.isEmpty(paramSessionModel.nickName))
      return paramSessionModel.nickName; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramSessionModel.sessionId);
    stringBuilder.append("");
    return stringBuilder.toString();
  }
  
  public ChattingModel a(long paramLong, short paramShort1, short paramShort2, String paramString1, String paramString2) {
    return ChatHelper.getChattingModelForSendmsg(paramLong, paramShort2, paramString1, ILiveMsgSender.e(), paramString2, paramShort1);
  }
  
  public void a(View paramView) {
    paramView = LayoutInflater.from(this.o).inflate(2131493316, (ViewGroup)paramView, true);
    this.t = (ProgressBar)paramView.findViewById(2131299526);
    this.t.setVisibility(8);
    this.x = (FrameLayout)paramView.findViewById(2131297158);
    this.x.setBackgroundResource(2131100662);
    this.r = paramView.findViewById(2131297985);
    this.v = (PullToRefreshRecyclerView)paramView.findViewById(2131299532);
    this.v.setRefreshEnabled(false);
    this.u = (RecyclerView)this.v.getRefreshableView();
    this.w = (KeyboardListenLinearLayout)paramView.findViewById(2131297982);
    a(this.w);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.o);
    this.p = new ChatListAdapter();
    this.u.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.p.d(true);
    this.u.setAdapter((RecyclerView.Adapter)this.p);
    this.p.a(this.u);
    this.p.f();
    this.q = new ShareToSessionListListener();
    ChatManager.getInstance().registerSessionListener((SessionListener)this.q);
    this.u.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
          public void onGlobalLayout() {
            InviteChatRecentFragment.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (!InviteChatRecentFragment.b(this.a)) {
              InviteChatRecentFragment.a(this.a, true);
              InviteChatRecentFragment inviteChatRecentFragment = this.a;
              InviteChatRecentFragment.a(inviteChatRecentFragment, new NoDataAndLoadFailView(InviteChatRecentFragment.c(inviteChatRecentFragment)));
              InviteChatRecentFragment.d(this.a).setBackgroundColorRes(2131100662);
              InviteChatRecentFragment.d(this.a).setNoDataImg(2131232632);
              InviteChatRecentFragment.d(this.a).setNoDataTextColor(2131100980);
              InviteChatRecentFragment.d(this.a).setNoDataStr(2131759016);
              InviteChatRecentFragment.d(this.a).a();
              InviteChatRecentFragment.e(this.a).e((View)InviteChatRecentFragment.d(this.a));
            } 
          }
        });
  }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    this.o = paramContext;
    if (getArguments() != null) {
      this.z = getArguments().getInt("share_type");
      this.A = (ShareToMsgEntity)getArguments().get("share_entity");
      this.B = getArguments().getString("share_yy_type_name");
      this.C = getArguments().getString("share_yy_type_id");
    } 
  }
  
  class ChatListAdapter extends BaseQuickAdapter<SessionModel, BaseViewHolder> {
    private TextView b;
    
    private ImageView c;
    
    private ShapeTextView d;
    
    private ChatListAdapter(InviteChatRecentFragment this$0) {
      super(2131493552, null);
    }
    
    private void a(UserBasicModel param1UserBasicModel, int param1Int) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((InviteChatRecentFragment.g(this.a)).sessionId);
      stringBuilder.append("");
      LiveHttpUtils.b(stringBuilder.toString(), new BluedUIHttpResponse<BluedEntityA<LiveMsgShareEntity>>(this, (IRequestHost)this.a.w_(), param1UserBasicModel, param1Int) {
            protected void a(BluedEntityA<LiveMsgShareEntity> param2BluedEntityA) {
              if (param2BluedEntityA != null) {
                if (!param2BluedEntityA.hasData())
                  return; 
                LiveMsgShareEntity liveMsgShareEntity = (LiveMsgShareEntity)param2BluedEntityA.getSingleData();
                Gson gson = AppInfo.f();
                liveMsgShareEntity.copywriting = (InviteChatRecentFragment.g(this.c.a)).title;
                liveMsgShareEntity.room_type = StringUtils.a(InviteChatRecentFragment.h(this.c.a), 1);
                liveMsgShareEntity.description = InviteChatRecentFragment.i(this.c.a);
                String str = gson.toJson(liveMsgShareEntity);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("invite friends extra: ");
                stringBuilder.append(str);
                Logger.e("invite", new Object[] { stringBuilder.toString() });
                ChattingModel chattingModel = this.c.a.a(StringUtils.a(this.a.uid, 0L), (short)2, (short)210, InviteChatRecentFragment.ChatListAdapter.a(this.c).getResources().getString(2131759501), str);
                ChatHelperV4.a().a(chattingModel, false);
                YYRoomInfoManager.d().b().addInvited(this.a.uid);
                InviteChatRecentFragment.e(this.c.a).notifyItemChanged(this.b);
                LiveEventBus.get("share_to_private_chat").post(this.a.uid);
              } 
            }
          }(IRequestHost)this.a.w_());
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, SessionModel param1SessionModel) {
      if (param1BaseViewHolder != null && param1SessionModel != null) {
        this.b = (TextView)param1BaseViewHolder.d(2131301088);
        this.c = (ImageView)param1BaseViewHolder.d(2131299684);
        this.d = (ShapeTextView)param1BaseViewHolder.d(2131297604);
        this.b.setText(InviteChatRecentFragment.a(this.a, param1SessionModel));
        YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1SessionModel.sessionId);
        stringBuilder.append("");
        if (yYRoomModel.isInvited(stringBuilder.toString())) {
          this.d.setEnabled(false);
          this.d.setText("已邀请");
          ShapeHelper.a((ShapeHelper.ShapeView)this.d, 2131100692);
          ShapeHelper.a((ShapeHelper.ShapeView)this.d, 2131100748, 2131100748);
        } else {
          this.d.setText("邀请");
          this.d.setEnabled(true);
          ShapeHelper.a((ShapeHelper.ShapeView)this.d, 2131100980);
          ShapeHelper.a((ShapeHelper.ShapeView)this.d, 2131100658, 2131100672);
        } 
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.vip_grade = param1SessionModel.vipGrade;
        userBasicModel.is_vip_annual = param1SessionModel.vipAnnual;
        userBasicModel.vip_exp_lvl = param1SessionModel.vipExpLvl;
        stringBuilder = new StringBuilder();
        stringBuilder.append(param1SessionModel.sessionId);
        stringBuilder.append("");
        userBasicModel.uid = stringBuilder.toString();
        ImageLoader.a((IRequestHost)this.a.w_(), param1SessionModel.avatar).a(2131234356).c().a(this.c);
        this.d.setOnClickListener(new View.OnClickListener(this, userBasicModel, param1BaseViewHolder) {
              public void onClick(View param2View) {
                YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
                if (yYRoomModel != null)
                  EventTrackYY.g(ChatRoomProtos.Event.CHAT_ROOM_USER_INVITE_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.a.uid); 
                InviteChatRecentFragment.ChatListAdapter.a(this.c, this.a, this.b.getAdapterPosition());
              }
            });
      } 
    }
  }
  
  class null implements View.OnClickListener {
    null(InviteChatRecentFragment this$0, UserBasicModel param1UserBasicModel, BaseViewHolder param1BaseViewHolder) {}
    
    public void onClick(View param1View) {
      YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null)
        EventTrackYY.g(ChatRoomProtos.Event.CHAT_ROOM_USER_INVITE_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.a.uid); 
      InviteChatRecentFragment.ChatListAdapter.a(this.c, this.a, this.b.getAdapterPosition());
    }
  }
  
  class null extends BluedUIHttpResponse<BluedEntityA<LiveMsgShareEntity>> {
    null(InviteChatRecentFragment this$0, IRequestHost param1IRequestHost, UserBasicModel param1UserBasicModel, int param1Int) {
      super(param1IRequestHost);
    }
    
    protected void a(BluedEntityA<LiveMsgShareEntity> param1BluedEntityA) {
      if (param1BluedEntityA != null) {
        if (!param1BluedEntityA.hasData())
          return; 
        LiveMsgShareEntity liveMsgShareEntity = (LiveMsgShareEntity)param1BluedEntityA.getSingleData();
        Gson gson = AppInfo.f();
        liveMsgShareEntity.copywriting = (InviteChatRecentFragment.g(this.c.a)).title;
        liveMsgShareEntity.room_type = StringUtils.a(InviteChatRecentFragment.h(this.c.a), 1);
        liveMsgShareEntity.description = InviteChatRecentFragment.i(this.c.a);
        String str = gson.toJson(liveMsgShareEntity);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invite friends extra: ");
        stringBuilder.append(str);
        Logger.e("invite", new Object[] { stringBuilder.toString() });
        ChattingModel chattingModel = this.c.a.a(StringUtils.a(this.a.uid, 0L), (short)2, (short)210, InviteChatRecentFragment.ChatListAdapter.a(this.c).getResources().getString(2131759501), str);
        ChatHelperV4.a().a(chattingModel, false);
        YYRoomInfoManager.d().b().addInvited(this.a.uid);
        InviteChatRecentFragment.e(this.c.a).notifyItemChanged(this.b);
        LiveEventBus.get("share_to_private_chat").post(this.a.uid);
      } 
    }
  }
  
  class ShareToSessionListListener extends StableSessionListListener {
    private ShareToSessionListListener(InviteChatRecentFragment this$0) {}
    
    public void onUISessionDataChanged(List<SessionModel> param1List) {
      if (param1List == null) {
        param1List = new ArrayList<SessionModel>();
      } else {
        ChatHelperV4.b(param1List);
      } 
      if (BluedConstant.a) {
        Iterator<SessionModel> iterator = param1List.iterator();
        while (iterator.hasNext()) {
          SessionModel sessionModel = iterator.next();
          if (sessionModel.sessionType == 3) {
            iterator.remove();
            continue;
          } 
          if (sessionModel.sessionType == 1 && sessionModel.sessionId == 2L)
            iterator.remove(); 
        } 
      } 
      if (InviteChatRecentFragment.f(this.a) != null)
        return; 
      InviteChatRecentFragment.a(this.a, new ArrayList());
      InviteChatRecentFragment.f(this.a).addAll(param1List);
      if (InviteChatRecentFragment.f(this.a).size() > 0) {
        InviteChatRecentFragment.e(this.a).c(InviteChatRecentFragment.f(this.a));
        return;
      } 
      InviteChatRecentFragment.e(this.a).c(null);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\fragment\InviteChatRecentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */