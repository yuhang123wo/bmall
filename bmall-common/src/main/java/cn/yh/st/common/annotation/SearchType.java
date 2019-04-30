/**
 * 
 */
package cn.yh.st.common.annotation;

/**
 * @author yuhang
 * @date 2019年4月30日
 * @desc
 */
public enum SearchType {
  
    /**
     * 等于 =
     */
     eq,
    /**
     * 不等于 &lt;&gt;
     */
     ne,

    /**
     * 大于 &gt;
     */
     gt,

    /**
     * 大于等于 &gt;=
     */
    ge,

    /**
     * 小于 &lt;
     */
    lt,


    /**
     * 小于等于 &lt;=
     */
    le,

    /**
     * LIKE '%值%'
     */
    like,
    /**
     * LIKE '%值'
     */
    likeLeft,

    /**
     * LIKE '值%'
     */
    likeRight,
	
    /**
     * in
     */
	in;
	
}
