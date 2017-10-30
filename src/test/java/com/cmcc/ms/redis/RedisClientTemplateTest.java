package com.cmcc.ms.redis;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPipeline;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;

import com.cmcc.ms.entity.system.SysMenus;
import com.cmcc.ms.service.BaseTestCase;

/**
 *
 * @author zhangxu-ws
 */
public class RedisClientTemplateTest extends BaseTestCase {

    @Autowired
    public RedisClientTemplate redisClientTemplate;

    /**
     * Run the RedisClientTemplate() constructor test.
     *
     */
    @Test
    public void testRedisClientTemplate() throws Exception {
        assertNotNull(redisClientTemplate);
    }

    /**
     * Run the void addUserList(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testAddUserList() throws Exception {
        String userId = "1";
        redisClientTemplate.addUserList(userId);

    }

    /**
     * Run the Long append(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void testAppend() throws Exception {
        String key = "ldyldy";
        String value = "asdasdas";
        String setRedis = redisClientTemplate.set("ldyldy", "123");
        Long append = redisClientTemplate.append(key, value);
        Assert.notNull(setRedis);
        Assert.notNull(append);
    }

    /**
     * Run the Long append(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testAppenda() throws Exception {
        String key = "ldy";
        String value = "valueAppenda";
        redisClientTemplate.set(key, value);
        Long append = redisClientTemplate.append(key, "Test");
        Assert.notNull(append);
    }

    /**
     * Run the Long append(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testAppendc() throws Exception {
        byte[] key = "testAppendc".getBytes();
        byte[] value = "valueAppendc".getBytes();
        redisClientTemplate.set(key, value);
        Long append = redisClientTemplate.append(key, "Test".getBytes());

        Assert.notNull(append);
    }

    /**
     * Run the Long append(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testAppendd() throws Exception {
        byte[] key = "testAppendd".getBytes();
        byte[] value = "valueAppendd".getBytes();
        redisClientTemplate.set(key, value);
        Long append = redisClientTemplate.append(key, "test".getBytes());

        Assert.notNull(append);
    }

    /**
     * Run the Long decr(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testDecr() throws Exception {
        String key = "141";

        Long append = redisClientTemplate.decr(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long decr(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testDecra() throws Exception {
        byte[] key = new byte[] { 3 };

        Long append = redisClientTemplate.decr(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long decr(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testDecrd() throws Exception {
        byte[] key = new byte[] { 5 };

        Long append = redisClientTemplate.decr(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long decrBy(String,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testDecrBy() throws Exception {
        String key = "2";
        long integer = 1L;

        Long append = redisClientTemplate.decrBy(key, integer);

        Assert.notNull(append);
    }

    /**
     * Run the Long decrBy(String,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testDecrByb() throws Exception {
        String key = "3";
        long integer = 1L;

        Long append = redisClientTemplate.decrBy(key, integer);

        Assert.notNull(append);
    }

    /**
     * Run the Long decrBy(byte[],long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testDecrByc() throws Exception {
        byte[] key = new byte[] {};
        long integer = 1L;

        Long append = redisClientTemplate.decrBy(key, integer);

        Assert.notNull(append);
    }

    /**
     * Run the Long decrBy(byte[],long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testDecrByd() throws Exception {
        byte[] key = new byte[] {};
        long integer = 1L;

        Long count = redisClientTemplate.decrBy(key, integer);

        assertNotNull(count);
    }

    /**
     * Run the Long del(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testDel() throws Exception {
        String key = "4";

        Long append = redisClientTemplate.del(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long del(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testDell() throws Exception {
        String key = "5";

        Long append = redisClientTemplate.del(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long del(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testDelt() throws Exception {
        ;
        byte[] key = new byte[] { 34 };

        Long countDelt = redisClientTemplate.del(key);

        Assert.notNull(countDelt);
    }

    /**
     * Run the Long del(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testDelh() throws Exception {
        byte[] key = "testDelh".getBytes();
        byte[] value = "valueDelh".getBytes();
        redisClientTemplate.set(key, value);
        Long countDelh = redisClientTemplate.del(key);

        assertNotNull(countDelh);
    }

    /**
     * Run the void disconnect() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testDisconnect() throws Exception {

        redisClientTemplate.disconnect();

    }

    /**
     * Run the Boolean exists(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testExists() throws Exception {
        String key = "355";

        Boolean append = redisClientTemplate.exists(key);

        Assert.notNull(append);
    }

    /**
     * Run the Boolean exists(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testExistsb() throws Exception {
        String key = "373";

        Boolean append = redisClientTemplate.exists(key);

        Assert.notNull(append);
    }

    /**
     * Run the Boolean exists(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testExistsc() throws Exception {
        ;
        byte[] key = "testExistsc".getBytes();

        Boolean append = redisClientTemplate.exists(key);

        Assert.notNull(append);
    }

    /**
     * Run the Boolean exists(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testExistsd() throws Exception {
        ;
        byte[] key = "testExistsd".getBytes();

        Boolean append = redisClientTemplate.exists(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long expire(String,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testExpiref() throws Exception {
        ;
        String key = "427";
        int seconds = 1;

        Long append = redisClientTemplate.expire(key, seconds);

        Assert.notNull(append);
    }

    /**
     * Run the Long expire(String,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testExpireb() throws Exception {
        ;
        String key = "446";
        int seconds = 1;

        Long append = redisClientTemplate.expire(key, seconds);

        Assert.notNull(append);
    }

    /**
     * Run the Long expire(byte[],int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testExpirec() throws Exception {
        ;
        byte[] key = "testExpirec".getBytes();
        int seconds = 1;
        byte[] value = "valueExpirec".getBytes();
        redisClientTemplate.set(key, value);
        Long append = redisClientTemplate.expire(key, seconds);

        Assert.notNull(append);
    }

    /**
     * Run the Long expire(byte[],int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testExpired() throws Exception {
        ;
        byte[] key = "testxpired".getBytes();
        int seconds = 1;

        Long append = redisClientTemplate.expire(key, seconds);

        Assert.notNull(append);
    }

    /**
     * Run the Long expireAt(String,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testExpireAta() throws Exception {
        ;
        String key = "503";
        long unixTime = 1L;

        Long append = redisClientTemplate.expireAt(key, unixTime);

        Assert.notNull(append);
    }

    /**
     * Run the Long expireAt(String,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testExpireAtb() throws Exception {
        ;
        String key = "522";
        long unixTime = 1L;

        Long append = redisClientTemplate.expireAt(key, unixTime);

        Assert.notNull(append);
    }

    /**
     * Run the Long expireAt(byte[],long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testExpireAt() throws Exception {
        ;
        byte[] key = new byte[] { 5, 4, 1 };
        long unixTime = 1L;

        Long append = redisClientTemplate.expireAt(key, unixTime);

        Assert.notNull(append);
    }

    /**
     * Run the Long expireAt(byte[],long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testExpireAtf() throws Exception {
        ;
        byte[] key = new byte[] { 5, 6, 0 };
        long unixTime = 1L;

        Long append = redisClientTemplate.expireAt(key, unixTime);

        Assert.notNull(append);
    }

    /**
     * Run the String get(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGeta() throws Exception {
        ;
        String key = "testGeta";
        redisClientTemplate.set(key, "571");
        String append = redisClientTemplate.get(key);

        Assert.notNull(append);
    }

    /**
     * Run the String get(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetb() throws Exception {
        ;
        String key = "testGetb";
        redisClientTemplate.set(key, "590");
        String append = redisClientTemplate.get(key);

        Assert.notNull(append);
    }

    /**
     * Run the byte[] get(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetc() throws Exception {
        ;
        byte[] key = "testGetc".getBytes();
        byte[] member = "valueGetc".getBytes();
        redisClientTemplate.set(key, member);
        byte[] append = redisClientTemplate.get(key);

        Assert.notNull(append);
    }

    /**
     * Run the byte[] get(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetd() throws Exception {
        ;
        byte[] key = "testGetd".getBytes();
        byte[] value = "valueGetd".getBytes();
        redisClientTemplate.set(key, value);
        byte[] append = redisClientTemplate.get(key);

        Assert.notNull(append);
    }

    /**
     * Run the Collection<JedisShardInfo> getAllShardInfo() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetAllShardInfoa() throws Exception {
        ;

        Collection<JedisShardInfo> append = redisClientTemplate.getAllShardInfo();

        Assert.notNull(append);
    }

    /**
     * Run the Collection<JedisShardInfo> getAllShardInfo() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 17-9-26 下午4:03
     */
    @Test
    public void testGetAllShardInfob() throws Exception {
        ;

        Collection<JedisShardInfo> append = redisClientTemplate.getAllShardInfo();

        Assert.notNull(append);
    }

    /**
     * Run the Collection<Jedis> getAllShards() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetAllShardsa() throws Exception {
        ;

        Collection<Jedis> append = redisClientTemplate.getAllShards();

        Assert.notNull(append);
    }

    /**
     * Run the Collection<Jedis> getAllShards() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetAllShardsb() throws Exception {
        ;

        Collection<Jedis> append = redisClientTemplate.getAllShards();

        Assert.notNull(append);
    }

    /**
     * Run the Object getEntity(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetEntitya() throws Exception {
        ;
        String key = "720";
        redisClientTemplate.setEntity(key, "720v");
        Object append = redisClientTemplate.getEntity(key);

        Assert.notNull(append);
    }

    /**
     * Run the String getKeyTag(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetKeyTaga() throws Exception {
        ;
        String key = "756";

        String append = redisClientTemplate.getKeyTag(key);

        Assert.notNull(append);
    }

    /**
     * Run the String getKeyTag(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetKeyTagb() throws Exception {
        ;
        String key = "774";

        String append = redisClientTemplate.getKeyTag(key);

        Assert.notNull(append);
    }

    /**
     * Run the String getSet(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetSeta() throws Exception {
        ;
        String key = "testGetSeta";
        String value = "valueGetSeta";

        redisClientTemplate.getSet(key, value);

    }

    /**
     * Run the String getSet(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetSetb() throws Exception {
        ;
        String key = "testGetSetb";
        String value = "valueGetSetb";

        redisClientTemplate.getSet(key, value);
        redisClientTemplate.del(key);

    }

    /**
     * Run the byte[] getSet(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetSetc() throws Exception {
        ;
        byte[] key = "testGetSetc".getBytes();
        byte[] value = "valueGetSetc".getBytes();

        redisClientTemplate.getSet(key, value);

    }

    /**
     * Run the byte[] getSet(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetSetd() throws Exception {
        ;
        byte[] key = "testGetSetd".getBytes();
        byte[] value = "valueGetSetd".getBytes();

        redisClientTemplate.getSet(key, value);

    }

    /**
     * Run the Jedis getShard(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetSharda() throws Exception {
        ;
        String key = "868";

        Jedis append = redisClientTemplate.getShard(key);

        Assert.notNull(append);
    }

    /**
     * Run the Jedis getShard(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetShardb() throws Exception {
        ;
        String key = "886";

        Jedis append = redisClientTemplate.getShard(key);

        Assert.notNull(append);
    }

    /**
     * Run the Jedis getShard(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetSharc() throws Exception {
        ;
        byte[] key = new byte[] { 9, 0, 4 };

        Jedis append = redisClientTemplate.getShard(key);

        Assert.notNull(append);
    }

    /**
     * Run the Jedis getShard(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetShardd() throws Exception {
        ;
        byte[] key = new byte[] { 9, 2, 2 };

        Jedis append = redisClientTemplate.getShard(key);

        Assert.notNull(append);
    }

    /**
     * Run the JedisShardInfo getShardInfo(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetShardInfoa() throws Exception {
        ;
        String key = "9,4,0";

        JedisShardInfo append = redisClientTemplate.getShardInfo(key);

        Assert.notNull(append);
    }

    /**
     * Run the JedisShardInfo getShardInfo(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetShardInfob() throws Exception {
        ;
        String key = "9,5,8";

        JedisShardInfo append = redisClientTemplate.getShardInfo(key);

        Assert.notNull(append);
    }

    /**
     * Run the JedisShardInfo getShardInfo(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetShardInfoc() throws Exception {
        ;
        byte[] key = new byte[] { 9, 7, 6 };

        JedisShardInfo append = redisClientTemplate.getShardInfo(key);

        Assert.notNull(append);
    }

    /**
     * Run the JedisShardInfo getShardInfo(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetShardInfod() throws Exception {
        ;
        byte[] key = new byte[] { 9, 9, 4 };

        JedisShardInfo append = redisClientTemplate.getShardInfo(key);

        Assert.notNull(append);
    }

    /**
     * Run the Set<String> getUserList() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetUserLista() throws Exception {
        ;

        Set<String> append = redisClientTemplate.getUserList();

        Assert.notNull(append);
    }

    /**
     * Run the boolean getbit(String,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetbit() throws Exception {
        ;
        String key = "testGetbit";
        long offset = 1L;
        redisClientTemplate.setbit(key, offset, true);
        boolean append = redisClientTemplate.getbit(key, offset);

        assertTrue(append);
    }

    /**
     * Run the boolean getbit(String,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetbitb() throws Exception {
        ;
        String key = "testGetbitb";
        long offset = 1L;
        redisClientTemplate.setbit(key, offset, true);
        boolean append = redisClientTemplate.getbit(key, offset);

        assertTrue(append);
    }

    /**
     * Run the boolean getbit(String,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetbitc() throws Exception {
        ;
        String key = "testGetbitc";
        long offset = 1L;
        redisClientTemplate.setbit(key, offset, true);
        boolean append = redisClientTemplate.getbit(key, offset);

        assertTrue(append);
    }

    /**
     * Run the boolean getbit(String,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetbitd() throws Exception {
        ;
        String key = "testGetbitd";
        long offset = 1L;
        redisClientTemplate.setbit(key, offset, true);
        boolean append = redisClientTemplate.getbit(key, offset);

        assertTrue(append);
    }

    /**
     * Run the String getrange(String,long,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetrange() throws Exception {
        ;
        String key = "1105";
        long startOffset = 1L;
        long endOffset = 1L;
        String value = "This is my test key";
        redisClientTemplate.set(key, value);
        String append = redisClientTemplate.getrange(key, startOffset, endOffset);

        Assert.notNull(append);
    }

    /**
     * Run the Long hdel(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHdela() throws Exception {
        ;
        String key = "1146";
        String field = "1146f";
        redisClientTemplate.hset(key, field, "1146v");
        Long append = redisClientTemplate.hdel(key, field);

        Assert.notNull(append);
    }

    /**
     * Run the Long hdel(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHdel() throws Exception {
        ;
        String key = "1165";
        String field = "1165f";
        redisClientTemplate.hset(key, field, "1165v");
        Long append = redisClientTemplate.hdel(key, field);

        Assert.notNull(append);
    }

    /**
     * Run the Long hdel(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHdelc() throws Exception {
        ;
        byte[] key = new byte[] { 1, 1, 8, 4 };
        byte[] field = new byte[] {};
        byte[] value = new byte[] {};
        redisClientTemplate.hset(key, field, value);
        Long append = redisClientTemplate.hdel(key, field);

        Assert.notNull(append);
    }

    /**
     * Run the Long hdel(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHdeld() throws Exception {
        ;
        byte[] key = new byte[] { 1, 2, 0, 4 };
        byte[] field = new byte[] {};
        byte[] value = new byte[] {};
        redisClientTemplate.hset(key, field, value);
        Long append = redisClientTemplate.hdel(key, field);

        Assert.notNull(append);
    }

    /**
     * Run the Boolean hexists(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHexistsa() throws Exception {
        ;
        String key = "testHexistsa";
        String field = "fieldHexistsa";
        redisClientTemplate.hset(key, field, "valueHexistsa");
        Boolean append = redisClientTemplate.hexists(key, field);

        Assert.notNull(append);
    }

    /**
     * Run the Boolean hexists(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHexistsb() throws Exception {
        ;
        String key = "testHexistsb";
        String field = "fieldHexistsb";
        redisClientTemplate.hset(key, field, "valueHexistsa");
        Boolean append = redisClientTemplate.hexists(key, field);

        Assert.notNull(append);
    }

    /**
     * Run the Boolean hexists(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHexists() throws Exception {
        ;
        byte[] key = "testHexists".getBytes();
        byte[] field = "fieldHexists".getBytes();
        byte[] value = "valueHexists".getBytes();
        redisClientTemplate.hset(key, field, value);
        Boolean append = redisClientTemplate.hexists(key, field);

        Assert.notNull(append);
    }

    /**
     * Run the Boolean hexists(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHexistsd() throws Exception {
        ;
        byte[] key = "testHexistsd".getBytes();
        byte[] field = "fieldHexistsd".getBytes();
        byte[] value = "valueHexistsd".getBytes();
        redisClientTemplate.hset(key, field, value);
        Boolean append = redisClientTemplate.hexists(key, field);

        Assert.notNull(append);
    }

    /**
     * Run the String hget(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHget() throws Exception {
        ;
        String key = "testHget";
        String field = "fieldHget";
        String value = "valueHget";
        redisClientTemplate.hset(key, field, value);
        String append = redisClientTemplate.hget(key, field);

        Assert.notNull(append);
    }

    /**
     * Run the byte[] hget(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHgetc() throws Exception {
        ;
        byte[] key = "site".getBytes();
        byte[] field = "redis".getBytes();
        byte[] value = "test".getBytes();
        redisClientTemplate.hset(key, field, value);
        byte[] append = redisClientTemplate.hget(key, field);

        Assert.notNull(append);
    }

    /**
     * Run the byte[] hget(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHgetd() throws Exception {
        ;
        byte[] key = "testHgetd".getBytes();
        byte[] field = "fieldHgetd".getBytes();
        ;
        byte[] value = "valueHgetd".getBytes();
        redisClientTemplate.hset(key, field, value);
        byte[] append = redisClientTemplate.hget(key, field);

        Assert.notNull(append);
    }

    /**
     * Run the Map<String, String> hgetAll(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHgetAlla() throws Exception {
        ;
        String key = "testHgetAlla";
        String field = "fieldHgetAlla";
        String value = "1322";
        redisClientTemplate.hset(key, field, value);
        Map<String, String> append = redisClientTemplate.hgetAll(key);

        Assert.notNull(append);
    }

    /**
     * Run the Map<String, String> hgetAll(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHgetAllb() throws Exception {
        ;
        String key = "testHgetAllb";
        String field = "fieldHgetAllb";
        String value = "1342";
        redisClientTemplate.hset(key, field, value);
        Map<String, String> append = redisClientTemplate.hgetAll(key);

        Assert.notNull(append);
    }

    /**
     * Run the Map<byte[], byte[]> hgetAll(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHgetAllc() throws Exception {
        ;
        byte[] key = "testHgetAllc".getBytes();
        byte[] field = "fieldHgetAllc".getBytes();
        byte[] value = "valueHgetAllc".getBytes();
        redisClientTemplate.hsetnx(key, field, value);
        Map<byte[], byte[]> append = redisClientTemplate.hgetAll(key);

        Assert.notNull(append);
    }

    /**
     * Run the Map<byte[], byte[]> hgetAll(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHgetAlld() throws Exception {
        ;
        byte[] key = "testHgetAllc".getBytes();

        Map<byte[], byte[]> append = redisClientTemplate.hgetAll(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long hincrBy(String,String,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHincrBy() throws Exception {
        ;
        String key = "testHincrBy";
        String field = "fieldHincrBy";
        long value = 1L;
        redisClientTemplate.hincrBy(key, field, value);

    }

    /**
     * Run the Long hincrBy(String,String,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHincrByb() throws Exception {
        ;
        String key = "testHincrByb";
        String field = "fieldHincrByb";
        long value = 1L;

        Long append = redisClientTemplate.hincrBy(key, field, value);

        Assert.notNull(append);
    }

    /**
     * Run the Long hincrBy(byte[],byte[],long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHincrByc() throws Exception {
        ;
        byte[] key = "testHincrByc".getBytes();
        byte[] field = "valueHincrByc".getBytes();
        long value = 1L;

        Long append = redisClientTemplate.hincrBy(key, field, value);

        Assert.notNull(append);
    }

    /**
     * Run the Set<String> hkeys(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHkeys() throws Exception {
        ;
        String key = "testHkeys";
        String field = "foo";
        String value = "test";
        redisClientTemplate.hset(key, field, value);
        Set<String> append = redisClientTemplate.hkeys(key);

        Assert.notNull(append);
    }

    /**
     * Run the Set<String> hkeys(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHkeysb() throws Exception {
        ;
        String key = "testHkeys";
        Set<String> append = redisClientTemplate.hkeys(key);

        Assert.notNull(append);
    }

    /**
     * Run the Set<byte[]> hkeys(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHkeysc() throws Exception {
        ;
        byte[] key = "testHkeys".getBytes();
        byte[] field = "test".getBytes();
        byte[] value = "test".getBytes();
        redisClientTemplate.hset(key, field, value);
        Set<byte[]> append = redisClientTemplate.hkeys(key);

        Assert.notNull(append);
    }

    /**
     * Run the Set<byte[]> hkeys(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHkeyss() throws Exception {
        ;
        byte[] key = "testHkeyss".getBytes();
        byte[] field = "test".getBytes();
        byte[] value = "valueHkeyss".getBytes();
        redisClientTemplate.hset(key, field, value);
        Set<byte[]> append = redisClientTemplate.hkeys(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long hlen(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHlena() throws Exception {
        ;
        String key = "myhash";
        Long append = redisClientTemplate.hlen(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long hlen(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHlenb() throws Exception {
        ;
        String key = "myhash";
        String field = "field1";
        String value = "foo";
        redisClientTemplate.hset(key, field, value);
        Long append = redisClientTemplate.hlen(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long hlen(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHlenc() throws Exception {
        ;
        byte[] key = "myhash".getBytes();
        byte[] field = "field1".getBytes();
        byte[] value = "foo".getBytes();
        redisClientTemplate.hset(key, field, value);
        Long append = redisClientTemplate.hlen(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long hlen(byte[]) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 17-9-26 下午4:03
     */
    @Test
    public void testHlend() throws Exception {
        ;
        byte[] key = "myhash".getBytes();
        Long append = redisClientTemplate.hlen(key);

        Assert.notNull(append);
    }

    /**
     * Run the List<String> hmget(String,String[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHmgeta() throws Exception {
        ;
        String key = "testHmgeta";
        String field = "fieldHmgeta";
        String value = "valueHmgeta";
        redisClientTemplate.hset(key, field, value);

    }

    /**
     * Run the List<String> hmget(String,String[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHmgetb() throws Exception {
        ;
        String key = "testHmgetb";
        String field = "fieldHmgetb";
        String value = "valueHmgetb";
        redisClientTemplate.hset(key, field, value);

    }

    /**
     * Run the List<byte[]> hmget(byte[],byte[][]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHmgetc() throws Exception {
        byte[] key = "testHmgetc".getBytes();
        byte[] field = "fieldHmgetc".getBytes();
        byte[] value = "valueHmgetc".getBytes();
        redisClientTemplate.hset(key, field, value);

    }

    /**
     * Run the List<byte[]> hmget(byte[],byte[][]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHmgetd() throws Exception {
        byte[] key = "testHmgetd".getBytes();
        Map<byte[], byte[]> hash = new HashMap<byte[], byte[]>();
        hash.put("fieldHmgetd".getBytes(), "valueHmgetd".getBytes());
        redisClientTemplate.hmset(key, hash);
        redisClientTemplate.hmget(key);
    }

    /**
     * Run the String hmset(String,Map<String,String>) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHmseta() throws Exception {
        String key = "testHmseta";
        Map<String, String> hash = new HashMap<String, String>();
        hash.put("fieldHmseta", "valueHmseta");
        String append = redisClientTemplate.hmset(key, hash);

        Assert.notNull(append);
    }

    /**
     * Run the String hmset(String,Map<String,String>) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHmsetb() throws Exception {
        String key = "testHmsetb";
        Map<String, String> hash = new HashMap<String, String>();
        hash.put("fieldHmsetb", "valueHmsetb");
        String append = redisClientTemplate.hmset(key, hash);

        Assert.notNull(append);
    }

    /**
     * Run the String hmset(byte[],Map<byte[],byte[]>) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHmsetc() throws Exception {
        byte[] key = "testHmsetc".getBytes();
        Map<byte[], byte[]> hash = new HashMap<byte[], byte[]>();
        hash.put("fieldHmsetc".getBytes(), "valueHmsetc".getBytes());
        String append = redisClientTemplate.hmset(key, hash);

        Assert.notNull(append);
    }

    /**
     * Run the String hmset(byte[],Map<byte[],byte[]>) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHmsetd() throws Exception {
        byte[] key = "testHmsetd".getBytes();
        Map<byte[], byte[]> hash = new HashMap<byte[], byte[]>();
        hash.put("fieldHmsetd".getBytes(), "valueHmsetd".getBytes());
        String append = redisClientTemplate.hmset(key, hash);

        Assert.notNull(append);
    }

    /**
     * Run the Long hset(String,String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHseta() throws Exception {
        String key = "testHseta";
        String field = "fieldHseta";
        String value = "valueHseta";

        Long append = redisClientTemplate.hset(key, field, value);

        Assert.notNull(append);
    }

    /**
     * Run the Long hset(String,String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHsetb() throws Exception {
        String key = "testHsetb";
        String field = "fieldHsetb";
        String value = "valueHsetb";

        Long append = redisClientTemplate.hset(key, field, value);

        Assert.notNull(append);
    }

    /**
     * Run the Long hset(byte[],byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHsetc() throws Exception {
        ;
        byte[] key = "testHsetc".getBytes();
        byte[] field = "fieldHsetc".getBytes();
        byte[] value = "valueHsetc".getBytes();

        Long append = redisClientTemplate.hset(key, field, value);

        Assert.notNull(append);
    }

    /**
     * Run the Long hset(byte[],byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHsetd() throws Exception {
        byte[] key = "testHsetd".getBytes();
        byte[] field = "fieldHsetd".getBytes();
        byte[] value = "valueHsetd".getBytes();

        Long append = redisClientTemplate.hset(key, field, value);

        Assert.notNull(append);
    }

    /**
     * Run the Long hsetnx(String,String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHsetnxa() throws Exception {
        ;
        String key = "testHsetnxa";
        String field = "fieldHsetnxa";
        String value = "valueHsetnxa";

        Long append = redisClientTemplate.hsetnx(key, field, value);

        Assert.notNull(append);
    }

    /**
     * Run the Long hsetnx(String,String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHsetnxb() throws Exception {
        ;
        String key = "testHsetnxb";
        String field = "fieldHsetnxb";
        String value = "valueHsetnxb";

        Long append = redisClientTemplate.hsetnx(key, field, value);

        Assert.notNull(append);
    }

    /**
     * Run the Long hsetnx(byte[],byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHsetnxc() throws Exception {
        byte[] key = "testHsetnxc".getBytes();
        byte[] field = "fieldHsetnxc".getBytes();
        byte[] value = "valueHsetnxc".getBytes();

        Long append = redisClientTemplate.hsetnx(key, field, value);

        Assert.notNull(append);
    }

    /**
     * Run the Long hsetnx(byte[],byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHsetnxd() throws Exception {
        byte[] key = "testHsetnxd".getBytes();
        byte[] field = "fieldHsetnxd".getBytes();
        byte[] value = "valueHsetnxd".getBytes();

        Long append = redisClientTemplate.hsetnx(key, field, value);

        Assert.notNull(append);
    }

    /**
     * Run the List<String> hvals(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHvalsa() throws Exception {
        String key = "testHvalsa";
        String field = "fieldHvalsa";
        String value = "valueHvalsa";
        redisClientTemplate.hset(key, field, value);
        List<String> append = redisClientTemplate.hvals(key);

        Assert.notNull(append);
    }

    /**
     * Run the List<String> hvals(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHvalsb() throws Exception {

        String key = "testHvalsb";
        String field = "fieldHvalsb";
        String value = "valueHvalsb";
        redisClientTemplate.hset(key, field, value);
        List<String> append = redisClientTemplate.hvals(key);

        Assert.notNull(append);
    }

    /**
     * Run the Collection<byte[]> hvals(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHvalsc() throws Exception {

        byte[] key = "testHvalsc".getBytes();
        byte[] field = "fieldHvalsc".getBytes();
        byte[] value = "valueHvalsc".getBytes();
        redisClientTemplate.hset(key, field, value);
        Collection<byte[]> append = redisClientTemplate.hvals(key);

        Assert.notNull(append);
    }

    /**
     * Run the Collection<byte[]> hvals(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHvalsd() throws Exception {

        byte[] key = "testHvalsd".getBytes();
        byte[] field = "fieldHvalsd".getBytes();
        byte[] value = "valueHvalsd".getBytes();
        redisClientTemplate.hset(key, field, value);
        Collection<byte[]> append = redisClientTemplate.hvals(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long incr(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testIncra() throws Exception {
        String key = "testIncra";
        redisClientTemplate.set(key, "2020");
        Long append = redisClientTemplate.incr(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long incr(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testIncrb() throws Exception {
        String key = "testIncrb";
        redisClientTemplate.set(key, "2037");
        Long append = redisClientTemplate.incr(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long incr(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testIncr() throws Exception {
        byte[] key = "testIncr".getBytes();
        byte[] value = "2049".getBytes();
        redisClientTemplate.set(key, value);
        Long append = redisClientTemplate.incr(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long incrBy(String,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testIncrBya() throws Exception {
        String key = "testIncrBya";
        long integer = 1L;
        redisClientTemplate.set(key, "2095");
        Long append = redisClientTemplate.incrBy(key, integer);

        Assert.notNull(append);
    }

    /**
     * Run the Long incrBy(String,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testIncrByb() throws Exception {
        String key = "testIncrByb";
        long integer = 1L;
        redisClientTemplate.set(key, "2114");
        Long append = redisClientTemplate.incrBy(key, integer);

        Assert.notNull(append);
    }

    /**
     * Run the Long incrBy(byte[],long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testIncrByc() throws Exception {
        byte[] key = "testIncrByc".getBytes();
        long integer = 2069;

        Long append = redisClientTemplate.incrBy(key, integer);

        Assert.notNull(append);
    }

    /**
     * Run the Long incrBy(byte[],long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void append() throws Exception {
        ;
        byte[] key = "append".getBytes();
        long integer = 2088;

        redisClientTemplate.incrBy(key, integer);

    }

    /**
     * Run the String lindex(String,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLindexa() throws Exception {
        ;
        String key = "testLindexa";
        long index = 1L;

        redisClientTemplate.lindex(key, index);

    }

    /**
     * Run the String lindex(String,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLindexb() throws Exception {
        ;
        String key = "testLindexb";
        long index = 1L;
        redisClientTemplate.lpush(key, "helloTest");
        redisClientTemplate.lindex(key, index);

    }

    /**
     * Run the byte[] lindex(byte[],int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLindexc() throws Exception {
        byte[] key = "testLindexc".getBytes();
        int index = 1;
        redisClientTemplate.lpush(key, "helloTest".getBytes());
        redisClientTemplate.lindex(key, index);

    }

    /**
     * Run the byte[] lindex(byte[],int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLindexd() throws Exception {
        byte[] key = "testLindexd".getBytes();
        int index = 1;

        redisClientTemplate.lindex(key, index);

    }

    /**
     * Run the Long linsert(String,LIST_POSITION,String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLinserta() throws Exception {
        String key = "testLinserta";
        redis.clients.jedis.BinaryClient.LIST_POSITION where = redis.clients.jedis.BinaryClient.LIST_POSITION.AFTER;
        String pivot = "pivotLinserta";
        String value = "valueLinserta";

        redisClientTemplate.linsert(key, where, pivot, value);

    }

    /**
     * Run the Long linsert(String,LIST_POSITION,String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLinsertb() throws Exception {
        String key = "testLinsertb";
        redis.clients.jedis.BinaryClient.LIST_POSITION where = redis.clients.jedis.BinaryClient.LIST_POSITION.AFTER;
        String pivot = "pivottestLinsertb";
        String value = "value";
        redisClientTemplate.rpush(key, "test");
        redisClientTemplate.linsert(key, where, pivot, value);

    }

    /**
     * Run the Long linsert(byte[],LIST_POSITION,byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLinsertc() throws Exception {
        byte[] key = "testLinsertc".getBytes();
        redis.clients.jedis.BinaryClient.LIST_POSITION where = redis.clients.jedis.BinaryClient.LIST_POSITION.AFTER;
        byte[] pivot = "pivotLinsertc".getBytes();
        byte[] value = "valueLinsertc".getBytes();

        redisClientTemplate.linsert(key, where, pivot, value);
        redisClientTemplate.del(key);

    }

    /**
     * Run the Long linsert(byte[],LIST_POSITION,byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLinsertd() throws Exception {
        byte[] key = "testLinsertd".getBytes();
        redis.clients.jedis.BinaryClient.LIST_POSITION where = redis.clients.jedis.BinaryClient.LIST_POSITION.AFTER;
        byte[] pivot = "pivotLinsertd".getBytes();
        byte[] value = "valueLinsertd".getBytes();

        redisClientTemplate.linsert(key, where, pivot, value);
        redisClientTemplate.del(key);
    }

    /**
     * Run the Long llen(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLlena() throws Exception {
        ;
        String key = "testLlena";
        redisClientTemplate.rpush(key, "valueLlena");
        Long append = redisClientTemplate.llen(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long llen(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLlenb() throws Exception {
        ;
        String key = "testLlenb";
        redisClientTemplate.rpush(key, "valueLlenb");
        Long append = redisClientTemplate.llen(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long llen(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLlenc() throws Exception {
        ;
        byte[] key = "testLlenc".getBytes();
        redisClientTemplate.rpush(key, "valueLlenc".getBytes());
        Long append = redisClientTemplate.llen(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long llen(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLlend() throws Exception {
        ;
        byte[] key = "testLlend".getBytes();
        redisClientTemplate.rpush(key, "valueLlend".getBytes());
        Long append = redisClientTemplate.llen(key);

        Assert.notNull(append);
    }

    /**
     * Run the String lpop(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLpopa() throws Exception {
        ;
        String key = "testLlend";
        redisClientTemplate.rpush(key, "valueLpopa");
        String append = redisClientTemplate.lpop(key);

        Assert.notNull(append);
    }

    /**
     * Run the String lpop(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLpopb() throws Exception {
        ;
        String key = "testLpopb";
        redisClientTemplate.rpush(key, "valueLpopb");
        String append = redisClientTemplate.lpop(key);

        Assert.notNull(append);
    }

    /**
     * Run the byte[] lpop(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLpopc() throws Exception {

        byte[] key = "testLlenc".getBytes();
        redisClientTemplate.rpush(key, "valueLlenc".getBytes());
        byte[] append = redisClientTemplate.lpop(key);

        Assert.notNull(append);
    }

    /**
     * Run the byte[] lpop(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLpopd() throws Exception {
        ;
        byte[] key = "testLpopd".getBytes();
        redisClientTemplate.rpush(key, "fieldLpopd".getBytes());
        byte[] append = redisClientTemplate.lpop(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long lpush(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLpusha() throws Exception {
        ;
        String key = "testLpusha";
        String string = "valueLpusha";

        Long append = redisClientTemplate.lpush(key, string);

        Assert.notNull(append);
    }

    /**
     * Run the Long lpush(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLpush() throws Exception {
        ;
        String key = "testLpush";
        String string = "valueLpush";

        Long append = redisClientTemplate.lpush(key, string);

        Assert.notNull(append);
    }

    /**
     * Run the Long lpush(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLpushc() throws Exception {
        ;
        byte[] key = "testLpushc".getBytes();
        byte[] string = "valueLpushc".getBytes();

        Long append = redisClientTemplate.lpush(key, string);

        Assert.notNull(append);
    }

    /**
     * Run the Long lpush(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLpushd() throws Exception {
        ;
        byte[] key = "testLpushd".getBytes();
        byte[] string = "valueLpushd".getBytes();

        Long append = redisClientTemplate.lpush(key, string);

        Assert.notNull(append);
    }

    /**
     * Run the List<String> lrange(String,long,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLrangea() throws Exception {
        ;
        String key = "testLrangea";
        long start = 1L;
        long end = 1L;

        redisClientTemplate.lrange(key, start, end);

    }

    /**
     * Run the List<String> lrange(String,long,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLrangeb() throws Exception {
        ;
        String key = "testLrangeb";
        long start = 1L;
        long end = 1L;

        redisClientTemplate.lrange(key, start, end);

    }

    /**
     * Run the List<byte[]> lrange(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLrangec() throws Exception {
        ;
        byte[] key = "testLrangec".getBytes();
        int start = 1;
        int end = 1;

        redisClientTemplate.lrange(key, start, end);

    }

    /**
     * Run the List<byte[]> lrange(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLranged() throws Exception {
        ;
        byte[] key = "testLranged".getBytes();
        int start = 1;
        int end = 1;

        redisClientTemplate.lrange(key, start, end);

    }

    /**
     * Run the Long lrem(String,long,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLrema() throws Exception {
        ;
        String key = "testLrema";
        long count = 1L;
        String value = "valueLrema";
        redisClientTemplate.rpush(key, value);
        redisClientTemplate.lrem(key, count, value);

    }

    /**
     * Run the Long lrem(String,long,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLremb() throws Exception {
        ;
        String key = "testLremb";
        long count = 1L;
        String value = "valueLremb";
        redisClientTemplate.rpush(key, value);
        redisClientTemplate.lrem(key, count, value);

    }

    /**
     * Run the Long lrem(byte[],int,byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLremc() throws Exception {
        ;
        byte[] key = "testLremc".getBytes();
        int count = 1;
        byte[] value = "valueLremc".getBytes();

        Long append = redisClientTemplate.lrem(key, count, value);

        Assert.notNull(append);
    }

    /**
     * Run the Long lrem(byte[],int,byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLremd() throws Exception {
        ;
        byte[] key = "testLremd".getBytes();
        int count = 1;
        byte[] value = "valueLremd".getBytes();

        Long append = redisClientTemplate.lrem(key, count, value);

        Assert.notNull(append);
    }

    /**
     * Run the String lset(byte[],int,byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLset() throws Exception {
        ;
        byte[] key = "testLremc".getBytes();
        int index = 1;
        byte[] value = "valueLremc".getBytes();
        redisClientTemplate.rpush(key, "2621".getBytes());
        redisClientTemplate.lset(key, index, value);

    }

    /**
     * Run the String ltrim(String,long,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLtrima() throws Exception {
        ;
        String key = "testLtrima";
        long start = 1;
        long end = -1;
        redisClientTemplate.rpush(key, "valueLtrima");
        String append = redisClientTemplate.ltrim(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the String ltrim(String,long,long) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLtrimb() throws Exception {
        ;
        String key = "testLtrimb";
        String member = "valueLtrimb";
        long start = 1;
        long end = -1;
        redisClientTemplate.rpush(key, member);
        String append = redisClientTemplate.ltrim(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the String ltrim(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLtrimc() throws Exception {
        ;
        byte[] key = "testLtrimc".getBytes();
        int start = 1;
        int end = -1;
        byte[] member = "valueLtrimc".getBytes();
        redisClientTemplate.rpush(key, member);
        String append = redisClientTemplate.ltrim(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the String ltrim(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testLtrimd() throws Exception {
        ;
        byte[] key = "testLtrimd".getBytes();
        byte[] member = "valueLtrimd".getBytes();
        int start = 1;
        int end = -1;
        redisClientTemplate.rpush(key, member);
        String append = redisClientTemplate.ltrim(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the List<Object> pipelined(ShardedJedisPipeline) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testPipelineda() throws Exception {
        ;
        ShardedJedisPipeline shardedJedisPipeline = new ShardedJedisPipeline();

        List<Object> append = redisClientTemplate.pipelined(shardedJedisPipeline);

        Assert.notNull(append);
    }

    /**
     * Run the List<Object> pipelined(ShardedJedisPipeline) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testPipelinedb() throws Exception {
        ;
        ShardedJedisPipeline shardedJedisPipeline = new ShardedJedisPipeline();

        List<Object> append = redisClientTemplate.pipelined(shardedJedisPipeline);

        Assert.notNull(append);
    }

    /**
     * Run the void remUserList(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testRemUserLista() throws Exception {
        ;
        String userId = "2";

        redisClientTemplate.remUserList(userId);

    }

    /**
     * Run the String rpop(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testRpopa() throws Exception {
        ;
        String key = "testRpopa";
        String value = "valueRpopa";
        redisClientTemplate.rpush(key, value);
        String append = redisClientTemplate.rpop(key);

        Assert.notNull(append);
    }

    /**
     * Run the String rpop(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testRpopb() throws Exception {
        ;
        String key = "testRpopb";
        String value = "valueRpopb";
        redisClientTemplate.rpush(key, value);
        String append = redisClientTemplate.rpop(key);

        Assert.notNull(append);
    }

    /**
     * Run the byte[] rpop(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testRpopc() throws Exception {
        ;
        byte[] key = "testRpopc".getBytes();
        byte[] value = "valueRpopc".getBytes();
        redisClientTemplate.rpush(key, value);
        byte[] append = redisClientTemplate.rpop(key);

        Assert.notNull(append);
    }

    /**
     * Run the byte[] rpop(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testRpopd() throws Exception {
        ;
        byte[] key = "testRpopd".getBytes();
        byte[] value = "valueRpopd".getBytes();
        redisClientTemplate.rpush(key, value);
        byte[] append = redisClientTemplate.rpop(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long rpush(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testRpusha() throws Exception {
        ;
        String key = "testRpusha";
        String string = "valueRpusha";

        Long append = redisClientTemplate.rpush(key, string);

        Assert.notNull(append);
    }

    /**
     * Run the Long rpush(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testRpushb() throws Exception {
        ;
        String key = "testRpushb";
        String string = "valueRpushb";

        Long append = redisClientTemplate.rpush(key, string);

        Assert.notNull(append);
    }

    /**
     * Run the Long rpush(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testRpushc() throws Exception {
        byte[] key = "testRpushc".getBytes();
        byte[] string = "valueRpushc".getBytes();

        Long append = redisClientTemplate.rpush(key, string);

        Assert.notNull(append);
    }

    /**
     * Run the Long rpush(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testRpushd() throws Exception {
        ;
        byte[] key = "testRpushd".getBytes();
        byte[] string = "valueRpushd".getBytes();

        Long append = redisClientTemplate.rpush(key, string);

        Assert.notNull(append);
    }

    /**
     * Run the Long sadd(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSadda() throws Exception {
        ;
        String key = "testSadda";
        String member = "valueSadda";

        Long append = redisClientTemplate.sadd(key, member);

        Assert.notNull(append);
    }

    /**
     * Run the Long sadd(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSaddb() throws Exception {
        ;
        String key = "testSaddb";
        String member = "valueSaddb";

        Long append = redisClientTemplate.sadd(key, member);

        Assert.notNull(append);
    }

    /**
     * Run the Long sadd(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSaddc() throws Exception {
        ;
        byte[] key = "testSaddc".getBytes();
        byte[] member = "valueSaddc".getBytes();

        Long append = redisClientTemplate.sadd(key, member);

        Assert.notNull(append);
    }

    /**
     * Run the Long sadd(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSaddd() throws Exception {
        ;
        byte[] key = "testSaddd".getBytes();
        byte[] member = "valueSaddd".getBytes();

        Long append = redisClientTemplate.sadd(key, member);

        Assert.notNull(append);
    }

    /**
     * Run the Long scard(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testScarda() throws Exception {
        ;
        String key = "testScarda";
        String member = "valueScarda";
        redisClientTemplate.sadd(key, member);
        Long append = redisClientTemplate.scard(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long scard(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testScardb() throws Exception {
        ;
        String key = "testScardb";
        String member = "valueScardb";
        redisClientTemplate.sadd(key, member);
        Long append = redisClientTemplate.scard(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long scard(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testScardc() throws Exception {
        ;
        byte[] key = "testScardc".getBytes();
        byte[] member = "valueScardc".getBytes();
        redisClientTemplate.sadd(key, member);
        Long append = redisClientTemplate.scard(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long scard(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testScardd() throws Exception {
        ;
        byte[] key = "testScardd".getBytes();
        byte[] member = "valueScardd".getBytes();
        redisClientTemplate.sadd(key, member);
        Long append = redisClientTemplate.scard(key);

        Assert.notNull(append);
    }

    /**
     * Run the String set(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSeta() throws Exception {
        ;
        String key = "testSeta";
        String value = "valueSeta";

        String append = redisClientTemplate.set(key, value);

        Assert.notNull(append);
    }

    /**
     * Run the String set(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetb() throws Exception {
        ;
        String key = "testSetb";
        String value = "valueSetb";

        String append = redisClientTemplate.set(key, value);

        Assert.notNull(append);
    }

    /**
     * Run the String set(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetc() throws Exception {
        ;
        byte[] key = "testSetc".getBytes();
        byte[] value = "valueSetc".getBytes();

        String append = redisClientTemplate.set(key, value);

        Assert.notNull(append);
    }

    /**
     * Run the String set(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetd() throws Exception {
        ;
        byte[] key = "testSetd".getBytes();
        byte[] value = "valueSetd".getBytes();

        String append = redisClientTemplate.set(key, value);

        Assert.notNull(append);
    }

    /**
     * Run the String setEntity(String,Object) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetEntitya() throws Exception {
        ;
        String key = "testSetEntitya";
        SysMenus sysMenus = new SysMenus();
        sysMenus.setParentId(0);
        sysMenus.setMenuName("测试");
        sysMenus.setMenuId(1);
        redisClientTemplate.setEntity(key, sysMenus);
    }

    /**
     * Run the boolean setbit(String,long,boolean) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetbita() throws Exception {
        ;
        String key = "testSetbita";
        long offset = 1L;
        boolean value = true;

        redisClientTemplate.setbit(key, offset, value);

    }

    /**
     * Run the boolean setbit(String,long,boolean) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetbitb() throws Exception {
        ;
        String key = "testSetbitb";
        long offset = 2L;
        boolean value = true;

        redisClientTemplate.setbit(key, offset, value);

    }

    /**
     * Run the boolean setbit(String,long,boolean) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetbitc() throws Exception {
        ;
        String key = "testSetbitc";
        long offset = 1L;
        boolean value = true;

        redisClientTemplate.setbit(key, offset, value);

    }

    /**
     * Run the boolean setbit(String,long,boolean) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetbitd() throws Exception {
        ;
        String key = "testSetbitd";
        long offset = 1L;
        boolean value = true;

        redisClientTemplate.setbit(key, offset, value);

    }

    /**
     * Run the String setex(String,int,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetexa() throws Exception {
        ;
        String key = "testSetexa";
        int seconds = 1;
        String value = "valueSetexa";

        String append = redisClientTemplate.setex(key, seconds, value);

        Assert.notNull(append);
    }

    /**
     * Run the String setex(String,int,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetexb() throws Exception {
        ;
        String key = "testSetexb";
        int seconds = 1;
        String value = "valueSetexb";

        String append = redisClientTemplate.setex(key, seconds, value);

        Assert.notNull(append);
    }

    /**
     * Run the String setex(byte[],int,byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetexc() throws Exception {
        ;
        byte[] key = "testSetexc".getBytes();
        int seconds = 1;
        byte[] value = "valueSetexc".getBytes();

        String append = redisClientTemplate.setex(key, seconds, value);

        Assert.notNull(append);
    }

    /**
     * Run the String setex(byte[],int,byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetexd() throws Exception {
        ;
        byte[] key = "testSetexd".getBytes();
        int seconds = 1;
        byte[] value = "valueSetexd".getBytes();

        String append = redisClientTemplate.setex(key, seconds, value);

        Assert.notNull(append);
    }

    /**
     * Run the Long setnx(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetnxa() throws Exception {
        ;
        String key = "testSetnxa";
        String value = "valueSetnxa";

        Long append = redisClientTemplate.setnx(key, value);

        Assert.notNull(append);
    }

    /**
     * Run the Long setnx(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetnxb() throws Exception {
        ;
        String key = "testSetnxb";
        String value = "valueSetnxb";

        Long append = redisClientTemplate.setnx(key, value);

        Assert.notNull(append);
    }

    /**
     * Run the Long setnx(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetnxc() throws Exception {
        ;
        byte[] key = "testSetnxc".getBytes();
        byte[] value = "valueSetnxc".getBytes();

        Long append = redisClientTemplate.setnx(key, value);

        Assert.notNull(append);
    }

    /**
     * Run the Long setnx(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetnxd() throws Exception {
        ;
        byte[] key = "testSetnxd".getBytes();
        byte[] value = "valueSetnxd".getBytes();

        Long append = redisClientTemplate.setnx(key, value);

        Assert.notNull(append);
    }

    /**
     * Run the long setrange(String,long,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetrangea() throws Exception {
        ;
        String key = "testSetrangea";
        long offset = 1L;
        String value = "valueSetrangea";

        long append = redisClientTemplate.setrange(key, offset, value);

        Assert.notNull(append);
    }

    /**
     * Run the long setrange(String,long,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetrangeb() throws Exception {
        ;
        String key = "testSetrangeb";
        long offset = 1L;
        String value = "valueSetrangeb";

        long append = redisClientTemplate.setrange(key, offset, value);

        Assert.notNull(append);
    }

    /**
     * Run the Boolean sismember(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSismembera() throws Exception {
        ;
        String key = "testSismembera";
        String member = "memberSismembera";

        Boolean append = redisClientTemplate.sismember(key, member);

        Assert.notNull(append);
    }

    /**
     * Run the Boolean sismember(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSismemberb() throws Exception {
        ;
        String key = "testSismemberb";
        String member = "memberSismemberb";

        Boolean append = redisClientTemplate.sismember(key, member);

        Assert.notNull(append);
    }

    /**
     * Run the Boolean sismember(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSismemberc() throws Exception {
        ;
        byte[] key = "testSismemberc".getBytes();
        byte[] member = "memberSismemberc".getBytes();
        redisClientTemplate.sadd(key, member);
        Boolean append = redisClientTemplate.sismember(key, member);

        Assert.notNull(append);
    }

    /**
     * Run the Boolean sismember(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSismemberd() throws Exception {
        ;
        byte[] key = "testSismemberd".getBytes();
        byte[] member = "memberSismemberd".getBytes();
        redisClientTemplate.sadd(key, member);
        Boolean append = redisClientTemplate.sismember(key, member);

        Assert.notNull(append);
    }

    /**
     * Run the Set<String> smembers(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSmembersa() throws Exception {
        String key = "testSmembersa";
        String member = "memberSmembersa";
        redisClientTemplate.sadd(key, "3498");
        redisClientTemplate.sadd(key, member);

    }

    /**
     * Run the Set<String> smembers(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSmembersb() throws Exception {
        String key = "testSmembersb";
        String member = "memberSmembersb";
        redisClientTemplate.sadd(key, member);
        redisClientTemplate.sadd(key, "3515");

    }

    /**
     * Run the List<String> sort(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSorta() throws Exception {
        String key = "testSorta";

        List<String> append = redisClientTemplate.sort(key);

        Assert.notNull(append);
    }

    /**
     * Run the List<String> sort(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSortb() throws Exception {
        ;
        String key = "testSortb";

        List<String> append = redisClientTemplate.sort(key);

        Assert.notNull(append);
    }

    /**
     * Run the List<byte[]> sort(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSortc() throws Exception {
        ;
        byte[] key = "testSortc".getBytes();

        List<byte[]> append = redisClientTemplate.sort(key);

        Assert.notNull(append);
        ;
    }

    /**
     * Run the List<byte[]> sort(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSortd() throws Exception {
        ;
        byte[] key = "testSortd".getBytes();

        List<byte[]> append = redisClientTemplate.sort(key);

        Assert.notNull(append);
    }

    /**
     * Run the List<String> sort(String,SortingParams) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSortf() throws Exception {
        String key = "testSortf";
        SortingParams sortingParameters = new SortingParams();

        List<String> append = redisClientTemplate.sort(key, sortingParameters);

        Assert.notNull(append);
    }

    /**
     * Run the List<String> sort(String,SortingParams) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSorth() throws Exception {
        ;
        String key = "testSorth";
        SortingParams sortingParameters = new SortingParams();

        List<String> append = redisClientTemplate.sort(key, sortingParameters);

        Assert.notNull(append);
    }

    /**
     * Run the List<byte[]> sort(byte[],SortingParams) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSortk() throws Exception {
        ;
        byte[] key = "testSortk".getBytes();
        SortingParams sortingParameters = new SortingParams();

        List<byte[]> append = redisClientTemplate.sort(key, sortingParameters);

        Assert.notNull(append);
    }

    /**
     * Run the List<byte[]> sort(byte[],SortingParams) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSortt() throws Exception {
        ;
        byte[] key = "testSortt".getBytes();
        SortingParams sortingParameters = new SortingParams();

        List<byte[]> append = redisClientTemplate.sort(key, sortingParameters);

        Assert.notNull(append);
    }

    /**
     * Run the String srandmember(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSrandmembera() throws Exception {
        ;
        String key = "testSrandmembera";
        String member = "memberSrandmembera";
        redisClientTemplate.sadd(key, member);
        String append = redisClientTemplate.srandmember(key);

        Assert.notNull(append);
    }

    /**
     * Run the String srandmember(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSrandmemberb() throws Exception {
        ;
        String key = "testSrandmemberb";
        String member = "memberSrandmemberb";
        redisClientTemplate.sadd(key, member);
        String append = redisClientTemplate.srandmember(key);

        Assert.notNull(append);
    }

    /**
     * Run the byte[] srandmember(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSrandmemberc() throws Exception {
        ;
        byte[] key = "testSrandmemberc".getBytes();
        byte[] member = "memberSrandmemberc".getBytes();
        redisClientTemplate.sadd(key, member);
        byte[] append = redisClientTemplate.srandmember(key);

        Assert.notNull(append);
    }

    /**
     * Run the byte[] srandmember(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSrandmemberd() throws Exception {
        ;
        byte[] key = "testSrandmemberd".getBytes();
        byte[] member = "memberSrandmemberc".getBytes();
        redisClientTemplate.sadd(key, member);
        byte[] append = redisClientTemplate.srandmember(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long srem(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSrema() throws Exception {
        ;
        String key = "testSrema";
        String member = "memberSrema";

        Long append = redisClientTemplate.srem(key, member);

        Assert.notNull(append);
    }

    /**
     * Run the Long srem(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSremb() throws Exception {
        String key = "testSremb";
        String member = "memberSremb";

        Long append = redisClientTemplate.srem(key, member);

        Assert.notNull(append);
    }

    /**
     * Run the Long srem(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSremc() throws Exception {
        ;
        byte[] key = "testSremc".getBytes();
        byte[] member = "memberSremc".getBytes();
        redisClientTemplate.sadd(key, member);
        Long append = redisClientTemplate.srem(key, member);

        Assert.notNull(append);
    }

    /**
     * Run the Long srem(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSremd() throws Exception {
        ;
        byte[] key = "testSremd".getBytes();
        byte[] member = "member".getBytes();
        redisClientTemplate.sadd(key, member);
        Long append = redisClientTemplate.srem(key, member);

        Assert.notNull(append);
    }

    /**
     * Run the String substr(String,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSubstra() throws Exception {
        ;
        String key = "testSubstra";
        int start = 1;
        int end = 1;
        redisClientTemplate.set(key, "valueSubstra");
        String append = redisClientTemplate.substr(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the String substr(String,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSubstrb() throws Exception {
        ;
        String key = "testSubstrb";
        int start = 1;
        int end = 1;
        redisClientTemplate.set(key, "valueSubstrb");
        String append = redisClientTemplate.substr(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the byte[] substr(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSubstrc() throws Exception {
        ;
        byte[] key = "testSubstrc".getBytes();
        int start = 1;
        int end = 1;
        redisClientTemplate.set(key, "valueSubstrc".getBytes());
        byte[] append = redisClientTemplate.substr(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the byte[] substr(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSubstrd() throws Exception {
        ;
        byte[] key = "testSubstrd".getBytes();
        int start = 1;
        int end = 1;
        redisClientTemplate.set(key, "valueSubstrd".getBytes());
        byte[] append = redisClientTemplate.substr(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the Long ttl(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testTtla() throws Exception {
        ;
        byte[] key = "testTtla".getBytes();

        Long append = redisClientTemplate.ttl(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long ttl(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testTtlb() throws Exception {
        ;
        byte[] key = "testTtlb".getBytes();
        Long append = redisClientTemplate.ttl(key);

        Assert.notNull(append);
    }

    /**
     * Run the String type(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testTypea() throws Exception {
        ;
        String key = "testTypea";

        String append = redisClientTemplate.type(key);

        Assert.notNull(append);
    }

    /**
     * Run the String type(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testTypeb() throws Exception {
        ;
        String key = "testTypeb";

        String append = redisClientTemplate.type(key);

        Assert.notNull(append);
    }

    /**
     * Run the String type(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testTypec() throws Exception {
        byte[] key = "testTypec".getBytes();
        redisClientTemplate.set(key, "valueTypec".getBytes());
        String append = redisClientTemplate.type(key);

        Assert.notNull(append);
    }

    /**
     * Run the String type(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testTyped() throws Exception {
        byte[] key = "testTyped".getBytes();
        redisClientTemplate.set(key, "valueTyped".getBytes());
        String append = redisClientTemplate.type(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long zadd(String,double,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZadd() throws Exception {
        ;
        String key = "testZadd";
        double score = 1.0;
        String member = "memberZadd";

        Long append = redisClientTemplate.zadd(key, score, member);

        Assert.notNull(append);
    }

    /**
     * Run the Long zadd(String,double,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZaddb() throws Exception {
        String key = "testZaddb";
        double score = 1.0;
        String member = "memberZaddb";

        Long countZaddb = redisClientTemplate.zadd(key, score, member);
        assertNotNull(countZaddb);
    }

    /**
     * Run the Long zadd(byte[],double,byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZaddc() throws Exception {
        ;
        byte[] key = "testZaddc".getBytes();
        double score = 1.0;
        byte[] member = "memberZaddc".getBytes();

        Long append = redisClientTemplate.zadd(key, score, member);

        Assert.notNull(append);
    }

    /**
     * Run the Long zadd(byte[],double,byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZaddd() throws Exception {
        ;
        byte[] key = "testZaddd".getBytes();
        double score = 1.0;
        byte[] member = "memberZaddd".getBytes();

        Long append = redisClientTemplate.zadd(key, score, member);

        Assert.notNull(append);
    }

    /**
     * Run the Long zcard(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZcarda() throws Exception {
        ;
        String key = "testZcarda";
        String member = "valueZcarda";
        redisClientTemplate.zadd(key, 1, member);
        Long append = redisClientTemplate.zcard(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long zcard(String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZcardb() throws Exception {
        ;
        String key = "testZcardb";
        String member = "valueZcardb";
        redisClientTemplate.zadd(key, 2, member);
        Long append = redisClientTemplate.zcard(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long zcard(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZcardc() throws Exception {
        ;
        byte[] key = "testZcardc".getBytes();
        byte[] member = "valueZcardc".getBytes();
        redisClientTemplate.zadd(key, 4238, member);
        Long append = redisClientTemplate.zcard(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long zcard(byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZcardd() throws Exception {
        ;
        byte[] key = "testZcardd".getBytes();
        byte[] member = "valueZcardd".getBytes();
        redisClientTemplate.zadd(key, 4256, member);
        Long append = redisClientTemplate.zcard(key);

        Assert.notNull(append);
    }

    /**
     * Run the Long zcount(String,double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZcounta() throws Exception {
        ;
        String key = "testZcounta";
        String member = "memberZcounta";
        double min = 0;
        double max = 1.0;
        redisClientTemplate.zadd(key, 3500, member);
        Long append = redisClientTemplate.zcount(key, min, max);
        Assert.notNull(append);
    }

    /**
     * Run the Long zcount(String,double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZcountb() throws Exception {
        ;
        String key = "testZcountb";
        double min = 1.0;
        double max = 1.0;

        Long append = redisClientTemplate.zcount(key, min, max);

        Assert.notNull(append);
    }

    /**
     * Run the Long zcount(byte[],double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZcountc() throws Exception {
        ;
        byte[] key = "testZcountc".getBytes();
        double min = 1.0;
        double max = 1.0;

        Long append = redisClientTemplate.zcount(key, min, max);

        Assert.notNull(append);
    }

    /**
     * Run the Long zcount(byte[],double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZcountd() throws Exception {
        ;
        byte[] key = "testZcountd".getBytes();
        double min = 1.0;
        double max = 1.0;

        Long append = redisClientTemplate.zcount(key, min, max);
        Assert.notNull(append);
    }

    /**
     * Run the Double zincrby(String,double,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZincrbya() throws Exception {
        ;
        String key = "testZincrbya";
        double score = 1.0;
        String member = "memberZincrbya";
        redisClientTemplate.zadd(key, 10, member);
        Double append = redisClientTemplate.zincrby(key, score, member);
        Assert.notNull(append);
    }

    /**
     * Run the Double zincrby(String,double,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZincrbyb() throws Exception {
        ;
        String key = "testZincrbyb";
        double score = 1.0;
        String member = "memberZincrbyb";

        Double append = redisClientTemplate.zincrby(key, score, member);
        Assert.notNull(append);
    }

    /**
     * Run the Double zincrby(byte[],double,byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZincrbyc() throws Exception {
        ;
        byte[] key = "testZincrbyc".getBytes();
        double score = 1.0;
        byte[] member = "memberZincrbyc".getBytes();

        Double append = redisClientTemplate.zincrby(key, score, member);
        Assert.notNull(append);
    }

    /**
     * Run the Double zincrby(byte[],double,byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZincrbyd() throws Exception {
        ;
        byte[] key = "testZincrbyd".getBytes();
        double score = 1.0;
        byte[] member = "memberZincrbyd".getBytes();

        Double append = redisClientTemplate.zincrby(key, score, member);

        Assert.notNull(append);
    }

    /**
     * Run the Set<String> zrange(String,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangea() throws Exception {
        ;
        String key = "testZrangea";
        int start = 1;
        int end = 1;

        Set<String> append = redisClientTemplate.zrange(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the Set<String> zrange(String,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeb() throws Exception {
        ;
        String key = "testZrangeb";
        int start = 0;
        int end = 1;

        Set<String> append = redisClientTemplate.zrange(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Set<byte[]> zrange(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangec() throws Exception {
        ;
        byte[] key = "testZrangec".getBytes();
        int start = 0;
        int end = 3;

        Set<byte[]> append = redisClientTemplate.zrange(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Set<byte[]> zrange(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZranged() throws Exception {
        ;
        byte[] key = "testZranged".getBytes();
        int start = 1;
        int end = 4;

        Set<byte[]> append = redisClientTemplate.zrange(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Set<String> zrangeByScore(String,double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScorea() throws Exception {
        ;
        String key = "testZrangeByScorea";
        double min = 1.0;
        double max = 1.0;

        redisClientTemplate.zrangeByScore(key, min, max);

    }

    /**
     * Run the Set<String> zrangeByScore(String,double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScoreb() throws Exception {
        ;
        String key = "testZrangeByScoreb";
        double min = 1.0;
        double max = 1.0;

        redisClientTemplate.zrangeByScore(key, min, max);
    }

    /**
     * Run the Set<byte[]> zrangeByScore(byte[],double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScorec() throws Exception {
        ;
        byte[] key = "testZrangeByScorec".getBytes();
        double min = 1.0;
        double max = 1.0;

        redisClientTemplate.zrangeByScore(key, min, max);

    }

    /**
     * Run the Set<byte[]> zrangeByScore(byte[],double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScored() throws Exception {
        byte[] key = "testZrangeByScored".getBytes();
        double min = 1.0;
        double max = 1.0;

        redisClientTemplate.zrangeByScore(key, min, max);

    }

    /**
     * Run the Set<String> zrangeByScore(String,double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScoree() throws Exception {
        ;
        String key = "testZrangeByScoree";
        double min = 1.0;
        double max = 1.0;
        int offset = 1;
        int count = 1;

        redisClientTemplate.zrangeByScore(key, min, max, offset, count);

    }

    /**
     * Run the Set<String> zrangeByScore(String,double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScoref() throws Exception {
        ;
        String key = "testZrangeByScoref";
        double min = 1.0;
        double max = 1.0;
        int offset = 1;
        int count = 1;

        redisClientTemplate.zrangeByScore(key, min, max, offset, count);

    }

    /**
     * Run the Set<byte[]> zrangeByScore(byte[],double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScoreg() throws Exception {
        ;
        byte[] key = "testZrangeByScoreg".getBytes();
        double min = 1.0;
        double max = 1.0;
        int offset = 1;
        int count = 1;

        redisClientTemplate.zrangeByScore(key, min, max, offset, count);

    }

    /**
     * Run the Set<byte[]> zrangeByScore(byte[],double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScoreh() throws Exception {
        ;
        byte[] key = "testZrangeByScoreh".getBytes();
        double min = 1.0;
        double max = 1.0;
        int offset = 1;
        int count = 1;

        redisClientTemplate.zrangeByScore(key, min, max, offset, count);

    }

    /**
     * Run the Set<Tuple> zrangeByScoreWithScores(String,double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScoreWithScoresa() throws Exception {
        ;
        String key = "tom";
        double min = 1.0;
        double max = 1.0;
        redisClientTemplate.zadd(key, 5000, "salary");
        Set<Tuple> append = redisClientTemplate.zrangeByScoreWithScores(key, min, max);

        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrangeByScoreWithScores(String,double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScoreWithScoresb() throws Exception {
        ;
        String key = "peter";
        double min = 1.0;
        double max = 1.0;
        redisClientTemplate.zadd(key, 6000, "salary");
        Set<Tuple> append = redisClientTemplate.zrangeByScoreWithScores(key, min, max);
        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrangeByScoreWithScores(byte[],double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScoreWithScoresc() throws Exception {
        ;
        byte[] key = "peter".getBytes();
        byte[] member = "salary".getBytes();
        double min = 1.0;
        double max = 1.0;
        redisClientTemplate.zadd(key, 6000, member);
        Set<Tuple> append = redisClientTemplate.zrangeByScoreWithScores(key, min, max);

        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrangeByScoreWithScores(byte[],double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScoreWithScoresd() throws Exception {
        ;
        byte[] key = "peter".getBytes();
        ;
        double min = 1.0;
        double max = 1.0;

        Set<Tuple> append = redisClientTemplate.zrangeByScoreWithScores(key, min, max);
        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrangeByScoreWithScores(String,double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScoreWithScorese() throws Exception {
        ;
        String key = "tom";
        double min = 1.0;
        double max = 1.0;
        int offset = 1;
        int count = 1;
        Set<Tuple> append = redisClientTemplate.zrangeByScoreWithScores(key, min, max, offset,
                count);

        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrangeByScoreWithScores(String,double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScoreWithScoresf() throws Exception {
        ;
        String key = "tom";
        double min = 1.0;
        double max = 1.0;
        int offset = 1;
        int count = 1;

        Set<Tuple> append = redisClientTemplate.zrangeByScoreWithScores(key, min, max, offset,
                count);

        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrangeByScoreWithScores(byte[],double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScoreWithScoresh() throws Exception {
        ;
        byte[] key = "tom".getBytes();
        double min = 1.0;
        double max = 1.0;
        int offset = 1;
        int count = 1;

        Set<Tuple> append = redisClientTemplate.zrangeByScoreWithScores(key, min, max, offset,
                count);
        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrangeByScoreWithScores(byte[],double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeByScoreWithScorest() throws Exception {
        ;
        byte[] key = "tom".getBytes();
        double min = 1.0;
        double max = 1.0;
        int offset = 1;
        int count = 1;

        Set<Tuple> append = redisClientTemplate.zrangeByScoreWithScores(key, min, max, offset,
                count);
        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrangeWithScores(String,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeWithScoresa() throws Exception {
        ;
        String key = "tom";
        int start = 1;
        int end = 1;

        Set<Tuple> append = redisClientTemplate.zrangeWithScores(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrangeWithScores(String,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeWithScoresb() throws Exception {
        ;
        String key = "peter";
        int start = 1;
        int end = 1;

        Set<Tuple> append = redisClientTemplate.zrangeWithScores(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrangeWithScores(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeWithScoresc() throws Exception {
        ;
        byte[] key = "tom".getBytes();
        int start = 1;
        int end = 1;

        Set<Tuple> append = redisClientTemplate.zrangeWithScores(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrangeWithScores(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrangeWithScorese() throws Exception {
        ;
        byte[] key = "peter".getBytes();
        int start = 1;
        int end = 1;
        Set<Tuple> append = redisClientTemplate.zrangeWithScores(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the Long zrank(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZranka() throws Exception {
        String key = "testZranka";
        String member = "salary";
        redisClientTemplate.zadd(key, 4795, member);
        Long append = redisClientTemplate.zrank(key, member);
        Assert.notNull(append);
    };

    /**
     * Run the Long zrank(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrankb() throws Exception {
        String key = "test";
        String member = "testZrankb";
        redisClientTemplate.zadd(key, 4812, member);
        Long append = redisClientTemplate.zrank(key, member);
        Assert.notNull(append);
    }

    /**
     * Run the Long zrank(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrankc() throws Exception {
        byte[] key = "test".getBytes();
        byte[] member = "testZrankc".getBytes();
        redisClientTemplate.zadd(key, 4828, member);
        Long append = redisClientTemplate.zrank(key, member);
        Assert.notNull(append);
    }

    /**
     * Run the Long zrank(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrankd() throws Exception {
        byte[] key = "test".getBytes();
        byte[] member = "testZrankd".getBytes();
        redisClientTemplate.zadd(key, 4828, member);
        Long append = redisClientTemplate.zrank(key, member);

        Assert.notNull(append);
    }

    /**
     * Run the Long zrem(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrema() throws Exception {
        String key = "test";
        String member = "testZrema";
        redisClientTemplate.zadd(key, 4860, member);
        Long append = redisClientTemplate.zrem(key, member);

        Assert.notNull(append);
    }

    /**
     * Run the Long zrem(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZremb() throws Exception {
        ;
        String key = "testZremb";
        String member = "memberZremb";
        redisClientTemplate.zadd(key, 4873, member);
        Long append = redisClientTemplate.zrem(key, member);
        Assert.notNull(append);
    }

    /**
     * Run the Long zrem(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZremc() throws Exception {
        ;
        byte[] key = "testZremc".getBytes();
        byte[] member = "memberZremc".getBytes();
        redisClientTemplate.zadd(key, 4890, member);
        Long append = redisClientTemplate.zrem(key, member);
        Assert.notNull(append);
    }

    /**
     * Run the Long zrem(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZremd() throws Exception {
        ;
        byte[] key = "testZremd".getBytes();
        byte[] member = "memberZremd".getBytes();
        redisClientTemplate.zadd(key, 4907, member);
        Long append = redisClientTemplate.zrem(key, member);
        Assert.notNull(append);
    }

    /**
     * Run the Long zremrangeByRank(String,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZremrangeByRanka() throws Exception {
        ;
        String key = "testZremrangeByRanka";
        String member = "memberZremrangeByRanka";
        int start = 0;
        int end = 1;
        redisClientTemplate.zadd(key, 3500, member);
        Long append = redisClientTemplate.zremrangeByRank(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Long zremrangeByRank(String,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZremrangeByRankb() throws Exception {
        ;
        String key = "testZremrangeByRankb";
        String member = "memberZremrangeByRankb";
        int start = 0;
        int end = 1;
        redisClientTemplate.zadd(key, 5000, member);
        Long append = redisClientTemplate.zremrangeByRank(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Long zremrangeByRank(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZremrangeByRankc() throws Exception {
        ;
        byte[] key = "testZremrangeByRankc".getBytes();
        byte[] member = "memberZremrangeByRankc".getBytes();
        int start = 0;
        int end = 1;
        redisClientTemplate.zadd(key, 6500, member);
        Long append = redisClientTemplate.zremrangeByRank(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the Long zremrangeByRank(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZremrangeByRankd() throws Exception {
        ;
        byte[] key = "testZremrangeByRankd".getBytes();
        byte[] member = "memberZremrangeByRankc".getBytes();
        int start = 0;
        int end = 1;
        redisClientTemplate.zadd(key, 7500, member);
        Long append = redisClientTemplate.zremrangeByRank(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Long zremrangeByScore(String,double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZremrangeByScorea() throws Exception {
        ;
        String key = "tom";
        double start = 1.0;
        double end = 1.0;

        Long append = redisClientTemplate.zremrangeByScore(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Long zremrangeByScore(String,double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZremrangeByScoreb() throws Exception {
        ;
        String key = "peter";
        double start = 1.0;
        double end = 1.0;

        Long append = redisClientTemplate.zremrangeByScore(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the Long zremrangeByScore(byte[],double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZremrangeByScorec() throws Exception {
        ;
        byte[] key = "tom".getBytes();
        double start = 1.0;
        double end = 1.0;

        Long append = redisClientTemplate.zremrangeByScore(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Long zremrangeByScore(byte[],double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZremrangeByScored() throws Exception {
        ;
        byte[] key = "peter".getBytes();
        double start = 1.0;
        double end = 1.0;

        Long append = redisClientTemplate.zremrangeByScore(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Set<String> zrevrange(String,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangea() throws Exception {
        ;
        String key = "salary";
        int start = 1;
        int end = 1;

        Set<String> append = redisClientTemplate.zrevrange(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the Set<String> zrevrange(String,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeb() throws Exception {
        ;
        String key = "salary";
        int start = 1;
        int end = 1;

        Set<String> append = redisClientTemplate.zrevrange(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Set<byte[]> zrevrange(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangec() throws Exception {
        ;
        byte[] key = "salary".getBytes();
        int start = 1;
        int end = 1;

        Set<byte[]> append = redisClientTemplate.zrevrange(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the Set<byte[]> zrevrange(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevranged() throws Exception {
        ;
        byte[] key = "salary".getBytes();
        int start = 1;
        int end = 1;

        Set<byte[]> append = redisClientTemplate.zrevrange(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Set<String> zrevrangeByScore(String,double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScorea() throws Exception {
        String key = "tom";
        double max = 1.0;
        double min = 1.0;

        Set<String> append = redisClientTemplate.zrevrangeByScore(key, max, min);
        Assert.notNull(append);
    }

    /**
     * Run the Set<String> zrevrangeByScore(String,double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScoreb() throws Exception {
        ;
        String key = "peter";
        double max = 1.0;
        double min = 1.0;

        Set<String> append = redisClientTemplate.zrevrangeByScore(key, max, min);
        Assert.notNull(append);
    }

    /**
     * Run the Set<byte[]> zrevrangeByScore(byte[],double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScorec() throws Exception {
        byte[] key = "tom".getBytes();
        double max = 1.0;
        double min = 1.0;

        Set<byte[]> append = redisClientTemplate.zrevrangeByScore(key, max, min);

        Assert.notNull(append);
    }

    /**
     * Run the Set<byte[]> zrevrangeByScore(byte[],double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScored() throws Exception {
        byte[] key = "peter".getBytes();
        double max = 1.0;
        double min = 1.0;

        Set<byte[]> append = redisClientTemplate.zrevrangeByScore(key, max, min);
        Assert.notNull(append);
    }

    /**
     * Run the Set<String> zrevrangeByScore(String,double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScor() throws Exception {
        String key = "tom";
        double max = 1.0;
        double min = 1.0;
        int offset = 1;
        int count = 1;

        Set<String> append = redisClientTemplate.zrevrangeByScore(key, max, min, offset, count);

        Assert.notNull(append);
    }

    /**
     * Run the Set<String> zrevrangeByScore(String,double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScoref() throws Exception {
        ;
        String key = "tom";
        double max = 1.0;
        double min = 1.0;
        int offset = 1;
        int count = 1;

        Set<String> append = redisClientTemplate.zrevrangeByScore(key, max, min, offset, count);
        Assert.notNull(append);
    }

    /**
     * Run the Set<byte[]> zrevrangeByScore(byte[],double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScoreappend() throws Exception {
        byte[] key = "tom".getBytes();
        double max = 1.0;
        double min = 1.0;
        int offset = 1;
        int count = 1;

        Set<byte[]> append = redisClientTemplate.zrevrangeByScore(key, max, min, offset, count);

        Assert.notNull(append);
    }

    /**
     * Run the Set<byte[]> zrevrangeByScore(byte[],double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScoreg() throws Exception {
        byte[] key = "tom".getBytes();
        double max = 1.0;
        double min = 1.0;
        int offset = 1;
        int count = 1;

        Set<byte[]> append = redisClientTemplate.zrevrangeByScore(key, max, min, offset, count);
        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrevrangeByScoreWithScores(String,double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScoreWithScoresa() throws Exception {
        String key = "tom";
        double max = 1.0;
        double min = 1.0;

        Set<Tuple> append = redisClientTemplate.zrevrangeByScoreWithScores(key, max, min);
        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrevrangeByScoreWithScores(String,double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScoreWithScoresb() throws Exception {
        String key = "peter";
        double max = 1.0;
        double min = 1.0;

        Set<Tuple> append = redisClientTemplate.zrevrangeByScoreWithScores(key, max, min);
        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrevrangeByScoreWithScores(byte[],double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScoreWithScoresc() throws Exception {
        byte[] key = "tom".getBytes();
        double max = 1.0;
        double min = 1.0;

        Set<Tuple> append = redisClientTemplate.zrevrangeByScoreWithScores(key, max, min);
        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrevrangeByScoreWithScores(byte[],double,double) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScoreWithScoresd() throws Exception {
        byte[] key = "peter".getBytes();
        double max = 1.0;
        double min = 1.0;

        Set<Tuple> append = redisClientTemplate.zrevrangeByScoreWithScores(key, max, min);

        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrevrangeByScoreWithScores(String,double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScoreWithScorese() throws Exception {
        String key = "tom";
        double max = 1.0;
        double min = 1.0;
        int offset = 1;
        int count = 1;

        Set<Tuple> append = redisClientTemplate.zrevrangeByScoreWithScores(key, max, min, offset,
                count);

        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrevrangeByScoreWithScores(String,double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScoreWithScoresf() throws Exception {
        String key = "peter";
        double max = 1.0;
        double min = 1.0;
        int offset = 1;
        int count = 1;

        Set<Tuple> append = redisClientTemplate.zrevrangeByScoreWithScores(key, max, min, offset,
                count);

        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrevrangeByScoreWithScores(byte[],double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScoreWithScores() throws Exception {
        ;
        byte[] key = "tom".getBytes();
        double max = 1.0;
        double min = 1.0;
        int offset = 1;
        int count = 1;

        Set<Tuple> append = redisClientTemplate.zrevrangeByScoreWithScores(key, max, min, offset,
                count);

        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrevrangeByScoreWithScores(byte[],double,double,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeByScoreWithScoresg() throws Exception {
        byte[] key = "tom".getBytes();
        double max = 1.0;
        double min = 1.0;
        int offset = 1;
        int count = 1;

        Set<Tuple> append = redisClientTemplate.zrevrangeByScoreWithScores(key, max, min, offset,
                count);

        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrevrangeWithScores(String,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeWithScoresa() throws Exception {
        String key = "tom";
        int start = 1;
        int end = 1;

        Set<Tuple> append = redisClientTemplate.zrevrangeWithScores(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrevrangeWithScores(String,int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeWithScoresb() throws Exception {
        String key = "peter";
        int start = 1;
        int end = 1;

        Set<Tuple> append = redisClientTemplate.zrevrangeWithScores(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrevrangeWithScores(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeWithScoresappend() throws Exception {
        byte[] key = "peter".getBytes();
        int start = 1;
        int end = 1;

        Set<Tuple> append = redisClientTemplate.zrevrangeWithScores(key, start, end);
        Assert.notNull(append);
    }

    /**
     * Run the Set<Tuple> zrevrangeWithScores(byte[],int,int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrangeWithScoresd() throws Exception {
        byte[] key = "tom".getBytes();
        int start = 1;
        int end = 1;

        Set<Tuple> append = redisClientTemplate.zrevrangeWithScores(key, start, end);

        Assert.notNull(append);
    }

    /**
     * Run the Long zrevrank(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevran() throws Exception {
        String key = "testZrevran";
        String member = "memberZrevran";

        redisClientTemplate.zrevrank(key, member);

    }

    /**
     * Run the Long zrevrank(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrankb() throws Exception {
        String key = "test";
        String member = "testZrevrankb";
        redisClientTemplate.zadd(key, 5537, member);
        Long append = redisClientTemplate.zrevrank(key, member);
        Assert.notNull(append);
    }

    /**
     * Run the Long zrevrank(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZrevrankd() throws Exception {
        byte[] key = "testZrevrankd".getBytes();
        byte[] member = "valueZrevrankd".getBytes();
        double score = 12.0;
        redisClientTemplate.zadd(key, score, member);
        Long append = redisClientTemplate.zrevrank(key, member);
        Assert.notNull(append);
    }

    /**
     * Run the Double zscore(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZscorea() throws Exception {
        String key = "testZscorea";
        String member = "memberZscorea";

        redisClientTemplate.zscore(key, member);
    }

    /**
     * Run the Double zscore(String,String) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZscoreb() throws Exception {
        String key = "testZscoreb";
        String member = "memberZscoreb";

        redisClientTemplate.zscore(key, member);

    }

    /**
     * Run the Double zscore(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZscorec() throws Exception {
        byte[] key = "testZscorec".getBytes();
        byte[] member = "member".getBytes();

        redisClientTemplate.zscore(key, member);

    }

    /**
     * Run the Double zscore(byte[],byte[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testZscored() throws Exception {
        byte[] key = "testZscored".getBytes();
        byte[] member = "memberZscored".getBytes();

        redisClientTemplate.zscore(key, member);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *         if the initialization fails for some reason
     *
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *         if the clean-up fails for some reason
     *
     */
    @After
    public void tearDown() throws Exception {
    }
    /**
     * Run the void testNull() method test.
     */
    @Test
    public void testNull() {
        String nu = null;
        byte[] by = null;
        redisClientTemplate.addUserList(nu);
        redisClientTemplate.hkeys(nu);
        redisClientTemplate.hkeys(by);
        redisClientTemplate.hgetAll(by);
        redisClientTemplate.hgetAll(nu);
        redisClientTemplate.hincrBy(nu,nu,0L);
        redisClientTemplate.hincrBy(by,by,0L);
        redisClientTemplate.hsetnx(by,by,by);
        redisClientTemplate.hsetnx(nu,nu,nu);
        redisClientTemplate.decrBy(nu,0L);
        redisClientTemplate.decrBy(by,0L);
        redisClientTemplate.expireAt(by,0L);
        redisClientTemplate.expireAt(nu,0L);
        redisClientTemplate.getShardInfo(by);
        redisClientTemplate.getShardInfo(nu);
        redisClientTemplate.expire(nu,0);
        redisClientTemplate.expire(by,0);
        redisClientTemplate.getEntity(nu);
        redisClientTemplate.getKeyTag(nu);
        redisClientTemplate.setEntity(nu,null);
        redisClientTemplate.getShard(nu);
        redisClientTemplate.getShard(by);
        redisClientTemplate.getrange(nu,0L,0L);
        redisClientTemplate.getbit(nu,0L);
        redisClientTemplate.setbit(nu,0L,true);
        redisClientTemplate.hexists(by,by);
        redisClientTemplate.hexists(nu,nu);
        redisClientTemplate.rpush(by,by);
        redisClientTemplate.rpush(nu,nu);
        redisClientTemplate.linsert(nu,null,nu,nu);
        redisClientTemplate.linsert(by,null,by,by);
        redisClientTemplate.lindex(by,0);
        redisClientTemplate.lindex(nu,0L);
        redisClientTemplate.lpush(by,by);
        redisClientTemplate.lpush(nu,nu);
        redisClientTemplate.incrBy(by,0L);
        redisClientTemplate.incrBy(nu,0L);
        redisClientTemplate.ltrim(nu,0L,0L);
        redisClientTemplate.ltrim(by,0,0);
        redisClientTemplate.lrange(nu,0L,0L);
        redisClientTemplate.lrange(by,0,0);
        redisClientTemplate.hmget(nu,nu);
        redisClientTemplate.hmget(by,by);
        redisClientTemplate.hmset(by,null);
        redisClientTemplate.hmset(nu,null);
        redisClientTemplate.hvals(by);
        redisClientTemplate.hvals(nu);
        redisClientTemplate.scard(by);
        redisClientTemplate.scard(nu);
        redisClientTemplate.pipelined(null);
        redisClientTemplate.remUserList(nu);
        redisClientTemplate.setex(nu,0,nu);
        redisClientTemplate.setex(by,0,by);
        redisClientTemplate.substr(nu,0,0);
        redisClientTemplate.substr(by,0,0);
        redisClientTemplate.setrange(nu,0L,nu);
        redisClientTemplate.sismember(nu,nu);
        redisClientTemplate.sismember(by,by);
        redisClientTemplate.setnx(by,by);
        redisClientTemplate.setnx(nu,nu);
        redisClientTemplate.srandmember(nu);
        redisClientTemplate.srandmember(by);
        redisClientTemplate.zcard(nu);
        redisClientTemplate.zcard(by);
        redisClientTemplate.zcount(nu,0d,0d);
        redisClientTemplate.zcount(by,0d,0d);
        redisClientTemplate.zrevrank(nu,nu);
        redisClientTemplate.zrevrank(by,by);
        redisClientTemplate.zincrby(by,0d,by);
        redisClientTemplate.zincrby(nu,0d,nu);
        redisClientTemplate.zscore(by,by);
        redisClientTemplate.zscore(nu,nu);
        redisClientTemplate.zrank(by,by);
        redisClientTemplate.zrank(nu,nu);
        redisClientTemplate.zrevrange(by,0,0);
        redisClientTemplate.zrevrange(nu,0,0);
        redisClientTemplate.zrange(by,0,0);
        redisClientTemplate.zrange(nu,0,0);
        redisClientTemplate.zremrangeByScore(by,0d,0d);
        redisClientTemplate.zremrangeByScore(nu,0d,0d);
        redisClientTemplate.zrevrangeByScore(nu,0d,0d);
        redisClientTemplate.zrevrangeByScore(by,0d,0d);
        redisClientTemplate.zrevrangeByScore(by,0d,0d,0,0);
        redisClientTemplate.zrevrangeByScore(nu,0d,0d,0,0);
        redisClientTemplate.zrangeByScore(nu,0d,0d);
        redisClientTemplate.zrangeByScore(by,0d,0d);
        redisClientTemplate.zrangeByScore(by,0d,0d,0,0);
        redisClientTemplate.zrangeByScore(nu,0d,0d,0,0);
        redisClientTemplate.zrangeWithScores(by,0,0);
        redisClientTemplate.zrangeWithScores(nu,0,0);
        redisClientTemplate.zremrangeByRank(nu,0,0);
        redisClientTemplate.zremrangeByRank(by,0,0);
        redisClientTemplate.zrevrangeWithScores(by,0,0);
        redisClientTemplate.zrevrangeWithScores(nu,0,0);
        redisClientTemplate.zrem(by,by);
        redisClientTemplate.zrem(nu,nu);
        redisClientTemplate.rpop(by);
        redisClientTemplate.rpop(nu);
        redisClientTemplate.sadd(nu,nu);
        redisClientTemplate.sadd(by,by);
        redisClientTemplate.lpop(nu);
        redisClientTemplate.lpop(by);
        redisClientTemplate.llen(nu);
        redisClientTemplate.llen(by);
        redisClientTemplate.srem(by,by);
        redisClientTemplate.srem(nu,nu);
        redisClientTemplate.ttl(by);
        redisClientTemplate.zadd(nu,0d,nu);
        redisClientTemplate.zadd(by,0d,by);
        redisClientTemplate.lset(nu,0L,nu);
        redisClientTemplate.lset(by,0,by);
        redisClientTemplate.lrem(nu,0L,nu);
        redisClientTemplate.lrem(by,0,by);
        redisClientTemplate.del(nu);
        redisClientTemplate.del(by);
        redisClientTemplate.decr(nu);
        redisClientTemplate.decr(by);
        redisClientTemplate.hdel(by,by);
        redisClientTemplate.hdel(nu,nu);
        redisClientTemplate.hlen(nu);
        redisClientTemplate.hlen(by);
        redisClientTemplate.incr(nu);
        redisClientTemplate.incr(by);
        redisClientTemplate.hget(by,by);
        redisClientTemplate.hget(nu,nu);
        redisClientTemplate.hset(by,by,by);
        redisClientTemplate.hset(nu,nu,nu);
        redisClientTemplate.zrevrangeByScoreWithScores(by,0d,0d,0,0);
        redisClientTemplate.zrevrangeByScoreWithScores(by,0d,0d);
        redisClientTemplate.zrevrangeByScoreWithScores(nu,0d,0d);
        redisClientTemplate.zrevrangeByScoreWithScores(nu,0d,0d,0,0);
        redisClientTemplate.zrangeByScoreWithScores(nu,0d,0d,0,0);
        redisClientTemplate.zrangeByScoreWithScores(by,0d,0d,0,0);
        redisClientTemplate.zrangeByScoreWithScores(nu,0d,0d);
        redisClientTemplate.zrangeByScoreWithScores(by,0d,0d);
        redisClientTemplate.spop(nu);
        redisClientTemplate.spop(by);
        redisClientTemplate.smembers(nu);
        redisClientTemplate.smembers(by);
        redisClientTemplate.append(nu,nu);
        redisClientTemplate.append(by,by);
        redisClientTemplate.get(nu);
        redisClientTemplate.get(by);
        redisClientTemplate.set(nu,nu);
        redisClientTemplate.set(by,by);
        redisClientTemplate.type(by);
        redisClientTemplate.type(nu);
        redisClientTemplate.exists(nu);
        redisClientTemplate.exists(by);
        redisClientTemplate.sort(nu);
        redisClientTemplate.sort(nu,null);
        redisClientTemplate.sort(by);
        redisClientTemplate.sort(by,null);
        redisClientTemplate.getSet(by,by);
        redisClientTemplate.getSet(nu,nu);
    }

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(RedisClientTemplateTest.class);
        try {
            Class<?> clazz = Class.forName("com.cmcc.ms.entity.datashow.UnifiedCdnWeekExample");
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                method.getParameterTypes();
                Class<?>[] parameterTypes = method.getParameterTypes();
                String palast = "";
                int i = 1;
                for (Class<?> clas : parameterTypes) {
                    if (i == 1) {
                        System.err.print(methodName+"(");
                    }
                    if (clas.getName().contains("String")) {
                        palast += "nu,";
                    } else if (clas.getName().contains("Integer") || clas.getName().contains("int")) {
                        palast += "0,";
                    } else if (clas.getName().contains("Long") || clas.getName().contains("long")) {
                        palast += "0L,";
                    } else if (clas.getName().contains("Boolean")
                            || clas.getName().contains("boolean")) {
                        palast += "true,";
                    } else if (clas.getName().contains("Double")
                            || clas.getName().contains("double")) {
                        palast += "0d,";
                    } else if (clas.getName().contains("byte") || clas.getName().contains("Byte")) {
                        palast += "0b,";
                    }else if (clas.getName().contains("[B")) {
                        palast += "by,";
                    }else {
                        palast += "null,";
                    }
                    i++;
                }
                if (palast.length() >= 1 && i >= 2) {
                    System.err.println(palast.substring(0, palast.length() - 1) + ");");
                } else if (palast.length() == 0 && i >= 2) {
                    System.err.println(");");
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
