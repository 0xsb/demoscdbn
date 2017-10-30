/**
 * @author ldy
 */
package com.cmcc.ms.entity.system;


/**
 * 节点接口.
 *
 * @author bing.peng
 */
public interface Node {

    /**
     * 节点id.
     *
     * @return the id
     */
    Long getId();

    /**
     * 节点父id.
     *
     * @return the parent id
     */
    Integer getParentId();

    /**
     * 节点名称.
     *
     * @return the name
     */
    String getName();

    /**
     * 节点所关联的资源.
     *
     * @return the resouce
     */
    String getResouce();
}
