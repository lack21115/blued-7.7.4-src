package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;

class ViewInfoStore {
  final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> a = new SimpleArrayMap();
  
  final LongSparseArray<RecyclerView.ViewHolder> b = new LongSparseArray();
  
  private RecyclerView.ItemAnimator.ItemHolderInfo a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    int i = this.a.indexOfKey(paramViewHolder);
    if (i < 0)
      return null; 
    InfoRecord infoRecord = (InfoRecord)this.a.valueAt(i);
    if (infoRecord != null && (infoRecord.a & paramInt) != 0) {
      RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
      infoRecord.a &= paramInt;
      if (paramInt == 4) {
        itemHolderInfo = infoRecord.b;
      } else if (paramInt == 8) {
        itemHolderInfo = infoRecord.c;
      } else {
        throw new IllegalArgumentException("Must provide flag PRE or POST");
      } 
      if ((infoRecord.a & 0xC) == 0) {
        this.a.removeAt(i);
        InfoRecord.a(infoRecord);
      } 
      return itemHolderInfo;
    } 
    return null;
  }
  
  RecyclerView.ViewHolder a(long paramLong) {
    return (RecyclerView.ViewHolder)this.b.get(paramLong);
  }
  
  void a() {
    this.a.clear();
    this.b.clear();
  }
  
  void a(long paramLong, RecyclerView.ViewHolder paramViewHolder) {
    this.b.put(paramLong, paramViewHolder);
  }
  
  void a(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo) {
    InfoRecord infoRecord2 = (InfoRecord)this.a.get(paramViewHolder);
    InfoRecord infoRecord1 = infoRecord2;
    if (infoRecord2 == null) {
      infoRecord1 = InfoRecord.a();
      this.a.put(paramViewHolder, infoRecord1);
    } 
    infoRecord1.b = paramItemHolderInfo;
    infoRecord1.a |= 0x4;
  }
  
  void a(ProcessCallback paramProcessCallback) {
    for (int i = this.a.size() - 1; i >= 0; i--) {
      RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)this.a.keyAt(i);
      InfoRecord infoRecord = (InfoRecord)this.a.removeAt(i);
      if ((infoRecord.a & 0x3) == 3) {
        paramProcessCallback.unused(viewHolder);
      } else if ((infoRecord.a & 0x1) != 0) {
        if (infoRecord.b == null) {
          paramProcessCallback.unused(viewHolder);
        } else {
          paramProcessCallback.processDisappeared(viewHolder, infoRecord.b, infoRecord.c);
        } 
      } else if ((infoRecord.a & 0xE) == 14) {
        paramProcessCallback.processAppeared(viewHolder, infoRecord.b, infoRecord.c);
      } else if ((infoRecord.a & 0xC) == 12) {
        paramProcessCallback.processPersistent(viewHolder, infoRecord.b, infoRecord.c);
      } else if ((infoRecord.a & 0x4) != 0) {
        paramProcessCallback.processDisappeared(viewHolder, infoRecord.b, null);
      } else if ((infoRecord.a & 0x8) != 0) {
        paramProcessCallback.processAppeared(viewHolder, infoRecord.b, infoRecord.c);
      } else {
        int j = infoRecord.a;
      } 
      InfoRecord.a(infoRecord);
    } 
  }
  
  boolean a(RecyclerView.ViewHolder paramViewHolder) {
    InfoRecord infoRecord = (InfoRecord)this.a.get(paramViewHolder);
    return (infoRecord != null && (infoRecord.a & 0x1) != 0);
  }
  
  RecyclerView.ItemAnimator.ItemHolderInfo b(RecyclerView.ViewHolder paramViewHolder) {
    return a(paramViewHolder, 4);
  }
  
  void b() {
    InfoRecord.b();
  }
  
  void b(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo) {
    InfoRecord infoRecord2 = (InfoRecord)this.a.get(paramViewHolder);
    InfoRecord infoRecord1 = infoRecord2;
    if (infoRecord2 == null) {
      infoRecord1 = InfoRecord.a();
      this.a.put(paramViewHolder, infoRecord1);
    } 
    infoRecord1.a |= 0x2;
    infoRecord1.b = paramItemHolderInfo;
  }
  
  RecyclerView.ItemAnimator.ItemHolderInfo c(RecyclerView.ViewHolder paramViewHolder) {
    return a(paramViewHolder, 8);
  }
  
  void c(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo) {
    InfoRecord infoRecord2 = (InfoRecord)this.a.get(paramViewHolder);
    InfoRecord infoRecord1 = infoRecord2;
    if (infoRecord2 == null) {
      infoRecord1 = InfoRecord.a();
      this.a.put(paramViewHolder, infoRecord1);
    } 
    infoRecord1.c = paramItemHolderInfo;
    infoRecord1.a |= 0x8;
  }
  
  boolean d(RecyclerView.ViewHolder paramViewHolder) {
    InfoRecord infoRecord = (InfoRecord)this.a.get(paramViewHolder);
    return (infoRecord != null && (infoRecord.a & 0x4) != 0);
  }
  
  void e(RecyclerView.ViewHolder paramViewHolder) {
    InfoRecord infoRecord2 = (InfoRecord)this.a.get(paramViewHolder);
    InfoRecord infoRecord1 = infoRecord2;
    if (infoRecord2 == null) {
      infoRecord1 = InfoRecord.a();
      this.a.put(paramViewHolder, infoRecord1);
    } 
    infoRecord1.a |= 0x1;
  }
  
  void f(RecyclerView.ViewHolder paramViewHolder) {
    InfoRecord infoRecord = (InfoRecord)this.a.get(paramViewHolder);
    if (infoRecord == null)
      return; 
    infoRecord.a &= 0xFFFFFFFE;
  }
  
  void g(RecyclerView.ViewHolder paramViewHolder) {
    for (int i = this.b.size() - 1; i >= 0; i--) {
      if (paramViewHolder == this.b.valueAt(i)) {
        this.b.removeAt(i);
        break;
      } 
    } 
    InfoRecord infoRecord = (InfoRecord)this.a.remove(paramViewHolder);
    if (infoRecord != null)
      InfoRecord.a(infoRecord); 
  }
  
  public void onViewDetached(RecyclerView.ViewHolder paramViewHolder) {
    f(paramViewHolder);
  }
  
  static class InfoRecord {
    static Pools.Pool<InfoRecord> d = (Pools.Pool<InfoRecord>)new Pools.SimplePool(20);
    
    int a;
    
    RecyclerView.ItemAnimator.ItemHolderInfo b;
    
    RecyclerView.ItemAnimator.ItemHolderInfo c;
    
    static InfoRecord a() {
      InfoRecord infoRecord2 = (InfoRecord)d.acquire();
      InfoRecord infoRecord1 = infoRecord2;
      if (infoRecord2 == null)
        infoRecord1 = new InfoRecord(); 
      return infoRecord1;
    }
    
    static void a(InfoRecord param1InfoRecord) {
      param1InfoRecord.a = 0;
      param1InfoRecord.b = null;
      param1InfoRecord.c = null;
      d.release(param1InfoRecord);
    }
    
    static void b() {
      while (d.acquire() != null);
    }
  }
  
  static interface ProcessCallback {
    void processAppeared(RecyclerView.ViewHolder param1ViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo2);
    
    void processDisappeared(RecyclerView.ViewHolder param1ViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo2);
    
    void processPersistent(RecyclerView.ViewHolder param1ViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo2);
    
    void unused(RecyclerView.ViewHolder param1ViewHolder);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\ViewInfoStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */