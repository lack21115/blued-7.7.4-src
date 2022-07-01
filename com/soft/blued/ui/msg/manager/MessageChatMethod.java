package com.soft.blued.ui.msg.manager;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.RetractionListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AppUtils;
import com.blued.das.message.MessageProtos;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback;
import com.soft.blued.ui.msg.contract.IMsgChatAdapterOperationCallback;
import com.soft.blued.ui.msg.controller.tools.IMV4Method;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.msg.model.MsgContentTranslatedEntity;
import com.soft.blued.ui.user.fragment.VipBubbleFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.NetworkUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.net.URLDecoder;
import java.util.List;
import java.util.Set;

public class MessageChatMethod {
  public static void a(Context paramContext, ChattingModel paramChattingModel) {
    String str;
    MessageProtos.Event event = MessageProtos.Event.MSG_CLICK_BUBBLE_CLICK;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramChattingModel.fromId);
    stringBuilder.append("");
    EventTrackMessage.a(event, null, stringBuilder.toString());
    if (paramChattingModel.isFromSelf()) {
      str = "chat_msg_bubble_owner";
    } else {
      str = "chat_msg_bubble_guest";
    } 
    VipBubbleFragment.a(paramContext, 0, str);
  }
  
  public static void a(Context paramContext, ChattingModel paramChattingModel, IMsgChatAdapterCallback paramIMsgChatAdapterCallback) {
    if (NetworkUtils.b()) {
      if (a(paramChattingModel, paramIMsgChatAdapterCallback)) {
        ChatManager.getInstance().retractOneMessage(paramChattingModel.sessionType, paramChattingModel.sessionId, paramChattingModel.msgId, new RetractionListener(paramChattingModel, paramContext) {
              public void onMsgRetractedTimeout() {
                AppInfo.n().post(new Runnable(this) {
                      public void run() {
                        CommonAlertDialog.a(this.a.b, null, null, this.a.b.getResources().getString(2131758689), this.a.b.getResources().getString(2131758968), new DialogInterface.OnClickListener(this) {
                              public void onClick(DialogInterface param3DialogInterface, int param3Int) {}
                            },  null, true);
                      }
                    });
              }
              
              public void onRetractFailed() {}
              
              public void onRetractSuccess() {
                if (this.a.sessionType == 3 && !this.a.isFromSelf())
                  ChatManager.getInstance().updateMsgState(this.a, (short)10); 
              }
            });
        return;
      } 
      CommonAlertDialog.a(paramContext, null, null, paramContext.getResources().getString(2131758689), paramContext.getResources().getString(2131758968), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
          },  null, true);
      return;
    } 
    CommonAlertDialog.a(paramContext, null, null, paramContext.getResources().getString(2131758627), paramContext.getResources().getString(2131758968), new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
        },  null, true);
  }
  
  public static void a(Context paramContext, ChattingModel paramChattingModel, List<ChattingModel> paramList, IMsgChatAdapterCallback paramIMsgChatAdapterCallback, IMsgChatAdapterOperationCallback paramIMsgChatAdapterOperationCallback) {
    byte b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramChattingModel.fromId);
    stringBuilder.append("");
    String str = stringBuilder.toString();
    if (paramIMsgChatAdapterCallback.c()) {
      b = 7;
    } else {
      b = 6;
    } 
    MsgCommonUtils.a(paramContext, paramList, paramChattingModel, str, b, 1, (IRequestHost)paramIMsgChatAdapterOperationCallback.w_());
  }
  
  public static void a(View paramView1, TextView paramTextView, View paramView2, ChattingModel paramChattingModel, Set<Long> paramSet, IMsgChatAdapterOperationCallback paramIMsgChatAdapterOperationCallback, IRequestHost paramIRequestHost) {
    EventTrackMessage.d(MessageProtos.Event.MSG_VOICE_TRANSFER_WORD_CLICK, String.valueOf(paramChattingModel.fromId));
    if (BluedPreferences.eF()) {
      BluedPreferences.eG();
      CommonAlertDialog.a(paramView1.getContext(), AppUtils.a(2131759091), AppUtils.a(2131759090), AppUtils.a(2131757852), null, new DialogInterface.OnDismissListener(paramView1, paramTextView, paramView2, paramChattingModel, paramSet, paramIMsgChatAdapterOperationCallback, paramIRequestHost) {
            public void onDismiss(DialogInterface param1DialogInterface) {
              MessageChatMethod.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
            }
          }0);
      return;
    } 
    b(paramView1, paramTextView, paramView2, paramChattingModel, paramSet, paramIMsgChatAdapterOperationCallback, paramIRequestHost);
  }
  
  public static void a(View paramView, IMsgChatAdapterOperationCallback paramIMsgChatAdapterOperationCallback, ChattingModel paramChattingModel) {
    paramView.setVisibility(8);
    f(paramChattingModel, paramIMsgChatAdapterOperationCallback);
  }
  
  public static void a(ChattingModel paramChattingModel, IMsgChatAdapterOperationCallback paramIMsgChatAdapterOperationCallback) {
    if (TextUtils.isEmpty(paramChattingModel.msgTextTranslateContent)) {
      a(paramChattingModel.msgContent, paramChattingModel, paramIMsgChatAdapterOperationCallback);
      return;
    } 
    if (paramChattingModel.msgTextTranslateIsShow == 1) {
      f(paramChattingModel, paramIMsgChatAdapterOperationCallback);
      return;
    } 
    e(paramChattingModel, paramIMsgChatAdapterOperationCallback);
  }
  
  private static void a(String paramString, ChattingModel paramChattingModel, IMsgChatAdapterOperationCallback paramIMsgChatAdapterOperationCallback) {
    if (!TextUtils.isEmpty(paramString)) {
      String str;
      if (paramChattingModel == null)
        return; 
      try {
        paramString = URLDecoder.decode(paramString.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
      } catch (Exception exception) {
        exception.printStackTrace();
        str = "";
      } 
      c(paramChattingModel, paramIMsgChatAdapterOperationCallback);
      ChatHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<MsgContentTranslatedEntity>>(paramChattingModel, paramIMsgChatAdapterOperationCallback) {
            boolean a;
            
            protected void a(BluedEntityA<MsgContentTranslatedEntity> param1BluedEntityA) {
              if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
                MsgContentTranslatedEntity msgContentTranslatedEntity = param1BluedEntityA.data.get(0);
                if (msgContentTranslatedEntity != null && msgContentTranslatedEntity.trans_result != null && msgContentTranslatedEntity.trans_result.size() > 0) {
                  String str = ((MsgContentTranslatedEntity.TranslateResult)msgContentTranslatedEntity.trans_result.get(0)).dst;
                  if (!TextUtils.isEmpty(str))
                    MessageChatMethod.a(this.b, str, this.c); 
                } 
              } 
            }
            
            public boolean onUIFailure(int param1Int, String param1String) {
              this.a = true;
              return super.onUIFailure(param1Int, param1String);
            }
            
            public void onUIFinish() {
              super.onUIFinish();
              if (this.a) {
                this.a = false;
                MessageChatMethod.b(this.b, this.c);
              } 
            }
          }str, (IRequestHost)paramIMsgChatAdapterOperationCallback.w_());
    } 
  }
  
  public static void a(boolean paramBoolean, short paramShort, int paramInt, TextView paramTextView, String paramString) {
    if (paramShort == 3 && paramInt == 10) {
      paramTextView.setText(String.format(paramTextView.getContext().getString(2131756628), new Object[] { paramString }));
      return;
    } 
    if (paramBoolean) {
      paramTextView.setText(paramTextView.getContext().getResources().getString(2131758069));
      return;
    } 
    paramTextView.setText(String.format(paramTextView.getContext().getResources().getString(2131758068), new Object[] { paramString }));
  }
  
  public static boolean a(ChattingModel paramChattingModel, IMsgChatAdapterCallback paramIMsgChatAdapterCallback) {
    boolean bool1 = paramChattingModel.isFromSelf();
    boolean bool = false;
    if (bool1) {
      if (paramChattingModel.msgLocalId == 0L) {
        if ((System.currentTimeMillis() - paramChattingModel.msgTimestamp) / 60000L < 2L)
          bool = true; 
        return bool;
      } 
    } else if (paramIMsgChatAdapterCallback != null && paramIMsgChatAdapterCallback.c() && paramChattingModel.fromId != paramIMsgChatAdapterCallback.a() && (paramIMsgChatAdapterCallback.b() == 1 || paramIMsgChatAdapterCallback.b() == 2)) {
      return true;
    } 
    return false;
  }
  
  public static void b(View paramView1, TextView paramTextView, View paramView2, ChattingModel paramChattingModel, Set<Long> paramSet, IMsgChatAdapterOperationCallback paramIMsgChatAdapterOperationCallback, IRequestHost paramIRequestHost) {
    if (!TextUtils.isEmpty(paramChattingModel.msgTextTranslateContent)) {
      paramView1.setVisibility(0);
      paramTextView.setText(paramChattingModel.msgTextTranslateContent);
      paramSet.add(Long.valueOf(paramChattingModel.msgId));
      e(paramChattingModel, paramIMsgChatAdapterOperationCallback);
      return;
    } 
    if (paramChattingModel.msgStateCode == 6 || !NetworkUtils.b()) {
      AppMethods.d(2131759087);
      return;
    } 
    c(paramChattingModel, null);
    ChatHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<VoiceTurnText>>(paramIRequestHost, paramView2, paramView1, paramTextView, paramSet, paramChattingModel, paramIMsgChatAdapterOperationCallback) {
          protected void a(BluedEntityA<MessageChatMethod.VoiceTurnText> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              String str = ((MessageChatMethod.VoiceTurnText)param1BluedEntityA.getSingleData()).text;
              if (!TextUtils.isEmpty(str)) {
                this.b.setVisibility(0);
                this.c.setText(str);
                this.d.add(Long.valueOf(this.e.msgId));
                MessageChatMethod.a(this.e, str, this.f);
                if (IMV4Method.a(this.e.fromId) == 1 && this.e.msgStateCode != 5) {
                  ChatManager.getInstance().updateMsgState(this.e, (short)5);
                  return;
                } 
              } else {
                AppMethods.d(2131759088);
              } 
            } 
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            this.a.setVisibility(4);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.setVisibility(0);
          }
        }IMV4Method.a(paramChattingModel), paramIRequestHost);
  }
  
  private static void b(ChattingModel paramChattingModel, String paramString, IMsgChatAdapterOperationCallback paramIMsgChatAdapterOperationCallback) {
    paramChattingModel.msgTextTranslateStatus = 2;
    paramChattingModel.msgTextTranslateIsShow = 1;
    paramChattingModel.msgTextTranslateContent = paramString;
    g(paramChattingModel, paramIMsgChatAdapterOperationCallback);
  }
  
  public static boolean b(ChattingModel paramChattingModel, IMsgChatAdapterCallback paramIMsgChatAdapterCallback) {
    return false;
  }
  
  private static void c(ChattingModel paramChattingModel, IMsgChatAdapterOperationCallback paramIMsgChatAdapterOperationCallback) {
    paramChattingModel.msgTextTranslateStatus = 1;
    paramChattingModel.msgTextTranslateIsShow = 0;
    g(paramChattingModel, paramIMsgChatAdapterOperationCallback);
  }
  
  private static void d(ChattingModel paramChattingModel, IMsgChatAdapterOperationCallback paramIMsgChatAdapterOperationCallback) {
    paramChattingModel.msgTextTranslateStatus = 0;
    paramChattingModel.msgTextTranslateIsShow = 0;
    g(paramChattingModel, paramIMsgChatAdapterOperationCallback);
  }
  
  private static void e(ChattingModel paramChattingModel, IMsgChatAdapterOperationCallback paramIMsgChatAdapterOperationCallback) {
    paramChattingModel.msgTextTranslateIsShow = 1;
    g(paramChattingModel, paramIMsgChatAdapterOperationCallback);
  }
  
  private static void f(ChattingModel paramChattingModel, IMsgChatAdapterOperationCallback paramIMsgChatAdapterOperationCallback) {
    paramChattingModel.msgTextTranslateIsShow = 0;
    g(paramChattingModel, paramIMsgChatAdapterOperationCallback);
  }
  
  private static void g(ChattingModel paramChattingModel, IMsgChatAdapterOperationCallback paramIMsgChatAdapterOperationCallback) {
    ChatManager.getInstance().updateMsgOneData(paramChattingModel);
    if (paramIMsgChatAdapterOperationCallback != null)
      paramIMsgChatAdapterOperationCallback.J(); 
  }
  
  static class VoiceTurnText {
    public String text;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\manager\MessageChatMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */