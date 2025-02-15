package uz.pdp.ecommerce_with_spring_boot.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommerce_with_spring_boot.entity.Category;
import uz.pdp.ecommerce_with_spring_boot.dto.CategorySaveDto;
import uz.pdp.ecommerce_with_spring_boot.repo.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category getOneCategory(@PathVariable Integer id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void saveCategory(@RequestBody CategorySaveDto categorySaveDto) {
        Category category = Category
                .builder()
                .name(categorySaveDto.getCategoryName())
                .build();

        categoryRepository.save(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateCategory(@RequestBody CategorySaveDto categorySaveDto,
                               @PathVariable Integer id) {
        Category category = Category
                .builder()
                .id(id)
                .name(categorySaveDto.getCategoryName())
                .build();

        categoryRepository.save(category);
    }
}