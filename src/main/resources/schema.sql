-- Apple Store DB Schema (H2 / JPA auto-managed)

CREATE TABLE IF NOT EXISTS categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    slug VARCHAR(50) NOT NULL UNIQUE,
    image_url VARCHAR(255),
    link_url VARCHAR(255),
    sort_order INT
);

CREATE TABLE IF NOT EXISTS page_heroes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    page_slug VARCHAR(50) NOT NULL UNIQUE,
    eyebrow VARCHAR(100),
    title VARCHAR(200) NOT NULL,
    description TEXT,
    image_url VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS content_blocks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    page_slug VARCHAR(50) NOT NULL,
    block_type VARCHAR(50) NOT NULL,
    title VARCHAR(200),
    subtitle VARCHAR(500),
    description TEXT,
    image_url VARCHAR(255),
    layout_class VARCHAR(50),
    sort_order INT
);

CREATE INDEX IF NOT EXISTS idx_content_blocks_page_type ON content_blocks(page_slug, block_type);
