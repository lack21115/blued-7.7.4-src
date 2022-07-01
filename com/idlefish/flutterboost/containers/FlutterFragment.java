package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XPlatformPlugin;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.android.SplashScreenProvider;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import java.util.HashMap;
import java.util.Map;

public class FlutterFragment extends Fragment implements FlutterActivityAndFragmentDelegate.Host {
  private FlutterActivityAndFragmentDelegate a;
  
  public FlutterFragment() {
    setArguments(new Bundle());
  }
  
  public XPlatformPlugin a(FlutterEngine paramFlutterEngine) {
    return BoostViewUtils.a(paramFlutterEngine.getPlatformChannel());
  }
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine) {
    FragmentActivity fragmentActivity = getActivity();
    if (fragmentActivity instanceof FlutterEngineConfigurator)
      ((FlutterEngineConfigurator)fragmentActivity).configureFlutterEngine(paramFlutterEngine); 
  }
  
  public FlutterView.TransparencyMode g() {
    return FlutterView.TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", FlutterView.TransparencyMode.transparent.name()));
  }
  
  public String i() {
    return getArguments().getString("url");
  }
  
  public Map j() {
    return ((BoostFlutterActivity.SerializableMap)getArguments().getSerializable("params")).a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    this.a.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    this.a = new FlutterActivityAndFragmentDelegate(this);
    this.a.a(paramContext);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    return this.a.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView() {
    super.onDestroyView();
    this.a.g();
  }
  
  public void onDetach() {
    super.onDetach();
    this.a.h();
    this.a.a();
    this.a = null;
  }
  
  public void onHiddenChanged(boolean paramBoolean) {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean) {
      this.a.e();
      return;
    } 
    this.a.c();
  }
  
  public void onLowMemory() {
    super.onLowMemory();
    this.a.k();
  }
  
  public void onPause() {
    super.onPause();
    if (!isHidden())
      this.a.e(); 
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    this.a.a(paramInt, paramArrayOfString, paramArrayOfint);
  }
  
  public void onResume() {
    super.onResume();
    if (!isHidden())
      this.a.c(); 
  }
  
  public void onStart() {
    super.onStart();
    if (!isHidden())
      this.a.b(); 
  }
  
  public void onStop() {
    super.onStop();
    if (!isHidden())
      this.a.f(); 
  }
  
  public FlutterEngine provideFlutterEngine(Context paramContext) {
    return FlutterBoost.a().g();
  }
  
  public SplashScreen provideSplashScreen() {
    FragmentActivity fragmentActivity = getActivity();
    return (fragmentActivity instanceof SplashScreenProvider) ? ((SplashScreenProvider)fragmentActivity).provideSplashScreen() : null;
  }
  
  static @interface ActivityCallThrough {}
  
  public static class NewEngineFragmentBuilder {
    private final Class<? extends FlutterFragment> a = FlutterFragment.class;
    
    private FlutterShellArgs b = null;
    
    private FlutterView.RenderMode c = FlutterView.RenderMode.surface;
    
    private FlutterView.TransparencyMode d = FlutterView.TransparencyMode.transparent;
    
    private boolean e = true;
    
    private String f = "";
    
    private Map g = new HashMap<Object, Object>();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\containers\FlutterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */