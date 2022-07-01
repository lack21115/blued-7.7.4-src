package com.soft.blued.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.model.AreaCode;
import com.soft.blued.ui.user.model.Country;
import com.soft.blued.user.UserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public class AreaUtils {
  public static Map<String, String> a = (Map<String, String>)new ArrayMap();
  
  public static Map<String, String> b = (Map<String, String>)new ArrayMap();
  
  public static Map<String, String> c = (Map<String, String>)new ArrayMap();
  
  public static Map<String, String> d = (Map<String, String>)new ArrayMap();
  
  public static Map<String, String> e = (Map<String, String>)new ArrayMap();
  
  public static String f = "";
  
  public static String g = "";
  
  public static String a(Context paramContext, Long paramLong) {
    if (BlueAppLocal.d()) {
      if (paramLong.longValue() >= 100000L && paramLong.longValue() < 100000000L) {
        if (Math.round((float)paramLong.longValue() / 1.0E7F) * 10000000 >= 100000000) {
          StringBuilder stringBuilder3 = new StringBuilder();
          StringBuilder stringBuilder4 = new StringBuilder();
          stringBuilder4.append(Math.round((float)paramLong.longValue() / 1.0E7F));
          stringBuilder4.append("");
          stringBuilder3.append(StringUtils.a(stringBuilder4.toString()));
          stringBuilder3.append(paramContext.getResources().getString(2131756134));
          return stringBuilder3.toString();
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(Math.round((float)paramLong.longValue() / 10000.0F));
        stringBuilder2.append("");
        stringBuilder1.append(StringUtils.a(stringBuilder2.toString()));
        stringBuilder1.append(paramContext.getResources().getString(2131756133));
        return stringBuilder1.toString();
      } 
      if (paramLong.longValue() >= 100000000L) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(Math.round((float)paramLong.longValue() / 1.0E7F));
        stringBuilder2.append("");
        stringBuilder1.append(StringUtils.a(stringBuilder2.toString()));
        stringBuilder1.append(paramContext.getResources().getString(2131756134));
        return stringBuilder1.toString();
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramLong);
      stringBuilder.append("");
      return StringUtils.a(stringBuilder.toString());
    } 
    if (paramLong.longValue() >= 100000L && paramLong.longValue() < 1000000L) {
      if (Math.round((float)paramLong.longValue() / 1000.0F) * 1000 >= 1000000) {
        StringBuilder stringBuilder3 = new StringBuilder();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(Math.round((float)paramLong.longValue() / 1000000.0F));
        stringBuilder4.append("");
        stringBuilder3.append(StringUtils.a(stringBuilder4.toString()));
        stringBuilder3.append(stringBuilder.getResources().getString(2131756134));
        return stringBuilder3.toString();
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(Math.round((float)paramLong.longValue() / 1000.0F));
      stringBuilder2.append("");
      stringBuilder1.append(StringUtils.a(stringBuilder2.toString()));
      stringBuilder1.append(stringBuilder.getResources().getString(2131756133));
      return stringBuilder1.toString();
    } 
    if (paramLong.longValue() >= 1000000L) {
      StringBuilder stringBuilder1 = new StringBuilder();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(Math.round((float)paramLong.longValue() / 1000000.0F));
      stringBuilder2.append("");
      stringBuilder1.append(StringUtils.a(stringBuilder2.toString()));
      stringBuilder1.append(stringBuilder.getResources().getString(2131756134));
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    return StringUtils.a(stringBuilder.toString());
  }
  
  public static String a(Context paramContext, String paramString) {
    try {
      return a(paramContext, Long.valueOf(Long.parseLong(paramString)));
    } catch (Exception exception) {
      return "0";
    } 
  }
  
  public static String a(String paramString, Locale paramLocale) {
    return a(paramString, paramLocale, false);
  }
  
  public static String a(String paramString, Locale paramLocale, boolean paramBoolean) {
    if (!StringUtils.e(paramString)) {
      StringBuilder stringBuilder;
      String str = paramString;
      if (paramString.contains("999_000000"))
        str = "1_999_000000"; 
      str = str.replace("\\s", "").replace("\n", "");
      if (a.size() <= 0 || !TextUtils.equals(paramLocale.getLanguage(), f) || !TextUtils.equals(paramLocale.getCountry(), g))
        a(); 
      if (Pattern.compile("^[0-9]{1}_[0-9]{3}_[0-9a-zA-Z]{6}$").matcher(str).matches()) {
        String[] arrayOfString;
        String str1 = AppInfo.d().getResources().getString(2131759102);
        boolean bool = a.containsKey(str);
        int i = 1;
        if (bool) {
          paramString = a.get(str);
        } else if (str.length() >= 8 && c.containsKey(str.substring(0, 8))) {
          paramString = c.get(str.substring(0, 8));
        } else if (str.length() >= 5 && d.containsKey(str.substring(0, 5))) {
          paramString = d.get(str.substring(0, 5));
        } else {
          paramString = str1;
          if (str.length() >= 1) {
            paramString = str1;
            if (e.containsKey(str.substring(0, 1)))
              paramString = e.get(str.substring(0, 1)); 
          } 
        } 
        if (paramString.contains("_")) {
          arrayOfString = paramString.split("_");
          if (arrayOfString.length == 2)
            return arrayOfString[1]; 
          if (arrayOfString.length >= 3) {
            if (UserInfo.a() != null && UserInfo.a().i() != null && a(str, UserInfo.a().i().getCity_settled())) {
              if ("en".equals(BlueAppLocal.c().getLanguage())) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(arrayOfString[arrayOfString.length - 1]);
                stringBuilder3.append(" ");
                stringBuilder3.append(arrayOfString[arrayOfString.length - 2]);
                return stringBuilder3.toString();
              } 
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append(arrayOfString[arrayOfString.length - 2]);
              stringBuilder2.append(" ");
              stringBuilder2.append(arrayOfString[arrayOfString.length - 1]);
              return stringBuilder2.toString();
            } 
            if ("en".equals(BlueAppLocal.c().getLanguage())) {
              if (paramBoolean) {
                StringBuffer stringBuffer = new StringBuffer();
                for (i = arrayOfString.length - 1; i >= 1; i--) {
                  stringBuilder = new StringBuilder();
                  stringBuilder.append(" ");
                  stringBuilder.append(arrayOfString[i]);
                  stringBuffer.append(stringBuilder.toString());
                } 
                return stringBuffer.toString();
              } 
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append(arrayOfString[2]);
              stringBuilder2.append(" ");
              stringBuilder2.append(arrayOfString[1]);
              return stringBuilder2.toString();
            } 
            if (paramBoolean) {
              StringBuffer stringBuffer = new StringBuffer();
              while (i < arrayOfString.length) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(" ");
                stringBuilder.append(arrayOfString[i]);
                stringBuffer.append(stringBuilder.toString());
                i++;
              } 
              return stringBuffer.toString();
            } 
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(arrayOfString[1]);
            stringBuilder1.append(" ");
            stringBuilder1.append(arrayOfString[2]);
            return stringBuilder1.toString();
          } 
          return arrayOfString[0];
        } 
        return (String)arrayOfString;
      } 
      return (String)stringBuilder;
    } 
    return AppInfo.d().getResources().getString(2131759102);
  }
  
  public static String a(List<AreaCode> paramList) {
    Iterator<AreaCode> iterator = paramList.iterator();
    String str = BlueAppLocal.c().getCountry();
    while (iterator.hasNext()) {
      AreaCode areaCode = iterator.next();
      if (str.toUpperCase().equals(areaCode.getAbbr().toUpperCase()))
        return areaCode.getCode(); 
    } 
    return "";
  }
  
  public static List<Country> a(String paramString) {
    ArrayList<Country> arrayList = new ArrayList();
    if (!StringUtils.e(paramString)) {
      String str1 = "";
      String str2 = paramString.replace("\\s", "").replace("\n", "");
      if (a.isEmpty() || !BlueAppLocal.c().getLanguage().equals(f) || !BlueAppLocal.c().getCountry().equals(g))
        a(); 
      Iterator<Map.Entry> iterator = a.entrySet().iterator();
      paramString = str1;
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        String str4 = entry.getKey().toString();
        String str3 = entry.getValue().toString();
        if (str4.indexOf(str2) == 0) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str2);
          stringBuilder.append("0000");
          if (!str4.equals(stringBuilder.toString())) {
            Country country;
            String str;
            StringBuilder stringBuilder1;
            if ((str2.split("_")).length == 2) {
              if (str3.contains("_") && (str3.split("_")).length >= 3) {
                String str5 = str3.split("_")[2];
                country = new Country(str5, str4, "", "", "", 0);
                boolean bool = "0000".equals(str4.substring(str4.length() - 4));
                int i = 0;
                if (bool) {
                  Country country1 = country;
                  country1.has_child = "0";
                  country1.nation_code = str4;
                } else {
                  Country country1 = country;
                  country1.has_child = "1";
                  country1.nation_code = str4.substring(0, 8);
                } 
                if (!paramString.contains(str5)) {
                  stringBuilder = new StringBuilder();
                  stringBuilder.append(paramString);
                  stringBuilder.append(";");
                  stringBuilder.append(str5);
                  paramString = stringBuilder.toString();
                  arrayList.add(country);
                  continue;
                } 
                while (i < arrayList.size()) {
                  if (((Country)arrayList.get(i)).nation.equals(str5) && ((Country)arrayList.get(i)).has_child.equals("0") && country.has_child.equals("1")) {
                    ((Country)arrayList.get(i)).has_child = country.has_child;
                    ((Country)arrayList.get(i)).nation_code = country.nation_code;
                  } 
                  i++;
                } 
              } 
              continue;
            } 
            if ((country.split("_")).length == 4) {
              str = country.split("_")[3];
              Country country1 = new Country(str, str4, "", "", "", 0);
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append(paramString);
              stringBuilder1.append(";");
              stringBuilder1.append(str);
              paramString = stringBuilder1.toString();
              arrayList.add(country1);
              continue;
            } 
            if ((str.split("_")).length == 3) {
              str = str.split("_")[2];
              Country country1 = new Country(str, (String)stringBuilder1, "", "", "", 0);
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append(paramString);
              stringBuilder1.append(";");
              stringBuilder1.append(str);
              paramString = stringBuilder1.toString();
              arrayList.add(country1);
            } 
          } 
        } 
      } 
    } 
    Collections.sort(arrayList, new Comparator<Country>() {
          public int a(Country param1Country1, Country param1Country2) {
            return param1Country1.nation_code.compareTo(param1Country2.nation_code);
          }
        });
    return arrayList;
  }
  
  public static void a() {
    // Byte code:
    //   0: getstatic com/soft/blued/utils/AreaUtils.a : Ljava/util/Map;
    //   3: invokeinterface clear : ()V
    //   8: getstatic com/soft/blued/utils/AreaUtils.b : Ljava/util/Map;
    //   11: invokeinterface clear : ()V
    //   16: getstatic com/soft/blued/utils/AreaUtils.c : Ljava/util/Map;
    //   19: invokeinterface clear : ()V
    //   24: getstatic com/soft/blued/utils/AreaUtils.d : Ljava/util/Map;
    //   27: invokeinterface clear : ()V
    //   32: getstatic com/soft/blued/utils/AreaUtils.e : Ljava/util/Map;
    //   35: invokeinterface clear : ()V
    //   40: aconst_null
    //   41: astore_3
    //   42: invokestatic c : ()Ljava/util/Locale;
    //   45: invokevirtual getLanguage : ()Ljava/lang/String;
    //   48: putstatic com/soft/blued/utils/AreaUtils.f : Ljava/lang/String;
    //   51: invokestatic c : ()Ljava/util/Locale;
    //   54: invokevirtual getCountry : ()Ljava/lang/String;
    //   57: putstatic com/soft/blued/utils/AreaUtils.g : Ljava/lang/String;
    //   60: invokestatic d : ()Z
    //   63: ifeq -> 116
    //   66: ldc_w 'CN'
    //   69: invokestatic c : ()Ljava/util/Locale;
    //   72: invokevirtual getCountry : ()Ljava/lang/String;
    //   75: invokevirtual toUpperCase : ()Ljava/lang/String;
    //   78: invokevirtual equals : (Ljava/lang/Object;)Z
    //   81: ifeq -> 100
    //   84: invokestatic d : ()Landroid/content/Context;
    //   87: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   90: ldc_w 'CityCode/cityCode_zh.txt'
    //   93: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   96: astore_2
    //   97: goto -> 129
    //   100: invokestatic d : ()Landroid/content/Context;
    //   103: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   106: ldc_w 'CityCode/cityCode_tw.txt'
    //   109: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   112: astore_2
    //   113: goto -> 129
    //   116: invokestatic d : ()Landroid/content/Context;
    //   119: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   122: ldc_w 'CityCode/cityCode_en.txt'
    //   125: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   128: astore_2
    //   129: new java/io/BufferedReader
    //   132: dup
    //   133: new java/io/InputStreamReader
    //   136: dup
    //   137: aload_2
    //   138: ldc_w 'UTF-8'
    //   141: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   144: invokespecial <init> : (Ljava/io/Reader;)V
    //   147: astore #4
    //   149: new java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial <init> : ()V
    //   156: astore_3
    //   157: aload #4
    //   159: invokevirtual readLine : ()Ljava/lang/String;
    //   162: astore #5
    //   164: aload #5
    //   166: ifnull -> 179
    //   169: aload_3
    //   170: aload #5
    //   172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: goto -> 157
    //   179: aload_3
    //   180: invokevirtual toString : ()Ljava/lang/String;
    //   183: ldc_w '{'
    //   186: ldc ''
    //   188: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   191: ldc_w '}'
    //   194: ldc ''
    //   196: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   199: ldc_w ','
    //   202: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   205: astore #6
    //   207: aload_3
    //   208: iconst_0
    //   209: aload_3
    //   210: invokevirtual length : ()I
    //   213: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: iconst_0
    //   218: istore_0
    //   219: iload_0
    //   220: aload #6
    //   222: arraylength
    //   223: if_icmpge -> 779
    //   226: aload #6
    //   228: iload_0
    //   229: aaload
    //   230: ldc_w ':'
    //   233: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   236: iconst_0
    //   237: aaload
    //   238: ldc_w '"'
    //   241: ldc ''
    //   243: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   246: invokevirtual trim : ()Ljava/lang/String;
    //   249: astore #7
    //   251: aload #6
    //   253: iload_0
    //   254: aaload
    //   255: ldc_w ':'
    //   258: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   261: iconst_1
    //   262: aaload
    //   263: ldc_w '"'
    //   266: ldc ''
    //   268: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   271: invokevirtual trim : ()Ljava/lang/String;
    //   274: astore_3
    //   275: aload_3
    //   276: astore #5
    //   278: aload #7
    //   280: ldc_w '1_156_'
    //   283: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   286: ifeq -> 362
    //   289: aload_3
    //   290: astore #5
    //   292: aload #7
    //   294: ldc_w '1_156_000000'
    //   297: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   300: ifne -> 362
    //   303: new java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial <init> : ()V
    //   310: astore #5
    //   312: aload #5
    //   314: invokestatic d : ()Landroid/content/Context;
    //   317: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   320: ldc_w 2131755355
    //   323: invokevirtual getString : (I)Ljava/lang/String;
    //   326: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload #5
    //   332: invokestatic d : ()Landroid/content/Context;
    //   335: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   338: ldc_w 2131755823
    //   341: invokevirtual getString : (I)Ljava/lang/String;
    //   344: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload #5
    //   350: aload_3
    //   351: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload #5
    //   357: invokevirtual toString : ()Ljava/lang/String;
    //   360: astore #5
    //   362: getstatic com/soft/blued/utils/AreaUtils.a : Ljava/util/Map;
    //   365: aload #7
    //   367: aload #5
    //   369: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   374: pop
    //   375: getstatic com/soft/blued/utils/AreaUtils.b : Ljava/util/Map;
    //   378: aload #5
    //   380: aload #7
    //   382: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   387: pop
    //   388: aload #7
    //   390: iconst_0
    //   391: bipush #8
    //   393: invokevirtual substring : (II)Ljava/lang/String;
    //   396: astore #9
    //   398: aload #5
    //   400: ldc '_'
    //   402: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   405: astore #8
    //   407: aload #8
    //   409: arraylength
    //   410: iconst_3
    //   411: if_icmplt -> 959
    //   414: new java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial <init> : ()V
    //   421: astore_3
    //   422: aload_3
    //   423: aload #8
    //   425: iconst_0
    //   426: aaload
    //   427: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload_3
    //   432: ldc '_'
    //   434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload_3
    //   439: aload #8
    //   441: iconst_1
    //   442: aaload
    //   443: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload_3
    //   448: ldc '_'
    //   450: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload_3
    //   455: aload #8
    //   457: iconst_2
    //   458: aaload
    //   459: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload_3
    //   464: invokevirtual toString : ()Ljava/lang/String;
    //   467: astore_3
    //   468: goto -> 537
    //   471: iload_1
    //   472: aload #8
    //   474: arraylength
    //   475: if_icmpge -> 973
    //   478: new java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial <init> : ()V
    //   485: astore #10
    //   487: aload #10
    //   489: aload_3
    //   490: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_3
    //   495: invokestatic e : (Ljava/lang/String;)Z
    //   498: ifeq -> 967
    //   501: ldc ''
    //   503: astore_3
    //   504: goto -> 507
    //   507: aload #10
    //   509: aload_3
    //   510: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload #10
    //   516: aload #8
    //   518: iload_1
    //   519: aaload
    //   520: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload #10
    //   526: invokevirtual toString : ()Ljava/lang/String;
    //   529: astore_3
    //   530: iload_1
    //   531: iconst_1
    //   532: iadd
    //   533: istore_1
    //   534: goto -> 471
    //   537: getstatic com/soft/blued/utils/AreaUtils.c : Ljava/util/Map;
    //   540: aload #9
    //   542: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   547: ifne -> 562
    //   550: getstatic com/soft/blued/utils/AreaUtils.c : Ljava/util/Map;
    //   553: aload #9
    //   555: aload_3
    //   556: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   561: pop
    //   562: aload #7
    //   564: iconst_0
    //   565: iconst_5
    //   566: invokevirtual substring : (II)Ljava/lang/String;
    //   569: astore #9
    //   571: aload #5
    //   573: ldc '_'
    //   575: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   578: astore #10
    //   580: aload #10
    //   582: arraylength
    //   583: iconst_2
    //   584: if_icmplt -> 976
    //   587: new java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial <init> : ()V
    //   594: astore_3
    //   595: aload_3
    //   596: aload #10
    //   598: iconst_0
    //   599: aaload
    //   600: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload_3
    //   605: ldc '_'
    //   607: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload_3
    //   612: aload #8
    //   614: iconst_1
    //   615: aaload
    //   616: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload_3
    //   621: invokevirtual toString : ()Ljava/lang/String;
    //   624: astore_3
    //   625: goto -> 694
    //   628: iload_1
    //   629: aload #10
    //   631: arraylength
    //   632: if_icmpge -> 990
    //   635: new java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial <init> : ()V
    //   642: astore #8
    //   644: aload #8
    //   646: aload_3
    //   647: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload_3
    //   652: invokestatic e : (Ljava/lang/String;)Z
    //   655: ifeq -> 984
    //   658: ldc ''
    //   660: astore_3
    //   661: goto -> 664
    //   664: aload #8
    //   666: aload_3
    //   667: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload #8
    //   673: aload #10
    //   675: iload_1
    //   676: aaload
    //   677: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: aload #8
    //   683: invokevirtual toString : ()Ljava/lang/String;
    //   686: astore_3
    //   687: iload_1
    //   688: iconst_1
    //   689: iadd
    //   690: istore_1
    //   691: goto -> 628
    //   694: getstatic com/soft/blued/utils/AreaUtils.d : Ljava/util/Map;
    //   697: aload #9
    //   699: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   704: ifne -> 719
    //   707: getstatic com/soft/blued/utils/AreaUtils.d : Ljava/util/Map;
    //   710: aload #9
    //   712: aload_3
    //   713: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   718: pop
    //   719: aload #7
    //   721: iconst_0
    //   722: iconst_1
    //   723: invokevirtual substring : (II)Ljava/lang/String;
    //   726: astore_3
    //   727: aload #5
    //   729: ldc '_'
    //   731: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   734: astore #5
    //   736: aload #5
    //   738: arraylength
    //   739: ifle -> 772
    //   742: aload #5
    //   744: iconst_0
    //   745: aaload
    //   746: astore #5
    //   748: getstatic com/soft/blued/utils/AreaUtils.e : Ljava/util/Map;
    //   751: aload_3
    //   752: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   757: ifne -> 772
    //   760: getstatic com/soft/blued/utils/AreaUtils.e : Ljava/util/Map;
    //   763: aload_3
    //   764: aload #5
    //   766: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   771: pop
    //   772: iload_0
    //   773: iconst_1
    //   774: iadd
    //   775: istore_0
    //   776: goto -> 219
    //   779: aload_2
    //   780: ifnull -> 787
    //   783: aload_2
    //   784: invokevirtual close : ()V
    //   787: aload #4
    //   789: invokevirtual close : ()V
    //   792: return
    //   793: astore_3
    //   794: aload_2
    //   795: astore #5
    //   797: aload #4
    //   799: astore_2
    //   800: goto -> 885
    //   803: astore_3
    //   804: goto -> 824
    //   807: astore_3
    //   808: aconst_null
    //   809: astore #4
    //   811: aload_2
    //   812: astore #5
    //   814: aload #4
    //   816: astore_2
    //   817: goto -> 885
    //   820: astore_3
    //   821: aconst_null
    //   822: astore #4
    //   824: aload_3
    //   825: astore #5
    //   827: aload_2
    //   828: astore_3
    //   829: aload #4
    //   831: astore_2
    //   832: goto -> 855
    //   835: aconst_null
    //   836: astore #4
    //   838: goto -> 920
    //   841: astore_3
    //   842: aconst_null
    //   843: astore #5
    //   845: aload #5
    //   847: astore_2
    //   848: goto -> 885
    //   851: astore #5
    //   853: aconst_null
    //   854: astore_2
    //   855: aload #5
    //   857: invokevirtual printStackTrace : ()V
    //   860: aload_3
    //   861: ifnull -> 868
    //   864: aload_3
    //   865: invokevirtual close : ()V
    //   868: aload_2
    //   869: ifnull -> 946
    //   872: aload_2
    //   873: invokevirtual close : ()V
    //   876: return
    //   877: astore #4
    //   879: aload_3
    //   880: astore #5
    //   882: aload #4
    //   884: astore_3
    //   885: aload #5
    //   887: ifnull -> 898
    //   890: aload #5
    //   892: invokevirtual close : ()V
    //   895: goto -> 898
    //   898: aload_2
    //   899: ifnull -> 913
    //   902: aload_2
    //   903: invokevirtual close : ()V
    //   906: goto -> 913
    //   909: aload_2
    //   910: invokevirtual printStackTrace : ()V
    //   913: aload_3
    //   914: athrow
    //   915: aconst_null
    //   916: astore_2
    //   917: aload_2
    //   918: astore #4
    //   920: aload_2
    //   921: ifnull -> 931
    //   924: aload_2
    //   925: invokevirtual close : ()V
    //   928: goto -> 931
    //   931: aload #4
    //   933: ifnull -> 946
    //   936: aload #4
    //   938: invokevirtual close : ()V
    //   941: return
    //   942: aload_2
    //   943: invokevirtual printStackTrace : ()V
    //   946: return
    //   947: astore_2
    //   948: goto -> 915
    //   951: astore_3
    //   952: goto -> 835
    //   955: astore_3
    //   956: goto -> 920
    //   959: ldc ''
    //   961: astore_3
    //   962: iconst_0
    //   963: istore_1
    //   964: goto -> 471
    //   967: ldc '_'
    //   969: astore_3
    //   970: goto -> 507
    //   973: goto -> 537
    //   976: ldc ''
    //   978: astore_3
    //   979: iconst_0
    //   980: istore_1
    //   981: goto -> 628
    //   984: ldc '_'
    //   986: astore_3
    //   987: goto -> 664
    //   990: goto -> 694
    //   993: astore_2
    //   994: goto -> 909
    //   997: astore_2
    //   998: goto -> 942
    // Exception table:
    //   from	to	target	type
    //   42	97	947	java/lang/OutOfMemoryError
    //   42	97	851	java/io/IOException
    //   42	97	841	finally
    //   100	113	947	java/lang/OutOfMemoryError
    //   100	113	851	java/io/IOException
    //   100	113	841	finally
    //   116	129	947	java/lang/OutOfMemoryError
    //   116	129	851	java/io/IOException
    //   116	129	841	finally
    //   129	149	951	java/lang/OutOfMemoryError
    //   129	149	820	java/io/IOException
    //   129	149	807	finally
    //   149	157	955	java/lang/OutOfMemoryError
    //   149	157	803	java/io/IOException
    //   149	157	793	finally
    //   157	164	955	java/lang/OutOfMemoryError
    //   157	164	803	java/io/IOException
    //   157	164	793	finally
    //   169	176	955	java/lang/OutOfMemoryError
    //   169	176	803	java/io/IOException
    //   169	176	793	finally
    //   179	217	955	java/lang/OutOfMemoryError
    //   179	217	803	java/io/IOException
    //   179	217	793	finally
    //   219	275	955	java/lang/OutOfMemoryError
    //   219	275	803	java/io/IOException
    //   219	275	793	finally
    //   278	289	955	java/lang/OutOfMemoryError
    //   278	289	803	java/io/IOException
    //   278	289	793	finally
    //   292	362	955	java/lang/OutOfMemoryError
    //   292	362	803	java/io/IOException
    //   292	362	793	finally
    //   362	468	955	java/lang/OutOfMemoryError
    //   362	468	803	java/io/IOException
    //   362	468	793	finally
    //   471	501	955	java/lang/OutOfMemoryError
    //   471	501	803	java/io/IOException
    //   471	501	793	finally
    //   507	530	955	java/lang/OutOfMemoryError
    //   507	530	803	java/io/IOException
    //   507	530	793	finally
    //   537	562	955	java/lang/OutOfMemoryError
    //   537	562	803	java/io/IOException
    //   537	562	793	finally
    //   562	625	955	java/lang/OutOfMemoryError
    //   562	625	803	java/io/IOException
    //   562	625	793	finally
    //   628	658	955	java/lang/OutOfMemoryError
    //   628	658	803	java/io/IOException
    //   628	658	793	finally
    //   664	687	955	java/lang/OutOfMemoryError
    //   664	687	803	java/io/IOException
    //   664	687	793	finally
    //   694	719	955	java/lang/OutOfMemoryError
    //   694	719	803	java/io/IOException
    //   694	719	793	finally
    //   719	742	955	java/lang/OutOfMemoryError
    //   719	742	803	java/io/IOException
    //   719	742	793	finally
    //   748	772	955	java/lang/OutOfMemoryError
    //   748	772	803	java/io/IOException
    //   748	772	793	finally
    //   783	787	997	java/io/IOException
    //   787	792	997	java/io/IOException
    //   855	860	877	finally
    //   864	868	997	java/io/IOException
    //   872	876	997	java/io/IOException
    //   890	895	993	java/io/IOException
    //   902	906	993	java/io/IOException
    //   924	928	997	java/io/IOException
    //   936	941	997	java/io/IOException
  }
  
  private static boolean a(String paramString1, String paramString2) {
    return (!StringUtils.e(paramString1) && !StringUtils.e(paramString2) && paramString1.length() >= 5 && paramString2.length() >= 5 && paramString1.substring(0, 5).equals(paramString2.substring(0, 5)));
  }
  
  public static String b(String paramString, Locale paramLocale) {
    if (!StringUtils.e(paramString)) {
      String str = paramString;
      if (paramString.contains("999_000000"))
        str = "1_999_000000"; 
      str = str.replace("\\s", "").replace("\n", "");
      if (a.size() <= 0 || !TextUtils.equals(paramLocale.getLanguage(), f) || !TextUtils.equals(paramLocale.getCountry(), g))
        a(); 
      if (Pattern.compile("^[0-9]{1}_[0-9]{3}_[0-9a-zA-Z]{6}$").matcher(str).matches()) {
        String str1 = AppInfo.d().getResources().getString(2131759102);
        if (a.containsKey(str)) {
          paramString = a.get(str);
        } else if (str.length() >= 8 && c.containsKey(str.substring(0, 8))) {
          paramString = c.get(str.substring(0, 8));
        } else if (str.length() >= 5 && d.containsKey(str.substring(0, 5))) {
          paramString = d.get(str.substring(0, 5));
        } else {
          paramString = str1;
          if (str.length() >= 1) {
            paramString = str1;
            if (e.containsKey(str.substring(0, 1)))
              paramString = e.get(str.substring(0, 1)); 
          } 
        } 
        if (paramString.contains("_")) {
          String[] arrayOfString = paramString.split("_");
          return (arrayOfString.length == 2) ? arrayOfString[1] : ((arrayOfString.length >= 3) ? arrayOfString[arrayOfString.length - 1] : arrayOfString[0]);
        } 
      } 
    } 
    return null;
  }
  
  public static List<AreaCode> b() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: invokestatic c : ()Ljava/util/Locale;
    //   5: invokevirtual getCountry : ()Ljava/lang/String;
    //   8: pop
    //   9: invokestatic d : ()Z
    //   12: ifeq -> 69
    //   15: ldc_w 'CN'
    //   18: invokestatic c : ()Ljava/util/Locale;
    //   21: invokevirtual getCountry : ()Ljava/lang/String;
    //   24: invokevirtual toUpperCase : ()Ljava/lang/String;
    //   27: invokevirtual equals : (Ljava/lang/Object;)Z
    //   30: ifeq -> 51
    //   33: invokestatic d : ()Landroid/content/Context;
    //   36: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   39: ldc_w 'areacode/areacode_zh.txt'
    //   42: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   45: astore_1
    //   46: aload_1
    //   47: astore_0
    //   48: goto -> 84
    //   51: invokestatic d : ()Landroid/content/Context;
    //   54: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   57: ldc_w 'areacode/areacode_zht.txt'
    //   60: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   63: astore_1
    //   64: aload_1
    //   65: astore_0
    //   66: goto -> 84
    //   69: invokestatic d : ()Landroid/content/Context;
    //   72: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   75: ldc_w 'areacode/areacode_en.txt'
    //   78: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   81: astore_1
    //   82: aload_1
    //   83: astore_0
    //   84: new java/io/BufferedReader
    //   87: dup
    //   88: new java/io/InputStreamReader
    //   91: dup
    //   92: aload_0
    //   93: ldc_w 'UTF-8'
    //   96: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   99: invokespecial <init> : (Ljava/io/Reader;)V
    //   102: astore_2
    //   103: new java/lang/StringBuffer
    //   106: dup
    //   107: invokespecial <init> : ()V
    //   110: astore_1
    //   111: aload_2
    //   112: invokevirtual readLine : ()Ljava/lang/String;
    //   115: astore_3
    //   116: aload_3
    //   117: ifnull -> 129
    //   120: aload_1
    //   121: aload_3
    //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   125: pop
    //   126: goto -> 111
    //   129: new com/soft/blued/utils/AreaUtils$2
    //   132: dup
    //   133: invokespecial <init> : ()V
    //   136: invokevirtual getType : ()Ljava/lang/reflect/Type;
    //   139: astore_3
    //   140: invokestatic f : ()Lcom/google/gson/Gson;
    //   143: aload_1
    //   144: invokevirtual toString : ()Ljava/lang/String;
    //   147: aload_3
    //   148: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   151: checkcast java/util/List
    //   154: astore_1
    //   155: aload_0
    //   156: ifnull -> 166
    //   159: aload_0
    //   160: invokevirtual close : ()V
    //   163: goto -> 166
    //   166: aload_2
    //   167: invokevirtual close : ()V
    //   170: aload_1
    //   171: areturn
    //   172: aload_0
    //   173: invokevirtual printStackTrace : ()V
    //   176: aload_1
    //   177: areturn
    //   178: astore_1
    //   179: goto -> 249
    //   182: astore_3
    //   183: aload_2
    //   184: astore_1
    //   185: aload_3
    //   186: astore_2
    //   187: goto -> 213
    //   190: astore_1
    //   191: aconst_null
    //   192: astore_2
    //   193: goto -> 249
    //   196: astore_2
    //   197: aconst_null
    //   198: astore_1
    //   199: goto -> 213
    //   202: astore_1
    //   203: aconst_null
    //   204: astore_2
    //   205: goto -> 249
    //   208: astore_2
    //   209: aconst_null
    //   210: astore_0
    //   211: aload_0
    //   212: astore_1
    //   213: aload_2
    //   214: invokevirtual printStackTrace : ()V
    //   217: aload_0
    //   218: ifnull -> 228
    //   221: aload_0
    //   222: invokevirtual close : ()V
    //   225: goto -> 228
    //   228: aload_1
    //   229: ifnull -> 242
    //   232: aload_1
    //   233: invokevirtual close : ()V
    //   236: aconst_null
    //   237: areturn
    //   238: aload_0
    //   239: invokevirtual printStackTrace : ()V
    //   242: aconst_null
    //   243: areturn
    //   244: astore_3
    //   245: aload_1
    //   246: astore_2
    //   247: aload_3
    //   248: astore_1
    //   249: aload_0
    //   250: ifnull -> 260
    //   253: aload_0
    //   254: invokevirtual close : ()V
    //   257: goto -> 260
    //   260: aload_2
    //   261: ifnull -> 275
    //   264: aload_2
    //   265: invokevirtual close : ()V
    //   268: goto -> 275
    //   271: aload_0
    //   272: invokevirtual printStackTrace : ()V
    //   275: aload_1
    //   276: athrow
    //   277: astore_0
    //   278: goto -> 172
    //   281: astore_0
    //   282: goto -> 238
    //   285: astore_0
    //   286: goto -> 271
    // Exception table:
    //   from	to	target	type
    //   2	46	208	java/io/IOException
    //   2	46	202	finally
    //   51	64	208	java/io/IOException
    //   51	64	202	finally
    //   69	82	208	java/io/IOException
    //   69	82	202	finally
    //   84	103	196	java/io/IOException
    //   84	103	190	finally
    //   103	111	182	java/io/IOException
    //   103	111	178	finally
    //   111	116	182	java/io/IOException
    //   111	116	178	finally
    //   120	126	182	java/io/IOException
    //   120	126	178	finally
    //   129	155	182	java/io/IOException
    //   129	155	178	finally
    //   159	163	277	java/io/IOException
    //   166	170	277	java/io/IOException
    //   213	217	244	finally
    //   221	225	281	java/io/IOException
    //   232	236	281	java/io/IOException
    //   253	257	285	java/io/IOException
    //   264	268	285	java/io/IOException
  }
  
  public static List<Country> c() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: invokestatic c : ()Ljava/util/Locale;
    //   5: invokevirtual getCountry : ()Ljava/lang/String;
    //   8: pop
    //   9: invokestatic c : ()Ljava/util/Locale;
    //   12: invokevirtual getLanguage : ()Ljava/lang/String;
    //   15: pop
    //   16: invokestatic d : ()Z
    //   19: ifeq -> 76
    //   22: ldc_w 'CN'
    //   25: invokestatic c : ()Ljava/util/Locale;
    //   28: invokevirtual getCountry : ()Ljava/lang/String;
    //   31: invokevirtual toUpperCase : ()Ljava/lang/String;
    //   34: invokevirtual equals : (Ljava/lang/Object;)Z
    //   37: ifeq -> 58
    //   40: invokestatic d : ()Landroid/content/Context;
    //   43: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   46: ldc_w 'CountryCode/countryCode_zh.txt'
    //   49: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   52: astore_1
    //   53: aload_1
    //   54: astore_0
    //   55: goto -> 91
    //   58: invokestatic d : ()Landroid/content/Context;
    //   61: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   64: ldc_w 'CountryCode/countryCode_tw.txt'
    //   67: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   70: astore_1
    //   71: aload_1
    //   72: astore_0
    //   73: goto -> 91
    //   76: invokestatic d : ()Landroid/content/Context;
    //   79: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   82: ldc_w 'CountryCode/countryCode_en.txt'
    //   85: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   88: astore_1
    //   89: aload_1
    //   90: astore_0
    //   91: new java/io/BufferedReader
    //   94: dup
    //   95: new java/io/InputStreamReader
    //   98: dup
    //   99: aload_0
    //   100: ldc_w 'UTF-8'
    //   103: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   106: invokespecial <init> : (Ljava/io/Reader;)V
    //   109: astore_2
    //   110: new java/lang/StringBuffer
    //   113: dup
    //   114: invokespecial <init> : ()V
    //   117: astore_1
    //   118: aload_2
    //   119: invokevirtual readLine : ()Ljava/lang/String;
    //   122: astore_3
    //   123: aload_3
    //   124: ifnull -> 136
    //   127: aload_1
    //   128: aload_3
    //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   132: pop
    //   133: goto -> 118
    //   136: new com/soft/blued/utils/AreaUtils$3
    //   139: dup
    //   140: invokespecial <init> : ()V
    //   143: invokevirtual getType : ()Ljava/lang/reflect/Type;
    //   146: astore_3
    //   147: invokestatic f : ()Lcom/google/gson/Gson;
    //   150: aload_1
    //   151: invokevirtual toString : ()Ljava/lang/String;
    //   154: aload_3
    //   155: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   158: checkcast java/util/List
    //   161: astore_1
    //   162: aload_0
    //   163: ifnull -> 173
    //   166: aload_0
    //   167: invokevirtual close : ()V
    //   170: goto -> 173
    //   173: aload_2
    //   174: invokevirtual close : ()V
    //   177: aload_1
    //   178: areturn
    //   179: aload_0
    //   180: invokevirtual printStackTrace : ()V
    //   183: aload_1
    //   184: areturn
    //   185: astore_1
    //   186: goto -> 256
    //   189: astore_3
    //   190: aload_2
    //   191: astore_1
    //   192: aload_3
    //   193: astore_2
    //   194: goto -> 220
    //   197: astore_1
    //   198: aconst_null
    //   199: astore_2
    //   200: goto -> 256
    //   203: astore_2
    //   204: aconst_null
    //   205: astore_1
    //   206: goto -> 220
    //   209: astore_1
    //   210: aconst_null
    //   211: astore_2
    //   212: goto -> 256
    //   215: astore_2
    //   216: aconst_null
    //   217: astore_0
    //   218: aload_0
    //   219: astore_1
    //   220: aload_2
    //   221: invokevirtual printStackTrace : ()V
    //   224: aload_0
    //   225: ifnull -> 235
    //   228: aload_0
    //   229: invokevirtual close : ()V
    //   232: goto -> 235
    //   235: aload_1
    //   236: ifnull -> 249
    //   239: aload_1
    //   240: invokevirtual close : ()V
    //   243: aconst_null
    //   244: areturn
    //   245: aload_0
    //   246: invokevirtual printStackTrace : ()V
    //   249: aconst_null
    //   250: areturn
    //   251: astore_3
    //   252: aload_1
    //   253: astore_2
    //   254: aload_3
    //   255: astore_1
    //   256: aload_0
    //   257: ifnull -> 267
    //   260: aload_0
    //   261: invokevirtual close : ()V
    //   264: goto -> 267
    //   267: aload_2
    //   268: ifnull -> 282
    //   271: aload_2
    //   272: invokevirtual close : ()V
    //   275: goto -> 282
    //   278: aload_0
    //   279: invokevirtual printStackTrace : ()V
    //   282: aload_1
    //   283: athrow
    //   284: astore_0
    //   285: goto -> 179
    //   288: astore_0
    //   289: goto -> 245
    //   292: astore_0
    //   293: goto -> 278
    // Exception table:
    //   from	to	target	type
    //   2	53	215	java/io/IOException
    //   2	53	209	finally
    //   58	71	215	java/io/IOException
    //   58	71	209	finally
    //   76	89	215	java/io/IOException
    //   76	89	209	finally
    //   91	110	203	java/io/IOException
    //   91	110	197	finally
    //   110	118	189	java/io/IOException
    //   110	118	185	finally
    //   118	123	189	java/io/IOException
    //   118	123	185	finally
    //   127	133	189	java/io/IOException
    //   127	133	185	finally
    //   136	162	189	java/io/IOException
    //   136	162	185	finally
    //   166	170	284	java/io/IOException
    //   173	177	284	java/io/IOException
    //   220	224	251	finally
    //   228	232	288	java/io/IOException
    //   239	243	288	java/io/IOException
    //   260	264	292	java/io/IOException
    //   271	275	292	java/io/IOException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\AreaUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */