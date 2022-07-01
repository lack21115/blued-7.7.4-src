package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.das.guy.GuyProtos;
import com.blued.das.vip.VipProtos;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.find.adapter.VisitorListAdapter;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.model.BluedMyVisitorList;
import com.soft.blued.ui.find.model.BluedVisitorExtra;
import com.soft.blued.ui.find.model.VisitorCountExtra;
import com.soft.blued.ui.find.view.ImageLineChartRenderer;
import com.soft.blued.ui.find.view.VisitorChartMarkerView;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Date;

public class MyVisitorFragment extends PreloadFragment implements VIPBuyResultObserver.IVIPBuyResultObserver {
  private View A;
  
  private View B;
  
  private View C;
  
  private LayoutInflater D;
  
  private VisitorListAdapter E;
  
  private int F;
  
  private int G;
  
  private boolean H = true;
  
  private NoDataAndLoadFailView I;
  
  private boolean J = false;
  
  private LineChart K;
  
  private View L;
  
  private View M;
  
  private View N;
  
  private TextView O;
  
  private TextView P;
  
  private TextView Q;
  
  private TextView R;
  
  private TextView S;
  
  private TextView T;
  
  BluedUIHttpResponse o = new BluedUIHttpResponse<BluedEntityA<VisitorCountExtra>>(this, (IRequestHost)w_()) {
      protected void a(BluedEntityA<VisitorCountExtra> param1BluedEntityA) {
        if (param1BluedEntityA != null && param1BluedEntityA.data != null) {
          if (param1BluedEntityA.data.size() == 0)
            return; 
          if (MyVisitorFragment.d(this.a).getVisibility() == 0)
            MyVisitorFragment.a(this.a, (VisitorCountExtra)param1BluedEntityA.getSingleData()); 
          if (((VisitorCountExtra)param1BluedEntityA.getSingleData()).new_user == 1)
            MyVisitorFragment.e(this.a).setVisibility(8); 
          if ((UserInfo.a().i()).vip_grade != 0)
            MyVisitorFragment.f(this.a).setText(AreaUtils.a(MyVisitorFragment.c(this.a), Long.valueOf(((VisitorCountExtra)param1BluedEntityA.getSingleData()).history))); 
          if ((UserInfo.a().i()).vip_grade != 0) {
            if (((VisitorCountExtra)param1BluedEntityA.getSingleData()).increase == 0L) {
              MyVisitorFragment.g(this.a).setVisibility(8);
            } else {
              String str = AreaUtils.a(MyVisitorFragment.c(this.a), Long.valueOf(((VisitorCountExtra)param1BluedEntityA.getSingleData()).increase));
              if (!StringUtils.e(str)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("+");
                stringBuilder.append(str);
                str = stringBuilder.toString();
                MyVisitorFragment.g(this.a).setText(str);
                MyVisitorFragment.g(this.a).setVisibility(0);
              } 
            } 
          } else {
            MyVisitorFragment.g(this.a).setVisibility(8);
          } 
          MyVisitorFragment.h(this.a).setText(AreaUtils.a(MyVisitorFragment.c(this.a), Long.valueOf(((VisitorCountExtra)param1BluedEntityA.getSingleData()).today)));
          if (!MyVisitorFragment.i(this.a)) {
            MyVisitorFragment.b(this.a, true);
            MyVisitorFragment.k(this.a).addHeaderView(MyVisitorFragment.j(this.a));
            MyVisitorFragment.l(this.a).notifyDataSetChanged();
          } 
          if (((VisitorCountExtra)param1BluedEntityA.getSingleData()).visitors_is_complete_rate == 1)
            MyVisitorFragment.m(this.a); 
        } 
      }
      
      public void onUIStart() {
        super.onUIStart();
      }
    };
  
  BluedUIHttpResponse p = new BluedUIHttpResponse<BluedEntity<BluedMyVisitorList, BluedVisitorExtra>>(this, (IRequestHost)w_()) {
      boolean a;
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        if (MyVisitorFragment.n(this.b) != 1)
          MyVisitorFragment.o(this.b); 
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        MyVisitorFragment.a(this.b).j();
        MyVisitorFragment.a(this.b).q();
        if (MyVisitorFragment.l(this.b).getCount() == 0) {
          if (this.a) {
            MyVisitorFragment.p(this.b).b();
          } else {
            MyVisitorFragment.p(this.b).a();
          } 
        } else {
          MyVisitorFragment.p(this.b).c();
        } 
        MyVisitorFragment.l(this.b).notifyDataSetChanged();
        this.a = false;
      }
      
      public void onUIUpdate(BluedEntity<BluedMyVisitorList, BluedVisitorExtra> param1BluedEntity) {
        // Byte code:
        //   0: aload_1
        //   1: ifnull -> 134
        //   4: aload_1
        //   5: getfield data : Ljava/util/List;
        //   8: ifnull -> 134
        //   11: aload_1
        //   12: getfield data : Ljava/util/List;
        //   15: invokeinterface size : ()I
        //   20: ifle -> 134
        //   23: aload_1
        //   24: invokevirtual hasMore : ()Z
        //   27: ifeq -> 52
        //   30: aload_0
        //   31: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   34: iconst_1
        //   35: invokestatic c : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;Z)Z
        //   38: pop
        //   39: aload_0
        //   40: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   43: invokestatic a : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   46: invokevirtual o : ()V
        //   49: goto -> 71
        //   52: aload_0
        //   53: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   56: iconst_0
        //   57: invokestatic c : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;Z)Z
        //   60: pop
        //   61: aload_0
        //   62: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   65: invokestatic a : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   68: invokevirtual p : ()V
        //   71: aload_0
        //   72: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   75: invokestatic n : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)I
        //   78: iconst_1
        //   79: if_icmpne -> 118
        //   82: aload_0
        //   83: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   86: invokestatic l : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)Lcom/soft/blued/ui/find/adapter/VisitorListAdapter;
        //   89: aload_1
        //   90: getfield data : Ljava/util/List;
        //   93: iconst_1
        //   94: invokevirtual a : (Ljava/util/List;I)V
        //   97: aload_0
        //   98: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   101: invokestatic l : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)Lcom/soft/blued/ui/find/adapter/VisitorListAdapter;
        //   104: aload_1
        //   105: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
        //   108: checkcast com/soft/blued/ui/find/model/BluedVisitorExtra
        //   111: getfield last_visit_time : Ljava/lang/String;
        //   114: invokevirtual a : (Ljava/lang/String;)V
        //   117: return
        //   118: aload_0
        //   119: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   122: invokestatic l : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)Lcom/soft/blued/ui/find/adapter/VisitorListAdapter;
        //   125: aload_1
        //   126: getfield data : Ljava/util/List;
        //   129: iconst_1
        //   130: invokevirtual b : (Ljava/util/List;I)V
        //   133: return
        //   134: aload_0
        //   135: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   138: invokestatic n : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)I
        //   141: iconst_1
        //   142: if_icmpne -> 160
        //   145: aload_0
        //   146: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   149: invokestatic l : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)Lcom/soft/blued/ui/find/adapter/VisitorListAdapter;
        //   152: aload_1
        //   153: getfield data : Ljava/util/List;
        //   156: iconst_1
        //   157: invokevirtual a : (Ljava/util/List;I)V
        //   160: aload_0
        //   161: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   164: invokestatic a : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   167: invokevirtual p : ()V
        //   170: aload_0
        //   171: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   174: invokestatic n : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)I
        //   177: iconst_1
        //   178: if_icmpeq -> 198
        //   181: aload_0
        //   182: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   185: invokestatic o : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)I
        //   188: pop
        //   189: aload_0
        //   190: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   193: iconst_0
        //   194: invokestatic c : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;Z)Z
        //   197: pop
        //   198: aload_0
        //   199: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   202: invokestatic c : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)Landroid/content/Context;
        //   205: invokevirtual getResources : ()Landroid/content/res/Resources;
        //   208: ldc 2131756083
        //   210: invokevirtual getString : (I)Ljava/lang/String;
        //   213: invokestatic a : (Ljava/lang/CharSequence;)V
        //   216: return
        //   217: astore_1
        //   218: aload_1
        //   219: invokevirtual printStackTrace : ()V
        //   222: aload_0
        //   223: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   226: invokestatic c : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)Landroid/content/Context;
        //   229: invokevirtual getResources : ()Landroid/content/res/Resources;
        //   232: ldc 2131756082
        //   234: invokevirtual getString : (I)Ljava/lang/String;
        //   237: invokestatic a : (Ljava/lang/CharSequence;)V
        //   240: aload_0
        //   241: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   244: invokestatic n : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)I
        //   247: iconst_1
        //   248: if_icmpeq -> 259
        //   251: aload_0
        //   252: getfield b : Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;
        //   255: invokestatic o : (Lcom/soft/blued/ui/find/fragment/MyVisitorFragment;)I
        //   258: pop
        //   259: return
        // Exception table:
        //   from	to	target	type
        //   4	49	217	java/lang/Exception
        //   52	71	217	java/lang/Exception
        //   71	117	217	java/lang/Exception
        //   118	133	217	java/lang/Exception
        //   134	160	217	java/lang/Exception
        //   160	198	217	java/lang/Exception
        //   198	216	217	java/lang/Exception
      }
      
