package com.blued.android.module.live_china.liveForMsg.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.BaseListAdapter;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.liveForMsg.ClickMsgTalkerListener;
import com.blued.android.module.live_china.liveForMsg.LiveMsgManager;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.model.LiveFansLevelModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.model.LiveMsgReportModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.LiveBitmapUtils;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveMsgContentAdapter extends BaseListAdapter<ChattingModel> {
  private LiveMsgManager A;
  
  private Context B;
  
  private float C = AppMethods.a(203);
  
  private int D = AppMethods.b(12);
  
  private boolean E = false;
  
  private final int e = 21;
  
  private final int f = 0;
  
  private final int g = 1;
  
  private final int h = 2;
  
  private final int i = 3;
  
  private final int j = 4;
  
  private final int k = 5;
  
  private final int l = 6;
  
  private final int m = 7;
  
  private final int n = 8;
  
  private final int o = 9;
  
  private final int p = 10;
  
  private final int q = 11;
  
  private final int r = 12;
  
  private final int s = 13;
  
  private final int t = 14;
  
  private final int u = 15;
  
  private final int v = 16;
  
  private final int w = 17;
  
  private final int x = 18;
  
  private final int y = 19;
  
  private final int z = 20;
  
  public LiveMsgContentAdapter(LiveMsgManager paramLiveMsgManager, List<ChattingModel> paramList) {
    super(paramLiveMsgManager.g, paramList);
    this.A = paramLiveMsgManager;
    this.B = paramLiveMsgManager.g;
  }
  
  private View a(ChattingModel paramChattingModel, int paramInt) {
    paramInt = paramChattingModel.msgType;
    if (paramInt != 1) {
      if (paramInt != 27) {
        if (paramInt != 33) {
          if (paramInt != 61) {
            if (paramInt != 155) {
              if (paramInt != 202) {
                switch (paramInt) {
                  default:
                    switch (paramInt) {
                      default:
                        switch (paramInt) {
                          default:
                            switch (paramInt) {
                              default:
                                return null;
                              case 106:
                              case 107:
                              case 108:
                              case 109:
                                break;
                            } 
                            return this.c.inflate(R.layout.item_live_msg_content_filed_control, null);
                          case 104:
                            return this.c.inflate(R.layout.item_live_msg_content_chat, null);
                          case 103:
                            return this.c.inflate(R.layout.item_live_msg_content_attention, null);
                          case 102:
                            break;
                        } 
                        return this.c.inflate(R.layout.item_live_msg_content_level, null);
                      case 51:
                        return this.c.inflate(R.layout.item_live_msg_content_liked, null);
                      case 49:
                      case 50:
                        break;
                    } 
                    return this.c.inflate(R.layout.item_live_msg_content_share, null);
                  case -10001:
                  case -10000:
                    return this.c.inflate(R.layout.item_live_msg_gift_task, null);
                  case -10003:
                  case -10002:
                    break;
                } 
                return this.c.inflate(R.layout.item_live_msg_content_topcard, null);
              } 
              return this.c.inflate(R.layout.item_live_msg_task, null);
            } 
            return this.c.inflate(R.layout.item_live_msg_content_level, null);
          } 
          return this.c.inflate(R.layout.item_live_msg_content_get_gift, null);
        } 
        return this.c.inflate(R.layout.item_live_msg_content_gift1, null);
      } 
      return this.c.inflate(R.layout.item_live_msg_content_normal_entrance, null);
    } 
    return this.c.inflate(R.layout.item_live_msg_content1, null);
  }
  
  private void a(ChattingModel paramChattingModel, View paramView1, View paramView2) {
    TextView textView = (TextView)paramView2.findViewById(R.id.live_msg_content_task_text);
    paramView2 = paramView2.findViewById(R.id.live_msg_task);
    if (!TextUtils.isEmpty(paramChattingModel.msgContent)) {
      textView.setText(paramChattingModel.msgContent);
      paramView2.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              LiveSetDataObserver.a().w();
            }
          });
    } 
  }
  
  private void b(ChattingModel paramChattingModel, View paramView1, View paramView2) {
    TextView textView = (TextView)paramView2.findViewById(R.id.live_msg_content_text);
    if (!TextUtils.isEmpty(paramChattingModel.msgContent))
      textView.setText(paramChattingModel.msgContent); 
    t(paramChattingModel, paramView2);
    o(paramChattingModel, paramView2);
    m(paramChattingModel, paramView1);
  }
  
  private void c(ChattingModel paramChattingModel, View paramView) {
    paramChattingModel.msgContent = this.B.getResources().getString(R.string.live_send_a_like);
    t(paramChattingModel, paramView);
  }
  
  private void c(ChattingModel paramChattingModel, View paramView1, View paramView2) {
    TextView textView = (TextView)paramView2.findViewById(R.id.live_msg_content_text);
    if (!TextUtils.isEmpty(paramChattingModel.msgContent))
      textView.setText(paramChattingModel.msgContent); 
    m(paramChattingModel, paramView1);
  }
  
  private void d(ChattingModel paramChattingModel, View paramView) {
    TextView textView = (TextView)paramView.findViewById(R.id.live_msg_content_text);
    long l1 = paramChattingModel.fromId;
    String str1 = paramChattingModel.fromNickName;
    Map map = MsgPackHelper.getMapValue(paramChattingModel.msgMapExtra, "mute_profile");
    long l2 = MsgPackHelper.getLongValue(map, "uid");
    String str2 = MsgPackHelper.getStringValue(map, "name");
    str1 = CommonStringUtils.a(str1, String.valueOf(l1));
    str2 = CommonStringUtils.a(str2, String.valueOf(l2));
    SpannableStringBuilder spannableStringBuilder = a(textView, paramChattingModel, String.format(this.B.getString(R.string.live_released_to_speak), new Object[] { str1, str2 }));
    Logger.a("rrb", new Object[] { "spannableString = ", spannableStringBuilder });
    CharSequence charSequence = a(textView, spannableStringBuilder);
    Logger.a("rrb", new Object[] { "charSequence = ", charSequence });
    textView.setText(charSequence);
  }
  
  public static LiveFansLevelModel e(ChattingModel paramChattingModel) {
    LiveFansInfoModel liveFansInfoModel;
    LiveFansLevelModel liveFansLevelModel = new LiveFansLevelModel();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramChattingModel.fromId);
    stringBuilder.append("");
    if (stringBuilder.toString().equals(LiveRoomInfo.a().f())) {
      liveFansInfoModel = LiveRoomManager.a().i();
      if (liveFansInfoModel != null) {
        liveFansLevelModel.fan_club_name = liveFansInfoModel.name;
        liveFansLevelModel.fan_club_level = liveFansInfoModel.level;
        liveFansLevelModel.in_fan_club = liveFansInfoModel.fans_status;
        liveFansLevelModel.fans_status = liveFansInfoModel.fans_status;
        return liveFansLevelModel;
      } 
    } else {
      if (((ChattingModel)liveFansInfoModel).msgMapExtra != null) {
        liveFansLevelModel.fan_club_name = MsgPackHelper.getStringValue(((ChattingModel)liveFansInfoModel).msgMapExtra, "fan_club_name");
        liveFansLevelModel.fan_club_level = MsgPackHelper.getIntValue(((ChattingModel)liveFansInfoModel).msgMapExtra, "fan_club_level");
        liveFansLevelModel.in_fan_club = MsgPackHelper.getIntValue(((ChattingModel)liveFansInfoModel).msgMapExtra, "in_fan_club");
        liveFansLevelModel.fans_status = MsgPackHelper.getIntValue(((ChattingModel)liveFansInfoModel).msgMapExtra, "fans_status");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("from map fan_club_info:");
        stringBuilder1.append(liveFansLevelModel.fan_club_name);
        stringBuilder1.append(" : ");
        stringBuilder1.append(liveFansLevelModel.fan_club_level);
        stringBuilder1.append("  : ");
        stringBuilder1.append(liveFansLevelModel.in_fan_club);
        stringBuilder1.append(" : ");
        stringBuilder1.append(liveFansLevelModel.fans_status);
        Log.i("xpp", stringBuilder1.toString());
        return liveFansLevelModel;
      } 
      Gson gson = AppInfo.f();
      StringBuilder stringBuilder2 = null;
      stringBuilder = stringBuilder2;
      try {
        if (!TextUtils.isEmpty(stringBuilder1.getMsgExtra()))
          LiveFansLevelModel liveFansLevelModel1 = (LiveFansLevelModel)gson.fromJson(stringBuilder1.getMsgExtra(), LiveFansLevelModel.class); 
      } catch (Exception exception) {
        exception.printStackTrace();
        stringBuilder = stringBuilder2;
      } 
      if (stringBuilder != null) {
        liveFansLevelModel.fan_club_name = ((LiveFansLevelModel)stringBuilder).fan_club_name;
        liveFansLevelModel.fan_club_level = ((LiveFansLevelModel)stringBuilder).fan_club_level;
        liveFansLevelModel.in_fan_club = ((LiveFansLevelModel)stringBuilder).in_fan_club;
        liveFansLevelModel.fans_status = ((LiveFansLevelModel)stringBuilder).fans_status;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("from gson fan_club_info:");
      stringBuilder1.append(liveFansLevelModel.fan_club_name);
      stringBuilder1.append(" : ");
      stringBuilder1.append(liveFansLevelModel.fan_club_level);
      stringBuilder1.append("  : ");
      stringBuilder1.append(liveFansLevelModel.in_fan_club);
      stringBuilder1.append(" : ");
      stringBuilder1.append(liveFansLevelModel.fans_status);
      Log.i("xpp", stringBuilder1.toString());
    } 
    return liveFansLevelModel;
  }
  
  private void e(ChattingModel paramChattingModel, View paramView) {
    TextView textView = (TextView)paramView.findViewById(R.id.live_msg_content_text);
    long l1 = paramChattingModel.fromId;
    String str1 = paramChattingModel.fromNickName;
    Map map = MsgPackHelper.getMapValue(paramChattingModel.msgMapExtra, "mute_profile");
    long l2 = MsgPackHelper.getLongValue(map, "uid");
    String str2 = MsgPackHelper.getStringValue(map, "name");
    str1 = CommonStringUtils.a(str1, String.valueOf(l1));
    str2 = CommonStringUtils.a(str2, String.valueOf(l2));
    textView.setText(a(textView, a(textView, paramChattingModel, String.format(this.B.getString(R.string.live_forbade_to_speak), new Object[] { str1, str2 }))));
  }
  
  private void f(ChattingModel paramChattingModel) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramChattingModel.fromId);
    stringBuilder.append("");
    if (stringBuilder.toString().equals(LiveRoomInfo.a().f())) {
      if (LiveFloatManager.a().w()) {
        paramChattingModel.fromLiveManager = 1;
        return;
      } 
      paramChattingModel.fromLiveManager = 0;
    } 
  }
  
  private void f(ChattingModel paramChattingModel, View paramView) {
    TextView textView = (TextView)paramView.findViewById(R.id.live_msg_content_text);
    long l = paramChattingModel.fromId;
    String str = CommonStringUtils.a(paramChattingModel.fromNickName, String.valueOf(l));
    str = String.format(this.B.getString(R.string.live_removed_your_manager), new Object[] { str });
    textView.setTextColor(Color.parseColor("#ffd452"));
    textView.setText(a(textView, str));
  }
  
  private void g(ChattingModel paramChattingModel, View paramView) {
    TextView textView = (TextView)paramView.findViewById(R.id.live_msg_content_text);
    long l = paramChattingModel.fromId;
    String str = CommonStringUtils.a(paramChattingModel.fromNickName, String.valueOf(l));
    str = String.format(this.B.getString(R.string.live_on_being_manager), new Object[] { str });
    textView.setTextColor(Color.parseColor("#ffd452"));
    textView.setText(a(textView, str));
  }
  
  private void h(ChattingModel paramChattingModel, View paramView) {
    String str1;
    TextView textView = (TextView)paramView.findViewById(R.id.live_msg_content_text);
    String str2 = this.B.getString(R.string.live_chat_congratulations);
    long l = paramChattingModel.fromId;
    String str3 = CommonStringUtils.a(paramChattingModel.fromNickName, String.valueOf(l));
    if (paramChattingModel.fromRichLevel == 30) {
      str1 = String.format(this.B.getString(R.string.live_chat_upgrade), new Object[] { "男爵" });
    } else if (paramChattingModel.fromRichLevel == 31) {
      str1 = String.format(this.B.getString(R.string.live_chat_upgrade), new Object[] { "子爵" });
    } else if (paramChattingModel.fromRichLevel == 32) {
      str1 = String.format(this.B.getString(R.string.live_chat_upgrade), new Object[] { "伯爵" });
    } else if (paramChattingModel.fromRichLevel == 33) {
      str1 = String.format(this.B.getString(R.string.live_chat_upgrade), new Object[] { "公爵" });
    } else if (paramChattingModel.fromRichLevel == 34) {
      str1 = String.format(this.B.getString(R.string.live_chat_upgrade), new Object[] { "国王" });
    } else {
      str1 = this.B.getString(R.string.live_chat_upgrade);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramChattingModel.fromRichLevel);
      stringBuilder1.append("");
      str1 = String.format(str1, new Object[] { stringBuilder1.toString() });
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str2);
    stringBuilder.append(str3);
    stringBuilder.append(str1);
    textView.setText(a(textView, stringBuilder.toString()));
    paramView.setOnClickListener(new View.OnClickListener(this, paramChattingModel) {
          public void onClick(View param1View) {
            this.b.b(this.a);
          }
        });
  }
  
  private void i(ChattingModel paramChattingModel, View paramView) {
    TextView textView = (TextView)paramView.findViewById(R.id.live_msg_content_text);
    String str1 = this.B.getString(R.string.live_chat_congratulations);
    long l = paramChattingModel.fromId;
    String str2 = CommonStringUtils.a(paramChattingModel.fromNickName, String.valueOf(l));
    int i = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "level");
    String str3 = this.B.getString(R.string.live_record_level_msg);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i);
    stringBuilder.append("");
    str3 = String.format(str3, new Object[] { stringBuilder.toString() });
    stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append(str2);
    stringBuilder.append(str3);
    textView.setText(a(textView, stringBuilder.toString()));
    paramView.setOnClickListener(new View.OnClickListener(this, paramChattingModel) {
          public void onClick(View param1View) {
            this.b.b(this.a);
          }
        });
  }
  
  private void j(ChattingModel paramChattingModel, View paramView) {
    paramView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveSetDataObserver.a().i();
            InstantLog.a("live_chat_guide_click");
          }
        });
  }
  
  private void k(ChattingModel paramChattingModel, View paramView) {
    Logger.a("rrb", new Object[] { "setAttentionRemind" });
    if (paramChattingModel.liveChatListFollowed) {
      paramView.setEnabled(false);
    } else {
      paramView.setEnabled(true);
    } 
    paramView.setOnClickListener(new View.OnClickListener(this, paramView, paramChattingModel) {
          public void onClick(View param1View) {
            this.a.setEnabled(false);
            LiveSetDataObserver.a().k();
            if (LiveRoomManager.a().h() != null)
              EventTrackLive.a(LiveProtos.Event.LIVE_FOLLOW_GUIDE_CLICK, String.valueOf(LiveRoomManager.a().b()), LiveRoomManager.a().e()); 
            InstantLog.a("live_follow_guide_click");
            this.c.a.remove(this.b);
            this.c.notifyDataSetChanged();
          }
        });
  }
  
  private void l(ChattingModel paramChattingModel, View paramView) {
    TextView textView = (TextView)paramView.findViewById(R.id.live_msg_content_text);
    if (!TextUtils.isEmpty(paramChattingModel.msgContent))
      textView.setText(paramChattingModel.msgContent); 
    ImageView imageView = (ImageView)paramView.findViewById(R.id.iv_liang);
    LiveLiangModel liveLiangModel = LiveUtils.b(paramChattingModel);
    if (liveLiangModel != null && liveLiangModel.liang_type >= 2) {
      if (imageView != null)
        imageView.setVisibility(0); 
    } else if (imageView != null) {
      imageView.setVisibility(8);
    } 
    u(paramChattingModel, paramView);
  }
  
  private void m(ChattingModel paramChattingModel, View paramView) {
    ImageView imageView = (ImageView)paramView.findViewById(R.id.live_msg_light);
    if (paramChattingModel != null) {
      if (imageView == null)
        return; 
      if (paramChattingModel.msgMapExtra == null)
        paramChattingModel.msgMapExtra = new HashMap<Object, Object>(); 
      if (!paramChattingModel.msgMapExtra.containsKey("convertView")) {
        TranslateAnimation translateAnimation;
        if (!this.E && d(paramChattingModel) >= 34) {
          paramChattingModel.msgMapExtra.put("convertView", paramView);
          this.E = true;
          translateAnimation = new TranslateAnimation(0, 0.0F, 0, AppInfo.l, 1, 0.0F, 1, 0.0F);
          translateAnimation.setDuration(2000L);
          translateAnimation.setFillAfter(true);
          translateAnimation.setFillBefore(true);
          translateAnimation.setRepeatMode(1);
          translateAnimation.setRepeatCount(1);
          imageView.startAnimation((Animation)translateAnimation);
          imageView.setVisibility(0);
          AppInfo.n().postDelayed(new Runnable(this) {
                public void run() {
                  try {
                    LiveMsgContentAdapter.a(this.a, false);
                    for (ChattingModel chattingModel : this.a.a()) {
                      if (chattingModel.msgMapExtra != null)
                        chattingModel.msgMapExtra.put("convertView", null); 
                    } 
                  } catch (Exception exception) {
                    exception.printStackTrace();
                  } 
                }
              }2000L);
          return;
        } 
        ((ChattingModel)translateAnimation).msgMapExtra.put("convertView", null);
      } 
    } 
  }
  
  private void n(ChattingModel paramChattingModel, View paramView) {
    TextView textView = (TextView)paramView.findViewById(R.id.live_msg_content_text);
    if (!TextUtils.isEmpty(paramChattingModel.msgContent))
      textView.setText(paramChattingModel.msgContent); 
    t(paramChattingModel, paramView);
  }
  
  private void o(ChattingModel paramChattingModel, View paramView) {
    int i = d(paramChattingModel);
    if (i >= 0 && i <= 15) {
      paramView.setBackgroundResource(R.drawable.shape_round_live_msg_item_bg);
    } else if (i >= 16 && i <= 20) {
      paramView.setBackgroundResource(R.drawable.shape_gradient_name_level_yellow);
    } else if (i >= 21 && i <= 25) {
      paramView.setBackgroundResource(R.drawable.shape_gradient_name_level_orange);
    } else if (i >= 26 && i < 30) {
      paramView.setBackgroundResource(R.drawable.shape_gradient_name_level_red);
    } else if (i == 30) {
      paramView.setBackgroundResource(R.drawable.shape_gradient_name_level_30);
    } else if (i == 31) {
      paramView.setBackgroundResource(R.drawable.shape_gradient_name_level_31);
    } else if (i == 32) {
      paramView.setBackgroundResource(R.drawable.shape_gradient_name_level_32);
    } else if (i == 33) {
      paramView.setBackgroundResource(R.drawable.shape_gradient_name_level_33);
    } else if (i == 34) {
      paramView.setBackgroundResource(R.drawable.shape_gradient_name_level_34);
    } 
    ImageView imageView = (ImageView)paramView.findViewById(R.id.live_msg_content_star);
    if (imageView != null) {
      if (i >= 30) {
        imageView.setVisibility(0);
        if (i >= 34) {
          imageView.setImageResource(R.drawable.live_msg_list_star_wang);
          return;
        } 
        imageView.setImageResource(R.drawable.live_msg_list_star);
        return;
      } 
      imageView.setVisibility(8);
    } 
  }
  
  private void p(ChattingModel paramChattingModel, View paramView) {
    ImageView imageView = (ImageView)paramView.findViewById(R.id.msg_user_level);
    int i = d(paramChattingModel);
    LiveBitmapUtils.a(this.B, imageView, i);
  }
  
  private void q(ChattingModel paramChattingModel, View paramView) {
    v(paramChattingModel, paramView);
    LiveGiftModel liveGiftModel = LiveUtils.a(paramChattingModel);
    if (liveGiftModel == null)
      return; 
    p(paramChattingModel, paramView);
    LiveLiangModel liveLiangModel = LiveUtils.b(paramChattingModel);
    ImageView imageView2 = (ImageView)paramView.findViewById(R.id.msg_user_liang);
    if (liveLiangModel != null && liveLiangModel.liang_type >= 2) {
      if (imageView2 != null)
        imageView2.setVisibility(0); 
    } else if (imageView2 != null) {
      imageView2.setVisibility(8);
    } 
    ImageView imageView1 = (ImageView)paramView.findViewById(R.id.msg_img_gift);
    ImageLoader.a(null, liveGiftModel.images_static).c(R.drawable.live_msg_gift_default_bg).a(imageView1);
    TextView textView = (TextView)paramView.findViewById(R.id.live_msg_git_count);
    if (liveGiftModel.hit_batch == 1) {
      textView.setVisibility(0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("X");
      stringBuilder.append(liveGiftModel.hit_count);
      textView.setText(stringBuilder.toString());
    } else {
      textView.setVisibility(8);
    } 
    r(paramChattingModel, paramView);
  }
  
  private void r(ChattingModel paramChattingModel, View paramView) {
    paramView.findViewById(R.id.msg_fans_group_layout).setVisibility(8);
  }
  
  private void s(ChattingModel paramChattingModel, View paramView) {
    MsgPackHelper.getLongValue(paramChattingModel.msgMapExtra, "id");
    int i = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "count");
    String str1 = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "image");
    String str2 = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "name");
    MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "uid");
    TextView textView2 = (TextView)paramView.findViewById(R.id.live_msg_content_nickname);
    if (!TextUtils.isEmpty(str2)) {
      textView2.setText(str2);
      paramView.setOnClickListener(new View.OnClickListener(this, paramChattingModel) {
            public void onClick(View param1View) {
              this.b.b(this.a);
            }
          });
    } 
    ImageView imageView = (ImageView)paramView.findViewById(R.id.live_msg_content_get_icon);
    ImageLoader.a(null, str1).c(R.drawable.live_msg_gift_default_bg).a(imageView);
    TextView textView1 = (TextView)paramView.findViewById(R.id.live_msg_content_get_num);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i);
    stringBuilder.append("");
    textView1.setText(stringBuilder.toString());
  }
  
  private void t(ChattingModel paramChattingModel, View paramView) {
    TextView textView = (TextView)paramView.findViewById(R.id.live_msg_content_text);
    f(paramChattingModel);
    textView.setText(a(textView, paramChattingModel, new ClickMsgTalkerListener(this, paramChattingModel) {
            public void a() {
              this.b.b(this.a);
            }
          }this.A.f));
    if (!TextUtils.isEmpty(paramChattingModel.fromNickName))
      paramView.setOnClickListener(new View.OnClickListener(this, paramChattingModel) {
            public void onClick(View param1View) {
              this.b.c(this.a);
            }
          }); 
  }
  
  private void u(ChattingModel paramChattingModel, View paramView) {
    TextView textView = (TextView)paramView.findViewById(R.id.live_msg_content_nickname);
    if (!TextUtils.isEmpty(paramChattingModel.fromNickName)) {
      textView.setText((CharSequence)new SpannableStringBuilder(paramChattingModel.fromNickName));
      paramView.setOnClickListener(new View.OnClickListener(this, paramChattingModel) {
            public void onClick(View param1View) {
              this.b.b(this.a);
            }
          });
    } 
  }
  
  private void v(ChattingModel paramChattingModel, View paramView) {
    TextView textView = (TextView)paramView.findViewById(R.id.live_msg_content_nickname);
    if (!TextUtils.isEmpty(paramChattingModel.fromNickName)) {
      textView.setText((CharSequence)new SpannableStringBuilder(paramChattingModel.fromNickName));
      paramView.setOnClickListener(new View.OnClickListener(this, paramChattingModel) {
            public void onClick(View param1View) {
              this.b.c(this.a);
            }
          });
    } 
    if ((LiveUtils.a(paramChattingModel)).hit_batch == 1) {
      textView.setMaxEms(3);
    } else {
      textView.setMaxEms(6);
    } 
    paramView.findViewById(R.id.live_msg_avatar_cover).setBackgroundResource(R.drawable.shape_round_live_msg_avatar_cover_color1);
    ImageView imageView = (ImageView)paramView.findViewById(R.id.live_msg_avatar_avatar);
    ImageLoader.a(null, paramChattingModel.fromAvatar).a(4.0F).a(imageView);
  }
  
  public SpannableStringBuilder a(TextView paramTextView, ChattingModel paramChattingModel, CharSequence paramCharSequence) {
    String str1;
    int i = paramChattingModel.fromLiveManager;
    int j = d(paramChattingModel);
    String str2 = "";
    if (i != 0) {
      str1 = "field_control ";
    } else {
      str1 = "";
    } 
    if (j != 0)
      str2 = "rich "; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append(str2);
    stringBuilder.append(paramCharSequence);
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
    if (i != 0) {
      Drawable drawable = LiveBitmapUtils.a();
      drawable.setBounds(0, 0, AppMethods.a(27), AppMethods.a(13));
      spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), 0, str1.length() - 1, 33);
    } 
    if (j != 0) {
      Drawable drawable = LiveBitmapUtils.a(AppInfo.d(), j);
      if (j >= 30) {
        drawable.setBounds(0, 0, AppMethods.a(38), AppMethods.a(14));
      } else {
        drawable.setBounds(0, 0, AppMethods.a(27), AppMethods.a(13));
      } 
      spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), str1.length(), str1.length() + str2.length() - 1, 33);
    } 
    return spannableStringBuilder;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ChattingModel chattingModel = this.a.get(paramInt);
    short s = chattingModel.msgType;
    View view = paramView;
    if (s == 1) {
      view = paramView;
      if (chattingModel.msgMapExtra != null) {
        view = paramView;
        if (chattingModel.msgMapExtra.containsKey("convertView"))
          view = (View)chattingModel.msgMapExtra.get("convertView"); 
      } 
    } 
    paramView = view;
    if (view == null)
      paramView = a(chattingModel, paramInt); 
    view = paramView.findViewById(R.id.live_msg_content_root);
    if (s != 1) {
      if (s != 27) {
        if (s != 33) {
          if (s != 61) {
            if (s != 155) {
              if (s != 202) {
                switch (s) {
                  default:
                    switch (s) {
                      default:
                        switch (s) {
                          default:
                            switch (s) {
                              default:
                                return paramView;
                              case 109:
                                Logger.a("rrb", new Object[] { "解禁消息" });
                                d(chattingModel, view);
                                return paramView;
                              case 108:
                                e(chattingModel, view);
                                Logger.a("rrb", new Object[] { "禁言消息" });
                                return paramView;
                              case 107:
                                f(chattingModel, view);
                                return paramView;
                              case 106:
                                break;
                            } 
                            g(chattingModel, view);
                            return paramView;
                          case 104:
                            j(chattingModel, view);
                            return paramView;
                          case 103:
                            k(chattingModel, view);
                            return paramView;
                          case 102:
                            break;
                        } 
                        h(chattingModel, view);
                        return paramView;
                      case 51:
                        Logger.a("rrb", new Object[] { "点赞消息" });
                        c(chattingModel, view);
                        return paramView;
                      case 49:
                      case 50:
                        break;
                    } 
                    l(chattingModel, view);
                    return paramView;
                  case -10000:
                    a(chattingModel, view);
                    return paramView;
                  case -10001:
                    b(chattingModel, view);
                    return paramView;
                  case -10003:
                  case -10002:
                    break;
                } 
                c(chattingModel, paramView, view);
                return paramView;
              } 
              Logger.a("rrb", new Object[] { "领取奖励消息" });
              a(chattingModel, paramView, view);
              return paramView;
            } 
            i(chattingModel, view);
            return paramView;
          } 
          s(chattingModel, view);
          return paramView;
        } 
        q(chattingModel, view);
        return paramView;
      } 
      n(chattingModel, view);
      return paramView;
    } 
    b(chattingModel, paramView, view);
    return paramView;
  }
  
  public CharSequence a(TextView paramTextView, SpannableStringBuilder paramSpannableStringBuilder) {
    CharSequence charSequence = LiveRoomInfo.a().a((CharSequence)paramSpannableStringBuilder, "#ffd452", new LiveRoomConstants.ClickAtLinkListener(this) {
          public void a(String param1String1, String param1String2) {
            if (TextUtils.isEmpty(param1String2)) {
              LiveSetDataObserver.a().d(param1String1);
              return;
            } 
            LiveSetDataObserver.a().e(param1String2);
          }
        });
    paramTextView.setMovementMethod((MovementMethod)LinkMovementClickMethod.a());
    return charSequence;
  }
  
  public CharSequence a(TextView paramTextView, ChattingModel paramChattingModel, ClickMsgTalkerListener paramClickMsgTalkerListener, boolean paramBoolean) {
    String str1;
    int i;
    byte b;
    String str2;
    String str4;
    String str5;
    if (paramTextView == null || paramChattingModel == null)
      return ""; 
    String str3 = paramChattingModel.fromNickName;
    String str8 = paramChattingModel.msgContent;
    if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str8))
      return ""; 
    String str9 = (String)TextUtils.ellipsize(str3, paramTextView.getPaint(), DensityUtils.a(AppInfo.d(), 100.0F), TextUtils.TruncateAt.END);
    int k = paramChattingModel.fromLiveManager;
    LiveFansLevelModel liveFansLevelModel = e(paramChattingModel);
    String str6 = liveFansLevelModel.fan_club_name;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(liveFansLevelModel.fan_club_level);
    stringBuilder1.append("");
    String str7 = stringBuilder1.toString();
    int m = liveFansLevelModel.in_fan_club;
    int n = liveFansLevelModel.fans_status;
    int i1 = d(paramChattingModel);
    LiveLiangModel liveLiangModel = LiveUtils.b(paramChattingModel);
    if (liveLiangModel != null) {
      b = liveLiangModel.liang_type;
    } else {
      b = 0;
    } 
    int j = str9.length();
    if (k != 0) {
      i = 14;
      j = str9.length() + 14;
      str1 = "field_control ";
    } else {
      str1 = "";
      i = 0;
    } 
    if (m != 0) {
      i += 5;
      j = str9.length() + i;
      str2 = "fans ";
    } else {
      str2 = "";
    } 
    if (i1 != 0) {
      i += 5;
      j = i + str9.length();
      str4 = "rich ";
    } else {
      str4 = "";
    } 
    if (b >= 2) {
      j = i + 7;
      int i2 = str9.length();
      i = j;
      j += i2;
      str5 = "liveId ";
    } else {
      str5 = "";
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append(str2);
    stringBuilder2.append(str4);
    stringBuilder2.append(str5);
    stringBuilder2.append("");
    stringBuilder2.append(str9);
    stringBuilder2.append(" ");
    stringBuilder2.append(str8);
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder2.toString());
    if (k != 0) {
      Drawable drawable = LiveBitmapUtils.a();
      drawable.setBounds(0, 0, AppMethods.a(27), AppMethods.a(13));
      spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), 0, str1.length() - 1, 33);
    } 
    if (m != 0) {
      Bitmap bitmap;
      View view2 = LayoutInflater.from(paramTextView.getContext()).inflate(R.layout.live_fans_heart_level_small, null);
      ((TextView)view2.findViewById(R.id.tv_level_num)).setText(str7);
      ((TextView)view2.findViewById(R.id.tv_fans_name)).setText(str6);
      View view1 = view2.findViewById(R.id.ll_level);
      ImageView imageView = (ImageView)view2.findViewById(R.id.iv_heart);
      if (n == 1) {
        view1.setBackgroundResource(R.drawable.live_fans_level_open_small_bg);
        imageView.setImageResource(R.drawable.live_fans_level_open_small_heart);
      } else if (n == 2) {
        view1.setBackgroundResource(R.drawable.live_fans_level_disopen_small_bg);
        imageView.setImageResource(R.drawable.live_fans_level_disopen_small_heart);
      } 
      try {
        view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view2.layout(0, 0, view2.getMeasuredWidth(), view2.getMeasuredHeight());
        bitmap = Bitmap.createBitmap(view2.getMeasuredWidth(), view2.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(bitmap));
      } catch (Exception exception) {
        bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      } 
      BitmapDrawable bitmapDrawable = new BitmapDrawable(paramTextView.getResources(), bitmap);
      bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), AppMethods.a(13));
      spannableStringBuilder.setSpan(new ImageSpan((Drawable)bitmapDrawable, 1), str1.length(), str1.length() + str2.length() - 1, 33);
    } 
    if (i1 != 0) {
      Drawable drawable = LiveBitmapUtils.a(AppInfo.d(), i1);
      if (i1 >= 30) {
        drawable.setBounds(0, 0, AppMethods.a(38), AppMethods.a(13));
      } else {
        drawable.setBounds(0, 0, AppMethods.a(27), AppMethods.a(13));
      } 
      spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), str2.length() + str1.length(), str2.length() + str1.length() + str4.length() - 1, 33);
    } 
    if (b >= 2) {
      Drawable drawable = AppInfo.d().getResources().getDrawable(R.drawable.live_liang);
      drawable.setBounds(0, 0, AppMethods.a(24), AppMethods.a(13));
      spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), str2.length() + str1.length() + str4.length(), str2.length() + str1.length() + str4.length() + str5.length() - 1, 33);
    } 
    spannableStringBuilder.setSpan(new ClickableSpan(this, paramClickMsgTalkerListener) {
          public void onClick(View param1View) {
            Selection.removeSelection((Spannable)((TextView)param1View).getText());
            this.a.a();
          }
          
          public void updateDrawState(TextPaint param1TextPaint) {
            super.updateDrawState(param1TextPaint);
            param1TextPaint.setColor(AppInfo.d().getResources().getColor(R.color.biao_live_msg_name_3));
            param1TextPaint.setUnderlineText(false);
            param1TextPaint.clearShadowLayer();
          }
        }i, j, 33);
    paramTextView.setMovementMethod((MovementMethod)LinkMovementClickMethod.a());
    return (CharSequence)spannableStringBuilder;
  }
  
  public CharSequence a(TextView paramTextView, String paramString) {
    return a(paramTextView, new SpannableStringBuilder(paramString));
  }
  
  public void a(ChattingModel paramChattingModel) {
    if (this.a != null && this.a.size() > 0) {
      LiveRoomInfo.a().a(paramChattingModel, this.a.get(this.a.size() - 1));
      notifyDataSetChanged();
    } 
  }
  
  public void a(ChattingModel paramChattingModel, View paramView) {
    ((TextView)paramView.findViewById(R.id.tv_tip)).setText(R.string.live_gift_task_tip_1);
    paramView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveRoomPreferences.P();
            LiveSetDataObserver.a().v();
            if (LiveMsgContentAdapter.a(this.a) != null && LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).profile != null)
              EventTrackLive.a(LiveProtos.Event.LIVE_TODAY_WELFARE_TOAST_CLICK, String.valueOf((LiveMsgContentAdapter.a(this.a)).e), LiveRoomManager.a().e()); 
          }
        });
  }
  
  public void a(boolean paramBoolean) {
    for (int i = 0; i < this.a.size(); i++) {
      ChattingModel chattingModel = this.a.get(i);
      if (chattingModel.msgType == 103) {
        chattingModel.liveChatListFollowed = paramBoolean;
        notifyDataSetChanged();
        return;
      } 
    } 
  }
  
  public ChattingModel b() {
    return (this.a != null && this.a.size() > 0) ? this.a.get(this.a.size() - 1) : null;
  }
  
  public void b(ChattingModel paramChattingModel) {
    if (paramChattingModel == null)
      return; 
    LiveMsgReportModel liveMsgReportModel = new LiveMsgReportModel();
    if (LiveRoomManager.a().h() != null)
      liveMsgReportModel.lid = LiveRoomManager.a().c(); 
    liveMsgReportModel.uid = String.valueOf(paramChattingModel.fromId);
    liveMsgReportModel.reportMsg = paramChattingModel.msgContent;
    liveMsgReportModel.time = String.valueOf(paramChattingModel.msgTimestamp / 1000L);
    this.A.d(String.valueOf(paramChattingModel.fromId), liveMsgReportModel);
  }
  
  public void b(ChattingModel paramChattingModel, View paramView) {
    ((TextView)paramView.findViewById(R.id.tv_tip)).setText(R.string.live_gift_task_tip_2);
    paramView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveRoomPreferences.R();
            LiveSetDataObserver.a().v();
            if (LiveMsgContentAdapter.a(this.a) != null && LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).profile != null)
              EventTrackLive.a(LiveProtos.Event.LIVE_GLOW_STICK_TOAST_CLICK, String.valueOf((LiveMsgContentAdapter.a(this.a)).e), LiveRoomManager.a().e()); 
          }
        });
  }
  
  public void c(ChattingModel paramChattingModel) {
    if (paramChattingModel == null)
      return; 
    LiveMsgReportModel liveMsgReportModel = new LiveMsgReportModel();
    if (LiveRoomManager.a().h() != null)
      liveMsgReportModel.lid = LiveRoomManager.a().c(); 
    liveMsgReportModel.uid = String.valueOf(paramChattingModel.fromId);
    liveMsgReportModel.reportMsg = paramChattingModel.msgContent;
    liveMsgReportModel.time = String.valueOf(paramChattingModel.msgTimestamp / 1000L);
    this.A.c(paramChattingModel.fromNickName, liveMsgReportModel);
  }
  
  public int d(ChattingModel paramChattingModel) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramChattingModel.fromId);
    stringBuilder.append("");
    return stringBuilder.toString().equals(LiveRoomInfo.a().f()) ? LiveRoomInfo.a().q() : paramChattingModel.fromRichLevel;
  }
  
  public int getItemViewType(int paramInt) {
    paramInt = ((ChattingModel)this.a.get(paramInt)).msgType;
    if (paramInt != 1) {
      if (paramInt != 27) {
        if (paramInt != 33) {
          if (paramInt != 61) {
            if (paramInt != 155) {
              if (paramInt != 202) {
                switch (paramInt) {
                  default:
                    switch (paramInt) {
                      default:
                        switch (paramInt) {
                          default:
                            switch (paramInt) {
                              default:
                                return -1;
                              case 109:
                                return 13;
                              case 108:
                                return 12;
                              case 107:
                                return 11;
                              case 106:
                                break;
                            } 
                            return 10;
                          case 104:
                            return 8;
                          case 103:
                            return 7;
                          case 102:
                            break;
                        } 
                        return 9;
                      case 51:
                        return 14;
                      case 50:
                        return 4;
                      case 49:
                        break;
                    } 
                    return 5;
                  case -10000:
                    return 16;
                  case -10001:
                    return 17;
                  case -10002:
                    return 18;
                  case -10003:
                    break;
                } 
                return 19;
              } 
              return 20;
            } 
            return 15;
          } 
          return 3;
        } 
        return 2;
      } 
      return 6;
    } 
    return 0;
  }
  
  public int getViewTypeCount() {
    return 21;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\liveForMsg\data\LiveMsgContentAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */