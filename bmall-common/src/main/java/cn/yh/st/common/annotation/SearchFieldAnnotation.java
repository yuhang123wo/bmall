/**
 * 
 */
package cn.yh.st.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yuhang
 * @date 2019年4月30日
 * @desc
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SearchFieldAnnotation {

	String column() default "";

	SearchType type() default SearchType.eq;
}
