package com.applestore.repository;

import com.applestore.entity.ContentBlock;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentBlockRepository extends JpaRepository<ContentBlock, Long> {

    List<ContentBlock> findByPageSlugAndBlockTypeOrderBySortOrderAsc(String pageSlug, String blockType);

    List<ContentBlock> findByPageSlugOrderBySortOrderAsc(String pageSlug);
}
