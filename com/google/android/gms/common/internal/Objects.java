package com.google.android.gms.common.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public final class Objects {
  private Objects() {
    throw new AssertionError("Uninstantiable");
  }
  
  public static boolean checkBundlesEquality(Bundle paramBundle1, Bundle paramBundle2) {
    if (paramBundle1 == null || paramBundle2 == null)
      return (paramBundle1 == paramBundle2); 
    if (paramBundle1.size() != paramBundle2.size())
      return false; 
    Set set = paramBundle1.keySet();
    if (!set.containsAll(paramBundle2.keySet()))
      return false; 
    for (String str : set) {
      if (!equal(paramBundle1.get(str), paramBundle2.get(str)))
        return false; 
    } 
    return true;
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  public static int hashCode(Object... paramVarArgs) {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static ToStringHelper toStringHelper(Object paramObject) {
    return new ToStringHelper(paramObject, null);
  }
  
  public static final class ToStringHelper {
    private final List<String> zza;
    
    private final Object zzb;
    
    private ToStringHelper(Object param1Object) {
      this.zzb = Preconditions.checkNotNull(param1Object);
      this.zza = new ArrayList<String>();
    }
    
    public final ToStringHelper add(String param1String, Object param1Object) {
      List<String> list = this.zza;
      param1String = Preconditions.<String>checkNotNull(param1String);
      param1Object = String.valueOf(param1Object);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(param1String).length() + 1 + String.valueOf(param1Object).length());
      stringBuilder.append(param1String);
      stringBuilder.append("=");
      stringBuilder.append((String)param1Object);
      list.add(stringBuilder.toString());
      return this;
    }
    
    public final String toString() {
      StringBuilder stringBuilder = new StringBuilder(100);
      stringBuilder.append(this.zzb.getClass().getSimpleName());
      stringBuilder.append('{');
      int j = this.zza.size();
      for (int i = 0; i < j; i++) {
        stringBuilder.append(this.zza.get(i));
        if (i < j - 1)
          stringBuilder.append(", "); 
      } 
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\Objects.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */