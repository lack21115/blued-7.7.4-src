package com.j256.ormlite.android.apptools;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;

public abstract class OrmLiteBaseActivity<H extends OrmLiteSqliteOpenHelper> extends Activity {
  private static Logger logger = LoggerFactory.getLogger(OrmLiteBaseActivity.class);
  
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
    OrmLiteSqliteOpenHelper ormLiteSqliteOpenHelper = OpenHelperManager.getHelper(paramContext);
    logger.trace("{}: got new helper {} from OpenHelperManager", this, ormLiteSqliteOpenHelper);
    return (H)ormLiteSqliteOpenHelper;
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
    logger.trace("{}: helper {} was released, set to null", this, paramH);
    this.helper = null;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append("@");
    stringBuilder.append(Integer.toHexString(hashCode()));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\android\apptools\OrmLiteBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */