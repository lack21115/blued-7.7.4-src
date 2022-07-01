package androidx.core.util;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;

public class ObjectsCompat {
  public static boolean equals(Object paramObject1, Object paramObject2) {
    return (Build.VERSION.SDK_INT >= 19) ? Objects.equals(paramObject1, paramObject2) : ((paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2))));
  }
  
  public static int hash(Object... paramVarArgs) {
    return (Build.VERSION.SDK_INT >= 19) ? Objects.hash(paramVarArgs) : Arrays.hashCode(paramVarArgs);
  }
  
  public static int hashCode(Object paramObject) {
    return (paramObject != null) ? paramObject.hashCode() : 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\cor\\util\ObjectsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */