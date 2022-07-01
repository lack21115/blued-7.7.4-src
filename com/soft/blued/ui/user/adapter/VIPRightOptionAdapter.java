package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.vip.VipProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.find.fragment.DependentVIPSelectedFragment;
import com.soft.blued.ui.find.fragment.FilterDialogFragment;
import com.soft.blued.ui.find.fragment.VisitHistoryFragment;
import com.soft.blued.ui.find.view.TwoWaysBar;
import com.soft.blued.ui.group.UserGroupListsFragment;
import com.soft.blued.ui.msg.ChatBgSettingFragment;
import com.soft.blued.ui.setting.fragment.BlacklistFragment;
import com.soft.blued.ui.setting.fragment.ChangeBluedIconFragment;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.user.fragment.FollowedAndFansFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.fragment.VIPCustomizedFragment;
import com.soft.blued.ui.user.fragment.VipInvisibleDialogFragment;
import com.soft.blued.ui.user.fragment.WidgetListFragment;
import com.soft.blued.ui.user.model.VIPRightOption;
import com.soft.blued.ui.user.observer.FollowAndFansSelectedTabObserver;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VIPRightOptionAdapter extends BaseQuickAdapter<VIPRightOption, BaseViewHolder> {
  private static final String e = VIPRightOptionAdapter.class.getSimpleName();
  
  public Context a;
  
  public LayoutInflater b;
  
  public IRequestHost c;
  
  public boolean d = false;
  
  private VipInvisibleDialogFragment f;
  
  private FragmentManager g;
  
  private int h;
  
  public VIPRightOptionAdapter(Context paramContext, int paramInt, FragmentManager paramFragmentManager, IRequestHost paramIRequestHost) {
    super(2131493689, new ArrayList());
    this.a = paramContext;
    this.g = paramFragmentManager;
    this.h = paramInt;
    this.c = paramIRequestHost;
    this.b = LayoutInflater.from(this.a);
    this.f = new VipInvisibleDialogFragment();
  }
  
  private void b(int paramInt) {
    if (!a(paramInt))
      return; 
    EventTrackVIP.a((UserInfo.a().i()).vip_grade, this.h, false, paramInt);
    if (paramInt != 4) {
      if (paramInt != 5) {
        if (paramInt != 12) {
          if (paramInt != 14) {
            if (paramInt != 26) {
              if (paramInt != 28) {
                if (paramInt != 31) {
                  if (paramInt != 32) {
                    switch (paramInt) {
                      default:
                        switch (paramInt) {
                          default:
                            return;
                          case 24:
                            (new FilterDialogFragment()).show(((FragmentActivity)this.a).getSupportFragmentManager(), "");
                            return;
                          case 23:
                            ChatBgSettingFragment.a(this.a, 2);
                            return;
                          case 22:
                            FollowedAndFansFragment.a(this.a, (UserInfo.a().i()).uid);
                            AppInfo.n().postDelayed(-$$Lambda$VIPRightOptionAdapter$KH9Prox30y-K4UsapURuJt7rAHY.INSTANCE, 500L);
                            return;
                          case 21:
                            break;
                        } 
                        BluedURIRouterAdapter.openMapFind(this.a);
                        return;
                      case 10:
                        ModifyUserInfoFragment.a(this.a, false);
                        return;
                      case 9:
                        UserInfoFragmentNew.a(this.a, (UserInfo.a().i()).uid, "");
                        return;
                      case 8:
                        UserGroupListsFragment.a(this.a);
                        return;
                      case 7:
                        break;
                    } 
                    TerminalActivity.d(this.a, BlacklistFragment.class, null);
                    return;
                  } 
                  EventTrackVIP.a(VipProtos.Event.VIP_CENTER_PHOTO_PENDANT_CLICK, this.h);
                  WidgetListFragment.a(this.a, this.h, "photo_pendant_vip_center", VipProtos.FromType.PHOTO_PENDANT_OTHER);
                  return;
                } 
                VIPCustomizedFragment.a(this.a, this.h);
                return;
              } 
              BluedURIRouterAdapter.goChatAndOpenMsgBox(this.g, this.h);
              return;
            } 
            DependentVIPSelectedFragment.a(this.a);
            return;
          } 
          ChangeBluedIconFragment.a(this.a, this.h);
          return;
        } 
        TerminalActivity.d(this.a, VisitHistoryFragment.class, null);
        return;
      } 
      ModifyUserInfoFragment.a(this.a, false);
      return;
    } 
    if (!this.f.isAdded()) {
      this.f.show(this.g, VIPRightOptionAdapter.class.getName());
      return;
    } 
    this.f.dismiss();
  }
  
  public void a(int paramInt1, int paramInt2) {
    Map<String, String> map = BluedHttpTools.a();
    if (paramInt1 == 5) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt2);
      stringBuilder.append("");
      map.put("is_show_vip_page", stringBuilder.toString());
      UserHttpUtils.a(this.a, new BluedUIHttpResponse(this, null, paramInt2) {
            public void onUIUpdate(BluedEntity param1BluedEntity) {
              (UserInfo.a().i()).is_show_vip_page = this.a;
            }
          }(UserInfo.a().i()).uid, map, null);
      return;
    } 
    if (paramInt1 != 0) {
      if (paramInt1 != 1) {
        if (paramInt1 != 2) {
          String str = "0";
          if (paramInt1 != 3) {
            if (paramInt1 != 4) {
              if (paramInt1 != 11) {
                if (paramInt1 != 13) {
                  if (paramInt1 != 25) {
                    if (paramInt1 == 27) {
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append(paramInt2);
                      stringBuilder.append("");
                      map.put("is_filter_ads", stringBuilder.toString());
                    } 
                  } else {
                    if (paramInt2 != 1)
                      str = "1"; 
                    map.put("is_hide_vip_look", str);
                  } 
                } else {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(paramInt2);
                  stringBuilder.append("");
                  map.put("is_global_view_secretly", stringBuilder.toString());
                  boolean bool2 = false;
                  if (paramInt2 == 1) {
                    bool1 = true;
                  } else {
                    bool1 = false;
                  } 
                  BluedPreferences.v(bool1);
                  boolean bool1 = bool2;
                  if (paramInt2 != 1)
                    bool1 = true; 
                  BluedPreferences.S(bool1);
                } 
              } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(paramInt2);
                stringBuilder.append("");
                map.put("is_traceless_access", stringBuilder.toString());
              } 
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(paramInt2);
              stringBuilder.append("");
              map.put("is_invisible_all", stringBuilder.toString());
              if (paramInt2 == 1)
                map.put("is_invisible_half", "0"); 
            } 
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(paramInt2);
            stringBuilder.append("");
            map.put("is_invisible_half", stringBuilder.toString());
            if (paramInt2 == 1) {
              map.put("stealth_distance", BluedPreferences.Z());
              map.put("is_invisible_all", "0");
            } 
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramInt2);
          stringBuilder.append("");
          map.put("is_hide_city_settled", stringBuilder.toString());
        } 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramInt2);
        stringBuilder.append("");
        map.put("is_hide_distance", stringBuilder.toString());
      } 
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt2);
      stringBuilder.append("");
      map.put("is_hide_last_operate", stringBuilder.toString());
    } 
    ProfileHttpUtils.a(new BluedUIHttpResponse(this, this.c) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            BluedConfig.b().d();
          }
        }(UserInfo.a().i()).uid, map);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, VIPRightOption paramVIPRightOption) {
    if (paramBaseViewHolder != null && paramVIPRightOption != null) {
      ToggleItemViewHolder toggleItemViewHolder = new ToggleItemViewHolder(this);
      ToggleItemViewHolder.a(toggleItemViewHolder, paramBaseViewHolder.d(2131300299));
      ToggleItemViewHolder.b(toggleItemViewHolder, paramBaseViewHolder.d(2131301687));
      ToggleItemViewHolder.a(toggleItemViewHolder, (TextView)paramBaseViewHolder.d(2131301382));
      ToggleItemViewHolder.a(toggleItemViewHolder, (ImageView)paramBaseViewHolder.d(2131300237));
      ToggleItemViewHolder.b(toggleItemViewHolder, (TextView)paramBaseViewHolder.d(2131301381));
      ToggleItemViewHolder.c(toggleItemViewHolder, paramBaseViewHolder.d(2131301671));
      ToggleItemViewHolder.c(toggleItemViewHolder, (TextView)paramBaseViewHolder.d(2131301161));
      ToggleItemViewHolder.d(toggleItemViewHolder, (TextView)paramBaseViewHolder.d(2131301160));
      ToggleItemViewHolder.a(toggleItemViewHolder, (TwoWaysBar)paramBaseViewHolder.d(2131299563));
      ToggleItemViewHolder.e(toggleItemViewHolder, (TextView)paramBaseViewHolder.d(2131301215));
      ToggleItemViewHolder.f(toggleItemViewHolder, (TextView)paramBaseViewHolder.d(2131301214));
      ToggleItemViewHolder.b(toggleItemViewHolder, (ImageView)paramBaseViewHolder.d(2131297501));
      ToggleItemViewHolder.c(toggleItemViewHolder, (ImageView)paramBaseViewHolder.d(2131297537));
      ToggleItemViewHolder.d(toggleItemViewHolder, paramBaseViewHolder.d(2131301645));
      ToggleItemViewHolder.e(toggleItemViewHolder, paramBaseViewHolder.d(2131297479));
      ToggleItemViewHolder.f(toggleItemViewHolder, paramBaseViewHolder.d(2131297531));
      ToggleItemViewHolder.g(toggleItemViewHolder, paramBaseViewHolder.d(2131297538));
      ToggleItemViewHolder.h(toggleItemViewHolder, paramBaseViewHolder.d(2131297563));
      ToggleItemViewHolder.i(toggleItemViewHolder, paramBaseViewHolder.d(2131297564));
      ToggleItemViewHolder.j(toggleItemViewHolder, paramBaseViewHolder.d(2131298900));
      int i = paramBaseViewHolder.getAdapterPosition();
      if (i == 0) {
        ToggleItemViewHolder.a(toggleItemViewHolder).setVisibility(8);
      } else {
        ToggleItemViewHolder.a(toggleItemViewHolder).setVisibility(0);
      } 
      if (i == this.n.size()) {
        ToggleItemViewHolder.b(toggleItemViewHolder).setBackground(BluedSkinUtils.b(this.a, 2131234026));
      } else {
        ToggleItemViewHolder.b(toggleItemViewHolder).setBackgroundColor(BluedSkinUtils.a(this.a, 2131100728));
      } 
      ToggleItemViewHolder.c(toggleItemViewHolder).setVisibility(8);
      ToggleItemViewHolder.d(toggleItemViewHolder).setVisibility(8);
      ToggleItemViewHolder.e(toggleItemViewHolder).setVisibility(8);
      if (paramVIPRightOption.is_svip == 1) {
        ToggleItemViewHolder.f(toggleItemViewHolder).setVisibility(0);
        ToggleItemViewHolder.g(toggleItemViewHolder).setVisibility(0);
      } else {
        ToggleItemViewHolder.f(toggleItemViewHolder).setVisibility(8);
        ToggleItemViewHolder.g(toggleItemViewHolder).setVisibility(8);
      } 
      ImageLoader.a(this.c, paramVIPRightOption.icon).a(ToggleItemViewHolder.h(toggleItemViewHolder));
      ImageLoader.a(this.c, paramVIPRightOption.icon).a(ToggleItemViewHolder.i(toggleItemViewHolder));
      if (paramVIPRightOption.getRightType() == 0) {
        if (paramVIPRightOption.is_new == 1) {
          ToggleItemViewHolder.j(toggleItemViewHolder).setVisibility(0);
        } else {
          ToggleItemViewHolder.j(toggleItemViewHolder).setVisibility(8);
        } 
        if (paramVIPRightOption.pid != 3) {
          ToggleItemViewHolder.e(toggleItemViewHolder).setVisibility(8);
          ToggleItemViewHolder.k(toggleItemViewHolder).setVisibility(8);
        } else if (paramVIPRightOption.is_on == 1) {
          this.d = true;
          ToggleItemViewHolder.e(toggleItemViewHolder).setVisibility(0);
          ToggleItemViewHolder.k(toggleItemViewHolder).setVisibility(0);
          String str = BluedPreferences.Z();
          ToggleItemViewHolder.l(toggleItemViewHolder).setText(this.a.getResources().getString(2131756818));
          ToggleItemViewHolder.m(toggleItemViewHolder).a(str, 100);
          ToggleItemViewHolder.n(toggleItemViewHolder).setText(TwoWaysBar.a(this.a, str, 1));
          TextView textView = ToggleItemViewHolder.n(toggleItemViewHolder);
          ToggleItemViewHolder.m(toggleItemViewHolder).setTwoWaysBarListner((TwoWaysBar.TwoWaysBarListner)new TwoWaysBar.TowWaysBarListenerAdapter(this, textView) {
                public void a(int param1Int1, int param1Int2) {
                  Integer integer;
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(param1Int1);
                  stringBuilder.append("-");
                  if (param1Int2 >= 100) {
                    String str = "max";
                  } else {
                    integer = Integer.valueOf(param1Int2);
                  } 
                  stringBuilder.append(integer);
                  BluedPreferences.u(stringBuilder.toString());
                  this.a.setText(TwoWaysBar.a(this.b.a, param1Int1, param1Int2, 1));
                }
                
                public void a(boolean param1Boolean) {}
                
                public void b(boolean param1Boolean) {
                  if (param1Boolean) {
                    String str = BluedPreferences.Z();
                    EventTrackVIP.a(VipProtos.Event.STEALTH_BTN_CLICK, VipProtos.StealthType.HALF, str.contains("max") ^ true);
                  } 
                }
              });
        } else {
          this.d = false;
          ToggleItemViewHolder.e(toggleItemViewHolder).setVisibility(8);
          ToggleItemViewHolder.k(toggleItemViewHolder).setVisibility(8);
        } 
        ToggleItemViewHolder.c(toggleItemViewHolder).setVisibility(0);
        ToggleItemViewHolder.o(toggleItemViewHolder).setText(paramVIPRightOption.title);
        if (StringUtils.e(paramVIPRightOption.description)) {
          ToggleItemViewHolder.p(toggleItemViewHolder).setVisibility(8);
        } else {
          ToggleItemViewHolder.p(toggleItemViewHolder).setVisibility(0);
          ToggleItemViewHolder.p(toggleItemViewHolder).setText(paramVIPRightOption.description);
        } 
        if (paramVIPRightOption.is_on == 1) {
          ToggleItemViewHolder.q(toggleItemViewHolder).setImageResource(2131234234);
        } else {
          ToggleItemViewHolder.q(toggleItemViewHolder).setImageResource(2131234233);
        } 
        ToggleItemViewHolder.q(toggleItemViewHolder).setOnClickListener(new -$$Lambda$VIPRightOptionAdapter$M5nbtXsQ7GXaoAracLlSX3XKl7w(this, paramVIPRightOption));
        ToggleItemViewHolder.b(toggleItemViewHolder).setOnClickListener(null);
        return;
      } 
      if (paramVIPRightOption.is_new == 1) {
        ToggleItemViewHolder.r(toggleItemViewHolder).setVisibility(0);
      } else {
        ToggleItemViewHolder.r(toggleItemViewHolder).setVisibility(8);
      } 
      ToggleItemViewHolder.d(toggleItemViewHolder).setVisibility(0);
      if (StringUtils.e(paramVIPRightOption.description)) {
        ToggleItemViewHolder.s(toggleItemViewHolder).setVisibility(8);
      } else {
        ToggleItemViewHolder.s(toggleItemViewHolder).setVisibility(0);
        ToggleItemViewHolder.s(toggleItemViewHolder).setText(paramVIPRightOption.description);
      } 
      ToggleItemViewHolder.t(toggleItemViewHolder).setText(paramVIPRightOption.title);
      if (paramVIPRightOption.pid == 4)
        this.f.a = paramVIPRightOption.title; 
      ToggleItemViewHolder.b(toggleItemViewHolder).setOnClickListener(new -$$Lambda$VIPRightOptionAdapter$PHy16gjiUc772VbCK5UvDyTaYAs(this, paramVIPRightOption));
    } 
  }
  
  public void a(VIPRightOption paramVIPRightOption) {
    int i = paramVIPRightOption.is_on;
    boolean bool = false;
    if (i == 1) {
      i = 0;
    } else {
      i = 1;
    } 
    paramVIPRightOption.is_on = i;
    a(paramVIPRightOption.pid, paramVIPRightOption.is_on);
    notifyDataSetChanged();
    i = (UserInfo.a().i()).vip_grade;
    int j = this.h;
    if (paramVIPRightOption.is_on == 1)
      bool = true; 
    EventTrackVIP.a(i, j, bool, paramVIPRightOption.pid);
  }
  
  public void a(List<VIPRightOption> paramList, int paramInt) {
    if (paramList != null && paramList.size() > 0) {
      this.n.clear();
      for (VIPRightOption vIPRightOption : paramList) {
        vIPRightOption.is_on = VIPRightOption.getOnOffStatus(vIPRightOption.pid);
        if (paramInt == 2) {
          this.n.add(vIPRightOption);
          continue;
        } 
        if (vIPRightOption.is_svip == 0)
          this.n.add(vIPRightOption); 
      } 
    } 
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt) {
    // Byte code:
    //   0: iconst_2
    //   1: istore_2
    //   2: iconst_1
    //   3: istore #5
    //   5: iconst_1
    //   6: istore #6
    //   8: iconst_1
    //   9: istore #7
    //   11: iconst_1
    //   12: istore #8
    //   14: iconst_1
    //   15: istore #4
    //   17: ldc ''
    //   19: astore #10
    //   21: iload_1
    //   22: ifeq -> 1028
    //   25: iload_1
    //   26: iconst_1
    //   27: if_icmpeq -> 972
    //   30: iload_1
    //   31: iconst_3
    //   32: if_icmpeq -> 916
    //   35: iload_1
    //   36: iconst_4
    //   37: if_icmpeq -> 904
    //   40: iload_1
    //   41: iconst_5
    //   42: if_icmpeq -> 848
    //   45: iload_1
    //   46: bipush #7
    //   48: if_icmpeq -> 787
    //   51: iload_1
    //   52: bipush #9
    //   54: if_icmpeq -> 731
    //   57: iload_1
    //   58: bipush #31
    //   60: if_icmpeq -> 904
    //   63: iload_1
    //   64: tableswitch default -> 96, 11 -> 683, 12 -> 627, 13 -> 585, 14 -> 529
    //   96: iload_1
    //   97: tableswitch default -> 144, 21 -> 473, 22 -> 431, 23 -> 356, 24 -> 300, 25 -> 236, 26 -> 194, 27 -> 156, 28 -> 904
    //   144: iconst_0
    //   145: istore_2
    //   146: iconst_0
    //   147: istore #4
    //   149: aload #10
    //   151: astore #9
    //   153: goto -> 1084
    //   156: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   159: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   162: getfield is_filter_ads : I
    //   165: iconst_1
    //   166: if_icmpne -> 172
    //   169: goto -> 175
    //   172: iconst_0
    //   173: istore #4
    //   175: aload_0
    //   176: getfield h : I
    //   179: iconst_2
    //   180: if_icmpeq -> 186
    //   183: goto -> 714
    //   186: ldc_w 'vip_center_no_ad_svip'
    //   189: astore #9
    //   191: goto -> 728
    //   194: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   197: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   200: getfield is_vip_select : I
    //   203: iconst_1
    //   204: if_icmpne -> 214
    //   207: iload #5
    //   209: istore #4
    //   211: goto -> 217
    //   214: iconst_0
    //   215: istore #4
    //   217: aload_0
    //   218: getfield h : I
    //   221: iconst_2
    //   222: if_icmpeq -> 228
    //   225: goto -> 714
    //   228: ldc_w 'vip_center_featured_svip'
    //   231: astore #9
    //   233: goto -> 728
    //   236: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   239: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   242: getfield is_hide_vip_look : I
    //   245: iconst_1
    //   246: if_icmpne -> 255
    //   249: iconst_1
    //   250: istore #4
    //   252: goto -> 258
    //   255: iconst_0
    //   256: istore #4
    //   258: aload_0
    //   259: getfield h : I
    //   262: istore_3
    //   263: iload_3
    //   264: iconst_1
    //   265: if_icmpeq -> 290
    //   268: iload_3
    //   269: iconst_2
    //   270: if_icmpeq -> 282
    //   273: iconst_0
    //   274: istore_2
    //   275: aload #10
    //   277: astore #9
    //   279: goto -> 1084
    //   282: ldc_w 'vip_center_logo_svip'
    //   285: astore #9
    //   287: goto -> 1084
    //   290: ldc_w 'vip_center_logo_vip'
    //   293: astore #9
    //   295: iconst_1
    //   296: istore_2
    //   297: goto -> 1084
    //   300: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   303: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   306: getfield is_filter_vip : I
    //   309: iconst_1
    //   310: if_icmpne -> 319
    //   313: iconst_1
    //   314: istore #4
    //   316: goto -> 322
    //   319: iconst_0
    //   320: istore #4
    //   322: aload_0
    //   323: getfield h : I
    //   326: istore_3
    //   327: iload_3
    //   328: iconst_1
    //   329: if_icmpeq -> 348
    //   332: iload_3
    //   333: iconst_2
    //   334: if_icmpeq -> 340
    //   337: goto -> 273
    //   340: ldc_w 'vip_center_super_filter_svip'
    //   343: astore #9
    //   345: goto -> 1084
    //   348: ldc_w 'vip_center_super_filter_vip'
    //   351: astore #9
    //   353: goto -> 295
    //   356: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   359: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   362: getfield is_chat_backgrounds : I
    //   365: iconst_1
    //   366: if_icmpne -> 375
    //   369: iconst_1
    //   370: istore #4
    //   372: goto -> 378
    //   375: iconst_0
    //   376: istore #4
    //   378: aload_0
    //   379: getfield h : I
    //   382: istore_3
    //   383: ldc_w 'chat_customize_bg'
    //   386: astore #11
    //   388: iload #4
    //   390: istore #5
    //   392: aload #11
    //   394: astore #9
    //   396: iload_3
    //   397: iconst_1
    //   398: if_icmpeq -> 424
    //   401: iload #4
    //   403: istore #5
    //   405: aload #11
    //   407: astore #9
    //   409: iload_3
    //   410: iconst_2
    //   411: if_icmpeq -> 417
    //   414: goto -> 273
    //   417: iload #5
    //   419: istore #4
    //   421: goto -> 1084
    //   424: iload #5
    //   426: istore #4
    //   428: goto -> 295
    //   431: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   434: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   437: getfield is_secretly_followed : I
    //   440: iconst_1
    //   441: if_icmpne -> 451
    //   444: iload #6
    //   446: istore #4
    //   448: goto -> 454
    //   451: iconst_0
    //   452: istore #4
    //   454: aload_0
    //   455: getfield h : I
    //   458: iconst_2
    //   459: if_icmpeq -> 465
    //   462: goto -> 714
    //   465: ldc_w 'vip_center_quietly_follow_svip'
    //   468: astore #9
    //   470: goto -> 728
    //   473: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   476: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   479: getfield is_find_on_map : I
    //   482: iconst_1
    //   483: if_icmpne -> 492
    //   486: iconst_1
    //   487: istore #4
    //   489: goto -> 495
    //   492: iconst_0
    //   493: istore #4
    //   495: aload_0
    //   496: getfield h : I
    //   499: istore_3
    //   500: iload_3
    //   501: iconst_1
    //   502: if_icmpeq -> 521
    //   505: iload_3
    //   506: iconst_2
    //   507: if_icmpeq -> 513
    //   510: goto -> 273
    //   513: ldc_w 'vip_center_map_find_svip'
    //   516: astore #9
    //   518: goto -> 1084
    //   521: ldc_w 'vip_center_map_find_vip'
    //   524: astore #9
    //   526: goto -> 295
    //   529: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   532: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   535: getfield is_change_blued_icon : I
    //   538: iconst_1
    //   539: if_icmpne -> 548
    //   542: iconst_1
    //   543: istore #4
    //   545: goto -> 551
    //   548: iconst_0
    //   549: istore #4
    //   551: aload_0
    //   552: getfield h : I
    //   555: istore_3
    //   556: iload_3
    //   557: iconst_1
    //   558: if_icmpeq -> 577
    //   561: iload_3
    //   562: iconst_2
    //   563: if_icmpeq -> 569
    //   566: goto -> 273
    //   569: ldc_w 'vip_center_change_logo_svip'
    //   572: astore #9
    //   574: goto -> 1084
    //   577: ldc_w 'vip_center_change_logo_vip'
    //   580: astore #9
    //   582: goto -> 295
    //   585: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   588: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   591: getfield is_global_view_secretly : I
    //   594: iconst_1
    //   595: if_icmpne -> 605
    //   598: iload #7
    //   600: istore #4
    //   602: goto -> 608
    //   605: iconst_0
    //   606: istore #4
    //   608: aload_0
    //   609: getfield h : I
    //   612: iconst_2
    //   613: if_icmpeq -> 619
    //   616: goto -> 714
    //   619: ldc_w 'vip_center_quiety_see_svip'
    //   622: astore #9
    //   624: goto -> 728
    //   627: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   630: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   633: getfield is_advanced_recently_view : I
    //   636: iconst_1
    //   637: if_icmpne -> 646
    //   640: iconst_1
    //   641: istore #4
    //   643: goto -> 649
    //   646: iconst_0
    //   647: istore #4
    //   649: aload_0
    //   650: getfield h : I
    //   653: istore_3
    //   654: iload_3
    //   655: iconst_1
    //   656: if_icmpeq -> 675
    //   659: iload_3
    //   660: iconst_2
    //   661: if_icmpeq -> 667
    //   664: goto -> 273
    //   667: ldc_w 'vip_center_super_visit_svip'
    //   670: astore #9
    //   672: goto -> 1084
    //   675: ldc_w 'vip_center_super_visit_vip'
    //   678: astore #9
    //   680: goto -> 295
    //   683: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   686: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   689: getfield is_traceless_access : I
    //   692: iconst_1
    //   693: if_icmpne -> 703
    //   696: iload #8
    //   698: istore #4
    //   700: goto -> 706
    //   703: iconst_0
    //   704: istore #4
    //   706: aload_0
    //   707: getfield h : I
    //   710: iconst_2
    //   711: if_icmpeq -> 723
    //   714: iconst_0
    //   715: istore_2
    //   716: aload #10
    //   718: astore #9
    //   720: goto -> 728
    //   723: ldc_w 'vip_center_no_trace_visit_svip'
    //   726: astore #9
    //   728: goto -> 1084
    //   731: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   734: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   737: getfield is_top_feed_views : I
    //   740: iconst_1
    //   741: if_icmpne -> 750
    //   744: iconst_1
    //   745: istore #4
    //   747: goto -> 753
    //   750: iconst_0
    //   751: istore #4
    //   753: aload_0
    //   754: getfield h : I
    //   757: istore_3
    //   758: iload_3
    //   759: iconst_1
    //   760: if_icmpeq -> 779
    //   763: iload_3
    //   764: iconst_2
    //   765: if_icmpeq -> 771
    //   768: goto -> 273
    //   771: ldc_w 'vip_center_feed_top_svip'
    //   774: astore #9
    //   776: goto -> 1084
    //   779: ldc_w 'vip_center_feed_top_vip'
    //   782: astore #9
    //   784: goto -> 295
    //   787: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   790: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   793: getfield is_improve_backlist : I
    //   796: iconst_1
    //   797: if_icmpne -> 806
    //   800: iconst_1
    //   801: istore #4
    //   803: goto -> 809
    //   806: iconst_0
    //   807: istore #4
    //   809: aload_0
    //   810: getfield h : I
    //   813: istore_3
    //   814: ldc_w 'blacklist_expand'
    //   817: astore #11
    //   819: iload #4
    //   821: istore #5
    //   823: aload #11
    //   825: astore #9
    //   827: iload_3
    //   828: iconst_1
    //   829: if_icmpeq -> 424
    //   832: iload #4
    //   834: istore #5
    //   836: aload #11
    //   838: astore #9
    //   840: iload_3
    //   841: iconst_2
    //   842: if_icmpeq -> 417
    //   845: goto -> 273
    //   848: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   851: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   854: getfield is_show_vip_page : I
    //   857: iconst_1
    //   858: if_icmpne -> 867
    //   861: iconst_1
    //   862: istore #4
    //   864: goto -> 870
    //   867: iconst_0
    //   868: istore #4
    //   870: aload_0
    //   871: getfield h : I
    //   874: istore_3
    //   875: iload_3
    //   876: iconst_1
    //   877: if_icmpeq -> 896
    //   880: iload_3
    //   881: iconst_2
    //   882: if_icmpeq -> 888
    //   885: goto -> 273
    //   888: ldc_w 'vip_center_personal_hom_svip'
    //   891: astore #9
    //   893: goto -> 1084
    //   896: ldc_w 'vip_center_personal_hom_vip'
    //   899: astore #9
    //   901: goto -> 295
    //   904: iconst_0
    //   905: istore_2
    //   906: iconst_1
    //   907: istore #4
    //   909: aload #10
    //   911: astore #9
    //   913: goto -> 1084
    //   916: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   919: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   922: getfield is_invisible_half : I
    //   925: iconst_1
    //   926: if_icmpne -> 935
    //   929: iconst_1
    //   930: istore #4
    //   932: goto -> 938
    //   935: iconst_0
    //   936: istore #4
    //   938: aload_0
    //   939: getfield h : I
    //   942: istore_3
    //   943: iload_3
    //   944: iconst_1
    //   945: if_icmpeq -> 964
    //   948: iload_3
    //   949: iconst_2
    //   950: if_icmpeq -> 956
    //   953: goto -> 273
    //   956: ldc_w 'vip_center_half_hide_svip'
    //   959: astore #9
    //   961: goto -> 1084
    //   964: ldc_w 'vip_center_half_hide_vip'
    //   967: astore #9
    //   969: goto -> 295
    //   972: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   975: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   978: getfield is_hide_distance : I
    //   981: iconst_1
    //   982: if_icmpne -> 991
    //   985: iconst_1
    //   986: istore #4
    //   988: goto -> 994
    //   991: iconst_0
    //   992: istore #4
    //   994: aload_0
    //   995: getfield h : I
    //   998: istore_3
    //   999: iload_3
    //   1000: iconst_1
    //   1001: if_icmpeq -> 1020
    //   1004: iload_3
    //   1005: iconst_2
    //   1006: if_icmpeq -> 1012
    //   1009: goto -> 273
    //   1012: ldc_w 'vip_center_hide_distance_svip'
    //   1015: astore #9
    //   1017: goto -> 1084
    //   1020: ldc_w 'vip_center_hide_distance_vip'
    //   1023: astore #9
    //   1025: goto -> 295
    //   1028: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   1031: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   1034: getfield is_hide_last_operate : I
    //   1037: iconst_1
    //   1038: if_icmpne -> 1047
    //   1041: iconst_1
    //   1042: istore #4
    //   1044: goto -> 1050
    //   1047: iconst_0
    //   1048: istore #4
    //   1050: aload_0
    //   1051: getfield h : I
    //   1054: istore_3
    //   1055: iload_3
    //   1056: iconst_1
    //   1057: if_icmpeq -> 1076
    //   1060: iload_3
    //   1061: iconst_2
    //   1062: if_icmpeq -> 1068
    //   1065: goto -> 273
    //   1068: ldc_w 'vip_center_hide_time_svip'
    //   1071: astore #9
    //   1073: goto -> 1084
    //   1076: ldc_w 'vip_center_hide_time_vip'
    //   1079: astore #9
    //   1081: goto -> 295
    //   1084: iload #4
    //   1086: ifne -> 1121
    //   1089: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
    //   1092: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   1095: getfield vip_grade : I
    //   1098: aload_0
    //   1099: getfield h : I
    //   1102: iconst_0
    //   1103: iload_1
    //   1104: invokestatic a : (IIZI)V
    //   1107: aload_0
    //   1108: getfield a : Landroid/content/Context;
    //   1111: iload_2
    //   1112: aload #9
    //   1114: iload_1
    //   1115: getstatic com/blued/das/vip/VipProtos$FromType.UNKNOWN_FROM : Lcom/blued/das/vip/VipProtos$FromType;
    //   1118: invokestatic a : (Landroid/content/Context;ILjava/lang/String;ILcom/blued/das/vip/VipProtos$FromType;)V
    //   1121: iload #4
    //   1123: ireturn
  }
  
  public class ToggleItemViewHolder {
    private View b;
    
    private View c;
    
    private View d;
    
    private TextView e;
    
    private ImageView f;
    
    private TextView g;
    
    private View h;
    
    private TextView i;
    
    private TextView j;
    
    private TextView k;
    
    private TextView l;
    
    private TwoWaysBar m;
    
    private ImageView n;
    
    private ImageView o;
    
    private View p;
    
    private View q;
    
    private View r;
    
    private View s;
    
    private View t;
    
    private View u;
    
    public ToggleItemViewHolder(VIPRightOptionAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\VIPRightOptionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */