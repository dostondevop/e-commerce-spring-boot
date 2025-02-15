package uz.pdp.ecommerce_with_spring_boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ecommerce_with_spring_boot.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}