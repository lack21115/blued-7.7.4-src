package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R;
import javax.annotation.Nullable;

public class StringResourceValueReader {
  private final Resources zza;
  
  private final String zzb;
  
  public StringResourceValueReader(Context paramContext) {
    Preconditions.checkNotNull(paramContext);
    this.zza = paramContext.getResources();
    this.zzb = this.zza.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
  }
  
  @Nullable
  public String getString(String paramString) {
    int i = this.zza.getIdentifier(paramString, "string", this.zzb);
    return (i == 0) ? null : this.zza.getString(i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\StringResourceValueReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */