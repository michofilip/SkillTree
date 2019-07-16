TRUNCATE items CASCADE;
TRUNCATE item_levels CASCADE;
TRUNCATE item_level_requirements CASCADE;
TRUNCATE features CASCADE;
TRUNCATE feature_values CASCADE;

ALTER SEQUENCE items_id_seq RESTART WITH 1;
ALTER SEQUENCE item_levels_id_seq RESTART WITH 1;
ALTER SEQUENCE features_id_seq RESTART WITH 1;
ALTER SEQUENCE feature_values_id_seq RESTART WITH 1;

INSERT INTO items(type, name, title, max_level, description)
VALUES ('MASTERY', 'necromancy', 'Necromancy', 3, 'Makes dead things rise'),
       ('SKILL', 'rise_skeleton', 'Rise Skeleton', 9, 'Rises a fearless skeleton');

INSERT INTO item_levels(item_id, level)
VALUES (get_item_id('necromancy'), 1),
       (get_item_id('necromancy'), 2),
       (get_item_id('necromancy'), 3),

       (get_item_id('rise_skeleton'), 1),
       (get_item_id('rise_skeleton'), 2),
       (get_item_id('rise_skeleton'), 3),
       (get_item_id('rise_skeleton'), 4),
       (get_item_id('rise_skeleton'), 5),
       (get_item_id('rise_skeleton'), 6),
       (get_item_id('rise_skeleton'), 7),
       (get_item_id('rise_skeleton'), 8),
       (get_item_id('rise_skeleton'), 9);

INSERT INTO item_level_requirements(item_level_id, required_item_level_id)
VALUES (get_item_level_id('necromancy', 2), get_item_level_id('necromancy', 1)),
       (get_item_level_id('necromancy', 3), get_item_level_id('necromancy', 2)),

       (get_item_level_id('rise_skeleton', 1), get_item_level_id('necromancy', 1)),
       (get_item_level_id('rise_skeleton', 2), get_item_level_id('necromancy', 1)),
       (get_item_level_id('rise_skeleton', 3), get_item_level_id('necromancy', 1)),
       (get_item_level_id('rise_skeleton', 4), get_item_level_id('necromancy', 2)),
       (get_item_level_id('rise_skeleton', 5), get_item_level_id('necromancy', 2)),
       (get_item_level_id('rise_skeleton', 6), get_item_level_id('necromancy', 2)),
       (get_item_level_id('rise_skeleton', 7), get_item_level_id('necromancy', 3)),
       (get_item_level_id('rise_skeleton', 8), get_item_level_id('necromancy', 3)),
       (get_item_level_id('rise_skeleton', 9), get_item_level_id('necromancy', 3)),

       (get_item_level_id('rise_skeleton', 2), get_item_level_id('rise_skeleton', 1)),
       (get_item_level_id('rise_skeleton', 3), get_item_level_id('rise_skeleton', 2)),
       (get_item_level_id('rise_skeleton', 4), get_item_level_id('rise_skeleton', 3)),
       (get_item_level_id('rise_skeleton', 5), get_item_level_id('rise_skeleton', 4)),
       (get_item_level_id('rise_skeleton', 6), get_item_level_id('rise_skeleton', 5)),
       (get_item_level_id('rise_skeleton', 7), get_item_level_id('rise_skeleton', 6)),
       (get_item_level_id('rise_skeleton', 8), get_item_level_id('rise_skeleton', 7)),
       (get_item_level_id('rise_skeleton', 9), get_item_level_id('rise_skeleton', 8));

INSERT INTO features(name, title, type)
VALUES ('max_number_of_skeletons', 'Max number of skeletons', 'ADDITIVE'),
       ('skeleton_hp', 'Skeleton health', 'ADDITIVE'),
       ('skeleton_attack', 'Skeleton attack', 'ADDITIVE');

INSERT INTO feature_values(feature_id, item_level_id, value)
VALUES (get_feature_id('max_number_of_skeletons'), get_item_level_id('rise_skeleton', 1), 2),
       (get_feature_id('max_number_of_skeletons'), get_item_level_id('rise_skeleton', 2), 2),
       (get_feature_id('max_number_of_skeletons'), get_item_level_id('rise_skeleton', 3), 2),
       (get_feature_id('max_number_of_skeletons'), get_item_level_id('rise_skeleton', 4), 3),
       (get_feature_id('max_number_of_skeletons'), get_item_level_id('rise_skeleton', 5), 3),
       (get_feature_id('max_number_of_skeletons'), get_item_level_id('rise_skeleton', 6), 3),
       (get_feature_id('max_number_of_skeletons'), get_item_level_id('rise_skeleton', 7), 4),
       (get_feature_id('max_number_of_skeletons'), get_item_level_id('rise_skeleton', 8), 4),
       (get_feature_id('max_number_of_skeletons'), get_item_level_id('rise_skeleton', 9), 4),

       (get_feature_id('skeleton_hp'), get_item_level_id('rise_skeleton', 1), 100),
       (get_feature_id('skeleton_hp'), get_item_level_id('rise_skeleton', 2), 150),
       (get_feature_id('skeleton_hp'), get_item_level_id('rise_skeleton', 3), 200),
       (get_feature_id('skeleton_hp'), get_item_level_id('rise_skeleton', 4), 250),
       (get_feature_id('skeleton_hp'), get_item_level_id('rise_skeleton', 5), 300),
       (get_feature_id('skeleton_hp'), get_item_level_id('rise_skeleton', 6), 350),
       (get_feature_id('skeleton_hp'), get_item_level_id('rise_skeleton', 7), 400),
       (get_feature_id('skeleton_hp'), get_item_level_id('rise_skeleton', 8), 450),
       (get_feature_id('skeleton_hp'), get_item_level_id('rise_skeleton', 9), 500),

       (get_feature_id('skeleton_attack'), get_item_level_id('rise_skeleton', 1), 10),
       (get_feature_id('skeleton_attack'), get_item_level_id('rise_skeleton', 2), 40),
       (get_feature_id('skeleton_attack'), get_item_level_id('rise_skeleton', 3), 90),
       (get_feature_id('skeleton_attack'), get_item_level_id('rise_skeleton', 4), 160),
       (get_feature_id('skeleton_attack'), get_item_level_id('rise_skeleton', 5), 250),
       (get_feature_id('skeleton_attack'), get_item_level_id('rise_skeleton', 6), 360),
       (get_feature_id('skeleton_attack'), get_item_level_id('rise_skeleton', 7), 490),
       (get_feature_id('skeleton_attack'), get_item_level_id('rise_skeleton', 8), 640),
       (get_feature_id('skeleton_attack'), get_item_level_id('rise_skeleton', 9), 810);