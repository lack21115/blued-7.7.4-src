package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zad;
import com.google.android.gms.signin.internal.zam;
import java.lang.ref.WeakReference;

final class zaak extends zad {
  private final WeakReference<zaaf> zaa;
  
  zaak(zaaf paramzaaf) {
    this.zaa = new WeakReference<zaaf>(paramzaaf);
  }
  
  public final void zaa(zam paramzam) {
    zaaf zaaf = this.zaa.get();
    if (zaaf == null)
      return; 
    zaaf.zad(zaaf).zaa(new zaan(this, zaaf, zaaf, paramzam));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */