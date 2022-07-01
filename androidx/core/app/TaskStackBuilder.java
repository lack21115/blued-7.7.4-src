package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

public final class TaskStackBuilder implements Iterable<Intent> {
  private final ArrayList<Intent> a = new ArrayList<Intent>();
  
  private final Context b;
  
  private TaskStackBuilder(Context paramContext) {
    this.b = paramContext;
  }
  
  public static TaskStackBuilder create(Context paramContext) {
    return new TaskStackBuilder(paramContext);
  }
  
  @Deprecated
  public static TaskStackBuilder from(Context paramContext) {
    return create(paramContext);
  }
  
  public TaskStackBuilder addNextIntent(Intent paramIntent) {
    this.a.add(paramIntent);
    return this;
  }
  
  public TaskStackBuilder addNextIntentWithParentStack(Intent paramIntent) {
    ComponentName componentName2 = paramIntent.getComponent();
    ComponentName componentName1 = componentName2;
    if (componentName2 == null)
      componentName1 = paramIntent.resolveActivity(this.b.getPackageManager()); 
    if (componentName1 != null)
      addParentStack(componentName1); 
    addNextIntent(paramIntent);
    return this;
  }
  
  public TaskStackBuilder addParentStack(Activity paramActivity) {
    Intent intent1;
    if (paramActivity instanceof SupportParentable) {
      intent1 = ((SupportParentable)paramActivity).getSupportParentActivityIntent();
    } else {
      intent1 = null;
    } 
    Intent intent2 = intent1;
    if (intent1 == null)
      intent2 = NavUtils.getParentActivityIntent(paramActivity); 
    if (intent2 != null) {
      ComponentName componentName2 = intent2.getComponent();
      ComponentName componentName1 = componentName2;
      if (componentName2 == null)
        componentName1 = intent2.resolveActivity(this.b.getPackageManager()); 
      addParentStack(componentName1);
      addNextIntent(intent2);
    } 
    return this;
  }
  
  public TaskStackBuilder addParentStack(ComponentName paramComponentName) {
    int i = this.a.size();
    try {
      for (Intent intent = NavUtils.getParentActivityIntent(this.b, paramComponentName); intent != null; intent = NavUtils.getParentActivityIntent(this.b, intent.getComponent()))
        this.a.add(i, intent); 
      return this;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
      throw new IllegalArgumentException(nameNotFoundException);
    } 
  }
  
  public TaskStackBuilder addParentStack(Class<?> paramClass) {
    return addParentStack(new ComponentName(this.b, paramClass));
  }
  
  public Intent editIntentAt(int paramInt) {
    return this.a.get(paramInt);
  }
  
  @Deprecated
  public Intent getIntent(int paramInt) {
    return editIntentAt(paramInt);
  }
  
  public int getIntentCount() {
    return this.a.size();
  }
  
  public Intent[] getIntents() {
    Intent[] arrayOfIntent = new Intent[this.a.size()];
    if (arrayOfIntent.length == 0)
      return arrayOfIntent; 
    arrayOfIntent[0] = (new Intent(this.a.get(0))).addFlags(268484608);
    for (int i = 1; i < arrayOfIntent.length; i++)
      arrayOfIntent[i] = new Intent(this.a.get(i)); 
    return arrayOfIntent;
  }
  
  public PendingIntent getPendingIntent(int paramInt1, int paramInt2) {
    return getPendingIntent(paramInt1, paramInt2, null);
  }
  
  public PendingIntent getPendingIntent(int paramInt1, int paramInt2, Bundle paramBundle) {
    if (!this.a.isEmpty()) {
      ArrayList<Intent> arrayList = this.a;
      Intent[] arrayOfIntent = arrayList.<Intent>toArray(new Intent[arrayList.size()]);
      arrayOfIntent[0] = (new Intent(arrayOfIntent[0])).addFlags(268484608);
      return (Build.VERSION.SDK_INT >= 16) ? PendingIntent.getActivities(this.b, paramInt1, arrayOfIntent, paramInt2, paramBundle) : PendingIntent.getActivities(this.b, paramInt1, arrayOfIntent, paramInt2);
    } 
    throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
  }
  
  @Deprecated
  public Iterator<Intent> iterator() {
    return this.a.iterator();
  }
  
  public void startActivities() {
    startActivities(null);
  }
  
  public void startActivities(Bundle paramBundle) {
    if (!this.a.isEmpty()) {
      ArrayList<Intent> arrayList = this.a;
      Intent[] arrayOfIntent = arrayList.<Intent>toArray(new Intent[arrayList.size()]);
      arrayOfIntent[0] = (new Intent(arrayOfIntent[0])).addFlags(268484608);
      if (!ContextCompat.startActivities(this.b, arrayOfIntent, paramBundle)) {
        Intent intent = new Intent(arrayOfIntent[arrayOfIntent.length - 1]);
        intent.addFlags(268435456);
        this.b.startActivity(intent);
      } 
      return;
    } 
    throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
  }
  
  public static interface SupportParentable {
    Intent getSupportParentActivityIntent();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\app\TaskStackBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */