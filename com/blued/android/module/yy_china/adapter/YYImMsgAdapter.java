package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.ClickAtLinkListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMsgBlindResultExtra;
import com.blued.android.module.yy_china.model.YYMsgEmojiExtra;
import com.blued.android.module.yy_china.model.YYMsgGiftExtra;
import com.blued.android.module.yy_china.model.YYMsgMicStatusExtra;
import com.blued.android.module.yy_china.model.YYMsgMuteStatusExtra;
import com.blued.android.module.yy_china.model.YYMsgOfficeExtra;
import com.blued.android.module.yy_china.model.YYMsgUpSeatExtra;
import com.blued.android.module.yy_china.model.YYReportModel;
import com.blued.android.module.yy_china.model.YYReportMsg;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.UserRelationshipUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.HashMap;

public class YYImMsgAdapter extends BaseMultiItemQuickAdapter<YYImModel, BaseViewHolder> {
  private final int a = 6;
  
  private final int b = 7;
  
  private final int c = 8;
  
  private final int d = 9;
  
  private final int e = 14;
  
  private final int f = 15;
  
  private final int g = 16;
  
  private final int h = 17;
  
  private final int i = 18;
  
  private final int o = 19;
  
  private final int p = 20;
  
  private int q = 0;
  
  private BaseYYStudioFragment r;
  
  private HashMap<String, Bitmap> s = new HashMap<String, Bitmap>();
  
  public YYImMsgAdapter(BaseYYStudioFragment paramBaseYYStudioFragment) {
    super(null);
    this.r = paramBaseYYStudioFragment;
    this.k = paramBaseYYStudioFragment.getContext();
    this.q = DensityUtils.a(this.k, 3.0F);
    b(21, R.layout.item_yy_msg_system);
    b(1, R.layout.item_yy_msg_text);
    b(20, R.layout.item_yy_msg_rename);
    b(2, R.layout.item_yy_msg_join);
    b(14, R.layout.item_yy_msg_text);
    b(19, R.layout.item_yy_msg_text);
    b(6, R.layout.item_yy_msg_text);
    b(7, R.layout.item_yy_apply_mic);
    b(18, R.layout.item_yy_apply_mic);
    b(17, R.layout.item_yy_apply_mic);
    b(8, R.layout.item_yy_apply_mic);
    b(9, R.layout.item_yy_apply_mic);
    b(15, R.layout.item_yy_apply_mic);
    b(16, R.layout.item_yy_msg_apply_seat);
    b(5, R.layout.item_yy_msg_send_giftt);
    b(23, R.layout.item_yy_apply_mic);
    b(10, R.layout.item_yy_msg_text);
    b(11, R.layout.item_yy_msg_text);
    b(26, R.layout.item_yy_msg_broadcast);
    b(36, R.layout.item_yy_vote_result);
    b(-2, R.layout.item_yy_apply_mic);
    b(-3, R.layout.item_yy_msg_system_follow);
    b(-4, R.layout.item_yy_msg_system_gift);
    b(-5, R.layout.item_yy_msg_edit_broadcast);
    b(-6, R.layout.item_yy_msg_cp_guide);
    b(27, R.layout.item_yy_apply_mic);
    b(28, R.layout.item_yy_apply_mic);
    b(31, R.layout.item_yy_vote_result);
  }
  
