package com.example.ed.serviceImplementations;

import com.example.ed.entities.*;
import com.example.ed.models.OrderModel;
import com.example.ed.models.ProductModel;
import com.example.ed.repositories.OrderRepository;
import com.example.ed.repositories.ProductRepository;
import com.example.ed.services.ConfigurationService;
import com.example.ed.services.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ProductConfigurationImplementation implements ProductService {

    private final ProductRepository productRepo;
    private final ConfigurationService configurationService;
    private final OrderRepository orderRepo;

    public ProductConfigurationImplementation(ProductRepository productRepo, ConfigurationService configurationService, OrderRepository orderRepo) {
        this.productRepo = productRepo;
        this.configurationService = configurationService;
        this.orderRepo = orderRepo;
    }

    public Products createProduct(ProductModel productModel){
        Products product=new Products();
        Double totalQuantity = 0.0;
        Double totalPrice = 0.0;
        List<Details> productContent = new ArrayList<>();
        for (subCategories p:
                productModel.getContent() ) {
                subCategories subCategory=configurationService.getSubCategoryById(p.getId());
                Double customPrice=this.calculateUnitPrice(subCategory,p.getQuantity());
                Details detail_=new Details();
                detail_.setProduct(product);
                totalPrice+=customPrice;
                detail_.setPrice(customPrice);
                detail_.setQuantity(p.getQuantity());
                detail_.setName(subCategory.getName()+" "+p.getQuantity()+" ml");
                detail_.setDescription(subCategory.getName()+" "+p.getQuantity()+" ml");
                detail_.setSubCategory(subCategory);
                productContent.add(detail_);
                totalQuantity+=detail_.getQuantity();

        }
        product.setName(productModel.getName());
        product.setProposedRetailPrice(productModel.getProposedRetailPrice());
        product.setProductDescription(productModel.getProductDescription());
        product.setCostOfProduction(totalPrice);
        product.setTotalQuantity(totalQuantity);
         this.saveProduct(product);
            this.saveDetails(productContent);

        return product;
    }

   @Async
    public void saveDetails(List<Details> details_){
        log.info("Saving Detail(s): {}",details_);
        try {
           configurationService.createSubDetailsList(details_);
        }
         catch (Exception e){
            log.error("Error Saving Detail(s) Error: {}",e.getMessage());
         }

    }
    //saving a single product
    @Async
    public void saveProduct(Products product){
        Double transportC=this.calculateTransport(product.getTotalQuantity());
        log.info("Transport Cost Calculated at Ksh {} ",transportC);
        Double totalProductCost=transportC+product.getCostOfProduction();
        log.info("Total  Cost cost of production Calculated at Ksh {} ",totalProductCost);
        product.setCostOfProduction(totalProductCost);
        Double customProfit=this.calculateProfitMargin(product.getTotalQuantity())+product.getCostOfProduction();
        if (product.getProposedRetailPrice()<customProfit){
            product.setProposedRetailPrice(customProfit);
        }
        log.info("Saving product .. .. ..");
        try {
            productRepo.save(product);
        }catch (Exception e){
           log.error(e.getMessage());
        }

    }
    public List<Products> getAllProducts(){
        return productRepo.findAll();
    }
    //processing order
    public Orders processOrder(OrderModel order_){
        log.info("Processing Order");
      Orders order=new Orders();
      List<Products> orderProducts = new ArrayList<>();
      Double proposedRetailPrice=0.0;
        Double costOfProduction=0.0;
        for (Products product:
             order_.getProducts()) {
             orderProducts.add(product);
             costOfProduction+=product.getCostOfProduction();
             proposedRetailPrice+=product.getProposedRetailPrice();

            
        }
        order.setOrderContent(orderProducts);
        order.setCostOfProduction(costOfProduction);
        order.setProposedRetailPrice(proposedRetailPrice);
        Double calculatedProfit=proposedRetailPrice-costOfProduction;
        order.setCalculatedProfit(calculatedProfit);

      return this.saveOrder(order);
    }

   //saving an order
  private Orders saveOrder(Orders order){
        log.info("Saving Order ... ");
        return orderRepo.save(order);
  }
public List<Orders> getAllOrder(){return orderRepo.findAll();}
    //calculating fixed charges per product
    private Double calculateTransport(Double quantity){
        String chargeType="TRANSPORT_RATE";
        Configurations configuration=configurationService.getConfigByName(chargeType);
        Double charge=(configuration.getBaseCharge()/100)*quantity;
        return this.getActualCharge(chargeType,charge);
    }
    private Double calculateProfitMargin(Double quantity){
        String chargeType="PROFIT_MARGIN";
        Configurations configuration=configurationService.getConfigByName(chargeType);
        Double charge=(configuration.getBaseCharge()/100)*quantity;

        return this.getActualCharge(chargeType,charge);
    }
    //checking Minimum Charge
    private Double getActualCharge(String chargeType, Double charge){
        Configurations configuration=configurationService.getConfigByName(chargeType+"_MIN_CHARGE");
        Double minimumCharge=configuration.getBaseCharge();
        if (charge<minimumCharge){
            charge=minimumCharge;
        }
        return charge;
    }

    //calculate price in small units
    public Double calculateUnitPrice(subCategories subCategory, Double quantity){
        Double uPrice;
        log.info("working Sub Category: {}",subCategory);
               Double pricePerMl=subCategory.getBasePrice()/subCategory.getQuantity();
               log.info("price per ml : {}",pricePerMl);
               uPrice=pricePerMl*quantity;
               log.info("{} ml calculated at ksh {}",quantity,uPrice);

        return uPrice;
    }
}
