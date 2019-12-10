package be.wavenet.technocite.store.server.repository.impl;

import be.wavenet.technocite.store.server.configuration.ResourceFiles;
import be.wavenet.technocite.store.server.model.Product;
import be.wavenet.technocite.store.server.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductRepositoryImpl extends AbstractRepository<Product> implements ProductRepository {

    public ProductRepositoryImpl(ObjectReader objectReader, ResourceLoader resourceLoader) {
        super(objectReader, resourceLoader, ResourceFiles.PRODUCT_CSV_FILE, Product.class);
    }

    @Override
    public Optional<Product> findById(String id) {
        return findAll().stream()
                .filter(product -> product.getId().equals(id))
                .findAny();
    }
}
