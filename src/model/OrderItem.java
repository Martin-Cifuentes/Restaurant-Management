package model;
public class OrderItem {
	public Product product;
	public String productSize;
	public double productPrice;
	public int productAmount;
	public OrderItem(Product pl, String ps, double pp, int qp) {
		this.product = pl;
		this.productSize = ps;
		this.productPrice = pp;
		this.productAmount = qp;
	}
	
	public String getProductName() {
		return product.getName();
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int quantityOfProduct) {
		this.productAmount = quantityOfProduct;
	}
	
}
