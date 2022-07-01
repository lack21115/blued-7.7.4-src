package com.sina.weibo.sdk.call;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public final class WeiboPageUtils {
  public static void displayInWeiboMap(Context paramContext, Position paramPosition, String paramString) throws WeiboNotInstalledException {
    if (paramContext != null) {
      String str1;
      String str2;
      String str3;
      String str4 = "";
      if (paramPosition != null) {
        str4 = paramPosition.getStrLongitude();
        str2 = paramPosition.getStrLatitude();
        str3 = paramPosition.getStrOffset();
        str1 = str4;
      } else {
        str3 = "";
        str2 = str3;
        str1 = str4;
      } 
      openInWeiboBrowser(paramContext, String.format("http://weibo.cn/dpool/ttt/maps.php?xy=%s,%s&amp;size=320x320&amp;offset=%s", new Object[] { str1, str2, str3 }), "default", paramString);
      return;
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void openInWeiboBrowser(Context paramContext, String paramString1, String paramString2, String paramString3) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (!TextUtils.isEmpty(paramString1)) {
        if (TextUtils.isEmpty(paramString2) || "topnav".equals(paramString2) || "default".equals(paramString2) || "fullscreen".equals(paramString2)) {
          StringBuilder stringBuilder = new StringBuilder("sinaweibo://browser");
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          hashMap.put("url", paramString1);
          hashMap.put("sinainternalbrowser", paramString2);
          hashMap.put("extparam", paramString3);
          stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
          CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString());
          return;
        } 
        throw new WeiboIllegalParameterException("sinainternalbrowser不合法");
      } 
      throw new WeiboIllegalParameterException("url不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void openQrcodeScanner(Context paramContext, String paramString) throws WeiboNotInstalledException {
    if (paramContext != null) {
      StringBuilder stringBuilder = new StringBuilder("sinaweibo://qrcode");
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("extparam", paramString);
      stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString());
      return;
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void postNewWeibo(Context paramContext, String paramString1, String paramString2, String paramString3, Position paramPosition, String paramString4, String paramString5) throws WeiboNotInstalledException {
    if (paramContext != null) {
      StringBuilder stringBuilder = new StringBuilder("sinaweibo://sendweibo");
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      try {
        hashMap.put("content", URLEncoder.encode(paramString1, "UTF-8").replaceAll("\\+", "%20"));
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
      } 
      hashMap.put("poiid", paramString2);
      hashMap.put("poiname", paramString3);
      if (paramPosition != null) {
        hashMap.put("longitude", paramPosition.getStrLongitude());
        hashMap.put("latitude", paramPosition.getStrLatitude());
      } 
      hashMap.put("pageid", paramString4);
      hashMap.put("extparam", paramString5);
      stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString());
      return;
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewNearPhotoList(Context paramContext, String paramString1, String paramString2, Integer paramInteger, String paramString3) throws WeiboNotInstalledException {
    StringBuilder stringBuilder = new StringBuilder("100101");
    stringBuilder.append(paramString1);
    stringBuilder.append("_");
    stringBuilder.append(paramString2);
    viewPagePhotoList(paramContext, stringBuilder.toString(), "nearphoto", "周边热图", paramInteger, paramString3);
  }
  
  public static void viewNearbyPeople(Context paramContext, Position paramPosition, String paramString) throws WeiboNotInstalledException {
    if (paramContext != null) {
      StringBuilder stringBuilder = new StringBuilder("sinaweibo://nearbypeople");
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      if (paramPosition != null) {
        hashMap.put("longitude", paramPosition.getStrLongitude());
        hashMap.put("latitude", paramPosition.getStrLatitude());
        hashMap.put("offset", paramPosition.getStrOffset());
      } 
      hashMap.put("extparam", paramString);
      stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString());
      return;
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewNearbyWeibo(Context paramContext, Position paramPosition, String paramString) throws WeiboNotInstalledException {
    if (paramContext != null) {
      StringBuilder stringBuilder = new StringBuilder("sinaweibo://nearbyweibo");
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      if (paramPosition != null) {
        hashMap.put("longitude", paramPosition.getStrLongitude());
        hashMap.put("latitude", paramPosition.getStrLatitude());
        hashMap.put("offset", paramPosition.getStrOffset());
      } 
      hashMap.put("extparam", paramString);
      stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString());
      return;
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewPageDetailInfo(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (!TextUtils.isEmpty(paramString1)) {
        if (!TextUtils.isEmpty(paramString2)) {
          StringBuilder stringBuilder = new StringBuilder("sinaweibo://pagedetailinfo");
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          hashMap.put("pageid", paramString1);
          hashMap.put("cardid", paramString2);
          hashMap.put("title", paramString3);
          hashMap.put("extparam", paramString4);
          stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
          CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString());
          return;
        } 
        throw new WeiboIllegalParameterException("cardId不能为空");
      } 
      throw new WeiboIllegalParameterException("pageId不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewPageInfo(Context paramContext, String paramString1, String paramString2, String paramString3) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (!TextUtils.isEmpty(paramString1)) {
        StringBuilder stringBuilder = new StringBuilder("sinaweibo://pageinfo");
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("pageid", paramString1);
        hashMap.put("title", paramString2);
        hashMap.put("extparam", paramString3);
        stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString());
        return;
      } 
      throw new WeiboIllegalParameterException("pageId不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewPagePhotoList(Context paramContext, String paramString1, String paramString2, String paramString3, Integer paramInteger, String paramString4) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (!TextUtils.isEmpty(paramString1)) {
        if (!TextUtils.isEmpty(paramString2)) {
          if (paramInteger == null || paramInteger.intValue() >= 0) {
            StringBuilder stringBuilder = new StringBuilder("sinaweibo://pagephotolist");
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            hashMap.put("pageid", paramString1);
            hashMap.put("cardid", paramString2);
            hashMap.put("title", paramString3);
            hashMap.put("page", "1");
            hashMap.put("count", String.valueOf(paramInteger));
            hashMap.put("extparam", paramString4);
            stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
            CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString());
            return;
          } 
          throw new WeiboIllegalParameterException("count不能为负数");
        } 
        throw new WeiboIllegalParameterException("cardId不能为空");
      } 
      throw new WeiboIllegalParameterException("pageId不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewPageProductList(Context paramContext, String paramString1, String paramString2, String paramString3, Integer paramInteger, String paramString4) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (!TextUtils.isEmpty(paramString1)) {
        if (!TextUtils.isEmpty(paramString2)) {
          if (paramInteger == null || paramInteger.intValue() >= 0) {
            StringBuilder stringBuilder = new StringBuilder("sinaweibo://pageproductlist");
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            hashMap.put("pageid", paramString1);
            hashMap.put("cardid", paramString2);
            hashMap.put("title", paramString3);
            hashMap.put("page", "1");
            hashMap.put("count", String.valueOf(paramInteger));
            hashMap.put("extparam", paramString4);
            stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
            CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString());
            return;
          } 
          throw new WeiboIllegalParameterException("count不能为负数");
        } 
        throw new WeiboIllegalParameterException("cardId不能为空");
      } 
      throw new WeiboIllegalParameterException("pageId不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewPageUserList(Context paramContext, String paramString1, String paramString2, String paramString3, Integer paramInteger, String paramString4) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (!TextUtils.isEmpty(paramString1)) {
        if (!TextUtils.isEmpty(paramString2)) {
          if (paramInteger == null || paramInteger.intValue() >= 0) {
            StringBuilder stringBuilder = new StringBuilder("sinaweibo://pageuserlist");
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            hashMap.put("pageid", paramString1);
            hashMap.put("cardid", paramString2);
            hashMap.put("title", paramString3);
            hashMap.put("page", "1");
            hashMap.put("count", String.valueOf(paramInteger));
            hashMap.put("extparam", paramString4);
            stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
            CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString());
            return;
          } 
          throw new WeiboIllegalParameterException("count不能为负数");
        } 
        throw new WeiboIllegalParameterException("cardId不能为空");
      } 
      throw new WeiboIllegalParameterException("pageId不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewPageWeiboList(Context paramContext, String paramString1, String paramString2, String paramString3, Integer paramInteger, String paramString4) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (!TextUtils.isEmpty(paramString1)) {
        if (!TextUtils.isEmpty(paramString2)) {
          if (paramInteger == null || paramInteger.intValue() >= 0) {
            StringBuilder stringBuilder = new StringBuilder("sinaweibo://pageweibolist");
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            hashMap.put("pageid", paramString1);
            hashMap.put("cardid", paramString2);
            hashMap.put("title", paramString3);
            hashMap.put("page", "1");
            hashMap.put("count", String.valueOf(paramInteger));
            hashMap.put("extparam", paramString4);
            stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
            CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString());
            return;
          } 
          throw new WeiboIllegalParameterException("count不能为负数");
        } 
        throw new WeiboIllegalParameterException("cardId不能为空");
      } 
      throw new WeiboIllegalParameterException("pageId不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewPoiPage(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) throws WeiboNotInstalledException {
    StringBuilder stringBuilder = new StringBuilder("100101");
    stringBuilder.append(paramString1);
    stringBuilder.append("_");
    stringBuilder.append(paramString2);
    viewPageInfo(paramContext, stringBuilder.toString(), paramString3, paramString4);
  }
  
  public static void viewPoiPhotoList(Context paramContext, String paramString1, Integer paramInteger, String paramString2) throws WeiboNotInstalledException {
    StringBuilder stringBuilder = new StringBuilder("100101");
    stringBuilder.append(paramString1);
    viewPagePhotoList(paramContext, stringBuilder.toString(), "nearphoto", "周边热图", paramInteger, paramString2);
  }
  
  public static void viewUserInfo(Context paramContext, String paramString1, String paramString2, String paramString3) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (!TextUtils.isEmpty(paramString1) || !TextUtils.isEmpty(paramString2)) {
        StringBuilder stringBuilder = new StringBuilder("sinaweibo://userinfo");
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("uid", paramString1);
        hashMap.put("nick", paramString2);
        hashMap.put("extparam", paramString3);
        stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString());
        return;
      } 
      throw new WeiboIllegalParameterException("uid和nick必须至少有一个不为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void viewUsertrends(Context paramContext, String paramString1, String paramString2) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (!TextUtils.isEmpty(paramString1)) {
        StringBuilder stringBuilder = new StringBuilder("sinaweibo://usertrends");
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("uid", paramString1);
        hashMap.put("extparam", paramString2);
        stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString());
        return;
      } 
      throw new WeiboIllegalParameterException("uid和nick必须至少有一个不为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
  
  public static void weiboDetail(Context paramContext, String paramString1, String paramString2) throws WeiboNotInstalledException {
    if (paramContext != null) {
      if (!TextUtils.isEmpty(paramString1)) {
        StringBuilder stringBuilder = new StringBuilder("sinaweibo://detail");
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("mblogid", paramString1);
        hashMap.put("extparam", paramString2);
        stringBuilder.append(CommonUtils.buildUriQuery((HashMap)hashMap));
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", stringBuilder.toString());
        return;
      } 
      throw new WeiboIllegalParameterException("pageId不能为空");
    } 
    throw new WeiboIllegalParameterException("context不能为空");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\call\WeiboPageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */