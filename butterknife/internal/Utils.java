package butterknife.internal;

import android.util.TypedValue;
import android.view.View;

public final class Utils {
  private static final TypedValue a = new TypedValue();
  
  private Utils() {
    throw new AssertionError("No instances.");
  }
  
  public static View a(View paramView, int paramInt, String paramString) {
    View view = paramView.findViewById(paramInt);
    if (view != null)
      return view; 
    String str = a(paramView, paramInt);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Required view '");
    stringBuilder.append(str);
    stringBuilder.append("' with ID ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" for ");
    stringBuilder.append(paramString);
    stringBuilder.append(" was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public static <T> T a(View paramView, int paramInt, String paramString, Class<T> paramClass) {
    return b(a(paramView, paramInt, paramString), paramInt, paramString, paramClass);
  }
  
  private static String a(View paramView, int paramInt) {
    return paramView.isInEditMode() ? "<unavailable while editing>" : paramView.getContext().getResources().getResourceEntryName(paramInt);
  }
  
  public static <T> T b(View paramView, int paramInt, String paramString, Class<T> paramClass) {
    try {
      return paramClass.cast(paramView);
    } catch (ClassCastException classCastException) {
      String str = a(paramView, paramInt);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("View '");
      stringBuilder.append(str);
      stringBuilder.append("' with ID ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" for ");
      stringBuilder.append(paramString);
      stringBuilder.append(" was of the wrong type. See cause for more info.");
      throw new IllegalStateException(stringBuilder.toString(), classCastException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\butterknife\internal\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */