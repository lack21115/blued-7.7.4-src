package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zab;
import java.util.LinkedList;

public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {
  private T zaa;
  
  private Bundle zab;
  
  private LinkedList<zaa> zac;
  
  private final OnDelegateCreatedListener<T> zad = new zab(this);
  
  public static void showGooglePlayUnavailableMessage(FrameLayout paramFrameLayout) {
    GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
    Context context = paramFrameLayout.getContext();
    int i = googleApiAvailability.isGooglePlayServicesAvailable(context);
    String str2 = zab.zac(context, i);
    String str1 = zab.zae(context, i);
    LinearLayout linearLayout = new LinearLayout(paramFrameLayout.getContext());
    linearLayout.setOrientation(1);
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView((View)linearLayout);
    TextView textView = new TextView(paramFrameLayout.getContext());
    textView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
    textView.setText(str2);
    linearLayout.addView((View)textView);
    Intent intent = googleApiAvailability.getErrorResolutionIntent(context, i, null);
    if (intent != null) {
      Button button = new Button(context);
      button.setId(16908313);
      button.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
      button.setText(str1);
      linearLayout.addView((View)button);
      button.setOnClickListener(new zaf(context, intent));
    } 
  }
  
  private final void zaa(int paramInt) {
    while (!this.zac.isEmpty() && ((zaa)this.zac.getLast()).zaa() >= paramInt)
      this.zac.removeLast(); 
  }
  
  private final void zaa(Bundle paramBundle, zaa paramzaa) {
    T t = this.zaa;
    if (t != null) {
      paramzaa.zaa((LifecycleDelegate)t);
      return;
    } 
    if (this.zac == null)
      this.zac = new LinkedList<zaa>(); 
    this.zac.add(paramzaa);
    if (paramBundle != null) {
      Bundle bundle = this.zab;
      if (bundle == null) {
        this.zab = (Bundle)paramBundle.clone();
      } else {
        bundle.putAll(paramBundle);
      } 
    } 
    createDelegate(this.zad);
  }
  
  protected abstract void createDelegate(OnDelegateCreatedListener<T> paramOnDelegateCreatedListener);
  
  public T getDelegate() {
    return this.zaa;
  }
  
  protected void handleGooglePlayUnavailable(FrameLayout paramFrameLayout) {
    showGooglePlayUnavailableMessage(paramFrameLayout);
  }
  
  public void onCreate(Bundle paramBundle) {
    zaa(paramBundle, new zad(this, paramBundle));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    FrameLayout frameLayout = new FrameLayout(paramLayoutInflater.getContext());
    zaa(paramBundle, new zac(this, frameLayout, paramLayoutInflater, paramViewGroup, paramBundle));
    if (this.zaa == null)
      handleGooglePlayUnavailable(frameLayout); 
    return (View)frameLayout;
  }
  
  public void onDestroy() {
    T t = this.zaa;
    if (t != null) {
      t.onDestroy();
      return;
    } 
    zaa(1);
  }
  
  public void onDestroyView() {
    T t = this.zaa;
    if (t != null) {
      t.onDestroyView();
      return;
    } 
    zaa(2);
  }
  
  public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2) {
    zaa(paramBundle2, new zaa(this, paramActivity, paramBundle1, paramBundle2));
  }
  
  public void onLowMemory() {
    T t = this.zaa;
    if (t != null)
      t.onLowMemory(); 
  }
  
  public void onPause() {
    T t = this.zaa;
    if (t != null) {
      t.onPause();
      return;
    } 
    zaa(5);
  }
  
  public void onResume() {
    zaa((Bundle)null, new zag(this));
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    T t = this.zaa;
    if (t != null) {
      t.onSaveInstanceState(paramBundle);
      return;
    } 
    Bundle bundle = this.zab;
    if (bundle != null)
      paramBundle.putAll(bundle); 
  }
  
  public void onStart() {
    zaa((Bundle)null, new zae(this));
  }
  
  public void onStop() {
    T t = this.zaa;
    if (t != null) {
      t.onStop();
      return;
    } 
    zaa(4);
  }
  
  static interface zaa {
    int zaa();
    
    void zaa(LifecycleDelegate param1LifecycleDelegate);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\dynamic\DeferredLifecycleHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */