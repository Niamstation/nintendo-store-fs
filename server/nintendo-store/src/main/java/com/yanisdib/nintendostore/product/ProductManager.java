package com.yanisdib.nintendostore.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductManager implements SimpleProductManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductManager.class);

    private final ProductRepository productRepository;
    private final ProductPayloadMapper productPayloadMapper;

    public ProductManager(
            ProductRepository productRepository,
            ProductPayloadMapper productPayloadMapper
    ) {
        this.productRepository = productRepository;
        this.productPayloadMapper = productPayloadMapper;
    }

    /**
     * Create a product and add it to MongoDB
     *
     * @param addRequest data sent to database
     */
    public void create(ProductAddRequest addRequest) {

        if (addRequest == null) {
            LOGGER.info("Cannot save empty product.");
            return;
        }

        LOGGER.info("Saving product: {}", addRequest);

        productRepository.save(new Product(
                addRequest.reference(),
                addRequest.name(),
                addRequest.description(),
                addRequest.categories(),
                addRequest.releaseDate(),
                addRequest.unitPrice(),
                addRequest.stock(),
                addRequest.productAvailability()
        ));

    }

    /**
     * Remove a product from MongoDB
     * @param id product's id
     */
    public void delete(String id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        LOGGER.info("Deleting product " + product.getId());

        productRepository.delete(product);

    }

    public void update(ProductAddRequest addRequest, String id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        LOGGER.info("Updating product " + product.getId());

        productRepository.save(product);

    }

    /**
     * Find all database records from products document
     *
     * @return a list of products
     */
    public List<ProductPayload> findAll() {

        List<ProductPayload> products = productRepository.findAll()
                .stream()
                .map(productPayloadMapper)
                .toList();

        LOGGER.info("Products found: {}", products);

        return products;

    }

    /**
     * Find a record from product document by id
     * @param id product's id
     * @return a product
     */
    public ProductPayload findById(String id) {

        Product product = productRepository.findById(id).orElseThrow();

        return new ProductPayload(
                product.getId(),
                product.getReference(),
                product.getName(),
                product.getDescription(),
                product.getCategories(),
                product.getReleaseDate(),
                product.getUnitPrice(),
                product.getStock(),
                product.getAvailability()
        );

    }

    /**
     * Find a record from product document by name
     *
     * @param name name of the product
     * @return a product
     */
    @Override
    public ProductPayload findByName(String name) {
        if (Objects.equals(name, "")) {
            LOGGER.info("Cannot find product with empty name");
            return null;
        }

        return productRepository.findByReference(name);
    }

    /**
     * Find all database records from products document by category
     *
     * @param category category of products
     * @return a list of products
     */
    @Override
    public List<ProductPayload> findAllByCategory(String category) {

        List<ProductPayload> products = productRepository.findAll()
                .stream()
                .map(productPayloadMapper)
                .toList();

        LOGGER.info("Products found: {}", products);

        return products;

    }

    /**
     * Find a record from product document by reference
     *
     * @param reference of searched product
     * @return a product
     */
    @Override
    public ProductPayload findByReference(String reference) {

        if (Objects.equals(reference, "")) {
            LOGGER.info("Cannot find product with empty reference");
            return null;
        }

        return productRepository.findByReference(reference);

    }

}
