package com.soft.blued.ui.msg.controller.tools;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.message.MessageProtos;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.feed.fragment.FeedDetailsFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.msg.customview.Emotion;
import com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.user.fragment.ReportChatFragment;
import com.soft.blued.ui.video.fragment.VideoScanFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.TimeAndDateUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MsgCommonUtils {
  private static final String a = MsgCommonUtils.class.getSimpleName();
  
  public static MsgExtraForTextTypeEntity.SecureNotify a(MsgExtraForTextTypeEntity.SecureNotify paramSecureNotify) {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #10
    //   9: new java/util/ArrayList
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore #5
    //   18: ldc ''
    //   20: astore #12
    //   22: aload_0
    //   23: ifnull -> 398
    //   26: invokestatic b : ()Ljava/lang/String;
    //   29: astore_1
    //   30: aload_1
    //   31: ldc 'zh-cn'
    //   33: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   36: ifeq -> 81
    //   39: aload_0
    //   40: getfield contents_zh_cn : Ljava/lang/String;
    //   43: astore_2
    //   44: aload_0
    //   45: getfield title_zh_cn : Ljava/lang/String;
    //   48: astore_3
    //   49: aload_0
    //   50: getfield link_title_zh_cn : Ljava/lang/String;
    //   53: astore #4
    //   55: aload_0
    //   56: getfield report_title_zh_cn : Ljava/lang/String;
    //   59: astore #5
    //   61: aload_0
    //   62: getfield multi_contents_zh_cn : Ljava/util/List;
    //   65: astore #6
    //   67: aload_0
    //   68: getfield collapse_desc_zh_cn : Ljava/lang/String;
    //   71: astore #7
    //   73: aload_0
    //   74: getfield highlight_keywords_zh_cn : Ljava/util/List;
    //   77: astore_1
    //   78: goto -> 222
    //   81: aload_1
    //   82: ldc 'zh-tw'
    //   84: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   87: ifeq -> 132
    //   90: aload_0
    //   91: getfield contents_zh_tw : Ljava/lang/String;
    //   94: astore_2
    //   95: aload_0
    //   96: getfield title_zh_tw : Ljava/lang/String;
    //   99: astore_3
    //   100: aload_0
    //   101: getfield link_title_zh_tw : Ljava/lang/String;
    //   104: astore #4
    //   106: aload_0
    //   107: getfield report_title_zh_tw : Ljava/lang/String;
    //   110: astore #5
    //   112: aload_0
    //   113: getfield multi_contents_zh_tw : Ljava/util/List;
    //   116: astore #6
    //   118: aload_0
    //   119: getfield collapse_desc_zh_tw : Ljava/lang/String;
    //   122: astore #7
    //   124: aload_0
    //   125: getfield highlight_keywords_zh_tw : Ljava/util/List;
    //   128: astore_1
    //   129: goto -> 222
    //   132: aload_1
    //   133: ldc 'en-us'
    //   135: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   138: ifeq -> 183
    //   141: aload_0
    //   142: getfield contents_en_us : Ljava/lang/String;
    //   145: astore_2
    //   146: aload_0
    //   147: getfield title_en_us : Ljava/lang/String;
    //   150: astore_3
    //   151: aload_0
    //   152: getfield link_title_en_us : Ljava/lang/String;
    //   155: astore #4
    //   157: aload_0
    //   158: getfield report_title_en_us : Ljava/lang/String;
    //   161: astore #5
    //   163: aload_0
    //   164: getfield multi_contents_en_us : Ljava/util/List;
    //   167: astore #6
    //   169: aload_0
    //   170: getfield collapse_desc_en_us : Ljava/lang/String;
    //   173: astore #7
    //   175: aload_0
    //   176: getfield highlight_keywords_en_us : Ljava/util/List;
    //   179: astore_1
    //   180: goto -> 222
    //   183: aload_0
    //   184: getfield contents_en_us : Ljava/lang/String;
    //   187: astore_2
    //   188: aload_0
    //   189: getfield title_en_us : Ljava/lang/String;
    //   192: astore_3
    //   193: aload_0
    //   194: getfield link_title_en_us : Ljava/lang/String;
    //   197: astore #4
    //   199: aload_0
    //   200: getfield report_title_en_us : Ljava/lang/String;
    //   203: astore #5
    //   205: aload_0
    //   206: getfield multi_contents_en_us : Ljava/util/List;
    //   209: astore #6
    //   211: aload_0
    //   212: getfield collapse_desc_en_us : Ljava/lang/String;
    //   215: astore #7
    //   217: aload_0
    //   218: getfield highlight_keywords_en_us : Ljava/util/List;
    //   221: astore_1
    //   222: aload_2
    //   223: astore #8
    //   225: aload_2
    //   226: invokestatic e : (Ljava/lang/String;)Z
    //   229: ifeq -> 238
    //   232: aload_0
    //   233: getfield contents : Ljava/lang/String;
    //   236: astore #8
    //   238: aload_3
    //   239: astore_2
    //   240: aload_3
    //   241: invokestatic e : (Ljava/lang/String;)Z
    //   244: ifeq -> 252
    //   247: aload_0
    //   248: getfield title : Ljava/lang/String;
    //   251: astore_2
    //   252: aload #4
    //   254: astore_3
    //   255: aload #4
    //   257: invokestatic e : (Ljava/lang/String;)Z
    //   260: ifeq -> 268
    //   263: aload_0
    //   264: getfield link_title : Ljava/lang/String;
    //   267: astore_3
    //   268: aload #5
    //   270: astore #4
    //   272: aload #5
    //   274: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   277: ifeq -> 286
    //   280: aload_0
    //   281: getfield report_title : Ljava/lang/String;
    //   284: astore #4
    //   286: aload #6
    //   288: ifnull -> 305
    //   291: aload #6
    //   293: astore #9
    //   295: aload #6
    //   297: invokeinterface size : ()I
    //   302: ifgt -> 311
    //   305: aload_0
    //   306: getfield multi_contents : Ljava/util/List;
    //   309: astore #9
    //   311: aload #7
    //   313: astore #6
    //   315: aload #7
    //   317: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   320: ifeq -> 329
    //   323: aload_0
    //   324: getfield collapse_desc : Ljava/lang/String;
    //   327: astore #6
    //   329: aload_1
    //   330: ifnull -> 367
    //   333: aload #8
    //   335: astore #14
    //   337: aload_2
    //   338: astore #13
    //   340: aload_3
    //   341: astore #12
    //   343: aload #4
    //   345: astore #11
    //   347: aload #9
    //   349: astore #10
    //   351: aload #6
    //   353: astore #7
    //   355: aload_1
    //   356: astore #5
    //   358: aload_1
    //   359: invokeinterface size : ()I
    //   364: ifgt -> 416
    //   367: aload_0
    //   368: getfield highlight_keywords : Ljava/util/List;
    //   371: astore #5
    //   373: aload #8
    //   375: astore #14
    //   377: aload_2
    //   378: astore #13
    //   380: aload_3
    //   381: astore #12
    //   383: aload #4
    //   385: astore #11
    //   387: aload #9
    //   389: astore #10
    //   391: aload #6
    //   393: astore #7
    //   395: goto -> 416
    //   398: ldc ''
    //   400: astore #14
    //   402: aload #14
    //   404: astore_1
    //   405: aload_1
    //   406: astore_2
    //   407: aload_2
    //   408: astore #7
    //   410: aload_2
    //   411: astore #11
    //   413: aload_1
    //   414: astore #13
    //   416: aload_0
    //   417: aload #14
    //   419: putfield contents : Ljava/lang/String;
    //   422: aload_0
    //   423: aload #13
    //   425: putfield title : Ljava/lang/String;
    //   428: aload_0
    //   429: aload #12
    //   431: putfield link_title : Ljava/lang/String;
    //   434: aload_0
    //   435: aload #11
    //   437: putfield report_title : Ljava/lang/String;
    //   440: aload_0
    //   441: aload #10
    //   443: putfield multi_contents : Ljava/util/List;
    //   446: aload_0
    //   447: aload #7
    //   449: putfield collapse_desc : Ljava/lang/String;
    //   452: aload_0
    //   453: aload #5
    //   455: putfield highlight_keywords : Ljava/util/List;
    //   458: aload_0
    //   459: areturn
  }
  
  private static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    return TextUtils.isEmpty(paramCharSequence) ? paramCharSequence : Emotion.a(paramCharSequence, paramInt1, paramInt2);
  }
  
  public static String a(Context paramContext, long paramLong) {
    return TimeAndDateUtils.f(paramLong) ? (TimeAndDateUtils.e(paramLong) ? ((SimpleDateFormat)TimeAndDateUtils.f.get()).format(new Date(paramLong)) : (TimeAndDateUtils.g(paramLong) ? paramContext.getResources().getString(2131755486) : ((SimpleDateFormat)TimeAndDateUtils.g.get()).format(new Date(paramLong)))) : ((SimpleDateFormat)TimeAndDateUtils.a.get()).format(new Date(paramLong));
  }
  
  public static String a(Context paramContext, MessageProtos.StrangerSource paramStrangerSource, String paramString1, String paramString2) {
    String str = "";
    if (paramStrangerSource != null) {
      EventTrackMessage.a(MessageProtos.Event.MSG_PRIVATE_STRANGER_SOURCE_PROMPT, paramStrangerSource, paramString2);
      switch (null.a[paramStrangerSource.ordinal()]) {
        default:
          return "";
        case 25:
          return paramContext.getResources().getString(2131756827);
        case 24:
          return paramContext.getResources().getString(2131756840);
        case 23:
          return paramContext.getResources().getString(2131756822);
        case 22:
          return paramContext.getResources().getString(2131756836);
        case 21:
          return paramContext.getResources().getString(2131756851);
        case 18:
        case 19:
        case 20:
          return paramContext.getResources().getString(2131756833);
        case 14:
        case 15:
        case 16:
        case 17:
          return paramContext.getResources().getString(2131756823);
        case 13:
          return paramContext.getResources().getString(2131756828);
        case 12:
          return paramContext.getResources().getString(2131756832);
        case 11:
          return paramContext.getResources().getString(2131756831);
        case 10:
          return paramContext.getResources().getString(2131756829);
        case 9:
          return paramContext.getResources().getString(2131756830);
        case 8:
          return paramContext.getResources().getString(2131756847);
        case 7:
          return String.format(paramContext.getResources().getString(2131759381), new Object[] { paramString1 });
        case 6:
          return paramContext.getResources().getString(2131756825);
        case 5:
          return paramContext.getResources().getString(2131756826);
        case 4:
          return paramContext.getResources().getString(2131756824);
        case 3:
          return paramContext.getResources().getString(2131756849);
        case 2:
          break;
      } 
      str = paramContext.getResources().getString(2131756848);
    } 
    return str;
  }
  
  public static String a(ChattingModel paramChattingModel, String paramString1, String paramString2) {
    String str = IMV4Method.a(paramChattingModel.sessionType, paramChattingModel.sessionId, paramString1);
    return TextUtils.isEmpty(str) ? paramString2 : (AppMethods.a(paramString2, str) ? str : paramString2);
  }
  
  public static String a(List<ChattingModel> paramList, ChattingModel paramChattingModel) {
    if (paramList != null) {
      if (paramList.size() == 0)
        return ""; 
      int j = paramList.indexOf(paramChattingModel);
      ArrayList<ChattingModel> arrayList = new ArrayList();
      if (j >= 0)
        for (int k = j - 5; k <= j + 5; k++) {
          if (k >= 0) {
            if (k >= paramList.size())
              break; 
            ChattingModel chattingModel = paramList.get(k);
            if (chattingModel.msgType == 1 || chattingModel.msgType == 2 || chattingModel.msgType == 3 || chattingModel.msgType == 5)
              arrayList.add(chattingModel); 
          } 
        }  
      StringBuffer stringBuffer = new StringBuffer();
      for (int i = 0; i < arrayList.size(); i++) {
        ChattingModel chattingModel = arrayList.get(i);
        j = arrayList.size();
        String str = "[§]";
        if (i == j - 1) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("[");
          stringBuilder.append(chattingModel.fromId);
          stringBuilder.append("][");
          stringBuilder.append(chattingModel.msgContent);
          stringBuilder.append("][");
          stringBuilder.append(chattingModel.msgTimestamp);
          stringBuilder.append("]");
          if (chattingModel.msgId != paramChattingModel.msgId)
            str = ""; 
          stringBuilder.append(str);
          stringBuffer.append(stringBuilder.toString());
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("[");
          stringBuilder.append(chattingModel.fromId);
          stringBuilder.append("][");
          stringBuilder.append(chattingModel.msgContent);
          stringBuilder.append("][");
          stringBuilder.append(chattingModel.msgTimestamp);
          stringBuilder.append("]");
          if (chattingModel.msgId != paramChattingModel.msgId)
            str = ""; 
          stringBuilder.append(str);
          stringBuilder.append("§§§§");
          stringBuffer.append(stringBuilder.toString());
        } 
      } 
      Logger.b(a, new Object[] { "举报传给服务器的拼接字符串：", stringBuffer.toString() });
      return stringBuffer.toString();
    } 
    return "";
  }
  
  public static void a(Context paramContext, EditText paramEditText, int paramInt1, int paramInt2, String paramString, Map<String, String> paramMap) {
    if (paramMap != null) {
      if (paramMap.size() == 0)
        return; 
      ArrayList<String> arrayList = new ArrayList();
      Iterator<String> iterator = paramMap.keySet().iterator();
      while (iterator.hasNext())
        arrayList.add(iterator.next()); 
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(paramString);
      int i;
      for (i = 0; i < arrayList.size(); i++) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@");
        stringBuilder.append(arrayList.get(i));
        stringBuilder.append(" ");
        String str = stringBuilder.toString();
        if (paramString.contains(str)) {
          Matcher matcher = Pattern.compile(str).matcher(paramString);
          while (matcher.find()) {
            TextView textView = new TextView(paramContext);
            textView.setText(str);
            textView.setTextSize(paramInt1);
            textView.setTextColor(paramInt2);
            textView.setDrawingCacheEnabled(true);
            textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
            ImageSpan imageSpan = new ImageSpan(paramContext, textView.getDrawingCache());
            try {
              if (a(spannableStringBuilder, matcher.start(), matcher.end()))
                spannableStringBuilder.setSpan(imageSpan, matcher.start(), matcher.end(), 33); 
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
          } 
        } 
      } 
      paramEditText.setText(a((CharSequence)spannableStringBuilder, (int)paramEditText.getTextSize(), 0));
    } 
  }
  
  public static void a(Context paramContext, MessageProtos.StrangerSource paramStrangerSource, String paramString) {
    if (paramStrangerSource != null) {
      int i = null.a[paramStrangerSource.ordinal()];
      if (i != 25) {
        BluedIngSelfFeed bluedIngSelfFeed;
        switch (i) {
          default:
            return;
          case 14:
          case 15:
          case 16:
          case 17:
            WebViewShowInfoFragment.show(paramContext, H5Url.a(49, new Object[] { (UserInfo.a().i()).uid }), 0);
            return;
          case 10:
          case 11:
          case 12:
          case 13:
          case 18:
          case 19:
          case 20:
            bluedIngSelfFeed = new BluedIngSelfFeed();
            bluedIngSelfFeed.feed_id = EncryptTool.a(paramString);
            bluedIngSelfFeed.is_ads = 0;
            FeedDetailsFragment.a(paramContext, bluedIngSelfFeed, -1, 0);
            return;
          case 9:
            break;
        } 
        VideoScanFragment.a(paramContext, paramString);
        return;
      } 
      WebViewShowInfoFragment.show(paramContext, H5Url.a(43, new Object[] { (UserInfo.a().i()).uid }), 0);
    } 
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong, IRequestHost paramIRequestHost) {
    Logger.b(a, new Object[] { "举报消息字符串：targetID：", paramString2, ",contents:", paramString1 });
    ChatHttpUtils.a(paramContext, new BluedUIHttpResponse(paramIRequestHost) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            AppMethods.d(2131755510);
          }
        },  paramString1, null, 8, paramString2, "", paramLong, 0, paramIRequestHost);
  }
  
  public static void a(Context paramContext, List<ChattingModel> paramList, ChattingModel paramChattingModel, String paramString, int paramInt1, int paramInt2, IRequestHost paramIRequestHost) {
    String str = a(paramList, paramChattingModel);
    if (paramInt1 == 6) {
      ReportChatFragment.a(paramContext, str, paramString, paramInt1);
      if (paramInt2 == 1) {
        EventTrackMessage.a(MessageProtos.Event.PRIVATE_CHAT_REPORT_CLICK, 1, paramString);
        InstantLog.b("private_chat_report_click", 1);
        return;
      } 
      EventTrackMessage.a(MessageProtos.Event.PRIVATE_CHAT_REPORT_CLICK, 0, paramString);
      InstantLog.b("private_chat_report_click", 0);
      return;
    } 
    MsgGroupHttpUtils.a(paramIRequestHost, GroupUtil.a(paramList, paramChattingModel), new BluedUIHttpResponse(paramIRequestHost, paramContext) {
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (param1Boolean)
              ToastUtils.a(this.a.getString(2131758599)); 
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        });
  }
  
  private static boolean a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2) {
    if (paramInt2 < paramInt1)
      return false; 
    int i = paramSpannableStringBuilder.length();
    if (paramInt1 <= i) {
      if (paramInt2 > i)
        return false; 
      if (paramInt1 >= 0)
        return !(paramInt2 < 0); 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\controller\tools\MsgCommonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */