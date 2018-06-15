package com.ara.controller;

import com.ara.model.Offer;
import com.ara.model.Product;
import com.ara.search.OfferSearch;
import com.ara.search.ProductSearch;
import com.ara.service.OfferService;
import com.ara.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import java.util.Collection;
import java.util.List;

/**
 * CRUD RESTful controller for Offer object
 */
@RestController
@Api(value="offer",tags = {"Offer Management"})
public class OfferRestController {

    @Autowired
    private OfferService offerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OfferSearch offerSearch;

    @Autowired
    private ProductSearch productSearch;

    @ApiOperation(value = "getOffers", nickname = "getOffers")
    @GetMapping(value = "/offers")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public ResponseEntity<Collection<Offer>> getOffers(){
        return new ResponseEntity<>(offerService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "getProducts", nickname = "getProducts")
    @GetMapping(value = "/products")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public ResponseEntity<Collection<Product>> getProducts(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "createOffer", nickname = "createOffer")
    @PostMapping("/offers")
    public void addOffer(@RequestBody Offer offer){
        offerService.saveOffer(offer);
    }

    @ApiOperation(value = "createProduct", nickname = "createProduct")
    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }

    @ApiOperation(value = "updateOfferByOfferCode", nickname = "updateOfferByOfferCode")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiParam(name="offercode",value="Offer Code",required = true)
    @PatchMapping(value = "/offer/{offercode}",consumes = "application/merge-patch+json")
    public void updateOffer(@RequestBody Offer offer,@PathVariable String offercode){
        offerService.updateByOffercode(
                offerService.findByOffercode(offercode));
    }

    @ApiOperation(value = "getOfferById", nickname = "getOfferById")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiParam(name="id",value="Offer Id",required = true)
    @GetMapping("/offers/{id}")
    public ResponseEntity<Offer> getOffer(@PathVariable long id){
        Offer offer = offerService.findOne(id);
        if (offer != null) {
            return new ResponseEntity<>(offer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(offer, HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "getOfferByOfferCode", nickname = "getOfferByOfferCode")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiParam(name="offercode",value="Offer Code",required = true)
    @GetMapping("/offer/{offercode}")
    public ResponseEntity<Offer> getOfferCode(@PathVariable String offercode){
        Offer offer = offerService.findByOffercode(offercode);
        if (offer != null) {
            return new ResponseEntity<>(offer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(offer, HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "searchOffer", nickname = "searchOffer")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "q", value = "query string", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/searchoffer")
    public ResponseEntity<List<Offer>> searchOffer(String q){
        List<Offer> searchResults = null;
        try {
            searchResults =  offerSearch.searchOffer(q);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(searchResults,HttpStatus.OK);
    }

    @ApiOperation(value = "searchProduct", nickname = "searchProduct")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "q", value = "query string", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/searchproduct")
    public ResponseEntity<List<Product>> searchProudct(String q){
        List<Product> searchResults = null;
        try{
            searchResults = productSearch.searchProduct(q);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(searchResults,HttpStatus.OK);
    }

    @GetMapping("/offerproduct")
    public ResponseEntity<List<Product>> searchOfferProduct(String q){
        List<Product> searchResults = null;
        try {
            searchResults = offerSearch.searchProduct(q);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(searchResults,HttpStatus.OK);
    }


}
