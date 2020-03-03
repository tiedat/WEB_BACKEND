package Service.impl;

import Model.Product;

import java.util.List;

public interface IProductService extends IGeneralService<Product>{
    List<Product> sortPriceIncresing();
    List<Product> sortPriceDecresing();
}
