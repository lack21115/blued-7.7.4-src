package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class RequestManagerFragment extends Fragment {
  private final ActivityFragmentLifecycle a;
  
  private final RequestManagerTreeNode b = new FragmentRequestManagerTreeNode(this);
  
  private final Set<RequestManagerFragment> c = new HashSet<RequestManagerFragment>();
  
  private RequestManager d;
  
  private RequestManagerFragment e;
  
  private Fragment f;
  
  public RequestManagerFragment() {
    this(new ActivityFragmentLifecycle());
  }
  
  RequestManagerFragment(ActivityFragmentLifecycle paramActivityFragmentLifecycle) {
    this.a = paramActivityFragmentLifecycle;
  }
  
  private void a(Activity paramActivity) {
    f();
    this.e = Glide.a((Context)paramActivity).h().b(paramActivity);
    if (!equals(this.e))
      this.e.a(this); 
  }
  
  private void a(RequestManagerFragment paramRequestManagerFragment) {
    this.c.add(paramRequestManagerFragment);
  }
  
  private void b(RequestManagerFragment paramRequestManagerFragment) {
    this.c.remove(paramRequestManagerFragment);
  }
  
  private boolean b(Fragment paramFragment) {
    Fragment fragment = getParentFragment();
    while (true) {
      Fragment fragment1 = paramFragment.getParentFragment();
      if (fragment1 != null) {
        if (fragment1.equals(fragment))
          return true; 
        paramFragment = paramFragment.getParentFragment();
        continue;
      } 
      return false;
    } 
  }
  
  private Fragment e() {
    Fragment fragment;
    if (Build.VERSION.SDK_INT >= 17) {
      fragment = getParentFragment();
    } else {
      fragment = null;
    } 
    return (fragment != null) ? fragment : this.f;
  }
  
  private void f() {
    RequestManagerFragment requestManagerFragment = this.e;
    if (requestManagerFragment != null) {
      requestManagerFragment.b(this);
      this.e = null;
    } 
  }
  
  ActivityFragmentLifecycle a() {
    return this.a;
  }
  
  void a(Fragment paramFragment) {
    this.f = paramFragment;
    if (paramFragment != null && paramFragment.getActivity() != null)
      a(paramFragment.getActivity()); 
  }
  
  public void a(RequestManager paramRequestManager) {
    this.d = paramRequestManager;
  }
  
  public RequestManager b() {
    return this.d;
  }
  
  public RequestManagerTreeNode c() {
    return this.b;
  }
  
  Set<RequestManagerFragment> d() {
    if (equals(this.e))
      return Collections.unmodifiableSet(this.c); 
    if (this.e == null || Build.VERSION.SDK_INT < 17)
      return Collections.emptySet(); 
    HashSet<RequestManagerFragment> hashSet = new HashSet();
    for (RequestManagerFragment requestManagerFragment : this.e.d()) {
      if (b(requestManagerFragment.getParentFragment()))
        hashSet.add(requestManagerFragment); 
    } 
    return Collections.unmodifiableSet(hashSet);
  }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    try {
      a(paramActivity);
      return;
    } catch (IllegalStateException illegalStateException) {
      if (Log.isLoggable("RMFragment", 5))
        Log.w("RMFragment", "Unable to register fragment with root", illegalStateException); 
      return;
    } 
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.a.c();
    f();
  }
  
  public void onDetach() {
    super.onDetach();
    f();
  }
  
  public void onStart() {
    super.onStart();
    this.a.a();
  }
  
  public void onStop() {
    super.onStop();
    this.a.b();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("{parent=");
    stringBuilder.append(e());
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
    FragmentRequestManagerTreeNode(RequestManagerFragment this$0) {}
    
    public Set<RequestManager> a() {
      Set<RequestManagerFragment> set = this.a.d();
      HashSet<RequestManager> hashSet = new HashSet(set.size());
      for (RequestManagerFragment requestManagerFragment : set) {
        if (requestManagerFragment.b() != null)
          hashSet.add(requestManagerFragment.b()); 
      } 
      return hashSet;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(super.toString());
      stringBuilder.append("{fragment=");
      stringBuilder.append(this.a);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\manager\RequestManagerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */