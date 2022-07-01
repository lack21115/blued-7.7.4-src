package com.soft.blued.ui.msg_group.utils;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.message.MessageProtos;
import com.soft.blued.BluedConstant;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg_group.model.GroupConfigModel;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import com.soft.blued.ui.msg_group.model.ReportJsonModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GroupUtil {
  public static int a = 168;
  
  public static int a(int paramInt1, int paramInt2, int paramInt3) {
    boolean bool = false;
    if (paramInt1 == 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    } 
    if (paramInt2 == 1) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    } 
    if (paramInt3 == 1)
      bool = true; 
    return b(paramInt1, paramInt2, bool);
  }
  
  public static ReportJsonModel a(List<ChattingModel> paramList, ChattingModel paramChattingModel) {
    if (paramList == null || paramList.size() == 0)
      return null; 
    int i = paramList.indexOf(paramChattingModel);
    ReportJsonModel reportJsonModel = new ReportJsonModel();
    reportJsonModel.group_id = paramChattingModel.sessionId;
    reportJsonModel.report_uid = paramChattingModel.fromId;
    reportJsonModel.contexts = new ArrayList();
    if (i >= 0) {
      int j = i - 5;
      while (true) {
        if (j <= i + 5) {
          if (j >= 0) {
            if (j >= paramList.size())
              return reportJsonModel; 
            ChattingModel chattingModel = paramList.get(j);
            if (chattingModel.msgType == 1 || chattingModel.msgType == 2 || chattingModel.msgType == 5 || chattingModel.msgType == 3) {
              ReportJsonModel.ReportMsgContent reportMsgContent = new ReportJsonModel.ReportMsgContent();
              reportMsgContent.contents = chattingModel.msgContent;
              reportMsgContent.createdAt = chattingModel.msgTimestamp;
              reportMsgContent.uid = chattingModel.fromId;
              reportMsgContent.messageId = chattingModel.msgId;
              reportMsgContent.setMsgTypeString(chattingModel.msgType);
              try {
                if (chattingModel.msgType == 3) {
                  reportMsgContent.url = chattingModel.msgContent.split(",,")[0];
                } else {
                  reportMsgContent.url = chattingModel.msgContent;
                } 
              } finally {
                Exception exception;
              } 
              if (chattingModel.msgId == paramChattingModel.msgId)
                reportMsgContent.report = 1; 
              reportJsonModel.contexts.add(reportMsgContent);
            } 
          } 
          j++;
          continue;
        } 
        return reportJsonModel;
      } 
    } 
    return reportJsonModel;
  }
  
  public static String a(List<Integer> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<Integer> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      stringBuilder.append(d(((Integer)iterator.next()).intValue()));
      stringBuilder.append("、");
    } 
    String str = stringBuilder.toString();
    return (str.length() > 1) ? str.substring(0, str.length() - 1) : "";
  }
  
  public static void a() {
    MsgGroupHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<GroupConfigModel>>(null) {
          protected void a(BluedEntityA<GroupConfigModel> param1BluedEntityA) {
            if (param1BluedEntityA.hasData()) {
              boolean bool;
              GroupConfigModel groupConfigModel = param1BluedEntityA.data.get(0);
              if (groupConfigModel.tips_interval != 0)
                GroupUtil.a = groupConfigModel.tips_interval; 
              if (groupConfigModel.group_open == 0) {
                bool = true;
              } else {
                bool = false;
              } 
              BluedConstant.a = bool;
              if (BluedPreferences.db() && groupConfigModel.groups != null && groupConfigModel.groups.size() > 0) {
                ChatManager.getInstance().getSessionModelMap(new FetchDataListener<Map<String, SessionModel>>(this, groupConfigModel) {
                      public void a(Map<String, SessionModel> param2Map) {
                        ArrayList<GroupInfoModel> arrayList = new ArrayList();
                        for (GroupInfoModel groupInfoModel : this.a.groups) {
                          long l = groupInfoModel.group_id;
                          if (param2Map != null) {
                            SessionModel sessionModel = param2Map.get(SessionHeader.getSessionKey(3, l));
                            if (sessionModel != null && sessionModel.sessionSettingModel != null) {
                              SessionSettingModel sessionSettingModel = (SessionSettingModel)sessionModel.sessionSettingModel;
                              sessionSettingModel.setRemindAudio(GroupUtil.a(groupInfoModel.message_is_mute, groupInfoModel.at_message_is_mute, groupInfoModel.notice_is_mute));
                              ChatManager.getInstance().setSessionSetting((short)3, l, (SessionSettingBaseModel)sessionSettingModel);
                              continue;
                            } 
                          } 
                          arrayList.add(groupInfoModel);
                        } 
                        for (GroupInfoModel groupInfoModel : arrayList) {
                          long l = groupInfoModel.group_id;
                          SessionSettingModel sessionSettingModel = new SessionSettingModel();
                          sessionSettingModel.setRemindAudio(GroupUtil.a(groupInfoModel.message_is_mute, groupInfoModel.at_message_is_mute, groupInfoModel.notice_is_mute));
                          sessionSettingModel.setLoadName(Long.valueOf(UserInfo.a().i().getUid()).longValue());
                          sessionSettingModel.setSessionId(l);
                          sessionSettingModel.setSessionType((short)3);
                          ChatManager.getInstance().setSessionSetting((short)3, l, (SessionSettingBaseModel)sessionSettingModel);
                        } 
                      }
                    });
                BluedPreferences.K(false);
              } 
            } 
          }
        });
  }
  
  public static void a(TextView paramTextView, UserBasicModel paramUserBasicModel) {
    if (!TextUtils.isEmpty(paramUserBasicModel.note)) {
      paramTextView.setText(paramUserBasicModel.note);
      return;
    } 
    if (!TextUtils.isEmpty(paramUserBasicModel.name)) {
      paramTextView.setText(paramUserBasicModel.name);
      return;
    } 
    paramTextView.setText("");
  }
  
  public static void a(SessionModel paramSessionModel, ImageView paramImageView, IRequestHost paramIRequestHost) {
    ChatManager.getInstance().getSessionModelList(new FetchDataListener<List<SessionModel>>(paramIRequestHost, paramImageView, paramSessionModel) {
          public void a(List<SessionModel> param1List) {
            AppInfo.n().post(new -$$Lambda$GroupUtil$1$u67Zv5dxAzjfw23vxf2ZTYN4Z5k(this.a, this.b, param1List, this.c));
          }
        });
  }
  
  public static void a(IRequestHost paramIRequestHost, String paramString, ImageView paramImageView) {
    ImageLoader.a(paramIRequestHost, AvatarUtils.a(0, paramString)).c().a(2131234356).a(paramImageView);
  }
  
  public static void a(ShapeTextView paramShapeTextView, int paramInt) {
    paramShapeTextView.setVisibility(0);
    if (paramInt != 1) {
      if (paramInt != 2) {
        paramShapeTextView.setVisibility(8);
        return;
      } 
      paramShapeTextView.setText(paramShapeTextView.getContext().getString(2131756625));
      ShapeHelper.b((ShapeHelper.ShapeView)paramShapeTextView, 2131100456);
      ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, 2131100716);
      return;
    } 
    paramShapeTextView.setText(paramShapeTextView.getContext().getString(2131756710));
    ShapeHelper.b((ShapeHelper.ShapeView)paramShapeTextView, 2131100459);
    ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, 2131099802);
  }
  
  public static void a(Object paramObject1, String paramString, Object paramObject2) throws Exception {
    Field field = paramObject1.getClass().getDeclaredField(paramString);
    field.setAccessible(true);
    field.set(paramObject1, paramObject2);
  }
  
  public static boolean a(int paramInt) {
    return ((paramInt & 0x1) != 0);
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3) {
    return paramInt1 | paramInt2 << 1 | paramInt3 << 2;
  }
  
  public static void b(IRequestHost paramIRequestHost, String paramString, ImageView paramImageView) {
    ImageLoader.a(paramIRequestHost, paramString).c().a(paramImageView);
  }
  
  public static boolean b(int paramInt) {
    return ((paramInt & 0x2) != 0);
  }
  
  public static boolean c(int paramInt) {
    return ((paramInt & 0x4) != 0);
  }
  
  public static String d(int paramInt) {
    switch (paramInt) {
      default:
        return "";
      case 9:
        return AppInfo.d().getResources().getString(2131757903);
      case 8:
        return AppInfo.d().getResources().getString(2131758375);
      case 7:
        return AppInfo.d().getResources().getString(2131756126);
      case 6:
        return AppInfo.d().getResources().getString(2131755820);
      case 5:
        return AppInfo.d().getResources().getString(2131756219);
      case 4:
        return AppInfo.d().getResources().getString(2131758403);
      case 2:
        return AppInfo.d().getResources().getString(2131758404);
      case 1:
        return AppInfo.d().getResources().getString(2131755235);
      case 0:
        break;
    } 
    return AppInfo.d().getResources().getString(2131758335);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_grou\\utils\GroupUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */