package uz.pdp.ecommerce_with_spring_boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ecommerce_with_spring_boot.entity.AttachmentContent;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {
    AttachmentContent findByAttachmentId(Integer attachmentId);
}