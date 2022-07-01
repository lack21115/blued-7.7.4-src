package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;

final class zac {
  public final Uri zaa;
  
  public zac(Uri paramUri) {
    this.zaa = paramUri;
  }
  
  public final boolean equals(Object paramObject) {
    return (this == paramObject) ? true : (!(paramObject instanceof zac) ? false : Objects.equal(((zac)paramObject).zaa, this.zaa));
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { this.zaa });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\images\zac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */