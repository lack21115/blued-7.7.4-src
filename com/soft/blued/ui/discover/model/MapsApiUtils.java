package com.soft.blued.ui.discover.model;

import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.StringHttpResponseHandler;
import org.json.JSONObject;

public class MapsApiUtils {
  public static void getAddress(String paramString1, String paramString2, String paramString3, final OnGetAddressListener listener) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("http://maps.google.com/maps/api/geocode/json?latlng=");
    stringBuilder.append(paramString2);
    stringBuilder.append(",");
    stringBuilder.append(paramString1);
    stringBuilder.append("&sensor=false®ion=cn&language=");
    stringBuilder.append(paramString3);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)new StringHttpResponseHandler() {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            MapsApiUtils.OnGetAddressListener onGetAddressListener = listener;
            if (onGetAddressListener != null)
              onGetAddressListener.onFinish(""); 
          }
          
          public void onSuccess(String param1String) {
            String str;
            try {
              param1String = (new JSONObject(param1String)).getJSONArray("results").getJSONObject(0).getString("formatted_address");
            } catch (Exception exception) {
              exception.printStackTrace();
              str = "";
            } 
            MapsApiUtils.OnGetAddressListener onGetAddressListener = listener;
            if (onGetAddressListener != null)
              onGetAddressListener.onFinish(str); 
          }
        }).i();
  }
  
  public static void getLocationInfo(String paramString1, String paramString2, final OnGetLocationListener listener) {
    paramString1 = paramString1.replaceAll(" +", "");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("http://maps.google.com/maps/api/geocode/json?address=");
    stringBuilder.append(paramString1);
    stringBuilder.append("&sensor=false&language=");
    stringBuilder.append(paramString2);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)new StringHttpResponseHandler() {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            MapsApiUtils.OnGetLocationListener onGetLocationListener = listener;
            if (onGetLocationListener != null)
              onGetLocationListener.onFinish(new double[2]); 
          }
          
          public void onSuccess(String param1String) {
            double[] arrayOfDouble = new double[2];
            try {
              JSONObject jSONObject = new JSONObject(param1String);
              if (jSONObject.getJSONArray("results").length() > 0) {
                jSONObject = jSONObject.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
                double d1 = jSONObject.getDouble("lng");
                double d2 = jSONObject.getDouble("lat");
                arrayOfDouble[0] = d1;
                arrayOfDouble[1] = d2;
              } 
            } catch (Exception exception) {}
            MapsApiUtils.OnGetLocationListener onGetLocationListener = listener;
            if (onGetLocationListener != null)
              onGetLocationListener.onFinish(arrayOfDouble); 
          }
        }).i();
  }
  
  public static interface OnGetAddressListener {
    void onFinish(String param1String);
  }
  
  public static interface OnGetLocationListener {
    void onFinish(double[] param1ArrayOfdouble);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\model\MapsApiUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */