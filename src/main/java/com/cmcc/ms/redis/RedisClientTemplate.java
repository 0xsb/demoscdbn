package com.cmcc.ms.redis;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPipeline;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;


/**
 * The Class RedisClientTemplate.
 *
 * @date 2016年7月25日 下午5:03:58
 */
/**
 * @author lipeipei
 *
 * 2016年9月21日 下午1:13:17
 */
@Repository("redisClientTemplate")
public class RedisClientTemplate {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(RedisClientTemplate.class);

    /** The sharded jedis pool. */
    @Autowired
    private ShardedJedisPool shardedJedisPool;

    /**
     * Gets the user list.
     *
     * @return the user list
     */
    public Set<String> getUserList() {
        return this.smembers("loginUserId");
    }

    /**
     * remUserList.
     *
     * @param userId the user id
     */
    public void remUserList(String userId) {
        this.srem("loginUserId", userId);
    }

    /**
     * Sets the user list.
     *
     * @param userId the user id
     */
    public void addUserList(String userId) {
        this.sadd("loginUserId", userId);
    }

    /**
     * 断开连接.
     */
    public void disconnect() {
        ShardedJedis shardedJedis = getResourceForTemp();
        shardedJedis.disconnect();
    }

    /**
     * 获取连接.
     *
     * @return the resource for temp
     */
    private ShardedJedis getResourceForTemp() {
        ShardedJedis shardJedis = null;
        try {
            shardJedis = shardedJedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {
            logger.error("[JedisDS] getRedisClent error:" + e.getMessage());
            //            if (null != shardJedis)
            shardedJedisPool.returnResource(shardJedis);
        }
        return null;
    }

    /**
     * 关闭连接.
     *
     * @param shardedJedis the sharded jedis
     * @param broken the broken
     */
    private void close(ShardedJedis shardedJedis, boolean broken) {
        if (broken) {
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } else {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    /**
     * 设置单个值（永久）.
     *
     * @param key the key
     * @param value the value
     * @return the string
     */
    public String set(String key, String value) {
        String result = null;

        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.set(key, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 获取单个值.
     *
     * @param key the key
     * @return the string
     */
    public String get(String key) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }

        boolean broken = false;
        try {
            result = shardedJedis.get(key);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 判断是否存在key为 的记录 存在返回true，不存在返回false.
     *
     * @param key the key
     * @return the boolean
     */
    public Boolean exists(String key) {
        Boolean result = false;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.exists(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 返回key所储存的值的类型。 
     * none(key不存在),string(字符串),list(列表),set(集合),zset(有序集),hash(哈希表).
     *
     * @param key the key
     * @return the string
     */
    public String type(String key) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.type(key);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 设置key生存时间，当key过期时，它会被自动删除.
     *
     * @param key the key
     * @param seconds 秒
     * Date date = formatter.parse("2016-08-12 16:43:00");==1470991380000
     * 若不精确到毫秒，则去掉long后三位
     * @return the long
     */
    public Long expire(String key, int seconds) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.expire(key, seconds);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 在某个时间点失效
     *  expireAt的作用和expire一样，都用于为key设置生存时间。
     *  不同在于expireAt命令接受的时间参数是UNIX时间戳(unix timestamp)。 .
     *
     * @param key the key
     * @param unixTime the unix time
     * @return the long
     */
    public Long expireAt(String key, long unixTime) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.expireAt(key, unixTime);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)。
     * 位的设置或清除取决于 value 参数，可以是 0 也可以是 1 。
     *  当 key 不存在时，自动生成一个新的字符串值。
     *  字符串会进行伸展(grown)以确保它可以将 value 保存在指定的偏移量上。当字符串值进行伸展时，空白位置以 0 填充。
     *  offset 参数必须大于或等于 0 ，小于 2^32 (bit 映射被限制在 512 MB 之内).
     *
     * @param key the key
     * @param offset the offset
     * @param value the value
     * @return true, if successful
     */
    public boolean setbit(String key, long offset, boolean value) {

        ShardedJedis shardedJedis = getResourceForTemp();
        boolean result = false;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.setbit(key, offset, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Gets the bit.
     *
     * @param key the key
     * @param offset the offset
     * @return the bit
     */
    public boolean getbit(String key, long offset) {
        ShardedJedis shardedJedis = getResourceForTemp();
        boolean result = false;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;

        try {
            result = shardedJedis.getbit(key, offset);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Setrange.
     *
     * @param key the key
     * @param offset the offset
     * @param value the value
     * @return the long
     */
    public long setrange(String key, long offset, String value) {
        ShardedJedis shardedJedis = getResourceForTemp();
        long result = 0;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.setrange(key, offset, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Gets the range.
     *
     * @param key the key
     * @param startOffset the start offset
     * @param endOffset the end offset
     * @return the range
     */
    public String getrange(String key, long startOffset, long endOffset) {
        ShardedJedis shardedJedis = getResourceForTemp();
        String result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.getrange(key, startOffset, endOffset);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Gets the sets the.
     *
     * @param key the key
     * @param value the value
     * @return the sets the
     */
    public String getSet(String key, String value) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.getSet(key, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Setnx.
     *
     * @param key the key
     * @param value the value
     * @return the long
     */
    public Long setnx(String key, String value) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.setnx(key, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 有过期时间的存储数据.
     *
     * @param key the key
     * @param seconds 单位秒
     * @param value the value
     * @return the string
     */
    public String setex(String key, int seconds, String value) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.setex(key, seconds, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Decr by.
     *
     * @param key the key
     * @param integer the integer
     * @return the long
     */
    public Long decrBy(String key, long integer) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.decrBy(key, integer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Decr.
     *
     * @param key the key
     * @return the long
     */
    public Long decr(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.decr(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Incr by.
     *
     * @param key the key
     * @param integer the integer
     * @return the long
     */
    public Long incrBy(String key, long integer) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.incrBy(key, integer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Incr.
     *
     * @param key the key
     * @return the long
     */
    public Long incr(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.incr(key);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Append.
     *
     * @param key the key
     * @param value the value
     * @return the long
     */
    public Long append(String key, String value) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.append(key, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Substr.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the string
     */
    public String substr(String key, int start, int end) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.substr(key, start, end);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hset.
     *
     * @param key the key
     * @param field the field
     * @param value the value
     * @return the long
     */
    public Long hset(String key, String field, String value) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hset(key, field, value);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hget.
     *
     * @param key the key
     * @param field the field
     * @return the string
     */
    public String hget(String key, String field) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hget(key, field);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hsetnx.
     *
     * @param key the key
     * @param field the field
     * @param value the value
     * @return the long
     */
    public Long hsetnx(String key, String field, String value) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hsetnx(key, field, value);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hmset.
     *
     * @param key the key
     * @param hash the hash
     * @return the string
     */
    public String hmset(String key, Map<String, String> hash) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hmset(key, hash);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 获取全部指定的hash filed。.
     *
     * @param key the key
     * @param fields the fields
     * @return the list
     */
    public List<String> hmget(String key, String... fields) {
        List<String> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hmget(key, fields);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hincr by.
     *
     * @param key the key
     * @param field the field
     * @param value the value
     * @return the long
     */
    public Long hincrBy(String key, String field, long value) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hincrBy(key, field, value);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 查看哈希表key中，给定域field是否存在。.
     *
     * @param key the key
     * @param field the field
     * @return the boolean
     */
    public Boolean hexists(String key, String field) {
        Boolean result = false;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hexists(key, field);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Del.
     *
     * @param key the key
     * @return the long
     */
    public Long del(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.del(key);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Del.
     *
     * @param key the key
     * @return the long
     */
    public Long del(byte[] key) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.del(key);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 删除哈希表key中的一个或多个指定域.
     *
     * @param key the key
     * @param field the field
     * @return the long
     */
    public Long hdel(String key, String field) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hdel(key, field);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hlen.
     *
     * @param key the key
     * @return the long
     */
    public Long hlen(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hlen(key);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 返回哈希表key中的所有域.
     *
     * @param key the key
     * @return the sets the
     */
    public Set<String> hkeys(String key) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hkeys(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 返回哈希表key中的所有值.
     *
     * @param key the key
     * @return the list
     */
    public List<String> hvals(String key) {
        List<String> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hvals(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 返回哈希表key中所有域和值.
     *
     * @param key the key
     * @return the map
     */
    public Map<String, String> hgetAll(String key) {
        Map<String, String> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hgetAll(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    // ================list ====== l表示 list或 left, r表示right====================
    /**
     * 在key对应list的尾部添加字符串元素，返回1表示成功，0表示key存在且不是list类型 .
     *
     * @param key the key
     * @param string the string
     * @return the long
     */
    public Long rpush(String key, String string) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.rpush(key, string);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 将值value插入到列表key的表头.
     *
     * @param key the key
     * @param string the string
     * @return the long
     */
    public Long lpush(String key, String string) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.lpush(key, string);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 返回列表key的长度。 .
     *
     * @param key the key
     * @return the long
     */
    public Long llen(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.llen(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 返回列表key中指定区间内的元素,区间以偏移量start和stop指定.
     * 下标(index)参数start和end从0开始;
     * 数下标代表从后开始(-1表示列表的最后一个元素,-2表示列表的倒数第二个元素,以此类推)
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the list
     */
    public List<String> lrange(String key, long start, long end) {
        List<String> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.lrange(key, start, end);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 保留指定区域（index 为start到end之间）的元素，其他元素全部删除.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the string
     */
    public String ltrim(String key, long start, long end) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.ltrim(key, start, end);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 返回list下标为index的value值.
     *
     * @param key 存储list的key
     * @param index the index
     * @return the string
     */
    public String lindex(String key, long index) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.lindex(key, index);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 设置list中指定下标的元素值(下标从0开始)：
     * 如：lset mylist4 0 "four" .
     *
     * @param key the key
     * @param index the index
     * @param value the value
     * @return the string
     */
    public String lset(String key, long index, String value) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.lset(key, index, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 移除等于value的元素，
     * 当count>0时，从表头开始查找，移除count个；
     * 当count=0时，从表头开始查找，移除所有等于value的；
     * 当count<0时，从表尾开始查找，移除|count| 个。.
     *
     * @param key the key
     * @param count the count
     * @param value the value
     * @return the long
     */
    public Long lrem(String key, long count, String value) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.lrem(key, count, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 从list的头部删除元素，并返回删除元素：.
     *
     * @param key the key
     * @return the string
     */
    public String lpop(String key) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.lpop(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 从list的尾部删除元素，并返回删除元素：.
     *
     * @param key the key
     * @return the string
     */
    public String rpop(String key) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.rpop(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    //return 1 add a not exist value ,
    //return 0 add a exist value
    /**
     * 将member元素加入到集合key当中。 .
     *
     * @param key the key
     * @param member the member
     * @return the long
     */
    public Long sadd(String key, String member) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.sadd(key, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 返回集合key中的所有成员.
     *
     * @param key 集合的key
     * @return the sets the
     */
    public Set<String> smembers(String key) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.smembers(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 移除集合中的member元素。 .
     *
     * @param key the key
     * @param member the member
     * @return the long
     */
    public Long srem(String key, String member) {
        ShardedJedis shardedJedis = getResourceForTemp();

        Long result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.srem(key, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 用于移除并返回集合中的一个随机元素。.
     *
     * @param key the key
     * @return the string
     */
    public String spop(String key) {
        ShardedJedis shardedJedis = getResourceForTemp();
        String result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.spop(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 返回集合key的元素的数量.
     *
     * @param key the key
     * @return the long
     */
    public Long scard(String key) {
        ShardedJedis shardedJedis = getResourceForTemp();
        Long result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.scard(key);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 判断元素是否是集合key的成员.
     *
     * @param key 集合的key
     * @param member 集合的value
     * @return the boolean
     */
    public Boolean sismember(String key, String member) {
        ShardedJedis shardedJedis = getResourceForTemp();
        Boolean result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.sismember(key, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 返回集合中一个或多个随机数.
     *
     * @param key the key
     * @return the string
     */
    public String srandmember(String key) {
        ShardedJedis shardedJedis = getResourceForTemp();
        String result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.srandmember(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 用于将一个或多个成员元素及其分数值加入到有序集当中。
     * 如果某个成员已经是有序集的成员，那么更新这个成员的分数值，并通过重新插入这个成员元素，来保证该成员在正确的位置上。
     * 分数值可以是整数值或双精度浮点数。
     * 如果有序集合 key 不存在，则创建一个空的有序集并执行 ZADD 操作。
     * 当 key 存在但不是有序集类型时，返回一个错误。 .
     *
     * @param key the key
     * @param score the score
     * @param member the member
     * @return the long
     */
    public Long zadd(String key, double score, String member) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zadd(key, score, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrange.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the sets the
     */
    public Set<String> zrange(String key, int start, int end) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrange(key, start, end);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrem.
     *
     * @param key the key
     * @param member the member
     * @return the long
     */
    public Long zrem(String key, String member) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrem(key, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zincrby.
     *
     * @param key the key
     * @param score the score
     * @param member the member
     * @return the double
     */
    public Double zincrby(String key, double score, String member) {
        Double result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zincrby(key, score, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrank.
     *
     * @param key the key
     * @param member the member
     * @return the long
     */
    public Long zrank(String key, String member) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrank(key, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrevrank.
     *
     * @param key the key
     * @param member the member
     * @return the long
     */
    public Long zrevrank(String key, String member) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrevrank(key, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrevrange.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the sets the
     */
    public Set<String> zrevrange(String key, int start, int end) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrevrange(key, start, end);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrange with scores.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the sets the
     */
    public Set<Tuple> zrangeWithScores(String key, int start, int end) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrangeWithScores(key, start, end);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrevrange with scores.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the sets the
     */
    public Set<Tuple> zrevrangeWithScores(String key, int start, int end) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrevrangeWithScores(key, start, end);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zcard.
     *
     * @param key the key
     * @return the long
     */
    public Long zcard(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zcard(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zscore.
     *
     * @param key the key
     * @param member the member
     * @return the double
     */
    public Double zscore(String key, String member) {
        Double result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zscore(key, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Sort.
     *
     * @param key the key
     * @return the list
     */
    public List<String> sort(String key) {
        List<String> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.sort(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Sort.
     *
     * @param key the key
     * @param sortingParameters the sorting parameters
     * @return the list
     */
    public List<String> sort(String key, SortingParams sortingParameters) {
        List<String> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.sort(key, sortingParameters);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zcount.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the long
     */
    public Long zcount(String key, double min, double max) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zcount(key, min, max);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrange by score.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the sets the
     */
    public Set<String> zrangeByScore(String key, double min, double max) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrangeByScore(key, min, max);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrevrange by score.
     *
     * @param key the key
     * @param max the max
     * @param min the min
     * @return the sets the
     */
    public Set<String> zrevrangeByScore(String key, double max, double min) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrevrangeByScore(key, max, min);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrange by score.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @param offset the offset
     * @param count the count
     * @return the sets the
     */
    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrangeByScore(key, min, max, offset, count);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrevrange by score.
     *
     * @param key the key
     * @param max the max
     * @param min the min
     * @param offset the offset
     * @param count the count
     * @return the sets the
     */
    public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrevrangeByScore(key, max, min, offset, count);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrange by score with scores.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the sets the
     */
    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrangeByScoreWithScores(key, min, max);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrevrange by score with scores.
     *
     * @param key the key
     * @param max the max
     * @param min the min
     * @return the sets the
     */
    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrevrangeByScoreWithScores(key, max, min);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrange by score with scores.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @param offset the offset
     * @param count the count
     * @return the sets the
     */
    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset,
                                              int count) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrangeByScoreWithScores(key, min, max, offset, count);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrevrange by score with scores.
     *
     * @param key the key
     * @param max the max
     * @param min the min
     * @param offset the offset
     * @param count the count
     * @return the sets the
     */
    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset,
                                                 int count) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zremrange by rank.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the long
     */
    public Long zremrangeByRank(String key, int start, int end) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zremrangeByRank(key, start, end);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zremrange by score.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the long
     */
    public Long zremrangeByScore(String key, double start, double end) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zremrangeByScore(key, start, end);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Linsert.
     *
     * @param key the key
     * @param where the where
     * @param pivot the pivot
     * @param value the value
     * @return the long
     */
    public Long linsert(String key, LIST_POSITION where, String pivot, String value) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.linsert(key, where, pivot, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * redis 存储实体对象，被存储的实体要 implements Serializable，否则报错.
     *
     * @param key the key
     * @param object the object
     * @return the string
     */
    public String setEntity(String key, Object object) {
        String result = null;
        try {
            result = set(key.getBytes(), SerializeUtil.serialize(object));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据存储的key取到实体.
     *
     * @param key the key
     * @return the entity
     */
    public Object getEntity(String key) {
        try {
            byte[] valueB = get(key.getBytes());
            Object object = SerializeUtil.unserialize(valueB);
            return object;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 一般用于存储实体对象，使用序列化存储，反序列化get.
     *
     * @param key the key
     * @param value the value
     * @return the string
     */
    public String set(byte[] key, byte[] value) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.set(key, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Gets the.
     *
     * @param key the key
     * @return the byte[]
     */
    public byte[] get(byte[] key) {
        byte[] result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.get(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Exists.
     *
     * @param key the key
     * @return the boolean
     */
    public Boolean exists(byte[] key) {
        Boolean result = false;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.exists(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Type.
     *
     * @param key the key
     * @return the string
     */
    public String type(byte[] key) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.type(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Expire.
     *
     * @param key the key
     * @param seconds the seconds
     * @return the long
     */
    public Long expire(byte[] key, int seconds) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.expire(key, seconds);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Expire at.
     *
     * @param key the key
     * @param unixTime the unix time
     * @return the long
     */
    public Long expireAt(byte[] key, long unixTime) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.expireAt(key, unixTime);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Ttl.
     *
     * @param key the key
     * @return the long
     */
    public Long ttl(byte[] key) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.ttl(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Gets the sets the.
     *
     * @param key the key
     * @param value the value
     * @return the sets the
     */
    public byte[] getSet(byte[] key, byte[] value) {
        byte[] result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.getSet(key, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Setnx.
     *
     * @param key the key
     * @param value the value
     * @return the long
     */
    public Long setnx(byte[] key, byte[] value) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.setnx(key, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Setex.
     *
     * @param key the key
     * @param seconds the seconds
     * @param value the value
     * @return the string
     */
    public String setex(byte[] key, int seconds, byte[] value) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.setex(key, seconds, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Decr by.
     *
     * @param key the key
     * @param integer the integer
     * @return the long
     */
    public Long decrBy(byte[] key, long integer) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.decrBy(key, integer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Decr.
     *
     * @param key the key
     * @return the long
     */
    public Long decr(byte[] key) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.decr(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Incr by.
     *
     * @param key the key
     * @param integer the integer
     * @return the long
     */
    public Long incrBy(byte[] key, long integer) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.incrBy(key, integer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Incr.
     *
     * @param key the key
     * @return the long
     */
    public Long incr(byte[] key) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.incr(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Append.
     *
     * @param key the key
     * @param value the value
     * @return the long
     */
    public Long append(byte[] key, byte[] value) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.append(key, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Substr.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the byte[]
     */
    public byte[] substr(byte[] key, int start, int end) {
        byte[] result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.substr(key, start, end);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hset.
     *
     * @param key the key
     * @param field the field
     * @param value the value
     * @return the long
     */
    public Long hset(byte[] key, byte[] field, byte[] value) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hset(key, field, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hget.
     *
     * @param key the key
     * @param field the field
     * @return the byte[]
     */
    public byte[] hget(byte[] key, byte[] field) {
        byte[] result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hget(key, field);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hsetnx.
     *
     * @param key the key
     * @param field the field
     * @param value the value
     * @return the long
     */
    public Long hsetnx(byte[] key, byte[] field, byte[] value) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hsetnx(key, field, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hmset.
     *
     * @param key the key
     * @param hash the hash
     * @return the string
     */
    public String hmset(byte[] key, Map<byte[], byte[]> hash) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hmset(key, hash);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hmget.
     *
     * @param key the key
     * @param fields the fields
     * @return the list
     */
    public List<byte[]> hmget(byte[] key, byte[]... fields) {
        List<byte[]> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hmget(key, fields);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hincr by.
     *
     * @param key the key
     * @param field the field
     * @param value the value
     * @return the long
     */
    public Long hincrBy(byte[] key, byte[] field, long value) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hincrBy(key, field, value);
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hexists.
     *
     * @param key the key
     * @param field the field
     * @return the boolean
     */
    public Boolean hexists(byte[] key, byte[] field) {
        Boolean result = false;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hexists(key, field);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hdel.
     *
     * @param key the key
     * @param field the field
     * @return the long
     */
    public Long hdel(byte[] key, byte[] field) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hdel(key, field);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hlen.
     *
     * @param key the key
     * @return the long
     */
    public Long hlen(byte[] key) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hlen(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hkeys.
     *
     * @param key the key
     * @return the sets the
     */
    public Set<byte[]> hkeys(byte[] key) {
        Set<byte[]> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hkeys(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hvals.
     *
     * @param key the key
     * @return the collection
     */
    public Collection<byte[]> hvals(byte[] key) {
        Collection<byte[]> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hvals(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Hget all.
     *
     * @param key the key
     * @return the map
     */
    public Map<byte[], byte[]> hgetAll(byte[] key) {
        Map<byte[], byte[]> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.hgetAll(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Rpush.
     *
     * @param key the key
     * @param string the string
     * @return the long
     */
    public Long rpush(byte[] key, byte[] string) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.rpush(key, string);
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Lpush.
     *
     * @param key the key
     * @param string the string
     * @return the long
     */
    public Long lpush(byte[] key, byte[] string) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.lpush(key, string);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Llen.
     *
     * @param key the key
     * @return the long
     */
    public Long llen(byte[] key) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.llen(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 返回从start到stop的所有元素的列表,start和stop都是从0开始.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the list
     */
    public List<byte[]> lrange(byte[] key, int start, int end) {
        List<byte[]> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.lrange(key, start, end);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Ltrim.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the string
     */
    public String ltrim(byte[] key, int start, int end) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.ltrim(key, start, end);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Lindex.
     *
     * @param key the key
     * @param index the index
     * @return the byte[]
     */
    public byte[] lindex(byte[] key, int index) {
        byte[] result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.lindex(key, index);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Lset.
     *
     * @param key the key
     * @param index the index
     * @param value the value
     * @return the string
     */
    public String lset(byte[] key, int index, byte[] value) {
        String result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.lset(key, index, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Lrem.
     *
     * @param key the key
     * @param count the count
     * @param value the value
     * @return the long
     */
    public Long lrem(byte[] key, int count, byte[] value) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.lrem(key, count, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Lpop.
     *
     * @param key the key
     * @return the byte[]
     */
    public byte[] lpop(byte[] key) {
        byte[] result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.lpop(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Rpop.
     *
     * @param key the key
     * @return the byte[]
     */
    public byte[] rpop(byte[] key) {
        byte[] result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.rpop(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Sadd.
     *
     * @param key the key
     * @param member the member
     * @return the long
     */
    public Long sadd(byte[] key, byte[] member) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.sadd(key, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Smembers.
     *
     * @param key the key
     * @return the sets the
     */
    public Set<byte[]> smembers(byte[] key) {
        Set<byte[]> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.smembers(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Srem.
     *
     * @param key the key
     * @param member the member
     * @return the long
     */
    public Long srem(byte[] key, byte[] member) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.srem(key, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Spop.
     *
     * @param key the key
     * @return the byte[]
     */
    public byte[] spop(byte[] key) {
        byte[] result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.spop(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Scard.
     *
     * @param key the key
     * @return the long
     */
    public Long scard(byte[] key) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.scard(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Sismember.
     *
     * @param key the key
     * @param member the member
     * @return the boolean
     */
    public Boolean sismember(byte[] key, byte[] member) {
        Boolean result = false;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.sismember(key, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Srandmember.
     *
     * @param key the key
     * @return the byte[]
     */
    public byte[] srandmember(byte[] key) {
        byte[] result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.srandmember(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zadd.
     *
     * @param key the key
     * @param score the score
     * @param member the member
     * @return the long
     */
    public Long zadd(byte[] key, double score, byte[] member) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zadd(key, score, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrange.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the sets the
     */
    public Set<byte[]> zrange(byte[] key, int start, int end) {
        Set<byte[]> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrange(key, start, end);
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrem.
     *
     * @param key the key
     * @param member the member
     * @return the long
     */
    public Long zrem(byte[] key, byte[] member) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrem(key, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zincrby.
     *
     * @param key the key
     * @param score the score
     * @param member the member
     * @return the double
     */
    public Double zincrby(byte[] key, double score, byte[] member) {
        Double result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zincrby(key, score, member);
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrank.
     *
     * @param key the key
     * @param member the member
     * @return 如果该成员存在，则返回它的位置索引值。否则返回nil
     */
    public Long zrank(byte[] key, byte[] member) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zrank(key, member);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrevrank.
     *
     * @param key the key
     * @param member the member
     * @return the long
     */
    public Long zrevrank(byte[] key, byte[] member) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrevrank(key, member);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrevrange.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the sets the
     */
    public Set<byte[]> zrevrange(byte[] key, int start, int end) {
        Set<byte[]> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.zrevrange(key, start, end);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrange with scores.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the sets the
     */
    public Set<Tuple> zrangeWithScores(byte[] key, int start, int end) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zrangeWithScores(key, start, end);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrevrange with scores.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the sets the
     */
    public Set<Tuple> zrevrangeWithScores(byte[] key, int start, int end) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zrevrangeWithScores(key, start, end);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     *  Sorted-Sets和Sets类型极为相似，它们都是字符串的集合，都不允许重复的成员出现在一个Set中。
     *  它们之间的主要差别是Sorted-Sets中的每一个成员都会有一个分数(score)与之关联，
     *  Redis正是通过分数来为集合中的成员进行从小到大的排序。
     *  然而需要额外指出的是，尽管Sorted-Sets中的成员必须是唯一的，但是分数(score)却是可以重复的。
     *  
     *  
     *  
     * 获取与该Key相关联的Sorted-Sets中包含的成员数量。.
     *
     * @param key the key
     * @return 返回Sorted-Sets中的成员数量，如果该Key不存在，返回0。
     */
    public Long zcard(byte[] key) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zcard(key);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zscore.
     *
     * @param key the key
     * @param member the member
     * @return the double
     */
    public Double zscore(byte[] key, byte[] member) {
        Double result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zscore(key, member);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Sort.
     *
     * @param key the key
     * @return the list
     */
    public List<byte[]> sort(byte[] key) {
        List<byte[]> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.sort(key);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Sort.
     *
     * @param key the key
     * @param sortingParameters the sorting parameters
     * @return the list
     */
    public List<byte[]> sort(byte[] key, SortingParams sortingParameters) {
        List<byte[]> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.sort(key, sortingParameters);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zcount.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the long
     */
    public Long zcount(byte[] key, double min, double max) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zcount(key, min, max);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrange by score.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the sets the
     */
    public Set<byte[]> zrangeByScore(byte[] key, double min, double max) {
        Set<byte[]> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zrangeByScore(key, min, max);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrange by score.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @param offset the offset
     * @param count the count
     * @return the sets the
     */
    public Set<byte[]> zrangeByScore(byte[] key, double min, double max, int offset, int count) {
        Set<byte[]> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zrangeByScore(key, min, max, offset, count);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrange by score with scores.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @return the sets the
     */
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zrangeByScoreWithScores(key, min, max);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrange by score with scores.
     *
     * @param key the key
     * @param min the min
     * @param max the max
     * @param offset the offset
     * @param count the count
     * @return the sets the
     */
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max, int offset,
                                              int count) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zrangeByScoreWithScores(key, min, max, offset, count);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrevrange by score.
     *
     * @param key the key
     * @param max the max
     * @param min the min
     * @return the sets the
     */
    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min) {
        Set<byte[]> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zrevrangeByScore(key, max, min);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrevrange by score.
     *
     * @param key the key
     * @param max the max
     * @param min the min
     * @param offset the offset
     * @param count the count
     * @return the sets the
     */
    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min, int offset, int count) {
        Set<byte[]> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zrevrangeByScore(key, max, min, offset, count);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrevrange by score with scores.
     *
     * @param key the key
     * @param max the max
     * @param min the min
     * @return the sets the
     */
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zrevrangeByScoreWithScores(key, max, min);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zrevrange by score with scores.
     *
     * @param key the key
     * @param max the max
     * @param min the min
     * @param offset the offset
     * @param count the count
     * @return the sets the
     */
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min, int offset,
                                                 int count) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zrevrangeByScoreWithScores(key, max, min, offset, count);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zremrange by rank.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the long
     */
    public Long zremrangeByRank(byte[] key, int start, int end) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zremrangeByRank(key, start, end);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Zremrange by score.
     *
     * @param key the key
     * @param start the start
     * @param end the end
     * @return the long
     */
    public Long zremrangeByScore(byte[] key, double start, double end) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.zremrangeByScore(key, start, end);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Linsert.
     *
     * @param key the key
     * @param where the where
     * @param pivot the pivot
     * @param value the value
     * @return the long
     */
    public Long linsert(byte[] key, LIST_POSITION where, byte[] pivot, byte[] value) {
        Long result = null;
        ShardedJedis shardedJedis = getResourceForTemp();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = shardedJedis.linsert(key, where, pivot, value);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Pipelined.
     *
     * @param shardedJedisPipeline the sharded jedis pipeline
     * @return the list
     */
    @SuppressWarnings("deprecation")
    public List<Object> pipelined(ShardedJedisPipeline shardedJedisPipeline) {
        ShardedJedis shardedJedis = getResourceForTemp();
        List<Object> result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.pipelined(shardedJedisPipeline);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Gets the shard.
     *
     * @param key the key
     * @return the shard
     */
    public Jedis getShard(byte[] key) {
        ShardedJedis shardedJedis = getResourceForTemp();
        Jedis result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.getShard(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Gets the shard.
     *
     * @param key the key
     * @return the shard
     */
    public Jedis getShard(String key) {
        ShardedJedis shardedJedis = getResourceForTemp();
        Jedis result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.getShard(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Gets the shard info.
     *
     * @param key the key
     * @return the shard info
     */
    public JedisShardInfo getShardInfo(byte[] key) {
        ShardedJedis shardedJedis = getResourceForTemp();
        JedisShardInfo result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.getShardInfo(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Gets the shard info.
     *
     * @param key the key
     * @return the shard info
     */
    public JedisShardInfo getShardInfo(String key) {
        ShardedJedis shardedJedis = getResourceForTemp();
        JedisShardInfo result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.getShardInfo(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Gets the key tag.
     *
     * @param key the key
     * @return the key tag
     */
    public String getKeyTag(String key) {
        ShardedJedis shardedJedis = getResourceForTemp();
        String result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.getKeyTag(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Gets the all shard info.
     *
     * @return the all shard info
     */
    public Collection<JedisShardInfo> getAllShardInfo() {
        ShardedJedis shardedJedis = getResourceForTemp();
        Collection<JedisShardInfo> result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.getAllShardInfo();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }

    /**
     * Gets the all shards.
     *
     * @return the all shards
     */
    public Collection<Jedis> getAllShards() {
        ShardedJedis shardedJedis = getResourceForTemp();
        Collection<Jedis> result = null;
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.getAllShards();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            broken = true;
        } finally {
            close(shardedJedis, broken);
        }
        return result;
    }
}