  private void A(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    String str;
    boolean bool;
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_header);
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.txt_view);
    YYAudienceModel yYAudienceModel2 = paramYYImModel.source_profile;
    YYAudienceModel yYAudienceModel1 = paramYYImModel.target_profile;
    if (yYAudienceModel2 == null || yYAudienceModel1 == null) {
      textView.setText("");
      ImageLoader.a((IRequestHost)this.r.w_(), "").a(R.drawable.user_bg_round).a(imageView);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    ImageLoader.a((IRequestHost)this.r.w_(), yYAudienceModel2.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
    boolean bool1 = TextUtils.equals("2", yYAudienceModel2.chat_anchor);
    int i = 0;
    if (bool1) {
      str = this.k.getResources().getString(R.string.yy_role_manager);
      bool = R.color.syc_8F38FD;
    } else if (TextUtils.equals("1", yYAudienceModel2.chat_anchor)) {
      str = this.k.getResources().getString(R.string.yy_role_host);
      bool = R.color.syc_3883FD;
    } else {
      i = this.q;
      str = "";
      bool = false;
    } 
    if (textView.getLayoutParams() instanceof LinearLayout.LayoutParams)
      ((LinearLayout.LayoutParams)textView.getLayoutParams()).topMargin = i; 
    stringBuilder.append(" 已将 ");
    stringBuilder.append(yYAudienceModel1.getName());
    stringBuilder.append(" 禁言");
    SpannableStringBuilder spannableStringBuilder = CommonStringUtils.a(this.k, str, bool, yYAudienceModel2.getName(), stringBuilder.toString(), false);
    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#00E0AB")), spannableStringBuilder.length() - 2, spannableStringBuilder.length(), 33);
    textView.setText((CharSequence)spannableStringBuilder);
  }
  
  private void B(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    String str;
    boolean bool;
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_header);
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.txt_view);
    YYAudienceModel yYAudienceModel2 = paramYYImModel.source_profile;
    YYAudienceModel yYAudienceModel1 = paramYYImModel.target_profile;
    if (yYAudienceModel2 == null || yYAudienceModel1 == null) {
      textView.setText("");
      ImageLoader.a((IRequestHost)this.r.w_(), "").a(R.drawable.user_bg_round).a(imageView);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    ImageLoader.a((IRequestHost)this.r.w_(), yYAudienceModel2.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
    boolean bool1 = TextUtils.equals("2", yYAudienceModel2.chat_anchor);
    int i = 0;
    if (bool1) {
      str = this.k.getResources().getString(R.string.yy_role_manager);
      bool = R.color.syc_8F38FD;
    } else if (TextUtils.equals("1", yYAudienceModel2.chat_anchor)) {
      str = this.k.getResources().getString(R.string.yy_role_host);
      bool = R.color.syc_3883FD;
    } else {
      i = this.q;
      str = "";
      bool = false;
    } 
    if (textView.getLayoutParams() instanceof LinearLayout.LayoutParams)
      ((LinearLayout.LayoutParams)textView.getLayoutParams()).topMargin = i; 
    stringBuilder.append(" 已将 ");
    stringBuilder.append(yYAudienceModel1.getName());
    stringBuilder.append(" 解除禁言");
    SpannableStringBuilder spannableStringBuilder = CommonStringUtils.a(this.k, str, bool, yYAudienceModel2.getName(), stringBuilder.toString(), false);
    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#00E0AB")), spannableStringBuilder.length() - 4, spannableStringBuilder.length(), 33);
    textView.setText((CharSequence)spannableStringBuilder);
  }
  
  private int a(String paramString) {
    return TextUtils.equals(paramString, "2") ? R.color.syc_8F38FD : (TextUtils.equals(paramString, "1") ? R.color.syc_3883FD : 0);
  }
  
  private CharSequence a(SpannableStringBuilder paramSpannableStringBuilder) {
    return YYRoomInfoManager.d().c().a((CharSequence)paramSpannableStringBuilder, "#00E0AB", new ClickAtLinkListener(this) {
          public void a(String param1String1, String param1String2) {
            String str = YYImMsgAdapter.b();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("click at member (uid : ");
            stringBuilder.append(param1String2);
            stringBuilder.append(" , uName : ");
            stringBuilder.append(param1String1);
            Logger.e(str, new Object[] { stringBuilder.toString() });
            YYImMsgAdapter.a(this.a, param1String2, param1String1, "");
          }
        });
  }
  
  private void a(int paramInt) {
    ArrayList<YYReportMsg> arrayList = new ArrayList();
    YYReportModel yYReportModel = new YYReportModel();
    for (int i = paramInt; i >= 0; i--) {
      YYImModel yYImModel = n().get(i);
      if (yYImModel.type == 1) {
        YYReportMsg yYReportMsg = new YYReportMsg();
        yYReportMsg.uid = yYImModel.source_profile.getUid();
        yYReportMsg.contents = yYImModel.contents;
        if (paramInt == i) {
          yYReportMsg.report = 1;
          yYReportModel.uid = yYImModel.source_profile.getUid();
        } else {
          yYReportMsg.report = 0;
        } 
        yYReportMsg.time = yYImModel.msg_time;
        arrayList.add(yYReportMsg);
        if (arrayList.size() >= 5)
          break; 
      } 
    } 
    yYReportModel.msg = arrayList;
    this.r.a(yYReportModel, 2);
  }
  
  private void a(View paramView, YYAudienceModel paramYYAudienceModel) {
    if (paramView != null) {
      if (paramYYAudienceModel == null)
        return; 
      paramView.setOnClickListener(new View.OnClickListener(this, paramYYAudienceModel) {
            public void onClick(View param1View) {
              YYImMsgAdapter.a(this.b, this.a.getUid(), this.a.getName(), this.a.getAvatar());
            }
          });
    } 
  }
  
  private void a(TextView paramTextView, Bitmap paramBitmap, int paramInt, String paramString1, String paramString2, YYAudienceModel paramYYAudienceModel) {
    paramTextView.setText(a(CommonStringUtils.a(this.k, paramString1, a(paramYYAudienceModel.chat_anchor), paramYYAudienceModel.getName(), paramString2, paramBitmap, paramInt)));
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    if (TextUtils.isEmpty(paramString1))
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    if (yYUserInfo == null)
      return; 
    boolean bool = yYRoomModel.isExistById(paramString1);
    this.r.a(paramString1, paramString2, paramString3, yYUserInfo.chat_anchor, bool);
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.tv_vote_result);
    if ((YYMsgBlindResultExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgBlindResultExtra.class) == null)
      return; 
    textView.setText(paramYYImModel.contents);
  }
  
  private void c(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_header);
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.txt_view);
    ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(R.id.tv_send_gift);
    YYAudienceModel yYAudienceModel = paramYYImModel.source_profile;
    if (yYAudienceModel != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(yYAudienceModel.getName());
      stringBuilder.append(" ");
      stringBuilder.append("申请上麦");
      textView.setText(stringBuilder);
      ImageLoader.a((IRequestHost)this.r.w_(), yYAudienceModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
    } 
    shapeTextView.setOnClickListener(new View.OnClickListener(this, paramYYImModel) {
          public void onClick(View param1View) {
            YYImMsgAdapter.a(this.b).A();
            YYImMsgAdapter.a(this.b).U().b(this.a);
          }
        });
    a((View)imageView, yYAudienceModel);
  }
  
  private void d(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ((TextView)paramBaseViewHolder.d(R.id.tv_vote_result)).setText(paramYYImModel.contents);
  }
  
  private void e(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.tv_msg_content);
    textView.setTextColor(this.k.getResources().getColor(R.color.syc_dark_b));
    textView.setText(paramYYImModel.contents);
  }
  
  private void f(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.tv_msg_content);
    textView.setTextColor(this.k.getResources().getColor(R.color.syc_dark_b));
    YYAudienceModel yYAudienceModel = paramYYImModel.source_profile;
    YYMsgEmojiExtra yYMsgEmojiExtra = (YYMsgEmojiExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgEmojiExtra.class);
    if (yYMsgEmojiExtra != null) {
      textView.setText(String.format(this.k.getResources().getString(R.string.yy_emoji_result), new Object[] { yYAudienceModel.getName(), yYMsgEmojiExtra.name, yYMsgEmojiExtra.result }));
      return;
    } 
    textView.setText(String.format(this.k.getResources().getString(R.string.yy_emoji_result), new Object[] { yYAudienceModel.getName(), "猜拳", "出了布" }));
  }
  
  private void g(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ((ShapeTextView)paramBaseViewHolder.d(R.id.tv_edit)).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYImMsgAdapter.a(this.a).Q();
          }
        });
  }
  
  private void h(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ((TextView)paramBaseViewHolder.d(R.id.tv_msg_broadcast)).setText(paramYYImModel.contents);
  }
  
  private void i(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ((TextView)paramBaseViewHolder.d(R.id.tv_msg_content)).setText(this.k.getResources().getString(R.string.yy_up_apply_reject));
  }
  
  private void j(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(R.id.iv_header);
    TextView textView1 = (TextView)paramBaseViewHolder.d(R.id.txt_view);
    TextView textView2 = (TextView)paramBaseViewHolder.d(R.id.tv_gift_count);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(R.id.iv_gift_img);
    YYAudienceModel yYAudienceModel1 = paramYYImModel.source_profile;
    StringBuilder stringBuilder1 = new StringBuilder();
    StringBuilder stringBuilder2 = new StringBuilder();
    if (yYAudienceModel1 != null) {
      ImageLoader.a((IRequestHost)this.r.w_(), yYAudienceModel1.getAvatar()).a(R.drawable.user_bg_round).a(imageView1);
      stringBuilder2.append(UserRelationshipUtils.b(this.k, yYAudienceModel1.chat_anchor));
    } 
    stringBuilder1.append(this.k.getResources().getString(R.string.yy_give_to));
    YYAudienceModel yYAudienceModel2 = paramYYImModel.target_profile;
    if (yYAudienceModel2 == null)
      return; 
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(" ");
    stringBuilder3.append(yYAudienceModel2.getName());
    stringBuilder3.append(" ");
    stringBuilder1.append(stringBuilder3.toString());
    YYMsgGiftExtra yYMsgGiftExtra = (YYMsgGiftExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgGiftExtra.class);
    if (yYMsgGiftExtra != null) {
      byte b;
      ImageLoader.a((IRequestHost)this.r.w_(), yYMsgGiftExtra.gift_icon).a(R.drawable.gift_default_icon).a(imageView2);
      if (yYMsgGiftExtra.hit_batch == 1) {
        b = yYMsgGiftExtra.hit_count;
      } else {
        b = 0;
      } 
      if (b > 1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" x");
        stringBuilder.append(b);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
        spannableStringBuilder.setSpan(new RelativeSizeSpan(0.8F), 1, 2, 33);
        textView2.setText((CharSequence)spannableStringBuilder);
        textView2.setVisibility(0);
      } else {
        textView2.setVisibility(4);
      } 
      a(textView1, (Bitmap)null, 0, stringBuilder2.toString(), stringBuilder1.toString(), yYAudienceModel1);
    } 
    a((View)imageView1, yYAudienceModel1);
  }
  
  private void k(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(R.id.tv_guide);
    ((TextView)paramBaseViewHolder.d(R.id.tv_guide_content)).setText(paramYYImModel.contents);
    shapeTextView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null)
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_INSTRUCTION, yYRoomModel.room_id, yYRoomModel.uid); 
            if (YYImMsgAdapter.a(this.a) != null)
              YYImMsgAdapter.a(this.a).t(); 
          }
        });
  }
  
  private void l(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.tv_msg_content);
    YYAudienceModel yYAudienceModel = paramYYImModel.target_profile;
    if (yYAudienceModel == null)
      return; 
    YYMsgUpSeatExtra yYMsgUpSeatExtra = (YYMsgUpSeatExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgUpSeatExtra.class);
    if (yYMsgUpSeatExtra == null)
      return; 
    if (yYMsgUpSeatExtra.leave_type == 1) {
      if (TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.d().e())) {
        textView.setText(String.format(this.k.getResources().getString(R.string.yy_bean_down), new Object[] { "你" }));
        return;
      } 
      textView.setText(String.format(this.k.getResources().getString(R.string.yy_bean_down), new Object[] { yYAudienceModel.getName() }));
      return;
    } 
    if (yYMsgUpSeatExtra.leave_type == 2) {
      if (TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.d().e())) {
        textView.setText("由于发言涉及违规内容，你已被抱下麦位");
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(yYAudienceModel.getName());
      stringBuilder.append("由于发言涉及违规内容，已被抱下麦位");
      textView.setText(stringBuilder.toString());
    } 
  }
  
  private void m(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    String str;
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.tv_msg_content);
    YYAudienceModel yYAudienceModel = paramYYImModel.target_profile;
    if (yYAudienceModel == null)
      return; 
    if (TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.d().e())) {
      str = "你";
    } else {
      str = yYAudienceModel.getName();
    } 
    if (TextUtils.equals(yYAudienceModel.chat_anchor, "2")) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("被房主设为场控");
      textView.setText(stringBuilder1.toString());
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("被房主取消场控");
    textView.setText(stringBuilder.toString());
  }
  
  private void n(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    StringBuilder stringBuilder1;
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.tv_msg_content);
    YYMsgMuteStatusExtra yYMsgMuteStatusExtra = (YYMsgMuteStatusExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgMuteStatusExtra.class);
    if (yYMsgMuteStatusExtra == null)
      return; 
    YYAudienceModel yYAudienceModel1 = paramYYImModel.source_profile;
    YYAudienceModel yYAudienceModel2 = paramYYImModel.target_profile;
    if (yYAudienceModel1 == null || yYAudienceModel2 == null) {
      textView.setText("");
      return;
    } 
    String str = UserRelationshipUtils.b(this.k, yYAudienceModel1.chat_anchor);
    if (TextUtils.equals(YYRoomInfoManager.d().e(), yYMsgMuteStatusExtra.uid)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("你被");
      stringBuilder1.append(str);
      stringBuilder1.append("闭麦");
      textView.setText(stringBuilder1.toString());
      return;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(((YYImModel)stringBuilder1).target_profile.getName());
    stringBuilder2.append("被");
    stringBuilder2.append(str);
    stringBuilder2.append("闭麦");
    textView.setText(stringBuilder2.toString());
  }
  
  private void o(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.tv_msg_content);
    YYMsgMicStatusExtra yYMsgMicStatusExtra = (YYMsgMicStatusExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgMicStatusExtra.class);
    StringBuilder stringBuilder = new StringBuilder();
    if (yYMsgMicStatusExtra != null) {
      stringBuilder.append(this.k.getResources().getString(R.string.yy_role_host));
      if (yYMsgMicStatusExtra.seat_close == 0) {
        stringBuilder.append("解封");
      } else {
        stringBuilder.append("封禁");
      } 
      stringBuilder.append(yYMsgMicStatusExtra.seat_num);
      stringBuilder.append("号麦位");
    } 
    textView.setText(stringBuilder.toString());
  }
  
  private void p(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.tv_msg_content);
    StringBuilder stringBuilder = new StringBuilder();
    YYAudienceModel yYAudienceModel = paramYYImModel.source_profile;
    if (yYAudienceModel != null)
      stringBuilder.append(yYAudienceModel.getName()); 
    stringBuilder.append("关注了房主");
    textView.setText(stringBuilder.toString());
  }
  
  private void q(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_header);
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.txt_view);
    YYAudienceModel yYAudienceModel = paramYYImModel.target_profile;
    StringBuilder stringBuilder = new StringBuilder();
    if (yYAudienceModel != null) {
      stringBuilder.append(yYAudienceModel.getName());
      stringBuilder.append(" ");
      stringBuilder.append(paramYYImModel.contents);
      ImageLoader.a((IRequestHost)this.r.w_(), yYAudienceModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
      textView.setText(stringBuilder.toString());
    } 
    a((View)imageView, yYAudienceModel);
  }
  
  private void r(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_header);
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.txt_view);
    YYAudienceModel yYAudienceModel = paramYYImModel.target_profile;
    StringBuilder stringBuilder = new StringBuilder();
    if (yYAudienceModel != null) {
      stringBuilder.append(yYAudienceModel.getName());
      stringBuilder.append(" ");
      stringBuilder.append("被移出了房间");
      ImageLoader.a((IRequestHost)this.r.w_(), yYAudienceModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
      textView.setText(stringBuilder.toString());
    } 
  }
  
  private void s(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_header);
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.txt_view);
    YYAudienceModel yYAudienceModel = paramYYImModel.target_profile;
    StringBuilder stringBuilder = new StringBuilder();
    if (yYAudienceModel != null) {
      stringBuilder.append(" ");
      stringBuilder.append(yYAudienceModel.getName());
      stringBuilder.append(" ");
      ImageLoader.a((IRequestHost)this.r.w_(), yYAudienceModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
    } 
    if ((YYMsgUpSeatExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgUpSeatExtra.class) != null)
      stringBuilder.append(this.k.getResources().getString(R.string.yy_msg_up_seat_success)); 
    if (textView.getLayoutParams() instanceof LinearLayout.LayoutParams)
      ((LinearLayout.LayoutParams)textView.getLayoutParams()).gravity = 16; 
    textView.setText(stringBuilder.toString());
    a((View)imageView, yYAudienceModel);
  }
  
  private void t(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ((TextView)paramBaseViewHolder.d(R.id.tv_msg_content)).setText(paramYYImModel.contents);
  }
  
  private void u(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    TextView textView2 = (TextView)paramBaseViewHolder.d(R.id.tv_msg_title);
    TextView textView1 = (TextView)paramBaseViewHolder.d(R.id.tv_msg_content);
    YYMsgOfficeExtra yYMsgOfficeExtra = (YYMsgOfficeExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgOfficeExtra.class);
    if (yYMsgOfficeExtra != null) {
      if (!TextUtils.isEmpty(yYMsgOfficeExtra.text_color)) {
        textView2.setTextColor(Color.parseColor(yYMsgOfficeExtra.text_color));
        textView1.setTextColor(Color.parseColor(yYMsgOfficeExtra.text_color));
      } 
      if (TextUtils.isEmpty(yYMsgOfficeExtra.title)) {
        textView2.setVisibility(8);
      } else {
        textView2.setVisibility(0);
        textView2.setText(yYMsgOfficeExtra.title);
      } 
      if (TextUtils.isEmpty(yYMsgOfficeExtra.content)) {
        textView1.setVisibility(8);
        return;
      } 
      textView1.setVisibility(0);
      textView1.setText(yYMsgOfficeExtra.content);
    } 
  }
  
  private void v(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_header);
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.txt_view);
    YYAudienceModel yYAudienceModel = paramYYImModel.source_profile;
    String str2 = "";
    byte b = 0;
    String str1 = str2;
    int i = b;
    if (yYAudienceModel != null) {
      ImageLoader.a((IRequestHost)this.r.w_(), yYAudienceModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
      if (TextUtils.equals("2", yYAudienceModel.chat_anchor)) {
        str1 = this.k.getResources().getString(R.string.yy_role_manager);
        i = R.color.syc_8F38FD;
      } else {
        str1 = str2;
        i = b;
        if (TextUtils.equals("1", yYAudienceModel.chat_anchor)) {
          str1 = this.k.getResources().getString(R.string.yy_role_host);
          i = R.color.syc_3883FD;
        } 
      } 
    } 
    textView.setText(a(CommonStringUtils.a(this.k, str1, i, yYAudienceModel.getName(), paramYYImModel.contents)));
    textView.setOnLongClickListener(new View.OnLongClickListener(this, paramBaseViewHolder) {
          public boolean onLongClick(View param1View) {
            YYImMsgAdapter.a(this.b, this.a.getAdapterPosition());
            return true;
          }
        });
    textView.setMovementMethod(LinkMovementMethod.getInstance());
    a((View)imageView, yYAudienceModel);
  }
  
  private void w(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_header);
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.txt_view);
    YYAudienceModel yYAudienceModel = paramYYImModel.source_profile;
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    if (yYUserInfo != null && yYAudienceModel != null) {
      SpannableStringBuilder spannableStringBuilder;
      if (yYRoomModel == null)
        return; 
      StringBuilder stringBuilder1 = new StringBuilder();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("@(name:");
      stringBuilder2.append(yYAudienceModel.getName());
      stringBuilder2.append(",id:");
      stringBuilder2.append(EncryptTool.b(yYAudienceModel.getUid()));
      stringBuilder2.append(") ");
      String str = stringBuilder2.toString();
      if (TextUtils.equals(yYUserInfo.getUid(), yYAudienceModel.getUid())) {
        ImageLoader.a((IRequestHost)this.r.w_(), yYRoomModel.avatar).a(R.drawable.user_bg_round).a(imageView);
        stringBuilder1.append("欢迎");
        stringBuilder1.append(str);
        stringBuilder1.append("来到我的房间");
        spannableStringBuilder = CommonStringUtils.a(this.k, "房主", R.color.syc_3883FD, yYRoomModel.name, stringBuilder1.toString());
        yYAudienceModel = new YYAudienceModel();
        yYAudienceModel.setUid(yYRoomModel.uid);
        yYAudienceModel.setName(yYRoomModel.name);
        yYAudienceModel.setAvatar(yYRoomModel.avatar);
        yYAudienceModel.chat_anchor = "1";
        a((View)imageView, yYAudienceModel);
      } else {
        ImageLoader.a((IRequestHost)this.r.w_(), yYAudienceModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
        stringBuilder1.append(str);
        stringBuilder1.append("进来陪你聊天");
        spannableStringBuilder = CommonStringUtils.a(this.k, "", R.color.syc_3883FD, "", stringBuilder1.toString());
        a((View)imageView, yYAudienceModel);
      } 
      textView.setText(a(spannableStringBuilder));
      textView.setMovementMethod(LinkMovementMethod.getInstance());
    } 
  }
  
  private void x(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ((ShapeTextView)paramBaseViewHolder.d(R.id.tv_rename)).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYImMsgAdapter.a(this.a).u();
          }
        });
  }
  
  private void y(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_header);
    ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(R.id.tv_follow);
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.txt_view);
    YYAudienceModel yYAudienceModel = paramYYImModel.source_profile;
    if (yYAudienceModel != null) {
      ImageLoader.a((IRequestHost)this.r.w_(), yYAudienceModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
      textView.setText(this.k.getResources().getString(R.string.yy_msg_follow));
      YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null)
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_GUIDE_SHOW, yYRoomModel.room_id, yYRoomModel.uid); 
    } 
    shapeTextView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel == null)
              return; 
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_GUIDE_FOLLOW_CLICK, yYRoomModel.room_id, yYRoomModel.uid);
            YYRoomInfoManager.d().b(YYImMsgAdapter.b(this.a), yYRoomModel.uid, yYRoomModel.name, (IRequestHost)YYImMsgAdapter.a(this.a).w_());
          }
        });
  }
  
  private void z(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_header);
    ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(R.id.tv_send_gift);
    YYAudienceModel yYAudienceModel = paramYYImModel.source_profile;
    if (yYAudienceModel != null)
      ImageLoader.a((IRequestHost)this.r.w_(), yYAudienceModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView); 
    shapeTextView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null)
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_SEND_GIFT_CLICK, yYRoomModel.room_id, yYRoomModel.uid); 
            YYImMsgAdapter.a(this.a).a(true, "gift_guiding_robot", "");
          }
        });
  }
  
  public void a() {
    if (this.s == null)
      return; 
    Logger.e(j, new Object[] { "onDetachedFromWindow ... " });
    for (String str : this.s.keySet()) {
      Bitmap bitmap = this.s.get(str);
      if (bitmap == null)
        continue; 
      bitmap.recycle();
    } 
    this.s.clear();
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYImModel paramYYImModel) {
    if (paramBaseViewHolder == null)
      return; 
    int i = paramBaseViewHolder.getItemViewType();
    if (i != -6) {
      if (i != -5) {
        if (i != -4) {
          if (i != -3) {
            if (i != -2) {
              if (i != 1) {
                if (i != 2) {
                  if (i != 23) {
                    if (i != 31) {
                      if (i != 36) {
                        switch (i) {
                          default:
                            switch (i) {
                              default:
                                switch (i) {
                                  default:
                                    return;
                                  case 28:
                                    e(paramBaseViewHolder, paramYYImModel);
                                    return;
                                  case 27:
                                    f(paramBaseViewHolder, paramYYImModel);
                                    return;
                                  case 26:
                                    break;
                                } 
                                h(paramBaseViewHolder, paramYYImModel);
                                return;
                              case 21:
                                u(paramBaseViewHolder, paramYYImModel);
                                return;
                              case 20:
                                x(paramBaseViewHolder, paramYYImModel);
                                return;
                              case 19:
                                r(paramBaseViewHolder, paramYYImModel);
                                return;
                              case 18:
                                o(paramBaseViewHolder, paramYYImModel);
                                return;
                              case 17:
                                n(paramBaseViewHolder, paramYYImModel);
                                return;
                              case 16:
                                c(paramBaseViewHolder, paramYYImModel);
                                return;
                              case 15:
                                l(paramBaseViewHolder, paramYYImModel);
                                return;
                              case 14:
                                break;
                            } 
                            s(paramBaseViewHolder, paramYYImModel);
                            return;
                          case 11:
                            B(paramBaseViewHolder, paramYYImModel);
                            return;
                          case 10:
                            A(paramBaseViewHolder, paramYYImModel);
                            return;
                          case 8:
                          case 9:
                            m(paramBaseViewHolder, paramYYImModel);
                            return;
                          case 7:
                            p(paramBaseViewHolder, paramYYImModel);
                            return;
                          case 6:
                            q(paramBaseViewHolder, paramYYImModel);
                            return;
                          case 5:
                            break;
                        } 
                        j(paramBaseViewHolder, paramYYImModel);
                        return;
                      } 
                      b(paramBaseViewHolder, paramYYImModel);
                      return;
                    } 
                    d(paramBaseViewHolder, paramYYImModel);
                    return;
                  } 
                  i(paramBaseViewHolder, paramYYImModel);
                  return;
                } 
                w(paramBaseViewHolder, paramYYImModel);
                return;
              } 
              v(paramBaseViewHolder, paramYYImModel);
              return;
            } 
            t(paramBaseViewHolder, paramYYImModel);
            return;
          } 
          y(paramBaseViewHolder, paramYYImModel);
          return;
        } 
        z(paramBaseViewHolder, paramYYImModel);
        return;
      } 
      g(paramBaseViewHolder, paramYYImModel);
      return;
    } 
    k(paramBaseViewHolder, paramYYImModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\YYImMsgAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */