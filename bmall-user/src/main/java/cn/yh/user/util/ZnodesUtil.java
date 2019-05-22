/**
 * 
 */
package cn.yh.user.util;

import java.util.ArrayList;
import java.util.List;

import cn.yh.pojo.product.Category;
import cn.yh.vo.user.MAuthNodes;
import cn.yh.vo.user.Znodes;

/**
 * @author yuhang
 * @date 2019年5月6日
 * @desc
 */
public class ZnodesUtil {
	public static List<Znodes> createZnodes(List<MAuthNodes> list, List<Long> listRole) {
		List<Znodes> lz = new ArrayList<Znodes>();
		for (int i = 0; i < list.size(); i++) {
			MAuthNodes auth = list.get(i);
			Znodes nodes = new Znodes();
			nodes.setId(auth.getId().intValue());
			nodes.setName(auth.getAuthName());
			nodes.setOpen(true);
			nodes.setpId(auth.getpId());
			if (listRole.contains(auth.getId())) {
				nodes.setChecked(true);
			}
			lz.add(nodes);
		}
		return lz;
	}

	public static List<Znodes> createZnodesByCateGory(List<Category> list) {
		List<Znodes> lz = new ArrayList<Znodes>();
		for (int i = 0; i < list.size(); i++) {
			Category cate = list.get(i);
			Znodes nodes = new Znodes();
			nodes.setId(cate.getId().intValue());
			nodes.setName(cate.getCategoryName());
			nodes.setOpen(true);
			nodes.setpId(cate.getpId());
			lz.add(nodes);
		}
		return lz;
	}
}
