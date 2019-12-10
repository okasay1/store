package be.wavenet.technocite.store.server.repository.impl;

import be.wavenet.technocite.store.server.configuration.ResourceFiles;
import be.wavenet.technocite.store.server.model.Customer;
import be.wavenet.technocite.store.server.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerRepositoryImpl extends AbstractRepository<Customer> implements CustomerRepository {


    public CustomerRepositoryImpl(ObjectReader objectReader, ResourceLoader resourceLoader) {
        super(objectReader, resourceLoader, ResourceFiles.CUSTOMER_CSV_FILE, Customer.class);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return findAll().stream()
                .filter(customer -> customer.getId().equals(id))
                .findAny();
    }
}
