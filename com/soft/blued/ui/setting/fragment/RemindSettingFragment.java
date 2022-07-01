package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.BluedConstant;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import java.util.Map;

public class RemindSettingFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
  private SessionSettingModel A;
  
  private String d = RemindSettingFragment.class.getSimpleName();
  
  private View e;
  
  private Context f;
  
  private LinearLayout g;
  
  private TextView h;
  
  private ToggleButton i;
  
  private ToggleButton j;
  
  private ToggleButton k;
  
  private ToggleButton l;
  
  private ToggleButton m;
  
  private ToggleButton n;
  
  private ToggleButton o;
  
  private ToggleButton p;
  
  private ToggleButton q;
  
  private ToggleButton r;
  
  private ToggleButton s;
  
  private ToggleButton t;
  
  private ToggleButton u;
  
  private ToggleButton v;
  
  private ToggleButton w;
  
  private LinearLayout x;
  
  private LinearLayout y;
  
  private ToggleButton z;
  
  private void a(Map<String, String> paramMap) {
    if (paramMap != null) {
      if (paramMap.size() == 0)
        return; 
      MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
            public void a(BluedEntityA<Object> param1BluedEntityA) {}
          },  UserInfo.a().i().getUid(), paramMap, null);
    } 
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.g.setVisibility(0);
      this.h.setVisibility(0);
      return;
    } 
    this.g.setVisibility(8);
    this.h.setVisibility(8);
  }
  
  private void l() {
    ChatManager chatManager = ChatManager.getInstance();
    boolean bool = true;
    SessionModel sessionModel = chatManager.getSnapSessionModel((short)1, 2L);
    if (sessionModel != null) {
      this.A = (SessionSettingModel)sessionModel.sessionSettingModel;
      SessionSettingModel sessionSettingModel = this.A;
      if (sessionSettingModel != null) {
        if (sessionSettingModel.getRemindAudio() != 0)
          bool = false; 
        this.q.setChecked(bool);
        this.q.setOnCheckedChangeListener(this);
        return;
      } 
    } else {
      ChatManager.getInstance().getSessionSettingModel((short)1, 2L, new FetchDataListener<SessionSettingBaseModel>(this) {
            public void a(SessionSettingBaseModel param1SessionSettingBaseModel) {
              RemindSettingFragment.a(this.a, (SessionSettingModel)param1SessionSettingBaseModel);
              if (RemindSettingFragment.a(this.a) == null) {
                RemindSettingFragment.a(this.a, new SessionSettingModel());
                RemindSettingFragment.a(this.a).setLoadName(Long.valueOf(UserInfo.a().i().getUid()).longValue());
                RemindSettingFragment.a(this.a).setSessionId(2L);
                RemindSettingFragment.a(this.a).setSessionType((short)1);
              } 
              this.a.a(new Runnable(this) {
                    public void run() {
                      boolean bool;
                      if (RemindSettingFragment.a(this.a.a).getRemindAudio() == 0) {
                        bool = true;
                      } else {
                        bool = false;
                      } 
                      RemindSettingFragment.b(this.a.a).setChecked(bool);
                      RemindSettingFragment.b(this.a.a).setOnCheckedChangeListener(this.a.a);
                    }
                  });
            }
          });
    } 
  }
  
  public void a() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.e();
    commonTopTitleNoTrans.setCenterText(getString(2131758567));
    commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
  }
  
  public void k() {
    this.x = (LinearLayout)this.e.findViewById(2131298861);
    if (BluedConstant.a) {
      this.x.setVisibility(8);
    } else {
      this.x.setVisibility(0);
    } 
    this.w = (ToggleButton)this.e.findViewById(2131300253);
    this.h = (TextView)this.e.findViewById(2131301398);
    this.g = (LinearLayout)this.e.findViewById(2131298135);
    this.l = (ToggleButton)this.e.findViewById(2131300257);
    this.j = (ToggleButton)this.e.findViewById(2131300255);
    this.i = (ToggleButton)this.e.findViewById(2131300260);
    this.k = (ToggleButton)this.e.findViewById(2131300256);
    this.m = (ToggleButton)this.e.findViewById(2131300193);
    this.n = (ToggleButton)this.e.findViewById(2131300194);
    this.r = (ToggleButton)this.e.findViewById(2131300252);
    this.o = (ToggleButton)this.e.findViewById(2131300192);
    this.p = (ToggleButton)this.e.findViewById(2131300189);
    this.q = (ToggleButton)this.e.findViewById(2131300191);
    this.s = (ToggleButton)this.e.findViewById(2131300249);
    this.t = (ToggleButton)this.e.findViewById(2131300195);
    this.u = (ToggleButton)this.e.findViewById(2131300251);
    this.v = (ToggleButton)this.e.findViewById(2131300250);
    this.z = (ToggleButton)this.e.findViewById(2131300188);
    this.y = (LinearLayout)this.e.findViewById(2131298951);
    this.w.setChecked(BluedPreferences.ah());
    this.l.setChecked(BluedPreferences.ae());
    a(BluedPreferences.ac());
    this.j.setChecked(BluedPreferences.ac());
    this.i.setChecked(BluedPreferences.aa());
    this.k.setChecked(BluedPreferences.ad());
    this.n.setChecked(BluedPreferences.af());
    this.r.setChecked(BluedPreferences.ag());
    this.o.setChecked(BluedPreferences.ai());
    this.p.setChecked(BluedPreferences.aj());
    this.q.setChecked(BluedPreferences.ak());
    l();
    this.s.setChecked(BluedPreferences.al());
    this.m.setChecked(BluedPreferences.ap());
    this.t.setChecked(BluedPreferences.ao());
    this.u.setChecked(BluedPreferences.am());
    this.v.setChecked(BluedPreferences.an());
    this.z.setChecked(BluedPreferences.aq());
    this.w.setOnCheckedChangeListener(this);
    this.m.setOnCheckedChangeListener(this);
    this.l.setOnCheckedChangeListener(this);
    this.j.setOnCheckedChangeListener(this);
    this.i.setOnCheckedChangeListener(this);
    this.k.setOnCheckedChangeListener(this);
    this.n.setOnCheckedChangeListener(this);
    this.r.setOnCheckedChangeListener(this);
    this.o.setOnCheckedChangeListener(this);
    this.p.setOnCheckedChangeListener(this);
    this.s.setOnCheckedChangeListener(this);
    this.t.setOnCheckedChangeListener(this);
    this.u.setOnCheckedChangeListener(this);
    this.v.setOnCheckedChangeListener(this);
    this.z.setOnCheckedChangeListener(this);
    this.y.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_MSG_CLICK);
            MessageNotifyFragment.a(this.a.getContext());
          }
        });
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    Map<String, String> map = BluedHttpTools.a();
    int i = paramCompoundButton.getId();
    String str = "1";
    if (i != 2131300260) {
      SessionSettingModel sessionSettingModel;
      switch (i) {
        default:
          switch (i) {
            default:
              switch (i) {
                default:
                  switch (i) {
                    default:
                      break;
                    case 2131300257:
                      BluedPreferences.i(paramBoolean);
                      if (!paramBoolean)
                        str = "0"; 
                      map.put("is_push_content", str);
                      break;
                    case 2131300256:
                      BluedPreferences.h(paramBoolean);
                      if (!paramBoolean)
                        str = "0"; 
                      map.put("is_open_shake", str);
                      break;
                    case 2131300255:
                      break;
                  } 
                  BluedPreferences.g(paramBoolean);
                  a(paramBoolean);
                  if (!paramBoolean)
                    str = "0"; 
                  map.put("is_open_sound", str);
                  break;
                case 2131300253:
                  BluedPreferences.l(paramBoolean);
                  if (!paramBoolean)
                    str = "0"; 
                  map.put("is_other_message_push", str);
                  break;
                case 2131300252:
                  BluedPreferences.k(paramBoolean);
                  if (paramBoolean)
                    str = "0"; 
                  map.put("is_live_push", str);
                  break;
                case 2131300251:
                  BluedPreferences.q(paramBoolean);
                  if (!paramBoolean)
                    str = "0"; 
                  map.put("is_like_push", str);
                  break;
                case 2131300250:
                  BluedPreferences.r(paramBoolean);
                  if (!paramBoolean)
                    str = "0"; 
                  map.put("is_at_push", str);
                  break;
                case 2131300249:
                  break;
              } 
              BluedPreferences.p(paramBoolean);
              if (!paramBoolean)
                str = "0"; 
              map.put("is_comment_push", str);
              break;
            case 2131300195:
              BluedPreferences.s(paramBoolean);
              if (!paramBoolean)
                str = "0"; 
              map.put("is_visited_push", str);
              break;
            case 2131300194:
              BluedPreferences.j(paramBoolean);
              if (!paramBoolean)
                str = "0"; 
              map.put("is_system_push", str);
              break;
            case 2131300193:
              BluedPreferences.t(paramBoolean);
              if (!paramBoolean)
                str = "0"; 
              map.put("is_recall_live_push", str);
              break;
            case 2131300192:
              BluedPreferences.m(paramBoolean);
              if (!paramBoolean)
                str = "0"; 
              map.put("is_private_msg_push", str);
              break;
            case 2131300191:
              break;
          } 
          sessionSettingModel = this.A;
          if (sessionSettingModel != null) {
            sessionSettingModel.setRemindAudio(paramBoolean ^ true);
            ChatManager.getInstance().setSessionSetting(this.A.getSessionType(), this.A.getSessionId(), (SessionSettingBaseModel)this.A);
          } 
          BluedPreferences.o(paramBoolean);
          if (!paramBoolean)
            str = "0"; 
          map.put("is_groups_notify", str);
          break;
        case 2131300189:
          BluedPreferences.n(paramBoolean);
          if (!paramBoolean)
            str = "0"; 
          map.put("is_followed_push", str);
          break;
        case 2131300188:
          BluedPreferences.u(paramBoolean);
          if (!paramBoolean)
            str = "0"; 
          map.put("is_push_posting_post", str);
          break;
      } 
    } else {
      BluedPreferences.f(paramBoolean);
      if (!paramBoolean)
        str = "0"; 
      map.put("is_bluedtone", str);
    } 
    a(map);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493297, paramViewGroup, false);
      k();
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\RemindSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */