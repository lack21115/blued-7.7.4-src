package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

final class LocaleListPlatformWrapper implements LocaleListInterface {
  private final LocaleList a;
  
  LocaleListPlatformWrapper(LocaleList paramLocaleList) {
    this.a = paramLocaleList;
  }
  
  public boolean equals(Object paramObject) {
    return this.a.equals(((LocaleListInterface)paramObject).getLocaleList());
  }
  
  public Locale get(int paramInt) {
    return this.a.get(paramInt);
  }
  
  public Locale getFirstMatch(String[] paramArrayOfString) {
    return this.a.getFirstMatch(paramArrayOfString);
  }
  
  public Object getLocaleList() {
    return this.a;
  }
  
  public int hashCode() {
    return this.a.hashCode();
  }
  
  public int indexOf(Locale paramLocale) {
    return this.a.indexOf(paramLocale);
  }
  
  public boolean isEmpty() {
    return this.a.isEmpty();
  }
  
  public int size() {
    return this.a.size();
  }
  
  public String toLanguageTags() {
    return this.a.toLanguageTags();
  }
  
  public String toString() {
    return this.a.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\os\LocaleListPlatformWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */