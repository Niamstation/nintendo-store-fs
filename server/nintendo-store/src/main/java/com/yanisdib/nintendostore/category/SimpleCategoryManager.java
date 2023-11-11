package com.yanisdib.nintendostore.category;

import java.util.List;

public interface SimpleCategoryManager {

    CategoryPayload findByName(String name) throws CategoryNotFoundException;

    List<CategoryPayload> findAllByParent(String parentId) throws CategoryNotFoundException;

}
