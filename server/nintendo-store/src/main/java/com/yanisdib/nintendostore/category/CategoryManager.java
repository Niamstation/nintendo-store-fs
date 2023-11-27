package com.yanisdib.nintendostore.category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryManager implements SimpleCategoryManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryManager.class);

    private final CategoryRepository categoryRepository;
    private final CategoryPayloadMapper categoryPayloadMapper;

    public CategoryManager(
            CategoryRepository categoryRepository,
            CategoryPayloadMapper categoryPayloadMapper
    ) {
        this.categoryRepository = categoryRepository;
        this.categoryPayloadMapper = categoryPayloadMapper;
    }

    /**
     * Create a category and add it to MongoDB
     *
     * @param addRequest data sent to database
     */
    public void create(CategoryAddRequest addRequest) {

        if (addRequest == null) {
            LOGGER.info("Cannot save empty category");
            return;
        }

        LOGGER.info("Saving category: {}", addRequest);

        categoryRepository.save(new Category(
                addRequest.name(),
                addRequest.description(),
                addRequest.subcategories()
        ));
    }

    public void delete(String id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        LOGGER.info("Deleting category: {}", id);

        categoryRepository.delete(category);
    }

    /**
     * Retrieve a category by id
     *
     * @param id of the category
     * @return a category
     */
    public CategoryPayload findById(String id) {

        if (Objects.equals(id, "") || Objects.equals(id, null)) {
            LOGGER.info("Cannot find category with empty name");
            return null;
        }

        return categoryRepository.findById(id)
                .map(categoryPayloadMapper)
                .orElseThrow(() -> new CategoryNotFoundException(id));

    }

    /**
     * Retrieve a category by name
     *
     * @param name name of the category
     * @return a category payload
     */
    @Override
    public CategoryPayload findByName(String name) {

        if (Objects.equals(name, "") || Objects.equals(name, null)) {
            LOGGER.info("Cannot category with empty name");
            return null;
        }

        LOGGER.info("Searching for category: {}", name);

        return categoryRepository.findByName(name)
                .map(categoryPayloadMapper)
                .orElseThrow(() -> new CategoryNotFoundException(name));

    }

    /**
     * Find all categories from document
     *
     * @return a list of category payloads
     */
    public List<CategoryPayload> findAll() {

        LOGGER.info("Retrieving all categories...");

        return categoryRepository.findAll()
                .stream()
                .map(categoryPayloadMapper)
                .toList();

    }

    /**
     * Retrieve all subcategories by its parent category
     *
     * @param parentId Parent category's id
     * @return a list of categories
     */
    @Override
    public List<CategoryPayload> findAllByParent(String parentId) {

        CategoryPayload categoryPayload = categoryRepository.findById(parentId)
                .map(categoryPayloadMapper)
                .orElseThrow(() -> new CategoryNotFoundException(parentId));

        LOGGER.info("Retrieving subcategories from parent: {}", parentId);

        return categoryPayload.subcategories()
                .stream()
                .map(categoryPayloadMapper)
                .toList();

    }
}
