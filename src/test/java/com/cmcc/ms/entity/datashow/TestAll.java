package com.cmcc.ms.entity.datashow;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 17-9-29 上午9:43
 * @author ldy
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    UnifiedCacheWeekTest.class,
    UnifiedCacheWeekExampleTest.class,
    OverallAnalysisExampleTest.class,
    UnifiedCacheDayTest.class,
    BusinessTrafficTest.class,
    IdcDayTest.class,
    UnifiedCdnWeekExampleTest.class,
    IdcDayExampleTest.class,
    OverallAnalysisTest.class,
    EverytimeGprsTest.class,
    ProvinceOttWeekExampleTest.class,
    UnifiedCdnDayExampleTest.class,
    BaseDataTest.class,
    ProvinceCacheDayExampleTest.class,
    IdcWeekExampleTest.class,
    EverytimeGprsExampleTest.class,
    ProvinceCacheDayTest.class,
    ProvinceOttDayExampleTest.class,
    BaseDataExampleTest.class,
    ProvinceOttWeekTest.class,
    MapDataTest.class,
    ProvinceOttDayTest.class,
    IdcWeekTest.class,
    ProvinceCacheWeekExampleTest.class,
    MapDataExampleTest.class,
    ProvinceCacheWeekTest.class,
    UnifiedCdnWeekTest.class,
    BusinessTrafficExampleTest.class,
    UnifiedCdnDayTest.class,
    UnifiedCacheDayExampleTest.class,
})
public class TestAll {

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     * @generatedBy CodePro at 17-9-29 上午9:43
     */
    public static void main(String[] args) {
        JUnitCore.runClasses(new Class[] { TestAll.class });
    }
}
