package com.blued.android.module.chat.utils;

import android.content.SharedPreferences;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;

public class PreferencesUtils {
  private static String FOLLOWER_SWITCH;
  
  private static String INITIATOR_SWITCH;
  
  private static final String MODULE_CHAT_SP = "module_chat_sp";
  
  private static String NEARBY_SWITCH;
  
  private static String ONLINE_SWITCH;
  
  private static String TAG;
  
  private static String UPDTATE_FINISH;
  
  private static SharedPreferences module_chat_sp;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("@@@ module_chat_");
    stringBuilder.append(PreferencesUtils.class.getSimpleName());
    TAG = stringBuilder.toString();
    NEARBY_SWITCH = "nearby_switch";
    ONLINE_SWITCH = "online_switch";
    FOLLOWER_SWITCH = "follower_switch";
    INITIATOR_SWITCH = "initiator_switch";
    UPDTATE_FINISH = "updtate_finish";
  }
  
  public static boolean getFollowerSwitch() {
    boolean bool = getModuleChatSp().getBoolean(FOLLOWER_SWITCH, false);
    if (AppInfo.m()) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("获取筛选开关：follower：");
      stringBuilder.append(bool);
      Logger.b(str, new Object[] { stringBuilder.toString() });
    } 
    return bool;
  }
  
  public static boolean getInitiatorSwitch() {
    boolean bool = getModuleChatSp().getBoolean(INITIATOR_SWITCH, false);
    if (AppInfo.m()) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("获取筛选开关：initiator：");
      stringBuilder.append(bool);
      Logger.b(str, new Object[] { stringBuilder.toString() });
    } 
    return bool;
  }
  
  private static SharedPreferences getModuleChatSp() {
    if (module_chat_sp == null)
      module_chat_sp = AppInfo.d().getSharedPreferences("module_chat_sp", 0); 
    return module_chat_sp;
  }
  
  public static boolean getNearbySwitch() {
    boolean bool = getModuleChatSp().getBoolean(NEARBY_SWITCH, false);
    if (AppInfo.m()) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("获取筛选开关：nearby：");
      stringBuilder.append(bool);
      Logger.b(str, new Object[] { stringBuilder.toString() });
    } 
    return bool;
  }
  
  public static boolean getOnlineSwitch() {
    boolean bool = getModuleChatSp().getBoolean(ONLINE_SWITCH, false);
    if (AppInfo.m()) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("获取筛选开关：online：");
      stringBuilder.append(bool);
      Logger.b(str, new Object[] { stringBuilder.toString() });
    } 
    return bool;
  }
  
  public static boolean getUpdateFinish() {
    return getModuleChatSp().getBoolean(UPDTATE_FINISH, false);
  }
  
  public static void setFollowerSwitch(boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   2: monitorenter
    //   3: invokestatic getModuleChatSp : ()Landroid/content/SharedPreferences;
    //   6: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   11: getstatic com/blued/android/module/chat/utils/PreferencesUtils.FOLLOWER_SWITCH : Ljava/lang/String;
    //   14: iload_0
    //   15: invokeinterface putBoolean : (Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
    //   20: invokeinterface commit : ()Z
    //   25: pop
    //   26: invokestatic m : ()Z
    //   29: ifeq -> 72
    //   32: getstatic com/blued/android/module/chat/utils/PreferencesUtils.TAG : Ljava/lang/String;
    //   35: astore_1
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore_2
    //   44: aload_2
    //   45: ldc '设置筛选开关：follower：'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: iload_0
    //   53: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_1
    //   58: iconst_1
    //   59: anewarray java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_2
    //   65: invokevirtual toString : ()Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   74: monitorexit
    //   75: return
    //   76: astore_1
    //   77: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   3	72	76	finally
  }
  
  public static void setInitiatorSwitch(boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   2: monitorenter
    //   3: invokestatic getModuleChatSp : ()Landroid/content/SharedPreferences;
    //   6: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   11: getstatic com/blued/android/module/chat/utils/PreferencesUtils.INITIATOR_SWITCH : Ljava/lang/String;
    //   14: iload_0
    //   15: invokeinterface putBoolean : (Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
    //   20: invokeinterface commit : ()Z
    //   25: pop
    //   26: invokestatic m : ()Z
    //   29: ifeq -> 72
    //   32: getstatic com/blued/android/module/chat/utils/PreferencesUtils.TAG : Ljava/lang/String;
    //   35: astore_1
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore_2
    //   44: aload_2
    //   45: ldc '设置筛选开关：initiator：'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: iload_0
    //   53: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_1
    //   58: iconst_1
    //   59: anewarray java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_2
    //   65: invokevirtual toString : ()Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   74: monitorexit
    //   75: return
    //   76: astore_1
    //   77: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   3	72	76	finally
  }
  
  public static void setNearbySwitch(boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   2: monitorenter
    //   3: invokestatic getModuleChatSp : ()Landroid/content/SharedPreferences;
    //   6: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   11: getstatic com/blued/android/module/chat/utils/PreferencesUtils.NEARBY_SWITCH : Ljava/lang/String;
    //   14: iload_0
    //   15: invokeinterface putBoolean : (Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
    //   20: invokeinterface commit : ()Z
    //   25: pop
    //   26: invokestatic m : ()Z
    //   29: ifeq -> 72
    //   32: getstatic com/blued/android/module/chat/utils/PreferencesUtils.TAG : Ljava/lang/String;
    //   35: astore_1
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore_2
    //   44: aload_2
    //   45: ldc '设置筛选开关：nearby：'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: iload_0
    //   53: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_1
    //   58: iconst_1
    //   59: anewarray java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_2
    //   65: invokevirtual toString : ()Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   74: monitorexit
    //   75: return
    //   76: astore_1
    //   77: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   3	72	76	finally
  }
  
  public static void setOnlineSwitch(boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   2: monitorenter
    //   3: invokestatic getModuleChatSp : ()Landroid/content/SharedPreferences;
    //   6: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   11: getstatic com/blued/android/module/chat/utils/PreferencesUtils.ONLINE_SWITCH : Ljava/lang/String;
    //   14: iload_0
    //   15: invokeinterface putBoolean : (Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
    //   20: invokeinterface commit : ()Z
    //   25: pop
    //   26: invokestatic m : ()Z
    //   29: ifeq -> 72
    //   32: getstatic com/blued/android/module/chat/utils/PreferencesUtils.TAG : Ljava/lang/String;
    //   35: astore_1
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore_2
    //   44: aload_2
    //   45: ldc '设置筛选开关：online：'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: iload_0
    //   53: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_1
    //   58: iconst_1
    //   59: anewarray java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_2
    //   65: invokevirtual toString : ()Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   74: monitorexit
    //   75: return
    //   76: astore_1
    //   77: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   3	72	76	finally
  }
  
  public static void setUpdtateFinish(boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   2: monitorenter
    //   3: invokestatic getModuleChatSp : ()Landroid/content/SharedPreferences;
    //   6: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   11: getstatic com/blued/android/module/chat/utils/PreferencesUtils.UPDTATE_FINISH : Ljava/lang/String;
    //   14: iload_0
    //   15: invokeinterface putBoolean : (Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
    //   20: invokeinterface commit : ()Z
    //   25: pop
    //   26: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   28: monitorexit
    //   29: return
    //   30: astore_1
    //   31: ldc com/blued/android/module/chat/utils/PreferencesUtils
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	26	30	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\cha\\utils\PreferencesUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */