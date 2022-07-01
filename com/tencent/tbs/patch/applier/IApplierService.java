package com.tencent.tbs.patch.applier;

import com.tencent.raft.raftannotation.RaftService;
import com.tencent.tbs.patch.common.util.PatchLogger;

@RaftService
public interface IApplierService {
  void apply(ApplierConfig paramApplierConfig, ApplierListener paramApplierListener);
  
  void applySync(ApplierConfig paramApplierConfig);
  
  void setLogger(int paramInt, PatchLogger.Delegate paramDelegate);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\applier\IApplierService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */