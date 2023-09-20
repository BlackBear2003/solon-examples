package demo3011.dso;

import org.noear.solon.data.cache.CacheService;
import org.noear.wood.cache.memcached.MemCache;

import java.util.Properties;

public class MemCacheService implements CacheService {
    MemCache cache;

    public MemCacheService(Properties prop) {
        cache = new MemCache(prop);
    }

    @Override
    public void store(String key, Object obj, int seconds) {
        cache.store(key, obj, seconds);
    }


    @Override
    public void remove(String key) {
        cache.remove(key);
    }

    @Override
    public <T> T get(String key, Class<T> clz) {
        return cache.get(key, clz);
    }
}
