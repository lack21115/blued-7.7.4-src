package com.tencent.ams.a.a.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import cn.mmachina.JniClient;
import com.tencent.ams.a.a.b.b;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
  public static String a(Context paramContext, String paramString) {
    String str = JniClient.MDString("", paramContext, paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MMASignature: ");
    stringBuilder.append(str);
    com.tencent.ams.a.b.a.a(stringBuilder.toString());
    return str;
  }
  
  public static String a(String paramString) {
    Matcher matcher = Pattern.compile("^([\\w\\d]+):\\/\\/([\\w\\d\\-_]+(?:\\.[\\w\\d\\-_]+)*)").matcher(paramString);
    return matcher.find() ? matcher.group(0) : "";
  }
  
  public static String a(String paramString, com.tencent.ams.a.a.b.a parama, b paramb) {
    try {
      if (!parama.c) {
        String str = paramString;
        return (paramString == null) ? "" : str;
      } 
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      return "";
    } 
    return (unsupportedEncodingException != null) ? URLEncoder.encode((String)unsupportedEncodingException, "utf-8") : "";
  }
  
  public static String a(String paramString1, List<String> paramList, String paramString2, String paramString3) {
    for (String str : paramList) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append(str);
      if (paramString1.contains(stringBuilder.toString())) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("mma_");
        stringBuilder.append(paramString2);
        stringBuilder.append(str);
        stringBuilder.append(paramString3);
        stringBuilder.append("[^");
        stringBuilder.append(paramString2);
        stringBuilder.append("]*");
        com.tencent.ams.a.b.a.a(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramString2);
        stringBuilder.append(str);
        stringBuilder.append(paramString3);
        stringBuilder.append("[^");
        stringBuilder.append(paramString2);
        stringBuilder.append("]*");
        paramString1 = paramString1.replaceAll(stringBuilder.toString(), "");
      } 
    } 
    return paramString1;
  }
  
  private static List<String> a(List<?> paramList) {
    Collections.sort(paramList, new Comparator<String>() {
          public int a(String param1String1, String param1String2) {
            if (param1String1 != null) {
              if (param1String2 == null)
                return 1; 
              if (param1String1.length() <= param1String2.length())
                return 1; 
            } 
            return -1;
          }
        });
    return (List)paramList;
  }
  
  public static Map a(String paramString1, List<String> paramList, String paramString2, String paramString3, String paramString4) {
    List<String> list = a(paramList);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (String str : list) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append(str);
      if (paramString1.contains(stringBuilder.toString())) {
        if (str.equals(paramString4)) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramString2);
          stringBuilder.append(str);
          stringBuilder.append("[^");
          stringBuilder.append(paramString2);
          stringBuilder.append("]*");
          Matcher matcher = Pattern.compile(stringBuilder.toString()).matcher(paramString1);
          if (matcher.find()) {
            String str1 = matcher.group(0);
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(paramString2);
            stringBuilder1.append(str);
            str1.replace(stringBuilder1.toString(), "");
          } 
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramString2);
        stringBuilder.append(str);
        stringBuilder.append(paramString3);
        stringBuilder.append("[^");
        stringBuilder.append(paramString2);
        stringBuilder.append("]*");
        paramString1 = paramString1.replaceAll(stringBuilder.toString(), "");
      } 
    } 
    hashMap.put("URL", paramString1);
    return hashMap;
  }
  
  public static boolean a(Context paramContext) {
    if (paramContext != null) {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager != null) {
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null)
          return networkInfo.isAvailable(); 
      } 
    } 
    return false;
  }
  
  public static String b(String paramString) {
    String str;
    MessageDigest messageDigest3 = null;
    MessageDigest messageDigest2 = null;
    MessageDigest messageDigest1 = messageDigest3;
    if (paramString != null) {
      messageDigest1 = messageDigest3;
      if (!"".equals(paramString)) {
        messageDigest1 = messageDigest2;
        try {
          messageDigest3 = MessageDigest.getInstance("MD5");
          messageDigest1 = messageDigest2;
          messageDigest3.update(paramString.getBytes());
          messageDigest1 = messageDigest2;
          paramString = (new BigInteger(1, messageDigest3.digest())).toString(16);
          while (true) {
            str = paramString;
            if (paramString.length() < 32) {
              str = paramString;
              StringBuilder stringBuilder = new StringBuilder();
              str = paramString;
              stringBuilder.append("0");
              str = paramString;
              stringBuilder.append(paramString);
              str = paramString;
              paramString = stringBuilder.toString();
              continue;
            } 
            str = paramString;
            return paramString.toUpperCase();
          } 
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
          noSuchAlgorithmException.printStackTrace();
        } 
      } 
    } 
    return str;
  }
  
  public static boolean b(Context paramContext) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null) {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      bool1 = bool2;
      if (connectivityManager != null) {
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        bool1 = bool2;
        if (networkInfo != null)
          bool1 = networkInfo.isAvailable(); 
      } 
    } 
    return bool1;
  }
  
  public static String c(String paramString) {
    if (paramString == null)
      return ""; 
    try {
      return URLEncoder.encode(paramString, "utf-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ams\a\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */