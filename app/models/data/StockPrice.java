package models.data;

import constants.ApplicationConstants;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * Stock Price entity bean.
 */
@Entity
@Table(name = "STOCK_PRICE")
public class StockPrice extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    @Constraints.Required
    private Integer id;

    private Timestamp Date;

    private Double Open;

    private Double High;

    private Double Low;

    private Double Close;

    @ManyToOne
    private Stock stock;

    public static Model.Finder<String, StockPrice> find = new Model.Finder<String, StockPrice>(String.class, StockPrice.class);

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

    public Timestamp getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {

        Date = new Timestamp(date.getTime());
    }

    public Double getOpen() {
        return Open;
    }

    public void setOpen(Double open) {
        Open = open;
    }

    public Double getHigh() {
        return High;
    }

    public void setHigh(Double high) {
        High = high;
    }

    public Double getLow() {
        return Low;
    }

    public void setLow(Double low) {
        Low = low;
    }

    public Double getClose() {
        return Close;
    }

    public void setClose(Double close) {
        Close = close;
    }

    /**
     * Return stock.
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * Set stock.
     */
    public void setStock(Stock stock) {
        this.stock = stock;
    }

    /**
     * Gets stock price
     *
     * @return
     */
    public double getStockPrice() {
        //this algorith ensure
        long myBin = System.currentTimeMillis() / ApplicationConstants.STOCK_PRICE_CHANGE_INTERVAL;
        double multiplier = (ApplicationConstants.STOCK_PRICE_CHANGE_BINS - (myBin % ApplicationConstants.STOCK_PRICE_CHANGE_BINS)) / ((double) ApplicationConstants.STOCK_PRICE_CHANGE_BINS);
        return Low + ((High - Low) * multiplier);
    }

    public boolean isValidQuotedPrice(double quotedPrice) {
        return Low <= quotedPrice && quotedPrice <= High;
    }
}
