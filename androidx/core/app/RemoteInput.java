package androidx.core.app;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class RemoteInput {
  public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
  
  public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
  
  public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
  
  public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
  
  public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
  
  public static final int SOURCE_CHOICE = 1;
  
  public static final int SOURCE_FREE_FORM_INPUT = 0;
  
  private final String a;
  
  private final CharSequence b;
  
  private final CharSequence[] c;
  
  private final boolean d;
  
  private final int e;
  
  private final Bundle f;
  
  private final Set<String> g;
  
  RemoteInput(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, int paramInt, Bundle paramBundle, Set<String> paramSet) {
    this.a = paramString;
    this.b = paramCharSequence;
    this.c = paramArrayOfCharSequence;
    this.d = paramBoolean;
    this.e = paramInt;
    this.f = paramBundle;
    this.g = paramSet;
    if (getEditChoicesBeforeSending() == 2) {
      if (getAllowFreeFormInput())
        return; 
      throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
    } 
  }
  
  static android.app.RemoteInput a(RemoteInput paramRemoteInput) {
    android.app.RemoteInput.Builder builder = (new android.app.RemoteInput.Builder(paramRemoteInput.getResultKey())).setLabel(paramRemoteInput.getLabel()).setChoices(paramRemoteInput.getChoices()).setAllowFreeFormInput(paramRemoteInput.getAllowFreeFormInput()).addExtras(paramRemoteInput.getExtras());
    if (Build.VERSION.SDK_INT >= 29)
      builder.setEditChoicesBeforeSending(paramRemoteInput.getEditChoicesBeforeSending()); 
    return builder.build();
  }
  
  private static Intent a(Intent paramIntent) {
    ClipData clipData = paramIntent.getClipData();
    if (clipData == null)
      return null; 
    ClipDescription clipDescription = clipData.getDescription();
    return !clipDescription.hasMimeType("text/vnd.android.intent") ? null : (!clipDescription.getLabel().equals("android.remoteinput.results") ? null : clipData.getItemAt(0).getIntent());
  }
  
  private static String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("android.remoteinput.dataTypeResultsData");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  static android.app.RemoteInput[] a(RemoteInput[] paramArrayOfRemoteInput) {
    if (paramArrayOfRemoteInput == null)
      return null; 
    android.app.RemoteInput[] arrayOfRemoteInput = new android.app.RemoteInput[paramArrayOfRemoteInput.length];
    for (int i = 0; i < paramArrayOfRemoteInput.length; i++)
      arrayOfRemoteInput[i] = a(paramArrayOfRemoteInput[i]); 
    return arrayOfRemoteInput;
  }
  
  public static void addDataResultToIntent(RemoteInput paramRemoteInput, Intent paramIntent, Map<String, Uri> paramMap) {
    if (Build.VERSION.SDK_INT >= 26) {
      android.app.RemoteInput.addDataResultToIntent(a(paramRemoteInput), paramIntent, paramMap);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      Intent intent2 = a(paramIntent);
      Intent intent1 = intent2;
      if (intent2 == null)
        intent1 = new Intent(); 
      for (Map.Entry<String, Uri> entry : paramMap.entrySet()) {
        String str = (String)entry.getKey();
        Uri uri = (Uri)entry.getValue();
        if (str == null)
          continue; 
        Bundle bundle2 = intent1.getBundleExtra(a(str));
        Bundle bundle1 = bundle2;
        if (bundle2 == null)
          bundle1 = new Bundle(); 
        bundle1.putString(paramRemoteInput.getResultKey(), uri.toString());
        intent1.putExtra(a(str), bundle1);
      } 
      paramIntent.setClipData(ClipData.newIntent("android.remoteinput.results", intent1));
    } 
  }
  
  public static void addResultsToIntent(RemoteInput[] paramArrayOfRemoteInput, Intent paramIntent, Bundle paramBundle) {
    if (Build.VERSION.SDK_INT >= 26) {
      android.app.RemoteInput.addResultsToIntent(a(paramArrayOfRemoteInput), paramIntent, paramBundle);
      return;
    } 
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if (j >= 20) {
      Bundle bundle = getResultsFromIntent(paramIntent);
      j = getResultsSource(paramIntent);
      if (bundle != null) {
        bundle.putAll(paramBundle);
        paramBundle = bundle;
      } 
      int k = paramArrayOfRemoteInput.length;
      for (i = 0; i < k; i++) {
        RemoteInput remoteInput = paramArrayOfRemoteInput[i];
        Map<String, Uri> map = getDataResultsFromIntent(paramIntent, remoteInput.getResultKey());
        android.app.RemoteInput.addResultsToIntent(a(new RemoteInput[] { remoteInput }, ), paramIntent, paramBundle);
        if (map != null)
          addDataResultToIntent(remoteInput, paramIntent, map); 
      } 
      setResultsSource(paramIntent, j);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      Intent intent2 = a(paramIntent);
      Intent intent1 = intent2;
      if (intent2 == null)
        intent1 = new Intent(); 
      Bundle bundle2 = intent1.getBundleExtra("android.remoteinput.resultsData");
      Bundle bundle1 = bundle2;
      if (bundle2 == null)
        bundle1 = new Bundle(); 
      j = paramArrayOfRemoteInput.length;
      while (i < j) {
        RemoteInput remoteInput = paramArrayOfRemoteInput[i];
        Object object = paramBundle.get(remoteInput.getResultKey());
        if (object instanceof CharSequence)
          bundle1.putCharSequence(remoteInput.getResultKey(), (CharSequence)object); 
        i++;
      } 
      intent1.putExtra("android.remoteinput.resultsData", bundle1);
      paramIntent.setClipData(ClipData.newIntent("android.remoteinput.results", intent1));
    } 
  }
  
  public static Map<String, Uri> getDataResultsFromIntent(Intent paramIntent, String paramString) {
    if (Build.VERSION.SDK_INT >= 26)
      return android.app.RemoteInput.getDataResultsFromIntent(paramIntent, paramString); 
    if (Build.VERSION.SDK_INT >= 16) {
      paramIntent = a(paramIntent);
      if (paramIntent == null)
        return null; 
      HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
      for (String str : paramIntent.getExtras().keySet()) {
        if (str.startsWith("android.remoteinput.dataTypeResultsData")) {
          String str1 = str.substring(39);
          if (str1.isEmpty())
            continue; 
          str = paramIntent.getBundleExtra(str).getString(paramString);
          if (str == null || str.isEmpty())
            continue; 
          hashMap2.put(str1, Uri.parse(str));
        } 
      } 
      HashMap<Object, Object> hashMap1 = hashMap2;
      if (hashMap2.isEmpty())
        hashMap1 = null; 
      return (Map)hashMap1;
    } 
    return null;
  }
  
  public static Bundle getResultsFromIntent(Intent paramIntent) {
    if (Build.VERSION.SDK_INT >= 20)
      return android.app.RemoteInput.getResultsFromIntent(paramIntent); 
    if (Build.VERSION.SDK_INT >= 16) {
      paramIntent = a(paramIntent);
      return (paramIntent == null) ? null : (Bundle)paramIntent.getExtras().getParcelable("android.remoteinput.resultsData");
    } 
    return null;
  }
  
  public static int getResultsSource(Intent paramIntent) {
    if (Build.VERSION.SDK_INT >= 28)
      return android.app.RemoteInput.getResultsSource(paramIntent); 
    if (Build.VERSION.SDK_INT >= 16) {
      paramIntent = a(paramIntent);
      return (paramIntent == null) ? 0 : paramIntent.getExtras().getInt("android.remoteinput.resultsSource", 0);
    } 
    return 0;
  }
  
  public static void setResultsSource(Intent paramIntent, int paramInt) {
    if (Build.VERSION.SDK_INT >= 28) {
      android.app.RemoteInput.setResultsSource(paramIntent, paramInt);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      Intent intent2 = a(paramIntent);
      Intent intent1 = intent2;
      if (intent2 == null)
        intent1 = new Intent(); 
      intent1.putExtra("android.remoteinput.resultsSource", paramInt);
      paramIntent.setClipData(ClipData.newIntent("android.remoteinput.results", intent1));
    } 
  }
  
  public boolean getAllowFreeFormInput() {
    return this.d;
  }
  
  public Set<String> getAllowedDataTypes() {
    return this.g;
  }
  
  public CharSequence[] getChoices() {
    return this.c;
  }
  
  public int getEditChoicesBeforeSending() {
    return this.e;
  }
  
  public Bundle getExtras() {
    return this.f;
  }
  
  public CharSequence getLabel() {
    return this.b;
  }
  
  public String getResultKey() {
    return this.a;
  }
  
  public boolean isDataOnly() {
    return (!getAllowFreeFormInput() && (getChoices() == null || (getChoices()).length == 0) && getAllowedDataTypes() != null && !getAllowedDataTypes().isEmpty());
  }
  
  public static final class Builder {
    private final String a;
    
    private final Set<String> b = new HashSet<String>();
    
    private final Bundle c = new Bundle();
    
    private CharSequence d;
    
    private CharSequence[] e;
    
    private boolean f = true;
    
    private int g = 0;
    
    public Builder(String param1String) {
      if (param1String != null) {
        this.a = param1String;
        return;
      } 
      throw new IllegalArgumentException("Result key can't be null");
    }
    
    public Builder addExtras(Bundle param1Bundle) {
      if (param1Bundle != null)
        this.c.putAll(param1Bundle); 
      return this;
    }
    
    public RemoteInput build() {
      return new RemoteInput(this.a, this.d, this.e, this.f, this.g, this.c, this.b);
    }
    
    public Bundle getExtras() {
      return this.c;
    }
    
    public Builder setAllowDataType(String param1String, boolean param1Boolean) {
      if (param1Boolean) {
        this.b.add(param1String);
        return this;
      } 
      this.b.remove(param1String);
      return this;
    }
    
    public Builder setAllowFreeFormInput(boolean param1Boolean) {
      this.f = param1Boolean;
      return this;
    }
    
    public Builder setChoices(CharSequence[] param1ArrayOfCharSequence) {
      this.e = param1ArrayOfCharSequence;
      return this;
    }
    
    public Builder setEditChoicesBeforeSending(int param1Int) {
      this.g = param1Int;
      return this;
    }
    
    public Builder setLabel(CharSequence param1CharSequence) {
      this.d = param1CharSequence;
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EditChoicesBeforeSending {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Source {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\app\RemoteInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */