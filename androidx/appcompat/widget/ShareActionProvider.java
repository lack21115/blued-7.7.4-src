package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ActionProvider;

public class ShareActionProvider extends ActionProvider {
  public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
  
  final Context a;
  
  String b = "share_history.xml";
  
  OnShareTargetSelectedListener c;
  
  private int d = 4;
  
  private final ShareMenuItemOnMenuItemClickListener e = new ShareMenuItemOnMenuItemClickListener(this);
  
  private ActivityChooserModel.OnChooseActivityListener f;
  
  public ShareActionProvider(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
  }
  
  private void a() {
    if (this.c == null)
      return; 
    if (this.f == null)
      this.f = new ShareActivityChooserModelPolicy(this); 
    ActivityChooserModel.get(this.a, this.b).setOnChooseActivityListener(this.f);
  }
  
  void a(Intent paramIntent) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramIntent.addFlags(134742016);
      return;
    } 
    paramIntent.addFlags(524288);
  }
  
  public boolean hasSubMenu() {
    return true;
  }
  
  public View onCreateActionView() {
    ActivityChooserView activityChooserView = new ActivityChooserView(this.a);
    if (!activityChooserView.isInEditMode())
      activityChooserView.setActivityChooserModel(ActivityChooserModel.get(this.a, this.b)); 
    TypedValue typedValue = new TypedValue();
    this.a.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
    activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.a, typedValue.resourceId));
    activityChooserView.setProvider(this);
    activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
    activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
    return (View)activityChooserView;
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu) {
    paramSubMenu.clear();
    ActivityChooserModel activityChooserModel = ActivityChooserModel.get(this.a, this.b);
    PackageManager packageManager = this.a.getPackageManager();
    int j = activityChooserModel.getActivityCount();
    int k = Math.min(j, this.d);
    int i;
    for (i = 0; i < k; i++) {
      ResolveInfo resolveInfo = activityChooserModel.getActivity(i);
      paramSubMenu.add(0, i, i, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setOnMenuItemClickListener(this.e);
    } 
    if (k < j) {
      paramSubMenu = paramSubMenu.addSubMenu(0, k, k, this.a.getString(R.string.abc_activity_chooser_view_see_all));
      for (i = 0; i < j; i++) {
        ResolveInfo resolveInfo = activityChooserModel.getActivity(i);
        paramSubMenu.add(0, i, i, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setOnMenuItemClickListener(this.e);
      } 
    } 
  }
  
  public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener paramOnShareTargetSelectedListener) {
    this.c = paramOnShareTargetSelectedListener;
    a();
  }
  
  public void setShareHistoryFileName(String paramString) {
    this.b = paramString;
    a();
  }
  
  public void setShareIntent(Intent paramIntent) {
    if (paramIntent != null) {
      String str = paramIntent.getAction();
      if ("android.intent.action.SEND".equals(str) || "android.intent.action.SEND_MULTIPLE".equals(str))
        a(paramIntent); 
    } 
    ActivityChooserModel.get(this.a, this.b).setIntent(paramIntent);
  }
  
  public static interface OnShareTargetSelectedListener {
    boolean onShareTargetSelected(ShareActionProvider param1ShareActionProvider, Intent param1Intent);
  }
  
  class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
    ShareActivityChooserModelPolicy(ShareActionProvider this$0) {}
    
    public boolean onChooseActivity(ActivityChooserModel param1ActivityChooserModel, Intent param1Intent) {
      if (this.a.c != null)
        this.a.c.onShareTargetSelected(this.a, param1Intent); 
      return false;
    }
  }
  
  class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
    ShareMenuItemOnMenuItemClickListener(ShareActionProvider this$0) {}
    
    public boolean onMenuItemClick(MenuItem param1MenuItem) {
      Intent intent = ActivityChooserModel.get(this.a.a, this.a.b).chooseActivity(param1MenuItem.getItemId());
      if (intent != null) {
        String str = intent.getAction();
        if ("android.intent.action.SEND".equals(str) || "android.intent.action.SEND_MULTIPLE".equals(str))
          this.a.a(intent); 
        this.a.a.startActivity(intent);
      } 
      return true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\ShareActionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */