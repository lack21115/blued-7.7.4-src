package com.soft.blued.ui.msg.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.VideoChatMsgContentModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.live_china.liveForMsg.model.LiveMsgShareEntity;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.das.authority.SystemAuthorityProtos;
import com.blued.das.guy.GuyProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.BluedConstant;
import com.soft.blued.customview.SpacesItemDecoration;
import com.soft.blued.customview.XRoundedImageView;
import com.soft.blued.customview.selectabletextview.SelectFrameLayout;
import com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener;
import com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener2;
import com.soft.blued.customview.selectabletextview.SelectableOnChangeListener;
import com.soft.blued.customview.selectabletextview.SelectableOnShowListener;
import com.soft.blued.db.model.MsgExtra;
import com.soft.blued.emoticon.manager.EmotionLoadListener;
import com.soft.blued.emoticon.manager.EmotionManager;
import com.soft.blued.emoticon.model.EmoticonModel;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.log.trackUtils.EventTrackSystemAuthority;
import com.soft.blued.ui.feed.fragment.ShowPhotoDestroyFragment;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.msg.DialogSkipFragment;
import com.soft.blued.ui.msg.MsgChattingFragment;
import com.soft.blued.ui.msg.ShowPositionActivity;
import com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback;
import com.soft.blued.ui.msg.contract.IMsgChatAdapterOperationCallback;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.IMV4Constant;
import com.soft.blued.ui.msg.controller.tools.IMV4Method;
import com.soft.blued.ui.msg.controller.tools.MediaRecordHelper;
import com.soft.blued.ui.msg.controller.tools.MediaUtils;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.msg.customview.Emotion;
import com.soft.blued.ui.msg.event.KeepScreenEvent;
import com.soft.blued.ui.msg.manager.MessageChatMethod;
import com.soft.blued.ui.msg.manager.UserPagerGiftManager;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.ui.msg.model.CommonNoticeExtra;
import com.soft.blued.ui.msg.model.MsgChattingImageModel;
import com.soft.blued.ui.msg.model.MsgContentTranslatedEntity;
import com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity;
import com.soft.blued.ui.msg.model.MsgExtraGift;
import com.soft.blued.ui.msg.model.MsgExtraLike;
import com.soft.blued.ui.msg.model.MsgPrivateImgApplyExtra;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.msg.model.SystemNoticeExtra;
import com.soft.blued.ui.msg.pop.BottomMenuPop;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.fragment.VipBubbleFragment;
import com.soft.blued.ui.user.manager.VipBubbleManager;
import com.soft.blued.ui.user.model.VipBubbleModel;
import com.soft.blued.ui.video.ShowVideoDestroyFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.FileUtils;
import com.soft.blued.utils.FlutterRouter;
import com.soft.blued.utils.ImageUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.MemoryBitmapCache;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.click.SingleClickProxy;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.pop.BluedPopupWindow;
import java.io.File;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class MessageChatAdapter extends BaseListAdapter<ChattingModel> {
  private static final String k = MessageChatAdapter.class.getSimpleName();
  
  private final int A = 14;
  
  private final int B = 15;
  
  private final int C = 16;
  
  private final int D = 17;
  
  private final int E = 18;
  
  private final int F = 19;
  
  private final int G = 20;
  
  private final int H = 21;
  
  private final int I = 22;
  
  private final int J = 23;
  
  private final int K = 24;
  
  private final int L = 25;
  
  private final int M = 26;
  
  private final int N = 27;
  
  private final int O = 28;
  
  private final int P = 29;
  
  private final int Q = 30;
  
  private final int R = 31;
  
  private final int S = 32;
  
  private final int T = 33;
  
  private final int U = 34;
  
  private final int V = 35;
  
  private final int W = 36;
  
  private final int X = 37;
  
  private final int Y = 38;
  
  private final int Z = 39;
  
  private MsgChattingFragment aA;
  
  private Set<Long> aB = new HashSet<Long>();
  
  private int aC;
  
  private BottomMenuPop aD;
  
  private final int aa = 40;
  
  private final int ab = 41;
  
  private final int ac = 42;
  
  private final int ad = 43;
  
  private final int ae = 44;
  
  private final int af = 45;
  
  private final int ag = 46;
  
  private final int ah = 47;
  
  private final int ai = 48;
  
  private final int aj = 49;
  
  private final int ak = 50;
  
  private final int al = 51;
  
  private final int am = 52;
  
  private final int an = 53;
  
  private final int ao = 54;
  
  private String ap;
  
  private Dialog aq;
  
  private AtChooseUserHelper ar;
  
  private TextWatcher as;
  
  private LoadOptions at;
  
  private LoadOptions au;
  
  private LoadOptions av;
  
  private LoadOptions aw;
  
  private LoadOptions ax;
  
  private IMsgChatAdapterCallback ay;
  
  private IMsgChatAdapterOperationCallback az;
  
  public int e = 0;
  
  public Emotion f;
  
  public MediaRecordHelper g = new MediaRecordHelper();
  
  public String h = "";
  
  public String i = "";
  
  public VipBubbleModel j;
  
  private final int l = 55;
  
  private final int m = 0;
  
  private final int n = 1;
  
  private final int o = 2;
  
  private final int p = 3;
  
  private final int q = 4;
  
  private final int r = 5;
  
  private final int s = 6;
  
  private final int t = 7;
  
  private final int u = 8;
  
  private final int v = 9;
  
  private final int w = 10;
  
  private final int x = 11;
  
  private final int y = 12;
  
  private final int z = 13;
  
  public MessageChatAdapter(IMsgChatAdapterCallback paramIMsgChatAdapterCallback, IMsgChatAdapterOperationCallback paramIMsgChatAdapterOperationCallback, List<ChattingModel> paramList, AtChooseUserHelper paramAtChooseUserHelper, TextWatcher paramTextWatcher, MsgChattingFragment paramMsgChattingFragment) {
    super((Context)paramIMsgChatAdapterOperationCallback.V(), paramList);
    this.ay = paramIMsgChatAdapterCallback;
    this.az = paramIMsgChatAdapterOperationCallback;
    this.f = new Emotion(this.b);
    this.aq = DialogUtils.a(this.b);
    this.ar = paramAtChooseUserHelper;
    this.as = paramTextWatcher;
    this.at = new LoadOptions();
    LoadOptions loadOptions = this.at;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
    this.av = new LoadOptions();
    loadOptions = this.av;
    loadOptions.b = 2131232322;
    loadOptions.d = 2131232322;
    this.au = new LoadOptions();
    loadOptions = this.au;
    loadOptions.d = 2131100549;
    loadOptions.b = 2131100549;
    this.aw = new LoadOptions();
    loadOptions = this.aw;
    loadOptions.d = 2131232614;
    loadOptions.b = 2131232614;
    this.ax = new LoadOptions();
    loadOptions = this.ax;
    loadOptions.d = 2131232479;
    loadOptions.b = 2131100549;
    this.aA = paramMsgChattingFragment;
  }
  
  private int a(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      try {
        return ((ChannelModel)AppInfo.f().fromJson(paramString, ChannelModel.class)).chat_sdk_type;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return 0;
  }
  
  private View a(ChattingModel paramChattingModel, int paramInt, ViewGroup paramViewGroup) {
    short s = paramChattingModel.msgType;
    if (MsgType.getClassify(s) == 1 || s == 26)
      return this.c.inflate(2131493475, paramViewGroup, false); 
    if (MsgType.getGroupOperationNotifyType(s) == 2 || s == 0)
      return this.c.inflate(2131493432, paramViewGroup, false); 
    if (s != -3) {
      if (s != -2) {
        if (s != -1) {
          if (s != 9) {
            if (s != 10) {
              if (s != 24) {
                if (s != 25) {
                  if (s != 32) {
                    if (s != 55) {
                      if (s != 68) {
                        if (s != 164) {
                          if (s != 169) {
                            if (s != 205) {
                              if (s != 210) {
                                if (s != 216) {
                                  if (s != 52 && s != 53) {
                                    if (s != 73) {
                                      if (s != 74) {
                                        if (s != 98 && s != 99) {
                                          switch (s) {
                                            default:
                                              switch (s) {
                                                default:
                                                  return (getItemViewType(paramInt) == 1) ? this.c.inflate(2131493449, paramViewGroup, false) : this.c.inflate(2131493466, paramViewGroup, false);
                                                case 90:
                                                  return (getItemViewType(paramInt) == 37) ? this.c.inflate(2131493443, paramViewGroup, false) : this.c.inflate(2131493460, paramViewGroup, false);
                                                case 89:
                                                  return (getItemViewType(paramInt) == 35) ? this.c.inflate(2131493438, paramViewGroup, false) : this.c.inflate(2131493456, paramViewGroup, false);
                                                case 88:
                                                  return (getItemViewType(paramInt) == 33) ? this.c.inflate(2131493438, paramViewGroup, false) : this.c.inflate(2131493456, paramViewGroup, false);
                                                case 87:
                                                  break;
                                              } 
                                              return (getItemViewType(paramInt) == 31) ? this.c.inflate(2131493439, paramViewGroup, false) : this.c.inflate(2131493457, paramViewGroup, false);
                                            case 6:
                                              return (getItemViewType(paramInt) == 15) ? this.c.inflate(2131493442, paramViewGroup, false) : this.c.inflate(2131493459, paramViewGroup, false);
                                            case 5:
                                              return (getItemViewType(paramInt) == 17) ? this.c.inflate(2131493452, paramViewGroup, false) : this.c.inflate(2131493469, paramViewGroup, false);
                                            case 4:
                                              return (getItemViewType(paramInt) == 5) ? this.c.inflate(2131493448, paramViewGroup, false) : this.c.inflate(2131493465, paramViewGroup, false);
                                            case 3:
                                              return (getItemViewType(paramInt) == 7) ? this.c.inflate(2131493454, paramViewGroup, false) : this.c.inflate(2131493472, paramViewGroup, false);
                                            case 2:
                                              return (getItemViewType(paramInt) == 3) ? this.c.inflate(2131493445, paramViewGroup, false) : this.c.inflate(2131493462, paramViewGroup, false);
                                            case 1:
                                              break;
                                          } 
                                          return (getItemViewType(paramInt) == 1) ? this.c.inflate(2131493449, paramViewGroup, false) : this.c.inflate(2131493466, paramViewGroup, false);
                                        } 
                                        return (getItemViewType(paramInt) == 39) ? this.c.inflate(2131493440, paramViewGroup, false) : this.c.inflate(2131493471, paramViewGroup, false);
                                      } 
                                      return (getItemViewType(paramInt) == 43) ? this.c.inflate(2131493451, paramViewGroup, false) : this.c.inflate(2131493468, paramViewGroup, false);
                                    } 
                                    return (getItemViewType(paramInt) == 41) ? this.c.inflate(2131493441, paramViewGroup, false) : this.c.inflate(2131493458, paramViewGroup, false);
                                  } 
                                  return (getItemViewType(paramInt) == 27) ? this.c.inflate(2131493675, paramViewGroup, false) : this.c.inflate(2131493676, paramViewGroup, false);
                                } 
                                return this.c.inflate(2131493474, paramViewGroup, false);
                              } 
                              return (getItemViewType(paramInt) == 53) ? this.c.inflate(2131493455, paramViewGroup, false) : this.c.inflate(2131493473, paramViewGroup, false);
                            } 
                            return (getItemViewType(paramInt) == 51) ? this.c.inflate(2131493444, paramViewGroup, false) : this.c.inflate(2131493461, paramViewGroup, false);
                          } 
                          return this.c.inflate(2131493428, paramViewGroup, false);
                        } 
                        return (getItemViewType(paramInt) == 45) ? this.c.inflate(2131493450, paramViewGroup, false) : this.c.inflate(2131493467, paramViewGroup, false);
                      } 
                      return this.c.inflate(2131493435, paramViewGroup, false);
                    } 
                    return this.c.inflate(2131493475, paramViewGroup, false);
                  } 
                  return (getItemViewType(paramInt) == 23) ? this.c.inflate(2131493447, paramViewGroup, false) : this.c.inflate(2131493464, paramViewGroup, false);
                } 
                return (getItemViewType(paramInt) == 21) ? this.c.inflate(2131493453, paramViewGroup, false) : this.c.inflate(2131493470, paramViewGroup, false);
              } 
              return (getItemViewType(paramInt) == 19) ? this.c.inflate(2131493446, paramViewGroup, false) : this.c.inflate(2131493463, paramViewGroup, false);
            } 
            return (getItemViewType(paramInt) == 11) ? this.c.inflate(2131493443, paramViewGroup, false) : this.c.inflate(2131493460, paramViewGroup, false);
          } 
          return (getItemViewType(paramInt) == 9) ? this.c.inflate(2131493443, paramViewGroup, false) : this.c.inflate(2131493460, paramViewGroup, false);
        } 
        return this.c.inflate(2131493429, paramViewGroup, false);
      } 
      return this.c.inflate(2131493431, paramViewGroup, false);
    } 
    return this.c.inflate(2131493430, paramViewGroup, false);
  }
  
  private String a(MsgExtraForTextTypeEntity paramMsgExtraForTextTypeEntity) {
    return (paramMsgExtraForTextTypeEntity == null) ? "" : paramMsgExtraForTextTypeEntity.htmlContent;
  }
  
  private String a(String paramString, ChattingModel paramChattingModel) {
    String str = paramString;
    if (paramString.contains("http"))
      str = IMV4Method.a(paramChattingModel.sessionType, paramChattingModel.sessionId, paramString); 
    return str;
  }
  
  private void a(int paramInt, TextView paramTextView) {
    String str1;
    String str2;
    int i = paramInt / 60;
    paramInt %= 60;
    if (i < 10) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("0");
      stringBuilder1.append(i);
      str1 = stringBuilder1.toString();
    } else {
      str1 = String.valueOf(i);
    } 
    if (paramInt < 10) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("0");
      stringBuilder1.append(paramInt);
      str2 = stringBuilder1.toString();
    } else {
      str2 = String.valueOf(paramInt);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.getResources().getString(2131758086));
    stringBuilder.append(" ");
    stringBuilder.append(str1);
    stringBuilder.append(":");
    stringBuilder.append(str2);
    paramTextView.setText(stringBuilder.toString());
  }
  
  private void a(long paramLong, TextView paramTextView) {
    if (TimeAndDateUtils.f(paramLong)) {
      if (TimeAndDateUtils.e(paramLong)) {
        this.ap = ((SimpleDateFormat)TimeAndDateUtils.f.get()).format(new Date(paramLong));
      } else if (TimeAndDateUtils.g(paramLong)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.getResources().getString(2131755486));
        stringBuilder.append(" ");
        stringBuilder.append(((SimpleDateFormat)TimeAndDateUtils.f.get()).format(new Date(paramLong)));
        this.ap = stringBuilder.toString();
      } else {
        this.ap = ((SimpleDateFormat)TimeAndDateUtils.h.get()).format(new Date(paramLong));
      } 
    } else {
      this.ap = ((SimpleDateFormat)TimeAndDateUtils.e.get()).format(new Date(paramLong));
    } 
    paramTextView.setText(this.ap);
    paramTextView.setVisibility(0);
  }
  
  private void a(ImageView paramImageView, String paramString, LoadOptions paramLoadOptions) {
    ImageWrapper imageWrapper;
    if (TextUtils.isEmpty(paramString))
      return; 
    Logger.b(k, new Object[] { "loadLocalPic===", RecyclingUtils.Scheme.c.b(paramString) });
    if (paramString.startsWith("assets://")) {
      imageWrapper = ImageLoader.c(b(), paramString.substring(9));
    } else if (imageWrapper.startsWith("file://")) {
      imageWrapper = ImageLoader.d(b(), imageWrapper.substring(7));
    } else {
      imageWrapper = ImageLoader.a(b(), (String)imageWrapper);
    } 
    imageWrapper.e(-1).a(paramImageView);
  }
  
  private void a(TextView paramTextView, String paramString, int paramInt, boolean... paramVarArgs) {
    TypefaceUtils.a(paramTextView, paramString, false, "", paramInt, paramVarArgs);
  }
  
  private void a(ChattingModel paramChattingModel, View paramView) {
    ImageView imageView = (ImageView)paramView.findViewById(2131297797);
    imageView.setVisibility(8);
    if (!TextUtils.isEmpty(paramChattingModel.getMsgExtra())) {
      Exception exception;
      try {
        SystemNoticeExtra systemNoticeExtra = (SystemNoticeExtra)AppInfo.f().fromJson(paramChattingModel.getMsgExtra(), SystemNoticeExtra.class);
      } finally {
        exception = null;
        String str = k;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setGroupNoticeType  error: ");
        stringBuilder.append(exception.getMessage());
        Logger.e(str, new Object[] { stringBuilder.toString() });
      } 
      if (exception != null && ((SystemNoticeExtra)exception).notice_type == 1) {
        imageView.setVisibility(0);
        paramView.findViewById(2131298758).setOnClickListener(new View.OnClickListener(this, paramChattingModel) {
              public void onClick(View param1View) {
                Context context = this.b.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a.fromId);
                stringBuilder.append("");
                UserInfoFragmentNew.a(context, stringBuilder.toString(), "group_chatting");
              }
            });
        ImageLoader.a(b(), paramChattingModel.fromAvatar).a(2131234356).c().a(imageView);
      } 
      ((TextView)paramView.findViewById(2131300704)).setText(paramChattingModel.msgContent);
      return;
    } 
    Object object = null;
  }
  
  private void a(ChattingModel paramChattingModel, View paramView, int paramInt) {
    String str = ChatHelperV4.a().b(paramChattingModel);
    a(paramChattingModel, paramChattingModel.msgContent, paramView, 2);
    paramView.setOnClickListener(new View.OnClickListener(this, str, paramChattingModel, paramInt) {
          public void onClick(View param1View) {
            Logger.b(MessageChatAdapter.a(), new Object[] { "点击解密后的视频地址===", this.a });
            if (!TextUtils.isEmpty(this.a)) {
              if (!this.a.contains("http"))
                return; 
              String str2 = this.a;
              String str3 = BluedPreferences.ac(this.b.msgContent);
              String str1 = str2;
              if (!TextUtils.isEmpty(str3)) {
                File file = new File(str3);
                str1 = str2;
                if (file.isFile()) {
                  str1 = str2;
                  if (file.exists())
                    str1 = str3; 
                } 
              } 
              ShowVideoDestroyFragment.a(MessageChatAdapter.c(this.d).L(), str1, this.c, 701);
            } 
          }
        });
    paramView.setOnLongClickListener(new View.OnLongClickListener(this, paramChattingModel) {
          public boolean onLongClick(View param1View) {
            MessageChatAdapter.a(this.b, this.a);
            return false;
          }
        });
  }
  
  private void a(ChattingModel paramChattingModel, View paramView, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: ldc_w ''
    //   3: astore #8
    //   5: aload_2
    //   6: ldc_w 2131301503
    //   9: invokestatic a : (Landroid/view/View;I)Landroid/view/View;
    //   12: checkcast android/widget/TextView
    //   15: astore #11
    //   17: aload_2
    //   18: ldc_w 2131301499
    //   21: invokestatic a : (Landroid/view/View;I)Landroid/view/View;
    //   24: checkcast android/widget/TextView
    //   27: astore #12
    //   29: aload_2
    //   30: ldc_w 2131301500
    //   33: invokestatic a : (Landroid/view/View;I)Landroid/view/View;
    //   36: checkcast android/widget/TextView
    //   39: astore #13
    //   41: aload_2
    //   42: ldc_w 2131297579
    //   45: invokestatic a : (Landroid/view/View;I)Landroid/view/View;
    //   48: checkcast android/widget/ImageView
    //   51: astore #14
    //   53: iconst_0
    //   54: istore #6
    //   56: iconst_0
    //   57: istore #7
    //   59: iconst_0
    //   60: istore #5
    //   62: aload_1
    //   63: invokevirtual getMsgExtra : ()Ljava/lang/String;
    //   66: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   69: ifne -> 151
    //   72: invokestatic f : ()Lcom/google/gson/Gson;
    //   75: aload_1
    //   76: invokevirtual getMsgExtra : ()Ljava/lang/String;
    //   79: ldc_w com/soft/blued/ui/msg/model/MsgVIPModel
    //   82: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   85: checkcast com/soft/blued/ui/msg/model/MsgVIPModel
    //   88: astore #9
    //   90: aload #9
    //   92: ifnull -> 151
    //   95: aload #9
    //   97: getfield title : Ljava/lang/String;
    //   100: astore #8
    //   102: aload #9
    //   104: getfield content : Ljava/lang/String;
    //   107: astore_1
    //   108: aload #9
    //   110: getfield vip_type : I
    //   113: istore #6
    //   115: iload #6
    //   117: istore #5
    //   119: aload #9
    //   121: getfield link : Ljava/lang/String;
    //   124: astore #9
    //   126: iload #6
    //   128: istore #5
    //   130: goto -> 192
    //   133: astore #9
    //   135: goto -> 182
    //   138: astore #9
    //   140: ldc_w ''
    //   143: astore_1
    //   144: iload #6
    //   146: istore #5
    //   148: goto -> 182
    //   151: ldc_w ''
    //   154: astore_1
    //   155: aload_1
    //   156: astore #9
    //   158: iload #7
    //   160: istore #5
    //   162: aload_1
    //   163: astore #10
    //   165: goto -> 199
    //   168: astore #9
    //   170: ldc_w ''
    //   173: astore #8
    //   175: aload #8
    //   177: astore_1
    //   178: iload #6
    //   180: istore #5
    //   182: aload #9
    //   184: invokevirtual printStackTrace : ()V
    //   187: ldc_w ''
    //   190: astore #9
    //   192: aload #9
    //   194: astore #10
    //   196: aload_1
    //   197: astore #9
    //   199: aload #11
    //   201: aload #8
    //   203: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   206: aload #12
    //   208: aload #9
    //   210: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   213: iload_3
    //   214: bipush #98
    //   216: if_icmpne -> 299
    //   219: aload #13
    //   221: aload_0
    //   222: getfield b : Landroid/content/Context;
    //   225: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   228: ldc_w 2131758088
    //   231: invokevirtual getString : (I)Ljava/lang/String;
    //   234: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   237: iload #4
    //   239: ifne -> 253
    //   242: aload #14
    //   244: ldc_w 2131231255
    //   247: invokevirtual setImageResource : (I)V
    //   250: goto -> 267
    //   253: iload #4
    //   255: iconst_1
    //   256: if_icmpne -> 267
    //   259: aload #14
    //   261: ldc_w 2131231254
    //   264: invokevirtual setImageResource : (I)V
    //   267: aload #11
    //   269: aload_0
    //   270: getfield b : Landroid/content/Context;
    //   273: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   276: ldc_w 2131100528
    //   279: invokevirtual getColor : (I)I
    //   282: invokevirtual setTextColor : (I)V
    //   285: aload #12
    //   287: ldc_w '#afffffff'
    //   290: invokestatic parseColor : (Ljava/lang/String;)I
    //   293: invokevirtual setTextColor : (I)V
    //   296: goto -> 470
    //   299: iload_3
    //   300: bipush #99
    //   302: if_icmpne -> 470
    //   305: aload #13
    //   307: aload_0
    //   308: getfield b : Landroid/content/Context;
    //   311: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   314: ldc_w 2131758089
    //   317: invokevirtual getString : (I)Ljava/lang/String;
    //   320: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   323: iload #5
    //   325: iconst_1
    //   326: if_icmpne -> 398
    //   329: iload #4
    //   331: ifne -> 345
    //   334: aload #14
    //   336: ldc_w 2131231257
    //   339: invokevirtual setImageResource : (I)V
    //   342: goto -> 359
    //   345: iload #4
    //   347: iconst_1
    //   348: if_icmpne -> 359
    //   351: aload #14
    //   353: ldc_w 2131231256
    //   356: invokevirtual setImageResource : (I)V
    //   359: aload #11
    //   361: aload_0
    //   362: getfield b : Landroid/content/Context;
    //   365: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   368: ldc_w 2131100528
    //   371: invokevirtual getColor : (I)I
    //   374: invokevirtual setTextColor : (I)V
    //   377: aload #12
    //   379: aload_0
    //   380: getfield b : Landroid/content/Context;
    //   383: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   386: ldc_w 2131100528
    //   389: invokevirtual getColor : (I)I
    //   392: invokevirtual setTextColor : (I)V
    //   395: goto -> 470
    //   398: iload #5
    //   400: iconst_2
    //   401: if_icmpne -> 470
    //   404: iload #4
    //   406: ifne -> 420
    //   409: aload #14
    //   411: ldc_w 2131231253
    //   414: invokevirtual setImageResource : (I)V
    //   417: goto -> 434
    //   420: iload #4
    //   422: iconst_1
    //   423: if_icmpne -> 434
    //   426: aload #14
    //   428: ldc_w 2131231252
    //   431: invokevirtual setImageResource : (I)V
    //   434: aload #11
    //   436: aload_0
    //   437: getfield b : Landroid/content/Context;
    //   440: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   443: ldc_w 2131100532
    //   446: invokevirtual getColor : (I)I
    //   449: invokevirtual setTextColor : (I)V
    //   452: aload #12
    //   454: aload_0
    //   455: getfield b : Landroid/content/Context;
    //   458: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   461: ldc_w 2131100532
    //   464: invokevirtual getColor : (I)I
    //   467: invokevirtual setTextColor : (I)V
    //   470: aload_2
    //   471: new com/soft/blued/ui/msg/adapter/MessageChatAdapter$78
    //   474: dup
    //   475: aload_0
    //   476: iload_3
    //   477: aload #10
    //   479: iload #4
    //   481: invokespecial <init> : (Lcom/soft/blued/ui/msg/adapter/MessageChatAdapter;ILjava/lang/String;I)V
    //   484: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   487: return
    // Exception table:
    //   from	to	target	type
    //   62	90	168	java/lang/Exception
    //   95	102	168	java/lang/Exception
    //   102	108	138	java/lang/Exception
    //   108	115	133	java/lang/Exception
    //   119	126	133	java/lang/Exception
  }
  
  private void a(ChattingModel paramChattingModel, View paramView1, View paramView2) {
    IMsgChatAdapterCallback iMsgChatAdapterCallback;
    if (TextUtils.isEmpty(paramChattingModel.msgContent))
      return; 
    String[] arrayOfString = paramChattingModel.msgContent.split(",,");
    if (arrayOfString.length < 2)
      return; 
    int i = StringUtils.a(arrayOfString[1], 0);
    if (i == 0)
      return; 
    float f1 = ((i - 1) / 5) * 12.5F + 90.0F;
    float f2 = 365.0F;
    if (f1 > 365.0F)
      f1 = f2; 
    TextView textView2 = ViewHolder.<TextView>a(paramView1, 2131296728);
    ImageView imageView1 = ViewHolder.<ImageView>a(paramView1, 2131301715);
    ViewGroup.LayoutParams layoutParams = paramView2.getLayoutParams();
    layoutParams.width = DensityUtils.a(this.b, f1);
    layoutParams.height = -2;
    paramView2.setLayoutParams(layoutParams);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i);
    stringBuilder.append("”");
    textView2.setText(stringBuilder.toString());
    a(paramChattingModel);
    String str = IMV4Method.a(paramChattingModel);
    SelectFrameLayout selectFrameLayout2 = (SelectFrameLayout)paramView1.findViewById(2131299886);
    RelativeLayout relativeLayout = (RelativeLayout)paramView2.findViewById(2131299688);
    ImageView imageView2 = (ImageView)paramView2.findViewById(2131296703);
    ImageView imageView3 = (ImageView)paramView2.findViewById(2131296704);
    SelectFrameLayout selectFrameLayout1 = (SelectFrameLayout)paramView1.findViewById(2131299887);
    TextView textView1 = (TextView)paramView1.findViewById(2131301454);
    paramView1 = paramView1.findViewById(2131301676);
    if (paramChattingModel.msgTextTranslateIsShow == 1 && this.aB.contains(Long.valueOf(paramChattingModel.msgId))) {
      selectFrameLayout1.setVisibility(0);
      textView1.setText(paramChattingModel.msgTextTranslateContent);
    } else {
      selectFrameLayout1.setVisibility(8);
    } 
    VipBubbleModel vipBubbleModel = VipBubbleManager.a().c();
    AnimationDrawable animationDrawable = (AnimationDrawable)imageView2.getBackground();
    if (paramChattingModel.isFromSelf()) {
      RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams)relativeLayout.getLayoutParams();
      layoutParams1.leftMargin = 0;
      relativeLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
      textView2.setTextColor(ContextCompat.getColor(this.b, 2131100980));
      imageView2.setVisibility(0);
      imageView3.setVisibility(4);
      VipBubbleManager.a().a(1, 1, new View[] { paramView2 });
      VipBubbleManager.a().a(0, 1, new View[] { (View)selectFrameLayout1 });
      if (vipBubbleModel != null) {
        iMsgChatAdapterCallback = this.ay;
        if (iMsgChatAdapterCallback != null && !iMsgChatAdapterCallback.c()) {
          imageView2.setVisibility(4);
          imageView3.setVisibility(0);
          ImageLoader.a(b(), vipBubbleModel.voice_right_default).c(2131231240).f().a(imageView3);
          try {
            textView2.setTextColor(Color.parseColor(vipBubbleModel.text_color));
          } finally {}
          VipBubbleManager.a().a(vipBubbleModel, 1, new View[] { paramView2 });
          VipBubbleManager.a().a(vipBubbleModel, 1, new View[] { (View)selectFrameLayout1 });
        } 
      } 
    } else if (!paramChattingModel.isFromSelf()) {
      RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams)iMsgChatAdapterCallback.getLayoutParams();
      layoutParams1.leftMargin = 0;
      iMsgChatAdapterCallback.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
      imageView2.setVisibility(0);
      imageView3.setVisibility(4);
      textView2.setTextColor(BluedSkinUtils.a(this.b, 2131100838));
      VipBubbleManager.a().a(1, 0, new View[] { paramView2 });
      VipBubbleManager.a().a(0, 0, new View[] { (View)selectFrameLayout1 });
      VipBubbleModel vipBubbleModel1 = this.j;
      if (vipBubbleModel1 != null) {
        try {
          textView2.setTextColor(Color.parseColor(vipBubbleModel1.text_color));
        } finally {}
        imageView2.setVisibility(4);
        imageView3.setVisibility(0);
        ImageLoader.a(b(), this.j.voice_left_default).c(2131231239).a(imageView3);
        VipBubbleManager.a().a(this.j, 0, new View[] { paramView2 });
        VipBubbleManager.a().a(this.j, 0, new View[] { (View)selectFrameLayout1 });
      } 
    } 
    if (!TextUtils.isEmpty(this.h) && this.h.equals(str)) {
      animationDrawable.start();
      if (paramChattingModel.isFromSelf() && vipBubbleModel != null) {
        ImageLoader.a(b(), vipBubbleModel.voice_right_gift).c(2131231240).g().e(-1).a(imageView3);
      } else if (!paramChattingModel.isFromSelf() && this.j != null) {
        ImageLoader.a(b(), this.j.voice_left_gift).c(2131231239).g().e(-1).a(imageView3);
      } 
    } else if (animationDrawable.isRunning()) {
      animationDrawable.stop();
      if (IMV4Method.a(paramChattingModel.fromId) == 1) {
        imageView2.setBackgroundResource(0);
        imageView2.setBackgroundResource(2131231239);
        if (this.j != null)
          ImageLoader.a(b(), this.j.voice_left_default).c(2131231239).a(imageView3); 
      } else {
        imageView2.setBackgroundResource(0);
        imageView2.setBackgroundResource(2131231240);
        if (vipBubbleModel != null)
          ImageLoader.a(b(), vipBubbleModel.voice_right_default).c(2131231240).a(imageView3); 
      } 
    } 
    paramView2.setTag(paramChattingModel);
    paramView2.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (!AudioChannelManager.e().h()) {
              MessageChatAdapter messageChatAdapter1;
              ChattingModel chattingModel = (ChattingModel)param1View.getTag();
              if (!this.a.a(chattingModel))
                return; 
              String str = IMV4Method.a(chattingModel);
              MessageChatAdapter messageChatAdapter2 = this.a;
              messageChatAdapter2.i = MessageChatAdapter.a(messageChatAdapter2, str, chattingModel);
              if (MessageChatAdapter.f(this.a)) {
                this.a.g.b();
                LiveEventBus.get("keep_screen").post(new KeepScreenEvent(false));
                if (this.a.h.equals(str)) {
                  messageChatAdapter1 = this.a;
                  messageChatAdapter1.h = "";
                  messageChatAdapter1.notifyDataSetChanged();
                  return;
                } 
              } 
              messageChatAdapter2 = this.a;
              messageChatAdapter2.h = str;
              MessageChatAdapter.g(messageChatAdapter2);
              if (IMV4Method.a(((ChattingModel)messageChatAdapter1).fromId) == 1 && ((ChattingModel)messageChatAdapter1).msgStateCode != 5)
                ChatManager.getInstance().updateMsgState((ChattingModel)messageChatAdapter1, (short)5); 
              if (MessageChatAdapter.c(this.a) != null)
                MessageChatAdapter.c(this.a).K(); 
              this.a.notifyDataSetChanged();
              return;
            } 
            AppMethods.a(this.a.b.getResources().getText(2131759450));
          }
        });
    if (IMV4Method.a(paramChattingModel.fromId) == 1)
      if (paramChattingModel.msgStateCode != 5) {
        imageView1.setVisibility(0);
      } else {
        imageView1.setVisibility(8);
      }  
    if (BluedPreferences.eH()) {
      BluedPreferences.eI();
      paramView2 = View.inflate(this.b, 2131494046, null);
      TextView textView = (TextView)paramView2.findViewById(2131300873);
      textView.setBackgroundResource(2131232336);
      textView.setText(2131759089);
      BluedPopupWindow bluedPopupWindow = BluedPopupWindow.Builder.a((Activity)this.b, paramView2).a(true).a();
      paramView2.setOnClickListener(new View.OnClickListener(this, bluedPopupWindow) {
            public void onClick(View param1View) {
              this.a.dismiss();
            }
          });
      bluedPopupWindow.a((View)selectFrameLayout2, 1, 0, 0, 0);
      paramView2.postDelayed(new Runnable(this, bluedPopupWindow) {
            public void run() {
              try {
                return;
              } finally {
                Exception exception = null;
              } 
            }
          }3000L);
    } 
    a(selectFrameLayout2, (View)selectFrameLayout1, textView1, paramView1, paramChattingModel);
    a(selectFrameLayout1, paramChattingModel);
  }
  
  private void a(ChattingModel paramChattingModel, View paramView1, View paramView2, int paramInt) {
    String str = ChatHelperV4.a().a(paramChattingModel);
    Logger.c(k, new Object[] { "setPicBurnType=====ImageLoader" });
    if (this.aA != null && !TextUtils.isEmpty(str))
      MemoryBitmapCache.a().a(this.aA.getContext(), str); 
    a(paramChattingModel, paramChattingModel.msgContent, paramView2, 1);
    paramView2.setOnClickListener(new View.OnClickListener(this, str, paramInt) {
          public void onClick(View param1View) {
            Logger.b(MessageChatAdapter.a(), new Object[] { "点击解密后的图片地址===", this.a });
            if (TextUtils.isEmpty(this.a))
              return; 
            if (!TextUtils.isEmpty(this.a)) {
              if (!this.a.contains("http"))
                return; 
              ShowPhotoDestroyFragment.a(MessageChatAdapter.c(this.c).L(), this.a, this.b, 700);
            } 
          }
        });
    paramView2.setOnLongClickListener(new View.OnLongClickListener(this, paramChattingModel) {
          public boolean onLongClick(View param1View) {
            MessageChatAdapter.a(this.b, this.a);
            return false;
          }
        });
    if (IMV4Method.a(paramChattingModel.fromId) == 1 && BluedConfig.b().v()) {
      MsgChattingImageModel msgChattingImageModel = ChatHelperV4.a().d(paramChattingModel);
      if (msgChattingImageModel != null && paramChattingModel.msgId == 1L && msgChattingImageModel.getMsgSource() != null)
        a(msgChattingImageModel.getMsgSource(), paramView1, String.valueOf(paramChattingModel.fromId)); 
    } 
  }
  
  private void a(ChattingModel paramChattingModel, View paramView, ImageView paramImageView, TextView paramTextView) {
    if (TextUtils.isEmpty(paramChattingModel.msgContent))
      return; 
    MsgChattingImageModel msgChattingImageModel = ChatHelperV4.a().f(paramChattingModel);
    if (msgChattingImageModel != null) {
      String str1 = msgChattingImageModel.getLongitude();
      String str2 = msgChattingImageModel.getLatitude();
      String str3 = msgChattingImageModel.getLocation();
      String str4 = IMV4Constant.c.replace("%a", str1).replace("%b", str2).replace("%c", str1).replace("%d", str2);
      LoadOptions loadOptions = new LoadOptions();
      loadOptions.b = 2131231246;
      loadOptions.d = 2131231246;
      ImageLoader.a(b(), str4).a(2131231246).a(paramImageView);
      if (!TextUtils.isEmpty(str3)) {
        paramTextView.setText(str3);
      } else {
        paramTextView.setText("");
      } 
      paramView.setOnClickListener(new View.OnClickListener(this, str1, str2, str3, paramChattingModel) {
            public void onClick(View param1View) {
              String str1;
              Context context = this.e.b;
              String str2 = this.a;
              String str3 = this.b;
              String str4 = this.c;
              if (IMV4Method.b(this.d.fromId)) {
                str1 = "";
              } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.d.fromId);
                stringBuilder.append("");
                str1 = stringBuilder.toString();
              } 
              ShowPositionActivity.a(context, str2, str3, str4, 0, str1);
            }
          });
    } 
    paramView.setOnLongClickListener(new View.OnLongClickListener(this, paramChattingModel) {
          public boolean onLongClick(View param1View) {
            MessageChatAdapter.a(this.b, this.a);
            return false;
          }
        });
  }
  
  private void a(ChattingModel paramChattingModel, View paramView, TextView paramTextView1, ImageView paramImageView, TextView paramTextView2, TextView paramTextView3) {
    String str = paramChattingModel.getMsgExtra();
    if (TextUtils.isEmpty(str))
      return; 
    Type type = (new TypeToken<MsgExtra>(this) {
      
      }).getType();
    MsgExtra msgExtra = (MsgExtra)AppInfo.f().fromJson(str, type);
    paramTextView1.setText(this.b.getResources().getString(2131755457));
    ImageLoader.a(b(), msgExtra.getGroups_avatar()).c().a(2131232322).a(paramImageView);
    if (!TextUtils.isEmpty(msgExtra.getGroups_name()))
      paramTextView2.setText(msgExtra.getGroups_name()); 
    if (!TextUtils.isEmpty(msgExtra.getGroups_description())) {
      paramTextView3.setText(msgExtra.getGroups_description());
      ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)paramImageView.getLayoutParams();
      if (paramTextView3.getLineCount() == 1) {
        layoutParams.bottomToBottom = 0;
        layoutParams.bottomMargin = DensityUtils.a(this.b, 17.0F);
      } else {
        layoutParams.bottomToBottom = -1;
      } 
      paramImageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
    paramView.setOnClickListener(new View.OnClickListener(this, paramChattingModel, msgExtra) {
          public void onClick(View param1View) {
            boolean bool;
            if (BluedConstant.a && this.a.sessionType == 2 && (this.a.msgType == 9 || this.a.msgType == 10)) {
              bool = true;
            } else {
              bool = false;
            } 
            if (bool) {
              MessageChatAdapter.d(this.c);
              return;
            } 
            Bundle bundle = new Bundle();
            String str1 = String.valueOf(this.b.getGroups_gid());
            String str2 = this.b.getGroups_iid();
            if (StringUtils.e(str1))
              return; 
            if (this.a.isFromSelf()) {
              bundle.putString("gid", str1);
              bundle.putString("iid", str2);
              bundle.putString("from_page", MsgChattingFragment.class.getSimpleName());
              TerminalActivity.d(this.c.b, GroupInfoFragment.class, bundle);
            } else {
              GroupHttpUtils.a(this.c.b, new BluedUIHttpResponse<BluedEntityA<BluedCreatedGroupInfo>>(this, bundle, str1, str2) {
                    boolean a;
                    
                    public void a(BluedEntityA<BluedCreatedGroupInfo> param2BluedEntityA) {
                      try {
                        int i = ((BluedCreatedGroupInfo)param2BluedEntityA.data.get(0)).groups_is_locked;
                        String str = ((BluedCreatedGroupInfo)param2BluedEntityA.data.get(0)).groups_in_members;
                        if (i == 1) {
                          this.b.putString("gid", this.c);
                          this.b.putString("iid", this.d);
                          this.b.putString("from_page", MsgChattingFragment.class.getSimpleName());
                          TerminalActivity.d(this.e.c.b, GroupInfoFragment.class, this.b);
                          return;
                        } 
                        if ("1".equals(str)) {
                          BluedCreatedGroupInfo bluedCreatedGroupInfo = param2BluedEntityA.data.get(0);
                          if (bluedCreatedGroupInfo == null)
                            return; 
                          LogData logData = new LogData();
                          logData.g = "none";
                          ChatHelperV4.a().a(this.e.c.b, Long.valueOf(bluedCreatedGroupInfo.groups_gid).longValue(), bluedCreatedGroupInfo.groups_name, bluedCreatedGroupInfo.groups_avatar, bluedCreatedGroupInfo.vbadge, 0, 0, 0, "", false, 1, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
                          return;
                        } 
                        this.b.putString("gid", this.c);
                        this.b.putString("iid", this.d);
                        this.b.putString("from_page", MsgChattingFragment.class.getSimpleName());
                        TerminalActivity.d(this.e.c.b, GroupInfoFragment.class, this.b);
                        return;
                      } catch (Exception exception) {
                        exception.printStackTrace();
                        return;
                      } 
                    }
                    
                    public boolean onUIFailure(int param2Int, String param2String) {
                      this.a = true;
                      return super.onUIFailure(param2Int, param2String);
                    }
                    
                    public void onUIFinish() {
                      super.onUIFinish();
                      if (this.a) {
                        this.a = false;
                        this.b.putString("gid", this.c);
                        this.b.putString("iid", this.d);
                        this.b.putString("from_page", MsgChattingFragment.class.getSimpleName());
                        TerminalActivity.d(this.e.c.b, GroupInfoFragment.class, this.b);
                      } 
                    }
                  }str1, "detail", null);
            } 
            if (10 == this.a.msgType) {
              String str3;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("http://common.blued.com/?action=group&id=");
              stringBuilder.append(EncryptTool.b(str1));
              String str4 = stringBuilder.toString();
              boolean bool1 = IMV4Method.b(this.a.fromId);
              str1 = "";
              if (!bool1) {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(this.a.fromId);
                stringBuilder1.append("");
                str3 = stringBuilder1.toString();
              } 
              InstantLog.a(10, str4, str3);
            } 
          }
        });
    if (paramChattingModel.msgType != 9)
      paramView.setOnLongClickListener(new View.OnLongClickListener(this, paramChattingModel) {
            public boolean onLongClick(View param1View) {
              boolean bool;
              if (BluedConstant.a && this.a.sessionType == 2 && this.a.msgType == 10) {
                bool = true;
              } else {
                bool = false;
              } 
              if (bool) {
                MessageChatAdapter.d(this.b);
                return false;
              } 
              MessageChatAdapter.a(this.b, this.a);
              return false;
            }
          }); 
  }
  
  private void a(ChattingModel paramChattingModel, View paramView1, TextView paramTextView1, ShapeTextView paramShapeTextView, ImageView paramImageView, View paramView2, TextView paramTextView2) {
    String str;
    if (this.ay.c()) {
      if (paramView1 != null)
        paramView1.setVisibility(0); 
      UserBasicModel userBasicModel = new UserBasicModel();
      userBasicModel.vip_grade = paramChattingModel.fromVipGrade;
      userBasicModel.is_vip_annual = paramChattingModel.fromVipAnnual;
      userBasicModel.vip_exp_lvl = paramChattingModel.fromVipExpLvl;
      userBasicModel.is_hide_vip_look = paramChattingModel.fromHideVipLook;
      if (!TextUtils.isEmpty(paramChattingModel.fromNickName)) {
        paramTextView1.setText(paramChattingModel.fromNickName);
        UserRelationshipUtils.a(this.b, paramTextView1, userBasicModel);
      } else {
        paramTextView1.setText("");
      } 
      UserRelationshipUtils.a(paramImageView, userBasicModel);
      String str1 = String.valueOf(paramChattingModel.fromId);
      if (!TextUtils.isEmpty(this.ay.g()) && str1.equals(this.ay.g())) {
        GroupUtil.a(paramShapeTextView, 1);
      } else {
        str = this.ay.h();
        if (!TextUtils.isEmpty(str)) {
          try {
            if (Arrays.<String>asList(str.split(",")).contains(str1)) {
              GroupUtil.a(paramShapeTextView, 2);
            } else {
              paramShapeTextView.setVisibility(8);
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
            paramShapeTextView.setVisibility(8);
          } 
        } else {
          paramShapeTextView.setVisibility(8);
        } 
      } 
      paramView2.setVisibility(8);
      return;
    } 
    if (str != null)
      str.setVisibility(8); 
  }
  
  private void a(ChattingModel paramChattingModel, View paramView, short paramShort, int paramInt) {
    TextView textView1 = (TextView)paramView.findViewById(2131300669);
    TextView textView2 = (TextView)paramView.findViewById(2131301494);
    ImageView imageView = (ImageView)paramView.findViewById(2131297804);
    textView2.setVisibility(8);
    MsgExtraGift msgExtraGift = (MsgExtraGift)AppInfo.f().fromJson(paramChattingModel.getMsgExtra(), MsgExtraGift.class);
    if (!TextUtils.isEmpty(paramChattingModel.getMsgExtra()) && msgExtraGift != null && msgExtraGift.gift_like != null) {
      boolean bool;
      ((RelativeLayout)paramView.findViewById(2131296700)).setOnClickListener(new View.OnClickListener(this, paramChattingModel) {
            public void onClick(View param1View) {
              if (MessageChatAdapter.a(this.b) != null && (MessageChatAdapter.a(this.b)).u != null)
                (MessageChatAdapter.a(this.b)).u.a(this.a); 
            }
          });
      textView2.setOnClickListener(new View.OnClickListener(this, paramChattingModel) {
            public void onClick(View param1View) {
              if (MessageChatAdapter.a(this.b) != null && (MessageChatAdapter.a(this.b)).u != null)
                (MessageChatAdapter.a(this.b)).u.a(this.a); 
            }
          });
      if (msgExtraGift.gift_like.giftTye == 3)
        textView2.setVisibility(0); 
      textView2 = (TextView)paramView.findViewById(2131300663);
      if (paramInt == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      textView2.setText(UserPagerGiftManager.a(bool, msgExtraGift, this.b, paramChattingModel.fromNickName));
      ImageLoader.a(b(), msgExtraGift.gift_like.img_url).a(imageView);
    } 
    if (paramInt == 1)
      textView1.setText(this.b.getResources().getString(2131757997)); 
    textView1.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            MessageChatAdapter.c(this.a).O();
          }
        });
    if (paramChattingModel.isFromSelf()) {
      textView1 = (TextView)paramView.findViewById(2131301355);
      TextView textView = (TextView)paramView.findViewById(2131301231);
      if (paramChattingModel.msgStateCode == 3) {
        textView.setVisibility(0);
        textView1.setVisibility(8);
        if (msgExtraGift != null && msgExtraGift.gift_like != null && msgExtraGift.gift_like.cardGift != null) {
          textView.setText(this.b.getString(2131757955));
          return;
        } 
        textView.setText(this.b.getString(2131757991));
        return;
      } 
      textView.setVisibility(8);
    } 
  }
  
  private void a(ChattingModel paramChattingModel, ImageView paramImageView) {
    if (TextUtils.isEmpty(paramChattingModel.msgContent))
      return; 
    if (paramImageView.getTag() != null && paramImageView.getTag().equals(paramChattingModel.msgContent))
      return; 
    ViewGroup.LayoutParams layoutParams = paramImageView.getLayoutParams();
    layoutParams.width = AppMethods.a(120);
    layoutParams.height = AppMethods.a(120);
    paramImageView.setLayoutParams(layoutParams);
    paramImageView.requestLayout();
    paramImageView.setImageResource(2131233430);
    paramImageView.setTag(paramChattingModel.msgContent);
    LoadOptions loadOptions = new LoadOptions();
    loadOptions.d = 2131233430;
    loadOptions.e = true;
    loadOptions.l = false;
    Logger.b(k, new Object[] { "emotionCode====", paramChattingModel.msgContent });
    EmoticonModel emoticonModel = EmotionManager.c(paramChattingModel.msgContent);
    if (emoticonModel == null) {
      EmotionManager.a(this.b, paramChattingModel.msgContent, new EmotionLoadListener(this, paramImageView, paramChattingModel, loadOptions) {
            public void a(EmoticonModel param1EmoticonModel) {
              if (param1EmoticonModel == null)
                return; 
              Logger.b(MessageChatAdapter.a(), new Object[] { "em.url111======", param1EmoticonModel.url_original });
              AppInfo.n().post(new Runnable(this, param1EmoticonModel) {
                    public void run() {
                      if (this.b.a.getTag() != null && this.b.a.getTag().equals(this.b.b.msgContent))
                        MessageChatAdapter.a(this.b.d, this.b.a, this.a.url_original, this.b.c); 
                    }
                  });
            }
            
            public void b(EmoticonModel param1EmoticonModel) {}
            
            public void c(EmoticonModel param1EmoticonModel) {}
          });
    } else {
      String str = emoticonModel.url_original;
      Logger.b(k, new Object[] { "em.url222======", str });
      a(paramImageView, str, loadOptions);
    } 
    paramImageView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            String str = (String)param1View.getTag();
            if (TextUtils.isEmpty(str))
              return; 
            FlutterRouter.a(this.a.b, str);
          }
        });
    paramImageView.setOnLongClickListener(new View.OnLongClickListener(this, paramChattingModel) {
          public boolean onLongClick(View param1View) {
            MessageChatAdapter.a(this.b, this.a);
            return false;
          }
        });
  }
  
  private void a(ChattingModel paramChattingModel, ImageView paramImageView1, ImageView paramImageView2) {
    this.at.c = AvatarUtils.a(0, i(paramChattingModel));
    if (paramImageView1 == null)
      return; 
    ImageLoader.a(b(), AvatarUtils.a(1, i(paramChattingModel))).a(2131234356).c().a(paramImageView1);
    paramImageView1.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this, paramChattingModel) {
            public void onClick(View param1View) {
              String str;
              if (MessageChatAdapter.e(this.b).c()) {
                if (IMV4Method.a(this.a.fromId) == 1) {
                  str = this.a.fromNickName;
                } else {
                  str = UserInfo.a().i().getName();
                } 
              } else if (IMV4Method.a(this.a.fromId) == 1) {
                str = MessageChatAdapter.e(this.b).e();
              } else {
                str = UserInfo.a().i().getName();
              } 
              UserBasicModel userBasicModel = new UserBasicModel();
              userBasicModel.uid = String.valueOf(this.a.fromId);
              userBasicModel.name = str;
              userBasicModel.avatar = MessageChatAdapter.f(this.b, this.a);
              if (userBasicModel.uid.equals((UserInfo.a().i()).uid)) {
                userBasicModel.is_show_vip_page = (BluedConfig.b().c()).is_show_vip_page;
              } else {
                userBasicModel.is_show_vip_page = this.b.e;
              } 
              if (MessageChatAdapter.e(this.b).c()) {
                UserInfoFragmentNew.a((Fragment)MessageChatAdapter.c(this.b).L(), userBasicModel, "group_chatting", 608);
                return;
              } 
              UserInfoFragmentNew.a((Fragment)MessageChatAdapter.c(this.b).L(), userBasicModel, "private_chatting", 608);
            }
          }));
    if (this.ay.c() && IMV4Method.a(paramChattingModel.fromId) == 1)
      paramImageView1.setOnLongClickListener(new View.OnLongClickListener(this, paramChattingModel) {
            public boolean onLongClick(View param1View) {
              try {
                if (!TextUtils.isEmpty(this.a.fromNickName)) {
                  if (MessageChatAdapter.j(this.b) != null && MessageChatAdapter.c(this.b).V() != null && MessageChatAdapter.c(this.b).M() != null) {
                    UserBasicModel userBasicModel = new UserBasicModel();
                    userBasicModel.uid = String.valueOf(this.a.fromId);
                    userBasicModel.name = this.a.fromNickName;
                    userBasicModel.avatar = MessageChatAdapter.f(this.b, this.a);
                    MessageChatAdapter.j(this.b).a(MessageChatAdapter.c(this.b).M(), userBasicModel, MessageChatAdapter.k(this.b), false);
                  } 
                  MessageChatAdapter.c(this.b).N();
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
              } 
              return true;
            }
          }); 
    UserRelationshipUtils.a(paramImageView2, paramChattingModel.fromVBadge, 3);
  }
  
  private void a(ChattingModel paramChattingModel, TextView paramTextView) {
    DialogUtils.b(this.aq);
    if (paramTextView != null)
      MessageChatMethod.a(paramChattingModel.isFromSelf(), paramChattingModel.sessionType, paramChattingModel.msgStateCode, paramTextView, paramChattingModel.fromNickName); 
  }
  
  private void a(ChattingModel paramChattingModel, TextView paramTextView, int paramInt) {
    String str1;
    String[] arrayOfString;
    if (paramChattingModel == null)
      return; 
    if (!this.ay.c()) {
      MessageProtos.Event event = MessageProtos.Event.PRIVATE_CHAT_OPTION_SHOW;
      MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramChattingModel.fromId);
      stringBuilder.append("");
      EventTrackMessage.a(event, strangerSource, stringBuilder.toString());
      InstantLog.a("private_chat_option_show");
    } 
    String str2 = paramChattingModel.msgContent;
    String str3 = paramChattingModel.msgTextTranslateContent;
    if (TextUtils.isEmpty(str2))
      return; 
    if (TextUtils.isEmpty(str3)) {
      str1 = this.b.getResources().getString(2131755467);
    } else if (paramChattingModel.msgTextTranslateIsShow == 1) {
      str1 = this.b.getResources().getString(2131755471);
    } else {
      str1 = this.b.getResources().getString(2131755467);
    } 
    if (paramChattingModel.fromId == Long.valueOf(UserInfo.a().i().getUid()).longValue()) {
      if (paramChattingModel.msgLocalId == 0L) {
        if (MessageChatMethod.a(paramChattingModel, this.ay)) {
          String[] arrayOfString1 = new String[4];
          arrayOfString1[0] = this.b.getResources().getString(2131756058);
          arrayOfString1[1] = str1;
          arrayOfString1[2] = this.b.getString(2131758626);
          arrayOfString1[3] = this.b.getString(2131758061);
          arrayOfString = arrayOfString1;
        } else {
          String[] arrayOfString1 = new String[3];
          arrayOfString1[0] = this.b.getResources().getString(2131756058);
          arrayOfString1[1] = (String)arrayOfString;
          arrayOfString1[2] = this.b.getString(2131758061);
          arrayOfString = arrayOfString1;
        } 
      } else {
        String[] arrayOfString1 = new String[2];
        arrayOfString1[0] = this.b.getResources().getString(2131756058);
        arrayOfString1[1] = (String)arrayOfString;
        arrayOfString = arrayOfString1;
      } 
    } else if (this.j != null) {
      String[] arrayOfString1 = new String[4];
      arrayOfString1[0] = this.b.getResources().getString(2131756058);
      arrayOfString1[1] = (String)arrayOfString;
      arrayOfString1[2] = this.b.getResources().getString(2131756088);
      arrayOfString1[3] = this.b.getString(2131758061);
      arrayOfString = arrayOfString1;
    } else {
      String[] arrayOfString1 = new String[3];
      arrayOfString1[0] = this.b.getResources().getString(2131756058);
      arrayOfString1[1] = (String)arrayOfString;
      arrayOfString1[2] = this.b.getResources().getString(2131756088);
      arrayOfString = arrayOfString1;
    } 
    CommonAlertDialog.a(this.b, "", arrayOfString, new DialogInterface.OnClickListener(this, paramChattingModel, str3, str2) {
          void a() {
            String str;
            MessageProtos.Event event = MessageProtos.Event.MSG_CLICK_BUBBLE_CLICK;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.fromId);
            stringBuilder.append("");
            EventTrackMessage.a(event, null, stringBuilder.toString());
            Context context = this.d.b;
            if (this.a.isFromSelf()) {
              str = "chat_msg_bubble_owner";
            } else {
              str = "chat_msg_bubble_guest";
            } 
            VipBubbleFragment.a(context, 0, str);
          }
          
          void b() {
            String str;
            if (this.a.msgTextTranslateIsShow == 1) {
              if (!TextUtils.isEmpty(this.b)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.c);
                stringBuilder.append("\n\n");
                stringBuilder.append(this.b);
                str = stringBuilder.toString();
              } else {
                str = this.c;
              } 
            } else {
              str = this.c;
            } 
            FileUtils.a(this.d.b, str);
          }
          
          void c() {
            MessageChatMethod.a(this.d.b, this.a, this.d.a, MessageChatAdapter.e(this.d), MessageChatAdapter.c(this.d));
          }
          
          void d() {
            if (TextUtils.isEmpty(this.b)) {
              MessageChatAdapter.b(this.d, this.c, this.a);
              return;
            } 
            if (this.a.msgTextTranslateIsShow == 1) {
              MessageChatAdapter.c(this.d, this.a);
              return;
            } 
            MessageChatAdapter.d(this.d, this.a);
          }
          
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (this.a.isFromSelf()) {
              if (param1Int != 0) {
                if (param1Int != 1) {
                  if (param1Int != 2) {
                    if (param1Int != 3)
                      return; 
                    a();
                    return;
                  } 
                  if (MessageChatMethod.a(this.a, MessageChatAdapter.e(this.d))) {
                    MessageChatMethod.a(this.d.b, this.a, MessageChatAdapter.e(this.d));
                    return;
                  } 
                  a();
                  return;
                } 
                d();
                return;
              } 
              b();
              return;
            } 
            if (param1Int != 0) {
              if (param1Int != 1) {
                if (param1Int != 2) {
                  if (param1Int != 3)
                    return; 
                  a();
                  return;
                } 
                c();
                return;
              } 
              d();
              return;
            } 
            b();
          }
        }new DialogInterface.OnDismissListener(this, paramTextView, paramChattingModel, paramInt) {
          public void onDismiss(DialogInterface param1DialogInterface) {
            MessageChatAdapter.a(this.d, this.a, this.b.msgContent, this.c, new boolean[0]);
          }
        });
  }
  
  private void a(ChattingModel paramChattingModel, TextView paramTextView, ImageView paramImageView1, ImageView paramImageView2) {
    if (paramImageView1 == null)
      return; 
    AnimationDrawable animationDrawable = (AnimationDrawable)paramImageView1.getBackground();
    if (paramTextView != null && animationDrawable != null) {
      if (this.ay.c()) {
        short s1 = paramChattingModel.msgStateCode;
        if (s1 != 1) {
          if (s1 != 6) {
            paramTextView.setVisibility(4);
            paramImageView1.setVisibility(4);
            animationDrawable.stop();
            paramImageView2.setVisibility(8);
            return;
          } 
          paramImageView1.setVisibility(8);
          animationDrawable.stop();
          paramTextView.setVisibility(4);
          paramImageView2.setVisibility(0);
          return;
        } 
        paramTextView.setVisibility(4);
        paramImageView1.setVisibility(0);
        animationDrawable.start();
        paramImageView2.setVisibility(8);
        return;
      } 
      paramTextView.setTextColor(this.b.getResources().getColor(2131100235));
      short s = paramChattingModel.msgStateCode;
      if (s != 1) {
        if (s != 2) {
          if (s != 3) {
            if (s != 6) {
              paramTextView.setVisibility(4);
              paramImageView1.setVisibility(4);
              animationDrawable.stop();
              paramImageView2.setVisibility(8);
              return;
            } 
            paramImageView1.setVisibility(8);
            animationDrawable.stop();
            paramTextView.setVisibility(4);
            paramImageView2.setVisibility(0);
            return;
          } 
          paramImageView1.setVisibility(4);
          animationDrawable.stop();
          paramTextView.setVisibility(0);
          paramTextView.setText(b(paramChattingModel.msgStateCode));
          paramImageView2.setVisibility(8);
          return;
        } 
        paramImageView1.setVisibility(4);
        animationDrawable.stop();
        paramTextView.setVisibility(0);
        paramTextView.setText(b(paramChattingModel.msgStateCode));
        paramImageView2.setVisibility(8);
        MsgChattingFragment msgChattingFragment = this.aA;
        if (msgChattingFragment != null) {
          msgChattingFragment.A();
          return;
        } 
      } else {
        paramTextView.setVisibility(4);
        paramImageView1.setVisibility(0);
        animationDrawable.start();
        paramImageView2.setVisibility(8);
      } 
    } 
  }
  
  private void a(ChattingModel paramChattingModel, MsgExtraForTextTypeEntity.SecureNotify paramSecureNotify, View paramView1, View paramView2) {
    View view1 = (View)ViewHolder.a(paramView2, 2131296810);
    TextView textView2 = ViewHolder.<TextView>a(paramView2, 2131296816);
    View view2 = (View)ViewHolder.a(paramView2, 2131296821);
    View view3 = (View)ViewHolder.a(paramView2, 2131296817);
    RelativeLayout relativeLayout = ViewHolder.<RelativeLayout>a(paramView2, 2131296815);
    TextView textView3 = ViewHolder.<TextView>a(paramView2, 2131296814);
    RecyclerView recyclerView = ViewHolder.<RecyclerView>a(paramView2, 2131296811);
    View view4 = (View)ViewHolder.a(paramView2, 2131296812);
    TextView textView1 = ViewHolder.<TextView>a(paramView2, 2131296813);
    ImageView imageView = ViewHolder.<ImageView>a(paramView2, 2131296803);
    if (paramSecureNotify.multi_contents != null && paramSecureNotify.multi_contents.size() > 0) {
      paramView1.setVisibility(0);
      view1.setVisibility(0);
      if (BluedConfig.b().t()) {
        imageView.setVisibility(8);
        view2.setVisibility(8);
        relativeLayout.setVisibility(4);
        recyclerView.setVisibility(0);
        view4.setVisibility(0);
        BluedPreferences.bU();
      } else {
        imageView.setVisibility(0);
        view2.setVisibility(0);
        view3.setOnClickListener(new View.OnClickListener(this, recyclerView, view4, relativeLayout) {
              public void onClick(View param1View) {
                if (this.a.getVisibility() == 0) {
                  this.a.setVisibility(8);
                  this.b.setVisibility(8);
                  this.c.setVisibility(0);
                  param1View.setSelected(false);
                  return;
                } 
                this.a.setVisibility(0);
                this.b.setVisibility(0);
                this.c.setVisibility(4);
                param1View.setSelected(true);
              }
            });
        if (BluedPreferences.bT()) {
          BluedPreferences.bU();
          recyclerView.setVisibility(0);
          view4.setVisibility(0);
          relativeLayout.setVisibility(4);
          imageView.setSelected(true);
        } else {
          recyclerView.setVisibility(8);
          view4.setVisibility(8);
          relativeLayout.setVisibility(0);
          imageView.setSelected(false);
        } 
      } 
      textView1.setOnClickListener(new View.OnClickListener(this, paramChattingModel) {
            public void onClick(View param1View) {
              Context context = this.b.b;
              List<ChattingModel> list = this.b.a;
              ChattingModel chattingModel = this.a;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(MessageChatAdapter.e(this.b).f());
              stringBuilder.append("");
              MsgCommonUtils.a(context, list, chattingModel, stringBuilder.toString(), 6, 0, (IRequestHost)MessageChatAdapter.c(this.b).w_());
            }
          });
      if (!TextUtils.isEmpty(paramSecureNotify.title)) {
        textView2.setVisibility(0);
        textView2.setText(paramSecureNotify.title);
      } else {
        textView2.setVisibility(8);
      } 
      if (!TextUtils.isEmpty(paramSecureNotify.collapse_desc)) {
        textView3.setText(paramSecureNotify.collapse_desc);
        textView3.setVisibility(0);
      } else {
        textView3.setVisibility(4);
      } 
      if (recyclerView.getItemDecorationCount() <= 0) {
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(0, DensityUtils.a(AppInfo.d(), 5.0F), DensityUtils.a(AppInfo.d(), 4.0F), DensityUtils.a(AppInfo.d(), 5.0F));
        spacesItemDecoration.a(5);
        recyclerView.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(this, this.b, 3) {
              public boolean canScrollVertically() {
                return false;
              }
            });
        recyclerView.addItemDecoration((RecyclerView.ItemDecoration)spacesItemDecoration);
      } 
      recyclerView.setAdapter(new SafeCommonContentListAdapter(paramSecureNotify.multi_contents));
      if (!TextUtils.isEmpty(paramSecureNotify.report_title)) {
        textView1.setText(paramSecureNotify.report_title);
        textView1.setVisibility(0);
        return;
      } 
      textView1.setVisibility(8);
    } 
  }
  
  private void a(ChattingModel paramChattingModel, String paramString) {
    paramChattingModel.msgTextTranslateStatus = 2;
    paramChattingModel.msgTextTranslateIsShow = 1;
    paramChattingModel.msgTextTranslateContent = paramString;
    h(paramChattingModel);
  }
  
  private void a(ChattingModel paramChattingModel, String paramString, View paramView, int paramInt) {
    IMV4Method.a(paramChattingModel.fromId);
    ImageView imageView = (ImageView)paramView.findViewById(2131299235);
    TextView textView = (TextView)paramView.findViewById(2131299236);
    if (imageView != null) {
      if (textView == null)
        return; 
      if (TextUtils.isEmpty(paramString)) {
        textView.setText(2131755465);
        imageView.setImageResource(2131232468);
        return;
      } 
      textView.setText(2131755466);
      if (paramInt != 1) {
        if (paramInt != 2)
          return; 
        imageView.setImageResource(2131232598);
        return;
      } 
      imageView.setImageResource(2131232597);
    } 
  }
  
  private void a(SelectFrameLayout paramSelectFrameLayout, View paramView1, TextView paramTextView, View paramView2, ChattingModel paramChattingModel) {
    if (paramSelectFrameLayout == null)
      return; 
    boolean bool = Locale.getDefault().getLanguage().equals("en");
    boolean bool1 = false;
    if (!bool && paramView1.getVisibility() != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    paramSelectFrameLayout.setTurnTextVisibility(bool);
    if (paramChattingModel.isFromSelf()) {
      paramSelectFrameLayout.setRepostVisibility(false);
      paramSelectFrameLayout.setBubbleVisibility(true);
    } else {
      paramSelectFrameLayout.setRepostVisibility(true);
      bool = bool1;
      if (this.j != null)
        bool = true; 
      paramSelectFrameLayout.setBubbleVisibility(bool);
    } 
    paramSelectFrameLayout.setRecallVisibility(MessageChatMethod.a(paramChattingModel, this.ay));
    paramSelectFrameLayout.setSelectableItemOnClickListener(new SelectableItemOnClickListener(this, paramChattingModel, paramView1, paramTextView, paramView2) {
          public void a() {
            MessageChatMethod.a(this.e.b, this.a, MessageChatAdapter.e(this.e));
          }
          
          public void b() {}
          
          public void c() {
            MessageChatMethod.a(this.b, this.c, this.d, this.a, MessageChatAdapter.h(this.e), MessageChatAdapter.c(this.e), MessageChatAdapter.i(this.e));
          }
          
          public void d() {
            MessageChatMethod.a(this.e.b, this.a, this.e.a, MessageChatAdapter.e(this.e), MessageChatAdapter.c(this.e));
          }
          
          public void e() {
            MessageChatMethod.a(this.e.b, this.a);
          }
          
          public void f() {}
        });
    paramSelectFrameLayout.setSelectableOnShowListener(new SelectableOnShowListener(this, paramChattingModel) {
          public void a() {
            if (!MessageChatAdapter.e(this.b).c()) {
              MessageProtos.Event event = MessageProtos.Event.PRIVATE_CHAT_OPTION_SHOW;
              MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.a.fromId);
              stringBuilder.append("");
              EventTrackMessage.a(event, strangerSource, stringBuilder.toString());
              InstantLog.a("private_chat_option_show");
            } 
          }
        });
  }
  
  private void a(SelectFrameLayout paramSelectFrameLayout, ChattingModel paramChattingModel) {
    if (paramSelectFrameLayout == null)
      return; 
    paramSelectFrameLayout.setSelectableOnChangeListener(new SelectableOnChangeListener(this, paramSelectFrameLayout) {
          public void a(CharSequence param1CharSequence, boolean param1Boolean) {
            if (param1Boolean) {
              this.a.setCancelVisibility(true);
              return;
            } 
            this.a.setCancelVisibility(false);
          }
        });
    paramSelectFrameLayout.setSelectableItemOnClickListener((SelectableItemOnClickListener)new SelectableItemOnClickListener2(this, paramChattingModel, paramSelectFrameLayout) {
          public void f() {
            MessageChatAdapter.h(this.c).remove(Long.valueOf(this.a.msgId));
            MessageChatMethod.a((View)this.b, MessageChatAdapter.c(this.c), this.a);
          }
        });
    paramSelectFrameLayout.setSelectableOnShowListener(new SelectableOnShowListener(this, paramChattingModel) {
          public void a() {
            if (!MessageChatAdapter.e(this.b).c()) {
              MessageProtos.Event event = MessageProtos.Event.PRIVATE_CHAT_OPTION_SHOW;
              MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.a.fromId);
              stringBuilder.append("");
              EventTrackMessage.a(event, strangerSource, stringBuilder.toString());
              InstantLog.a("private_chat_option_show");
            } 
          }
        });
  }
  
  private void a(MsgExtraForTextTypeEntity.SecureNotify paramSecureNotify, View paramView1, View paramView2) {
    View view = (View)ViewHolder.a(paramView2, 2131300159);
    TextView textView = ViewHolder.<TextView>a(paramView2, 2131300160);
    if (!TextUtils.isEmpty(paramSecureNotify.contents)) {
      paramView1.setVisibility(0);
      view.setVisibility(0);
      textView.setVisibility(0);
      textView.setMovementMethod(ScrollingMovementMethod.getInstance());
      textView.setText((CharSequence)Html.fromHtml(paramSecureNotify.contents));
      textView.setOnClickListener(new View.OnClickListener(this, paramSecureNotify) {
            public void onClick(View param1View) {
              if (!TextUtils.isEmpty(this.a.link))
                WebViewShowInfoFragment.show(this.b.b, this.a.link, -1); 
            }
          });
      view.setOnClickListener(new View.OnClickListener(this, paramSecureNotify) {
            public void onClick(View param1View) {
              if (!TextUtils.isEmpty(this.a.link))
                WebViewShowInfoFragment.show(this.b.b, this.a.link, -1); 
            }
          });
    } 
  }
  
  private void a(MsgSourceEntity paramMsgSourceEntity, View paramView1, View paramView2, String paramString) {
    if (paramView1 != null) {
      View view = (View)ViewHolder.a(paramView2, 2131299297);
      TextView textView = ViewHolder.<TextView>a(paramView2, 2131299298);
      paramView1.setVisibility(0);
      if (view != null) {
        String str = MsgCommonUtils.a(AppInfo.d(), paramMsgSourceEntity.getType(), paramMsgSourceEntity.getContent(), paramString);
        if (StringUtils.e(str)) {
          view.setVisibility(8);
          return;
        } 
        view.setVisibility(0);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setText((CharSequence)Html.fromHtml(str));
        textView.setOnClickListener(new View.OnClickListener(this, paramMsgSourceEntity) {
              public void onClick(View param1View) {
                MsgCommonUtils.a(this.b.b, this.a.getType(), this.a.getContent());
              }
            });
        view.setOnClickListener(new View.OnClickListener(this, paramMsgSourceEntity) {
              public void onClick(View param1View) {
                MsgCommonUtils.a(this.b.b, this.a.getType(), this.a.getContent());
              }
            });
      } 
    } 
  }
  
  private void a(MsgSourceEntity paramMsgSourceEntity, View paramView, String paramString) {
    a(paramMsgSourceEntity, ViewHolder.a(paramView, 2131298022), paramView, paramString);
  }
  
  private int b(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? ((paramInt != 4) ? ((paramInt != 6) ? 0 : 2131758903) : 2131758904) : 2131758905) : 2131758906) : 2131758907;
  }
  
  private IRequestHost b() {
    MsgChattingFragment msgChattingFragment = this.aA;
    return (IRequestHost)((msgChattingFragment != null) ? msgChattingFragment.w_() : null);
  }
  
  private void b(int paramInt, TextView paramTextView) {
    ChattingModel chattingModel = this.a.get(paramInt);
    if (chattingModel.isShowTime) {
      a(chattingModel.msgTimestamp, paramTextView);
      return;
    } 
    paramTextView.setVisibility(8);
  }
  
  private void b(ChattingModel paramChattingModel) {
    String[] arrayOfString;
    DialogInterface.OnClickListener onClickListener;
    if (MessageChatMethod.a(paramChattingModel, this.ay) && MessageChatMethod.b(paramChattingModel, this.ay)) {
      String[] arrayOfString1 = new String[2];
      arrayOfString1[0] = this.b.getString(2131756088);
      arrayOfString1[1] = this.b.getString(2131758626);
      DialogInterface.OnClickListener onClickListener1 = new DialogInterface.OnClickListener(this, paramChattingModel) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (param1Int != 0) {
              if (param1Int != 1)
                return; 
              MessageChatMethod.a(this.b.b, this.a, MessageChatAdapter.e(this.b));
              return;
            } 
            MessageChatMethod.a(this.b.b, this.a, this.b.a, MessageChatAdapter.e(this.b), MessageChatAdapter.c(this.b));
          }
        };
      arrayOfString = arrayOfString1;
      onClickListener = onClickListener1;
    } else if (MessageChatMethod.a((ChattingModel)arrayOfString, this.ay)) {
      String[] arrayOfString1 = new String[1];
      arrayOfString1[0] = this.b.getString(2131758626);
      DialogInterface.OnClickListener onClickListener1 = new DialogInterface.OnClickListener(this, (ChattingModel)arrayOfString) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (param1Int != 0)
              return; 
            MessageChatMethod.a(this.b.b, this.a, MessageChatAdapter.e(this.b));
          }
        };
      arrayOfString = arrayOfString1;
      onClickListener = onClickListener1;
    } else if (MessageChatMethod.b((ChattingModel)arrayOfString, this.ay)) {
      String[] arrayOfString1 = new String[1];
      arrayOfString1[0] = this.b.getString(2131756088);
      onClickListener = new DialogInterface.OnClickListener(this, (ChattingModel)arrayOfString) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (param1Int != 0)
              return; 
            MessageChatMethod.a(this.b.b, this.a, this.b.a, MessageChatAdapter.e(this.b), MessageChatAdapter.c(this.b));
          }
        };
      arrayOfString = arrayOfString1;
    } else {
      return;
    } 
    CommonAlertDialog.a(this.b, "", arrayOfString, onClickListener, new DialogInterface.OnDismissListener(this) {
          public void onDismiss(DialogInterface param1DialogInterface) {}
        });
  }
  
  private void b(ChattingModel paramChattingModel, View paramView) {
    ((ShapeTextView)paramView.findViewById(2131301124)).setText(paramChattingModel.msgContent);
  }
  
  private void b(ChattingModel paramChattingModel, View paramView, int paramInt) {
    if (!TextUtils.isEmpty(paramChattingModel.msgContent)) {
      IMsgChatAdapterCallback iMsgChatAdapterCallback;
      if (paramView == null)
        return; 
      ViewHolder.a(paramView, 2131296700);
      SelectFrameLayout selectFrameLayout1 = ViewHolder.<SelectFrameLayout>a(paramView, 2131299886);
      SelectFrameLayout selectFrameLayout2 = ViewHolder.<SelectFrameLayout>a(paramView, 2131299887);
      TextView textView1 = ViewHolder.<TextView>a(paramView, 2131301038);
      TextView textView2 = ViewHolder.<TextView>a(paramView, 2131301039);
      View view1 = (View)ViewHolder.a(paramView, 2131299243);
      View view2 = (View)ViewHolder.a(paramView, 2131300315);
      ImageView imageView = ViewHolder.<ImageView>a(paramView, 2131301040);
      TextView textView3 = ViewHolder.<TextView>a(paramView, 2131301041);
      TextView textView4 = ViewHolder.<TextView>a(paramView, 2131301212);
      if (paramInt == 0) {
        textView2.setTextColor(this.b.getResources().getColor(2131100728));
      } else {
        textView2.setTextColor(this.b.getResources().getColor(2131100838));
      } 
      try {
        MsgExtraForTextTypeEntity msgExtraForTextTypeEntity = (MsgExtraForTextTypeEntity)AppInfo.f().fromJson(paramChattingModel.getMsgExtra(), MsgExtraForTextTypeEntity.class);
      } catch (Exception exception) {
        exception = null;
      } 
      if (exception != null && !TextUtils.isEmpty(((MsgExtraForTextTypeEntity)exception).quote)) {
        textView4.setVisibility(0);
        textView4.setText(((MsgExtraForTextTypeEntity)exception).quote);
      } else {
        textView4.setVisibility(8);
      } 
      j(paramChattingModel, paramView);
      String str = a((MsgExtraForTextTypeEntity)exception);
      if (TextUtils.isEmpty(str)) {
        boolean bool;
        str = paramChattingModel.msgContent;
        if (paramChattingModel.fromVBadge == 3) {
          bool = true;
        } else {
          bool = false;
        } 
        a(textView1, str, paramInt, new boolean[] { bool });
      } else {
        boolean bool;
        textView1.setMovementMethod((MovementMethod)LinkMovementClickMethod.a());
        Context context = this.b;
        if (paramChattingModel.fromVBadge == 3) {
          bool = true;
        } else {
          bool = false;
        } 
        textView1.setText((CharSequence)TypefaceUtils.a(context, str, bool));
      } 
      if (paramChattingModel.msgTextTranslateStatus == 1) {
        textView2.setVisibility(8);
        view2.setVisibility(8);
        view1.setVisibility(0);
        imageView.setImageResource(2131232762);
        textView3.setText(2131755470);
      } else if (paramChattingModel.msgTextTranslateStatus == 2) {
        if (paramChattingModel.msgTextTranslateIsShow == 1) {
          textView2.setVisibility(0);
          view2.setVisibility(0);
          a(textView2, paramChattingModel.msgTextTranslateContent, paramInt, new boolean[0]);
          view1.setVisibility(0);
          imageView.setImageResource(2131232761);
          textView3.setText(2131755468);
        } else {
          textView2.setVisibility(8);
          view2.setVisibility(8);
          view1.setVisibility(8);
        } 
      } else {
        textView2.setVisibility(8);
        view2.setVisibility(8);
        view1.setVisibility(8);
      } 
      b(selectFrameLayout1, paramChattingModel);
      b(selectFrameLayout2, paramChattingModel);
      str = ViewHolder.a(paramView, 2131296700);
      paramView = ViewHolder.a(paramView, 2131299242);
      if (paramChattingModel.isFromSelf()) {
        if (paramView != null) {
          VipBubbleManager.a().a(0, 1, new View[] { paramView });
          textView1.setTextColor(ContextCompat.getColor(this.b, 2131100980));
          textView2.setTextColor(ContextCompat.getColor(this.b, 2131100980));
        } 
        VipBubbleModel vipBubbleModel = VipBubbleManager.a().c();
        if (vipBubbleModel != null) {
          iMsgChatAdapterCallback = this.ay;
          if (iMsgChatAdapterCallback != null && !iMsgChatAdapterCallback.c()) {
            try {
              textView1.setTextColor(Color.parseColor(vipBubbleModel.text_color));
              textView2.setTextColor(Color.parseColor(vipBubbleModel.text_color));
            } finally {}
            VipBubbleManager.a().b(vipBubbleModel, 1, new View[] { paramView });
            return;
          } 
        } 
      } else {
        if (iMsgChatAdapterCallback != null) {
          textView1.setTextColor(BluedSkinUtils.a(this.b, 2131100838));
          textView2.setTextColor(BluedSkinUtils.a(this.b, 2131100838));
          VipBubbleManager.a().a(0, 0, new View[] { (View)iMsgChatAdapterCallback });
        } 
        VipBubbleModel vipBubbleModel = this.j;
        if (vipBubbleModel != null) {
          try {
            textView1.setTextColor(Color.parseColor(vipBubbleModel.text_color));
            textView2.setTextColor(Color.parseColor(this.j.text_color));
          } finally {}
          VipBubbleManager.a().b(this.j, 0, new View[] { (View)iMsgChatAdapterCallback });
        } 
      } 
    } 
  }
  
  private void b(ChattingModel paramChattingModel, View paramView1, View paramView2) {
    if (!TextUtils.isEmpty(paramChattingModel.msgContent)) {
      int i;
      int j;
      if (paramView2 == null)
        return; 
      MsgChattingImageModel msgChattingImageModel = ChatHelperV4.a().d(paramChattingModel);
      if (msgChattingImageModel != null) {
        i = msgChattingImageModel.getPicWidth();
        j = msgChattingImageModel.getPicHeight();
      } else {
        i = AppInfo.l / 3;
        j = i;
      } 
      ImageView imageView = (ImageView)paramView2.findViewById(2131297539);
      if (imageView != null) {
        ImageWrapper imageWrapper;
        if (i != 0 && j != 0) {
          int[] arrayOfInt = ImageUtils.a(i, j, AppInfo.l / 2, AppInfo.l / 2, AppInfo.l / 3, AppInfo.l / 3);
          ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
          layoutParams.width = arrayOfInt[0];
          layoutParams.height = arrayOfInt[1];
          imageView.setLayoutParams(layoutParams);
        } 
        String str = paramChattingModel.msgContent;
        if ((true ^ str.contains("http")) != 0) {
          imageWrapper = ImageLoader.d(b(), str);
        } else {
          imageWrapper = ImageLoader.a(b(), str);
        } 
        imageWrapper.a(14.0F).a(2131231370).a(imageView);
        imageView.setOnClickListener(new View.OnClickListener(this, str, imageView) {
              public void onClick(View param1View) {
                ArrayList arrayList = IMV4Method.a(this.c.a);
                String[] arrayOfString = (String[])arrayList.toArray((Object[])new String[arrayList.size()]);
                int i = IMV4Method.a(arrayList, this.a);
                BasePhotoFragment.a(this.c.b, arrayOfString, i, 5, null, "", (View)this.b, this.a);
              }
            });
        if (!paramChattingModel.isFromSelf()) {
          imageView.setOnLongClickListener(new View.OnLongClickListener(this, paramChattingModel) {
                public boolean onLongClick(View param1View) {
                  if (!MessageChatAdapter.e(this.b).c()) {
                    MessageProtos.Event event = MessageProtos.Event.PRIVATE_CHAT_OPTION_SHOW;
                    MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.a.fromId);
                    stringBuilder.append("");
                    EventTrackMessage.a(event, strangerSource, stringBuilder.toString());
                    InstantLog.a("private_chat_option_show");
                  } 
                  MessageChatAdapter.b(this.b, this.a);
                  return false;
                }
              });
          if (msgChattingImageModel != null && paramChattingModel.msgId == 1L && msgChattingImageModel.getMsgSource() != null && (BluedConfig.b().v() || msgChattingImageModel.getMsgSource().getType() == MessageProtos.StrangerSource.SHADOW_SOURCE)) {
            a(msgChattingImageModel.getMsgSource(), paramView1, String.valueOf(paramChattingModel.fromId));
            return;
          } 
        } else {
          imageView.setOnLongClickListener(new View.OnLongClickListener(this, paramChattingModel) {
                public boolean onLongClick(View param1View) {
                  MessageChatAdapter.a(this.b, this.a);
                  return false;
                }
              });
        } 
      } 
    } 
  }
  
  private void b(ChattingModel paramChattingModel, View paramView, short paramShort, int paramInt) {
    ((TextView)paramView.findViewById(2131301038)).setText(this.b.getResources().getString(2131758081));
    if (paramInt == 1)
      ((TextView)paramView.findViewById(2131301494)).setOnClickListener(new View.OnClickListener(this, paramChattingModel) {
            public void onClick(View param1View) {
              Context context = this.b.b;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.a.fromId);
              stringBuilder.append("");
              UserInfoFragmentNew.b(context, stringBuilder.toString(), "private_chatting");
            }
          }); 
  }
  
  private void b(ChattingModel paramChattingModel, MsgExtraForTextTypeEntity.SecureNotify paramSecureNotify, View paramView1, View paramView2) {
    View view = (View)ViewHolder.a(paramView2, 2131299900);
    ImageView imageView = ViewHolder.<ImageView>a(paramView2, 2131299897);
    TextView textView2 = ViewHolder.<TextView>a(paramView2, 2131299908);
    RecyclerView recyclerView = ViewHolder.<RecyclerView>a(paramView2, 2131299903);
    TextView textView1 = ViewHolder.<TextView>a(paramView2, 2131299904);
    TextView textView3 = ViewHolder.<TextView>a(paramView2, 2131299906);
    if (!TextUtils.isEmpty(paramSecureNotify.title) || !TextUtils.isEmpty(paramSecureNotify.link_title)) {
      RelativeLayout.LayoutParams layoutParams;
      paramView1.setVisibility(0);
      view.setVisibility(0);
      View view1 = (View)ViewHolder.a(paramView2, 2131299898);
      view = ViewHolder.a(paramView2, 2131299902);
      textView1 = ViewHolder.a(paramView2, 2131299899);
      TextView textView = ViewHolder.<TextView>a(paramView2, 2131299907);
      ImageView imageView1 = ViewHolder.<ImageView>a(paramView2, 2131299901);
      if (!TextUtils.isEmpty(paramSecureNotify.title)) {
        textView2.setVisibility(0);
        textView2.setText(paramSecureNotify.title);
      } else {
        textView2.setVisibility(8);
      } 
      if (paramSecureNotify.multi_contents != null) {
        if (recyclerView.getItemDecorationCount() <= 0) {
          SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(0, 0, 0, DensityUtils.a(AppInfo.d(), 5.0F));
          spacesItemDecoration.a(1);
          recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this, this.b) {
                public boolean canScrollVertically() {
                  return false;
                }
              });
          recyclerView.addItemDecoration((RecyclerView.ItemDecoration)spacesItemDecoration);
        } 
        recyclerView.setAdapter(new SafeSensitiveContentListAdapter(paramSecureNotify.multi_contents, paramSecureNotify.highlight_keywords));
      } else {
        recyclerView.setVisibility(8);
      } 
      if (!TextUtils.isEmpty(paramSecureNotify.link_title) && !TextUtils.isEmpty(paramSecureNotify.link)) {
        textView3.setText(paramSecureNotify.link_title);
        view1.setVisibility(0);
        imageView1.setVisibility(8);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      } else {
        view1.setVisibility(8);
        layoutParams.setVisibility(0);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.leftMargin = DensityUtils.a(this.b, 10.0F);
        textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      } 
      if (!TextUtils.isEmpty(paramSecureNotify.report_title)) {
        textView.setText(paramSecureNotify.report_title);
        view.setVisibility(0);
        textView1.setVisibility(0);
        textView1.setOnClickListener(new View.OnClickListener(this, paramChattingModel) {
              public void onClick(View param1View) {
                Context context = this.b.b;
                List<ChattingModel> list = this.b.a;
                ChattingModel chattingModel = this.a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(MessageChatAdapter.e(this.b).f());
                stringBuilder.append("");
                MsgCommonUtils.a(context, list, chattingModel, stringBuilder.toString(), 6, 0, (IRequestHost)MessageChatAdapter.c(this.b).w_());
              }
            });
      } else {
        view.setVisibility(8);
        textView1.setVisibility(8);
      } 
      imageView.setVisibility(0);
      ImageLoader.a(b(), paramSecureNotify.icon).a(imageView);
      paramView1.setOnClickListener(new View.OnClickListener(this, paramSecureNotify) {
            public void onClick(View param1View) {
              if (!TextUtils.isEmpty(this.a.link))
                WebViewShowInfoFragment.show(this.b.b, this.a.link, -1); 
            }
          });
    } 
  }
  
  private void b(SelectFrameLayout paramSelectFrameLayout, ChattingModel paramChattingModel) {
    if (paramSelectFrameLayout == null)
      return; 
    boolean bool1 = paramChattingModel.isFromSelf();
    boolean bool = true;
    if (bool1) {
      paramSelectFrameLayout.setRecallVisibility(MessageChatMethod.a(paramChattingModel, this.ay));
      paramSelectFrameLayout.setTranslateVisibility(true);
      paramSelectFrameLayout.setBubbleVisibility(true);
    } else {
      paramSelectFrameLayout.setTranslateVisibility(true);
      paramSelectFrameLayout.setRepostVisibility(true);
      if (this.j == null)
        bool = false; 
      paramSelectFrameLayout.setBubbleVisibility(bool);
    } 
    paramSelectFrameLayout.setSelectableOnChangeListener(new SelectableOnChangeListener(this, paramSelectFrameLayout, paramChattingModel) {
          public void a(CharSequence param1CharSequence, boolean param1Boolean) {
            boolean bool = true;
            if (param1Boolean) {
              this.a.setSelectAllVisibility(false);
              if (this.b.isFromSelf()) {
                this.a.setTranslateVisibility(true);
                this.a.setRepostVisibility(false);
                this.a.setBubbleVisibility(true);
              } else {
                this.a.setRecallVisibility(false);
                this.a.setTranslateVisibility(true);
                this.a.setRepostVisibility(true);
                SelectFrameLayout selectFrameLayout = this.a;
                if (this.c.j != null) {
                  param1Boolean = bool;
                } else {
                  param1Boolean = false;
                } 
                selectFrameLayout.setBubbleVisibility(param1Boolean);
              } 
              this.a.setRecallVisibility(MessageChatMethod.a(this.b, MessageChatAdapter.e(this.c)));
              return;
            } 
            this.a.setSelectAllVisibility(true);
            this.a.setRecallVisibility(false);
            this.a.setTranslateVisibility(false);
            this.a.setRepostVisibility(false);
            this.a.setBubbleVisibility(false);
          }
        });
    paramSelectFrameLayout.setSelectableItemOnClickListener(new SelectableItemOnClickListener(this, paramChattingModel) {
          public void a() {
            MessageChatMethod.a(this.b.b, this.a, MessageChatAdapter.e(this.b));
          }
          
          public void b() {
            MessageChatMethod.a(this.a, MessageChatAdapter.c(this.b));
          }
          
          public void c() {}
          
          public void d() {
            MessageChatMethod.a(this.b.b, this.a, this.b.a, MessageChatAdapter.e(this.b), MessageChatAdapter.c(this.b));
          }
          
          public void e() {
            MessageChatMethod.a(this.b.b, this.a);
          }
          
          public void f() {}
        });
    paramSelectFrameLayout.setSelectableOnShowListener(new SelectableOnShowListener(this, paramChattingModel) {
          public void a() {
            if (!MessageChatAdapter.e(this.b).c()) {
              MessageProtos.Event event = MessageProtos.Event.PRIVATE_CHAT_OPTION_SHOW;
              MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.a.fromId);
              stringBuilder.append("");
              EventTrackMessage.a(event, strangerSource, stringBuilder.toString());
              InstantLog.a("private_chat_option_show");
            } 
          }
        });
  }
  
  private void b(String paramString, ChattingModel paramChattingModel) {
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
      d(paramChattingModel);
      ChatHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<MsgContentTranslatedEntity>>(this, paramChattingModel) {
            boolean a;
            
            protected void a(BluedEntityA<MsgContentTranslatedEntity> param1BluedEntityA) {
              if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
                MsgContentTranslatedEntity msgContentTranslatedEntity = param1BluedEntityA.data.get(0);
                if (msgContentTranslatedEntity != null && msgContentTranslatedEntity.trans_result != null && msgContentTranslatedEntity.trans_result.size() > 0) {
                  String str = ((MsgContentTranslatedEntity.TranslateResult)msgContentTranslatedEntity.trans_result.get(0)).dst;
                  if (!TextUtils.isEmpty(str))
                    MessageChatAdapter.a(this.c, this.b, str); 
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
                MessageChatAdapter.e(this.c, this.b);
              } 
            }
          }str, (IRequestHost)this.az.w_());
    } 
  }
  
  private void c() {
    AppMethods.d(2131758077);
  }
  
  private void c(ChattingModel paramChattingModel) {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.b.getResources().getString(2131756088);
    if (MessageChatMethod.a(paramChattingModel, this.ay)) {
      arrayOfString = new String[2];
      arrayOfString[0] = this.b.getResources().getString(2131756088);
      arrayOfString[1] = this.b.getResources().getString(2131758626);
    } 
    CommonAlertDialog.a(this.b, "", arrayOfString, new DialogInterface.OnClickListener(this, paramChattingModel) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (param1Int != 0) {
              if (param1Int != 1)
                return; 
              MessageChatMethod.a(this.b.b, this.a, MessageChatAdapter.e(this.b));
              return;
            } 
            MessageChatMethod.a(this.b.b, this.a, this.b.a, MessageChatAdapter.e(this.b), MessageChatAdapter.c(this.b));
          }
        });
  }
  
  private void c(ChattingModel paramChattingModel, View paramView) {
    StringBuilder stringBuilder1;
    TextView textView = (TextView)paramView.findViewById(2131300890);
    ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout)paramView.findViewById(2131297191);
    ShapeHelper.b((ShapeHelper.ShapeView)shapeFrameLayout, 2131100328);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("getMsgExtra===");
    stringBuilder2.append(paramChattingModel.getMsgExtra());
    Logger.e("CommonNotice", new Object[] { stringBuilder2.toString() });
    if (!TextUtils.isEmpty(paramChattingModel.getMsgExtra())) {
      CommonNoticeExtra commonNoticeExtra = (CommonNoticeExtra)AppInfo.f().fromJson(paramChattingModel.getMsgExtra(), CommonNoticeExtra.class);
    } else {
      stringBuilder2 = null;
    } 
    if (stringBuilder2 != null && IMV4Method.a(paramChattingModel.fromId) == 0 && !TextUtils.isEmpty(((CommonNoticeExtra)stringBuilder2).sender_tips)) {
      shapeFrameLayout.setVisibility(0);
      textView.setText((CharSequence)Html.fromHtml(((CommonNoticeExtra)stringBuilder2).sender_tips));
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("sender===");
      stringBuilder1.append(((CommonNoticeExtra)stringBuilder2).sender_tips);
      Logger.e("CommonNotice", new Object[] { stringBuilder1.toString() });
      return;
    } 
    if (stringBuilder2 != null && IMV4Method.a(((ChattingModel)stringBuilder1).fromId) == 1 && !TextUtils.isEmpty(((CommonNoticeExtra)stringBuilder2).receiver_tips)) {
      shapeFrameLayout.setVisibility(0);
      textView.setText((CharSequence)Html.fromHtml(((CommonNoticeExtra)stringBuilder2).receiver_tips));
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("receive===");
      stringBuilder1.append(((CommonNoticeExtra)stringBuilder2).receiver_tips);
      Logger.e("CommonNotice", new Object[] { stringBuilder1.toString() });
      return;
    } 
    shapeFrameLayout.setVisibility(8);
  }
  
  private void c(ChattingModel paramChattingModel, View paramView1, View paramView2) {
    if (TextUtils.isEmpty(paramChattingModel.msgContent))
      return; 
    int i = IMV4Method.a(paramChattingModel.fromId);
    TextView textView = ViewHolder.<TextView>a(paramView2, 2131301038);
    ImageView imageView = ViewHolder.<ImageView>a(paramView2, 2131297392);
    j(paramChattingModel, paramView1);
    paramView2 = ViewHolder.a(paramView2, 2131299278);
    if (paramView2 != null)
      paramView2.setOnLongClickListener(new View.OnLongClickListener(this, paramChattingModel, i) {
            public boolean onLongClick(View param1View) {
              MessageChatAdapter.a(this.c, this.a, (TextView)null, this.b);
              return false;
            }
          }); 
    VideoChatMsgContentModel videoChatMsgContentModel = (VideoChatMsgContentModel)AppInfo.f().fromJson(paramChattingModel.msgContent, VideoChatMsgContentModel.class);
    if (videoChatMsgContentModel != null) {
      if (videoChatMsgContentModel.room_type == 1) {
        if (i == 1) {
          imageView.setImageResource(2131232406);
          if (paramChattingModel.msgType == 52) {
            textView.setText(2131758007);
            paramView1.setOnClickListener(new View.OnClickListener(this, paramChattingModel, videoChatMsgContentModel) {
                  public void onClick(View param1View) {
                    ChannelModel channelModel = new ChannelModel();
                    channelModel.callType = 3;
                    channelModel.remoteUid = (int)this.a.fromId;
                    channelModel.channelId = this.b.room_id;
                    channelModel.has_screenshot = this.b.has_screenshot;
                    channelModel.chat_sdk_type = MessageChatAdapter.a(this.c, this.a.getMsgExtra());
                    DialogSkipFragment.a(this.c.b, channelModel);
                  }
                });
          } else {
            paramView1.setOnClickListener(new View.OnClickListener(this, paramChattingModel, videoChatMsgContentModel) {
                  public void onClick(View param1View) {
                    ChannelModel channelModel = new ChannelModel();
                    channelModel.callType = 1;
                    channelModel.remoteUid = (int)this.a.sessionId;
                    channelModel.chat_sdk_type = MessageChatAdapter.a(this.c, this.a.getMsgExtra());
                    channelModel.has_screenshot = this.b.has_screenshot;
                    DialogSkipFragment.a(this.c.b, channelModel);
                  }
                });
          } 
        } else {
          if (paramChattingModel.msgType == 52)
            textView.setText(2131757949); 
          imageView.setImageResource(2131232407);
          paramView1.setOnClickListener(new View.OnClickListener(this, paramChattingModel, videoChatMsgContentModel) {
                public void onClick(View param1View) {
                  ChannelModel channelModel = new ChannelModel();
                  channelModel.callType = 1;
                  channelModel.remoteUid = (int)this.a.sessionId;
                  channelModel.has_screenshot = this.b.has_screenshot;
                  channelModel.chat_sdk_type = MessageChatAdapter.a(this.c, this.a.getMsgExtra());
                  DialogSkipFragment.a(this.c.b, channelModel);
                }
              });
        } 
      } else if (videoChatMsgContentModel.room_type == 2) {
        if (i == 1) {
          imageView.setImageResource(2131232416);
          if (paramChattingModel.msgType == 52) {
            textView.setText(2131758008);
            paramView1.setOnClickListener(new View.OnClickListener(this, paramChattingModel, videoChatMsgContentModel) {
                  public void onClick(View param1View) {
                    ChannelModel channelModel = new ChannelModel();
                    channelModel.callType = 2;
                    channelModel.remoteUid = (int)this.a.fromId;
                    channelModel.channelId = this.b.room_id;
                    channelModel.has_screenshot = this.b.has_screenshot;
                    channelModel.chat_sdk_type = MessageChatAdapter.a(this.c, this.a.getMsgExtra());
                    DialogSkipFragment.a(this.c.b, channelModel);
                  }
                });
          } else {
            paramView1.setOnClickListener(new View.OnClickListener(this, paramChattingModel, videoChatMsgContentModel) {
                  public void onClick(View param1View) {
                    ChannelModel channelModel = new ChannelModel();
                    channelModel.callType = 0;
                    channelModel.remoteUid = (int)this.a.sessionId;
                    channelModel.has_screenshot = this.b.has_screenshot;
                    channelModel.chat_sdk_type = MessageChatAdapter.a(this.c, this.a.getMsgExtra());
                    DialogSkipFragment.a(this.c.b, channelModel);
                  }
                });
          } 
        } else {
          if (paramChattingModel.msgType == 52)
            textView.setText(2131757949); 
          imageView.setImageResource(2131232417);
          paramView1.setOnClickListener(new View.OnClickListener(this, paramChattingModel, videoChatMsgContentModel) {
                public void onClick(View param1View) {
                  ChannelModel channelModel = new ChannelModel();
                  channelModel.callType = 0;
                  channelModel.remoteUid = (int)this.a.sessionId;
                  channelModel.has_screenshot = this.b.has_screenshot;
                  channelModel.chat_sdk_type = MessageChatAdapter.a(this.c, this.a.getMsgExtra());
                  DialogSkipFragment.a(this.c.b, channelModel);
                }
              });
        } 
      } 
      if (paramChattingModel.msgType == 53) {
        if (i == 1) {
          switch (videoChatMsgContentModel.close_type) {
            default:
              textView.setText(2131757948);
              return;
            case 6:
              textView.setText(2131758084);
              return;
            case 5:
              textView.setText(2131757948);
              return;
            case 4:
              textView.setText(2131758065);
              return;
            case 3:
              textView.setText(2131757948);
              return;
            case 1:
            case 2:
              break;
          } 
          a(videoChatMsgContentModel.total_time, textView);
          return;
        } 
        switch (videoChatMsgContentModel.close_type) {
          default:
            textView.setText(2131757949);
            return;
          case 6:
            textView.setText(2131758084);
            return;
          case 5:
            textView.setText(2131758046);
            return;
          case 4:
            textView.setText(2131758064);
            return;
          case 3:
            textView.setText(2131757949);
            return;
          case 1:
          case 2:
            break;
        } 
        a(videoChatMsgContentModel.total_time, textView);
      } 
    } 
  }
  
  private void c(ChattingModel paramChattingModel, View paramView, short paramShort, int paramInt) {
    ((TextView)paramView.findViewById(2131301038)).setText(this.b.getResources().getString(2131758014));
    if (paramInt == 1) {
      MsgPrivateImgApplyExtra msgPrivateImgApplyExtra;
      TextView textView1 = (TextView)paramView.findViewById(2131300504);
      TextView textView2 = (TextView)paramView.findViewById(2131300912);
      LinearLayout linearLayout = (LinearLayout)paramView.findViewById(2131299086);
      TextView textView3 = (TextView)paramView.findViewById(2131301356);
      ImageView imageView = (ImageView)paramView.findViewById(2131301040);
      String str = paramChattingModel.getMsgExtra();
      if (!TextUtils.isEmpty(str)) {
        msgPrivateImgApplyExtra = (MsgPrivateImgApplyExtra)AppInfo.f().fromJson(str, MsgPrivateImgApplyExtra.class);
      } else {
        msgPrivateImgApplyExtra = new MsgPrivateImgApplyExtra();
      } 
      if (msgPrivateImgApplyExtra.state == 0) {
        textView1.setVisibility(0);
        textView2.setVisibility(0);
        linearLayout.setVisibility(8);
        textView1.setOnClickListener(new View.OnClickListener(this, paramChattingModel, msgPrivateImgApplyExtra, textView1, textView2, linearLayout, textView3, imageView) {
              public void onClick(View param1View) {
                PersonalProfileProtos.Event event = PersonalProfileProtos.Event.APPLY_PHOTO_AGREE_CLICK;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a.fromId);
                stringBuilder.append("");
                EventTrackPersonalProfile.b(event, stringBuilder.toString());
                MineHttpUtils.a(String.valueOf(this.a.fromId), "open", new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)MessageChatAdapter.a(this.h).w_()) {
                      protected void a(BluedEntityA<Object> param2BluedEntityA) {
                        if (MessageChatAdapter.a(this.a.h) != null) {
                          if ((MessageChatAdapter.a(this.a.h)).t == null)
                            return; 
                          SessionModel sessionModel = (MessageChatAdapter.a(this.a.h)).t.H();
                          ChatHelperV4.a().a(String.valueOf(this.a.a.fromId), this.a.a.fromNickName, this.a.a.fromAvatar, sessionModel.vBadge, sessionModel.vipGrade, sessionModel.vipAnnual, sessionModel.vipExpLvl, sessionModel.hideVipLook);
                          this.a.b.state = 1;
                          this.a.a.setMsgExtra(AppInfo.f().toJson(this.a.b));
                          ChatManager.getInstance().updateMsgOneData(this.a.a);
                          this.a.c.setVisibility(8);
                          this.a.d.setVisibility(8);
                          this.a.e.setVisibility(0);
                          this.a.f.setText(this.a.h.b.getResources().getString(2131757939));
                          this.a.g.setImageResource(2131232761);
                        } 
                      }
                      
                      public void onUIFinish() {
                        super.onUIFinish();
                        DialogUtils.b((MessageChatAdapter.a(this.a.h)).f);
                      }
                      
                      public void onUIStart() {
                        super.onUIStart();
                        DialogUtils.a((MessageChatAdapter.a(this.a.h)).f);
                      }
                    }(IRequestHost)MessageChatAdapter.a(this.h).w_());
              }
            });
        textView2.setOnClickListener(new View.OnClickListener(this, msgPrivateImgApplyExtra, paramChattingModel, textView1, textView2, linearLayout, textView3, imageView) {
              public void onClick(View param1View) {
                this.a.state = 2;
                this.b.setMsgExtra(AppInfo.f().toJson(this.a));
                ChatManager.getInstance().updateMsgOneData(this.b);
                this.c.setVisibility(8);
                this.d.setVisibility(8);
                this.e.setVisibility(0);
                this.f.setText(this.h.b.getResources().getString(2131758004));
                this.g.setImageResource(2131232675);
                PersonalProfileProtos.Event event = PersonalProfileProtos.Event.APPLY_PHOTO_IGNORE_CLICK;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.b.fromId);
                stringBuilder.append("");
                EventTrackPersonalProfile.b(event, stringBuilder.toString());
              }
            });
        return;
      } 
      textView1.setVisibility(8);
      textView2.setVisibility(8);
      linearLayout.setVisibility(0);
      if (msgPrivateImgApplyExtra.state == 1) {
        textView3.setText(this.b.getResources().getString(2131757939));
        imageView.setImageResource(2131232761);
        return;
      } 
      textView3.setText(this.b.getResources().getString(2131758004));
      imageView.setImageResource(2131232675);
      return;
    } 
  }
  
  private void d() {
    LiveEventBus.get("keep_screen").post(new KeepScreenEvent(true));
    this.g.b(this.i);
    this.g.a(new MediaPlayer.OnCompletionListener(this) {
          public void onCompletion(MediaPlayer param1MediaPlayer) {
            LiveEventBus.get("keep_screen").post(new KeepScreenEvent(false));
            LiveFloatManager.a().i();
            MessageChatAdapter messageChatAdapter = this.a;
            messageChatAdapter.h = "";
            messageChatAdapter.notifyDataSetChanged();
            MediaUtils.a().a(2);
          }
        });
  }
  
  private void d(ChattingModel paramChattingModel) {
    paramChattingModel.msgTextTranslateStatus = 1;
    paramChattingModel.msgTextTranslateIsShow = 0;
    h(paramChattingModel);
  }
  
  private void d(ChattingModel paramChattingModel, View paramView) {
    ImageView imageView1 = ViewHolder.<ImageView>a(paramView, 2131297815);
    ImageView imageView2 = ViewHolder.<ImageView>a(paramView, 2131297816);
    ImageLoader.a(b(), (UserInfo.a().i()).avatar).a(2.0F, BluedSkinUtils.a(this.b, 2131100728)).a(2131234356).a(imageView1);
    ImageLoader.a(b(), this.aA.t.e).a(2.0F, BluedSkinUtils.a(this.b, 2131100728)).a(2131234356).a(imageView2);
    ShapeLinearLayout shapeLinearLayout = ViewHolder.<ShapeLinearLayout>a(paramView, 2131299977);
    TextView textView = ViewHolder.<TextView>a(paramView, 2131300483);
    ShapeHelper.b((ShapeHelper.ShapeView)shapeLinearLayout, 2131100881);
    String str = paramChattingModel.getMsgExtra();
    if (TextUtils.isEmpty(str))
      return; 
    MsgExtraLike msgExtraLike = (MsgExtraLike)AppInfo.f().fromJson(str, MsgExtraLike.class);
    if (msgExtraLike == null)
      return; 
    if (!TextUtils.isEmpty(msgExtraLike.content) && !TextUtils.isEmpty(msgExtraLike.identical) && msgExtraLike.content.length() > msgExtraLike.identical.length()) {
      SpannableString spannableString = new SpannableString(msgExtraLike.content);
      int i = msgExtraLike.content.indexOf(msgExtraLike.identical);
      int j = msgExtraLike.identical.length();
      spannableString.setSpan(new ForegroundColorSpan(BluedSkinUtils.a(this.b, 2131100838)), i, j + i, 17);
      textView.setText((CharSequence)spannableString);
    } else {
      textView.setText(msgExtraLike.content);
    } 
    imageView1.setOnClickListener(new View.OnClickListener(this, paramChattingModel) {
          public void onClick(View param1View) {
            Context context = this.b.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.fromId);
            stringBuilder.append("");
            UserInfoFragmentNew.a(context, stringBuilder.toString(), "private_chatting");
          }
        });
    imageView2.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            Context context = this.a.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((MessageChatAdapter.a(this.a)).t.b);
            stringBuilder.append("");
            UserInfoFragmentNew.a(context, stringBuilder.toString(), "private_chatting");
          }
        });
  }
  
  private void e(ChattingModel paramChattingModel) {
    paramChattingModel.msgTextTranslateStatus = 0;
    paramChattingModel.msgTextTranslateIsShow = 0;
    h(paramChattingModel);
  }
  
  private void e(ChattingModel paramChattingModel, View paramView) {
    EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_OLD_MSG_SHOW);
    TextView textView = (TextView)paramView.findViewById(2131301415);
    ImageView imageView = (ImageView)paramView.findViewById(2131297729);
    textView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_OLD_MSG_CLICK);
            ModifyUserInfoFragment.a(this.a.b, 0, false);
          }
        });
    imageView.setOnClickListener(new View.OnClickListener(this, paramChattingModel) {
          public void onClick(View param1View) {
            ArrayList<BottomMenuPop.MenuItemInfo> arrayList = new ArrayList();
            BottomMenuPop.MenuItemInfo menuItemInfo1 = new BottomMenuPop.MenuItemInfo();
            menuItemInfo1.a = this.b.b.getString(2131758067);
            menuItemInfo1.b = 2131100716;
            menuItemInfo1.c = new View.OnClickListener(this) {
                public void onClick(View param2View) {
                  if (MessageChatAdapter.b(this.a.b) != null)
                    MessageChatAdapter.b(this.a.b).p(); 
                  EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_OLD_MSG_NOTIFY_CLICK);
                  ChatManager.getInstance().deleteOneMessage(this.a.a.sessionType, this.a.a.sessionId, this.a.a.msgId, this.a.a.msgLocalId);
                }
              };
            BottomMenuPop.MenuItemInfo menuItemInfo2 = new BottomMenuPop.MenuItemInfo();
            menuItemInfo2.a = this.b.b.getString(2131758051);
            menuItemInfo2.b = 2131100576;
            menuItemInfo2.c = new View.OnClickListener(this) {
                public void onClick(View param2View) {
                  if (MessageChatAdapter.b(this.a.b) != null)
                    MessageChatAdapter.b(this.a.b).p(); 
                  EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_OLD_MSG_FORBID_CLICK);
                  ChatManager.getInstance().deleteOneMessage(this.a.a.sessionType, this.a.a.sessionId, this.a.a.msgId, this.a.a.msgLocalId);
                  BluedPreferences.cQ();
                }
              };
            arrayList.add(menuItemInfo1);
            arrayList.add(menuItemInfo2);
            MessageChatAdapter messageChatAdapter = this.b;
            MessageChatAdapter.a(messageChatAdapter, new BottomMenuPop(messageChatAdapter.b));
            (MessageChatAdapter.b(this.b)).b = arrayList;
            (MessageChatAdapter.b(this.b)).c = new View.OnClickListener(this) {
                public void onClick(View param2View) {
                  EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_OLD_MSG_CANCEL_CLICK);
                }
              };
            (new XPopup.Builder(this.b.b)).a((BasePopupView)MessageChatAdapter.b(this.b)).h();
          }
        });
  }
  
  private boolean e() {
    return TextUtils.isEmpty(this.h) ^ true;
  }
  
  private void f(ChattingModel paramChattingModel) {
    paramChattingModel.msgTextTranslateIsShow = 1;
    h(paramChattingModel);
  }
  
  private void f(ChattingModel paramChattingModel, View paramView) {
    try {
      LiveMsgShareEntity liveMsgShareEntity = (LiveMsgShareEntity)AppInfo.f().fromJson(paramChattingModel.getMsgExtra(), LiveMsgShareEntity.class);
      if (liveMsgShareEntity == null)
        return; 
      View view = (View)ViewHolder.a(paramView, 2131296709);
      TextView textView1 = ViewHolder.<TextView>a(view, 2131301064);
      ImageView imageView = ViewHolder.<ImageView>a(view, 2131299685);
      TextView textView2 = ViewHolder.<TextView>a(view, 2131300665);
      TextView textView3 = ViewHolder.<TextView>a(view, 2131300504);
      ImageLoader.a(b(), liveMsgShareEntity.avatar).c().a(imageView);
      textView2.setText(liveMsgShareEntity.copywriting);
      textView1.setText(liveMsgShareEntity.description);
      if (IMV4Method.a(paramChattingModel.fromId) == 0) {
        textView3.setVisibility(8);
        return;
      } 
      textView3.setOnClickListener(new View.OnClickListener(this, liveMsgShareEntity) {
            public void onClick(View param1View) {
              if (LiveFloatManager.a().x()) {
                ToastUtils.a("你正在直播间内，需要退出后操作", 0);
                return;
              } 
              YYRoomInfoManager.d().a((BaseFragmentActivity)this.b.b, this.a.room_id, "");
              EventTrackMessage.c(MessageProtos.Event.CHAT_ROOM_INVITE_MSG_JOIN_CLICK, this.a.room_id, this.a.uid);
            }
          });
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private void g(ChattingModel paramChattingModel) {
    paramChattingModel.msgTextTranslateIsShow = 0;
    h(paramChattingModel);
  }
  
  private void g(ChattingModel paramChattingModel, View paramView) {
    String str = paramChattingModel.getMsgExtra();
    if (TextUtils.isEmpty(str))
      return; 
    Logger.b("直播分享extraJson==", new Object[] { str });
    try {
      LiveMsgShareEntity liveMsgShareEntity = (LiveMsgShareEntity)AppInfo.f().fromJson(str, LiveMsgShareEntity.class);
      if (liveMsgShareEntity == null)
        return; 
      View view = paramView.findViewById(2131296708);
      ImageView imageView = (ImageView)view.findViewById(2131299280);
      TextView textView2 = (TextView)view.findViewById(2131299281);
      TextView textView3 = (TextView)view.findViewById(2131299279);
      TextView textView1 = (TextView)view.findViewById(2131299282);
      new LoadOptions();
      ImageLoader.a(b(), liveMsgShareEntity.pic_url).a(2131233443).a(14.0F).a(imageView);
      if (!TextUtils.isEmpty(liveMsgShareEntity.description))
        textView3.setText(liveMsgShareEntity.description); 
      if (!TextUtils.isEmpty(liveMsgShareEntity.name)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.getResources().getString(2131757180));
        stringBuilder.append(": ");
        stringBuilder.append(liveMsgShareEntity.name);
        textView2.setText(stringBuilder.toString());
      } 
      if (TextUtils.isEmpty(liveMsgShareEntity.copywriting)) {
        if (liveMsgShareEntity.watch_count > 0) {
          String str1 = this.b.getResources().getString(2131757195);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(liveMsgShareEntity.watch_count);
          stringBuilder.append("");
          textView1.setText(String.format(str1, new Object[] { stringBuilder.toString() }));
        } else {
          textView1.setText(this.b.getResources().getString(2131757182));
        } 
      } else {
        textView1.setText(liveMsgShareEntity.copywriting);
      } 
      paramView.setOnClickListener(new View.OnClickListener(this, liveMsgShareEntity, paramChattingModel) {
            public void onClick(View param1View) {
              LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(this.a.lid, 0L), 0, "msg", this.a.uid, this.a.name, this.a.avatar, this.a.vbadge);
              LiveRoomInfoChannel.a(this.c.b, liveRoomData);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("http://native.blued.cn/?action=liveplay&lid=");
              stringBuilder.append(this.a.lid);
              stringBuilder.append("&uid=");
              stringBuilder.append(EncryptTool.b(this.a.uid));
              stringBuilder.append("&from=");
              stringBuilder.append("msg");
              String str2 = stringBuilder.toString();
              boolean bool = IMV4Method.b(this.b.fromId);
              String str1 = "";
              if (!bool) {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(this.b.fromId);
                stringBuilder1.append("");
                str1 = stringBuilder1.toString();
              } 
              InstantLog.a(32, str2, str1);
            }
          });
      paramView.setOnLongClickListener(new View.OnLongClickListener(this, paramChattingModel) {
            public boolean onLongClick(View param1View) {
              MessageChatAdapter.a(this.b, this.a);
              return false;
            }
          });
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private void h(ChattingModel paramChattingModel) {
    ChatManager.getInstance().updateMsgOneData(paramChattingModel);
    IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback = this.az;
    if (iMsgChatAdapterOperationCallback != null)
      iMsgChatAdapterOperationCallback.J(); 
  }
  
  private void h(ChattingModel paramChattingModel, View paramView) {
    int i = IMV4Method.a(paramChattingModel.fromId);
    ImageView imageView = (ImageView)paramView.findViewById(2131297539);
    MsgChattingImageModel msgChattingImageModel = ChatHelperV4.a().d(paramChattingModel);
    if (msgChattingImageModel != null && msgChattingImageModel.getPicHeight() != 0 && msgChattingImageModel.getPicWidth() != 0) {
      ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
      float f = DensityUtil.a(120.0F) / msgChattingImageModel.getPicWidth();
      layoutParams.height = (int)(msgChattingImageModel.getPicHeight() * f);
      layoutParams.width = (int)(msgChattingImageModel.getPicWidth() * f);
      imageView.setLayoutParams(layoutParams);
    } 
    if (!TextUtils.isEmpty(paramChattingModel.msgContent)) {
      String[] arrayOfString = paramChattingModel.msgContent.split("@");
      if (arrayOfString.length > 1) {
        ImageLoader.a(b(), arrayOfString[0]).a(6.0F).a(2131231370).a(imageView);
        if (i == 0)
          imageView.setOnLongClickListener(new View.OnLongClickListener(this, paramChattingModel) {
                public boolean onLongClick(View param1View) {
                  MessageChatAdapter.a(this.b, this.a);
                  return true;
                }
              }); 
      } 
    } 
    if (i == 1 && msgChattingImageModel != null && paramChattingModel.msgId == 1L && msgChattingImageModel.getMsgSource() != null && (BluedConfig.b().v() || msgChattingImageModel.getMsgSource().getType() == MessageProtos.StrangerSource.SHADOW_SOURCE))
      a(msgChattingImageModel.getMsgSource(), paramView, String.valueOf(paramChattingModel.fromId)); 
  }
  
  private String i(ChattingModel paramChattingModel) {
    return this.ay.c() ? ((IMV4Method.a(paramChattingModel.fromId) == 1) ? paramChattingModel.fromAvatar : UserInfo.a().i().getAvatar()) : ((IMV4Method.a(paramChattingModel.fromId) == 1) ? this.ay.d() : UserInfo.a().i().getAvatar());
  }
  
  private void i(ChattingModel paramChattingModel, View paramView) {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 2131301607
    //   4: invokevirtual findViewById : (I)Landroid/view/View;
    //   7: checkcast com/blued/android/module/player/media/view/PLVideoPageView
    //   10: astore #6
    //   12: aload #6
    //   14: invokevirtual j : ()V
    //   17: invokestatic a : ()Lcom/soft/blued/ui/msg/controller/tools/ChatHelperV4;
    //   20: aload_1
    //   21: invokevirtual c : (Lcom/blued/android/chat/model/ChattingModel;)[Ljava/lang/String;
    //   24: astore #7
    //   26: invokestatic a : ()Lcom/soft/blued/ui/msg/controller/tools/ChatHelperV4;
    //   29: aload_1
    //   30: invokevirtual g : (Lcom/blued/android/chat/model/ChattingModel;)[I
    //   33: astore #5
    //   35: aload #5
    //   37: ifnull -> 64
    //   40: aload #5
    //   42: arraylength
    //   43: iconst_2
    //   44: if_icmplt -> 64
    //   47: aload #5
    //   49: iconst_0
    //   50: iaload
    //   51: ifle -> 64
    //   54: aload #5
    //   56: astore_2
    //   57: aload #5
    //   59: iconst_1
    //   60: iaload
    //   61: ifgt -> 82
    //   64: iconst_2
    //   65: newarray int
    //   67: astore_2
    //   68: aload_2
    //   69: dup
    //   70: iconst_0
    //   71: sipush #480
    //   74: iastore
    //   75: dup
    //   76: iconst_1
    //   77: sipush #480
    //   80: iastore
    //   81: pop
    //   82: aload_2
    //   83: iconst_0
    //   84: iaload
    //   85: istore_3
    //   86: aload_2
    //   87: iconst_1
    //   88: iaload
    //   89: istore #4
    //   91: iload_3
    //   92: ifeq -> 240
    //   95: iload #4
    //   97: ifeq -> 240
    //   100: iload_3
    //   101: iload #4
    //   103: getstatic com/blued/android/core/AppInfo.l : I
    //   106: iconst_2
    //   107: idiv
    //   108: getstatic com/blued/android/core/AppInfo.l : I
    //   111: iconst_2
    //   112: idiv
    //   113: getstatic com/blued/android/core/AppInfo.l : I
    //   116: iconst_3
    //   117: idiv
    //   118: getstatic com/blued/android/core/AppInfo.l : I
    //   121: iconst_3
    //   122: idiv
    //   123: invokestatic b : (IIIIII)[I
    //   126: astore #5
    //   128: aload #6
    //   130: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   133: astore_2
    //   134: aload_2
    //   135: aload #5
    //   137: iconst_0
    //   138: iaload
    //   139: putfield width : I
    //   142: aload_2
    //   143: aload #5
    //   145: iconst_1
    //   146: iaload
    //   147: putfield height : I
    //   150: aload #6
    //   152: aload_2
    //   153: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   156: new com/blued/android/module/player/media/model/VideoPlayConfig
    //   159: dup
    //   160: invokespecial <init> : ()V
    //   163: astore #5
    //   165: aload #5
    //   167: aload #7
    //   169: iconst_0
    //   170: aaload
    //   171: putfield a : Ljava/lang/String;
    //   174: aload #5
    //   176: aload #7
    //   178: iconst_1
    //   179: aaload
    //   180: putfield b : Ljava/lang/String;
    //   183: aload #5
    //   185: aload_2
    //   186: getfield width : I
    //   189: putfield e : I
    //   192: aload #5
    //   194: aload_2
    //   195: getfield height : I
    //   198: putfield f : I
    //   201: aload #5
    //   203: iload_3
    //   204: invokevirtual a : (I)V
    //   207: aload #5
    //   209: iload #4
    //   211: invokevirtual b : (I)V
    //   214: aload #5
    //   216: new com/soft/blued/ui/msg/adapter/MessageChatAdapter$47
    //   219: dup
    //   220: aload_0
    //   221: aload #7
    //   223: iload_3
    //   224: iload #4
    //   226: aload_1
    //   227: invokespecial <init> : (Lcom/soft/blued/ui/msg/adapter/MessageChatAdapter;[Ljava/lang/String;IILcom/blued/android/chat/model/ChattingModel;)V
    //   230: putfield g : Landroid/view/View$OnClickListener;
    //   233: aload #6
    //   235: aload #5
    //   237: invokevirtual b : (Lcom/blued/android/module/player/media/model/VideoPlayConfig;)V
    //   240: aload_1
    //   241: invokevirtual isFromSelf : ()Z
    //   244: ifne -> 262
    //   247: aload #6
    //   249: new com/soft/blued/ui/msg/adapter/MessageChatAdapter$48
    //   252: dup
    //   253: aload_0
    //   254: aload_1
    //   255: invokespecial <init> : (Lcom/soft/blued/ui/msg/adapter/MessageChatAdapter;Lcom/blued/android/chat/model/ChattingModel;)V
    //   258: invokevirtual setOnLongClickListener : (Landroid/view/View$OnLongClickListener;)V
    //   261: return
    //   262: aload #6
    //   264: new com/soft/blued/ui/msg/adapter/MessageChatAdapter$49
    //   267: dup
    //   268: aload_0
    //   269: aload_1
    //   270: invokespecial <init> : (Lcom/soft/blued/ui/msg/adapter/MessageChatAdapter;Lcom/blued/android/chat/model/ChattingModel;)V
    //   273: invokevirtual setOnLongClickListener : (Landroid/view/View$OnLongClickListener;)V
    //   276: return
  }
  
  private void j(ChattingModel paramChattingModel, View paramView) {
    View view1 = (View)ViewHolder.a(paramView, 2131298022);
    View view2 = (View)ViewHolder.a(paramView, 2131298024);
    if (view1 != null && view2 != null) {
      view1.setVisibility(8);
      view2.setVisibility(8);
      String str = paramChattingModel.getMsgExtra();
      if (!TextUtils.isEmpty(str)) {
        Gson gson = AppInfo.f();
        try {
          MsgExtraForTextTypeEntity msgExtraForTextTypeEntity = (MsgExtraForTextTypeEntity)gson.fromJson(str, MsgExtraForTextTypeEntity.class);
          if (msgExtraForTextTypeEntity != null) {
            MsgExtraForTextTypeEntity.SecureNotify secureNotify = msgExtraForTextTypeEntity.secureNotify;
            if (secureNotify != null) {
              secureNotify = MsgCommonUtils.a(secureNotify);
              if (secureNotify != null) {
                int i = secureNotify.notify_type;
                if (i != 1) {
                  if (i != 2) {
                    if (i == 3)
                      a(secureNotify, view1, paramView); 
                  } else {
                    b(paramChattingModel, secureNotify, view1, paramView);
                  } 
                } else {
                  a(paramChattingModel, secureNotify, view2, paramView);
                } 
              } 
            } 
            if (IMV4Method.a(paramChattingModel.fromId) == 1 && paramChattingModel.msgId == 1L && msgExtraForTextTypeEntity.msgSource != null && (BluedConfig.b().v() || msgExtraForTextTypeEntity.msgSource.getType() == MessageProtos.StrangerSource.SHADOW_SOURCE)) {
              a(msgExtraForTextTypeEntity.msgSource, view1, paramView, String.valueOf(paramChattingModel.fromId));
              return;
            } 
          } 
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
    } 
  }
  
  private void k(ChattingModel paramChattingModel, View paramView) {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 2131296884
    //   4: invokestatic a : (Landroid/view/View;I)Landroid/view/View;
    //   7: checkcast androidx/cardview/widget/CardView
    //   10: astore #8
    //   12: aload_2
    //   13: ldc_w 2131300708
    //   16: invokestatic a : (Landroid/view/View;I)Landroid/view/View;
    //   19: checkcast android/widget/TextView
    //   22: astore #9
    //   24: aload_2
    //   25: ldc_w 2131301061
    //   28: invokestatic a : (Landroid/view/View;I)Landroid/view/View;
    //   31: checkcast android/widget/TextView
    //   34: astore #10
    //   36: aload_2
    //   37: ldc_w 2131301064
    //   40: invokestatic a : (Landroid/view/View;I)Landroid/view/View;
    //   43: checkcast android/widget/TextView
    //   46: astore #11
    //   48: aload_2
    //   49: ldc_w 2131296348
    //   52: invokestatic a : (Landroid/view/View;I)Landroid/view/View;
    //   55: checkcast android/widget/ImageView
    //   58: astore #12
    //   60: new com/blued/android/core/imagecache/LoadOptions
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: astore_2
    //   68: aload_2
    //   69: ldc_w 2131100549
    //   72: putfield d : I
    //   75: aload_2
    //   76: ldc_w 2131100549
    //   79: putfield b : I
    //   82: aload_1
    //   83: invokevirtual getMsgExtra : ()Ljava/lang/String;
    //   86: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   89: istore_3
    //   90: ldc_w ''
    //   93: astore #6
    //   95: iload_3
    //   96: ifne -> 302
    //   99: invokestatic f : ()Lcom/google/gson/Gson;
    //   102: aload_1
    //   103: invokevirtual getMsgExtra : ()Ljava/lang/String;
    //   106: ldc_w com/soft/blued/ui/msg/model/MsgImageAndTextModel
    //   109: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   112: checkcast com/soft/blued/ui/msg/model/MsgImageAndTextModel
    //   115: astore #5
    //   117: aload #5
    //   119: ifnull -> 302
    //   122: aload #5
    //   124: getfield title : Ljava/lang/String;
    //   127: astore #6
    //   129: aload #5
    //   131: getfield image : Ljava/lang/String;
    //   134: astore #4
    //   136: aload #5
    //   138: getfield desc : Ljava/lang/String;
    //   141: astore_2
    //   142: aload #5
    //   144: getfield link : Ljava/lang/String;
    //   147: astore #7
    //   149: aload #5
    //   151: getfield click_desc : Ljava/lang/String;
    //   154: astore #5
    //   156: goto -> 159
    //   159: aload #6
    //   161: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   164: ifne -> 183
    //   167: aload #11
    //   169: aload #6
    //   171: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   174: aload #11
    //   176: iconst_0
    //   177: invokevirtual setVisibility : (I)V
    //   180: goto -> 190
    //   183: aload #11
    //   185: bipush #8
    //   187: invokevirtual setVisibility : (I)V
    //   190: aload_0
    //   191: invokespecial b : ()Lcom/blued/android/core/net/IRequestHost;
    //   194: aload #4
    //   196: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
    //   199: aload #12
    //   201: invokevirtual a : (Landroid/widget/ImageView;)V
    //   204: aload_2
    //   205: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   208: ifne -> 226
    //   211: aload #10
    //   213: aload_2
    //   214: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   217: aload #10
    //   219: iconst_0
    //   220: invokevirtual setVisibility : (I)V
    //   223: goto -> 233
    //   226: aload #10
    //   228: bipush #8
    //   230: invokevirtual setVisibility : (I)V
    //   233: aload #5
    //   235: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   238: ifne -> 257
    //   241: aload #9
    //   243: aload #5
    //   245: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   248: aload #9
    //   250: iconst_0
    //   251: invokevirtual setVisibility : (I)V
    //   254: goto -> 264
    //   257: aload #9
    //   259: bipush #8
    //   261: invokevirtual setVisibility : (I)V
    //   264: aload #7
    //   266: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   269: ifne -> 289
    //   272: aload #8
    //   274: new com/soft/blued/ui/msg/adapter/MessageChatAdapter$71
    //   277: dup
    //   278: aload_0
    //   279: aload_1
    //   280: aload #7
    //   282: invokespecial <init> : (Lcom/soft/blued/ui/msg/adapter/MessageChatAdapter;Lcom/blued/android/chat/model/ChattingModel;Ljava/lang/String;)V
    //   285: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   288: return
    //   289: aload #8
    //   291: aconst_null
    //   292: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   295: return
    //   296: astore_1
    //   297: aload_1
    //   298: invokevirtual printStackTrace : ()V
    //   301: return
    //   302: ldc_w ''
    //   305: astore #5
    //   307: aload #5
    //   309: astore #4
    //   311: aload #4
    //   313: astore_2
    //   314: aload_2
    //   315: astore #7
    //   317: goto -> 159
    // Exception table:
    //   from	to	target	type
    //   82	90	296	java/lang/Exception
    //   99	117	296	java/lang/Exception
    //   122	156	296	java/lang/Exception
    //   159	180	296	java/lang/Exception
    //   183	190	296	java/lang/Exception
    //   190	223	296	java/lang/Exception
    //   226	233	296	java/lang/Exception
    //   233	254	296	java/lang/Exception
    //   257	264	296	java/lang/Exception
    //   264	288	296	java/lang/Exception
    //   289	295	296	java/lang/Exception
  }
  
  private void l(ChattingModel paramChattingModel, View paramView) {
    View view = (View)ViewHolder.a(paramView, 2131296707);
    TextView textView1 = ViewHolder.<TextView>a(paramView, 2131301064);
    TextView textView2 = ViewHolder.<TextView>a(paramView, 2131300665);
    ImageView imageView2 = ViewHolder.<ImageView>a(paramView, 2131297808);
    ImageView imageView1 = ViewHolder.<ImageView>a(paramView, 2131299685);
    ShareToMsgEntity shareToMsgEntity = ChatHelperV4.a().e(paramChattingModel);
    textView1.setText(paramChattingModel.msgContent);
    if (paramChattingModel.msgType == 89) {
      textView2.setText(StringUtils.a(StringUtils.a(StringUtils.a(shareToMsgEntity.name, (int)textView2.getTextSize(), 0), false, true, false, ""), false, new boolean[0]));
      int i = shareToMsgEntity.type;
      if (i != 0) {
        if (i != 1) {
          if (i == 2) {
            ImageLoader.a(b(), shareToMsgEntity.image).a(10.0F).a(2131100549).a(imageView1);
            imageView2.setVisibility(0);
          } 
        } else {
          ImageLoader.a(b(), shareToMsgEntity.image).a(10.0F).a(2131100549).a(imageView1);
          imageView2.setVisibility(8);
        } 
      } else {
        ImageLoader.a(b(), shareToMsgEntity.image).a(10.0F).a(2131232614).a(imageView1);
        imageView2.setVisibility(8);
      } 
    } else {
      textView2.setText(shareToMsgEntity.name);
      ImageLoader.a(b(), shareToMsgEntity.image).a(10.0F).a(2131100549).a(imageView1);
      imageView2.setVisibility(8);
    } 
    view.setOnClickListener(new View.OnClickListener(this, shareToMsgEntity, paramChattingModel) {
          public void onClick(View param1View) {
            WebViewShowInfoFragment.show(this.c.b, this.a.url, -1);
            short s = this.b.msgType;
            String str2 = this.a.url;
            boolean bool = IMV4Method.b(this.b.fromId);
            String str1 = "";
            if (!bool) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.b.fromId);
              stringBuilder.append("");
              str1 = stringBuilder.toString();
            } 
            InstantLog.a(s, str2, str1);
          }
        });
    view.setOnLongClickListener(new View.OnLongClickListener(this, paramChattingModel) {
          public boolean onLongClick(View param1View) {
            MessageChatAdapter.a(this.b, this.a);
            return true;
          }
        });
  }
  
  private void m(ChattingModel paramChattingModel, View paramView) {
    View view = (View)ViewHolder.a(paramView, 2131296707);
    TextView textView = ViewHolder.<TextView>a(paramView, 2131301064);
    XRoundedImageView xRoundedImageView = ViewHolder.<XRoundedImageView>a(paramView, 2131301769);
    ShareToMsgEntity shareToMsgEntity = ChatHelperV4.a().e(paramChattingModel);
    textView.setText(paramChattingModel.msgContent);
    ImageLoader.a(b(), shareToMsgEntity.image).a(2131100549).c(2131232479).a((ImageView)xRoundedImageView);
    view.setOnClickListener(new View.OnClickListener(this, shareToMsgEntity, paramChattingModel) {
          public void onClick(View param1View) {
            WebViewShowInfoFragment.show(this.c.b, this.a.url, -1);
            short s = this.b.msgType;
            String str2 = this.a.url;
            boolean bool = IMV4Method.b(this.b.fromId);
            String str1 = "";
            if (!bool) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.b.fromId);
              stringBuilder.append("");
              str1 = stringBuilder.toString();
            } 
            InstantLog.a(s, str2, str1);
          }
        });
    view.setOnLongClickListener(new View.OnLongClickListener(this, paramChattingModel) {
          public boolean onLongClick(View param1View) {
            MessageChatAdapter.a(this.b, this.a);
            return true;
          }
        });
  }
  
  private void n(ChattingModel paramChattingModel, View paramView) {
    ConstraintLayout.LayoutParams layoutParams;
    View view = (View)ViewHolder.a(paramView, 2131296707);
    TextView textView3 = ViewHolder.<TextView>a(paramView, 2131301064);
    TextView textView1 = ViewHolder.<TextView>a(paramView, 2131300665);
    TextView textView2 = ViewHolder.<TextView>a(paramView, 2131300664);
    ImageView imageView = ViewHolder.<ImageView>a(paramView, 2131299685);
    ShareToMsgEntity shareToMsgEntity = ChatHelperV4.a().e(paramChattingModel);
    textView3.setText(paramChattingModel.msgContent);
    textView1.setText(shareToMsgEntity.name);
    ImageLoader.a(b(), shareToMsgEntity.image).c().a(2131234356).a(imageView);
    if (!TextUtils.isEmpty(shareToMsgEntity.description)) {
      textView2.setText(shareToMsgEntity.description);
      ConstraintLayout.LayoutParams layoutParams1 = (ConstraintLayout.LayoutParams)imageView.getLayoutParams();
      if (textView2.getLineCount() == 1) {
        layoutParams1.bottomToBottom = 0;
        layoutParams1.bottomMargin = DensityUtils.a(this.b, 17.0F);
      } else {
        layoutParams1.bottomToBottom = -1;
      } 
      imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
      layoutParams = (ConstraintLayout.LayoutParams)textView1.getLayoutParams();
      layoutParams.bottomToBottom = -1;
      textView1.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } else {
      layoutParams.setVisibility(8);
      layoutParams = (ConstraintLayout.LayoutParams)imageView.getLayoutParams();
      layoutParams.bottomToBottom = 0;
      layoutParams.bottomMargin = DensityUtils.a(this.b, 17.0F);
      imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      layoutParams = (ConstraintLayout.LayoutParams)textView1.getLayoutParams();
      layoutParams.bottomToBottom = 0;
      layoutParams.bottomMargin = DensityUtils.a(this.b, 20.0F);
      textView1.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
    view.setOnClickListener(new View.OnClickListener(this, shareToMsgEntity, paramChattingModel) {
          public void onClick(View param1View) {
            WebViewShowInfoFragment.show(this.c.b, this.a.url, -1);
            short s = this.b.msgType;
            String str2 = this.a.url;
            boolean bool = IMV4Method.b(this.b.fromId);
            String str1 = "";
            if (!bool) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.b.fromId);
              stringBuilder.append("");
              str1 = stringBuilder.toString();
            } 
            InstantLog.a(s, str2, str1);
          }
        });
    view.setOnLongClickListener(new View.OnLongClickListener(this, paramChattingModel) {
          public boolean onLongClick(View param1View) {
            MessageChatAdapter.a(this.b, this.a);
            return true;
          }
        });
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ChattingModel chattingModel = this.a.get(paramInt);
    int i = IMV4Method.a(chattingModel.fromId);
    short s = chattingModel.msgType;
    if (paramView == null)
      paramView = a(chattingModel, paramInt, paramViewGroup); 
    paramViewGroup = ViewHolder.a(paramView, 2131299278);
    if (paramViewGroup != null)
      paramViewGroup.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (MessageChatAdapter.a(this.a) != null)
                MessageChatAdapter.a(this.a).u(); 
            }
          }); 
    paramViewGroup = ViewHolder.a(paramView, 2131299272);
    TextView textView1 = ViewHolder.<TextView>a(paramView, 2131299269);
    ImageView imageView1 = ViewHolder.<ImageView>a(paramView, 2131299273);
    ShapeTextView shapeTextView = ViewHolder.<ShapeTextView>a(paramView, 2131299271);
    ImageView imageView2 = ViewHolder.<ImageView>a(paramView, 2131297695);
    ImageView imageView3 = ViewHolder.<ImageView>a(paramView, 2131299277);
    View view1 = (View)ViewHolder.a(paramView, 2131296943);
    TextView textView2 = ViewHolder.<TextView>a(paramView, 2131300715);
    TextView textView3 = ViewHolder.<TextView>a(paramView, 2131300697);
    TextView textView4 = ViewHolder.<TextView>a(paramView, 2131301355);
    ImageView imageView4 = ViewHolder.<ImageView>a(paramView, 2131296710);
    View view2 = (View)ViewHolder.a(paramView, 2131296700);
    ImageView imageView5 = ViewHolder.<ImageView>a(paramView, 2131296727);
    ImageView imageView6 = ViewHolder.<ImageView>a(paramView, 2131297540);
    ImageView imageView7 = ViewHolder.<ImageView>a(paramView, 2131297541);
    TextView textView5 = ViewHolder.<TextView>a(paramView, 2131300497);
    View view3 = (View)ViewHolder.a(paramView, 2131296707);
    TextView textView6 = ViewHolder.<TextView>a(paramView, 2131301064);
    ImageView imageView8 = ViewHolder.<ImageView>a(paramView, 2131299685);
    TextView textView7 = ViewHolder.<TextView>a(paramView, 2131300665);
    TextView textView8 = ViewHolder.<TextView>a(paramView, 2131300664);
    LinearLayout linearLayout = ViewHolder.<LinearLayout>a(paramView, 2131298850);
    TextView textView9 = ViewHolder.<TextView>a(paramView, 2131301125);
    if (textView3 != null) {
      if (s != 0) {
        try {
          b(paramInt, textView3);
        } catch (Exception exception) {
          exception.printStackTrace();
          textView3.setVisibility(0);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("时间异常: ");
          stringBuilder.append(chattingModel.msgTimestamp);
          textView3.setText(stringBuilder.toString());
        } 
      } else {
        textView3.setVisibility(8);
      } 
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)textView3.getLayoutParams();
      int j = DensityUtils.a(AppInfo.d(), 2.5F);
      int k = DensityUtils.a(AppInfo.d(), 17.5F);
      if (paramInt != 0) {
        if (textView3.getVisibility() == 0) {
          marginLayoutParams.topMargin = j;
          marginLayoutParams.bottomMargin = k;
          textView3.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
        } 
      } else if (textView3.getVisibility() == 0) {
        marginLayoutParams.topMargin = k;
        marginLayoutParams.bottomMargin = k;
        textView3.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
      } 
    } 
    if (1 == MsgType.getClassify(s)) {
      if (TextUtils.isEmpty(chattingModel.msgContent)) {
        textView9.setVisibility(8);
        return paramView;
      } 
      textView9.setText(chattingModel.msgContent);
      textView9.setVisibility(0);
      return paramView;
    } 
    if (2 == MsgType.getGroupOperationNotifyType(s) || s == 0) {
      if (TextUtils.isEmpty(chattingModel.msgContent)) {
        linearLayout.setVisibility(8);
        return paramView;
      } 
      linearLayout.setVisibility(0);
      textView9.setText(chattingModel.msgContent);
      return paramView;
    } 
    if (s == 26) {
      if (i == 0) {
        if (textView9 != null) {
          textView9.setText(this.b.getResources().getString(2131755480));
          return paramView;
        } 
      } else {
        EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.IOS_SCREENSHOT_SHOW);
        if (textView9 != null) {
          textView9.setText(this.b.getResources().getString(2131755481));
          return paramView;
        } 
      } 
    } else {
      if (chattingModel.msgType == 55) {
        a(chattingModel, textView9);
        return paramView;
      } 
      if (chattingModel.msgType == 68) {
        k(chattingModel, paramView);
        return paramView;
      } 
      if (chattingModel.msgType == 216) {
        a(chattingModel, paramView);
        return paramView;
      } 
      if ((chattingModel.msgType != 98 || chattingModel.msgType != 99) && !chattingModel.isFromSelf())
        a(chattingModel, (View)paramViewGroup, textView1, shapeTextView, imageView1, view1, textView2); 
      a(chattingModel, imageView2, imageView3);
      if (chattingModel.isFromSelf())
        a(chattingModel, textView4, imageView4, imageView5); 
      if (s != -3) {
        if (s != -2) {
          if (s != -1) {
            if (s != 9 && s != 10) {
              if (s != 24) {
                if (s != 25) {
                  if (s != 32) {
                    if (s != 164) {
                      if (s != 169) {
                        if (s != 205) {
                          if (s != 210) {
                            if (s != 52 && s != 53) {
                              if (s != 73) {
                                if (s != 74) {
                                  if (s != 98 && s != 99) {
                                    switch (s) {
                                      default:
                                        switch (s) {
                                          default:
                                            if (chattingModel.app != 2) {
                                              chattingModel.msgContent = this.b.getResources().getString(2131755608);
                                            } else {
                                              chattingModel.msgContent = this.b.getResources().getString(2131757981);
                                            } 
                                            b(chattingModel, paramView, i);
                                            return paramView;
                                          case 90:
                                            n(chattingModel, paramView);
                                            return paramView;
                                          case 88:
                                          case 89:
                                            l(chattingModel, paramView);
                                            return paramView;
                                          case 87:
                                            break;
                                        } 
                                        m(chattingModel, paramView);
                                        return paramView;
                                      case 6:
                                        a(chattingModel, imageView6);
                                        return paramView;
                                      case 5:
                                        i(chattingModel, view2);
                                        return paramView;
                                      case 4:
                                        a(chattingModel, view2, imageView7, textView5);
                                        return paramView;
                                      case 3:
                                        a(chattingModel, paramView, view2);
                                        return paramView;
                                      case 2:
                                        b(chattingModel, paramView, view2);
                                        return paramView;
                                      case 1:
                                        break;
                                    } 
                                    b(chattingModel, paramView, i);
                                    return paramView;
                                  } 
                                  a(chattingModel, paramView, s, i);
                                  return paramView;
                                } 
                                b(chattingModel, paramView, s, i);
                                return paramView;
                              } 
                              c(chattingModel, paramView, s, i);
                              return paramView;
                            } 
                            c(chattingModel, view2, paramView);
                            return paramView;
                          } 
                          f(chattingModel, paramView);
                          return paramView;
                        } 
                        h(chattingModel, paramView);
                        return paramView;
                      } 
                      c(chattingModel, paramView);
                      return paramView;
                    } 
                    a(chattingModel, paramView, s, i);
                    return paramView;
                  } 
                  g(chattingModel, view2);
                  return paramView;
                } 
                a(chattingModel, view2, paramInt);
                return paramView;
              } 
              a(chattingModel, paramView, view2, paramInt);
              return paramView;
            } 
            a(chattingModel, view3, textView6, imageView8, textView7, textView8);
            return paramView;
          } 
          e(chattingModel, paramView);
          return paramView;
        } 
        d(chattingModel, paramView);
        return paramView;
      } 
      b(chattingModel, paramView);
      return paramView;
    } 
    return paramView;
  }
  
  public void a(int paramInt) {
    this.aC = paramInt;
    this.j = VipBubbleManager.a().b(paramInt);
  }
  
  public boolean a(ChattingModel paramChattingModel) {
    String str = IMV4Method.a(paramChattingModel);
    if (TextUtils.isEmpty(str))
      return false; 
    if (str.contains("http")) {
      String str1 = IMV4Method.a(paramChattingModel.sessionType, paramChattingModel.sessionId, str);
      if ((new File(str1)).exists())
        return true; 
      FileDownloader.a(str, str1, null, null);
      return false;
    } 
    return (new File(str)).exists();
  }
  
  public int getItemViewType(int paramInt) {
    ChattingModel chattingModel = this.a.get(paramInt);
    int i = IMV4Method.a(chattingModel.fromId);
    short s = chattingModel.msgType;
    if (MsgType.getClassify(s) == 1 || s == 26)
      return (i == 0) ? 12 : 13; 
    if (MsgType.getGroupOperationNotifyType(s) == 2 || s == 0)
      return (i == 0) ? 24 : 25; 
    if (s != -3) {
      if (s != -2) {
        if (s != -1) {
          paramInt = 9;
          if (s != 9) {
            if (s != 10) {
              if (s != 24) {
                if (s != 25) {
                  if (s != 32) {
                    if (s != 55) {
                      if (s != 68) {
                        if (s != 164) {
                          if (s != 169) {
                            if (s != 205) {
                              paramInt = 53;
                              if (s != 210) {
                                if (s != 216) {
                                  if (s != 52 && s != 53) {
                                    if (s != 73) {
                                      if (s != 74) {
                                        if (s != 98 && s != 99) {
                                          switch (s) {
                                            default:
                                              switch (s) {
                                                default:
                                                  return (i == 0) ? 0 : 1;
                                                case 90:
                                                  return (i == 0) ? 36 : 37;
                                                case 89:
                                                  return (i == 0) ? 34 : 35;
                                                case 88:
                                                  return (i == 0) ? 32 : 33;
                                                case 87:
                                                  break;
                                              } 
                                              return (i == 0) ? 30 : 31;
                                            case 6:
                                              return (i == 0) ? 14 : 15;
                                            case 5:
                                              return (i == 0) ? 16 : 17;
                                            case 4:
                                              return (i == 0) ? 4 : 5;
                                            case 3:
                                              return (i == 0) ? 6 : 7;
                                            case 2:
                                              return (i == 0) ? 2 : 3;
                                            case 1:
                                              break;
                                          } 
                                          return (i == 0) ? 0 : 1;
                                        } 
                                        return (i == 0) ? 38 : 39;
                                      } 
                                      return (i == 0) ? 42 : 43;
                                    } 
                                    return (i == 0) ? 40 : 41;
                                  } 
                                  return (i == 0) ? 26 : 27;
                                } 
                                return 54;
                              } 
                              if (i == 0)
                                paramInt = 52; 
                              return paramInt;
                            } 
                            return (i == 0) ? 50 : 51;
                          } 
                          return 48;
                        } 
                        return (i == 0) ? 44 : 45;
                      } 
                      return 29;
                    } 
                    return 28;
                  } 
                  return (i == 0) ? 22 : 23;
                } 
                return (i == 0) ? 20 : 21;
              } 
              return (i == 0) ? 18 : 19;
            } 
            return (i == 0) ? 10 : 11;
          } 
          if (i == 0)
            paramInt = 8; 
          return paramInt;
        } 
        return 46;
      } 
      return 47;
    } 
    return 49;
  }
  
  public int getViewTypeCount() {
    return 55;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\MessageChatAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */