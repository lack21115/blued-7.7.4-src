package com.soft.blued.ui.setting.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.chat.IMDebuger;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.pool.ThreadPriority;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.LogUploadHelper;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.im.biz.IMConnectorDebuger;
import com.blued.android.web.SimpleWebCallBack;
import com.blued.das.message.MessageProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.tinker.util.TinkerTools;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.NetworkUtils;
import com.soft.blued.utils.third.HuaweiChannelUtils;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

public class DebugFragment extends BaseFragment implements View.OnClickListener {
  private BluedWebView A;
  
  private EditText B;
  
  private TextView C;
  
  private boolean D;
  
  private int E;
  
  private int F;
  
  private String G;
  
  private String H;
  
  private int I;
  
  private String J;
  
  private String K;
  
  private String L;
  
  private String M;
  
  private String N;
  
  private String O;
  
  private String P;
  
  private String Q;
  
  private String R;
  
  private Context S;
  
  private int T;
  
  private String U;
  
  private String V;
  
  private String W;
  
  private String X;
  
  private String Y;
  
  private String Z;
  
  private String aa;
  
  private String ab;
  
  private String ac;
  
  private String ad;
  
  private String ae;
  
  private String af;
  
  private String ag;
  
  private String ah;
  
  private final String[] d = new String[] { "https://www.bldimg.com/test_img_10k.jpg", "https://static.blued.com/test_img_10k.jpg", "https://staticsg.bldimg.com/test_img_10k.jpg", "https://staticus.bldimg.com/test_img_10k.jpg" };
  
  private final String e;
  
  private final String f;
  
  private final String g;
  
  private final String h;
  
  private final String i;
  
  private final String j;
  
  private final String k;
  
  private final String l;
  
  private final String m;
  
  private final String n;
  
  private View o;
  
  private CommonTopTitleNoTrans p;
  
  private ShapeTextView q;
  
  private ShapeTextView r;
  
  private ProgressBar s;
  
  private ProgressBar t;
  
  private TextView u;
  
  private TextView v;
  
  private TextView w;
  
  private ShapeTextView x;
  
  private ShapeTextView y;
  
  private WebView z;
  
