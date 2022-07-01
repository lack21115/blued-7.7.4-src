package androidx.core.content.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShortcutManagerCompat {
  public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
  
  private static volatile ShortcutInfoCompatSaver<?> a;
  
  private static ShortcutInfoCompatSaver<?> a(Context paramContext) {
    if (a == null) {
      if (Build.VERSION.SDK_INT >= 23)
        try {
          a = (ShortcutInfoCompatSaver)Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
        } catch (Exception exception) {} 
      if (a == null)
        a = new ShortcutInfoCompatSaver.NoopImpl(); 
    } 
    return a;
  }
  
  public static boolean addDynamicShortcuts(Context paramContext, List<ShortcutInfoCompat> paramList) {
    if (Build.VERSION.SDK_INT >= 25) {
      ArrayList<ShortcutInfo> arrayList = new ArrayList();
      Iterator<ShortcutInfoCompat> iterator = paramList.iterator();
      while (iterator.hasNext())
        arrayList.add(((ShortcutInfoCompat)iterator.next()).toShortcutInfo()); 
      if (!((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).addDynamicShortcuts(arrayList))
        return false; 
    } 
    a(paramContext).addShortcuts(paramList);
    return true;
  }
  
  public static Intent createShortcutResultIntent(Context paramContext, ShortcutInfoCompat paramShortcutInfoCompat) {
    Intent intent;
    if (Build.VERSION.SDK_INT >= 26) {
      Intent intent1 = ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).createShortcutResultIntent(paramShortcutInfoCompat.toShortcutInfo());
    } else {
      paramContext = null;
    } 
    Context context = paramContext;
    if (paramContext == null)
      intent = new Intent(); 
    return paramShortcutInfoCompat.a(intent);
  }
  
  public static List<ShortcutInfoCompat> getDynamicShortcuts(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 25) {
      List list = ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
      ArrayList<ShortcutInfoCompat> arrayList = new ArrayList(list.size());
      Iterator<ShortcutInfo> iterator = list.iterator();
      while (iterator.hasNext())
        arrayList.add((new ShortcutInfoCompat.Builder(paramContext, iterator.next())).build()); 
      return arrayList;
    } 
    try {
      return a(paramContext).getShortcuts();
    } catch (Exception exception) {
      return new ArrayList<ShortcutInfoCompat>();
    } 
  }
  
  public static int getMaxShortcutCountPerActivity(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 25) ? ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity() : 0;
  }
  
  public static boolean isRequestPinShortcutSupported(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 26)
      return ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported(); 
    if (ContextCompat.checkSelfPermission(paramContext, "com.android.launcher.permission.INSTALL_SHORTCUT") != 0)
      return false; 
    Iterator iterator = paramContext.getPackageManager().queryBroadcastReceivers(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"), 0).iterator();
    while (iterator.hasNext()) {
      String str = ((ResolveInfo)iterator.next()).activityInfo.permission;
      if (TextUtils.isEmpty(str) || "com.android.launcher.permission.INSTALL_SHORTCUT".equals(str))
        return true; 
    } 
    return false;
  }
  
  public static void removeAllDynamicShortcuts(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 25)
      ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts(); 
    a(paramContext).removeAllShortcuts();
  }
  
  public static void removeDynamicShortcuts(Context paramContext, List<String> paramList) {
    if (Build.VERSION.SDK_INT >= 25)
      ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(paramList); 
    a(paramContext).removeShortcuts(paramList);
  }
  
  public static boolean requestPinShortcut(Context paramContext, ShortcutInfoCompat paramShortcutInfoCompat, IntentSender paramIntentSender) {
    if (Build.VERSION.SDK_INT >= 26)
      return ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).requestPinShortcut(paramShortcutInfoCompat.toShortcutInfo(), paramIntentSender); 
    if (!isRequestPinShortcutSupported(paramContext))
      return false; 
    Intent intent = paramShortcutInfoCompat.a(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"));
    if (paramIntentSender == null) {
      paramContext.sendBroadcast(intent);
      return true;
    } 
    paramContext.sendOrderedBroadcast(intent, null, new BroadcastReceiver(paramIntentSender) {
          public void onReceive(Context param1Context, Intent param1Intent) {
            try {
              this.a.sendIntent(param1Context, 0, null, null, null);
              return;
            } catch (android.content.IntentSender.SendIntentException sendIntentException) {
              return;
            } 
          }
        }null, -1, null, null);
    return true;
  }
  
  public static boolean updateShortcuts(Context paramContext, List<ShortcutInfoCompat> paramList) {
    if (Build.VERSION.SDK_INT >= 25) {
      ArrayList<ShortcutInfo> arrayList = new ArrayList();
      Iterator<ShortcutInfoCompat> iterator = paramList.iterator();
      while (iterator.hasNext())
        arrayList.add(((ShortcutInfoCompat)iterator.next()).toShortcutInfo()); 
      if (!((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).updateShortcuts(arrayList))
        return false; 
    } 
    a(paramContext).addShortcuts(paramList);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\content\pm\ShortcutManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */