package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

final class zaal extends zaap {
  private final ArrayList<Api.Client> zaa;
  
  public zaal(zaaf paramzaaf, ArrayList<Api.Client> paramArrayList) {
    super(paramzaaf, null);
    this.zaa = paramArrayList;
  }
  
  public final void zaa() {
    (zaaf.zad(this.zab)).zad.zac = zaaf.zag(this.zab);
    ArrayList<Api.Client> arrayList = this.zaa;
    int j = arrayList.size();
    int i = 0;
    while (i < j) {
      Api.Client client = (Api.Client)arrayList.get(i);
      i++;
      ((Api.Client)client).getRemoteService(zaaf.zah(this.zab), (zaaf.zad(this.zab)).zad.zac);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */