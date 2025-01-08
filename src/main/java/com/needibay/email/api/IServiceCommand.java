package com.needibay.email.api;

import java.util.concurrent.CompletableFuture;

public interface IServiceCommand {
    public Object execute();
    public CompletableFuture<Object> executeAsync();

}
