package com.amap.api.col.s;

import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class i {
  public static double a(double paramDouble) {
    return Double.parseDouble((new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US))).format(paramDouble));
  }
  
  public static float a(LatLonPoint paramLatLonPoint1, LatLonPoint paramLatLonPoint2) {
    if (paramLatLonPoint1 == null || paramLatLonPoint2 == null)
      return 0.0F; 
    try {
      double d4 = paramLatLonPoint1.getLongitude();
      double d3 = paramLatLonPoint1.getLatitude();
      double d2 = paramLatLonPoint2.getLongitude();
      double d1 = paramLatLonPoint2.getLatitude();
      double d5 = d4 * 0.01745329251994329D;
      double d6 = d3 * 0.01745329251994329D;
      d3 = d2 * 0.01745329251994329D;
      d4 = d1 * 0.01745329251994329D;
      d1 = Math.sin(d5);
      d2 = Math.sin(d6);
      d5 = Math.cos(d5);
      d6 = Math.cos(d6);
      double d7 = Math.sin(d3);
      double d8 = Math.sin(d4);
      d3 = Math.cos(d3);
      d4 = Math.cos(d4);
      double[] arrayOfDouble1 = new double[3];
      double[] arrayOfDouble2 = new double[3];
      arrayOfDouble1[0] = d5 * d6;
      arrayOfDouble1[1] = d6 * d1;
      arrayOfDouble1[2] = d2;
      arrayOfDouble2[0] = d3 * d4;
      arrayOfDouble2[1] = d4 * d7;
      return (float)(d1 * 1.27420015798544E7D);
    } finally {
      paramLatLonPoint1 = null;
      paramLatLonPoint1.printStackTrace();
    } 
  }
  
  public static String a(LatLonPoint paramLatLonPoint) {
    if (paramLatLonPoint == null)
      return ""; 
    double d1 = a(paramLatLonPoint.getLongitude());
    double d2 = a(paramLatLonPoint.getLatitude());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(d1);
    stringBuilder.append(",");
    stringBuilder.append(d2);
    return stringBuilder.toString();
  }
  
  public static String a(Date paramDate) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
    return (paramDate != null) ? simpleDateFormat.format(paramDate) : "";
  }
  
  public static String a(List<LatLonPoint> paramList) {
    return a(paramList, ";");
  }
  
  public static String a(List<LatLonPoint> paramList, String paramString) {
    if (paramList == null)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer();
    int j;
    for (j = 0; j < paramList.size(); j++) {
      LatLonPoint latLonPoint = paramList.get(j);
      if (latLonPoint != null) {
        double d1 = a(latLonPoint.getLongitude());
        double d2 = a(latLonPoint.getLatitude());
        stringBuffer.append(d1);
        stringBuffer.append(",");
        stringBuffer.append(d2);
        stringBuffer.append(paramString);
      } 
    } 
    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
    return stringBuffer.toString();
  }
  
  private static void a(int paramInt, String paramString) throws AMapException, JSONException {
    if (paramInt != 0)
      if (paramInt != 22000) {
        if (paramInt != 32200) {
          if (paramInt != 32201) {
            switch (paramInt) {
              default:
                switch (paramInt) {
                  default:
                    switch (paramInt) {
                      default:
                        switch (paramInt) {
                          default:
                            switch (paramInt) {
                              default:
                                if (!TextUtils.isEmpty(paramString) && paramInt > 0)
                                  throw new AMapException(paramString, 2, paramString, paramInt); 
                                throw new AMapException(paramString, 2, paramString);
                              case 32002:
                                throw new AMapException("服务器维护中", 2, paramString);
                              case 32001:
                                throw new AMapException("ID不存在", 2, paramString);
                              case 32000:
                                break;
                            } 
                            throw new AMapException("key对应的tableID不存在", 2, paramString);
                          case 30003:
                            throw new AMapException("读取服务结果超时", 2, paramString);
                          case 30002:
                            throw new AMapException("服务端请求链接超时", 2, paramString);
                          case 30001:
                            throw new AMapException("引擎返回数据异常", 2, paramString);
                          case 30000:
                            break;
                        } 
                        throw new AMapException("请求服务响应错误", 2, paramString);
                      case 20803:
                        throw new AMapException("起点终点距离过长", 2, paramString);
                      case 20802:
                        throw new AMapException("路线计算失败，通常是由于道路连通关系导致", 2, paramString);
                      case 20801:
                        throw new AMapException("规划点（起点、终点、途经点）附近搜不到路", 2, paramString);
                      case 20800:
                        break;
                    } 
                    throw new AMapException("规划点（包括起点、终点、途经点）不在中国陆地范围内", 2, paramString);
                  case 20003:
                    throw new AMapException("其他未知错误", 2, paramString);
                  case 20002:
                    throw new AMapException("请求协议非法", 2, paramString);
                  case 20001:
                    throw new AMapException("缺少必填参数", 2, paramString);
                  case 20000:
                    break;
                } 
                throw new AMapException("请求参数非法", 2, paramString);
              case 10013:
                throw new AMapException("开发者删除了key，key被删除后无法正常使用", 2, paramString);
              case 10012:
                throw new AMapException("权限不足，服务请求被拒绝", 2, paramString);
              case 10011:
                throw new AMapException("服务不支持https请求", 2, paramString);
              case 10010:
                throw new AMapException("IP访问超限", 2, paramString);
              case 10009:
                throw new AMapException("请求key与绑定平台不符", 2, paramString);
              case 10008:
                throw new AMapException("用户MD5安全码未通过", 2, paramString);
              case 10007:
                throw new AMapException("用户签名未通过", 2, paramString);
              case 10006:
                throw new AMapException("用户域名无效", 2, paramString);
              case 10005:
                throw new AMapException("用户IP无效", 2, paramString);
              case 10004:
                throw new AMapException("用户访问过于频繁", 2, paramString);
              case 10003:
                throw new AMapException("访问已超出日访问量", 2, paramString);
              case 10002:
                throw new AMapException("请求服务不存在", 2, paramString);
              case 10001:
                throw new AMapException("用户key不正确或过期", 2, paramString);
              case 10000:
                break;
            } 
          } else {
            throw new AMapException("App key未开通“附近”功能,请注册附近KEY", 2, paramString);
          } 
        } else {
          throw new AMapException("找不到对应的userid信息,请检查您提供的userid是否存在", 2, paramString);
        } 
      } else {
        throw new AMapException("tableID格式不正确不存在", 2, paramString);
      }  
  }
  
  public static void a(Throwable paramThrowable, String paramString1, String paramString2) {
    try {
      cg cg = cg.d();
      return;
    } finally {
      paramThrowable = null;
      paramThrowable.printStackTrace();
    } 
  }
  
  public static boolean a(String paramString) {
    return (paramString == null || paramString.trim().length() == 0);
  }
  
  public static void b(String paramString) throws AMapException {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (jSONObject.has("errcode")) {
        a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
        return;
      } 
      if (!jSONObject.has("status"))
        return; 
      String str = jSONObject.getString("status");
      if (str.equals("1"))
        return; 
      boolean bool = str.equals("0");
      if (!bool || jSONObject.has("infocode")) {
        int j = jSONObject.getInt("infocode");
        if (str.equals("0"))
          a(j, jSONObject.getString("info")); 
        return;
      } 
      throw new AMapException("未知错误");
    } catch (JSONException jSONException) {
      a((Throwable)jSONException, "CoreUtil", "paseAuthFailurJson");
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
  }
  
  public static void c(String paramString) throws AMapException {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (jSONObject.has("errcode")) {
        a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
        return;
      } 
      if (!jSONObject.has("status"))
        return; 
      if (jSONObject.optInt("status") == 0)
        if (jSONObject.has("infocode")) {
          a(jSONObject.getInt("infocode"), jSONObject.getString("info"));
        } else {
          throw new AMapException("未知错误");
        }  
      int j = jSONObject.optInt("code");
      if (j == 0)
        return; 
      String str = jSONObject.optString("message");
      throw new AMapException(str, 2, str, Integer.parseInt("1".concat(String.valueOf(j))));
    } catch (JSONException jSONException) {
      a((Throwable)jSONException, "CoreUtil", "paseAuthFailurJson");
      throw new AMapException("协议解析错误 - ProtocolException");
    } 
  }
  
  public static Date d(String paramString) {
    if (paramString != null) {
      if (paramString.trim().equals(""))
        return null; 
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmm");
      try {
        return simpleDateFormat.parse(paramString);
      } catch (ParseException parseException) {
        a(parseException, "CoreUtil", "parseString2Time");
      } 
    } 
    return null;
  }
  
  public static Date e(String paramString) {
    if (paramString != null) {
      if (paramString.trim().equals(""))
        return null; 
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
      try {
        return simpleDateFormat.parse(paramString);
      } catch (ParseException parseException) {
        a(parseException, "CoreUtil", "parseTime");
      } 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */