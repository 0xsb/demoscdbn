/**
 * @author ldy
 */
package com.cmcc.ms.mapper;

import java.util.LinkedHashMap;
import java.util.LinkedList;


/**
 * The Interface SysCustomQueryMapperManual.
 *
 * @author ldy
 */
public interface SysCustomQueryMapperManual {

    /**
     * Super manager select.
     *
     * @param sql the sql
     * @return the linked list
     */
    LinkedList<LinkedHashMap<String, Object>> superManagerSelect(String sql);
}
