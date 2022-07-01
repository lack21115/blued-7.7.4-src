package androidx.core.app;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;

public class Person {
  CharSequence a;
  
  IconCompat b;
  
  String c;
  
  String d;
  
  boolean e;
  
  boolean f;
  
  Person(Builder paramBuilder) {
    this.a = paramBuilder.a;
    this.b = paramBuilder.b;
    this.c = paramBuilder.c;
    this.d = paramBuilder.d;
    this.e = paramBuilder.e;
    this.f = paramBuilder.f;
  }
  
  public static Person fromAndroidPerson(android.app.Person paramPerson) {
    IconCompat iconCompat;
    Builder builder = (new Builder()).setName(paramPerson.getName());
    if (paramPerson.getIcon() != null) {
      iconCompat = IconCompat.createFromIcon(paramPerson.getIcon());
    } else {
      iconCompat = null;
    } 
    return builder.setIcon(iconCompat).setUri(paramPerson.getUri()).setKey(paramPerson.getKey()).setBot(paramPerson.isBot()).setImportant(paramPerson.isImportant()).build();
  }
  
  public static Person fromBundle(Bundle paramBundle) {
    Bundle bundle = paramBundle.getBundle("icon");
    Builder builder = (new Builder()).setName(paramBundle.getCharSequence("name"));
    if (bundle != null) {
      IconCompat iconCompat = IconCompat.createFromBundle(bundle);
    } else {
      bundle = null;
    } 
    return builder.setIcon((IconCompat)bundle).setUri(paramBundle.getString("uri")).setKey(paramBundle.getString("key")).setBot(paramBundle.getBoolean("isBot")).setImportant(paramBundle.getBoolean("isImportant")).build();
  }
  
  public static Person fromPersistableBundle(PersistableBundle paramPersistableBundle) {
    return (new Builder()).setName(paramPersistableBundle.getString("name")).setUri(paramPersistableBundle.getString("uri")).setKey(paramPersistableBundle.getString("key")).setBot(paramPersistableBundle.getBoolean("isBot")).setImportant(paramPersistableBundle.getBoolean("isImportant")).build();
  }
  
  public IconCompat getIcon() {
    return this.b;
  }
  
  public String getKey() {
    return this.d;
  }
  
  public CharSequence getName() {
    return this.a;
  }
  
  public String getUri() {
    return this.c;
  }
  
  public boolean isBot() {
    return this.e;
  }
  
  public boolean isImportant() {
    return this.f;
  }
  
  public android.app.Person toAndroidPerson() {
    Icon icon;
    android.app.Person.Builder builder = (new android.app.Person.Builder()).setName(getName());
    if (getIcon() != null) {
      icon = getIcon().toIcon();
    } else {
      icon = null;
    } 
    return builder.setIcon(icon).setUri(getUri()).setKey(getKey()).setBot(isBot()).setImportant(isImportant()).build();
  }
  
  public Builder toBuilder() {
    return new Builder(this);
  }
  
  public Bundle toBundle() {
    Bundle bundle = new Bundle();
    bundle.putCharSequence("name", this.a);
    IconCompat iconCompat = this.b;
    if (iconCompat != null) {
      Bundle bundle1 = iconCompat.toBundle();
    } else {
      iconCompat = null;
    } 
    bundle.putBundle("icon", (Bundle)iconCompat);
    bundle.putString("uri", this.c);
    bundle.putString("key", this.d);
    bundle.putBoolean("isBot", this.e);
    bundle.putBoolean("isImportant", this.f);
    return bundle;
  }
  
  public PersistableBundle toPersistableBundle() {
    PersistableBundle persistableBundle = new PersistableBundle();
    CharSequence charSequence = this.a;
    if (charSequence != null) {
      charSequence = charSequence.toString();
    } else {
      charSequence = null;
    } 
    persistableBundle.putString("name", (String)charSequence);
    persistableBundle.putString("uri", this.c);
    persistableBundle.putString("key", this.d);
    persistableBundle.putBoolean("isBot", this.e);
    persistableBundle.putBoolean("isImportant", this.f);
    return persistableBundle;
  }
  
  public static class Builder {
    CharSequence a;
    
    IconCompat b;
    
    String c;
    
    String d;
    
    boolean e;
    
    boolean f;
    
    public Builder() {}
    
    Builder(Person param1Person) {
      this.a = param1Person.a;
      this.b = param1Person.b;
      this.c = param1Person.c;
      this.d = param1Person.d;
      this.e = param1Person.e;
      this.f = param1Person.f;
    }
    
    public Person build() {
      return new Person(this);
    }
    
    public Builder setBot(boolean param1Boolean) {
      this.e = param1Boolean;
      return this;
    }
    
    public Builder setIcon(IconCompat param1IconCompat) {
      this.b = param1IconCompat;
      return this;
    }
    
    public Builder setImportant(boolean param1Boolean) {
      this.f = param1Boolean;
      return this;
    }
    
    public Builder setKey(String param1String) {
      this.d = param1String;
      return this;
    }
    
    public Builder setName(CharSequence param1CharSequence) {
      this.a = param1CharSequence;
      return this;
    }
    
    public Builder setUri(String param1String) {
      this.c = param1String;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\app\Person.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */