/**
 * 
 */
package cn.yh.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.yh.pojo.product.Attr;
import cn.yh.pojo.product.Brand;
import cn.yh.pojo.product.CateBrand;
import cn.yh.pojo.product.Product;
import cn.yh.pojo.product.Props;
import cn.yh.pojo.product.Spec;
import cn.yh.product.service.IAttrService;
import cn.yh.product.service.IBrandService;
import cn.yh.product.service.ICateBrandService;
import cn.yh.product.service.IProductService;
import cn.yh.product.service.IPropsService;
import cn.yh.product.service.ISpecService;
import cn.yh.st.common.api.ApiResponseEnity;
import cn.yh.st.common.util.SearchToQuery;
import cn.yh.vo.product.AddProductVo;
import cn.yh.vo.product.QueryProductVo;

/**
 * @author yuhang
 * @date 2019年5月15日
 * @desc
 */
@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private IProductService productService;
	@Autowired
	private IAttrService attrService;
	@Autowired
	private ISpecService specService;
	@Autowired
	private IPropsService propsService;
	@Autowired
	private IBrandService brandService;
	@Autowired
	private ICateBrandService cateBrandService;

	@GetMapping("getProductProperty")
	public ApiResponseEnity<?> getProductProperty(@RequestParam Long categoryId, @RequestParam Long userId) {
		List<Attr> attrs = attrService.list(new QueryWrapper<Attr>().eq("category_id", categoryId)
				.and(obj -> obj.eq("user_id", 0).or().eq("user_id", userId)));
		List<Spec> specs = specService.list(new QueryWrapper<Spec>().eq("category_id", categoryId)
				.and(obj -> obj.eq("user_id", 0).or().eq("user_id", userId)));
		List<Props> props = propsService.list(new QueryWrapper<Props>().eq("category_id", categoryId)
				.and(obj -> obj.eq("user_id", 0).or().eq("user_id", userId)));
		List<Brand> brands = brandService
				.list(new QueryWrapper<Brand>().and(obj -> obj.eq("user_id", 0).or().eq("user_id", userId)));
		List<CateBrand> cateBrands = cateBrandService.list(new QueryWrapper<CateBrand>().eq("category_id", categoryId));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("attrs", attrs);
		map.put("specs", specs);
		map.put("props", props);
		map.put("brands", brands);
		map.put("cateBrands", cateBrands);
		return new ApiResponseEnity<>(map);
	}

	/**
	 * 查询商品
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("listProduct")
	public ApiResponseEnity<Page<Product>> listProduct(@RequestBody @Validated QueryProductVo vo) {
		Page<Product> page = new Page<Product>(vo.getPageNo(), vo.getPageSize());
		QueryWrapper<Product> queryWrapper = SearchToQuery.getQuery(vo);

		if (vo.getCategoryId() != null) {
			queryWrapper.inSql("category_id",
					"select id from category where id=" + vo.getCategoryId() + " or p_id=" + vo.getCategoryId());
		}
		queryWrapper.orderByDesc("id");
		return new ApiResponseEnity<Page<Product>>((Page<Product>) productService.page(page, queryWrapper));
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	@PostMapping("addProduct")
	public ApiResponseEnity<Boolean> addProduct(@Validated @RequestBody AddProductVo vo) {
		productService.addProduct(vo);
		return new ApiResponseEnity<Boolean>();
	}

}
