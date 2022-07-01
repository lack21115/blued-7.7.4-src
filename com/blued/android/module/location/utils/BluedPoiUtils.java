package com.blued.android.module.location.utils;

import android.text.TextUtils;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.location.LocationService;
import com.blued.android.module.location.listener.OnPoiListener;
import com.blued.android.module.location.model.BluedGeocodeModel;
import com.blued.android.module.location.model.BluedMyExtra;
import com.blued.android.module.location.model.BluedNearbyModel;
import com.blued.android.module.location.model.LocationPOIModel;
import java.util.ArrayList;
import java.util.Map;

public class BluedPoiUtils {
  private static String a = "";
  
  private static String b;
  
  private static String c;
  
  private static String d;
  
  private static BluedUIHttpResponse a(OnPoiListener paramOnPoiListener) {
    return new BluedUIHttpResponse<BluedEntity<BluedGeocodeModel, BluedMyExtra>>(null, paramOnPoiListener) {
        public boolean onUIFailure(int param1Int, String param1String) {
          OnPoiListener onPoiListener = this.a;
          if (onPoiListener != null)
            onPoiListener.a(-200, null, false); 
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIUpdate(BluedEntity<BluedGeocodeModel, BluedMyExtra> param1BluedEntity) {
          ArrayList<LocationPOIModel> arrayList = new ArrayList();
          if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0)
            for (BluedGeocodeModel bluedGeocodeModel : param1BluedEntity.data) {
              LocationPOIModel locationPOIModel = new LocationPOIModel();
              locationPOIModel.name = bluedGeocodeModel.a;
              locationPOIModel.address = bluedGeocodeModel.a;
              locationPOIModel.latitude = bluedGeocodeModel.c;
              locationPOIModel.longitude = bluedGeocodeModel.b;
              arrayList.add(locationPOIModel);
            }  
          if (this.a != null) {
            if (arrayList.size() > 0) {
              this.a.a(0, arrayList, false);
              return;
            } 
            this.a.a(-100, null, false);
          } 
        }
      };
  }
  
  private static BluedUIHttpResponse a(OnPoiListener paramOnPoiListener, int paramInt) {
    return new BluedUIHttpResponse<BluedEntity<BluedNearbyModel, BluedMyExtra>>(null, paramInt, paramOnPoiListener) {
        public boolean onUIFailure(int param1Int, String param1String) {
          OnPoiListener onPoiListener = this.b;
          if (onPoiListener != null)
            onPoiListener.a(-200, null, false); 
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIUpdate(BluedEntity<BluedNearbyModel, BluedMyExtra> param1BluedEntity) {
          // Byte code:
          //   0: new java/util/ArrayList
          //   3: dup
          //   4: invokespecial <init> : ()V
          //   7: astore #4
          //   9: aload_1
          //   10: ifnull -> 223
          //   13: aload_1
          //   14: getfield data : Ljava/util/List;
          //   17: ifnull -> 223
          //   20: aload_1
          //   21: getfield data : Ljava/util/List;
          //   24: invokeinterface size : ()I
          //   29: ifle -> 223
          //   32: aload_1
          //   33: getfield data : Ljava/util/List;
          //   36: invokeinterface iterator : ()Ljava/util/Iterator;
          //   41: astore #5
          //   43: aload #5
          //   45: invokeinterface hasNext : ()Z
          //   50: ifeq -> 127
          //   53: aload #5
          //   55: invokeinterface next : ()Ljava/lang/Object;
          //   60: checkcast com/blued/android/module/location/model/BluedNearbyModel
          //   63: astore #6
          //   65: new com/blued/android/module/location/model/LocationPOIModel
          //   68: dup
          //   69: invokespecial <init> : ()V
          //   72: astore #7
          //   74: aload #7
          //   76: aload #6
          //   78: getfield a : Ljava/lang/String;
          //   81: putfield name : Ljava/lang/String;
          //   84: aload #7
          //   86: aload #6
          //   88: getfield b : Ljava/lang/String;
          //   91: putfield address : Ljava/lang/String;
          //   94: aload #7
          //   96: aload #6
          //   98: getfield d : Ljava/lang/String;
          //   101: putfield latitude : Ljava/lang/String;
          //   104: aload #7
          //   106: aload #6
          //   108: getfield c : Ljava/lang/String;
          //   111: putfield longitude : Ljava/lang/String;
          //   114: aload #4
          //   116: aload #7
          //   118: invokeinterface add : (Ljava/lang/Object;)Z
          //   123: pop
          //   124: goto -> 43
          //   127: aload_1
          //   128: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
          //   131: ifnull -> 223
          //   134: aload_0
          //   135: getfield a : I
          //   138: istore_2
          //   139: iload_2
          //   140: ifeq -> 190
          //   143: iload_2
          //   144: iconst_1
          //   145: if_icmpeq -> 173
          //   148: iload_2
          //   149: iconst_2
          //   150: if_icmpeq -> 156
          //   153: goto -> 204
          //   156: aload_1
          //   157: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
          //   160: checkcast com/blued/android/module/location/model/BluedMyExtra
          //   163: getfield pagetoken : Ljava/lang/String;
          //   166: invokestatic d : (Ljava/lang/String;)Ljava/lang/String;
          //   169: pop
          //   170: goto -> 204
          //   173: aload_1
          //   174: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
          //   177: checkcast com/blued/android/module/location/model/BluedMyExtra
          //   180: getfield pagetoken : Ljava/lang/String;
          //   183: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
          //   186: pop
          //   187: goto -> 204
          //   190: aload_1
          //   191: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
          //   194: checkcast com/blued/android/module/location/model/BluedMyExtra
          //   197: getfield pagetoken : Ljava/lang/String;
          //   200: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
          //   203: pop
          //   204: aload_1
          //   205: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
          //   208: checkcast com/blued/android/module/location/model/BluedMyExtra
          //   211: getfield pagetoken : Ljava/lang/String;
          //   214: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
          //   217: iconst_1
          //   218: ixor
          //   219: istore_3
          //   220: goto -> 225
          //   223: iconst_0
          //   224: istore_3
          //   225: aload_0
          //   226: getfield b : Lcom/blued/android/module/location/listener/OnPoiListener;
          //   229: ifnull -> 269
          //   232: aload #4
          //   234: invokeinterface size : ()I
          //   239: ifle -> 256
          //   242: aload_0
          //   243: getfield b : Lcom/blued/android/module/location/listener/OnPoiListener;
          //   246: iconst_0
          //   247: aload #4
          //   249: iload_3
          //   250: invokeinterface a : (ILjava/util/List;Z)V
          //   255: return
          //   256: aload_0
          //   257: getfield b : Lcom/blued/android/module/location/listener/OnPoiListener;
          //   260: bipush #-100
          //   262: aconst_null
          //   263: iconst_0
          //   264: invokeinterface a : (ILjava/util/List;Z)V
          //   269: return
        }
      };
  }
  
  public static void a(int paramInt, OnPoiListener paramOnPoiListener) {
    if (paramInt == 0)
      b = null; 
    if (StringUtils.a(a)) {
      if (paramOnPoiListener != null) {
        paramOnPoiListener.a(-10, null, false);
        LogUtils.d("请设置UrlHost！");
      } 
      return;
    } 
    BluedUIHttpResponse bluedUIHttpResponse = a(paramOnPoiListener, 0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LocationService.b());
    stringBuilder.append(",");
    stringBuilder.append(LocationService.a());
    a((StringHttpResponseHandler)bluedUIHttpResponse, stringBuilder.toString(), (String)null, b);
  }
  
  public static void a(int paramInt, String paramString, OnPoiListener paramOnPoiListener) {
    if (paramInt == 0)
      d = null; 
    if (StringUtils.a(a)) {
      if (paramOnPoiListener != null) {
        paramOnPoiListener.a(-10, null, false);
        LogUtils.d("请设置UrlHost！");
      } 
      return;
    } 
    BluedUIHttpResponse bluedUIHttpResponse = a(paramOnPoiListener, 2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LocationService.b());
    stringBuilder.append(",");
    stringBuilder.append(LocationService.a());
    a((StringHttpResponseHandler)bluedUIHttpResponse, stringBuilder.toString(), paramString, d);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, OnPoiListener paramOnPoiListener) {
    if (paramInt == 0)
      c = null; 
    if (StringUtils.a(a)) {
      if (paramOnPoiListener != null) {
        paramOnPoiListener.a(-10, null, false);
        LogUtils.d("请设置UrlHost！");
      } 
      return;
    } 
    BluedUIHttpResponse bluedUIHttpResponse = a(paramOnPoiListener, 1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append(",");
    stringBuilder.append(paramString1);
    a((StringHttpResponseHandler)bluedUIHttpResponse, stringBuilder.toString(), (String)null, c);
  }
  
  private static void a(StringHttpResponseHandler paramStringHttpResponseHandler, String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    if (!StringUtils.a(paramString1))
      map.put("latlng", paramString1); 
    if (!StringUtils.a(paramString2))
      map.put("address", paramString2); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("/blued/maps/google/geocode");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramStringHttpResponseHandler, null).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  private static void a(StringHttpResponseHandler paramStringHttpResponseHandler, String paramString1, String paramString2, String paramString3) {
    Map<String, String> map = BluedHttpTools.a();
    if (!StringUtils.a(paramString1))
      map.put("location", paramString1); 
    map.put("radius", "3000");
    map.put("language", AppUtils.d());
    if (!StringUtils.a(paramString2))
      map.put("keyword", paramString2); 
    if (!StringUtils.a(paramString3))
      map.put("pagetoken", paramString3); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("/blued/maps/google/nearby");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramStringHttpResponseHandler, null).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      a = paramString; 
  }
  
  public static void b(int paramInt, String paramString, OnPoiListener paramOnPoiListener) {
    if (StringUtils.a(a)) {
      if (paramOnPoiListener != null) {
        paramOnPoiListener.a(-10, null, false);
        LogUtils.d("请设置UrlHost！");
      } 
      return;
    } 
    a((StringHttpResponseHandler)a(paramOnPoiListener), (String)null, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\locatio\\utils\BluedPoiUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */