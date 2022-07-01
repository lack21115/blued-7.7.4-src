package androidx.core.content.pm;

import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortcutInfoCompat {
  Context a;
  
  String b;
  
  Intent[] c;
  
  ComponentName d;
  
  CharSequence e;
  
  CharSequence f;
  
  CharSequence g;
  
  IconCompat h;
  
  boolean i;
  
  Person[] j;
  
  Set<String> k;
  
  boolean l;
  
  int m;
  
  private PersistableBundle a() {
    PersistableBundle persistableBundle = new PersistableBundle();
    Person[] arrayOfPerson = this.j;
    if (arrayOfPerson != null && arrayOfPerson.length > 0) {
      persistableBundle.putInt("extraPersonCount", arrayOfPerson.length);
      for (int i = 0; i < this.j.length; i = j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("extraPerson_");
        int j = i + 1;
        stringBuilder.append(j);
        persistableBundle.putPersistableBundle(stringBuilder.toString(), this.j[i].toPersistableBundle());
      } 
    } 
    persistableBundle.putBoolean("extraLongLived", this.l);
    return persistableBundle;
  }
  
  static Person[] a(PersistableBundle paramPersistableBundle) {
    if (paramPersistableBundle == null || !paramPersistableBundle.containsKey("extraPersonCount"))
      return null; 
    int j = paramPersistableBundle.getInt("extraPersonCount");
    Person[] arrayOfPerson = new Person[j];
    for (int i = 0; i < j; i = k) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("extraPerson_");
      int k = i + 1;
      stringBuilder.append(k);
      arrayOfPerson[i] = Person.fromPersistableBundle(paramPersistableBundle.getPersistableBundle(stringBuilder.toString()));
    } 
    return arrayOfPerson;
  }
  
  Intent a(Intent paramIntent) {
    Intent[] arrayOfIntent = this.c;
    paramIntent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)arrayOfIntent[arrayOfIntent.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.e.toString());
    if (this.h != null) {
      Drawable drawable;
      ComponentName componentName = null;
      Intent[] arrayOfIntent1 = null;
      if (this.i) {
        Intent[] arrayOfIntent2;
        PackageManager packageManager = this.a.getPackageManager();
        componentName = this.d;
        arrayOfIntent = arrayOfIntent1;
        if (componentName != null)
          try {
            Drawable drawable1 = packageManager.getActivityIcon(componentName);
          } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
            arrayOfIntent2 = arrayOfIntent1;
          }  
        Intent[] arrayOfIntent3 = arrayOfIntent2;
        if (arrayOfIntent2 == null)
          drawable = this.a.getApplicationInfo().loadIcon(packageManager); 
      } 
      this.h.addToShortcutIntent(paramIntent, drawable, this.a);
    } 
    return paramIntent;
  }
  
  public ComponentName getActivity() {
    return this.d;
  }
  
  public Set<String> getCategories() {
    return this.k;
  }
  
  public CharSequence getDisabledMessage() {
    return this.g;
  }
  
  public IconCompat getIcon() {
    return this.h;
  }
  
  public String getId() {
    return this.b;
  }
  
  public Intent getIntent() {
    Intent[] arrayOfIntent = this.c;
    return arrayOfIntent[arrayOfIntent.length - 1];
  }
  
  public Intent[] getIntents() {
    Intent[] arrayOfIntent = this.c;
    return Arrays.<Intent>copyOf(arrayOfIntent, arrayOfIntent.length);
  }
  
  public CharSequence getLongLabel() {
    return this.f;
  }
  
  public int getRank() {
    return this.m;
  }
  
  public CharSequence getShortLabel() {
    return this.e;
  }
  
  public ShortcutInfo toShortcutInfo() {
    ShortcutInfo.Builder builder = (new ShortcutInfo.Builder(this.a, this.b)).setShortLabel(this.e).setIntents(this.c);
    IconCompat iconCompat = this.h;
    if (iconCompat != null)
      builder.setIcon(iconCompat.toIcon()); 
    if (!TextUtils.isEmpty(this.f))
      builder.setLongLabel(this.f); 
    if (!TextUtils.isEmpty(this.g))
      builder.setDisabledMessage(this.g); 
    ComponentName componentName = this.d;
    if (componentName != null)
      builder.setActivity(componentName); 
    Set<String> set = this.k;
    if (set != null)
      builder.setCategories(set); 
    builder.setRank(this.m);
    if (Build.VERSION.SDK_INT >= 29) {
      Person[] arrayOfPerson = this.j;
      if (arrayOfPerson != null && arrayOfPerson.length > 0) {
        Person[] arrayOfPerson1 = new Person[arrayOfPerson.length];
        for (int i = 0; i < arrayOfPerson1.length; i++)
          arrayOfPerson1[i] = this.j[i].toAndroidPerson(); 
        builder.setPersons(arrayOfPerson1);
      } 
      builder.setLongLived(this.l);
    } else {
      builder.setExtras(a());
    } 
    return builder.build();
  }
  
  public static class Builder {
    private final ShortcutInfoCompat a = new ShortcutInfoCompat();
    
    public Builder(Context param1Context, ShortcutInfo param1ShortcutInfo) {
      ShortcutInfoCompat shortcutInfoCompat = this.a;
      shortcutInfoCompat.a = param1Context;
      shortcutInfoCompat.b = param1ShortcutInfo.getId();
      Intent[] arrayOfIntent = param1ShortcutInfo.getIntents();
      this.a.c = Arrays.<Intent>copyOf(arrayOfIntent, arrayOfIntent.length);
      this.a.d = param1ShortcutInfo.getActivity();
      this.a.e = param1ShortcutInfo.getShortLabel();
      this.a.f = param1ShortcutInfo.getLongLabel();
      this.a.g = param1ShortcutInfo.getDisabledMessage();
      this.a.k = param1ShortcutInfo.getCategories();
      this.a.j = ShortcutInfoCompat.a(param1ShortcutInfo.getExtras());
      this.a.m = param1ShortcutInfo.getRank();
    }
    
    public Builder(Context param1Context, String param1String) {
      ShortcutInfoCompat shortcutInfoCompat = this.a;
      shortcutInfoCompat.a = param1Context;
      shortcutInfoCompat.b = param1String;
    }
    
    public Builder(ShortcutInfoCompat param1ShortcutInfoCompat) {
      this.a.a = param1ShortcutInfoCompat.a;
      this.a.b = param1ShortcutInfoCompat.b;
      this.a.c = Arrays.<Intent>copyOf(param1ShortcutInfoCompat.c, param1ShortcutInfoCompat.c.length);
      this.a.d = param1ShortcutInfoCompat.d;
      this.a.e = param1ShortcutInfoCompat.e;
      this.a.f = param1ShortcutInfoCompat.f;
      this.a.g = param1ShortcutInfoCompat.g;
      this.a.h = param1ShortcutInfoCompat.h;
      this.a.i = param1ShortcutInfoCompat.i;
      this.a.l = param1ShortcutInfoCompat.l;
      this.a.m = param1ShortcutInfoCompat.m;
      if (param1ShortcutInfoCompat.j != null)
        this.a.j = Arrays.<Person>copyOf(param1ShortcutInfoCompat.j, param1ShortcutInfoCompat.j.length); 
      if (param1ShortcutInfoCompat.k != null)
        this.a.k = new HashSet<String>(param1ShortcutInfoCompat.k); 
    }
    
    public ShortcutInfoCompat build() {
      if (!TextUtils.isEmpty(this.a.e)) {
        if (this.a.c != null && this.a.c.length != 0)
          return this.a; 
        throw new IllegalArgumentException("Shortcut must have an intent");
      } 
      throw new IllegalArgumentException("Shortcut must have a non-empty label");
    }
    
    public Builder setActivity(ComponentName param1ComponentName) {
      this.a.d = param1ComponentName;
      return this;
    }
    
    public Builder setAlwaysBadged() {
      this.a.i = true;
      return this;
    }
    
    public Builder setCategories(Set<String> param1Set) {
      this.a.k = param1Set;
      return this;
    }
    
    public Builder setDisabledMessage(CharSequence param1CharSequence) {
      this.a.g = param1CharSequence;
      return this;
    }
    
    public Builder setIcon(IconCompat param1IconCompat) {
      this.a.h = param1IconCompat;
      return this;
    }
    
    public Builder setIntent(Intent param1Intent) {
      return setIntents(new Intent[] { param1Intent });
    }
    
    public Builder setIntents(Intent[] param1ArrayOfIntent) {
      this.a.c = param1ArrayOfIntent;
      return this;
    }
    
    public Builder setLongLabel(CharSequence param1CharSequence) {
      this.a.f = param1CharSequence;
      return this;
    }
    
    @Deprecated
    public Builder setLongLived() {
      this.a.l = true;
      return this;
    }
    
    public Builder setLongLived(boolean param1Boolean) {
      this.a.l = param1Boolean;
      return this;
    }
    
    public Builder setPerson(Person param1Person) {
      return setPersons(new Person[] { param1Person });
    }
    
    public Builder setPersons(Person[] param1ArrayOfPerson) {
      this.a.j = param1ArrayOfPerson;
      return this;
    }
    
    public Builder setRank(int param1Int) {
      this.a.m = param1Int;
      return this;
    }
    
    public Builder setShortLabel(CharSequence param1CharSequence) {
      this.a.e = param1CharSequence;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\content\pm\ShortcutInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */