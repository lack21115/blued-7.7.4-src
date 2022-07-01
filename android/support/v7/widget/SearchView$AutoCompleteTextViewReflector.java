package android.support.v7.widget;

import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

final class SearchView$AutoCompleteTextViewReflector {
  Method doAfterTextChanged;
  
  Method doBeforeTextChanged;
  
  Method ensureImeVisible;
  
  SearchView$AutoCompleteTextViewReflector() {
    try {
      this.doBeforeTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
      this.doBeforeTextChanged.setAccessible(true);
    } catch (NoSuchMethodException noSuchMethodException) {}
    try {
      this.doAfterTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
      this.doAfterTextChanged.setAccessible(true);
    } catch (NoSuchMethodException noSuchMethodException) {}
    try {
      this.ensureImeVisible = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { boolean.class });
      this.ensureImeVisible.setAccessible(true);
      return;
    } catch (NoSuchMethodException noSuchMethodException) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\SearchView$AutoCompleteTextViewReflector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */