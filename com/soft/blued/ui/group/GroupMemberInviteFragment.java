package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.ClickUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.db.model.MsgExtra;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.group.model.ExtraGroupInvitationModel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class GroupMemberInviteFragment extends BaseFragment implements View.OnClickListener {
  public static List<String> d = new ArrayList<String>();
  
  public static List<String> e = new ArrayList<String>();
  
  public static List<String> f = new ArrayList<String>();
  
  public static List<Integer> g = new ArrayList<Integer>();
  
  public static List<Short> h = new ArrayList<Short>();
  
  public static List<String> i = new ArrayList<String>();
  
  public static List<String> j;
  
  public static String k = "isinvite";
  
  private String A;
  
  private String B;
  
  private boolean C;
  
  private ChatHelperV4 D;
  
  private String E;
  
  private ViewPager.OnPageChangeListener F = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {
        if (param1Int1 == 0) {
          if ((GroupMemberInviteFragment.a(this.a)).d != null && (GroupMemberInviteFragment.a(this.a)).d.d != null) {
            (GroupMemberInviteFragment.a(this.a)).d.d.notifyDataSetChanged();
            return;
          } 
        } else if (param1Int1 == 1) {
          if ((GroupMemberInviteFragment.a(this.a)).a != null) {
            (GroupMemberInviteFragment.a(this.a)).a.d.notifyDataSetChanged();
            return;
          } 
        } else if (param1Int1 == 2) {
          if ((GroupMemberInviteFragment.a(this.a)).b != null) {
            (GroupMemberInviteFragment.a(this.a)).b.d.notifyDataSetChanged();
            return;
          } 
        } else if ((GroupMemberInviteFragment.a(this.a)).c != null) {
          (GroupMemberInviteFragment.a(this.a)).c.d.notifyDataSetChanged();
        } 
      }
      
      public void onPageSelected(int param1Int) {
        if (param1Int == 0) {
          if ((GroupMemberInviteFragment.a(this.a)).d != null && (GroupMemberInviteFragment.a(this.a)).d.d != null) {
            (GroupMemberInviteFragment.a(this.a)).d.d.notifyDataSetChanged();
            return;
          } 
        } else if (param1Int == 1) {
          if ((GroupMemberInviteFragment.a(this.a)).a != null) {
            (GroupMemberInviteFragment.a(this.a)).a.d.notifyDataSetChanged();
            return;
          } 
        } else if (param1Int == 2) {
          if ((GroupMemberInviteFragment.a(this.a)).b != null) {
            (GroupMemberInviteFragment.a(this.a)).b.d.notifyDataSetChanged();
            return;
          } 
        } else if ((GroupMemberInviteFragment.a(this.a)).c != null) {
          (GroupMemberInviteFragment.a(this.a)).c.d.notifyDataSetChanged();
        } 
      }
    };
  
  public BluedUIHttpResponse l = new BluedUIHttpResponse<BluedEntityA<String>>(this) {
      protected BluedEntityA<String> a(String param1String) {
        Logger.a(GroupMemberInviteFragment.d(this.a), new Object[] { "onSuccess, content:", param1String });
        return (BluedEntityA<String>)super.parseData(param1String);
      }
      
      public void a(BluedEntityA<String> param1BluedEntityA) {
        if (param1BluedEntityA != null)
          try {
            if (param1BluedEntityA.hasData()) {
              GroupMemberInviteFragment.j.clear();
              ArrayList<? extends String> arrayList = new ArrayList(param1BluedEntityA.data);
              GroupMemberInviteFragment.j.addAll(arrayList);
              GroupMemberInviteFragment.e(this.a);
              return;
            } 
          } catch (Exception exception) {
            AppMethods.a(this.a.getResources().getString(2131756082));
            exception.printStackTrace();
          }  
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
        Logger.a(GroupMemberInviteFragment.d(this.a), new Object[] { "onFailure, error:", param1Throwable });
      }
      
      public void onUIFinish() {
        Logger.a(GroupMemberInviteFragment.d(this.a), new Object[] { "onUIFinish" });
        DialogUtils.b(GroupMemberInviteFragment.c(this.a));
      }
      
      public void onUIStart() {
        DialogUtils.a(GroupMemberInviteFragment.c(this.a));
      }
    };
  
  public BluedUIHttpResponse m = new BluedUIHttpResponse<BluedEntity<Object, ExtraGroupInvitationModel>>(this) {
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
        AppMethods.a(this.a.getResources().getString(2131756082));
      }
      
      public void onUIFinish() {
        Logger.a(GroupMemberInviteFragment.d(this.a), new Object[] { "onUIFinish" });
        DialogUtils.b(GroupMemberInviteFragment.c(this.a));
        this.a.getActivity().finish();
      }
      
      public void onUIStart() {
        DialogUtils.a(GroupMemberInviteFragment.c(this.a));
      }
      
      public void onUIUpdate(BluedEntity<Object, ExtraGroupInvitationModel> param1BluedEntity) {
        if (param1BluedEntity != null)
          try {
            if (param1BluedEntity.extra != null && ((ExtraGroupInvitationModel)param1BluedEntity.extra).iid != null && ((ExtraGroupInvitationModel)param1BluedEntity.extra).iid.size() > 0) {
              int j = ((ExtraGroupInvitationModel)param1BluedEntity.extra).iid.size();
              Gson gson = AppInfo.f();
              for (int i = 0;; i++) {
                if (i < j) {
                  MsgExtra msgExtra = (MsgExtra)gson.fromJson(GroupMemberInviteFragment.f(this.a), (new TypeToken<MsgExtra>(this) {
                      
                      }).getType());
                  String str = ((ExtraGroupInvitationModel.GroupInvitaion)((ExtraGroupInvitationModel)param1BluedEntity.extra).iid.get(i)).iid;
                  if (!TextUtils.isEmpty(str)) {
                    msgExtra.setGroups_iid(str);
                    String str1 = gson.toJson(msgExtra);
                    GroupMemberInviteFragment.a(this.a, Long.parseLong(GroupMemberInviteFragment.g(this.a).get(i)), ((Short)GroupMemberInviteFragment.h(this.a).get(i)).shortValue(), GroupMemberInviteFragment.i(this.a).get(i), GroupMemberInviteFragment.j(this.a).get(i), ((Integer)GroupMemberInviteFragment.k(this.a).get(i)).intValue(), str1, StringUtils.a(GroupMemberInviteFragment.l(this.a), -1));
                  } else {
                    AppMethods.a(this.a.getResources().getString(2131756082));
                  } 
                } else {
                  GroupMemberInviteFragment.j(this.a).clear();
                  GroupMemberInviteFragment.h(this.a).clear();
                  GroupMemberInviteFragment.g(this.a).clear();
                  GroupMemberInviteFragment.i(this.a).clear();
                  GroupMemberInviteFragment.k(this.a).clear();
                  AppMethods.d(2131755675);
                  return;
                } 
              } 
            } 
            AppMethods.a(this.a.getResources().getString(2131756082));
            return;
          } catch (Exception exception) {
            AppMethods.a(this.a.getResources().getString(2131756082));
            exception.printStackTrace();
            return;
          }  
        AppMethods.a(this.a.getResources().getString(2131756082));
      }
    };
  
  private String n = GroupMemberInviteFragment.class.getSimpleName();
  
  private View o;
  
  private Context p;
  
  private TabPageIndicatorWithDot q;
  
  private ViewPager r;
  
  private MyPagerAdapter s;
  
  private Dialog t;
  
  private List<String> u = new ArrayList<String>();
  
  private List<String> v = new ArrayList<String>();
  
  private List<String> w = new ArrayList<String>();
  
  private List<Integer> x = new ArrayList<Integer>();
  
  private List<Short> y = new ArrayList<Short>();
  
  private String z;
  
  private void a() {
    if (!StringUtils.e(this.z))
      GroupHttpUtils.c(this.p, this.l, this.z, "", "", "desc", this.E, (IRequestHost)w_()); 
  }
  
  private void a(long paramLong, short paramShort, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2) {
    if (!StringUtils.e(paramString3)) {
      byte b;
      if (paramInt2 == -1)
        return; 
      String str = getResources().getString(2131755457);
      if (paramInt2 == 0) {
        b = 10;
      } else {
        b = 9;
      } 
      ChattingModel chattingModel = ChatHelper.getChattingModelForSendmsg(paramLong, b, str, this.D.b(), paramString3, paramShort);
      if (chattingModel == null)
        return; 
      this.D.c(chattingModel, paramString1, paramString2, paramInt1, 0, 0, 0, 0, false);
    } 
  }
  
  public static void a(Context paramContext, BluedCreatedGroupInfo paramBluedCreatedGroupInfo) {
    if (paramBluedCreatedGroupInfo != null) {
      String str1;
      String str2 = paramBluedCreatedGroupInfo.groups_gid;
      String str3 = paramBluedCreatedGroupInfo.groups_is_created;
      String str4 = paramBluedCreatedGroupInfo.groups_is_admins;
      Bundle bundle = new Bundle();
      bundle.putString("gid", str2);
      str2 = "1";
      if (str3.equals("1") || str4.equals("1")) {
        bundle.putBoolean(k, true);
      } else {
        bundle.putBoolean(k, false);
      } 
      MsgExtra msgExtra = new MsgExtra();
      msgExtra.setGroups_avatar(paramBluedCreatedGroupInfo.groups_avatar);
      msgExtra.setGroups_city(paramBluedCreatedGroupInfo.groups_city);
      msgExtra.setGroups_members_count(paramBluedCreatedGroupInfo.groups_members_count);
      msgExtra.setGroups_name(paramBluedCreatedGroupInfo.groups_name);
      msgExtra.setGroups_gid(paramBluedCreatedGroupInfo.groups_gid);
      msgExtra.setGroups_description(paramBluedCreatedGroupInfo.groups_description);
      if (!StringUtils.e(str3) && !StringUtils.e(str4)) {
        str1 = str2;
        if (!str3.equals("1"))
          if (str4.equals("1")) {
            str1 = str2;
          } else {
            str1 = "0";
          }  
      } else {
        str1 = "";
      } 
      bundle.putString("group_extra_json", AppInfo.f().toJson(msgExtra));
      bundle.putString("flag", str1);
      TerminalActivity.d(paramContext, GroupMemberInviteFragment.class, bundle);
    } 
  }
  
  public static void a(Context paramContext, String paramString) {
    a(paramContext, (BluedCreatedGroupInfo)AppInfo.f().fromJson(paramString, BluedCreatedGroupInfo.class));
  }
  
  private void k() {
    Bundle bundle = getArguments();
    if (bundle == null)
      return; 
    this.z = bundle.getString("gid");
    this.C = bundle.getBoolean(k);
    this.A = bundle.getString("group_extra_json");
    this.B = bundle.getString("flag");
    this.E = "uid";
    d.clear();
    e.clear();
    f.clear();
    g.clear();
    h.clear();
    i.clear();
  }
  
  private void l() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.o.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131756706));
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setRightClickListener(this);
    commonTopTitleNoTrans.setRightText(this.p.getString(2131756206));
    ((TextView)commonTopTitleNoTrans.findViewById(2131296857)).setOnTouchListener((View.OnTouchListener)new ClickUtils());
  }
  
  private void m() {
    this.t = DialogUtils.a(this.p);
    j = new ArrayList<String>();
  }
  
  private void n() {
    this.q = (TabPageIndicatorWithDot)this.o.findViewById(2131297592);
    this.q.setOnPageChangeListener(this.F);
    this.r = (ViewPager)this.o.findViewById(2131299439);
    this.s = new MyPagerAdapter(this, getChildFragmentManager());
    this.r.setOffscreenPageLimit(4);
    this.r.setAdapter((PagerAdapter)this.s);
    this.q.setViewPager(this.r);
    this.o.findViewById(2131296944).setVisibility(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (this.s.d != null)
      this.s.d.onActivityResult(paramInt1, paramInt2, paramIntent); 
    if (this.s.a != null)
      this.s.a.onActivityResult(paramInt1, paramInt2, paramIntent); 
    if (this.s.b != null)
      this.s.b.onActivityResult(paramInt1, paramInt2, paramIntent); 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      if (d.size() == 0) {
        AppMethods.a(getResources().getString(2131758257));
        return;
      } 
      boolean bool1 = this.C;
      i = 0;
      boolean bool = false;
      if (bool1) {
        for (i = bool; i < d.size(); i++) {
          if (3 == ((Short)h.get(i)).shortValue()) {
            a(Long.parseLong(d.get(i)), ((Short)h.get(i)).shortValue(), e.get(i), f.get(i), ((Integer)g.get(i)).intValue(), this.A, 0);
          } else {
            this.w.add(f.get(i));
            this.y.add(h.get(i));
            this.u.add(d.get(i));
            this.v.add(e.get(i));
            this.x.add(g.get(i));
          } 
        } 
        if (this.u.size() > 0) {
          String[] arrayOfString = new String[this.u.size()];
          arrayOfString = this.u.<String>toArray(arrayOfString);
          GroupHttpUtils.a(this.m, this.z, arrayOfString, true);
          return;
        } 
        getActivity().finish();
        return;
      } 
      while (i < d.size()) {
        a(Long.valueOf(d.get(i)).longValue(), ((Short)h.get(i)).shortValue(), e.get(i), f.get(i), ((Integer)g.get(i)).intValue(), this.A, StringUtils.a(this.B, -1));
        i++;
      } 
      AppMethods.d(2131755675);
      getActivity().finish();
      return;
    } 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.p = (Context)getActivity();
    View view = this.o;
    if (view == null) {
      this.o = paramLayoutInflater.inflate(2131493140, paramViewGroup, false);
      l();
      m();
      k();
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.o.getParent()).removeView(this.o);
    } 
    this.D = ChatHelperV4.a();
    return this.o;
  }
  
  public class MyPagerAdapter extends FragmentPagerAdapter {
    public GroupUserInviteFragment a;
    
    public GroupUserInviteFragment b;
    
    public GroupUserInviteFragment c;
    
    public GroupInviteFromChatListFragment d;
    
    private final String[] f = new String[] { this.e.getResources().getString(2131756643), this.e.getResources().getString(2131756727), this.e.getResources().getString(2131756728), this.e.getResources().getString(2131756726) };
    
    public MyPagerAdapter(GroupMemberInviteFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public int getCount() {
      return this.f.length;
    }
    
    public Fragment getItem(int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int != 2) {
            if (param1Int != 3)
              return null; 
            if (this.c == null)
              this.c = GroupUserInviteFragment.a(2); 
            return (Fragment)this.c;
          } 
          if (this.b == null)
            this.b = GroupUserInviteFragment.a(1); 
          return (Fragment)this.b;
        } 
        if (this.a == null)
          this.a = GroupUserInviteFragment.a(0); 
        return (Fragment)this.a;
      } 
      if (this.d == null) {
        this.d = new GroupInviteFromChatListFragment();
        this.d.a(GroupMemberInviteFragment.b(this.e));
      } 
      return (Fragment)this.d;
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.f[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\GroupMemberInviteFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */