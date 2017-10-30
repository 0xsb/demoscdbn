/**
 * @author ldy
 */
package com.cmcc.ms.service.system;

import java.util.LinkedHashMap;
import java.util.LinkedList;


/**
 * The Interface SysCustomQueryService.
 */
public interface SysCustomQueryService {

    /**
     * Super manager select.
     *
     * @param sql the sql
     * @return the linked list
     */
    public LinkedList<LinkedHashMap<String, Object>> superManagerSelect(String sql);
}
