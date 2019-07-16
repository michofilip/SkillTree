CREATE OR REPLACE FUNCTION get_item_id(item_name VARCHAR(255))
    RETURNS BIGINT
    LANGUAGE plpgsql
AS
$$
DECLARE
    item_id BIGINT;

BEGIN
    SELECT INTO item_id id
    FROM items
    WHERE name = item_name;

    RETURN item_id;
END;
$$;

CREATE OR REPLACE FUNCTION get_item_level_id(item_level_name VARCHAR(255), item_level_level INTEGER)
    RETURNS BIGINT
    LANGUAGE plpgsql
AS
$$
DECLARE
    item_level_id BIGINT;

BEGIN
    SELECT INTO item_level_id item_levels.id
    FROM item_levels
             INNER JOIN items ON items.id = item_levels.item_id
    WHERE items.name = item_level_name
      AND item_levels.level = item_level_level;

    RETURN item_level_id;
END;
$$;

CREATE OR REPLACE FUNCTION get_feature_id(feature_name VARCHAR(255))
    RETURNS BIGINT
    LANGUAGE plpgsql
AS
$$
DECLARE
    feature_id BIGINT;

BEGIN
    SELECT INTO feature_id id
    FROM features
    WHERE name = feature_name;

    RETURN feature_id;
END;
$$;