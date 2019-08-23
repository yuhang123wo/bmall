/**
 * 
 */
package cn.yh.st.common.annotation;

/**
 * @author yuhang
 * @date 2019年8月23日
 * @desc
 */
public enum Type {
	REGEXPEQUERY {
		public String getName() {
			return "字符串匹配";
		}
	},
	REGEXPE2QUERY {
		public String getName() {
			return "正则表达式匹配";
		}
	},
	WILDCARDQUERY {
		public String getName() {
			return "wildcard匹配";
		}
	},
	PHRASEQUERY {
		public String getName() {
			return "字符串匹配";
		}
	},
	PHRASEQUERY_NEST {
		public String getName() {
			return "嵌套字符串匹配";
		}
	},
	TERMQUERY {
		public String getName() {
			return "完全匹配";
		}
	},
	NOTNULLQUERY {
		public String getName() {
			return "非空匹配";
		}
	},
	EQNULLQUERY {
		public String getName() {
			return "空匹配";
		}
	},
	IDQUERY {
		public String getName() {
			return "主键匹配";
		}
	},
	ANDOPERQUERY {
		public String getName() {
			return "与预算";
		}
	},
	NEQANDOPERQUERY {
		public String getName() {
			return "非与预算";
		}
	},
	TERMQUERYBATCH {
		public String getName() {
			return "完全匹配";
		}
	},
	TERMQUERY_NEST {
		public String getName() {
			return "完全匹配";
		}
	},
	TIMEQUERYBEGIN { // QUERY_NAME默认为开始时间
		public String getName() {
			return "时间查询(开始结束)";
		}
	},
	TIMEQUERYEND { // QUERY_NAME默认为开始时间
		public String getName() {
			return "时间查询(开始结束)";
		}
	},
	BACTHQUERY_NEST { // 多个参数用,隔开
		public String getName() {
			return "嵌套字符串批量查询";
		}
	};
	public abstract String getName();
}
