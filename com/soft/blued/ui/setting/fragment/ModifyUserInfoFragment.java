package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.das.profile.PersonalProfileProtos;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.DragGridBaseAdapter;
import com.soft.blued.customview.PhotoGridView;
import com.soft.blued.db.UserAccountsVDao;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.find.observer.PersonalVerifyObserver;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.login_register.model.BluedLoginResult;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.setting.View.ModifyUserInfoPopView;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.model.MultiHeadMigration;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.ui.user.model.UserTagAll;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.third.QiniuUploadUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.simonvt.datepicker.DatePicker;
import net.simonvt.datepicker.DatePickerDialog;
import net.simonvt.numberpicker.NumberPicker;

public class ModifyUserInfoFragment extends BaseFragment implements View.OnClickListener {
  private static String[] ap;
  
  private TextView A;
  
  private TextView B;
  
  private TextView C;
  
  private TextView D;
  
  private TextView E;
  
  private LinearLayout F;
  
  private LinearLayout G;
  
  private LinearLayout H;
  
  private LinearLayout I;
  
  private LinearLayout J;
  
  private LinearLayout K;
  
  private LinearLayout L;
  
  private LinearLayout M;
  
  private LinearLayout N;
  
  private LinearLayout O;
  
  private LinearLayout P;
  
  private LinearLayout Q;
  
  private LinearLayout R;
  
  private LinearLayout S;
  
  private LinearLayout T;
  
  private LinearLayout U;
  
  private LinearLayout V;
  
  private LinearLayout W;
  
  private LinearLayout X;
  
  private LinearLayout Y;
  
  private LinearLayout Z;
  
  private ArrayList<String> aA;
  
  private ArrayList<String> aB = new ArrayList<String>();
  
  private ArrayList<String> aC;
  
  private ArrayList<String> aD = new ArrayList<String>();
  
  private ArrayList<String> aE;
  
  private ArrayList<String> aF = new ArrayList<String>();
  
  private ArrayList<String> aG;
  
  private String aH;
  
  private String aI;
  
  private String aJ;
  
  private String aK;
  
  private String aL;
  
  private String aM;
  
  private List<ViewGroup> aN = new ArrayList<ViewGroup>();
  
  private CommonTopTitleNoTrans aO;
  
  private TextView aP;
  
  private ScrollView aQ;
  
  private View aR;
  
  private ImageView aS;
  
  private TextView aT;
  
  private TextView aU;
  
  private TextView aV;
  
  private String aW;
  
  private int aX;
  
  private boolean aY = false;
  
  private boolean aZ = false;
  
  private LinearLayout aa;
  
  private ImageView ab;
  
  private ImageView ac;
  
  private String ad = "0";
  
  private int ae = 0;
  
  private int af = 170;
  
  private int ag = 60;
  
  private int ah = 120;
  
  private int ai = 220;
  
  private int aj = 30;
  
  private int ak = 200;
  
  private PhotoGridView al;
  
  private List<BluedAlbum> am = new LinkedList<BluedAlbum>();
  
  private UserDragGirdAdapter an;
  
  private LoadOptions ao;
  
  private int aq;
  
  private int ar;
  
  private String as = "";
  
  private String at = "";
  
  private boolean au = false;
  
  private ArrayList<String> av = new ArrayList<String>();
  
  private ArrayList<String> aw;
  
  private BluedAlbum ax;
  
  private boolean ay;
  
  private ArrayList<String> az = new ArrayList<String>();
  
  ModifyUserInfoPopView d;
  
  public BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(this) {
      public void a(BluedEntityA<UserInfoEntity> param1BluedEntityA) {
        if (param1BluedEntityA != null) {
          DialogUtils.b(ModifyUserInfoFragment.u(this.a));
          List<UserInfoEntity> list = param1BluedEntityA.data;
          int i = 0;
          UserInfoEntity userInfoEntity = list.get(0);
          Logger.a("modify", userInfoEntity);
          if (userInfoEntity != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("userInfo.avatar_audited:");
            stringBuilder.append(userInfoEntity.avatar_audited);
            Log.v("drb", stringBuilder.toString());
            if (userInfoEntity.avatar_audited == 0) {
              ModifyUserInfoFragment.j(this.a).setVisibility(0);
            } else {
              ModifyUserInfoFragment.j(this.a).setVisibility(8);
            } 
            if (userInfoEntity.vip_avatars != null) {
              ArrayList<BluedAlbum> arrayList = new ArrayList();
              while (i < userInfoEntity.vip_avatars.size()) {
                BluedAlbum bluedAlbum = new BluedAlbum();
                bluedAlbum.setPid(String.valueOf(((BluedAlbum)userInfoEntity.vip_avatars.get(i)).getPid()));
                bluedAlbum.setUrl(((BluedAlbum)userInfoEntity.vip_avatars.get(i)).getUrl());
                arrayList.add(bluedAlbum);
                i++;
              } 
              UserInfo.a().i().setVip_avatars(arrayList);
              this.a.a();
              return;
            } 
          } else {
            AppMethods.d(2131756584);
            return;
          } 
        } else {
          AppMethods.d(2131756584);
        } 
      }
    };
  
  private Context f;
  
  private View g;
  
  private Dialog h;
  
  private String i = ModifyUserInfoFragment.class.getSimpleName();
  
  private ToggleButton j;
  
  private TextView k;
  
  private TextView l;
  
  private TextView m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private TextView q;
  
  private TextView r;
  
  private TextView s;
  
  private TextView t;
  
  private TextView u;
  
  private TextView v;
  
  private TextView w;
  
  private TextView x;
  
  private TextView y;
  
  private TextView z;
  
  private String a(ArrayList<String> paramArrayList) {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < paramArrayList.size(); i++) {
      boolean bool = "en".equals(BlueAppLocal.a());
      String str = "";
      if (bool) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!StringUtils.e(stringBuffer.toString()))
          str = ", "; 
        stringBuilder.append(str);
        stringBuilder.append(paramArrayList.get(i));
        stringBuffer.append(stringBuilder.toString());
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        if (!StringUtils.e(stringBuffer.toString()))
          str = "、"; 
        stringBuilder.append(str);
        stringBuilder.append(paramArrayList.get(i));
        stringBuffer.append(stringBuilder.toString());
      } 
    } 
    return stringBuffer.toString();
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("show_avatar_items", Boolean.valueOf(paramBoolean));
    bundle.putInt("fromPage", paramInt);
    TerminalActivity.d(paramContext, ModifyUserInfoFragment.class, bundle);
  }
  
  public static void a(Context paramContext, boolean paramBoolean) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("show_avatar_items", Boolean.valueOf(paramBoolean));
    TerminalActivity.d(paramContext, ModifyUserInfoFragment.class, bundle);
  }
  
  public static void a(BaseFragment paramBaseFragment, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("show_avatar_items", Boolean.valueOf(false));
    bundle.putInt("fromPage", paramInt);
    TerminalActivity.a((Fragment)paramBaseFragment, ModifyUserInfoFragment.class, bundle, 701);
  }
  
  private void a(UserInfoEntity paramUserInfoEntity) {
    String str2 = "";
    ImageLoader.a((IRequestHost)w_(), paramUserInfoEntity.avatar).a(2131232200).c().a(this.ab);
    if (paramUserInfoEntity.is_show_vip_page == 1)
      this.j.setChecked(true); 
    this.k.setText(paramUserInfoEntity.name);
    this.l.setText(paramUserInfoEntity.description);
    String str1 = TimeAndDateUtils.a(paramUserInfoEntity.birthday);
    this.m.setText(str1);
    int i = BluedPreferences.aD();
    if (i != 1) {
      if (i == 2) {
        TextView textView = this.n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringUtils.a(paramUserInfoEntity.height, BlueAppLocal.c(), false));
        stringBuilder.append(" / ");
        stringBuilder.append(StringUtils.a(paramUserInfoEntity.weight, BlueAppLocal.c()));
        textView.setText(stringBuilder.toString());
      } 
    } else {
      TextView textView = this.n;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramUserInfoEntity.height);
      stringBuilder.append(" / ");
      stringBuilder.append(paramUserInfoEntity.weight);
      textView.setText(stringBuilder.toString());
    } 
    try {
      this.t.setText(StringUtils.b(Integer.parseInt(paramUserInfoEntity.ethnicity)));
    } catch (Exception exception) {}
    this.o.setText(StringUtils.f(paramUserInfoEntity.role));
    String str3 = (String)UserRelationshipUtils.c().get(paramUserInfoEntity.blood_type);
    str1 = str3;
    if (StringUtils.e(str3))
      str1 = this.f.getResources().getString(2131756917); 
    this.p.setText(str1);
    this.s.setText(AreaUtils.a(paramUserInfoEntity.hometown, LocaleUtils.c()));
    if (!TextUtils.isEmpty(paramUserInfoEntity.mate)) {
      i = Integer.parseInt(paramUserInfoEntity.mate);
      if (i == 1 || i == 0) {
        this.v.setText(getResources().getString(2131756205));
      } else {
        this.v.setText(StringUtils.a(this.f, BlueAppLocal.c(), i));
      } 
    } 
    try {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("服务器返回 userInfo.mate:");
      stringBuilder1.append(paramUserInfoEntity.mate);
      Log.v("drb", stringBuilder1.toString());
      i = UserRelationshipUtils.b(this.f, this.v.getText().toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("服务器返回解析后 userInfo.mate:");
      stringBuilder1.append(i);
      Log.v("drb", stringBuilder1.toString());
      BluedLoginResult bluedLoginResult = UserInfo.a().i();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(i);
      stringBuilder2.append("");
      bluedLoginResult.setMate(stringBuilder2.toString());
    } catch (Exception exception) {}
    UserRelationshipUtils.a(this.ac, paramUserInfoEntity.vbadge, 3);
    p();
    UserTagAll userTagAll = paramUserInfoEntity.tags;
    if (userTagAll != null) {
      StringBuffer stringBuffer = new StringBuffer();
      i = 0;
      while (true) {
        int j = userTagAll.i_want.size();
        str1 = ", ";
        str3 = "、";
        if (i < j) {
          StringBuilder stringBuilder;
          this.az.add(((UserTag)userTagAll.i_want.get(i)).id);
          if ("EN".equals(BlueAppLocal.b())) {
            stringBuilder = new StringBuilder();
            if (StringUtils.e(stringBuffer.toString()))
              str1 = ""; 
            stringBuilder.append(str1);
            stringBuilder.append(((UserTag)userTagAll.i_want.get(i)).name);
            stringBuffer.append(stringBuilder.toString());
          } else {
            String str;
            StringBuilder stringBuilder2 = new StringBuilder();
            StringBuilder stringBuilder1 = stringBuilder;
            if (StringUtils.e(stringBuffer.toString()))
              str = ""; 
            stringBuilder2.append(str);
            stringBuilder2.append(((UserTag)userTagAll.i_want.get(i)).name);
            stringBuffer.append(stringBuilder2.toString());
          } 
          i++;
          continue;
        } 
        this.w.setText(stringBuffer.toString());
        StringBuffer stringBuffer1 = new StringBuffer();
        if (userTagAll.work != null)
          for (i = 0; i < userTagAll.work.size(); i++) {
            this.aB.add(((UserTag)userTagAll.work.get(i)).id);
            if ("EN".equals(BlueAppLocal.b())) {
              StringBuilder stringBuilder = new StringBuilder();
              if (StringUtils.e(stringBuffer1.toString())) {
                str1 = "";
              } else {
                str1 = ", ";
              } 
              stringBuilder.append(str1);
              stringBuilder.append(((UserTag)userTagAll.work.get(i)).name);
              stringBuffer1.append(stringBuilder.toString());
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              if (StringUtils.e(stringBuffer1.toString())) {
                str1 = "";
              } else {
                str1 = "、";
              } 
              stringBuilder.append(str1);
              stringBuilder.append(((UserTag)userTagAll.work.get(i)).name);
              stringBuffer1.append(stringBuilder.toString());
            } 
          }  
        this.x.setText(stringBuffer1.toString());
        stringBuffer1 = new StringBuffer();
        for (i = 0; i < userTagAll.type.size(); i++) {
          this.aD.add(((UserTag)userTagAll.type.get(i)).id);
          if ("EN".equals(BlueAppLocal.b())) {
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.e(stringBuffer1.toString())) {
              str1 = "";
            } else {
              str1 = ", ";
            } 
            stringBuilder.append(str1);
            stringBuilder.append(((UserTag)userTagAll.type.get(i)).name);
            stringBuffer1.append(stringBuilder.toString());
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.e(stringBuffer1.toString())) {
              str1 = "";
            } else {
              str1 = "、";
            } 
            stringBuilder.append(str1);
            stringBuilder.append(((UserTag)userTagAll.type.get(i)).name);
            stringBuffer1.append(stringBuilder.toString());
          } 
        } 
        this.y.setText(stringBuffer1.toString());
        stringBuffer1 = new StringBuffer();
        for (i = 0; i < userTagAll.character.size(); i++) {
          this.aD.add(((UserTag)userTagAll.character.get(i)).id);
          if ("EN".equals(BlueAppLocal.b())) {
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.e(stringBuffer1.toString())) {
              str1 = "";
            } else {
              str1 = ", ";
            } 
            stringBuilder.append(str1);
            stringBuilder.append(((UserTag)userTagAll.character.get(i)).name);
            stringBuffer1.append(stringBuilder.toString());
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.e(stringBuffer1.toString())) {
              str1 = "";
            } else {
              str1 = "、";
            } 
            stringBuilder.append(str1);
            stringBuilder.append(((UserTag)userTagAll.character.get(i)).name);
            stringBuffer1.append(stringBuilder.toString());
          } 
        } 
        this.z.setText(stringBuffer1.toString());
        stringBuffer1 = new StringBuffer();
        if (userTagAll.hobbies != null)
          for (i = 0; i < userTagAll.hobbies.size(); i++) {
            this.aD.add(((UserTag)userTagAll.hobbies.get(i)).id);
            if ("EN".equals(BlueAppLocal.b())) {
              StringBuilder stringBuilder = new StringBuilder();
              if (StringUtils.e(stringBuffer1.toString())) {
                str1 = "";
              } else {
                str1 = ", ";
              } 
              stringBuilder.append(str1);
              stringBuilder.append(((UserTag)userTagAll.hobbies.get(i)).name);
              stringBuffer1.append(stringBuilder.toString());
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              if (StringUtils.e(stringBuffer1.toString())) {
                str1 = "";
              } else {
                str1 = "、";
              } 
              stringBuilder.append(str1);
              stringBuilder.append(((UserTag)userTagAll.hobbies.get(i)).name);
              stringBuffer1.append(stringBuilder.toString());
            } 
          }  
        this.A.setText(stringBuffer1.toString());
        stringBuffer1 = new StringBuffer();
        if (userTagAll.recreation != null)
          for (i = 0; i < userTagAll.recreation.size(); i++) {
            this.aD.add(((UserTag)userTagAll.recreation.get(i)).id);
            if ("EN".equals(BlueAppLocal.b())) {
              StringBuilder stringBuilder = new StringBuilder();
              if (StringUtils.e(stringBuffer1.toString())) {
                str1 = "";
              } else {
                str1 = ", ";
              } 
              stringBuilder.append(str1);
              stringBuilder.append(((UserTag)userTagAll.recreation.get(i)).name);
              stringBuffer1.append(stringBuilder.toString());
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              if (StringUtils.e(stringBuffer1.toString())) {
                str1 = "";
              } else {
                str1 = "、";
              } 
              stringBuilder.append(str1);
              stringBuilder.append(((UserTag)userTagAll.recreation.get(i)).name);
              stringBuffer1.append(stringBuilder.toString());
            } 
          }  
        this.B.setText(stringBuffer1.toString());
        stringBuffer1 = new StringBuffer();
        if (userTagAll.love_type != null)
          for (i = 0; i < userTagAll.love_type.size(); i++) {
            this.aF.add(((UserTag)userTagAll.love_type.get(i)).id);
            if ("EN".equals(BlueAppLocal.b())) {
              StringBuilder stringBuilder = new StringBuilder();
              if (StringUtils.e(stringBuffer1.toString())) {
                str1 = "";
              } else {
                str1 = ", ";
              } 
              stringBuilder.append(str1);
              stringBuilder.append(((UserTag)userTagAll.love_type.get(i)).name);
              stringBuffer1.append(stringBuilder.toString());
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              if (StringUtils.e(stringBuffer1.toString())) {
                str1 = "";
              } else {
                str1 = "、";
              } 
              stringBuilder.append(str1);
              stringBuilder.append(((UserTag)userTagAll.love_type.get(i)).name);
              stringBuffer1.append(stringBuilder.toString());
            } 
          }  
        this.C.setText(stringBuffer1.toString());
        stringBuffer1 = new StringBuffer();
        if (userTagAll.love_character != null)
          for (i = 0; i < userTagAll.love_character.size(); i++) {
            this.aF.add(((UserTag)userTagAll.love_character.get(i)).id);
            if ("EN".equals(BlueAppLocal.b())) {
              StringBuilder stringBuilder = new StringBuilder();
              if (StringUtils.e(stringBuffer1.toString())) {
                str1 = "";
              } else {
                str1 = ", ";
              } 
              stringBuilder.append(str1);
              stringBuilder.append(((UserTag)userTagAll.love_character.get(i)).name);
              stringBuffer1.append(stringBuilder.toString());
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              if (StringUtils.e(stringBuffer1.toString())) {
                str1 = "";
              } else {
                str1 = "、";
              } 
              stringBuilder.append(str1);
              stringBuilder.append(((UserTag)userTagAll.love_character.get(i)).name);
              stringBuffer1.append(stringBuilder.toString());
            } 
          }  
        this.D.setText(stringBuffer1.toString());
        stringBuffer1 = new StringBuffer();
        i = 0;
        while (true) {
          String str4;
          String str5;
          j = userTagAll.type.size();
          str1 = ",";
          if (i < j) {
            this.av.add(((UserTag)userTagAll.type.get(i)).id);
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.e(stringBuffer1.toString()))
              str1 = ""; 
            stringBuilder.append(str1);
            stringBuilder.append(((UserTag)userTagAll.type.get(i)).name);
            stringBuffer1.append(stringBuilder.toString());
            i++;
            continue;
          } 
          for (i = 0; i < userTagAll.character.size(); i++) {
            this.av.add(((UserTag)userTagAll.character.get(i)).id);
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.e(stringBuffer1.toString())) {
              str1 = "";
            } else {
              str1 = ",";
            } 
            stringBuilder.append(str1);
            stringBuilder.append(((UserTag)userTagAll.character.get(i)).name);
            stringBuffer1.append(stringBuilder.toString());
          } 
          stringBuffer1 = new StringBuffer();
          for (i = 0; i < userTagAll.love_type.size(); i++) {
            this.av.add(((UserTag)userTagAll.love_type.get(i)).id);
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.e(stringBuffer1.toString())) {
              str1 = "";
            } else {
              str1 = ",";
            } 
            stringBuilder.append(str1);
            stringBuilder.append(((UserTag)userTagAll.love_type.get(i)).name);
            stringBuffer1.append(stringBuilder.toString());
          } 
          for (i = 0; i < userTagAll.i_want.size(); i++) {
            this.av.add(((UserTag)userTagAll.i_want.get(i)).id);
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.e(stringBuffer1.toString())) {
              str1 = "";
            } else {
              str1 = ",";
            } 
            stringBuilder.append(str1);
            stringBuilder.append(((UserTag)userTagAll.i_want.get(i)).name);
            stringBuffer1.append(stringBuilder.toString());
          } 
          for (i = 0; i < userTagAll.love_character.size(); i++) {
            this.av.add(((UserTag)userTagAll.love_character.get(i)).id);
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.e(stringBuffer1.toString())) {
              str1 = "";
            } else {
              str1 = ",";
            } 
            stringBuilder.append(str1);
            stringBuilder.append(((UserTag)userTagAll.love_character.get(i)).name);
            stringBuffer1.append(stringBuilder.toString());
          } 
          ArrayList<String> arrayList = this.av;
          if (arrayList != null && arrayList.size() > 0) {
            this.u.setText(getResources().getString(2131756099));
          } else {
            this.u.setText(getResources().getString(2131759098));
          } 
          this.aP.setVisibility(0);
          TextView textView = this.aP;
          String str6 = this.f.getResources().getString(2131756096);
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(BluedConfig.b().C());
          stringBuilder2.append("");
          textView.setText(String.format(str6, new Object[] { stringBuilder2.toString() }));
          this.aK = paramUserInfoEntity.health_test_result;
          this.aL = paramUserInfoEntity.health_test_time;
          this.aM = paramUserInfoEntity.health_prpe_use_situation;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("服务端返回健康信息 healthResult：");
          stringBuilder1.append(this.aK);
          stringBuilder1.append(" -- healthTime：");
          stringBuilder1.append(this.aL);
          stringBuilder1.append(" -- healthPrep：");
          stringBuilder1.append(this.aM);
          Log.v("drb", stringBuilder1.toString());
          if (TextUtils.equals(this.aK, "0"))
            this.aK = "-1"; 
          if (TextUtils.equals(this.aL, "0"))
            this.aL = "-1"; 
          if (TextUtils.equals(this.aM, "0"))
            this.aM = "-1"; 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("服务端返回健康信息处理后 healthResult：");
          stringBuilder1.append(this.aK);
          stringBuilder1.append(" -- healthTime：");
          stringBuilder1.append(this.aL);
          stringBuilder1.append(" -- healthPrep：");
          stringBuilder1.append(this.aM);
          Log.v("drb", stringBuilder1.toString());
          ArrayMap arrayMap1 = UserRelationshipUtils.e();
          if (TextUtils.isEmpty(this.aK)) {
            str4 = "";
          } else {
            str4 = this.aK;
          } 
          str6 = (String)arrayMap1.get(str4);
          if (TextUtils.equals(this.aL, "1")) {
            str4 = getString(2131756978);
          } else if (TextUtils.equals(this.aL, "-1")) {
            str4 = getString(2131756977);
          } else if (TextUtils.isEmpty(this.aL)) {
            str4 = "";
          } else {
            str4 = TimeAndDateUtils.d(this.aL);
          } 
          ArrayMap arrayMap2 = UserRelationshipUtils.f();
          if (TextUtils.isEmpty(this.aM)) {
            str5 = str2;
          } else {
            str5 = this.aM;
          } 
          b(str6, str4, (String)arrayMap2.get(str5));
          break;
        } 
        break;
      } 
    } 
  }
  
  private void a(String paramString) {
    MineHttpUtils.c(this.f, new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>(this, (IRequestHost)w_(), paramString) {
          protected void a(BluedEntityA<BluedLoginResult> param1BluedEntityA) {
            AppMethods.d(2131756181);
            for (int i = 0; i < ModifyUserInfoFragment.r(this.b).size(); i++) {
              if (this.a.equals(((BluedAlbum)ModifyUserInfoFragment.r(this.b).get(i)).getPid())) {
                ModifyUserInfoFragment.r(this.b).remove(i);
                BluedAlbum bluedAlbum = new BluedAlbum();
                ModifyUserInfoFragment.r(this.b).add(bluedAlbum);
                ModifyUserInfoFragment.s(this.b).notifyDataSetChanged();
                break;
              } 
            } 
            UserInfoDataObserver.a().b();
            UserHttpUtils.a(ModifyUserInfoFragment.h(this.b), this.b.e, (UserInfo.a().i()).uid, "", false, 0, 0, 0, (IRequestHost)this.b.w_());
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ModifyUserInfoFragment.u(this.b));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ModifyUserInfoFragment.u(this.b));
          }
        }paramString, (IRequestHost)w_());
  }
  
  private void a(String paramString, BluedAlbum paramBluedAlbum) {
    QiniuUploadUtils.a(paramString, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this) {
          public void a(String param1String) {
            if (CommonTools.a((Fragment)this.a))
              DialogUtils.b(ModifyUserInfoFragment.u(this.a)); 
          }
          
          public void a(String param1String, double param1Double) {}
          
          public void a(String param1String1, String param1String2) {
            ModifyUserInfoFragment.d(this.a, param1String1);
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  private void a(String paramString1, BluedAlbum paramBluedAlbum, String paramString2) {
    QiniuUploadUtils.a(paramString1, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this, paramString2) {
          double a = 0.0D;
          
          public void a(String param1String) {
            this.c.a(new -$$Lambda$ModifyUserInfoFragment$16$5DBAaGofLaByL_ZHNezWppVXCO8(this, param1String));
          }
          
          public void a(String param1String, double param1Double) {
            if (ModifyUserInfoFragment.v(this.c))
              return; 
            this.c.a(new -$$Lambda$ModifyUserInfoFragment$16$2vcORiY4EJSP0HFpe8q4-Tk0LF8(this, param1Double, param1String));
          }
          
          public void a(String param1String1, String param1String2) {
            this.c.a(new -$$Lambda$ModifyUserInfoFragment$16$dolYOZlHloh83vgK8FRhYjtfEGE(this, param1String1, this.b, param1String2));
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  private void a(String paramString1, String paramString2) {
    this.aV.setVisibility(0);
    this.aV.setText("0%");
    LoginRegisterHttpUtils.a(this.f, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, (IRequestHost)w_(), paramString1, paramString2) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              BluedAlbum bluedAlbum = param1BluedEntityA.data.get(0);
              ModifyUserInfoFragment.b(this.c, this.a, bluedAlbum, this.b);
              ModifyUserInfoFragment.D(this.c).setText("5%");
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            ModifyUserInfoFragment.D(this.c).setText(2131756378);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ModifyUserInfoFragment.u(this.c));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ModifyUserInfoFragment.u(this.c));
          }
        }(IRequestHost)w_());
  }
  
  private void a(String paramString1, String paramString2, int paramInt) {
    LoginRegisterHttpUtils.a(this.f, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, (IRequestHost)w_(), paramInt, paramString1, paramString2) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              BluedAlbum bluedAlbum = param1BluedEntityA.data.get(0);
              ((BluedAlbum)ModifyUserInfoFragment.r(this.d).get(this.a)).key = bluedAlbum.key;
              ModifyUserInfoFragment.a(this.d, this.b, bluedAlbum, this.c);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            ModifyUserInfoFragment.a(this.d, true);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            if (ModifyUserInfoFragment.t(this.d)) {
              ((BluedAlbum)ModifyUserInfoFragment.r(this.d).get(this.a)).setProgress(this.d.getResources().getString(2131756378));
              ModifyUserInfoFragment.s(this.d).notifyDataSetChanged();
            } 
          }
          
          public void onUIStart() {
            super.onUIStart();
            ModifyUserInfoFragment.a(this.d, false);
            ((BluedAlbum)ModifyUserInfoFragment.r(this.d).get(this.a)).setProgress("0%");
            ((BluedAlbum)ModifyUserInfoFragment.r(this.d).get(this.a)).setUrl(RecyclingUtils.Scheme.c.b(this.b));
            ModifyUserInfoFragment.s(this.d).notifyDataSetChanged();
          }
        }(IRequestHost)w_());
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    MineHttpUtils.c(this.f, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, (IRequestHost)w_(), paramString3) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            int i = ModifyUserInfoFragment.b(this.b, this.a);
            ((BluedAlbum)ModifyUserInfoFragment.r(this.b).get(i)).setProgress("100%");
            ModifyUserInfoFragment.s(this.b).notifyDataSetChanged();
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              BluedAlbum bluedAlbum = param1BluedEntityA.data.get(0);
              ((BluedAlbum)ModifyUserInfoFragment.r(this.b).get(i)).setPid(bluedAlbum.getPid());
              ((BluedAlbum)ModifyUserInfoFragment.r(this.b).get(i)).setProgress("");
              ModifyUserInfoFragment.s(this.b).notifyDataSetChanged();
            } 
            UserInfoDataObserver.a().b();
            UserHttpUtils.a(ModifyUserInfoFragment.h(this.b), this.b.e, (UserInfo.a().i()).uid, "", false, 0, 0, 0, (IRequestHost)this.b.w_());
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            ModifyUserInfoFragment.b(this.b, true);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            if (ModifyUserInfoFragment.w(this.b)) {
              int i = ModifyUserInfoFragment.b(this.b, this.a);
              ((BluedAlbum)ModifyUserInfoFragment.r(this.b).get(i)).setProgress(this.b.getResources().getString(2131756378));
              ModifyUserInfoFragment.s(this.b).notifyDataSetChanged();
            } 
          }
          
          public void onUIStart() {
            super.onUIStart();
            ModifyUserInfoFragment.b(this.b, false);
          }
        }paramString1, paramString2, (IRequestHost)w_());
  }
  
  private void a(Map<String, String> paramMap) {
    UserHttpUtils.a(this.f, new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>(this, (IRequestHost)w_()) {
          protected BluedEntityA<BluedLoginResult> a(String param1String) {
            UserAccountsVDao.a().b(param1String);
            return (BluedEntityA<BluedLoginResult>)super.parseData(param1String);
          }
          
          protected void a(BluedEntityA<BluedLoginResult> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              BluedLoginResult bluedLoginResult1 = param1BluedEntityA.data.get(0);
              bluedLoginResult1.setVip_avatars(UserInfo.a().i().getVip_avatars());
              (UserInfo.a().i()).is_show_vip_page = bluedLoginResult1.is_show_vip_page;
              (BluedConfig.b().c()).is_show_vip_page = bluedLoginResult1.is_show_vip_page;
              UserInfo.a().i().setAvatar(bluedLoginResult1.getAvatar());
              UserInfo.a().i().setHeight(bluedLoginResult1.getHeight());
              UserInfo.a().i().setWeight(bluedLoginResult1.getWeight());
              UserInfo.a().i().setAge(bluedLoginResult1.getAge());
              UserInfo.a().i().setBirthday(bluedLoginResult1.getBirthday());
              UserInfo.a().i().setTags(bluedLoginResult1.getTags());
              UserInfo.a().i().setCity_settled(bluedLoginResult1.getCity_settled());
              UserInfo.a().i().setHometown(bluedLoginResult1.getHometown());
              UserInfo.a().i().setRole(bluedLoginResult1.getRole());
              UserInfo.a().i().setBlood_type(bluedLoginResult1.getBlood_type());
              UserInfo.a().i().setName(bluedLoginResult1.getName());
              BluedLoginResult bluedLoginResult2 = UserInfo.a().i();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(ModifyUserInfoFragment.C(this.a).getText());
              stringBuilder.append("");
              bluedLoginResult2.setDescription(stringBuilder.toString());
              UserInfo.a().i().setEthnicity(bluedLoginResult1.getEthnicity());
              UserInfo.a().i().setMate(bluedLoginResult1.getMate());
              (UserInfo.a().i()).health_test_result = bluedLoginResult1.health_test_result;
              (UserInfo.a().i()).health_test_time = bluedLoginResult1.health_test_time;
              (UserInfo.a().i()).health_prpe_use_situation = bluedLoginResult1.health_prpe_use_situation;
              AppMethods.a(this.a.getResources().getString(2131757921));
              UserInfoDataObserver.a().b();
              BluedConfig.b().e();
              this.a.m();
            } 
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ModifyUserInfoFragment.u(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ModifyUserInfoFragment.u(this.a));
          }
        }UserInfo.a().i().getUid(), paramMap, (IRequestHost)w_());
  }
  
  private int b(String paramString) {
    if (!StringUtils.e(paramString))
      for (int i = 0; i < this.am.size(); i++) {
        if (paramString.equals(((BluedAlbum)this.am.get(i)).key))
          return i; 
      }  
    return 0;
  }
  
  private void b(String paramString1, BluedAlbum paramBluedAlbum, String paramString2) {
    QiniuUploadUtils.a(paramString1, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this, paramString2) {
          public void a(String param1String) {
            if (CommonTools.a((Fragment)this.b)) {
              ModifyUserInfoFragment.D(this.b).setText(2131756378);
              DialogUtils.b(ModifyUserInfoFragment.u(this.b));
              AppMethods.d(2131756082);
            } 
          }
          
          public void a(String param1String, double param1Double) {
            if (CommonTools.a((Fragment)this.b)) {
              int i = (int)(param1Double * 100.0D);
              TextView textView = ModifyUserInfoFragment.D(this.b);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(Math.min(i + 5, 98));
              stringBuilder.append("%");
              textView.setText(stringBuilder.toString());
            } 
          }
          
          public void a(String param1String1, String param1String2) {
            ModifyUserInfoFragment.b(this.b, param1String1, this.a, param1String2);
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  private void b(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("setHealthToLanguage result：");
    stringBuilder2.append(paramString1);
    stringBuilder2.append(" -- time：");
    stringBuilder2.append(paramString2);
    stringBuilder2.append(" -- prep：");
    stringBuilder2.append(paramString3);
    Log.v("drb", stringBuilder2.toString());
    if (StringUtils.e(paramString1) && StringUtils.e(paramString2) && StringUtils.e(paramString3)) {
      this.q.setText("");
      return;
    } 
    String str = paramString1;
    if (TextUtils.equals(paramString1, getString(2131756972)))
      str = ""; 
    paramString1 = paramString2;
    if (TextUtils.equals(paramString2, getString(2131756972)))
      paramString1 = ""; 
    paramString2 = paramString3;
    if (TextUtils.equals(paramString3, getString(2131756972)))
      paramString2 = ""; 
    StringBuffer stringBuffer = new StringBuffer();
    if ("en".equals(BlueAppLocal.a())) {
      stringBuffer.append(str);
      if (!StringUtils.e(paramString1) && !StringUtils.e(str))
        stringBuffer.append(", "); 
      stringBuffer.append(paramString1);
      if (!StringUtils.e(paramString2) && (!StringUtils.e(str) || !StringUtils.e(paramString1)))
        stringBuffer.append(", "); 
      stringBuffer.append(paramString2);
    } else {
      stringBuffer.append(str);
      if (!StringUtils.e(paramString1) && !StringUtils.e(str))
        stringBuffer.append("，"); 
      stringBuffer.append(paramString1);
      if (!StringUtils.e(paramString2) && (!StringUtils.e(str) || !StringUtils.e(paramString1)))
        stringBuffer.append("，"); 
      stringBuffer.append(paramString2);
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("setHealthToLanguage end ：");
    stringBuilder1.append(stringBuffer.toString());
    Log.v("drb", stringBuilder1.toString());
    this.q.setText(stringBuffer.toString());
  }
  
  private void c(String paramString) {
    LoginRegisterHttpUtils.a(this.f, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, (IRequestHost)w_(), paramString) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              BluedAlbum bluedAlbum = param1BluedEntityA.data.get(0);
              ModifyUserInfoFragment.a(this.b, this.a, bluedAlbum);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ModifyUserInfoFragment.u(this.b));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ModifyUserInfoFragment.u(this.b));
          }
        }(IRequestHost)w_());
  }
  
  private void c(String paramString1, String paramString2, String paramString3) {
    MineHttpUtils.j(this.f, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, (IRequestHost)w_(), paramString1) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            ImageLoader.a((IRequestHost)this.b.w_(), this.a).a(2131232200).c().a(ModifyUserInfoFragment.m(this.b));
            ModifyUserInfoFragment.j(this.b).setVisibility(0);
            UserInfo.a().i().setAvatar(this.a);
            BluedConfig.b().e();
            AppMethods.d(2131755403);
            ModifyUserInfoFragment.D(this.b).setText("100%");
            this.b.a(new -$$Lambda$ModifyUserInfoFragment$33$_TbbKQC_Mgs2zgmlm1XDcDL8diQ(this), 2000L);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            ModifyUserInfoFragment.D(this.b).setText(2131756378);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ModifyUserInfoFragment.u(this.b));
          }
        }UserInfo.a().i().getUid(), paramString2, paramString1, (IRequestHost)w_());
  }
  
  private void d(String paramString) {
    MineHttpUtils.d(this.f, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, (IRequestHost)w_(), paramString) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            ModifyUserInfoFragment.a(this.b, 1);
            ModifyUserInfoFragment.a(this.b, this.a);
            ModifyUserInfoFragment.n(this.b).setText(2131758467);
            AppMethods.d(2131758464);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ModifyUserInfoFragment.u(this.b));
          }
        }paramString, (IRequestHost)w_());
  }
  
  private void o() {
    this.aO = (CommonTopTitleNoTrans)this.g.findViewById(2131300300);
    this.aO.setCenterText(getString(2131757912));
    this.aO.setRightText(2131756100);
    this.aO.setLeftClickListener(this);
    this.aO.setRightClickListener(this);
    this.aO.setRightTextColor(2131100838);
    this.aO.setCenterTextColor(2131100838);
    TextView textView = this.aO.getCenterTextView();
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(14);
    layoutParams.topMargin = DensityUtils.a(this.f, 5.0F);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    textView.setTextSize(16.0F);
    this.aP = this.aO.getCenterBelowTextView();
    this.aO.e();
  }
  
  private void p() {
    ProfileHttpUtils.a(ChatManager.context, new BluedUIHttpResponse<BluedEntityA<BluedBlackList.privacySettingEntity>>(this) {
          public void a(BluedEntityA<BluedBlackList.privacySettingEntity> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
                  if (((BluedBlackList.privacySettingEntity)param1BluedEntityA.data.get(0)).is_open_private_photos == 1) {
                    BluedPreferences.B(true);
                    ModifyUserInfoFragment.a(this.a);
                    return;
                  } 
                  BluedPreferences.B(false);
                  ModifyUserInfoFragment.a(this.a);
                  return;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
              }  
          }
        },  UserInfo.a().i().getUid(), (IRequestHost)w_());
  }
  
  private void q() {
    ArrayList<String> arrayList = new ArrayList();
    if (StringUtils.e(UserInfo.a().i().getAvatar())) {
      arrayList.add(getResources().getString(2131759125));
    } else {
      String[] arrayOfString1 = getResources().getStringArray(2130903074);
      arrayList.add(arrayOfString1[0]);
      arrayList.add(arrayOfString1[1]);
    } 
    String[] arrayOfString = arrayList.<String>toArray(new String[arrayList.size()]);
    CommonShowBottomWindow.a((FragmentActivity)this.f, arrayOfString, new ActionSheet.ActionSheetListener(this) {
          public void a(ActionSheet param1ActionSheet, int param1Int) {
            if (param1Int != 0) {
              if (param1Int != 1)
                return; 
              String[] arrayOfString = new String[1];
              arrayOfString[0] = UserInfo.a().i().getAvatar();
              if (arrayOfString.length > 0) {
                BasePhotoFragment.a(ModifyUserInfoFragment.h(this.a), arrayOfString, 0, 3, ModifyUserInfoFragment.i(this.a));
                return;
              } 
            } else {
              PermissionHelper.e(new PermissionCallbacks(this) {
                    public void a(String[] param2ArrayOfString) {}
                    
                    public void aa_() {
                      if (4 == UserInfo.a().i().getVBadge() || 7 == UserInfo.a().i().getVBadge()) {
                        CommonAlertDialog.a(ModifyUserInfoFragment.h(this.a.a), null, this.a.a.getResources().getString(2131755746), this.a.a.getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                              public void onClick(DialogInterface param3DialogInterface, int param3Int) {
                                PhotoSelectFragment.a(this.a.a.a, 2, 177);
                              }
                            }null, null, null);
                        return;
                      } 
                      PhotoSelectFragment.a(this.a.a, 2, 177);
                    }
                  });
            } 
          }
          
          public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
        });
  }
  
  private void r() {
    BluedUIHttpResponse<BluedEntityA<UserInfoEntity>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(this, (IRequestHost)w_()) {
        public void a(BluedEntityA<UserInfoEntity> param1BluedEntityA) {
          if (param1BluedEntityA != null) {
            UserInfoEntity userInfoEntity = (UserInfoEntity)param1BluedEntityA.getSingleData();
            if (userInfoEntity != null) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("userInfo.avatar_audited:");
              stringBuilder.append(userInfoEntity.avatar_audited);
              Log.v("drb", stringBuilder.toString());
              if (userInfoEntity.avatar_audited == 0) {
                ModifyUserInfoFragment.j(this.a).setVisibility(0);
              } else {
                ModifyUserInfoFragment.j(this.a).setVisibility(8);
              } 
              UserInfo.a().i().setAvatar_pid(userInfoEntity.avatar_pid);
              UserInfo.a().i().setAvatar(userInfoEntity.avatar);
              (UserInfo.a().i()).vip_grade = userInfoEntity.vip_grade;
              (UserInfo.a().i()).is_show_vip_page = userInfoEntity.is_show_vip_page;
              (BluedConfig.b().c()).is_show_vip_page = userInfoEntity.is_show_vip_page;
              (UserInfo.a().i()).nickname_limit = userInfoEntity.nickname_limit;
              if ((UserInfo.a().i()).is_show_vip_page == 1)
                ModifyUserInfoFragment.k(this.a).setChecked(true); 
              ReflectionUtils.a(userInfoEntity, UserInfo.a().i());
              if (userInfoEntity.album != null) {
                UserInfo.a().i().setAlbum(userInfoEntity.album);
                ModifyUserInfoFragment.l(this.a);
              } 
              ImageLoader.a((IRequestHost)this.a.w_(), UserInfo.a().i().getAvatar()).a(2131232200).c().a(ModifyUserInfoFragment.m(this.a));
              ModifyUserInfoFragment.a(this.a, userInfoEntity.background_photo);
              if (!TextUtils.isEmpty(userInfoEntity.background_photo)) {
                if (userInfoEntity.background_photo_auditing == 1) {
                  ModifyUserInfoFragment.a(this.a, 1);
                  ModifyUserInfoFragment.n(this.a).setText(2131758467);
                } else {
                  ModifyUserInfoFragment.a(this.a, 2);
                  ModifyUserInfoFragment.n(this.a).setText(2131758471);
                } 
              } else {
                ModifyUserInfoFragment.a(this.a, 0);
                ModifyUserInfoFragment.n(this.a).setText(2131758469);
              } 
              if (userInfoEntity.health_test_info_show == 1) {
                ModifyUserInfoFragment.o(this.a).setVisibility(0);
              } else {
                ModifyUserInfoFragment.o(this.a).setVisibility(8);
              } 
              if ((UserInfo.a().i()).vip_grade != 0)
                ModifyUserInfoFragment.p(this.a); 
              ModifyUserInfoFragment.a(this.a, userInfoEntity);
              return;
            } 
            AppMethods.d(2131756584);
            return;
          } 
          AppMethods.d(2131756584);
        }
      };
    UserHttpUtils.a(ChatManager.context, bluedUIHttpResponse, UserInfo.a().i().getUid(), "", false, 0, 0, 0, (IRequestHost)w_());
  }
  
  private void s() {
    UserHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<MultiHeadMigration.DataBean>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<MultiHeadMigration.DataBean> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              MultiHeadMigration.DataBean dataBean = (MultiHeadMigration.DataBean)param1BluedEntityA.getSingleData();
              if (dataBean != null) {
                if (dataBean.vip_grade != 0 && dataBean.vip_avatar_num > 0) {
                  AppMethods.a(ModifyUserInfoFragment.h(this.a).getResources().getString(2131758438));
                  return;
                } 
                if (dataBean.vip_grade == 0 && dataBean.vip_avatar_num > 0)
                  AppMethods.a(ModifyUserInfoFragment.h(this.a).getResources().getString(2131758439)); 
              } 
            } 
          }
        }(UserInfo.a().i()).uid, (IRequestHost)w_());
  }
  
  private void t() {
    if (BluedPreferences.bu() == 1)
      return; 
    Context context = this.f;
    this.d = new ModifyUserInfoPopView(context, context.getResources().getString(2131758461), this.f.getResources().getString(2131757093), 5, DensityUtils.a(this.f, 20.0F), DensityUtils.a(this.f, 201.0F), new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.d.d();
            ModifyUserInfoFragment.q(this.a);
          }
        });
    this.d.c();
  }
  
  private void u() {
    Context context = this.f;
    this.d = new ModifyUserInfoPopView(context, context.getResources().getString(2131758462), this.f.getResources().getString(2131757093), 5, DensityUtils.a(this.f, 20.0F), DensityUtils.a(this.f, 255.0F), new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.d.d();
            BluedPreferences.l(1);
          }
        });
    this.d.c();
  }
  
  private void v() {
    this.aV = (TextView)this.g.findViewById(2131301465);
    this.aU = (TextView)this.g.findViewById(2131300541);
    this.h = DialogUtils.a(this.f);
    this.aT = (TextView)this.g.findViewById(2131301502);
    this.aS = (ImageView)this.g.findViewById(2131297582);
    this.aT.setText(2131759288);
    this.aS.setImageResource(2131232812);
    this.r = (TextView)this.g.findViewById(2131301360);
    this.aa = (LinearLayout)this.g.findViewById(2131299024);
    this.aa.setOnClickListener(this);
    this.F = (LinearLayout)this.g.findViewById(2131298974);
    this.F.setOnClickListener(this);
    this.G = (LinearLayout)this.g.findViewById(2131298772);
    this.G.setOnClickListener(this);
    this.H = (LinearLayout)this.g.findViewById(2131298722);
    this.H.setOnClickListener(this);
    this.I = (LinearLayout)this.g.findViewById(2131298875);
    this.I.setOnClickListener(this);
    this.J = (LinearLayout)this.g.findViewById(2131299064);
    this.J.setOnClickListener(this);
    this.K = (LinearLayout)this.g.findViewById(2131298725);
    this.K.setOnClickListener(this);
    this.L = (LinearLayout)this.g.findViewById(2131298874);
    this.L.setOnClickListener(this);
    this.M = (LinearLayout)this.g.findViewById(2131298885);
    this.M.setOnClickListener(this);
    this.N = (LinearLayout)this.g.findViewById(2131298789);
    this.N.setOnClickListener(this);
    this.Q = (LinearLayout)this.g.findViewById(2131299048);
    this.Q.setOnClickListener(this);
    this.O = (LinearLayout)this.g.findViewById(2131298870);
    this.O.setOnClickListener(this);
    this.P = (LinearLayout)this.g.findViewById(2131299095);
    this.P.setOnClickListener(this);
    this.ab = (ImageView)this.g.findViewById(2131297362);
    this.ac = (ImageView)this.g.findViewById(2131297575);
    this.k = (TextView)this.g.findViewById(2131301105);
    this.l = (TextView)this.g.findViewById(2131300705);
    this.m = (TextView)this.g.findViewById(2131300569);
    this.n = (TextView)this.g.findViewById(2131300886);
    this.t = (TextView)this.g.findViewById(2131300735);
    this.o = (TextView)this.g.findViewById(2131301285);
    this.p = (TextView)this.g.findViewById(2131300581);
    this.q = (TextView)this.g.findViewById(2131300879);
    this.s = (TextView)this.g.findViewById(2131300902);
    this.u = (TextView)this.g.findViewById(2131301373);
    this.v = (TextView)this.g.findViewById(2131301249);
    this.R = (LinearLayout)this.g.findViewById(2131298941);
    this.w = (TextView)this.g.findViewById(2131301022);
    this.R.setOnClickListener(this);
    this.S = (LinearLayout)this.g.findViewById(2131298903);
    this.x = (TextView)this.g.findViewById(2131300935);
    this.S.setOnClickListener(this);
    this.T = (LinearLayout)this.g.findViewById(2131298970);
    this.y = (TextView)this.g.findViewById(2131301086);
    this.T.setOnClickListener(this);
    this.U = (LinearLayout)this.g.findViewById(2131298969);
    this.z = (TextView)this.g.findViewById(2131301084);
    this.U.setOnClickListener(this);
    this.V = (LinearLayout)this.g.findViewById(2131298884);
    this.A = (TextView)this.g.findViewById(2131300901);
    this.V.setOnClickListener(this);
    this.W = (LinearLayout)this.g.findViewById(2131298782);
    this.B = (TextView)this.g.findViewById(2131300724);
    this.W.setOnClickListener(this);
    this.X = (LinearLayout)this.g.findViewById(2131298913);
    this.C = (TextView)this.g.findViewById(2131300958);
    this.X.setOnClickListener(this);
    this.Y = (LinearLayout)this.g.findViewById(2131298912);
    this.D = (TextView)this.g.findViewById(2131300957);
    this.Y.setOnClickListener(this);
    this.aQ = (ScrollView)this.g.findViewById(2131299836);
    this.aR = this.g.findViewById(2131299487);
    this.Z = (LinearLayout)this.g.findViewById(2131299137);
    this.E = (TextView)this.g.findViewById(2131301506);
    this.Z.setOnClickListener(this);
    this.aN.add(this.F);
    this.aN.add(this.G);
    this.aN.add(this.H);
    this.aN.add(this.I);
    this.aN.add(this.J);
    this.aN.add(this.K);
    this.aN.add(this.M);
    this.aN.add(this.N);
    this.aN.add(this.P);
    this.aN.add(this.Q);
    this.aN.add(this.R);
    this.aN.add(this.S);
    this.aN.add(this.T);
    this.aN.add(this.U);
    this.aN.add(this.V);
    this.aN.add(this.W);
    this.aN.add(this.X);
    this.aN.add(this.Y);
    this.j = (ToggleButton)this.g.findViewById(2131300261);
    this.j.setOnClickListener(this);
    this.j.setOnCheckedChangeListener(-$$Lambda$ModifyUserInfoFragment$juMWu7bjx5Ad0Z3jQF4aLXDEwIM.INSTANCE);
  }
  
  private void w() {
    this.al = (PhotoGridView)this.g.findViewById(2131297289);
    this.an = new UserDragGirdAdapter(this, this.f);
    this.al.setAdapter((ListAdapter)this.an);
    this.al.setColumnWidth(this.aq);
  }
  
  private void x() {
    if (BluedPreferences.bB()) {
      this.r.setText(getResources().getString(2131755300));
      this.r.setTextColor(this.f.getResources().getColor(2131100607));
      return;
    } 
    this.r.setText(getResources().getString(2131755299));
    this.r.setTextColor(this.f.getResources().getColor(2131100610));
  }
  
  private void y() {
    byte b;
    View view = LayoutInflater.from(this.f).inflate(2131494098, null);
    int k = BluedPreferences.aD();
    int j = -1;
    if (k != 1) {
      if (k != 2) {
        i = j;
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.n.getText());
        stringBuilder.append("");
        String str1 = stringBuilder.toString().split(" / ")[0];
        b = 0;
        while (true) {
          String[] arrayOfString = ap;
          i = j;
          if (b < arrayOfString.length) {
            if (arrayOfString[b].equals(str1)) {
              i = b;
              break;
            } 
            b++;
            continue;
          } 
          break;
        } 
      } 
    } else {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.n.getText());
        stringBuilder.append("");
        i = Integer.parseInt(stringBuilder.toString().split(" / ")[0]);
      } catch (Exception exception) {
        i = j;
      } 
    } 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.n.getText());
      stringBuilder.append("");
      b = Integer.parseInt(stringBuilder.toString().split(" / ")[1]);
    } catch (Exception exception) {
      b = 0;
    } 
    NumberPicker numberPicker = (NumberPicker)view.findViewById(2131299409);
    numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener(this) {
          public void a(NumberPicker param1NumberPicker, int param1Int1, int param1Int2) {
            ModifyUserInfoFragment modifyUserInfoFragment = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1Int2);
            stringBuilder.append("");
            ModifyUserInfoFragment.c(modifyUserInfoFragment, stringBuilder.toString());
            param1Int1 = BluedPreferences.aD();
            if (param1Int1 != 1) {
              if (param1Int1 != 2)
                return; 
              ModifyUserInfoFragment.c(this.a, ModifyUserInfoFragment.n()[param1Int2]);
              return;
            } 
            modifyUserInfoFragment = this.a;
            stringBuilder = new StringBuilder();
            stringBuilder.append(param1Int2);
            stringBuilder.append("");
            ModifyUserInfoFragment.c(modifyUserInfoFragment, stringBuilder.toString());
          }
        });
    if (k != 1) {
      if (k == 2)
        if (i < 0) {
          this.ad = ap[0];
        } else {
          String[] arrayOfString = ap;
          if (i > arrayOfString.length - 1) {
            this.ad = arrayOfString[arrayOfString.length - 1];
          } else {
            this.ad = arrayOfString[i];
          } 
        }  
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i);
      stringBuilder.append("");
      this.ad = stringBuilder.toString();
    } 
    if (k != 1) {
      if (k == 2) {
        this.ah = 0;
        String[] arrayOfString = ap;
        this.ai = arrayOfString.length - 1;
        this.af = 20;
        numberPicker.setDisplayedValues(arrayOfString);
        this.aj = 66;
        this.ak = 441;
        this.ag = 132;
      } 
    } else {
      this.ah = 120;
      this.ai = 220;
      this.af = 170;
      numberPicker.setDisplayedValues(null);
      this.aj = 30;
      this.ak = 200;
      this.ag = 60;
    } 
    numberPicker.setMinValue(this.ah);
    numberPicker.setMaxValue(this.ai);
    j = this.ah;
    if (i < j) {
      numberPicker.setValue(j);
    } else {
      j = this.ai;
      if (i > j) {
        numberPicker.setValue(j);
      } else {
        numberPicker.setValue(i);
      } 
    } 
    numberPicker.setFocusable(true);
    numberPicker.setFocusableInTouchMode(true);
    numberPicker = (NumberPicker)view.findViewById(2131299410);
    numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener(this) {
          public void a(NumberPicker param1NumberPicker, int param1Int1, int param1Int2) {
            ModifyUserInfoFragment.b(this.a, param1Int2);
          }
        });
    this.ae = b;
    numberPicker.setMinValue(this.aj);
    numberPicker.setMaxValue(this.ak);
    int i = this.aj;
    if (b < i) {
      numberPicker.setValue(i);
    } else {
      i = this.ak;
      if (b > i) {
        numberPicker.setValue(i);
      } else {
        numberPicker.setValue(b);
      } 
    } 
    numberPicker.setFocusable(true);
    numberPicker.setFocusableInTouchMode(true);
    String str = getResources().getString(2131755611);
    if (k != 1) {
      if (k == 2)
        str = getResources().getString(2131756880); 
    } else {
      str = getResources().getString(2131755611);
    } 
    CommonAlertDialog.a(this.f, view, str, "", "", getResources().getString(2131755609), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if ("0".equals(ModifyUserInfoFragment.x(this.a))) {
              ModifyUserInfoFragment modifyUserInfoFragment = this.a;
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(ModifyUserInfoFragment.y(this.a));
              stringBuilder1.append("");
              ModifyUserInfoFragment.c(modifyUserInfoFragment, stringBuilder1.toString());
              param1Int = BluedPreferences.aD();
              if (param1Int != 1) {
                if (param1Int == 2)
                  ModifyUserInfoFragment.c(this.a, ModifyUserInfoFragment.n()[ModifyUserInfoFragment.y(this.a)]); 
              } else {
                modifyUserInfoFragment = this.a;
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append(ModifyUserInfoFragment.y(this.a));
                stringBuilder1.append("");
                ModifyUserInfoFragment.c(modifyUserInfoFragment, stringBuilder1.toString());
              } 
            } 
            if (ModifyUserInfoFragment.z(this.a) == 0) {
              ModifyUserInfoFragment modifyUserInfoFragment = this.a;
              ModifyUserInfoFragment.b(modifyUserInfoFragment, ModifyUserInfoFragment.A(modifyUserInfoFragment));
            } 
            TextView textView = ModifyUserInfoFragment.B(this.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ModifyUserInfoFragment.x(this.a));
            stringBuilder.append(" / ");
            stringBuilder.append(ModifyUserInfoFragment.z(this.a));
            textView.setText(stringBuilder.toString());
          }
        }null, null, true);
  }
  
  public boolean V_() {
    ModifyUserInfoPopView modifyUserInfoPopView = this.d;
    if (modifyUserInfoPopView != null && modifyUserInfoPopView.b())
      return true; 
    a(true);
    return true;
  }
  
  public void a() {
    if (UserInfo.a().i() != null)
      this.am = UserInfo.a().i().getVip_avatars(); 
    int i = 0;
    List<BluedAlbum> list = this.am;
    if (list != null) {
      i = list.size();
    } else {
      this.am = new LinkedList<BluedAlbum>();
    } 
    while (i < 6) {
      BluedAlbum bluedAlbum = new BluedAlbum();
      this.am.add(bluedAlbum);
      i++;
    } 
  }
  
  public void a(boolean paramBoolean) {
    Map<String, String> map = l();
    if (paramBoolean) {
      if (map.size() != 1) {
        CommonAlertDialog.a(this.f, "", getResources().getString(2131756111), getResources().getString(2131756127), new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
            },  getResources().getString(2131756598), new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                this.a.m();
              }
            },  null);
        return;
      } 
      if (!a(this.aC, this.aB) || !a(this.aA, this.az) || !a(this.aE, this.aD) || !a(this.aG, this.aF)) {
        CommonAlertDialog.a(this.f, "", getResources().getString(2131756111), getResources().getString(2131756127), new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
            },  getResources().getString(2131756598), new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                this.a.m();
              }
            },  null);
        return;
      } 
      m();
      return;
    } 
    if (this.l.getText().length() > 256) {
      AppMethods.a(getResources().getString(2131756185));
      return;
    } 
    if (map.size() != 0) {
      a(map);
      return;
    } 
    m();
  }
  
  public boolean a(List<String> paramList1, List<String> paramList2) {
    boolean bool = false;
    if (paramList1 == null)
      return true; 
    if (paramList2 == null)
      return false; 
    if (paramList1.size() == paramList2.size()) {
      int i = 0;
      bool = true;
      while (i < paramList1.size()) {
        String str = paramList1.get(i);
        if (bool && paramList2.contains(str)) {
          bool = true;
        } else {
          bool = false;
        } 
        i++;
      } 
    } 
    return bool;
  }
  
  public void k() {
    x();
  }
  
  public Map<String, String> l() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void m() {
    int i = this.ar;
    if (i == 601) {
      Intent intent = new Intent();
      intent.putExtra("from", 601);
      getActivity().setResult(-1, intent);
      getActivity().finish();
      return;
    } 
    if (i == 602)
      PersonalVerifyObserver.a().b(); 
    getActivity().finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    // Byte code:
    //   0: iload_2
    //   1: iconst_m1
    //   2: if_icmpne -> 1305
    //   5: iload_1
    //   6: iconst_2
    //   7: if_icmpeq -> 1287
    //   10: iload_1
    //   11: iconst_4
    //   12: if_icmpeq -> 1255
    //   15: iload_1
    //   16: bipush #22
    //   18: if_icmpeq -> 1204
    //   21: iload_1
    //   22: sipush #507
    //   25: if_icmpeq -> 1139
    //   28: iload_1
    //   29: sipush #177
    //   32: if_icmpeq -> 1001
    //   35: iload_1
    //   36: sipush #178
    //   39: if_icmpeq -> 971
    //   42: iload_1
    //   43: sipush #501
    //   46: if_icmpeq -> 835
    //   49: iload_1
    //   50: sipush #502
    //   53: if_icmpeq -> 906
    //   56: iload_1
    //   57: tableswitch default -> 88, 510 -> 557, 511 -> 373, 512 -> 276, 513 -> 91
    //   88: goto -> 1305
    //   91: aload_3
    //   92: ifnull -> 1305
    //   95: aload_0
    //   96: aload_3
    //   97: ldc_w 'health_result'
    //   100: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   103: putfield aH : Ljava/lang/String;
    //   106: aload_0
    //   107: aload_3
    //   108: ldc_w 'health_time'
    //   111: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   114: putfield aI : Ljava/lang/String;
    //   117: aload_0
    //   118: aload_3
    //   119: ldc_w 'health_prep'
    //   122: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   125: putfield aJ : Ljava/lang/String;
    //   128: aload_0
    //   129: aload_3
    //   130: ldc_w 'health_result_name'
    //   133: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   136: aload_3
    //   137: ldc_w 'health_time_name'
    //   140: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   143: aload_3
    //   144: ldc_w 'health_prep_name'
    //   147: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   150: invokespecial b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   153: new java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial <init> : ()V
    //   160: astore #5
    //   162: aload #5
    //   164: ldc_w 'onActivityResult unSaveHealthResult:'
    //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload #5
    //   173: aload_0
    //   174: getfield aH : Ljava/lang/String;
    //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: ldc_w 'drb'
    //   184: aload #5
    //   186: invokevirtual toString : ()Ljava/lang/String;
    //   189: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   192: pop
    //   193: new java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial <init> : ()V
    //   200: astore #5
    //   202: aload #5
    //   204: ldc_w 'onActivityResult unSaveHealthTime:'
    //   207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload #5
    //   213: aload_0
    //   214: getfield aI : Ljava/lang/String;
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: ldc_w 'drb'
    //   224: aload #5
    //   226: invokevirtual toString : ()Ljava/lang/String;
    //   229: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   232: pop
    //   233: new java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial <init> : ()V
    //   240: astore #5
    //   242: aload #5
    //   244: ldc_w 'onActivityResult unSaveHealthPrep:'
    //   247: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload #5
    //   253: aload_0
    //   254: getfield aJ : Ljava/lang/String;
    //   257: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: ldc_w 'drb'
    //   264: aload #5
    //   266: invokevirtual toString : ()Ljava/lang/String;
    //   269: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   272: pop
    //   273: goto -> 1305
    //   276: aload_3
    //   277: ifnull -> 1305
    //   280: aload_3
    //   281: ldc_w 'background_photo'
    //   284: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   287: astore #5
    //   289: aload_3
    //   290: ldc_w 'background_photo_auditing'
    //   293: iconst_0
    //   294: invokevirtual getIntExtra : (Ljava/lang/String;I)I
    //   297: istore #4
    //   299: aload_0
    //   300: aload #5
    //   302: putfield aW : Ljava/lang/String;
    //   305: aload #5
    //   307: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   310: ifne -> 355
    //   313: iload #4
    //   315: iconst_1
    //   316: if_icmpne -> 337
    //   319: aload_0
    //   320: iconst_1
    //   321: putfield aX : I
    //   324: aload_0
    //   325: getfield E : Landroid/widget/TextView;
    //   328: ldc_w 2131758467
    //   331: invokevirtual setText : (I)V
    //   334: goto -> 1305
    //   337: aload_0
    //   338: iconst_2
    //   339: putfield aX : I
    //   342: aload_0
    //   343: getfield E : Landroid/widget/TextView;
    //   346: ldc_w 2131758471
    //   349: invokevirtual setText : (I)V
    //   352: goto -> 1305
    //   355: aload_0
    //   356: iconst_0
    //   357: putfield aX : I
    //   360: aload_0
    //   361: getfield E : Landroid/widget/TextView;
    //   364: ldc_w 2131758469
    //   367: invokevirtual setText : (I)V
    //   370: goto -> 1305
    //   373: aload_3
    //   374: ifnull -> 1305
    //   377: aload_0
    //   378: aload_3
    //   379: ldc_w 'choosed_like_list'
    //   382: invokevirtual getStringArrayListExtra : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   385: putfield aG : Ljava/util/ArrayList;
    //   388: aload_0
    //   389: getfield aG : Ljava/util/ArrayList;
    //   392: invokevirtual iterator : ()Ljava/util/Iterator;
    //   395: astore #5
    //   397: aload #5
    //   399: invokeinterface hasNext : ()Z
    //   404: ifeq -> 460
    //   407: aload #5
    //   409: invokeinterface next : ()Ljava/lang/Object;
    //   414: checkcast java/lang/String
    //   417: astore #6
    //   419: new java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial <init> : ()V
    //   426: astore #7
    //   428: aload #7
    //   430: ldc_w '返回我喜欢的标签：'
    //   433: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload #7
    //   439: aload #6
    //   441: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: ldc_w 'drb'
    //   448: aload #7
    //   450: invokevirtual toString : ()Ljava/lang/String;
    //   453: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   456: pop
    //   457: goto -> 397
    //   460: aload_3
    //   461: ldc_w 'choosed_like_shape_list_name'
    //   464: invokevirtual getStringArrayListExtra : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   467: astore #5
    //   469: aload #5
    //   471: ifnull -> 498
    //   474: aload #5
    //   476: invokevirtual size : ()I
    //   479: ifle -> 498
    //   482: aload_0
    //   483: getfield C : Landroid/widget/TextView;
    //   486: aload_0
    //   487: aload #5
    //   489: invokespecial a : (Ljava/util/ArrayList;)Ljava/lang/String;
    //   492: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   495: goto -> 507
    //   498: aload_0
    //   499: getfield C : Landroid/widget/TextView;
    //   502: ldc ''
    //   504: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   507: aload_3
    //   508: ldc_w 'choosed_like_personality_list_name'
    //   511: invokevirtual getStringArrayListExtra : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   514: astore #5
    //   516: aload #5
    //   518: ifnull -> 545
    //   521: aload #5
    //   523: invokevirtual size : ()I
    //   526: ifle -> 545
    //   529: aload_0
    //   530: getfield D : Landroid/widget/TextView;
    //   533: aload_0
    //   534: aload #5
    //   536: invokespecial a : (Ljava/util/ArrayList;)Ljava/lang/String;
    //   539: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   542: goto -> 1305
    //   545: aload_0
    //   546: getfield D : Landroid/widget/TextView;
    //   549: ldc ''
    //   551: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   554: goto -> 1305
    //   557: aload_3
    //   558: ifnull -> 1305
    //   561: aload_0
    //   562: aload_3
    //   563: ldc_w 'choosed_label_list'
    //   566: invokevirtual getStringArrayListExtra : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   569: putfield aE : Ljava/util/ArrayList;
    //   572: aload_0
    //   573: getfield aE : Ljava/util/ArrayList;
    //   576: invokevirtual iterator : ()Ljava/util/Iterator;
    //   579: astore #5
    //   581: aload #5
    //   583: invokeinterface hasNext : ()Z
    //   588: ifeq -> 644
    //   591: aload #5
    //   593: invokeinterface next : ()Ljava/lang/Object;
    //   598: checkcast java/lang/String
    //   601: astore #6
    //   603: new java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial <init> : ()V
    //   610: astore #7
    //   612: aload #7
    //   614: ldc_w '返回我的标签：'
    //   617: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: aload #7
    //   623: aload #6
    //   625: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: ldc_w 'drb'
    //   632: aload #7
    //   634: invokevirtual toString : ()Ljava/lang/String;
    //   637: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   640: pop
    //   641: goto -> 581
    //   644: aload_3
    //   645: ldc_w 'choosed_shape_list_name'
    //   648: invokevirtual getStringArrayListExtra : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   651: astore #5
    //   653: aload #5
    //   655: ifnull -> 682
    //   658: aload #5
    //   660: invokevirtual size : ()I
    //   663: ifle -> 682
    //   666: aload_0
    //   667: getfield y : Landroid/widget/TextView;
    //   670: aload_0
    //   671: aload #5
    //   673: invokespecial a : (Ljava/util/ArrayList;)Ljava/lang/String;
    //   676: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   679: goto -> 691
    //   682: aload_0
    //   683: getfield y : Landroid/widget/TextView;
    //   686: ldc ''
    //   688: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   691: aload_3
    //   692: ldc_w 'choosed_personality_list_name'
    //   695: invokevirtual getStringArrayListExtra : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   698: astore #5
    //   700: aload #5
    //   702: ifnull -> 729
    //   705: aload #5
    //   707: invokevirtual size : ()I
    //   710: ifle -> 729
    //   713: aload_0
    //   714: getfield z : Landroid/widget/TextView;
    //   717: aload_0
    //   718: aload #5
    //   720: invokespecial a : (Ljava/util/ArrayList;)Ljava/lang/String;
    //   723: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   726: goto -> 738
    //   729: aload_0
    //   730: getfield z : Landroid/widget/TextView;
    //   733: ldc ''
    //   735: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   738: aload_3
    //   739: ldc_w 'choosed_hobby_list_name'
    //   742: invokevirtual getStringArrayListExtra : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   745: astore #5
    //   747: aload #5
    //   749: ifnull -> 776
    //   752: aload #5
    //   754: invokevirtual size : ()I
    //   757: ifle -> 776
    //   760: aload_0
    //   761: getfield A : Landroid/widget/TextView;
    //   764: aload_0
    //   765: aload #5
    //   767: invokespecial a : (Ljava/util/ArrayList;)Ljava/lang/String;
    //   770: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   773: goto -> 785
    //   776: aload_0
    //   777: getfield A : Landroid/widget/TextView;
    //   780: ldc ''
    //   782: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   785: aload_3
    //   786: ldc_w 'choosed_douban_list_name'
    //   789: invokevirtual getStringArrayListExtra : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   792: astore #5
    //   794: aload #5
    //   796: ifnull -> 823
    //   799: aload #5
    //   801: invokevirtual size : ()I
    //   804: ifle -> 823
    //   807: aload_0
    //   808: getfield B : Landroid/widget/TextView;
    //   811: aload_0
    //   812: aload #5
    //   814: invokespecial a : (Ljava/util/ArrayList;)Ljava/lang/String;
    //   817: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   820: goto -> 1305
    //   823: aload_0
    //   824: getfield B : Landroid/widget/TextView;
    //   827: ldc ''
    //   829: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   832: goto -> 1305
    //   835: aload_3
    //   836: ifnull -> 906
    //   839: aload_0
    //   840: aload_3
    //   841: ldc_w 'CHOOSED_TAG_LIST'
    //   844: invokevirtual getStringArrayListExtra : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   847: putfield aw : Ljava/util/ArrayList;
    //   850: aload_0
    //   851: getfield aw : Ljava/util/ArrayList;
    //   854: astore #5
    //   856: aload #5
    //   858: ifnull -> 889
    //   861: aload #5
    //   863: invokevirtual size : ()I
    //   866: ifle -> 889
    //   869: aload_0
    //   870: getfield u : Landroid/widget/TextView;
    //   873: aload_0
    //   874: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   877: ldc_w 2131756099
    //   880: invokevirtual getString : (I)Ljava/lang/String;
    //   883: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   886: goto -> 906
    //   889: aload_0
    //   890: getfield u : Landroid/widget/TextView;
    //   893: aload_0
    //   894: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   897: ldc_w 2131759098
    //   900: invokevirtual getString : (I)Ljava/lang/String;
    //   903: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   906: aload_3
    //   907: ifnull -> 1305
    //   910: aload_0
    //   911: aload_3
    //   912: ldc_w 'choosed_make_friends_list'
    //   915: invokevirtual getStringArrayListExtra : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   918: putfield aA : Ljava/util/ArrayList;
    //   921: aload_3
    //   922: ldc_w 'CHOOSED_MAKE_FRIENDS_LIST_NAME'
    //   925: invokevirtual getStringArrayListExtra : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   928: astore #5
    //   930: aload #5
    //   932: ifnull -> 959
    //   935: aload #5
    //   937: invokevirtual size : ()I
    //   940: ifle -> 959
    //   943: aload_0
    //   944: getfield w : Landroid/widget/TextView;
    //   947: aload_0
    //   948: aload #5
    //   950: invokespecial a : (Ljava/util/ArrayList;)Ljava/lang/String;
    //   953: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   956: goto -> 1305
    //   959: aload_0
    //   960: getfield w : Landroid/widget/TextView;
    //   963: ldc ''
    //   965: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   968: goto -> 1305
    //   971: aload_3
    //   972: ifnull -> 1305
    //   975: aload_3
    //   976: ldc_w 'photo_path'
    //   979: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   982: astore #5
    //   984: aload #5
    //   986: invokestatic e : (Ljava/lang/String;)Z
    //   989: ifne -> 1305
    //   992: aload_0
    //   993: aload #5
    //   995: invokespecial c : (Ljava/lang/String;)V
    //   998: goto -> 1305
    //   1001: aload_3
    //   1002: ifnull -> 1305
    //   1005: aload_3
    //   1006: ldc_w 'photo_path'
    //   1009: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   1012: astore #5
    //   1014: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
    //   1017: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   1020: invokevirtual getAvatar_pid : ()Ljava/lang/String;
    //   1023: astore #6
    //   1025: aload #6
    //   1027: invokestatic e : (Ljava/lang/String;)Z
    //   1030: ifne -> 1128
    //   1033: aload #5
    //   1035: invokestatic e : (Ljava/lang/String;)Z
    //   1038: ifne -> 1128
    //   1041: aload_0
    //   1042: aload #5
    //   1044: aload #6
    //   1046: invokespecial a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1049: invokestatic bV : ()Z
    //   1052: ifeq -> 1305
    //   1055: invokestatic bW : ()V
    //   1058: aload_0
    //   1059: getfield f : Landroid/content/Context;
    //   1062: ldc_w 2131231380
    //   1065: aload_0
    //   1066: ldc_w 2131758988
    //   1069: invokevirtual getString : (I)Ljava/lang/String;
    //   1072: aload_0
    //   1073: ldc_w 2131758991
    //   1076: invokevirtual getString : (I)Ljava/lang/String;
    //   1079: aload_0
    //   1080: ldc_w 2131758990
    //   1083: invokevirtual getString : (I)Ljava/lang/String;
    //   1086: new com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment$22
    //   1089: dup
    //   1090: aload_0
    //   1091: invokespecial <init> : (Lcom/soft/blued/ui/setting/fragment/ModifyUserInfoFragment;)V
    //   1094: aload_0
    //   1095: ldc_w 2131758989
    //   1098: invokevirtual getString : (I)Ljava/lang/String;
    //   1101: aconst_null
    //   1102: aconst_null
    //   1103: iconst_3
    //   1104: invokestatic a : (Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnDismissListener;I)Lcom/soft/blued/view/tip/dialog/BluedAlertDialog;
    //   1107: astore #5
    //   1109: aload #5
    //   1111: ldc_w 182.0
    //   1114: invokevirtual a : (F)V
    //   1117: aload #5
    //   1119: ldc_w 2131232392
    //   1122: invokevirtual a : (I)V
    //   1125: goto -> 1305
    //   1128: aload_0
    //   1129: aload #5
    //   1131: ldc ''
    //   1133: invokespecial a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1136: goto -> 1305
    //   1139: aload_3
    //   1140: ifnull -> 1305
    //   1143: aload_0
    //   1144: aload_3
    //   1145: ldc_w 'choosed_job_list'
    //   1148: invokevirtual getStringArrayListExtra : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   1151: putfield aC : Ljava/util/ArrayList;
    //   1154: aload_3
    //   1155: ldc_w 'choosed_job_list_name'
    //   1158: invokevirtual getStringArrayListExtra : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   1161: astore #5
    //   1163: aload #5
    //   1165: ifnull -> 1192
    //   1168: aload #5
    //   1170: invokevirtual size : ()I
    //   1173: ifle -> 1192
    //   1176: aload_0
    //   1177: getfield x : Landroid/widget/TextView;
    //   1180: aload_0
    //   1181: aload #5
    //   1183: invokespecial a : (Ljava/util/ArrayList;)Ljava/lang/String;
    //   1186: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   1189: goto -> 1305
    //   1192: aload_0
    //   1193: getfield x : Landroid/widget/TextView;
    //   1196: ldc ''
    //   1198: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   1201: goto -> 1305
    //   1204: aload_3
    //   1205: ifnull -> 1305
    //   1208: aload_3
    //   1209: ldc_w 'photo_path'
    //   1212: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   1215: astore #5
    //   1217: aload_0
    //   1218: getfield ax : Lcom/soft/blued/model/BluedAlbum;
    //   1221: ifnull -> 1305
    //   1224: aload #5
    //   1226: invokestatic e : (Ljava/lang/String;)Z
    //   1229: ifne -> 1305
    //   1232: aload_0
    //   1233: aload #5
    //   1235: aload_0
    //   1236: getfield ax : Lcom/soft/blued/model/BluedAlbum;
    //   1239: invokevirtual getPid : ()Ljava/lang/String;
    //   1242: aload_0
    //   1243: getfield ax : Lcom/soft/blued/model/BluedAlbum;
    //   1246: getfield position : I
    //   1249: invokespecial a : (Ljava/lang/String;Ljava/lang/String;I)V
    //   1252: goto -> 1305
    //   1255: aload_0
    //   1256: aload_3
    //   1257: ldc_w 'areacode'
    //   1260: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   1263: putfield at : Ljava/lang/String;
    //   1266: aload_0
    //   1267: getfield s : Landroid/widget/TextView;
    //   1270: aload_0
    //   1271: getfield at : Ljava/lang/String;
    //   1274: invokestatic c : ()Ljava/util/Locale;
    //   1277: iconst_1
    //   1278: invokestatic a : (Ljava/lang/String;Ljava/util/Locale;Z)Ljava/lang/String;
    //   1281: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   1284: goto -> 1305
    //   1287: aload_3
    //   1288: ldc_w 'string_edit'
    //   1291: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   1294: astore #5
    //   1296: aload_0
    //   1297: getfield l : Landroid/widget/TextView;
    //   1300: aload #5
    //   1302: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   1305: aload_0
    //   1306: iload_1
    //   1307: iload_2
    //   1308: aload_3
    //   1309: invokespecial onActivityResult : (IILandroid/content/Intent;)V
    //   1312: return
  }
  
  public void onClick(View paramView) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getId : ()I
    //   4: lookupswitch default -> 216, 2131296863 -> 1546, 2131296867 -> 1540, 2131298722 -> 1231, 2131298725 -> 1196, 2131298772 -> 1094, 2131298782 -> 1062, 2131298789 -> 1027, 2131298870 -> 1022, 2131298874 -> 936, 2131298875 -> 931, 2131298884 -> 899, 2131298885 -> 893, 2131298903 -> 863, 2131298912 -> 831, 2131298913 -> 730, 2131298941 -> 700, 2131298969 -> 668, 2131298970 -> 567, 2131298974 -> 482, 2131299024 -> 470, 2131299048 -> 435, 2131299064 -> 400, 2131299095 -> 370, 2131299137 -> 280, 2131300261 -> 217
    //   216: return
    //   217: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
    //   220: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   223: getfield vip_grade : I
    //   226: ifne -> 272
    //   229: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   232: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   235: getfield is_show_vip_page : I
    //   238: ifne -> 272
    //   241: aload_0
    //   242: getfield j : Landroid/widget/ToggleButton;
    //   245: iconst_0
    //   246: invokevirtual setChecked : (Z)V
    //   249: aload_0
    //   250: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   253: iconst_5
    //   254: ldc_w 'vip_user_page'
    //   257: invokestatic a : (Landroid/content/Context;ILjava/lang/String;)V
    //   260: ldc_w 'modify_vip_page_click'
    //   263: iconst_0
    //   264: invokestatic a : (Ljava/lang/String;I)V
    //   267: iconst_0
    //   268: invokestatic a : (Z)V
    //   271: return
    //   272: ldc_w 'modify_vip_page_click'
    //   275: iconst_1
    //   276: invokestatic a : (Ljava/lang/String;I)V
    //   279: return
    //   280: aload_0
    //   281: getfield aX : I
    //   284: istore_2
    //   285: iload_2
    //   286: ifeq -> 316
    //   289: iload_2
    //   290: iconst_1
    //   291: if_icmpeq -> 300
    //   294: iload_2
    //   295: iconst_2
    //   296: if_icmpeq -> 300
    //   299: return
    //   300: aload_0
    //   301: aload_0
    //   302: getfield aX : I
    //   305: aload_0
    //   306: getfield aW : Ljava/lang/String;
    //   309: sipush #512
    //   312: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;ILjava/lang/String;I)V
    //   315: return
    //   316: getstatic com/blued/das/profile/PersonalProfileProtos$Event.PERSONAL_EDIT_BACKGROUND_UPLOAD_CLICK : Lcom/blued/das/profile/PersonalProfileProtos$Event;
    //   319: invokestatic a : (Lcom/blued/das/profile/PersonalProfileProtos$Event;)V
    //   322: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
    //   325: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   328: getfield vip_grade : I
    //   331: ifne -> 358
    //   334: invokestatic b : ()Lcom/soft/blued/user/BluedConfig;
    //   337: invokevirtual j : ()Lcom/soft/blued/ui/login_register/model/AppConfigModel$VIPRight;
    //   340: getfield is_show_vip_page : I
    //   343: ifne -> 358
    //   346: aload_0
    //   347: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   350: iconst_5
    //   351: ldc_w 'personal_background_upload'
    //   354: invokestatic a : (Landroid/content/Context;ILjava/lang/String;)V
    //   357: return
    //   358: new com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment$8
    //   361: dup
    //   362: aload_0
    //   363: invokespecial <init> : (Lcom/soft/blued/ui/setting/fragment/ModifyUserInfoFragment;)V
    //   366: invokestatic e : (Lcom/blued/android/framework/permission/PermissionCallbacks;)V
    //   369: return
    //   370: aload_0
    //   371: getfield aw : Ljava/util/ArrayList;
    //   374: astore_1
    //   375: aload_1
    //   376: ifnull -> 388
    //   379: aload_0
    //   380: aload_1
    //   381: sipush #501
    //   384: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;Ljava/util/ArrayList;I)V
    //   387: return
    //   388: aload_0
    //   389: aload_0
    //   390: getfield av : Ljava/util/ArrayList;
    //   393: sipush #501
    //   396: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;Ljava/util/ArrayList;I)V
    //   399: return
    //   400: aload_0
    //   401: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   404: ldc_w 2130903108
    //   407: invokevirtual getStringArray : (I)[Ljava/lang/String;
    //   410: astore_1
    //   411: aload_0
    //   412: getfield f : Landroid/content/Context;
    //   415: aload_0
    //   416: ldc_w 2131758631
    //   419: invokevirtual getString : (I)Ljava/lang/String;
    //   422: aload_1
    //   423: new com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment$6
    //   426: dup
    //   427: aload_0
    //   428: invokespecial <init> : (Lcom/soft/blued/ui/setting/fragment/ModifyUserInfoFragment;)V
    //   431: invokestatic a : (Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Lcom/soft/blued/view/tip/CommonAlertDialog$TextOnClickListener;)V
    //   434: return
    //   435: aload_0
    //   436: getfield f : Landroid/content/Context;
    //   439: invokestatic c : ()Ljava/util/Locale;
    //   442: invokestatic a : (Landroid/content/Context;Ljava/util/Locale;)[Ljava/lang/String;
    //   445: astore_1
    //   446: aload_0
    //   447: getfield f : Landroid/content/Context;
    //   450: aload_0
    //   451: ldc_w 2131758553
    //   454: invokevirtual getString : (I)Ljava/lang/String;
    //   457: aload_1
    //   458: new com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment$7
    //   461: dup
    //   462: aload_0
    //   463: invokespecial <init> : (Lcom/soft/blued/ui/setting/fragment/ModifyUserInfoFragment;)V
    //   466: invokestatic a : (Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Lcom/soft/blued/view/tip/CommonAlertDialog$TextOnClickListener;)V
    //   469: return
    //   470: aload_0
    //   471: getfield f : Landroid/content/Context;
    //   474: ldc_w com/soft/blued/ui/setting/fragment/PrivacyPhotoAlbumFragment
    //   477: aconst_null
    //   478: invokestatic d : (Landroid/content/Context;Ljava/lang/Class;Landroid/os/Bundle;)V
    //   481: return
    //   482: ldc_w 'ljx_nickname'
    //   485: iconst_1
    //   486: anewarray java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
    //   494: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   497: getfield nickname_limit : Ljava/lang/String;
    //   500: aastore
    //   501: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   504: aload_0
    //   505: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   508: astore_1
    //   509: new java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial <init> : ()V
    //   516: astore #7
    //   518: aload #7
    //   520: aload_0
    //   521: getfield k : Landroid/widget/TextView;
    //   524: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   527: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload #7
    //   533: ldc ''
    //   535: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload_1
    //   540: aload #7
    //   542: invokevirtual toString : ()Ljava/lang/String;
    //   545: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
    //   548: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   551: getfield nickname_limit : Ljava/lang/String;
    //   554: new com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment$2
    //   557: dup
    //   558: aload_0
    //   559: invokespecial <init> : (Lcom/soft/blued/ui/setting/fragment/ModifyUserInfoFragment;)V
    //   562: aconst_null
    //   563: invokestatic a : (Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/soft/blued/view/tip/CommonAlertDialog$TextOnClickListener;Landroid/content/DialogInterface$OnClickListener;)V
    //   566: return
    //   567: aload_0
    //   568: getfield aE : Ljava/util/ArrayList;
    //   571: astore_1
    //   572: aload_1
    //   573: ifnull -> 655
    //   576: aload_1
    //   577: invokevirtual iterator : ()Ljava/util/Iterator;
    //   580: astore_1
    //   581: aload_1
    //   582: invokeinterface hasNext : ()Z
    //   587: ifeq -> 642
    //   590: aload_1
    //   591: invokeinterface next : ()Ljava/lang/Object;
    //   596: checkcast java/lang/String
    //   599: astore #7
    //   601: new java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial <init> : ()V
    //   608: astore #8
    //   610: aload #8
    //   612: ldc_w '跳转时标签：'
    //   615: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload #8
    //   621: aload #7
    //   623: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: pop
    //   627: ldc_w 'drb'
    //   630: aload #8
    //   632: invokevirtual toString : ()Ljava/lang/String;
    //   635: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   638: pop
    //   639: goto -> 581
    //   642: aload_0
    //   643: iconst_0
    //   644: aload_0
    //   645: getfield aE : Ljava/util/ArrayList;
    //   648: sipush #510
    //   651: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;ILjava/util/ArrayList;I)V
    //   654: return
    //   655: aload_0
    //   656: iconst_0
    //   657: aload_0
    //   658: getfield aD : Ljava/util/ArrayList;
    //   661: sipush #510
    //   664: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;ILjava/util/ArrayList;I)V
    //   667: return
    //   668: aload_0
    //   669: getfield aE : Ljava/util/ArrayList;
    //   672: astore_1
    //   673: aload_1
    //   674: ifnull -> 687
    //   677: aload_0
    //   678: iconst_1
    //   679: aload_1
    //   680: sipush #510
    //   683: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;ILjava/util/ArrayList;I)V
    //   686: return
    //   687: aload_0
    //   688: iconst_1
    //   689: aload_0
    //   690: getfield aD : Ljava/util/ArrayList;
    //   693: sipush #510
    //   696: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;ILjava/util/ArrayList;I)V
    //   699: return
    //   700: aload_0
    //   701: getfield aA : Ljava/util/ArrayList;
    //   704: astore_1
    //   705: aload_1
    //   706: ifnull -> 718
    //   709: aload_0
    //   710: aload_1
    //   711: sipush #502
    //   714: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;Ljava/util/ArrayList;I)V
    //   717: return
    //   718: aload_0
    //   719: aload_0
    //   720: getfield az : Ljava/util/ArrayList;
    //   723: sipush #502
    //   726: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;Ljava/util/ArrayList;I)V
    //   729: return
    //   730: aload_0
    //   731: getfield aG : Ljava/util/ArrayList;
    //   734: astore_1
    //   735: aload_1
    //   736: ifnull -> 818
    //   739: aload_1
    //   740: invokevirtual iterator : ()Ljava/util/Iterator;
    //   743: astore_1
    //   744: aload_1
    //   745: invokeinterface hasNext : ()Z
    //   750: ifeq -> 805
    //   753: aload_1
    //   754: invokeinterface next : ()Ljava/lang/Object;
    //   759: checkcast java/lang/String
    //   762: astore #7
    //   764: new java/lang/StringBuilder
    //   767: dup
    //   768: invokespecial <init> : ()V
    //   771: astore #8
    //   773: aload #8
    //   775: ldc_w '跳转时标签：'
    //   778: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: pop
    //   782: aload #8
    //   784: aload #7
    //   786: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: ldc_w 'drb'
    //   793: aload #8
    //   795: invokevirtual toString : ()Ljava/lang/String;
    //   798: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   801: pop
    //   802: goto -> 744
    //   805: aload_0
    //   806: iconst_0
    //   807: aload_0
    //   808: getfield aG : Ljava/util/ArrayList;
    //   811: sipush #511
    //   814: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;ILjava/util/ArrayList;I)V
    //   817: return
    //   818: aload_0
    //   819: iconst_0
    //   820: aload_0
    //   821: getfield aF : Ljava/util/ArrayList;
    //   824: sipush #511
    //   827: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;ILjava/util/ArrayList;I)V
    //   830: return
    //   831: aload_0
    //   832: getfield aG : Ljava/util/ArrayList;
    //   835: astore_1
    //   836: aload_1
    //   837: ifnull -> 850
    //   840: aload_0
    //   841: iconst_1
    //   842: aload_1
    //   843: sipush #511
    //   846: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;ILjava/util/ArrayList;I)V
    //   849: return
    //   850: aload_0
    //   851: iconst_1
    //   852: aload_0
    //   853: getfield aF : Ljava/util/ArrayList;
    //   856: sipush #511
    //   859: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;ILjava/util/ArrayList;I)V
    //   862: return
    //   863: aload_0
    //   864: getfield aC : Ljava/util/ArrayList;
    //   867: astore_1
    //   868: aload_1
    //   869: ifnull -> 881
    //   872: aload_0
    //   873: aload_1
    //   874: sipush #507
    //   877: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;Ljava/util/ArrayList;I)V
    //   880: return
    //   881: aload_0
    //   882: aload_0
    //   883: getfield aB : Ljava/util/ArrayList;
    //   886: sipush #507
    //   889: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;Ljava/util/ArrayList;I)V
    //   892: return
    //   893: aload_0
    //   894: iconst_4
    //   895: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;I)V
    //   898: return
    //   899: aload_0
    //   900: getfield aE : Ljava/util/ArrayList;
    //   903: astore_1
    //   904: aload_1
    //   905: ifnull -> 918
    //   908: aload_0
    //   909: iconst_2
    //   910: aload_1
    //   911: sipush #510
    //   914: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;ILjava/util/ArrayList;I)V
    //   917: return
    //   918: aload_0
    //   919: iconst_2
    //   920: aload_0
    //   921: getfield aD : Ljava/util/ArrayList;
    //   924: sipush #510
    //   927: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;ILjava/util/ArrayList;I)V
    //   930: return
    //   931: aload_0
    //   932: invokespecial y : ()V
    //   935: return
    //   936: aload_0
    //   937: getfield aH : Ljava/lang/String;
    //   940: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   943: ifne -> 954
    //   946: aload_0
    //   947: getfield aH : Ljava/lang/String;
    //   950: astore_1
    //   951: goto -> 959
    //   954: aload_0
    //   955: getfield aK : Ljava/lang/String;
    //   958: astore_1
    //   959: aload_0
    //   960: getfield aI : Ljava/lang/String;
    //   963: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   966: ifne -> 978
    //   969: aload_0
    //   970: getfield aI : Ljava/lang/String;
    //   973: astore #7
    //   975: goto -> 984
    //   978: aload_0
    //   979: getfield aL : Ljava/lang/String;
    //   982: astore #7
    //   984: aload_0
    //   985: getfield aJ : Ljava/lang/String;
    //   988: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   991: ifne -> 1003
    //   994: aload_0
    //   995: getfield aJ : Ljava/lang/String;
    //   998: astore #8
    //   1000: goto -> 1009
    //   1003: aload_0
    //   1004: getfield aM : Ljava/lang/String;
    //   1007: astore #8
    //   1009: aload_0
    //   1010: aload_1
    //   1011: aload #7
    //   1013: aload #8
    //   1015: sipush #513
    //   1018: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   1021: return
    //   1022: aload_0
    //   1023: invokespecial q : ()V
    //   1026: return
    //   1027: aload_0
    //   1028: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1031: ldc_w 2130903100
    //   1034: invokevirtual getStringArray : (I)[Ljava/lang/String;
    //   1037: astore_1
    //   1038: aload_0
    //   1039: getfield f : Landroid/content/Context;
    //   1042: aload_0
    //   1043: ldc_w 2131758521
    //   1046: invokevirtual getString : (I)Ljava/lang/String;
    //   1049: aload_1
    //   1050: new com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment$5
    //   1053: dup
    //   1054: aload_0
    //   1055: invokespecial <init> : (Lcom/soft/blued/ui/setting/fragment/ModifyUserInfoFragment;)V
    //   1058: invokestatic a : (Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Lcom/soft/blued/view/tip/CommonAlertDialog$TextOnClickListener;)V
    //   1061: return
    //   1062: aload_0
    //   1063: getfield aE : Ljava/util/ArrayList;
    //   1066: astore_1
    //   1067: aload_1
    //   1068: ifnull -> 1081
    //   1071: aload_0
    //   1072: iconst_3
    //   1073: aload_1
    //   1074: sipush #510
    //   1077: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;ILjava/util/ArrayList;I)V
    //   1080: return
    //   1081: aload_0
    //   1082: iconst_3
    //   1083: aload_0
    //   1084: getfield aD : Ljava/util/ArrayList;
    //   1087: sipush #510
    //   1090: invokestatic a : (Lcom/blued/android/core/ui/BaseFragment;ILjava/util/ArrayList;I)V
    //   1093: return
    //   1094: new android/os/Bundle
    //   1097: dup
    //   1098: invokespecial <init> : ()V
    //   1101: astore_1
    //   1102: aload_1
    //   1103: ldc_w 'max_count'
    //   1106: aload_0
    //   1107: ldc_w 2131758291
    //   1110: invokevirtual getString : (I)Ljava/lang/String;
    //   1113: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1116: aload_1
    //   1117: ldc_w 'string_edit_hint'
    //   1120: aload_0
    //   1121: ldc_w 2131757863
    //   1124: invokevirtual getString : (I)Ljava/lang/String;
    //   1127: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1130: new java/lang/StringBuilder
    //   1133: dup
    //   1134: invokespecial <init> : ()V
    //   1137: astore #7
    //   1139: aload #7
    //   1141: aload_0
    //   1142: getfield l : Landroid/widget/TextView;
    //   1145: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   1148: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1151: pop
    //   1152: aload #7
    //   1154: ldc ''
    //   1156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: pop
    //   1160: aload_1
    //   1161: ldc_w 'string_edit'
    //   1164: aload #7
    //   1166: invokevirtual toString : ()Ljava/lang/String;
    //   1169: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1172: aload_1
    //   1173: ldc_w 'string_center'
    //   1176: aload_0
    //   1177: ldc_w 2131758155
    //   1180: invokevirtual getString : (I)Ljava/lang/String;
    //   1183: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1186: aload_0
    //   1187: ldc_w com/soft/blued/fragment/CommonWriteTextFragment
    //   1190: aload_1
    //   1191: iconst_2
    //   1192: invokestatic a : (Landroidx/fragment/app/Fragment;Ljava/lang/Class;Landroid/os/Bundle;I)V
    //   1195: return
    //   1196: aload_0
    //   1197: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1200: ldc_w 2130903047
    //   1203: invokevirtual getStringArray : (I)[Ljava/lang/String;
    //   1206: astore_1
    //   1207: aload_0
    //   1208: getfield f : Landroid/content/Context;
    //   1211: aload_0
    //   1212: ldc_w 2131755655
    //   1215: invokevirtual getString : (I)Ljava/lang/String;
    //   1218: aload_1
    //   1219: new com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment$4
    //   1222: dup
    //   1223: aload_0
    //   1224: invokespecial <init> : (Lcom/soft/blued/ui/setting/fragment/ModifyUserInfoFragment;)V
    //   1227: invokestatic a : (Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Lcom/soft/blued/view/tip/CommonAlertDialog$TextOnClickListener;)V
    //   1230: return
    //   1231: sipush #1994
    //   1234: istore_2
    //   1235: new java/lang/StringBuilder
    //   1238: dup
    //   1239: invokespecial <init> : ()V
    //   1242: astore_1
    //   1243: aload_1
    //   1244: aload_0
    //   1245: getfield m : Landroid/widget/TextView;
    //   1248: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   1251: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1254: pop
    //   1255: aload_1
    //   1256: ldc ''
    //   1258: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: pop
    //   1262: aload_1
    //   1263: invokevirtual toString : ()Ljava/lang/String;
    //   1266: invokestatic e : (Ljava/lang/String;)Z
    //   1269: ifne -> 1494
    //   1272: new java/lang/StringBuilder
    //   1275: dup
    //   1276: invokespecial <init> : ()V
    //   1279: astore_1
    //   1280: aload_1
    //   1281: aload_0
    //   1282: getfield m : Landroid/widget/TextView;
    //   1285: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   1288: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1291: pop
    //   1292: aload_1
    //   1293: ldc ''
    //   1295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: pop
    //   1299: aload_1
    //   1300: invokevirtual toString : ()Ljava/lang/String;
    //   1303: ldc_w '-'
    //   1306: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   1309: astore_1
    //   1310: aload_1
    //   1311: ifnull -> 1494
    //   1314: aload_1
    //   1315: arraylength
    //   1316: iconst_3
    //   1317: if_icmplt -> 1494
    //   1320: iload_2
    //   1321: istore_3
    //   1322: new java/lang/StringBuilder
    //   1325: dup
    //   1326: invokespecial <init> : ()V
    //   1329: astore_1
    //   1330: iload_2
    //   1331: istore_3
    //   1332: aload_1
    //   1333: aload_0
    //   1334: getfield m : Landroid/widget/TextView;
    //   1337: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   1340: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1343: pop
    //   1344: iload_2
    //   1345: istore_3
    //   1346: aload_1
    //   1347: ldc ''
    //   1349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: pop
    //   1353: iload_2
    //   1354: istore_3
    //   1355: aload_1
    //   1356: invokevirtual toString : ()Ljava/lang/String;
    //   1359: ldc_w '-'
    //   1362: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   1365: iconst_0
    //   1366: aaload
    //   1367: invokestatic parseInt : (Ljava/lang/String;)I
    //   1370: istore_2
    //   1371: iload_2
    //   1372: istore_3
    //   1373: new java/lang/StringBuilder
    //   1376: dup
    //   1377: invokespecial <init> : ()V
    //   1380: astore_1
    //   1381: iload_2
    //   1382: istore_3
    //   1383: aload_1
    //   1384: aload_0
    //   1385: getfield m : Landroid/widget/TextView;
    //   1388: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   1391: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1394: pop
    //   1395: iload_2
    //   1396: istore_3
    //   1397: aload_1
    //   1398: ldc ''
    //   1400: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: pop
    //   1404: iload_2
    //   1405: istore_3
    //   1406: aload_1
    //   1407: invokevirtual toString : ()Ljava/lang/String;
    //   1410: ldc_w '-'
    //   1413: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   1416: iconst_1
    //   1417: aaload
    //   1418: invokestatic parseInt : (Ljava/lang/String;)I
    //   1421: istore #4
    //   1423: new java/lang/StringBuilder
    //   1426: dup
    //   1427: invokespecial <init> : ()V
    //   1430: astore_1
    //   1431: aload_1
    //   1432: aload_0
    //   1433: getfield m : Landroid/widget/TextView;
    //   1436: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   1439: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1442: pop
    //   1443: aload_1
    //   1444: ldc ''
    //   1446: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1449: pop
    //   1450: aload_1
    //   1451: invokevirtual toString : ()Ljava/lang/String;
    //   1454: ldc_w '-'
    //   1457: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   1460: iconst_2
    //   1461: aaload
    //   1462: invokestatic parseInt : (Ljava/lang/String;)I
    //   1465: istore_3
    //   1466: iload_2
    //   1467: istore #5
    //   1469: iload_3
    //   1470: istore #6
    //   1472: goto -> 1509
    //   1475: iconst_1
    //   1476: istore #4
    //   1478: iload_3
    //   1479: istore_2
    //   1480: iload #4
    //   1482: istore_3
    //   1483: iload_2
    //   1484: istore #4
    //   1486: iload_3
    //   1487: istore_2
    //   1488: iload #4
    //   1490: istore_3
    //   1491: goto -> 1500
    //   1494: iconst_1
    //   1495: istore_2
    //   1496: sipush #1994
    //   1499: istore_3
    //   1500: iconst_0
    //   1501: istore #6
    //   1503: iload_3
    //   1504: istore #5
    //   1506: iload_2
    //   1507: istore #4
    //   1509: new com/soft/blued/customview/MDatePickerDialog
    //   1512: dup
    //   1513: aload_0
    //   1514: getfield f : Landroid/content/Context;
    //   1517: new com/soft/blued/ui/setting/fragment/ModifyUserInfoFragment$3
    //   1520: dup
    //   1521: aload_0
    //   1522: invokespecial <init> : (Lcom/soft/blued/ui/setting/fragment/ModifyUserInfoFragment;)V
    //   1525: iload #5
    //   1527: iload #4
    //   1529: iconst_1
    //   1530: isub
    //   1531: iload #6
    //   1533: invokespecial <init> : (Landroid/content/Context;Lnet/simonvt/datepicker/DatePickerDialog$OnDateSetListener;III)V
    //   1536: invokevirtual show : ()V
    //   1539: return
    //   1540: aload_0
    //   1541: iconst_0
    //   1542: invokevirtual a : (Z)V
    //   1545: return
    //   1546: aload_0
    //   1547: invokevirtual V_ : ()Z
    //   1550: pop
    //   1551: return
    //   1552: astore_1
    //   1553: goto -> 1475
    //   1556: astore_1
    //   1557: iload #4
    //   1559: istore_3
    //   1560: goto -> 1483
    // Exception table:
    //   from	to	target	type
    //   1322	1330	1552	java/lang/Exception
    //   1332	1344	1552	java/lang/Exception
    //   1346	1353	1552	java/lang/Exception
    //   1355	1371	1552	java/lang/Exception
    //   1373	1381	1552	java/lang/Exception
    //   1383	1395	1552	java/lang/Exception
    //   1397	1404	1552	java/lang/Exception
    //   1406	1423	1552	java/lang/Exception
    //   1423	1466	1556	java/lang/Exception
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493229, paramViewGroup, false);
      if (getArguments() != null) {
        this.au = getArguments().getBoolean("show_avatar_items");
        this.ar = getArguments().getInt("fromPage");
      } 
      ap = getResources().getStringArray(2130903079);
      this.aq = ((this.f.getResources().getDisplayMetrics()).widthPixels - DensityUtils.a(this.f, 66.0F)) / 3;
      o();
      v();
      k();
      w();
      r();
      s();
      if (this.au)
        q(); 
    } else {
      ((ViewGroup)view.getParent()).removeView(this.g);
    } 
    return this.g;
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.ay = true;
    for (int i = 0; i < this.am.size(); i = j + 1) {
      int j = i;
      if (!StringUtils.e(((BluedAlbum)this.am.get(i)).progress)) {
        this.am.remove(i);
        j = i - 1;
      } 
    } 
  }
  
  public void onResume() {
    super.onResume();
    k();
    a();
    UserDragGirdAdapter userDragGirdAdapter = this.an;
    if (userDragGirdAdapter != null)
      userDragGirdAdapter.notifyDataSetChanged(); 
  }
  
  public class UserDragGirdAdapter extends BaseAdapter implements DragGridBaseAdapter {
    private LayoutInflater b;
    
    private ImageView c;
    
    private TextView d;
    
    private TextView e;
    
    private int f = -1;
    
    public UserDragGirdAdapter(ModifyUserInfoFragment this$0, Context param1Context) {
      this.b = LayoutInflater.from(param1Context);
    }
    
    public void a(int param1Int) {
      this.f = param1Int;
      notifyDataSetChanged();
    }
    
    public void a(int param1Int1, int param1Int2) {}
    
    public int getCount() {
      return ModifyUserInfoFragment.r(this.a).size();
    }
    
    public Object getItem(int param1Int) {
      return Integer.valueOf(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      param1View = this.b.inflate(2131493225, null);
      this.d = (TextView)param1View.findViewById(2131301333);
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.d.getLayoutParams();
      layoutParams.height = ModifyUserInfoFragment.E(this.a);
      this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.e = (TextView)param1View.findViewById(2131301198);
      this.c = (ImageView)param1View.findViewById(2131297362);
      layoutParams = (FrameLayout.LayoutParams)this.c.getLayoutParams();
      layoutParams.height = ModifyUserInfoFragment.E(this.a);
      this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      BluedAlbum bluedAlbum = ModifyUserInfoFragment.r(this.a).get(param1Int);
      if (StringUtils.e(bluedAlbum.progress)) {
        this.e.setVisibility(8);
        this.d.setVisibility(8);
      } else {
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.e.setText(bluedAlbum.progress);
      } 
      if (!TextUtils.isEmpty(bluedAlbum.getUrl())) {
        ImageLoader.a((IRequestHost)this.a.w_(), bluedAlbum.getUrl()).a(2131232200).a(this.c);
      } else {
        this.c.setImageResource(2131232200);
      } 
      this.d.setOnClickListener(new View.OnClickListener(this, bluedAlbum, param1Int) {
            public void onClick(View param2View) {
              if ((UserInfo.a().i()).vip_grade == 0 && (BluedConfig.b().j()).is_vip_more_avatar == 0) {
                PayUtils.a((Context)this.c.a.getActivity(), 10, "vip_user_avatar");
                InstantLog.a("modify_vip_multi_avatar_click", 0);
                return;
              } 
              PermissionHelper.e(new PermissionCallbacks(this) {
                    public void a(String[] param3ArrayOfString) {}
                    
                    public void aa_() {
                      InstantLog.a("modify_vip_multi_avatar_click", 1);
                      if (this.a.a.progress.equals(this.a.c.a.getResources().getString(2131756378))) {
                        ModifyUserInfoFragment.a(this.a.c.a, this.a.a);
                        (ModifyUserInfoFragment.F(this.a.c.a)).position = this.a.b;
                        PhotoSelectFragment.a(this.a.c.a, 2, 22);
                      } 
                    }
                  });
            }
          });
      this.e.setOnClickListener(new View.OnClickListener(this, bluedAlbum, param1Int) {
            public void onClick(View param2View) {
              if ((UserInfo.a().i()).vip_grade == 0 && (BluedConfig.b().j()).is_vip_more_avatar == 0) {
                PayUtils.a((Context)this.c.a.getActivity(), 10, "vip_user_avatar");
                InstantLog.a("modify_vip_multi_avatar_click", 0);
                return;
              } 
              InstantLog.a("modify_vip_multi_avatar_click", 1);
              if (this.a.progress.equals(this.c.a.getResources().getString(2131756378))) {
                ModifyUserInfoFragment.a(this.c.a, this.a);
                (ModifyUserInfoFragment.F(this.c.a)).position = this.b;
                PhotoSelectFragment.a(this.c.a, 2, 22);
              } 
            }
          });
      this.c.setOnClickListener(new View.OnClickListener(this, bluedAlbum, param1Int) {
            public void onClick(View param2View) {
              EventTrackSettings.a(SettingsProtos.Event.MINE_EDIT_MORE_PHOTO_BTN_CLICK);
              if ((UserInfo.a().i()).vip_grade == 0 && (BluedConfig.b().j()).is_vip_more_avatar == 0) {
                PayUtils.a((Context)this.c.a.getActivity(), 10, "vip_user_avatar");
                InstantLog.a("modify_vip_multi_avatar_click", 0);
                return;
              } 
              InstantLog.a("modify_vip_multi_avatar_click", 1);
              ModifyUserInfoFragment.a(this.c.a, this.a);
              (ModifyUserInfoFragment.F(this.c.a)).position = this.b;
              if (TextUtils.isEmpty(this.a.getUrl())) {
                PermissionHelper.e(new PermissionCallbacks(this) {
                      public void a(String[] param3ArrayOfString) {}
                      
                      public void aa_() {
                        PhotoSelectFragment.a(this.a.c.a, 2, 22);
                      }
                    });
                return;
              } 
              String[] arrayOfString = this.c.a.getResources().getStringArray(2130903074);
              arrayOfString[0] = this.c.a.getResources().getString(2131755748);
              CommonShowBottomWindow.a((FragmentActivity)ModifyUserInfoFragment.h(this.c.a), arrayOfString, new ActionSheet.ActionSheetListener(this) {
                    public void a(ActionSheet param3ActionSheet, int param3Int) {
                      if (param3Int != 0) {
                        if (param3Int != 1) {
                          if (param3Int != 2)
                            return; 
                          ModifyUserInfoFragment.e(this.a.c.a, this.a.a.getPid());
                          return;
                        } 
                        ArrayList<BluedAlbum> arrayList = new ArrayList();
                        for (BluedAlbum bluedAlbum : ModifyUserInfoFragment.r(this.a.c.a)) {
                          if (bluedAlbum.getPid() != null && StringUtils.e(bluedAlbum.key))
                            arrayList.add(bluedAlbum); 
                        } 
                        String[] arrayOfString1 = new String[arrayList.size()];
                        String[] arrayOfString2 = new String[arrayList.size()];
                        for (param3Int = 0; param3Int < arrayList.size(); param3Int++) {
                          arrayOfString1[param3Int] = ((BluedAlbum)arrayList.get(param3Int)).getUrl();
                          arrayOfString2[param3Int] = ((BluedAlbum)arrayList.get(param3Int)).getPid();
                        } 
                        param3Int = this.a.b;
                        BasePhotoFragment.a(ModifyUserInfoFragment.h(this.a.c.a), arrayOfString1, arrayOfString2, param3Int, 13, UserInfo.a().i().getName(), ModifyUserInfoFragment.i(this.a.c.a));
                        return;
                      } 
                      PermissionHelper.e(new PermissionCallbacks(this) {
                            public void a(String[] param4ArrayOfString) {}
                            
                            public void aa_() {
                              PhotoSelectFragment.a(this.a.a.c.a, 2, 22);
                            }
                          });
                    }
                    
                    public void a(ActionSheet param3ActionSheet, boolean param3Boolean) {}
                  });
            }
          });
      if (param1Int == this.f)
        param1View.setVisibility(4); 
      return param1View;
    }
  }
  
  class null implements View.OnClickListener {
    null(ModifyUserInfoFragment this$0, BluedAlbum param1BluedAlbum, int param1Int) {}
    
    public void onClick(View param1View) {
      if ((UserInfo.a().i()).vip_grade == 0 && (BluedConfig.b().j()).is_vip_more_avatar == 0) {
        PayUtils.a((Context)this.c.a.getActivity(), 10, "vip_user_avatar");
        InstantLog.a("modify_vip_multi_avatar_click", 0);
        return;
      } 
      PermissionHelper.e(new PermissionCallbacks(this) {
            public void a(String[] param3ArrayOfString) {}
            
            public void aa_() {
              InstantLog.a("modify_vip_multi_avatar_click", 1);
              if (this.a.a.progress.equals(this.a.c.a.getResources().getString(2131756378))) {
                ModifyUserInfoFragment.a(this.a.c.a, this.a.a);
                (ModifyUserInfoFragment.F(this.a.c.a)).position = this.a.b;
                PhotoSelectFragment.a(this.a.c.a, 2, 22);
              } 
            }
          });
    }
  }
  
  class null implements PermissionCallbacks {
    public void a(String[] param1ArrayOfString) {}
    
    public void aa_() {
      InstantLog.a("modify_vip_multi_avatar_click", 1);
      if (this.a.a.progress.equals(this.a.c.a.getResources().getString(2131756378))) {
        ModifyUserInfoFragment.a(this.a.c.a, this.a.a);
        (ModifyUserInfoFragment.F(this.a.c.a)).position = this.a.b;
        PhotoSelectFragment.a(this.a.c.a, 2, 22);
      } 
    }
  }
  
  class null implements View.OnClickListener {
    null(ModifyUserInfoFragment this$0, BluedAlbum param1BluedAlbum, int param1Int) {}
    
    public void onClick(View param1View) {
      if ((UserInfo.a().i()).vip_grade == 0 && (BluedConfig.b().j()).is_vip_more_avatar == 0) {
        PayUtils.a((Context)this.c.a.getActivity(), 10, "vip_user_avatar");
        InstantLog.a("modify_vip_multi_avatar_click", 0);
        return;
      } 
      InstantLog.a("modify_vip_multi_avatar_click", 1);
      if (this.a.progress.equals(this.c.a.getResources().getString(2131756378))) {
        ModifyUserInfoFragment.a(this.c.a, this.a);
        (ModifyUserInfoFragment.F(this.c.a)).position = this.b;
        PhotoSelectFragment.a(this.c.a, 2, 22);
      } 
    }
  }
  
  class null implements View.OnClickListener {
    null(ModifyUserInfoFragment this$0, BluedAlbum param1BluedAlbum, int param1Int) {}
    
    public void onClick(View param1View) {
      EventTrackSettings.a(SettingsProtos.Event.MINE_EDIT_MORE_PHOTO_BTN_CLICK);
      if ((UserInfo.a().i()).vip_grade == 0 && (BluedConfig.b().j()).is_vip_more_avatar == 0) {
        PayUtils.a((Context)this.c.a.getActivity(), 10, "vip_user_avatar");
        InstantLog.a("modify_vip_multi_avatar_click", 0);
        return;
      } 
      InstantLog.a("modify_vip_multi_avatar_click", 1);
      ModifyUserInfoFragment.a(this.c.a, this.a);
      (ModifyUserInfoFragment.F(this.c.a)).position = this.b;
      if (TextUtils.isEmpty(this.a.getUrl())) {
        PermissionHelper.e(new PermissionCallbacks(this) {
              public void a(String[] param3ArrayOfString) {}
              
              public void aa_() {
                PhotoSelectFragment.a(this.a.c.a, 2, 22);
              }
            });
        return;
      } 
      String[] arrayOfString = this.c.a.getResources().getStringArray(2130903074);
      arrayOfString[0] = this.c.a.getResources().getString(2131755748);
      CommonShowBottomWindow.a((FragmentActivity)ModifyUserInfoFragment.h(this.c.a), arrayOfString, new ActionSheet.ActionSheetListener(this) {
            public void a(ActionSheet param3ActionSheet, int param3Int) {
              if (param3Int != 0) {
                if (param3Int != 1) {
                  if (param3Int != 2)
                    return; 
                  ModifyUserInfoFragment.e(this.a.c.a, this.a.a.getPid());
                  return;
                } 
                ArrayList<BluedAlbum> arrayList = new ArrayList();
                for (BluedAlbum bluedAlbum : ModifyUserInfoFragment.r(this.a.c.a)) {
                  if (bluedAlbum.getPid() != null && StringUtils.e(bluedAlbum.key))
                    arrayList.add(bluedAlbum); 
                } 
                String[] arrayOfString1 = new String[arrayList.size()];
                String[] arrayOfString2 = new String[arrayList.size()];
                for (param3Int = 0; param3Int < arrayList.size(); param3Int++) {
                  arrayOfString1[param3Int] = ((BluedAlbum)arrayList.get(param3Int)).getUrl();
                  arrayOfString2[param3Int] = ((BluedAlbum)arrayList.get(param3Int)).getPid();
                } 
                param3Int = this.a.b;
                BasePhotoFragment.a(ModifyUserInfoFragment.h(this.a.c.a), arrayOfString1, arrayOfString2, param3Int, 13, UserInfo.a().i().getName(), ModifyUserInfoFragment.i(this.a.c.a));
                return;
              } 
              PermissionHelper.e(new PermissionCallbacks(this) {
                    public void a(String[] param4ArrayOfString) {}
                    
                    public void aa_() {
                      PhotoSelectFragment.a(this.a.a.c.a, 2, 22);
                    }
                  });
            }
            
            public void a(ActionSheet param3ActionSheet, boolean param3Boolean) {}
          });
    }
  }
  
  class null implements PermissionCallbacks {
    public void a(String[] param1ArrayOfString) {}
    
    public void aa_() {
      PhotoSelectFragment.a(this.a.c.a, 2, 22);
    }
  }
  
  class null implements ActionSheet.ActionSheetListener {
    public void a(ActionSheet param1ActionSheet, int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int != 2)
            return; 
          ModifyUserInfoFragment.e(this.a.c.a, this.a.a.getPid());
          return;
        } 
        ArrayList<BluedAlbum> arrayList = new ArrayList();
        for (BluedAlbum bluedAlbum : ModifyUserInfoFragment.r(this.a.c.a)) {
          if (bluedAlbum.getPid() != null && StringUtils.e(bluedAlbum.key))
            arrayList.add(bluedAlbum); 
        } 
        String[] arrayOfString1 = new String[arrayList.size()];
        String[] arrayOfString2 = new String[arrayList.size()];
        for (param1Int = 0; param1Int < arrayList.size(); param1Int++) {
          arrayOfString1[param1Int] = ((BluedAlbum)arrayList.get(param1Int)).getUrl();
          arrayOfString2[param1Int] = ((BluedAlbum)arrayList.get(param1Int)).getPid();
        } 
        param1Int = this.a.b;
        BasePhotoFragment.a(ModifyUserInfoFragment.h(this.a.c.a), arrayOfString1, arrayOfString2, param1Int, 13, UserInfo.a().i().getName(), ModifyUserInfoFragment.i(this.a.c.a));
        return;
      } 
      PermissionHelper.e(new PermissionCallbacks(this) {
            public void a(String[] param4ArrayOfString) {}
            
            public void aa_() {
              PhotoSelectFragment.a(this.a.a.c.a, 2, 22);
            }
          });
    }
    
    public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
  }
  
  class null implements PermissionCallbacks {
    public void a(String[] param1ArrayOfString) {}
    
    public void aa_() {
      PhotoSelectFragment.a(this.a.a.c.a, 2, 22);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\ModifyUserInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */