package com.qcloud.scf.runtime;

public interface Context {
    String getRequestId();

    int getTimeLimitInMs();

    int getMemoryLimitInMb();
}
