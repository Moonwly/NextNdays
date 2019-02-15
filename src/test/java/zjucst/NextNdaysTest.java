package zjucst;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NextNdaysTest {
    NextNdays nextNdays = new NextNdays();

    @Before
    public void setUp() {

    }

    @Test
    public void testNextNdays() {

// wly_testcase:
        assertEquals("2019-4-11", nextNdays.nextNdays("2019", "1", "1", "100"));
        assertEquals("2019-2-14", nextNdays.nextNdays("2019", "2", "14", "0"));
        assertEquals("2002-5-1", nextNdays.nextNdays("2001", "5", "1", "365"));
        assertEquals("2000-1-4", nextNdays.nextNdays("1999", "12", "30", "5"));
        assertEquals("2020-2-29", nextNdays.nextNdays("2020", "2", "28", "1"));
        assertEquals("1500-2-29", nextNdays.nextNdays("1500", "2", "28", "1"));
        assertEquals("1600-2-29", nextNdays.nextNdays("1600", "2", "28", "1"));
        assertEquals("1700-3-1", nextNdays.nextNdays("1700", "2", "28", "1"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2001", "0", "1", "20"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2019", "2", "29", "1"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2019", "1", "32", "3"));
        assertEquals("输入参数错误", nextNdays.nextNdays("0", "1", "1", "100"));
        assertEquals("输入参数错误", nextNdays.nextNdays("a", "b", "c", "d"));
        assertEquals("输入参数错误", nextNdays.nextNdays("1582", "10", "5", "1"));
        assertEquals("1-1-1", nextNdays.nextNdays("-1", "12", "31", "1"));
        assertEquals("1582-10-16", nextNdays.nextNdays("1582", "10", "1", "5"));
        assertEquals("1583-10-11", nextNdays.nextNdays("1582", "10", "1", "365"));
        assertEquals("1583-10-25", nextNdays.nextNdays("1581", "10", "15", "730"));
        assertEquals("2019-2-8", nextNdays.nextNdays("2019", "2", "10", "-2"));
        assertEquals("1999-12-29", nextNdays.nextNdays("2000", "1", "1", "-3"));
        assertEquals("-1-12-29", nextNdays.nextNdays("1", "1", "1", "-3"));
        assertEquals("1582-10-2", nextNdays.nextNdays("1582", "10", "15", "-3"));
        assertEquals("1582-9-13", nextNdays.nextNdays("1583", "1", "1", "-100"));
        assertEquals("2019-1-1", nextNdays.nextNdays("2019", "4", "11", "-100"));
        assertEquals("2020-4-1", nextNdays.nextNdays("2020", "4", "2", "-1"));
        assertEquals("2020-2-26", nextNdays.nextNdays("2020", "2", "29", "-3"));
        assertEquals("1234567890-1-2", nextNdays.nextNdays("1234567890", "1", "1", "1"));
        assertEquals("2046-5-19", nextNdays.nextNdays("2019", "1", "1", "10000"));

// zz_testcase:
        assertEquals("输入参数错误", nextNdays.nextNdays("-1", "1", "2", "3"));
        assertEquals("输入参数错误", nextNdays.nextNdays("0", "1", "2", "3"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2014", "-1", "2", "12"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2018", "0", "2", "155"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2014", "13", "2", "12"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2014", "2", "29", "1"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2019", "4", "31", "1"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2014", "3", "-3", "10"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2019", "9", "0", "10"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2014", "3", "1", "-1"));
        assertEquals("2008-9-16", nextNdays.nextNdays("2008", "9", "16", "0"));
        assertEquals("2014-11-1", nextNdays.nextNdays("2014", "10", "31", "1"));
        assertEquals("2014-12-1", nextNdays.nextNdays("2014", "11", "30", "1"));
        assertEquals("2015-1-1", nextNdays.nextNdays("2014", "12", "31", "1"));
        assertEquals("2012-2-29", nextNdays.nextNdays("2012", "2", "28", "1"));
        assertEquals("2014-3-1", nextNdays.nextNdays("2014", "2", "28", "1"));
        assertEquals("2018-3-30", nextNdays.nextNdays("2018", "3", "20", "10"));

// wyj_testcase:
        assertEquals("2018-2-1", nextNdays.nextNdays("2018", "2", "1", "0"));
        assertEquals("2018-2-11", nextNdays.nextNdays("2018", "2", "1", "10"));
        assertEquals("2018-5-12", nextNdays.nextNdays("2018", "2", "1", "100"));
        assertEquals("2020-10-28", nextNdays.nextNdays("2018", "2", "1", "1000"));
        assertEquals("2018-2-28", nextNdays.nextNdays("2018", "2", "1", "27"));
        assertEquals("2018-3-1", nextNdays.nextNdays("2018", "2", "1", "28"));
        assertEquals("2020-2-29", nextNdays.nextNdays("2020", "2", "1", "28"));
        assertEquals("2020-3-1", nextNdays.nextNdays("2020", "2", "1", "29"));
        assertEquals("2018-3-31", nextNdays.nextNdays("2018", "3", "1", "30"));
        assertEquals("2018-4-1", nextNdays.nextNdays("2018", "3", "1", "31"));
        assertEquals("2018-5-1", nextNdays.nextNdays("2018", "4", "1", "30"));
        assertEquals("2019-2-1", nextNdays.nextNdays("2018", "2", "1", "365"));
        assertEquals("2019-2-2", nextNdays.nextNdays("2018", "2", "1", "366"));
        assertEquals("2021-1-31", nextNdays.nextNdays("2020", "2", "1", "365"));
        assertEquals("2021-2-1", nextNdays.nextNdays("2020", "2", "1", "366"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2018", "2", "1", "-10"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2018", "2", "29", "10"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2020", "2", "30", "10"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2018", "4", "31", "10"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2018", "5", "32", "10"));

// czh_testcase:
        assertEquals("2018-4-25", nextNdays.nextNdays("2018", "4", "10", "15"));
        assertEquals("2018-7-10", nextNdays.nextNdays("2018", "6", "30", "10"));
        assertEquals("2019-1-8", nextNdays.nextNdays("2018", "12", "30", "9"));
        assertEquals("2018-10-31", nextNdays.nextNdays("2018", "9", "1", "60"));
        assertEquals("2001-1-31", nextNdays.nextNdays("2000", "2", "1", "365"));
        assertEquals("2001-11-1", nextNdays.nextNdays("2000", "11", "1", "365"));
        assertEquals("2012-3-4", nextNdays.nextNdays("2012", "2", "28", "5"));
        assertEquals("2001-3-5", nextNdays.nextNdays("2001", "2", "28", "5"));
        assertEquals("2000-12-31", nextNdays.nextNdays("2000", "1", "1", "365"));
        assertEquals("2002-1-1", nextNdays.nextNdays("2001", "1", "1", "365"));
        assertEquals("2001-1-1", nextNdays.nextNdays("2000", "1", "1", "366"));
        assertEquals("2004-2-12", nextNdays.nextNdays("2000", "3", "28", "1416"));
        assertEquals("2005-9-18", nextNdays.nextNdays("2000", "3", "28", "2000"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2018", "0", "15", "365"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2018", "3", "0", "365"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2018", "3", "32", "365"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2018", "4", "31", "365"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2011", "2", "29", "365"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2011", "13", "29", "365"));

// hyh_testcase:
        assertEquals("输入参数错误", nextNdays.nextNdays("2013", "2", "29", "5"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2013", "13", "29", "5"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2013", "0", "29", "5"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2013", "3", "0", "5"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2013", "13", "40", "5"));
        assertEquals("2018-2-20", nextNdays.nextNdays("2018", "2", "15", "5"));
        assertEquals("2018-3-1", nextNdays.nextNdays("2018", "2", "15", "14"));
        assertEquals("2019-2-15", nextNdays.nextNdays("2018", "2", "15", "365"));
        assertEquals("2018-1-31", nextNdays.nextNdays("2018", "1", "26", "5"));
        assertEquals("2018-2-1", nextNdays.nextNdays("2018", "1", "26", "6"));
        assertEquals("2018-3-31", nextNdays.nextNdays("2018", "3", "20", "11"));
        assertEquals("2018-4-1", nextNdays.nextNdays("2018", "3", "20", "12"));
        assertEquals("2016-2-28", nextNdays.nextNdays("2016", "2", "20", "8"));
        assertEquals("2016-2-29", nextNdays.nextNdays("2016", "2", "20", "9"));
        assertEquals("2016-3-1", nextNdays.nextNdays("2016", "2", "20", "10"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2016", "2", "20", "-100"));
        assertEquals("2016-2-20", nextNdays.nextNdays("2016", "2", "20", "0"));
        assertEquals("2017-2-28", nextNdays.nextNdays("2016", "2", "29", "365"));
        assertEquals("2017-3-1", nextNdays.nextNdays("2016", "2", "29", "366"));
        assertEquals("2043-7-17", nextNdays.nextNdays("2016", "2", "29", "10000"));

// lrh_testcase:
        assertEquals("2018-4-4", nextNdays.nextNdays("2018", "4", "1", "3"));
        assertEquals("2016-5-3", nextNdays.nextNdays("2016", "4", "28", "5"));
        assertEquals("2014-1-31", nextNdays.nextNdays("2014", "1", "27", "4"));
        assertEquals("2013-11-3", nextNdays.nextNdays("2013", "10", "29", "5"));
        assertEquals("2001-12-15", nextNdays.nextNdays("2001", "12", "12", "3"));
        assertEquals("2012-1-4", nextNdays.nextNdays("2011", "12", "28", "7"));
        assertEquals("2019-2-12", nextNdays.nextNdays("2019", "2", "4", "8"));
        assertEquals("2019-3-5", nextNdays.nextNdays("2019", "2", "20", "13"));
        assertEquals("2008-2-29", nextNdays.nextNdays("2008", "2", "2", "27"));
        assertEquals("2009-3-1", nextNdays.nextNdays("2009", "2", "3", "26"));
        assertEquals("2020-2-4", nextNdays.nextNdays("2019", "2", "4", "365"));
        assertEquals("2009-2-20", nextNdays.nextNdays("2008", "2", "20", "366"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2008", "0", "27", "0"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2001", "2", "29", "0"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2007", "13", "27", "0"));

// lh_testcase:
        assertEquals("2019-1-17", nextNdays.nextNdays("2019", "1", "17", "0"));
        assertEquals("2018-3-1", nextNdays.nextNdays("2018", "2", "28", "1"));
        assertEquals("2020-2-29", nextNdays.nextNdays("2020", "2", "28", "1"));
        assertEquals("2019-1-31", nextNdays.nextNdays("2019", "1", "30", "1"));
        assertEquals("2019-5-1", nextNdays.nextNdays("2019", "4", "30", "1"));
        assertEquals("2020-1-1", nextNdays.nextNdays("2019", "12", "31", "1"));
        assertEquals("2019-2-16", nextNdays.nextNdays("2019", "1", "17", "30"));
        assertEquals("2019-3-19", nextNdays.nextNdays("2019", "2", "17", "30"));
        assertEquals("2019-5-17", nextNdays.nextNdays("2019", "4", "17", "30"));
        assertEquals("2020-1-16", nextNdays.nextNdays("2019", "12", "17", "30"));
        assertEquals("2020-2-15", nextNdays.nextNdays("2019", "12", "17", "60"));
        assertEquals("2020-3-16", nextNdays.nextNdays("2019", "12", "17", "90"));
        assertEquals("2019-3-17", nextNdays.nextNdays("2018", "12", "17", "90"));
        assertEquals("2019-12-17", nextNdays.nextNdays("2018", "12", "17", "365"));
        assertEquals("2020-12-16", nextNdays.nextNdays("2019", "12", "17", "365"));
        assertEquals("2020-12-16", nextNdays.nextNdays("2018", "12", "17", "730"));
        assertEquals("2021-12-16", nextNdays.nextNdays("2018", "12", "17", "1095"));
        assertEquals("4756-11-13", nextNdays.nextNdays("2018", "12", "17", "1000000"));
        assertEquals("5881629-6-26", nextNdays.nextNdays("2018", "12", "17", "2147483647"));
        assertEquals("5881629-6-25", nextNdays.nextNdays("2018", "12", "17", "2147483646"));
        assertEquals("5881629-6-27", nextNdays.nextNdays("2018", "12", "17", "2147483648"));
        assertEquals("5881629-6-27", nextNdays.nextNdays("2018", "12", "17", "2147483648"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2018", "12", "17", "-1"));
        assertEquals("输入参数错误", nextNdays.nextNdays("2018", "12", "32", "1"));
        assertEquals("11761240-1-5", nextNdays.nextNdays("2018", "12", "17", "4294967295"));

    }

    @After
    public void tearDown() {

    }

}
