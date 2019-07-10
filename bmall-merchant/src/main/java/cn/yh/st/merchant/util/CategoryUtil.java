/**
 * 
 */
package cn.yh.st.merchant.util;

import java.util.ArrayList;
import java.util.List;

import cn.yh.pojo.product.Category;
import cn.yh.st.merchant.vo.CategoryVO;
import cn.yh.util.ConvertUtil;

/**
 * @author yuhang
 * @date 2019年7月10日
 * @desc
 */
public class CategoryUtil {

	/**
	 * 
	 * @param treeNodes
	 * @return
	 */
	public static List<CategoryVO> getP(List<Category> treeNodes) {
		List<CategoryVO> trees = new ArrayList<CategoryVO>();
		for (Category treeNode : treeNodes) {
			trees.add(ConvertUtil.convert(treeNode, CategoryVO.class));
		}
		List<CategoryVO> result = new ArrayList<CategoryVO>();
		for (CategoryVO treeNode : trees) {
			if (treeNode.getpId().longValue() == 0) {
				treeNode.setList(buildTree(trees, treeNode.getId()));
				result.add(treeNode);
			}
		}
		return result;
	}

	private static List<CategoryVO> buildTree(List<CategoryVO> list, long parentId) {
		List<CategoryVO> voList = new ArrayList<CategoryVO>();
		for (CategoryVO v : list) {
			long pid = v.getpId();
			if (parentId == pid) {
				List<CategoryVO> menuLists = buildTree(list, v.getId());
				v.setList(menuLists);
				voList.add(v);
			}
		}
		return voList;
	}
}
