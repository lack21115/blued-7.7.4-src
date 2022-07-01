package com.blued.android.web;

import android.content.SharedPreferences;
import com.blued.android.core.AppInfo;
import java.util.ArrayList;
import java.util.List;

public class WebBlackListPreference {
  public static SharedPreferences a;
  
  public static SharedPreferences a() {
    if (a == null)
      a = AppInfo.d().getSharedPreferences("web_black_list", 0); 
    return a;
  }
  
  public static void a(String paramString) {
    List<String> list1;
    List<String> list2 = b();
    if (list2 != null && list2.size() > 0) {
      list2.add(paramString);
      list1 = list2;
    } else {
      list2 = new ArrayList<String>();
      list2.add(list1);
      list1 = list2;
    } 
    a(list1);
  }
  
  private static void a(List<String> paramList) {
    PreferenceBlackList preferenceBlackList = new PreferenceBlackList();
    preferenceBlackList.a = paramList;
    String str = AppInfo.f().toJson(preferenceBlackList);
    a().edit().putString("WEB_BLACK_LIST_JSON", str).commit();
  }
  
  public static List<String> b() {
    String str = a().getString("WEB_BLACK_LIST_JSON", "");
    List<String> list = new ArrayList();
    PreferenceBlackList preferenceBlackList = (PreferenceBlackList)AppInfo.f().fromJson(str, PreferenceBlackList.class);
    if (preferenceBlackList != null)
      list = preferenceBlackList.a; 
    return list;
  }
  
  public static void b(String paramString) {
    List<String> list = b();
    if (list != null && list.size() > 0 && list.contains(paramString))
      list.remove(paramString); 
    a(list);
  }
  
  public static boolean c(String paramString) {
    // Byte code:
    //   0: invokestatic b : ()Ljava/util/List;
    //   3: astore #5
    //   5: iconst_0
    //   6: istore_3
    //   7: iload_3
    //   8: istore_2
    //   9: aload #5
    //   11: ifnull -> 113
    //   14: iload_3
    //   15: istore_2
    //   16: aload #5
    //   18: invokeinterface size : ()I
    //   23: ifle -> 113
    //   26: iconst_0
    //   27: istore_1
    //   28: iconst_0
    //   29: istore_2
    //   30: iload_1
    //   31: aload #5
    //   33: invokeinterface size : ()I
    //   38: if_icmpge -> 113
    //   41: aload #5
    //   43: iload_1
    //   44: invokeinterface get : (I)Ljava/lang/Object;
    //   49: checkcast java/lang/String
    //   52: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   55: astore #6
    //   57: aload #6
    //   59: invokestatic e : (Ljava/lang/String;)Z
    //   62: istore_3
    //   63: iconst_1
    //   64: istore #4
    //   66: iload_3
    //   67: ifne -> 95
    //   70: iload #4
    //   72: istore_3
    //   73: iload_2
    //   74: ifne -> 104
    //   77: aload #6
    //   79: aload_0
    //   80: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   83: invokevirtual equals : (Ljava/lang/Object;)Z
    //   86: ifeq -> 102
    //   89: iload #4
    //   91: istore_3
    //   92: goto -> 104
    //   95: iload #4
    //   97: istore_3
    //   98: iload_2
    //   99: ifne -> 104
    //   102: iconst_0
    //   103: istore_3
    //   104: iload_3
    //   105: istore_2
    //   106: iload_1
    //   107: iconst_1
    //   108: iadd
    //   109: istore_1
    //   110: goto -> 30
    //   113: iload_2
    //   114: ireturn
  }
  
  public static class PreferenceBlackList {
    public List<String> a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\web\WebBlackListPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */