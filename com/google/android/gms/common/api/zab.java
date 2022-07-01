package com.google.android.gms.common.api;

final class zab implements PendingResult.StatusListener {
  zab(Batch paramBatch) {}
  
  public final void onComplete(Status paramStatus) {
    synchronized (Batch.zaa(this.zaa)) {
      if (this.zaa.isCanceled())
        return; 
      if (paramStatus.isCanceled()) {
        Batch.zaa(this.zaa, true);
      } else if (!paramStatus.isSuccess()) {
        Batch.zab(this.zaa, true);
      } 
      Batch.zab(this.zaa);
      if (Batch.zac(this.zaa) == 0)
        if (Batch.zad(this.zaa)) {
          Batch.zae(this.zaa);
        } else {
          if (Batch.zaf(this.zaa)) {
            paramStatus = new Status(13);
          } else {
            paramStatus = Status.RESULT_SUCCESS;
          } 
          this.zaa.setResult(new BatchResult(paramStatus, (PendingResult<?>[])Batch.zag(this.zaa)));
        }  
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\zab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */