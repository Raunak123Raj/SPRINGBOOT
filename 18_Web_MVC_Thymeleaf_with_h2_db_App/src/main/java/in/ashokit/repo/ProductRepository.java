package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.binding.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
