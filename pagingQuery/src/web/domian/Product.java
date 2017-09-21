package web.domian;

import java.util.Date;

public class Product {
/*商品
    create table `product` (
            `pid` varchar (96),
	        `pname` varchar (150),
	        `market_price` double ,
            `shop_price` double ,
            `pimage` varchar (600),
            `pdate` date ,
            `pdesc` varchar (765)
    );*/

    private String pid;
    private String pname;
    private String market_price;
    private String shop_price;
    private String pimage;
    private Date pdate;
    private String pdesc;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getMarket_price() {
        return market_price;
    }

    public void setMarket_price(String market_price) {
        this.market_price = market_price;
    }

    public String getShop_price() {
        return shop_price;
    }

    public void setShop_price(String shop_price) {
        this.shop_price = shop_price;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }
}
