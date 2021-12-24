package com.gent.miniproject.commonbackendservice.Model;



public class Products {

    private int ProductID;
    private String ProductName;
    private short UnitsInStock;
    private double UnitPrice;
    private boolean Discontinued;


    public Products() {    }

    public Products(String productName, short unitsInStock, double unitPrice, boolean discontinued) {
        ProductName = productName;
        UnitsInStock = unitsInStock;
        UnitPrice = unitPrice;
        Discontinued = discontinued;
    }

    public Products(String productName, double unitPrice) {
        ProductName = productName;
        UnitPrice = unitPrice;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public short getUnitsInStock() {
        return UnitsInStock;
    }

    public void setUnitsInStock(short unitsInStock) {
        UnitsInStock = unitsInStock;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public boolean isDiscontinued() {
        return Discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        Discontinued = discontinued;
    }


    @Override
    public String toString() {
        return "Tutorial [ProductID=" + ProductID + ", ProductName=" + ProductName + ", UnitsInStock=" + UnitsInStock + ", UnitPrice=" + UnitPrice + "]";
    }


}
