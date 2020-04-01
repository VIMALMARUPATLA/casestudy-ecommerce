package com.sapient.casestudy.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Product implements Serializable {
	
    private static final long serialVersionUID = 2207764388503574828L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String brandName;
	private String productCategories;
	private String productCode;
    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
	private String productName;
	private String imageUrl;
	private double price;
	private int productSize;
	private String productColour;
	
    public Product()
    {
        super();
    }    

    public Product(String id, String brandName, String productCategories, String productCode, @NotNull(message = "Product name is required.") String productName, String imageUrl, double price, int size,
            String productColour)
    {
        super();
        this.id = id;
        this.brandName = brandName;
        this.productCategories = productCategories;
        this.productCode = productCode;
        this.productName = productName;
        this.imageUrl = imageUrl;
        this.price = price;
        this.productSize = size;
        this.productColour = productColour;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getBrandName()
    {
        return brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    public String getProductCategories()
    {
        return productCategories;
    }

    public void setProductCategories(String productCategories)
    {
        this.productCategories = productCategories;
    }

    public String getProductCode()
    {
        return productCode;
    }

    public void setProductCode(String productCode)
    {
        this.productCode = productCode;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getSize()
    {
        return productSize;
    }

    public void setSize(int size)
    {
        this.productSize = size;
    }

    public String getProductColour()
    {
        return productColour;
    }

    public void setProductColour(String productColour)
    {
        this.productColour = productColour;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
}
