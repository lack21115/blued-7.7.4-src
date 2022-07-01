package org.chromium.content.browser.selection;

import android.content.Context;
import android.view.ActionMode;
import java.lang.reflect.Field;

public final class LGEmailActionModeWorkaroundImpl {
  private static Object getField(Object paramObject, String paramString) {
    Field field = paramObject.getClass().getDeclaredField(paramString);
    field.setAccessible(true);
    return field.get(paramObject);
  }
  
  public static void runIfNecessary(Context paramContext, ActionMode paramActionMode) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getPackageName : ()Ljava/lang/String;
    //   4: astore #4
    //   6: aload_0
    //   7: aload #4
    //   9: invokestatic getPackageVersion : (Landroid/content/Context;Ljava/lang/String;)I
    //   12: istore_2
    //   13: iload_2
    //   14: iconst_m1
    //   15: if_icmpne -> 23
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -> 105
    //   23: aload_0
    //   24: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   27: getfield targetSdkVersion : I
    //   30: istore_3
    //   31: iload_3
    //   32: bipush #23
    //   34: if_icmplt -> 102
    //   37: iload_3
    //   38: bipush #24
    //   40: if_icmple -> 46
    //   43: goto -> 102
    //   46: ldc 'com.lge.email'
    //   48: aload #4
    //   50: invokevirtual equals : (Ljava/lang/Object;)Z
    //   53: ifne -> 59
    //   56: goto -> 18
    //   59: iload_2
    //   60: ldc 67502100
    //   62: if_icmple -> 68
    //   65: goto -> 18
    //   68: new java/lang/StringBuilder
    //   71: dup
    //   72: ldc 'Working around action mode LG Email bug in WebView (http://crbug.com/651706). APK name: com.lge.email, versionCode: '
    //   74: invokespecial <init> : (Ljava/lang/String;)V
    //   77: astore_0
    //   78: aload_0
    //   79: iload_2
    //   80: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: ldc 'cr_Ime'
    //   86: aload_0
    //   87: invokevirtual toString : ()Ljava/lang/String;
    //   90: iconst_0
    //   91: anewarray java/lang/Object
    //   94: invokestatic w : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: iconst_1
    //   98: istore_2
    //   99: goto -> 105
    //   102: goto -> 18
    //   105: iload_2
    //   106: ifeq -> 268
    //   109: aload_1
    //   110: ldc 'mCallback'
    //   112: new org/chromium/content/browser/selection/LGEmailActionModeWorkaroundImpl$1
    //   115: dup
    //   116: aload_1
    //   117: ldc 'mCallback'
    //   119: invokestatic getField : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   122: checkcast android/view/ActionMode$Callback2
    //   125: invokespecial <init> : (Landroid/view/ActionMode$Callback2;)V
    //   128: invokestatic setField : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
    //   131: aload_1
    //   132: ldc 'mFloatingToolbar'
    //   134: invokestatic getField : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   137: astore #5
    //   139: aload #5
    //   141: ldc 'mPopup'
    //   143: invokestatic getField : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   146: astore_0
    //   147: aload_0
    //   148: ldc 'mContentContainer'
    //   150: invokestatic getField : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   153: checkcast android/view/ViewGroup
    //   156: astore_1
    //   157: aload_0
    //   158: ldc 'mPopupWindow'
    //   160: invokestatic getField : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   163: checkcast android/widget/PopupWindow
    //   166: astore #4
    //   168: aload #5
    //   170: invokevirtual getClass : ()Ljava/lang/Class;
    //   173: ldc 'createExitAnimation'
    //   175: iconst_3
    //   176: anewarray java/lang/Class
    //   179: dup
    //   180: iconst_0
    //   181: ldc android/view/View
    //   183: aastore
    //   184: dup
    //   185: iconst_1
    //   186: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   189: aastore
    //   190: dup
    //   191: iconst_2
    //   192: ldc android/animation/Animator$AnimatorListener
    //   194: aastore
    //   195: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   198: astore #5
    //   200: aload #5
    //   202: iconst_1
    //   203: invokevirtual setAccessible : (Z)V
    //   206: aload_0
    //   207: ldc 'mDismissAnimation'
    //   209: aload #5
    //   211: aconst_null
    //   212: iconst_3
    //   213: anewarray java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: aload_1
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: sipush #150
    //   225: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   228: aastore
    //   229: dup
    //   230: iconst_2
    //   231: new org/chromium/content/browser/selection/LGEmailActionModeWorkaroundImpl$2
    //   234: dup
    //   235: aload #4
    //   237: aload_1
    //   238: invokespecial <init> : (Landroid/widget/PopupWindow;Landroid/view/ViewGroup;)V
    //   241: aastore
    //   242: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   245: invokestatic setField : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
    //   248: return
    //   249: astore_0
    //   250: ldc 'cr_Ime'
    //   252: ldc 'Error occurred during LGEmailActionModeWorkaround: '
    //   254: iconst_1
    //   255: anewarray java/lang/Object
    //   258: dup
    //   259: iconst_0
    //   260: aload_0
    //   261: aastore
    //   262: invokestatic w : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: return
    //   266: astore_0
    //   267: return
    //   268: return
    // Exception table:
    //   from	to	target	type
    //   109	248	266	java/lang/NoSuchFieldException
    //   109	248	266	java/lang/IllegalAccessException
    //   109	248	266	java/lang/IllegalArgumentException
    //   109	248	266	java/lang/NoSuchMethodException
    //   109	248	266	java/lang/reflect/InvocationTargetException
    //   109	248	249	java/lang/Exception
  }
  
  private static void setField(Object paramObject1, String paramString, Object paramObject2) {
    Field field = paramObject1.getClass().getDeclaredField(paramString);
    field.setAccessible(true);
    field.set(paramObject1, paramObject2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\LGEmailActionModeWorkaroundImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */