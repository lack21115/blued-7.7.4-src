package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback<E> extends FragmentContainer {
  private final Activity a;
  
  final FragmentManagerImpl b = new FragmentManagerImpl();
  
  private final Context c;
  
  private final Handler d;
  
  private final int e;
  
  FragmentHostCallback(Activity paramActivity, Context paramContext, Handler paramHandler, int paramInt) {
    this.a = paramActivity;
    this.c = (Context)Preconditions.checkNotNull(paramContext, "context == null");
    this.d = (Handler)Preconditions.checkNotNull(paramHandler, "handler == null");
    this.e = paramInt;
  }
  
  public FragmentHostCallback(Context paramContext, Handler paramHandler, int paramInt) {
    this(activity, paramContext, paramHandler, paramInt);
  }
  
  FragmentHostCallback(FragmentActivity paramFragmentActivity) {
    this((Activity)paramFragmentActivity, (Context)paramFragmentActivity, new Handler(), 0);
  }
  
  Activity a() {
    return this.a;
  }
  
  Context b() {
    return this.c;
  }
  
  Handler c() {
    return this.d;
  }
  
  void onAttachFragment(Fragment paramFragment) {}
  
  public void onDump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public View onFindViewById(int paramInt) {
    return null;
  }
  
  public abstract E onGetHost();
  
  public LayoutInflater onGetLayoutInflater() {
    return LayoutInflater.from(this.c);
  }
  
  public int onGetWindowAnimations() {
    return this.e;
  }
  
  public boolean onHasView() {
    return true;
  }
  
  public boolean onHasWindowAnimations() {
    return true;
  }
  
  public void onRequestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt) {}
  
  public boolean onShouldSaveFragmentState(Fragment paramFragment) {
    return true;
  }
  
  public boolean onShouldShowRequestPermissionRationale(String paramString) {
    return false;
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt) {
    onStartActivityFromFragment(paramFragment, paramIntent, paramInt, null);
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle) {
    if (paramInt == -1) {
      this.c.startActivity(paramIntent);
      return;
    } 
    throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
  }
  
  public void onStartIntentSenderFromFragment(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle) throws IntentSender.SendIntentException {
    if (paramInt1 == -1) {
      ActivityCompat.startIntentSenderForResult(this.a, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    } 
    throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
  }
  
  public void onSupportInvalidateOptionsMenu() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentHostCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */