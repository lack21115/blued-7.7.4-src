package com.soft.blued.ui.msg.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.VideoChatMsgContentModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.das.message.MessageProtos;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.ui.msg.contract.IMsgView;
import com.soft.blued.ui.msg.controller.tools.IMV4Method;
import com.soft.blued.ui.msg.customview.Emotion;
import com.soft.blued.ui.msg.manager.MessageChatMethod;
import com.soft.blued.ui.msg.manager.UserPagerGiftManager;
import com.soft.blued.ui.msg.model.MsgExtraGift;
import com.soft.blued.ui.msg.presenter.MsgPresenter;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class ChatFriendListAdapter extends BaseAdapter {
  public MsgPresenter a;
  
  private LayoutInflater b;
  
  private IMsgView c;
  
  private Emotion d;
  
  private List<ViewHolder> e = new ArrayList<ViewHolder>();
  
  private boolean f = false;
  
  private List<SessionModel> g = new ArrayList<SessionModel>();
  
  private IRequestHost h;
  
  public ChatFriendListAdapter(IRequestHost paramIRequestHost, IMsgView paramIMsgView) {
    this.c = paramIMsgView;
    this.h = paramIRequestHost;
    this.b = LayoutInflater.from(this.c.getContext());
    this.d = new Emotion(this.c.getContext());
  }
  
  public static String a(View paramView, SessionModel paramSessionModel) {
    int i = paramSessionModel.vBadge;
    String str1 = "";
    if (i == 3)
      return ""; 
    String str2 = str1;
    if (paramSessionModel.sessionType == 2) {
      str2 = str1;
      if (IMV4Method.a(paramSessionModel.lastMsgFromId) == 1) {
        if (DistanceUtils.c(paramSessionModel.lastMsgFromDistance)) {
          paramView.setVisibility(0);
          return "";
        } 
        str2 = DistanceUtils.a(paramSessionModel.lastMsgFromDistance, BlueAppLocal.c(), false);
        String str = str1;
        if (!StringUtils.e(str2)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("[");
          stringBuilder.append(str2);
          stringBuilder.append("] ");
          str = stringBuilder.toString();
        } 
        paramView.setVisibility(8);
        str2 = str;
      } 
    } 
    return str2;
  }
  
  private static String a(SessionModel paramSessionModel, Context paramContext) {
    MsgExtraGift msgExtraGift;
    try {
    
    } finally {
      paramSessionModel = null;
    } 
    boolean bool = false;
    return UserPagerGiftManager.a(bool, msgExtraGift, paramContext, paramSessionModel.lastMsgFromNickname);
  }
  
  public static void a(Context paramContext, View paramView, TextView paramTextView, SessionModel paramSessionModel, String paramString) {
    StringBuilder stringBuilder1;
    String str1;
    StringBuilder stringBuilder2;
    SpannableStringBuilder spannableStringBuilder;
    StringBuilder stringBuilder3;
    paramView.setVisibility(8);
    String str2 = paramSessionModel.lastDraft;
    if (!TextUtils.isEmpty(str2)) {
      str1 = paramContext.getResources().getString(2131757969);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(str2);
      spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
      spannableStringBuilder.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131100538)), 0, str1.length(), 33);
      paramTextView.setText(StringUtils.a((CharSequence)spannableStringBuilder, (int)paramTextView.getTextSize(), 0));
      return;
    } 
    if (MsgType.getClassify(((SessionModel)spannableStringBuilder).lastMsgType) == 1 || ((SessionModel)spannableStringBuilder).lastMsgType == 8) {
      if (!TextUtils.isEmpty(((SessionModel)spannableStringBuilder).lastMsgContent)) {
        paramTextView.setText(((SessionModel)spannableStringBuilder).lastMsgContent);
        return;
      } 
      paramTextView.setText("");
      return;
    } 
    if (MsgType.getGroupOperationNotifyType(((SessionModel)spannableStringBuilder).lastMsgType) == 2) {
      if (!TextUtils.isEmpty(((SessionModel)spannableStringBuilder).lastMsgContent)) {
        paramTextView.setText(((SessionModel)spannableStringBuilder).lastMsgContent);
        return;
      } 
      paramTextView.setText("");
      return;
    } 
    if (((SessionModel)spannableStringBuilder).sessionType == 1 && ((SessionModel)spannableStringBuilder).sessionId == 5L) {
      if (!TextUtils.isEmpty(((SessionModel)spannableStringBuilder).lastMsgContent)) {
        if (!TextUtils.isEmpty(((SessionModel)spannableStringBuilder).lastMsgFromNickname)) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(((SessionModel)spannableStringBuilder).lastMsgFromNickname);
          stringBuilder1.append(": ");
          stringBuilder1.append(((SessionModel)spannableStringBuilder).lastMsgContent);
          paramTextView.setText(stringBuilder1.toString());
          return;
        } 
        paramTextView.setText(((SessionModel)spannableStringBuilder).lastMsgContent);
        return;
      } 
      paramTextView.setText("");
      return;
    } 
    short s = ((SessionModel)spannableStringBuilder).lastMsgType;
    if (s != 9 && s != 10) {
      if (s != 32) {
        if (s != 55) {
          if (s != 68) {
            String str;
            if (s != 164) {
              if (s != 169) {
                if (s != 205) {
                  if (s != 210 && s != 216) {
                    if (s != 52) {
                      if (s != 53) {
                        if (s != 73) {
                          if (s != 74) {
                            if (s != 98) {
                              if (s != 99) {
                                StringBuilder stringBuilder;
                                switch (s) {
                                  default:
                                    switch (s) {
                                      default:
                                        switch (s) {
                                          default:
                                            if (((SessionModel)spannableStringBuilder).lastMsgId == 0L) {
                                              paramTextView.setText("");
                                              break;
                                            } 
                                            if (((SessionModel)spannableStringBuilder).lastMsgFromApp != 2) {
                                              paramTextView.setText(stringBuilder1.getResources().getString(2131755608));
                                              break;
                                            } 
                                            paramTextView.setText(stringBuilder1.getResources().getString(2131757981));
                                            break;
                                          case 87:
                                          case 88:
                                          case 89:
                                          case 90:
                                            break;
                                        } 
                                        stringBuilder1 = new StringBuilder();
                                        stringBuilder1.append(a((View)str1, (SessionModel)spannableStringBuilder));
                                        stringBuilder1.append(paramString);
                                        stringBuilder1.append(((SessionModel)spannableStringBuilder).lastMsgContent);
                                        paramTextView.setText(stringBuilder1.toString());
                                        break;
                                      case 26:
                                        if (((SessionModel)spannableStringBuilder).lastMsgFromId == Long.valueOf(UserInfo.a().i().getUid()).longValue()) {
                                          StringBuilder stringBuilder4 = new StringBuilder();
                                          stringBuilder4.append(a((View)str1, (SessionModel)spannableStringBuilder));
                                          stringBuilder4.append(stringBuilder1.getResources().getText(2131755480));
                                          paramTextView.setText(stringBuilder4.toString());
                                          break;
                                        } 
                                        stringBuilder3 = new StringBuilder();
                                        stringBuilder3.append(a((View)str1, (SessionModel)spannableStringBuilder));
                                        stringBuilder3.append(stringBuilder1.getResources().getText(2131755481));
                                        paramTextView.setText(stringBuilder3.toString());
                                        break;
                                      case 25:
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append(a((View)str1, (SessionModel)spannableStringBuilder));
                                        stringBuilder.append((String)stringBuilder3);
                                        stringBuilder.append(stringBuilder1.getResources().getString(2131755605));
                                        paramTextView.setText(stringBuilder.toString());
                                        break;
                                      case 24:
                                        break;
                                    } 
                                  case 6:
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(a((View)str1, (SessionModel)spannableStringBuilder));
                                    stringBuilder.append((String)stringBuilder3);
                                    stringBuilder.append(stringBuilder1.getResources().getString(2131755601));
                                    paramTextView.setText(stringBuilder.toString());
                                    break;
                                  case 5:
                                  
                                  case 4:
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(a((View)str1, (SessionModel)spannableStringBuilder));
                                    stringBuilder.append((String)stringBuilder3);
                                    stringBuilder.append(stringBuilder1.getResources().getString(2131755604));
                                    paramTextView.setText(stringBuilder.toString());
                                    break;
                                  case 3:
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(a((View)str1, (SessionModel)spannableStringBuilder));
                                    stringBuilder.append((String)stringBuilder3);
                                    stringBuilder.append(stringBuilder1.getResources().getString(2131755599));
                                    paramTextView.setText(stringBuilder.toString());
                                    if (IMV4Method.a(((SessionModel)spannableStringBuilder).lastMsgFromId) == 1 && ((SessionModel)spannableStringBuilder).lastMsgStateCode != 5)
                                      paramTextView.setTextColor(stringBuilder1.getResources().getColor(2131100538)); 
                                    break;
                                  case 2:
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(a((View)str1, (SessionModel)spannableStringBuilder));
                                    stringBuilder.append((String)stringBuilder3);
                                    stringBuilder.append(stringBuilder1.getResources().getString(2131755603));
                                    paramTextView.setText(stringBuilder.toString());
                                    break;
                                  case 1:
                                    if (!TextUtils.isEmpty(((SessionModel)spannableStringBuilder).lastMsgContent)) {
                                      stringBuilder1 = new StringBuilder();
                                      stringBuilder1.append(a((View)str1, (SessionModel)spannableStringBuilder));
                                      stringBuilder1.append((String)stringBuilder3);
                                      stringBuilder1.append(((SessionModel)spannableStringBuilder).lastMsgContent);
                                      paramTextView.setText(StringUtils.a(StringUtils.a(stringBuilder1.toString(), false, true, true, ""), (int)paramTextView.getTextSize()));
                                      break;
                                    } 
                                    paramTextView.setText("");
                                    break;
                                } 
                              } else {
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("[");
                                stringBuilder2.append(stringBuilder1.getResources().getText(2131758089));
                                stringBuilder2.append("]");
                                paramTextView.setText(stringBuilder2.toString());
                                paramTextView.setTextColor(stringBuilder1.getResources().getColor(2131100540));
                              } 
                            } else {
                              stringBuilder2 = new StringBuilder();
                              stringBuilder2.append("[");
                              stringBuilder2.append(stringBuilder1.getResources().getText(2131758088));
                              stringBuilder2.append("]");
                              paramTextView.setText(stringBuilder2.toString());
                              paramTextView.setTextColor(stringBuilder1.getResources().getColor(2131100540));
                            } 
                          } else {
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(a((View)stringBuilder2, (SessionModel)spannableStringBuilder));
                            stringBuilder3.append(stringBuilder1.getResources().getText(2131758081));
                            paramTextView.setText(stringBuilder3.toString());
                          } 
                        } else {
                          stringBuilder3 = new StringBuilder();
                          stringBuilder3.append(a((View)stringBuilder2, (SessionModel)spannableStringBuilder));
                          stringBuilder3.append(stringBuilder1.getResources().getText(2131758014));
                          paramTextView.setText(stringBuilder3.toString());
                        } 
                      } else {
                        b((Context)stringBuilder1, (SessionModel)spannableStringBuilder, paramTextView, (View)stringBuilder2);
                      } 
                    } else {
                      a((Context)stringBuilder1, (SessionModel)spannableStringBuilder, paramTextView, (View)stringBuilder2);
                    } 
                  } else {
                    paramTextView.setText(((SessionModel)spannableStringBuilder).lastMsgContent);
                  } 
                } else {
                  paramString = "[表情]";
                  str = paramString;
                  try {
                  
                  } finally {
                    str = null;
                  } 
                  paramTextView.setText(str);
                } 
              } else {
                paramTextView.setText((CharSequence)Html.fromHtml(((SessionModel)spannableStringBuilder).lastMsgContent));
              } 
            } else {
              stringBuilder3 = new StringBuilder();
              stringBuilder3.append(a((View)stringBuilder2, (SessionModel)spannableStringBuilder));
              stringBuilder3.append(a((SessionModel)spannableStringBuilder, (Context)str));
              paramTextView.setText(stringBuilder3.toString());
            } 
          } else if (!TextUtils.isEmpty(((SessionModel)spannableStringBuilder).lastMsgContent)) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append(a((View)stringBuilder2, (SessionModel)spannableStringBuilder));
            stringBuilder1.append(((SessionModel)spannableStringBuilder).lastMsgContent);
            paramTextView.setText(StringUtils.a(stringBuilder1.toString(), false, true, true, ""));
          } else {
            paramTextView.setText("");
          } 
        } else {
          boolean bool2 = false;
          boolean bool1 = bool2;
          if (!TextUtils.isEmpty(UserInfo.a().i().getUid())) {
            long l = -1L;
            try {
              long l1 = Long.valueOf(UserInfo.a().i().getUid()).longValue();
              l = l1;
            } catch (Exception exception) {}
            bool1 = bool2;
            if (((SessionModel)spannableStringBuilder).lastMsgFromId == l)
              bool1 = true; 
          } 
          MessageChatMethod.a(bool1, ((SessionModel)spannableStringBuilder).sessionType, ((SessionModel)spannableStringBuilder).lastMsgStateCode, paramTextView, ((SessionModel)spannableStringBuilder).lastMsgFromNickname);
        } 
      } else {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(a((View)stringBuilder2, (SessionModel)spannableStringBuilder));
        stringBuilder1.append((String)stringBuilder3);
        stringBuilder1.append(((SessionModel)spannableStringBuilder).lastMsgContent);
        paramTextView.setText(stringBuilder1.toString());
      } 
    } else {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(a((View)stringBuilder2, (SessionModel)spannableStringBuilder));
      stringBuilder1.append((String)stringBuilder3);
      stringBuilder1.append(((SessionModel)spannableStringBuilder).lastMsgContent);
      paramTextView.setText(stringBuilder1.toString());
    } 
    if (((SessionModel)spannableStringBuilder).sessionType == 6668) {
      if (((SessionModel)spannableStringBuilder).lastMsgFromId != 0L) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(((SessionModel)spannableStringBuilder).lastMsgFromNickname);
        stringBuilder1.append(": ");
        stringBuilder1.append(paramTextView.getText());
        paramTextView.setText(stringBuilder1.toString());
        return;
      } 
      paramTextView.setText(((SessionModel)spannableStringBuilder).lastMsgContent);
      return;
    } 
  }
  
  private static void a(Context paramContext, SessionModel paramSessionModel, TextView paramTextView, View paramView) {
    VideoChatMsgContentModel videoChatMsgContentModel = (VideoChatMsgContentModel)AppInfo.f().fromJson(paramSessionModel.lastMsgContent, VideoChatMsgContentModel.class);
    if (videoChatMsgContentModel != null) {
      String str;
      ImageSpan imageSpan;
      if (videoChatMsgContentModel.room_type == 2) {
        String str1 = paramContext.getResources().getString(2131758021);
        Drawable drawable = paramContext.getResources().getDrawable(2131232608);
        drawable.setBounds(0, DensityUtils.a(paramContext, 3.0F), DensityUtils.a(paramContext, 17.0F), DensityUtils.a(paramContext, 17.0F));
        ImageSpan imageSpan1 = new ImageSpan(drawable, 1);
        str = str1;
        imageSpan = imageSpan1;
      } else if (((VideoChatMsgContentModel)imageSpan).room_type == 1) {
        String str1 = str.getResources().getString(2131758020);
        Drawable drawable = str.getResources().getDrawable(2131232607);
        drawable.setBounds(0, DensityUtils.a((Context)str, 3.0F), DensityUtils.a((Context)str, 17.0F), DensityUtils.a((Context)str, 17.0F));
        ImageSpan imageSpan2 = new ImageSpan(drawable, 1);
        str = str1;
        ImageSpan imageSpan1 = imageSpan2;
      } else {
        str = "";
        imageSpan = null;
      } 
      SpannableString spannableString = new SpannableString(str);
      spannableString.setSpan(imageSpan, 2, 3, 17);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a(paramView, paramSessionModel));
      stringBuilder.append(spannableString);
      paramTextView.setText(stringBuilder.toString());
      paramTextView.setTextColor(Color.parseColor("#9CD225"));
    } 
  }
  
  private void a(ImageView paramImageView, int paramInt1, int paramInt2) {
    if (paramInt2 == 1 || !BluedConfig.b().H()) {
      paramImageView.setVisibility(8);
      return;
    } 
    MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.forNumber(paramInt1);
    paramImageView.setVisibility(0);
    paramInt1 = null.a[strangerSource.ordinal()];
    if (paramInt1 != 1 && paramInt1 != 2 && paramInt1 != 3 && paramInt1 != 4) {
      if (paramInt1 != 5) {
        paramImageView.setVisibility(8);
        return;
      } 
      paramImageView.setImageDrawable(BluedSkinUtils.b(paramImageView.getContext(), 2131232508));
      return;
    } 
    paramImageView.setImageDrawable(BluedSkinUtils.b(paramImageView.getContext(), 2131232507));
  }
  
  private void a(SessionModel paramSessionModel, SessionSettingModel paramSessionSettingModel, TextView paramTextView) {
    String str1;
    String str2;
    String str4 = paramSessionModel.nickName;
    String str3 = "";
    if (paramSessionSettingModel != null) {
      str2 = paramSessionSettingModel.getSessinoNote();
    } else {
      str2 = "";
    } 
    if (!TextUtils.isEmpty(str2)) {
      paramTextView.setText(str2);
      return;
    } 
    if (!TextUtils.isEmpty(str4)) {
      paramTextView.setText(str4);
      return;
    } 
    if (paramSessionModel.sessionType == 3) {
      str1 = str3;
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((SessionModel)str1).sessionId);
      stringBuilder.append("");
      str1 = stringBuilder.toString();
    } 
    paramTextView.setText(str1);
  }
  
  private void a(SessionModel paramSessionModel, SessionSettingModel paramSessionSettingModel, ViewHolder paramViewHolder) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 5
    //   4: return
    //   5: aload_1
    //   6: getfield sessionType : S
    //   9: istore #4
    //   11: iconst_1
    //   12: istore #5
    //   14: iload #4
    //   16: iconst_3
    //   17: if_icmpne -> 101
    //   20: aload_1
    //   21: getfield lastMsgFromId : J
    //   24: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
    //   27: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   30: invokevirtual getUid : ()Ljava/lang/String;
    //   33: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   36: invokevirtual longValue : ()J
    //   39: lcmp
    //   40: ifeq -> 101
    //   43: aload_1
    //   44: getfield lastMsgType : S
    //   47: invokestatic getClassify : (S)I
    //   50: iconst_1
    //   51: if_icmpeq -> 101
    //   54: new java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial <init> : ()V
    //   61: astore #6
    //   63: aload #6
    //   65: aload_1
    //   66: getfield lastMsgFromNickname : Ljava/lang/String;
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #6
    //   75: ldc_w ': '
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload #6
    //   84: invokevirtual toString : ()Ljava/lang/String;
    //   87: astore #7
    //   89: aload #7
    //   91: astore #6
    //   93: aload #7
    //   95: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   98: ifeq -> 105
    //   101: ldc ''
    //   103: astore #6
    //   105: aload_3
    //   106: getfield f : Landroid/widget/TextView;
    //   109: aload_0
    //   110: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   113: invokeinterface getContext : ()Landroid/content/Context;
    //   118: ldc_w 2131100844
    //   121: invokestatic a : (Landroid/content/Context;I)I
    //   124: invokevirtual setTextColor : (I)V
    //   127: aload_0
    //   128: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   131: invokeinterface getContext : ()Landroid/content/Context;
    //   136: aload_3
    //   137: getfield d : Landroid/view/View;
    //   140: aload_3
    //   141: getfield f : Landroid/widget/TextView;
    //   144: aload_1
    //   145: aload #6
    //   147: invokestatic a : (Landroid/content/Context;Landroid/view/View;Landroid/widget/TextView;Lcom/blued/android/chat/model/SessionModel;Ljava/lang/String;)V
    //   150: aload_1
    //   151: getfield lastMsgTime : J
    //   154: lconst_0
    //   155: lcmp
    //   156: ifeq -> 197
    //   159: aload_1
    //   160: getfield lastMsgFromId : J
    //   163: lconst_0
    //   164: lcmp
    //   165: ifne -> 171
    //   168: goto -> 197
    //   171: aload_3
    //   172: getfield h : Landroid/widget/TextView;
    //   175: aload_0
    //   176: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   179: invokeinterface getContext : ()Landroid/content/Context;
    //   184: aload_1
    //   185: getfield lastMsgTime : J
    //   188: invokestatic a : (Landroid/content/Context;J)Ljava/lang/String;
    //   191: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   194: goto -> 206
    //   197: aload_3
    //   198: getfield h : Landroid/widget/TextView;
    //   201: ldc ''
    //   203: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   206: aload_2
    //   207: ifnull -> 238
    //   210: aload_1
    //   211: getfield atMessageId : J
    //   214: aload_1
    //   215: getfield lastMsgId : J
    //   218: lcmp
    //   219: ifne -> 225
    //   222: goto -> 228
    //   225: iconst_0
    //   226: istore #5
    //   228: aload_0
    //   229: aload_2
    //   230: iload #5
    //   232: invokevirtual a : (Lcom/soft/blued/db/model/SessionSettingModel;Z)Z
    //   235: ifne -> 248
    //   238: aload_0
    //   239: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   242: instanceof com/soft/blued/ui/msg/MsgBoxFragment
    //   245: ifeq -> 257
    //   248: aload_3
    //   249: getfield k : Landroid/view/View;
    //   252: iconst_0
    //   253: invokevirtual setVisibility : (I)V
    //   256: return
    //   257: aload_3
    //   258: getfield k : Landroid/view/View;
    //   261: bipush #8
    //   263: invokevirtual setVisibility : (I)V
    //   266: return
  }
  
  private static void b(Context paramContext, SessionModel paramSessionModel, TextView paramTextView, View paramView) {
    try {
      VideoChatMsgContentModel videoChatMsgContentModel = (VideoChatMsgContentModel)AppInfo.f().fromJson(paramSessionModel.lastMsgContent, VideoChatMsgContentModel.class);
      String str = "";
      if (videoChatMsgContentModel != null) {
        if (videoChatMsgContentModel.room_type == 2) {
          str = paramContext.getResources().getString(2131755793);
        } else if (videoChatMsgContentModel.room_type == 1) {
          str = paramContext.getResources().getString(2131755794);
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a(paramView, paramSessionModel));
        stringBuilder.append("[");
        stringBuilder.append(str);
        stringBuilder.append("]");
        paramTextView.setText(stringBuilder.toString());
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Ljava/util/List;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore_1
    //   12: aload_1
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 65
    //   21: aload_1
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast com/soft/blued/ui/msg/adapter/ChatFriendListAdapter$ViewHolder
    //   30: astore_2
    //   31: aload_2
    //   32: getfield e : Lcom/blued/android/framework/view/badgeview/QBadgeContainer;
    //   35: invokevirtual getBadgeText : ()Ljava/lang/String;
    //   38: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   41: ifne -> 12
    //   44: aload_2
    //   45: getfield b : Landroid/view/View;
    //   48: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   51: ifnull -> 12
    //   54: aload_2
    //   55: getfield e : Lcom/blued/android/framework/view/badgeview/QBadgeContainer;
    //   58: iconst_1
    //   59: invokevirtual b : (Z)V
    //   62: goto -> 12
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	68	finally
    //   12	62	68	finally
  }
  
  public void a(List<SessionModel> paramList, boolean paramBoolean) {
    this.g = paramList;
    this.f = paramBoolean;
  }
  
  public boolean a(SessionSettingModel paramSessionSettingModel, boolean paramBoolean) {
    if (paramSessionSettingModel != null) {
      if (paramSessionSettingModel.getSessionType() == 2 && paramSessionSettingModel.getRemindAudio() == 1)
        return true; 
      if (paramSessionSettingModel.getSessionType() == 3 && GroupUtil.a(paramSessionSettingModel.getRemindAudio()))
        return true; 
    } 
    return false;
  }
  
  public int getCount() {
    boolean bool;
    List<SessionModel> list = this.g;
    if (list != null) {
      int i = list.size();
      bool = i;
      if (this.f) {
        bool = i;
        if (i > 0)
          return i + 1; 
      } 
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Object getItem(int paramInt) {
    List<SessionModel> list = this.g;
    return (list != null && list.size() > paramInt) ? this.g.get(paramInt) : null;
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    // Byte code:
    //   0: aload_2
    //   1: astore #8
    //   3: aload_0
    //   4: getfield f : Z
    //   7: ifeq -> 46
    //   10: iload_1
    //   11: aload_0
    //   12: invokevirtual getCount : ()I
    //   15: iconst_1
    //   16: isub
    //   17: if_icmpne -> 46
    //   20: aload_0
    //   21: getfield b : Landroid/view/LayoutInflater;
    //   24: ldc_w 2131493600
    //   27: aload_3
    //   28: iconst_0
    //   29: invokevirtual inflate : (ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   32: astore_2
    //   33: aload_2
    //   34: ldc_w 2131301686
    //   37: iconst_1
    //   38: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   41: invokevirtual setTag : (ILjava/lang/Object;)V
    //   44: aload_2
    //   45: areturn
    //   46: aload #8
    //   48: ifnull -> 98
    //   51: aload #8
    //   53: ldc_w 2131301686
    //   56: invokevirtual getTag : (I)Ljava/lang/Object;
    //   59: checkcast java/lang/Integer
    //   62: invokevirtual intValue : ()I
    //   65: ifne -> 82
    //   68: aload_2
    //   69: invokevirtual getTag : ()Ljava/lang/Object;
    //   72: checkcast com/soft/blued/ui/msg/adapter/ChatFriendListAdapter$ViewHolder
    //   75: astore_2
    //   76: aload #8
    //   78: astore_3
    //   79: goto -> 113
    //   82: aload_0
    //   83: getfield b : Landroid/view/LayoutInflater;
    //   86: ldc_w 2131493601
    //   89: aload_3
    //   90: iconst_0
    //   91: invokevirtual inflate : (ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   94: astore_3
    //   95: goto -> 111
    //   98: aload_0
    //   99: getfield b : Landroid/view/LayoutInflater;
    //   102: ldc_w 2131493601
    //   105: aload_3
    //   106: iconst_0
    //   107: invokevirtual inflate : (ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   110: astore_3
    //   111: aconst_null
    //   112: astore_2
    //   113: aload_2
    //   114: astore #8
    //   116: aload_2
    //   117: ifnonnull -> 479
    //   120: new com/soft/blued/ui/msg/adapter/ChatFriendListAdapter$ViewHolder
    //   123: dup
    //   124: aload_0
    //   125: aconst_null
    //   126: invokespecial <init> : (Lcom/soft/blued/ui/msg/adapter/ChatFriendListAdapter;Lcom/soft/blued/ui/msg/adapter/ChatFriendListAdapter$1;)V
    //   129: astore #8
    //   131: aload #8
    //   133: aload_3
    //   134: putfield b : Landroid/view/View;
    //   137: aload #8
    //   139: aload_3
    //   140: ldc_w 2131299261
    //   143: invokevirtual findViewById : (I)Landroid/view/View;
    //   146: checkcast android/widget/ImageView
    //   149: putfield i : Landroid/widget/ImageView;
    //   152: aload #8
    //   154: aload_3
    //   155: ldc_w 2131299262
    //   158: invokevirtual findViewById : (I)Landroid/view/View;
    //   161: checkcast android/widget/ImageView
    //   164: putfield j : Landroid/widget/ImageView;
    //   167: aload #8
    //   169: aload_3
    //   170: ldc_w 2131299264
    //   173: invokevirtual findViewById : (I)Landroid/view/View;
    //   176: checkcast android/widget/ImageView
    //   179: putfield a : Landroid/widget/ImageView;
    //   182: aload #8
    //   184: aload_3
    //   185: ldc_w 2131300828
    //   188: invokevirtual findViewById : (I)Landroid/view/View;
    //   191: checkcast android/widget/TextView
    //   194: putfield l : Landroid/widget/TextView;
    //   197: aload #8
    //   199: aload_3
    //   200: ldc_w 2131300844
    //   203: invokevirtual findViewById : (I)Landroid/view/View;
    //   206: checkcast android/widget/TextView
    //   209: putfield m : Landroid/widget/TextView;
    //   212: aload #8
    //   214: aload_3
    //   215: ldc_w 2131299265
    //   218: invokevirtual findViewById : (I)Landroid/view/View;
    //   221: checkcast android/widget/TextView
    //   224: putfield c : Landroid/widget/TextView;
    //   227: aload #8
    //   229: aload_3
    //   230: ldc_w 2131298023
    //   233: invokevirtual findViewById : (I)Landroid/view/View;
    //   236: putfield d : Landroid/view/View;
    //   239: aload #8
    //   241: aload_3
    //   242: ldc_w 2131299263
    //   245: invokevirtual findViewById : (I)Landroid/view/View;
    //   248: checkcast android/widget/TextView
    //   251: putfield f : Landroid/widget/TextView;
    //   254: aload #8
    //   256: aload_3
    //   257: ldc_w 2131296534
    //   260: invokevirtual findViewById : (I)Landroid/view/View;
    //   263: putfield r : Landroid/view/View;
    //   266: aload #8
    //   268: aload_3
    //   269: ldc_w 2131299260
    //   272: invokevirtual findViewById : (I)Landroid/view/View;
    //   275: checkcast com/blued/android/framework/view/badgeview/QBadgeContainer
    //   278: putfield e : Lcom/blued/android/framework/view/badgeview/QBadgeContainer;
    //   281: aload #8
    //   283: getfield e : Lcom/blued/android/framework/view/badgeview/QBadgeContainer;
    //   286: aload #8
    //   288: getfield r : Landroid/view/View;
    //   291: invokevirtual a : (Landroid/view/View;)V
    //   294: aload #8
    //   296: getfield e : Lcom/blued/android/framework/view/badgeview/QBadgeContainer;
    //   299: bipush #17
    //   301: invokevirtual d : (I)Lcom/blued/android/framework/view/badgeview/Badge;
    //   304: pop
    //   305: aload #8
    //   307: getfield e : Lcom/blued/android/framework/view/badgeview/QBadgeContainer;
    //   310: ldc_w 5.0
    //   313: iconst_1
    //   314: invokevirtual b : (FZ)Lcom/blued/android/framework/view/badgeview/Badge;
    //   317: pop
    //   318: aload #8
    //   320: aload_3
    //   321: ldc_w 2131299266
    //   324: invokevirtual findViewById : (I)Landroid/view/View;
    //   327: checkcast android/widget/ImageView
    //   330: putfield g : Landroid/widget/ImageView;
    //   333: aload #8
    //   335: aload_3
    //   336: ldc_w 2131299270
    //   339: invokevirtual findViewById : (I)Landroid/view/View;
    //   342: putfield k : Landroid/view/View;
    //   345: aload #8
    //   347: aload_3
    //   348: ldc_w 2131299267
    //   351: invokevirtual findViewById : (I)Landroid/view/View;
    //   354: checkcast android/widget/TextView
    //   357: putfield h : Landroid/widget/TextView;
    //   360: aload #8
    //   362: aload_3
    //   363: ldc_w 2131297581
    //   366: invokevirtual findViewById : (I)Landroid/view/View;
    //   369: checkcast android/widget/ImageView
    //   372: putfield n : Landroid/widget/ImageView;
    //   375: aload #8
    //   377: aload_3
    //   378: ldc_w 2131297823
    //   381: invokevirtual findViewById : (I)Landroid/view/View;
    //   384: checkcast android/widget/ImageView
    //   387: putfield o : Landroid/widget/ImageView;
    //   390: aload #8
    //   392: aload_3
    //   393: ldc_w 2131300800
    //   396: invokevirtual findViewById : (I)Landroid/view/View;
    //   399: checkcast android/widget/TextView
    //   402: putfield q : Landroid/widget/TextView;
    //   405: aload #8
    //   407: aload_3
    //   408: ldc_w 2131297193
    //   411: invokevirtual findViewById : (I)Landroid/view/View;
    //   414: checkcast com/blued/android/framework/view/shape/ShapeFrameLayout
    //   417: putfield p : Lcom/blued/android/framework/view/shape/ShapeFrameLayout;
    //   420: aload #8
    //   422: aload_3
    //   423: ldc_w 2131297919
    //   426: invokevirtual findViewById : (I)Landroid/view/View;
    //   429: checkcast android/widget/ImageView
    //   432: putfield s : Landroid/widget/ImageView;
    //   435: aload #8
    //   437: aload_3
    //   438: ldc_w 2131300531
    //   441: invokevirtual findViewById : (I)Landroid/view/View;
    //   444: checkcast android/widget/TextView
    //   447: putfield t : Landroid/widget/TextView;
    //   450: aload_0
    //   451: getfield e : Ljava/util/List;
    //   454: aload #8
    //   456: invokeinterface add : (Ljava/lang/Object;)Z
    //   461: pop
    //   462: aload_3
    //   463: ldc_w 2131301686
    //   466: iconst_0
    //   467: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   470: invokevirtual setTag : (ILjava/lang/Object;)V
    //   473: aload_3
    //   474: aload #8
    //   476: invokevirtual setTag : (Ljava/lang/Object;)V
    //   479: aload_0
    //   480: iload_1
    //   481: invokevirtual getItem : (I)Ljava/lang/Object;
    //   484: checkcast com/blued/android/chat/model/SessionModel
    //   487: astore #9
    //   489: aload #9
    //   491: ifnonnull -> 496
    //   494: aload_3
    //   495: areturn
    //   496: aload #9
    //   498: getfield lieTop : I
    //   501: iconst_1
    //   502: if_icmpeq -> 545
    //   505: aload #9
    //   507: getfield expireTime : J
    //   510: lconst_0
    //   511: lcmp
    //   512: ifeq -> 518
    //   515: goto -> 545
    //   518: aload #8
    //   520: getfield o : Landroid/widget/ImageView;
    //   523: bipush #8
    //   525: invokevirtual setVisibility : (I)V
    //   528: aload_3
    //   529: aload_3
    //   530: invokevirtual getContext : ()Landroid/content/Context;
    //   533: ldc_w 2131233702
    //   536: invokestatic b : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   539: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
    //   542: goto -> 568
    //   545: aload #8
    //   547: getfield o : Landroid/widget/ImageView;
    //   550: iconst_0
    //   551: invokevirtual setVisibility : (I)V
    //   554: aload_3
    //   555: aload_3
    //   556: invokevirtual getContext : ()Landroid/content/Context;
    //   559: ldc_w 2131100881
    //   562: invokestatic a : (Landroid/content/Context;I)I
    //   565: invokevirtual setBackgroundColor : (I)V
    //   568: aload #9
    //   570: getfield sessionSettingModel : Lcom/blued/android/chat/model/SessionSettingBaseModel;
    //   573: checkcast com/soft/blued/db/model/SessionSettingModel
    //   576: astore #10
    //   578: aload #9
    //   580: getfield noReadMsgCount : I
    //   583: bipush #99
    //   585: invokestatic min : (II)I
    //   588: istore_1
    //   589: aload #10
    //   591: ifnull -> 628
    //   594: aload #9
    //   596: getfield atMessageId : J
    //   599: aload #9
    //   601: getfield lastMsgId : J
    //   604: lcmp
    //   605: ifne -> 614
    //   608: iconst_1
    //   609: istore #5
    //   611: goto -> 617
    //   614: iconst_0
    //   615: istore #5
    //   617: aload_0
    //   618: aload #10
    //   620: iload #5
    //   622: invokevirtual a : (Lcom/soft/blued/db/model/SessionSettingModel;Z)Z
    //   625: ifne -> 682
    //   628: aload_0
    //   629: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   632: instanceof com/soft/blued/ui/msg/MsgBoxFragment
    //   635: ifne -> 682
    //   638: aload #9
    //   640: getfield sessionType : S
    //   643: sipush #6668
    //   646: if_icmpne -> 652
    //   649: goto -> 682
    //   652: aload #8
    //   654: getfield e : Lcom/blued/android/framework/view/badgeview/QBadgeContainer;
    //   657: aload_0
    //   658: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   661: invokeinterface getContext : ()Landroid/content/Context;
    //   666: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   669: ldc_w 2131100837
    //   672: invokevirtual getColor : (I)I
    //   675: invokevirtual b : (I)Lcom/blued/android/framework/view/badgeview/Badge;
    //   678: pop
    //   679: goto -> 709
    //   682: aload #8
    //   684: getfield e : Lcom/blued/android/framework/view/badgeview/QBadgeContainer;
    //   687: aload_0
    //   688: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   691: invokeinterface getContext : ()Landroid/content/Context;
    //   696: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   699: ldc_w 2131099757
    //   702: invokevirtual getColor : (I)I
    //   705: invokevirtual b : (I)Lcom/blued/android/framework/view/badgeview/Badge;
    //   708: pop
    //   709: aload #8
    //   711: getfield e : Lcom/blued/android/framework/view/badgeview/QBadgeContainer;
    //   714: iload_1
    //   715: invokevirtual a : (I)Lcom/blued/android/framework/view/badgeview/Badge;
    //   718: pop
    //   719: aload #9
    //   721: getfield secretLookStatus : I
    //   724: iconst_1
    //   725: if_icmpne -> 750
    //   728: aload #8
    //   730: getfield s : Landroid/widget/ImageView;
    //   733: iconst_0
    //   734: invokevirtual setVisibility : (I)V
    //   737: aload #8
    //   739: getfield e : Lcom/blued/android/framework/view/badgeview/QBadgeContainer;
    //   742: bipush #8
    //   744: invokevirtual setVisibility : (I)V
    //   747: goto -> 769
    //   750: aload #8
    //   752: getfield s : Landroid/widget/ImageView;
    //   755: bipush #8
    //   757: invokevirtual setVisibility : (I)V
    //   760: aload #8
    //   762: getfield e : Lcom/blued/android/framework/view/badgeview/QBadgeContainer;
    //   765: iconst_0
    //   766: invokevirtual setVisibility : (I)V
    //   769: aload #9
    //   771: getfield sessionId : J
    //   774: lstore #6
    //   776: aload #9
    //   778: getfield sessionType : S
    //   781: istore_1
    //   782: aload #9
    //   784: getfield lastDraft : Ljava/lang/String;
    //   787: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   790: ifeq -> 927
    //   793: aload #9
    //   795: getfield lastMsgType : S
    //   798: bipush #52
    //   800: if_icmpeq -> 927
    //   803: aload #9
    //   805: getfield lastMsgType : S
    //   808: bipush #68
    //   810: if_icmpne -> 816
    //   813: goto -> 927
    //   816: aload #9
    //   818: getfield lastMsgStateCode : S
    //   821: bipush #7
    //   823: if_icmpne -> 849
    //   826: aload #8
    //   828: getfield g : Landroid/widget/ImageView;
    //   831: ldc_w 2131232601
    //   834: invokevirtual setImageResource : (I)V
    //   837: aload #8
    //   839: getfield g : Landroid/widget/ImageView;
    //   842: iconst_0
    //   843: invokevirtual setVisibility : (I)V
    //   846: goto -> 937
    //   849: aload #9
    //   851: getfield lastMsgStateCode : S
    //   854: iconst_1
    //   855: if_icmpne -> 881
    //   858: aload #8
    //   860: getfield g : Landroid/widget/ImageView;
    //   863: ldc_w 2131232613
    //   866: invokevirtual setImageResource : (I)V
    //   869: aload #8
    //   871: getfield g : Landroid/widget/ImageView;
    //   874: iconst_0
    //   875: invokevirtual setVisibility : (I)V
    //   878: goto -> 937
    //   881: aload #9
    //   883: getfield lastMsgStateCode : S
    //   886: bipush #6
    //   888: if_icmpne -> 914
    //   891: aload #8
    //   893: getfield g : Landroid/widget/ImageView;
    //   896: ldc_w 2131232602
    //   899: invokevirtual setImageResource : (I)V
    //   902: aload #8
    //   904: getfield g : Landroid/widget/ImageView;
    //   907: iconst_0
    //   908: invokevirtual setVisibility : (I)V
    //   911: goto -> 937
    //   914: aload #8
    //   916: getfield g : Landroid/widget/ImageView;
    //   919: bipush #8
    //   921: invokevirtual setVisibility : (I)V
    //   924: goto -> 937
    //   927: aload #8
    //   929: getfield g : Landroid/widget/ImageView;
    //   932: bipush #8
    //   934: invokevirtual setVisibility : (I)V
    //   937: aload #8
    //   939: getfield a : Landroid/widget/ImageView;
    //   942: bipush #8
    //   944: invokevirtual setVisibility : (I)V
    //   947: aload #8
    //   949: getfield c : Landroid/widget/TextView;
    //   952: aload_0
    //   953: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   956: invokeinterface getContext : ()Landroid/content/Context;
    //   961: ldc_w 120.0
    //   964: invokestatic a : (Landroid/content/Context;F)I
    //   967: invokevirtual setMaxWidth : (I)V
    //   970: aload #8
    //   972: getfield t : Landroid/widget/TextView;
    //   975: bipush #8
    //   977: invokevirtual setVisibility : (I)V
    //   980: aload #9
    //   982: getfield sessionType : S
    //   985: istore_1
    //   986: iload_1
    //   987: iconst_1
    //   988: if_icmpeq -> 1584
    //   991: iload_1
    //   992: iconst_2
    //   993: if_icmpeq -> 1411
    //   996: iload_1
    //   997: iconst_3
    //   998: if_icmpeq -> 1228
    //   1001: iload_1
    //   1002: sipush #6668
    //   1005: if_icmpeq -> 1084
    //   1008: aload #8
    //   1010: getfield i : Landroid/widget/ImageView;
    //   1013: aconst_null
    //   1014: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   1017: aload #8
    //   1019: getfield l : Landroid/widget/TextView;
    //   1022: bipush #8
    //   1024: invokevirtual setVisibility : (I)V
    //   1027: aload #8
    //   1029: getfield c : Landroid/widget/TextView;
    //   1032: ldc ''
    //   1034: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   1037: aload #8
    //   1039: getfield j : Landroid/widget/ImageView;
    //   1042: bipush #8
    //   1044: invokevirtual setVisibility : (I)V
    //   1047: aload #8
    //   1049: getfield n : Landroid/widget/ImageView;
    //   1052: bipush #8
    //   1054: invokevirtual setVisibility : (I)V
    //   1057: aload_0
    //   1058: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   1061: invokeinterface getContext : ()Landroid/content/Context;
    //   1066: aload #8
    //   1068: getfield c : Landroid/widget/TextView;
    //   1071: new com/soft/blued/ui/find/model/UserBasicModel
    //   1074: dup
    //   1075: invokespecial <init> : ()V
    //   1078: invokestatic a : (Landroid/content/Context;Landroid/widget/TextView;Lcom/soft/blued/ui/find/model/UserBasicModel;)V
    //   1081: goto -> 1853
    //   1084: aload #8
    //   1086: getfield c : Landroid/widget/TextView;
    //   1089: aload_0
    //   1090: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   1093: invokeinterface getContext : ()Landroid/content/Context;
    //   1098: ldc_w 200.0
    //   1101: invokestatic a : (Landroid/content/Context;F)I
    //   1104: invokevirtual setMaxWidth : (I)V
    //   1107: aload_0
    //   1108: getfield h : Lcom/blued/android/core/net/IRequestHost;
    //   1111: ldc_w 2131232596
    //   1114: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;I)Lcom/blued/android/core/image/ImageWrapper;
    //   1117: ldc_w 2131232596
    //   1120: invokevirtual a : (I)Lcom/blued/android/core/image/ImageWrapper;
    //   1123: invokevirtual c : ()Lcom/blued/android/core/image/ImageWrapper;
    //   1126: aload #8
    //   1128: getfield i : Landroid/widget/ImageView;
    //   1131: invokevirtual a : (Landroid/widget/ImageView;)V
    //   1134: aload #8
    //   1136: getfield l : Landroid/widget/TextView;
    //   1139: bipush #8
    //   1141: invokevirtual setVisibility : (I)V
    //   1144: aload #8
    //   1146: getfield c : Landroid/widget/TextView;
    //   1149: aload_0
    //   1150: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   1153: invokeinterface getContext : ()Landroid/content/Context;
    //   1158: ldc_w 2131758024
    //   1161: invokevirtual getString : (I)Ljava/lang/String;
    //   1164: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   1167: aload #8
    //   1169: getfield j : Landroid/widget/ImageView;
    //   1172: iconst_4
    //   1173: invokevirtual setVisibility : (I)V
    //   1176: aload #8
    //   1178: getfield m : Landroid/widget/TextView;
    //   1181: bipush #8
    //   1183: invokevirtual setVisibility : (I)V
    //   1186: aload #8
    //   1188: getfield n : Landroid/widget/ImageView;
    //   1191: new com/soft/blued/ui/find/model/UserBasicModel
    //   1194: dup
    //   1195: invokespecial <init> : ()V
    //   1198: invokestatic a : (Landroid/widget/ImageView;Lcom/soft/blued/ui/find/model/UserBasicModel;)V
    //   1201: aload_0
    //   1202: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   1205: invokeinterface getContext : ()Landroid/content/Context;
    //   1210: aload #8
    //   1212: getfield c : Landroid/widget/TextView;
    //   1215: new com/soft/blued/ui/find/model/UserBasicModel
    //   1218: dup
    //   1219: invokespecial <init> : ()V
    //   1222: invokestatic a : (Landroid/content/Context;Landroid/widget/TextView;Lcom/soft/blued/ui/find/model/UserBasicModel;)V
    //   1225: goto -> 1853
    //   1228: aload #9
    //   1230: getfield atMessageId : J
    //   1233: lconst_0
    //   1234: lcmp
    //   1235: ifeq -> 1247
    //   1238: aload #8
    //   1240: getfield t : Landroid/widget/TextView;
    //   1243: iconst_0
    //   1244: invokevirtual setVisibility : (I)V
    //   1247: aload_0
    //   1248: getfield h : Lcom/blued/android/core/net/IRequestHost;
    //   1251: aload #9
    //   1253: getfield avatar : Ljava/lang/String;
    //   1256: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
    //   1259: ldc_w 2131232322
    //   1262: invokevirtual a : (I)Lcom/blued/android/core/image/ImageWrapper;
    //   1265: invokevirtual c : ()Lcom/blued/android/core/image/ImageWrapper;
    //   1268: aload #8
    //   1270: getfield i : Landroid/widget/ImageView;
    //   1273: invokevirtual a : (Landroid/widget/ImageView;)V
    //   1276: aload #9
    //   1278: getfield sessionStatus : I
    //   1281: iconst_1
    //   1282: if_icmpne -> 1298
    //   1285: aload #8
    //   1287: getfield l : Landroid/widget/TextView;
    //   1290: bipush #8
    //   1292: invokevirtual setVisibility : (I)V
    //   1295: goto -> 1325
    //   1298: aload #9
    //   1300: getfield sessionStatus : I
    //   1303: ifne -> 1325
    //   1306: aload #8
    //   1308: getfield l : Landroid/widget/TextView;
    //   1311: iconst_0
    //   1312: invokevirtual setVisibility : (I)V
    //   1315: aload #8
    //   1317: getfield m : Landroid/widget/TextView;
    //   1320: bipush #8
    //   1322: invokevirtual setVisibility : (I)V
    //   1325: aload #9
    //   1327: getfield lastMsgType : S
    //   1330: invokestatic getGroupOperationNotifyType : (S)I
    //   1333: iconst_2
    //   1334: if_icmpne -> 1347
    //   1337: aload #8
    //   1339: getfield g : Landroid/widget/ImageView;
    //   1342: bipush #8
    //   1344: invokevirtual setVisibility : (I)V
    //   1347: aload_0
    //   1348: aload #9
    //   1350: aload #10
    //   1352: aload #8
    //   1354: getfield c : Landroid/widget/TextView;
    //   1357: invokespecial a : (Lcom/blued/android/chat/model/SessionModel;Lcom/soft/blued/db/model/SessionSettingModel;Landroid/widget/TextView;)V
    //   1360: aload #8
    //   1362: getfield j : Landroid/widget/ImageView;
    //   1365: aload #9
    //   1367: getfield vBadge : I
    //   1370: iconst_3
    //   1371: invokestatic a : (Landroid/widget/ImageView;II)V
    //   1374: aload #8
    //   1376: getfield n : Landroid/widget/ImageView;
    //   1379: bipush #8
    //   1381: invokevirtual setVisibility : (I)V
    //   1384: aload_0
    //   1385: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   1388: invokeinterface getContext : ()Landroid/content/Context;
    //   1393: aload #8
    //   1395: getfield c : Landroid/widget/TextView;
    //   1398: new com/soft/blued/ui/find/model/UserBasicModel
    //   1401: dup
    //   1402: invokespecial <init> : ()V
    //   1405: invokestatic a : (Landroid/content/Context;Landroid/widget/TextView;Lcom/soft/blued/ui/find/model/UserBasicModel;)V
    //   1408: goto -> 1853
    //   1411: aload_0
    //   1412: getfield h : Lcom/blued/android/core/net/IRequestHost;
    //   1415: iconst_0
    //   1416: aload #9
    //   1418: getfield avatar : Ljava/lang/String;
    //   1421: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
    //   1424: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
    //   1427: ldc_w 2131234356
    //   1430: invokevirtual a : (I)Lcom/blued/android/core/image/ImageWrapper;
    //   1433: invokevirtual c : ()Lcom/blued/android/core/image/ImageWrapper;
    //   1436: aload #8
    //   1438: getfield i : Landroid/widget/ImageView;
    //   1441: invokevirtual a : (Landroid/widget/ImageView;)V
    //   1444: aload #8
    //   1446: getfield l : Landroid/widget/TextView;
    //   1449: bipush #8
    //   1451: invokevirtual setVisibility : (I)V
    //   1454: aload_0
    //   1455: aload #9
    //   1457: aload #10
    //   1459: aload #8
    //   1461: getfield c : Landroid/widget/TextView;
    //   1464: invokespecial a : (Lcom/blued/android/chat/model/SessionModel;Lcom/soft/blued/db/model/SessionSettingModel;Landroid/widget/TextView;)V
    //   1467: aload #8
    //   1469: getfield j : Landroid/widget/ImageView;
    //   1472: aload #9
    //   1474: getfield vBadge : I
    //   1477: iconst_3
    //   1478: invokestatic a : (Landroid/widget/ImageView;II)V
    //   1481: aload #8
    //   1483: getfield m : Landroid/widget/TextView;
    //   1486: bipush #8
    //   1488: invokevirtual setVisibility : (I)V
    //   1491: new com/soft/blued/ui/find/model/UserBasicModel
    //   1494: dup
    //   1495: invokespecial <init> : ()V
    //   1498: astore_2
    //   1499: aload_2
    //   1500: aload #9
    //   1502: getfield vipGrade : I
    //   1505: putfield vip_grade : I
    //   1508: aload_2
    //   1509: aload #9
    //   1511: getfield vipAnnual : I
    //   1514: putfield is_vip_annual : I
    //   1517: aload_2
    //   1518: aload #9
    //   1520: getfield hideVipLook : I
    //   1523: putfield is_hide_vip_look : I
    //   1526: aload_2
    //   1527: aload #9
    //   1529: getfield vipExpLvl : I
    //   1532: putfield vip_exp_lvl : I
    //   1535: aload #8
    //   1537: getfield n : Landroid/widget/ImageView;
    //   1540: aload_2
    //   1541: invokestatic a : (Landroid/widget/ImageView;Lcom/soft/blued/ui/find/model/UserBasicModel;)V
    //   1544: aload_0
    //   1545: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   1548: invokeinterface getContext : ()Landroid/content/Context;
    //   1553: aload #8
    //   1555: getfield c : Landroid/widget/TextView;
    //   1558: aload_2
    //   1559: invokestatic a : (Landroid/content/Context;Landroid/widget/TextView;Lcom/soft/blued/ui/find/model/UserBasicModel;)V
    //   1562: aload_0
    //   1563: aload #8
    //   1565: getfield a : Landroid/widget/ImageView;
    //   1568: aload #9
    //   1570: getfield sourceFrom : I
    //   1573: aload #9
    //   1575: getfield hasReply : I
    //   1578: invokespecial a : (Landroid/widget/ImageView;II)V
    //   1581: goto -> 1853
    //   1584: aload #9
    //   1586: getfield sessionId : J
    //   1589: ldc2_w 2
    //   1592: lcmp
    //   1593: ifne -> 1688
    //   1596: new com/blued/android/core/imagecache/LoadOptions
    //   1599: dup
    //   1600: invokespecial <init> : ()V
    //   1603: astore_2
    //   1604: aload_2
    //   1605: ldc_w 2131233440
    //   1608: putfield d : I
    //   1611: aload_2
    //   1612: ldc_w 2131233440
    //   1615: putfield b : I
    //   1618: aload #8
    //   1620: getfield i : Landroid/widget/ImageView;
    //   1623: ldc_w 2131233440
    //   1626: invokevirtual setImageResource : (I)V
    //   1629: aload #8
    //   1631: getfield l : Landroid/widget/TextView;
    //   1634: bipush #8
    //   1636: invokevirtual setVisibility : (I)V
    //   1639: aload #8
    //   1641: getfield c : Landroid/widget/TextView;
    //   1644: aload_0
    //   1645: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   1648: invokeinterface getContext : ()Landroid/content/Context;
    //   1653: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1656: ldc_w 2131755602
    //   1659: invokevirtual getString : (I)Ljava/lang/String;
    //   1662: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   1665: aload #8
    //   1667: getfield j : Landroid/widget/ImageView;
    //   1670: bipush #8
    //   1672: invokevirtual setVisibility : (I)V
    //   1675: aload #8
    //   1677: getfield m : Landroid/widget/TextView;
    //   1680: bipush #8
    //   1682: invokevirtual setVisibility : (I)V
    //   1685: goto -> 1819
    //   1688: aload #9
    //   1690: getfield sessionId : J
    //   1693: ldc2_w 5
    //   1696: lcmp
    //   1697: ifne -> 1770
    //   1700: aload #8
    //   1702: getfield i : Landroid/widget/ImageView;
    //   1705: ldc_w 2131233444
    //   1708: invokevirtual setImageResource : (I)V
    //   1711: aload #8
    //   1713: getfield l : Landroid/widget/TextView;
    //   1716: bipush #8
    //   1718: invokevirtual setVisibility : (I)V
    //   1721: aload #8
    //   1723: getfield c : Landroid/widget/TextView;
    //   1726: aload_0
    //   1727: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   1730: invokeinterface getContext : ()Landroid/content/Context;
    //   1735: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1738: ldc_w 2131755473
    //   1741: invokevirtual getString : (I)Ljava/lang/String;
    //   1744: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   1747: aload #8
    //   1749: getfield j : Landroid/widget/ImageView;
    //   1752: bipush #8
    //   1754: invokevirtual setVisibility : (I)V
    //   1757: aload #8
    //   1759: getfield m : Landroid/widget/TextView;
    //   1762: bipush #8
    //   1764: invokevirtual setVisibility : (I)V
    //   1767: goto -> 1819
    //   1770: aload #8
    //   1772: getfield i : Landroid/widget/ImageView;
    //   1775: aconst_null
    //   1776: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   1779: aload #8
    //   1781: getfield l : Landroid/widget/TextView;
    //   1784: bipush #8
    //   1786: invokevirtual setVisibility : (I)V
    //   1789: aload #8
    //   1791: getfield c : Landroid/widget/TextView;
    //   1794: ldc ''
    //   1796: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   1799: aload #8
    //   1801: getfield j : Landroid/widget/ImageView;
    //   1804: bipush #8
    //   1806: invokevirtual setVisibility : (I)V
    //   1809: aload #8
    //   1811: getfield m : Landroid/widget/TextView;
    //   1814: bipush #8
    //   1816: invokevirtual setVisibility : (I)V
    //   1819: aload #8
    //   1821: getfield n : Landroid/widget/ImageView;
    //   1824: bipush #8
    //   1826: invokevirtual setVisibility : (I)V
    //   1829: aload_0
    //   1830: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   1833: invokeinterface getContext : ()Landroid/content/Context;
    //   1838: aload #8
    //   1840: getfield c : Landroid/widget/TextView;
    //   1843: new com/soft/blued/ui/find/model/UserBasicModel
    //   1846: dup
    //   1847: invokespecial <init> : ()V
    //   1850: invokestatic a : (Landroid/content/Context;Landroid/widget/TextView;Lcom/soft/blued/ui/find/model/UserBasicModel;)V
    //   1853: aload #9
    //   1855: getfield unreadGiftCnt : I
    //   1858: ifle -> 2028
    //   1861: aload #8
    //   1863: getfield p : Lcom/blued/android/framework/view/shape/ShapeFrameLayout;
    //   1866: iconst_0
    //   1867: invokevirtual setVisibility : (I)V
    //   1870: aload #9
    //   1872: getfield unreadGiftCnt : I
    //   1875: invokestatic a : (I)[B
    //   1878: astore_2
    //   1879: aload_2
    //   1880: iconst_0
    //   1881: baload
    //   1882: istore_1
    //   1883: aload_2
    //   1884: iconst_1
    //   1885: baload
    //   1886: istore #4
    //   1888: iload_1
    //   1889: ifle -> 1957
    //   1892: new java/lang/StringBuilder
    //   1895: dup
    //   1896: invokespecial <init> : ()V
    //   1899: astore_2
    //   1900: iload_1
    //   1901: iload #4
    //   1903: iadd
    //   1904: istore_1
    //   1905: aload_2
    //   1906: iload_1
    //   1907: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1910: pop
    //   1911: aload_0
    //   1912: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   1915: invokeinterface getContext : ()Landroid/content/Context;
    //   1920: astore #11
    //   1922: iload_1
    //   1923: iconst_1
    //   1924: if_icmple -> 1934
    //   1927: ldc_w 2131758018
    //   1930: istore_1
    //   1931: goto -> 1938
    //   1934: ldc_w 2131758019
    //   1937: istore_1
    //   1938: aload_2
    //   1939: aload #11
    //   1941: iload_1
    //   1942: invokevirtual getString : (I)Ljava/lang/String;
    //   1945: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: pop
    //   1949: aload_2
    //   1950: invokevirtual toString : ()Ljava/lang/String;
    //   1953: astore_2
    //   1954: goto -> 2016
    //   1957: new java/lang/StringBuilder
    //   1960: dup
    //   1961: invokespecial <init> : ()V
    //   1964: astore_2
    //   1965: aload_2
    //   1966: iload #4
    //   1968: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1971: pop
    //   1972: aload_0
    //   1973: getfield c : Lcom/soft/blued/ui/msg/contract/IMsgView;
    //   1976: invokeinterface getContext : ()Landroid/content/Context;
    //   1981: astore #11
    //   1983: iload #4
    //   1985: iconst_1
    //   1986: if_icmple -> 1996
    //   1989: ldc_w 2131758016
    //   1992: istore_1
    //   1993: goto -> 2000
    //   1996: ldc_w 2131758017
    //   1999: istore_1
    //   2000: aload_2
    //   2001: aload #11
    //   2003: iload_1
    //   2004: invokevirtual getString : (I)Ljava/lang/String;
    //   2007: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2010: pop
    //   2011: aload_2
    //   2012: invokevirtual toString : ()Ljava/lang/String;
    //   2015: astore_2
    //   2016: aload #8
    //   2018: getfield q : Landroid/widget/TextView;
    //   2021: aload_2
    //   2022: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   2025: goto -> 2038
    //   2028: aload #8
    //   2030: getfield p : Lcom/blued/android/framework/view/shape/ShapeFrameLayout;
    //   2033: bipush #8
    //   2035: invokevirtual setVisibility : (I)V
    //   2038: aload_0
    //   2039: aload #9
    //   2041: aload #10
    //   2043: aload #8
    //   2045: invokespecial a : (Lcom/blued/android/chat/model/SessionModel;Lcom/soft/blued/db/model/SessionSettingModel;Lcom/soft/blued/ui/msg/adapter/ChatFriendListAdapter$ViewHolder;)V
    //   2048: aload #9
    //   2050: getfield sessionType : S
    //   2053: sipush #6668
    //   2056: if_icmpne -> 2071
    //   2059: aload_3
    //   2060: ldc_w 2131299234
    //   2063: ldc_w 'msgBox'
    //   2066: invokevirtual setTag : (ILjava/lang/Object;)V
    //   2069: aload_3
    //   2070: areturn
    //   2071: aload_3
    //   2072: ldc_w 2131299234
    //   2075: ldc ''
    //   2077: invokevirtual setTag : (ILjava/lang/Object;)V
    //   2080: aload_3
    //   2081: areturn
  }
  
  class ViewHolder {
    ImageView a;
    
    View b;
    
    TextView c;
    
    View d;
    
    QBadgeContainer e;
    
    TextView f;
    
    ImageView g;
    
    TextView h;
    
    ImageView i;
    
    ImageView j;
    
    View k;
    
    TextView l;
    
    TextView m;
    
    ImageView n;
    
    ImageView o;
    
    ShapeFrameLayout p;
    
    TextView q;
    
    View r;
    
    ImageView s;
    
    TextView t;
    
    private ViewHolder(ChatFriendListAdapter this$0) {}
  }
  
  static interface ViewType {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\ChatFriendListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */