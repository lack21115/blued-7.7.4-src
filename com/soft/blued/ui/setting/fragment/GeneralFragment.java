package com.soft.blued.ui.setting.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.grpc.backup.MsgBackupService;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.pool.ThreadPriority;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.settings.SettingsProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.LabeledTextView;
import com.soft.blued.db.BluedBaseDataHelper;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.service.UploadMsgDbService;
import com.soft.blued.ui.msg.ChatBgSettingFragment;
import com.soft.blued.ui.msg.SelectSessionFragment;
import com.soft.blued.ui.setting.event.SelectSessionEvent;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.CacheManager;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.io.File;
import java.util.Locale;
import java.util.Map;
import skin.support.observe.SkinObservable;

public class GeneralFragment extends BaseFragment implements View.OnClickListener, BluedSkinObserver {
  private ShapeTextView A;
  
  private LinearLayout B;
  
  private TextView C;
  
  private LinearLayout D;
  
  private View E;
  
  private boolean F;
  
  private CacheManager G = new CacheManager();
  
  private CommonTopTitleNoTrans H;
  
  private Dialog I;
  
  private BluedUIHttpResponse J = new BluedUIHttpResponse<BluedEntityA<BluedBlackList.privacySettingEntity>>(this, "my_privacy_setting", (IRequestHost)w_()) {
      protected BluedEntityA<BluedBlackList.privacySettingEntity> a(String param1String) {
        return (BluedEntityA<BluedBlackList.privacySettingEntity>)super.parseData(param1String);
      }
      
      protected void a(BluedEntityA<BluedBlackList.privacySettingEntity> param1BluedEntityA) {
        super.onUICache((BluedEntity)param1BluedEntityA);
        GeneralFragment.a(this.a, param1BluedEntityA);
      }
      
      public void b(BluedEntityA<BluedBlackList.privacySettingEntity> param1BluedEntityA) {
        GeneralFragment.a(this.a, param1BluedEntityA);
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
      }
    };
  
  public boolean d = false;
  
  private Context e;
  
  private View f;
  
  private ToggleButton g;
  
  private View h;
  
  private LinearLayout i;
  
  private LinearLayout j;
  
  private LinearLayout k;
  
  private TextView l;
  
  private TextView m;
  
  private View n;
  
  private TextView o;
  
  private TextView p;
  
  private ProgressBar q;
  
  private LinearLayout r;
  
  private LinearLayout s;
  
  private LabeledTextView t;
  
  private LinearLayout u;
  
  private LinearLayout v;
  
  private ShapeTextView w;
  
  private ToggleButton x;
  
  private ShapeTextView y;
  
  private ToggleButton z;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, GeneralFragment.class, null);
  }
  
  private void a(BluedEntityA<BluedBlackList.privacySettingEntity> paramBluedEntityA) {
    boolean bool = false;
    if (paramBluedEntityA != null && paramBluedEntityA.data != null && paramBluedEntityA.data.size() > 0) {
      if (((BluedBlackList.privacySettingEntity)paramBluedEntityA.data.get(0)).is_sync_avatar == 1)
        bool = true; 
      this.F = bool;
      this.g.setChecked(this.F);
    } else {
      this.F = false;
      this.g.setChecked(this.F);
    } 
    this.g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            String str;
            if (param1Boolean) {
              str = "1";
            } else {
              str = "0";
            } 
            Map<String, String> map = BluedHttpTools.a();
            map.put("is_sync_avatar", str);
            ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
                  public void a(BluedEntityA<Object> param2BluedEntityA) {
                    if (param2BluedEntityA == null)
                      try {
                        AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                        GeneralFragment.h(this.a.a).setChecked(GeneralFragment.g(this.a.a));
                        return;
                      } catch (Exception exception) {
                        exception.printStackTrace();
                        AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                        GeneralFragment.h(this.a.a).setChecked(GeneralFragment.g(this.a.a));
                      }  
                  }
                },  UserInfo.a().i().getUid(), map);
          }
        });
  }
  
  private void k() {
    LiveEventBus.get("select_session", SelectSessionEvent.class).observe((LifecycleOwner)this, new Observer<SelectSessionEvent>(this) {
          public void a(SelectSessionEvent param1SelectSessionEvent) {
            if (MsgBackupService.isRunning()) {
              ToastUtils.a("服务已运行");
              return;
            } 
            MsgBackupService.startMsgBackupService(this.a.getContext(), 11, 2131232357, "消息备份", "正在备份聊天消息，请稍后", "备份成功", BluedBaseDataHelper.a().b(), param1SelectSessionEvent.a, UploadMsgDbService.class);
          }
        });
  }
  
  private void l() {
    this.H = (CommonTopTitleNoTrans)this.f.findViewById(2131300300);
    this.H.e();
    this.H.a();
    this.H.setCenterText(getString(2131756091));
    this.H.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
  }
  
  private void m() {
    String str1;
    this.I = DialogUtils.a(getContext());
    this.g = (ToggleButton)this.f.findViewById(2131300198);
    this.g.setOnClickListener(this);
    this.h = this.f.findViewById(2131297937);
    if (BluedPreferences.bX()) {
      this.h.setVisibility(0);
    } else {
      this.h.setVisibility(8);
    } 
    this.i = (LinearLayout)this.f.findViewById(2131299121);
    this.l = (TextView)this.f.findViewById(2131301458);
    this.j = (LinearLayout)this.f.findViewById(2131298906);
    this.m = (TextView)this.f.findViewById(2131300941);
    this.k = (LinearLayout)this.f.findViewById(2131298743);
    this.n = this.f.findViewById(2131296468);
    this.o = (TextView)this.f.findViewById(2131300913);
    this.q = (ProgressBar)this.f.findViewById(2131296499);
    this.r = (LinearLayout)this.f.findViewById(2131298748);
    this.p = (TextView)this.f.findViewById(2131300638);
    this.s = (LinearLayout)this.f.findViewById(2131298747);
    this.t = (LabeledTextView)this.f.findViewById(2131296713);
    this.t.a(Boolean.valueOf(BluedPreferences.e(2)));
    this.w = (ShapeTextView)this.f.findViewById(2131297936);
    this.x = (ToggleButton)this.f.findViewById(2131300185);
    this.y = (ShapeTextView)this.f.findViewById(2131297935);
    this.z = (ToggleButton)this.f.findViewById(2131300197);
    this.u = (LinearLayout)this.f.findViewById(2131298715);
    this.v = (LinearLayout)this.f.findViewById(2131299056);
    int i = BluedPreferences.aD();
    if (i != 1) {
      if (i == 2)
        this.l.setText("ft/lb"); 
    } else {
      this.l.setText("cm/kg");
    } 
    Locale locale = LocaleUtils.c();
    String str2 = "";
    if (locale != null) {
      str2 = locale.getLanguage();
      str1 = locale.getCountry();
    } else {
      str1 = "";
    } 
    if (!LocaleUtils.a() && !TextUtils.isEmpty(str2)) {
      if (TextUtils.equals("zh", str2) && TextUtils.equals("CN", str1)) {
        this.m.setText(getResources().getString(2131757104));
      } else if (TextUtils.equals("zh", str2) && (TextUtils.equals("TW", str1) || TextUtils.equals("HK", str1))) {
        this.m.setText(getResources().getString(2131757105));
      } else if (TextUtils.equals("en", str2)) {
        this.m.setText(getResources().getString(2131757094));
      } else {
        this.m.setText(getResources().getString(2131757102));
      } 
    } else {
      this.m.setText(getResources().getString(2131757102));
    } 
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.x.setChecked(BluedPreferences.cq());
    this.x.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            BluedPreferences.E(param1Boolean);
          }
        });
    this.z.setChecked(BluedPreferences.aW());
    this.z.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            BluedPreferences.x(param1Boolean);
          }
        });
    if (!BluedPreferences.cy()) {
      this.w.setVisibility(0);
      BluedPreferences.cz();
    } 
    if (!BluedPreferences.cr()) {
      this.y.setVisibility(0);
      BluedPreferences.cs();
    } 
    this.A = (ShapeTextView)this.f.findViewById(2131297740);
    if (!BluedPreferences.ct()) {
      this.A.setVisibility(0);
    } else {
      this.A.setVisibility(8);
    } 
    this.B = (LinearLayout)this.f.findViewById(2131299084);
    this.B.setOnClickListener(this);
    this.C = (TextView)this.f.findViewById(2131301347);
    if ((FlexDebugSevConfig.a().b()).android_msg_backup == 0) {
      this.u.setVisibility(8);
      this.v.setVisibility(8);
    } 
    this.D = (LinearLayout)this.f.findViewById(2131299099);
    this.E = this.f.findViewById(2131297941);
    if ((FlexDebugSevConfig.a().b()).android_font_adjust == 1) {
      this.D.setVisibility(0);
      this.D.setOnClickListener(this);
      if (!BluedPreferences.cu()) {
        this.E.setVisibility(0);
        return;
      } 
      this.E.setVisibility(8);
      return;
    } 
    this.D.setVisibility(8);
  }
  
  private void n() {
    if (this.d) {
      this.n.setVisibility(8);
      this.o.setVisibility(8);
      this.q.setVisibility(0);
      this.r.setClickable(false);
      this.r.setOnClickListener(null);
      this.p.setTextColor(BluedSkinUtils.a(this.e, 2131100359));
      return;
    } 
    this.n.setVisibility(0);
    this.o.setVisibility(0);
    this.q.setVisibility(8);
    this.r.setClickable(true);
    this.r.setOnClickListener(this);
    this.p.setTextColor(BluedSkinUtils.a(this.e, 2131100669));
  }
  
  private void o() {
    ThreadManager.a().a(new ThreadExecutor(this, "setImageCacheSize") {
          public void execute() {
            String str = GeneralFragment.a(this.a).a();
            this.a.a(new Runnable(this, str) {
                  public void run() {
                    GeneralFragment.b(this.b.a).setText(this.a);
                  }
                });
          }
        });
  }
  
  private void p() {
    ThreadManager.a().a(new ThreadExecutor(this, "clearCache", ThreadPriority.a) {
          public void execute() {
            GeneralFragment.a(this.a).b();
            this.a.a(new Runnable(this) {
                  public void run() {
                    AppMethods.d(2131756009);
                    this.a.a.d = false;
                    GeneralFragment.c(this.a.a);
                    GeneralFragment.d(this.a.a);
                  }
                });
          }
        });
  }
  
  public void a() {
    ProfileHttpUtils.a(this.e, this.J, UserInfo.a().i().getUid(), (IRequestHost)w_());
  }
  
  public void a(SkinObservable paramSkinObservable, Object paramObject) {
    Log.e("skin", "GeneralFragment updateSkin");
    CommonTopTitleNoTrans commonTopTitleNoTrans = this.H;
    if (commonTopTitleNoTrans != null) {
      commonTopTitleNoTrans.setCenterTextColor(2131100838);
      int i = BluedSkinUtils.a(getContext(), 2131100728);
      getActivity().findViewById(16908290).setBackgroundColor(i);
    } 
    TextView textView = this.C;
    if (textView != null)
      textView.setText(this.e.getResources().getString(BluedPreferences.dN())); 
    StatusBarHelper.a((Activity)getActivity());
    StatusBarHelper.a((Activity)getActivity(), BluedSkinUtils.a(getContext(), AppInfo.k()));
  }
  
  public void onClick(View paramView) {
    FragmentActivity fragmentActivity;
    String str;
    CommonAlertDialog.TextOnClickListener textOnClickListener;
    switch (paramView.getId()) {
      default:
        return;
      case 2131300198:
        BluedPreferences.bY();
        this.h.setVisibility(8);
        return;
      case 2131299121:
        fragmentActivity = getActivity();
        str = getString(2131759101);
        textOnClickListener = new CommonAlertDialog.TextOnClickListener(this) {
            public void a(String param1String) {
              if (!StringUtils.e(param1String)) {
                GeneralFragment.e(this.a).setText(param1String);
                if ("cm/kg".equals(param1String)) {
                  BluedPreferences.c(1);
                  return;
                } 
                if ("ft/lb".equals(param1String))
                  BluedPreferences.c(2); 
              } 
            }
          };
        CommonAlertDialog.a((Context)fragmentActivity, str, new String[] { "cm/kg", "ft/lb" }, textOnClickListener);
        return;
      case 2131299099:
        BluedPreferences.G(true);
        this.E.setVisibility(8);
        TextSizeSettingFragment.a((Context)getActivity());
        return;
      case 2131299084:
        BluedPreferences.F(true);
        this.A.setVisibility(8);
        BluedSkinFragment.a((Context)getActivity());
        return;
      case 2131299056:
        if (MsgBackupService.isRunning()) {
          ToastUtils.a("服务已运行");
          return;
        } 
        if (Environment.getExternalStorageState().equals("mounted")) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(Environment.getExternalStorageDirectory());
          stringBuilder1.append(File.separator);
          stringBuilder1.append("blued");
          stringBuilder1.append(File.separator);
          stringBuilder1.append("database");
          String str1 = stringBuilder1.toString();
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("android_");
          stringBuilder2.append(ChatManager.getInstance().getUid());
          stringBuilder2.append("_");
          stringBuilder2.append(ChatManager.clientType.ordinal());
          String str2 = stringBuilder2.toString();
          Context context = getContext();
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append(str1);
          stringBuilder3.append(File.separator);
          stringBuilder3.append(str2);
          MsgBackupService.startMsgRestoreService(context, 11, 2131232357, "消息恢复", "正在恢复聊天消息，请稍后", "恢复成功", stringBuilder3.toString());
          return;
        } 
        return;
      case 2131298906:
        LanguageSelectFragment.a((Context)getActivity());
        return;
      case 2131298748:
        CommonAlertDialog.a((Context)getActivity(), getResources().getString(2131756094), getResources().getString(2131756932), getResources().getString(2131756007), new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                GeneralFragment generalFragment = this.a;
                generalFragment.d = true;
                GeneralFragment.c(generalFragment);
                GeneralFragment.f(this.a);
              }
            },  getString(2131755577), null, null);
        return;
      case 2131298747:
        CommonAlertDialog.a((Context)getActivity(), null, getResources().getString(2131756102), null, new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                ProgressDialog progressDialog = new ProgressDialog((Context)this.a.getActivity());
                progressDialog.show();
                ThreadManager.a().a(new ThreadExecutor(this, "ClearChatRecord", progressDialog) {
                      public void execute() {
                        try {
                          ChatManager.getInstance().deleteAllChattings();
                        } catch (Exception exception) {
                          exception.printStackTrace();
                        } 
                        this.b.a.a(new Runnable(this) {
                              public void run() {
                                if (this.a.a != null)
                                  this.a.a.dismiss(); 
                                AppMethods.d(2131755732);
                              }
                            });
                      }
                    });
              }
            }getString(2131755577), null, null);
        return;
      case 2131298743:
        if ((UserInfo.a().i()).vip_grade == 0 && (BluedConfig.b().j()).is_change_blued_icon == 0) {
          PayUtils.a((Context)getActivity(), 14, "setting_change_icon");
          InstantLog.a("setting_change_icon_click", 0);
        } else {
          InstantLog.a("setting_change_icon_click", 1);
          ChangeBluedIconFragment.a((Context)getActivity());
        } 
        EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_COMMON_CHANGE_ICON_CLICK);
        return;
      case 2131298715:
        TerminalActivity.d(getContext(), SelectSessionFragment.class, null);
        return;
      case 2131296713:
        break;
    } 
    LabeledTextView labeledTextView = this.t;
    if (labeledTextView != null)
      labeledTextView.a(Boolean.valueOf(false)); 
    BluedPreferences.f(2);
    if ((UserInfo.a().i()).vip_grade != 0 || (BluedConfig.b().j()).is_chat_backgrounds == 1) {
      ChatBgSettingFragment.a(this, 2, 0);
      InstantLog.a("setting_change_chat_bg_click", 1);
    } else {
      InstantLog.a("setting_change_chat_bg_click", 0);
      PayUtils.a(this.e, 23, "setting_common_background");
    } 
    EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_COMMON_CHANGE_BG_CLICK);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    View view = this.f;
    if (view == null) {
      this.f = paramLayoutInflater.inflate(2131493131, paramViewGroup, false);
      l();
      m();
      k();
      a();
      n();
      o();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    } 
    return this.f;
  }
  
  public void onDestroyView() {
    super.onDestroyView();
    BluedSkinUtils.b(this);
  }
  
  public void onResume() {
    super.onResume();
    BluedSkinUtils.a(this);
    this.C.setText(this.e.getResources().getString(BluedPreferences.dN()));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\GeneralFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */