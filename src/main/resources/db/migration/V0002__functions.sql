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