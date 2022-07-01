package androidx.core.os;

import java.util.Locale;

interface LocaleListInterface {
  Locale get(int paramInt);
  
  Locale getFirstMatch(String[] paramArrayOfString);
  
  Object getLocaleList();
  
  int indexOf(Locale paramLocale);
  
  boolean isEmpty();
  
  int size();
  
  String toLanguageTags();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\os\LocaleListInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */