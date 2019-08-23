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
 * @date 2019年8月23日
 * @desc
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SearchEsFieldAnnotation {

	String column() default "";

	/**
	 * 
	 * @return
	 */
	Type type();

	/**
	 * nestedPath
	 * 
	 * @return
	 */
	String nestedPath() default "";
}
