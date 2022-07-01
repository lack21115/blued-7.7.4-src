package com.soft.blued.ui.msg.controller.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.listener.MsgPreProcesser;
import com.blued.android.chat.listener.MsgPreProcesserListener;
import com.blued.android.chat.listener.SingleSessionListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.model.VideoChatMsgContentModel;
import com.blued.android.chat.utils.AtRegExpUtils;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.push.NotificationModel;
import com.blued.android.framework.push.NotificationSender;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.upload.qiniu.MediaSender;
import com.blued.android.framework.utils.upload.qiniu.SenderListener;
import com.blued.android.framework.utils.upload.qiniu.UploadModel;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.live_china.liveForMsg.model.LiveMsgShareEntity;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.share.Util;
import com.blued.das.message.MessageProtos;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.BluedConstant;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.constant.ChatConstants;
import com.soft.blued.db.model.MsgExtra;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.fragment.PendingFragment;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.model.UrlPicResult;
import com.soft.blued.ui.circle.model.CircleAddPoints;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.group.model.ExtraGroupInvitationModel;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.live.view.VideoChatHintToast;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.msg.DialogSkipFragment;
import com.soft.blued.ui.msg.MsgChattingFragment;
import com.soft.blued.ui.msg.MsgFragment;
import com.soft.blued.ui.msg.ShareToFragment;
import com.soft.blued.ui.msg.manager.MsgBoxManager;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.ui.msg.model.ChatBundleExtra;
import com.soft.blued.ui.msg.model.MsgAudioExtra;
import com.soft.blued.ui.msg.model.MsgChattingImageModel;
import com.soft.blued.ui.msg.model.MsgChattingVideoModel;
import com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity;
import com.soft.blued.ui.msg.model.MsgExtraGift;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.msg.model.SysCommandModel;
import com.soft.blued.ui.msg_group.model.GroupMemberModel;
import com.soft.blued.ui.msg_group.model.GroupNotificationExtra;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.notify.fragment.MsgAttentionNotifyFragment;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.welcome.FirstActivity;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.ImageUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.VideoCacheUtils;
import com.soft.blued.utils.third.QiniuUploadUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class ChatHelperV4 {
  private static final String a = ChatHelperV4.class.getSimpleName();
  
  private static ChatHelperV4 d;
  
  private static LinkedBlockingQueue<Pair<ChattingModel, MsgPreProcesserListener>> g = new LinkedBlockingQueue<Pair<ChattingModel, MsgPreProcesserListener>>();
  
  private static AtomicLong j = new AtomicLong(0L);
  
  private Gson b = AppInfo.f();
  
  private NotificationSender c = NotificationSender.a();
  
  private boolean e = false;
  
  private String f;
  
  private int h = 0;
  
  private volatile boolean i;
  
  private LiveMsgShareEntity a(String paramString) {
    Logger.b(a, new Object[] { "直播通知 notification：extraJson==", paramString });
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      return (LiveMsgShareEntity)AppInfo.f().fromJson(paramString, LiveMsgShareEntity.class);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static ChatHelperV4 a() {
    // Byte code:
    //   0: getstatic com/soft/blued/ui/msg/controller/tools/ChatHelperV4.d : Lcom/soft/blued/ui/msg/controller/tools/ChatHelperV4;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/ui/msg/controller/tools/ChatHelperV4
    //   8: monitorenter
    //   9: getstatic com/soft/blued/ui/msg/controller/tools/ChatHelperV4.d : Lcom/soft/blued/ui/msg/controller/tools/ChatHelperV4;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/ui/msg/controller/tools/ChatHelperV4
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/ui/msg/controller/tools/ChatHelperV4.d : Lcom/soft/blued/ui/msg/controller/tools/ChatHelperV4;
    //   25: ldc com/soft/blued/ui/msg/controller/tools/ChatHelperV4
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/ui/msg/controller/tools/ChatHelperV4
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/ui/msg/controller/tools/ChatHelperV4.d : Lcom/soft/blued/ui/msg/controller/tools/ChatHelperV4;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(ChattingModel paramChattingModel, Pair<String, UploadModel> paramPair, MsgPreProcesserListener paramMsgPreProcesserListener, boolean paramBoolean) {
    if (paramPair != null) {
      String str2 = (String)paramPair.first;
      UploadModel uploadModel = (UploadModel)paramPair.second;
      String str1 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("uploadQiNiu===url:");
      stringBuilder.append(uploadModel.url);
      stringBuilder.append(",compressPath:");
      stringBuilder.append(uploadModel.compressPath);
      Logger.e(str1, new Object[] { stringBuilder.toString() });
      try {
        if (TextUtils.isEmpty(uploadModel.url)) {
          a(paramChattingModel, paramMsgPreProcesserListener);
          i();
          return;
        } 
        if (paramChattingModel.msgType == 2) {
          paramChattingModel.msgContent = uploadModel.url;
          if (paramBoolean) {
            LoadOptions loadOptions = new LoadOptions();
            loadOptions.e = true;
            loadOptions.j = true;
            Drawable drawable = RecyclingImageLoader.a(RecyclingUtils.a(RecyclingUtils.Scheme.c.b(uploadModel.compressPath), loadOptions));
            if (drawable != null && drawable instanceof IRecyclingDrawable) {
              RecyclingImageLoader.a(RecyclingUtils.a(uploadModel.url, loadOptions), (IRecyclingDrawable)drawable);
            } else {
              Logger.e(a, new Object[] { "RecyclingUtils.getMemoryCache fail" });
            } 
            RecyclingUtils.a(new File(uploadModel.compressPath), uploadModel.url);
          } 
        } else if (paramChattingModel.msgType == 24) {
          paramChattingModel.msgContent = uploadModel.url;
          if (paramBoolean) {
            str1 = "";
            try {
              String str3 = AesCrypto.e(uploadModel.url);
              str1 = str3;
              String str4 = a;
              str1 = str3;
              StringBuilder stringBuilder1 = new StringBuilder();
              str1 = str3;
              stringBuilder1.append("解密服务器返回的地址===");
              str1 = str3;
              stringBuilder1.append(str3);
              str1 = str3;
              Logger.e(str4, new Object[] { stringBuilder1.toString() });
              str1 = str3;
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
            RecyclingUtils.a(new File(uploadModel.compressPath), str1);
          } 
        } else if (paramChattingModel.msgType == 3) {
          String[] arrayOfString = paramChattingModel.msgContent.split(",,");
          if (arrayOfString.length < 2)
            return; 
          int i = StringUtils.a(arrayOfString[1], 0);
          if (i == 0)
            return; 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(uploadModel.url);
          stringBuilder1.append(",,");
          stringBuilder1.append(i);
          paramChattingModel.msgContent = stringBuilder1.toString();
          MsgCommonUtils.a(paramChattingModel, uploadModel.url, uploadModel.compressPath);
        } 
        b(paramChattingModel, paramMsgPreProcesserListener);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
        a(paramChattingModel, paramMsgPreProcesserListener);
        return;
      } 
    } 
    a(paramChattingModel, paramMsgPreProcesserListener);
  }
  
  private void a(ChattingModel paramChattingModel, MsgPreProcesserListener paramMsgPreProcesserListener, String paramString) {
    // Byte code:
    //   0: aload_3
    //   1: ldc_w 'http'
    //   4: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   7: ifeq -> 17
    //   10: aload_0
    //   11: aload_1
    //   12: aload_2
    //   13: invokevirtual b : (Lcom/blued/android/chat/model/ChattingModel;Lcom/blued/android/chat/listener/MsgPreProcesserListener;)V
    //   16: return
    //   17: aload_3
    //   18: ldc ''
    //   20: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   23: astore #6
    //   25: aload_1
    //   26: getfield msgType : S
    //   29: istore #4
    //   31: iload #4
    //   33: iconst_2
    //   34: if_icmpeq -> 115
    //   37: iload #4
    //   39: iconst_3
    //   40: if_icmpeq -> 94
    //   43: iload #4
    //   45: iconst_5
    //   46: if_icmpeq -> 64
    //   49: iload #4
    //   51: bipush #24
    //   53: if_icmpeq -> 115
    //   56: iload #4
    //   58: bipush #25
    //   60: if_icmpeq -> 64
    //   63: return
    //   64: aload_1
    //   65: invokestatic a : (Lcom/blued/android/chat/model/ChattingModel;)Ljava/lang/String;
    //   68: new androidx/core/util/Pair
    //   71: dup
    //   72: aload_3
    //   73: ldc ''
    //   75: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   78: new com/soft/blued/ui/msg/controller/tools/ChatHelperV4$9
    //   81: dup
    //   82: aload_0
    //   83: aload_1
    //   84: aload_2
    //   85: aload_3
    //   86: invokespecial <init> : (Lcom/soft/blued/ui/msg/controller/tools/ChatHelperV4;Lcom/blued/android/chat/model/ChattingModel;Lcom/blued/android/chat/listener/MsgPreProcesserListener;Ljava/lang/String;)V
    //   89: invokestatic a : (Ljava/lang/String;Landroidx/core/util/Pair;Lcom/blued/android/framework/utils/upload/qiniu/SenderListener;)Ljava/lang/String;
    //   92: pop
    //   93: return
    //   94: aload_1
    //   95: invokestatic a : (Lcom/blued/android/chat/model/ChattingModel;)Ljava/lang/String;
    //   98: aload #6
    //   100: new com/soft/blued/ui/msg/controller/tools/ChatHelperV4$10
    //   103: dup
    //   104: aload_0
    //   105: aload_1
    //   106: aload_2
    //   107: invokespecial <init> : (Lcom/soft/blued/ui/msg/controller/tools/ChatHelperV4;Lcom/blued/android/chat/model/ChattingModel;Lcom/blued/android/chat/listener/MsgPreProcesserListener;)V
    //   110: invokestatic a : (Ljava/lang/String;Ljava/util/List;Lcom/blued/android/framework/utils/upload/qiniu/SenderListener;)Ljava/lang/String;
    //   113: pop
    //   114: return
    //   115: new java/io/File
    //   118: dup
    //   119: aload_3
    //   120: invokespecial <init> : (Ljava/lang/String;)V
    //   123: invokestatic a : (Ljava/io/File;)Z
    //   126: iconst_1
    //   127: ixor
    //   128: istore #5
    //   130: aload_1
    //   131: invokestatic a : (Lcom/blued/android/chat/model/ChattingModel;)Ljava/lang/String;
    //   134: aload #6
    //   136: iload #5
    //   138: new com/soft/blued/ui/msg/controller/tools/ChatHelperV4$8
    //   141: dup
    //   142: aload_0
    //   143: aload_1
    //   144: aload_2
    //   145: iload #5
    //   147: invokespecial <init> : (Lcom/soft/blued/ui/msg/controller/tools/ChatHelperV4;Lcom/blued/android/chat/model/ChattingModel;Lcom/blued/android/chat/listener/MsgPreProcesserListener;Z)V
    //   150: invokestatic a : (Ljava/lang/String;Ljava/util/List;ZLcom/blued/android/framework/utils/upload/qiniu/SenderListener;)Ljava/lang/String;
    //   153: pop
    //   154: return
  }
  
  public static void a(List<SessionModel> paramList, boolean paramBoolean) {
    if (paramList == null)
      return; 
    Iterator<SessionModel> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      if (!a(iterator.next()))
        iterator.remove(); 
    } 
    if (paramBoolean)
      c(paramList); 
  }
  
  public static boolean a(SessionModel paramSessionModel) {
    boolean bool = false;
    if (paramSessionModel != null) {
      if (paramSessionModel.sessionType == 1)
        return false; 
      if (paramSessionModel.sessionType != 2 && paramSessionModel.sessionType != 3 && paramSessionModel.sessionType != 6668)
        return false; 
      bool = true;
    } 
    return bool;
  }
  
  public static boolean a(File paramFile) {
    boolean bool = false;
    try {
      FileInputStream fileInputStream = new FileInputStream(paramFile);
      int[] arrayOfInt = new int[5];
      arrayOfInt[0] = fileInputStream.read();
      arrayOfInt[1] = fileInputStream.read();
      arrayOfInt[2] = fileInputStream.read();
      arrayOfInt[3] = fileInputStream.read();
      fileInputStream.skip((fileInputStream.available() - 1));
      arrayOfInt[4] = fileInputStream.read();
      fileInputStream.close();
      boolean bool1 = bool;
      if (arrayOfInt[0] == 71) {
        bool1 = bool;
        if (arrayOfInt[1] == 73) {
          bool1 = bool;
          if (arrayOfInt[2] == 70) {
            bool1 = bool;
            if (arrayOfInt[3] == 56) {
              int i = arrayOfInt[4];
              bool1 = bool;
              if (i == 59)
                bool1 = true; 
            } 
          } 
        } 
      } 
      return bool1;
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
      return false;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return false;
    } catch (Exception exception) {
      exception.printStackTrace();
      return false;
    } 
  }
  
  private void b(Context paramContext, ChattingModel paramChattingModel) {
    if (paramChattingModel != null) {
      Bundle bundle;
      if (CommonTools.a(paramContext))
        return; 
      if (!j())
        return; 
      NotificationModel notificationModel = new NotificationModel();
      if (BluedPreferences.ae()) {
        if (1 == paramChattingModel.msgType || 8 == paramChattingModel.msgType) {
          if (StringUtils.e(paramChattingModel.msgContent)) {
            notificationModel.setContentText(paramContext.getResources().getString(2131755504));
          } else {
            notificationModel.setContentText(StringUtils.a(paramChattingModel.msgContent, false, true, true, ""));
          } 
        } else if (4 == paramChattingModel.msgType) {
          notificationModel.setContentText(paramContext.getResources().getString(2131755500));
        } else if (2 == paramChattingModel.msgType || 24 == paramChattingModel.msgType) {
          notificationModel.setContentText(paramContext.getResources().getString(2131755499));
        } else if (5 == paramChattingModel.msgType || 25 == paramChattingModel.msgType) {
          notificationModel.setContentText(paramContext.getResources().getString(2131755502));
        } else if (3 == paramChattingModel.msgType) {
          notificationModel.setContentText(paramContext.getResources().getString(2131755501));
        } else if (32 == paramChattingModel.msgType) {
          notificationModel.setContentText(paramContext.getResources().getString(2131757184));
        } else if (6 == paramChattingModel.msgType || 205 == paramChattingModel.msgType) {
          notificationModel.setContentText(paramContext.getString(2131758001));
        } else {
          notificationModel.setContentText(paramContext.getResources().getString(2131755504));
        } 
      } else {
        notificationModel.setContentText(paramContext.getResources().getString(2131755504));
      } 
      if (paramChattingModel.sessionType == 1 && paramChattingModel.sessionId == 2L) {
        SessionModel sessionModel = ChatManager.getInstance().getSnapSessionModel((short)3, paramChattingModel.fromId);
        if (sessionModel != null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramContext.getString(2131756750));
          stringBuilder.append(sessionModel.nickName);
          notificationModel.setContentTitle(stringBuilder.toString());
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramContext.getString(2131756750));
          stringBuilder.append("");
          notificationModel.setContentTitle(stringBuilder.toString());
        } 
      } else {
        SessionModel sessionModel = ChatManager.getInstance().getSnapSessionModel(paramChattingModel.sessionType, paramChattingModel.sessionId);
        if (sessionModel != null && sessionModel.sessionType == 3) {
          notificationModel.setContentTitle(sessionModel.nickName);
          String str = notificationModel.getContentText().toString();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramChattingModel.fromNickName);
          stringBuilder.append(": ");
          stringBuilder.append(str);
          notificationModel.setContentText(stringBuilder.toString());
        } else {
          notificationModel.setContentTitle(paramChattingModel.fromNickName);
        } 
      } 
      notificationModel.setId(h());
      notificationModel.setTickerText(paramContext.getResources().getString(2131755503));
      notificationModel.setIconResId(2131231104);
      notificationModel.setBitmapDef(BitmapFactory.decodeResource(AppInfo.d().getResources(), 2131231104));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("android.resource://");
      stringBuilder1.append(AppInfo.d().getPackageName());
      stringBuilder1.append("/");
      stringBuilder1.append(2131689476);
      notificationModel.setSoundFileUri(Uri.parse(stringBuilder1.toString()));
      notificationModel.setShakeEnable(BluedPreferences.ad());
      notificationModel.setVoiceEnable(BluedPreferences.ac());
      notificationModel.setInnerVoiceEnable(BluedPreferences.aa());
      UserRelationshipUtils.a(Short.valueOf(paramChattingModel.sessionType), paramChattingModel.sessionId);
      StringBuilder stringBuilder2 = null;
      stringBuilder1 = stringBuilder2;
      if (paramChattingModel.sessionType == 1) {
        stringBuilder1 = stringBuilder2;
        if (paramChattingModel.sessionId == 2L) {
          bundle = new Bundle();
          bundle.putString("arg_open_homeactivity_ope", "ope_group_notification");
        } 
      } 
      notificationModel.setIntent(HomeArgumentHelper.b(paramContext, "msg", bundle));
      this.c.a(notificationModel);
    } 
  }
  
  public static void b(List<SessionModel> paramList) {
    if (paramList == null)
      return; 
    Iterator<SessionModel> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      SessionModel sessionModel = iterator.next();
      if (sessionModel.sessionType != 2 && sessionModel.sessionType != 3)
        iterator.remove(); 
    } 
    c(paramList);
  }
  
  public static List<SessionModel> c(List<SessionModel> paramList) {
    if (paramList != null && paramList.size() > 0)
      Collections.sort(paramList, new SessionModelComparator()); 
    return paramList;
  }
  
  private void c(Context paramContext, ChattingModel paramChattingModel) {
    if (paramChattingModel != null) {
      if (CommonTools.a(paramContext))
        return; 
      if (!j())
        return; 
      LiveMsgShareEntity liveMsgShareEntity = a(paramChattingModel.getMsgExtra());
      if (liveMsgShareEntity == null)
        return; 
      Bundle bundle = b(liveMsgShareEntity);
      if (bundle == null)
        return; 
      Intent intent = HomeArgumentHelper.b(paramContext, "live", bundle);
      NotificationModel notificationModel = new NotificationModel();
      notificationModel.setId(h());
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(liveMsgShareEntity.name);
      stringBuilder2.append(" ");
      stringBuilder2.append(paramContext.getResources().getString(2131757143));
      notificationModel.setContentText(stringBuilder2.toString());
      notificationModel.setContentTitle(paramContext.getResources().getString(2131755304));
      notificationModel.setTickerText(paramContext.getResources().getString(2131755503));
      if (Build.VERSION.SDK_INT < 21) {
        notificationModel.setIconResId(2131231104);
      } else {
        notificationModel.setIconResId(2131232545);
      } 
      notificationModel.setBitmapDef(BitmapFactory.decodeResource(AppInfo.d().getResources(), 2131231104));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("android.resource://");
      stringBuilder1.append(AppInfo.d().getPackageName());
      stringBuilder1.append("/");
      stringBuilder1.append(2131689476);
      notificationModel.setSoundFileUri(Uri.parse(stringBuilder1.toString()));
      notificationModel.setShakeEnable(BluedPreferences.ad());
      notificationModel.setVoiceEnable(BluedPreferences.ac());
      notificationModel.setInnerVoiceEnable(BluedPreferences.aa());
      notificationModel.setIntent(intent);
      this.c.a(notificationModel);
    } 
  }
  
  private void d(Context paramContext, ChattingModel paramChattingModel) {
    byte b;
    String str1;
    Object object;
    try {
      object = AppInfo.f().fromJson(paramChattingModel.msgContent, (new TypeToken<VideoChatMsgContentModel>(this) {
          
          }).getType());
    } catch (Exception exception) {
      exception.printStackTrace();
      object = null;
    } 
    if (object == null)
      return; 
    NotificationModel notificationModel = new NotificationModel();
    String str2 = paramChattingModel.fromNickName;
    if (52 == paramChattingModel.msgType) {
      if (object != null) {
        b = ((VideoChatMsgContentModel)object).room_type;
      } else {
        b = 0;
      } 
      if (b == 1) {
        str1 = paramContext.getResources().getString(2131755721);
      } else {
        str1 = paramContext.getResources().getString(2131755722);
      } 
    } else {
      str1 = "";
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str2);
    stringBuilder2.append(" ");
    stringBuilder2.append(str1);
    String str3 = stringBuilder2.toString();
    notificationModel.setRemindEnable(this.e ^ true);
    notificationModel.setContentTitle(str2);
    notificationModel.setContentText(str1);
    notificationModel.setTickerText(str3);
    notificationModel.setId(100);
    if (Build.VERSION.SDK_INT < 21) {
      notificationModel.setIconResId(2131231104);
    } else {
      notificationModel.setIconResId(2131232545);
    } 
    notificationModel.setBitmapDef(BitmapFactory.decodeResource(AppInfo.d().getResources(), 2131231104));
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("android.resource://");
    stringBuilder1.append(AppInfo.d().getPackageName());
    stringBuilder1.append("/");
    stringBuilder1.append(2131689476);
    notificationModel.setSoundFileUri(Uri.parse(stringBuilder1.toString()));
    notificationModel.setShakeEnable(BluedPreferences.ad());
    notificationModel.setVoiceEnable(BluedPreferences.ac());
    notificationModel.setInnerVoiceEnable(BluedPreferences.aa());
    Bundle bundle = new Bundle();
    ChannelModel channelModel = new ChannelModel();
    if (((VideoChatMsgContentModel)object).room_type == 1) {
      b = 3;
    } else {
      b = 2;
    } 
    channelModel.callType = b;
    channelModel.channelId = ((VideoChatMsgContentModel)object).room_id;
    channelModel.remoteUid = (int)paramChattingModel.fromId;
    channelModel.has_screenshot = ((VideoChatMsgContentModel)object).has_screenshot;
    if (paramChattingModel.msgMapExtra != null)
      channelModel.chat_sdk_type = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "chat_sdk_type"); 
    bundle.putSerializable("CHANNEL", (Serializable)channelModel);
    bundle.putInt("action", 1);
    bundle.putBoolean("arg_bool_backtomain", true);
    notificationModel.setIntent(TransparentActivity.a(paramContext, PendingFragment.class, bundle).a());
    this.c.a(notificationModel);
    Activity activity = BluedApplicationLike.getForeActivity();
    if (activity != null)
      VideoChatHintToast.a((Context)activity, paramChattingModel.fromAvatar, paramChattingModel.fromVBadge, str3, new VideoChatHintToast.onHintClickLisnter(this, activity, channelModel) {
            public void a() {
              DialogSkipFragment.a((Context)this.a, this.b);
            }
          }); 
  }
  
  private void e(Context paramContext, ChattingModel paramChattingModel) {
    if (paramChattingModel == null)
      return; 
    if (paramChattingModel.msgMapExtra == null)
      return; 
    if (CommonTools.a(paramContext))
      return; 
    if (!j())
      return; 
    NotificationModel notificationModel = new NotificationModel();
    MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "version");
    String str3 = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "title");
    String str2 = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "link");
    String str4 = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "content");
    String str1 = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "image");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str3);
    stringBuilder2.append(" ");
    stringBuilder2.append(str4);
    String str5 = stringBuilder2.toString();
    notificationModel.setId(h());
    notificationModel.setRemindEnable(this.e ^ true);
    notificationModel.setContentTitle(str3);
    notificationModel.setContentText(str4);
    notificationModel.setTickerText(str5);
    if (Build.VERSION.SDK_INT < 21) {
      notificationModel.setIconResId(2131231104);
    } else {
      notificationModel.setIconResId(2131232545);
    } 
    notificationModel.setBitmapDef(BitmapFactory.decodeResource(AppInfo.d().getResources(), 2131231104));
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("android.resource://");
    stringBuilder1.append(AppInfo.d().getPackageName());
    stringBuilder1.append("/");
    stringBuilder1.append(2131689476);
    notificationModel.setSoundFileUri(Uri.parse(stringBuilder1.toString()));
    notificationModel.setShakeEnable(BluedPreferences.ad());
    notificationModel.setVoiceEnable(BluedPreferences.ac());
    notificationModel.setInnerVoiceEnable(BluedPreferences.aa());
    Intent intent = new Intent(paramContext, FirstActivity.class);
    intent.setAction("android.intent.action.VIEW");
    intent.putExtra("extra_bool_open_welcome_page", false);
    if (!TextUtils.isEmpty(str2))
      intent.setData(Uri.parse(str2)); 
    notificationModel.setIntent(intent);
    this.c.a(notificationModel);
    if (!TextUtils.isEmpty(str1))
      ImageFileLoader.a(null).a(str1).a(new ImageFileLoader.OnLoadFileListener(this, notificationModel) {
            public void onUIFinish(File param1File, Exception param1Exception) {
              if (param1File != null && param1File.exists())
                try {
                  Bitmap bitmap = Util.imageZoomToSize(BitmapFactory.decodeFile(param1File.getPath()), 30);
                  this.a.setBitmap(bitmap);
                  this.a.setRemindEnable(false);
                  ChatHelperV4.d(this.b).a(this.a);
                  Logger.b("xpf", new Object[] { "notifyMsg bitmap" });
                  return;
                } catch (Exception|OutOfMemoryError exception) {
                  return;
                }  
            }
          }).a(); 
  }
  
  private void f(Context paramContext, ChattingModel paramChattingModel) {
    if (paramChattingModel != null) {
      StringBuilder stringBuilder1;
      if (CommonTools.a(paramContext))
        return; 
      if (!j())
        return; 
      NotificationModel notificationModel = new NotificationModel();
      Bundle bundle = new Bundle();
      bundle.putString("from_tag_page", "from_notification_attention");
      Intent intent = HomeArgumentHelper.b(paramContext, "msg", bundle);
      if (!TextUtils.isEmpty(paramChattingModel.msgContent)) {
        if (paramChattingModel.sessionId == 3L && paramChattingModel.msgType == 19) {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(paramChattingModel.fromNickName);
          stringBuilder2.append(paramContext.getResources().getString(2131758527));
          notificationModel.setContentText(stringBuilder2.toString());
          bundle.putString("from_tag_page", "from_notification_feed");
          bundle.putString("to_message_tab", "0");
          Intent intent1 = HomeArgumentHelper.b(paramContext, "msg", bundle);
        } else {
          stringBuilder1 = stringBuilder2;
          if (paramChattingModel.sessionId == 5L) {
            stringBuilder1 = stringBuilder2;
            if (paramChattingModel.msgType == 1) {
              notificationModel.setContentText(paramChattingModel.msgContent);
              stringBuilder1 = stringBuilder2;
            } 
          } 
        } 
      } else {
        notificationModel.setContentText(paramContext.getResources().getString(2131755504));
        stringBuilder1 = stringBuilder2;
      } 
      notificationModel.setId(h());
      if (Build.VERSION.SDK_INT < 21) {
        notificationModel.setIconResId(2131231104);
      } else {
        notificationModel.setIconResId(2131232545);
      } 
      notificationModel.setBitmapDef(BitmapFactory.decodeResource(AppInfo.d().getResources(), 2131231104));
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("android.resource://");
      stringBuilder2.append(AppInfo.d().getPackageName());
      stringBuilder2.append("/");
      stringBuilder2.append(2131689476);
      notificationModel.setSoundFileUri(Uri.parse(stringBuilder2.toString()));
      notificationModel.setShakeEnable(BluedPreferences.ad());
      notificationModel.setVoiceEnable(BluedPreferences.ac());
      notificationModel.setInnerVoiceEnable(BluedPreferences.aa());
      notificationModel.setContentTitle(paramChattingModel.fromNickName);
      notificationModel.setTickerText(paramContext.getResources().getString(2131755503));
      notificationModel.setIntent((Intent)stringBuilder1);
      this.c.a(notificationModel);
    } 
  }
  
  private int h() {
    int i = this.h;
    this.h = i + 1;
    return i % 10;
  }
  
  private void i() {
    String str1;
    StringBuilder stringBuilder1;
    if (g.size() == 0) {
      this.i = false;
      this.f = null;
      return;
    } 
    Pair pair = g.poll();
    if (pair == null) {
      i();
      return;
    } 
    ChattingModel chattingModel = (ChattingModel)pair.first;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(chattingModel.fromId);
    stringBuilder2.append("");
    if (!AppUtils.c(stringBuilder2.toString())) {
      str1 = a;
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("checkAndUpload===串号，列表还剩：");
      stringBuilder1.append(g.size());
      Logger.e(str1, new Object[] { stringBuilder1.toString() });
      if (!StringUtils.a(this.f))
        MediaSender.a(this.f); 
      g.clear();
      this.i = false;
      this.f = null;
      return;
    } 
    this.i = true;
    MsgPreProcesserListener msgPreProcesserListener = (MsgPreProcesserListener)((Pair)stringBuilder1).second;
    String str2 = a((ChattingModel)str1);
    if (str2.startsWith("http")) {
      b((ChattingModel)str1, msgPreProcesserListener);
      i();
      return;
    } 
    int i = a(new File(str2)) ^ true;
    List list = QiniuUploadUtils.a(str2, "");
    this.f = MediaSender.a(ChatHttpUtils.a((ChattingModel)str1), list, i, new SenderListener(this, (ChattingModel)str1, msgPreProcesserListener, i) {
          public void a(String param1String, int param1Int) {}
          
          public void a(String param1String, Pair<String, UploadModel> param1Pair) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.fromId);
            stringBuilder.append("");
            if (AppUtils.c(stringBuilder.toString())) {
              if (!ChatHelperV4.a(this.d))
                return; 
              ThreadManager.a().a(new Runnable(this, param1Pair) {
                    public void run() {
                      ChatHelperV4.a(this.b.d, this.b.a, this.a, this.b.b, this.b.c);
                    }
                  });
            } 
          }
          
          public void a(String param1String, boolean param1Boolean, List<Pair<String, String>> param1List) {
            ChatHelperV4.b(this.d);
          }
        });
  }
  
  private boolean j() {
    try {
      if (j.get() != 0L && (System.currentTimeMillis() - j.get()) / 1000L < 3L && (System.currentTimeMillis() - j.get()) / 1000L >= 0L) {
        j.set(System.currentTimeMillis());
        return false;
      } 
      j.set(System.currentTimeMillis());
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return true;
  }
  
  public Bundle a(LiveMsgShareEntity paramLiveMsgShareEntity) {
    LiveMsgShareEntity liveMsgShareEntity = null;
    if (paramLiveMsgShareEntity == null)
      return null; 
    int i = paramLiveMsgShareEntity.redirect;
    Bundle bundle = new Bundle();
    if (i == 6) {
      bundle.putString("arg_open_homeactivity_ope", "ope_liveplay");
      bundle.putSerializable("live_anchor_model", (Serializable)new LiveRoomData(StringUtils.a(paramLiveMsgShareEntity.lid, 0L), 0, "push", paramLiveMsgShareEntity.uid, paramLiveMsgShareEntity.name, paramLiveMsgShareEntity.avatar, paramLiveMsgShareEntity.vbadge));
    } else if (i == 1) {
      bundle.putString("from_tag_page", "from_notification_attention");
      bundle.putString("arg_open_homeactivity_ope", "ope_notifications");
      bundle.putLong("passby_session_id", 5L);
      bundle.putShort("passby_session_type", (short)1);
      InstantLog.d("msg_push", "followed");
      EventTrackMessage.b(MessageProtos.Event.MSG_PUSH, "followed");
    } else if (i == 2) {
      bundle.putString("arg_open_homeactivity_ope", "ope_visitors");
      InstantLog.d("msg_push", "visitors");
      EventTrackMessage.b(MessageProtos.Event.MSG_PUSH, "visitors");
    } else if (i == 3) {
      bundle.putString("from_tag_page", "from_notification_feed");
    } else {
      paramLiveMsgShareEntity = liveMsgShareEntity;
      if (i != 4) {
        if (i == 5)
          return null; 
      } else {
        return (Bundle)paramLiveMsgShareEntity;
      } 
    } 
    return bundle;
  }
  
  public SessionProfileModel a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    SessionProfileModel sessionProfileModel = new SessionProfileModel();
    sessionProfileModel.nickname = paramString1;
    sessionProfileModel.avatar = paramString2;
    sessionProfileModel.vBadge = paramInt1;
    sessionProfileModel.vipGrade = paramInt2;
    sessionProfileModel.vipAnnual = paramInt3;
    sessionProfileModel.vipExpLvl = paramInt4;
    sessionProfileModel.hideVipLook = paramInt5;
    return sessionProfileModel;
  }
  
  public String a(int paramInt1, int paramInt2) {
    return a((MsgSourceEntity)null, paramInt1, paramInt2);
  }
  
  public String a(ChattingModel paramChattingModel) {
    String str1;
    short s = paramChattingModel.msgType;
    if (s != 2) {
      if (s != 3) {
        if (s != 24) {
          str1 = "";
        } else {
          String str;
          if (StringUtils.e(((ChattingModel)str1).msgContent))
            return ""; 
          try {
            str = AesCrypto.e(((ChattingModel)str1).msgContent);
          } catch (Exception exception) {
            exception.printStackTrace();
            str = "";
          } 
          if (StringUtils.e(str))
            return ((ChattingModel)str1).msgContent; 
          if (!StringUtils.e(str) && !str.contains("http"))
            return ((ChattingModel)str1).msgContent; 
          str1 = str;
        } 
      } else {
        str1 = IMV4Method.a((ChattingModel)str1);
      } 
    } else {
      str1 = ((ChattingModel)str1).msgContent;
    } 
    String str2 = str1;
    if (StringUtils.e(str1))
      str2 = ""; 
    return str2;
  }
  
  public String a(MsgSourceEntity paramMsgSourceEntity) {
    if (paramMsgSourceEntity != null) {
      MsgExtraForTextTypeEntity msgExtraForTextTypeEntity = new MsgExtraForTextTypeEntity();
      msgExtraForTextTypeEntity.msgSource = paramMsgSourceEntity;
      return this.b.toJson(msgExtraForTextTypeEntity);
    } 
    return null;
  }
  
  public String a(MsgSourceEntity paramMsgSourceEntity, int paramInt1, int paramInt2) {
    MsgChattingImageModel msgChattingImageModel = new MsgChattingImageModel();
    msgChattingImageModel.setPicWidth(paramInt1);
    msgChattingImageModel.setPicHeight(paramInt2);
    if (paramMsgSourceEntity != null)
      msgChattingImageModel.setMsgSource(paramMsgSourceEntity); 
    return this.b.toJson(msgChattingImageModel);
  }
  
  public String a(List<GroupMemberModel> paramList) {
    if (paramList == null || paramList.size() == 0)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < paramList.size(); i++) {
      stringBuffer.append(((GroupMemberModel)paramList.get(i)).uid);
      if (i != paramList.size() - 1)
        stringBuffer.append(","); 
    } 
    return stringBuffer.toString();
  }
  
  public void a(long paramLong) {
    ChatManager.getInstance().deleteSessionAndChatting(Short.valueOf((short)1), paramLong);
  }
  
  public void a(Context paramContext, long paramLong1, long paramLong2) {
    Bundle bundle = new Bundle();
    bundle.putLong("passby_session_id", paramLong1);
    bundle.putShort("passby_session_type", (short)1);
    bundle.putLong("passby_maxHasReadMsgID", paramLong2);
    TerminalActivity.d(paramContext, MsgAttentionNotifyFragment.class, bundle);
  }
  
  public void a(Context paramContext, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, boolean paramBoolean, int paramInt5, int paramInt6, LogData paramLogData, MsgSourceEntity paramMsgSourceEntity) {
    a(paramContext, paramLong, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramString3, paramBoolean, paramInt5, paramInt6, paramLogData, paramMsgSourceEntity, -1L, -1L);
  }
  
  public void a(Context paramContext, long paramLong1, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, boolean paramBoolean, int paramInt5, int paramInt6, LogData paramLogData, MsgSourceEntity paramMsgSourceEntity, long paramLong2, long paramLong3) {
    Bundle bundle = new Bundle();
    bundle.putLong("passby_session_id", paramLong1);
    bundle.putString("passby_nick_name", paramString1);
    bundle.putString("passby_avatar", paramString2);
    bundle.putInt("passby_vbadge", paramInt1);
    bundle.putInt("passby_vip_grade", paramInt2);
    bundle.putInt("passby_is_vip_annual", paramInt3);
    bundle.putInt("passby_vip_exp_lvl", paramInt4);
    bundle.putString("passby_last_msg_distance", paramString3);
    bundle.putBoolean("passby_session_secret", paramBoolean);
    bundle.putSerializable("PASSBY_LOG_DATA", (Serializable)paramLogData);
    bundle.putSerializable("msg_source_model", (Serializable)paramMsgSourceEntity);
    bundle.putInt("passby_is_hide_vip_look", paramInt6);
    bundle.putLong("PASSBY_MSG_ID", paramLong2);
    bundle.putLong("PASSBY_MSG_LOCAL_ID", paramLong3);
    if (paramInt5 == 0) {
      bundle.putShort("passby_session_type", (short)2);
    } else if (paramInt5 == 1) {
      bundle.putShort("passby_session_type", (short)3);
    } else {
      return;
    } 
    TerminalActivity.d(paramContext, MsgChattingFragment.class, bundle);
  }
  
  public void a(Context paramContext, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, boolean paramBoolean, int paramInt5, int paramInt6, LogData paramLogData, MsgSourceEntity paramMsgSourceEntity, ChatBundleExtra paramChatBundleExtra) {
    Bundle bundle = new Bundle();
    bundle.putLong("passby_session_id", paramLong);
    bundle.putString("passby_nick_name", paramString1);
    bundle.putString("passby_avatar", paramString2);
    bundle.putInt("passby_vbadge", paramInt1);
    bundle.putInt("passby_vip_grade", paramInt2);
    bundle.putInt("passby_is_vip_annual", paramInt3);
    bundle.putInt("passby_vip_exp_lvl", paramInt4);
    bundle.putString("passby_last_msg_distance", paramString3);
    bundle.putBoolean("passby_session_secret", paramBoolean);
    bundle.putSerializable("PASSBY_LOG_DATA", (Serializable)paramLogData);
    bundle.putSerializable("msg_source_model", (Serializable)paramMsgSourceEntity);
    bundle.putInt("passby_is_hide_vip_look", paramInt6);
    bundle.putSerializable("EXTRA", (Serializable)paramChatBundleExtra);
    if (paramInt5 == 0) {
      bundle.putShort("passby_session_type", (short)2);
    } else if (paramInt5 == 1) {
      bundle.putShort("passby_session_type", (short)3);
    } else {
      return;
    } 
    TerminalActivity.d(paramContext, MsgChattingFragment.class, bundle);
  }
  
  public void a(Context paramContext, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, boolean paramBoolean1, int paramInt5, int paramInt6, LogData paramLogData, MsgSourceEntity paramMsgSourceEntity, boolean paramBoolean2) {
    Bundle bundle = new Bundle();
    bundle.putLong("passby_session_id", paramLong);
    bundle.putString("passby_nick_name", paramString1);
    bundle.putString("passby_avatar", paramString2);
    bundle.putInt("passby_vbadge", paramInt1);
    bundle.putInt("passby_vip_grade", paramInt2);
    bundle.putInt("passby_is_vip_annual", paramInt3);
    bundle.putInt("passby_vip_exp_lvl", paramInt4);
    bundle.putString("passby_last_msg_distance", paramString3);
    bundle.putBoolean("passby_session_secret", paramBoolean1);
    bundle.putSerializable("PASSBY_LOG_DATA", (Serializable)paramLogData);
    bundle.putSerializable("msg_source_model", (Serializable)paramMsgSourceEntity);
    bundle.putInt("passby_is_hide_vip_look", paramInt6);
    bundle.putBoolean("IS_FROM_MSG_BOX", paramBoolean2);
    if (paramInt5 == 0) {
      bundle.putShort("passby_session_type", (short)2);
    } else if (paramInt5 == 1) {
      bundle.putShort("passby_session_type", (short)3);
    } else {
      return;
    } 
    TerminalActivity.d(paramContext, MsgChattingFragment.class, bundle);
  }
  
  public void a(Context paramContext, ChattingModel paramChattingModel) {
    if (paramChattingModel != null) {
      if (!CommonTools.a(paramContext))
        return; 
      if (!j())
        return; 
      i(paramChattingModel);
    } 
  }
  
  public void a(Context paramContext, SessionModel paramSessionModel, ChattingModel paramChattingModel) {
    if (paramChattingModel == null)
      return; 
    GroupNotificationExtra groupNotificationExtra = null;
    if (paramSessionModel != null) {
      SessionSettingModel sessionSettingModel = (SessionSettingModel)paramSessionModel.sessionSettingModel;
    } else {
      paramSessionModel = null;
    } 
    if (paramChattingModel.msgType == 52) {
      d(paramContext, paramChattingModel);
      return;
    } 
    if (paramChattingModel.sessionType == 2) {
      if ((!MsgBoxManager.a().c() || !MsgBoxManager.a().a(paramChattingModel.sessionId)) && BluedPreferences.ai() && paramChattingModel.status == 0) {
        b(paramContext, paramChattingModel);
        a(paramContext, paramChattingModel);
        return;
      } 
    } else if (paramChattingModel.sessionType == 3 && 1 != MsgType.getClassify(paramChattingModel.msgType)) {
      if (!BluedConstant.a) {
        if (!BluedPreferences.ak())
          return; 
        if (paramSessionModel == null) {
          b(paramContext, paramChattingModel);
          a(paramContext, paramChattingModel);
          return;
        } 
        if (GroupUtil.a(paramSessionModel.getRemindAudio())) {
          if (!GroupUtil.b(paramSessionModel.getRemindAudio()) && AtRegExpUtils.isAtSelf(paramChattingModel.msgAt)) {
            b(paramContext, paramChattingModel);
            a(paramContext, paramChattingModel);
            return;
          } 
        } else {
          b(paramContext, paramChattingModel);
          a(paramContext, paramChattingModel);
          return;
        } 
      } 
    } else if (paramChattingModel.sessionType == 1) {
      if (paramChattingModel.sessionId == 6L || paramChattingModel.sessionId == 7L) {
        c(paramContext, paramChattingModel);
        return;
      } 
      if (paramChattingModel.sessionId == 2L) {
        if (!BluedConstant.a)
          try {
            return;
          } finally {
            paramContext = null;
          }  
      } else {
        if (paramChattingModel.sessionId == 16L && BluedPreferences.af()) {
          e(paramContext, paramChattingModel);
          return;
        } 
        if (paramChattingModel.sessionId == 3L && paramChattingModel.msgType == 19 && BluedPreferences.al()) {
          f(paramContext, paramChattingModel);
          return;
        } 
        if (paramChattingModel.sessionId == 5L && paramChattingModel.msgType == 1 && BluedPreferences.aj()) {
          f(paramContext, paramChattingModel);
          return;
        } 
        if (paramChattingModel.sessionId == 10L) {
          if (!StringUtils.e(paramChattingModel.msgContent))
            try {
              ReflectionUtils.a(AppInfo.f().fromJson(paramChattingModel.msgContent, BluedLoginResult.class), UserInfo.a().i(), true);
            } catch (Exception exception) {} 
          BluedConfig.b().d();
          return;
        } 
        if (paramChattingModel.sessionId == 18L) {
          if (!TextUtils.isEmpty(paramChattingModel.getMsgExtra()))
            try {
              SysCommandModel sysCommandModel = (SysCommandModel)AppInfo.f().fromJson(paramChattingModel.getMsgExtra(), SysCommandModel.class);
              if (sysCommandModel.command_type == 1) {
                ChatManager.getInstance().deleteSessionAndChatting(Short.valueOf((short)2), sysCommandModel.command_info.session_id);
                return;
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
              return;
            }  
        } else if (paramChattingModel.sessionId == 19L) {
          MsgFragment.e = true;
          return;
        } 
      } 
    } 
  }
  
  public void a(Context paramContext, UserBasicModel paramUserBasicModel, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3) {
    byte b;
    if (paramUserBasicModel == null)
      return; 
    long l = Long.parseLong(paramUserBasicModel.uid);
    if (paramInt1 == 0) {
      b = 98;
    } else {
      b = 99;
    } 
    ChattingModel chattingModel = ChatHelper.getChattingModelForSendmsg(l, b, "vip", b(), "", (short)2);
    chattingModel.msgMapExtra = new HashMap<Object, Object>();
    chattingModel.msgMapExtra.put("title", paramString1);
    chattingModel.msgMapExtra.put("content", paramString2);
    chattingModel.msgMapExtra.put("vip_type", Integer.valueOf(paramInt2));
    chattingModel.msgMapExtra.put("link", paramString3);
    for (String paramString2 : chattingModel.msgMapExtra.keySet()) {
      Logger.b("xpf", new Object[] { paramString2, " :", chattingModel.msgMapExtra.get(paramString2) });
    } 
    paramInt1 = paramUserBasicModel.vbadge;
    c(chattingModel, paramUserBasicModel.name, paramUserBasicModel.avatar, paramInt1, paramUserBasicModel.vip_grade, paramUserBasicModel.is_vip_annual, paramUserBasicModel.vip_exp_lvl, paramInt3, false);
  }
  
  public void a(Context paramContext, BluedCreatedGroupInfo paramBluedCreatedGroupInfo) {
    String str = paramContext.getResources().getString(2131755483);
    b(ChatHelper.getChattingModelForSendmsg(Long.valueOf(paramBluedCreatedGroupInfo.groups_gid).longValue(), (short)-1000, str, a().b(), "", (short)3), paramBluedCreatedGroupInfo.groups_name, paramBluedCreatedGroupInfo.groups_avatar, 0, 0, 0, 0, 0);
  }
  
  public void a(Context paramContext, ShareToMsgEntity paramShareToMsgEntity) {
    ShareToFragment.a(paramContext, paramShareToMsgEntity);
  }
  
  public void a(SingleSessionListener paramSingleSessionListener) {
    ChatManager.getInstance().registerSessionListener((short)1, 13L, paramSingleSessionListener);
  }
  
  public void a(ChattingModel paramChattingModel, MsgPreProcesserListener paramMsgPreProcesserListener) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramChattingModel.fromId);
    stringBuilder.append("");
    if (!AppUtils.c(stringBuilder.toString()))
      return; 
    paramChattingModel.msgStateCode = 6;
    paramMsgPreProcesserListener.onProcessToSave(paramChattingModel);
  }
  
  public void a(ChattingModel paramChattingModel, String paramString1, String paramString2, int paramInt) {
    SessionProfileModel sessionProfileModel = new SessionProfileModel();
    sessionProfileModel.nickname = paramString1;
    sessionProfileModel.avatar = paramString2;
    sessionProfileModel.vBadge = paramInt;
    ChatManager.getInstance().sendMsg(paramChattingModel, sessionProfileModel, new MsgPreProcesser(this) {
          public void preProcess(ChattingModel param1ChattingModel, MsgPreProcesserListener param1MsgPreProcesserListener) {
            param1ChattingModel.msgStateCode = 6;
            param1MsgPreProcesserListener.onProcessToSave(param1ChattingModel);
          }
        });
  }
  
  public void a(ChattingModel paramChattingModel, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    long l = paramChattingModel.sessionId;
    String str1 = paramChattingModel.getMsgExtra();
    if (TextUtils.isEmpty(str1)) {
      a(paramChattingModel, paramString1, paramString2, paramInt1);
      return;
    } 
    Type type = (new TypeToken<MsgExtra>(this) {
      
      }).getType();
    Gson gson = AppInfo.f();
    MsgExtra msgExtra = (MsgExtra)gson.fromJson(str1, type);
    String str2 = msgExtra.getGroups_gid();
    GroupHttpUtils.a(new BluedUIHttpResponse<BluedEntity<Object, ExtraGroupInvitationModel>>(this, msgExtra, gson, paramChattingModel, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            this.k.a(this.c, this.d, this.e, this.f);
          }
          
          public void onUIUpdate(BluedEntity<Object, ExtraGroupInvitationModel> param1BluedEntity) {
            if (param1BluedEntity != null)
              try {
                if (param1BluedEntity.extra != null && ((ExtraGroupInvitationModel)param1BluedEntity.extra).iid != null && ((ExtraGroupInvitationModel)param1BluedEntity.extra).iid.size() > 0) {
                  String str = ((ExtraGroupInvitationModel.GroupInvitaion)((ExtraGroupInvitationModel)param1BluedEntity.extra).iid.get(0)).iid;
                  if (!TextUtils.isEmpty(str)) {
                    this.a.setGroups_iid(str);
                    str = this.b.toJson(this.a);
                    this.c.setMsgExtra(str);
                    this.k.c(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, false);
                    return;
                  } 
                  this.k.a(this.c, this.d, this.e, this.f);
                  return;
                } 
                this.k.a(this.c, this.d, this.e, this.f);
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                this.k.a(this.c, this.d, this.e, this.f);
                return;
              }  
            this.k.a(this.c, this.d, this.e, this.f);
          }
          
          public BluedEntity<Object, ExtraGroupInvitationModel> parseData(String param1String) {
            return super.parseData(param1String);
          }
        }str2, new String[] { String.valueOf(l) }, false);
  }
  
  public void a(ChattingModel paramChattingModel, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {
    SessionProfileModel sessionProfileModel = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    paramString2 = a(paramChattingModel);
    if (paramBoolean) {
      ChatManager.getInstance().resendMsg(paramChattingModel, sessionProfileModel, new MsgPreProcesser(this, paramString2) {
            public void preProcess(ChattingModel param1ChattingModel, MsgPreProcesserListener param1MsgPreProcesserListener) {
              ChatHelperV4.a(this.b, param1ChattingModel, param1MsgPreProcesserListener, this.a);
            }
          });
      return;
    } 
    ChatManager.getInstance().sendMsg(paramChattingModel, sessionProfileModel, new MsgPreProcesser(this, paramString2) {
          public void preProcess(ChattingModel param1ChattingModel, MsgPreProcesserListener param1MsgPreProcesserListener) {
            ChatHelperV4.a(this.b, param1ChattingModel, param1MsgPreProcesserListener, this.a);
          }
        });
  }
  
  public void a(ChattingModel paramChattingModel, boolean paramBoolean) {
    SessionProfileModel sessionProfileModel = a("", "", 0, 0, 0, 0, 0);
    if ((paramChattingModel.msgType == 32 || paramChattingModel.msgType == 210) && IMManager.a().b(paramChattingModel)) {
      if (paramBoolean) {
        ChatManager.getInstance().resendMsg(paramChattingModel, sessionProfileModel, new MsgPreProcesser(this) {
              public void preProcess(ChattingModel param1ChattingModel, MsgPreProcesserListener param1MsgPreProcesserListener) {
                IMManager.a().a(param1ChattingModel);
              }
            });
        return;
      } 
      ChatManager.getInstance().sendMsg(paramChattingModel, sessionProfileModel, new MsgPreProcesser(this) {
            public void preProcess(ChattingModel param1ChattingModel, MsgPreProcesserListener param1MsgPreProcesserListener) {
              IMManager.a().a(param1ChattingModel);
            }
          });
      return;
    } 
    if (paramBoolean) {
      ChatManager.getInstance().resendMsg(paramChattingModel, sessionProfileModel);
      return;
    } 
    ChatManager.getInstance().sendMsg(paramChattingModel, sessionProfileModel);
  }
  
  public void a(SessionModel paramSessionModel, ChattingModel paramChattingModel) {
    ChattingModel chattingModel = new ChattingModel(paramChattingModel);
    chattingModel.msgLocalId = ChatHelper.getLocalId();
    chattingModel.msgType = -1;
    h(chattingModel);
  }
  
  public void a(ShareToMsgEntity paramShareToMsgEntity, long paramLong, short paramShort, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (paramShareToMsgEntity == null)
      return; 
    MsgExtra msgExtra = new MsgExtra();
    msgExtra.setGroups_avatar(paramShareToMsgEntity.image);
    msgExtra.setGroups_name(paramShareToMsgEntity.name);
    msgExtra.setGroups_gid(paramShareToMsgEntity.gid);
    msgExtra.setGroups_description(paramShareToMsgEntity.description);
    String str = this.b.toJson(msgExtra);
    ChattingModel chattingModel = ChatHelper.getChattingModelForSendmsg(paramLong, (short)10, paramShareToMsgEntity.title, b(), str, paramShort);
    if (paramShort == 3) {
      chattingModel.msgType = 10;
      c(chattingModel, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
      return;
    } 
    if ("0".equals(paramShareToMsgEntity.isCreatorOrAdmin)) {
      chattingModel.msgType = 10;
      c(chattingModel, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
      return;
    } 
    if ("1".equals(paramShareToMsgEntity.isCreatorOrAdmin)) {
      chattingModel.msgType = 9;
      a(chattingModel, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    } 
  }
  
  public void a(ShareToMsgEntity paramShareToMsgEntity, long paramLong, short paramShort, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3) {
    byte b;
    if (paramShareToMsgEntity == null)
      return; 
    switch (paramShareToMsgEntity.share_from) {
      default:
        b = -1;
        break;
      case 11:
        CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CircleAddPoints>>(this) {
              protected void a(BluedEntityA<CircleAddPoints> param1BluedEntityA) {
                if (param1BluedEntityA != null && param1BluedEntityA.hasData() && ((CircleAddPoints)param1BluedEntityA.getSingleData()).circle_active_shared_posting > 0) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("分享成功，基分+");
                  stringBuilder.append(((CircleAddPoints)param1BluedEntityA.getSingleData()).circle_active_shared_posting);
                  AppMethods.a(stringBuilder.toString());
                } 
              }
            },  paramString3);
      case 9:
        b = 2;
        break;
      case 6:
      case 7:
        b = 88;
        break;
      case 5:
        b = 87;
        break;
      case 4:
      case 10:
        b = 89;
        break;
      case 2:
        a(paramShareToMsgEntity, paramLong, paramShort, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
        return;
      case 1:
        b = 90;
        break;
    } 
    if (b == 2) {
      boolean bool;
      boolean bool1 = (new File(paramShareToMsgEntity.image)).exists();
      int i = 0;
      if (bool1) {
        int[] arrayOfInt = ImageUtils.b(paramShareToMsgEntity.image);
        i = arrayOfInt[0];
        bool = arrayOfInt[1];
      } else {
        bool = false;
      } 
      paramString3 = a(i, bool);
      a(ChatHelper.getChattingModelForSendmsg(paramLong, b, paramShareToMsgEntity.image, b(), paramString3, paramShort), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
      return;
    } 
    ChattingModel chattingModel = ChatHelper.getChattingModelForSendmsg(paramLong, b, paramShareToMsgEntity.title, b(), "", paramShort);
    chattingModel.msgMapExtra = new HashMap<Object, Object>();
    chattingModel.msgMapExtra.put("image", paramShareToMsgEntity.image);
    chattingModel.msgMapExtra.put("name", paramShareToMsgEntity.name);
    chattingModel.msgMapExtra.put("type", Integer.valueOf(paramShareToMsgEntity.type));
    chattingModel.msgMapExtra.put("url", paramShareToMsgEntity.url);
    chattingModel.msgMapExtra.put("description", paramShareToMsgEntity.description);
    if (!TextUtils.isEmpty(paramShareToMsgEntity.image) && !paramShareToMsgEntity.image.contains("http")) {
      ChatHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<UrlPicResult>>(this, chattingModel, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramShareToMsgEntity) {
            protected void a(BluedEntityA<UrlPicResult> param1BluedEntityA) {
              if (param1BluedEntityA.data == null || param1BluedEntityA.data.size() <= 0) {
                this.j.c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, false);
                return;
              } 
              UrlPicResult urlPicResult = param1BluedEntityA.data.get(0);
              if (TextUtils.isEmpty(urlPicResult.url)) {
                this.j.c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, false);
                return;
              } 
              if (this.a.msgMapExtra != null)
                this.a.msgMapExtra.put("image", urlPicResult.url); 
              ImageFileLoader.a(null).a(this.i.image, urlPicResult.url).a();
              this.j.c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, false);
            }
            
            public boolean onUIFailure(int param1Int, String param1String) {
              this.j.c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, false);
              return super.onUIFailure(param1Int, param1String);
            }
          }UserInfo.a().i().getUid(), paramShareToMsgEntity.image, chattingModel);
      return;
    } 
    c(chattingModel, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    c(ChatHelper.getChattingModelForSendmsg(StringUtils.a(paramString1, 0L), (short)74, "unlock", b(), "", (short)2), paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, GiftGivingOptionForJsonParse paramGiftGivingOptionForJsonParse, MsgSourceEntity paramMsgSourceEntity) {
    if (paramGiftGivingOptionForJsonParse.type == -1)
      return; 
    long l = StringUtils.a(paramString1, 0L);
    MsgExtraGift msgExtraGift = new MsgExtraGift();
    MsgExtraGift.GiftInfo giftInfo = new MsgExtraGift.GiftInfo();
    giftInfo.gift_name_cn = paramGiftGivingOptionForJsonParse.gift_name_cn;
    giftInfo.gift_name_en = paramGiftGivingOptionForJsonParse.gift_name_en;
    giftInfo.gift_name_tw = paramGiftGivingOptionForJsonParse.gift_name_tw;
    giftInfo.gift_url = paramGiftGivingOptionForJsonParse.effects;
    giftInfo.toNickName = paramString2;
    giftInfo.giftTye = paramGiftGivingOptionForJsonParse.type;
    giftInfo.money = paramGiftGivingOptionForJsonParse.money;
    giftInfo.topTime = paramGiftGivingOptionForJsonParse.seconds;
    giftInfo.img_url = paramGiftGivingOptionForJsonParse.icon;
    giftInfo.giftId = paramGiftGivingOptionForJsonParse.gift_id;
    giftInfo.cardGift = paramGiftGivingOptionForJsonParse.extra_info;
    msgExtraGift.gift_like = giftInfo;
    msgExtraGift.msgSource = paramMsgSourceEntity;
    c(ChatHelper.getChattingModelForSendmsg(l, (short)164, "gift", b(), this.b.toJson(msgExtraGift), (short)2), paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
  }
  
  public void a(List<ChattingModel> paramList, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    for (ChattingModel chattingModel : paramList) {
      SessionProfileModel sessionProfileModel = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      ChatManager.getInstance().sendMsg(chattingModel, sessionProfileModel, new MsgPreProcesser(this) {
            public void preProcess(ChattingModel param1ChattingModel, MsgPreProcesserListener param1MsgPreProcesserListener) {
              ChatHelperV4.f().add(new Pair(param1ChattingModel, param1MsgPreProcesserListener));
              if (!ChatHelperV4.a(this.a))
                ChatHelperV4.b(this.a); 
            }
          });
    } 
  }
  
  public void a(short paramShort, long paramLong, ChattingModel paramChattingModel) {
    ChatManager.getInstance().destroyMsg(paramShort, paramLong, paramChattingModel);
  }
  
  public Bundle b(LiveMsgShareEntity paramLiveMsgShareEntity) {
    if (paramLiveMsgShareEntity == null)
      return null; 
    Bundle bundle = new Bundle();
    LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(paramLiveMsgShareEntity.lid, 0L), 0, "push", paramLiveMsgShareEntity.uid, paramLiveMsgShareEntity.name, paramLiveMsgShareEntity.avatar, paramLiveMsgShareEntity.vbadge);
    bundle.putString("arg_open_homeactivity_ope", "ope_liveplay");
    bundle.putSerializable("live_anchor_model", (Serializable)liveRoomData);
    return bundle;
  }
  
  public SessionProfileModel b() {
    SessionProfileModel sessionProfileModel = new SessionProfileModel();
    if (UserInfo.a().i() != null) {
      sessionProfileModel.nickname = UserInfo.a().i().getName();
      sessionProfileModel.avatar = UserInfo.a().i().getAvatar();
      sessionProfileModel.vBadge = UserInfo.a().i().getVBadge();
    } 
    return sessionProfileModel;
  }
  
  public String b(ChattingModel paramChattingModel) {
    String str1;
    short s = paramChattingModel.msgType;
    if (s != 5) {
      if (s != 25) {
        str1 = "";
      } else {
        String str;
        if (StringUtils.e(((ChattingModel)str1).msgContent))
          return ""; 
        try {
          str = AesCrypto.e(((ChattingModel)str1).msgContent);
        } catch (Exception exception) {
          exception.printStackTrace();
          str = "";
        } 
        if (StringUtils.e(str))
          return ((ChattingModel)str1).msgContent; 
        if (!StringUtils.e(str) && !str.contains("http"))
          return ((ChattingModel)str1).msgContent; 
        str1 = str;
      } 
    } else {
      str1 = ((ChattingModel)str1).msgContent;
    } 
    String str2 = str1;
    if (StringUtils.e(str1))
      str2 = ""; 
    return str2;
  }
  
  public String b(MsgSourceEntity paramMsgSourceEntity) {
    if (paramMsgSourceEntity == null)
      return null; 
    MsgAudioExtra msgAudioExtra = new MsgAudioExtra();
    msgAudioExtra.msgSource = paramMsgSourceEntity;
    return this.b.toJson(msgAudioExtra);
  }
  
  public void b(long paramLong) {
    ChatManager.getInstance().deleteSession((short)2, paramLong);
  }
  
  public void b(SingleSessionListener paramSingleSessionListener) {
    ChatManager.getInstance().unregisterSessionListener((short)1, 13L, paramSingleSessionListener);
  }
  
  public void b(ChattingModel paramChattingModel, MsgPreProcesserListener paramMsgPreProcesserListener) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramChattingModel.fromId);
    stringBuilder.append("");
    if (!AppUtils.c(stringBuilder.toString()))
      return; 
    paramMsgPreProcesserListener.onProcessToSave(paramChattingModel);
    if (IMManager.a().b(paramChattingModel)) {
      IMManager.a().a(paramChattingModel);
      return;
    } 
    paramMsgPreProcesserListener.onProcessToSend(paramChattingModel);
  }
  
  public void b(ChattingModel paramChattingModel, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    SessionProfileModel sessionProfileModel = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    ChatManager.getInstance().sendMsg(paramChattingModel, sessionProfileModel, new MsgPreProcesser(this) {
          public void preProcess(ChattingModel param1ChattingModel, MsgPreProcesserListener param1MsgPreProcesserListener) {
            param1ChattingModel.msgStateCode = 3;
            param1MsgPreProcesserListener.onProcessToSave(param1ChattingModel);
          }
        });
  }
  
  public void b(ChattingModel paramChattingModel, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {
    SessionProfileModel sessionProfileModel = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    paramString2 = b(paramChattingModel);
    if (paramBoolean) {
      ChatManager.getInstance().resendMsg(paramChattingModel, sessionProfileModel, new MsgPreProcesser(this, paramString2) {
            public void preProcess(ChattingModel param1ChattingModel, MsgPreProcesserListener param1MsgPreProcesserListener) {
              ChatHelperV4.a(this.b, param1ChattingModel, param1MsgPreProcesserListener, this.a);
            }
          });
      return;
    } 
    ChatManager.getInstance().sendMsg(paramChattingModel, sessionProfileModel, new MsgPreProcesser(this, paramString2) {
          public void preProcess(ChattingModel param1ChattingModel, MsgPreProcesserListener param1MsgPreProcesserListener) {
            ChatHelperV4.a(this.b, param1ChattingModel, param1MsgPreProcesserListener, this.a);
          }
        });
  }
  
  public void b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    c(ChatHelper.getChattingModelForSendmsg(StringUtils.a(paramString1, 0L), (short)73, "apply", b(), "", (short)2), paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
  }
  
  public void c() {
    this.c.a(100);
  }
  
  public void c(SingleSessionListener paramSingleSessionListener) {
    ChatManager.getInstance().registerSessionListener((short)1, 4L, paramSingleSessionListener);
  }
  
  public void c(ChattingModel paramChattingModel, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {
    SessionProfileModel sessionProfileModel = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    if (IMManager.a().b(paramChattingModel)) {
      if (paramBoolean) {
        ChatManager.getInstance().resendMsg(paramChattingModel, sessionProfileModel, new MsgPreProcesser(this) {
              public void preProcess(ChattingModel param1ChattingModel, MsgPreProcesserListener param1MsgPreProcesserListener) {
                IMManager.a().a(param1ChattingModel);
              }
            });
        return;
      } 
      ChatManager.getInstance().sendMsg(paramChattingModel, sessionProfileModel, new MsgPreProcesser(this) {
            public void preProcess(ChattingModel param1ChattingModel, MsgPreProcesserListener param1MsgPreProcesserListener) {
              IMManager.a().a(param1ChattingModel);
            }
          });
      return;
    } 
    if (paramBoolean) {
      ChatManager.getInstance().resendMsg(paramChattingModel, sessionProfileModel);
      return;
    } 
    ChatManager.getInstance().sendMsg(paramChattingModel, sessionProfileModel);
  }
  
  public String[] c(ChattingModel paramChattingModel) {
    String[] arrayOfString = new String[2];
    if (paramChattingModel == null)
      return arrayOfString; 
    String str = paramChattingModel.msgContent;
    if (StringUtils.e(str))
      return arrayOfString; 
    try {
      if (paramChattingModel.msgMapExtra != null && !TextUtils.isEmpty((String)paramChattingModel.msgMapExtra.get("videoCoverUrl"))) {
        arrayOfString[0] = (String)paramChattingModel.msgMapExtra.get("videoCoverUrl");
      } else {
        String str1 = paramChattingModel.getMsgExtra();
        MsgChattingVideoModel msgChattingVideoModel = (MsgChattingVideoModel)this.b.fromJson(str1, MsgChattingVideoModel.class);
        if (msgChattingVideoModel != null && !TextUtils.isEmpty(msgChattingVideoModel.getVideoCoverUrl())) {
          arrayOfString[0] = msgChattingVideoModel.getVideoCoverUrl();
        } else if (str.contains("http")) {
          arrayOfString[0] = str;
        } else {
          arrayOfString[0] = paramChattingModel.msgVideoCoverUrlLocal;
        } 
      } 
    } catch (Exception exception) {}
    arrayOfString[1] = str;
    return arrayOfString;
  }
  
  public MsgChattingImageModel d(ChattingModel paramChattingModel) {
    if (paramChattingModel == null)
      return null; 
    try {
      String str = paramChattingModel.getMsgExtra();
      return (MsgChattingImageModel)this.b.fromJson(str, MsgChattingImageModel.class);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public void d() {
    this.e = true;
  }
  
  public void d(SingleSessionListener paramSingleSessionListener) {
    ChatManager.getInstance().unregisterSessionListener((short)1, 4L, paramSingleSessionListener);
  }
  
  public ShareToMsgEntity e(ChattingModel paramChattingModel) {
    ShareToMsgEntity shareToMsgEntity = new ShareToMsgEntity();
    try {
      if (paramChattingModel.msgMapExtra != null) {
        shareToMsgEntity.image = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "image");
        shareToMsgEntity.name = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "name");
        shareToMsgEntity.type = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "type");
        shareToMsgEntity.url = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "url");
        shareToMsgEntity.description = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "description");
        return shareToMsgEntity;
      } 
      String str = paramChattingModel.getMsgExtra();
      if (!TextUtils.isEmpty(str))
        return (ShareToMsgEntity)this.b.fromJson(str, ShareToMsgEntity.class); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return shareToMsgEntity;
  }
  
  public void e() {
    this.e = false;
  }
  
  public void e(SingleSessionListener paramSingleSessionListener) {
    ChatManager.getInstance().registerSessionListener((short)1, 7L, paramSingleSessionListener);
  }
  
  public MsgChattingImageModel f(ChattingModel paramChattingModel) {
    // Byte code:
    //   0: new com/soft/blued/ui/msg/model/MsgChattingImageModel
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #6
    //   9: aload #6
    //   11: astore #4
    //   13: aload #6
    //   15: astore #5
    //   17: aload_1
    //   18: invokevirtual getMsgExtra : ()Ljava/lang/String;
    //   21: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   24: ifne -> 50
    //   27: aload #6
    //   29: astore #5
    //   31: aload_0
    //   32: getfield b : Lcom/google/gson/Gson;
    //   35: aload_1
    //   36: invokevirtual getMsgExtra : ()Ljava/lang/String;
    //   39: ldc_w com/soft/blued/ui/msg/model/MsgChattingImageModel
    //   42: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   45: checkcast com/soft/blued/ui/msg/model/MsgChattingImageModel
    //   48: astore #4
    //   50: aload #4
    //   52: astore #5
    //   54: aload #4
    //   56: invokevirtual getLatitude : ()Ljava/lang/String;
    //   59: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   62: ifne -> 84
    //   65: aload #4
    //   67: astore #5
    //   69: aload #4
    //   71: astore #6
    //   73: aload #4
    //   75: invokevirtual getLongitude : ()Ljava/lang/String;
    //   78: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   81: ifeq -> 247
    //   84: aload #4
    //   86: astore #5
    //   88: aload_1
    //   89: getfield msgContent : Ljava/lang/String;
    //   92: ldc_w ','
    //   95: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   98: astore_1
    //   99: aload #4
    //   101: astore #5
    //   103: aload #4
    //   105: aload_1
    //   106: iconst_0
    //   107: aaload
    //   108: invokevirtual setLongitude : (Ljava/lang/String;)V
    //   111: aload #4
    //   113: astore #5
    //   115: aload #4
    //   117: aload_1
    //   118: iconst_1
    //   119: aaload
    //   120: invokevirtual setLatitude : (Ljava/lang/String;)V
    //   123: aload #4
    //   125: astore #5
    //   127: aload_1
    //   128: arraylength
    //   129: istore_3
    //   130: iconst_2
    //   131: istore_2
    //   132: aload #4
    //   134: astore #6
    //   136: iload_3
    //   137: iconst_2
    //   138: if_icmple -> 247
    //   141: aload #4
    //   143: astore #5
    //   145: new java/lang/StringBuffer
    //   148: dup
    //   149: invokespecial <init> : ()V
    //   152: astore #6
    //   154: aload #4
    //   156: astore #5
    //   158: iload_2
    //   159: aload_1
    //   160: arraylength
    //   161: if_icmpge -> 221
    //   164: aload #4
    //   166: astore #5
    //   168: iload_2
    //   169: aload_1
    //   170: arraylength
    //   171: iconst_1
    //   172: isub
    //   173: if_icmpne -> 192
    //   176: aload #4
    //   178: astore #5
    //   180: aload #6
    //   182: aload_1
    //   183: iload_2
    //   184: aaload
    //   185: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   188: pop
    //   189: goto -> 250
    //   192: aload #4
    //   194: astore #5
    //   196: aload #6
    //   198: aload_1
    //   199: iload_2
    //   200: aaload
    //   201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   204: pop
    //   205: aload #4
    //   207: astore #5
    //   209: aload #6
    //   211: ldc_w ','
    //   214: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   217: pop
    //   218: goto -> 250
    //   221: aload #4
    //   223: astore #5
    //   225: aload #4
    //   227: aload #6
    //   229: invokevirtual toString : ()Ljava/lang/String;
    //   232: invokevirtual setLocation : (Ljava/lang/String;)V
    //   235: aload #4
    //   237: areturn
    //   238: astore_1
    //   239: aload_1
    //   240: invokevirtual printStackTrace : ()V
    //   243: aload #5
    //   245: astore #6
    //   247: aload #6
    //   249: areturn
    //   250: iload_2
    //   251: iconst_1
    //   252: iadd
    //   253: istore_2
    //   254: goto -> 154
    // Exception table:
    //   from	to	target	type
    //   17	27	238	java/lang/Exception
    //   31	50	238	java/lang/Exception
    //   54	65	238	java/lang/Exception
    //   73	84	238	java/lang/Exception
    //   88	99	238	java/lang/Exception
    //   103	111	238	java/lang/Exception
    //   115	123	238	java/lang/Exception
    //   127	130	238	java/lang/Exception
    //   145	154	238	java/lang/Exception
    //   158	164	238	java/lang/Exception
    //   168	176	238	java/lang/Exception
    //   180	189	238	java/lang/Exception
    //   196	205	238	java/lang/Exception
    //   209	218	238	java/lang/Exception
    //   225	235	238	java/lang/Exception
  }
  
  public void f(SingleSessionListener paramSingleSessionListener) {
    ChatManager.getInstance().unregisterSessionListener((short)1, 7L, paramSingleSessionListener);
  }
  
  public void g(SingleSessionListener paramSingleSessionListener) {
    ChatManager.getInstance().registerSessionListener((short)1, 6L, paramSingleSessionListener);
  }
  
  public int[] g(ChattingModel paramChattingModel) {
    Gson gson = AppInfo.f();
    String str = paramChattingModel.getMsgExtra();
    int[] arrayOfInt = new int[2];
    try {
      if (paramChattingModel.msgMapExtra != null) {
        arrayOfInt[0] = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "video_width");
        arrayOfInt[1] = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "video_height");
        if ((arrayOfInt[0] == 0 || arrayOfInt[1] == 0) && !StringUtils.e(str)) {
          MsgChattingVideoModel msgChattingVideoModel = (MsgChattingVideoModel)gson.fromJson(str, MsgChattingVideoModel.class);
          if (msgChattingVideoModel != null) {
            arrayOfInt[0] = msgChattingVideoModel.getVideo_width();
            arrayOfInt[1] = msgChattingVideoModel.getVideo_height();
            return arrayOfInt;
          } 
        } 
      } else if (!StringUtils.e(str)) {
        MsgChattingVideoModel msgChattingVideoModel = (MsgChattingVideoModel)gson.fromJson(str, MsgChattingVideoModel.class);
        if (msgChattingVideoModel != null) {
          arrayOfInt[0] = msgChattingVideoModel.getVideo_width();
          arrayOfInt[1] = msgChattingVideoModel.getVideo_height();
          return arrayOfInt;
        } 
      } 
    } catch (JsonSyntaxException jsonSyntaxException) {
      jsonSyntaxException.printStackTrace();
    } 
    return arrayOfInt;
  }
  
  public void h(SingleSessionListener paramSingleSessionListener) {
    ChatManager.getInstance().unregisterSessionListener((short)1, 6L, paramSingleSessionListener);
  }
  
  public void h(ChattingModel paramChattingModel) {
    ChatManager.getInstance().sendMsg(paramChattingModel, null, null);
  }
  
  public void i(ChattingModel paramChattingModel) {
    try {
      if (this.e)
        return; 
      if (IMV4Constant.a)
        return; 
      if (!BluedPreferences.ac() && !BluedPreferences.ad())
        return; 
      if (ChatConstants.a == paramChattingModel.sessionId && IMV4Constant.b)
        return; 
      if (BluedPreferences.ad() && BluedPreferences.ac()) {
        if (ChatConstants.a != paramChattingModel.sessionId)
          if (BluedPreferences.aa()) {
            MediaUtils.a().a(1);
          } else {
            MediaUtils.a().b();
          }  
        MediaUtils.a().a(1000L);
        return;
      } 
      if (BluedPreferences.ad()) {
        MediaUtils.a().a(1000L);
        return;
      } 
      if (BluedPreferences.ac() && ChatConstants.a != paramChattingModel.sessionId) {
        if (BluedPreferences.aa()) {
          MediaUtils.a().a(1);
          return;
        } 
        MediaUtils.a().b();
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\controller\tools\ChatHelperV4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */