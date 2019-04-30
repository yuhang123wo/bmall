/**
 * 
 */
package cn.yh.user.util;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import cn.yh.vo.user.MAuthNodes;

/**
 * @author yuhang
 * @date 2019年4月30日
 * @desc
 */
public class TreeNodeUtil {

	public static List<MAuthNodes> getZnodes(List<MAuthNodes> treeNodes) {
		List<MAuthNodes> trees = new ArrayList<MAuthNodes>();
		for (MAuthNodes treeNode : treeNodes) {
			if (0 == treeNode.getpId()) {
				trees.add(findChildren(treeNode, treeNodes));
			}
		}
		return trees;
	}

	/**
	 * 递归查找子节点
	 * 
	 * @param treeNodes
	 * @return
	 */
	private static MAuthNodes findChildren(MAuthNodes treeNode, List<MAuthNodes> treeNodes) {
		for (MAuthNodes it : treeNodes) {
			if (treeNode.getId() == it.getpId()) {
				if (treeNode.getChild() == null) {
					treeNode.setChild(new ArrayList<MAuthNodes>());
				}
				treeNode.getChild().add(findChildren(it, treeNodes));
			}
		}
		return treeNode;
	}

	public static void main(String[] args) {
		List<MAuthNodes> list = new ArrayList<MAuthNodes>();
		MAuthNodes n1 = new MAuthNodes(1L, "1", 0L);
		MAuthNodes n2 = new MAuthNodes(2L, "1", 0L);
		MAuthNodes n3 = new MAuthNodes(3L, "1", 0L);
		MAuthNodes n4 = new MAuthNodes(4L, "1", 1L);
		MAuthNodes n5 = new MAuthNodes(5L, "1", 2L);
		MAuthNodes n6 = new MAuthNodes(6L, "1", 3L);
		MAuthNodes n7 = new MAuthNodes(7L, "1", 5L);
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);
		list.add(n6);
		list.add(n7);
		List<MAuthNodes> ls = getZnodes(list);

		System.out.println(JSON.toJSONString(ls));
	}
}
