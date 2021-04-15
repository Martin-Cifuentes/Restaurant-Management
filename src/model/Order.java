package model;


import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String code;
	public State state;
	public String requestClient;
	public String deliverEmployee;
	public String date;
	public ArrayList<String> observations;
	/*public ArrayList<Product> productsList;
	public ArrayList<String> productsSizes;
	public ArrayList<Integer> quantityOfProduct;*/
	public ArrayList<OrderItem> items;
	
	public Order(String c, State s, String rc, String de, String d, ArrayList<String> o, ArrayList<OrderItem> oi) {
		this.code = c;//
		this.state = s;//
		this.requestClient = rc;//
		this.deliverEmployee = de;//
		this.date = d;//
		this.observations = o;//
		this.items = oi;
		/*this.productsList = pl;
		this.quantityOfProduct = qp;*/
	}
	
	
	
	@Override
	public String toString() {
		return "Order [code=" + code + ", state=" + state + ", requestClient=" + requestClient + ", deliverEmployee="
				+ deliverEmployee + ", date=" + date + ", observations=" + observations + ", items=" + items + "]";
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public State getState() {
		return state;
	}
	
	public String getStateString() {
		String stateStr = "";
		if(state == State.SOLICITADO) {
			stateStr = "SOLICITADO";
		}else if(state == State.ENVIADO) {
			stateStr = "ENVIADO";
		}else if(state == State.ENTREGADO) {
			stateStr = "ENTREGADO";
		}else if(state == State.EN_PROCESO){
			stateStr = "EN PROCESO";
		}
		return stateStr;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getRequestClient() {
		return requestClient;
	}

	public void setRequestClient(String requestClient) {
		this.requestClient = requestClient;
	}

	public String getDeliverEmployee() {
		return deliverEmployee;
	}

	public void setDeliverEmployee(String deliverEmployee) {
		this.deliverEmployee = deliverEmployee;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public ArrayList<String> getObservations() {
		return observations;
	}
	
	public String getObservationsStr() {
		String obs = "";
		for(int i = 0; i < observations.size(); i++) {
			obs += observations.get(i) + "\n";
		}
		return obs;
	}
	public String getObservationsStrWhitoutLinejump() {
		String obs = "";
		for(int i = 0; i < observations.size(); i++) {
			obs += observations.get(i) + " ";
		}
		return obs;
	}

	public void setObservations(ArrayList<String> observations) {
		this.observations = observations;
	}

	public ArrayList<Product> getProductsList() {
		ArrayList<Product> productsList = new ArrayList<Product>();
		for(int i = 0; i < items.size(); i++) {
			productsList.add(items.get(i).getProduct());
		}
		return productsList;
	}
	
	public ArrayList<String> getProductsNames() {
		ArrayList<String> prodNames = new ArrayList<String>();
		for(int i = 0; i < items.size(); i++) {
			prodNames.add(items.get(i).getProductName());
		}
		return prodNames;
	}

	public ArrayList<Integer> getQuantityOfProduct() {
		ArrayList<Integer> quantityOfProduct = new ArrayList<Integer>();
		for(int i = 0; i < items.size(); i++) {
			quantityOfProduct.add(items.get(i).getProductAmount());
		}
		return quantityOfProduct;
	}
	
	public ArrayList<String> getQuantityOfProductStr() {
		ArrayList<String> prodAm = new ArrayList<String>();
		ArrayList<Integer> quantityOfProduct = getQuantityOfProduct();
		for(int i = 0; i < quantityOfProduct.size(); i++) {
			prodAm.add(String.valueOf(quantityOfProduct.get(i)));
		}
		return prodAm;
	}
	public ArrayList<Double> getProductsPricesList(){
		ArrayList<Double> prodPrice = new ArrayList<Double>();
		for(int i = 0; i < items.size(); i++) {
			prodPrice.add(items.get(i).getProductPrice());
		}
		return prodPrice;
	}

	public ArrayList<String> getProductsSizes() {
		ArrayList<String> productsSizes = new ArrayList<String>();
		for(int i = 0; i < items.size(); i++) {
			productsSizes.add(items.get(i).getProductSize());
		}
		return productsSizes;
	}

	public String exportProduct(String sep) {
		String export="";
		for(int c=0;c<items.size();c++){
			export+=sep+""+items.get(c).getProductName()+""+sep+""+items.get(c).getProductAmount()+""+sep+""+items.get(c).getProductPrice();
		}
		return export;
	}
	

	public ArrayList<OrderItem> getItems() {
		return items;
	}



	public void setItems(ArrayList<OrderItem> items) {
		this.items = items;
	}
	
	
}
