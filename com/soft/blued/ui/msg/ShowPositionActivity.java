package com.soft.blued.ui.msg;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps2d.model.LatLng;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.view.PopActionSheet;
import com.blued.android.module.location.View.MapViews;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;

public class ShowPositionActivity extends BaseFragmentActivity implements View.OnClickListener {
  public int c;
  
  PopActionSheet d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private MapViews h;
  
  private LatLng i;
  
  private SparseArray j = new SparseArray();
  
  private SparseArray k = new SparseArray();
  
  private CustomDialog l;
  
  private String m;
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt) {
    PermissionHelper.c(new PermissionCallbacks(paramContext, paramString1, paramString2, paramString3, paramInt) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            Intent intent = new Intent(this.a, ShowPositionActivity.class);
            intent.putExtra("lot", this.b);
            intent.putExtra("lat", this.c);
            intent.putExtra("address", this.d);
            intent.putExtra("from", this.e);
            this.a.startActivity(intent);
          }
        });
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4) {
    PermissionHelper.c(new PermissionCallbacks(paramContext, paramString1, paramString2, paramString3, paramString4, paramInt) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            Intent intent = new Intent(this.a, ShowPositionActivity.class);
            intent.putExtra("lot", this.b);
            intent.putExtra("lat", this.c);
            intent.putExtra("address", this.d);
            intent.putExtra("uid", this.e);
            intent.putExtra("from", this.f);
            this.a.startActivity(intent);
          }
        });
  }
  
  private void b(int paramInt) {
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 4)
            return; 
          try {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("google.navigation:q=");
            stringBuilder1.append(this.f);
            stringBuilder1.append(",");
            stringBuilder1.append(this.e);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder1.toString()));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
            return;
          } catch (Exception exception) {
            Logger.e("xpf", new Object[] { exception.getMessage() });
            return;
          } 
        } 
        try {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("androidamap://navi?sourceApplication=Blued&poiname=");
          stringBuilder1.append(this.g);
          stringBuilder1.append("&lat=");
          stringBuilder1.append(this.f);
          stringBuilder1.append("&lon=");
          stringBuilder1.append(this.e);
          stringBuilder1.append("&dev=0");
          startActivity(Intent.getIntent(stringBuilder1.toString()));
          LiveFloatManager.a().l();
          return;
        } catch (Exception exception) {
          Logger.e("xpf", new Object[] { exception.getMessage() });
          return;
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("http://apis.map.qq.com/uri/v1/routeplan?type=drive&fromcoord=");
      stringBuilder.append(BluedPreferences.t());
      stringBuilder.append(",");
      stringBuilder.append(BluedPreferences.s());
      stringBuilder.append("&to=");
      stringBuilder.append(this.g);
      stringBuilder.append("&tocoord=");
      stringBuilder.append(this.f);
      stringBuilder.append(",");
      stringBuilder.append(this.e);
      stringBuilder.append("&policy=1&referer=Blued");
      WebViewShowInfoFragment.show((Context)this, stringBuilder.toString(), 9);
      return;
    } 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("intent://map/direction?destination=latlng:");
      stringBuilder.append(this.f);
      stringBuilder.append(",");
      stringBuilder.append(this.e);
      stringBuilder.append("|name:");
      stringBuilder.append(this.g);
      stringBuilder.append("&mode=driving&&coord_type=gcj02&&src=Blued#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
      startActivity(Intent.getIntent(stringBuilder.toString()));
      return;
    } catch (Exception exception) {
      Logger.e("xpf", new Object[] { exception.getMessage() });
      return;
    } 
  }
  
  private void i() {
    ((ImageView)findViewById(2131296863)).setOnClickListener(this);
    ((TextView)findViewById(2131296857)).setText(2131758405);
    TextView textView = (TextView)findViewById(2131296867);
    textView.setOnClickListener(this);
    Intent intent = getIntent();
    this.e = intent.getStringExtra("lot");
    this.f = intent.getStringExtra("lat");
    this.g = intent.getStringExtra("address");
    this.c = intent.getIntExtra("from", 0);
    this.m = intent.getStringExtra("uid");
    if (!StringUtils.e(this.e) && !StringUtils.e(this.f))
      this.i = new LatLng(Double.valueOf(this.f).doubleValue(), Double.valueOf(this.e).doubleValue()); 
    if (this.c == 1) {
      textView.setVisibility(4);
      return;
    } 
    textView.setVisibility(0);
  }
  
  private void j() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'navigation_btn'
    //   4: invokestatic a : (Ljava/lang/String;)V
    //   7: getstatic com/blued/das/message/MessageProtos$Event.NAVIGATION_BTN : Lcom/blued/das/message/MessageProtos$Event;
    //   10: aload_0
    //   11: getfield m : Ljava/lang/String;
    //   14: invokestatic d : (Lcom/blued/das/message/MessageProtos$Event;Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield d : Lcom/blued/android/module/live_china/view/PopActionSheet;
    //   21: ifnull -> 53
    //   24: aload_0
    //   25: getfield d : Lcom/blued/android/module/live_china/view/PopActionSheet;
    //   28: invokevirtual e : ()Lcom/blued/android/module/live_china/view/PopActionSheet$MyPopupWindow;
    //   31: astore #5
    //   33: aload #5
    //   35: ifnull -> 53
    //   38: aload #5
    //   40: invokevirtual isShowing : ()Z
    //   43: istore #4
    //   45: iload #4
    //   47: ifeq -> 53
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: getfield j : Landroid/util/SparseArray;
    //   57: invokevirtual clear : ()V
    //   60: aload_0
    //   61: getfield k : Landroid/util/SparseArray;
    //   64: invokevirtual clear : ()V
    //   67: aload_0
    //   68: ldc_w 'com.baidu.BaiduMap'
    //   71: invokestatic isClientAvailable : (Landroid/content/Context;Ljava/lang/String;)Z
    //   74: istore #4
    //   76: iconst_0
    //   77: istore_3
    //   78: iconst_1
    //   79: istore_2
    //   80: iload #4
    //   82: ifeq -> 397
    //   85: aload_0
    //   86: getfield j : Landroid/util/SparseArray;
    //   89: iconst_0
    //   90: iconst_1
    //   91: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   94: invokevirtual put : (ILjava/lang/Object;)V
    //   97: aload_0
    //   98: getfield k : Landroid/util/SparseArray;
    //   101: iconst_0
    //   102: aload_0
    //   103: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   106: ldc_w 2131757839
    //   109: invokevirtual getString : (I)Ljava/lang/String;
    //   112: invokevirtual put : (ILjava/lang/Object;)V
    //   115: goto -> 118
    //   118: iload_2
    //   119: istore_1
    //   120: aload_0
    //   121: ldc_w 'com.tencent.map'
    //   124: invokestatic isClientAvailable : (Landroid/content/Context;Ljava/lang/String;)Z
    //   127: ifeq -> 164
    //   130: aload_0
    //   131: getfield j : Landroid/util/SparseArray;
    //   134: iload_2
    //   135: iconst_2
    //   136: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   139: invokevirtual put : (ILjava/lang/Object;)V
    //   142: aload_0
    //   143: getfield k : Landroid/util/SparseArray;
    //   146: iload_2
    //   147: aload_0
    //   148: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   151: ldc_w 2131757853
    //   154: invokevirtual getString : (I)Ljava/lang/String;
    //   157: invokevirtual put : (ILjava/lang/Object;)V
    //   160: iload_2
    //   161: iconst_1
    //   162: iadd
    //   163: istore_1
    //   164: iload_1
    //   165: istore_2
    //   166: aload_0
    //   167: ldc_w 'com.autonavi.minimap'
    //   170: invokestatic isClientAvailable : (Landroid/content/Context;Ljava/lang/String;)Z
    //   173: ifeq -> 210
    //   176: aload_0
    //   177: getfield j : Landroid/util/SparseArray;
    //   180: iload_1
    //   181: iconst_3
    //   182: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   185: invokevirtual put : (ILjava/lang/Object;)V
    //   188: aload_0
    //   189: getfield k : Landroid/util/SparseArray;
    //   192: iload_1
    //   193: aload_0
    //   194: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   197: ldc_w 2131757847
    //   200: invokevirtual getString : (I)Ljava/lang/String;
    //   203: invokevirtual put : (ILjava/lang/Object;)V
    //   206: iload_1
    //   207: iconst_1
    //   208: iadd
    //   209: istore_2
    //   210: aload_0
    //   211: ldc 'com.google.android.apps.maps'
    //   213: invokestatic isClientAvailable : (Landroid/content/Context;Ljava/lang/String;)Z
    //   216: ifeq -> 249
    //   219: aload_0
    //   220: getfield j : Landroid/util/SparseArray;
    //   223: iload_2
    //   224: iconst_4
    //   225: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   228: invokevirtual put : (ILjava/lang/Object;)V
    //   231: aload_0
    //   232: getfield k : Landroid/util/SparseArray;
    //   235: iload_2
    //   236: aload_0
    //   237: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   240: ldc_w 2131757848
    //   243: invokevirtual getString : (I)Ljava/lang/String;
    //   246: invokevirtual put : (ILjava/lang/Object;)V
    //   249: aload_0
    //   250: getfield k : Landroid/util/SparseArray;
    //   253: invokevirtual size : ()I
    //   256: anewarray java/lang/String
    //   259: astore #5
    //   261: aload_0
    //   262: getfield k : Landroid/util/SparseArray;
    //   265: invokevirtual size : ()I
    //   268: newarray int
    //   270: astore #6
    //   272: iload_3
    //   273: istore_1
    //   274: iload_1
    //   275: aload_0
    //   276: getfield k : Landroid/util/SparseArray;
    //   279: invokevirtual size : ()I
    //   282: if_icmpge -> 314
    //   285: aload #5
    //   287: iload_1
    //   288: aload_0
    //   289: getfield k : Landroid/util/SparseArray;
    //   292: iload_1
    //   293: invokevirtual valueAt : (I)Ljava/lang/Object;
    //   296: checkcast java/lang/String
    //   299: aastore
    //   300: aload #6
    //   302: iload_1
    //   303: ldc_w 2131100602
    //   306: iastore
    //   307: iload_1
    //   308: iconst_1
    //   309: iadd
    //   310: istore_1
    //   311: goto -> 274
    //   314: aload_0
    //   315: getfield k : Landroid/util/SparseArray;
    //   318: invokevirtual size : ()I
    //   321: ifle -> 373
    //   324: aload_0
    //   325: new com/blued/android/module/live_china/view/PopActionSheet
    //   328: dup
    //   329: aload_0
    //   330: aload #5
    //   332: aload #6
    //   334: iconst_1
    //   335: new com/soft/blued/ui/msg/ShowPositionActivity$3
    //   338: dup
    //   339: aload_0
    //   340: invokespecial <init> : (Lcom/soft/blued/ui/msg/ShowPositionActivity;)V
    //   343: invokespecial <init> : (Landroid/content/Context;[Ljava/lang/String;[IZLcom/blued/android/module/live_china/view/PopActionSheet$PopSheetClickListner;)V
    //   346: putfield d : Lcom/blued/android/module/live_china/view/PopActionSheet;
    //   349: aload_0
    //   350: getfield d : Lcom/blued/android/module/live_china/view/PopActionSheet;
    //   353: aload_0
    //   354: ldc_w 300.0
    //   357: invokestatic a : (Landroid/content/Context;F)I
    //   360: invokevirtual a : (I)V
    //   363: aload_0
    //   364: getfield d : Lcom/blued/android/module/live_china/view/PopActionSheet;
    //   367: invokevirtual a : ()V
    //   370: goto -> 387
    //   373: aload_0
    //   374: aload_0
    //   375: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   378: ldc_w 2131757851
    //   381: invokevirtual getString : (I)Ljava/lang/String;
    //   384: invokevirtual a : (Ljava/lang/String;)V
    //   387: aload_0
    //   388: monitorexit
    //   389: return
    //   390: astore #5
    //   392: aload_0
    //   393: monitorexit
    //   394: aload #5
    //   396: athrow
    //   397: iconst_0
    //   398: istore_2
    //   399: goto -> 118
    // Exception table:
    //   from	to	target	type
    //   2	33	390	finally
    //   38	45	390	finally
    //   53	76	390	finally
    //   85	115	390	finally
    //   120	160	390	finally
    //   166	206	390	finally
    //   210	249	390	finally
    //   249	272	390	finally
    //   274	300	390	finally
    //   314	370	390	finally
    //   373	387	390	finally
  }
  
  public Bitmap a(View paramView) {
    paramView.destroyDrawingCache();
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    paramView.setDrawingCacheEnabled(true);
    return paramView.getDrawingCache(true);
  }
  
  public void a(String paramString) {
    CustomDialog customDialog = this.l;
    if (customDialog != null && customDialog.isShowing())
      return; 
    View view = LayoutInflater.from((Context)this).inflate(2131493743, null);
    view.findViewById(2131301409).setVisibility(8);
    view.findViewById(2131300611).setVisibility(8);
    view.findViewById(2131300719).setVisibility(8);
    ((TextView)view.findViewById(2131300703)).setText(paramString);
    TextView textView = (TextView)view.findViewById(2131301130);
    textView.setText(getString(2131757775));
    textView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ShowPositionActivity.b(this.a).dismiss();
          }
        });
    this.l = new CustomDialog((Context)this, 2131821111);
    this.l.a(view, null);
  }
  
  public MapViews.Marker h() {
    View view = LayoutInflater.from((Context)this).inflate(2131493633, null);
    TextView textView = (TextView)view.findViewById(2131301183);
    if (!TextUtils.isEmpty(this.g) && !this.g.equals("null")) {
      textView.setVisibility(0);
    } else {
      textView.setVisibility(4);
    } 
    textView.setText(this.g);
    Bitmap bitmap = a(view);
    MapViews.Marker marker = new MapViews.Marker();
    marker.b = this.i.latitude;
    marker.a = this.i.longitude;
    marker.c = bitmap;
    return marker;
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      j();
      return;
    } 
    finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492908);
    i();
    this.h = (MapViews)findViewById(2131299198);
    MapViews.Marker marker = h();
    ArrayList<MapViews.Marker> arrayList = new ArrayList();
    arrayList.add(marker);
    this.h.a((Context)this, paramBundle, arrayList);
    this.h.b();
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.h.e();
  }
  
  public void onPause() {
    super.onPause();
    MobclickAgent.onPageEnd(ShowPositionActivity.class.getSimpleName());
    MobclickAgent.onPause((Context)this);
    this.h.d();
  }
  
  public void onResume() {
    super.onResume();
    MobclickAgent.onPageStart(ShowPositionActivity.class.getSimpleName());
    MobclickAgent.onResume((Context)this);
    this.h.c();
    LiveFloatManager.a().k();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\ShowPositionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */