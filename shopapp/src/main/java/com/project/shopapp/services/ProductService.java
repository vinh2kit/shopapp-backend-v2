package com.project.shopapp.services;

import com.project.shopapp.dto.ProductDTO;
import com.project.shopapp.dto.ProductImageDTO;
import com.project.shopapp.model.Category;
import com.project.shopapp.model.Product;
import com.project.shopapp.model.ProductImage;
import com.project.shopapp.repositories.CategoryRepository;
import com.project.shopapp.repositories.ProductImageRepository;
import com.project.shopapp.repositories.ProductRepository;
import com.project.shopapp.responses.ProductResponse;
import com.project.shopapp.services.interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductImageRepository productImageRepository;
    @Override
    public Product createProduct(ProductDTO productDTO) throws Exception {
        Category existingCategory = categoryRepository
                .findById(productDTO.getCategoryId())
                .orElseThrow(() ->
                        new Exception(
                                "Cannot find : "+productDTO.getCategoryId()));

        Product newProduct = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .thumbnail(productDTO.getThumbnail())
                .description(productDTO.getDescription())
                .category(existingCategory)
                .build();
        return productRepository.save(newProduct);
    }

    @Override
    public Product getProductById(long productId) throws Exception {
        return productRepository.findById(productId).
                orElseThrow(()-> new Exception(
                        "Cannot find "+productId));
    }

    @Override
    public Page<ProductResponse> getAllProducts(PageRequest pageRequest) {
//        return productRepository
//                .findAll(pageRequest)
//                .map(product -> ProductResponse.fromProduct(product));
        return productRepository    // cái này đẹp hơn, được IDE khuyến khích
                .findAll(pageRequest)
                .map(ProductResponse::fromProduct);

    }

    @Override
    public Product updateProduct(
            long id,
            ProductDTO productDTO
    )
            throws Exception {
        Product existingProduct = getProductById(id);
        if(existingProduct != null) {
            //copy các thuộc tính từ DTO -> Product
            //Có thể sử dụng ModelMapper
            Category existingCategory = categoryRepository
                    .findById(productDTO.getCategoryId())
                    .orElseThrow(() ->
                            new Exception(
                                    "Cannot find "+productDTO.getCategoryId()));
            existingProduct.setName(productDTO.getName());
            existingProduct.setCategory(existingCategory);
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setDescription(productDTO.getDescription());
            existingProduct.setThumbnail(productDTO.getThumbnail());
            return productRepository.save(existingProduct);
        }
        return null;

    }

    @Override
    public void deleteProduct(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        optionalProduct.ifPresent(productRepository::delete);
    }

    @Override
    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }
    @Override
    public ProductImage createProductImage(
            Long productId,
            ProductImageDTO productImageDTO) throws Exception {
        Product existingProduct = productRepository
                .findById(productId)
                .orElseThrow(() ->
                        new Exception(
                                "Cannot find: "+productImageDTO.getProductId()));
        ProductImage newProductImage = ProductImage.builder()
                .product(existingProduct)
                .imageUrl(productImageDTO.getImageUrl())
                .build();
        int size = productImageRepository.findByProductId(productId).size();
        if(size >= ProductImage.MAXIMUM_IMAGES_PER_PRODUCT) {
            throw new Exception(
                    "quantity of images <= "
                    +ProductImage.MAXIMUM_IMAGES_PER_PRODUCT);
        }
        return productImageRepository.save(newProductImage);
    }
}
