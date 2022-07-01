package com.soft.blued.ui.pay.googlepay.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.vending.billing.IInAppBillingService;
import com.blued.android.framework.pool.ThreadExecutor;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public class IabHelper {
  boolean a;
  
  String b;
  
  boolean c;
  
  boolean d;
  
  boolean e;
  
  boolean f;
  
  boolean g;
  
  boolean h;
  
  String i;
  
  Context j;
  
  IInAppBillingService k;
  
  ServiceConnection l;
  
  String m;
  
  OnIabPurchaseFinishedListener n;
  
  private final Object o;
  
  public static String a(int paramInt) {
    StringBuilder stringBuilder;
    String[] arrayOfString1 = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
    String[] arrayOfString2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
    if (paramInt <= -1000) {
      int i = -1000 - paramInt;
      if (i >= 0 && i < arrayOfString2.length)
        return arrayOfString2[i]; 
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append(":Unknown IAB Helper Error");
      return stringBuilder.toString();
    } 
    if (paramInt < 0 || paramInt >= stringBuilder.length) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append(":Unknown");
      return stringBuilder.toString();
    } 
    return (String)stringBuilder[paramInt];
  }
  
  private void c() {
    if (!this.d)
      return; 
    throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
  }
  
  int a(Bundle paramBundle) {
    Object object = paramBundle.get("RESPONSE_CODE");
    if (object == null) {
      b("Bundle with null response code, assuming OK (known issue)");
      return 0;
    } 
    if (object instanceof Integer)
      return ((Integer)object).intValue(); 
    if (object instanceof Long)
      return (int)((Long)object).longValue(); 
    c("Unexpected type for bundle response code.");
    c(object.getClass().getName());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected type for bundle response code: ");
    stringBuilder.append(object.getClass().getName());
    throw new RuntimeException(stringBuilder.toString());
  }
  
  int a(Inventory paramInventory, String paramString) throws JSONException, RemoteException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Querying owned items, item type: ");
    stringBuilder.append(paramString);
    b(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Package name: ");
    stringBuilder.append(this.j.getPackageName());
    b(stringBuilder.toString());
    boolean bool2 = false;
    stringBuilder = null;
    boolean bool1 = false;
    while (true) {
      StringBuilder stringBuilder1;
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("Calling getPurchases with continuation token: ");
      stringBuilder3.append((String)stringBuilder);
      b(stringBuilder3.toString());
      Bundle bundle = this.k.a(3, this.j.getPackageName(), paramString, (String)stringBuilder);
      int i = a(bundle);
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append("Owned items response: ");
      stringBuilder3.append(i);
      b(stringBuilder3.toString());
      if (i != 0) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("getPurchases() failed: ");
        stringBuilder1.append(a(i));
        b(stringBuilder1.toString());
        return i;
      } 
      if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST"))
        break; 
      ArrayList<String> arrayList1 = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
      ArrayList<String> arrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
      ArrayList<String> arrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
      for (i = 0; i < arrayList2.size(); i++) {
        Purchase purchase;
        String str1 = arrayList2.get(i);
        String str2 = arrayList3.get(i);
        String str3 = arrayList1.get(i);
        b("queryPurchases result==");
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("Purchase data: ");
        stringBuilder4.append(str1);
        b(stringBuilder4.toString());
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append("Data signature: ");
        stringBuilder4.append(str2);
        b(stringBuilder4.toString());
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append("sku: ");
        stringBuilder4.append(str3);
        b(stringBuilder4.toString());
        if (Security.a(this.m, str1, str2)) {
          stringBuilder4 = new StringBuilder();
          stringBuilder4.append("Sku is owned: ");
          stringBuilder4.append(str3);
          b(stringBuilder4.toString());
          purchase = new Purchase(paramString, str1, str2);
          if (TextUtils.isEmpty(purchase.c())) {
            d("BUG: empty/null token!");
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("Purchase data: ");
            stringBuilder5.append(str1);
            b(stringBuilder5.toString());
          } 
          stringBuilder1.a(purchase);
        } else {
          d("Purchase signature verification **FAILED**. Not adding item.");
          StringBuilder stringBuilder6 = new StringBuilder();
          stringBuilder6.append("   Purchase data: ");
          stringBuilder6.append(str1);
          b(stringBuilder6.toString());
          StringBuilder stringBuilder5 = new StringBuilder();
          stringBuilder5.append("   Signature: ");
          stringBuilder5.append((String)purchase);
          b(stringBuilder5.toString());
          bool1 = true;
        } 
      } 
      String str = bundle.getString("INAPP_CONTINUATION_TOKEN");
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Continuation token: ");
      stringBuilder2.append(str);
      b(stringBuilder2.toString());
      if (TextUtils.isEmpty(str)) {
        i = bool2;
        if (bool1)
          i = -1003; 
        return i;
      } 
    } 
    c("Bundle returned from getPurchases() doesn't contain required fields.");
    return -1002;
  }
  
  int a(String paramString, Inventory paramInventory, List<String> paramList) throws RemoteException, JSONException, IllegalStateException {
    b("Querying SKU details.");
    arrayList = new ArrayList();
    arrayList.addAll(paramInventory.a(paramString));
    if (paramList != null)
      for (String str : paramList) {
        if (!arrayList.contains(str))
          arrayList.add(str); 
      }  
    if (arrayList.size() == 0) {
      b("queryPrices: nothing to do because there are no SKUs.");
      return 0;
    } 
    paramList = new ArrayList<String>();
    int k = arrayList.size() / 20;
    int j = arrayList.size() % 20;
    int i;
    for (i = 0; i < k; i++) {
      ArrayList<String> arrayList1 = new ArrayList();
      int m = i * 20;
      Iterator<String> iterator = arrayList.subList(m, m + 20).iterator();
      while (iterator.hasNext())
        arrayList1.add(iterator.next()); 
      paramList.add(arrayList1);
    } 
    if (j != 0) {
      ArrayList<String> arrayList1 = new ArrayList();
      i = k * 20;
      Iterator<String> iterator = arrayList.subList(i, j + i).iterator();
      while (iterator.hasNext())
        arrayList1.add(iterator.next()); 
      paramList.add(arrayList1);
    } 
    for (ArrayList<String> arrayList : paramList) {
      StringBuilder stringBuilder;
      Bundle bundle2 = new Bundle();
      bundle2.putStringArrayList("ITEM_ID_LIST", arrayList);
      Bundle bundle1 = this.k.a(3, this.j.getPackageName(), paramString, bundle2);
      if (!bundle1.containsKey("DETAILS_LIST")) {
        i = a(bundle1);
        if (i != 0) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("getSkuDetails() failed: ");
          stringBuilder.append(a(i));
          b(stringBuilder.toString());
          return i;
        } 
        c("getSkuDetails() returned a bundle with neither an error nor a detail list.");
        return -1002;
      } 
      Iterator<String> iterator = bundle1.getStringArrayList("DETAILS_LIST").iterator();
      while (iterator.hasNext()) {
        SkuDetails skuDetails = new SkuDetails((String)stringBuilder, iterator.next());
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Got sku details: ");
        stringBuilder1.append(skuDetails);
        b(stringBuilder1.toString());
        paramInventory.a(skuDetails);
      } 
    } 
    return 0;
  }
  
  public Inventory a(boolean paramBoolean, List<String> paramList1, List<String> paramList2) throws IabException {
    Inventory inventory;
    c();
    a("queryInventory");
    try {
      inventory = new Inventory();
      int i = a(inventory, "inapp");
      if (i == 0) {
        if (paramBoolean) {
          i = a("inapp", inventory, paramList1);
          if (i != 0)
            throw new IabException(i, "Error refreshing inventory (querying prices of items)."); 
        } 
        if (this.f) {
          i = a(inventory, "subs");
          if (i == 0) {
            if (paramBoolean) {
              i = a("subs", inventory, paramList2);
              if (i == 0)
                return inventory; 
              throw new IabException(i, "Error refreshing inventory (querying prices of subscriptions).");
            } 
          } else {
            throw new IabException(i, "Error refreshing inventory (querying owned subscriptions).");
          } 
        } 
      } else {
        throw new IabException(i, "Error refreshing inventory (querying owned items).");
      } 
    } catch (RemoteException remoteException) {
      throw new IabException(-1001, "Remote exception while refreshing inventory.", remoteException);
    } catch (JSONException jSONException) {
      throw new IabException(-1002, "Error parsing JSON response while refreshing inventory.", jSONException);
    } catch (NullPointerException nullPointerException) {
      throw new IabException(-1008, "NullPointer while refreshing inventory.", nullPointerException);
    } catch (IllegalStateException illegalStateException) {
      throw new IabException(-1008, "Exception java.lang.IllegalStateException: Failed parsing settings file: /data/system/users/0/settings_fingerprint.xml IabHelper.querySkuDetails (IabHelper.java:1059)", illegalStateException);
    } 
    return inventory;
  }
  
  public void a() throws IabAsyncInProgressException {
    synchronized (this.o) {
      if (!this.h) {
        b("Disposing.");
        this.c = false;
        if (this.l != null) {
          b("Unbinding from service.");
          null = this.j;
          if (null != null)
            null.unbindService(this.l); 
        } 
        this.d = true;
        this.j = null;
        this.l = null;
        this.k = null;
        this.n = null;
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Can't dispose because an async operation (");
      stringBuilder.append(this.i);
      stringBuilder.append(") is in progress.");
      throw new IabAsyncInProgressException(stringBuilder.toString());
    } 
  }
  
  void a(Purchase paramPurchase) throws IabException {
    c();
    a("consume");
    if (paramPurchase.a.equals("inapp"))
      try {
        String str2 = paramPurchase.c();
        String str1 = paramPurchase.b();
        if (str2 != null && !str2.equals("")) {
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append("Consuming sku: ");
          stringBuilder3.append(str1);
          stringBuilder3.append(", token: ");
          stringBuilder3.append(str2);
          b(stringBuilder3.toString());
          int i = this.k.b(3, this.j.getPackageName(), str2);
          if (i == 0) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Successfully consumed sku: ");
            stringBuilder4.append(str1);
            b(stringBuilder4.toString());
            return;
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Error consuming consuming sku ");
          stringBuilder2.append(str1);
          stringBuilder2.append(". ");
          stringBuilder2.append(a(i));
          b(stringBuilder2.toString());
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Error consuming sku ");
          stringBuilder2.append(str1);
          throw new IabException(i, stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Can't consume ");
        stringBuilder1.append(str1);
        stringBuilder1.append(". No token.");
        c(stringBuilder1.toString());
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("PurchaseInfo is missing token for sku: ");
        stringBuilder1.append(str1);
        stringBuilder1.append(" ");
        stringBuilder1.append(paramPurchase);
        throw new IabException(-1007, stringBuilder1.toString());
      } catch (RemoteException remoteException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Remote exception while consuming. PurchaseInfo: ");
        stringBuilder1.append(paramPurchase);
        throw new IabException(-1001, stringBuilder1.toString(), remoteException);
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Items of type '");
    stringBuilder.append(paramPurchase.a);
    stringBuilder.append("' can't be consumed.");
    throw new IabException(-1010, stringBuilder.toString());
  }
  
  void a(String paramString) {
    if (this.c)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Illegal state for operation (");
    stringBuilder.append(paramString);
    stringBuilder.append("): IAB helper is not set up.");
    c(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("IAB helper is not set up. Can't perform operation: ");
    stringBuilder.append(paramString);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  void b() {
    synchronized (this.o) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Ending async operation: ");
      stringBuilder.append(this.i);
      b(stringBuilder.toString());
      this.i = "";
      this.h = false;
      boolean bool = this.e;
      if (bool)
        try {
          a();
        } catch (IabAsyncInProgressException iabAsyncInProgressException) {} 
      return;
    } 
  }
  
  void b(String paramString) {
    if (this.a)
      Logger.c(this.b, new Object[] { paramString }); 
  }
  
  void c(String paramString) {
    Logger.e(this.b, new Object[] { "In-app billing error: ", paramString });
  }
  
  void d(String paramString) {
    Logger.d(this.b, new Object[] { "In-app billing warning: ", paramString });
  }
  
  public static class IabAsyncInProgressException extends Exception {
    public IabAsyncInProgressException(String param1String) {
      super(param1String);
    }
  }
  
  public static interface OnConsumeFinishedListener {
    void a(Purchase param1Purchase, IabResult param1IabResult);
  }
  
  public static interface OnConsumeMultiFinishedListener {
    void a(List<Purchase> param1List, List<IabResult> param1List1);
  }
  
  public static interface OnIabPurchaseFinishedListener {}
  
  public static interface OnIabSetupFinishedListener {
    void a(IabResult param1IabResult);
  }
  
  public static interface QueryInventoryFinishedListener {
    void a(IabResult param1IabResult, Inventory param1Inventory);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\googlepa\\util\IabHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */