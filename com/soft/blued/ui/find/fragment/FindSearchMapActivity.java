package com.soft.blued.ui.find.fragment;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.guy.GuyProtos;
import com.blued.das.vip.VipProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.model.BluedMyExtra;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.adapter.PeopleListQuickAdapter;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.ui.find.manager.MapSearchHistoryManager;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.model.SearchPositionModel;
import com.soft.blued.ui.find.model.ShadowModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.setting.fragment.MapFinderSettingFragment;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.umeng.analytics.MobclickAgent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;

public class FindSearchMapActivity extends BaseFragment implements View.OnClickListener, AMapLocationListener, AMap.OnCameraChangeListener, LocationSource, GeocodeSearch.OnGeocodeSearchListener {
  private TextView A;
  
  private TextView B;
  
  private AMap C;
  
  private GeocodeSearch D;
  
  private PoiSearch E = null;
  
  private String F;
  
  private LatLng G;
  
  private LatLng H;
  
  private String I = "";
  
  private String J = "";
  
  private double K;
  
  private LocationSource.OnLocationChangedListener L;
  
  private AMapLocationClient M;
  
  private AMapLocationClientOption N;
  
  private String O;
  
  private PoiItem P;
  
  private LatLng Q;
  
  private PeopleGridQuickAdapter R;
  
  private PeopleListQuickAdapter S;
  
  private int T;
  
  private View U;
  
  private TextView V;
  
  private FrameLayout W;
  
  private MapSearchPositionFragment X;
  
  private ImageView Y;
  
  private int Z;
  
  private int aa;
  
  private View ab;
  
  private TextView ac;
  
  private TextView ad;
  
  private TextView ae;
  
  private Context af;
  
  private CardView ag;
  
