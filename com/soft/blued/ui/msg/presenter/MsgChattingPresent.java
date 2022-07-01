package com.soft.blued.ui.msg.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.listener.LoadListener;
import com.blued.android.chat.listener.MsgContentListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.das.message.MessageProtos;
import com.soft.blued.constant.ChatConstants;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackGroup;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.model.UserInfoBasicModel;
import com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.model.PayExperimentConfigModel;
import com.soft.blued.ui.msg.ChatSettingFragment;
import com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback;
import com.soft.blued.ui.msg.contract.IMsgChattingView;
import com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.IMV4Constant;
import com.soft.blued.ui.msg.controller.tools.IMV4Method;
import com.soft.blued.ui.msg.manager.RecentPhotoManager;
import com.soft.blued.ui.msg.model.ChatBundleExtra;
import com.soft.blued.ui.msg.model.HelloExpressionData;
import com.soft.blued.ui.msg.model.MsgRecentPhotoInfo;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg_group.fragment.GroupInfoFragment;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.CameraUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MsgChattingPresent implements FetchDataListener<SessionModel>, MsgContentListener, IMsgChatAdapterCallback {
  private static final String h = MsgChattingPresent.class.getSimpleName();
  
  private int A = 0;
  
  private String B;
  
  private int C;
  
  private int D;
  
  private long E;
  
  private int F;
  
  private boolean G = false;
  
  private boolean H = false;
  
  private boolean I = false;
  
  private boolean J = false;
  
  private boolean K = false;
  
  private boolean L = false;
  
  private boolean M = false;
  
  private boolean N = true;
  
  private boolean O = true;
  
  private boolean P;
  
  private int Q = 0;
  
  private String R = "";
  
  private UserInfoBasicModel S;
  
  private SessionSettingModel T;
  
  private SessionModel U;
  
  private MsgSourceEntity V;
  
  private RecentPhotoManager W;
  
  private EditDataModel.SerializableData X;
  
  private PayExperimentConfigModel Y;
  
  private GroupInfoModel Z;
  
  public LogData a;
  
  private boolean aa = false;
  
  public long b;
  
  public short c;
  
  public String d = "";
  
  public String e = "";
  
  public String f;
  
  public String g;
  
  private int i = 0;
  
  private IMsgChattingView j;
  
  private boolean k;
  
  private boolean l;
  
  private String m = "";
  
  private String n = "";
  
  private int o;
  
  private int p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private String u = "";
  
  private boolean v;
  
  private volatile String w;
  
  private boolean x;
  
  private long y;
  
  private long z;
  
  public MsgChattingPresent(Bundle paramBundle, IMsgChattingView paramIMsgChattingView) {
    this.j = paramIMsgChattingView;
    if (this.j == null)
      return; 
    this.W = new RecentPhotoManager();
    if (paramBundle != null)
      this.R = paramBundle.getString("image_path"); 
  }
  
  private List<ChattingModel> a(List<ChattingModel> paramList) {
    long l = 0L;
    for (int i = 0; i < paramList.size(); i = j + 1) {
      int j;
      ChattingModel chattingModel = paramList.get(i);
      if (chattingModel == null) {
        paramList.remove(i);
        j = i - 1;
      } else {
        long l1;
        chattingModel.isShowTime = false;
        if (i == 0) {
          chattingModel.isShowTime = true;
          l1 = chattingModel.msgTimestamp;
        } else {
          long l2 = chattingModel.msgTimestamp;
          if ((l2 - ((ChattingModel)paramList.get(i - 1)).msgTimestamp) / 1000L > 180L) {
            chattingModel.isShowTime = true;
            l1 = chattingModel.msgTimestamp;
          } else {
            l1 = l;
            if ((l2 - l) / 1000L > 180L) {
              chattingModel.isShowTime = true;
              l1 = chattingModel.msgTimestamp;
            } 
          } 
        } 
        j = i;
        l = l1;
        if (chattingModel.msgType == 3) {
          j = i;
          l = l1;
          if (!chattingModel.isFromSelf()) {
            j = i;
            l = l1;
            if (chattingModel.msgStateCode != 5) {
              j = i;
              l = l1;
              if (this.j.P() != null) {
                this.j.P().a(chattingModel);
                l = l1;
                j = i;
              } 
            } 
          } 
        } 
      } 
    } 
    return paramList;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4) {
    if (this.j != null) {
      String str;
      ChattingModel chattingModel;
      if (TextUtils.isEmpty(paramString))
        return; 
      if (paramInt1 <= 0) {
        str = ChatHelperV4.a().a(this.V, paramInt2, paramInt3);
      } else {
        str = ChatHelperV4.a().a(paramInt2, paramInt3);
      } 
      if (this.V != null)
        this.V = null; 
      if (paramInt4 == 1) {
        chattingModel = a((short)24, paramString, str);
      } else {
        chattingModel = a((short)2, paramString, (String)chattingModel);
      } 
      if (chattingModel == null)
        return; 
      a(paramString, paramInt2, paramInt3);
      b(chattingModel, false);
    } 
  }
  
  private void a(FetchDataListener<SessionModel> paramFetchDataListener) {
    ChatManager.getInstance().getSessionModel((short)2, f(), paramFetchDataListener);
  }
  
  private void ah() {
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<PayExperimentConfigModel>>(this, MsgChattingPresent.a(this.a).U()) {
                  protected void a(BluedEntityA<PayExperimentConfigModel> param2BluedEntityA) {
                    if (param2BluedEntityA.hasData()) {
                      MsgChattingPresent.a(this.a.a, param2BluedEntityA.data.get(0));
                      if ((MsgChattingPresent.l(this.a.a)).is_gift_free == 1) {
                        MsgChattingPresent.a(this.a.a).a(1, (MsgChattingPresent.l(this.a.a)).is_gift_free_content);
                        return;
                      } 
                      if ((MsgChattingPresent.l(this.a.a)).is_gift_new != 0 && !BluedPreferences.B((MsgChattingPresent.l(this.a.a)).is_gift_new))
                        MsgChattingPresent.a(this.a.a).a(2, (MsgChattingPresent.l(this.a.a)).is_gift_new_content); 
                    } 
                  }
                });
          }
        }300L);
  }
  
  private void ai() {
    if (this.U.expireTime != 0L) {
      SessionModel sessionModel = this.U;
      sessionModel.expireTime = 0L;
      sessionModel.totalMoney = 0.0F;
      ChatManager.getInstance().updateSessionTopGift(this.U.sessionType, this.U.sessionId, 0L, 0.0F);
    } 
  }
  
  private void c(int paramInt) {
    if (this.j != null) {
      ChattingModel chattingModel = new ChattingModel();
      chattingModel.msgType = 0;
      chattingModel.msgContent = this.j.getContext().getResources().getString(2131756547);
      (this.j.P()).a.add(paramInt, chattingModel);
      this.j.B();
    } 
  }
  
  public int A() {
    return this.q;
  }
  
  public int B() {
    return this.r;
  }
  
  public int C() {
    return this.s;
  }
  
  public String D() {
    return this.u;
  }
  
  public String E() {
    return this.w;
  }
  
  public LogData F() {
    return this.a;
  }
  
  public SessionSettingModel G() {
    return this.T;
  }
  
  public SessionModel H() {
    return this.U;
  }
  
  public int I() {
    return this.D;
  }
  
  public long J() {
    return this.E;
  }
  
  public int K() {
    return this.F;
  }
  
  public boolean L() {
    return this.I;
  }
  
  public boolean M() {
    return this.J;
  }
  
  public UserInfoBasicModel N() {
    return this.S;
  }
  
  public boolean O() {
    return this.H;
  }
  
  public boolean P() {
    return this.G;
  }
  
  public boolean Q() {
    return this.N;
  }
  
  public boolean R() {
    return this.O;
  }
  
  public boolean S() {
    return this.P;
  }
  
  public int T() {
    return this.Q;
  }
  
  public boolean U() {
    IMsgChattingView iMsgChattingView = this.j;
    if (iMsgChattingView == null)
      return false; 
    Bundle bundle = iMsgChattingView.getArguments();
    if (bundle != null) {
      this.b = bundle.getLong("passby_session_id");
      this.c = bundle.getShort("passby_session_type");
      this.d = bundle.getString("passby_nick_name");
      this.e = bundle.getString("passby_avatar");
      this.o = bundle.getInt("passby_vbadge");
      this.p = bundle.getInt("passby_vip_grade", 0);
      this.q = bundle.getInt("passby_is_vip_annual", 0);
      this.r = bundle.getInt("passby_vip_exp_lvl", 0);
      this.s = bundle.getInt("passby_is_hide_vip_look", 0);
      this.u = bundle.getString("passby_last_msg_distance");
      this.v = bundle.getBoolean("passby_session_secret");
      this.x = bundle.getBoolean("IS_FROM_MSG_BOX", false);
      this.y = bundle.getLong("PASSBY_MSG_ID", -1L);
      this.z = bundle.getLong("PASSBY_MSG_LOCAL_ID", -1L);
      try {
        this.a = (LogData)bundle.getSerializable("PASSBY_LOG_DATA");
      } catch (Exception exception) {
        this.a = new LogData();
      } 
      this.a.b = String.valueOf(this.b);
      try {
        this.V = (MsgSourceEntity)bundle.getSerializable("msg_source_model");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("msgSource===");
        stringBuilder.append(this.V.getType());
        Logger.c("msgSource", new Object[] { stringBuilder.toString() });
      } catch (Exception exception) {
        this.V = new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, "");
      } 
      ChatBundleExtra chatBundleExtra = (ChatBundleExtra)bundle.getSerializable("EXTRA");
      if (chatBundleExtra != null && chatBundleExtra.fuGiftListEvent != null && chatBundleExtra.fuGiftListEvent.a != null)
        AppInfo.n().postDelayed(new Runnable(this, chatBundleExtra) {
              public void run() {
                if (MsgChattingPresent.a(this.b) != null)
                  MsgChattingPresent.a(this.b).a(this.a.fuGiftListEvent); 
              }
            }500L); 
      if (this.b <= 0L)
        return false; 
      short s = this.c;
      if (s == 2) {
        InstantLog.a("chat_page_show", Integer.valueOf(0));
        this.k = false;
      } else {
        if (s == 3) {
          SocialNetWorkProtos.SourceType sourceType;
          InstantLog.a("chat_page_show", Integer.valueOf(1));
          this.k = true;
          SocialNetWorkProtos.Event event = SocialNetWorkProtos.Event.GROUP_CHAT_SHOW;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.b);
          stringBuilder.append("");
          String str = stringBuilder.toString();
          if (this.a.g == "group_info") {
            sourceType = SocialNetWorkProtos.SourceType.GROUPINFO;
          } else {
            sourceType = SocialNetWorkProtos.SourceType.MESSAGE;
          } 
          EventTrackGroup.a(event, str, sourceType);
          Y();
          return true;
        } 
        return false;
      } 
      Y();
      return true;
    } 
    return false;
  }
  
  public boolean V() {
    return !(this.y != -1L && this.z != -1L);
  }
  
  public String W() {
    return this.k ? "群聊页" : "私聊页";
  }
  
  public int X() {
    SessionSettingModel sessionSettingModel = this.T;
    return (sessionSettingModel != null) ? sessionSettingModel.getRemindAudio() : ChatConstants.b;
  }
  
  public void Y() {
    if (this.j == null)
      return; 
    this.U = ChatManager.getInstance().getSnapSessionModel(this.c, this.b);
    SessionModel sessionModel = this.U;
    if (sessionModel != null) {
      IMsgChattingView iMsgChattingView = this.j;
      if (iMsgChattingView != null)
        iMsgChattingView.a(sessionModel); 
      this.D = this.U.noReadMsgCount;
      this.E = this.U.lastMsgId - this.D + 1L;
      this.n = this.U.lastDraft;
      this.T = (SessionSettingModel)this.U.sessionSettingModel;
      SessionSettingModel sessionSettingModel = this.T;
      if (sessionSettingModel != null) {
        this.w = sessionSettingModel.getChatBgUri();
        this.m = this.T.getSessinoNote();
        this.j.v();
      } else {
        this.L = true;
        ChatManager.getInstance().getSessionSettingModel(this.c, this.b, new FetchDataListener<SessionSettingBaseModel>(this) {
              public void a(SessionSettingBaseModel param1SessionSettingBaseModel) {
                if (param1SessionSettingBaseModel != null)
                  MsgChattingPresent.a(this.a, (SessionSettingModel)param1SessionSettingBaseModel); 
                if (MsgChattingPresent.j(this.a) != null) {
                  MsgChattingPresent msgChattingPresent = this.a;
                  MsgChattingPresent.a(msgChattingPresent, MsgChattingPresent.j(msgChattingPresent).getChatBgUri());
                  msgChattingPresent = this.a;
                  MsgChattingPresent.b(msgChattingPresent, MsgChattingPresent.j(msgChattingPresent).getSessinoNote());
                  MsgChattingPresent.a(this.a).v();
                } 
                MsgChattingPresent.a(this.a).t();
              }
            });
      } 
      ai();
      return;
    } 
    this.L = true;
    ChatManager.getInstance().getSessionModel(this.c, this.b, this);
  }
  
  public void Z() {
    ChatConstants.a = this.b;
    if (!this.L) {
      Logger.c(h, new Object[] { "onResume==updateInfo" });
      this.j.t();
    } 
  }
  
  public long a() {
    try {
      return Long.parseLong(this.f);
    } finally {
      Exception exception = null;
    } 
  }
  
  public ChattingModel a(short paramShort, String paramString) {
    return a(paramShort, paramString, "");
  }
  
  public ChattingModel a(short paramShort, String paramString1, String paramString2) {
    return ChatHelper.getChattingModelForSendmsg(this.b, paramShort, paramString1, ChatHelperV4.a().b(), paramString2, this.c);
  }
  
  public void a(int paramInt) {
    IMsgChattingView iMsgChattingView = this.j;
    if (iMsgChattingView != null) {
      if (iMsgChattingView.P() != null && (this.j.P()).a != null && paramInt >= 0) {
        ChattingModel chattingModel = (this.j.P()).a.get(paramInt);
        if (chattingModel != null && chattingModel.msgType != 0) {
          int i = paramInt - 1;
          if (i < 0) {
            c(paramInt);
          } else {
            chattingModel = (this.j.P()).a.get(i);
            if (chattingModel != null && chattingModel.msgType != 0)
              c(paramInt); 
          } 
        } 
      } 
      this.j.B();
    } 
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(long paramLong1, long paramLong2, Handler paramHandler) {
    ChatManager.getInstance().loadSessionDownMsgList(w(), this.b, 20, paramLong1, paramLong2, new LoadListener(this, paramHandler) {
          public void onLoadFailed(String param1String) {
            Handler handler = this.a;
            if (handler != null)
              handler.sendEmptyMessage(304); 
          }
          
          public void onLoadSuccess() {
            Handler handler = this.a;
            if (handler != null)
              handler.sendEmptyMessage(303); 
          }
        });
  }
  
  public void a(Intent paramIntent) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(Bundle paramBundle) {
    if (!TextUtils.isEmpty(this.R))
      paramBundle.putString("image_path", this.R); 
  }
  
  public void a(Handler paramHandler) {
    ChatManager.getInstance().loadSessionMsgList(w(), this.b, 20, new LoadListener(this, paramHandler) {
          public void onLoadFailed(String param1String) {
            Handler handler = this.a;
            if (handler != null)
              handler.sendEmptyMessage(304); 
          }
          
          public void onLoadSuccess() {
            Handler handler = this.a;
            if (handler != null)
              handler.sendEmptyMessage(303); 
          }
        });
  }
  
  public void a(Handler paramHandler, int paramInt) {
    IMsgChattingView iMsgChattingView = this.j;
    if (iMsgChattingView == null)
      return; 
    if (this.C == paramInt)
      return; 
    this.C = paramInt;
    if (this.G) {
      if (this.U == null)
        return; 
      paramInt = this.F;
      if (paramInt >= 0)
        iMsgChattingView.c(paramInt); 
      this.Q = (this.j.P()).a.size();
      if (!this.K)
        a(paramHandler); 
    } 
  }
  
  public void a(ChattingModel paramChattingModel) {
    this.N = true;
    ChatHelperV4.a().a(paramChattingModel, this.d, this.e, this.o, this.p, this.q, this.r, this.s);
  }
  
  public void a(ChattingModel paramChattingModel, boolean paramBoolean) {
    this.N = true;
    ChatHelperV4.a().c(paramChattingModel, this.d, this.e, this.o, this.p, this.q, this.r, this.s, paramBoolean);
    u();
  }
  
  public void a(SessionModel paramSessionModel) {
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramSessionModel != null) {
      this.n = paramSessionModel.lastDraft;
      this.U = paramSessionModel;
      IMsgChattingView iMsgChattingView = this.j;
      if (iMsgChattingView != null && paramSessionModel != null)
        iMsgChattingView.a(paramSessionModel); 
      if (this.U != null)
        this.T = (SessionSettingModel)paramSessionModel.sessionSettingModel; 
      SessionSettingModel sessionSettingModel = this.T;
      bool1 = bool2;
      if (sessionSettingModel != null) {
        this.w = sessionSettingModel.getChatBgUri();
        this.m = this.T.getSessinoNote();
        this.j.v();
        bool1 = false;
      } 
      ai();
    } 
    if (bool1) {
      ChatManager.getInstance().getSessionSettingModel(this.c, this.b, new FetchDataListener<SessionSettingBaseModel>(this) {
            public void a(SessionSettingBaseModel param1SessionSettingBaseModel) {
              MsgChattingPresent.a(this.a, (SessionSettingModel)param1SessionSettingBaseModel);
              if (MsgChattingPresent.j(this.a) == null) {
                MsgChattingPresent.a(this.a, new SessionSettingModel());
                MsgChattingPresent.j(this.a).setLoadName(Long.valueOf(UserInfo.a().i().getUid()).longValue());
                MsgChattingPresent.j(this.a).setSessionId(this.a.b);
                MsgChattingPresent.j(this.a).setSessionType(this.a.c);
              } else {
                MsgChattingPresent msgChattingPresent = this.a;
                MsgChattingPresent.a(msgChattingPresent, MsgChattingPresent.j(msgChattingPresent).getChatBgUri());
              } 
              MsgChattingPresent.a(this.a).v();
              MsgChattingPresent.a(this.a).t();
            }
          });
      return;
    } 
    this.j.t();
  }
  
  public void a(BaseFragment paramBaseFragment) {
    MsgPhotoSelectFragment.a(paramBaseFragment, 4, c(), 605);
  }
  
  public void a(UserInfoBasicModel paramUserInfoBasicModel) {
    if (paramUserInfoBasicModel == null)
      return; 
    this.d = paramUserInfoBasicModel.name;
    this.e = paramUserInfoBasicModel.avatar;
    this.o = paramUserInfoBasicModel.vbadge;
    this.p = paramUserInfoBasicModel.vip_grade;
    this.q = paramUserInfoBasicModel.is_vip_annual;
    this.r = paramUserInfoBasicModel.vip_exp_lvl;
    this.s = paramUserInfoBasicModel.is_hide_vip_look;
    this.t = paramUserInfoBasicModel.is_show_vip_page;
    this.m = paramUserInfoBasicModel.note;
    this.B = paramUserInfoBasicModel.in_blacklist;
    Logger.b(h, new Object[] { "isInMyBlacklist===", this.B });
  }
  
  public void a(IRecentPhotoAdapterCallback.IGetPhotoListCallback paramIGetPhotoListCallback) {
    this.W.a(paramIGetPhotoListCallback);
  }
  
  public void a(HelloExpressionData paramHelloExpressionData) {
    String str = ChatHelperV4.a().a(this.V, paramHelloExpressionData.w, paramHelloExpressionData.h);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramHelloExpressionData.gif);
    stringBuilder.append("@");
    stringBuilder.append(paramHelloExpressionData.title);
    ChattingModel chattingModel = a((short)205, stringBuilder.toString(), str);
    ChatHelperV4.a().c(chattingModel, this.d, this.e, this.o, this.p, this.q, this.r, this.s, false);
  }
  
  public void a(MsgRecentPhotoInfo paramMsgRecentPhotoInfo) {
    this.W.b(paramMsgRecentPhotoInfo);
  }
  
  public void a(GroupInfoModel paramGroupInfoModel) {
    this.Z = paramGroupInfoModel;
  }
  
  public void a(GiftGivingOptionForJsonParse paramGiftGivingOptionForJsonParse) {
    if (paramGiftGivingOptionForJsonParse == null)
      return; 
    IMsgChattingView iMsgChattingView = this.j;
    if (iMsgChattingView != null)
      iMsgChattingView.a(paramGiftGivingOptionForJsonParse); 
    ChatHelperV4 chatHelperV4 = ChatHelperV4.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(f());
    stringBuilder.append("");
    chatHelperV4.a(stringBuilder.toString(), e(), d(), this.o, z(), A(), B(), C(), paramGiftGivingOptionForJsonParse, this.V);
  }
  
  public void a(Object paramObject) {
    // Byte code:
    //   0: aload_1
    //   1: checkcast com/blued/android/chat/model/ChattingModel
    //   4: astore_1
    //   5: aload_1
    //   6: getfield msgType : S
    //   9: istore_2
    //   10: iload_2
    //   11: iconst_2
    //   12: if_icmpeq -> 63
    //   15: iload_2
    //   16: iconst_3
    //   17: if_icmpeq -> 63
    //   20: iload_2
    //   21: iconst_5
    //   22: if_icmpeq -> 56
    //   25: iload_2
    //   26: bipush #9
    //   28: if_icmpeq -> 50
    //   31: iload_2
    //   32: bipush #24
    //   34: if_icmpeq -> 63
    //   37: iload_2
    //   38: bipush #25
    //   40: if_icmpeq -> 56
    //   43: aload_0
    //   44: aload_1
    //   45: iconst_1
    //   46: invokevirtual a : (Lcom/blued/android/chat/model/ChattingModel;Z)V
    //   49: return
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual a : (Lcom/blued/android/chat/model/ChattingModel;)V
    //   55: return
    //   56: aload_0
    //   57: aload_1
    //   58: iconst_1
    //   59: invokevirtual c : (Lcom/blued/android/chat/model/ChattingModel;Z)V
    //   62: return
    //   63: aload_0
    //   64: aload_1
    //   65: iconst_1
    //   66: invokevirtual b : (Lcom/blued/android/chat/model/ChattingModel;Z)V
    //   69: return
  }
  
  public void a(String paramString) {
    this.w = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {
    MsgRecentPhotoInfo msgRecentPhotoInfo = this.W.a(paramString, paramInt1, paramInt2);
    this.W.a(msgRecentPhotoInfo, new RecentPhotoManager.IRecordPicCallback(this) {
          public void a() {
            if (MsgChattingPresent.a(this.a) != null)
              MsgChattingPresent.a(this.a).a(new Runnable(this) {
                    public void run() {
                      if (MsgChattingPresent.a(this.a.a) != null)
                        MsgChattingPresent.a(this.a.a).w(); 
                    }
                  }); 
          }
        });
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, int paramInt3) {
    if (!StringUtils.e(paramString1)) {
      if (StringUtils.e(paramString2))
        return; 
      if (paramInt1 > 0) {
        ChattingModel chattingModel;
        if (paramInt2 <= 0)
          return; 
        if (paramInt3 == 1) {
          chattingModel = a((short)25, paramString1, "");
        } else {
          chattingModel = a((short)5, (String)chattingModel, "");
        } 
        chattingModel.msgMapExtra = new HashMap<Object, Object>();
        chattingModel.msgMapExtra.put("video_width", Integer.valueOf(paramInt1));
        chattingModel.msgMapExtra.put("video_height", Integer.valueOf(paramInt2));
        chattingModel.msgMapExtra.put("video_time_long", Long.valueOf(paramLong));
        chattingModel.msgMapExtra.put("msgSource", this.V);
        if (chattingModel == null)
          return; 
        chattingModel.msgVideoCoverUrlLocal = paramString2;
        c(chattingModel, false);
      } 
    } 
  }
  
  public void a(boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void aa() {
    this.L = false;
  }
  
  public void ab() {
    if (this.j == null)
      return; 
    if (!this.M) {
      this.M = true;
      ChatManager.getInstance().unregisterMsgContentListener(this.c, this.b, this);
    } 
    ChatConstants.a = 0L;
    IMV4Constant.b = false;
    String str = this.j.T();
    if (TextUtils.isEmpty(str.trim()) && !TextUtils.isEmpty(this.n)) {
      ChatManager.getInstance().updateSessionDraft(this.c, this.b, "");
    } else if (!TextUtils.isEmpty(str.trim())) {
      ChatManager.getInstance().updateSessionDraft(this.c, this.b, str);
    } 
    ChatManager.getInstance().updateMsgForTextTranslateInit(this.c, this.b);
    IMsgChattingView iMsgChattingView = this.j;
    if (iMsgChattingView != null && iMsgChattingView.P() != null && this.j.P().getCount() == 1) {
      ChattingModel chattingModel = (ChattingModel)this.j.P().getItem(0);
      if (chattingModel != null && chattingModel.msgType == -2)
        ChatManager.getInstance().deleteSessionAndChatting(Short.valueOf((short)2), Long.valueOf(this.b).longValue()); 
    } 
    this.j.V().getWindow().clearFlags(128);
  }
  
  public void ac() {
    if (this.U == null)
      return; 
    ChatManager.getInstance().deleteSession(this.U.sessionType, this.b);
    IMsgChattingView iMsgChattingView = this.j;
    if (iMsgChattingView != null && iMsgChattingView.V() != null)
      this.j.V().finish(); 
  }
  
  public void ad() {
    a(new FetchDataListener<SessionModel>(this) {
          public void a(SessionModel param1SessionModel) {
            if (param1SessionModel != null && param1SessionModel._msgList != null) {
              if (param1SessionModel._msgList.size() > 2)
                return; 
              if (param1SessionModel._msgList.size() == 2 && ((ChattingModel)param1SessionModel._msgList.get(0)).msgType != -2)
                return; 
              if (param1SessionModel._msgList.size() == 2) {
                chattingModel = (ChattingModel)param1SessionModel._msgList.get(1);
              } else {
                chattingModel = (ChattingModel)param1SessionModel._msgList.get(0);
              } 
              ChattingModel chattingModel = chattingModel;
              String str = MsgChattingPresent.ag();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("fromId==");
              stringBuilder.append(chattingModel.fromId);
              Logger.c(str, new Object[] { stringBuilder.toString() });
              str = MsgChattingPresent.ag();
              stringBuilder = new StringBuilder();
              stringBuilder.append("getSessionId==");
              stringBuilder.append(this.a.f());
              Logger.c(str, new Object[] { stringBuilder.toString() });
              str = MsgChattingPresent.ag();
              stringBuilder = new StringBuilder();
              stringBuilder.append("msgId==");
              stringBuilder.append(chattingModel.msgId);
              Logger.c(str, new Object[] { stringBuilder.toString() });
              str = MsgChattingPresent.ag();
              stringBuilder = new StringBuilder();
              stringBuilder.append("getIsShowMessageEditTip==");
              stringBuilder.append(BluedConfig.b().z());
              Logger.c(str, new Object[] { stringBuilder.toString() });
              str = MsgChattingPresent.ag();
              stringBuilder = new StringBuilder();
              stringBuilder.append("time==");
              stringBuilder.append(System.currentTimeMillis() - chattingModel.msgTimestamp);
              Logger.c(str, new Object[] { stringBuilder.toString() });
              if (IMV4Method.a(chattingModel.fromId) == 0 && chattingModel.msgId == 1L && chattingModel.msgType != -1 && !BluedPreferences.cP() && BluedConfig.b().z())
                ChatHelperV4.a().a(param1SessionModel, chattingModel); 
            } 
          }
        });
  }
  
  public SessionSettingModel ae() {
    return this.T;
  }
  
  public void af() {
    if (this.k)
      return; 
    IMsgChattingView iMsgChattingView = this.j;
    if (iMsgChattingView != null && iMsgChattingView.U().isActive())
      ChatHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<HelloExpressionData>>(this, this.j.U()) {
            protected void a(BluedEntityA<HelloExpressionData> param1BluedEntityA) {
              if (param1BluedEntityA.hasData() && MsgChattingPresent.a(this.a) != null)
                MsgChattingPresent.a(this.a).b(param1BluedEntityA.data); 
            }
          }this.j.U()); 
  }
  
  public int b() {
    GroupInfoModel groupInfoModel = this.Z;
    return (groupInfoModel != null) ? groupInfoModel.group_role : 0;
  }
  
  public void b(int paramInt) {
    this.Q = paramInt;
  }
  
  public void b(Handler paramHandler) {
    if (this.v) {
      ChatManager.getInstance().registerMsgContentListenerSecret(this.c, this.b, this);
    } else {
      ChatManager.getInstance().registerMsgContentListener(this.c, this.b, this);
    } 
    this.M = false;
    if (V()) {
      a(paramHandler);
    } else {
      a(this.y, this.z, paramHandler);
    } 
    if (!this.k)
      ah(); 
  }
  
  public void b(ChattingModel paramChattingModel) {
    if (this.V != null) {
      paramChattingModel.setMsgExtra(ChatHelperV4.a().a(this.V));
      this.V = null;
    } 
  }
  
  public void b(ChattingModel paramChattingModel, boolean paramBoolean) {
    this.N = true;
    ChatHelperV4.a().a(paramChattingModel, this.d, this.e, this.o, this.p, this.q, this.r, this.s, paramBoolean);
    u();
  }
  
  public void b(IRecentPhotoAdapterCallback.IGetPhotoListCallback paramIGetPhotoListCallback) {
    this.W.b(paramIGetPhotoListCallback);
  }
  
  public void b(MsgRecentPhotoInfo paramMsgRecentPhotoInfo) {
    this.W.a(paramMsgRecentPhotoInfo);
  }
  
  public void b(GroupInfoModel paramGroupInfoModel) {
    this.d = paramGroupInfoModel.group_title;
    this.e = paramGroupInfoModel.group_cover;
  }
  
  public void b(String paramString) {
    this.f = paramString;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramInt1 <= 0)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(",,");
      stringBuilder.append(paramInt1);
      ChattingModel chattingModel = a((short)3, stringBuilder.toString());
      if (chattingModel == null)
        return; 
      chattingModel.setMsgExtra(ChatHelperV4.a().b(this.V));
      b(chattingModel, false);
    } 
  }
  
  public void b(boolean paramBoolean) {
    this.I = paramBoolean;
  }
  
  public void c(ChattingModel paramChattingModel, boolean paramBoolean) {
    this.N = true;
    ChatHelperV4.a().b(paramChattingModel, this.d, this.e, this.o, this.p, this.q, this.r, this.s, paramBoolean);
    u();
  }
  
  public void c(String paramString) {
    this.g = paramString;
  }
  
  public void c(boolean paramBoolean) {
    this.J = paramBoolean;
  }
  
  public boolean c() {
    return this.k;
  }
  
  public String d() {
    return this.e;
  }
  
  public void d(boolean paramBoolean) {
    this.H = paramBoolean;
  }
  
  public String e() {
    return this.d;
  }
  
  public void e(boolean paramBoolean) {
    this.G = paramBoolean;
  }
  
  public long f() {
    return this.b;
  }
  
  public void f(boolean paramBoolean) {
    this.N = paramBoolean;
  }
  
  public String g() {
    return this.f;
  }
  
  public void g(boolean paramBoolean) {
    this.O = paramBoolean;
  }
  
  public String h() {
    return this.g;
  }
  
  public void h(boolean paramBoolean) {
    this.P = paramBoolean;
  }
  
  public PayExperimentConfigModel i() {
    return this.Y;
  }
  
  public GroupInfoModel j() {
    return this.Z;
  }
  
  public void k() {
    if (this.j == null)
      return; 
    if (this.W.a().size() > 0)
      this.W.b(new IRecentPhotoAdapterCallback.IGetPhotoListCallback(this) {
            public void a(List<MsgRecentPhotoInfo> param1List) {
              MessageProtos.PhotoType photoType;
              ArrayList<ChattingModel> arrayList = new ArrayList();
              for (MsgRecentPhotoInfo msgRecentPhotoInfo : param1List) {
                String str;
                ChattingModel chattingModel;
                if (MsgChattingPresent.a(this.a).P().getCount() <= 0) {
                  str = ChatHelperV4.a().a(MsgChattingPresent.b(this.a), msgRecentPhotoInfo.width, msgRecentPhotoInfo.height);
                } else {
                  str = ChatHelperV4.a().a(msgRecentPhotoInfo.width, msgRecentPhotoInfo.height);
                } 
                if (MsgChattingPresent.b(this.a) != null)
                  MsgChattingPresent.a(this.a, (MsgSourceEntity)null); 
                if (MsgChattingPresent.c(this.a) == 1) {
                  chattingModel = this.a.a((short)24, msgRecentPhotoInfo.imgPath, str);
                } else {
                  chattingModel = this.a.a((short)2, msgRecentPhotoInfo.imgPath, (String)chattingModel);
                } 
                if (chattingModel == null)
                  continue; 
                arrayList.add(chattingModel);
                this.a.a(msgRecentPhotoInfo.imgPath, msgRecentPhotoInfo.width, msgRecentPhotoInfo.height);
              } 
              ChatHelperV4.a().a(arrayList, this.a.d, this.a.e, MsgChattingPresent.d(this.a), MsgChattingPresent.e(this.a), MsgChattingPresent.f(this.a), MsgChattingPresent.g(this.a), MsgChattingPresent.h(this.a));
              MessageProtos.Event event = MessageProtos.Event.MSG_SEND_PHOTO;
              MessageProtos.SourceType sourceType = MessageProtos.SourceType.RECENT_PHOTO;
              int i = param1List.size();
              if (MsgChattingPresent.c(this.a) == 1) {
                photoType = MessageProtos.PhotoType.BURN_AFTER_READ;
              } else {
                photoType = MessageProtos.PhotoType.NORMAL_PHOTO;
              } 
              EventTrackMessage.a(event, sourceType, i, photoType);
              this.a.u();
            }
          }); 
  }
  
  public List<MsgRecentPhotoInfo> l() {
    return this.W.a();
  }
  
  public void m() {
    this.W.b();
  }
  
  public void n() {
    IMsgChattingView iMsgChattingView = this.j;
    if (iMsgChattingView != null)
      ChatHttpUtils.a(iMsgChattingView.getContext(), new BluedUIHttpResponse<BluedEntityA<UserInfoBasicModel>>(this, this.j.U()) {
            public void a(BluedEntityA<UserInfoBasicModel> param1BluedEntityA) {
              List<UserInfoBasicModel> list = param1BluedEntityA.data;
              MsgChattingPresent.a(this.a, list.get(0));
              MsgChattingPresent.a(this.a).a(MsgChattingPresent.i(this.a));
              if (MsgChattingPresent.i(this.a) != null) {
                SessionProfileModel sessionProfileModel = new SessionProfileModel();
                sessionProfileModel.nickname = (MsgChattingPresent.i(this.a)).name;
                sessionProfileModel.avatar = (MsgChattingPresent.i(this.a)).avatar;
                sessionProfileModel.vBadge = (MsgChattingPresent.i(this.a)).vbadge;
                sessionProfileModel.vipAnnual = (MsgChattingPresent.i(this.a)).is_vip_annual;
                sessionProfileModel.vipExpLvl = (MsgChattingPresent.i(this.a)).vip_exp_lvl;
                sessionProfileModel.vipGrade = (MsgChattingPresent.i(this.a)).vip_grade;
                sessionProfileModel.hideVipLook = (MsgChattingPresent.i(this.a)).is_hide_vip_look;
                if (MsgChattingPresent.a(this.a).P() != null)
                  (MsgChattingPresent.a(this.a).P()).e = (MsgChattingPresent.i(this.a)).is_show_vip_page; 
                ChatManager.getInstance().updateSessionInfoData(this.a.c, this.a.b, sessionProfileModel);
                if (MsgChattingPresent.j(this.a) != null) {
                  String str;
                  MsgChattingPresent.j(this.a).setRemindAudio((MsgChattingPresent.i(this.a)).no_disturb);
                  SessionSettingModel sessionSettingModel = MsgChattingPresent.j(this.a);
                  if (StringUtils.e((MsgChattingPresent.i(this.a)).note)) {
                    str = "";
                  } else {
                    str = (MsgChattingPresent.i(this.a)).note;
                  } 
                  sessionSettingModel.setSessinoNote(str);
                  ChatManager.getInstance().setSessionSetting(this.a.c, this.a.b, (SessionSettingBaseModel)MsgChattingPresent.j(this.a));
                } else if (!TextUtils.isEmpty(MsgChattingPresent.k(this.a)) && !MsgChattingPresent.k(this.a).equals(this.a.d)) {
                  SessionSettingModel sessionSettingModel = new SessionSettingModel();
                  sessionSettingModel.setLoadName(Long.valueOf(UserInfo.a().i().getUid()).longValue());
                  sessionSettingModel.setSessionType(this.a.c);
                  sessionSettingModel.setSessionId(this.a.b);
                  sessionSettingModel.setSessinoNote(MsgChattingPresent.k(this.a));
                  ChatManager.getInstance().setSessionSetting(this.a.c, this.a.b, (SessionSettingBaseModel)sessionSettingModel);
                } 
                if ((MsgChattingPresent.i(this.a)).no_disturb == 0) {
                  MsgChattingPresent.a(this.a).b(8);
                } else {
                  MsgChattingPresent.a(this.a).b(0);
                } 
                if ((MsgChattingPresent.i(this.a)).is_locked == 1)
                  MsgChattingPresent.a(this.a).x(); 
                if ((MsgChattingPresent.i(this.a)).is_un_disturb != 1)
                  MsgChattingPresent.a(this.a).z(); 
                if ((MsgChattingPresent.i(this.a)).theme != null && MsgChattingPresent.j(this.a) != null && (MsgChattingPresent.j(this.a)).bubbleThemeId != (MsgChattingPresent.i(this.a)).theme.bubble) {
                  (MsgChattingPresent.j(this.a)).bubbleThemeId = (MsgChattingPresent.i(this.a)).theme.bubble;
                  MsgChattingPresent.a(this.a).a((MsgChattingPresent.i(this.a)).theme.bubble, true);
                } 
              } 
            }
          }String.valueOf(f()), this.j.U()); 
  }
  
  public void o() {
    IMsgChattingView iMsgChattingView = this.j;
    if (iMsgChattingView != null && iMsgChattingView.L() != null) {
      if (!this.j.U().isActive())
        return; 
      this.R = CameraUtils.a((Fragment)this.j.L());
    } 
  }
  
  public void onMsgDataChanged(List<ChattingModel> paramList) {
    IMsgChattingView iMsgChattingView = this.j;
    if (iMsgChattingView != null && iMsgChattingView.V() != null && !this.j.V().isFinishing())
      this.j.a(a(paramList)); 
  }
  
  public void p() {
    IMsgChattingView iMsgChattingView = this.j;
    if (iMsgChattingView == null)
      return; 
    if (this.k) {
      GroupInfoFragment.a(iMsgChattingView.getContext(), String.valueOf(this.b), this.Z, SocialNetWorkProtos.SourceType.MESSAGE);
      return;
    } 
    Bundle bundle = new Bundle();
    bundle.putString("passby_nick_name", this.d);
    bundle.putString("passby_nick_note", this.m);
    bundle.putString("passby_avatar", this.e);
    bundle.putInt("passby_vbadge", this.o);
    bundle.putString("passby_session_id", String.valueOf(this.b));
    bundle.putShort("passby_session_type", this.c);
    bundle.putString("passby_is_in_blacklist", this.B);
    bundle.putInt("passby_vip_grade", this.p);
    bundle.putInt("passby_is_vip_annual", this.q);
    bundle.putInt("passby_vip_exp_lvl", this.r);
    bundle.putInt("passby_remind_audio", X());
    bundle.putInt("passby_show_vip_page", this.t);
    bundle.putInt("passby_is_hide_vip_look", this.s);
    bundle.putSerializable("user", (Serializable)this.S);
    bundle.putBoolean("IS_FROM_MSG_BOX", this.x);
    TerminalActivity.a((Fragment)this.j.L(), ChatSettingFragment.class, bundle, 603);
  }
  
  public void q() {
    IMsgChattingView iMsgChattingView = this.j;
    if (iMsgChattingView == null)
      return; 
    KeyboardUtils.a(iMsgChattingView.V());
    if (F() != null && "group_create".equals((F()).g)) {
      HomeArgumentHelper.a(this.j.getContext(), "msg", null);
      return;
    } 
    if (!this.M) {
      this.M = true;
      ChatManager.getInstance().unregisterMsgContentListener(this.c, this.b, this);
    } 
    this.j.V().finish();
  }
  
  public void r() {
    this.P = false;
    this.O = false;
  }
  
  public void s() {
    if (this.J && t())
      a(this.F); 
  }
  
  public boolean t() {
    try {
      if (this.j == null || this.j.P() == null)
        this.F = -1; 
      if ((this.j.P()).a.size() >= this.D) {
        int i = (this.j.P()).a.size() - this.D;
        ChattingModel chattingModel = (this.j.P()).a.get(i);
        if (chattingModel != null) {
          if (this.E == chattingModel.msgId) {
            this.K = true;
            this.F = i;
          } else {
            if (this.E < chattingModel.msgId) {
              while (--i >= 0) {
                if (((ChattingModel)(this.j.P()).a.get(i)).msgId != this.E) {
                  this.F = 0;
                  i--;
                  continue;
                } 
                this.K = true;
                this.F = i;
              } 
              return this.K;
            } 
            while (++i < (this.j.P()).a.size()) {
              if (((ChattingModel)(this.j.P()).a.get(i)).msgId != this.E) {
                this.F = 0;
                i++;
                continue;
              } 
              this.K = true;
              this.F = i;
            } 
          } 
        } else {
          this.F = -1;
        } 
      } else {
        this.F = 0;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      this.F = -1;
    } 
    return this.K;
  }
  
  public void u() {
    if (!this.k) {
      LogData logData = this.a;
      if (logData != null && !this.l) {
        logData.J = "chat_send_msg";
        InstantLog.a(logData);
        this.l = true;
        EventTrackMessage.a(MessageProtos.Event.CHAT_SEND_MSG, this.a);
      } 
    } 
  }
  
  public void v() {
    if (!TextUtils.isEmpty(y()))
      ChatManager.getInstance().updateSessionDraft(this.c, this.b, ""); 
  }
  
  public short w() {
    return this.c;
  }
  
  public String x() {
    return this.m;
  }
  
  public String y() {
    return this.n;
  }
  
  public int z() {
    return this.p;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\presenter\MsgChattingPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */