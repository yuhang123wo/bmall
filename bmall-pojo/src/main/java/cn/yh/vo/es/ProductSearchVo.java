/**
 * 
 */
package cn.yh.vo.es;

import java.util.List;

import cn.yh.pojo.product.Brand;
import cn.yh.pojo.product.Category;
import cn.yh.pojo.product.PRelaAttr;
import cn.yh.pojo.product.PRelaProps;
import cn.yh.pojo.product.PRelaSpec;
import cn.yh.pojo.product.Product;
import cn.yh.pojo.product.ProductDetail;
import cn.yh.pojo.product.ProductSku;

/**
 * @author yuhang
 * @date 2019年8月23日
 * @desc
 */
public class ProductSearchVo {

	private Product product;

	private ProductDetail detail;

	private List<ProductSku> skuList;

	private List<PRelaAttr> attrList;

	private List<PRelaProps> propsList;

	private List<PRelaSpec> specList;

	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductDetail getDetail() {
		return detail;
	}

	public void setDetail(ProductDetail detail) {
		this.detail = detail;
	}

	public List<ProductSku> getSkuList() {
		return skuList;
	}

	public void setSkuList(List<ProductSku> skuList) {
		this.skuList = skuList;
	}

	public List<PRelaAttr> getAttrList() {
		return attrList;
	}

	public void setAttrList(List<PRelaAttr> attrList) {
		this.attrList = attrList;
	}

	public List<PRelaProps> getPropsList() {
		return propsList;
	}

	public void setPropsList(List<PRelaProps> propsList) {
		this.propsList = propsList;
	}

	public List<PRelaSpec> getSpecList() {
		return specList;
	}

	public void setSpecList(List<PRelaSpec> specList) {
		this.specList = specList;
	}

}