  public DebugFragment() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("https://");
    stringBuilder.append(BluedHttpUrl.q());
    this.e = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("https://");
    stringBuilder.append(BluedHttpUrl.v());
    this.f = stringBuilder.toString();
    this.g = BluedHttpUrl.n();
    this.h = "https://app.blued.cn/intl/speed-test";
    this.i = BluedHttpUrl.o();
    this.j = "https://www.baidu.com";
    this.k = "http://pv.sohu.com/cityjson?ie=utf-8";
    this.l = "https://pay.blued.com";
    this.m = "https://www.google.com";
    this.n = "https://ifconfig.co/json";
    this.D = false;
    this.E = 0;
    this.F = 13;
    this.O = "";
    this.T = 0;
  }
  
  private void a() {
    this.B = (EditText)this.o.findViewById(2131297017);
    this.C = (TextView)this.o.findViewById(2131300805);
    if (AppInfo.m()) {
      this.B.setVisibility(0);
      this.C.setVisibility(0);
    } else {
      this.B.setVisibility(8);
      this.C.setVisibility(8);
    } 
    this.C.setOnClickListener(new -$$Lambda$DebugFragment$3vJi4Mpsrk94KMinC53GC0u22e8(this));
    this.p = (CommonTopTitleNoTrans)this.o.findViewById(2131300273);
    this.p.setLeftClickListener(this);
    this.p.setRightClickListener(this);
    this.p.setRightTextColor(2131100838);
    this.y = (ShapeTextView)this.o.findViewById(2131300165);
    ShapeHelper.b((ShapeHelper.ShapeView)this.y, 2131100881);
    this.q = (ShapeTextView)this.o.findViewById(2131300556);
    ShapeHelper.b((ShapeHelper.ShapeView)this.q, 2131100882);
    ShapeHelper.a((ShapeHelper.ShapeView)this.q, 2131100838);
    this.q.setOnClickListener(this);
    this.r = (ShapeTextView)this.o.findViewById(2131301352);
    ShapeHelper.b((ShapeHelper.ShapeView)this.r, 2131100881);
    ShapeHelper.a((ShapeHelper.ShapeView)this.r, 2131100838);
    this.r.setOnClickListener(this);
    this.z = (WebView)this.o.findViewById(2131300004);
    this.z.setBackgroundColor(BluedSkinUtils.a(this.S, 2131100733));
    this.A = new BluedWebView((Fragment)this, this.z, null, (BluedWebView.WebCallback)new SimpleWebCallBack(this) {
          public void a(BluedWebView param1BluedWebView, int param1Int, String param1String1, String param1String2) {
            DebugFragment.a(this.c, false);
            AppMethods.d(2131756082);
          }
          
          public void a(BluedWebView param1BluedWebView, String param1String, boolean param1Boolean) {
            DebugFragment.a(this.c, true);
          }
        });
    this.u = (TextView)this.o.findViewById(2131300555);
    this.u.setOnClickListener(new -$$Lambda$DebugFragment$RJ6YuSfLNtrwb1rMy1q4lExz_fs(this));
    this.v = (TextView)this.o.findViewById(2131301101);
    this.w = (TextView)this.o.findViewById(2131301269);
    this.s = (ProgressBar)this.o.findViewById(2131299452);
    this.t = (ProgressBar)this.o.findViewById(2131299454);
    this.x = (ShapeTextView)this.o.findViewById(2131300916);
    this.x.setVisibility(8);
  }
  
  private void a(int paramInt) {
    String[] arrayOfString = this.d;
    if (paramInt >= arrayOfString.length)
      return; 
    String str = arrayOfString[paramInt];
    FileDownloader.a(str, RecyclingUtils.e(str), new FileHttpResponseHandler(this, paramInt) {
          Long a = Long.valueOf(System.currentTimeMillis());
          
          boolean b = false;
          
          public void a(File param1File) {}
          
          public void a(Throwable param1Throwable, int param1Int, File param1File) {
            this.b = true;
          }
          
          public void onFinish() {
            String str;
            super.onFinish();
            if (this.b) {
              str = " ms/failure";
            } else {
              str = " ms/success";
            } 
            int i = this.c;
            if (i == 0) {
              DebugFragment debugFragment = this.d;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(System.currentTimeMillis() - this.a.longValue());
              stringBuilder.append(str);
              DebugFragment.k(debugFragment, stringBuilder.toString());
            } else if (i == 1) {
              DebugFragment debugFragment = this.d;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(System.currentTimeMillis() - this.a.longValue());
              stringBuilder.append(str);
              DebugFragment.l(debugFragment, stringBuilder.toString());
            } else if (i == 2) {
              DebugFragment debugFragment = this.d;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(System.currentTimeMillis() - this.a.longValue());
              stringBuilder.append(str);
              DebugFragment.m(debugFragment, stringBuilder.toString());
            } else if (i == 3) {
              DebugFragment debugFragment = this.d;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(System.currentTimeMillis() - this.a.longValue());
              stringBuilder.append(str);
              DebugFragment.n(debugFragment, stringBuilder.toString());
            } 
            this.d.a(new Runnable(this) {
                  public void run() {
                    DebugFragment.g(this.a.d);
                    DebugFragment.h(this.a.d);
                    DebugFragment.a(this.a.d, this.a.c + 1);
                  }
                });
          }
        }null);
  }
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, DebugFragment.class, null);
  }
  
  private void a(String paramString) {
    ThreadManager.a().a(new ThreadExecutor(this, "getIp", ThreadPriority.b, paramString) {
          public void execute() {
            String str1;
            String str2 = "x.x.x.x";
            try {
              str1 = (new URL(this.a)).getHost();
              String[] arrayOfString = HappyDnsUtils.d().query(str1);
              str1 = str2;
              if (arrayOfString != null) {
                str1 = str2;
                if (arrayOfString.length > 0)
                  str1 = arrayOfString[0]; 
              } 
            } catch (IOException iOException) {
              str1 = str2;
            } 
            if (this.a.equals(DebugFragment.b(this.b))) {
              DebugFragment.a(this.b, str1);
            } else if (this.a.equals(DebugFragment.c(this.b))) {
              DebugFragment.b(this.b, str1);
            } else if (this.a.equals(DebugFragment.d(this.b))) {
              DebugFragment.c(this.b, str1);
            } else if (this.a.equals(DebugFragment.e(this.b)) || this.a.equals("https://pay.blued.com")) {
              DebugFragment.d(this.b, str1);
            } else if (this.a.equals(DebugFragment.f(this.b)[0])) {
              DebugFragment.e(this.b, str1);
            } else if (this.a.equals(DebugFragment.f(this.b)[1])) {
              DebugFragment.f(this.b, str1);
            } else if (this.a.equals(DebugFragment.f(this.b)[2])) {
              DebugFragment.g(this.b, str1);
            } else if (this.a.equals(DebugFragment.f(this.b)[3])) {
              DebugFragment.h(this.b, str1);
            } 
            this.b.a(new Runnable(this) {
                  public void run() {
                    DebugFragment.g(this.a.b);
                    DebugFragment.h(this.a.b);
                  }
                });
          }
        });
  }
  
  private void b(String paramString) {
    HttpManager.a(paramString, (HttpResponseHandler)new StringHttpResponseHandler(this, true, paramString) {
          public void a(String param1String) {
            if (this.a.equals("https://www.baidu.com") || this.a.contains("https://www.google.com")) {
              DebugFragment.i(this.b, "200");
              return;
            } 
            if (this.a.equals("http://pv.sohu.com/cityjson?ie=utf-8") || this.a.equals("https://ifconfig.co/json")) {
              DebugFragment.j(this.b, param1String);
              return;
            } 
          }
          
          public void a(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            if (this.a.equals("https://www.baidu.com") || this.a.contains("https://www.google.com")) {
              DebugFragment.i(this.b, String.valueOf(param1Int));
              return;
            } 
            if (this.a.equals("http://pv.sohu.com/cityjson?ie=utf-8") || this.a.equals("https://ifconfig.co/json")) {
              DebugFragment.j(this.b, String.valueOf(param1Int));
              return;
            } 
          }
          
          public void onFinish() {
            super.onFinish();
            this.b.a(new Runnable(this) {
                  public void run() {
                    DebugFragment.g(this.a.b);
                    DebugFragment.h(this.a.b);
                  }
                });
          }
        }(IRequestHost)w_()).b(BluedHttpTools.a(false)).i();
  }
  
  private void c(String paramString) {
    ClipData clipData;
    if (Build.VERSION.SDK_INT != 18) {
      ClipboardManager clipboardManager = (ClipboardManager)this.S.getSystemService("clipboard");
      clipData = ClipData.newPlainText("simple text", RegExpUtils.a(paramString));
      if (clipboardManager != null)
        clipboardManager.setPrimaryClip(clipData); 
    } else {
      ((ClipboardManager)this.S.getSystemService("clipboard")).setText(RegExpUtils.a((String)clipData));
    } 
    AppMethods.a(this.S.getResources().getString(2131756130));
  }
  
  private void k() {
    String str;
    this.s.setVisibility(0);
    this.p.a();
    this.U = "";
    this.V = "";
    this.W = "";
    this.X = "";
    this.Y = "";
    this.Z = "";
    this.aa = "";
    this.ab = "";
    this.ac = "";
    this.ad = "";
    this.ae = "";
    this.af = "";
    this.ag = "";
    this.ah = "";
    this.G = AppInfo.e();
    this.H = UserInfo.a().i().getName();
    this.I = DeviceUtils.b();
    this.J = TinkerTools.a();
    this.K = AppInfo.c;
    this.L = TimeZone.getDefault().getID();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(AppInfo.d);
    stringBuilder.append("_");
    stringBuilder.append(AppMethods.a());
    this.M = stringBuilder.toString();
    this.N = BlueAppLocal.c().getLanguage();
    this.O = NetworkUtils.d();
    if (TextUtils.isEmpty(this.O)) {
      this.O = "no network";
    } else if (!TextUtils.equals(this.O, "wifi")) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.O);
      stringBuilder.append(" ");
      stringBuilder.append(NetworkUtils.e());
      this.O = stringBuilder.toString();
    } 
    this.P = IMDebuger.getIMInformation();
    this.Q = IMDebuger.getLastReceivePackageInfo();
    stringBuilder = new StringBuilder();
    stringBuilder.append(IMConnectorDebuger.c());
    stringBuilder.append(", ");
    stringBuilder.append(IMConnectorDebuger.d());
    this.R = stringBuilder.toString();
    a(this.e);
    a(this.f);
    a(this.g);
    if ("1".equals(this.G)) {
      str = this.i;
    } else {
      str = "https://pay.blued.com";
    } 
    a(str);
    int i = 0;
    while (true) {
      String str1;
      String[] arrayOfString = this.d;
      if (i < arrayOfString.length) {
        a(arrayOfString[i]);
        i++;
        continue;
      } 
      if ("1".equals(this.G)) {
        str1 = "https://www.baidu.com";
      } else {
        str1 = "https://www.google.com";
      } 
      b(str1);
      if ("1".equals(this.G)) {
        str1 = "http://pv.sohu.com/cityjson?ie=utf-8";
      } else {
        str1 = "https://ifconfig.co/json";
      } 
      b(str1);
      a(0);
      return;
    } 
  }
  
  private void l() {
    this.t.setVisibility(0);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/blued/monitor/report");
    String str = stringBuilder1.toString();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.u.getText());
    stringBuilder2.append("\n");
    stringBuilder2.append(this.v.getText());
    hashMap.put("contents", stringBuilder2.toString());
    HttpManager.b(str, (HttpResponseHandler)new StringHttpResponseHandler(this, true) {
          String a = "";
          
          public void a(String param1String) {
            this.a = param1String;
          }
          
          public void a(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("failure, code:");
            stringBuilder.append(param1Int);
            this.a = stringBuilder.toString();
          }
          
          public void onFinish() {
            super.onFinish();
            this.b.a(new Runnable(this) {
                  public void run() {
                    DebugFragment.i(this.a.b).b();
                    DebugFragment.j(this.a.b).setVisibility(8);
                    DebugFragment.k(this.a.b).setText(this.a.a);
                  }
                });
          }
        }).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).i();
  }
  
  private void m() {
    try {
      Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      calendar.setTimeInMillis(Long.valueOf(1623319966708L).longValue());
      str2 = (new SimpleDateFormat("yyyy-MM-dd,HH:mm", BlueAppLocal.c())).format(calendar.getTime());
    } catch (Exception exception) {
      str2 = "";
    } 
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("Name:");
    stringBuilder3.append(this.H);
    stringBuilder3.append("    Language:");
    stringBuilder3.append(this.N);
    stringBuilder3.append("\nApp version:");
    stringBuilder3.append(this.I);
    stringBuilder3.append("    patch:");
    stringBuilder3.append(this.J);
    stringBuilder3.append("    Channel:");
    stringBuilder3.append(this.K);
    stringBuilder3.append("\nTimezone:");
    stringBuilder3.append(this.L);
    stringBuilder3.append("\nDevices:");
    stringBuilder3.append(this.M);
    stringBuilder3.append("\nBuild Time:");
    stringBuilder3.append(str2);
    String str3 = stringBuilder3.toString();
    String str2 = str3;
    if (AppInfo.m()) {
      str2 = str3;
      if (b(this.S) != null) {
        str2 = str3;
        if ((b(this.S)).length == 2) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str3);
          stringBuilder.append("\nDevice Info:{\"device_id\"=\"");
          stringBuilder.append(b(this.S)[0]);
          stringBuilder.append("\",\"mac\":\"");
          stringBuilder.append(b(this.S)[1]);
          stringBuilder.append("\"}");
          str2 = stringBuilder.toString();
        } 
      } 
    } 
    str3 = str2;
    if (AppInfo.c.equalsIgnoreCase("a0031a")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append("\nTrackID:");
      stringBuilder.append(HuaweiChannelUtils.a(this.S));
      str3 = stringBuilder.toString();
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str3);
    stringBuilder1.append("\nIM gRPC:");
    stringBuilder1.append(FlexDebugSevConfig.a().d());
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append("\nLive gRPC:");
    stringBuilder2.append(FlexDebugSevConfig.a().e());
    str1 = stringBuilder2.toString();
    this.u.setText(str1);
    this.u.setOnLongClickListener(new -$$Lambda$DebugFragment$lno-0VolOaXvWFteWLPtuSZr73c(this));
    TextView textView = this.v;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Network:");
    stringBuilder2.append(this.O);
    stringBuilder2.append("\nWeb Test:");
    stringBuilder2.append(this.U);
    stringBuilder2.append("\nIfconfig:");
    stringBuilder2.append(this.V);
    stringBuilder2.append("\n\nIM State:");
    stringBuilder2.append(this.P);
    stringBuilder2.append("\nLast Package:");
    stringBuilder2.append(this.Q);
    stringBuilder2.append("\n\n");
    stringBuilder2.append(this.R);
    stringBuilder2.append("\n\nh4-->");
    stringBuilder2.append(this.W);
    stringBuilder2.append("\nh8-->");
    stringBuilder2.append(this.X);
    stringBuilder2.append("\nar-->");
    stringBuilder2.append(this.Y);
    stringBuilder2.append("\npa-->");
    stringBuilder2.append(this.Z);
    stringBuilder2.append("\n\nww-->");
    stringBuilder2.append(this.aa);
    stringBuilder2.append("    ");
    stringBuilder2.append(this.ae);
    stringBuilder2.append("\nst-->");
    stringBuilder2.append(this.ab);
    stringBuilder2.append("    ");
    stringBuilder2.append(this.af);
    stringBuilder2.append("\nsg-->");
    stringBuilder2.append(this.ac);
    stringBuilder2.append("    ");
    stringBuilder2.append(this.ag);
    stringBuilder2.append("\nus-->");
    stringBuilder2.append(this.ad);
    stringBuilder2.append("    ");
    stringBuilder2.append(this.ah);
    textView.setText(stringBuilder2.toString());
    if (this.E == this.F) {
      this.E = 0;
      this.s.setVisibility(8);
      l();
    } 
  }
  
  public String[] b(Context paramContext) {
    String[] arrayOfString = new String[2];
    if (paramContext != null)
      try {
        arrayOfString[0] = DeviceConfig.getDeviceIdForGeneral(paramContext);
        arrayOfString[1] = DeviceConfig.getMac(paramContext);
        return arrayOfString;
      } catch (Exception exception) {
        return arrayOfString;
      }  
    return arrayOfString;
  }
  
  public void onClick(View paramView) {
    StringBuilder stringBuilder;
    String str;
    switch (paramView.getId()) {
      default:
        return;
      case 2131301352:
        this.z.setVisibility(0);
        if (!this.D)
          this.A.a("https://app.blued.cn/intl/speed-test"); 
        ShapeHelper.b((ShapeHelper.ShapeView)this.q, 2131100881);
        ShapeHelper.b((ShapeHelper.ShapeView)this.r, 2131100882);
        return;
      case 2131300916:
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.u.getText());
        stringBuilder.append("\n\n");
        stringBuilder.append(this.v.getText());
        str = stringBuilder.toString();
        this.x.setEnabled(false);
        ShapeHelper.b((ShapeHelper.ShapeView)this.x, 2131100808);
        this.x.setText("Uploading, please wait.");
        (new LogUploadHelper(getActivity().getApplication())).a(BluedHttpUrl.n(), str, new LogUploadHelper.OnUploadListener(this) {
              public void a() {
                DebugFragment.a(this.a).setEnabled(true);
                Log.e("LogUploadHelper", "onFail");
                DebugFragment.a(this.a).setText("Operation failed. Please try again.");
                AppMethods.a("upload fail");
              }
              
              public void a(String param1String) {
                Log.e("LogUploadHelper", "onSuccess");
                DebugFragment.a(this.a).setVisibility(8);
                AppMethods.a("upload success");
              }
            });
        return;
      case 2131300556:
        this.z.setVisibility(8);
        ShapeHelper.b((ShapeHelper.ShapeView)this.q, 2131100882);
        ShapeHelper.b((ShapeHelper.ShapeView)this.r, 2131100881);
        return;
      case 2131296867:
        this.w.setText("");
        k();
        return;
      case 2131296863:
        break;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.S = (Context)getActivity();
    View view = this.o;
    if (view == null) {
      this.o = paramLayoutInflater.inflate(2131493115, paramViewGroup, false);
      a();
      k();
      m();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.o.getParent()).removeView(this.o);
    } 
    return this.o;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\DebugFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */