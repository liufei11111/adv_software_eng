package models.data;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * Stock entity bean.
 */
@Entity
@Table(name="STOCK")
public class Stock extends Model  {

	private static final long serialVersionUID = 1L;

	@Id
	@Constraints.Required
	private Integer id;

	private String companyName;

	private String ticker;

	private Timestamp addedOn;

	@Constraints.Required
	private Timestamp lastUpdated;

	/**
	 * 1 - true
	 * 0 - false
	 */
	private Integer isEnabled;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<StockPrice> prices;

	@OneToMany
	private List<PortfolioStock> portfolios;



	public static Model.Finder<String, Stock> find = new Model.Finder<String, Stock>(
			String.class, Stock.class);

	/**
	 * Retrieve all users.
	 */
	public static List<Stock> findAll() {
		return find.all();
	}

	/**
	 * Return id.
	 */    
	public Integer getId() {
		return id;
	}

	/**
	 * Set id.
	 */    
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Return company name.
	 */    
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Set company name.
	 */    
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Return ticker.
	 */    
	public String getTicker() {
		return ticker;
	}

	/**
	 * Set ticker.
	 */    
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	/**
	 * Return added on.
	 */    
	public Timestamp getAddedOn() {
		return addedOn;
	}

	/**
	 * Set added on.
	 */    
	public void setAddedOn(Timestamp addedOn) {
		this.addedOn = addedOn;
	}

	/**
	 * Return last updated.
	 */    
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * Set last updated.
	 */    
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * Return is enabled.
	 */    
	public Integer getIsEnabled() {
		return isEnabled;
	}
	
	/**
	 * Set is enabled.
	 */    
	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * Return prices.
	 */    
	public List<StockPrice> getPrices() {
		return prices;
	}

	/**
	 * Set prices.
	 */    
	public void setPrices(List<StockPrice> prices) {
		this.prices = prices;
	}

	/**
	 * Return portfolios.
	 */    
	public List<PortfolioStock> getPortfolios() {
		return portfolios;
	}

	/**
	 * Set portfolios.
	 */    
	public void setPortfolios(List<PortfolioStock> portfolios) {
		this.portfolios = portfolios;
	}


}
