package org.chromium.policy;

import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.json.JSONException;

public class CombinedPolicyProvider {
  private static CombinedPolicyProvider sInstance;
  
  public final List mCachedPolicies = new ArrayList();
  
  public long mNativeCombinedPolicyProvider;
  
  private PolicyConverter mPolicyConverter;
  
  public final List mPolicyProviders = new ArrayList();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  CombinedPolicyProvider() {
    new ArrayList();
  }
  
  public static CombinedPolicyProvider get() {
    if (sInstance == null)
      sInstance = new CombinedPolicyProvider(); 
    return sInstance;
  }
  
  @CalledByNative
  public static CombinedPolicyProvider linkNative(long paramLong, PolicyConverter paramPolicyConverter) {
    ThreadUtils.assertOnUiThread();
    CombinedPolicyProvider combinedPolicyProvider = get();
    combinedPolicyProvider.mNativeCombinedPolicyProvider = paramLong;
    combinedPolicyProvider.mPolicyConverter = paramPolicyConverter;
    if (paramLong != 0L) {
      Iterator<PolicyProvider> iterator = combinedPolicyProvider.mPolicyProviders.iterator();
      while (iterator.hasNext())
        ((PolicyProvider)iterator.next()).refresh(); 
    } 
    return get();
  }
  
  protected native void nativeFlushPolicies(long paramLong);
  
  final void onSettingsAvailable(int paramInt, Bundle paramBundle) {
    this.mCachedPolicies.set(paramInt, paramBundle);
    Iterator<Bundle> iterator1 = this.mCachedPolicies.iterator();
    while (iterator1.hasNext()) {
      if ((Bundle)iterator1.next() == null)
        return; 
    } 
    if (this.mNativeCombinedPolicyProvider == 0L)
      return; 
    Iterator<Bundle> iterator2 = this.mCachedPolicies.iterator();
    while (iterator2.hasNext()) {
      Bundle bundle = iterator2.next();
      for (String str : bundle.keySet()) {
        PolicyConverter policyConverter = this.mPolicyConverter;
        Object object = bundle.get(str);
        if (PolicyConverter.$assertionsDisabled || policyConverter.mNativePolicyConverter != 0L) {
          if (object instanceof Boolean) {
            policyConverter.nativeSetPolicyBoolean(policyConverter.mNativePolicyConverter, str, ((Boolean)object).booleanValue());
            continue;
          } 
          if (object instanceof String) {
            policyConverter.nativeSetPolicyString(policyConverter.mNativePolicyConverter, str, (String)object);
            continue;
          } 
          if (object instanceof Integer) {
            policyConverter.nativeSetPolicyInteger(policyConverter.mNativePolicyConverter, str, ((Integer)object).intValue());
            continue;
          } 
          if (object instanceof String[]) {
            policyConverter.nativeSetPolicyStringArray(policyConverter.mNativePolicyConverter, str, (String[])object);
            continue;
          } 
          if (Build.VERSION.SDK_INT >= 21) {
            StringBuilder stringBuilder1;
            if (object instanceof Bundle) {
              object = object;
              try {
                policyConverter.nativeSetPolicyString(policyConverter.mNativePolicyConverter, str, policyConverter.convertBundleToJson((Bundle)object).toString());
              } catch (JSONException jSONException) {
                stringBuilder1 = new StringBuilder("Invalid bundle in app restrictions ");
                stringBuilder1.append(object.toString());
                stringBuilder1.append(" for key ");
                stringBuilder1.append(str);
                Log.w("PolicyConverter", stringBuilder1.toString(), new Object[0]);
              } 
              continue;
            } 
            if (object instanceof Bundle[]) {
              object = object;
              try {
                stringBuilder1.nativeSetPolicyString(((PolicyConverter)stringBuilder1).mNativePolicyConverter, str, stringBuilder1.convertBundleArrayToJson((Bundle[])object).toString());
              } catch (JSONException jSONException) {
                StringBuilder stringBuilder2 = new StringBuilder("Invalid bundle array in app restrictions ");
                stringBuilder2.append(Arrays.toString((Object[])object));
                stringBuilder2.append(" for key ");
                stringBuilder2.append(str);
                Log.w("PolicyConverter", stringBuilder2.toString(), new Object[0]);
              } 
              continue;
            } 
          } 
          if (PolicyConverter.$assertionsDisabled)
            continue; 
          StringBuilder stringBuilder = new StringBuilder("Invalid setting ");
          stringBuilder.append(object);
          stringBuilder.append(" for key ");
          stringBuilder.append(str);
          throw new AssertionError(stringBuilder.toString());
        } 
        throw new AssertionError();
      } 
    } 
    nativeFlushPolicies(this.mNativeCombinedPolicyProvider);
  }
  
  @CalledByNative
  void refreshPolicies() {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\policy\CombinedPolicyProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */