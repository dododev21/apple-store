package com.applestore.config;

import com.applestore.entity.Category;
import com.applestore.entity.ContentBlock;
import com.applestore.entity.PageBlockType;
import com.applestore.entity.PageHero;
import com.applestore.repository.CategoryRepository;
import com.applestore.repository.ContentBlockRepository;
import com.applestore.repository.PageHeroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final PageHeroRepository pageHeroRepository;
    private final ContentBlockRepository contentBlockRepository;

    public DataInitializer(
            CategoryRepository categoryRepository,
            PageHeroRepository pageHeroRepository,
            ContentBlockRepository contentBlockRepository) {
        this.categoryRepository = categoryRepository;
        this.pageHeroRepository = pageHeroRepository;
        this.contentBlockRepository = contentBlockRepository;
    }

    @Override
    public void run(String... args) {
        if (categoryRepository.count() > 0) {
            return;
        }

        seedCategories();
        seedHeroes();
        seedMainProducts();
        seedMac();
        seedIpad();
        seedIphone();
        seedWatch();
        seedAirpods();
    }

    private void seedCategories() {
        saveCategory("Mac", "mac", "/images/main/mac.png", "/mac", 1);
        saveCategory("iPad", "ipad", "/images/main/ipad.png", "/ipad", 2);
        saveCategory("iPhone", "iphone", "/images/main/iphone.png", "/iphone", 3);
        saveCategory("Watch", "watch", "/images/main/watch.png", "/watch", 4);
        saveCategory("AirPods", "airpods", "/images/main/airpods.png", "/airpods", 5);
        saveCategory("Accessories", "accessories", "/images/main/accessories.png", null, 6);
    }

    private void seedHeroes() {
        saveHero("main", null, "iPhone 17 Pro", "혁신은 또 한 번, 당신의 손안에서.", "/images/main/main_img01.png");
        saveHero("mac", null, "Mac", "가능을 펼쳐보이다.", "/images/mac/nav_mbp_bfa749034.png");
        saveHero("ipad", "새로운 경험", "iPad", "강력함은 더 얇게.<br/>상상력은 더 거대하게.", "/images/ipad/shop-ipad.png");
        saveHero("iphone", "새로운 iPhone", "iPhone", "가장 강력한 성능.<br>가장 아름다운 경험.", "/images/iphone/iphone_17pro_pd01_large.jpg");
        saveHero("watch", "Apple Watch", "WATCH", "건강. 연결. 움직임.<br>손목 위의 미래.", "/images/watch/watch-main.png");
        saveHero("airpods", "새로운 AirPods", "AirPods", "몰입의 새로운 차원.<br>당신만의 사운드.", "/images/airpods/hero.png");
    }

    private void seedMainProducts() {
        saveBlock("main", PageBlockType.MAIN_PRODUCT, "iPhone 17 Pro", null, "프로 그 이상의 퍼포먼스.", "/images/main/iphone_pro.jpg", "dark", 1);
        saveBlock("main", PageBlockType.MAIN_PRODUCT, "iPhone Air", null, "놀랍도록 가볍다.", "/images/main/iphone_air.jpg", "light", 2);
        saveBlock("main", PageBlockType.MAIN_PRODUCT, "iPhone 17", null, "새로운 컬러, 새로운 감성.", "/images/main/iphone17.jpg", "purple", 3);
        saveBlock("main", PageBlockType.MAIN_PRODUCT, "iPhone 17e", null, "매일이 특별해지는 경험.", "/images/main/iphone17e.jpg", "pink", 4);
    }

    private void seedMac() {
        saveBlock("mac", PageBlockType.NAV_CARD, "iMac", null, null, "/images/mac/nav_imac.png", null, 1);
        saveBlock("mac", PageBlockType.NAV_CARD, "MacBook Air", null, null, "/images/mac/mba.jpg", null, 2);
        saveBlock("mac", PageBlockType.NAV_CARD, "MacBook Pro", null, null, "/images/mac/mbp.jpg", null, 3);
        saveBlock("mac", PageBlockType.NAV_CARD, "비교하기", null, null, "/images/mac/compare.png", null, 4);

        for (int i = 1; i <= 6; i++) {
            saveBlock("mac", PageBlockType.BANNER, null, null, null, "/images/mac/bnr0" + i + ".png", null, i);
        }

        saveBlock("mac", PageBlockType.SERVICE, "Trade In", null, "기존 제품 보상 판매.", "/images/mac/service01.png", null, 1);
        saveBlock("mac", PageBlockType.SERVICE, "전문가 지원", null, "제품 선택부터 설정까지.", "/images/mac/service02.png", null, 2);
        saveBlock("mac", PageBlockType.SERVICE, "Apple Store App", null, "더 빠른 쇼핑 경험.", "/images/mac/service03.png", null, 3);
        saveBlock("mac", PageBlockType.SERVICE, "액세서리", null, "Mac과 완벽한 조합.", "/images/mac/service04.png", null, 4);

        saveBlock("mac", PageBlockType.ACCESSORY, "Magic Keyboard", null, null, "/images/mac/acc01.png", null, 1);
        saveBlock("mac", PageBlockType.ACCESSORY, "Studio Display", null, null, "/images/mac/acc02.png", null, 2);
    }

    private void seedIpad() {
        saveBlock("ipad", PageBlockType.STICKY_LEFT, "압도적인 몰입감.", null,
                "Apple Pencil Pro와 Liquid Retina 디스플레이가 만나 창작의 경계를 무너뜨립니다.", null, null, 1);
        saveBlock("ipad", PageBlockType.STICKY_RIGHT, null, null, null, "/images/ipad/bnr01.png", null, 1);

        saveBlock("ipad", PageBlockType.LINEUP, "iPad", "가장 다재다능한 iPad", null, "/images/ipad/ipad.png", null, 1);
        saveBlock("ipad", PageBlockType.LINEUP, "iPad Air", "놀랍도록 가볍고 강력하게", null, "/images/ipad/ipad-air.png", null, 2);
        saveBlock("ipad", PageBlockType.LINEUP, "iPad Pro", "궁극의 프로를 위한 성능", null, "/images/ipad/ipad-pro.png", null, 3);

        saveBlock("ipad", PageBlockType.GALLERY, null, null, null, "/images/ipad/bnr02.png", "large", 1);
        saveBlock("ipad", PageBlockType.GALLERY, null, null, null, "/images/ipad/bnr03.png", null, 2);
        saveBlock("ipad", PageBlockType.GALLERY, null, null, null, "/images/ipad/bnr04.png", null, 3);
        saveBlock("ipad", PageBlockType.GALLERY, null, null, null, "/images/ipad/bnr05.png", "wide", 4);

        saveBlock("ipad", PageBlockType.COMPARE, "비교해보세요.", "최고의 iPad를 선택하는 가장 쉬운 방법.", null, "/images/ipad/compare.png", null, 1);
    }

    private void seedIphone() {
        saveBlock("iphone", PageBlockType.VIDEO_STICKY, "Pro. Beyond.", null, null, null, null, 1);
        saveBlock("iphone", PageBlockType.VIDEO_CARD, null, null, null, "/images/iphone/iphone_air_pd02_large.jpg", null, 1);

        saveBlock("iphone", PageBlockType.LINEUP, "iPhone", null, null, "/images/iphone/iphone-m01.png", null, 1);
        saveBlock("iphone", PageBlockType.LINEUP, "iPhone Air", null, null, "/images/iphone/iphone-m02.png", null, 2);
        saveBlock("iphone", PageBlockType.LINEUP, "iPhone Pro", null, null, "/images/iphone/iphone-m03.png", null, 3);
        saveBlock("iphone", PageBlockType.LINEUP, "iOS", null, null, "/images/iphone/iphone-m04.png", null, 4);

        saveBlock("iphone", PageBlockType.FEATURE, "Titanium.", "놀랍도록 가볍고 강력하게.", null, "/images/iphone/iphone_17pro_pd01_large.jpg", "large", 1);
        saveBlock("iphone", PageBlockType.FEATURE, null, null, null, "/images/iphone/iphone_17_pd03_large.jpg", null, 2);
        saveBlock("iphone", PageBlockType.FEATURE, null, null, null, "/images/iphone/iphone_17e_pd04_large.jpg", null, 3);

        saveBlock("iphone", PageBlockType.IOS, "iOS 26", "더 스마트하게.<br>더 개인화되게.", null, "/images/iphone/nav_ios_m.png", null, 1);
    }

    private void seedWatch() {
        saveBlock("watch", PageBlockType.ULTRA, "Ultra.", null, null, "/images/watch/ultra.png", null, 1);

        saveBlock("watch", PageBlockType.LINEUP, "Apple Watch", null, null, "/images/watch/watch-main.png", null, 1);
        saveBlock("watch", PageBlockType.LINEUP, "Apple Watch SE", null, null, "/images/watch/watch-se.png", null, 2);
        saveBlock("watch", PageBlockType.LINEUP, "Apple Watch Ultra", null, null, "/images/watch/ultra.png", null, 3);

        saveBlock("watch", PageBlockType.FEATURE, "Fitness+", "더 건강한 하루를 위한 동기부여.", null, "/images/watch/service01.png", "large", 1);
        saveBlock("watch", PageBlockType.FEATURE, null, null, null, "/images/watch/service02.png", null, 2);
        saveBlock("watch", PageBlockType.FEATURE, null, null, null, "/images/watch/service03.png", null, 3);
        saveBlock("watch", PageBlockType.FEATURE, null, null, null, "/images/watch/service04.png", "wide", 4);

        saveBlock("watch", PageBlockType.BANDS, "새로운 밴드.", "스타일은 더 자유롭게.<br>개성은 더 선명하게.", null, "/images/watch/bands.png", null, 1);

        saveBlock("watch", PageBlockType.HEALTH, null, null, null, "/images/watch/bnr01.png", null, 1);
        saveBlock("watch", PageBlockType.HEALTH, null, null, null, "/images/watch/bnr02.png", null, 2);
        saveBlock("watch", PageBlockType.HEALTH, null, null, null, "/images/watch/bnr03.png", null, 3);
    }

    private void seedAirpods() {
        saveBlock("airpods", PageBlockType.ICON, "빠른 배송", null, null, "/images/airpods/icon01.png", null, 1);
        saveBlock("airpods", PageBlockType.ICON, "할부 혜택", null, null, "/images/airpods/icon02.png", null, 2);
        saveBlock("airpods", PageBlockType.ICON, "전문 상담", null, null, "/images/airpods/icon03.png", null, 3);
        saveBlock("airpods", PageBlockType.ICON, "쉬운 결제", null, null, "/images/airpods/icon04.png", null, 4);

        saveBlock("airpods", PageBlockType.LINEUP, "AirPods", null, null, "/images/airpods/product01.png", null, 1);
        saveBlock("airpods", PageBlockType.LINEUP, "AirPods 4", null, null, "/images/airpods/product02.png", null, 2);
        saveBlock("airpods", PageBlockType.LINEUP, "AirPods Pro", null, null, "/images/airpods/product03.png", null, 3);
        saveBlock("airpods", PageBlockType.LINEUP, "AirPods Max", null, null, "/images/airpods/product04.png", null, 4);

        saveBlock("airpods", PageBlockType.FEATURE, "AirPods Max 2", "압도적인 사운드 경험.", null, "/images/airpods/airpodsmax.png", "large", 1);
        saveBlock("airpods", PageBlockType.FEATURE, null, null, null, "/images/airpods/airpods4.png", null, 2);
        saveBlock("airpods", PageBlockType.FEATURE, null, null, null, "/images/airpods/bnr01.png", null, 3);

        saveBlock("airpods", PageBlockType.SMART, "스마트 기능.", "운동 추적부터 실시간 통역까지.<br>AirPods는 더 똑똑해졌습니다.", null, "/images/airpods/bnr04.png", null, 1);

        saveBlock("airpods", PageBlockType.GALLERY, null, null, null, "/images/airpods/bnr02.png", null, 1);
        saveBlock("airpods", PageBlockType.GALLERY, null, null, null, "/images/airpods/bnr03.png", null, 2);
    }

    private void saveCategory(String name, String slug, String imageUrl, String linkUrl, int sortOrder) {
        Category category = new Category();
        category.setName(name);
        category.setSlug(slug);
        category.setImageUrl(imageUrl);
        category.setLinkUrl(linkUrl);
        category.setSortOrder(sortOrder);
        categoryRepository.save(category);
    }

    private void saveHero(String pageSlug, String eyebrow, String title, String description, String imageUrl) {
        PageHero hero = new PageHero();
        hero.setPageSlug(pageSlug);
        hero.setEyebrow(eyebrow);
        hero.setTitle(title);
        hero.setDescription(description);
        hero.setImageUrl(imageUrl);
        pageHeroRepository.save(hero);
    }

    private void saveBlock(
            String pageSlug,
            String blockType,
            String title,
            String subtitle,
            String description,
            String imageUrl,
            String layoutClass,
            int sortOrder) {
        ContentBlock block = new ContentBlock();
        block.setPageSlug(pageSlug);
        block.setBlockType(blockType);
        block.setTitle(title);
        block.setSubtitle(subtitle);
        block.setDescription(description);
        block.setImageUrl(imageUrl);
        block.setLayoutClass(layoutClass);
        block.setSortOrder(sortOrder);
        contentBlockRepository.save(block);
    }
}