  BluedUIHttpResponse d = new BluedUIHttpResponse<BluedEntity<UserFindResult, BluedMyExtra>>(this, (IRequestHost)w_()) {
      boolean a = false;
      
      boolean b = false;
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        if (param1Int == 4031213) {
          InstantLog.a("map_vip_dialog_show");
          this.b = true;
          return true;
        } 
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        DialogUtils.b(FindSearchMapActivity.B(this.c));
        FindSearchMapActivity.J(this.c).j();
        if (FindSearchMapActivity.F(this.c)) {
          FindSearchMapActivity.G(this.c).l();
          if (this.a) {
            if (FindSearchMapActivity.G(this.c).getItemCount() == 0)
              FindSearchMapActivity.C(this.c).b(); 
          } else if (FindSearchMapActivity.G(this.c).getItemCount() == 0) {
            FindSearchMapActivity.C(this.c).a();
          } 
        } else {
          FindSearchMapActivity.d(this.c).l();
          if (this.a) {
            if (FindSearchMapActivity.d(this.c).getItemCount() == 0)
              FindSearchMapActivity.C(this.c).b(); 
          } else if (FindSearchMapActivity.d(this.c).getItemCount() == 0) {
            FindSearchMapActivity.C(this.c).a();
          } 
        } 
        this.a = false;
        if (this.b)
          CommonAlertDialog.a((Context)this.c.getActivity(), 2131233398, AppUtils.a(2131757846), null, AppUtils.a(2131757840), new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                  InstantLog.a("map_vip_dialog_buy_click");
                  PayUtils.a((Context)this.a.c.getActivity(), 21, "map_find");
                }
              }null); 
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(FindSearchMapActivity.B(this.c));
      }
      
      public void onUIUpdate(BluedEntity<UserFindResult, BluedMyExtra> param1BluedEntity) {
        try {
          if (param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
            FindSearchMapActivity.C(this.c).c();
            if (!FindSearchMapActivity.D(this.c))
              FindSearchMapActivity.E(this.c); 
            if (param1BluedEntity.extra != null && param1BluedEntity.hasMore()) {
              if (FindSearchMapActivity.F(this.c)) {
                FindSearchMapActivity.G(this.c).c(true);
              } else {
                FindSearchMapActivity.d(this.c).c(true);
              } 
            } else if (FindSearchMapActivity.F(this.c)) {
              FindSearchMapActivity.G(this.c).c(false);
              FindSearchMapActivity.G(this.c).k();
            } else {
              FindSearchMapActivity.d(this.c).c(false);
              FindSearchMapActivity.d(this.c).k();
            } 
            if (FindSearchMapActivity.H(this.c) == 1) {
              if (FindSearchMapActivity.F(this.c)) {
                FindSearchMapActivity.G(this.c).c(param1BluedEntity.data);
              } else {
                FindSearchMapActivity.d(this.c).c(param1BluedEntity.data);
              } 
            } else if (FindSearchMapActivity.F(this.c)) {
              FindSearchMapActivity.G(this.c).a(param1BluedEntity.data);
            } else {
              FindSearchMapActivity.d(this.c).a(param1BluedEntity.data);
            } 
            if (param1BluedEntity.extra != null) {
              FindSearchMapActivity.a(this.c, ((BluedMyExtra)param1BluedEntity.extra).getNext_min_dist());
              FindSearchMapActivity.b(this.c, ((BluedMyExtra)param1BluedEntity.extra).getNext_skip_uid());
              return;
            } 
          } else {
            if (FindSearchMapActivity.F(this.c)) {
              FindSearchMapActivity.G(this.c).c(false);
              FindSearchMapActivity.G(this.c).k();
            } else {
              FindSearchMapActivity.d(this.c).c(false);
              FindSearchMapActivity.d(this.c).k();
            } 
            if (FindSearchMapActivity.H(this.c) != 1)
              FindSearchMapActivity.I(this.c); 
            if (BluedPreferences.G()) {
              AppMethods.d(2131755446);
              return;
            } 
            AppMethods.d(2131756083);
            return;
          } 
        } catch (Exception exception) {
          if (FindSearchMapActivity.H(this.c) != 1)
            FindSearchMapActivity.I(this.c); 
        } 
      }
      
      public BluedEntity<UserFindResult, BluedMyExtra> parseData(String param1String) {
        BluedEntity<UserFindResult, BluedMyExtra> bluedEntity = super.parseData(param1String);
        if (bluedEntity != null)
          for (int i = 0; i < bluedEntity.data.size(); i++) {
            ((UserFindResult)bluedEntity.data.get(i)).distance = DistanceUtils.a(((UserFindResult)bluedEntity.data.get(i)).distance, BlueAppLocal.c(), false);
            ((UserFindResult)bluedEntity.data.get(i)).last_operate = TimeAndDateUtils.a((Context)this.c.getActivity(), TimeAndDateUtils.b(((UserFindResult)bluedEntity.data.get(i)).last_operate));
          }  
        return bluedEntity;
      }
    };
  
  private String e = FindSearchMapActivity.class.getSimpleName();
  
  private CommonTopTitleNoTrans f;
  
  private SearchView g;
  
  private SearchEditText h;
  
  private ImageView i;
  
  private TextView j;
  
  private PullToRefreshRecyclerView k;
  
  private RecyclerView l;
  
  private boolean m;
  
  private boolean n = false;
  
  private int o = 1;
  
  private int p = 0;
  
  private int q = 36;
  
  private String r;
  
  private String s;
  
  private MapView t = null;
  
  private LinearLayout u;
  
  private View v;
  
  private int w;
  
  private Dialog x;
  
  private NoDataAndLoadFailView y;
  
  private LinearLayout z;
  
  private void A() {
    String str1;
    String str3;
    String str4;
    PoiItem poiItem = this.P;
    String str2 = "";
    if (poiItem != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.P.getLatLonPoint().getLatitude());
      stringBuilder1.append("");
      str1 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.P.getLatLonPoint().getLongitude());
      stringBuilder2.append("");
      String str = stringBuilder2.toString();
    } else if (this.H != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.H.latitude);
      stringBuilder1.append("");
      str1 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.H.longitude);
      stringBuilder2.append("");
      str2 = stringBuilder2.toString();
    } else {
      str1 = "";
    } 
    if (!TextUtils.isEmpty(this.J)) {
      str3 = this.J;
    } else {
      str3 = this.I;
    } 
    if (!TextUtils.isEmpty(this.h.getText().toString())) {
      str4 = this.h.getText().toString();
    } else {
      str4 = str3;
    } 
    EventTrackVIP.a(VipProtos.Event.MAP_FIND_SETTINGS_PAGE_SETTINGS_BTN_CLICK, str1, str2);
    MapSearchHistoryManager.a().a(new SearchPositionModel(str4, Double.valueOf(str1).doubleValue(), Double.valueOf(str2).doubleValue()));
    MineHttpUtils.a(new BluedUIHttpResponse(this, (IRequestHost)w_()) {
          public boolean onUIFailure(int param1Int, String param1String) {
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            FindSearchMapActivity.u(this.a);
            AppMethods.d(2131758734);
            FindSearchMapActivity.v(this.a);
          }
        }str3, str2, str1);
  }
  
  private void B() {
    NearbyHttpUtils.b(new BluedUIHttpResponse(this, (IRequestHost)w_()) {
          public boolean onUIFailure(int param1Int, String param1String) {
            if (param1Int == 4031219) {
              EventTrackGuy.b(GuyProtos.Event.NEARBY_FRIEND_MAP_FIND_OPEN_POP_SHOW);
              InstantLog.a("map_vip_dialog_show");
              CommonAlertDialog.a((Context)this.a.getActivity(), 2131233398, AppUtils.a(2131757846), null, AppUtils.a(2131757840), new DialogInterface.OnClickListener(this) {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      EventTrackGuy.b(GuyProtos.Event.NEARBY_FRIEND_MAP_FIND_OPEN_BTN_CLICK);
                      InstantLog.a("map_vip_dialog_buy_click");
                      PayUtils.a((Context)this.a.a.getActivity(), 21, "map_find");
                    }
                  }null);
              return true;
            } 
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            MapFindManager.MapFindBean mapFindBean = new MapFindManager.MapFindBean();
            if (FindSearchMapActivity.w(this.a) == null) {
              if (FindSearchMapActivity.x(this.a) == null)
                return; 
              mapFindBean.d = FindSearchMapActivity.y(this.a);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append((FindSearchMapActivity.x(this.a)).latitude);
              stringBuilder.append("");
              mapFindBean.b = stringBuilder.toString();
              stringBuilder = new StringBuilder();
              stringBuilder.append((FindSearchMapActivity.x(this.a)).longitude);
              stringBuilder.append("");
              mapFindBean.a = stringBuilder.toString();
              mapFindBean.c = FindSearchMapActivity.z(this.a);
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(FindSearchMapActivity.w(this.a).getCityName());
              stringBuilder.append(FindSearchMapActivity.w(this.a).getAdName());
              stringBuilder.append(FindSearchMapActivity.w(this.a).getDirection());
              mapFindBean.d = stringBuilder.toString();
              stringBuilder = new StringBuilder();
              stringBuilder.append(FindSearchMapActivity.w(this.a).getLatLonPoint().getLatitude());
              stringBuilder.append("");
              mapFindBean.b = stringBuilder.toString();
              stringBuilder = new StringBuilder();
              stringBuilder.append(FindSearchMapActivity.w(this.a).getLatLonPoint().getLongitude());
              stringBuilder.append("");
              mapFindBean.a = stringBuilder.toString();
              mapFindBean.c = FindSearchMapActivity.z(this.a);
            } 
            mapFindBean.c = FindSearchMapActivity.z(this.a);
            mapFindBean.e = FindSearchMapActivity.A(this.a).getText().toString();
            MapFindManager.a().a(mapFindBean);
            FindSearchMapActivity.v(this.a);
            LiveEventBus.get("map_find_click").post(Boolean.valueOf(true));
          }
        }(IRequestHost)w_());
  }
  
  private void C() {
    this.C.setLocationSource(this);
    this.C.setMyLocationEnabled(true);
    MyLocationStyle myLocationStyle = new MyLocationStyle();
    myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(2131233469));
    myLocationStyle.strokeColor(Color.argb(0, 0, 0, 0));
    myLocationStyle.radiusFillColor(Color.argb(0, 0, 0, 0));
    myLocationStyle.strokeWidth(0.0F);
    this.C.setMyLocationStyle(myLocationStyle);
    this.C.getUiSettings().setMyLocationButtonEnabled(false);
    this.C.getUiSettings().setZoomControlsEnabled(false);
    this.C.setOnCameraChangeListener(this);
  }
  
  private void D() {
    if (getParentFragment() instanceof DialogFragment) {
      ((DialogFragment)getParentFragment()).dismissAllowingStateLoss();
      return;
    } 
    if (getActivity() != null)
      getActivity().finish(); 
  }
  
  public static void a(Context paramContext, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putInt("from", paramInt);
    TransparentActivity.a(bundle);
    TransparentActivity.b(paramContext, FindSearchMapActivity.class, bundle);
    if (paramContext instanceof Activity)
      ActivityChangeAnimationUtils.a((Activity)paramContext); 
  }
  
  private void a(Bundle paramBundle) {
    this.t = (MapView)this.U.findViewById(2131299988);
    this.v = this.U.findViewById(2131299199);
    this.t = (MapView)this.U.findViewById(2131299988);
    this.t.onCreate(paramBundle);
    this.u = (LinearLayout)this.U.findViewById(2131298944);
    this.u.post(new Runnable(this) {
          public void run() {
            ConstraintLayout constraintLayout = (ConstraintLayout)FindSearchMapActivity.e(this.a).findViewById(2131296829);
            FindSearchMapActivity.a(this.a, constraintLayout.getHeight() - FindSearchMapActivity.f(this.a).getHeight() - StatusBarHelper.a(FindSearchMapActivity.g(this.a)));
            (FindSearchMapActivity.h(this.a).getLayoutParams()).height = FindSearchMapActivity.i(this.a);
            FindSearchMapActivity.h(this.a).requestLayout();
          }
        });
    this.z = (LinearLayout)this.U.findViewById(2131299111);
    this.A = (TextView)this.U.findViewById(2131301428);
    this.B = (TextView)this.U.findViewById(2131301429);
    if (this.C == null) {
      LatLng latLng;
      paramBundle = null;
      if (MapFindManager.a().b())
        latLng = new LatLng(Double.parseDouble((MapFindManager.a().c()).b), Double.parseDouble((MapFindManager.a().c()).a)); 
      this.D = new GeocodeSearch((Context)getActivity());
      this.D.setOnGeocodeSearchListener(this);
      this.C = this.t.getMap();
      s();
      C();
      this.C.moveCamera(CameraUpdateFactory.zoomTo(16.0F));
      if (latLng != null) {
        this.h.setText((MapFindManager.a().c()).e);
        a(new Runnable(this, latLng) {
              public void run() {
                FindSearchMapActivity.j(this.b).moveCamera(CameraUpdateFactory.newLatLngZoom(this.a, 16.0F));
              }
            }1000L);
      } 
    } 
  }
  
  private void a(String paramString) {
    String str1;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("address:");
    stringBuilder1.append(paramString);
    Log.v("drb", stringBuilder1.toString());
    if (!StringUtils.e(paramString)) {
      if (paramString.length() > 12) {
        if (!z()) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramString.substring(0, 12));
          stringBuilder1.append("... ");
          paramString = stringBuilder1.toString();
        } 
      } else {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString);
        stringBuilder1.append(" ");
        paramString = stringBuilder1.toString();
      } 
    } else {
      paramString = "";
    } 
    if (this.K < 100.0D) {
      DecimalFormat decimalFormat = new DecimalFormat("0.00");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(AppUtils.a(2131756202));
      stringBuilder.append(" ");
      stringBuilder.append(decimalFormat.format(this.K));
      stringBuilder.append(" km");
      str1 = stringBuilder.toString();
    } else {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(AppUtils.a(2131756202));
      stringBuilder1.append(" ");
      stringBuilder1.append((int)this.K);
      stringBuilder1.append(" km");
      str1 = stringBuilder1.toString();
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString);
    stringBuilder2.append(str1);
    String str2 = stringBuilder2.toString();
    this.A.setText(paramString);
    this.B.setText(str1);
    if (StringUtils.e(str2)) {
      this.z.setVisibility(8);
    } else {
      this.z.setVisibility(0);
    } 
    this.A.requestLayout();
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2) {
    MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<ShadowModel>>(this, (IRequestHost)w_(), paramBoolean1, paramBoolean2) {
          protected void a(BluedEntityA<ShadowModel> param1BluedEntityA) {
            ShadowModel shadowModel = param1BluedEntityA.data.get(0);
            if (shadowModel != null)
              if (shadowModel.has_right == 0) {
                if (this.a) {
                  WebViewShowInfoFragment.show((Context)this.c.getActivity(), H5Url.a(43, new Object[] { (UserInfo.a().i()).uid, "map_shadow" }), 0);
                  return;
                } 
              } else {
                if (shadowModel.latitude != 0.0D && shadowModel.longitude != 0.0D) {
                  FindSearchMapActivity.a(this.c, new LatLng(shadowModel.latitude, shadowModel.longitude));
                  if (this.a)
                    FindSearchMapActivity.j(this.c).moveCamera(CameraUpdateFactory.newLatLngZoom(FindSearchMapActivity.q(this.c), 16.0F)); 
                  FindSearchMapActivity.r(this.c).setText(2131758738);
                } else if (this.b) {
                  FindSearchMapActivity.s(this.c);
                } 
                if (this.b)
                  FindSearchMapActivity.t(this.c); 
              }  
          }
        });
  }
  
  private void m() {
    Bundle bundle = getArguments();
    if (bundle != null)
      this.Z = bundle.getInt("from"); 
  }
  
  private void n() {
    this.aa = 1;
    this.j.setVisibility(4);
    this.V.setVisibility(4);
    this.ab.setVisibility(8);
    this.ac.setVisibility(0);
    this.ad.setVisibility(0);
    this.Y.setImageResource(2131233708);
    a(this.J);
  }
  
  private void o() {
    if (!BluedPreferences.bi() || getActivity() == null)
      return; 
    BluedPreferences.bj();
    InstantLog.a("map_vip_dialog_show");
    if ((UserInfo.a().i()).vip_grade != 0) {
      CommonAlertDialog.a((Context)getActivity(), AppUtils.a(2131757854), AppUtils.a(2131757849), AppUtils.a(2131757852), null, null, 0);
      return;
    } 
    CommonAlertDialog.a((Context)getActivity(), 0, AppUtils.a(2131757854), AppUtils.a(2131757849), AppUtils.a(2131757840), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            InstantLog.a("map_vip_dialog_buy_click");
            PayUtils.a((Context)this.a.getActivity(), 21, "map_find");
          }
        }null);
  }
  
  private void p() {
    this.T = PeopleGridQuickAdapter.a((Context)getActivity());
    this.k = (PullToRefreshRecyclerView)this.U.findViewById(2131298144);
    PullToRefreshRecyclerView pullToRefreshRecyclerView = this.k;
    boolean bool = true;
    pullToRefreshRecyclerView.setRefreshEnabled(true);
    this.l = (RecyclerView)this.k.getRefreshableView();
    this.l.setClipToPadding(false);
    this.l.setScrollBarStyle(33554432);
    if (BluedPreferences.I() != 1)
      bool = false; 
    this.m = bool;
    this.k.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            this.a.a(true, false);
          }
        });
    if (this.m) {
      a();
      return;
    } 
    k();
  }
  
  private void q() {
    this.f = (CommonTopTitleNoTrans)this.U.findViewById(2131300300);
    this.f.setOnClickListener(this);
    this.f.setRightClickListener(this);
    this.f.setCenterText(AppUtils.a(2131757843));
    this.f.setRightImg(2131232757);
    this.f.e();
    this.f.setRightClickListener(this);
    this.f.setLeftClickListener(this);
    this.f.setCenterTextColor(2131100728);
  }
  
  private void r() {
    if (HomeActivity.c != null)
      HomeActivity.c.getWindow().setSoftInputMode(51); 
    this.x = DialogUtils.a((Context)getActivity());
    this.W = (FrameLayout)this.U.findViewById(2131299862);
    this.y = (NoDataAndLoadFailView)this.U.findViewById(2131299389);
    this.g = (SearchView)this.U.findViewById(2131299874);
    this.h = this.g.getEditView();
    this.g.setRootBgColor(17170445);
    ShapeModel shapeModel = new ShapeModel();
    shapeModel.H = DensityUtils.a(getContext(), 14.0F);
    shapeModel.k = ContextCompat.getColor(getContext(), 2131100728);
    this.g.setShapeModel(shapeModel);
    this.h.setTextColor(ContextCompat.getColor(getContext(), 2131100806));
    this.h.setHintTextColor(ContextCompat.getColor(getContext(), 2131100470));
    this.i = (ImageView)this.U.findViewById(2131297914);
    this.Y = (ImageView)this.U.findViewById(2131299160);
    this.ab = this.U.findViewById(2131299930);
    this.ae = (TextView)this.U.findViewById(2131299931);
    this.ac = (TextView)this.U.findViewById(2131301335);
    this.ad = (TextView)this.U.findViewById(2131301334);
    this.j = (TextView)this.U.findViewById(2131301130);
    this.V = (TextView)this.U.findViewById(2131300611);
    this.ag = (CardView)this.U.findViewById(2131296659);
    this.g.setMaskLayerOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackGuy.b(GuyProtos.Event.MAP_FIND_SEARCH_BAR_CLICK);
            FindSearchMapActivity.m(this.a).a(FindSearchMapActivity.k(this.a), FindSearchMapActivity.l(this.a));
            FindSearchMapActivity.n(this.a).setVisibility(0);
          }
        });
    if (y()) {
      ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)this.ag.getLayoutParams();
      layoutParams.setMargins(DensityUtils.a(this.af, 10.0F), DensityUtils.a(this.af, 40.0F), DensityUtils.a(this.af, 10.0F), DensityUtils.a(this.af, 40.0F));
      this.ag.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
    this.ab.setOnClickListener(this);
    this.ac.setOnClickListener(this);
    this.ad.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.V.setOnClickListener(this);
    this.X = new MapSearchPositionFragment();
    this.X.e = this;
    getChildFragmentManager().beginTransaction().replace(2131299862, (Fragment)this.X).commitAllowingStateLoss();
  }
  
  private void s() {
    String str;
    Locale locale = LocaleUtils.c();
    if (locale != null) {
      str = locale.getLanguage();
    } else {
      str = "";
    } 
    if (TextUtils.equals(str, "zh")) {
      this.C.setMapLanguage("zh");
      ServiceSettings.getInstance().setLanguage("zh-CN");
      return;
    } 
    this.C.setMapLanguage("en");
    ServiceSettings.getInstance().setLanguage("en");
  }
  
  private void t() {
    this.n = true;
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setFillAfter(true);
    alphaAnimation.setDuration(600L);
    this.g.startAnimation((Animation)alphaAnimation);
    this.g.setEnabled(false);
    this.j.setEnabled(false);
    this.i.setEnabled(false);
    ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { this.u.getHeight(), DensityUtils.a((Context)getActivity(), 100.0F) });
    valueAnimator.setTarget(this.u);
    valueAnimator.setInterpolator((TimeInterpolator)new AccelerateInterpolator());
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            (FindSearchMapActivity.h(this.a).getLayoutParams()).height = i;
            FindSearchMapActivity.h(this.a).requestLayout();
          }
        });
    valueAnimator.setDuration(600L).start();
    valueAnimator = ValueAnimator.ofInt(new int[] { this.z.getPaddingBottom(), DensityUtils.a((Context)getActivity(), 10.0F) });
    valueAnimator.setTarget(this.z);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            FindSearchMapActivity.o(this.a).setPadding(0, 0, 0, i);
            FindSearchMapActivity.o(this.a).requestLayout();
          }
        });
    valueAnimator.setDuration(600L).start();
    this.v.setVisibility(0);
    v();
  }
  
  private void u() {
    this.n = false;
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setFillAfter(true);
    alphaAnimation.setDuration(600L);
    this.g.startAnimation((Animation)alphaAnimation);
    this.g.setEnabled(true);
    this.j.setEnabled(true);
    this.i.setEnabled(true);
    ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { this.u.getHeight(), this.w });
    valueAnimator.setTarget(this.u);
    valueAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            (FindSearchMapActivity.h(this.a).getLayoutParams()).height = i;
            FindSearchMapActivity.h(this.a).requestLayout();
          }
        });
    valueAnimator.setDuration(600L).start();
    valueAnimator = ValueAnimator.ofInt(new int[] { this.z.getPaddingBottom(), DensityUtils.a((Context)getActivity(), 90.0F) });
    valueAnimator.setTarget(this.z);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            FindSearchMapActivity.o(this.a).setPadding(0, 0, 0, i);
            FindSearchMapActivity.o(this.a).requestLayout();
          }
        });
    valueAnimator.setDuration(600L).start();
    this.v.setVisibility(8);
  }
  
  private void v() {
    this.v.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FindSearchMapActivity.p(this.a);
          }
        });
  }
  
  private void w() {
    if (BluedPreferences.cH())
      ((TextView)this.U.findViewById(2131299932)).setVisibility(0); 
  }
  
  private void x() {
    ((TextView)this.U.findViewById(2131299932)).setVisibility(8);
    BluedPreferences.cI();
  }
  
  private boolean y() {
    return (this.Z == 1);
  }
  
  private boolean z() {
    return (this.aa == 1);
  }
  
  public boolean V_() {
    if (this.n) {
      u();
    } else {
      EventTrackVIP.a(VipProtos.Event.MAP_FIND_BACK_BTN_CLICK);
      D();
    } 
    return false;
  }
  
  public void a() {
    this.S = new PeopleListQuickAdapter(new ArrayList(), (Activity)getActivity(), (IRequestHost)w_(), "map_find", this.l);
    this.S.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            FindSearchMapActivity.b(this.a);
            this.a.a(false, false);
          }
        }this.l);
    this.l.setAdapter((RecyclerView.Adapter)this.S);
    GridLayoutManager gridLayoutManager = new GridLayoutManager((Context)getActivity(), 1);
    this.l.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
  }
  
  public void a(LatLonPoint paramLatLonPoint) {
    RegeocodeQuery regeocodeQuery = new RegeocodeQuery(paramLatLonPoint, 200.0F, "autonavi");
    this.D.getFromLocationAsyn(regeocodeQuery);
  }
  
  public void a(PoiItem paramPoiItem, String paramString) {
    this.P = paramPoiItem;
    this.W.setVisibility(8);
    this.Q = new LatLng(paramPoiItem.getLatLonPoint().getLatitude(), paramPoiItem.getLatLonPoint().getLongitude());
    this.C.moveCamera(CameraUpdateFactory.newLatLngZoom(this.Q, 16.0F));
    if (!StringUtils.e(paramString))
      this.h.setText(paramString); 
  }
  
  public void a(SearchPositionModel paramSearchPositionModel) {
    PoiItem poiItem = new PoiItem("", new LatLonPoint(paramSearchPositionModel.lat, paramSearchPositionModel.lon), "", "");
    this.P = poiItem;
    this.W.setVisibility(8);
    this.Q = new LatLng(poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude());
    this.C.moveCamera(CameraUpdateFactory.newLatLngZoom(this.Q, 16.0F));
    if (!StringUtils.e(paramSearchPositionModel.name))
      this.h.setText(paramSearchPositionModel.name); 
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    if (paramBoolean1)
      this.o = 1; 
    int i = this.q;
    int j = this.o;
    FilterEntity filterEntity = new FilterEntity();
    filterEntity.f = "map";
    filterEntity.sort_by = "index";
    filterEntity.source = "map";
    filterEntity.longitude = String.valueOf(this.H.longitude);
    filterEntity.latitude = String.valueOf(this.H.latitude);
    filterEntity.nickName = "";
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.q);
    stringBuilder.append("");
    filterEntity.limit = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(i * (j - 1));
    stringBuilder.append("");
    filterEntity.start = stringBuilder.toString();
    filterEntity.column = PeopleGridQuickAdapter.a((Context)getActivity());
    if (paramBoolean2)
      filterEntity.is_map_ok_click = "click"; 
    if (this.o == 1) {
      NearbyHttpUtils.a((Context)getActivity(), this.d, filterEntity, "", null);
      return;
    } 
    filterEntity.next_min_dist = this.r;
    filterEntity.next_skip_uid = this.s;
    NearbyHttpUtils.a((Context)getActivity(), this.d, filterEntity, "", null);
  }
  
  public void activate(LocationSource.OnLocationChangedListener paramOnLocationChangedListener) {
    this.L = paramOnLocationChangedListener;
    if (this.M == null) {
      this.M = new AMapLocationClient((Context)getActivity());
      this.N = new AMapLocationClientOption();
      this.M.setLocationListener(this);
      this.N.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
      this.N.setOnceLocation(true);
      this.M.setLocationOption(this.N);
      this.M.startLocation();
    } 
  }
  
  public void deactivate() {
    this.L = null;
    AMapLocationClient aMapLocationClient = this.M;
    if (aMapLocationClient != null) {
      aMapLocationClient.stopLocation();
      this.M.onDestroy();
    } 
    this.M = null;
  }
  
  public void k() {
    this.R = new PeopleGridQuickAdapter(new ArrayList(), (Activity)getActivity(), (IRequestHost)w_(), "map_find", this.l);
    this.R.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            FindSearchMapActivity.b(this.a);
            this.a.a(false, false);
          }
        }this.l);
    this.l.setAdapter((RecyclerView.Adapter)this.R);
    GridLayoutManager gridLayoutManager = new GridLayoutManager((Context)getActivity(), this.T);
    this.l.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) {
          public int getSpanSize(int param1Int) {
            int i = FindSearchMapActivity.c(this.c);
            if (FindSearchMapActivity.d(this.c).e(param1Int) != null) {
              param1Int = FindSearchMapActivity.d(this.c).getItemViewType(param1Int);
              if (param1Int != 10)
                return (param1Int != 11) ? FindSearchMapActivity.c(this.c) : FindSearchMapActivity.c(this.c); 
              i = 1;
            } 
            return i;
          }
        });
  }
  
  public void l() {
    this.W.setVisibility(8);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 != 1)
        return; 
      if (paramIntent != null) {
        this.O = paramIntent.getStringExtra("search_position");
        this.P = (PoiItem)paramIntent.getParcelableExtra("lat_lon_point");
        this.Q = new LatLng(this.P.getLatLonPoint().getLatitude(), this.P.getLatLonPoint().getLongitude());
        this.C.moveCamera(CameraUpdateFactory.newLatLngZoom(this.Q, 16.0F));
        if (!StringUtils.e(this.O))
          this.h.setText(this.O); 
      } 
    } 
  }
  
  public void onCameraChange(CameraPosition paramCameraPosition) {
    if (paramCameraPosition != null)
      LatLng latLng = paramCameraPosition.target; 
  }
  
  public void onCameraChangeFinish(CameraPosition paramCameraPosition) {
    if (paramCameraPosition != null) {
      this.P = null;
      LatLng latLng = new LatLng(paramCameraPosition.target.latitude, paramCameraPosition.target.longitude);
      this.H = latLng;
      this.K = AMapUtils.calculateLineDistance(this.G, latLng) / 1000.0D;
      a(new LatLonPoint(paramCameraPosition.target.latitude, paramCameraPosition.target.longitude));
      if (this.K > 0.05D)
        this.i.setImageResource(2131232689); 
    } 
  }
  
  public void onClick(View paramView) {
    GuyProtos.Event event1;
    VipProtos.Event event;
    LatLng latLng;
    int i = paramView.getId();
    boolean bool2 = false;
    boolean bool1 = false;
    switch (i) {
      default:
        return;
      case 2131301335:
        A();
        return;
      case 2131301334:
        D();
        return;
      case 2131301130:
        InstantLog.a("map_find_do_search");
        event1 = GuyProtos.Event.NEARBY_FRIEND_MAP_FIND_CONFIRM_CLICK;
        if ((BluedConfig.b().j()).is_chat_shadow == 1)
          bool1 = true; 
        EventTrackGuy.c(event1, bool1);
        B();
        return;
      case 2131300611:
        D();
        return;
      case 2131299930:
        event = VipProtos.Event.MAP_FIND_SETTINGS_BTN_CLICK;
        bool1 = bool2;
        if ((BluedConfig.b().j()).is_chat_shadow == 1)
          bool1 = true; 
        EventTrackVIP.a(event, bool1);
        b(true, true);
        return;
      case 2131297914:
        latLng = this.G;
        if (latLng != null) {
          this.C.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0F));
          this.i.setImageResource(2131232690);
          return;
        } 
        return;
      case 2131296867:
        InstantLog.a("map_find_setting_click");
        MapFinderSettingFragment.a((Context)getActivity());
        return;
      case 2131296863:
        break;
    } 
    EventTrackVIP.a(VipProtos.Event.MAP_FIND_BACK_BTN_CLICK);
    D();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.U = paramLayoutInflater.inflate(2131492902, null);
    this.af = (Context)getActivity();
    m();
    q();
    r();
    p();
    a(paramBundle);
    if (y()) {
      n();
      AppInfo.n().postDelayed(new Runnable(this) {
            public void run() {
              FindSearchMapActivity.a(this.a, true, true);
            }
          }800L);
    } else {
      AppInfo.n().postDelayed(new Runnable(this) {
            public void run() {
              FindSearchMapActivity.a(this.a);
            }
          },  800L);
      b(false, false);
    } 
    return this.U;
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.t.onDestroy();
    AMapLocationClient aMapLocationClient = this.M;
    if (aMapLocationClient != null)
      aMapLocationClient.onDestroy(); 
    if (HomeActivity.c != null)
      HomeActivity.c.getWindow().setSoftInputMode(35); 
  }
  
  public void onGeocodeSearched(GeocodeResult paramGeocodeResult, int paramInt) {
    if (paramInt == 1000 && paramGeocodeResult != null && paramGeocodeResult.getGeocodeAddressList() != null && paramGeocodeResult.getGeocodeAddressList().size() > 0) {
      GeocodeAddress geocodeAddress = paramGeocodeResult.getGeocodeAddressList().get(0);
      this.C.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(geocodeAddress.getLatLonPoint().getLatitude(), geocodeAddress.getLatLonPoint().getLongitude()), 16.0F));
    } 
  }
  
  public void onLocationChanged(AMapLocation paramAMapLocation) {
    if (this.L != null && paramAMapLocation != null) {
      if (paramAMapLocation.getErrorCode() == 0) {
        this.G = new LatLng(paramAMapLocation.getLatitude(), paramAMapLocation.getLongitude());
        this.H = this.G;
        this.F = paramAMapLocation.getCity();
        this.L.onLocationChanged((Location)paramAMapLocation);
        this.C.moveCamera(CameraUpdateFactory.newLatLngZoom(this.H, 16.0F));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramAMapLocation.getProvince());
        stringBuilder.append(paramAMapLocation.getCity());
        stringBuilder.append(paramAMapLocation.getDistrict());
        this.I = stringBuilder.toString();
        this.J = paramAMapLocation.getAddress();
      } else {
        this.I = "";
        this.J = "";
        AppMethods.d(2131758329);
      } 
      this.I = "";
      this.J = "";
    } 
    if (z()) {
      a(this.J);
      return;
    } 
    a(this.I);
  }
  
  public void onPause() {
    super.onPause();
    MobclickAgent.onPageEnd(FindSearchMapActivity.class.getSimpleName());
    MobclickAgent.onPause((Context)getActivity());
    this.t.onPause();
    deactivate();
  }
  
  public void onRegeocodeSearched(RegeocodeResult paramRegeocodeResult, int paramInt) {
    if (paramInt == 1000) {
      if (paramRegeocodeResult != null && paramRegeocodeResult.getRegeocodeAddress() != null && paramRegeocodeResult.getRegeocodeAddress().getFormatAddress() != null) {
        RegeocodeAddress regeocodeAddress = paramRegeocodeResult.getRegeocodeAddress();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(regeocodeAddress.getProvince());
        stringBuilder.append(regeocodeAddress.getCity());
        stringBuilder.append(regeocodeAddress.getDistrict());
        this.I = stringBuilder.toString();
        this.J = regeocodeAddress.getFormatAddress();
        stringBuilder = new StringBuilder();
        stringBuilder.append("街道:");
        stringBuilder.append(regeocodeAddress.getCrossroads());
        stringBuilder.append(" -- ");
        stringBuilder.append(regeocodeAddress.getFormatAddress());
        stringBuilder.append(" -- ");
        stringBuilder.append(regeocodeAddress.getStreetNumber());
        stringBuilder.append(" -- ");
        stringBuilder.append(regeocodeAddress.getNeighborhood());
        stringBuilder.append(" -- ");
        stringBuilder.append(regeocodeAddress.getBuilding());
        Log.v("drb", stringBuilder.toString());
      } else {
        this.I = "";
      } 
    } else {
      this.I = "";
    } 
    if (z()) {
      a(this.J);
      return;
    } 
    a(this.I);
  }
  
  public void onResume() {
    this.t.onResume();
    super.onResume();
    MobclickAgent.onPageStart(FindSearchMapActivity.class.getSimpleName());
    MobclickAgent.onResume((Context)getActivity());
    if (this.v.getVisibility() == 0)
      v(); 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    this.t.onSaveInstanceState(paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\FindSearchMapActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */