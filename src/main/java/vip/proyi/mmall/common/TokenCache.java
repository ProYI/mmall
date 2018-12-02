/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: TokenCache
 * Author: ProYI
 * Date: 2018-12-01 11:36
 * Description: Token缓存
 */


package vip.proyi.mmall.common;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 〈Token缓存〉
 * @author ProYI
 * @create 2018-12-01
 */

public class TokenCache {
    private static final Logger logger = LoggerFactory.getLogger(TokenCache.class);

    public static final String TOKEN_PREFIX = "token_";
    /**
    * 声明静态内存块，实现本地缓存
    * 本地缓存的建立使用 CacheBuilder通过调用链来创建
    * initialCapacity 设置缓存的初始化容量
    * maximumSize 缓存最大容量，超过容量时guava使用LRU算法(最小使用算法)来移除缓存项
    * expireAfterAccess 缓存有效期 expireAfterAccess(12, TimeUnit.HOURS) 有效期12小时
    * build为其匿名实现类，也可以单独写实现类
    */
   private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS).build(new CacheLoader<String, String>() {
       //默认的数据加载实现，当调用get取值的时候，如果key没有对应的值，就调用这个方法进行加载
        @Override
        public String load(String key) throws Exception {
            //如果之后调用 xxx.key为空，在判断时 xxx.key.equal() 由于key值为空会报空指针异常。因此将return null替换成 return 字符串的"null"
            return "null";
        }
    });

   public static void setKey(String key, String value) {
       localCache.put(key, value);
   }
   public static String getKey(String key) {
       String value = null;
       try {
           value = localCache.get(key);
           if ("null".equals(value)) {
               return null;
           }
           return value;
       } catch (Exception e) {
           logger.error("localCache get error", e);
       }
       return null;
   }
}