      public BluedEntity<BluedMyVisitorList, BluedVisitorExtra> parseData(String param1String) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("visitor:");
        stringBuilder.append(param1String);
        Logger.a("ad_extra", stringBuilder.toString());
        return super.parseData(param1String);
      }
    };
  
  private Context q;
  
  private View r;
  
  private RenrenPullToRefreshListView s;
  
  private ListView t;
  
  private View u;
  
  private View v;
  
  private ImageView w;
  
  private TextView x;
  
  private TextView y;
  
  private TextView z;
  
  private void a(int paramInt, long paramLong) {
    this.B.setVisibility(8);
    BluedPreferences.v(paramInt + 1);
    BluedPreferences.l(paramLong);
    if (!PopMenuUtils.a(this.q))
      ModifyUserInfoFragment.a(this.q, 0, false); 
  }
  
  private void a(VisitorCountExtra paramVisitorCountExtra) {
    if (BluedConfig.b().p() == 1) {
      this.R.setText(this.q.getResources().getString(2131758325));
    } else {
      this.R.setText(this.q.getResources().getString(2131758324));
    } 
    if (paramVisitorCountExtra.ratio > 0 && ((UserInfo.a().i()).vip_grade != 0 || (BluedConfig.b().j()).is_advanced_recently_view == 1) && BluedConfig.b().o()) {
      this.L.setVisibility(0);
      this.R.setVisibility(0);
      this.P.setText(paramVisitorCountExtra.label);
      TextView textView = this.O;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("↓");
      stringBuilder.append(paramVisitorCountExtra.ratio);
      stringBuilder.append("%");
      textView.setText(stringBuilder.toString());
    } else {
      this.L.setVisibility(8);
      this.R.setVisibility(8);
      if (paramVisitorCountExtra.show_shadow_btn == 1) {
        EventTrackVIP.a(VipProtos.Event.VISIT_PAGE_SHADOW_BTN_SHOW);
        this.T.setVisibility(0);
        this.R.setVisibility(4);
      } else {
        this.T.setVisibility(8);
      } 
    } 
    ArrayList<Entry> arrayList = new ArrayList();
    if (paramVisitorCountExtra.history_track != null) {
      int k;
      for (k = 0; k < paramVisitorCountExtra.history_track.size(); k++)
        arrayList.add(new Entry(k, (float)((VisitorCountExtra._history_track)paramVisitorCountExtra.history_track.get(k)).count, paramVisitorCountExtra.history_track.get(k))); 
    } 
    if (arrayList.size() > 0) {
      int k = 0;
      float f;
      for (f = 0.0F; k < arrayList.size(); f = f1) {
        float f1 = f;
        if (((Entry)arrayList.get(k)).b() >= f)
          f1 = ((Entry)arrayList.get(k)).b(); 
        k++;
      } 
      f *= 1.5F;
      Logger.c("ljx_visit_chart_ymax", new Object[] { Float.valueOf(f) });
      YAxis yAxis = this.K.getAxisLeft();
      if (f > 0.0F)
        yAxis.b(f); 
    } 
    if (arrayList.size() == 0) {
      this.L.setVisibility(8);
      this.M.setVisibility(8);
      this.N.setVisibility(8);
      this.R.setVisibility(8);
      return;
    } 
    if (this.K.getData() != null && ((LineData)this.K.getData()).d() > 0) {
      ((LineDataSet)((LineData)this.K.getData()).a(0)).a(arrayList);
      ((LineData)this.K.getData()).b();
      this.K.h();
      return;
    } 
    LineDataSet lineDataSet = new LineDataSet(arrayList, "");
    lineDataSet.d(7.0F);
    lineDataSet.a(LineDataSet.Mode.c);
    lineDataSet.c(0.2F);
    if (Build.VERSION.SDK_INT >= 18)
      lineDataSet.d(true); 
    lineDataSet.c(false);
    lineDataSet.e(1.8F);
    lineDataSet.a(true);
    lineDataSet.f(true);
    lineDataSet.c(this.q.getResources().getColor(2131100969));
    int i = this.q.getResources().getColor(2131100969);
    int j = this.q.getResources().getColor(2131100528);
    lineDataSet.a((Drawable)new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j }));
    lineDataSet.g(100);
    lineDataSet.e(false);
    lineDataSet.a(new -$$Lambda$MyVisitorFragment$ClNYvCaxuGQdXg0JTbYwYd8vWEs(this));
    LineData lineData = new LineData(new ILineDataSet[] { (ILineDataSet)lineDataSet });
    lineData.a(9.0F);
    lineData.a(false);
    this.K.setData((ChartData)lineData);
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.F = 1;
      if ((UserInfo.a().i()).vip_grade == 0 && (BluedConfig.b().j()).is_advanced_recently_view == 0) {
        this.A.setVisibility(0);
        this.A.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {}
            });
        this.K.setVisibility(0);
        this.L.setVisibility(0);
        this.N.setVisibility(0);
        this.S.setVisibility(0);
        this.M.setVisibility(0);
      } else {
        this.A.setVisibility(8);
        this.K.setVisibility(0);
        this.L.setVisibility(0);
        this.N.setVisibility(0);
        this.S.setVisibility(0);
        this.M.setVisibility(0);
      } 
    } 
    if (this.F == 1)
      this.H = true; 
    if (!this.H) {
      this.F--;
      AppMethods.a(this.q.getResources().getString(2131756083));
      this.s.j();
      this.s.q();
      return;
    } 
    Context context = this.q;
    BluedUIHttpResponse bluedUIHttpResponse = this.p;
    String str = UserInfo.a().i().getUid();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.F);
    stringBuilder.append("");
    MineHttpUtils.a(context, bluedUIHttpResponse, str, stringBuilder.toString(), "20", (IRequestHost)w_());
    if (!paramBoolean)
      return; 
    MineHttpUtils.a(this.q, this.o, UserInfo.a().i().getUid(), (IRequestHost)w_());
    if (UserInfo.a().i() != null && (UserInfo.a().i()).vip_grade == 0) {
      this.x.setVisibility(4);
      this.w.setVisibility(0);
      return;
    } 
    this.x.setVisibility(0);
    this.w.setVisibility(8);
  }
  
  private void v() {
    this.G = (UserInfo.a().i()).vip_grade;
  }
  
  private void w() {
    this.D = LayoutInflater.from(this.q);
    this.s = (RenrenPullToRefreshListView)this.r.findViewById(2131298144);
    this.s.setRefreshEnabled(true);
    this.t = (ListView)this.s.getRefreshableView();
    this.E = new VisitorListAdapter(this.q, (IRequestHost)w_());
    this.t.setAdapter((ListAdapter)this.E);
    this.t.setClipToPadding(false);
    this.t.setScrollBarStyle(33554432);
    this.t.setHeaderDividersEnabled(false);
    this.t.setDividerHeight(0);
    this.I = new NoDataAndLoadFailView(this.q);
    this.I.setNoDataImg(2131232637);
    this.I.setNoDataStr(2131758234);
    this.t.setEmptyView((View)this.I);
    this.s.postDelayed(new Runnable(this) {
          public void run() {
            MyVisitorFragment.a(this.a).k();
          }
        },  100L);
    this.s.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            MyVisitorFragment.a(this.a, 1);
            MyVisitorFragment.a(this.a, true);
          }
          
          public void b() {
            MyVisitorFragment.b(this.a);
            MyVisitorFragment.a(this.a, false);
          }
        });
  }
  
  private void x() {
    int i = BluedPreferences.cR();
    if (i >= 2)
      return; 
    long l = (new Date()).getTime();
    if (l - BluedPreferences.cS() < 604800000L)
      return; 
    this.B = this.r.findViewById(2131300729);
    this.C = this.u.findViewById(2131299957);
    this.B.setVisibility(0);
    EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_OLD_VISITED_SHOW);
    this.B.setOnClickListener(new View.OnClickListener(this, i, l) {
          public void onClick(View param1View) {
            EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_OLD_VISITED_CLICK);
            MyVisitorFragment.a(this.c, this.a, this.b);
          }
        });
    this.C.setOnClickListener(new View.OnClickListener(this, i, l) {
          public void onClick(View param1View) {
            EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_OLD_VISITED_CLICK);
            MyVisitorFragment.a(this.c, this.a, this.b);
          }
        });
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    if (paramBoolean)
      a(true); 
  }
  
  public void a(View paramView) {
    this.q = (Context)getActivity();
    this.r = paramView;
    this.D = LayoutInflater.from(this.q);
    View view = this.D.inflate(2131493364, null);
    ((ViewGroup)paramView).addView(view);
    w();
    t();
    v();
    VIPBuyResultObserver.a().a(this, getLifecycle());
    EventTrackGuy.b(GuyProtos.Event.NEARBY_VISIT_PAGE_SHOW);
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public void onResume() {
    super.onResume();
    if (UserInfo.a().i() != null && (UserInfo.a().i()).vip_grade != this.G && this.r != null) {
      this.G = (UserInfo.a().i()).vip_grade;
      a(true);
    } 
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void t() {
    this.u = this.D.inflate(2131493365, null);
    this.A = this.u.findViewById(2131298047);
    u();
    this.v = this.u.findViewById(2131299958);
    this.w = (ImageView)this.u.findViewById(2131297756);
    this.x = (TextView)this.u.findViewById(2131300894);
    this.y = (TextView)this.u.findViewById(2131300914);
    this.z = (TextView)this.u.findViewById(2131301430);
    this.v.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if ((UserInfo.a().i()).vip_grade == 0 && (BluedConfig.b().j()).is_advanced_recently_view == 0)
              PayUtils.a((Context)this.a.getActivity(), 12, "nearby_visit_history", VipProtos.FromType.HISTORY); 
          }
        });
  }
  
  public void u() {
    this.K = (LineChart)this.u.findViewById(2131298129);
    if (Build.VERSION.SDK_INT >= 18) {
      this.K.setVisibility(0);
    } else {
      this.K.setVisibility(4);
    } 
    this.K.setPinchZoom(false);
    this.K.getLegend().d(false);
    this.K.getAxisRight().d(false);
    this.K.setDoubleTapToZoomEnabled(false);
    Description description = new Description();
    description.d(false);
    this.K.setDescription(description);
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), 2131232826);
    if ((UserInfo.a().i()).vip_grade != 0 || (BluedConfig.b().j()).is_advanced_recently_view != 0) {
      LineChart lineChart = this.K;
      lineChart.setRenderer((DataRenderer)new ImageLineChartRenderer(lineChart, lineChart.getAnimator(), this.K.getViewPortHandler(), bitmap));
      VisitorChartMarkerView visitorChartMarkerView = new VisitorChartMarkerView(this.q, 2131493692);
      visitorChartMarkerView.setChartView((Chart)this.K);
      this.K.setMarker((IMarker)visitorChartMarkerView);
    } 
    XAxis xAxis = this.K.getXAxis();
    xAxis.d(true);
    xAxis.a(XAxis.XAxisPosition.b);
    xAxis.c(false);
    xAxis.b(true);
    xAxis.a(this.q.getResources().getColor(2131100548));
    xAxis.a(1.0F);
    xAxis.a(false);
    YAxis yAxis = this.K.getAxisLeft();
    yAxis.d(false);
    yAxis.c(false);
    yAxis.a(false);
    this.L = this.u.findViewById(2131299120);
    this.M = this.u.findViewById(2131297096);
    this.N = this.u.findViewById(2131298769);
    this.O = (TextView)this.u.findViewById(2131301448);
    this.P = (TextView)this.u.findViewById(2131301449);
    this.Q = (TextView)this.u.findViewById(2131296591);
    this.Q.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            PayUtils.a(MyVisitorFragment.c(this.a), 12, "nearby_visit_fifteen_trend", VipProtos.FromType.FIFTEEN_VISIT_TREND);
          }
        });
    this.R = (TextView)this.u.findViewById(2131301137);
    this.T = (TextView)this.u.findViewById(2131301139);
    this.S = (TextView)this.u.findViewById(2131300963);
    this.T.setOnClickListener(new -$$Lambda$MyVisitorFragment$TpO2IF1JFZEddZ2wkQw77O5HCwQ(this));
    this.R.setOnClickListener(new -$$Lambda$MyVisitorFragment$A6o6ZWassH6uUGNgMtVt_Jrel9E(this));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\MyVisitorFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */