package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;

public final class JsonUtils {
  private static final Pattern zza = Pattern.compile("\\\\.");
  
  private static final Pattern zzb = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
  
  public static boolean areJsonValuesEquivalent(Object paramObject1, Object paramObject2) {
    if (paramObject1 == null && paramObject2 == null)
      return true; 
    if (paramObject1 != null) {
      if (paramObject2 == null)
        return false; 
      if (paramObject1 instanceof org.json.JSONObject && paramObject2 instanceof org.json.JSONObject) {
        paramObject1 = paramObject1;
        paramObject2 = paramObject2;
        if (paramObject1.length() != paramObject2.length())
          return false; 
        Iterator<String> iterator = paramObject1.keys();
        while (true) {
          if (iterator.hasNext()) {
            String str = iterator.next();
            if (!paramObject2.has(str))
              return false; 
            try {
              boolean bool = areJsonValuesEquivalent(paramObject1.get(str), paramObject2.get(str));
              if (!bool)
                return false; 
            } catch (JSONException null) {
              return false;
            } 
            continue;
          } 
          return true;
        } 
      } 
      if (jSONException instanceof JSONArray && paramObject2 instanceof JSONArray) {
        JSONArray jSONArray = (JSONArray)jSONException;
        paramObject2 = paramObject2;
        if (jSONArray.length() != paramObject2.length())
          return false; 
        int i = 0;
        while (true) {
          if (i < jSONArray.length()) {
            try {
              boolean bool = areJsonValuesEquivalent(jSONArray.get(i), paramObject2.get(i));
              if (!bool)
                return false; 
              i++;
            } catch (JSONException jSONException) {
              return false;
            } 
            continue;
          } 
          return true;
        } 
      } 
      return jSONException.equals(paramObject2);
    } 
    return false;
  }
  
  public static String escapeString(String paramString) {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      StringBuffer stringBuffer;
      Matcher matcher = zzb.matcher(paramString);
      str = null;
      while (matcher.find()) {
        StringBuffer stringBuffer1;
        String str1 = str;
        if (str == null)
          stringBuffer1 = new StringBuffer(); 
        char c = matcher.group().charAt(0);
        if (c != '\f') {
          if (c != '\r') {
            if (c != '"') {
              if (c != '/') {
                if (c != '\\') {
                  switch (c) {
                    default:
                      stringBuffer6 = stringBuffer1;
                      continue;
                    case '\n':
                      matcher.appendReplacement(stringBuffer1, "\\\\n");
                      stringBuffer6 = stringBuffer1;
                      continue;
                    case '\t':
                      matcher.appendReplacement(stringBuffer1, "\\\\t");
                      stringBuffer6 = stringBuffer1;
                      continue;
                    case '\b':
                      break;
                  } 
                  matcher.appendReplacement(stringBuffer1, "\\\\b");
                  StringBuffer stringBuffer6 = stringBuffer1;
                  continue;
                } 
                matcher.appendReplacement(stringBuffer1, "\\\\\\\\");
                StringBuffer stringBuffer5 = stringBuffer1;
                continue;
              } 
              matcher.appendReplacement(stringBuffer1, "\\\\/");
              StringBuffer stringBuffer4 = stringBuffer1;
              continue;
            } 
            matcher.appendReplacement(stringBuffer1, "\\\\\\\"");
            StringBuffer stringBuffer3 = stringBuffer1;
            continue;
          } 
          matcher.appendReplacement(stringBuffer1, "\\\\r");
          StringBuffer stringBuffer2 = stringBuffer1;
          continue;
        } 
        matcher.appendReplacement(stringBuffer1, "\\\\f");
        stringBuffer = stringBuffer1;
      } 
      if (stringBuffer == null)
        return paramString; 
      matcher.appendTail(stringBuffer);
      str = stringBuffer.toString();
    } 
    return str;
  }
  
  public static String unescapeString(String paramString) {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      StringBuffer stringBuffer;
      String str1 = zzd.zza(paramString);
      Matcher matcher = zza.matcher(str1);
      paramString = null;
      while (matcher.find()) {
        StringBuffer stringBuffer1;
        str = paramString;
        if (paramString == null)
          stringBuffer1 = new StringBuffer(); 
        char c = matcher.group().charAt(1);
        if (c != '"') {
          if (c != '/') {
            if (c != '\\') {
              if (c != 'b') {
                if (c != 'f') {
                  if (c != 'n') {
                    if (c != 'r') {
                      if (c == 't') {
                        matcher.appendReplacement(stringBuffer1, "\t");
                        StringBuffer stringBuffer8 = stringBuffer1;
                        continue;
                      } 
                      throw new IllegalStateException("Found an escaped character that should never be.");
                    } 
                    matcher.appendReplacement(stringBuffer1, "\r");
                    StringBuffer stringBuffer7 = stringBuffer1;
                    continue;
                  } 
                  matcher.appendReplacement(stringBuffer1, "\n");
                  StringBuffer stringBuffer6 = stringBuffer1;
                  continue;
                } 
                matcher.appendReplacement(stringBuffer1, "\f");
                StringBuffer stringBuffer5 = stringBuffer1;
                continue;
              } 
              matcher.appendReplacement(stringBuffer1, "\b");
              StringBuffer stringBuffer4 = stringBuffer1;
              continue;
            } 
            matcher.appendReplacement(stringBuffer1, "\\\\");
            StringBuffer stringBuffer3 = stringBuffer1;
            continue;
          } 
          matcher.appendReplacement(stringBuffer1, "/");
          StringBuffer stringBuffer2 = stringBuffer1;
          continue;
        } 
        matcher.appendReplacement(stringBuffer1, "\"");
        stringBuffer = stringBuffer1;
      } 
      if (stringBuffer == null)
        return str1; 
      matcher.appendTail(stringBuffer);
      str = stringBuffer.toString();
    } 
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\JsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */