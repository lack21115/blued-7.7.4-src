package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live.base.view.FlowLayout;
import com.blued.das.profile.PersonalProfileProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.ADConstants;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.customview.bluedad.BluedADConstraintLayout;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.live.view.SwipeAnchorBadge;
import com.soft.blued.ui.msg.event.OpenGiftPackageEvent;
import com.soft.blued.ui.msg.pop.UserGiftDialogFragment;
import com.soft.blued.ui.user.adapter.UserMedalsAdapter;
import com.soft.blued.ui.user.adapter.UserProfileGiftdapter;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.user.model.UserGift;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.BitmapUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserinfoFragmentProfileTab extends BaseFragment {
  private TextView A;
  
  private LinearLayout B;
  
  private LinearLayout C;
  
  private ImageView D;
  
  private ImageView E;
  
  private LinearLayout F;
  
  private RecyclerView G;
  
  private LayoutInflater H;
  
  private ImageView I;
  
  private TextView J;
  
  private UserInfoEntity K;
  
  private boolean L = false;
  
  private boolean M = false;
  
  private LinearLayout N;
  
  private TextView O;
  
  private TextView P;
  
  private TextView Q;
  
  private TextView R;
  
  private TextView S;
  
  private TextView T;
  
  private FlowLayout U;
  
  private FlowLayout V;
  
  private FlowLayout W;
  
  private FlowLayout X;
  
  private FlowLayout Y;
  
  private FlowLayout Z;
  
  private TextView aa;
  
  private TextView ab;
  
  public Context d;
  
  public View e;
  
  private BannerADView f;
  
  private BluedADConstraintLayout g;
  
  private TextView h;
  
  private TextView i;
  
  private TextView j;
  
  private TextView k;
  
  private TextView l;
  
  private TextView m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private TextView q;
  
  private LinearLayout r;
  
  private FrameLayout s;
  
  private TextView t;
  
  private TextView u;
  
  private TextView v;
  
  private TextView w;
  
  private TextView x;
  
  private TextView y;
  
  private TextView z;
  
  private void f(UserInfoEntity paramUserInfoEntity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("服务端返回 userInfo.health_test_result：");
    stringBuilder.append(paramUserInfoEntity.health_test_result);
    stringBuilder.append(" -- userInfo.health_test_time：");
    stringBuilder.append(paramUserInfoEntity.health_test_time);
    stringBuilder.append(" -- userInfo.health_prpe_use_situation：");
    stringBuilder.append(paramUserInfoEntity.health_prpe_use_situation);
    Log.v("drb", stringBuilder.toString());
    if (!k()) {
      this.r.setVisibility(8);
      this.n.setVisibility(8);
      this.o.setVisibility(8);
      this.p.setVisibility(8);
      this.q.setVisibility(8);
    } else {
      this.r.setVisibility(0);
      this.n.setVisibility(0);
      if (!StringUtils.e(paramUserInfoEntity.health_test_result)) {
        if (TextUtils.equals(paramUserInfoEntity.health_test_result, "-1")) {
          this.o.setVisibility(8);
        } else {
          this.o.setVisibility(0);
          this.o.setText((CharSequence)UserRelationshipUtils.e().get(paramUserInfoEntity.health_test_result));
        } 
      } else {
        this.o.setVisibility(8);
      } 
      if (!StringUtils.e(paramUserInfoEntity.health_test_time) && !TextUtils.equals(paramUserInfoEntity.health_test_time, "-1") && !TextUtils.equals(paramUserInfoEntity.health_test_time, "0")) {
        this.p.setVisibility(0);
        if (TextUtils.equals(paramUserInfoEntity.health_test_time, "1")) {
          TextView textView = this.p;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(getString(2131756978));
          stringBuilder1.append(getString(2131756979));
          textView.setText(stringBuilder1.toString());
        } else if (TextUtils.equals(paramUserInfoEntity.health_test_time, "-1")) {
          this.p.setVisibility(8);
        } else {
          TextView textView = this.p;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(TimeAndDateUtils.d(paramUserInfoEntity.health_test_time));
          stringBuilder1.append(getString(2131756979));
          textView.setText(stringBuilder1.toString());
        } 
      } else {
        this.p.setVisibility(8);
      } 
      if (!StringUtils.e(paramUserInfoEntity.health_prpe_use_situation)) {
        if (TextUtils.equals(paramUserInfoEntity.health_prpe_use_situation, "-1")) {
          this.q.setVisibility(8);
        } else {
          this.q.setVisibility(0);
          this.q.setText((CharSequence)UserRelationshipUtils.f().get(paramUserInfoEntity.health_prpe_use_situation));
        } 
      } else {
        this.q.setVisibility(8);
      } 
    } 
    this.r.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.HEALTH_INFO_PAGE_SHOW);
            HealthDialogFragment.a(this.a.d);
          }
        });
  }
  
  private boolean k() {
    UserInfoEntity userInfoEntity = this.K;
    return (userInfoEntity != null && ((!TextUtils.isEmpty(userInfoEntity.health_test_result) && !TextUtils.equals(this.K.health_test_result, "0") && !TextUtils.equals(this.K.health_test_result, "-1")) || (!TextUtils.isEmpty(this.K.health_test_time) && !TextUtils.equals(this.K.health_test_time, "0") && !TextUtils.equals(this.K.health_test_time, "-1")) || (!TextUtils.isEmpty(this.K.health_prpe_use_situation) && !TextUtils.equals(this.K.health_prpe_use_situation, "0") && !TextUtils.equals(this.K.health_prpe_use_situation, "-1"))));
  }
  
  private void l() {
    LiveEventBus.get("open_gift_package", OpenGiftPackageEvent.class).observe((LifecycleOwner)this, new Observer<OpenGiftPackageEvent>(this) {
          public void a(OpenGiftPackageEvent param1OpenGiftPackageEvent) {
            if (param1OpenGiftPackageEvent.a != null) {
              if (!param1OpenGiftPackageEvent.a.equals(this.a.w_()))
                return; 
              UserGiftDialogFragment.a(this.a.getContext(), this.a.w_(), (UserinfoFragmentProfileTab.b(this.a)).uid, "chat_page_gift", new UserGiftDialogFragment.BuySucceedListener(this) {
                    public void a(UserGiftDialogFragment param2UserGiftDialogFragment, GiftGivingOptionForJsonParse param2GiftGivingOptionForJsonParse) {
                      param2UserGiftDialogFragment.dismiss();
                      ((UserInfoFragmentNew)this.a.a.getParentFragment()).a(param2GiftGivingOptionForJsonParse);
                    }
                  },  (UserinfoFragmentProfileTab.b(this.a)).relationship, (UserinfoFragmentProfileTab.b(this.a)).name, new int[] { 1 });
            } 
          }
        });
  }
  
  private void m() {
    this.f = (BannerADView)this.e.findViewById(2131296494);
    this.g = (BluedADConstraintLayout)this.e.findViewById(2131296419);
    this.h = (TextView)this.e.findViewById(2131300659);
    this.i = (TextView)this.e.findViewById(2131300660);
    this.j = (TextView)this.e.findViewById(2131301250);
    this.k = (TextView)this.e.findViewById(2131301251);
    this.l = (TextView)this.e.findViewById(2131300581);
    this.m = (TextView)this.e.findViewById(2131300582);
    this.n = (TextView)this.e.findViewById(2131300883);
    this.o = (TextView)this.e.findViewById(2131300881);
    this.p = (TextView)this.e.findViewById(2131300882);
    this.q = (TextView)this.e.findViewById(2131300880);
    this.r = (LinearLayout)this.e.findViewById(2131298872);
    this.t = (TextView)this.e.findViewById(2131301247);
    this.u = (TextView)this.e.findViewById(2131301248);
    this.s = (FrameLayout)this.e.findViewById(2131297112);
    this.v = (TextView)this.e.findViewById(2131300902);
    this.w = (TextView)this.e.findViewById(2131300903);
    this.x = (TextView)this.e.findViewById(2131300807);
    this.y = (TextView)this.e.findViewById(2131300808);
    this.z = (TextView)this.e.findViewById(2131300934);
    this.A = (TextView)this.e.findViewById(2131300936);
    this.N = (LinearLayout)this.e.findViewById(2131299095);
    this.B = (LinearLayout)this.e.findViewById(2131299060);
    this.C = (LinearLayout)this.e.findViewById(2131298706);
    this.D = (ImageView)this.e.findViewById(2131297548);
    this.E = (ImageView)this.e.findViewById(2131297427);
    this.F = (LinearLayout)this.e.findViewById(2131298946);
    this.G = (RecyclerView)this.e.findViewById(2131299184);
    this.aa = (TextView)this.e.findViewById(2131299354);
    this.ab = (TextView)this.e.findViewById(2131301011);
    this.O = (TextView)this.e.findViewById(2131301078);
    this.P = (TextView)this.e.findViewById(2131301075);
    this.Q = (TextView)this.e.findViewById(2131301081);
    this.R = (TextView)this.e.findViewById(2131301077);
    this.S = (TextView)this.e.findViewById(2131301010);
    this.T = (TextView)this.e.findViewById(2131301009);
    this.U = (FlowLayout)this.e.findViewById(2131297188);
    this.V = (FlowLayout)this.e.findViewById(2131297186);
    this.W = (FlowLayout)this.e.findViewById(2131297189);
    this.X = (FlowLayout)this.e.findViewById(2131297187);
    this.Y = (FlowLayout)this.e.findViewById(2131297185);
    this.Z = (FlowLayout)this.e.findViewById(2131297184);
    this.I = (ImageView)this.e.findViewById(2131297494);
    this.J = (TextView)this.e.findViewById(2131301168);
  }
  
  public void a() {
    if (this.K.ads_banner != null && this.K.ads_banner.size() > 0) {
      this.f.a((IRequestHost)w_(), this.K.ads_banner.get(0), ADConstants.AD_POSITION.a, new BannerADView.ADListener(this) {
            public void a() {
              UserinfoFragmentProfileTab.c(this.a).a();
            }
            
            public void b() {
              if (UserinfoFragmentProfileTab.c(this.a) != null)
                UserinfoFragmentProfileTab.c(this.a).a(); 
            }
          });
      this.g.setADData(this.K.ads_banner.get(0));
      return;
    } 
    this.f.a();
  }
  
  public void a(UserInfoEntity paramUserInfoEntity) {
    if (paramUserInfoEntity != null && !StringUtils.e(paramUserInfoEntity.uid)) {
      this.K = paramUserInfoEntity;
      b(paramUserInfoEntity);
      if (this.d != null && !this.L) {
        this.L = true;
        a();
      } 
    } 
  }
  
  public void a(List<UserTag> paramList, FlowLayout paramFlowLayout) {
    if (paramList != null && paramList.size() > 0) {
      paramFlowLayout.removeAllViews();
      for (int i = 0; i < paramList.size(); i++) {
        View view = this.H.inflate(2131494218, null);
        ((TextView)view.findViewById(2131301371)).setText(((UserTag)paramList.get(i)).name);
        paramFlowLayout.addView(view);
      } 
    } 
  }
  
  public void b(UserInfoEntity paramUserInfoEntity) {
    if (UserInfo.a().i().getUid().equals(paramUserInfoEntity.uid))
      this.M = true; 
    this.d = (Context)getActivity();
    if (paramUserInfoEntity != null && !StringUtils.e(paramUserInfoEntity.uid) && w_().isActive()) {
      if (this.d == null)
        return; 
      if ((paramUserInfoEntity.vbadge == 3 || paramUserInfoEntity.vbadge == 5) && !this.M) {
        this.J.setVisibility(8);
      } else {
        this.J.setVisibility(0);
      } 
      String str = StringUtils.a(this.d.getResources().getStringArray(2130903054), this.d.getResources().getStringArray(2130903055), paramUserInfoEntity.astro);
      if (StringUtils.e(str) || ((paramUserInfoEntity.vbadge == 3 || paramUserInfoEntity.vbadge == 5) && !this.M)) {
        this.h.setVisibility(8);
        this.i.setVisibility(8);
      } else {
        this.h.setVisibility(0);
        this.i.setVisibility(0);
        this.h.setText(str);
      } 
      if (paramUserInfoEntity.tags == null || paramUserInfoEntity.tags.work == null || paramUserInfoEntity.tags.work.size() == 0 || ((paramUserInfoEntity.vbadge == 3 || paramUserInfoEntity.vbadge == 5) && !this.M)) {
        this.A.setVisibility(8);
        this.z.setVisibility(8);
      } else {
        this.A.setVisibility(0);
        this.z.setVisibility(0);
        str = "";
        for (int i = 0; i < paramUserInfoEntity.tags.work.size(); i++) {
          if (i == 0) {
            str = ((UserTag)paramUserInfoEntity.tags.work.get(i)).name;
          } else {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(str);
            stringBuilder1.append("、");
            stringBuilder1.append(((UserTag)paramUserInfoEntity.tags.work.get(i)).name);
            str = stringBuilder1.toString();
          } 
        } 
        this.z.setText(str);
      } 
      if (paramUserInfoEntity.tags != null && paramUserInfoEntity.tags.i_want != null && paramUserInfoEntity.tags.i_want.size() > 0) {
        if ((paramUserInfoEntity.vbadge == 3 || paramUserInfoEntity.vbadge == 5) && !this.M) {
          this.y.setVisibility(8);
          this.x.setVisibility(8);
        } else {
          str = "";
          for (int i = 0; i < paramUserInfoEntity.tags.i_want.size(); i++) {
            if (i == 0) {
              str = ((UserTag)paramUserInfoEntity.tags.i_want.get(i)).name;
            } else {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(str);
              stringBuilder1.append("、");
              stringBuilder1.append(((UserTag)paramUserInfoEntity.tags.i_want.get(i)).name);
              str = stringBuilder1.toString();
            } 
          } 
          this.y.setVisibility(0);
          this.x.setVisibility(0);
          this.x.setText(str);
        } 
      } else {
        this.y.setVisibility(8);
        this.x.setVisibility(8);
      } 
      try {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("服务器返回 userInfo.mate:");
        stringBuilder1.append(paramUserInfoEntity.mate);
        Log.v("drb", stringBuilder1.toString());
        String str1 = StringUtils.a(this.d, BlueAppLocal.c(), Integer.parseInt(paramUserInfoEntity.mate));
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("服务器返回解析后 userInfo.mate:");
        stringBuilder2.append(str1);
        Log.v("drb", stringBuilder2.toString());
        if (StringUtils.e(str1) || ((paramUserInfoEntity.vbadge == 3 || paramUserInfoEntity.vbadge == 5) && !this.M)) {
          this.j.setVisibility(8);
          this.k.setVisibility(8);
        } else {
          this.j.setVisibility(0);
          this.k.setVisibility(0);
          this.j.setText(str1);
        } 
      } catch (Exception exception) {
        this.j.setVisibility(8);
        this.k.setVisibility(8);
      } 
      str = StringUtils.a(this.d.getResources().getStringArray(2130903047), this.d.getResources().getStringArray(2130903048), paramUserInfoEntity.blood_type);
      if (StringUtils.e(str) || this.d.getResources().getString(2131756917).equals(str) || ((paramUserInfoEntity.vbadge == 3 || paramUserInfoEntity.vbadge == 5) && !this.M)) {
        this.l.setVisibility(8);
        this.m.setVisibility(8);
      } else {
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.l.setText(str);
      } 
      str = AreaUtils.a(paramUserInfoEntity.hometown, BlueAppLocal.c());
      if (StringUtils.e(str) || ((paramUserInfoEntity.vbadge == 3 || paramUserInfoEntity.vbadge == 5) && !this.M)) {
        this.v.setVisibility(8);
        this.w.setVisibility(8);
      } else {
        this.v.setVisibility(0);
        this.w.setVisibility(0);
        this.v.setText(str);
      } 
      if (paramUserInfoEntity.vbadge == 5 && !this.M) {
        this.B.setVisibility(8);
      } else {
        BitmapUtils.a(this.d, this.D, paramUserInfoEntity.rich_level, false);
        if (paramUserInfoEntity.anchor == 1) {
          LiveUtils.a(this.d, this.E, paramUserInfoEntity.anchor_level, false);
          if ((UserInfo.a().i()).uid.equalsIgnoreCase(paramUserInfoEntity.uid)) {
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            this.C.setOnClickListener(new -$$Lambda$UserinfoFragmentProfileTab$Z70P8OGKwU6njKd1mu3h3lIUGO0(this));
          } else {
            if (paramUserInfoEntity.rich_level == 0) {
              this.B.setVisibility(8);
            } else {
              this.B.setVisibility(0);
            } 
            if (paramUserInfoEntity.anchor_level == 0) {
              this.C.setVisibility(8);
            } else {
              this.C.setVisibility(0);
            } 
          } 
        } else {
          this.C.setVisibility(8);
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("服务端返回 userInfo.registration_time：");
      stringBuilder.append(paramUserInfoEntity.registration_time);
      Log.v("drb", stringBuilder.toString());
      if (paramUserInfoEntity.registration_time == 0) {
        this.t.setVisibility(8);
        this.u.setVisibility(8);
      } else {
        this.t.setVisibility(0);
        this.u.setVisibility(0);
        TextView textView = this.t;
        ArrayMap arrayMap = UserRelationshipUtils.g();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramUserInfoEntity.registration_time);
        stringBuilder1.append("");
        textView.setText((CharSequence)arrayMap.get(stringBuilder1.toString()));
      } 
      this.B.setOnClickListener(new -$$Lambda$UserinfoFragmentProfileTab$GgOrxw_JS4AxaZtBdba2zMPBavo(this, paramUserInfoEntity));
      f(paramUserInfoEntity);
      c(paramUserInfoEntity);
      d(paramUserInfoEntity);
      e(paramUserInfoEntity);
    } 
  }
  
  public void c(UserInfoEntity paramUserInfoEntity) {
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    if (paramUserInfoEntity == null || StringUtils.e(paramUserInfoEntity.uid) || paramUserInfoEntity.tags == null || ((paramUserInfoEntity.vbadge == 3 || paramUserInfoEntity.vbadge == 5) && !this.M)) {
      this.N.setVisibility(8);
      return;
    } 
    if (paramUserInfoEntity.tags.type == null) {
      i = 0;
    } else {
      i = paramUserInfoEntity.tags.type.size();
    } 
    if (paramUserInfoEntity.tags.character == null) {
      j = 0;
    } else {
      j = paramUserInfoEntity.tags.character.size();
    } 
    if (paramUserInfoEntity.tags.hobbies == null) {
      k = 0;
    } else {
      k = paramUserInfoEntity.tags.hobbies.size();
    } 
    if (paramUserInfoEntity.tags.recreation == null) {
      m = 0;
    } else {
      m = paramUserInfoEntity.tags.recreation.size();
    } 
    if (paramUserInfoEntity.tags.love_type == null) {
      n = 0;
    } else {
      n = paramUserInfoEntity.tags.love_type.size();
    } 
    if (paramUserInfoEntity.tags.love_character == null) {
      i1 = 0;
    } else {
      i1 = paramUserInfoEntity.tags.love_character.size();
    } 
    int i2 = i + j + k + m;
    if (i2 + n + i1 == 0) {
      this.N.setVisibility(8);
      return;
    } 
    this.N.setVisibility(0);
    if (i2 == 0) {
      this.aa.setVisibility(8);
    } else {
      this.aa.setVisibility(0);
    } 
    if (n + i1 == 0) {
      this.ab.setVisibility(8);
    } else {
      this.ab.setVisibility(0);
    } 
    if (i == 0) {
      this.O.setVisibility(8);
      this.U.setVisibility(8);
    } else {
      this.O.setVisibility(0);
      this.U.setVisibility(0);
      a(paramUserInfoEntity.tags.type, this.U);
    } 
    if (j == 0) {
      this.P.setVisibility(8);
      this.V.setVisibility(8);
    } else {
      this.P.setVisibility(0);
      this.V.setVisibility(0);
      a(paramUserInfoEntity.tags.character, this.V);
    } 
    if (k == 0) {
      this.Q.setVisibility(8);
      this.W.setVisibility(8);
    } else {
      this.Q.setVisibility(0);
      this.W.setVisibility(0);
      a(paramUserInfoEntity.tags.hobbies, this.W);
    } 
    if (m == 0) {
      this.R.setVisibility(8);
      this.X.setVisibility(8);
    } else {
      this.R.setVisibility(0);
      this.X.setVisibility(0);
      a(paramUserInfoEntity.tags.recreation, this.X);
    } 
    if (n == 0) {
      this.S.setVisibility(8);
      this.Y.setVisibility(8);
    } else {
      this.S.setVisibility(0);
      this.Y.setVisibility(0);
      a(paramUserInfoEntity.tags.love_type, this.Y);
    } 
    if (i1 == 0) {
      this.T.setVisibility(8);
      this.Z.setVisibility(8);
    } else {
      this.T.setVisibility(0);
      this.Z.setVisibility(0);
      a(paramUserInfoEntity.tags.love_character, this.Z);
    } 
    this.N.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
          public void onGlobalLayout() {
            int i = ((Integer)Collections.<Integer>max(Arrays.asList(new Integer[] { Integer.valueOf(UserinfoFragmentProfileTab.d(this.a).getWidth()), Integer.valueOf(UserinfoFragmentProfileTab.e(this.a).getWidth()), Integer.valueOf(UserinfoFragmentProfileTab.f(this.a).getWidth()), Integer.valueOf(UserinfoFragmentProfileTab.g(this.a).getWidth()), Integer.valueOf(UserinfoFragmentProfileTab.h(this.a).getWidth()), Integer.valueOf(UserinfoFragmentProfileTab.i(this.a).getWidth()) }))).intValue();
            UserinfoFragmentProfileTab.d(this.a).setWidth(i);
            UserinfoFragmentProfileTab.e(this.a).setWidth(i);
            UserinfoFragmentProfileTab.f(this.a).setWidth(i);
            UserinfoFragmentProfileTab.g(this.a).setWidth(i);
            UserinfoFragmentProfileTab.h(this.a).setWidth(i);
            UserinfoFragmentProfileTab.i(this.a).setWidth(i);
            UserinfoFragmentProfileTab.j(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          }
        });
  }
  
  public void d(UserInfoEntity paramUserInfoEntity) {
    if (paramUserInfoEntity == null || StringUtils.e(paramUserInfoEntity.uid) || paramUserInfoEntity.badge == null || paramUserInfoEntity.badge.size() == 0) {
      this.F.setVisibility(8);
      return;
    } 
    ArrayList arrayList = new ArrayList();
    arrayList.addAll(paramUserInfoEntity.badge);
    UserMedalsAdapter userMedalsAdapter = new UserMedalsAdapter((IRequestHost)w_(), this.d, arrayList);
    userMedalsAdapter.a(new -$$Lambda$UserinfoFragmentProfileTab$QGZAzy-b8srPmFmZKktF5xsE5Ws(this, paramUserInfoEntity));
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d);
    linearLayoutManager.setStackFromEnd(true);
    linearLayoutManager.setOrientation(0);
    linearLayoutManager.scrollToPosition(0);
    this.G.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.G.setHasFixedSize(true);
    this.G.setAdapter((RecyclerView.Adapter)userMedalsAdapter);
    userMedalsAdapter.notifyDataSetChanged();
    if (userMedalsAdapter.getItemCount() > 0) {
      this.F.setVisibility(0);
      return;
    } 
    this.F.setVisibility(8);
  }
  
  public void e(UserInfoEntity paramUserInfoEntity) {
    LinearLayout linearLayout = (LinearLayout)this.e.findViewById(2131299124);
    TextView textView1 = (TextView)this.e.findViewById(2131301471);
    TextView textView2 = (TextView)this.e.findViewById(2131301470);
    RecyclerView recyclerView = (RecyclerView)this.e.findViewById(2131299189);
    if (paramUserInfoEntity.uid.equals((UserInfo.a().i()).uid) && !BluedPreferences.aS()) {
      this.I.setVisibility(0);
    } else {
      this.I.setVisibility(8);
    } 
    if ((UserInfo.a().i()).uid.equals(paramUserInfoEntity.uid)) {
      textView1.setText(this.d.getResources().getString(2131758160));
      linearLayout.setOnClickListener(new -$$Lambda$UserinfoFragmentProfileTab$ZEGyYP8S0VMRHnFQ6RUgOrk0zHU(this));
    } else {
      textView1.setText(this.d.getResources().getString(2131756959));
      linearLayout.setOnClickListener(new -$$Lambda$UserinfoFragmentProfileTab$XPuq4FoenAMFelHUdfI4pIdekqA(this, paramUserInfoEntity));
    } 
    UserHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<UserGift>>(this, (IRequestHost)w_(), paramUserInfoEntity, textView2, recyclerView) {
          protected void a(BluedEntityA<UserGift> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData() && param1BluedEntityA.getSingleData() != null) {
              if (((UserGift)param1BluedEntityA.getSingleData()).number == 0) {
                if (TextUtils.equals((UserInfo.a().i()).uid, this.a.uid)) {
                  this.b.setText(this.d.d.getResources().getString(2131759372));
                } else {
                  this.b.setText(this.d.d.getResources().getString(2131756843));
                } 
              } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(((UserGift)param1BluedEntityA.getSingleData()).number);
                stringBuilder.append("");
                String str = StringUtils.a(stringBuilder.toString());
                this.b.setText(str);
              } 
              ArrayList arrayList = new ArrayList();
              arrayList.addAll(((UserGift)param1BluedEntityA.getSingleData()).gift_list);
              UserProfileGiftdapter userProfileGiftdapter = new UserProfileGiftdapter((IRequestHost)this.d.w_(), this.d.d, arrayList);
              userProfileGiftdapter.a(new -$$Lambda$UserinfoFragmentProfileTab$7$LlSr5F8-HDr-kGFjlbquzzcTY-o(this, this.a));
              LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d.d);
              linearLayoutManager.setStackFromEnd(true);
              linearLayoutManager.setOrientation(0);
              linearLayoutManager.scrollToPosition(0);
              this.c.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
              this.c.setHasFixedSize(true);
              this.c.setAdapter((RecyclerView.Adapter)userProfileGiftdapter);
              userProfileGiftdapter.notifyDataSetChanged();
              if (userProfileGiftdapter.getItemCount() > 0) {
                this.c.setVisibility(0);
                return;
              } 
              this.c.setVisibility(8);
              return;
            } 
            this.c.setVisibility(8);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.c.setVisibility(8);
            return super.onUIFailure(param1Int, param1String);
          }
        }paramUserInfoEntity.uid, (IRequestHost)w_());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    this.H = paramLayoutInflater;
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493348, paramViewGroup, false);
      m();
      l();
      UserInfoEntity userInfoEntity = this.K;
      if (userInfoEntity != null)
        a(userInfoEntity); 
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    BannerADView bannerADView = this.f;
    if (bannerADView != null)
      bannerADView.b(); 
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean && !this.M && k()) {
      if (!BluedPreferences.dl()) {
        this.s.setVisibility(0);
        AppInfo.n().postDelayed(new Runnable(this) {
              public void run() {
                UserinfoFragmentProfileTab.a(this.a).setVisibility(8);
                BluedPreferences.dm();
              }
            },  5000L);
      } 
      this.s.setOnClickListener(new -$$Lambda$UserinfoFragmentProfileTab$XtCJj7_UiWQyQYiVevJxB8ia4Bw(this));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\UserinfoFragmentProfileTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */