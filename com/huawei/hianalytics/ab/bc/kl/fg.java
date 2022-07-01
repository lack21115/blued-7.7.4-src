package com.huawei.hianalytics.ab.bc.kl;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.gh.ab;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

public class fg {
  private static final String[] ab = new String[] { 
      "e2f856b9f9a4fd4cb2795aeaf83268e4bff189aaec05d691ffde76e075b82648", "173cf86fe9894a0f70dadd09d4fd88c380836099d4939f8c3754361bdc16a32b", "b368b110e3b565fe97c91f786e11bc48754cc8e4e6f21d8a94a68ac6ad67aaaf", "db48223fd9e143f7e133c57f5d08a4e38549ce3ebd921fe3b4003c26e5e35bed", "4bdecdf772491e35c4e8b48f88aee22bae1311984f2e1da4dfad0b78ee7f5163", "3081a0adab3018d57165e6dd24074bdbac640f6dbe21a9e24d3474a87ebf38b8", "db53fcdc9ab71e9bdd4eab257fe1aba7989ad2b24fbe3a85dfef72ea1dd6bae2", "d80f18e8081b624cc64985f87f70118f1702985d2e10dbc985ee7be334fd3c7d", "5fed96c85bd58c58aadbd465c172a4c9a794d8eb2f86cbc7bcee6caf4c7a2c5f", "07ff9b7aeeff969173c45b285fe0fecdbaae244576ff7a2796a36f1c0c11adb4", 
      "92974c6802419e4d18b5ec536cbfa167b8e8eff09ec4c8510a5b95750b1e0c82", "403f14ad2f0e5eb3c4f3a0bcd5c1592cc4492662ad53191c92905255d4990656", "4230baa077b401374d0fc012375047e79ea0790d58d095ef18d97d95470c738d" };
  
  public static String ab(String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      ab.cd("hmsSdk", "url is null");
      return paramString;
    } 
    try {
      if (!URLUtil.isNetworkUrl(paramString) || paramString.toLowerCase(Locale.US).startsWith("http:")) {
        ab.bc("hmsSdk", "url don't starts with https");
        return null;
      } 
      return (new URI(paramString)).getHost();
    } catch (URISyntaxException uRISyntaxException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getHostByURI error : ");
      stringBuilder.append(uRISyntaxException.getMessage());
      ab.bc("hmsSdk", stringBuilder.toString());
      return null;
    } 
  }
  
  private static String ab(String paramString, int paramInt) {
    if (TextUtils.isEmpty(paramString) || paramInt <= 0) {
      ab.cd("hmsSdk", "url is null");
      return paramString;
    } 
    String[] arrayOfString = paramString.split("\\.");
    if (arrayOfString.length < paramInt)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(arrayOfString[arrayOfString.length - paramInt]);
    for (int i = 1; i < paramInt; i++) {
      stringBuffer.append(".");
      stringBuffer.append(arrayOfString[arrayOfString.length - paramInt + i]);
    } 
    return stringBuffer.toString();
  }
  
  public static boolean ab(String paramString1, String paramString2, int paramInt) {
    paramString1 = ab(paramString1);
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      paramString1 = "url or whitelistHash is null";
      ab.bc("hmsSdk", paramString1);
      return false;
    } 
    String str = ab(paramString1, paramInt);
    if (TextUtils.isEmpty(str)) {
      paramString1 = "get urlLastNStr is null";
      ab.bc("hmsSdk", paramString1);
      return false;
    } 
    if (paramString2.equals(SHA.a(paramString1)))
      return true; 
    if (paramString2.equals(SHA.a(str))) {
      StringBuilder stringBuilder;
      try {
        paramString1 = paramString1.substring(0, paramString1.length() - str.length());
        return !paramString1.endsWith(".") ? false : paramString1.matches("^[A-Za-z0-9.-]+$");
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("IndexOutOfBoundsException");
        str1 = indexOutOfBoundsException.getMessage();
      } catch (Exception exception) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Exception : ");
        str1 = exception.getMessage();
      } 
      stringBuilder.append(str1);
      String str1 = stringBuilder.toString();
      ab.bc("hmsSdk", str1);
      return false;
    } 
    return false;
  }
  
  public static boolean bc(String paramString) {
    if (ab.ab.booleanValue())
      return true; 
    String[] arrayOfString = ab;
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (ab(paramString, arrayOfString[i], 2))
        return true; 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\kl\fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */