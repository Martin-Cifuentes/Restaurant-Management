package ui;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import model.Client;
import model.Dictionary;
import model.Employee;
import model.Ingredient;
import model.Language;
import model.Order;
import model.OrderItem;
import model.Product;
import model.Restaurant;

import model.SizeAndPrice;
import model.State;
import model.User;
import model.Word;


public class RestaurantGUI {

	private Restaurant restaurant;

	public RestaurantGUI() {
		restaurant= new Restaurant();
	}


	private String currentUser;
	private Language language = Language.ENGLISH;
	private Dictionary dictionary = new Dictionary(language);
	
	public final static String SEP = "\n";
	//main-pane
	@FXML
	private Pane mainPane;
	//main page
	@FXML
	private Label lbldateAndTime;
	//used to change the yyyy-MM-dd format
	private DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@FXML
    private ChoiceBox<String> cbLenguage;

	//admin-page
	@FXML
	private TextField txtUsuario;
	//admin-page
	@FXML
	private PasswordField txtPassword;
	//admin-page
	@FXML
	private Label lblAdminPagewarning;

	//Employee-page
	@FXML
	private TableView<Employee> tvEmployees;

	//Employee-page
	@FXML
	private TableColumn<Employee, String> tcName;

	//Employee-page
	@FXML
	private TableColumn<Employee, String> tcLastName;

	//Employee-page
	@FXML
	private TableColumn<Employee, String> tcId;

	//Employee-page
	@FXML
	private TableColumn<Employee, Integer> tcNumOfOrders;

	@FXML
	private TextField txtNameIgredient;

	@FXML
	private RadioButton rbtnAvailable;

	@FXML
	private ToggleGroup available;

	@FXML
	private RadioButton rbtnNotAvailable;


	//create-Employee
	@FXML
	private TextField txtEmployeeName;
	//create-Employee
	@FXML
	private TextField txtEmployeeLastName;
	//create-Employee

	@FXML
	private TextField txtEmployeeId;
	//create-Employee
	@FXML
	private TextField txtNumOfOrders;
	//create-Employee
	@FXML
	private Label confirmEmployee;
	//ingredient page
	@FXML
	private Label lblIngredientPageWarning;
	//addIngredients
	@FXML
	private Label lblAddIngredient;
	//ingredient
	@FXML
	private TableView<Ingredient> tvIngredients;
	//ingredient
	@FXML
	private TableColumn<Ingredient, String> tcIngredient;
	//ingredient
	@FXML
	private TableColumn<Ingredient, Boolean> tcAvialable;
	//admin ingredient
	@FXML
	private RadioButton rbtnAdminIngredientsAvielable;
	//admin ingredient
	@FXML
	private RadioButton rbtnAdminIngredientsNotAvailable;
	//admin ingredient
	@FXML
	private Label lblNameIngredient;
	//admin ingredient
	@FXML
	private ComboBox<String> cboxIngredients;
	//admin ingredient
	@FXML
	private ToggleGroup adminIngredoeint;
	//Export orders
	@FXML
	private DatePicker dPDate1;
	//Export orders
	@FXML
	private DatePicker dPDate2;
	//Export orders
	@FXML
	private Label lblExportOrderscsvWarning;
	//Export orders
	@FXML
	private TextField txtSep;

	//Export products 
	@FXML
	private DatePicker dpExportProductsDp1;
	//Export products
	@FXML
	private DatePicker dpExportProductsDp2;
	//Export products
	@FXML
	private Label lblexportProductWarnigns;



	@FXML
	private ListView<String> listA;



	//admin ingredient
	@FXML
	private Label lblIngredientCreatedBy;
	//admin ingredient
	@FXML
	private Label lblIngredientLastEditedBy;
	//addProduct-page
	@FXML
	private TextField txtPriceOfSizeOfProduct;
	//addProduct-page
	@FXML
	private TextField txtTypeOfProduct;
	//addProduct-page
	@FXML
	private TextField txtSizeOfProduct;
	//addProduct-page
	@FXML
	private TextField txtNameOfProduct;
	//addProduct-page
	@FXML
	private ComboBox<String> cboxIngredientsForProduct;
	//addProduct-page
	@FXML
	private Label lblSizeAndPriceOfProducts;
	//addProduct-page
	@FXML
	private Label lblIngredientsForProduct;
	//addProduct-page
	@FXML
	private Label lblAddProductWarning;

	//admin ingredient
	@FXML
	private Label lblAdminIngredientWarning;

	//Client-page
	@FXML
	private TableView<Client> tvClients;

	@FXML
	private TableColumn<Client, String> tcClientName;

	@FXML
	private ListView<String> lvClients;


	@FXML
	private TableColumn<Client, String> tcClientLastName;

	@FXML
	private TableColumn<Client, String> tcClientID;

	@FXML
	private TableColumn<Client, String> tcClientAdress;

	@FXML
	private TableColumn<Client, Integer> tcClientPhone;

	@FXML
	private Label lblTimeOfSearch;

	//product page
	@FXML
	private TableView<Product> tvProducts;
	//product page
	@FXML
	private TableColumn<Product, String> tcNameOfProduct;
	//product page
	@FXML
	private TableColumn<Product, String> tcTypeOfProduct;


	//create-Client
	@FXML
	private Button btnCreateClient;

	@FXML
	private Label tiltleCreateClient;

	@FXML
	private TextField txtClientName;

	@FXML
	private TextField txtClientLastName;

	@FXML
	private TextField txtClientID;

	@FXML
	private TextField txtClientAdress;

	@FXML
	private TextField txtClientPhone;


	/*@FXML
    private Button btnModifyClient;*/
	@FXML
	private TextArea txtClientObservations;

	@FXML
	private Label labConfirmClient;

	//modify-Clients
	@FXML
	private TextField txtModifyClientName;

	@FXML
	private TextField txtModifyClientLastName;

	@FXML
	private Label labModifyClientID;

	@FXML
	private TextField txtModifyClientAdress;

	@FXML
	private TextField txtModifyClientPhone;

	@FXML
	private TextArea txtModifyClientObservations;

	@FXML
	private Label labConfirmModifyClient;



	//Users-page
	@FXML
	private TableView<User> tvUsers;

	@FXML
	private TableColumn<User, String> tcUserUserName;

	@FXML
	private TableColumn<User, String> tcUserName;

	@FXML
	private TableColumn<User, String> tcUserLastName;

	@FXML
	private TableColumn<User, String> tcUserID;

	@FXML
	private TableColumn<User, Integer> tcUserNoo;

	//createUser

	@FXML
	private TextField txtUserUserName;

	@FXML
	private PasswordField txtUserPassword;

	@FXML
	private TextField txtUserName;

	@FXML
	private TextField txtUserLastName;

	@FXML
	private TextField txtUserID;

	@FXML
	private TextField txtUserNoo;

	@FXML
	private Label confirmCreateUser;

	//modify-User
	@FXML
	private TextField txtModifyUsersUserName;

	@FXML
	private PasswordField txtModifyUserPassword;

	@FXML
	private TextField txtModifyUsersName;


	//Orders-page
	@FXML
	private TableView<Order> tvOrders;

	@FXML
	private ListView<String> lvOrdersObs;

	@FXML
	private TableColumn<Order, String> tcOrderCode;

	@FXML
	private TableColumn<Order, String> tcOrderState;

	@FXML
	private TableColumn<Order, String> tcOrderClient;

	@FXML
	private TableColumn<Order, String> tcOrderEmployee;

	@FXML
	private TableColumn<Order, String> tcOrderDate;

	/*@FXML
    private ListView<String> lvOrderProductsPrice;

    @FXML
    private ListView<String> lvOrderProductsCant;

    @FXML
    private ListView<String> lvOrderProducts;

    @FXML
    private ListView<String> lvOrderProductsSize;*/

	@FXML
	private TableView<OrderItem> tvOrderItems;

	@FXML
	private TableColumn<OrderItem, String> tcOrderProduct;

	@FXML
	private TableColumn<OrderItem, Integer> tcOrderProductAmount;

	@FXML
	private TableColumn<OrderItem, String> tcOrderProductSize;

	@FXML
	private TableColumn<OrderItem, Double> tcOrderProductPrice;

	@FXML
	private Label labTotalPrice;


	//create-Order
	@FXML
	private TextArea txtOrderObs;

	@FXML
	private Label labConfirmOrder;

	@FXML
	private Label labConfirmAddOrderS1;

	/*@FXML
	private TextField txtClientOrderName;

    @FXML
	private TextField txtEmployeeOrderName;*/
	@FXML
	private ChoiceBox<String> cbAbleClients;

	@FXML
	private ChoiceBox<String> cbAbleEmployees;

	@FXML
	private ChoiceBox<String> cbOrderState;

	@FXML
	private DatePicker calendarDate;

	//create-Order1

	@FXML
	private TableView<OrderItem> tvListOrderProducts;

	@FXML
	private TableColumn<OrderItem, String> tcCreateOrderProduct;

	@FXML
	private TableColumn<OrderItem, Integer> tcCreateOrderProductAmount;

	//addProductToOrder-page
	@FXML
	private Label labConfirmProductToOrder;

	@FXML
	private TextField txtProductCant;

	@FXML
	private ChoiceBox<String> cbProductsToOrder;

	@FXML
	private ChoiceBox<String> cbProductsSize;

	//modify-Orderp1
	@FXML
	private TableView<OrderItem> tvListModifyOrderProducts;

	@FXML
	private TableColumn<OrderItem, String> tcModifyOrderProduct;

	@FXML
	private TableColumn<OrderItem, Integer> tcModifyOrderProductAmount;

	@FXML
	private Label labConfirmModifyOrderS1;

	//modify-Orderp2
	@FXML
	private TextArea txtModifyOrderObs;

	@FXML
	private DatePicker modifyCalendarDate;

	@FXML
	private ChoiceBox<String> cbModifyOrderState;

	@FXML
	private ChoiceBox<String> cbModifyAbleClients;

	@FXML
	private ChoiceBox<String> cbModifyAbleEmployees;

	@FXML
	private Label labConfirmModifyOrder;

	@FXML
	private Label oldDate;

	@FXML
	private Label labOrderCode;

	@FXML
	private Label labOrderCode2;
	
	/////initialize variables with languages
	
	//addIngredientAndSizePrice-page.fxml

    @FXML
    private Button btnBackIngSizeAndPrice;

    @FXML
    private Button btnAddSizeAndPriceIngSizeAndPrice;

    @FXML
    private Button btnAddingredientIngSizeAndPrice;

    @FXML
    private Label labSizeIngSizeAndPrice;

    @FXML
    private Label labPriceIngSizeAndPrice;
	
	//addIngredient-page.fxml
    
    @FXML
    private Label labIngNameAddIngredient;

    @FXML
    private Button btnAddAddIngredient;

    @FXML
    private Button btnBackAddIngredient;
	
	//addProduct-page.fxml
    
    @FXML
    private Button btnEraseIngredientsProdPage;

    @FXML
    private Label labProdNameProdPage;

    @FXML
    private Label labProdTypeProdPage;

    @FXML
    private Label labProdSizeProdPage;

    @FXML
    private Label labProdPriceProdPage;

    @FXML
    private Button btnAddSizeProdPage;

    @FXML
    private Label labIngredientsProdPage;

    @FXML
    private Button btnAddIngredientProdPage;

    @FXML
    private Label labSizeAndPricesToAddProdPage;

    @FXML
    private Label labIngredientsToAddProdPage;

    @FXML
    private Button btnEraseSizeAndPriceProdPage;

    @FXML
    private Button btnCreateProductProdPage;

    @FXML
    private Button btnBackProdPage;

	//addProductToModifyOrder-page.fxml
    
    @FXML
    private Button btnBackProdToModOrd;

    @FXML
    private Button labAddProdToModOrd;

    @FXML
    private Label labTitleProdToModOrd;

    @FXML
    private Label labProdProdToModOrd;

    @FXML
    private Label labAmountProdToModOrd;
    
    @FXML
    private Label labSizeProdToModOrd;
    
	//addProductToOrder-page.fxml
    
    @FXML
    private Button btnBackProdToOrd;

    @FXML
    private Button labAddProdToOrd;

    @FXML
    private Label labTitleProdToOrd;

    @FXML
    private Label labProdProdToOrd;

    @FXML
    private Label labAmountProdToOrd;

    @FXML
    private Label labSizeProdToOrd;
	
	//admin-ingredients.fxml

    @FXML
    private Button btnBackAdminIng;

    @FXML
    private Button btnSaveChangesAdminIng;

    @FXML
    private Button btnDeleteIngredientAdmingIng;

    @FXML
    private Label labCreatedByAdminIng;

    @FXML
    private Label labLastChangeAdminIng;

    @FXML
    private Label labSelectIngredientAdminIng;    
	
	//admin-page.fxml
    
    @FXML
    private Label labUserAdminPage;

    @FXML
    private Label labPassAdminPage;

    @FXML
    private Button btnLogInAdminPage;

    @FXML
    private Button btnBackAdminPage;
	
	//admin-product-page.fxml

    @FXML
    private Label labTypeOfProdAdminProdPage;

    @FXML
    private Button btnDeleteIngredientAdminProdPage;

    @FXML
    private Button btnSaveSizeAndPriceAdminProdPage;

    @FXML
    private Button btnSaveChangesAdminProdPage;

    @FXML
    private Button btnDeleteProdAdminProdPage;

    @FXML
    private Button btnBackAdminProdPage;

    @FXML
    private Button btnDeleteSizeAndPriceAdminProdPage;

    @FXML
    private Label labNameAdminProdPage;

    @FXML
    private Button btnAddIngredientsOrSizes;

    @FXML
    private Label labModProdAdminProdPage;

    @FXML
    private Label labSelectIngredientAdminProdPage;

    @FXML
    private Label labSelectSizeAdminProdPage;
    
    @FXML
    private Label labTitleAdminProdPage;
	
	//Clients-page.fxml
    
    @FXML
    private Button btnAddClientCliPage;

    @FXML
    private Button btnDeleteCliPage;

    @FXML
    private Label labTitleCliPage;

    @FXML
    private Button btnBackCliPage;

    @FXML
    private Button btnUpdateCliPage;

    @FXML
    private Button btnModifyCliPage;

    @FXML
    private Button btnSearchClientCliPage;

    @FXML
    private Button btnImportClientsCliPage;
    
	//create-Client.fxml
    
    @FXML
    private Button btnBackCreateClient;

    @FXML
    private Button btnCreateCreateClient;

    @FXML
    private Label labNameCreateClient;

    @FXML
    private Label labLastNameCreateClient;

    @FXML
    private Label labIDCreateClient;

    @FXML
    private Label labAdressCreateClient;

    @FXML
    private Label labPhoneCreateClient;

    @FXML
    private Label labTitleCreateClient;

    @FXML
    private Label labObsCreateClient;
	
	//create-Employee.fxml          ////
	
    @FXML
    private Button btnAddCreateEmp;

    @FXML
    private Label labIDCreateEmp;

    @FXML
    private Label labNameCreateEmp;

    @FXML
    private Label labLastNameCreateEmp;

    @FXML
    private Label labAmountOfOrdCreateEmp;

    @FXML
    private Button btnBackCreateEmp;
    
    @FXML
    private Label labTitleCreateEmp;
    
	//create-Order.fxml
    @FXML
    private Button btnAddAddOrder;

    @FXML
    private Label labCliNameAddOrder;

    @FXML
    private Label labEmployeeOnChargeAddOrder;

    @FXML
    private Label labObsAddOrder;

    @FXML
    private Label labTitleAddOrder;

    @FXML
    private Label labStateAddOrder;

    @FXML
    private Label labDateAddOrder;

    @FXML
    private Button btnExitAddOrder;

    @FXML
    private Button btnBackAddOrder;
    
	//create-Order1.fxml
    
    @FXML
    private Label labTitleAddOrder2;

    @FXML
    private Button btnSearchProdAddOrder2;

    @FXML
    private Button btnDeleteProdAddOrder2;

    @FXML
    private Button btnUpdTableAddOrder2;

    @FXML
    private Button btnBackAddOrder2;

    @FXML
    private Button btnContinueAddOrder2;
	
	//create-User.fxml
    
    @FXML
    private Button btnBackCreateUser;

    @FXML
    private Button btnAddCreateUser;

    @FXML
    private Label labNameCreateUser;

    @FXML
    private Label labLastNameCreateUser;

    @FXML
    private Label labTitleCreateUser;

    @FXML
    private Label labIDCreateUser;

    @FXML
    private Label labUserNameCreateUser;

    @FXML
    private Label labNumOfOrdCreateUser;

    @FXML
    private Label labPassCreateUser;
    
	//Employee-page.fxml
    
    @FXML
    private Button btnAddEmploEmploPage;

    @FXML
    private Button btnBackEmploPage;

    @FXML
    private Label labTitleEmploPage;

    @FXML
    private Button btnModifyEmploPage;

    @FXML
    private Button btnDeleteEmploPage;

    @FXML
    private Button btnUpdateEmploPage;
	
	//ExportOrdercsv.fxml

    @FXML
    private Label labFromExpOrds;

    @FXML
    private Label labTillExpOrds;

    @FXML
    private Label labIncludeExpOrds;

    @FXML
    private Button btnGenDataExpOrds;

    @FXML
    private Label labColumnSepExpOrds;

    @FXML
    private Button btnBackExpOrds;
	
	//exportProducts.fxml
    
    @FXML
    private Button btnExportExpProd;

    @FXML
    private Button btnBackExpProd;

    @FXML
    private Label labIncludeExpProd;

    @FXML
    private Label labFromExpProd;

    @FXML
    private Label labTillExpProd;
    
	//ingredient-page.fxml
    @FXML
    private Button btnAddIngIngPage;

    @FXML
    private Button btnBackIngPage;

    @FXML
    private Button btnAdminIngIngPage;

    @FXML
    private Button btnOrgaizeByNameIngPage;

    @FXML
    private Button btnImportIngIngPage;
    
	//logged-in-page.fxml
    
    @FXML
    private Button btnProductsLogPage;

    @FXML
    private Button btnIngredientsLogPage;

    @FXML
    private Button btnOrdersPage;

    @FXML
    private Button btnEmployeesLogPage;

    @FXML
    private Button btnClientsLogPage;

    @FXML
    private Button btnUsersLogPage;

    @FXML
    private Button btnBackLogPage;

    @FXML
    private Button btnDeleteallDataLogPage;

    @FXML
    private Button btnExpOrdersLogPage;

    @FXML
    private Button btnExpProdLogPage;
    
	//main-page.fxml
    
    @FXML
    private Button btnMenuMainPage;

    @FXML
    private Button btnAdminMainPage;

    @FXML
    private Label labLanguageMainPage;

    @FXML
    private Button btnAplyMainPage;

	
	//menu-page.fxml
    @FXML
    private Button btnBackMenu;

    @FXML
    private Label labTitleMenu;

    @FXML
    private Label labsearchProdMenu;

    @FXML
    private Button btnSearchMenu;

    @FXML
    private Button btnPreviusMenu;

    @FXML
    private Button btnNextMenu;

    @FXML
    private Button btnDeleteSearchMenu;
    
	//modify-Client.fxml
    
    @FXML
    private Button btnBackModCli;

    @FXML
    private Button btnModifyModCli;

    @FXML
    private Label labNameModCli;

    @FXML
    private Label labLastNameModCli;

    @FXML
    private Label labIDModCli;

    @FXML
    private Label labAdressModCli;

    @FXML
    private Label labPhoneModCli;

    @FXML
    private Label labTitleModCli;

    @FXML
    private Label labObsModCli;
    
	//modify-Employee.fxml
    
    @FXML
    private Button btnModifyModEmplo;

    @FXML
    private Label labIDModEmplo;

    @FXML
    private Label labNameModEmplo;

    @FXML
    private Label labLastNameModEmplo;

    @FXML
    private Label labOrdAmountModEmplo;

    @FXML
    private Label labTitleModEmplo;

    @FXML
    private Button btnBackModEmplo;
    
	//modify-Orderp1.fxml
    
    @FXML
    private Label labTitleModOrd2;

    @FXML
    private Button btnSearchProdModOrd2;

    @FXML
    private Button btnDeleteProdModOrd2;

    @FXML
    private Button btnUpdateTvModOrd2;

    @FXML
    private Button btnBackModOrd2;

    @FXML
    private Button btnModifyModOrd2;

    @FXML
    private Label labcodeModOrd2;
    
	//modify-Orderp2.fxml
    
    @FXML
    private Button btnModifyModOrd1;

    @FXML
    private Label labcliNameModOrd1;

    @FXML
    private Label labEmpOnChargeModOrd1;

    @FXML
    private Label labObsModOrd1;

    @FXML
    private Label labTitleModOrd1;

    @FXML
    private Label labStateModOrd1;

    @FXML
    private Label labDateModOrd1;

    @FXML
    private Button btnExitModOrd1;

    @FXML
    private Button btnBackModOrd1;

    @FXML
    private Label labcodeModOrd1;

    @FXML
    private Label labActDateModOrd1;
    
	//modify-User.fxml
    
    @FXML
    private Button btnBackModUser;

    @FXML
    private Button btnModifyModUser;

    @FXML
    private Label labNameModUser;

    @FXML
    private Label labLastNameModUser;

    @FXML
    private Label labTitleModUser;

    @FXML
    private Label labIDModUser;

    @FXML
    private Label labUserNameModUser;

    @FXML
    private Label labNumOfOrdModUser;

    @FXML
    private Label labpassModUser;
    
	//Orders-page.fxml
    
    @FXML
    private Button btnBackOrdPage;

    @FXML
    private Button btnAddOrdOrdPage;

    @FXML
    private Button btnModProdOrdPage;

    @FXML
    private Button btnDeleteOrdPage;

    @FXML
    private Label labObsOrdPage;

    @FXML
    private Button btnUpdateOrdPage;

    @FXML
    private Label labTotalOrdPage;

    @FXML
    private Button btnModOrdOrdPage;

    @FXML
    private Button btnImportOrdOrdPage;
    
	//product-page.fxml
    
    @FXML
    private Button btnAddProdProdPage;

    @FXML
    private Button btnAdminProdProdPage;

    @FXML
    private Button btnBackProductPage;

    @FXML
    private Button btnImportProdProdPage;
	
	//searchClient-page.fxml

    @FXML
    private Button btnSearchSearchClient;

    @FXML
    private Button btnBackSearchClient;

    @FXML
    private Label labNameSearchClient;

    @FXML
    private Label labLastNameSearchClient;

    @FXML
    private Label labIDSearchClient;

    @FXML
    private Label labAdressSearchClient;

    @FXML
    private Label labPhoneSearchClient;

    @FXML
    private Label labObsSearchClient;

    @FXML
    private Label labSearchClientByIdSearchClient;

    @FXML
    private Label labTimeSearchClient;
    
    //Users-page.fxml
    
    @FXML
    private Label labTitleUserPage;

    @FXML
    private Button btnBackUserPage;

    @FXML
    private Button btnUpdateUserPage;

    @FXML
    private Button btnaddUserUserPage;

    @FXML
    private Button btnModifyUserPage;

    @FXML
    private Button btnDeleteUserPage;
    
	////initialize screens with languages
	
	void loadLanguageAddIngredientAndSizePricePage() {//1
		btnBackIngSizeAndPrice.setText(dictionary.getValueOf("back"));
		btnAddSizeAndPriceIngSizeAndPrice.setText(dictionary.getValueOf("Add size and price"));
		btnAddingredientIngSizeAndPrice.setText(dictionary.getValueOf("Add ingredient"));
		labSizeIngSizeAndPrice.setText(dictionary.getValueOf("Size"));
		labPriceIngSizeAndPrice.setText(dictionary.getValueOf("Price"));
	}
	
	void loadLanguageAddIngredientPage(){//2
		rbtnAvailable.setText(dictionary.getValueOf("Available"));
		rbtnNotAvailable.setText(dictionary.getValueOf("Not available"));
		labIngNameAddIngredient.setText(dictionary.getValueOf("Ingredient name"));
		btnAddAddIngredient.setText(dictionary.getValueOf("Add"));
		btnBackAddIngredient.setText(dictionary.getValueOf("back"));
	}
	
	void loadLanguageAddProductPage() {//3
		btnEraseIngredientsProdPage.setText(dictionary.getValueOf("Delete ingredient"));
		labProdNameProdPage.setText(dictionary.getValueOf("Product name"));
		labProdTypeProdPage.setText(dictionary.getValueOf("Product type"));
		labProdSizeProdPage.setText(dictionary.getValueOf("Size"));
		labProdPriceProdPage.setText(dictionary.getValueOf("Size Price"));
		btnAddSizeProdPage.setText(dictionary.getValueOf("Add size"));
		labIngredientsProdPage.setText(dictionary.getValueOf("Ingredients"));
		btnAddIngredientProdPage.setText(dictionary.getValueOf("Add ingredient"));
		labSizeAndPricesToAddProdPage.setText(dictionary.getValueOf("Sizes and prices to add"));
		labIngredientsToAddProdPage.setText(dictionary.getValueOf("Ingredients to add"));
		btnEraseSizeAndPriceProdPage.setText(dictionary.getValueOf("Delete Size and Price"));
		btnCreateProductProdPage.setText(dictionary.getValueOf("Create product"));
		btnBackProdPage.setText(dictionary.getValueOf("Back"));
	}
	
	void loadLanguageAddProductToModifyOrderPage() {//4
	    btnBackProdToModOrd.setText(dictionary.getValueOf("Back"));
	    labAddProdToModOrd.setText(dictionary.getValueOf("Add"));
	    labTitleProdToModOrd.setText(dictionary.getValueOf("Add product"));
	    labProdProdToModOrd.setText(dictionary.getValueOf("Product"));
	    labAmountProdToModOrd.setText(dictionary.getValueOf("Quantity"));
	    labSizeProdToModOrd.setText(dictionary.getValueOf("Size"));
	}
	
	void loadLanguageAddProductToOrderPage() {//5
		btnBackProdToOrd.setText(dictionary.getValueOf("Back"));
	    labAddProdToOrd.setText(dictionary.getValueOf("Add"));
	    labTitleProdToOrd.setText(dictionary.getValueOf("Add product"));
	    labProdProdToOrd.setText(dictionary.getValueOf("Product"));
	    labAmountProdToOrd.setText(dictionary.getValueOf("Quantity"));
	    labSizeProdToOrd.setText(dictionary.getValueOf("Size"));
	}
	
	void loadLanguageAdminIngredients() {//6
		rbtnAdminIngredientsAvielable.setText(dictionary.getValueOf("Available"));
	    rbtnAdminIngredientsNotAvailable.setText(dictionary.getValueOf("Not available"));
	    lblNameIngredient.setText(dictionary.getValueOf("Name"));
	    btnBackAdminIng.setText(dictionary.getValueOf("Back"));
	    btnSaveChangesAdminIng.setText(dictionary.getValueOf("Save Changes"));
	    btnDeleteIngredientAdmingIng.setText(dictionary.getValueOf("Delete ingredient"));
	    labCreatedByAdminIng.setText(dictionary.getValueOf("Created by"+":"));
	    labLastChangeAdminIng.setText(dictionary.getValueOf("Last change by"+":"));
	    labSelectIngredientAdminIng.setText(dictionary.getValueOf("Select ingredient"));
	}
	
	void loadLanguageAdminPage() {//7
		labUserAdminPage.setText(dictionary.getValueOf("User"));
		labPassAdminPage.setText(dictionary.getValueOf("Password"));
	    btnLogInAdminPage.setText(dictionary.getValueOf("Log in"));
	    btnBackAdminPage.setText(dictionary.getValueOf("Back"));
	}
	
	void loadLanguageAdminProductPage() {//8
		txtSizeOfProductAdmin.setText(dictionary.getValueOf("Size"));
	    txtPriceOfSizeOfProductAdmin.setText(dictionary.getValueOf("Price"));
	    lblCreatedByProduct.setText(dictionary.getValueOf("Created by"+":"));
	    lblLastEditedByProduct.setText(dictionary.getValueOf("Last change by"+":"));
	    lblAvialableIngredientProduct.setText(dictionary.getValueOf("Availability"));
	    labTypeOfProdAdminProdPage.setText(dictionary.getValueOf("Product type"));
	    btnDeleteIngredientAdminProdPage.setText(dictionary.getValueOf("Delete ingredient"));
	    btnSaveSizeAndPriceAdminProdPage.setText(dictionary.getValueOf("Save size and price"));
	    btnSaveChangesAdminProdPage.setText(dictionary.getValueOf("Save Changes"));
	    btnDeleteProdAdminProdPage.setText(dictionary.getValueOf("Delete product"));
	    btnBackAdminProdPage.setText(dictionary.getValueOf("Back"));
	    btnDeleteSizeAndPriceAdminProdPage.setText(dictionary.getValueOf("Delete Size and Price"));
	    labNameAdminProdPage.setText(dictionary.getValueOf("Name"));
	    btnAddIngredientsOrSizes.setText(dictionary.getValueOf("Add ingredients or sizes"));
	    labModProdAdminProdPage.setText(dictionary.getValueOf("Select product"));
	    labSelectIngredientAdminProdPage.setText(dictionary.getValueOf("Select ingredient"));
	    labSelectSizeAdminProdPage.setText(dictionary.getValueOf("Select size"));
	    labTitleAdminProdPage.setText(dictionary.getValueOf("Modify Products"));
	}
	
	void loadLanguageClientsPage() {//9
	    tcClientName.setText(dictionary.getValueOf("Name"));
	    tcClientLastName.setText(dictionary.getValueOf("Surname"));
	    tcClientID.setText(dictionary.getValueOf("ID"));
	    tcClientAdress.setText(dictionary.getValueOf("Adress"));
	    tcClientPhone.setText(dictionary.getValueOf("Telephone"));
	    btnAddClientCliPage.setText(dictionary.getValueOf("Add client"));
	    btnDeleteCliPage.setText(dictionary.getValueOf("Delete"));
	    labTitleCliPage.setText(dictionary.getValueOf("Clients"));
	    btnBackCliPage.setText(dictionary.getValueOf("Back"));
	    btnUpdateCliPage.setText(dictionary.getValueOf("Update"));
	    btnModifyCliPage.setText(dictionary.getValueOf("Modify"));
	    btnSearchClientCliPage.setText(dictionary.getValueOf("Search client"));
	    btnImportClientsCliPage.setText(dictionary.getValueOf("Import clients"));
	}
	
	void loadLanguageCreateClient() {//10
		txtClientObservations.setPromptText(dictionary.getValueOf("Each Observation is separated with a line break"));
	    btnBackCreateClient.setText(dictionary.getValueOf("Back"));
	    btnCreateCreateClient.setText(dictionary.getValueOf("Add client"));
	    labNameCreateClient.setText(dictionary.getValueOf("Name"));
	    labLastNameCreateClient.setText(dictionary.getValueOf("Surname"));
	    labIDCreateClient.setText(dictionary.getValueOf("ID"));
	    labAdressCreateClient.setText(dictionary.getValueOf("Adress"));
	    labPhoneCreateClient.setText(dictionary.getValueOf("Telephone"));
	    labTitleCreateClient.setText(dictionary.getValueOf("Create client"));
	    labObsCreateClient.setText(dictionary.getValueOf("Observations"));
	}
	
	void loadLanguageCreateEmployee() {//11
		btnAddCreateEmp.setText(dictionary.getValueOf("Add"));
	    labIDCreateEmp.setText(dictionary.getValueOf("ID"));
	    labNameCreateEmp.setText(dictionary.getValueOf("Name"));
	    labLastNameCreateEmp.setText(dictionary.getValueOf("Surname"));
	    labAmountOfOrdCreateEmp.setText(dictionary.getValueOf("Orders delivered"));
	    btnBackCreateEmp.setText(dictionary.getValueOf("Back"));
	    labTitleCreateEmp.setText(dictionary.getValueOf("Create Employee"));
	}
	
	void loadLanguageCreateOrder() {//12
		txtOrderObs.setPromptText(dictionary.getValueOf("Each Observation is separated with a line break"));
	    btnAddAddOrder.setText(dictionary.getValueOf("Add"));
	    labCliNameAddOrder.setText(dictionary.getValueOf("Client name"));
	    labEmployeeOnChargeAddOrder.setText(dictionary.getValueOf("Employee in charge"));
	    labObsAddOrder.setText(dictionary.getValueOf("Observations"));
	    labTitleAddOrder.setText(dictionary.getValueOf("Create Order: Step 2"));
	    labStateAddOrder.setText(dictionary.getValueOf("State"));
	    labDateAddOrder.setText(dictionary.getValueOf("Date"));
	    btnExitAddOrder.setText(dictionary.getValueOf("Exit"));
	    btnBackAddOrder.setText(dictionary.getValueOf("Back"));
	    ObservableList<String> observableListStates = FXCollections.observableArrayList(dictionary.getValueOf("Requested")
	    											,dictionary.getValueOf("Sent"),dictionary.getValueOf("In progress")
	    											,dictionary.getValueOf("Delivered"));
		cbOrderState.setItems(observableListStates);
	}
	
	void loadLanguageCreateOrder1() {//13
		tcCreateOrderProduct.setText(dictionary.getValueOf("Add product"));
	    tcCreateOrderProductAmount.setText(dictionary.getValueOf("Add"));
	    labTitleAddOrder2.setText(dictionary.getValueOf("Create Order: Step 1"));
	    btnSearchProdAddOrder2.setText(dictionary.getValueOf("Search product"));
	    btnDeleteProdAddOrder2.setText(dictionary.getValueOf("Delete product"));
	    btnUpdTableAddOrder2.setText(dictionary.getValueOf("Update table"));
	    btnBackAddOrder2.setText(dictionary.getValueOf("Back"));
	    btnContinueAddOrder2.setText(dictionary.getValueOf("Continue"));
	}
	
	void loadLanguageCreateUser() {//14
		btnBackCreateUser.setText(dictionary.getValueOf("Back"));
	    btnAddCreateUser.setText(dictionary.getValueOf("Add"));
	    labNameCreateUser.setText(dictionary.getValueOf("Name"));
	    labLastNameCreateUser.setText(dictionary.getValueOf("Surname"));
	    labTitleCreateUser.setText(dictionary.getValueOf("Create User"));
	    labIDCreateUser.setText(dictionary.getValueOf("ID"));
	    labUserNameCreateUser.setText(dictionary.getValueOf("Username"));
	    labNumOfOrdCreateUser.setText(dictionary.getValueOf("Orders delivered"));
	    labPassCreateUser.setText(dictionary.getValueOf("Password"));
	}
	
	void loadLanguageEmployeePage() {//15
		tcName.setText(dictionary.getValueOf("Name"));
	    tcLastName.setText(dictionary.getValueOf("Surname"));
	    tcId.setText(dictionary.getValueOf("ID"));
	    tcNumOfOrders.setText(dictionary.getValueOf("Orders delivered"));
	    btnAddEmploEmploPage.setText(dictionary.getValueOf("Add employees"));
	    btnBackEmploPage.setText(dictionary.getValueOf("Back"));
	    labTitleEmploPage.setText(dictionary.getValueOf("Create Employee"));
	    btnModifyEmploPage.setText(dictionary.getValueOf("Modify"));
	    btnDeleteEmploPage.setText(dictionary.getValueOf("Delete"));
	    btnUpdateEmploPage.setText(dictionary.getValueOf("Update"));
	}
	
	void loadLanguageExportOrdercsvPage() {//16
		labFromExpOrds.setText(dictionary.getValueOf("From"));
	    labTillExpOrds.setText(dictionary.getValueOf("Till"));
	    labIncludeExpOrds.setText(dictionary.getValueOf("Include"));
	    btnGenDataExpOrds.setText(dictionary.getValueOf("Generate file"));
	    labColumnSepExpOrds.setText(dictionary.getValueOf("Column separator"));
	    btnBackExpOrds.setText(dictionary.getValueOf("Back"));
	}
	
	void loadLanguageExportProductsPage() {//17
		btnExportExpProd.setText(dictionary.getValueOf("Export"));
	    btnBackExpProd.setText(dictionary.getValueOf("Back"));
	    labIncludeExpProd.setText(dictionary.getValueOf("Include"));
	    labFromExpProd.setText(dictionary.getValueOf("From"));
	    labTillExpProd.setText(dictionary.getValueOf("Till"));
	}
	
	void loadLanguageIngredientPage() {//18
		tcIngredient.setText(dictionary.getValueOf("Ingredient"));
	    tcAvialable.setText(dictionary.getValueOf("Available"));
	    btnAddIngIngPage.setText(dictionary.getValueOf("Add ingredient"));
	    btnBackIngPage.setText(dictionary.getValueOf("Back"));
	    btnAdminIngIngPage.setText(dictionary.getValueOf("Manage Ingredient"));
	    btnOrgaizeByNameIngPage.setText(dictionary.getValueOf("Organize by name"));
	    btnImportIngIngPage.setText(dictionary.getValueOf("Import ingredients"));
	}
	
	void loadLanguageLoggedInPage() {//19
		btnProductsLogPage.setText(dictionary.getValueOf("Products"));
	    btnIngredientsLogPage.setText(dictionary.getValueOf("Ingredients"));
	    btnOrdersPage.setText(dictionary.getValueOf("Orders"));
	    btnEmployeesLogPage.setText(dictionary.getValueOf("Employees"));
	    btnClientsLogPage.setText(dictionary.getValueOf("Clients"));
	    btnUsersLogPage.setText(dictionary.getValueOf("Users"));
	    btnBackLogPage.setText(dictionary.getValueOf("Back"));
	    btnDeleteallDataLogPage.setText(dictionary.getValueOf("Delete all saved data"));
	    btnExpOrdersLogPage.setText(dictionary.getValueOf("Export orders csv"));
	    btnExpProdLogPage.setText(dictionary.getValueOf("Export csv of products"));
	}
	
	void loadLanguageMainPage() {//20
		btnMenuMainPage.setText(dictionary.getValueOf("Menu"));
		btnAdminMainPage.setText(dictionary.getValueOf("Admin"));
		labLanguageMainPage.setText(dictionary.getValueOf("Language"));
		btnAplyMainPage.setText(dictionary.getValueOf("Update"));
	}
	
	void loadLanguageMenuPage() {//21
		btnBackMenu.setText(dictionary.getValueOf("Back"));
	    labTitleMenu.setText(dictionary.getValueOf("Menu"));
	    labsearchProdMenu.setText(dictionary.getValueOf("Search product"));
	    btnSearchMenu.setText(dictionary.getValueOf("Search"));
	    btnPreviusMenu.setText(dictionary.getValueOf("Previous"));
	    btnNextMenu.setText(dictionary.getValueOf("Next"));
	    btnDeleteSearchMenu.setText(dictionary.getValueOf("Clear search"));
	}
	
	void loadLanguageModifyClientPage() {//22
		btnBackModCli.setText(dictionary.getValueOf("Back"));
	    btnModifyModCli.setText(dictionary.getValueOf("Modify"));
	    labNameModCli.setText(dictionary.getValueOf("Name"));
	    labLastNameModCli.setText(dictionary.getValueOf("Surname"));
	    labIDModCli.setText(dictionary.getValueOf("ID"));
	    labAdressModCli.setText(dictionary.getValueOf("Adress"));
	    labPhoneModCli.setText(dictionary.getValueOf("Telephone"));
	    labTitleModCli.setText(dictionary.getValueOf("Modify Client"));
	    labObsModCli.setText(dictionary.getValueOf("Observations"));
	}
	
	void loadLanguageModifyEmployeePage() {//23
		btnModifyModEmplo.setText(dictionary.getValueOf("Modify"));
		labIDModEmplo.setText(dictionary.getValueOf("ID"));
		labNameModEmplo.setText(dictionary.getValueOf("Name"));
		labLastNameModEmplo.setText(dictionary.getValueOf("Surname"));
		labOrdAmountModEmplo.setText(dictionary.getValueOf("Orders delivered"));
		btnBackModEmplo.setText(dictionary.getValueOf("Back"));
	    labTitleModEmplo.setText(dictionary.getValueOf("Modify Employee"));
	}
	
	void loadLanguageModifyOrderp1Page() {//24
		tcModifyOrderProduct.setText(dictionary.getValueOf("Product"));
	    tcModifyOrderProductAmount.setText(dictionary.getValueOf("Amount"));
	    labTitleModOrd2.setText(dictionary.getValueOf("Modify Order Products"));
	    btnSearchProdModOrd2.setText(dictionary.getValueOf("Search product"));
	    btnDeleteProdModOrd2.setText(dictionary.getValueOf("Delete product"));
	    btnUpdateTvModOrd2.setText(dictionary.getValueOf("Update table"));
	    btnBackModOrd2.setText(dictionary.getValueOf("Back"));
	    btnModifyModOrd2.setText(dictionary.getValueOf("Modify"));
	    labcodeModOrd2.setText(dictionary.getValueOf("Code"));
	}
	
	void loadLanguageModifyOrderp2Page() {//25
		txtModifyOrderObs.setPromptText(dictionary.getValueOf("Each Observation is separated with a line break"));
	    btnModifyModOrd1.setText(dictionary.getValueOf("Modify"));
	    labcliNameModOrd1.setText(dictionary.getValueOf("Client name"));
	    labEmpOnChargeModOrd1.setText(dictionary.getValueOf("Product"));
	    labObsModOrd1.setText(dictionary.getValueOf("Observations"));
	    labTitleModOrd1.setText(dictionary.getValueOf("Modify order"));
	    labStateModOrd1.setText(dictionary.getValueOf("State"));
	    labDateModOrd1.setText(dictionary.getValueOf("Date"));
	    btnExitModOrd1.setText(dictionary.getValueOf("Exit"));
	    btnBackModOrd1.setText(dictionary.getValueOf("Back"));
	    labcodeModOrd1.setText(dictionary.getValueOf("Code"));
	    labActDateModOrd1.setText(dictionary.getValueOf("Current date"));
	}
	
	void loadLanguageModifyUserPage() {//26
		btnBackModUser.setText(dictionary.getValueOf("Back"));
	    btnModifyModUser.setText(dictionary.getValueOf("Modify"));
	    labNameModUser.setText(dictionary.getValueOf("Name"));
	    labLastNameModUser.setText(dictionary.getValueOf("Surname"));
	    labTitleModUser.setText(dictionary.getValueOf("Modify User"));
	    labIDModUser.setText(dictionary.getValueOf("ID"));
	    labUserNameModUser.setText(dictionary.getValueOf("Username"));
	    labNumOfOrdModUser.setText(dictionary.getValueOf("Orders delivered"));
	    labpassModUser.setText(dictionary.getValueOf("Password"));
	}
	
	void loadLanguageOrdersPage() {//27
		tcOrderCode.setText(dictionary.getValueOf("Code"));
	    tcOrderState.setText(dictionary.getValueOf("State"));
	    tcOrderClient.setText(dictionary.getValueOf("Client"));
	    tcOrderEmployee.setText(dictionary.getValueOf("Employee"));
	    tcOrderDate.setText(dictionary.getValueOf("Date"));
	    tcOrderProduct.setText(dictionary.getValueOf("Product"));
	    tcOrderProductAmount.setText(dictionary.getValueOf("Amount"));
	    tcOrderProductSize.setText(dictionary.getValueOf("Size"));
	    tcOrderProductPrice.setText(dictionary.getValueOf("Price"));
	    btnBackOrdPage.setText(dictionary.getValueOf("Back"));
	    btnAddOrdOrdPage.setText(dictionary.getValueOf("Add order"));
	    btnModProdOrdPage.setText(dictionary.getValueOf("Modify Products"));
	    btnDeleteOrdPage.setText(dictionary.getValueOf("Delete"));
	    labObsOrdPage.setText(dictionary.getValueOf("Observations"));
	    btnUpdateOrdPage.setText(dictionary.getValueOf("Update"));
	    labTotalOrdPage.setText(dictionary.getValueOf("Total"));
	    btnModOrdOrdPage.setText(dictionary.getValueOf("Modify products"));
	    btnImportOrdOrdPage.setText(dictionary.getValueOf("Import Orders"));
	}
	
	void loadLanguageProductPage() {//28
		tcNameOfProduct.setText(dictionary.getValueOf("Name"));
	    tcTypeOfProduct.setText(dictionary.getValueOf("Type"));
	    btnAddProdProdPage.setText(dictionary.getValueOf("Add product"));
	    btnAdminProdProdPage.setText(dictionary.getValueOf("Manage Products"));
	    btnBackProductPage.setText(dictionary.getValueOf("Back"));
	    btnImportProdProdPage.setText(dictionary.getValueOf("Import products"));
	}
	
	void loadLanguageSearchClientPage() {//29
		btnSearchSearchClient.setText(dictionary.getValueOf("Search"));
	    btnBackSearchClient.setText(dictionary.getValueOf("Back"));
	    labNameSearchClient.setText(dictionary.getValueOf("Name"));
	    labLastNameSearchClient.setText(dictionary.getValueOf("Surname"));
	    labIDSearchClient.setText(dictionary.getValueOf("ID"));
	    labAdressSearchClient.setText(dictionary.getValueOf("Adress"));
	    labPhoneSearchClient.setText(dictionary.getValueOf("Telephone"));
	    labObsSearchClient.setText(dictionary.getValueOf("Observations"));
	    labSearchClientByIdSearchClient.setText(dictionary.getValueOf("Search client by id"));
	    labTimeSearchClient.setText(dictionary.getValueOf("Search time in nanoseconds"));
	}
	
	void loadLanguageUsersPage() {//30
		tcUserUserName.setText(dictionary.getValueOf("Username"));
	    tcUserName.setText(dictionary.getValueOf("Name"));
	    tcUserLastName.setText(dictionary.getValueOf("Surname"));
	    tcUserID.setText(dictionary.getValueOf("ID"));
	    tcUserNoo.setText(dictionary.getValueOf("Orders delivered"));
	    labTitleUserPage.setText(dictionary.getValueOf("Users"));
	    btnBackUserPage.setText(dictionary.getValueOf("Back"));
	    btnUpdateUserPage.setText(dictionary.getValueOf("Update"));
	    btnaddUserUserPage.setText(dictionary.getValueOf("Add user"));
	    btnModifyUserPage.setText(dictionary.getValueOf("Modify"));
	    btnDeleteUserPage.setText(dictionary.getValueOf("Delete"));
	}
	
	@FXML
	void modifyOrder(ActionEvent event) {
		String[] observations;

		try {

			if(!cbModifyAbleClients.getValue().equals("") && !cbModifyAbleEmployees.getValue().equals("") &&
					!cbModifyOrderState.getValue().equals("")) {
				String date = String.valueOf(dateTimeFormatter.format(modifyCalendarDate.getValue()));
				if(date.equalsIgnoreCase("null")) {
					date = oldDate.getText();
				}

				if(!txtModifyOrderObs.getText().equals("")) {
					observations = txtModifyOrderObs.getText().split(SEP);
				}else {
					observations = new String[1];
				}

				State state = null;
				if(cbModifyOrderState.getValue().equalsIgnoreCase(dictionary.getValueOf("Requested"))) {
					state = State.SOLICITADO;
				}else if(cbModifyOrderState.getValue().equalsIgnoreCase(dictionary.getValueOf("Sent"))) {
					state = State.ENVIADO;
				}else if(cbModifyOrderState.getValue().equalsIgnoreCase(dictionary.getValueOf("Delivered"))) {
					state = State.ENTREGADO;
				}else if(cbModifyOrderState.getValue().equalsIgnoreCase(dictionary.getValueOf("In progress"))) {
					state = State.EN_PROCESO;
				}



				restaurant.updateOrder(labOrderCode.getText() ,state, cbModifyAbleClients.getValue(),
						cbModifyAbleEmployees.getValue(), date ,observations);

				labConfirmModifyOrder.setText(dictionary.getValueOf("Order successfully modified"));
				labConfirmModifyOrder.setTextFill(Paint.valueOf("Green"));

			}else {

				labConfirmModifyOrder.setText(dictionary.getValueOf("All spaces must be filled"));
				labConfirmModifyOrder.setTextFill(Paint.valueOf("RED"));

			}
		}catch(NumberFormatException n) {

			labConfirmModifyOrder.setText(dictionary.getValueOf("The values ​​do not correspond"));
			labConfirmModifyOrder.setTextFill(Paint.valueOf("RED"));
		}
	}

	@FXML
	void btnImportOrders(ActionEvent event){
		try {
			restaurant.importOrders(currentUser);
			restaurant.saveData();
		} catch (IOException e) {
		}
	}

	@FXML
	void modifyOrderProducts(ActionEvent event) {
		System.out.println(labOrderCode2.getText());
		restaurant.updateOrderProducts(labOrderCode2.getText());
	}

	@FXML
	void btnOpenModifyOrder2(ActionEvent event) {
		if(tvOrders.getSelectionModel().getSelectedItem() != null) {
			Order order = tvOrders.getSelectionModel().getSelectedItem();

			if(restaurant.getOrderItems().isEmpty()) {
				try {
					FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("modify-Orderp2.fxml"));
					fxmlLoader.setController(this);
					Parent login;
					login = fxmlLoader.load();
					mainPane.getChildren().setAll(login);
					ObservableList<String> observableListStates = FXCollections.observableArrayList("SOLICITADO","ENVIADO","ENTREGADO","EN PROCESO");
					ObservableList<String> observableListClients = FXCollections.observableArrayList(restaurant.getClientsNames());
					ObservableList<String> observableListEmployees = FXCollections.observableArrayList(restaurant.getemployeesNames());
					cbModifyOrderState.setItems(observableListStates);
					cbModifyAbleClients.setItems(observableListClients);
					cbModifyAbleEmployees.setItems(observableListEmployees);

					//modify
					cbModifyOrderState.setValue(order.getStateString());
					cbModifyAbleClients.setValue(order.getRequestClient());
					cbModifyAbleEmployees.setValue(order.getDeliverEmployee());
					txtModifyOrderObs.setText(order.getObservationsStr());
					labOrderCode.setText(order.getCode());
					oldDate.setText(order.getDate());
					loadLanguageModifyOrderp2Page();

				} catch (IOException e) {

					e.printStackTrace();
				}
			}else {

				labConfirmAddOrderS1.setText(dictionary.getValueOf("At least one product must be added"));
				labConfirmAddOrderS1.setTextFill(Paint.valueOf("RED"));
			}
		}
	}

	@FXML
	void btnCloseCreateOrder(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Orders-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			restaurant.getOrderItems().clear();
			loadLanguageOrdersPage();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	void btnEraseProductFromModifyOrder(ActionEvent event) {
		if(tvListModifyOrderProducts.getSelectionModel().getSelectedItem() != null) {
			OrderItem prod = tvListModifyOrderProducts.getSelectionModel().getSelectedItem();
			int o = restaurant.searchOrderItem(prod.getProductName(), prod.getProductSize());
			restaurant.getOrderItems().remove(o);
		}
	}

	@FXML
	void btnOpenModifyPage(ActionEvent event) {
		if(tvOrders.getSelectionModel().getSelectedItem() != null) {
			Order order = tvOrders.getSelectionModel().getSelectedItem();
			int pos = restaurant.searchOrder(order.getCode());
			try {
				FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("modify-Orderp1.fxml"));
				fxmlLoader.setController(this);
				Parent login;
				login = fxmlLoader.load();
				mainPane.getChildren().setAll(login);
				labOrderCode2.setText(order.getCode());
				loadTvModifyProductsFromOrder(pos);
				loadLanguageModifyOrderp1Page();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	void loadTvModifyProductsFromOrder(int pos) {
		if(restaurant.getOrderItems().isEmpty()) {
			restaurant.getOrderItems().addAll(restaurant.getOrders().get(pos).getItems());
		}
		//restaurant.getOrders().get(pos).getItems().clear();
		ObservableList<OrderItem> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getOrderItems());
		tvListModifyOrderProducts.setItems(observableList);
		tcModifyOrderProduct.setCellValueFactory(new PropertyValueFactory<OrderItem,String>("productName")); 
		tcModifyOrderProductAmount.setCellValueFactory(new PropertyValueFactory<OrderItem,Integer>("productAmount"));
	}

	@FXML
	void btnOpenSearchProduct(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("addProductToOrder-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			ObservableList<String> observableList = FXCollections.observableArrayList(restaurant.getProductsNames());
			cbProductsToOrder.setItems(observableList);
			loadLanguageAddProductToOrderPage();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	void btnOpenSearchProduct2(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("addProductToModifyOrder-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			ObservableList<String> observableList = FXCollections.observableArrayList(restaurant.getProductsNames());
			cbProductsToOrder.setItems(observableList);
			loadLanguageAddProductToModifyOrderPage();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}





	@FXML
	void btnAddProductToOrder(ActionEvent event) {
		try {
			if(Integer.parseInt(txtProductCant.getText()) != 0 && !cbProductsToOrder.getValue().equals("") && !cbProductsSize.getValue().equals("")) {
				int pos = restaurant.searchProduct(cbProductsToOrder.getValue());
				int sizePos = restaurant.getProducts().get(pos).searchSize(cbProductsSize.getValue());
				double price = restaurant.getProducts().get(pos).getSizeAndPrice().get(sizePos).getPrice();
				restaurant.addOrderItem(restaurant.getProducts().get(pos), cbProductsSize.getValue(),
						price, Integer.parseInt(txtProductCant.getText()));

				labConfirmProductToOrder.setText(dictionary.getValueOf("Product successfully added to order"));
				labConfirmProductToOrder.setTextFill(Paint.valueOf("Green"));
			}else {
				labConfirmProductToOrder.setText(dictionary.getValueOf("All spaces must be filled"));
				labConfirmProductToOrder.setTextFill(Paint.valueOf("RED"));
			}
		}catch (NumberFormatException nfe) {
			labConfirmProductToOrder.setText(dictionary.getValueOf("The values ​​do not correspond"));
			labConfirmProductToOrder.setTextFill(Paint.valueOf("RED"));
		}

	}

	@FXML
	void findProduct(MouseEvent event) {
		if(cbProductsToOrder.getValue() != null) {
			String prodName = cbProductsToOrder.getValue();
			int pos = restaurant.searchProduct(prodName);
			ObservableList<String> observableList = FXCollections.observableArrayList(restaurant.getProducts().get(pos).getSizes());
			cbProductsSize.setItems(observableList);
		}else {
			labConfirmProductToOrder.setText(dictionary.getValueOf("Enter the product first to see its sizes"));
			labConfirmProductToOrder.setTextFill(Paint.valueOf("orange"));
		}
	}


	@FXML
	void btnBackToCreateOrder(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("create-Order.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageCreateOrder();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//create-Order
	@FXML
	void addOrder(ActionEvent event) {
		String[] observations;

		try {

			if(!cbAbleClients.getValue().equals("") && !cbAbleEmployees.getValue().equals("") &&
					!String.valueOf(calendarDate.getValue()).equals("") && !restaurant.getOrderItems().isEmpty()
					&& !cbOrderState.getValue().equals("")) {


				if(!txtOrderObs.getText().equals("")) {
					observations = txtOrderObs.getText().split(SEP);
				}else {
					observations = new String[1];
				}

				State state = null;
				if(cbOrderState.getValue().equalsIgnoreCase(dictionary.getValueOf("Requested"))) {
					state = State.SOLICITADO;
				}else if(cbOrderState.getValue().equalsIgnoreCase(dictionary.getValueOf("Sent"))) {
					state = State.ENVIADO;
				}else if(cbOrderState.getValue().equalsIgnoreCase(dictionary.getValueOf("Delivered"))) {
					state = State.ENTREGADO;
				}else if(cbOrderState.getValue().equalsIgnoreCase(dictionary.getValueOf("In progress"))) {
					state = State.EN_PROCESO;
				}

				restaurant.createOrder(state, cbAbleClients.getValue(),
						cbAbleEmployees.getValue(), String.valueOf(dateTimeFormatter.format(calendarDate.getValue())) ,
						observations);

				labConfirmOrder.setText(dictionary.getValueOf("Order added successfully"));
				labConfirmOrder.setTextFill(Paint.valueOf("Green"));
				try {
					restaurant.saveData();
				} catch (IOException e) {
				}
			}else {

				labConfirmOrder.setText(dictionary.getValueOf("All spaces must be filled"));
				labConfirmOrder.setTextFill(Paint.valueOf("RED"));

				System.out.println("observaciones: " + txtOrderObs.getText() + " cliente: " + cbAbleClients.getValue() 
				+ " empleado: " + cbAbleEmployees.getValue() + " dia: " + calendarDate.getValue() + 
				" orderitems: " + restaurant.getOrderItems() + " estado: " + cbOrderState.getValue());

			}
		}catch(NumberFormatException n) {

			labConfirmOrder.setText(dictionary.getValueOf("The values ​​do not correspond"));
			labConfirmOrder.setTextFill(Paint.valueOf("RED"));
		}
	}

	@FXML
	void btnEraseProductFromOrder(ActionEvent event) {
		if(tvListOrderProducts.getSelectionModel().getSelectedItem() != null) {
			OrderItem prod = tvListOrderProducts.getSelectionModel().getSelectedItem();
			int o = restaurant.searchOrderItem(prod.getProduct().getName(),prod.getProductSize());
			restaurant.getOrderItems().remove(o);
		}
	}


	@FXML
	void btnBackToOrders(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Orders-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}



	//Orders-page


	//Orders-page
	@FXML
	public void btnEraseOrder(ActionEvent event) {
		if(tvOrders.getSelectionModel().getSelectedItem() != null) {
			Order order = tvOrders.getSelectionModel().getSelectedItem();
			int pos = restaurant.searchOrder(order.getCode());
			restaurant.getOrders().remove(pos);
		}
	}

	public void loadTableViewOrders() {
		ObservableList<Order> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getOrders());
		tvOrders.setItems(observableList);
		tcOrderCode.setCellValueFactory(new PropertyValueFactory<Order,String>("code")); 
		tcOrderState.setCellValueFactory(new PropertyValueFactory<Order,String>("state")); 
		tcOrderClient.setCellValueFactory(new PropertyValueFactory<Order,String>("requestClient")); 
		tcOrderEmployee.setCellValueFactory(new PropertyValueFactory<Order,String>("deliverEmployee"));
		tcOrderDate.setCellValueFactory(new PropertyValueFactory<Order,String>("date"));
	}




	@FXML
	public void showOrderInfo(MouseEvent event) {
		if(tvOrders.getSelectionModel().getSelectedItem() != null) {

			//tv
			Order order = tvOrders.getSelectionModel().getSelectedItem();
			int pos = restaurant.searchOrder(order.getCode());

			System.out.println(pos + " " + order);
			loadTvShowProductsFromOrder(pos);
			//lv
			ObservableList<String> orderObs = FXCollections.observableArrayList(restaurant.getOrders().get(pos).getObservations());
			lvOrdersObs.setItems(orderObs);
			//lab
			labTotalPrice.setText(restaurant.getTotalPriceOfOrder(pos));
		}
	}



	void loadTvShowProductsFromOrder(int pos) {
		ObservableList<OrderItem> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getOrders().get(pos).getItems());

		tvOrderItems.setItems(observableList);
		tcOrderProduct.setCellValueFactory(new PropertyValueFactory<OrderItem,String>("productName")); 
		tcOrderProductAmount.setCellValueFactory(new PropertyValueFactory<OrderItem,Integer>("productAmount")); 
		tcOrderProductSize.setCellValueFactory(new PropertyValueFactory<OrderItem,String>("productSize")); 
		tcOrderProductPrice.setCellValueFactory(new PropertyValueFactory<OrderItem,Double>("productPrice"));


	}

	void loadTvProductsFromOrder() {
		if(restaurant.getOrderItems() != null) {
			ObservableList<OrderItem> observableList;
			observableList = FXCollections.observableArrayList(restaurant.getOrderItems());
			tvListOrderProducts.setItems(observableList);
			tcCreateOrderProduct.setCellValueFactory(new PropertyValueFactory<OrderItem,String>("productName")); 
			tcCreateOrderProductAmount.setCellValueFactory(new PropertyValueFactory<OrderItem,Integer>("productAmount"));
		}
	}

	@FXML
	void btnOpenAddOrder(ActionEvent event) {
		if(!restaurant.getOrderItems().isEmpty()) {
			try {
				FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("create-Order.fxml"));
				fxmlLoader.setController(this);
				Parent login;
				login = fxmlLoader.load();
				mainPane.getChildren().setAll(login);
				loadLanguageCreateOrder();
				ObservableList<String> observableListClients = FXCollections.observableArrayList(restaurant.getClientsNames());
				ObservableList<String> observableListEmployees = FXCollections.observableArrayList(restaurant.getemployeesNames());
				cbAbleClients.setItems(observableListClients);
				cbAbleEmployees.setItems(observableListEmployees);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}else {

			labConfirmAddOrderS1.setText(dictionary.getValueOf("At least one product must be added"));
			labConfirmAddOrderS1.setTextFill(Paint.valueOf("RED"));
		}
	}

	@FXML
	void btnOpenAddOrderS1(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("create-Order1.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTvProductsFromOrder();
			loadLanguageCreateOrder1();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	void btnUpdateModifyPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("modify-Orderp1.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTvProductsFromOrder();
			loadLanguageModifyOrderp1Page();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void btnOrdersToLoggedIn(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Logged-in-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageLoggedInPage();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	public void btnOrdersPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Orders-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewOrders();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	private TextField txtModifyUsersLastName;

	@FXML
	private Label labModifyUserID;

	@FXML
	private TextField txtModifyUsersNoo;

	@FXML
	private Label confirmModifyUser;

	@FXML
	public void modifyUser(ActionEvent event) {
		try {

			if(!txtModifyUsersUserName.getText().equals("") && !txtModifyUserPassword.getText().equals("") &&
					!txtModifyUsersName.getText().equals("") && !txtModifyUsersLastName.getText().equals("") &&
					!labModifyUserID.getText().equals("") && !txtModifyUsersNoo.getText().equals("")) {

				restaurant.updateUser(txtModifyUsersUserName.getText(), txtModifyUserPassword.getText(),
						txtModifyUsersName.getText(),txtModifyUsersLastName.getText(),
						labModifyUserID.getText(),Integer.parseInt(txtModifyUsersNoo.getText()) );

				confirmModifyUser.setText(dictionary.getValueOf("User modified successfully"));
				confirmModifyUser.setTextFill(Paint.valueOf("Green"));

			}else {

				confirmModifyUser.setText(dictionary.getValueOf("All spaces must be filled"));
				confirmModifyUser.setTextFill(Paint.valueOf("RED"));
			}
		}catch(NumberFormatException n) {

			confirmModifyUser.setText("The values ​​do not correspond");
			confirmModifyUser.setTextFill(Paint.valueOf("RED"));
		}
	}

	@FXML
	public void addUser(ActionEvent event) {
		try {

			if(!txtUserUserName.getText().equals("") && !txtUserPassword.getText().equals("") &&
					!txtUserName.getText().equals("") && !txtUserLastName.getText().equals("") &&
					!txtUserID.getText().equals("") && !txtUserNoo.getText().equals("")) {

				boolean x = restaurant.createUser(txtUserName.getText(), txtUserLastName.getText(),
						txtUserID.getText(),Integer.parseInt(txtUserNoo.getText()),
						txtUserUserName.getText(),txtUserPassword.getText());
				if(x == false) {
					confirmCreateUser.setText(dictionary.getValueOf("User added successfully"));
					confirmCreateUser.setTextFill(Paint.valueOf("Green"));
				}else {
					confirmCreateUser.setText(dictionary.getValueOf("The User has an id that already exists"));
					confirmCreateUser.setTextFill(Paint.valueOf("RED"));
				}

			}else {

				confirmCreateUser.setText(dictionary.getValueOf("All spaces must be filled"));
				confirmCreateUser.setTextFill(Paint.valueOf("RED"));
			}
		}catch(NumberFormatException n) {

			confirmCreateUser.setText(dictionary.getValueOf("The values ​​do not correspond"));
			confirmCreateUser.setTextFill(Paint.valueOf("RED"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	public void btnAtrasCrearUsers(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Users-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewUsers();
			loadLanguageUsersPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void eraseUser(ActionEvent event) {
		if(tvUsers.getSelectionModel().getSelectedItem() != null) {
			System.out.println("entró al if");
			User user = tvUsers.getSelectionModel().getSelectedItem();

			int pos = restaurant.searchEmployee(user.getId());
			restaurant.getEmployes().remove(pos);

		}

	}

	@FXML
	public void createUser(ActionEvent event) {
		try {		
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("create-User.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageCreateUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void btnOpenModifyUser(ActionEvent event) {

		if(tvUsers.getSelectionModel().getSelectedItem() != null) {

			User user = tvUsers.getSelectionModel().getSelectedItem();

			try {
				FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("modify-User.fxml"));
				fxmlLoader.setController(this);
				Parent login;
				login = fxmlLoader.load();
				mainPane.getChildren().setAll(login);
				loadLanguageModifyUserPage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txtModifyUsersName.setText(user.getName());
			txtModifyUsersLastName.setText(user.getLastName());
			labModifyUserID.setText(user.getId());
			txtModifyUsersUserName.setText(user.getUserName());
			txtModifyUsersNoo.setText(String.valueOf(user.getNumOfOrders()));
			txtModifyUserPassword.setText(user.getPassword());
		}else {
			//System.out.println("f");
		}
	}

	//Users page to logged in page
	@FXML
	public void btnUsersToLoggedInPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageLoggedInPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void btnUsers(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Users-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewUsers();
			loadLanguageUsersPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	public void modifyEmployee(ActionEvent event) {
		try {

			if(!txtModifyEmployeeName.getText().equals("") && !txtModifyEmployeeLastName.getText().equals("") &&
					!labModifyEmployeeId.getText().equals("") && !txtModifyNumOfOrders.getText().equals("")) {

				restaurant.updateEmployee(txtModifyEmployeeName.getText(), txtModifyEmployeeLastName.getText(),
						labModifyEmployeeId.getText(), Integer.parseInt(txtModifyNumOfOrders.getText()) );

				confirmModifyEmployee.setText(dictionary.getValueOf("Employee successfully modified"));
				confirmModifyEmployee.setTextFill(Paint.valueOf("Green"));

			}else {

				confirmModifyEmployee.setText(dictionary.getValueOf("All spaces must be filled"));
				confirmModifyEmployee.setTextFill(Paint.valueOf("RED"));
			}
		}catch(NumberFormatException n) {

			confirmModifyEmployee.setText(dictionary.getValueOf("The values ​​do not correspond"));
			confirmModifyEmployee.setTextFill(Paint.valueOf("RED"));
		}
	}
	@FXML
	public void btnOpenModifyEmployee(ActionEvent event) {
		if(tvEmployees.getSelectionModel().getSelectedItem() != null) {

			Employee employee = tvEmployees.getSelectionModel().getSelectedItem();

			try {
				FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("modify-Employee.fxml"));
				fxmlLoader.setController(this);
				Parent login;
				login = fxmlLoader.load();
				mainPane.getChildren().setAll(login);
				loadLanguageModifyEmployeePage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			txtModifyEmployeeName.setText(employee.getName());
			txtModifyEmployeeLastName.setText(employee.getLastName());
			labModifyEmployeeId.setText(employee.getId());
			txtModifyNumOfOrders.setText(String.valueOf(employee.getNumOfOrders()));


		}
	}

	@FXML
	public void eraseEmployee(ActionEvent event) {
		if(tvEmployees.getSelectionModel().getSelectedItem() != null) {

			Employee employee = tvEmployees.getSelectionModel().getSelectedItem();

			int pos = restaurant.searchEmployee(employee.getId());
			restaurant.getEmployes().remove(pos);

		}
	}


	@FXML
	private TextField txtModifyEmployeeName;

	@FXML
	private TextField txtModifyEmployeeLastName;

	@FXML
	private Label labModifyEmployeeId;

	@FXML
	private TextField txtModifyNumOfOrders;

	@FXML
	private Label confirmModifyEmployee;




	//product admin
	@FXML
	private ComboBox<String> cboxProducts;
	//product admin
	@FXML
	private ComboBox<String> cboxIngredientsOfProduct;
	//product admin
	@FXML
	private ComboBox<String> cboxSizeAndPriceOfProduct;
	//product admin
	@FXML
	private TextField txtPriceOfSizeOfProductAdmin;
	//product admin
	@FXML
	private TextField txtTypeOfProductAdmin;
	//product admin
	@FXML
	private TextField txtNameOfProductAdmin;
	//product admin
	@FXML
	private Label lblCreatedByProduct;
	//product admin
	@FXML
	private Label lblLastEditedByProduct;
	//product admin
	@FXML
	private TextField txtSizeOfProductAdmin;
	//product admin
	@FXML
	private Label lblAvialableIngredientProduct;
	//product admin
	@FXML
	private Label lblProductAdminWarnings;

	//add ingredient and size price
	@FXML
	private TextField txtAddPriceForProductAdmin;
	//add ingredient and size price
	@FXML
	private TextField txtAddSizeToProductAdmin;
	//add ingredient and size price
	@FXML
	private Button btnAddIngredientAndSizePriceToAdminProduct;
	//add ingredient and size price
	@FXML
	private ComboBox<String> cboxAddIngredientAdmin;
	//add ingredient and size price
	@FXML
	private Label lblAddIngredientAndSizePriceWarning;

	//product admin
	private int selectedProduct;

	//menu page
	@FXML
	private TextField txtSearchProduct;
	//menu page
	@FXML
	private Label lblNameOfProductMenu;
	//menu page
	@FXML
	private Label lblTypeOfProductMenu;
	//menu page
	@FXML
	private Label lblSizeAndPriceOfProductMenu;
	//menu page
	@FXML
	private Label lblIngredientOfProductMenu;
	//menu page
	@FXML
	private Label lblNUmberOfProducts;
	//menu page
	@FXML
	private Label lblWarningMenu;
	//menu page
	private int currentProductSelected;
	//search client
	@FXML
	private Label lblNameOfSearchedClient;
	//search client
	@FXML
	private Label lblLastNameOfSearchedClient;
	//search client
	@FXML
	private Label lblIdOfSearchedClient;
	//search client
	@FXML
	private Label lblAdressOfSearchedClient;
	//search client
	@FXML
	private Label lblPhoneOfSearchedClient;
	//search client
	@FXML
	private Label lblObservationsOfSearchedClient;
	//search client
	@FXML
	private Label lblWarningsForSearchClientPage;
	//search client
	@FXML
	private TextField txtIdForSearch;






	@FXML
	public void btnModifyClient(ActionEvent event) {
		try {
			String[]observations;
			if(!txtModifyClientName.getText().equals("") && !txtModifyClientLastName.getText().equals("")
					&& !txtModifyClientAdress.getText().equals("") && !txtModifyClientPhone.getText().equals("") ) {

				if(!txtModifyClientObservations.getText().equals("")) {
					observations = txtModifyClientObservations.getText().split(SEP);
				}else {
					observations = new String[1];
				}
				restaurant.updateClient(txtModifyClientName.getText(), txtModifyClientLastName.getText(),
						labModifyClientID.getText(),txtModifyClientAdress.getText(),
						txtModifyClientPhone.getText(), observations );

				labConfirmModifyClient.setText(dictionary.getValueOf("Successfully modified client"));
				labConfirmModifyClient.setTextFill(Paint.valueOf("Green"));


			}else {
				labConfirmModifyClient.setText(dictionary.getValueOf("All spaces must be filled"));
				labConfirmModifyClient.setTextFill(Paint.valueOf("RED"));
			}
		}catch(NumberFormatException n) {

			labConfirmModifyClient.setText(dictionary.getValueOf("The values ​​do not correspond"));
			labConfirmModifyClient.setTextFill(Paint.valueOf("RED"));
		}
	}
	@FXML
	public void addClient(ActionEvent event) {
		try {
			String[]observations;
			if(!txtClientName.getText().equals("") && !txtClientLastName.getText().equals("") &&
					!txtClientID.getText().equals("") && !txtClientAdress.getText().equals("") &&
					!txtClientPhone.getText().equals("") ) {

				if(!txtClientObservations.getText().equals("")) {
					observations = txtClientObservations.getText().split(SEP);
				}else {
					observations = new String[1];
				}

				boolean x = restaurant.createClient(txtClientName.getText(), txtClientLastName.getText(),
						txtClientID.getText(),txtClientAdress.getText(), txtClientPhone.getText(), observations );
				if(!x) {
					labConfirmClient.setText(dictionary.getValueOf("Successfully added client"));
					labConfirmClient.setTextFill(Paint.valueOf("Green"));
				}else {
					labConfirmClient.setText(dictionary.getValueOf("The client has an id that already exists"));
					labConfirmClient.setTextFill(Paint.valueOf("RED"));
				}

			}else {

				labConfirmClient.setText(dictionary.getValueOf("All spaces must be filled"));
				labConfirmClient.setTextFill(Paint.valueOf("RED"));
			}
		}catch(NumberFormatException n) {

			labConfirmModifyClient.setText(dictionary.getValueOf("The values ​​do not correspond"));
			labConfirmModifyClient.setTextFill(Paint.valueOf("RED"));
		}

	}

	//create-Client
	@FXML
	public void showClientInfo(MouseEvent event) {
		if(tvClients.getSelectionModel().getSelectedItem() != null) {
			Client client = tvClients.getSelectionModel().getSelectedItem();
			int pos = restaurant.searchClient(client.getId());
			ObservableList<String> clientObs = FXCollections.observableArrayList(restaurant.getClients().get(pos).getObservations());
			lvClients.setItems(clientObs);
		}
	}

	//client page to search client page
	@FXML
	public void btnSearchClient(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("searchClient-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			mainPane.getChildren().setAll(login);
			if(!restaurant.getClients().isEmpty()) {
				restaurant.bubbleSortForClients();
			}
			loadLanguageSearchClientPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//search client page
	@FXML
	public void bntSearchForId(ActionEvent event) {
		int found= restaurant.binarySearchForClients(txtIdForSearch.getText());
		lblTimeOfSearch.setText(""+restaurant.getTime());
		if(found==-1) {
			lblWarningsForSearchClientPage.setText(dictionary.getValueOf("A client with this id was not found"));
			lblWarningsForSearchClientPage.setTextFill(Paint.valueOf("RED"));
		}else {
			lblNameOfSearchedClient.setText(restaurant.getClients().get(found).getName());
			lblLastNameOfSearchedClient.setText(restaurant.getClients().get(found).getLastName());
			lblIdOfSearchedClient.setText(restaurant.getClients().get(found).getId());
			lblAdressOfSearchedClient.setText(restaurant.getClients().get(found).getAdress());
			lblPhoneOfSearchedClient.setText(restaurant.getClients().get(found).getPhone());
			lblObservationsOfSearchedClient.setText(restaurant.getClients().get(found).observationsToString());
		}
	}
	//search client page
	@FXML
	public void btnBackToClientPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Clients-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			if(!restaurant.getClients().isEmpty()) {
				restaurant.bubbleSortForClients();
			}
			loadTableViewClient();
			loadLanguageClientsPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void btnImportClients(ActionEvent event) {
		try {
			restaurant.importClients(currentUser);
			restaurant.saveData();
			if(!restaurant.getClients().isEmpty()) {
				restaurant.bubbleSortForClients();
			}
			loadTableViewClient();
		}catch (IOException e) {
			// TODO: handle exception
		}
	}



	@FXML
	public void openModifyClient(ActionEvent event) {
		if(tvClients.getSelectionModel().getSelectedItem() != null) {

			Client client = tvClients.getSelectionModel().getSelectedItem();

			String ModObs = "";
			for(int i = 0; i < client.getObservations().size(); i++) {
				ModObs += client.getObservations().get(i) + "\n";
			}

			try {
				FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("modify-Client.fxml"));
				fxmlLoader.setController(this);
				Parent login;
				login = fxmlLoader.load();
				mainPane.getChildren().setAll(login);
				loadLanguageModifyClientPage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txtModifyClientName.setText(client.getName());
			txtModifyClientLastName.setText(client.getLastName());
			labModifyClientID.setText(client.getId());
			txtModifyClientAdress.setText(client.getAdress());
			txtModifyClientPhone.setText(client.getPhone());
			txtModifyClientObservations.setText(ModObs);


		}
	}

	@FXML
	public void eraseClient(ActionEvent event) {
		if(tvClients.getSelectionModel().getSelectedItem() != null) {

			Client client = tvClients.getSelectionModel().getSelectedItem();

			int pos = restaurant.searchClient(client.getId());
			restaurant.getClients().remove(pos);

		}
	}

	@FXML
	public void createClient(ActionEvent event) {
		try {		
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("create-Client.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageCreateClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void addEmployee(ActionEvent event) {
		try {

			if(!txtEmployeeName.getText().equals("") && !txtEmployeeLastName.getText().equals("") &&
					!txtEmployeeId.getText().equals("") && !txtNumOfOrders.getText().equals("")) {

				boolean x = restaurant.createEmployee(txtEmployeeName.getText(), txtEmployeeLastName.getText(),
						txtEmployeeId.getText(), Integer.parseInt(txtNumOfOrders.getText()) );

				if(x == false) {
					confirmEmployee.setText(dictionary.getValueOf("Employee added successfully"));
					confirmEmployee.setTextFill(Paint.valueOf("Green"));
				}else {
					confirmEmployee.setText(dictionary.getValueOf("The employee has an id that already exists"));
					confirmEmployee.setTextFill(Paint.valueOf("RED"));
				}

			}else {

				confirmEmployee.setText(dictionary.getValueOf("All spaces must be filled"));
				confirmEmployee.setTextFill(Paint.valueOf("RED"));
			}
		}catch(NumberFormatException n) {

			confirmEmployee.setText(dictionary.getValueOf("The values ​​do not correspond"));
			confirmEmployee.setTextFill(Paint.valueOf("RED"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}



	//create-Employee
	@FXML
	public void btnAtrasCrearEmpleados(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Employee-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewEmployees();
			loadLanguageEmployeePage();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	//admin-page
	@FXML
	public void btnAtras(ActionEvent event) {
		try {

			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("main-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadCbLogIn();
			loadLanguageMainPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//admin-page
	@FXML
	public void btnLogIn(ActionEvent event) {
		if(restaurant.logInAdmin(txtUsuario.getText(), txtPassword.getText())) {
			currentUser=txtUsuario.getText();
			try {
				FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));
				fxmlLoader.setController(this);
				Parent login;
				login = fxmlLoader.load();
				mainPane.getChildren().setAll(login);
				loadLanguageLoggedInPage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			lblAdminPagewarning.setText(dictionary.getValueOf("The username or password is not correct"));
			lblAdminPagewarning.setTextFill(Paint.valueOf("Red"));
		}
	}
	@FXML
	public void btnDeleteSavedFiles(ActionEvent event) {
		try {
			restaurant.clearData();
			restaurant.loadClientsData();
			restaurant.loadEmployeesData();
			restaurant.loadIngredientsData();
			restaurant.loadProductsData();
			restaurant.loadOrderData();
			restaurant.saveData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//main-page
	private Thread time;
	public void loadMainPage(){
		try {
			restaurant.loadIngredientsData();
			restaurant.loadEmployeesData();
			restaurant.loadProductsData();
			restaurant.loadClientsData();
			restaurant.loadOrderData();
			restaurant.saveData();
			loadLenguage();
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("main-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadCbLogIn();
			lbldateAndTime.setText(LocalDateTime.now().getDayOfMonth()+"/"+LocalDateTime.now().getMonthValue()+"/"+LocalDateTime.now().getYear()  +" "+LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+":"+LocalTime.now().getSecond() );
			loadLanguageMainPage();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		time = new Thread(new Runnable() {
			@Override
			public void run() {
				for(;;){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							lbldateAndTime.setText(LocalDateTime.now().getDayOfMonth()+"/"+LocalDateTime.now().getMonthValue()+"/"+LocalDateTime.now().getYear()  +" "+LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+":"+LocalTime.now().getSecond() );
						}
					});
				}
			}
		});
		time.start();
	}
	public void loadCbLogIn() {
		ObservableList<String> ableLanguages;
		if(dictionary.getActualLanguage() == Language.SPANISH) {
			ableLanguages = FXCollections.observableArrayList("ESPAÑOL", "INGLES");
		} else if(dictionary.getActualLanguage() == Language.ENGLISH) {
			ableLanguages = FXCollections.observableArrayList("SPANISH", "ENGLISH");
		} else {
			ableLanguages = FXCollections.observableArrayList("SPANISH", "ENGLISH");
		}
		cbLenguage.setItems(ableLanguages);
	}
	
	//main-page
	@FXML
    void btnChangeLenguage(ActionEvent event) throws IOException {
		if(cbLenguage.getValue().equals("SPANISH") || cbLenguage.getValue().equals("ESPAÑOL")) {
			dictionary.setActualLanguage(Language.SPANISH);
		} else if(cbLenguage.getValue().equals("ENGLISH") || cbLenguage.getValue().equals("INGLES")) {
			dictionary.setActualLanguage(Language.ENGLISH);
		}
		loadLenguage();
		loadMainPage();
    }
	
	public void loadLenguage() throws IOException{
		ArrayList<Word> read = new ArrayList<Word>();
		BufferedReader br;
		if(dictionary.getActualLanguage() == Language.SPANISH) {
			br = new BufferedReader(new FileReader("data/ImportWordsSpanish.csv"));
		} else if(dictionary.getActualLanguage() == Language.ENGLISH) {
			br = new BufferedReader(new FileReader("data/ImportWordsEnglish.csv"));
		} else {
			br = new BufferedReader(new FileReader("data/ImportWordsEnglish.csv"));
		}
		String line= br.readLine();
		String[] parts;
		while(line!=null) {
			parts= line.split(",");
			read.add(new Word(parts[0],parts[1]));
			line=br.readLine();
		}
		br.close();
		
		dictionary.setWords(read);
	}

	//main-page
	@FXML
	public void btnAdmin(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("admin-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			time.interrupt();
			loadLanguageAdminPage();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//main-page
	@FXML
	public void btnMenu(ActionEvent event) {
		currentProductSelected=0;
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("menu-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			time.interrupt();
			if(restaurant.getProducts().isEmpty()) {
				lblWarningMenu.setText(dictionary.getValueOf("There are no products"));
				lblWarningMenu.setTextFill(Paint.valueOf("Red"));
			}else {
				restaurant.resetMenuProducts();
				lblNameOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getName());
				lblTypeOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getType());
				lblSizeAndPriceOfProductMenu.setText(dictionary.getValueOf("Size and prices")+restaurant.getMenuProducts().get(currentProductSelected).sizeAndPriceToString());
				lblIngredientOfProductMenu.setText(dictionary.getValueOf("Ingredients")+restaurant.getMenuProducts().get(currentProductSelected).ingredientsToString());
				lblNUmberOfProducts.setText((currentProductSelected+1)+"/"+(restaurant.getMenuProducts().size()));
			}
			lblSizeAndPriceOfProductMenu.setWrapText(true);
			lblIngredientOfProductMenu.setWrapText(true);
			loadLanguageMenuPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	//menu page
	@FXML
	public void btnBackProduct(ActionEvent event) {
		try {
			currentProductSelected--;
			lblNameOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getName());
			lblTypeOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getType());
			lblSizeAndPriceOfProductMenu.setText(dictionary.getValueOf("Size and prices")+restaurant.getMenuProducts().get(currentProductSelected).sizeAndPriceToString());
			lblIngredientOfProductMenu.setText(dictionary.getValueOf("Ingredients")+restaurant.getMenuProducts().get(currentProductSelected).ingredientsToString());
			lblNUmberOfProducts.setText((currentProductSelected+1)+"/"+(restaurant.getMenuProducts().size()));
		}catch(NullPointerException e) {
			lblWarningMenu.setText(dictionary.getValueOf("This is the first product, there is no previous"));
			lblWarningMenu.setTextFill(Paint.valueOf("Red"));
			currentProductSelected++;
		}catch(IndexOutOfBoundsException e) {
			lblWarningMenu.setText(dictionary.getValueOf("This is the first product, there is no previous"));
			lblWarningMenu.setTextFill(Paint.valueOf("Red"));
			currentProductSelected++;
		}

	}
	//menu page
	@FXML
	public void btnMenutoMain(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("main-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageMainPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//menu page
	@FXML
	public void btnNextProduct(ActionEvent event) {
		try {
			currentProductSelected++;
			lblNameOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getName());
			lblTypeOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getType());
			lblSizeAndPriceOfProductMenu.setText(dictionary.getValueOf("Size and prices")+restaurant.getMenuProducts().get(currentProductSelected).sizeAndPriceToString());
			lblIngredientOfProductMenu.setText(dictionary.getValueOf("Ingredients")+restaurant.getMenuProducts().get(currentProductSelected).ingredientsToString());
			lblNUmberOfProducts.setText((currentProductSelected+1)+"/"+(restaurant.getMenuProducts().size()));
		}catch(NullPointerException e) {
			lblWarningMenu.setText(dictionary.getValueOf("This is the last product"));
			lblWarningMenu.setTextFill(Paint.valueOf("Red"));
			currentProductSelected--;
		}catch(IndexOutOfBoundsException e) {
			lblWarningMenu.setText(dictionary.getValueOf("This is the last product"));
			lblWarningMenu.setTextFill(Paint.valueOf("Red"));
			currentProductSelected--;
		}
	}
	//menu page
	@FXML
	public void btnSearchProduct(ActionEvent event) {
		currentProductSelected=0;
		restaurant.searchMenuProducts(txtSearchProduct.getText());
		if(restaurant.getMenuProducts().isEmpty()) {
			lblWarningMenu.setText(dictionary.getValueOf("There are no products related with") + " " +txtSearchProduct.getText());
			lblWarningMenu.setTextFill(Paint.valueOf("Red"));	
		}else {
			lblNameOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getName());
			lblTypeOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getType());
			lblSizeAndPriceOfProductMenu.setText(dictionary.getValueOf("Size and prices")+restaurant.getMenuProducts().get(currentProductSelected).sizeAndPriceToString());
			lblIngredientOfProductMenu.setText(dictionary.getValueOf("Ingredients")+restaurant.getMenuProducts().get(currentProductSelected).ingredientsToString());
			lblNUmberOfProducts.setText((currentProductSelected+1)+"/"+(restaurant.getMenuProducts().size()));
		}

	}

	//menu page
	@FXML
	public void btnResetSearch(ActionEvent event) {
		restaurant.resetMenuProducts();
		txtSearchProduct.clear();
		if(restaurant.getProducts().isEmpty()) {
			lblWarningMenu.setText("No hay productos");
			lblWarningMenu.setTextFill(Paint.valueOf("Red"));
		}else {
			restaurant.resetMenuProducts();
			lblNameOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getName());
			lblTypeOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getType());
			lblSizeAndPriceOfProductMenu.setText(dictionary.getValueOf("Size and prices")+restaurant.getMenuProducts().get(currentProductSelected).sizeAndPriceToString());
			lblIngredientOfProductMenu.setText(dictionary.getValueOf("Ingredients")+restaurant.getMenuProducts().get(currentProductSelected).ingredientsToString());
			lblNUmberOfProducts.setText((currentProductSelected+1)+"/"+(restaurant.getMenuProducts().size()));
		}
		lblSizeAndPriceOfProductMenu.setWrapText(true);

	}



	//Logged-in-page
	@FXML
	public void btnEmpleados(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Employee-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewEmployees();
			loadLanguageEmployeePage();
		} catch (IOException e) {
		}

	}

	//Logged-in-page
	@FXML
	void btnGoToExportOrderscsv(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("ExportOrdercsv.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageExportOrdercsvPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Logged-in-page
	@FXML
	void btnGoToExportProducts(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("exportProducts.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageExportProductsPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//export orders csv
	@FXML
	void btnExportOrders(ActionEvent event) {
		try {
			restaurant.exportData(dateTimeFormatter.format(dPDate1.getValue()).toString(), dateTimeFormatter.format(dPDate2.getValue()).toString(), txtSep.getText());
			lblExportOrderscsvWarning.setText(dictionary.getValueOf("The file was generated successfully"));
			lblExportOrderscsvWarning.setTextFill(Paint.valueOf("Green"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//export orders csv
	@FXML
	void btnbackToLoggedInPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageLoggedInPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//export products
	@FXML
	void btnBackToLoggedInPageFromProducts(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageLoggedInPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//export products
	private Thread exportProducts;
	@FXML
	void btnExportProducts(ActionEvent event) {
		exportProducts = new Thread(){
			@Override
			public void run() {
					try {
						restaurant.exportProduct(dateTimeFormatter.format(dpExportProductsDp1.getValue()).toString(), dateTimeFormatter.format(dpExportProductsDp2.getValue()).toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		};
		exportProducts.start();
		lblexportProductWarnigns.setText(dictionary.getValueOf("The file was generated successfully"));
		lblexportProductWarnigns.setTextFill(Paint.valueOf("Green"));
	}


	//Logged-in-page
	@FXML
	public void btnClients(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Clients-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageClientsPage();
			if(!restaurant.getClients().isEmpty()) {
				restaurant.bubbleSortForClients();
			}
			loadTableViewClient();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//tv Users-page
	public void loadTableViewUsers() {
		ObservableList<User> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getUsers());
		tvUsers.setItems(observableList);
		tcUserName.setCellValueFactory(new PropertyValueFactory<User,String>("name")); 
		tcUserLastName.setCellValueFactory(new PropertyValueFactory<User,String>("lastName")); 
		tcUserID.setCellValueFactory(new PropertyValueFactory<User,String>("id"));
		tcUserNoo.setCellValueFactory(new PropertyValueFactory<User,Integer>("numOfOrders"));
		tcUserUserName.setCellValueFactory(new PropertyValueFactory<User,String>("userName"));

	}


	//tv Clients-page
	public void loadTableViewClient() {
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getClients());
		tvClients.setItems(observableList);
		tcClientName.setCellValueFactory(new PropertyValueFactory<Client,String>("name")); 
		tcClientLastName.setCellValueFactory(new PropertyValueFactory<Client,String>("lastName")); 
		tcClientID.setCellValueFactory(new PropertyValueFactory<Client,String>("id"));
		tcClientAdress.setCellValueFactory(new PropertyValueFactory<Client,String>("adress"));
		tcClientPhone.setCellValueFactory(new PropertyValueFactory<Client,Integer>("phone"));
	}

	@FXML
	public void btnReturnToLoggedInPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageLoggedInPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Employee to logged in page
	@FXML
	public void btnBackToLoggedInPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));

			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewEmployees();
			loadLanguageLoggedInPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//ingredient-page
	@FXML
	public void btnAddIngredient(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("addIngredient-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewIngredient();
			loadLanguageAddIngredientPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//ingredient-page
	@FXML
	public void btnImportIngredients(ActionEvent event) {
		try {
			restaurant.importIngredientData(currentUser);
			loadTableViewIngredient();
			restaurant.saveData();
		}catch(IOException e) {
			lblIngredientPageWarning.setText(dictionary.getValueOf("Ingredients file not found"));
			lblIngredientPageWarning.setTextFill(Paint.valueOf("Red"));
		}
	}

	//ingredient-page to logged-in-page
	@FXML
	public void btnGoToLoggedInPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageLoggedInPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//addIngredient-page
	@FXML
	public void btnAddINgredient(ActionEvent event) {
		boolean avialable=false;
		if(rbtnAvailable.isSelected() || rbtnNotAvailable.isSelected()) {
			if(rbtnAvailable.isSelected()) {
				avialable=true;
			}
			try {
				if(!restaurant.addIngredient(txtNameIgredient.getText(), avialable)) {
					restaurant.getIngredients().get(restaurant.getIngredients().size()-1).setCreatedBy(currentUser);
					restaurant.getIngredients().get(restaurant.getIngredients().size()-1).setLastEditedBy(currentUser);
					lblAddIngredient.setText(dictionary.getValueOf("Ingredient added correctly"));
					lblAddIngredient.setTextFill(Paint.valueOf("Green"));
				}else {
					lblAddIngredient.setText(dictionary.getValueOf("There is already an ingredient with this name"));
					lblAddIngredient.setTextFill(Paint.valueOf("Red"));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			lblAddIngredient.setText(dictionary.getValueOf("All spaces must be filled"));
			lblAddIngredient.setTextFill(Paint.valueOf("Red"));
		}
	}

	//addIngredient-page to ingredient-page
	@FXML
	public void btnBackToIngredient(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("ingredient-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewIngredient();
			loadLanguageIngredientPage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Logged-in-page
	@FXML
	public void btnLoadIngredient(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("ingredient-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewIngredient();
			loadLanguageIngredientPage();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//ingredient-page
	@FXML
	public void btnOrganizeIngredients(ActionEvent event) {
		restaurant.sortIngredients();
		loadTableViewIngredient();
	}

	//Logged-in-page
	public void loadTableViewEmployees() {
		if(!restaurant.getEmployes().isEmpty()) {
			restaurant.sortEmployee();
		}
		ObservableList<Employee> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getEmployes());
		tvEmployees.setItems(observableList);
		tcName.setCellValueFactory(new PropertyValueFactory<Employee,String>("name")); 
		tcLastName.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName")); 
		tcId.setCellValueFactory(new PropertyValueFactory<Employee,String>("id"));
		tcNumOfOrders.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("numOfOrders"));
	}

	//ingredient
	public void loadTableViewIngredient() {
		ObservableList<Ingredient> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getIngredients());
		tvIngredients.setItems(observableList);
		tcIngredient.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("ingredients")); 
		tcAvialable.setCellValueFactory(new PropertyValueFactory<Ingredient,Boolean>("avialable")); 
	}

	//ingredient to admin ingredient
	@FXML
	public void btnAdminIngredients(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("admin-ingredients.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageAdminIngredients();
			for(int c=0;c<restaurant.getIngredients().size();c++) {
				cboxIngredients.getItems().add(restaurant.getIngredients().get(c).getIngredients());
			}
			lblIngredientCreatedBy.setText("");
			lblIngredientLastEditedBy.setText("");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void btnAddEmployee(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("create-Employee.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageCreateEmployee();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//admin ingredient
	@FXML
	public void btnAdminIngredientsToIngredients(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("ingredient-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewIngredient();
			loadLanguageIngredientPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//admin ingredient
	@FXML
	public void btnDeleteIngredient(ActionEvent event) {
		boolean found = false;
		for(int c=0;c<restaurant.getProducts().size() && !found;c++) {
			for(int i=0; i<restaurant.getProducts().get(c).getIngredients().size() && !found;i++) {

				if(restaurant.getProducts().get(c).getIngredients().get(i).getIngredients().equals(restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).getIngredients())) {
					found=true;
				}
			}
		}
		if(found) {
			lblAdminIngredientWarning.setText(dictionary.getValueOf("The ingredient cannot be deleted because a product is using it"));
			lblAdminIngredientWarning.setTextFill(Paint.valueOf("Red"));
		}else {
			restaurant.getIngredients().remove(cboxIngredients.getSelectionModel().getSelectedIndex());
			cboxIngredients.getItems().clear();

			for(int c=0;c<restaurant.getIngredients().size();c++) {
				cboxIngredients.getItems().add(restaurant.getIngredients().get(c).getIngredients());
			}
		}
	}

	//admin ingredient
	@FXML
	public void btnSaveIngredient(ActionEvent event) {
		//poner if para que no saque error

		boolean found = false;
		for(int c=0;c<restaurant.getProducts().size() && !found;c++) {
			for(int i=0; i<restaurant.getProducts().get(c).getIngredients().size() && !found;i++) {
				if(restaurant.getProducts().get(c).getIngredients().get(i).getIngredients().equals(restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).getIngredients())) {
					restaurant.getProducts().get(c).getIngredients().get(i).setAvialable(rbtnAdminIngredientsAvielable.isSelected());
					restaurant.getProducts().get(c).getIngredients().get(i).setLastEditedBy(currentUser);


				}
			}
		}
		restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).setAvialable(rbtnAdminIngredientsAvielable.isSelected());
		restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).setLastEditedBy(currentUser);
	}

	//admin ingredient
	@FXML
	public void cBoxChangeIngredient(ActionEvent event) {
		try{
			lblNameIngredient.setText(restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).getIngredients());
			lblIngredientCreatedBy.setText(restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).getCreatedBy());
			lblIngredientLastEditedBy.setText(restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).getLastEditedBy());
			if(restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).isAvialable()) {
				rbtnAdminIngredientsAvielable.setSelected(true);
			}else {
				rbtnAdminIngredientsNotAvailable.setSelected(true);
			}
		}catch(ArrayIndexOutOfBoundsException a){
			lblNameIngredient.setText(dictionary.getValueOf("The ingredient was deleted"));
			lblIngredientCreatedBy.setText("");
			lblIngredientLastEditedBy.setText("");
			rbtnAdminIngredientsAvielable.setSelected(false);
			rbtnAdminIngredientsNotAvailable.setSelected(false);
		}
	}

	//addProduct-page
	@FXML
	public void btnAddProduct(ActionEvent event) {
		lblAddProductWarning.setText("");
		if(txtNameOfProduct.getText().equals("") || txtTypeOfProduct.getText().equals("") || restaurant.getIngredientsForProduct().isEmpty() || restaurant.getSizeAndPrice().isEmpty()) {
			lblAddProductWarning.setText(dictionary.getValueOf("All spaces must be filled"));
			lblAddProductWarning.setTextFill(Paint.valueOf("Red"));
		}else {
			try {
				if(!restaurant.addProduct(txtNameOfProduct.getText() ,txtTypeOfProduct.getText())) {
					lblAddProductWarning.setText("Se creo el producto: "+txtNameOfProduct.getText()+" con exito");
					lblAddProductWarning.setTextFill(Paint.valueOf("Green"));
					lblSizeAndPriceOfProducts.setText("");
					lblIngredientsForProduct.setText("");
					restaurant.getProducts().get(restaurant.getProducts().size()-1).setCreatedBy(currentUser);
					restaurant.getProducts().get(restaurant.getProducts().size()-1).setLastEditedBy(currentUser);
				}else {
					lblAddProductWarning.setText(dictionary.getValueOf("There is already a product") + ": "+txtNameOfProduct.getText());
					lblAddProductWarning.setTextFill(Paint.valueOf("Red"));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//addProduct-page
	@FXML
	public void btnClearSizeAndPrice(ActionEvent event) {
		restaurant.resetsizeAndPriceArray();
		lblSizeAndPriceOfProducts.setText("");
		lblAddProductWarning.setText(dictionary.getValueOf("Product sizes deleted"));
		lblAddProductWarning.setTextFill(Paint.valueOf("Green"));
		txtSizeOfProduct.clear();
		txtPriceOfSizeOfProduct.clear();
	}

	//addProduct-page to product-page
	@FXML
	public void btnAddProductToProduct(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("product-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			restaurant.resetProductIngredientArray();
			restaurant.resetsizeAndPriceArray();
			loadTableViewProduct();
			loadLanguageProductPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//addProduct-page
	@FXML
	public void btnClearIngredientsForProduct(ActionEvent event) {
		restaurant.resetProductIngredientArray();
		lblIngredientsForProduct.setText("");
		lblAddProductWarning.setText(dictionary.getValueOf("Product ingredients deleted")+" \n test");
		lblAddProductWarning.setTextFill(Paint.valueOf("Green"));
	}

	//addProduct-page
	@FXML
	public void btnAddSizeAndPriceForProduct(ActionEvent event) {
		lblAddProductWarning.setText("");
		if(txtSizeOfProduct.getText().equals("")) {
			lblAddProductWarning.setText(dictionary.getValueOf("All spaces must be filled"));
			lblAddProductWarning.setTextFill(Paint.valueOf("Red"));
			txtSizeOfProduct.clear();
			txtPriceOfSizeOfProduct.clear();
		}else {
			try {
				if(!restaurant.productCheckDoubleSize(txtSizeOfProduct.getText())) {
					restaurant.sizeAndPriceForProduct(txtSizeOfProduct.getText(), Double.parseDouble(txtPriceOfSizeOfProduct.getText()));
					lblSizeAndPriceOfProducts.setText(lblSizeAndPriceOfProducts.getText()+" "+restaurant.getSizeAndPrice().get(restaurant.getSizeAndPrice().size()-1).getSize()+" con precio de: "+restaurant.getSizeAndPrice().get(restaurant.getSizeAndPrice().size()-1).getPrice()+" , ");
					txtSizeOfProduct.clear();
					txtPriceOfSizeOfProduct.clear();
				}else {
					lblAddProductWarning.setText(dictionary.getValueOf("The price must be a number"));
					lblAddProductWarning.setTextFill(Paint.valueOf("Red"));
				}
			}catch (NumberFormatException e) {
				lblAddProductWarning.setText(dictionary.getValueOf("This size has already been added"));
				lblAddProductWarning.setTextFill(Paint.valueOf("Red"));
			}
		}
	}

	//addProduct-page
	@FXML
	public void btnIngredientForProduct(ActionEvent event) {
		lblAddProductWarning.setText("");
		if(cboxIngredientsForProduct.getSelectionModel().getSelectedIndex()!=-1) {
			if(!restaurant.productCheckDoubleIngredient(restaurant.getIngredients().get(cboxIngredientsForProduct.getSelectionModel().getSelectedIndex()).getIngredients())) {
				restaurant.ingredientForProduct(restaurant.getIngredients().get(cboxIngredientsForProduct.getSelectionModel().getSelectedIndex()));

				lblIngredientsForProduct.setText(lblIngredientsForProduct.getText()+" "+restaurant.getIngredientsForProduct().get(restaurant.getIngredientsForProduct().size()-1).getIngredients()+" , ");
			}else {
				lblAddProductWarning.setText(dictionary.getValueOf("This ingredient has already been added"));
				lblAddProductWarning.setTextFill(Paint.valueOf("Red"));
			}
		}else {
			lblAddProductWarning.setText(dictionary.getValueOf("Select an ingredient"));
			lblAddProductWarning.setTextFill(Paint.valueOf("Red"));
		}
	}

	//logged in page to products page 
	@FXML
	public void btnLoadProducts(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("product-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewProduct();
			loadLanguageProductPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//product page
	@FXML
	public void btnImportProductData(ActionEvent event) {
		try {
			restaurant.importProductData(currentUser);
			loadTableViewProduct();
			restaurant.saveData();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	//product page to add product page
	@FXML
	public void btnLoadAddProduct(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("addProduct-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			for(int c=0;c<restaurant.getIngredients().size();c++) {
				cboxIngredientsForProduct.getItems().add(restaurant.getIngredients().get(c).getIngredients());
			}
			loadLanguageAddProductPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//product page to logged in page
	@FXML
	public void btnProductToLoggedInPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageLoggedInPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//product load tv
	public void loadTableViewProduct() {
		if(!restaurant.getProducts().isEmpty())
			restaurant.selectionSort();
		ObservableList<Product> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getProducts());
		tvProducts.setItems(observableList);
		tcNameOfProduct.setCellValueFactory(new PropertyValueFactory<Product,String>("name")); 
		tcTypeOfProduct.setCellValueFactory(new PropertyValueFactory<Product,String>("type")); 
	}

	//products to admin products
	@FXML
	public void btnProductsToAdminProducts(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("admin-product-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			for(int c=0;c<restaurant.getProducts().size();c++) {
				cboxProducts.getItems().add(restaurant.getProducts().get(c).getName());
			}
			loadLanguageAdminProductPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//product admin
	@FXML
	public void btnCboxIngredientsOfProduct(ActionEvent event) {
		if(cboxIngredientsOfProduct.getSelectionModel().getSelectedIndex()!=-1) {
			if(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getIngredients().get(cboxIngredientsOfProduct.getSelectionModel().getSelectedIndex()).isAvialable()) {
				lblAvialableIngredientProduct.setText(dictionary.getValueOf("Is available"));
			}else {
				lblAvialableIngredientProduct.setText(dictionary.getValueOf("Not available"));
			}

		}
	}
	//product admin
	@FXML
	public void btnCboxProducts(ActionEvent event) {
		cboxIngredientsOfProduct.getItems().clear();
		cboxSizeAndPriceOfProduct.getItems().clear();
		if(cboxProducts.getSelectionModel().getSelectedIndex()!=-1) {
			txtNameOfProductAdmin.setText(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getName());
			txtTypeOfProductAdmin.setText(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getType());
			lblLastEditedByProduct.setText("Ultimo cambio por: "+restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getLastEditedBy());
			lblCreatedByProduct.setText("Creado por: "+restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getCreatedBy());
			for(int c=0;c<restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getIngredients().size();c++) {
				cboxIngredientsOfProduct.getItems().add(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getIngredients().get(c).getIngredients());
			}
			for(int c=0;c<restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().size();c++) {
				cboxSizeAndPriceOfProduct.getItems().add(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(c).getSize());
			}
		}
	}
	//product admin
	@FXML
	public void btnCboxSizeAndPriceOfProduct(ActionEvent event) {
		if(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()!=-1) {
			txtSizeOfProductAdmin.setText(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).getSize());
			txtPriceOfSizeOfProductAdmin.setText(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).getPrice()+"");
		}
	}
	//product admin
	@FXML
	public void btnChangePriceOfSizeOfProduct(ActionEvent event) {
		if(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()!=-1) {
			try {
				if(!txtSizeOfProduct.getText().equals("")) {
					restaurant.getProducts().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).setSize(txtSizeOfProduct.getText());
				}
				if(!txtPriceOfSizeOfProductAdmin.getText().equals("")) {
					restaurant.getProducts().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).setPrice(Double.parseDouble(txtPriceOfSizeOfProductAdmin.getText()));
				}
				txtSizeOfProductAdmin.setText(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).getSize());
				txtPriceOfSizeOfProductAdmin.setText(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).getPrice()+"");
			}catch(NumberFormatException e) {
				lblProductAdminWarnings.setText(dictionary.getValueOf("Enter a valid number"));
				lblProductAdminWarnings.setTextFill(Paint.valueOf("Red"));
			}
		}
	}
	//product admin
	@FXML
	public void btnDeleteIngredientFromProduct(ActionEvent event) {
		if(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getIngredients().size()==1) {
			lblProductAdminWarnings.setText(dictionary.getValueOf("Product must have at least 1 ingredient"));
			lblProductAdminWarnings.setTextFill(Paint.valueOf("Red"));
		}else {
			restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getIngredients().remove(cboxIngredientsOfProduct.getSelectionModel().getSelectedIndex());
			cboxIngredientsOfProduct.getItems().clear();
			lblProductAdminWarnings.setText(dictionary.getValueOf("The ingredient has been was deleted"));
			lblProductAdminWarnings.setTextFill(Paint.valueOf("Green"));
			lblAvialableIngredientProduct.setText(dictionary.getValueOf("Availability"));
			for(int c=0;c<restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getIngredients().size();c++) {
				cboxIngredientsOfProduct.getItems().add(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getIngredients().get(c).getIngredients());
			}
		}
	}

	//product admin
	@FXML
	public void btnDeleteSizeAndPrice(ActionEvent event) {
		if(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().size()==1) {
			lblProductAdminWarnings.setText(dictionary.getValueOf("The product must be at least 1 size"));
			lblProductAdminWarnings.setTextFill(Paint.valueOf("Red"));
		}else{
			restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().remove(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex());
			cboxSizeAndPriceOfProduct.getItems().clear();
			for(int c=0;c<restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().size();c++) {
				cboxSizeAndPriceOfProduct.getItems().add(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(c).getSize());
			}
			txtSizeOfProductAdmin.clear();
			txtPriceOfSizeOfProductAdmin.clear();
		}
	}
	//product admin
	@FXML
	public void btnDeleteProductAdmin(ActionEvent event) {
		restaurant.getProducts().remove(cboxProducts.getSelectionModel().getSelectedIndex());
		txtSizeOfProductAdmin.clear();
		txtPriceOfSizeOfProductAdmin.clear();
		txtNameOfProductAdmin.clear();
		txtTypeOfProductAdmin.clear();
		cboxIngredientsOfProduct.getItems().clear();
		cboxSizeAndPriceOfProduct.getItems().clear();
		cboxProducts.getItems().clear();
		for(int c=0;c<restaurant.getProducts().size();c++) {
			cboxProducts.getItems().add(restaurant.getProducts().get(c).getName());
		}
		lblAvialableIngredientProduct.setText(dictionary.getValueOf("Availability"));
		lblProductAdminWarnings.setText(dictionary.getValueOf("The product was deleted"));
		lblProductAdminWarnings.setTextFill(Paint.valueOf("Green"));
		lblLastEditedByProduct.setText(dictionary.getValueOf("Last change by")+": ");
		lblCreatedByProduct.setText(dictionary.getValueOf("Created by")+": ");
	}

	@FXML
	public void btnSaveChangesAdmin(ActionEvent event) {
		if(!txtNameOfProductAdmin.getText().equals("")) {
			restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).setName(txtNameOfProductAdmin.getText());
		}
		if(!txtTypeOfProductAdmin.getText().equals("")) {
			restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).setType(txtTypeOfProductAdmin.getText());
		}
		restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).setLastEditedBy(currentUser+"a");
		cboxProducts.getItems().clear();
		for(int c=0;c<restaurant.getProducts().size();c++) {
			cboxProducts.getItems().add(restaurant.getProducts().get(c).getName());
		}
		txtSizeOfProductAdmin.clear();
		txtPriceOfSizeOfProductAdmin.clear();
		txtNameOfProductAdmin.clear();
		txtTypeOfProductAdmin.clear();
		cboxIngredientsOfProduct.getItems().clear();
		cboxSizeAndPriceOfProduct.getItems().clear();
		lblAvialableIngredientProduct.setText(dictionary.getValueOf("Availability"));
		lblProductAdminWarnings.setText(dictionary.getValueOf("The product was saved"));
		lblProductAdminWarnings.setTextFill(Paint.valueOf("Green"));
		lblLastEditedByProduct.setText(dictionary.getValueOf("Last change by")+": ");
		lblCreatedByProduct.setText(dictionary.getValueOf("Created by")+": ");

	}


	//product admin to product
	@FXML
	public void btnAdminProductToProduct(ActionEvent event) {

		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("product-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewProduct();
			loadLanguageProductPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//product admin to product
	@FXML
	public void btnAddIngredientAndSizePriceToProductPage(ActionEvent event) {
		selectedProduct=cboxProducts.getSelectionModel().getSelectedIndex();
		if(selectedProduct!=-1) {
			try {
				FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("addIngredientAndSizePrice-page.fxml"));
				fxmlLoader.setController(this);
				Parent login;
				login = fxmlLoader.load();
				mainPane.getChildren().setAll(login);
				for(int c=0;c<restaurant.getIngredients().size();c++) {
					cboxAddIngredientAdmin.getItems().add(restaurant.getIngredients().get(c).getIngredients());
				}
				loadLanguageAddIngredientAndSizePricePage();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			lblProductAdminWarnings.setText(dictionary.getValueOf("Select a product please"));
			lblProductAdminWarnings.setTextFill(Paint.valueOf("Red"));
		}
	}

	//add ingredient and size price
	@FXML
	public void btnAddIngredientToProduct(ActionEvent event) {
		boolean found= false;
		try {
			for(int c=0;c<restaurant.getProducts().get(selectedProduct).getIngredients().size()&&!found;c++) {
				if(restaurant.getProducts().get(selectedProduct).getIngredients().get(c).getIngredients().equals(restaurant.getIngredients().get(cboxAddIngredientAdmin.getSelectionModel().getSelectedIndex()).getIngredients())){
					found =true;
				}
			}
			if(found) {

				lblAddIngredientAndSizePriceWarning.setText(dictionary.getValueOf("The product already has this ingredient"));
				lblAddIngredientAndSizePriceWarning.setTextFill(Paint.valueOf("Red"));
			}else {
				restaurant.getProducts().get(selectedProduct).getIngredients().add(restaurant.getIngredients().get(cboxAddIngredientAdmin.getSelectionModel().getSelectedIndex()));
				lblAddIngredientAndSizePriceWarning.setText(dictionary.getValueOf("The ingredient was added to the product"));
				lblAddIngredientAndSizePriceWarning.setTextFill(Paint.valueOf("Green"));
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			lblAddIngredientAndSizePriceWarning.setText(dictionary.getValueOf("Select an ingredient"));
			lblAddIngredientAndSizePriceWarning.setTextFill(Paint.valueOf("Red"));
		}
	}
	//add ingredient and size price
	@FXML
	public void btnAddIngredientAndSizePriceToAdminProduct(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("admin-product-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadLanguageAdminProductPage();
			for(int c=0;c<restaurant.getProducts().size();c++) {
				cboxProducts.getItems().add(restaurant.getProducts().get(c).getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@FXML
	public void btnBackToMainPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("main-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadCbLogIn();
			loadLanguageMainPage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//add ingredient and size price
	@FXML
	public void btnAddSizeAndPriceToProduct(ActionEvent event) {
		if(txtPriceOfSizeOfProductAdmin.getText().equals("") || txtSizeOfProductAdmin.getText().equals("")) {
			lblAddIngredientAndSizePriceWarning.setText(dictionary.getValueOf("Fill in all the fields for the size"));
			lblAddIngredientAndSizePriceWarning.setTextFill(Paint.valueOf("Red"));
		}else {
			try {

				boolean found= false;

				for(int c=0;c<restaurant.getProducts().get(selectedProduct).getSizeAndPrice().size()&&!found;c++) {
					if(restaurant.getProducts().get(selectedProduct).getSizeAndPrice().get(c).getSize().equals(txtAddSizeToProductAdmin.getText())){
						found =true;
					}
				}

				if(found) {
					lblAddIngredientAndSizePriceWarning.setText(dictionary.getValueOf("This size has already been added"));
					lblAddIngredientAndSizePriceWarning.setTextFill(Paint.valueOf("Red"));
				}else {
					restaurant.getProducts().get(selectedProduct).addSizeAndPrice(new SizeAndPrice(txtAddSizeToProductAdmin.getText(),Double.parseDouble(txtAddSizeToProductAdmin.getText())));
					lblAddIngredientAndSizePriceWarning.setText(dictionary.getValueOf("A size was added"));
					lblAddIngredientAndSizePriceWarning.setTextFill(Paint.valueOf("Green"));
				}

			}catch (NumberFormatException e) {
				lblAddIngredientAndSizePriceWarning.setText(dictionary.getValueOf("Enter a valid number"));
				lblAddIngredientAndSizePriceWarning.setTextFill(Paint.valueOf("Red"));
			}
		}

	}




}



