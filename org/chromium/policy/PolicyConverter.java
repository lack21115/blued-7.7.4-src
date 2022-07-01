package org.chromium.policy;

import android.annotation.TargetApi;
import android.os.Bundle;
import org.chromium.base.annotations.CalledByNative;
import org.json.JSONArray;
import org.json.JSONObject;

public class PolicyConverter {
  long mNativePolicyConverter;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private PolicyConverter(long paramLong) {
    this.mNativePolicyConverter = paramLong;
  }
  
  @CalledByNative
  static PolicyConverter create(long paramLong) {
    return new PolicyConverter(paramLong);
  }
  
  @CalledByNative
  private void onNativeDestroyed() {
    this.mNativePolicyConverter = 0L;
  }
  
  @TargetApi(21)
  final JSONArray convertBundleArrayToJson(Bundle[] paramArrayOfBundle) {
    JSONArray jSONArray = new JSONArray();
    int j = paramArrayOfBundle.length;
    for (int i = 0; i < j; i++)
      jSONArray.put(convertBundleToJson(paramArrayOfBundle[i])); 
    return jSONArray;
  }
  
  @TargetApi(21)
  final JSONObject convertBundleToJson(Bundle paramBundle) {
    JSONObject jSONObject = new JSONObject();
    for (String str : paramBundle.keySet()) {
      Object object2 = paramBundle.get(str);
      Object object1 = object2;
      if (object2 instanceof Bundle)
        object1 = convertBundleToJson((Bundle)object2); 
      object2 = object1;
      if (object1 instanceof Bundle[])
        object2 = convertBundleArrayToJson((Bundle[])object1); 
      jSONObject.put(str, JSONObject.wrap(object2));
    } 
    return jSONObject;
  }
  
  native void nativeSetPolicyBoolean(long paramLong, String paramString, boolean paramBoolean);
  
  native void nativeSetPolicyInteger(long paramLong, String paramString, int paramInt);
  
  native void nativeSetPolicyString(long paramLong, String paramString1, String paramString2);
  
  native void nativeSetPolicyStringArray(long paramLong, String paramString, String[] paramArrayOfString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\policy\PolicyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */