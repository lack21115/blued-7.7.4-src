package com.tencent.tbs.patch.applier;

import com.tencent.raft.raftannotation.RaftService;
import com.tencent.tbs.patch.common.util.PatchLogger;

@RaftService
public class ApplierService implements IApplierService {
  public void apply(ApplierConfig paramApplierConfig, ApplierListener paramApplierListener) {
    PackageDeltaApplier packageDeltaApplier = new PackageDeltaApplier(paramApplierConfig);
    packageDeltaApplier.setListener(paramApplierListener);
    packageDeltaApplier.doApply();
  }
  
  public void applySync(ApplierConfig paramApplierConfig) {
    (new PackageDeltaApplier(paramApplierConfig)).doApplySync();
  }
  
  public void setLogger(int paramInt, PatchLogger.Delegate paramDelegate) {
    PatchLogger.setLevel(paramInt);
    PatchLogger.setOutputDelegate(paramDelegate);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\applier\ApplierService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */