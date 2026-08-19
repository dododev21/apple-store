package com.applestore.service;

import com.applestore.entity.ContentBlock;
import com.applestore.entity.PageBlockType;
import com.applestore.entity.PageHero;
import com.applestore.repository.CategoryRepository;
import com.applestore.repository.ContentBlockRepository;
import com.applestore.repository.PageHeroRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class StoreService {

    private final CategoryRepository categoryRepository;
    private final PageHeroRepository pageHeroRepository;
    private final ContentBlockRepository contentBlockRepository;

    public StoreService(
            CategoryRepository categoryRepository,
            PageHeroRepository pageHeroRepository,
            ContentBlockRepository contentBlockRepository) {
        this.categoryRepository = categoryRepository;
        this.pageHeroRepository = pageHeroRepository;
        this.contentBlockRepository = contentBlockRepository;
    }

    public void populateMainPage(Model model) {
        model.addAttribute("activePage", "main");
        model.addAttribute("subPage", false);
        model.addAttribute("pageCss", "main.css");
        model.addAttribute("pageJs", "main.js");
        model.addAttribute("categories", categoryRepository.findAllByOrderBySortOrderAsc());
        model.addAttribute("hero", pageHeroRepository.findByPageSlug("main").orElseThrow());
        model.addAttribute("products", blocks("main", PageBlockType.MAIN_PRODUCT));
    }

    public void populateSubPage(Model model, String pageSlug) {
        PageHero hero = pageHeroRepository.findByPageSlug(pageSlug).orElseThrow();

        model.addAttribute("activePage", pageSlug);
        model.addAttribute("subPage", true);
        model.addAttribute("pageCss", pageSlug + ".css");
        model.addAttribute("pageJs", pageSlug + ".js");
        model.addAttribute("hero", hero);
        model.addAttribute("navCards", blocks(pageSlug, PageBlockType.NAV_CARD));
        model.addAttribute("banners", blocks(pageSlug, PageBlockType.BANNER));
        model.addAttribute("services", blocks(pageSlug, PageBlockType.SERVICE));
        model.addAttribute("accessories", blocks(pageSlug, PageBlockType.ACCESSORY));
        model.addAttribute("icons", blocks(pageSlug, PageBlockType.ICON));
        model.addAttribute("lineups", blocks(pageSlug, PageBlockType.LINEUP));
        model.addAttribute("features", blocks(pageSlug, PageBlockType.FEATURE));
        model.addAttribute("galleries", blocks(pageSlug, PageBlockType.GALLERY));
        model.addAttribute("stickyLeft", firstBlock(pageSlug, PageBlockType.STICKY_LEFT));
        model.addAttribute("stickyRight", firstBlock(pageSlug, PageBlockType.STICKY_RIGHT));
        model.addAttribute("compare", firstBlock(pageSlug, PageBlockType.COMPARE));
        model.addAttribute("smart", firstBlock(pageSlug, PageBlockType.SMART));
        model.addAttribute("bands", firstBlock(pageSlug, PageBlockType.BANDS));
        model.addAttribute("ios", firstBlock(pageSlug, PageBlockType.IOS));
        model.addAttribute("ultra", firstBlock(pageSlug, PageBlockType.ULTRA));
        model.addAttribute("videoSticky", firstBlock(pageSlug, PageBlockType.VIDEO_STICKY));
        model.addAttribute("videoCard", firstBlock(pageSlug, PageBlockType.VIDEO_CARD));
        model.addAttribute("healthCards", blocks(pageSlug, PageBlockType.HEALTH));
    }

    private List<ContentBlock> blocks(String pageSlug, String blockType) {
        return contentBlockRepository.findByPageSlugAndBlockTypeOrderBySortOrderAsc(pageSlug, blockType);
    }

    private ContentBlock firstBlock(String pageSlug, String blockType) {
        List<ContentBlock> blocks = blocks(pageSlug, blockType);
        return blocks.isEmpty() ? null : blocks.get(0);
    }
}
