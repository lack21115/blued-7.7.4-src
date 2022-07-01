package com.alibaba.mtl.log.e;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.model.LogField;
import com.alibaba.mtl.log.sign.IRequestAuth;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class t {
  private static final String TAG = t.class.getSimpleName();
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4) throws Exception {
    Context context = a.getContext();
    String str4 = b.getAppkey();
    String str2 = b.l();
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    String str5 = d.a(context).get(LogField.APPVERSION.toString());
    String str6 = d.a(context).get(LogField.OS.toString());
    String str7 = d.a(context).get(LogField.UTDID.toString());
    String str8 = String.valueOf(System.currentTimeMillis());
    IRequestAuth iRequestAuth = a.a();
    boolean bool = iRequestAuth instanceof com.alibaba.mtl.log.sign.SecurityRequestAuth;
    str2 = "0";
    String str3 = "1";
    if (!bool) {
      str3 = "0";
      str2 = "1";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str4);
    stringBuilder.append(str1);
    stringBuilder.append(str5);
    stringBuilder.append(str6);
    stringBuilder.append("2.5.1.3_for_bc");
    stringBuilder.append(str7);
    stringBuilder.append(str8);
    stringBuilder.append("3.0");
    stringBuilder.append(str3);
    if (paramString3 == null)
      paramString3 = ""; 
    stringBuilder.append(paramString3);
    if (paramString4 == null)
      paramString4 = ""; 
    stringBuilder.append(paramString4);
    paramString3 = iRequestAuth.getSign(j.b(stringBuilder.toString().getBytes()));
    if (!TextUtils.isEmpty(paramString2)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString2);
      stringBuilder1.append("&");
      paramString2 = stringBuilder1.toString();
    } else {
      paramString2 = "";
    } 
    return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s&k=%s", new Object[] { 
          paramString1, paramString2, e(str4), e(str5), e(str1), e("3.0"), e(paramString3), e(str7), "2.5.1.3_for_bc", str6, 
          str8, "", str3, str2 });
  }
  
  public static String a(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2) throws Exception {
    String str2;
    String str1 = "";
    String str3 = str1;
    if (paramMap2 != null) {
      str3 = str1;
      if (paramMap2.size() > 0) {
        Set<String> set = paramMap2.keySet();
        String[] arrayOfString = new String[set.size()];
        set.toArray(arrayOfString);
        arrayOfString = g.a().a(arrayOfString, true);
        int j = arrayOfString.length;
        int i = 0;
        while (true) {
          str3 = str1;
          if (i < j) {
            str3 = arrayOfString[i];
            byte[] arrayOfByte = (byte[])paramMap2.get(str3);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str1);
            stringBuilder.append(str3);
            stringBuilder.append(j.b(arrayOfByte));
            str1 = stringBuilder.toString();
            i++;
            continue;
          } 
          break;
        } 
      } 
    } 
    try {
      paramString = a(paramString, null, null, str3);
    } finally {
      paramString = null;
    } 
    str1 = paramString;
    if (!TextUtils.isEmpty(str2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("&dk=");
      stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
      str1 = stringBuilder.toString();
    } 
    return str1;
  }
  
  public static String b(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2) throws Exception {
    if (paramMap1 == null)
      new HashMap<Object, Object>(); 
    Context context = a.getContext();
    String str3 = b.getAppkey();
    String str2 = b.l();
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    String str4 = d.a(context).get(LogField.APPVERSION.toString());
    String str7 = d.a(context).get(LogField.OS.toString());
    String str5 = d.a(context).get(LogField.UTDID.toString());
    String str6 = String.valueOf(System.currentTimeMillis());
    IRequestAuth iRequestAuth = a.a();
    if (iRequestAuth instanceof com.alibaba.mtl.log.sign.SecurityRequestAuth) {
      str2 = "1";
    } else {
      str2 = "0";
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str3);
    stringBuilder2.append(str4);
    stringBuilder2.append(str1);
    stringBuilder2.append(str7);
    stringBuilder2.append(str5);
    stringBuilder2.append("2.5.1.3_for_bc");
    stringBuilder2.append(str6);
    stringBuilder2.append(str2);
    stringBuilder2.append(paramMap1.get("_b01n15"));
    stringBuilder2.append(paramMap1.get("_b01na"));
    str7 = iRequestAuth.getSign(j.b(stringBuilder2.toString().getBytes()));
    StringBuilder stringBuilder1 = new StringBuilder(paramString);
    stringBuilder1.append("?");
    stringBuilder1.append("ak");
    stringBuilder1.append("=");
    stringBuilder1.append(str3);
    stringBuilder1.append("&");
    stringBuilder1.append("av");
    stringBuilder1.append("=");
    stringBuilder1.append(str4);
    stringBuilder1.append("&");
    stringBuilder1.append("c");
    stringBuilder1.append("=");
    stringBuilder1.append(URLEncoder.encode(str1));
    stringBuilder1.append("&");
    stringBuilder1.append("d");
    stringBuilder1.append("=");
    stringBuilder1.append(str5);
    stringBuilder1.append("&");
    stringBuilder1.append("sv");
    stringBuilder1.append("=");
    stringBuilder1.append("2.5.1.3_for_bc");
    stringBuilder1.append("&");
    stringBuilder1.append("t");
    stringBuilder1.append("=");
    stringBuilder1.append(str6);
    stringBuilder1.append("&");
    stringBuilder1.append("is");
    stringBuilder1.append("=");
    stringBuilder1.append(str2);
    stringBuilder1.append("&");
    stringBuilder1.append("_b01n15");
    stringBuilder1.append("=");
    stringBuilder1.append(paramMap1.get("_b01n15"));
    stringBuilder1.append("&");
    stringBuilder1.append("_b01na");
    stringBuilder1.append("=");
    stringBuilder1.append(paramMap1.get("_b01na"));
    stringBuilder1.append("&");
    stringBuilder1.append("s");
    stringBuilder1.append("=");
    stringBuilder1.append(str7);
    return stringBuilder1.toString();
  }
  
  private static String e(String paramString) {
    if (paramString == null)
      return ""; 
    try {
      return URLEncoder.encode(paramString, "UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
      return paramString;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */