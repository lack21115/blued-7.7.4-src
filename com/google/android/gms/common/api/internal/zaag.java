package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zal;
import java.util.ArrayList;
import java.util.Map;

final class zaag extends zaap {
  private final Map<Api.Client, zaah> zab;
  
  public zaag(zaaf paramzaaf, Map<Api.Client, zaah> paramMap) {
    super(paramzaaf, null);
    this.zab = paramMap;
  }
  
  public final void zaa() {
    ConnectionResult connectionResult;
    zal zal = new zal(zaaf.zab(this.zaa));
    ArrayList<Api.Client> arrayList1 = new ArrayList();
    ArrayList<Api.Client> arrayList2 = new ArrayList();
    for (Api.Client client : this.zab.keySet()) {
      if (client.requiresGooglePlayServices() && !zaah.zaa(this.zab.get(client))) {
        arrayList1.add(client);
        continue;
      } 
      arrayList2.add(client);
    } 
    int i = -1;
    boolean bool = arrayList1.isEmpty();
    int k = 0;
    int j = 0;
    if (bool) {
      arrayList1 = arrayList2;
      int m = arrayList1.size();
      while (j < m) {
        arrayList2 = (ArrayList<Api.Client>)arrayList1.get(j);
        j++;
        Api.Client client = (Api.Client)arrayList2;
        k = zal.zaa(zaaf.zaa(this.zaa), client);
        i = k;
        if (k == 0) {
          i = k;
          break;
        } 
      } 
    } else {
      arrayList1 = arrayList1;
      int m = arrayList1.size();
      j = k;
      while (j < m) {
        arrayList2 = (ArrayList<Api.Client>)arrayList1.get(j);
        j++;
        Api.Client client = (Api.Client)arrayList2;
        k = zal.zaa(zaaf.zaa(this.zaa), client);
        i = k;
        if (k != 0) {
          i = k;
          break;
        } 
      } 
    } 
    if (i != 0) {
      connectionResult = new ConnectionResult(i, null);
      zaaf.zad(this.zaa).zaa(new zaaj(this, this.zaa, connectionResult));
      return;
    } 
    if (zaaf.zae(this.zaa) && zaaf.zaf(this.zaa) != null)
      zaaf.zaf(this.zaa).zab(); 
    for (Api.Client client : this.zab.keySet()) {
      BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = this.zab.get(client);
      if (client.requiresGooglePlayServices() && connectionResult.zaa(zaaf.zaa(this.zaa), client) != 0) {
        zaaf.zad(this.zaa).zaa(new zaai(this, this.zaa, connectionProgressReportCallbacks));
        continue;
      } 
      client.connect(connectionProgressReportCallbacks);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */