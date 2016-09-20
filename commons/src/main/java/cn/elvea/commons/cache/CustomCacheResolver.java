package cn.elvea.commons.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomCacheResolver implements CacheResolver {
    @Autowired
    private CacheManager cacheManager;

    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        List<Cache> caches = new ArrayList<>();
        return caches;
    }
}
