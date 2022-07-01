package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;

public final class ActionBarPolicy {
  public Context mContext;
  
  private ActionBarPolicy(Context paramContext) {
    this.mContext = paramContext;
  }
  
  public static ActionBarPolicy get(Context paramContext) {
    return new ActionBarPolicy(paramContext);
  }
  
  public final int getMaxActionButtons() {
    Configuration configuration = this.mContext.getResources().getConfiguration();
    int i = configuration.screenWidthDp;
    int j = configuration.screenHeightDp;
    return (configuration.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && j > 720) || (i > 720 && j > 960)) ? 5 : ((i >= 500 || (i > 640 && j > 480) || (i > 480 && j > 640)) ? 4 : ((i >= 360) ? 3 : 2));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\ActionBarPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */