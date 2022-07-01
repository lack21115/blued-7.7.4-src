package com.j256.ormlite.android.apptools;

import android.app.ActivityGroup;
import android.content.Context;
import android.os.Bundle;
import com.j256.ormlite.support.ConnectionSource;

public abstract class OrmLiteBaseActivityGroup<H extends OrmLiteSqliteOpenHelper> extends ActivityGroup {
  private volatile boolean created = false;
  
  private volatile boolean destroyed = false;
  
  private volatile H helper;
  
  public ConnectionSource getConnectionSource() {
    return getHelper().getConnectionSource();
  }
  
  public H getHelper() {
    if (this.helper == null) {
      if (this.created) {
        if (this.destroyed)
          throw new IllegalStateException("A call to onDestroy has already been made and the helper cannot be used after that point"); 
        throw new IllegalStateException("Helper is null for some unknown reason");
      } 
      throw new IllegalStateException("A call has not been made to onCreate() yet so the helper is null");
    } 
    return this.helper;
  }
  
  protected H getHelperInternal(Context paramContext) {
    return (H)OpenHelperManager.getHelper(paramContext);
  }
  
  protected void onCreate(Bundle paramBundle) {
    if (this.helper == null) {
      this.helper = getHelperInternal((Context)this);
      this.created = true;
    } 
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    releaseHelper(this.helper);
    this.destroyed = true;
  }
  
  protected void releaseHelper(H paramH) {
    OpenHelperManager.releaseHelper();
    this.helper = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\android\apptools\OrmLiteBaseActivityGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */