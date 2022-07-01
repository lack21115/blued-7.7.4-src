package com.soft.blued.ui.msg;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.message.MessageProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.LabeledTextView;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.fragment.CommonWriteTextFragment;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.user.fragment.ReportUserFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.fragment.VipBubbleFragment;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;

public class ChatSettingFragment extends BaseFragment implements View.OnClickListener {
  private short A;
  
  private SessionSettingModel B;
  
  private View C;
  
  private Context D;
  
  private Bundle E;
  
  private String F;
  
  private String G;
  
  private int H;
  
  private int I;
  
  private int J;
  
  private int K;
  
  private int L;
  
  private int M;
  
  private String N;
  
  private String[] O = AppInfo.d().getResources().getStringArray(2130903106);
  
  private SessionModel P;
  
  private UserBasicModel Q;
  
  private boolean R;
  
  private String d = ChatSettingFragment.class.getSimpleName();
  
  private View e;
  
  private View f;
  
  private TextView g;
  
  private ImageView h;
  
  private ImageView i;
  
  private TextView j;
  
  private TextView k;
  
  private TextView l;
  
  private ImageView m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private LabeledTextView q;
  
  private ToggleButton r;
  
  private LabeledTextView s;
  
  private LinearLayout t;
  
  private TextView u;
  
  private ImageView v;
  
  private View w;
  
  private boolean x = false;
  
  private Dialog y;
  
  private String z;
  
  private void a() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.C.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131755595));
    commonTopTitleNoTrans.setLeftClickListener(this);
  }
  
  private void a(String paramString) {
    String str = paramString;
    if (StringUtils.e(paramString))
      str = ""; 
    Bundle bundle = new Bundle();
    bundle.putString("max_count", "20");
    bundle.putString("string_edit_hint", getResources().getString(2131758397));
    bundle.putString("string_edit", str);
    bundle.putString("string_center", getResources().getString(2131756094));
    bundle.putBoolean("im_note", true);
    TerminalActivity.a((Fragment)this, CommonWriteTextFragment.class, bundle, 100);
  }
  
  private void a(boolean paramBoolean) {
    GroupHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
          public void a(BluedEntityA<Object> param1BluedEntityA) {}
        },  UserInfo.a().i().getUid(), this.z, paramBoolean, null);
  }
  
  private void k() {
    this.e = this.C.findViewById(2131299699);
    this.h = (ImageView)this.C.findViewById(2131296711);
    this.i = (ImageView)this.C.findViewById(2131296712);
    this.f = this.C.findViewById(2131296720);
    this.j = (TextView)this.C.findViewById(2131296719);
    this.g = (TextView)this.C.findViewById(2131296717);
    this.k = (TextView)this.C.findViewById(2131296718);
    this.m = (ImageView)this.C.findViewById(2131297581);
    this.l = (TextView)this.C.findViewById(2131296716);
    this.l.setVisibility(8);
    this.p = (TextView)this.C.findViewById(2131296721);
    this.o = (TextView)this.C.findViewById(2131296726);
    this.q = (LabeledTextView)this.C.findViewById(2131296713);
    this.q.a(Boolean.valueOf(BluedPreferences.e(0)));
    this.n = (TextView)this.C.findViewById(2131296715);
    this.r = (ToggleButton)this.C.findViewById(2131299296);
    this.v = (ImageView)this.C.findViewById(2131299295);
    this.v.setOnClickListener(this);
    this.s = (LabeledTextView)this.C.findViewById(2131296714);
    this.s.a(Boolean.valueOf(BluedPreferences.eh()));
    this.w = this.C.findViewById(2131299609);
    if (!BluedPreferences.co())
      this.w.setVisibility(0); 
    this.t = (LinearLayout)this.C.findViewById(2131298981);
    this.u = (TextView)this.C.findViewById(2131301107);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.n.setOnClickListener(this);
  }
  
  private void l() {
    this.y = DialogUtils.a(this.D);
    this.E = getArguments();
    Bundle bundle = this.E;
    if (bundle != null) {
      this.z = bundle.getString("passby_session_id");
      this.A = this.E.getShort("passby_session_type");
      this.N = this.E.getString("passby_is_in_blacklist");
      this.F = this.E.getString("passby_nick_name");
      this.G = this.E.getString("passby_nick_note");
      this.M = this.E.getInt("passby_remind_audio");
      this.H = this.E.getInt("passby_vip_grade");
      this.I = this.E.getInt("passby_is_vip_annual");
      this.J = this.E.getInt("passby_vip_exp_lvl");
      this.L = this.E.getInt("passby_show_vip_page");
      this.K = this.E.getInt("passby_is_hide_vip_look");
      this.Q = (UserBasicModel)this.E.getSerializable("user");
      this.R = this.E.getBoolean("IS_FROM_MSG_BOX", false);
      UserBasicModel userBasicModel2 = this.Q;
      if (userBasicModel2 != null && userBasicModel2.is_official == 1) {
        this.o.setVisibility(8);
      } else {
        this.o.setVisibility(0);
      } 
      this.P = ChatManager.getInstance().getSnapSessionModel(this.A, Long.valueOf(this.z).longValue());
      SessionModel sessionModel = this.P;
      if (sessionModel != null) {
        boolean bool;
        this.B = (SessionSettingModel)sessionModel.sessionSettingModel;
        ImageView imageView = this.v;
        if (this.P.lieTop == 1) {
          bool = true;
        } else {
          bool = false;
        } 
        imageView.setSelected(bool);
      } else {
        ChatManager.getInstance().getSessionModel(this.A, Long.valueOf(this.z).longValue(), new FetchDataListener<SessionModel>(this) {
              public void a(SessionModel param1SessionModel) {
                if (param1SessionModel == null)
                  return; 
                ChatSettingFragment.a(this.a, param1SessionModel);
                ChatSettingFragment.a(this.a, (SessionSettingModel)param1SessionModel.sessionSettingModel);
                ImageView imageView = ChatSettingFragment.a(this.a);
                int i = param1SessionModel.lieTop;
                boolean bool = true;
                if (i != 1)
                  bool = false; 
                imageView.setSelected(bool);
              }
            });
      } 
      if (!StringUtils.e(this.F) && !StringUtils.e(this.G)) {
        this.k.setText(this.G);
        TextView textView1 = this.g;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.D.getResources().getText(2131755495));
        stringBuilder1.append(": ");
        stringBuilder1.append(this.F);
        textView1.setText(stringBuilder1.toString());
        this.j.setText(this.G);
      } else {
        if (!StringUtils.e(this.F)) {
          this.k.setText(this.F);
        } else {
          TextView textView1 = this.k;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.z);
          stringBuilder1.append("");
          textView1.setText(stringBuilder1.toString());
        } 
        this.g.setVisibility(8);
      } 
      UserBasicModel userBasicModel1 = new UserBasicModel();
      userBasicModel1.vip_grade = this.H;
      userBasicModel1.is_vip_annual = this.I;
      userBasicModel1.is_hide_vip_look = this.K;
      userBasicModel1.vip_exp_lvl = this.J;
      UserRelationshipUtils.a(this.D, this.k, userBasicModel1);
      UserRelationshipUtils.a(this.m, userBasicModel1);
      TextView textView = this.l;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ID: ");
      stringBuilder.append(this.z);
      textView.setText(stringBuilder.toString());
      if (this.M == 0) {
        this.r.setChecked(false);
      } else {
        this.r.setChecked(true);
      } 
      this.r.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
            public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
              if (param1Boolean) {
                ChatSettingFragment.a(this.a, 1);
                if (ChatSettingFragment.b(this.a) != null) {
                  ChatSettingFragment.b(this.a).setRemindAudio(1);
                  ChatManager.getInstance().setSessionSetting(ChatSettingFragment.b(this.a).getSessionType(), ChatSettingFragment.b(this.a).getSessionId(), (SessionSettingBaseModel)ChatSettingFragment.b(this.a));
                } else {
                  SessionSettingModel sessionSettingModel = new SessionSettingModel();
                  sessionSettingModel.setLoadName(Long.valueOf(UserInfo.a().i().getUid()).longValue());
                  sessionSettingModel.setSessionId(Long.valueOf(ChatSettingFragment.c(this.a)).longValue());
                  sessionSettingModel.setSessionType(ChatSettingFragment.d(this.a));
                  sessionSettingModel.setRemindAudio(1);
                  ChatManager.getInstance().setSessionSetting(sessionSettingModel.getSessionType(), sessionSettingModel.getSessionId(), (SessionSettingBaseModel)sessionSettingModel);
                } 
              } else {
                ChatSettingFragment.a(this.a, 0);
                if (ChatSettingFragment.b(this.a) != null) {
                  ChatSettingFragment.b(this.a).setRemindAudio(0);
                  ChatManager.getInstance().setSessionSetting(ChatSettingFragment.b(this.a).getSessionType(), ChatSettingFragment.b(this.a).getSessionId(), (SessionSettingBaseModel)ChatSettingFragment.b(this.a));
                } else {
                  SessionSettingModel sessionSettingModel = new SessionSettingModel();
                  sessionSettingModel.setLoadName(Long.valueOf(UserInfo.a().i().getUid()).longValue());
                  sessionSettingModel.setSessionId(Long.valueOf(ChatSettingFragment.c(this.a)).longValue());
                  sessionSettingModel.setSessionType(ChatSettingFragment.d(this.a));
                  sessionSettingModel.setRemindAudio(0);
                  ChatManager.getInstance().setSessionSetting(sessionSettingModel.getSessionType(), sessionSettingModel.getSessionId(), (SessionSettingBaseModel)sessionSettingModel);
                } 
              } 
              ChatSettingFragment.a(this.a, param1Boolean);
            }
          });
      ImageLoader.a((IRequestHost)w_(), this.E.getString("passby_avatar")).c().a(2131234356).a(this.h);
      UserRelationshipUtils.a(this.i, this.E.getInt("passby_vbadge"), 3);
      if (!StringUtils.e(this.N) && this.N.equals("1")) {
        this.o.setText(getResources().getString(2131758573));
      } else {
        this.o.setText(getResources().getString(2131755594));
      } 
    } 
    if (this.R) {
      this.t.setVisibility(8);
      this.u.setVisibility(8);
    } 
  }
  
  private void m() {
    Intent intent = new Intent();
    intent.putExtra("result_delete_msg", this.x);
    intent.putExtra("passby_is_in_blacklist", this.N);
    getActivity().setResult(-1, intent);
    getActivity().finish();
    if (!BluedPreferences.co()) {
      BluedPreferences.cp();
      this.w.setVisibility(8);
    } 
  }
  
  private void n() {
    if (StringUtils.e(this.N) || this.N.equals("0")) {
      UserHttpUtils.b((Context)getActivity(), new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
            protected void a(BluedEntityA<Object> param1BluedEntityA) {
              AppMethods.d(2131755238);
              ChatSettingFragment.a(this.a, "1");
              if (ChatSettingFragment.f(this.a) != null && this.a.getActivity() != null)
                ChatSettingFragment.f(this.a).setText(this.a.getActivity().getResources().getString(2131758573)); 
              ChatHelperV4.a().b(Long.valueOf(ChatSettingFragment.c(this.a)).longValue());
              UserInfoEntity userInfoEntity = new UserInfoEntity();
              userInfoEntity.uid = ChatSettingFragment.c(this.a);
              userInfoEntity.relationship = "4";
              LiveEventBus.get("feed_relation_ship").post(userInfoEntity);
              HomeArgumentHelper.a(ChatSettingFragment.g(this.a), "msg", null);
            }
            
            public void onUIFinish() {
              super.onUIFinish();
              DialogUtils.b(ChatSettingFragment.e(this.a));
            }
            
            public void onUIStart() {
              DialogUtils.a(ChatSettingFragment.e(this.a));
              super.onUIStart();
            }
          }UserInfo.a().i().getUid(), this.z, (IRequestHost)w_());
      return;
    } 
    UserHttpUtils.c((Context)getActivity(), new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            DialogUtils.b(ChatSettingFragment.e(this.a));
            AppMethods.d(2131758572);
            ChatSettingFragment.a(this.a, "0");
            ChatSettingFragment.f(this.a).setText(this.a.getActivity().getResources().getString(2131755594));
            UserInfoEntity userInfoEntity = new UserInfoEntity();
            userInfoEntity.uid = ChatSettingFragment.c(this.a);
            userInfoEntity.relationship = "0";
            LiveEventBus.get("feed_relation_ship").post(userInfoEntity);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ChatSettingFragment.e(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ChatSettingFragment.e(this.a));
          }
        }UserInfo.a().i().getUid(), this.z, (IRequestHost)w_());
  }
  
  public boolean V_() {
    m();
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1) {
      switch (paramInt1) {
        default:
          return;
        case 102:
          getActivity().setResult(-1, paramIntent);
          getActivity().finish();
          return;
        case 101:
          Logger.c("ljxlog", new Object[] { Boolean.valueOf(paramIntent.getExtras().getBoolean("chat_setting", false)) });
          if (paramIntent != null && paramIntent.getExtras() != null && paramIntent.getExtras().getBoolean("chat_setting", false)) {
            getActivity().finish();
            return;
          } 
          return;
        case 100:
          break;
      } 
      if (paramIntent != null) {
        String str = paramIntent.getStringExtra("string_edit");
        MineHttpUtils.h((Context)getActivity(), new BluedUIHttpResponse<BluedEntityA<Object>>(this, str) {
              protected void a(BluedEntityA<Object> param1BluedEntityA) {
                DialogUtils.b(ChatSettingFragment.e(this.b));
                AppMethods.d(2131757917);
                boolean bool = StringUtils.e(ChatSettingFragment.h(this.b));
                String str = "";
                if (!bool && !StringUtils.e(this.a)) {
                  ChatSettingFragment.i(this.b).setText(this.a);
                  TextView textView = ChatSettingFragment.j(this.b);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(ChatSettingFragment.g(this.b).getResources().getText(2131755495));
                  stringBuilder.append(": ");
                  stringBuilder.append(ChatSettingFragment.h(this.b));
                  textView.setText(stringBuilder.toString());
                  ChatSettingFragment.j(this.b).setVisibility(0);
                  ChatSettingFragment.k(this.b).setText(this.a);
                } else {
                  if (!StringUtils.e(ChatSettingFragment.h(this.b))) {
                    ChatSettingFragment.i(this.b).setText(ChatSettingFragment.h(this.b));
                  } else {
                    TextView textView = ChatSettingFragment.i(this.b);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(ChatSettingFragment.c(this.b));
                    stringBuilder.append("");
                    textView.setText(stringBuilder.toString());
                  } 
                  ChatSettingFragment.j(this.b).setVisibility(8);
                  ChatSettingFragment.k(this.b).setText("");
                } 
                if (ChatSettingFragment.b(this.b) != null) {
                  SessionSettingModel sessionSettingModel1 = ChatSettingFragment.b(this.b);
                  if (!StringUtils.e(this.a))
                    str = this.a; 
                  sessionSettingModel1.setSessinoNote(str);
                  ChatManager.getInstance().setSessionSetting(ChatSettingFragment.b(this.b).getSessionType(), ChatSettingFragment.b(this.b).getSessionId(), (SessionSettingBaseModel)ChatSettingFragment.b(this.b));
                  return;
                } 
                SessionSettingModel sessionSettingModel = new SessionSettingModel();
                sessionSettingModel.setLoadName(Long.valueOf(UserInfo.a().i().getUid()).longValue());
                sessionSettingModel.setSessionId(Long.parseLong(ChatSettingFragment.c(this.b)));
                sessionSettingModel.setSessionType(ChatSettingFragment.d(this.b));
                if (!StringUtils.e(this.a))
                  str = this.a; 
                sessionSettingModel.setSessinoNote(str);
                ChatManager.getInstance().setSessionSetting(ChatSettingFragment.d(this.b), Long.parseLong(ChatSettingFragment.c(this.b)), (SessionSettingBaseModel)sessionSettingModel);
              }
              
              public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(ChatSettingFragment.e(this.b));
              }
              
              public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ChatSettingFragment.e(this.b));
              }
            }UserInfo.a().i().getUid(), str, this.z, (IRequestHost)w_());
      } 
    } 
  }
  
  public void onClick(View paramView) {
    UserBasicModel userBasicModel1;
    SessionModel sessionModel;
    FragmentActivity fragmentActivity;
    StringBuilder stringBuilder1;
    Context context;
    boolean bool1;
    String str1;
    StringBuilder stringBuilder2;
    String str2;
    UserBasicModel userBasicModel2;
    int i = paramView.getId();
    boolean bool2 = true;
    Boolean bool = Boolean.valueOf(false);
    switch (i) {
      default:
        return;
      case 2131299699:
        userBasicModel1 = new UserBasicModel();
        userBasicModel1.uid = this.z;
        userBasicModel1.is_show_vip_page = this.L;
        userBasicModel1.avatar = this.E.getString("passby_avatar");
        UserInfoFragmentNew.a((Fragment)this, userBasicModel1, "chat_setting", 101);
        return;
      case 2131299295:
        EventTrackMessage.a(MessageProtos.Event.MSG_TO_UP_BTN_CLICK);
        if (!BluedPreferences.co()) {
          BluedPreferences.cp();
          this.w.setVisibility(8);
        } 
        sessionModel = this.P;
        if (sessionModel != null) {
          GroupUtil.a(sessionModel, this.v, (IRequestHost)w_());
          return;
        } 
        return;
      case 2131296863:
        m();
        return;
      case 2131296726:
        n();
        return;
      case 2131296721:
        fragmentActivity = getActivity();
        str1 = this.z;
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.k.getText());
        stringBuilder2.append("");
        str2 = stringBuilder2.toString();
        userBasicModel2 = this.Q;
        bool1 = bool2;
        if (userBasicModel2 != null)
          if (userBasicModel2.is_official != 1) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }  
        ReportUserFragment.a((Context)fragmentActivity, str1, str2, bool1);
        return;
      case 2131296720:
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.j.getText());
        stringBuilder1.append("");
        a(stringBuilder1.toString());
        return;
      case 2131296715:
        context = this.D;
        CommonAlertDialog.a(context, context.getResources().getString(2131755498), this.D.getResources().getString(2131755805), this.D.getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                ChatManager.getInstance().deleteSessionAndChatting(Short.valueOf((short)2), Long.valueOf(ChatSettingFragment.c(this.a)).longValue());
                LiveEventBus.get("check_show_hello_expression").postDelay(null, 500L);
                ChatSettingFragment.b(this.a, true);
              }
            }this.D.getResources().getString(2131756057), new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
            },  null);
        return;
      case 2131296714:
        EventTrackMessage.a(MessageProtos.Event.MSG_SETTINGS_BUBBLE_CLICK);
        if (BluedPreferences.eh()) {
          BluedPreferences.ei();
          this.s.a((Boolean)context);
        } 
        VipBubbleFragment.a(this.D, 0, "chat_setting_bubble");
        return;
      case 2131296713:
        break;
    } 
    EventTrackMessage.a(MessageProtos.Event.MSG_CHAT_SET_BACKGROUND_BTN_CLICK, MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, this.z);
    LabeledTextView labeledTextView = this.q;
    if (labeledTextView != null)
      labeledTextView.a((Boolean)context); 
    BluedPreferences.f(0);
    if ((UserInfo.a().i()).vip_grade != 0 || (BluedConfig.b().j()).is_chat_backgrounds == 1) {
      ChatBgSettingFragment.a(this, 0, Long.parseLong(this.z), this.A, 102);
      return;
    } 
    PayUtils.a(this.D, 23, "chat_customize_bg");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = ChatSettingFragment.class.getSimpleName();
    this.D = (Context)getActivity();
    View view = this.C;
    if (view == null) {
      this.C = paramLayoutInflater.inflate(2131493087, paramViewGroup, false);
      a();
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.C.getParent()).removeView(this.C);
    } 
    return this.C;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\ChatSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */