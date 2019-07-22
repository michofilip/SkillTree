DROP TABLE IF EXISTS items CASCADE;
DROP TABLE IF EXISTS item_levels CASCADE;
DROP TABLE IF EXISTS item_level_requirements CASCADE;
DROP TABLE IF EXISTS features CASCADE;
DROP TABLE IF EXISTS feature_values CASCADE;

CREATE TABLE items
(
    id          BIGSERIAL    NOT NULL,
    type        VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL UNIQUE,
    title       VARCHAR(255) NOT NULL,
    max_level   INTEGER      NOT NULL,
    description VARCHAR(255),

    CONSTRAINT items_pkey
        PRIMARY KEY (id),
    CONSTRAINT max_level_check
        CHECK (max_level >= 1)
);

CREATE TABLE item_levels
(
    item_id BIGINT  NOT NULL,
    level   INTEGER NOT NULL,

    CONSTRAINT item_levels_pkey
        PRIMARY KEY (item_id, level),

    CONSTRAINT item_fkey
        FOREIGN KEY (item_id)
            REFERENCES items (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT level_check
        CHECK (level >= 1)
);

CREATE TABLE item_level_requirements
(
    item_id          BIGINT  NOT NULL,
    level            INTEGER NOT NULL,
    required_item_id BIGINT  NOT NULL,
    required_level   INTEGER NOT NULL,

    CONSTRAINT item_level_fkey
        FOREIGN KEY (item_id, level)
            REFERENCES item_levels (item_id, level)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT required_item_level_fkey
        FOREIGN KEY (required_item_id, required_level)
            REFERENCES item_levels (item_id, level)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT level_check
        CHECK (level >= 1),
    CONSTRAINT required_level_check
        CHECK (level >= 1)

);

CREATE TABLE features
(
    id          BIGSERIAL    NOT NULL,
    type        VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL UNIQUE,
    title       VARCHAR(255) NOT NULL,
    description VARCHAR(255),

    CONSTRAINT feature_pkey
        PRIMARY KEY (id)
);

CREATE TABLE feature_values
(
    id         BIGSERIAL        NOT NULL,
    feature_id BIGINT           NOT NULL,
    item_id    BIGINT           NOT NULL,
    level      INTEGER          NOT NULL,
    value      DOUBLE PRECISION NOT NULL,

    CONSTRAINT feature_values_pkey
        PRIMARY KEY (id),

    CONSTRAINT feature_fkey
        FOREIGN KEY (feature_id)
            REFERENCES features (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT item_level_fkey
        FOREIGN KEY (item_id, level)
            REFERENCES item_levels (item_id, level)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT level_check
        CHECK (level >= 1)
);

ALTER TABLE items
    OWNER TO postgres;
ALTER TABLE item_levels
    OWNER TO postgres;
ALTER TABLE item_level_requirements
    OWNER TO postgres;
ALTER TABLE features
    OWNER TO postgres;
ALTER TABLE feature_values
    OWNER TO postgres;



